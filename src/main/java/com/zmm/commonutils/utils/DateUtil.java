package com.zmm.commonutils.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 日期工具类 <功能详细描述>
 * 
 * @author lzy
 */
public class DateUtil {
	/** 格式化类型:YYYY-MM-dd */
	public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	/** 格式化类型:yyyy-MM-dd-HHmmss */
	public static final String FORMAT_YYYY_MM_DD_HHMMSS = "yyyy-MM-dd-HHmmss";

	/** 格式化类型:yyyyMMddHHmmss */
	public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	/** 格式化类型:yyyy-MM-dd HH:mm:ss */
	public static final String FORMAT_YYYY_MM_DD_SECONDS = "yyyy-MM-dd HH:mm:ss";

	/** 格式化类型:MM/dd/yy */
	public static final String FORMAT_MMDDYY = "MM/dd/yy";

	/** 格式化类型:yyyyMMdd */
	public static final String FORMAT_YYYYMMDD = "yyyyMMdd";

	/** 格式化类型:yyyyMMdd-HHmm */
	public static final String FORMAT_YYYYMMDD_HHMM = "yyyyMMdd-HHmm";

	/** 格式化类型:MM-dd */
	public static final String FORMAT_MMDD = "MM-dd";

	/** 格式化类型：hh:mm */
	public static final String FORMAT_HHMM = "HH:mm";

	/** 格式化类型：hh:mm:ss */
	public static final String FORMAT_HHMMSS = "HH:mm:ss";

	/** 格式化类型：yyyyMMddhhmmssSSS */
	public static final String FORMAT_YYYYMMDDHHMMSSSSS = "yyyyMMddhhmmssSSS";

	/**
	 * 格式化类型:yyyy-MM-dd HH:mm:ss.SSS
	 */
	public static final String FORMAT_YYYYMMDDHHMMSSSSSZ = "yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * 格式化类型MMM.dd, yyyy HH:mm:ss
	 */
	public static final String FORMAT_MMM_DD_YYYY_HH_MM_SS = "MMM.dd, yyyy HH:mm:ss";

	/** yyyy-MM-dd格式的 正则判断器 */
	public static final Pattern yyyyMMdd_Pattern = Pattern
			.compile("[1-9]{1}[0-9]{3}-((0?[1-9])|(1[0-2]))-((0?[1-9])|([1-2][0-9])|([3][0-1]))");

	/** yyyy-MM-dd HH:mm:ss格式的 正则判断器 */
	public static final Pattern yyyyMMddHHmmss_Pattern = Pattern.compile(
			"[1-9]{1}[0-9]{3}-((0?[1-9])|(1[0-2]))-((0?[1-9])|([1-2][0-9])|([3][0-1]))\\s+(([0-1]?[0-9])|([2][0-3])):([0-5]?[0-9]):([0-5]?[0-9])");

	private final static HashMap<CompareDateFormate, int[]> MAP = new HashMap<CompareDateFormate, int[]>();

	private static final Long DAY = 1000 * 60 * 60 * 24L;

	private final static long MINUTE = 60 * 1000;// 1分钟

	private final static long HOUR = 60 * MINUTE;// 1小时

	private final static long D_DAY = 24 * HOUR;// 1天

	private final static long MONTH = 31 * DAY;// 月

	private final static long YEAR = 12 * MONTH;// 年

	private DateUtil() {

	}

	/**
	 * 得到当前时间的字符格式 <功能详细描述>
	 * 
	 * @return 当前时间的字符格式
	 * @see [类、类#方法、类#成员]
	 */
	public static String getCurrentTime() {
		return format(new Date());
	}

