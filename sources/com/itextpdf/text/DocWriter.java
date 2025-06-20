package com.itextpdf.text;

import com.itextpdf.text.pdf.OutputStreamCounter;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public abstract class DocWriter implements DocListener {
    public static final byte Z2 = 10;
    public static final byte a3 = 9;
    public static final byte b3 = 60;
    public static final byte c3 = 32;
    public static final byte d3 = 61;
    public static final byte e3 = 34;
    public static final byte f3 = 62;
    public static final byte g3 = 47;
    protected Document X;
    protected boolean X2 = false;
    protected OutputStreamCounter Y;
    protected boolean Y2 = true;
    protected boolean Z = false;
    protected Rectangle s;

    protected DocWriter() {
    }

    public static final byte[] E(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) str.charAt(i2);
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public void C(int i2) throws IOException {
        this.Y.write(10);
        for (int i3 = 0; i3 < i2; i3++) {
            this.Y.write(9);
        }
    }

    public void D() {
        try {
            this.Y.flush();
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public boolean F() {
        return this.Y2;
    }

    public boolean G() {
        return this.X2;
    }

    public void H() {
        this.X2 = true;
    }

    public void I() {
        this.X2 = false;
    }

    public void J(boolean z) {
        this.Y2 = z;
    }

    /* access modifiers changed from: protected */
    public void K(String str) throws IOException {
        this.Y.write(E(str));
    }

    /* access modifiers changed from: protected */
    public void L(String str, String str2) throws IOException {
        this.Y.write(32);
        K(str);
        this.Y.write(61);
        this.Y.write(34);
        K(str2);
        this.Y.write(34);
    }

    /* access modifiers changed from: protected */
    public void M() throws IOException {
        this.Y.write(32);
        this.Y.write(47);
        this.Y.write(62);
    }

    /* access modifiers changed from: protected */
    public void N(String str) throws IOException {
        this.Y.write(60);
        this.Y.write(47);
        K(str);
        this.Y.write(62);
    }

    /* access modifiers changed from: protected */
    public boolean O(Properties properties) throws IOException {
        if (properties == null) {
            return false;
        }
        for (Object valueOf : properties.keySet()) {
            String valueOf2 = String.valueOf(valueOf);
            L(valueOf2, properties.getProperty(valueOf2));
        }
        properties.clear();
        return true;
    }

    /* access modifiers changed from: protected */
    public void P(String str) throws IOException {
        this.Y.write(60);
        K(str);
    }

    public boolean b(Element element) throws DocumentException {
        return false;
    }

    public boolean c(boolean z) {
        return false;
    }

    public void close() {
        this.Z = false;
        try {
            this.Y.flush();
            if (this.Y2) {
                this.Y.close();
            }
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public boolean f() {
        return this.Z;
    }

    public boolean g(boolean z) {
        return false;
    }

    public boolean j(Rectangle rectangle) {
        this.s = rectangle;
        return true;
    }

    public boolean k(float f2, float f4, float f5, float f6) {
        return false;
    }

    public void open() {
        this.Z = true;
    }

    public void s() {
    }

    public void t(int i2) {
    }

    protected DocWriter(Document document, OutputStream outputStream) {
        this.X = document;
        this.Y = new OutputStreamCounter(new BufferedOutputStream(outputStream));
    }
}
