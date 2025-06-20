package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public class EndOfCentralDirectoryRecord extends ZipHeader {

    /* renamed from: b  reason: collision with root package name */
    private int f30609b;

    /* renamed from: c  reason: collision with root package name */
    private int f30610c;

    /* renamed from: d  reason: collision with root package name */
    private int f30611d;

    /* renamed from: e  reason: collision with root package name */
    private int f30612e;

    /* renamed from: f  reason: collision with root package name */
    private int f30613f;

    /* renamed from: g  reason: collision with root package name */
    private long f30614g;

    /* renamed from: h  reason: collision with root package name */
    private long f30615h;

    /* renamed from: i  reason: collision with root package name */
    private String f30616i = "";

    public EndOfCentralDirectoryRecord() {
        b(HeaderSignature.END_OF_CENTRAL_DIRECTORY);
    }

    public String c() {
        return this.f30616i;
    }

    public int d() {
        return this.f30609b;
    }

    public int e() {
        return this.f30610c;
    }

    public long f() {
        return this.f30615h;
    }

    public long g() {
        return this.f30614g;
    }

    public int h() {
        return this.f30613f;
    }

    public int i() {
        return this.f30612e;
    }

    public int j() {
        return this.f30611d;
    }

    public void k(String str) {
        if (str != null) {
            this.f30616i = str;
        }
    }

    public void l(int i2) {
        this.f30609b = i2;
    }

    public void m(int i2) {
        this.f30610c = i2;
    }

    public void n(long j2) {
        this.f30615h = j2;
    }

    public void o(long j2) {
        this.f30614g = j2;
    }

    public void p(int i2) {
        this.f30613f = i2;
    }

    public void q(int i2) {
        this.f30612e = i2;
    }

    public void r(int i2) {
        this.f30611d = i2;
    }
}
