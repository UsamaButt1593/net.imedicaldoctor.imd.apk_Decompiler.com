package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

final class AutoValue_CrashlyticsReport_Session extends CrashlyticsReport.Session {

    /* renamed from: a  reason: collision with root package name */
    private final String f23969a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23970b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23971c;

    /* renamed from: d  reason: collision with root package name */
    private final long f23972d;

    /* renamed from: e  reason: collision with root package name */
    private final Long f23973e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f23974f;

    /* renamed from: g  reason: collision with root package name */
    private final CrashlyticsReport.Session.Application f23975g;

    /* renamed from: h  reason: collision with root package name */
    private final CrashlyticsReport.Session.User f23976h;

    /* renamed from: i  reason: collision with root package name */
    private final CrashlyticsReport.Session.OperatingSystem f23977i;

    /* renamed from: j  reason: collision with root package name */
    private final CrashlyticsReport.Session.Device f23978j;

    /* renamed from: k  reason: collision with root package name */
    private final List<CrashlyticsReport.Session.Event> f23979k;

    /* renamed from: l  reason: collision with root package name */
    private final int f23980l;

    static final class Builder extends CrashlyticsReport.Session.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f23981a;

        /* renamed from: b  reason: collision with root package name */
        private String f23982b;

        /* renamed from: c  reason: collision with root package name */
        private String f23983c;

        /* renamed from: d  reason: collision with root package name */
        private long f23984d;

        /* renamed from: e  reason: collision with root package name */
        private Long f23985e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f23986f;

        /* renamed from: g  reason: collision with root package name */
        private CrashlyticsReport.Session.Application f23987g;

        /* renamed from: h  reason: collision with root package name */
        private CrashlyticsReport.Session.User f23988h;

        /* renamed from: i  reason: collision with root package name */
        private CrashlyticsReport.Session.OperatingSystem f23989i;

        /* renamed from: j  reason: collision with root package name */
        private CrashlyticsReport.Session.Device f23990j;

        /* renamed from: k  reason: collision with root package name */
        private List<CrashlyticsReport.Session.Event> f23991k;

        /* renamed from: l  reason: collision with root package name */
        private int f23992l;

        /* renamed from: m  reason: collision with root package name */
        private byte f23993m;

        Builder() {
        }

