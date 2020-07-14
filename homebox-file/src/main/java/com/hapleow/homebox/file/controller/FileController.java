package com.hapleow.homebox.file.controller;

import com.hapleow.homebox.file.dto.FileCopyAllDto;
import com.hapleow.homebox.file.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyulin
 * @date 2020/7/14
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private IFileService fileService;

    /**
     * 拷贝所有文件
     *
     * @param fileCopyAllDto
     * @return
     */
    @RequestMapping("/copyAll")
    public Object copyAll(FileCopyAllDto fileCopyAllDto) {

        fileService.copyAll(fileCopyAllDto);
        return "SUCCESS";
    }
}
