package com.itextpdf.text.pdf;

public class CMYKColor extends ExtendedColor {
    private static final long D = 5940378778276468452L;
    float A;
    float B;
    float C;
    float z;

    public CMYKColor(float f2, float f3, float f4, float f5) {
        super(2, (1.0f - f2) - f5, (1.0f - f3) - f5, (1.0f - f4) - f5);
        this.z = ExtendedColor.l(f2);
        this.A = ExtendedColor.l(f3);
        this.B = ExtendedColor.l(f4);
        this.C = ExtendedColor.l(f5);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CMYKColor)) {
            return false;
        }
        CMYKColor cMYKColor = (CMYKColor) obj;
        return this.z == cMYKColor.z && this.A == cMYKColor.A && this.B == cMYKColor.B && this.C == cMYKColor.C;
    }

    public int hashCode() {
        return ((Float.floatToIntBits(this.z) ^ Float.floatToIntBits(this.A)) ^ Float.floatToIntBits(this.B)) ^ Float.floatToIntBits(this.C);
    }

    public float m() {
        return this.C;
    }

    public float n() {
        return this.z;
    }

    public float o() {
        return this.A;
    }

    public float p() {
        return this.B;
    }

    public CMYKColor(int i2, int i3, int i4, int i5) {
        this(((float) i2) / 255.0f, ((float) i3) / 255.0f, ((float) i4) / 255.0f, ((float) i5) / 255.0f);
    }
}
