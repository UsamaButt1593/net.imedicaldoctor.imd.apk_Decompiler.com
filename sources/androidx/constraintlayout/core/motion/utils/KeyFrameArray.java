package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.io.PrintStream;
import java.util.Arrays;

public class KeyFrameArray {

    public static class CustomArray {

        /* renamed from: d  reason: collision with root package name */
        private static final int f3817d = 999;

        /* renamed from: a  reason: collision with root package name */
        int[] f3818a = new int[101];

        /* renamed from: b  reason: collision with root package name */
        CustomAttribute[] f3819b = new CustomAttribute[101];

        /* renamed from: c  reason: collision with root package name */
        int f3820c;

        public CustomArray() {
            b();
        }

        public void a(int i2, CustomAttribute customAttribute) {
            if (this.f3819b[i2] != null) {
                e(i2);
            }
            this.f3819b[i2] = customAttribute;
            int[] iArr = this.f3818a;
            int i3 = this.f3820c;
            this.f3820c = i3 + 1;
            iArr[i3] = i2;
            Arrays.sort(iArr);
        }

        public void b() {
            Arrays.fill(this.f3818a, f3817d);
            Arrays.fill(this.f3819b, (Object) null);
            this.f3820c = 0;
        }

        public void c() {
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f3818a, this.f3820c)));
            printStream.print("K: [");
            int i2 = 0;
            while (i2 < this.f3820c) {
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i2 == 0 ? "" : ", ");
                sb.append(g(i2));
                printStream2.print(sb.toString());
                i2++;
            }
            System.out.println("]");
        }

        public int d(int i2) {
            return this.f3818a[i2];
        }

        public void e(int i2) {
            this.f3819b[i2] = null;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = this.f3820c;
                if (i3 < i5) {
                    int[] iArr = this.f3818a;
                    if (i2 == iArr[i3]) {
                        iArr[i3] = f3817d;
                        i4++;
                    }
                    if (i3 != i4) {
                        iArr[i3] = iArr[i4];
                    }
                    i4++;
                    i3++;
                } else {
                    this.f3820c = i5 - 1;
                    return;
                }
            }
        }

        public int f() {
            return this.f3820c;
        }

        public CustomAttribute g(int i2) {
            return this.f3819b[this.f3818a[i2]];
        }
    }

    public static class CustomVar {

        /* renamed from: d  reason: collision with root package name */
        private static final int f3821d = 999;

        /* renamed from: a  reason: collision with root package name */
        int[] f3822a = new int[101];

        /* renamed from: b  reason: collision with root package name */
        CustomVariable[] f3823b = new CustomVariable[101];

        /* renamed from: c  reason: collision with root package name */
        int f3824c;

        public CustomVar() {
            b();
        }

        public void a(int i2, CustomVariable customVariable) {
            if (this.f3823b[i2] != null) {
                e(i2);
            }
            this.f3823b[i2] = customVariable;
            int[] iArr = this.f3822a;
            int i3 = this.f3824c;
            this.f3824c = i3 + 1;
            iArr[i3] = i2;
            Arrays.sort(iArr);
        }

        public void b() {
            Arrays.fill(this.f3822a, f3821d);
            Arrays.fill(this.f3823b, (Object) null);
            this.f3824c = 0;
        }

        public void c() {
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f3822a, this.f3824c)));
            printStream.print("K: [");
            int i2 = 0;
            while (i2 < this.f3824c) {
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i2 == 0 ? "" : ", ");
                sb.append(g(i2));
                printStream2.print(sb.toString());
                i2++;
            }
            System.out.println("]");
        }

        public int d(int i2) {
            return this.f3822a[i2];
        }

        public void e(int i2) {
            this.f3823b[i2] = null;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = this.f3824c;
                if (i3 < i5) {
                    int[] iArr = this.f3822a;
                    if (i2 == iArr[i3]) {
                        iArr[i3] = f3821d;
                        i4++;
                    }
                    if (i3 != i4) {
                        iArr[i3] = iArr[i4];
                    }
                    i4++;
                    i3++;
                } else {
                    this.f3824c = i5 - 1;
                    return;
                }
            }
        }

        public int f() {
            return this.f3824c;
        }

        public CustomVariable g(int i2) {
            return this.f3823b[this.f3822a[i2]];
        }
    }

    static class FloatArray {

        /* renamed from: d  reason: collision with root package name */
        private static final int f3825d = 999;

        /* renamed from: a  reason: collision with root package name */
        int[] f3826a = new int[101];

        /* renamed from: b  reason: collision with root package name */
        float[][] f3827b = new float[101][];

        /* renamed from: c  reason: collision with root package name */
        int f3828c;

        public FloatArray() {
            b();
        }

        public void a(int i2, float[] fArr) {
            if (this.f3827b[i2] != null) {
                e(i2);
            }
            this.f3827b[i2] = fArr;
            int[] iArr = this.f3826a;
            int i3 = this.f3828c;
            this.f3828c = i3 + 1;
            iArr[i3] = i2;
            Arrays.sort(iArr);
        }

        public void b() {
            Arrays.fill(this.f3826a, f3825d);
            Arrays.fill(this.f3827b, (Object) null);
            this.f3828c = 0;
        }

        public void c() {
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f3826a, this.f3828c)));
            printStream.print("K: [");
            int i2 = 0;
            while (i2 < this.f3828c) {
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i2 == 0 ? "" : ", ");
                sb.append(Arrays.toString(g(i2)));
                printStream2.print(sb.toString());
                i2++;
            }
            System.out.println("]");
        }

        public int d(int i2) {
            return this.f3826a[i2];
        }

        public void e(int i2) {
            this.f3827b[i2] = null;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = this.f3828c;
                if (i3 < i5) {
                    int[] iArr = this.f3826a;
                    if (i2 == iArr[i3]) {
                        iArr[i3] = f3825d;
                        i4++;
                    }
                    if (i3 != i4) {
                        iArr[i3] = iArr[i4];
                    }
                    i4++;
                    i3++;
                } else {
                    this.f3828c = i5 - 1;
                    return;
                }
            }
        }

        public int f() {
            return this.f3828c;
        }

        public float[] g(int i2) {
            return this.f3827b[this.f3826a[i2]];
        }
    }
}
