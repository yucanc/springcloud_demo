package com.qf.v16index.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.v16.api.IProductTypeService;
import com.qf.v16.entity.TProductType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author yucan
 * @Date 2019/8/9
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @Reference
    private IProductTypeService productTypeService;

    @RequestMapping("home")
    public String showHome(Model model){
        List<TProductType> list = productTypeService.list();
        model.addAttribute("list",list);
        return "home";
    }
}
