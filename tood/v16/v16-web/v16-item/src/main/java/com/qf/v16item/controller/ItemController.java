package com.qf.v16item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.v16.api.IProductService;
import com.qf.v16.common.pojo.ResultBean;
import com.qf.v16.entity.TProduct;
import freemarker.template.Configuration;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
/**
 * @author yucan
 * @Date 2019/8/13
 */
@Controller
@RequestMapping("item")
public class ItemController {

    @Reference
    private IProductService productService;

    @Autowired
    private Configuration configuration;

    @Autowired
    private ThreadPoolExecutor pool;

    //创建静态页面
    @RequestMapping("createById/{id}")
    @ResponseBody
    public ResultBean createById(@PathVariable("id") Long id){
        //1.获取模板对象
        try {
            Template template = configuration.getTemplate("item.ftl");
            //2.获取数据
            TProduct product = productService.selectByPrimaryKey(id);
            Map<String,Object> data = new HashMap<>();
            data.put("product",product);
            //3.模板+数据=输出
            //获取static的路径
            String serverpath= ResourceUtils.getURL("classpath:static").getPath();
            StringBuilder stringBuilder = new StringBuilder(serverpath);
            stringBuilder.append(File.separator);
            stringBuilder.append(product.getId());
            stringBuilder.append(".html");
            FileWriter out = new FileWriter(stringBuilder.toString());
            template.process(data,out);
            //4.
            return new ResultBean("200","生成成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }catch (TemplateException e){
            e.printStackTrace();
        }
        return new ResultBean("500","生成失败！");
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

    @RequestMapping("batchCreate")
    public ResultBean batchCreate(List<Long> ids){
        //1.创建一个集合来保存线程的执行结果
        List<Future<Long>> results = new ArrayList<>(ids.size());
        //2.开启多线程执行批量生成静态页的任务
        for (Long id : ids) {//1 2 3
            //提交一个执行任务交给线程池来处理
            Future<Long> future = pool.submit(new CreateTask(id));
            results.add(future);
        }
        //并没有生成顺序性要求
        //改造成多线程模式
        //统一检查处理的结果
        //创建了一个集合用来保存执行失败的任务
        List<Long> errors = new ArrayList<>();
        for (Future<Long> result : results) {
            try {
                Long resultNo = result.get();
                //无法确定是谁失败了
                if (resultNo !=0){
                    errors.add(resultNo);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        //4.统一处理执行失败的任务
        if (errors.size() > 0) {
            //1.TODO 记录到日志表中（id product_id create_time）
            //2.后台又一个菜单
            //3.开启定时任务，扫描日志表，将其中执行失败的任务，重新执行，最多重试三次（后期人工介入）
            return new ResultBean("500","部分页面生成失败，请查看执行日志");
        }
        return new ResultBean("200","批量生成静态页成功");
    }

    /**
     * 创建静态页面的任务
     * 需要创建之后的返回值
     * 返回0.表示没错误，非0，则是错误
     */
    private class CreateTask implements Callable<Long> {

        private  Long id;

        public  CreateTask(Long id){
            this.id = id;
        }

        @Override
        public Long call() throws Exception {
            //1.获取模板对象
            try {
                Template template = configuration.getTemplate("item.ftl");
                //2.获取数据
                TProduct product = productService.selectByPrimaryKey(id);
                Map<String,Object> data = new HashMap<>();
                data.put("product",product);
                //3.模板+数据=输出
                //获取static的路径
                String serverpath= ResourceUtils.getURL("classpath:static").getPath();
                StringBuilder stringBuilder = new StringBuilder(serverpath);
                stringBuilder.append(File.separator);
                stringBuilder.append(product.getId());
                stringBuilder.append(".html");
                FileWriter out = new FileWriter(stringBuilder.toString());
                template.process(data,out);
                //4.
                return 0L;
            } catch (IOException e) {
                e.printStackTrace();
            }catch (TemplateException e){
                e.printStackTrace();
            }
            return id;
        }
    }
}


