/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.generator.codegen.utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类, 继承org.apache.commons.lang3.StringUtils类
 *
 * @author ThinkGem
 * @version 2013-05-22
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    private static final char SEPARATOR = '_';
    private static final String CHARSET_NAME = "UTF-8";


    /**
     * uuid
     *
     * @return
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 转换为字节数组
     *
     * @param str
     * @return
     */
    public static byte[] getBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes(CHARSET_NAME);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 转换为字节数组
     *
     * @param bytes
     * @return
     */
    public static String toString(byte[] bytes) {
        try {
            return new String(bytes, CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            return EMPTY;
        }
    }

    /**
     * 是否包含字符串
     *
     * @param str  验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inString(String str, String... strs) {
        if (str != null) {
            for (String s : strs) {
                if (str.equals(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 替换掉HTML标签方法
     */
    public static String replaceHtml(String html) {
        if (isBlank(html)) {
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        String s = m.replaceAll("");
        return s;
    }

    /**
     * 替换为手机识别的HTML，去掉样式及属性，保留回车。
     *
     * @param html
     * @return
     */
    public static String replaceMobileHtml(String html) {
        if (html == null) {
            return "";
        }
        return html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
    }


    /**
     * 缩略字符串（不区分中英文字符）
     *
     * @param str    目标字符串
     * @param length 截取长度
     * @return
     */
    public static String abbr(String str, int length) {
        if (str == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int currentLength = 0;
            for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
                currentLength += String.valueOf(c).getBytes("GBK").length;
                if (currentLength <= length - 3) {
                    sb.append(c);
                } else {
                    sb.append("...");
                    break;
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String abbr2(String param, int length) {
        if (param == null) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        int n = 0;
        char temp;
        boolean isCode = false; // 是不是HTML代码
        boolean isHTML = false; // 是不是HTML特殊字符,如&nbsp;
        for (int i = 0; i < param.length(); i++) {
            temp = param.charAt(i);
            if (temp == '<') {
                isCode = true;
            } else if (temp == '&') {
                isHTML = true;
            } else if (temp == '>' && isCode) {
                n = n - 1;
                isCode = false;
            } else if (temp == ';' && isHTML) {
                isHTML = false;
            }
            try {
                if (!isCode && !isHTML) {
                    n += String.valueOf(temp).getBytes("GBK").length;
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if (n <= length - 3) {
                result.append(temp);
            } else {
                result.append("...");
                break;
            }
        }
        // 取出截取字符串中的HTML标记
        String temp_result = result.toString().replaceAll("(>)[^<>]*(<?)",
                "$1$2");
        // 去掉不需要结素标记的HTML标记
        temp_result = temp_result
                .replaceAll(
                        "</?(AREA|BASE|BASEFONT|BODY|BR|COL|COLGROUP|DD|DT|FRAME|HEAD|HR|HTML|IMG|INPUT|ISINDEX|LI|LINK|META|OPTION|P|PARAM|TBODY|TD|TFOOT|TH|THEAD|TR|area|base|basefont|body|br|col|colgroup|dd|dt|frame|head|hr|html|img|input|isindex|li|link|meta|option|p|param|tbody|td|tfoot|th|thead|tr)[^<>]*/?>",
                        "");
        // 去掉成对的HTML标记
        temp_result = temp_result.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>",
                "$2");
        // 用正则表达式取出标记
        Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>");
        Matcher m = p.matcher(temp_result);
        List<String> endHTML = Lists.newArrayList();
        while (m.find()) {
            endHTML.add(m.group(1));
        }
        // 补全不成对的HTML标记
        for (int i = endHTML.size() - 1; i >= 0; i--) {
            result.append("</");
            result.append(endHTML.get(i));
            result.append(">");
        }
        return result.toString();
    }

    /**
     * 转换为Double类型
     */
    public static Double toDouble(Object val) {
        if (val == null) {
            return 0D;
        }
        try {
            return Double.valueOf(trim(val.toString()));
        } catch (Exception e) {
            return 0D;
        }
    }

    /**
     * 转换为Float类型
     */
    public static Float toFloat(Object val) {
        return toDouble(val).floatValue();
    }

    /**
     * 转换为Long类型
     */
    public static Long toLong(Object val) {
        return toDouble(val).longValue();
    }

    /**
     * 转换为Integer类型
     */
    public static Integer toInteger(Object val) {
        return toLong(val).intValue();
    }


    /**
     * 获得用户远程地址
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-Real-IP");
        if (isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("X-Forwarded-For");
        } else if (isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        } else if (isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase("hello_world") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase("hello_world") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * 转成SQL参数
     */
    public static String arrayToSql(String[] array) {
        String[] arr = new String[array.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "'" + array[i] + "'";
        }
        String sql = "(";
        sql = sql + StringUtils.join(arr, ",") + ")";
        return sql;
    }


    /**
     * 转成SQL参数
     */
    public static String arrayToSql(Long[] array) {
        String[] arr = new String[array.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array[i].toString();
        }
        String sql = "(";
        sql = sql + StringUtils.join(arr, ",") + ")";
        return sql;
    }

    /**
     * 驼峰命名法工具
     *
     * @return toCamelCase("hello_world") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 如果不为空，则设置值
     *
     * @param target
     * @param source
     */
    public static void setValueIfNotBlank(String target, String source) {
        if (isNotBlank(source)) {
            target = source;
        }
    }

    /**
     * 转换为JS获取对象值，生成三目运算返回结果
     *
     * @param objectString 对象串
     *                     例如：row.user.id
     *                     返回：!row?'':!row.user?'':!row.user.id?'':row.user.id
     */
    public static String jsGetVal(String objectString) {
        StringBuilder result = new StringBuilder();
        StringBuilder val = new StringBuilder();
        String[] vals = split(objectString, ".");
        for (int i = 0; i < vals.length; i++) {
            val.append("." + vals[i]);
            result.append("!" + (val.substring(1)) + "?'':");
        }
        result.append(val.substring(1));
        return result.toString();
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    public static String randomString(int length) {
        char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz").toCharArray();
        Random randGen = new Random();
        if (length < 1) {
            return null;
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(36)];
        }
        return new String(randBuffer);
    }

    public static String randomInt(int length) {
        char[] numbersAndLetters = ("0123456789").toCharArray();
        Random randGen = new Random();
        if (length < 1) {
            return null;
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(10)];
        }
        return new String(randBuffer);
    }

    /**
     * 打印请求参数
     */
    public static String printLog(String logName, HttpServletRequest request) {
        StringBuffer logBuffer = new StringBuffer(logName).append(",ip[").append(getIpAddr(request)).append("],参数为[");

        Enumeration<String> pnames = request.getParameterNames();
        String s;

        while (pnames.hasMoreElements()) {
            s = pnames.nextElement();
            logBuffer.append(s).append("=").append(request.getParameter(s)).append("&");
        }

        logBuffer.deleteCharAt(logBuffer.length() - 1).append("]");
        return logBuffer.toString();
    }


    public static String generateFormatStr(String str, int num, String separator) {

        String result = "";

        if (org.apache.commons.lang3.StringUtils.isBlank(str)) {
            return result;
        }

        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {

            if ((i + 1) % num == 0 && i != (charArray.length - 1)) {
                result += charArray[i] + separator;
            } else {
                result += charArray[i];
            }
        }

        return result;
    }

    /**
     * 判断是否为IOS设备
     */
    public static boolean isMacOsDevice(String userAgent) {
        return StringUtils.isNotBlank(userAgent) && StringUtils.containsIgnoreCase(userAgent, "Mac OS X");
    }

    /**
     * 判断请求是否为异步
     *
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return isNotBlank(request.getHeader("x-requested-with"));
    }

    public static boolean isMobile(String phone) {
        if (StringUtils.isNotBlank(phone)) {
            if (phone.length() == 11 && phone.startsWith("1") && isNumber(phone)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDragonCode(String str) {
        if (StringUtils.isNotBlank(str)) {
            if (str.length() == 16 && isNumber(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumber(String str) {
        char[] chares = str.toCharArray();
        for (int i = 0; i < chares.length; i++) {
            if ((chares[i] > '9') || (chares[i] < '0')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmail(String email) {
        if (null == email || "".equals(email))
            return false;
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");// 复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * @param phone
     * @return
     */
    public static String formatPhone(String phone) {
        if (phone == null) {
            return "";
        } else {
            phone = phone.replace(" ", "").replace("-", "");
            if (phone.startsWith("+86")) {
                phone = phone.substring(3);
            }
            return phone;
        }
    }


    /**
     * 邮箱加密
     *
     * @param mail
     * @return
     */
    public static String getSecuMail(String mail) {

        if (StringUtils.isBlank(mail)) {
            return "";
        }

        int atIndex = mail.indexOf("@");

        if (atIndex > 0) {
            int pointIndex = mail.lastIndexOf(".");

            StringBuffer sbf = new StringBuffer();
            int startIndex = atIndex > 2 ? 2 : atIndex;
            int distinct = pointIndex - atIndex > 2 ? 3 : pointIndex - atIndex;
            sbf.append(mail.substring(0, startIndex)).append("***").append(
                    mail.substring(mail.indexOf("@"), mail.indexOf("@")
                            + distinct)).append("***").append(
                    mail.substring(mail.indexOf(".")));

            return sbf.toString();
        } else {
            return mail;
        }
    }

    public static String lpad(int length, Number number) {
        return lpad(length, number, "0");
    }

    public static String lpad(int length, Number number, String charStr) {
        String f = "%" + charStr + length + "d";
        return String.format(f, number);
    }

    /**
     * 加密邮箱
     */
    public static String retSecuMail(String mail) {
        int atIndex = mail.indexOf("@");
        int pointIndex = mail.lastIndexOf(".");

        StringBuffer sbf = new StringBuffer();
        int startIndex = atIndex > 2 ? 2 : atIndex;
        int distinct = pointIndex - atIndex > 2 ? 3 : pointIndex - atIndex;
        sbf.append(mail.substring(0, startIndex)).append("***").append(mail.substring(mail.indexOf("@"), mail.indexOf("@") + distinct)).append("***").append(mail.substring(mail.lastIndexOf(".")));

        return sbf.toString();
    }

    /**
     * @param f
     * @return
     */
    public static String floatToString(Float f) {
        String str = String.valueOf(f);
        if (str.endsWith(".0")) {
            str = str.substring(0, str.length() - 2);
        }
        return str;
    }

    public static String phoneWithStar(String phone) {
        String p;

        if (StringUtils.isBlank(phone)) {
            return null;
        }

        if (phone.length() >= 11) {
            p = phone.substring(0, 3) + "****" + phone.substring(7);
        } else if (phone.length() < 3) {
            p = phone;
        } else {
            int index = phone.length() / 3;
            p = phone.substring(0, index) + repeat("*", phone.length() - index * 2) + phone.substring(phone.length() - index);
        }
        return p;
    }

    public static String dateToString(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    public static boolean isEnglishLetter(String str) {
        String regex = "^([A-Za-z]+[\\s.']*)*[A-Za-z]$";
        if (str.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        String replyContext = "回复 棒棒哒： 第二个人回复";
        if (StringUtils.startsWith(replyContext, "回复") && (StringUtils.contains(replyContext, "：") || StringUtils.contains(replyContext, ":"))) {
            replyContext=replyContext.substring(StringUtils.contains(replyContext, "：") ? replyContext.indexOf("：") + 1 : replyContext.indexOf(":") + 1);
        }
        System.out.println(replyContext);
    }
}
