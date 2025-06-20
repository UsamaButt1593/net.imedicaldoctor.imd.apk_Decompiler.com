package net.lingala.zip4j.model.enums;

public enum CompressionLevel {
    FASTEST(1),
    FAST(3),
    NORMAL(5),
    MAXIMUM(7),
    ULTRA(9);
    
    private int s;

    private CompressionLevel(int i2) {
        this.s = i2;
    }

    public int a() {
        return this.s;
    }
}
