package com.qf.v16search.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.api.ISearchService;
import com.qf.v16.common.pojo.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yucan
 * @Date 2019/8/12
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @Reference
    private ISearchService searchService;

    @RequestMapping("queryByKeywords")
    public String search(String keywords, Model model){
        ResultBean resultBean = searchService.queryByKeywords(keywords);
        model.addAttribute("result",resultBean);
        return "list";
    }
}
