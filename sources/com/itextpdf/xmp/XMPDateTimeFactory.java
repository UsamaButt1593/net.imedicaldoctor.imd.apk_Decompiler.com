package com.itextpdf.xmp;

import com.itextpdf.xmp.impl.XMPDateTimeImpl;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class XMPDateTimeFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final TimeZone f27735a = TimeZone.getTimeZone("UTC");

    private XMPDateTimeFactory() {
    }

    public static XMPDateTime a(XMPDateTime xMPDateTime) {
        long timeInMillis = xMPDateTime.o0().getTimeInMillis();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(timeInMillis);
        return new XMPDateTimeImpl((Calendar) gregorianCalendar);
    }

    public static XMPDateTime b(XMPDateTime xMPDateTime) {
        long timeInMillis = xMPDateTime.o0().getTimeInMillis();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(f27735a);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        gregorianCalendar.setTimeInMillis(timeInMillis);
        return new XMPDateTimeImpl((Calendar) gregorianCalendar);
    }

    public static XMPDateTime c() {
        return new XMPDateTimeImpl();
    }

    public static XMPDateTime d(int i2, int i3, int i4) {
        XMPDateTimeImpl xMPDateTimeImpl = new XMPDateTimeImpl();
        xMPDateTimeImpl.n0(i2);
        xMPDateTimeImpl.b2(i3);
        xMPDateTimeImpl.E0(i4);
        return xMPDateTimeImpl;
    }

    public static XMPDateTime e(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        XMPDateTimeImpl xMPDateTimeImpl = new XMPDateTimeImpl();
        xMPDateTimeImpl.n0(i2);
        xMPDateTimeImpl.b2(i3);
        xMPDateTimeImpl.E0(i4);
        xMPDateTimeImpl.X(i5);
        xMPDateTimeImpl.b0(i6);
        xMPDateTimeImpl.O1(i7);
        xMPDateTimeImpl.H0(i8);
        return xMPDateTimeImpl;
    }

    public static XMPDateTime f(Calendar calendar) {
        return new XMPDateTimeImpl(calendar);
    }

    public static XMPDateTime g(String str) throws XMPException {
        return new XMPDateTimeImpl(str);
    }

    public static XMPDateTime h() {
        return new XMPDateTimeImpl((Calendar) new GregorianCalendar());
    }

    public static XMPDateTime i(XMPDateTime xMPDateTime) {
        Calendar o0 = xMPDateTime.o0();
        o0.setTimeZone(TimeZone.getDefault());
        return new XMPDateTimeImpl(o0);
    }
}
