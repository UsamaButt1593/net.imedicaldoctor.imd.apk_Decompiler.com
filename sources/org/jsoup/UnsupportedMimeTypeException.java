package org.jsoup;

import java.io.IOException;

public class UnsupportedMimeTypeException extends IOException {
    private String X;
    private String s;

    public UnsupportedMimeTypeException(String str, String str2, String str3) {
        super(str);
        this.s = str2;
        this.X = str3;
    }

    public String a() {
        return this.s;
    }

    public String b() {
        return this.X;
    }

    public String toString() {
        return super.toString() + ". Mimetype=" + this.s + ", URL=" + this.X;
    }
}
