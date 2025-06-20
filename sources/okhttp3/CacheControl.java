package okhttp3;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class CacheControl {

    /* renamed from: n  reason: collision with root package name */
    public static final CacheControl f30756n = new Builder().f().a();
    public static final CacheControl o = new Builder().i().d(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f30757a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f30758b;

    /* renamed from: c  reason: collision with root package name */
    private final int f30759c;

    /* renamed from: d  reason: collision with root package name */
    private final int f30760d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f30761e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f30762f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f30763g;

    /* renamed from: h  reason: collision with root package name */
    private final int f30764h;

    /* renamed from: i  reason: collision with root package name */
    private final int f30765i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f30766j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f30767k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f30768l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    String f30769m;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        boolean f30770a;

        /* renamed from: b  reason: collision with root package name */
        boolean f30771b;

        /* renamed from: c  reason: collision with root package name */
        int f30772c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f30773d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f30774e = -1;

        /* renamed from: f  reason: collision with root package name */
        boolean f30775f;

        /* renamed from: g  reason: collision with root package name */
        boolean f30776g;

        /* renamed from: h  reason: collision with root package name */
        boolean f30777h;

        public CacheControl a() {
            return new CacheControl(this);
        }

        public Builder b() {
            this.f30777h = true;
            return this;
        }

        public Builder c(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds((long) i2);
                this.f30772c = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxAge < 0: " + i2);
        }

        public Builder d(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds((long) i2);
                this.f30773d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i2);
        }

        public Builder e(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds((long) i2);
                this.f30774e = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("minFresh < 0: " + i2);
        }

        public Builder f() {
            this.f30770a = true;
            return this;
        }

        public Builder g() {
            this.f30771b = true;
            return this;
        }

        public Builder h() {
            this.f30776g = true;
            return this;
        }

        public Builder i() {
            this.f30775f = true;
            return this;
        }
    }

    CacheControl(Builder builder) {
        this.f30757a = builder.f30770a;
        this.f30758b = builder.f30771b;
        this.f30759c = builder.f30772c;
        this.f30760d = -1;
        this.f30761e = false;
        this.f30762f = false;
        this.f30763g = false;
        this.f30764h = builder.f30773d;
        this.f30765i = builder.f30774e;
        this.f30766j = builder.f30775f;
        this.f30767k = builder.f30776g;
        this.f30768l = builder.f30777h;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f30757a) {
            sb.append("no-cache, ");
        }
        if (this.f30758b) {
            sb.append("no-store, ");
        }
        if (this.f30759c != -1) {
            sb.append("max-age=");
            sb.append(this.f30759c);
            sb.append(", ");
        }
        if (this.f30760d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f30760d);
            sb.append(", ");
        }
        if (this.f30761e) {
            sb.append("private, ");
        }
        if (this.f30762f) {
            sb.append("public, ");
        }
        if (this.f30763g) {
            sb.append("must-revalidate, ");
        }
        if (this.f30764h != -1) {
            sb.append("max-stale=");
            sb.append(this.f30764h);
            sb.append(", ");
        }
        if (this.f30765i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f30765i);
            sb.append(", ");
        }
        if (this.f30766j) {
            sb.append("only-if-cached, ");
        }
        if (this.f30767k) {
            sb.append("no-transform, ");
        }
        if (this.f30768l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static okhttp3.CacheControl m(okhttp3.Headers r22) {
        /*
            r0 = r22
            int r1 = r22.l()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x001a:
            if (r6 >= r1) goto L_0x0147
            java.lang.String r2 = r0.g(r6)
            java.lang.String r5 = r0.n(r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0032
            if (r8 == 0) goto L_0x0030
        L_0x002e:
            r7 = 0
            goto L_0x003b
        L_0x0030:
            r8 = r5
            goto L_0x003b
        L_0x0032:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0140
            goto L_0x002e
        L_0x003b:
            r2 = 0
        L_0x003c:
            int r3 = r5.length()
            if (r2 >= r3) goto L_0x0140
            java.lang.String r3 = "=,;"
            int r3 = okhttp3.internal.http.HttpHeaders.n(r5, r2, r3)
            java.lang.String r2 = r5.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r4 = r5.length()
            if (r3 == r4) goto L_0x0066
            char r4 = r5.charAt(r3)
            r0 = 44
            if (r4 == r0) goto L_0x0066
            char r0 = r5.charAt(r3)
            r4 = 59
            if (r0 != r4) goto L_0x0068
        L_0x0066:
            r4 = 1
            goto L_0x009b
        L_0x0068:
            int r3 = r3 + 1
            int r0 = okhttp3.internal.http.HttpHeaders.o(r5, r3)
            int r3 = r5.length()
            if (r0 >= r3) goto L_0x008b
            char r3 = r5.charAt(r0)
            r4 = 34
            if (r3 != r4) goto L_0x008b
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = okhttp3.internal.http.HttpHeaders.n(r5, r0, r3)
            java.lang.String r0 = r5.substring(r0, r3)
            r4 = 1
            int r3 = r3 + r4
            goto L_0x009e
        L_0x008b:
            r4 = 1
            java.lang.String r3 = ",;"
            int r3 = okhttp3.internal.http.HttpHeaders.n(r5, r0, r3)
            java.lang.String r0 = r5.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009e
        L_0x009b:
            int r3 = r3 + 1
            r0 = 0
        L_0x009e:
            java.lang.String r4 = "no-cache"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00aa
            r4 = -1
            r9 = 1
            goto L_0x013b
        L_0x00aa:
            java.lang.String r4 = "no-store"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00b6
            r4 = -1
            r10 = 1
            goto L_0x013b
        L_0x00b6:
            java.lang.String r4 = "max-age"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00c6
            r4 = -1
            int r0 = okhttp3.internal.http.HttpHeaders.h(r0, r4)
            r11 = r0
            goto L_0x013b
        L_0x00c6:
            java.lang.String r4 = "s-maxage"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00d6
            r4 = -1
            int r0 = okhttp3.internal.http.HttpHeaders.h(r0, r4)
            r12 = r0
            goto L_0x013b
        L_0x00d6:
            java.lang.String r4 = "private"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00e1
            r4 = -1
            r13 = 1
            goto L_0x013b
        L_0x00e1:
            java.lang.String r4 = "public"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00ec
            r4 = -1
            r14 = 1
            goto L_0x013b
        L_0x00ec:
            java.lang.String r4 = "must-revalidate"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00f7
            r4 = -1
            r15 = 1
            goto L_0x013b
        L_0x00f7:
            java.lang.String r4 = "max-stale"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x010a
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r0 = okhttp3.internal.http.HttpHeaders.h(r0, r2)
            r16 = r0
            r4 = -1
            goto L_0x013b
        L_0x010a:
            java.lang.String r4 = "min-fresh"
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x011a
            r4 = -1
            int r0 = okhttp3.internal.http.HttpHeaders.h(r0, r4)
            r17 = r0
            goto L_0x013b
        L_0x011a:
            r4 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0126
            r18 = 1
            goto L_0x013b
        L_0x0126:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0131
            r19 = 1
            goto L_0x013b
        L_0x0131:
            java.lang.String r0 = "immutable"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x013b
            r20 = 1
        L_0x013b:
            r0 = r22
            r2 = r3
            goto L_0x003c
        L_0x0140:
            r4 = -1
            int r6 = r6 + 1
            r0 = r22
            goto L_0x001a
        L_0x0147:
            if (r7 != 0) goto L_0x014c
            r21 = 0
            goto L_0x014e
        L_0x014c:
            r21 = r8
        L_0x014e:
            okhttp3.CacheControl r0 = new okhttp3.CacheControl
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.m(okhttp3.Headers):okhttp3.CacheControl");
    }

    public boolean b() {
        return this.f30768l;
    }

    public boolean c() {
        return this.f30761e;
    }

    public boolean d() {
        return this.f30762f;
    }

    public int e() {
        return this.f30759c;
    }

    public int f() {
        return this.f30764h;
    }

    public int g() {
        return this.f30765i;
    }

    public boolean h() {
        return this.f30763g;
    }

    public boolean i() {
        return this.f30757a;
    }

    public boolean j() {
        return this.f30758b;
    }

    public boolean k() {
        return this.f30767k;
    }

    public boolean l() {
        return this.f30766j;
    }

    public int n() {
        return this.f30760d;
    }

    public String toString() {
        String str = this.f30769m;
        if (str != null) {
            return str;
        }
        String a2 = a();
        this.f30769m = a2;
        return a2;
    }

    private CacheControl(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f30757a = z;
        this.f30758b = z2;
        this.f30759c = i2;
        this.f30760d = i3;
        this.f30761e = z3;
        this.f30762f = z4;
        this.f30763g = z5;
        this.f30764h = i4;
        this.f30765i = i5;
        this.f30766j = z6;
        this.f30767k = z7;
        this.f30768l = z8;
        this.f30769m = str;
    }
}
