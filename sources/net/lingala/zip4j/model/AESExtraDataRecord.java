package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;

public class AESExtraDataRecord extends ZipHeader {

    /* renamed from: b  reason: collision with root package name */
    private int f30582b = 7;

    /* renamed from: c  reason: collision with root package name */
    private AesVersion f30583c = AesVersion.TWO;

    /* renamed from: d  reason: collision with root package name */
    private String f30584d = "AE";

    /* renamed from: e  reason: collision with root package name */
    private AesKeyStrength f30585e = AesKeyStrength.KEY_STRENGTH_256;

    /* renamed from: f  reason: collision with root package name */
    private CompressionMethod f30586f = CompressionMethod.DEFLATE;

    public AESExtraDataRecord() {
        b(HeaderSignature.AES_EXTRA_DATA_RECORD);
    }

    public AesKeyStrength c() {
        return this.f30585e;
    }

    public AesVersion d() {
        return this.f30583c;
    }

    public CompressionMethod e() {
        return this.f30586f;
    }

    public int f() {
        return this.f30582b;
    }

    public String g() {
        return this.f30584d;
    }

    public void h(AesKeyStrength aesKeyStrength) {
        this.f30585e = aesKeyStrength;
    }

    public void i(AesVersion aesVersion) {
        this.f30583c = aesVersion;
    }

    public void j(CompressionMethod compressionMethod) {
        this.f30586f = compressionMethod;
    }

    public void k(int i2) {
        this.f30582b = i2;
    }

    public void l(String str) {
        this.f30584d = str;
    }
}
