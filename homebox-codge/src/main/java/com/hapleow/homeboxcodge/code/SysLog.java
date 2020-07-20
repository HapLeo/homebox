package com.hapleow.homeboxcodge.code;

import lombok.Data;

/**
 * @author wyl
 * @desc 系统日志表
 * @date 2020-07-20 17:35:51
 */
@Data
public class SysLog {

    /**
     * 日志ID
     */
    private Long logId;

    /**
     * 日志内容
     */
    private String logContent;

    /**
     * 日志类型
     */
    private String logType;


}