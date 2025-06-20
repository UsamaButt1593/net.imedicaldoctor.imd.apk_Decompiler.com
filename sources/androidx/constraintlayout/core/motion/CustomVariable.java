package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;

public class CustomVariable {

    /* renamed from: g  reason: collision with root package name */
    private static final String f3667g = "TransitionLayout";

    /* renamed from: a  reason: collision with root package name */
    String f3668a;

    /* renamed from: b  reason: collision with root package name */
    private int f3669b;

    /* renamed from: c  reason: collision with root package name */
    private int f3670c;

    /* renamed from: d  reason: collision with root package name */
    private float f3671d;

    /* renamed from: e  reason: collision with root package name */
    private String f3672e;

    /* renamed from: f  reason: collision with root package name */
    boolean f3673f;

    public CustomVariable(CustomVariable customVariable) {
        this.f3670c = Integer.MIN_VALUE;
        this.f3671d = Float.NaN;
        this.f3672e = null;
        this.f3668a = customVariable.f3668a;
        this.f3669b = customVariable.f3669b;
        this.f3670c = customVariable.f3670c;
        this.f3671d = customVariable.f3671d;
        this.f3672e = customVariable.f3672e;
        this.f3673f = customVariable.f3673f;
    }

    private static int b(int i2) {
        int i3 = (i2 & (~(i2 >> 31))) - 255;
        return (i3 & (i3 >> 31)) + 255;
    }

    public static String c(int i2) {
        String str = "00000000" + Integer.toHexString(i2);
        return "#" + str.substring(str.length() - 8);
    }

    public static int p(float f2, float f3, float f4) {
        float f5 = f2 * 6.0f;
        int i2 = (int) f5;
        float f6 = f5 - ((float) i2);
        float f7 = f4 * 255.0f;
        int i3 = (int) (((1.0f - f3) * f7) + 0.5f);
        int i4 = (int) (((1.0f - (f6 * f3)) * f7) + 0.5f);
        int i5 = (int) (((1.0f - ((1.0f - f6) * f3)) * f7) + 0.5f);
        int i6 = (int) (f7 + 0.5f);
        if (i2 == 0) {
            return ((i6 << 16) + (i5 << 8) + i3) | ViewCompat.y;
        }
        if (i2 == 1) {
            return ((i4 << 16) + (i6 << 8) + i3) | ViewCompat.y;
        }
        if (i2 == 2) {
            return ((i3 << 16) + (i6 << 8) + i5) | ViewCompat.y;
        }
        if (i2 == 3) {
            return ((i3 << 16) + (i4 << 8) + i6) | ViewCompat.y;
        }
        if (i2 == 4) {
            return ((i5 << 16) + (i3 << 8) + i6) | ViewCompat.y;
        }
        if (i2 != 5) {
            return 0;
        }
        return ((i6 << 16) + (i3 << 8) + i4) | ViewCompat.y;
    }

    public static int s(float f2, float f3, float f4, float f5) {
        int b2 = b((int) (f2 * 255.0f));
        int b3 = b((int) (f3 * 255.0f));
        return (b2 << 16) | (b((int) (f5 * 255.0f)) << 24) | (b3 << 8) | b((int) (f4 * 255.0f));
    }

    public void a(MotionWidget motionWidget) {
        int i2 = this.f3669b;
        switch (i2) {
            case TypedValues.Custom.f3957j /*900*/:
            case TypedValues.Custom.f3959l /*902*/:
            case TypedValues.Custom.p /*906*/:
                motionWidget.J(this.f3668a, i2, this.f3670c);
                return;
            case TypedValues.Custom.f3958k /*901*/:
            case TypedValues.Custom.o /*905*/:
                motionWidget.I(this.f3668a, i2, this.f3671d);
                return;
            case TypedValues.Custom.f3960m /*903*/:
                motionWidget.K(this.f3668a, i2, this.f3672e);
                return;
            case TypedValues.Custom.f3961n /*904*/:
                motionWidget.L(this.f3668a, i2, this.f3673f);
                return;
            default:
                return;
        }
    }

    public CustomVariable d() {
        return new CustomVariable(this);
    }

    public boolean e(CustomVariable customVariable) {
        int i2;
        if (customVariable == null || (i2 = this.f3669b) != customVariable.f3669b) {
            return false;
        }
        switch (i2) {
            case TypedValues.Custom.f3957j /*900*/:
            case TypedValues.Custom.p /*906*/:
                return this.f3670c == customVariable.f3670c;
            case TypedValues.Custom.f3958k /*901*/:
                return this.f3671d == customVariable.f3671d;
            case TypedValues.Custom.f3959l /*902*/:
                return this.f3670c == customVariable.f3670c;
            case TypedValues.Custom.f3960m /*903*/:
                return this.f3670c == customVariable.f3670c;
            case TypedValues.Custom.f3961n /*904*/:
                return this.f3673f == customVariable.f3673f;
            case TypedValues.Custom.o /*905*/:
                return this.f3671d == customVariable.f3671d;
            default:
                return false;
        }
    }