	/**
	 * 根据时间格式,获取当前时间戳
	 * 
	 * @param format
	 *            String
	 * @return String
	 */
	public static String getCurrentTime(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format, new Locale("EN"));
		return sdf.format(date);
	}

	/**
	 * 得到当前时间 <功能详细描述>
	 * 
	 * @return 得到当前时间
	 * @see [类、类#方法、类#成员]
	 */
	public static Timestamp getCurrentDatetime() {
		System.out.println(format(new Date()));
		return new Timestamp((new Date()).getTime());
	}

	/**
	 * 格式化成系统常用日期格式：yyyyMMddHHmmss <功能详细描述>
	 * 
	 * @param date
	 *            Date
	 * @return String
	 * @see [类、类#方法、类#成员]
	 */
	public static String format(Date date) {
		return format(date, "yyyyMMddHHmmss");
	}

	/**
	 * 格式化日期 <功能详细描述>
	 * 
	 * @param date
	 *            Date
	 * @param formatStr
	 *            String 日期转换类型
	 * @return String
	 * @see [类、类#方法、类#成员]
	 */
	public static String format(Date date, String formatStr) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat(formatStr, ResourceUtil.getLocaleObject());

		return sf.format(date);
	}

	/**
	 * 判断两个日期是否为同年同月 <功能详细描述>
	 * 
	 * @param date1
	 *            Date
	 * @param date2
	 *            Date
	 * @return boolean true 两个日期为同年同月
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isSameYYYYMM(Date date1, Date date2) {
		return compare(date1, date2, CompareDateFormate.yyyyMM) == 0;
	}

	/**
	 * 获取增加的小时的时间 <功能详细描述>
	 * 
	 * @param date
	 *            Date
	 * @param hour
	 *            int
	 * @return Timestamp
	 * @see [类、类#方法、类#成员]
	 */
	public static Timestamp getAddHourDate(Date date, int hour) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// 小时增加
		c.add(Calendar.HOUR_OF_DAY, hour);

		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 获取增加的天数的时间
	 * 
	 * @param date
	 * @param offset
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static Date addOffset(Date date, int offset) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, offset);// 增加天数
		return c.getTime();
	}

	/**
	 * date转成 calendar <功能详细描述>
	 * 
	 * @param date
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static Calendar date2Calendar(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}

	/**
	 * 获取当天开始时间 <功能详细描述>
	 * 
	 * @param date
	 *            Date
	 * @return Timestamp
	 * @see [类、类#方法、类#成员]
	 */
	public static Timestamp getBeginDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 获取当天结束时间 <功能详细描述>
	 * 
	 * @param date
	 *            Date
	 * @return Timestamp
	 * @see [类、类#方法、类#成员]
	 */
	public static Timestamp getEndDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);

		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 某个时间是否在两个时间段之间 <功能详细描述>
	 * 
	 * @param begintime
	 *            Timestamp
	 * @param endtime
	 *            Timestamp
	 * @param nowTimes
	 *            Timestamp
	 * @return boolean true 该时间在两个时间段之间
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isBetweenTime(Timestamp begintime, Timestamp endtime, Timestamp nowTimes) {
		if (nowTimes.compareTo(begintime) != -1 && nowTimes.compareTo(endtime) != 1) {
			return true;
		}

		return false;
	}

	/**
	 * 某个时间是否在两个时间段之间 <功能详细描述>
	 * 
	 * @param begintime
	 *            Timestamp
	 * @param endtime
	 *            Timestamp
	 * @param nowTimes
	 *            Timestamp
	 * @return boolean true 该时间在两个时间段之间
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isBetweenTimeStr(String begintime, String endtime, String nowTimes) {
		if (nowTimes.compareTo(begintime) >= 0 && nowTimes.compareTo(endtime) <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 日期格式枚举 <一句话功能简述> <功能详细描述>
	 * 
	 * @author wuwei
	 * @version [版本号, May 25, 2010]
	 * @see [相关类/方法]
	 * @since [产品/模块版本]
	 */
	public static enum CompareDateFormate {
		/** 年，月，日，时，分，秒 */
		year, month, day, hour, minute, second,

		/** 日期格式 */
		yyyyMMddhhmmss, yyyyMMddhhmm, yyyyMMddhh, yyyyMMdd, yyyyMM,

		/** 日期格式 */
		MMddhhmmss, MMddhhmm, MMddhh, MMdd, ddhhmmss, ddhhmm, ddhh, hhmmss, hhmm, mmss
	}

	static {
		MAP.put(CompareDateFormate.year, new int[] { Calendar.YEAR });
		MAP.put(CompareDateFormate.month, new int[] { Calendar.MONTH });
		MAP.put(CompareDateFormate.day, new int[] { Calendar.DATE });
		MAP.put(CompareDateFormate.hour, new int[] { Calendar.HOUR_OF_DAY });
		MAP.put(CompareDateFormate.minute, new int[] { Calendar.MINUTE });
		MAP.put(CompareDateFormate.second, new int[] { Calendar.SECOND });

		MAP.put(CompareDateFormate.yyyyMMddhhmmss, new int[] { Calendar.YEAR, Calendar.MONTH, Calendar.DATE,
				Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND });
		MAP.put(CompareDateFormate.yyyyMMddhhmm,
				new int[] { Calendar.YEAR, Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE });
		MAP.put(CompareDateFormate.yyyyMMddhh,
				new int[] { Calendar.YEAR, Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY });
		MAP.put(CompareDateFormate.yyyyMMdd, new int[] { Calendar.YEAR, Calendar.MONTH, Calendar.DATE });
		MAP.put(CompareDateFormate.yyyyMM, new int[] { Calendar.YEAR, Calendar.MONTH });

		MAP.put(CompareDateFormate.MMddhhmmss,
				new int[] { Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND });
		MAP.put(CompareDateFormate.MMddhhmm,
				new int[] { Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE });
		MAP.put(CompareDateFormate.MMddhh, new int[] { Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY });
		MAP.put(CompareDateFormate.MMdd, new int[] { Calendar.MONTH, Calendar.DATE });

		MAP.put(CompareDateFormate.ddhhmmss,
				new int[] { Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND });
		MAP.put(CompareDateFormate.ddhhmm, new int[] { Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE });
		MAP.put(CompareDateFormate.ddhh, new int[] { Calendar.DATE, Calendar.HOUR_OF_DAY });

		MAP.put(CompareDateFormate.hhmmss, new int[] { Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND });
		MAP.put(CompareDateFormate.hhmm, new int[] { Calendar.HOUR_OF_DAY, Calendar.MINUTE });
		MAP.put(CompareDateFormate.mmss, new int[] { Calendar.MINUTE, Calendar.SECOND });
	}

	/**
	 * 根据CompareFields的格式（如只比较年月）比较两个日期先后，
	 * 在比较字段内，若返回1，表示date1在date2之后，返回-1，表示date1在date2之前，0表示两者相等
	 * 
	 * @param date1
	 *            Date
	 * @param date2
	 *            Date
	 * @param cdf
	 *            CompareDateFormate
	 * @return int
	 * @see [类、类#方法、类#成员]
	 */
	public static int compare(Date date1, Date date2, CompareDateFormate cdf) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);

		int[] form = MAP.get(cdf);
		for (int field : form) {
			int t1 = c1.get(field);
			int t2 = c2.get(field);
			if (t1 > t2) {
				return 1;
			} else if (t1 < t2) {
				return -1;
			}
		}

		return 0;
	}

	/**
	 * 格式化为 Timestamp
	 * 
	 * @param dateStr
	 *            String
	 * @param formater
	 *            String
	 * @return Timestamp
	 * @see [类、类#方法、类#成员]
	 */
	public static Timestamp formTimestamp(String dateStr, String formater) {
		return new Timestamp(formdate(dateStr, formater).getTime());
	}

	/**
	 * 把字符串格式化日期
	 * 
	 * @param dateStr
	 *            String
	 * @param formater
	 *            String
	 * @return Date
	 * @see [类、类#方法、类#成员]
	 */
	public static Date formdate(String dateStr, String formater) {
		formater = (null == formater) ? "yyyy-MM-dd HH:mm:ss" : formater;
		try {
			SimpleDateFormat sf = new SimpleDateFormat(formater, ResourceUtil.getLocaleObject());
			return sf.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 把字符串格式化日期
	 * 
	 * @param dateStr
	 *            String
	 *            String
	 * @return Date
	 * @see [类、类#方法、类#成员]
	 */
	public static Date formdate(String dateStr) {
		if (StringUtils.isNotBlank(dateStr)) {
			try {
				if (yyyyMMddHHmmss_Pattern.matcher(dateStr).matches()) {
					SimpleDateFormat sf = new SimpleDateFormat(FORMAT_YYYY_MM_DD_SECONDS,
							ResourceUtil.getLocaleObject());
					return sf.parse(dateStr);
				} else if (yyyyMMdd_Pattern.matcher(dateStr).matches()) {
					SimpleDateFormat sf = new SimpleDateFormat(FORMAT_YYYY_MM_DD, ResourceUtil.getLocaleObject());
					return sf.parse(dateStr);
				}
			} catch (ParseException e) {
			}
		}
		return null;
	}

	/**
	 * 判断时间间隔是不是指定的天数 <功能详细描述>
	 * 
	 * @param begin
	 *            Calendar 起始时间
	 * @param end
	 *            Calendar 结束时间
	 * @param days
	 *            int
	 * @return boolean true 两时间的时间间隔相等
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean checkBetweenDay(Calendar begin, Calendar end, int days) {
		Calendar tmp = Calendar.getInstance();
		tmp.setTime(end.getTime());
		tmp.set(Calendar.DATE, end.get(Calendar.DATE) - days);
		return DateUtils.isSameDay(begin, tmp);
	}

	/**
	 * 判断时间间隔是不是指定的月数(如果结束时间的月里没有开始时间的天，则判断是不是这个月的最后一天)
	 * 
	 * @param begin
	 *            Calendar 起始时间
	 * @param end
	 *            Calendar 结束时间
	 * @param months
	 *            int
	 * @return boolean true 时间间隔是指定的月数
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean checkBetweenMonth(Calendar begin, Calendar end, int months) {
		// 订购结束时间那个月的最大天数
		int maximumDaysOfMonth = end.getActualMaximum(Calendar.DATE);
		if (begin.get(Calendar.DATE) > maximumDaysOfMonth) {
			// 判断end的天是否是月的最后一天
			if (end.get(Calendar.DATE) == maximumDaysOfMonth) {
				// 判断月份间隔是否是months
				int betweenMonths = (end.get(Calendar.YEAR) - begin.get(Calendar.YEAR)) * 12
						+ (end.get(Calendar.MONTH) - begin.get(Calendar.MONTH));
				return (betweenMonths == months) ? true : false;
			} else {
				return false;
			}
		} else {
			// 判断天是否相同
			if (end.get(Calendar.DATE) == begin.get(Calendar.DATE)) {
				// 判断月份间隔是否是months
				int betweenMonths = (end.get(Calendar.YEAR) - begin.get(Calendar.YEAR)) * 12
						+ (end.get(Calendar.MONTH) - begin.get(Calendar.MONTH));
				return (betweenMonths == months) ? true : false;
			} else {
				return false;
			}
		}
	}

	/**
	 * 判断时间间隔是不是指定的年数(如果结束时间的月里没有开始时间的天，则判断是不是这个月的最后一天) <功能详细描述>
	 * 
	 * @param begin
	 *            Calendar
	 * @param end
	 *            Calendar
	 * @param years
	 *            int
	 * @return boolean true 时间间隔是指定的年数
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean checkBetweenYear(Calendar begin, Calendar end, int years) {
		int maximumDaysOfMonth = end.getActualMaximum(Calendar.DATE);
		if (begin.get(Calendar.DATE) > maximumDaysOfMonth) {
			// 判断end的天是否是月的最后一天
			if (end.get(Calendar.DATE) == maximumDaysOfMonth && end.get(Calendar.MONTH) == begin.get(Calendar.MONTH)) {
				// 判断年份间隔是否是years
				int betweenYears = end.get(Calendar.YEAR) - begin.get(Calendar.YEAR);
				return (betweenYears == years) ? true : false;
			} else {
				return false;
			}
		} else {
			// 判断天是否相同
			if (end.get(Calendar.DATE) == begin.get(Calendar.DATE)
					&& end.get(Calendar.MONTH) == begin.get(Calendar.MONTH)) {
				// 判断年份间隔是否是years
				int betweenYears = end.get(Calendar.YEAR) - begin.get(Calendar.YEAR);
				return (betweenYears == years) ? true : false;
			} else {
				return false;
			}
		}
	}

	/**
	 * 获取传入时间所在周的第一天
	 * 
	 * @param calendar
	 * @return Date [返回类型说明]
	 * @exception throws
	 *                [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static Date getWeekFirstDate(Calendar calendar) {
		Calendar tempCalendar = (Calendar) calendar.clone();
		tempCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return tempCalendar.getTime();
	}

	/**
	 * 获取本周开始时间
	 *
	 * @return[参数、异常说明] @return Date [返回类型说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static Date getWeekStartTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取本周开始时间字符串
	 *
	 * @return[参数、异常说明] @return Date [返回类型说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static String getWeekStartTimeStr() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd 00:00:00", ResourceUtil.getLocaleObject());
		return sf.format(getWeekStartTime());
	}

	/**
	 * 获取传入时间所在周的最后一天
	 * 
	 * @param calendar
	 * @return Date [返回类型说明]
	 * @exception throws
	 *                [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static Date getWeekLastDate(Calendar calendar) {
		Calendar tempCalendar = (Calendar) calendar.clone();
		tempCalendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return tempCalendar.getTime();
	}

	/**
	 * 得到上周第一天
	 * 
	 * @return 上周第一天
	 */
	public static Date getPrevWeekFirstDate(Calendar calendar) {
		Calendar tempCalendar = (Calendar) calendar.clone();
		Date date = getWeekFirstDate(tempCalendar);
		tempCalendar.setTime(date);
		tempCalendar.add(Calendar.WEEK_OF_MONTH, -1);
		return tempCalendar.getTime();
	}

	/**
	 * 获取上周最后一天
	 * 
	 * @param calendar
	 * @return Date [返回类型说明]
	 * @exception throws
	 *                [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static Date getPrevWeekLastDate(Calendar calendar) {
		Calendar tempCalendar = (Calendar) calendar.clone();
		Date date = getWeekLastDate(tempCalendar);
		tempCalendar.setTime(date);
		tempCalendar.add(Calendar.WEEK_OF_MONTH, -1);
		return tempCalendar.getTime();
	}

	/**
	 * 获取下周第一天
	 * 
	 * @param calendar
	 * @return Date [返回类型说明]
	 * @exception throws
	 *                [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static Date getNextWeekFirstDate(Calendar calendar) {
		Calendar tempCalendar = (Calendar) calendar.clone();
		Date date = getWeekFirstDate(tempCalendar);
		tempCalendar.setTime(date);
		tempCalendar.add(Calendar.WEEK_OF_MONTH, 1);
		return tempCalendar.getTime();
	}

	/**
	 * 获取下周最后一天
	 * 
	 * @param calendar
	 * @return Date [返回类型说明]
	 * @exception throws
	 *                [违例类型] [违例说明]
	 * @see [类、类#方法、类#成员]
	 */
	public static Date getNextWeekLastDate(Calendar calendar) {
		Calendar tempCalendar = (Calendar) calendar.clone();
		Date date = getWeekLastDate(tempCalendar);
		tempCalendar.setTime(date);
		tempCalendar.add(Calendar.WEEK_OF_MONTH, 1);
		return tempCalendar.getTime();
	}

	/**
	 * 得到本月第一天
	 * 
	 * @return 本月第一天
	 */
	public static Date getMonthFirstDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));

		return calendar.getTime();
	}

	/**
	 * 得到本月最后一天
	 * 
	 * @return 本月最后一天
	 */
	public static Date getMonthLastDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}

	/**
	 * 得到上月第一天
	 * 
	 * @return 上月第一天
	 */
	public static Date getPrevMonthFirstDate() {
		Date date = getMonthFirstDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);

		return calendar.getTime();
	}

	/**
	 * 得到今年元旦
	 * 
	 * @return 今年元旦
	 */
	public static Date getYearFirstDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMinimum(Calendar.DAY_OF_YEAR));

		return calendar.getTime();
	}

	/**
	 * 得到今年年末
	 * 
	 * @return 今年年末
	 */
	public static Date getYearLastDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));

		return calendar.getTime();
	}

	/**
	 * 得到去年年份
	 * 
	 * @return 今年元旦
	 */
	public static String getLastYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		return format.format(calendar.getTime());
	}

	public static Long getDaysBetween(Date startDate, Date endDate) {
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.setTime(startDate);

		Calendar toCalendar = Calendar.getInstance();
		toCalendar.setTime(endDate);

		return (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / DAY;

	}

	/**
	 * 加减时间
	 * 
	 * @param time
	 *            时间
	 * @param amount
	 *            整数表示加，负数减
	 * @param format
	 *            time的时间格式
	 * @return
	 */
	public static String timeAdd(String time, int amount, String format) {
		Date date = formdate(time, format);
		if (null == date) {
			return null;
		}
		long timeStamp = date.getTime();
		long newTimeStamp = timeStamp + amount;
		Date newDate = new Date(newTimeStamp);
		return format(newDate, format);
	}

	/**
	 * 按当前时间计算 ，获取指定的一天
	 * 
	 * @param date
	 * @return
	 */
	public static String getDate(int date) {
		Calendar cal = Calendar.getInstance();// 获取当前日期
		int day_of_month = cal.get(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, day_of_month - date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return format(cal.getTime(), FORMAT_YYYY_MM_DD_SECONDS);
	}

	/**
	 * 按当天最后的时间
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		Calendar cal = Calendar.getInstance();// 获取当前日期
		int day_of_month = cal.get(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, day_of_month);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return format(cal.getTime(), FORMAT_YYYY_MM_DD_SECONDS);
	}

	/*
	 * 按分钟增加
	 */
	public static Timestamp getMinuteHourDate(Date date, int minute) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// 分钟增加
		c.add(Calendar.MINUTE, minute);
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 返回文字描述的日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeFormatText(Date date) {
		if (date == null) {
			return null;
		}
		long diff = new Date().getTime() - date.getTime();
		long r = 0;
		if (diff > YEAR) {
			r = (diff / YEAR);
			return r + "年前";
		}
		if (diff > MONTH) {
			r = (diff / MONTH);
			return r + "个月前";
		}
		if (diff > D_DAY) {
			r = (diff / D_DAY);
			return r + "天前";
		}
		if (diff > HOUR) {
			r = (diff / HOUR);
			return r + "个小时前";
		}
		if (diff > MINUTE) {
			r = (diff / MINUTE);
			return r + "分钟前";
		}
		return "刚刚";
	}

	/**
	 * 获取本周的第一天
	 *
	 * @return
	 */
	public static Date getStartDateOfWork(Date date) {
		Calendar cal = Calendar.getInstance();// 获取当前日期
		cal.setTime(date);
		int day_of_month = cal.get(Calendar.DAY_OF_MONTH);
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
		cal.set(Calendar.DAY_OF_MONTH, day_of_month - day_of_week + 2);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取下周的时间
	 * 
	 * @param date
	 * @param week
	 * @return
	 */
	public static Date getWeekDate(Date date, int week) {
		Calendar cal = Calendar.getInstance();// 获取当前日期
		cal.setTime(date);

		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + (week - 1) * 7);

		return cal.getTime();
	}

	/**
	 * 本年度第几周
	 *
	 * @param date
	 * @return int [返回类型说明]
	 * @exception throws
	 */
	public static int getWeekNumOfYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.SUNDAY);
		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 获取某个时间段的工作日
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDutyDays(Date startDate, Date endDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);

		int result = 0;
		while (startDate.compareTo(endDate) <= 0) {
			if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				result++;
			}
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
			startDate = cal.getTime();
		}

		return result;
	}

	public static boolean isDateStr(String dateStr) {
		return StringUtils.isNotBlank(dateStr)
				&& (yyyyMMddHHmmss_Pattern.matcher(dateStr).matches() || yyyyMMdd_Pattern.matcher(dateStr).matches());
	}
	//获取格式化时间
	public static String getFormatTime(Date date){
		SimpleDateFormat sf = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
		return sf.format(date);
	}
	// 判断今天昨天是否是同年同周
	public static boolean isSameWeek() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
		Date yes = calendar.getTime();
		return getWeekNumOfYear(date) == getWeekNumOfYear(yes);
	}
	// 今天昨天是否是同一个季度
	public static boolean isSameQuarter(){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
		Date yes = calendar.getTime();
		SimpleDateFormat sf = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
		String todayFormat = sf.format(date);
		String yesFormat = sf.format(yes);
		 String todMon = todayFormat.split("-")[1];
		 String yesMon = yesFormat.split("-")[1];
		ArrayList<String> quarters = new ArrayList<String>();
		quarters.add("1,2,3");
		quarters.add("4,5,6");
		quarters.add("7,8,9");
		quarters.add("10,11,12");
		Integer toM = 0;
		Integer yeM = -1;
		for (int i = 0; i < quarters.size(); i++) {
			String tem = quarters.get(i);
			if (tem.contains(todMon)){
				toM = i;
			}
			if (tem.contains(yesMon)){
				yeM = i;
			}
		}
		System.out.println("今天昨天季度是否是同一季度:"+toM.equals(yeM));

		return toM.equals(yeM);
	}

	/**
	 * 数据周期枚举类
	 * XN 学年, XQ学期 , Y月 , Z周 , D日 , JD季度
	 */
	public static enum SjzqFormate {
		XN , XQ , Y , Z , R , JD
	}

	/**
	 * 根据传入的参数 , 返回昨天所属的数据周期
	 * @param format
	 * format参数 : quarter季度 , month月,  week周, day
	 * @return
	 */
	public static String getYesterdaySjzq(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, -1);
		int year = c.get(Calendar.YEAR);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		int week = c.get(Calendar.WEEK_OF_YEAR);
		if(format.equals(SjzqFormate.JD.toString())){//季度
			if (currentMonth >= 1 && currentMonth <= 3) {
				return year+"年一季度（1、2、3）";
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				return year+"年二季度（4、5、6）";
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				return year+"年三季度（7、8、9）";
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				return year+"年四季度（10、11、12）";
			}
		}else if(format.equals(SjzqFormate.Y.toString())){//月
			return year+"年"+currentMonth+"月";
		}else if(format.equals(SjzqFormate.Z.toString())){//周
			if (currentMonth >= 11 && week <= 1) {
				week += 52;
			}
			return year+"年第"+week+"周";
		}else if(format.equals(SjzqFormate.R.toString())){//日期
			return sdf.format(c.getTime());
		}
		return "";
	}

}
