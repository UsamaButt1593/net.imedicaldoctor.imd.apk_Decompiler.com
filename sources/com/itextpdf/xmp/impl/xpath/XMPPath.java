package com.itextpdf.xmp.impl.xpath;

import java.util.ArrayList;
import java.util.List;

public class XMPPath {

    /* renamed from: b  reason: collision with root package name */
    public static final int f27789b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f27790c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f27791d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f27792e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f27793f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f27794g = 6;

    /* renamed from: h  reason: collision with root package name */
    public static final int f27795h = Integer.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public static final int f27796i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f27797j = 1;

    /* renamed from: a  reason: collision with root package name */
    private List f27798a = new ArrayList(5);

    public void a(XMPPathSegment xMPPathSegment) {
        this.f27798a.add(xMPPathSegment);
    }

    public XMPPathSegment b(int i2) {
        return (XMPPathSegment) this.f27798a.get(i2);
    }

    public int c() {
        return this.f27798a.size();
    }

    public String toString() {
        int b2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 1; i2 < c(); i2++) {
            stringBuffer.append(b(i2));
            if (i2 < c() - 1 && ((b2 = b(i2 + 1).b()) == 1 || b2 == 2)) {
                stringBuffer.append('/');
            }
        }
        return stringBuffer.toString();
    }
}
