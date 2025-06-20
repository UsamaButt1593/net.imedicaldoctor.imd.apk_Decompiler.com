package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event extends CrashlyticsReport.Session.Event {

    /* renamed from: a  reason: collision with root package name */
    private final long f24029a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24030b;

    /* renamed from: c  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application f24031c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Device f24032d;

    /* renamed from: e  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Log f24033e;

    /* renamed from: f  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.RolloutsState f24034f;

    static final class Builder extends CrashlyticsReport.Session.Event.Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f24035a;

        /* renamed from: b  reason: collision with root package name */
        private String f24036b;

        /* renamed from: c  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application f24037c;

        /* renamed from: d  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Device f24038d;

        /* renamed from: e  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Log f24039e;

        /* renamed from: f  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.RolloutsState f24040f;

        /* renamed from: g  reason: collision with root package name */
        private byte f24041g;

        Builder() {
        }

        public CrashlyticsReport.Session.Event a() {
            String str;
            CrashlyticsReport.Session.Event.Application application;
            CrashlyticsReport.Session.Event.Device device;
            if (this.f24041g == 1 && (str = this.f24036b) != null && (application = this.f24037c) != null && (device = this.f24038d) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event(this.f24035a, str, application, device, this.f24039e, this.f24040f);
            }
            StringBuilder sb = new StringBuilder();
            if ((1 & this.f24041g) == 0) {
                sb.append(" timestamp");
            }
            if (this.f24036b == null) {
                sb.append(" type");
            }
            if (this.f24037c == null) {
                sb.append(" app");
            }
            if (this.f24038d == null) {
                sb.append(" device");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Event.Builder b(CrashlyticsReport.Session.Event.Application application) {
            if (application != null) {
                this.f24037c = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public CrashlyticsReport.Session.Event.Builder c(CrashlyticsReport.Session.Event.Device device) {
            if (device != null) {
                this.f24038d = device;
                return this;
            }
            throw new NullPointerException("Null device");
        }

        public CrashlyticsReport.Session.Event.Builder d(CrashlyticsReport.Session.Event.Log log) {
            this.f24039e = log;
            return this;
        }

        public CrashlyticsReport.Session.Event.Builder e(CrashlyticsReport.Session.Event.RolloutsState rolloutsState) {
            this.f24040f = rolloutsState;
            return this;
        }

        public CrashlyticsReport.Session.Event.Builder f(long j2) {
            this.f24035a = j2;
            this.f24041g = (byte) (this.f24041g | 1);
            return this;
        }

        public CrashlyticsReport.Session.Event.Builder g(String str) {
            if (str != null) {
                this.f24036b = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        private Builder(CrashlyticsReport.Session.Event event) {
            this.f24035a = event.f();
            this.f24036b = event.g();
            this.f24037c = event.b();
            this.f24038d = event.c();
            this.f24039e = event.d();
            this.f24040f = event.e();
            this.f24041g = 1;
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event(long j2, String str, CrashlyticsReport.Session.Event.Application application, CrashlyticsReport.Session.Event.Device device, @Nullable CrashlyticsReport.Session.Event.Log log, @Nullable CrashlyticsReport.Session.Event.RolloutsState rolloutsState) {
        this.f24029a = j2;
        this.f24030b = str;
        this.f24031c = application;
        this.f24032d = device;
        this.f24033e = log;
        this.f24034f = rolloutsState;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Application b() {
        return this.f24031c;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Device c() {
        return this.f24032d;
    }

    @Nullable
    public CrashlyticsReport.Session.Event.Log d() {
        return this.f24033e;
    }

    @Nullable
    public CrashlyticsReport.Session.Event.RolloutsState e() {
        return this.f24034f;
    }

    public boolean equals(Object obj) {
        CrashlyticsReport.Session.Event.Log log;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event)) {
            return false;
        }
        CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
        if (this.f24029a == event.f() && this.f24030b.equals(event.g()) && this.f24031c.equals(event.b()) && this.f24032d.equals(event.c()) && ((log = this.f24033e) != null ? log.equals(event.d()) : event.d() == null)) {
            CrashlyticsReport.Session.Event.RolloutsState rolloutsState = this.f24034f;
            CrashlyticsReport.Session.Event.RolloutsState e2 = event.e();
            if (rolloutsState == null) {
                if (e2 == null) {
                    return true;
                }
            } else if (rolloutsState.equals(e2)) {
                return true;
            }
        }
        return false;
    }

    public long f() {
        return this.f24029a;
    }

    @NonNull
    public String g() {
        return this.f24030b;
    }

    public CrashlyticsReport.Session.Event.Builder h() {
        return new Builder(this);
    }

    public int hashCode() {
        long j2 = this.f24029a;
        int hashCode = (((((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f24030b.hashCode()) * 1000003) ^ this.f24031c.hashCode()) * 1000003) ^ this.f24032d.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Log log = this.f24033e;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (log == null ? 0 : log.hashCode())) * 1000003;
        CrashlyticsReport.Session.Event.RolloutsState rolloutsState = this.f24034f;
        if (rolloutsState != null) {
            i2 = rolloutsState.hashCode();
        }
        return hashCode2 ^ i2;
    }

    public String toString() {
        return "Event{timestamp=" + this.f24029a + ", type=" + this.f24030b + ", app=" + this.f24031c + ", device=" + this.f24032d + ", log=" + this.f24033e + ", rollouts=" + this.f24034f + "}";
    }
}
