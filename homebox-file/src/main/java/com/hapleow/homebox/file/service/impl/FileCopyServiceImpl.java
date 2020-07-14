package com.hapleow.homebox.file.service.impl;

import com.alibaba.fastjson.JSON;
import com.hapleow.homebox.file.dto.FileCopyAllDto;
import com.hapleow.homebox.file.enumeration.GroupType;
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

        GroupType groupType = fileCopyAllDto.getGroupType();
        log.info("参数列表：" + JSON.toJSONString(fileCopyAllDto));
        log.info("分组策略：" + groupType);
    }
}
