package com.itextpdf.text.pdf;

public class GrayColor extends ExtendedColor {
    private static final long A = -6571835680819282746L;
    public static final GrayColor B = new GrayColor(0.0f);
    public static final GrayColor C = new GrayColor(1.0f);
    private float z;

    public GrayColor(float f2) {
        super(1, f2, f2, f2);
        this.z = ExtendedColor.l(f2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof GrayColor) && ((GrayColor) obj).z == this.z;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.z);
    }

    public float m() {
        return this.z;
    }

    public GrayColor(int i2) {
        this(((float) i2) / 255.0f);
    }
}
