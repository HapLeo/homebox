package com.hapleow.homebox.file.service;

import com.hapleow.homebox.file.dto.FileCopyAllDto;
import com.hapleow.homebox.file.dto.HFileAddDto;
import com.hapleow.homebox.file.dto.HFileUploadDto;

/**
 * @author wuyulin
 * @date 2020/7/14
 */
public interface IFileService {


    void copyAll(FileCopyAllDto fileCopyAllDto);

    /**
     * 新增
     * @param hFileAddDto
     */
    void add(HFileAddDto hFileAddDto);

    /**
     * 上传文件
     * @param hFileUploadDto
     */
    void upload(HFileUploadDto hFileUploadDto);
}
