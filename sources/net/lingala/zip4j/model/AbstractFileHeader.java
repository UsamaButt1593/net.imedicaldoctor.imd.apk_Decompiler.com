package net.lingala.zip4j.model;

import java.util.List;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

public abstract class AbstractFileHeader extends ZipHeader {

    /* renamed from: b  reason: collision with root package name */
    private int f30587b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f30588c;

    /* renamed from: d  reason: collision with root package name */
    private CompressionMethod f30589d;

    /* renamed from: e  reason: collision with root package name */
    private long f30590e;

    /* renamed from: f  reason: collision with root package name */
    private long f30591f = 0;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f30592g;

    /* renamed from: h  reason: collision with root package name */
    private long f30593h = 0;

    /* renamed from: i  reason: collision with root package name */
    private long f30594i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f30595j;

    /* renamed from: k  reason: collision with root package name */
    private int f30596k;

    /* renamed from: l  reason: collision with root package name */
    private String f30597l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f30598m;

    /* renamed from: n  reason: collision with root package name */
    private EncryptionMethod f30599n = EncryptionMethod.NONE;
    private boolean o;
    private Zip64ExtendedInfo p;
    private AESExtraDataRecord q;
    private boolean r;
    private List<ExtraDataRecord> s;
    private boolean t;

    public void A(byte[] bArr) {
        this.f30592g = bArr;
    }

    public void B(boolean z) {
        this.o = z;
    }

    public void C(boolean z) {
        this.t = z;
    }

    public void D(boolean z) {
        this.f30598m = z;
    }

    public void E(EncryptionMethod encryptionMethod) {
        this.f30599n = encryptionMethod;
    }

    public void F(List<ExtraDataRecord> list) {
        this.s = list;
    }

    public void G(int i2) {
        this.f30596k = i2;
    }

    public void H(String str) {
        this.f30597l = str;
    }

    public void I(int i2) {
        this.f30595j = i2;
    }

    public void J(boolean z) {
        this.r = z;
    }

    public void K(byte[] bArr) {
        this.f30588c = bArr;
    }

    public void L(long j2) {
        this.f30590e = j2;
    }

    public void M(long j2) {
        this.f30594i = j2;
    }

    public void N(int i2) {
        this.f30587b = i2;
    }

    public void O(Zip64ExtendedInfo zip64ExtendedInfo) {
        this.p = zip64ExtendedInfo;
    }

    public AESExtraDataRecord c() {
        return this.q;
    }

    public long d() {
        return this.f30593h;
    }

    public CompressionMethod e() {
        return this.f30589d;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AbstractFileHeader)) {
            return k().equals(((AbstractFileHeader) obj).k());
        }
        return false;
    }

    public long f() {
        return this.f30591f;
    }

    public byte[] g() {
        return this.f30592g;
    }

    public EncryptionMethod h() {
        return this.f30599n;
    }

    public List<ExtraDataRecord> i() {
        return this.s;
    }

    public int j() {
        return this.f30596k;
    }

    public String k() {
        return this.f30597l;
    }

    public int l() {
        return this.f30595j;
    }

    public byte[] m() {
        return this.f30588c;
    }

    public long n() {
        return this.f30590e;
    }

    public long o() {
        return Zip4jUtil.d(this.f30590e);
    }

    public long p() {
        return this.f30594i;
    }

    public int q() {
        return this.f30587b;
    }

    public Zip64ExtendedInfo r() {
        return this.p;
    }

    public boolean s() {
        return this.o;
    }

    public boolean t() {
        return this.t;
    }

    public boolean u() {
        return this.f30598m;
    }

    public boolean v() {
        return this.r;
    }

    public void w(AESExtraDataRecord aESExtraDataRecord) {
        this.q = aESExtraDataRecord;
    }

    public void x(long j2) {
        this.f30593h = j2;
    }

    public void y(CompressionMethod compressionMethod) {
        this.f30589d = compressionMethod;
    }

    public void z(long j2) {
        this.f30591f = j2;
    }
}
