package org.ccil.cowan.tagsoup;

import java.util.HashMap;

public abstract class Schema {
    public static final int B = -1;
    public static final int C = 0;
    public static final int D = 1073741824;
    public static final int E = Integer.MIN_VALUE;
    public static final int F = 1;
    public static final int G = 2;
    public static final int H = 4;
    private ElementType A = null;
    private HashMap w = new HashMap();
    private HashMap x = new HashMap();
    private String y = "";
    private String z = "";

    public void a(String str, String str2, String str3, String str4) {
        ElementType d2 = d(str);
        if (d2 != null) {
            d2.n(str2, str3, str4);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Attribute ");
        stringBuffer.append(str2);
        stringBuffer.append(" specified for unknown element type ");
        stringBuffer.append(str);
        throw new Error(stringBuffer.toString());
    }

    public void b(String str, int i2, int i3, int i4) {
        ElementType elementType = new ElementType(str, i2, i3, i4, this);
        this.x.put(str.toLowerCase(), elementType);
        if (i3 == Integer.MIN_VALUE) {
            this.A = elementType;
        }
    }

    public void c(String str, int i2) {
        this.w.put(str, new Integer(i2));
    }

    public ElementType d(String str) {
        return (ElementType) this.x.get(str.toLowerCase());
    }

    public int e(String str) {
        Integer num = (Integer) this.w.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String f() {
        return this.z;
    }

    public String g() {
        return this.y;
    }

    public void h(String str, String str2) {
        ElementType d2 = d(str);
        ElementType d3 = d(str2);
        if (d2 == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No child ");
            stringBuffer.append(str);
            stringBuffer.append(" for parent ");
            stringBuffer.append(str2);
            throw new Error(stringBuffer.toString());
        } else if (d3 != null) {
            d2.s(d3);
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("No parent ");
            stringBuffer2.append(str2);
            stringBuffer2.append(" for child ");
            stringBuffer2.append(str);
            throw new Error(stringBuffer2.toString());
        }
    }

    public ElementType i() {
        return this.A;
    }

    public void j(String str) {
        this.z = str;
    }

    public void k(String str) {
        this.y = str;
    }
}
