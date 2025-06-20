package net.lingala.zip4j.crypto.PBKDF2;

public class PBKDF2Parameters {

    /* renamed from: a  reason: collision with root package name */
    protected byte[] f30551a;

    /* renamed from: b  reason: collision with root package name */
    protected int f30552b;

    /* renamed from: c  reason: collision with root package name */
    protected String f30553c;

    /* renamed from: d  reason: collision with root package name */
    protected String f30554d;

    /* renamed from: e  reason: collision with root package name */
    protected byte[] f30555e;

    public PBKDF2Parameters() {
        this.f30553c = null;
        this.f30554d = "UTF-8";
        this.f30551a = null;
        this.f30552b = 1000;
        this.f30555e = null;
    }

    public byte[] a() {
        return this.f30555e;
    }

    public String b() {
        return this.f30553c;
    }

    public String c() {
        return this.f30554d;
    }

    public int d() {
        return this.f30552b;
    }

    public byte[] e() {
        return this.f30551a;
    }

    public void f(byte[] bArr) {
        this.f30555e = bArr;
    }

    public void g(String str) {
        this.f30553c = str;
    }

    public void h(String str) {
        this.f30554d = str;
    }

    public void i(int i2) {
        this.f30552b = i2;
    }

    public void j(byte[] bArr) {
        this.f30551a = bArr;
    }

    public PBKDF2Parameters(String str, String str2, byte[] bArr, int i2) {
        this(str, str2, bArr, i2, (byte[]) null);
    }

    public PBKDF2Parameters(String str, String str2, byte[] bArr, int i2, byte[] bArr2) {
        this.f30553c = str;
        this.f30554d = str2;
        this.f30551a = bArr;
        this.f30552b = i2;
        this.f30555e = bArr2;
    }
}