        public CrashlyticsReport.Session a() {
            String str;
            String str2;
            CrashlyticsReport.Session.Application application;
            if (this.f23993m == 7 && (str = this.f23981a) != null && (str2 = this.f23982b) != null && (application = this.f23987g) != null) {
                return new AutoValue_CrashlyticsReport_Session(str, str2, this.f23983c, this.f23984d, this.f23985e, this.f23986f, application, this.f23988h, this.f23989i, this.f23990j, this.f23991k, this.f23992l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f23981a == null) {
                sb.append(" generator");
            }
            if (this.f23982b == null) {
                sb.append(" identifier");
            }
            if ((this.f23993m & 1) == 0) {
                sb.append(" startedAt");
            }
            if ((this.f23993m & 2) == 0) {
                sb.append(" crashed");
            }
            if (this.f23987g == null) {
                sb.append(" app");
            }
            if ((this.f23993m & 4) == 0) {
                sb.append(" generatorType");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Builder b(CrashlyticsReport.Session.Application application) {
            if (application != null) {
                this.f23987g = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public CrashlyticsReport.Session.Builder c(@Nullable String str) {
            this.f23983c = str;
            return this;
        }

        public CrashlyticsReport.Session.Builder d(boolean z) {
            this.f23986f = z;
            this.f23993m = (byte) (this.f23993m | 2);
            return this;
        }

        public CrashlyticsReport.Session.Builder e(CrashlyticsReport.Session.Device device) {
            this.f23990j = device;
            return this;
        }

        public CrashlyticsReport.Session.Builder f(Long l2) {
            this.f23985e = l2;
            return this;
        }

        public CrashlyticsReport.Session.Builder g(List<CrashlyticsReport.Session.Event> list) {
            this.f23991k = list;
            return this;
        }

        public CrashlyticsReport.Session.Builder h(String str) {
            if (str != null) {
                this.f23981a = str;
                return this;
            }
            throw new NullPointerException("Null generator");
        }

        public CrashlyticsReport.Session.Builder i(int i2) {
            this.f23992l = i2;
            this.f23993m = (byte) (this.f23993m | 4);
            return this;
        }

        public CrashlyticsReport.Session.Builder j(String str) {
            if (str != null) {
                this.f23982b = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public CrashlyticsReport.Session.Builder l(CrashlyticsReport.Session.OperatingSystem operatingSystem) {
            this.f23989i = operatingSystem;
            return this;
        }

        public CrashlyticsReport.Session.Builder m(long j2) {
            this.f23984d = j2;
            this.f23993m = (byte) (this.f23993m | 1);
            return this;
        }

        public CrashlyticsReport.Session.Builder n(CrashlyticsReport.Session.User user) {
            this.f23988h = user;
            return this;
        }

        private Builder(CrashlyticsReport.Session session) {
            this.f23981a = session.g();
            this.f23982b = session.i();
            this.f23983c = session.c();
            this.f23984d = session.l();
            this.f23985e = session.e();
            this.f23986f = session.n();
            this.f23987g = session.b();
            this.f23988h = session.m();
            this.f23989i = session.k();
            this.f23990j = session.d();
            this.f23991k = session.f();
            this.f23992l = session.h();
            this.f23993m = 7;
        }
    }

    private AutoValue_CrashlyticsReport_Session(String str, String str2, @Nullable String str3, long j2, @Nullable Long l2, boolean z, CrashlyticsReport.Session.Application application, @Nullable CrashlyticsReport.Session.User user, @Nullable CrashlyticsReport.Session.OperatingSystem operatingSystem, @Nullable CrashlyticsReport.Session.Device device, @Nullable List<CrashlyticsReport.Session.Event> list, int i2) {
        this.f23969a = str;
        this.f23970b = str2;
        this.f23971c = str3;
        this.f23972d = j2;
        this.f23973e = l2;
        this.f23974f = z;
        this.f23975g = application;
        this.f23976h = user;
        this.f23977i = operatingSystem;
        this.f23978j = device;
        this.f23979k = list;
        this.f23980l = i2;
    }

    @NonNull
    public CrashlyticsReport.Session.Application b() {
        return this.f23975g;
    }

    @Nullable
    public String c() {
        return this.f23971c;
    }

    @Nullable
    public CrashlyticsReport.Session.Device d() {
        return this.f23978j;
    }

    @Nullable
    public Long e() {
        return this.f23973e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        r1 = r7.f23973e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        r1 = r7.f23976h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0080, code lost:
        r1 = r7.f23977i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0095, code lost:
        r1 = r7.f23978j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00aa, code lost:
        r1 = r7.f23979k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        r1 = r7.f23971c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
            r2 = 0
            if (r1 == 0) goto L_0x00ca
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session r8 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session) r8
            java.lang.String r1 = r7.f23969a
            java.lang.String r3 = r8.g()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
            java.lang.String r1 = r7.f23970b
            java.lang.String r3 = r8.i()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
            java.lang.String r1 = r7.f23971c
            if (r1 != 0) goto L_0x002e
            java.lang.String r1 = r8.c()
            if (r1 != 0) goto L_0x00c8
            goto L_0x0038
        L_0x002e:
            java.lang.String r3 = r8.c()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
        L_0x0038:
            long r3 = r7.f23972d
            long r5 = r8.l()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x00c8
            java.lang.Long r1 = r7.f23973e
            if (r1 != 0) goto L_0x004d
            java.lang.Long r1 = r8.e()
            if (r1 != 0) goto L_0x00c8
            goto L_0x0057
        L_0x004d:
            java.lang.Long r3 = r8.e()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
        L_0x0057:
            boolean r1 = r7.f23974f
            boolean r3 = r8.n()
            if (r1 != r3) goto L_0x00c8
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application r1 = r7.f23975g
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application r3 = r8.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User r1 = r7.f23976h
            if (r1 != 0) goto L_0x0076
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User r1 = r8.m()
            if (r1 != 0) goto L_0x00c8
            goto L_0x0080
        L_0x0076:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User r3 = r8.m()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
        L_0x0080:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem r1 = r7.f23977i
            if (r1 != 0) goto L_0x008b
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem r1 = r8.k()
            if (r1 != 0) goto L_0x00c8
            goto L_0x0095
        L_0x008b:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem r3 = r8.k()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
        L_0x0095:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device r1 = r7.f23978j
            if (r1 != 0) goto L_0x00a0
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device r1 = r8.d()
            if (r1 != 0) goto L_0x00c8
            goto L_0x00aa
        L_0x00a0:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device r3 = r8.d()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
        L_0x00aa:
            java.util.List<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event> r1 = r7.f23979k
            if (r1 != 0) goto L_0x00b5
            java.util.List r1 = r8.f()
            if (r1 != 0) goto L_0x00c8
            goto L_0x00bf
        L_0x00b5:
            java.util.List r3 = r8.f()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00c8
        L_0x00bf:
            int r1 = r7.f23980l
            int r8 = r8.h()
            if (r1 != r8) goto L_0x00c8
            goto L_0x00c9
        L_0x00c8:
            r0 = 0
        L_0x00c9:
            return r0
        L_0x00ca:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session.equals(java.lang.Object):boolean");
    }

    @Nullable
    public List<CrashlyticsReport.Session.Event> f() {
        return this.f23979k;
    }

    @NonNull
    public String g() {
        return this.f23969a;
    }

    public int h() {
        return this.f23980l;
    }

    public int hashCode() {
        int hashCode = (((this.f23969a.hashCode() ^ 1000003) * 1000003) ^ this.f23970b.hashCode()) * 1000003;
        String str = this.f23971c;
        int i2 = 0;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j2 = this.f23972d;
        int i3 = (((hashCode ^ hashCode2) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        Long l2 = this.f23973e;
        int hashCode3 = (((((i3 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003) ^ (this.f23974f ? 1231 : 1237)) * 1000003) ^ this.f23975g.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user = this.f23976h;
        int hashCode4 = (hashCode3 ^ (user == null ? 0 : user.hashCode())) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.f23977i;
        int hashCode5 = (hashCode4 ^ (operatingSystem == null ? 0 : operatingSystem.hashCode())) * 1000003;
        CrashlyticsReport.Session.Device device = this.f23978j;
        int hashCode6 = (hashCode5 ^ (device == null ? 0 : device.hashCode())) * 1000003;
        List<CrashlyticsReport.Session.Event> list = this.f23979k;
        if (list != null) {
            i2 = list.hashCode();
        }
        return ((hashCode6 ^ i2) * 1000003) ^ this.f23980l;
    }

    @NonNull
    @Encodable.Ignore
    public String i() {
        return this.f23970b;
    }

    @Nullable
    public CrashlyticsReport.Session.OperatingSystem k() {
        return this.f23977i;
    }

    public long l() {
        return this.f23972d;
    }

    @Nullable
    public CrashlyticsReport.Session.User m() {
        return this.f23976h;
    }

    public boolean n() {
        return this.f23974f;
    }

    public CrashlyticsReport.Session.Builder o() {
        return new Builder(this);
    }

    public String toString() {
        return "Session{generator=" + this.f23969a + ", identifier=" + this.f23970b + ", appQualitySessionId=" + this.f23971c + ", startedAt=" + this.f23972d + ", endedAt=" + this.f23973e + ", crashed=" + this.f23974f + ", app=" + this.f23975g + ", user=" + this.f23976h + ", os=" + this.f23977i + ", device=" + this.f23978j + ", events=" + this.f23979k + ", generatorType=" + this.f23980l + "}";
    }
}
