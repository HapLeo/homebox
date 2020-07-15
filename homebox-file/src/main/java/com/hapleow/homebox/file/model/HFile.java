package com.hapleow.homebox.file.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wuyulin
 * @date 2020/7/15
 */
@Data
public class HFile {

    /**
     * 文件ID
     */
    private int fileId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件唯一编号
     */
    private String fileUuid;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 文件后缀名
     */
    private String fileSuffixName;

    /**
     * 文件最后修改时间
     */
    private LocalDateTime fileModifiedTime;

    /**
     * 文件记录创建日期
     */
    private LocalDateTime createTime;

    /**
     * 文件记录修改日期
     */
    private LocalDateTime updateTime;

}
