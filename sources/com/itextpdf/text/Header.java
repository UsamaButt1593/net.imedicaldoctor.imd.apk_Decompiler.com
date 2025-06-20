package com.itextpdf.text;

public class Header extends Meta {
    private StringBuffer c3;

    public Header(String str, String str2) {
        super(0, str2);
        this.c3 = new StringBuffer(str);
    }

    public String e() {
        return this.c3.toString();
    }
}
