package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.SendRequest;

final class AutoValue_SendRequest extends SendRequest {

    /* renamed from: a  reason: collision with root package name */
    private final TransportContext f19417a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19418b;

    /* renamed from: c  reason: collision with root package name */
    private final Event<?> f19419c;

    /* renamed from: d  reason: collision with root package name */
    private final Transformer<?, byte[]> f19420d;

    /* renamed from: e  reason: collision with root package name */
    private final Encoding f19421e;

    static final class Builder extends SendRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private TransportContext f19422a;

        /* renamed from: b  reason: collision with root package name */
        private String f19423b;

        /* renamed from: c  reason: collision with root package name */
        private Event<?> f19424c;

        /* renamed from: d  reason: collision with root package name */
        private Transformer<?, byte[]> f19425d;

        /* renamed from: e  reason: collision with root package name */
        private Encoding f19426e;

        Builder() {
        }

        public SendRequest a() {
            String str = "";
            if (this.f19422a == null) {
                str = str + " transportContext";
            }
            if (this.f19423b == null) {
                str = str + " transportName";
            }
            if (this.f19424c == null) {
                str = str + " event";
            }
            if (this.f19425d == null) {
                str = str + " transformer";
            }
            if (this.f19426e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new AutoValue_SendRequest(this.f19422a, this.f19423b, this.f19424c, this.f19425d, this.f19426e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public SendRequest.Builder b(Encoding encoding) {
            if (encoding != null) {
                this.f19426e = encoding;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        /* access modifiers changed from: package-private */
        public SendRequest.Builder c(Event<?> event) {
            if (event != null) {
                this.f19424c = event;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        /* access modifiers changed from: package-private */
        public SendRequest.Builder e(Transformer<?, byte[]> transformer) {
            if (transformer != null) {
                this.f19425d = transformer;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        public SendRequest.Builder f(TransportContext transportContext) {
            if (transportContext != null) {
                this.f19422a = transportContext;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        public SendRequest.Builder g(String str) {
            if (str != null) {
                this.f19423b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }
    }

    private AutoValue_SendRequest(TransportContext transportContext, String str, Event<?> event, Transformer<?, byte[]> transformer, Encoding encoding) {
        this.f19417a = transportContext;
        this.f19418b = str;
        this.f19419c = event;
        this.f19420d = transformer;
        this.f19421e = encoding;
    }

    public Encoding b() {
        return this.f19421e;
    }

    /* access modifiers changed from: package-private */
    public Event<?> c() {
        return this.f19419c;
    }

    /* access modifiers changed from: package-private */
    public Transformer<?, byte[]> e() {
        return this.f19420d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendRequest)) {
            return false;
        }
        SendRequest sendRequest = (SendRequest) obj;
        return this.f19417a.equals(sendRequest.f()) && this.f19418b.equals(sendRequest.g()) && this.f19419c.equals(sendRequest.c()) && this.f19420d.equals(sendRequest.e()) && this.f19421e.equals(sendRequest.b());
    }

    public TransportContext f() {
        return this.f19417a;
    }

    public String g() {
        return this.f19418b;
    }

    public int hashCode() {
        return ((((((((this.f19417a.hashCode() ^ 1000003) * 1000003) ^ this.f19418b.hashCode()) * 1000003) ^ this.f19419c.hashCode()) * 1000003) ^ this.f19420d.hashCode()) * 1000003) ^ this.f19421e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f19417a + ", transportName=" + this.f19418b + ", event=" + this.f19419c + ", transformer=" + this.f19420d + ", encoding=" + this.f19421e + "}";
    }
}
