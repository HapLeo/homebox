package com.hapleow.homeboxcodge.common;

/**
 * 异常工具类
 *
 * @author wuyulin
 * @date 2020/6/29
 */
public class ExceptionUtil {

    /**
     * 验证字段如果为空则抛出异常
     *
     * @param item     字段值
     * @param errorMsg 字段描述
     */
    public static void throwIfEmpty(Object item, String errorMsg) {

        if (item instanceof String) {
            String fieldVal = (String) item;
            if (StringUtil.isEmpty(fieldVal) || "".equals(fieldVal.trim())) {
                throwEx(errorMsg);
            }
        } else {
            if (item == null) {
                throwEx(errorMsg);
            }
        }
    }

    /**
     * 如果数字类型为null或非正数时抛出异常
     *
     * @param number
     * @param errorMsg
     */
    public static void throwIfNullOrNotPositive(Double number, String errorMsg) {

        if (number == null || number <= 0) {
            throwEx(errorMsg);
        }
    }

    /**
     * 如果数字类型为null或非正数时抛出异常
     *
     * @param number
     * @param errorMsg
     */
    public static void throwIfNullOrNotPositive(Integer number, String errorMsg) {

        if (number == null || number <= 0) {
            throwEx(errorMsg);
        }
    }

    /**
     * 抛出请求无效异常
     *
     * @param errorMsg
     */
    public static void throwEx(String errorMsg) {
        throw new RuntimeException(errorMsg);
    }
}
