package ch.tim.pizzashopv1.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatterUtils {

    public static final String DATE_PATTERN = "dd.MM.yyyy";
    public static final String DATE_TIME_PATTERN = DATE_PATTERN + " HH:mm:ss";
    public static final String TIME_PATTERN = "HH:mm";
    public static final String TIME_PATTERN_SECONDS = "HH:mm:ss";
    public static final String DD_MM_PATTERN = "dd.MM.";
    public static final String YYYY_MM_DD_PATTERN = "yyyy-MM-dd";
    public static final String YYYYMMDD_PATTERN = "yyyyMMdd";

    private static final Logger log = LoggerFactory.getLogger(DateFormatterUtils.class);

    private DateFormatterUtils() {
    }

    public static String formatLocalDateTime(LocalDateTime localDateTime,String pattern) {
        if(localDateTime != null) {
             var formatter = DateTimeFormatter.ofPattern(pattern);

            return localDateTime.format(formatter);
        }
        return StringUtils.EMPTY;
    }

    public static String formatDate(Date date, String format) {
        if (date != null) {
            return new SimpleDateFormat(format).format(date);
        }
        return StringUtils.EMPTY;
    }

    public static String formatTime(Date date) {
        return formatDate(date, TIME_PATTERN);
    }

    public static String formatTime(Date date, final String pattern) {
        if (date != null) {
            return new SimpleDateFormat(pattern).format(date);
        }
        return StringUtils.EMPTY;
    }

    public static Date parseDate(String date) {
        return parseDateByPattern(date, DATE_PATTERN);
    }

    public static Date parseDateDDMM(String date) {
        return parseDateByPattern(date, DD_MM_PATTERN);
    }

    public static Date parseTime(String date) {
        return parseDateByPattern(date, TIME_PATTERN);
    }



    public static Date parseDateByPattern(final String date, final String pattern) {
        if (StringUtils.isNotBlank(date)) {
            try {
                return new SimpleDateFormat(pattern).parse(date);
            } catch (ParseException e) {
                log.error("Cannot parse the date {} by pattern {}", date, pattern);
                return null;
            }
        }
        return null;
    }


    public static LocalDate toLocalDate(Date date) {
        if (date != null) {
            return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        }

        return null;
    }

    public static Date instantToDate(Instant instantDate) {
        if (instantDate != null) {
            return Date.from(instantDate);
        }
        return null;
    }

    public static LocalDate toLocalDateFromString(String strDate) {
        if (StringUtils.isNotBlank(strDate)) {
            return LocalDate.parse(strDate, DateTimeFormatter.ofPattern(DATE_PATTERN));
        }

        return null;
    }

    public static Date fromLocalDateToDate(LocalDate localDate) {
        if (localDate != null) {
            return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }

        return null;
    }

}
