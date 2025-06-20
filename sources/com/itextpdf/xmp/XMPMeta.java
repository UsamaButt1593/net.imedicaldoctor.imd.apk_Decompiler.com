package com.itextpdf.xmp;

import com.itextpdf.xmp.options.IteratorOptions;
import com.itextpdf.xmp.options.ParseOptions;
import com.itextpdf.xmp.options.PropertyOptions;
import com.itextpdf.xmp.properties.XMPProperty;
import java.util.Calendar;

public interface XMPMeta extends Cloneable {
    void A0(String str, String str2, Calendar calendar, PropertyOptions propertyOptions) throws XMPException;

    void B0(String str, String str2, Calendar calendar) throws XMPException;

    Boolean B1(String str, String str2) throws XMPException;

    void C(String str, String str2, String str3, String str4, String str5, PropertyOptions propertyOptions) throws XMPException;

    void D2(String str, String str2, byte[] bArr, PropertyOptions propertyOptions) throws XMPException;

    void E1(String str, String str2, int i2, PropertyOptions propertyOptions) throws XMPException;

    XMPProperty G1(String str, String str2, String str3, String str4) throws XMPException;

    XMPProperty H(String str, String str2, String str3, String str4) throws XMPException;

    String H2();

    XMPProperty I(String str, String str2, int i2) throws XMPException;

    void I0(String str, String str2, String str3, String str4);

    void I1(String str, String str2, long j2) throws XMPException;

    void J0(String str, String str2, byte[] bArr) throws XMPException;

    void J1(String str, String str2, int i2) throws XMPException;

    void K1(String str);

    void K2(String str, String str2, long j2, PropertyOptions propertyOptions) throws XMPException;

    int L1(String str, String str2) throws XMPException;

    void N(String str, String str2, String str3) throws XMPException;

    byte[] N1(String str, String str2) throws XMPException;

    void O(String str, String str2, double d2) throws XMPException;

    void O2(String str, String str2, boolean z) throws XMPException;

    void P0(String str, String str2, String str3, String str4, String str5, PropertyOptions propertyOptions) throws XMPException;

    Calendar P1(String str, String str2) throws XMPException;

    XMPIterator Q0(String str, String str2, IteratorOptions iteratorOptions) throws XMPException;

    void R(String str, String str2, int i2, String str3, PropertyOptions propertyOptions) throws XMPException;

    void R2(String str, String str2, Object obj) throws XMPException;

    void T(String str, String str2, String str3, String str4, String str5, PropertyOptions propertyOptions) throws XMPException;

    void U0(String str, String str2, PropertyOptions propertyOptions, String str3, PropertyOptions propertyOptions2) throws XMPException;

    boolean V0(String str, String str2);

    Integer V1(String str, String str2) throws XMPException;

    Double W(String str, String str2) throws XMPException;

    boolean W1(String str, String str2, int i2);

    void X0(String str, String str2, Object obj, PropertyOptions propertyOptions) throws XMPException;

    void X1(String str, String str2, int i2, String str3) throws XMPException;

    void Y1(String str, String str2, XMPDateTime xMPDateTime, PropertyOptions propertyOptions) throws XMPException;

    XMPProperty Z1(String str, String str2, String str3, String str4) throws XMPException;

    void a1(String str, String str2, String str3, String str4, String str5) throws XMPException;

    XMPIterator c2(IteratorOptions iteratorOptions) throws XMPException;

    Object clone();

    void d0(String str, String str2, String str3, String str4, String str5) throws XMPException;

    String f1();

    XMPProperty h2(String str, String str2) throws XMPException;

    void i0(String str, String str2, XMPDateTime xMPDateTime) throws XMPException;

    XMPIterator iterator() throws XMPException;

    void j0(String str, String str2, String str3, String str4, String str5) throws XMPException;

    void l2(String str, String str2, int i2);

    void m1(String str, String str2, boolean z, PropertyOptions propertyOptions) throws XMPException;

    void n1(String str, String str2);

    void o1(String str, String str2, String str3, String str4);

    void o2(ParseOptions parseOptions) throws XMPException;

    String p1();

    boolean q1(String str, String str2, String str3, String str4);

    void s1(String str, String str2, int i2, String str3) throws XMPException;

    void s2(String str, String str2, double d2, PropertyOptions propertyOptions) throws XMPException;

    XMPDateTime v1(String str, String str2) throws XMPException;

    void v2();

    void x0(String str, String str2, int i2, String str3, PropertyOptions propertyOptions) throws XMPException;

    boolean x1(String str, String str2, String str3, String str4);

    String y2(String str, String str2) throws XMPException;

    Long z2(String str, String str2) throws XMPException;
}
