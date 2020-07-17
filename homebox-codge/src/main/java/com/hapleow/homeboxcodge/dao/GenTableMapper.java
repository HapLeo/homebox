package com.hapleow.homeboxcodge.dao;

import com.hapleow.homeboxcodge.model.GenTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wuyulin
 * @date 2020/7/17
 */
public interface GenTableMapper {


    List<GenTable> list(@Param("genTable") GenTable genTable);
}
