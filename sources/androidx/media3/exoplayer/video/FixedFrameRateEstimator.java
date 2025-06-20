package androidx.media3.exoplayer.video;

import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import java.util.Arrays;

final class FixedFrameRateEstimator {

    /* renamed from: g  reason: collision with root package name */
    public static final int f12751g = 15;
    @VisibleForTesting

    /* renamed from: h  reason: collision with root package name */
    static final long f12752h = 1000000;

    /* renamed from: a  reason: collision with root package name */
    private Matcher f12753a = new Matcher();

    /* renamed from: b  reason: collision with root package name */
    private Matcher f12754b = new Matcher();

    /* renamed from: c  reason: collision with root package name */
    private boolean f12755c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12756d;

    /* renamed from: e  reason: collision with root package name */
    private long f12757e = C.f9084b;

    /* renamed from: f  reason: collision with root package name */
    private int f12758f;

    private static final class Matcher {

        /* renamed from: a  reason: collision with root package name */
        private long f12759a;

        /* renamed from: b  reason: collision with root package name */
        private long f12760b;

        /* renamed from: c  reason: collision with root package name */
        private long f12761c;

        /* renamed from: d  reason: collision with root package name */
        private long f12762d;

        /* renamed from: e  reason: collision with root package name */
        private long f12763e;

        /* renamed from: f  reason: collision with root package name */
        private long f12764f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean[] f12765g = new boolean[15];

        /* renamed from: h  reason: collision with root package name */
        private int f12766h;

        private static int c(long j2) {
            return (int) (j2 % 15);
        }

        public long a() {
            long j2 = this.f12763e;
            if (j2 == 0) {
                return 0;
            }
            return this.f12764f / j2;
        }

        public long b() {
            return this.f12764f;
        }

        public boolean d() {
            long j2 = this.f12762d;
            if (j2 == 0) {
                return false;
            }
            return this.f12765g[c(j2 - 1)];
        }

        public boolean e() {
            return this.f12762d > 15 && this.f12766h == 0;
        }

        public void f(long j2) {
            int i2;
            long j3 = this.f12762d;
            if (j3 == 0) {
                this.f12759a = j2;
            } else if (j3 == 1) {
                long j4 = j2 - this.f12759a;
                this.f12760b = j4;
                this.f12764f = j4;
                this.f12763e = 1;
            } else {
                long j5 = j2 - this.f12761c;
                int c2 = c(j3);
                if (Math.abs(j5 - this.f12760b) <= 1000000) {
                    this.f12763e++;
                    this.f12764f += j5;
                    boolean[] zArr = this.f12765g;
                    if (zArr[c2]) {
                        zArr[c2] = false;
                        i2 = this.f12766h - 1;
                    }
                } else {
                    boolean[] zArr2 = this.f12765g;
                    if (!zArr2[c2]) {
                        zArr2[c2] = true;
                        i2 = this.f12766h + 1;
                    }
                }
                this.f12766h = i2;
            }
            this.f12762d++;
            this.f12761c = j2;
        }

        public void g() {
            this.f12762d = 0;
            this.f12763e = 0;
            this.f12764f = 0;
            this.f12766h = 0;
            Arrays.fill(this.f12765g, false);
        }
    }

    public long a() {
        return e() ? this.f12753a.a() : C.f9084b;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / ((double) this.f12753a.a()));
        }
        return -1.0f;
    }

    public int c() {
        return this.f12758f;
    }

    public long d() {
        return e() ? this.f12753a.b() : C.f9084b;
    }

    public boolean e() {
        return this.f12753a.e();
    }

    public void f(long j2) {
        this.f12753a.f(j2);
        int i2 = 0;
        if (this.f12753a.e() && !this.f12756d) {
            this.f12755c = false;
        } else if (this.f12757e != C.f9084b) {
            if (!this.f12755c || this.f12754b.d()) {
                this.f12754b.g();
                this.f12754b.f(this.f12757e);
            }
            this.f12755c = true;
            this.f12754b.f(j2);
        }
        if (this.f12755c && this.f12754b.e()) {
            Matcher matcher = this.f12753a;
            this.f12753a = this.f12754b;
            this.f12754b = matcher;
            this.f12755c = false;
            this.f12756d = false;
        }
        this.f12757e = j2;
        if (!this.f12753a.e()) {
            i2 = this.f12758f + 1;
        }
        this.f12758f = i2;
    }

    public void g() {
        this.f12753a.g();
        this.f12754b.g();
        this.f12755c = false;
        this.f12757e = C.f9084b;
        this.f12758f = 0;
    }
}
