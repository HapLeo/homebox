package com.hapleow.homeboxcodge.common;

public class StringUtil {

    /**
     * 下划线字符
     */
    public static final char UNDERLINE = '_';

    public static final String UNDERSCORE = "_";

    public static final String SEPARATOR = System.getProperty("line.separator");

    public static final String FIlE_SEPARATOR = System.getProperty("file.separator");

    /**
     * 判断字符串是否不是空串或者null或者空格,
     *
     * @param str 字符串
     * @return 判定结果
     */
    public static boolean isEmpty(String str) {
        if (str == null
                || "".equals(str.trim())
                || "undefined".equalsIgnoreCase(str)
                || "null".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否不是空串或者null或者空格,
     *
     * @param str 字符串
     * @return 判定结果
     */
    public static boolean isNotEmpty(String str) {

        return !isEmpty(str);
    }

    /**
     * 获取对象的字符串值
     * <p>当对象为null时直接返回null</p>
     *
     * @param obj
     * @return
     */
    public static String valueOf(Object obj) {
        return (obj == null) ? null : obj.toString();
    }

    /**
     * 去除字符串两端空格
     *
     * @param param
     * @return
     */
    public static String trim(String param) {
        if (param == null) {
            return null;
        }
        String str = param.trim();
        if ("".equals(str)) {
            return str;
        }
        while (str.startsWith("　")) {//这里判断是不是全角空格
            str = str.substring(1, str.length()).trim();
        }
        while (str.endsWith("　")) {
            str = str.substring(0, str.length() - 1).trim();
        }
        return str;
    }

    /**
     * 字符串下划线转驼峰格式
     *
     * @param param 需要转换的字符串
     * @return 转换好的字符串
     */
    public static String underlineToCamel(String param) {
        if (isEmpty(param)) {
            return "";
        }
        if (!param.contains(UNDERSCORE) && Character.isLowerCase(param.charAt(0))) {
            return param;
        }
        String temp = param.toLowerCase();
        int len = temp.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = temp.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(temp.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 将字符串转换成首字母大写的驼峰格式
     *
     * @param param
     * @return
     */
    public static String firstLatterUpperCamel(String param) {

        if (StringUtil.isEmpty(param)) {
            return "";
        }
        String result = underlineToCamel(param);

        if (!Character.isUpperCase(result.charAt(0))) {
            StringBuilder sb = new StringBuilder(result);
            result = sb.replace(0, 1, String.valueOf(Character.toUpperCase(result.charAt(0)))).toString();
        }
        return result;
    }

    /**
     * 判断字符串是不是驼峰命名
     *
     * <li> 包含 '_' 不算 </li>
     * <li> 首字母大写的不算 </li>
     *
     * @param str 字符串
     * @return 结果
     */
    public static boolean isCamel(String str) {
        if (str.contains(UNDERSCORE)) {
            return false;
        }
        return Character.isLowerCase(str.charAt(0));
    }


    public static void main(String[] args) {
        String abcdeFghi = StringUtil.underlineToCamel("bbcdeFghi");
        System.out.println(abcdeFghi);
    }
}
