package net.lingala.zip4j.model;

public class Zip64EndOfCentralDirectoryRecord extends ZipHeader {

    /* renamed from: b  reason: collision with root package name */
    private long f30623b;

    /* renamed from: c  reason: collision with root package name */
    private int f30624c;

    /* renamed from: d  reason: collision with root package name */
    private int f30625d;

    /* renamed from: e  reason: collision with root package name */
    private int f30626e;

    /* renamed from: f  reason: collision with root package name */
    private int f30627f;

    /* renamed from: g  reason: collision with root package name */
    private long f30628g;

    /* renamed from: h  reason: collision with root package name */
    private long f30629h;

    /* renamed from: i  reason: collision with root package name */
    private long f30630i;

    /* renamed from: j  reason: collision with root package name */
    private long f30631j = -1;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f30632k;

    public byte[] c() {
        return this.f30632k;
    }

    public int d() {
        return this.f30626e;
    }

    public int e() {
        return this.f30627f;
    }

    public long f() {
        return this.f30631j;
    }

    public long g() {
        return this.f30630i;
    }

    public long h() {
        return this.f30623b;
    }

    public long i() {
        return this.f30629h;
    }

    public long j() {
        return this.f30628g;
    }

    public int k() {
        return this.f30624c;
    }

    public int l() {
        return this.f30625d;
    }

    public void m(byte[] bArr) {
        this.f30632k = bArr;
    }

    public void n(int i2) {
        this.f30626e = i2;
    }

    public void o(int i2) {
        this.f30627f = i2;
    }

    public void p(long j2) {
        this.f30631j = j2;
    }

    public void q(long j2) {
        this.f30630i = j2;
    }

    public void r(long j2) {
        this.f30623b = j2;
    }

    public void s(long j2) {
        this.f30629h = j2;
    }

    public void t(long j2) {
        this.f30628g = j2;
    }

    public void u(int i2) {
        this.f30624c = i2;
    }

    public void v(int i2) {
        this.f30625d = i2;
    }
}
