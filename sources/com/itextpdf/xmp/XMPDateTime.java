package com.itextpdf.xmp;

import java.util.Calendar;
import java.util.TimeZone;

public interface XMPDateTime extends Comparable {
    int A1();

    void E0(int i2);

    void H0(int i2);

    int M0();

    void O1(int i2);

    int S1();

    int W0();

    void X(int i2);

    void b0(int i2);

    void b2(int i2);

    int f0();

    int g1();

    boolean g2();

    TimeZone getTimeZone();

    boolean l0();

    void n0(int i2);

    Calendar o0();

    String t0();

    int y0();

    void y1(TimeZone timeZone);

    boolean z0();
}
