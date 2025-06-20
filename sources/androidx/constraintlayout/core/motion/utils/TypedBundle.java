package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class TypedBundle {

    /* renamed from: m  reason: collision with root package name */
    private static final int f3913m = 4;

    /* renamed from: n  reason: collision with root package name */
    private static final int f3914n = 10;
    private static final int o = 10;
    private static final int p = 5;

    /* renamed from: a  reason: collision with root package name */
    int[] f3915a = new int[10];

    /* renamed from: b  reason: collision with root package name */
    int[] f3916b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    int f3917c = 0;

    /* renamed from: d  reason: collision with root package name */
    int[] f3918d = new int[10];

    /* renamed from: e  reason: collision with root package name */
    float[] f3919e = new float[10];

    /* renamed from: f  reason: collision with root package name */
    int f3920f = 0;

    /* renamed from: g  reason: collision with root package name */
    int[] f3921g = new int[5];

    /* renamed from: h  reason: collision with root package name */
    String[] f3922h = new String[5];

    /* renamed from: i  reason: collision with root package name */
    int f3923i = 0;

    /* renamed from: j  reason: collision with root package name */
    int[] f3924j = new int[4];

    /* renamed from: k  reason: collision with root package name */
    boolean[] f3925k = new boolean[4];

    /* renamed from: l  reason: collision with root package name */
    int f3926l = 0;

    public void a(int i2, float f2) {
        int i3 = this.f3920f;
        int[] iArr = this.f3918d;
        if (i3 >= iArr.length) {
            this.f3918d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f3919e;
            this.f3919e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f3918d;
        int i4 = this.f3920f;
        iArr2[i4] = i2;
        float[] fArr2 = this.f3919e;
        this.f3920f = i4 + 1;
        fArr2[i4] = f2;
    }

    public void b(int i2, int i3) {
        int i4 = this.f3917c;
        int[] iArr = this.f3915a;
        if (i4 >= iArr.length) {
            this.f3915a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f3916b;
            this.f3916b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f3915a;
        int i5 = this.f3917c;
        iArr3[i5] = i2;
        int[] iArr4 = this.f3916b;
        this.f3917c = i5 + 1;
        iArr4[i5] = i3;
    }

    public void c(int i2, String str) {
        int i3 = this.f3923i;
        int[] iArr = this.f3921g;
        if (i3 >= iArr.length) {
            this.f3921g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f3922h;
            this.f3922h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f3921g;
        int i4 = this.f3923i;
        iArr2[i4] = i2;
        String[] strArr2 = this.f3922h;
        this.f3923i = i4 + 1;
        strArr2[i4] = str;
    }

    public void d(int i2, boolean z) {
        int i3 = this.f3926l;
        int[] iArr = this.f3924j;
        if (i3 >= iArr.length) {
            this.f3924j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f3925k;
            this.f3925k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f3924j;
        int i4 = this.f3926l;
        iArr2[i4] = i2;
        boolean[] zArr2 = this.f3925k;
        this.f3926l = i4 + 1;
        zArr2[i4] = z;
    }

    public void e(int i2, String str) {
        if (str != null) {
            c(i2, str);
        }
    }

    public void f(TypedBundle typedBundle) {
        for (int i2 = 0; i2 < this.f3917c; i2++) {
            typedBundle.b(this.f3915a[i2], this.f3916b[i2]);
        }
        for (int i3 = 0; i3 < this.f3920f; i3++) {
            typedBundle.a(this.f3918d[i3], this.f3919e[i3]);
        }
        for (int i4 = 0; i4 < this.f3923i; i4++) {
            typedBundle.c(this.f3921g[i4], this.f3922h[i4]);
        }
        for (int i5 = 0; i5 < this.f3926l; i5++) {
            typedBundle.d(this.f3924j[i5], this.f3925k[i5]);
        }
    }

    public void g(TypedValues typedValues) {
        for (int i2 = 0; i2 < this.f3917c; i2++) {
            typedValues.a(this.f3915a[i2], this.f3916b[i2]);
        }
        for (int i3 = 0; i3 < this.f3920f; i3++) {
            typedValues.b(this.f3918d[i3], this.f3919e[i3]);
        }
        for (int i4 = 0; i4 < this.f3923i; i4++) {
            typedValues.c(this.f3921g[i4], this.f3922h[i4]);
        }
        for (int i5 = 0; i5 < this.f3926l; i5++) {
            typedValues.d(this.f3924j[i5], this.f3925k[i5]);
        }
    }

    public void h() {
        this.f3926l = 0;
        this.f3923i = 0;
        this.f3920f = 0;
        this.f3917c = 0;
    }

    public int i(int i2) {
        for (int i3 = 0; i3 < this.f3917c; i3++) {
            if (this.f3915a[i3] == i2) {
                return this.f3916b[i3];
            }
        }
        return -1;
    }
}
