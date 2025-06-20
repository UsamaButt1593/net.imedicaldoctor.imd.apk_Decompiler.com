package com.itextpdf.text;

import java.util.ArrayList;
import java.util.List;

public class Meta implements Element {
    public static final String X2 = "creationdate";
    public static final String Y = "unknown";
    public static final String Y2 = "author";
    public static final String Z = "producer";
    public static final String Z2 = "keywords";
    public static final String a3 = "subject";
    public static final String b3 = "title";
    private final StringBuffer X;
    private final int s;

    Meta(int i2, String str) {
        this.s = i2;
        this.X = new StringBuffer(str);
    }

    public static int f(String str) {
        if ("subject".equals(str)) {
            return 2;
        }
        if (Z2.equals(str)) {
            return 3;
        }
        if (Y2.equals(str)) {
            return 4;
        }
        if ("title".equals(str)) {
            return 1;
        }
        if (Z.equals(str)) {
            return 5;
        }
        return X2.equals(str) ? 6 : 0;
    }

    public boolean V() {
        return false;
    }

    public List<Chunk> Y() {
        return new ArrayList();
    }

    public StringBuffer a(String str) {
        StringBuffer stringBuffer = this.X;
        stringBuffer.append(str);
        return stringBuffer;
    }

    public String c() {
        return this.X.toString();
    }

    public String e() {
        switch (this.s) {
            case 1:
                return "title";
            case 2:
                return "subject";
            case 3:
                return Z2;
            case 4:
                return Y2;
            case 5:
                return Z;
            case 6:
                return X2;
            default:
                return "unknown";
        }
    }

    public boolean t(ElementListener elementListener) {
        try {
            return elementListener.b(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public int type() {
        return this.s;
    }

    public boolean x() {
        return false;
    }

    public Meta(String str, String str2) {
        this.s = f(str);
        this.X = new StringBuffer(str2);
    }
}
