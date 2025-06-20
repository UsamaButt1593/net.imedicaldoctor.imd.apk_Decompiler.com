package com.itextpdf.xmp.impl;

import com.itextpdf.xmp.XMPDateTime;
import com.itextpdf.xmp.XMPException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.threeten.bp.chrono.HijrahDate;

public class XMPDateTimeImpl implements XMPDateTime {
    private int X = 0;
    private int X2 = 0;
    private int Y = 0;
    private int Y2 = 0;
    private int Z = 0;
    private TimeZone Z2 = null;
    private int a3;
    private boolean b3 = false;
    private boolean c3 = false;
    private boolean d3 = false;
    private int s = 0;

    public XMPDateTimeImpl() {
    }

    public int A1() {
        return this.Z;
    }

    public void E0(int i2) {
        if (i2 < 1) {
            this.Y = 1;
        } else if (i2 > 31) {
            this.Y = 31;
        } else {
            this.Y = i2;
        }
        this.b3 = true;
    }

    public void H0(int i2) {
        this.a3 = i2;
        this.c3 = true;
    }

    public int M0() {
        return this.s;
    }

    public void O1(int i2) {
        this.Y2 = Math.min(Math.abs(i2), 59);
        this.c3 = true;
    }

    public int S1() {
        return this.Y2;
    }

    public int W0() {
        return this.X;
    }

    public void X(int i2) {
        this.Z = Math.min(Math.abs(i2), 23);
        this.c3 = true;
    }

    public void b0(int i2) {
        this.X2 = Math.min(Math.abs(i2), 59);
        this.c3 = true;
    }

    public void b2(int i2) {
        if (i2 < 1) {
            this.X = 1;
        } else if (i2 > 12) {
            this.X = 12;
        } else {
            this.X = i2;
        }
        this.b3 = true;
    }

    public int compareTo(Object obj) {
        XMPDateTime xMPDateTime = (XMPDateTime) obj;
        long timeInMillis = o0().getTimeInMillis() - xMPDateTime.o0().getTimeInMillis();
        if (timeInMillis == 0) {
            timeInMillis = (long) (this.a3 - xMPDateTime.f0());
        }
        return (int) Math.signum((float) timeInMillis);
    }

    public int f0() {
        return this.a3;
    }

    public int g1() {
        return this.Y;
    }

    public boolean g2() {
        return this.b3;
    }

    public TimeZone getTimeZone() {
        return this.Z2;
    }

    public boolean l0() {
        return this.d3;
    }

    public void n0(int i2) {
        this.s = Math.min(Math.abs(i2), HijrahDate.f3);
        this.b3 = true;
    }

    public Calendar o0() {
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance(Locale.US);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        if (this.d3) {
            gregorianCalendar.setTimeZone(this.Z2);
        }
        gregorianCalendar.set(1, this.s);
        gregorianCalendar.set(2, this.X - 1);
        gregorianCalendar.set(5, this.Y);
        gregorianCalendar.set(11, this.Z);
        gregorianCalendar.set(12, this.X2);
        gregorianCalendar.set(13, this.Y2);
        gregorianCalendar.set(14, this.a3 / 1000000);
        return gregorianCalendar;
    }

    public String t0() {
        return ISO8601Converter.c(this);
    }

    public String toString() {
        return t0();
    }

    public int y0() {
        return this.X2;
    }

    public void y1(TimeZone timeZone) {
        this.Z2 = timeZone;
        this.c3 = true;
        this.d3 = true;
    }

    public boolean z0() {
        return this.c3;
    }

    public XMPDateTimeImpl(String str) throws XMPException {
        ISO8601Converter.b(str, this);
    }

    public XMPDateTimeImpl(Calendar calendar) {
        Date time = calendar.getTime();
        TimeZone timeZone = calendar.getTimeZone();
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance(Locale.US);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        gregorianCalendar.setTimeZone(timeZone);
        gregorianCalendar.setTime(time);
        this.s = gregorianCalendar.get(1);
        this.X = gregorianCalendar.get(2) + 1;
        this.Y = gregorianCalendar.get(5);
        this.Z = gregorianCalendar.get(11);
        this.X2 = gregorianCalendar.get(12);
        this.Y2 = gregorianCalendar.get(13);
        this.a3 = gregorianCalendar.get(14) * 1000000;
        this.Z2 = gregorianCalendar.getTimeZone();
        this.d3 = true;
        this.c3 = true;
        this.b3 = true;
    }

    public XMPDateTimeImpl(Date date, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
        gregorianCalendar.setTime(date);
        this.s = gregorianCalendar.get(1);
        this.X = gregorianCalendar.get(2) + 1;
        this.Y = gregorianCalendar.get(5);
        this.Z = gregorianCalendar.get(11);
        this.X2 = gregorianCalendar.get(12);
        this.Y2 = gregorianCalendar.get(13);
        this.a3 = gregorianCalendar.get(14) * 1000000;
        this.Z2 = timeZone;
        this.d3 = true;
        this.c3 = true;
        this.b3 = true;
    }
}
