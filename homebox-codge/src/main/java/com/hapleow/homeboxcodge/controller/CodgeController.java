package com.hapleow.homeboxcodge.controller;

import com.alibaba.fastjson.JSON;
import com.hapleow.homeboxcodge.common.AjaxResult;
import com.hapleow.homeboxcodge.config.CodgeProperties;
import com.hapleow.homeboxcodge.dto.CodgeDto;
import com.hapleow.homeboxcodge.service.ICodgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyulin
 * @date 2020/7/15
 */
@RestController
@RequestMapping("/codge")
public class CodgeController {

    @Autowired
    private ICodgeService codgeService;

    @Autowired
    private CodgeProperties codgeProperties;


    @RequestMapping("/execute")
    public AjaxResult execute(CodgeDto codgeDto) {
        codgeService.execute(codgeDto);
        return AjaxResult.success();
    }

    @RequestMapping("/getProperties")
    public Object getProperties(){
        return JSON.toJSON(codgeProperties);
    }
}
