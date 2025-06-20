package com.itextpdf.text.pdf.hyphenation;

import java.io.Serializable;

public class CharVector implements Cloneable, Serializable {
    private static final int X2 = 2048;
    private static final long Z = -4875768298308363544L;
    private char[] X;
    private int Y;
    private int s;

    public CharVector() {
        this(2048);
    }

    public int a(int i2) {
        int i3 = this.Y;
        char[] cArr = this.X;
        int length = cArr.length;
        if (i3 + i2 >= length) {
            char[] cArr2 = new char[(this.s + length)];
            System.arraycopy(cArr, 0, cArr2, 0, length);
            this.X = cArr2;
        }
        this.Y += i2;
        return i3;
    }

    public int b() {
        return this.X.length;
    }

    public void c() {
        this.Y = 0;
    }

    public Object clone() {
        CharVector charVector = new CharVector((char[]) this.X.clone(), this.s);
        charVector.Y = this.Y;
        return charVector;
    }

    public char d(int i2) {
        return this.X[i2];
    }

    public char[] e() {
        return this.X;
    }

    public int f() {
        return this.Y;
    }

    public void g(int i2, char c2) {
        this.X[i2] = c2;
    }

    public void h() {
        int i2 = this.Y;
        char[] cArr = this.X;
        if (i2 < cArr.length) {
            char[] cArr2 = new char[i2];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.X = cArr2;
        }
    }

    public CharVector(int i2) {
        this.s = i2 <= 0 ? 2048 : i2;
        this.X = new char[this.s];
        this.Y = 0;
    }

    public CharVector(char[] cArr) {
        this.s = 2048;
        this.X = cArr;
        this.Y = cArr.length;
    }

    public CharVector(char[] cArr, int i2) {
        this.s = i2 <= 0 ? 2048 : i2;
        this.X = cArr;
        this.Y = cArr.length;
    }
}
