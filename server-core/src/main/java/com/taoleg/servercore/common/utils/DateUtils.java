package com.taoleg.servercore.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZHe on 17/4/5.
 */
public class DateUtils {


    public static final String STANDARD_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String STANDARD_TIME_PATTERN_NO_SEPARATOR = "yyyyMMddHHmmss";
    public static final String STANDARD_DATE_PATTERN = "yyyy-MM-dd";
    public static final String STANDARD_DAY_TIME_PATTERN = "HH:mm:ss";
    public static final String STANDARD_CHINESE_DATE_PATTERN = "yyyy年MM月dd日";


    /**
     * 获取日期字符串
     *
     * @param date
     * @param datePattern
     * @return
     */
    public static String getDateStr(Date date, String datePattern) {
        String dateStr = "";

        if (date == null) {
            return dateStr;
        }
        DateFormat dateFormat = new SimpleDateFormat(datePattern);
        dateStr = dateFormat.format(date);

        return dateStr;
    }

    /**
     * yyyy-MM-dd 或 yyyy年MM月dd日 ====> Date
     *
     * @param dateStr     yyyy-MM-dd 或 yyyy年MM月dd日
     * @param datePattern yyyy-MM-dd 或 yyyy年MM月dd日
     * @return
     */
    public static Date getDate(String dateStr, String datePattern) {

        DateFormat dateFormat = new SimpleDateFormat(datePattern);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }

    }

    /**
     * 获取yyyy-MM-dd
     *
     * @param dateStr     yyyy-MM-dd 或 yyyy年MM月dd日
     * @param datePattern yyyy-MM-dd 或 yyyy年MM月dd日
     * @return
     */
    public static LocalDate getLocalDate(String dateStr, String datePattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(datePattern);
        return LocalDate.parse(dateStr, dateTimeFormatter);
    }

    /**
     * 时间格式转换：  yyyyMMddHHmmss 转换成 yyyy-MM-dd HH:mm:ss
     *
     * @param timeStr
     * @return
     */
    public static String format(String timeStr) {
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat(STANDARD_TIME_PATTERN_NO_SEPARATOR);
            Date date = sdf1.parse(timeStr);
            SimpleDateFormat sdf2 = new SimpleDateFormat(STANDARD_TIME_PATTERN);
            return sdf2.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Date --> String
     * yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getStringDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(STANDARD_TIME_PATTERN);
        return formatter.format(date);
    }

    /**
     * 时间戳转换成日期格式字符串
     * 精确到秒的字符串(yyyy-MM-dd HH:mm:ss)
     *
     * @param seconds
     * @return
     */
    public static String timeStampToDate(String seconds) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_TIME_PATTERN);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    /**
     * 获取精确到秒的时间戳
     *
     * @param date
     * @return
     */
    public static int getSecondTimestamp(Date date) {
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime() / 1000);
        return Integer.valueOf(timestamp);
    }

    /**
     * 日期格式字符串转换成时间戳
     * yyyy-MM-dd HH:mm:ss
     *
     * @param dateTime
     * @return
     */
    public static Integer transformation(String dateTime) {
        try {
            String tempStart = Timestamp.valueOf(dateTime).toString();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(STANDARD_TIME_PATTERN);
            Date date = simpleDateFormat.parse(tempStart);
            int result = (int) (date.getTime() / 1000);
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 日期格式字符串转换成时间戳
     * yyyy-MM-dd HH:mm:ss
     *
     * @param date_str
     * @return
     */
    public static String dateTimeStamp(String date_str) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_TIME_PATTERN);
            return String.valueOf(sdf.parse(date_str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取日期时间字符串
     * yyyy-MM-dd HH:mm:ss
     *
     * @param timestamp
     * @return
     */
    public static String getDateTimeStr(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return DateUtils.getDateStr(new Date(timestamp.getTime()), STANDARD_TIME_PATTERN);
    }

    /**
     * 获取当天日期时间最后一秒---传入Date类型
     *
     * @param endDate
     * @return
     */
    public static Date getDateLastSecond(Date endDate) {
        DateFormat format = new SimpleDateFormat(STANDARD_DATE_PATTERN);
        String strEndDate = format.format(endDate);
        return DateUtils.getDateLastSecond(strEndDate);
    }

    /**
     * 获取当天日期时间最后一秒---输出Date类型
     * yyyy-MM-dd HH:mm:ss
     *
     * @param endDate
     * @return
     */
    public static Date getDateLastSecond(String endDate) {
        Date finalEndDate = null;
        DateFormat format = new SimpleDateFormat(STANDARD_TIME_PATTERN);
        if (endDate != null) {
            try {
                endDate = endDate + " 23:59:59";
                finalEndDate = format.parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            finalEndDate = null;
        }
        return finalEndDate;
    }

    /**
     * 获取当天日期时间初始状态---输出Date类型
     * yyyy-MM-dd HH:mm:ss
     *
     * @param startDate
     * @return
     */

    public static Date getFirstDate(String startDate) {
        Date finalStartDate = null;
        DateFormat format = new SimpleDateFormat(STANDARD_TIME_PATTERN);
        if (startDate != null) {
            try {
                startDate = startDate + " 00:00:00";
                finalStartDate = format.parse(startDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            finalStartDate = null;
        }
        return finalStartDate;
    }

    /**
     * Date --> LocalDateTime
     */
    public static LocalDateTime getLocalDateTimeToDate(Date date) {
        if (date != null) {
            Instant instant = date.toInstant();
            ZoneId zone = ZoneId.systemDefault();
            return LocalDateTime.ofInstant(instant, zone);
        }
        return null;
    }

    /**
     * Date --> LocalDate(yyyy-MM-dd)
     */
    public static LocalDate getLocalDateToDate(Date date) {
        if (date != null) {
            Instant instant = date.toInstant();
            ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
            return zdt.toLocalDate();
        }
        return null;
    }

    /**
     * LocalDate(yyyy-MM-dd) --> Date
     */
    public static Date LocalDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * String(yyyy-MM-dd) --> LocalDateTime(yyyy-MM-ddT00:00)
     */
    public static LocalDateTime getFirstLocalDateTimeToDateStr(String dateStr) {
        if (dateStr != null) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(STANDARD_DATE_PATTERN);
            LocalDate ld = LocalDate.parse(dateStr, dateTimeFormatter);
            LocalDateTime localDateTime = ld.atStartOfDay();
            return localDateTime;
        }
        return null;
    }

    /**
     * String(yyyy-MM-dd) --> LocalDateTime(yyyy-MM-ddTHH:mm:ss)
     */
    public static LocalDateTime getLocalDateTimeToDateStr(String dateStr) {
        if (dateStr != null) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(STANDARD_DATE_PATTERN);
            LocalDate ld = LocalDate.parse(dateStr, dateTimeFormatter);
            return LocalDateTime.of(ld, LocalDateTime.now().toLocalTime().withNano(0));
        }
        return null;
    }

    /**
     * String(yyyy-MM-dd HH:mm:ss) --> LocalDateTime(yyyy-MM-ddTHH:mm:ss)
     */
    public static LocalDateTime getLocalDateTimeToLocalDateTimeStr(String dateStr) {
        if (dateStr != null) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(STANDARD_TIME_PATTERN);
            return LocalDateTime.parse(dateStr, dateTimeFormatter);
        }
        return null;
    }

    /**
     * LocalDateTime  --> String(yyyy-MM-dd HH:mm:ss)
     *
     * @param localDateTime
     * @return
     */
    public static String getLocalDateTimeStr(LocalDateTime localDateTime) {
        return DateUtils.getDateLocalDateTimeStr(localDateTime, DateUtils.STANDARD_TIME_PATTERN);
    }

    /**
     * String --> Date
     */
    public static Date getDateToDateStr(String dateStr) {
        Date finalDate = null;
        DateFormat format = new SimpleDateFormat(STANDARD_TIME_PATTERN);
        if (dateStr != null) {
            try {
                finalDate = format.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            finalDate = null;
        }
        return finalDate;
    }

    /**
     * LocalDateTime --> Date
     */
    public static Date getDateToLocalDateTime(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            ZoneId zone = ZoneId.systemDefault();
            Instant instant = localDateTime.atZone(zone).toInstant();
            return Date.from(instant);
        }
        return null;
    }

    /**
     * 获取当前日期的前一天
     * yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getYesterDayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_TIME_PATTERN);
        Calendar calendar = Calendar.getInstance();//此时打印它获取的是系统当前时间
        calendar.add(Calendar.DATE, -1);    //得到前一天
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取当天日期时间最后一秒---传入LocalDateTime类型
     *
     * @param endDate
     * @return
     */
    public static LocalDateTime getLocalDateTimeLastSecond(LocalDateTime endDate) {

        if (endDate != null) {
            Date date = DateUtils.getDateLastSecond(DateUtils.getDateToLocalDateTime(endDate));
            long curMillisecond = date.getTime();//当天的毫秒
            return DateUtils.getLocalDateTimeToDate(new Date(curMillisecond));
        }

        return endDate;
    }

    /**
     * Loacldatetime格式化
     *
     * @param localDateTime
     * @param datePattern
     * @return
     */
    public static String getDateLocalDateTimeStr(LocalDateTime localDateTime, String datePattern) {
        if (localDateTime == null) {
            return "";
        }
        return localDateTime.format(DateTimeFormatter.ofPattern(datePattern));
    }

    /**
     * 获取日期时间字符串
     *
     * @param timestamp
     * @param dateFormat
     * @return
     */
    public static String getDateTimeStr(Timestamp timestamp, String dateFormat) {
        return DateUtils.getDateStr(new Date(timestamp.getTime()), dateFormat);
    }

    /**
     * 获取时间戳日期字符串
     * yyyy-MM-dd HH:mm:ss
     *
     * @param time
     * @return
     */
    public static synchronized String getTimestampStr(long time) {
        return DateUtils.getDateStr(new Date(time * 1000L), DateUtils.STANDARD_TIME_PATTERN);
    }

    /**
     * 获取日期时间字符串
     *
     * @param timestamp
     * @return
     */
    public static String getDayTimeStr(Timestamp timestamp) {
        if (timestamp == null) {
            return "";
        }
        return DateUtils.getDateStr(new Date(timestamp.getTime()), DateUtils.STANDARD_DAY_TIME_PATTERN);
    }

    /**
     * 获取当前时间（到毫秒）
     *
     * @return
     */
    public static Timestamp getCurentTimestamp() {
        java.sql.Timestamp realTimeStamp =
                new java.sql.Timestamp(Instant.now().toEpochMilli());
        return realTimeStamp;
    }

    /**
     * 获取当前时间
     * yyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurentTimeString() {
        return DateUtils.getDateStr(new Date(), STANDARD_TIME_PATTERN);
    }

    /**
     * 开始日期到结束日期
     * 计算中间一共隔了多少日期
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<Date> getIntervalIDates(Date startDate, Date endDate) {

        List<Date> dates = new ArrayList<>();

        LocalDateTime start = LocalDateTime.ofInstant(startDate.toInstant(), ZoneId.systemDefault());
        LocalDateTime end = LocalDateTime.ofInstant(endDate.toInstant(), ZoneId.systemDefault());

        if (start.isEqual(end)) {
            dates.add(Date.from(start.atZone(ZoneId.systemDefault()).toInstant()));
            return dates;
        }

        if (!start.isBefore(end)) {
            return dates;
        }

        dates.add(Date.from(start.atZone(ZoneId.systemDefault()).toInstant()));
        while (true) {
            LocalDateTime transitionTime = start.plusDays(1);
            if (transitionTime.isBefore(end) || transitionTime.isEqual(end)) {
                dates.add(Date.from(transitionTime.atZone(ZoneId.systemDefault()).toInstant()));
                start = transitionTime;
            } else {
                break;
            }
        }
        return dates;
    }

    public static String getStandardDateStr(Date date) {
        return getDateStr(date, DateUtils.STANDARD_DATE_PATTERN);
    }

    /**
     * 获取昨天半夜00:00:00
     *
     * @return
     */
    public static Date getYesterdayStart() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.MINUTE, 0);
        todayEnd.set(Calendar.SECOND, 0);
        todayEnd.set(Calendar.MILLISECOND, 0);
        todayEnd.add(Calendar.DATE, -1);
        todayEnd.set(Calendar.HOUR_OF_DAY, 0);
        return todayEnd.getTime();
    }

    /**
     * 获取昨天半夜23:59:59
     *
     * @return
     */
    public static Date getYesterdayEnd() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 0);
        todayEnd.add(Calendar.DATE, -1);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        return todayEnd.getTime();
    }

    /**
     * 判断时间格式 格式必须为 yyyy-MM-dd HH:mm:ss
     *
     * @param timeStr
     * @return
     */
    public static boolean isValidDateTimeWithLongFormat(String timeStr) {
        String format = "((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) "
                + "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(timeStr);
        if (matcher.matches()) {
            pattern = Pattern.compile("(\\d{4})-(\\d+)-(\\d+).*");
            matcher = pattern.matcher(timeStr);
            if (matcher.matches()) {
                int y = Integer.valueOf(matcher.group(1));
                int m = Integer.valueOf(matcher.group(2));
                int d = Integer.valueOf(matcher.group(3));
                if (d > 28) {
                    Calendar c = Calendar.getInstance();
                    c.set(y, m - 1, 1);
                    int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                    return (lastDay >= d);
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 判断时间格式 格式必须为 yyyy-MM-dd
     */
    public static boolean isValidDate(String date) {

        String regex = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?" +
                "((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))" +
                "|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))" +
                "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])" +
                "|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

//    public static void main(String[] args) {
//        System.out.println(DateUtils.getLocalDateTimeLastSecond(DateUtils.getLocalDateTimeToDate(new Date())));
//        System.out.println(DateUtils.getLocalDateTimeToDate(DateUtils.getDateLastSecond(DateUtils.getYesterDayDate())));
//        int startDate = DateUtils.getSecondTimestamp(DateUtils.getYesterdayStart());
//        int endDate = DateUtils.getSecondTimestamp(DateUtils.getYesterdayEnd());
//        System.out.println(startDate);
//        System.out.println(endDate);
//    }
}
