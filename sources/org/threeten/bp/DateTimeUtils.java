package org.threeten.bp;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class DateTimeUtils {
    private DateTimeUtils() {
    }

    public static Date a(Instant instant) {
        try {
            return new Date(instant.Y0());
        } catch (ArithmeticException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static GregorianCalendar b(ZonedDateTime zonedDateTime) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(m(zonedDateTime.y()));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        gregorianCalendar.setFirstDayOfWeek(2);
        gregorianCalendar.setMinimalDaysInFirstWeek(4);
        try {
            gregorianCalendar.setTimeInMillis(zonedDateTime.S().Y0());
            return gregorianCalendar;
        } catch (ArithmeticException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Instant c(Timestamp timestamp) {
        return Instant.k0(timestamp.getTime() / 1000, (long) timestamp.getNanos());
    }

    public static Instant d(Calendar calendar) {
        return Instant.c0(calendar.getTimeInMillis());
    }

    public static Instant e(Date date) {
        return Instant.c0(date.getTime());
    }

    public static LocalDate f(java.sql.Date date) {
        return LocalDate.r2(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
    }

    public static LocalDateTime g(Timestamp timestamp) {
        return LocalDateTime.i2(timestamp.getYear() + 1900, timestamp.getMonth() + 1, timestamp.getDate(), timestamp.getHours(), timestamp.getMinutes(), timestamp.getSeconds(), timestamp.getNanos());
    }

    public static LocalTime h(Time time) {
        return LocalTime.q0(time.getHours(), time.getMinutes(), time.getSeconds());
    }

    public static java.sql.Date i(LocalDate localDate) {
        return new java.sql.Date(localDate.M0() - 1900, localDate.w1() - 1, localDate.h1());
    }

    public static Time j(LocalTime localTime) {
        return new Time(localTime.A1(), localTime.y0(), localTime.S1());
    }

    public static Timestamp k(Instant instant) {
        try {
            Timestamp timestamp = new Timestamp(instant.y() * 1000);
            timestamp.setNanos(instant.z());
            return timestamp;
        } catch (ArithmeticException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Timestamp l(LocalDateTime localDateTime) {
        return new Timestamp(localDateTime.M0() - 1900, localDateTime.L0() - 1, localDateTime.C0(), localDateTime.A1(), localDateTime.y0(), localDateTime.S1(), localDateTime.R0());
    }

    public static TimeZone m(ZoneId zoneId) {
        String s = zoneId.s();
        if (s.startsWith("+") || s.startsWith("-")) {
            s = "GMT" + s;
        } else if (s.equals("Z")) {
            s = "UTC";
        }
        return TimeZone.getTimeZone(s);
    }

    public static ZoneId n(TimeZone timeZone) {
        return ZoneId.x(timeZone.getID(), ZoneId.X);
    }

    public static ZonedDateTime o(Calendar calendar) {
        return ZonedDateTime.q2(Instant.c0(calendar.getTimeInMillis()), n(calendar.getTimeZone()));
    }
}
