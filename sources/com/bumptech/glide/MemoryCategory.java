package com.bumptech.glide;

public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    
    private final float s;

    private MemoryCategory(float f2) {
        this.s = f2;
    }

    public float a() {
        return this.s;
    }
}
