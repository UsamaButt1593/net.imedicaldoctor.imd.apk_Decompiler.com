package com.itextpdf.text.log;

import com.itextpdf.text.Version;
import com.itextpdf.text.pdf.codec.Base64;

public class DefaultCounter implements Counter {

    /* renamed from: e  reason: collision with root package name */
    private static byte[] f25814e = Base64.f("DQoNCllvdSBhcmUgdXNpbmcgaVRleHQgdW5kZXIgdGhlIEFHUEwuDQoNCklmIHRoaXMgaXMgeW91ciBpbnRlbnRpb24sIHlvdSBoYXZlIHB1Ymxpc2hlZCB5b3VyIG93biBzb3VyY2UgY29kZSBhcyBBR1BMIHNvZnR3YXJlIHRvby4NClBsZWFzZSBsZXQgdXMga25vdyB3aGVyZSB0byBmaW5kIHlvdXIgc291cmNlIGNvZGUgYnkgc2VuZGluZyBhIG1haWwgdG8gYWdwbEBpdGV4dHBkZi5jb20NCldlJ2QgYmUgaG9ub3JlZCB0byBhZGQgaXQgdG8gb3VyIGxpc3Qgb2YgQUdQTCBwcm9qZWN0cyBidWlsdCBvbiB0b3Agb2YgaVRleHQgb3IgaVRleHRTaGFycA0KYW5kIHdlJ2xsIGV4cGxhaW4gaG93IHRvIHJlbW92ZSB0aGlzIG1lc3NhZ2UgZnJvbSB5b3VyIGVycm9yIGxvZ3MuDQoNCklmIHRoaXMgd2Fzbid0IHlvdXIgaW50ZW50aW9uLCB5b3UgYXJlIHByb2JhYmx5IHVzaW5nIGlUZXh0IGluIGEgbm9uLWZyZWUgZW52aXJvbm1lbnQuDQpJbiB0aGlzIGNhc2UsIHBsZWFzZSBjb250YWN0IHVzIGJ5IGZpbGxpbmcgb3V0IHRoaXMgZm9ybTogaHR0cDovL2l0ZXh0cGRmLmNvbS9zYWxlcw0KSWYgeW91IGFyZSBhIGN1c3RvbWVyLCB3ZSdsbCBleHBsYWluIGhvdyB0byBpbnN0YWxsIHlvdXIgbGljZW5zZSBrZXkgdG8gYXZvaWQgdGhpcyBtZXNzYWdlLg0KSWYgeW91J3JlIG5vdCBhIGN1c3RvbWVyLCB3ZSdsbCBleHBsYWluIHRoZSBiZW5lZml0cyBvZiBiZWNvbWluZyBhIGN1c3RvbWVyLg0KDQo=");

    /* renamed from: a  reason: collision with root package name */
    private int f25815a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f25816b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f25817c = {10000, 5000, 1000};

    /* renamed from: d  reason: collision with root package name */
    private int f25818d = 10000;

    private void d() {
        int i2 = this.f25815a;
        this.f25815a = i2 + 1;
        if (i2 > this.f25818d) {
            if (Version.f()) {
                int i3 = this.f25816b + 1;
                this.f25816b = i3;
                this.f25818d = i3 == 1 ? this.f25817c[1] : this.f25817c[2];
                System.out.println(new String(f25814e));
            }
            this.f25815a = 0;
        }
    }

    public Counter a(Class<?> cls) {
        return this;
    }

    public void b(long j2) {
        d();
    }

    public void c(long j2) {
        d();
    }
}
