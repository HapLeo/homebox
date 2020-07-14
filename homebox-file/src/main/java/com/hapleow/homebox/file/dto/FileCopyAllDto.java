package com.hapleow.homebox.file.dto;

import com.hapleow.homebox.file.enumeration.GroupType;
import lombok.Data;

/**
 * @author wuyulin
 * @date 2020/7/14
 */
@Data
public class FileCopyAllDto {

    private String fromPath;

    private String toPath;

    private GroupType groupType;


}
