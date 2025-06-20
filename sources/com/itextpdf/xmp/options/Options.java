package com.itextpdf.xmp.options;

import com.itextpdf.xmp.XMPException;
import java.util.HashMap;
import java.util.Map;

public abstract class Options {

    /* renamed from: a  reason: collision with root package name */
    private int f27812a = 0;

    /* renamed from: b  reason: collision with root package name */
    private Map f27813b = null;

    public Options() {
    }

    private void b(int i2) throws XMPException {
        int i3 = (~k()) & i2;
        if (i3 == 0) {
            a(i2);
            return;
        }
        throw new XMPException("The option bit(s) 0x" + Integer.toHexString(i3) + " are invalid!", 103);
    }

    private String h(int i2) {
        Map m2 = m();
        Integer num = new Integer(i2);
        String str = (String) m2.get(num);
        if (str != null) {
            return str;
        }
        String f2 = f(i2);
        if (f2 == null) {
            return "<option name not defined>";
        }
        m2.put(num, f2);
        return f2;
    }

    private Map m() {
        if (this.f27813b == null) {
            this.f27813b = new HashMap();
        }
        return this.f27813b;
    }

    /* access modifiers changed from: protected */
    public void a(int i2) throws XMPException {
    }

    public void c() {
        this.f27812a = 0;
    }

    public boolean d(int i2) {
        return (i() & i2) == i2;
    }

    public boolean e(int i2) {
        return (i2 & i()) != 0;
    }

    public boolean equals(Object obj) {
        return i() == ((Options) obj).i();
    }

    /* access modifiers changed from: protected */
    public abstract String f(int i2);

    /* access modifiers changed from: protected */
    public boolean g(int i2) {
        return (i2 & this.f27812a) != 0;
    }

    public int hashCode() {
        return i();
    }

    public int i() {
        return this.f27812a;
    }

    public String j() {
        if (this.f27812a == 0) {
            return "<none>";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = this.f27812a;
        while (i2 != 0) {
            int i3 = (i2 - 1) & i2;
            stringBuffer.append(h(i2 ^ i3));
            if (i3 != 0) {
                stringBuffer.append(" | ");
            }
            i2 = i3;
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public abstract int k();

    public boolean l(int i2) {
        return i() == i2;
    }

    public void n(int i2, boolean z) {
        int i3;
        if (z) {
            i3 = i2 | this.f27812a;
        } else {
            i3 = (~i2) & this.f27812a;
        }
        this.f27812a = i3;
    }

    public void o(int i2) throws XMPException {
        b(i2);
        this.f27812a = i2;
    }

    public String toString() {
        return "0x" + Integer.toHexString(this.f27812a);
    }

    public Options(int i2) throws XMPException {
        b(i2);
        o(i2);
    }
}
