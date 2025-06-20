package net.lingala.zip4j.model.enums;

public enum AesKeyStrength {
    KEY_STRENGTH_128(1, 8, 16, 16),
    KEY_STRENGTH_192(2, 12, 24, 24),
    KEY_STRENGTH_256(3, 16, 32, 32);
    
    private int X;
    private int Y;
    private int Z;
    private int s;

    private AesKeyStrength(int i2, int i3, int i4, int i5) {
        this.s = i2;
        this.X = i3;
        this.Y = i4;
        this.Z = i5;
    }

    public static AesKeyStrength a(int i2) {
        for (AesKeyStrength aesKeyStrength : values()) {
            if (aesKeyStrength.e() == i2) {
                return aesKeyStrength;
            }
        }
        return null;
    }

    public int b() {
        return this.Z;
    }

    public int c() {
        return this.Y;
    }

    public int e() {
        return this.s;
    }

    public int f() {
        return this.X;
    }
}
