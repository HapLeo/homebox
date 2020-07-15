package com.hapleow.homebox.file.dto;

import com.hapleow.homebox.file.enumeration.GroupStrategy;
import com.hapleow.homebox.file.enumeration.StorageStrategy;
import com.hapleow.homebox.file.model.HFile;
import lombok.Data;

/**
 * @author wuyulin
 * @date 2020/7/15
 */
@Data
public class HFileUploadDto {

    private HFile hFile;

    /**
     * 分组策略
     */
    private GroupStrategy groupStrategy;

    /**
     * 保存策略
     */
    private StorageStrategy storageStrategy;
}
