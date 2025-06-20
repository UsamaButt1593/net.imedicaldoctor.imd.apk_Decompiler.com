package com.itextpdf.xmp.impl;

public class QName {

    /* renamed from: a  reason: collision with root package name */
    private String f27750a;

    /* renamed from: b  reason: collision with root package name */
    private String f27751b;

    public QName(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf >= 0) {
            this.f27750a = str.substring(0, indexOf);
            str = str.substring(indexOf + 1);
        } else {
            this.f27750a = "";
        }
        this.f27751b = str;
    }

    public String a() {
        return this.f27751b;
    }

    public String b() {
        return this.f27750a;
    }

    public boolean c() {
        String str = this.f27750a;
        return str != null && str.length() > 0;
    }

    public QName(String str, String str2) {
        this.f27750a = str;
        this.f27751b = str2;
    }
}
