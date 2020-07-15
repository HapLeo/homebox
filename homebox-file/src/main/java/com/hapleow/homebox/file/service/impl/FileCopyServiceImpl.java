package com.hapleow.homebox.file.service.impl;

import com.alibaba.fastjson.JSON;
import com.hapleow.homebox.file.dto.FileCopyAllDto;
import com.hapleow.homebox.file.dto.HFileAddDto;
import com.hapleow.homebox.file.dto.HFileUploadDto;
import com.hapleow.homebox.file.enumeration.GroupStrategy;
import com.hapleow.homebox.file.enumeration.StorageStrategy;
import com.hapleow.homebox.file.service.IFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wuyulin
 * @date 2020/7/14
 */
@Service
@Slf4j
public class FileCopyServiceImpl implements IFileService {


    @Override
    public void copyAll(FileCopyAllDto fileCopyAllDto) {

        log.info("参数列表：" + JSON.toJSONString(fileCopyAllDto));
    }

    /**
     * 新增
     *
     * @param hFileAddDto
     */
    @Override
    public void add(HFileAddDto hFileAddDto) {

        log.info("add hFile to database.");
    }

    /**
     * 上传文件
     *
     * @param hFileUploadDto
     */
    @Override
    public void upload(HFileUploadDto hFileUploadDto) {

        GroupStrategy groupStrategy = hFileUploadDto.getGroupStrategy();
        StorageStrategy storageStrategy = hFileUploadDto.getStorageStrategy();

        log.info("参数列表：" + JSON.toJSONString(hFileUploadDto));
        log.info("分组策略：" + groupStrategy);

        log.info("upload file finished.");
    }
}
