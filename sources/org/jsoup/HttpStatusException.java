package org.jsoup;

import java.io.IOException;

public class HttpStatusException extends IOException {
    private String X;
    private int s;

    public HttpStatusException(String str, int i2, String str2) {
        super(str);
        this.s = i2;
        this.X = str2;
    }

    public int a() {
        return this.s;
    }

    public String b() {
        return this.X;
    }

    public String toString() {
        return super.toString() + ". Status=" + this.s + ", URL=" + this.X;
    }
}
