package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public class FileHeader extends AbstractFileHeader {
    private String A;
    private int u;
    private int v = 0;
    private int w;
    private byte[] x;
    private byte[] y;
    private long z;

    public FileHeader() {
        b(HeaderSignature.CENTRAL_DIRECTORY);
    }

    public int P() {
        return this.w;
    }

    public byte[] Q() {
        return this.y;
    }

    public String R() {
        return this.A;
    }

    public int S() {
        return this.v;
    }

    public byte[] T() {
        return this.x;
    }

    public long U() {
        return this.z;
    }

    public int V() {
        return this.u;
    }

    public void W(int i2) {
        this.w = i2;
    }

    public void X(byte[] bArr) {
        this.y = bArr;
    }

    public void Y(String str) {
        this.A = str;
    }

    public void Z(int i2) {
        this.v = i2;
    }

    public void a0(byte[] bArr) {
        this.x = bArr;
    }

    public void b0(long j2) {
        this.z = j2;
    }

    public void c0(int i2) {
        this.u = i2;
    }

    public String toString() {
        return k();
    }
}
