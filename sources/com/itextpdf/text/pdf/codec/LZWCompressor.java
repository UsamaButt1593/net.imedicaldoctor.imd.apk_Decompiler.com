package com.itextpdf.text.pdf.codec;

import java.io.IOException;
import java.io.OutputStream;

public class LZWCompressor {

    /* renamed from: a  reason: collision with root package name */
    int f26605a;

    /* renamed from: b  reason: collision with root package name */
    int f26606b;

    /* renamed from: c  reason: collision with root package name */
    int f26607c;

    /* renamed from: d  reason: collision with root package name */
    int f26608d;

    /* renamed from: e  reason: collision with root package name */
    int f26609e;

    /* renamed from: f  reason: collision with root package name */
    short f26610f;

    /* renamed from: g  reason: collision with root package name */
    BitFile f26611g;

    /* renamed from: h  reason: collision with root package name */
    LZWStringTable f26612h;

    /* renamed from: i  reason: collision with root package name */
    boolean f26613i;

    public LZWCompressor(OutputStream outputStream, int i2, boolean z) throws IOException {
        this.f26611g = new BitFile(outputStream, !z);
        this.f26605a = i2;
        this.f26613i = z;
        int i3 = 1 << i2;
        this.f26606b = i3;
        this.f26607c = i3 + 1;
        int i4 = i2 + 1;
        this.f26608d = i4;
        int i5 = 1 << i4;
        this.f26609e = i5 - 1;
        if (z) {
            this.f26609e = i5 - 2;
        }
        this.f26610f = -1;
        LZWStringTable lZWStringTable = new LZWStringTable();
        this.f26612h = lZWStringTable;
        lZWStringTable.b(this.f26605a);
        this.f26611g.b(this.f26606b, this.f26608d);
    }

    public void a(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = i3 + i2;
        while (i2 < i5) {
            byte b2 = bArr[i2];
            short c2 = this.f26612h.c(this.f26610f, b2);
            if (c2 != -1) {
                this.f26610f = c2;
            } else {
                this.f26611g.b(this.f26610f, this.f26608d);
                if (this.f26612h.a(this.f26610f, b2) > this.f26609e) {
                    int i6 = this.f26608d;
                    if (i6 == 12) {
                        this.f26611g.b(this.f26606b, i6);
                        this.f26612h.b(this.f26605a);
                        i4 = this.f26605a + 1;
                    } else {
                        i4 = i6 + 1;
                    }
                    this.f26608d = i4;
                    int i7 = 1 << this.f26608d;
                    this.f26609e = i7 - 1;
                    if (this.f26613i) {
                        this.f26609e = i7 - 2;
                    }
                }
                this.f26610f = (short) (((short) b2) & 255);
            }
            i2++;
        }
    }

    public void b() throws IOException {
        short s = this.f26610f;
        if (s != -1) {
            this.f26611g.b(s, this.f26608d);
        }
        this.f26611g.b(this.f26607c, this.f26608d);
        this.f26611g.a();
    }
}
