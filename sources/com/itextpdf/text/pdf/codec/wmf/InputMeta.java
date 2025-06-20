package com.itextpdf.text.pdf.codec.wmf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Utilities;
import java.io.IOException;
import java.io.InputStream;

public class InputMeta {

    /* renamed from: a  reason: collision with root package name */
    InputStream f26710a;

    /* renamed from: b  reason: collision with root package name */
    int f26711b;

    public InputMeta(InputStream inputStream) {
        this.f26710a = inputStream;
    }

    public int a() {
        return this.f26711b;
    }

    public int b() throws IOException {
        this.f26711b++;
        return this.f26710a.read() & 255;
    }

    public BaseColor c() throws IOException {
        int b2 = b();
        int b3 = b();
        int b4 = b();
        b();
        return new BaseColor(b2, b3, b4);
    }

    public int d() throws IOException {
        this.f26711b += 4;
        int read = this.f26710a.read();
        if (read < 0) {
            return 0;
        }
        return read + (this.f26710a.read() << 8) + (this.f26710a.read() << 16) + (this.f26710a.read() << 24);
    }

    public int e() throws IOException {
        int f2 = f();
        return f2 > 32767 ? f2 - 65536 : f2;
    }

    public int f() throws IOException {
        this.f26711b += 2;
        int read = this.f26710a.read();
        if (read < 0) {
            return 0;
        }
        return (read + (this.f26710a.read() << 8)) & 65535;
    }

    public void g(int i2) throws IOException {
        this.f26711b += i2;
        Utilities.v(this.f26710a, i2);
    }
}
