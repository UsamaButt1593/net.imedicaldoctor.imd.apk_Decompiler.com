package com.itextpdf.xmp.impl;

import com.itextpdf.xmp.XMPException;

class ParseState {

    /* renamed from: a  reason: collision with root package name */
    private String f27748a;

    /* renamed from: b  reason: collision with root package name */
    private int f27749b = 0;

    public ParseState(String str) {
        this.f27748a = str;
    }

    public char a() {
        if (this.f27749b < this.f27748a.length()) {
            return this.f27748a.charAt(this.f27749b);
        }
        return 0;
    }

    public char b(int i2) {
        if (i2 < this.f27748a.length()) {
            return this.f27748a.charAt(i2);
        }
        return 0;
    }

    public int c(String str, int i2) throws XMPException {
        char b2 = b(this.f27749b);
        int i3 = 0;
        boolean z = false;
        while ('0' <= b2 && b2 <= '9') {
            i3 = (i3 * 10) + (b2 - '0');
            z = true;
            int i4 = this.f27749b + 1;
            this.f27749b = i4;
            b2 = b(i4);
        }
        if (!z) {
            throw new XMPException(str, 5);
        } else if (i3 > i2) {
            return i2;
        } else {
            if (i3 < 0) {
                return 0;
            }
            return i3;
        }
    }

    public boolean d() {
        return this.f27749b < this.f27748a.length();
    }

    public int e() {
        return this.f27748a.length();
    }

    public int f() {
        return this.f27749b;
    }

    public void g() {
        this.f27749b++;
    }
}
