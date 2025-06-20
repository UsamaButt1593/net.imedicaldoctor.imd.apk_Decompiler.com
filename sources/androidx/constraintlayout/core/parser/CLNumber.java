package androidx.constraintlayout.core.parser;

public class CLNumber extends CLElement {
    float a3;

    public CLNumber(float f2) {
        super((char[]) null);
        this.a3 = f2;
    }

    public static CLElement G(char[] cArr) {
        return new CLNumber(cArr);
    }

    /* access modifiers changed from: protected */
    public String D(int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        b(sb, i2);
        float j2 = j();
        int i4 = (int) j2;
        if (((float) i4) == j2) {
            sb.append(i4);
        } else {
            sb.append(j2);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String E() {
        float j2 = j();
        int i2 = (int) j2;
        if (((float) i2) == j2) {
            return "" + i2;
        }
        return "" + j2;
    }

    public boolean H() {
        float j2 = j();
        return ((float) ((int) j2)) == j2;
    }

    public void I(float f2) {
        this.a3 = f2;
    }

    public float j() {
        if (Float.isNaN(this.a3)) {
            this.a3 = Float.parseFloat(c());
        }
        return this.a3;
    }

    public int k() {
        if (Float.isNaN(this.a3)) {
            this.a3 = (float) Integer.parseInt(c());
        }
        return (int) this.a3;
    }

    public CLNumber(char[] cArr) {
        super(cArr);
        this.a3 = Float.NaN;
    }
}
