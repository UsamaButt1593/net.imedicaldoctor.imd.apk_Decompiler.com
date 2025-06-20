package net.lingala.zip4j.model.enums;

import net.lingala.zip4j.exception.ZipException;

public enum CompressionMethod {
    STORE(0),
    DEFLATE(8),
    AES_INTERNAL_ONLY(99);
    
    private int s;

    private CompressionMethod(int i2) {
        this.s = i2;
    }

    public static CompressionMethod b(int i2) throws ZipException {
        for (CompressionMethod compressionMethod : values()) {
            if (compressionMethod.a() == i2) {
                return compressionMethod;
            }
        }
        throw new ZipException("Unknown compression method", ZipException.Type.UNKNOWN_COMPRESSION_METHOD);
    }

    public int a() {
        return this.s;
    }
}
