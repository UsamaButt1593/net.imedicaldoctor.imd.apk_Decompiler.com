package androidx.constraintlayout.core.motion;

import androidx.core.view.ViewCompat;

public class CustomAttribute {

    /* renamed from: i  reason: collision with root package name */
    private static final String f3657i = "TransitionLayout";

    /* renamed from: a  reason: collision with root package name */
    private boolean f3658a;

    /* renamed from: b  reason: collision with root package name */
    String f3659b;

    /* renamed from: c  reason: collision with root package name */
    private AttributeType f3660c;

    /* renamed from: d  reason: collision with root package name */
    private int f3661d;

    /* renamed from: e  reason: collision with root package name */
    private float f3662e;

    /* renamed from: f  reason: collision with root package name */
    private String f3663f;

    /* renamed from: g  reason: collision with root package name */
    boolean f3664g;

    /* renamed from: h  reason: collision with root package name */
    private int f3665h;

    /* renamed from: androidx.constraintlayout.core.motion.CustomAttribute$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3666a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType[] r0 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3666a = r0
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.REFERENCE_TYPE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3666a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.BOOLEAN_TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3666a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.STRING_TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3666a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.COLOR_TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3666a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.COLOR_DRAWABLE_TYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3666a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.INT_TYPE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f3666a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.FLOAT_TYPE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f3666a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.motion.CustomAttribute$AttributeType r1 = androidx.constraintlayout.core.motion.CustomAttribute.AttributeType.DIMENSION_TYPE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.CustomAttribute.AnonymousClass1.<clinit>():void");
        }
    }

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public CustomAttribute(CustomAttribute customAttribute, Object obj) {
        this.f3658a = false;
        this.f3659b = customAttribute.f3659b;
        this.f3660c = customAttribute.f3660c;
        m(obj);
    }

    private static int a(int i2) {
        int i3 = (i2 & (~(i2 >> 31))) - 255;
        return (i3 & (i3 >> 31)) + 255;
    }

    public static int f(float f2, float f3, float f4) {
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

    public boolean b(CustomAttribute customAttribute) {
        AttributeType attributeType;
        if (customAttribute == null || (attributeType = this.f3660c) != customAttribute.f3660c) {
            return false;
        }
        switch (AnonymousClass1.f3666a[attributeType.ordinal()]) {
            case 1:
            case 6:
                return this.f3661d == customAttribute.f3661d;
            case 2:
                return this.f3664g == customAttribute.f3664g;
            case 3:
                return this.f3661d == customAttribute.f3661d;
            case 4:
            case 5:
                return this.f3665h == customAttribute.f3665h;
            case 7:
                return this.f3662e == customAttribute.f3662e;
            case 8:
                return this.f3662e == customAttribute.f3662e;
            default:
                return false;
        }
    }

    public AttributeType c() {
        return this.f3660c;
    }

    public float d() {
        switch (AnonymousClass1.f3666a[this.f3660c.ordinal()]) {
            case 2:
                return this.f3664g ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return (float) this.f3661d;
            case 7:
                return this.f3662e;
            case 8:
                return this.f3662e;
            default:
                return Float.NaN;
        }
    }

    public void e(float[] fArr) {
        switch (AnonymousClass1.f3666a[this.f3660c.ordinal()]) {
            case 2:
                fArr[0] = this.f3664g ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i2 = this.f3665h;
                float pow = (float) Math.pow((double) (((float) ((i2 >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i2 >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i2 & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i2 >> 24) & 255)) / 255.0f;
                return;
            case 6:
                fArr[0] = (float) this.f3661d;
                return;
            case 7:
                fArr[0] = this.f3662e;
                return;
            case 8:
                fArr[0] = this.f3662e;
                return;
            default:
                return;
        }
    }

    public boolean g() {
        int i2 = AnonymousClass1.f3666a[this.f3660c.ordinal()];
        return (i2 == 1 || i2 == 2 || i2 == 3) ? false : true;
    }

    public int h() {
        int i2 = AnonymousClass1.f3666a[this.f3660c.ordinal()];
        return (i2 == 4 || i2 == 5) ? 4 : 1;
    }

    public void i(int i2) {
        this.f3665h = i2;
    }

    public void j(float f2) {
        this.f3662e = f2;
    }

    public void k(int i2) {
        this.f3661d = i2;
    }

    public void l(String str) {
        this.f3663f = str;
    }

    public void m(Object obj) {
        switch (AnonymousClass1.f3666a[this.f3660c.ordinal()]) {
            case 1:
            case 6:
                this.f3661d = ((Integer) obj).intValue();
                return;
            case 2:
                this.f3664g = ((Boolean) obj).booleanValue();
                return;
            case 3:
                this.f3663f = (String) obj;
                return;
            case 4:
            case 5:
                this.f3665h = ((Integer) obj).intValue();
                return;
            case 7:
            case 8:
                this.f3662e = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public void n(float[] fArr) {
        float f2;
        boolean z = true;
        switch (AnonymousClass1.f3666a[this.f3660c.ordinal()]) {
            case 1:
            case 6:
                this.f3661d = (int) fArr[0];
                return;
            case 2:
                if (((double) fArr[0]) <= 0.5d) {
                    z = false;
                }
                this.f3664g = z;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int f3 = f(fArr[0], fArr[1], fArr[2]);
                this.f3665h = f3;
                this.f3665h = (a((int) (fArr[3] * 255.0f)) << 24) | (f3 & ViewCompat.x);
                return;
            case 7:
                f2 = fArr[0];
                break;
            case 8:
                f2 = fArr[0];
                break;
            default:
                return;
        }
        this.f3662e = f2;
    }

    public CustomAttribute(String str, AttributeType attributeType) {
        this.f3658a = false;
        this.f3659b = str;
        this.f3660c = attributeType;
    }

    public CustomAttribute(String str, AttributeType attributeType, Object obj, boolean z) {
        this.f3659b = str;
        this.f3660c = attributeType;
        this.f3658a = z;
        m(obj);
    }
}
