package com.hapleow.homeboxcodge.converter;

import java.util.HashMap;
import java.util.Map;

/**
 * 长整型类型转换器
 *
 * @author wuyulin
 * @date 2020/7/20
 */
public class TypeConverter {

    private static final String flag = "bigint";

    private static final Map<String, String> typeMap = new HashMap<>();

    static {
        typeMap.put("bigint", "Long");
        typeMap.put("int", "Integer");
        typeMap.put("nvarchar", "String");
        typeMap.put("varchar", "String");
        typeMap.put("char", "String");
        typeMap.put("BLOB", "String");
        typeMap.put("date", "LocalDate");
        typeMap.put("datetime", "LocalDateTime");

    }


    /**
     * 返回类型字符串
     *
     * @param typeStr
     * @return
     */
    public static String convert(String typeStr) {

        String trim = typeStr.split("\\(")[0].replace("<","").replace(">","");
        return typeMap.get(trim);
    }
}
