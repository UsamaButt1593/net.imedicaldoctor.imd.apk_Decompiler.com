package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public class LocalFileHeader extends AbstractFileHeader {
    private byte[] u;
    private long v;
    private boolean w;

    public LocalFileHeader() {
        b(HeaderSignature.LOCAL_FILE_HEADER);
    }

    public byte[] P() {
        return this.u;
    }

    public long Q() {
        return this.v;
    }

    public boolean R() {
        return this.w;
    }

    public void S(byte[] bArr) {
        this.u = bArr;
    }

    public void T(long j2) {
        this.v = j2;
    }

    public void U(boolean z) {
        this.w = z;
    }
}