    public boolean f() {
        return this.f3673f;
    }

    public int g() {
        return this.f3670c;
    }

    public float h() {
        return this.f3671d;
    }

    public int i() {
        return this.f3670c;
    }

    public int j(float[] fArr) {
        int b2 = b((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
        int b3 = b((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
        return (b((int) (fArr[3] * 255.0f)) << 24) | (b2 << 16) | (b3 << 8) | b((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public String k() {
        return this.f3668a;
    }

    public String l() {
        return this.f3672e;
    }

    public int m() {
        return this.f3669b;
    }

    public float n() {
        switch (this.f3669b) {
            case TypedValues.Custom.f3957j /*900*/:
                return (float) this.f3670c;
            case TypedValues.Custom.f3958k /*901*/:
                return this.f3671d;
            case TypedValues.Custom.f3959l /*902*/:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case TypedValues.Custom.f3960m /*903*/:
                throw new RuntimeException("Cannot interpolate String");
            case TypedValues.Custom.f3961n /*904*/:
                return this.f3673f ? 1.0f : 0.0f;
            case TypedValues.Custom.o /*905*/:
                return this.f3671d;
            default:
                return Float.NaN;
        }
    }

    public void o(float[] fArr) {
        switch (this.f3669b) {
            case TypedValues.Custom.f3957j /*900*/:
                fArr[0] = (float) this.f3670c;
                return;
            case TypedValues.Custom.f3958k /*901*/:
                fArr[0] = this.f3671d;
                return;
            case TypedValues.Custom.f3959l /*902*/:
                int i2 = this.f3670c;
                float pow = (float) Math.pow((double) (((float) ((i2 >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i2 >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i2 & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i2 >> 24) & 255)) / 255.0f;
                return;
            case TypedValues.Custom.f3960m /*903*/:
                throw new RuntimeException("Cannot interpolate String");
            case TypedValues.Custom.f3961n /*904*/:
                fArr[0] = this.f3673f ? 1.0f : 0.0f;
                return;
            case TypedValues.Custom.o /*905*/:
                fArr[0] = this.f3671d;
                return;
            default:
                return;
        }
    }

    public boolean q() {
        int i2 = this.f3669b;
        return (i2 == 903 || i2 == 904 || i2 == 906) ? false : true;
    }

    public int r() {
        return this.f3669b != 902 ? 1 : 4;
    }

    public void t(boolean z) {
        this.f3673f = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0022, code lost:
        r1.append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0029, code lost:
        return r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        r1.append(r0);
        r1.append(r2.f3671d);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r2.f3668a
            r0.append(r1)
            r1 = 58
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            int r1 = r2.f3669b
            switch(r1) {
                case 900: goto L_0x006a;
                case 901: goto L_0x0064;
                case 902: goto L_0x0055;
                case 903: goto L_0x004a;
                case 904: goto L_0x0038;
                case 905: goto L_0x002a;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "????"
        L_0x0022:
            r1.append(r0)
        L_0x0025:
            java.lang.String r0 = r1.toString()
            return r0
        L_0x002a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x002f:
            r1.append(r0)
            float r0 = r2.f3671d
            r1.append(r0)
            goto L_0x0025
        L_0x0038:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            boolean r0 = r2.f3673f
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r1.append(r0)
            goto L_0x0025
        L_0x004a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = r2.f3672e
            goto L_0x0022
        L_0x0055:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            int r0 = r2.f3670c
            java.lang.String r0 = c(r0)
            goto L_0x0022
        L_0x0064:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x002f
        L_0x006a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            int r0 = r2.f3670c
            r1.append(r0)
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.CustomVariable.toString():java.lang.String");
    }

    public void u(float f2) {
        this.f3671d = f2;
    }

    public void v(int i2) {
        this.f3670c = i2;
    }

    public void w(MotionWidget motionWidget, float[] fArr) {
        int i2 = this.f3669b;
        boolean z = true;
        switch (i2) {
            case TypedValues.Custom.f3957j /*900*/:
                motionWidget.J(this.f3668a, i2, (int) fArr[0]);
                return;
            case TypedValues.Custom.f3958k /*901*/:
            case TypedValues.Custom.o /*905*/:
                motionWidget.I(this.f3668a, i2, fArr[0]);
                return;
            case TypedValues.Custom.f3959l /*902*/:
                int b2 = b((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
                int b3 = b((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
                int b4 = b((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f));
                motionWidget.J(this.f3668a, this.f3669b, (b((int) (fArr[3] * 255.0f)) << 24) | (b2 << 16) | (b3 << 8) | b4);
                return;
            case TypedValues.Custom.f3960m /*903*/:
            case TypedValues.Custom.p /*906*/:
                throw new RuntimeException("unable to interpolate " + this.f3668a);
            case TypedValues.Custom.f3961n /*904*/:
                String str = this.f3668a;
                if (fArr[0] <= 0.5f) {
                    z = false;
                }
                motionWidget.L(str, i2, z);
                return;
            default:
                return;
        }
    }

    public void x(String str) {
        this.f3672e = str;
    }

    public void y(Object obj) {
        switch (this.f3669b) {
            case TypedValues.Custom.f3957j /*900*/:
            case TypedValues.Custom.f3959l /*902*/:
            case TypedValues.Custom.p /*906*/:
                this.f3670c = ((Integer) obj).intValue();
                return;
            case TypedValues.Custom.f3958k /*901*/:
            case TypedValues.Custom.o /*905*/:
                this.f3671d = ((Float) obj).floatValue();
                return;
            case TypedValues.Custom.f3960m /*903*/:
                this.f3672e = (String) obj;
                return;
            case TypedValues.Custom.f3961n /*904*/:
                this.f3673f = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }

    public void z(float[] fArr) {
        int i2;
        boolean z = true;
        switch (this.f3669b) {
            case TypedValues.Custom.f3957j /*900*/:
            case TypedValues.Custom.p /*906*/:
                i2 = (int) fArr[0];
                break;
            case TypedValues.Custom.f3958k /*901*/:
            case TypedValues.Custom.o /*905*/:
                this.f3671d = fArr[0];
                return;
            case TypedValues.Custom.f3959l /*902*/:
                float f2 = fArr[0];
                float f3 = fArr[1];
                float f4 = fArr[2];
                i2 = ((Math.round(fArr[3] * 255.0f) & 255) << 24) | ((Math.round(((float) Math.pow((double) f2, 0.5d)) * 255.0f) & 255) << 16) | ((Math.round(((float) Math.pow((double) f3, 0.5d)) * 255.0f) & 255) << 8) | (Math.round(((float) Math.pow((double) f4, 0.5d)) * 255.0f) & 255);
                break;
            case TypedValues.Custom.f3960m /*903*/:
                throw new RuntimeException("Cannot interpolate String");
            case TypedValues.Custom.f3961n /*904*/:
                if (((double) fArr[0]) <= 0.5d) {
                    z = false;
                }
                this.f3673f = z;
                return;
            default:
                return;
        }
        this.f3670c = i2;
    }

    public CustomVariable(CustomVariable customVariable, Object obj) {
        this.f3670c = Integer.MIN_VALUE;
        this.f3671d = Float.NaN;
        this.f3672e = null;
        this.f3668a = customVariable.f3668a;
        this.f3669b = customVariable.f3669b;
        y(obj);
    }

    public CustomVariable(String str, int i2) {
        this.f3670c = Integer.MIN_VALUE;
        this.f3671d = Float.NaN;
        this.f3672e = null;
        this.f3668a = str;
        this.f3669b = i2;
    }

    public CustomVariable(String str, int i2, float f2) {
        this.f3670c = Integer.MIN_VALUE;
        this.f3672e = null;
        this.f3668a = str;
        this.f3669b = i2;
        this.f3671d = f2;
    }

    public CustomVariable(String str, int i2, int i3) {
        this.f3670c = Integer.MIN_VALUE;
        this.f3671d = Float.NaN;
        this.f3672e = null;
        this.f3668a = str;
        this.f3669b = i2;
        if (i2 == 901) {
            this.f3671d = (float) i3;
        } else {
            this.f3670c = i3;
        }
    }

    public CustomVariable(String str, int i2, Object obj) {
        this.f3670c = Integer.MIN_VALUE;
        this.f3671d = Float.NaN;
        this.f3672e = null;
        this.f3668a = str;
        this.f3669b = i2;
        y(obj);
    }

    public CustomVariable(String str, int i2, String str2) {
        this.f3670c = Integer.MIN_VALUE;
        this.f3671d = Float.NaN;
        this.f3668a = str;
        this.f3669b = i2;
        this.f3672e = str2;
    }

    public CustomVariable(String str, int i2, boolean z) {
        this.f3670c = Integer.MIN_VALUE;
        this.f3671d = Float.NaN;
        this.f3672e = null;
        this.f3668a = str;
        this.f3669b = i2;
        this.f3673f = z;
    }
}
