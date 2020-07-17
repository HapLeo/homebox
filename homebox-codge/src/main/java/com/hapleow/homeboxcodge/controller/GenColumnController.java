package com.hapleow.homeboxcodge.controller;

import com.hapleow.homeboxcodge.common.AjaxResult;
import com.hapleow.homeboxcodge.service.IGenColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyulin
 * @date 2020/7/17
 */
@RestController
@RequestMapping("/genColumn")
public class GenColumnController {

    @Autowired
    private IGenColumnService genColumnService;


    @RequestMapping("/list")
    public AjaxResult list(@RequestParam("tableName") String tableName) {

        return AjaxResult.success(genColumnService.list(tableName));
    }
}
