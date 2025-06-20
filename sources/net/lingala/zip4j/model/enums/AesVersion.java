package net.lingala.zip4j.model.enums;

public enum AesVersion {
    ONE(1),
    TWO(2);
    
    private int s;

    private AesVersion(int i2) {
        this.s = i2;
    }

    public static AesVersion a(int i2) {
        for (AesVersion aesVersion : values()) {
            if (aesVersion.s == i2) {
                return aesVersion;
            }
        }
        throw new IllegalArgumentException("Unsupported Aes version");
    }

    public int b() {
        return this.s;
    }
}
