package net.lingala.zip4j.model;

import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;

public class ZipParameters {

    /* renamed from: a  reason: collision with root package name */
    private CompressionMethod f30639a = CompressionMethod.DEFLATE;

    /* renamed from: b  reason: collision with root package name */
    private CompressionLevel f30640b = CompressionLevel.NORMAL;

    /* renamed from: c  reason: collision with root package name */
    private boolean f30641c = false;

    /* renamed from: d  reason: collision with root package name */
    private EncryptionMethod f30642d = EncryptionMethod.NONE;

    /* renamed from: e  reason: collision with root package name */
    private boolean f30643e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f30644f = true;

    /* renamed from: g  reason: collision with root package name */
    private AesKeyStrength f30645g = AesKeyStrength.KEY_STRENGTH_256;

    /* renamed from: h  reason: collision with root package name */
    private AesVersion f30646h = AesVersion.TWO;

    /* renamed from: i  reason: collision with root package name */
    private boolean f30647i = true;

    /* renamed from: j  reason: collision with root package name */
    private long f30648j;

    /* renamed from: k  reason: collision with root package name */
    private String f30649k;

    /* renamed from: l  reason: collision with root package name */
    private String f30650l;

    /* renamed from: m  reason: collision with root package name */
    private long f30651m = System.currentTimeMillis();

    /* renamed from: n  reason: collision with root package name */
    private long f30652n = -1;
    private boolean o = true;
    private boolean p = true;
    private String q;
    private String r;
    private SymbolicLinkAction s = SymbolicLinkAction.INCLUDE_LINKED_FILE_ONLY;
    private ExcludeFileFilter t;
    private boolean u;

    public enum SymbolicLinkAction {
        INCLUDE_LINK_ONLY,
        INCLUDE_LINKED_FILE_ONLY,
        INCLUDE_LINK_AND_LINKED_FILE
    }

    public ZipParameters() {
    }

    public void A(boolean z) {
        this.f30641c = z;
    }

    public void B(EncryptionMethod encryptionMethod) {
        this.f30642d = encryptionMethod;
    }

    public void C(long j2) {
        this.f30648j = j2;
    }

    public void D(long j2) {
        this.f30652n = j2;
    }

    public void E(ExcludeFileFilter excludeFileFilter) {
        this.t = excludeFileFilter;
    }

    public void F(String str) {
        this.r = str;
    }

    public void G(String str) {
        this.f30650l = str;
    }

    public void H(boolean z) {
        this.f30647i = z;
    }

    public void I(long j2) {
        if (j2 > 0) {
            this.f30651m = j2;
        }
    }

    public void J(boolean z) {
        this.p = z;
    }

    public void K(boolean z) {
        this.f30643e = z;
    }

    public void L(boolean z) {
        this.f30644f = z;
    }

    public void M(String str) {
        this.q = str;
    }

    public void N(SymbolicLinkAction symbolicLinkAction) {
        this.s = symbolicLinkAction;
    }

    public void O(boolean z) {
        this.u = z;
    }

    public void P(boolean z) {
        this.o = z;
    }

    public AesKeyStrength a() {
        return this.f30645g;
    }

    public AesVersion b() {
        return this.f30646h;
    }

    public CompressionLevel c() {
        return this.f30640b;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public CompressionMethod d() {
        return this.f30639a;
    }

    public String e() {
        return this.f30649k;
    }

    public EncryptionMethod f() {
        return this.f30642d;
    }

    public long g() {
        return this.f30648j;
    }

    public long h() {
        return this.f30652n;
    }

    public ExcludeFileFilter i() {
        return this.t;
    }

    public String j() {
        return this.r;
    }

    public String k() {
        return this.f30650l;
    }

    public long l() {
        return this.f30651m;
    }

    public String m() {
        return this.q;
    }

    public SymbolicLinkAction n() {
        return this.s;
    }

    public boolean o() {
        return this.f30641c;
    }

    public boolean p() {
        return this.f30647i;
    }

    public boolean q() {
        return this.p;
    }

    public boolean r() {
        return this.f30643e;
    }

    public boolean s() {
        return this.f30644f;
    }

    public boolean t() {
        return this.u;
    }

    public boolean u() {
        return this.o;
    }

    public void v(AesKeyStrength aesKeyStrength) {
        this.f30645g = aesKeyStrength;
    }

    public void w(AesVersion aesVersion) {
        this.f30646h = aesVersion;
    }

    public void x(CompressionLevel compressionLevel) {
        this.f30640b = compressionLevel;
    }

    public void y(CompressionMethod compressionMethod) {
        this.f30639a = compressionMethod;
    }

    public void z(String str) {
        this.f30649k = str;
    }

    public ZipParameters(ZipParameters zipParameters) {
        this.f30639a = zipParameters.d();
        this.f30640b = zipParameters.c();
        this.f30641c = zipParameters.o();
        this.f30642d = zipParameters.f();
        this.f30643e = zipParameters.r();
        this.f30644f = zipParameters.s();
        this.f30645g = zipParameters.a();
        this.f30646h = zipParameters.b();
        this.f30647i = zipParameters.p();
        this.f30648j = zipParameters.g();
        this.f30649k = zipParameters.e();
        this.f30650l = zipParameters.k();
        this.f30651m = zipParameters.l();
        this.f30652n = zipParameters.h();
        this.o = zipParameters.u();
        this.p = zipParameters.q();
        this.q = zipParameters.m();
        this.r = zipParameters.j();
        this.s = zipParameters.n();
        this.t = zipParameters.i();
        this.u = zipParameters.t();
    }
}
