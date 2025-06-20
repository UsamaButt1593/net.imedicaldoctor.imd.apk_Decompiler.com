package androidx.constraintlayout.core;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable implements Comparable<SolverVariable> {
    static final int A3 = 9;
    private static final boolean k3 = false;
    private static final boolean l3 = false;
    public static final int m3 = 0;
    public static final int n3 = 1;
    public static final int o3 = 2;
    public static final int p3 = 3;
    public static final int q3 = 4;
    public static final int r3 = 5;
    public static final int s3 = 6;
    public static final int t3 = 7;
    public static final int u3 = 8;
    private static int v3 = 1;
    private static int w3 = 1;
    private static int x3 = 1;
    private static int y3 = 1;
    private static int z3 = 1;
    private String X;
    public int X2 = 0;
    public int Y = -1;
    public float Y2;
    int Z = -1;
    public boolean Z2 = false;
    float[] a3 = new float[9];
    float[] b3 = new float[9];
    Type c3;
    ArrayRow[] d3 = new ArrayRow[16];
    int e3 = 0;
    public int f3 = 0;
    boolean g3 = false;
    int h3 = -1;
    float i3 = 0.0f;
    HashSet<ArrayRow> j3 = null;
    public boolean s;

    /* renamed from: androidx.constraintlayout.core.SolverVariable$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3642a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.SolverVariable$Type[] r0 = androidx.constraintlayout.core.SolverVariable.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3642a = r0
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.UNRESTRICTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3642a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.CONSTANT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3642a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.SLACK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3642a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3642a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariable.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.c3 = type;
    }

    private static String f(Type type, String str) {
        StringBuilder sb;
        int i2;
        if (str != null) {
            sb = new StringBuilder();
            sb.append(str);
            i2 = w3;
        } else {
            int i4 = AnonymousClass1.f3642a[type.ordinal()];
            if (i4 == 1) {
                sb = new StringBuilder();
                sb.append("U");
                i2 = x3 + 1;
                x3 = i2;
            } else if (i4 == 2) {
                sb = new StringBuilder();
                sb.append("C");
                i2 = y3 + 1;
                y3 = i2;
            } else if (i4 == 3) {
                sb = new StringBuilder();
                sb.append(ExifInterface.R4);
                i2 = v3 + 1;
                v3 = i2;
            } else if (i4 == 4) {
                sb = new StringBuilder();
                sb.append("e");
                i2 = w3 + 1;
                w3 = i2;
            } else if (i4 == 5) {
                sb = new StringBuilder();
                sb.append(ExifInterface.X4);
                i2 = z3 + 1;
                z3 = i2;
            } else {
                throw new AssertionError(type.name());
            }
        }
        sb.append(i2);
        return sb.toString();
    }

    static void g() {
        w3++;
    }

    public final void a(ArrayRow arrayRow) {
        int i2 = 0;
        while (true) {
            int i4 = this.e3;
            if (i2 >= i4) {
                ArrayRow[] arrayRowArr = this.d3;
                if (i4 >= arrayRowArr.length) {
                    this.d3 = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.d3;
                int i5 = this.e3;
                arrayRowArr2[i5] = arrayRow;
                this.e3 = i5 + 1;
                return;
            } else if (this.d3[i2] != arrayRow) {
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.a3[i2] = 0.0f;
        }
    }

    /* renamed from: c */
    public int compareTo(SolverVariable solverVariable) {
        return this.Y - solverVariable.Y;
    }

    public String e() {
        return this.X;
    }

    public final void h(ArrayRow arrayRow) {
        int i2 = this.e3;
        int i4 = 0;
        while (i4 < i2) {
            if (this.d3[i4] == arrayRow) {
                while (i4 < i2 - 1) {
                    ArrayRow[] arrayRowArr = this.d3;
                    int i5 = i4 + 1;
                    arrayRowArr[i4] = arrayRowArr[i5];
                    i4 = i5;
                }
                this.e3--;
                return;
            }
            i4++;
        }
    }

    public void i() {
        this.X = null;
        this.c3 = Type.UNKNOWN;
        this.X2 = 0;
        this.Y = -1;
        this.Z = -1;
        this.Y2 = 0.0f;
        this.Z2 = false;
        this.g3 = false;
        this.h3 = -1;
        this.i3 = 0.0f;
        int i2 = this.e3;
        for (int i4 = 0; i4 < i2; i4++) {
            this.d3[i4] = null;
        }
        this.e3 = 0;
        this.f3 = 0;
        this.s = false;
        Arrays.fill(this.b3, 0.0f);
    }

    public void j(LinearSystem linearSystem, float f2) {
        this.Y2 = f2;
        this.Z2 = true;
        this.g3 = false;
        this.h3 = -1;
        this.i3 = 0.0f;
        int i2 = this.e3;
        this.Z = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            this.d3[i4].a(linearSystem, this, false);
        }
        this.e3 = 0;
    }

    public void k(String str) {
        this.X = str;
    }

    public void l(LinearSystem linearSystem, SolverVariable solverVariable, float f2) {
        this.g3 = true;
        this.h3 = solverVariable.Y;
        this.i3 = f2;
        int i2 = this.e3;
        this.Z = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            this.d3[i4].G(linearSystem, this, false);
        }
        this.e3 = 0;
        linearSystem.z();
    }

    public void m(Type type, String str) {
        this.c3 = type;
    }

    /* access modifiers changed from: package-private */
    public String n() {
        StringBuilder sb;
        String str;
        String str2 = this + "[";
        boolean z = false;
        boolean z2 = true;
        for (int i2 = 0; i2 < this.a3.length; i2++) {
            String str3 = str2 + this.a3[i2];
            float[] fArr = this.a3;
            float f2 = fArr[i2];
            if (f2 > 0.0f) {
                z = false;
            } else if (f2 < 0.0f) {
                z = true;
            }
            if (f2 != 0.0f) {
                z2 = false;
            }
            if (i2 < fArr.length - 1) {
                sb = new StringBuilder();
                sb.append(str3);
                str = ", ";
            } else {
                sb = new StringBuilder();
                sb.append(str3);
                str = "] ";
            }
            sb.append(str);
            str2 = sb.toString();
        }
        if (z) {
            str2 = str2 + " (-)";
        }
        if (!z2) {
            return str2;
        }
        return str2 + " (*)";
    }

    public final void o(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i2 = this.e3;
        for (int i4 = 0; i4 < i2; i4++) {
            this.d3[i4].c(linearSystem, arrayRow, false);
        }
        this.e3 = 0;
    }

    public String toString() {
        StringBuilder sb;
        if (this.X != null) {
            sb = new StringBuilder();
            sb.append("");
            sb.append(this.X);
        } else {
            sb = new StringBuilder();
            sb.append("");
            sb.append(this.Y);
        }
        return sb.toString();
    }

    public SolverVariable(String str, Type type) {
        this.X = str;
        this.c3 = type;
    }
}
