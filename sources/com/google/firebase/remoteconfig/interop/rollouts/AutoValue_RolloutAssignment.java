package com.google.firebase.remoteconfig.interop.rollouts;

import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment;

final class AutoValue_RolloutAssignment extends RolloutAssignment {

    /* renamed from: g  reason: collision with root package name */
    private final String f24979g;

    /* renamed from: h  reason: collision with root package name */
    private final String f24980h;

    /* renamed from: i  reason: collision with root package name */
    private final String f24981i;

    /* renamed from: j  reason: collision with root package name */
    private final String f24982j;

    /* renamed from: k  reason: collision with root package name */
    private final long f24983k;

    static final class Builder extends RolloutAssignment.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24984a;

        /* renamed from: b  reason: collision with root package name */
        private String f24985b;

        /* renamed from: c  reason: collision with root package name */
        private String f24986c;

        /* renamed from: d  reason: collision with root package name */
        private String f24987d;

        /* renamed from: e  reason: collision with root package name */
        private long f24988e;

        /* renamed from: f  reason: collision with root package name */
        private byte f24989f;

        Builder() {
        }

        public RolloutAssignment a() {
            if (this.f24989f == 1 && this.f24984a != null && this.f24985b != null && this.f24986c != null && this.f24987d != null) {
                return new AutoValue_RolloutAssignment(this.f24984a, this.f24985b, this.f24986c, this.f24987d, this.f24988e);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f24984a == null) {
                sb.append(" rolloutId");
            }
            if (this.f24985b == null) {
                sb.append(" variantId");
            }
            if (this.f24986c == null) {
                sb.append(" parameterKey");
            }
            if (this.f24987d == null) {
                sb.append(" parameterValue");
            }
            if ((1 & this.f24989f) == 0) {
                sb.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public RolloutAssignment.Builder b(String str) {
            if (str != null) {
                this.f24986c = str;
                return this;
            }
            throw new NullPointerException("Null parameterKey");
        }

        public RolloutAssignment.Builder c(String str) {
            if (str != null) {
                this.f24987d = str;
                return this;
            }
            throw new NullPointerException("Null parameterValue");
        }

        public RolloutAssignment.Builder d(String str) {
            if (str != null) {
                this.f24984a = str;
                return this;
            }
            throw new NullPointerException("Null rolloutId");
        }

        public RolloutAssignment.Builder e(long j2) {
            this.f24988e = j2;
            this.f24989f = (byte) (this.f24989f | 1);
            return this;
        }

        public RolloutAssignment.Builder f(String str) {
            if (str != null) {
                this.f24985b = str;
                return this;
            }
            throw new NullPointerException("Null variantId");
        }
    }

    private AutoValue_RolloutAssignment(String str, String str2, String str3, String str4, long j2) {
        this.f24979g = str;
        this.f24980h = str2;
        this.f24981i = str3;
        this.f24982j = str4;
        this.f24983k = j2;
    }

    @NonNull
    public String d() {
        return this.f24981i;
    }

    @NonNull
    public String e() {
        return this.f24982j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RolloutAssignment)) {
            return false;
        }
        RolloutAssignment rolloutAssignment = (RolloutAssignment) obj;
        return this.f24979g.equals(rolloutAssignment.f()) && this.f24980h.equals(rolloutAssignment.h()) && this.f24981i.equals(rolloutAssignment.d()) && this.f24982j.equals(rolloutAssignment.e()) && this.f24983k == rolloutAssignment.g();
    }

    @NonNull
    public String f() {
        return this.f24979g;
    }

    public long g() {
        return this.f24983k;
    }

    @NonNull
    public String h() {
        return this.f24980h;
    }

    public int hashCode() {
        long j2 = this.f24983k;
        return ((((((((this.f24979g.hashCode() ^ 1000003) * 1000003) ^ this.f24980h.hashCode()) * 1000003) ^ this.f24981i.hashCode()) * 1000003) ^ this.f24982j.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f24979g + ", variantId=" + this.f24980h + ", parameterKey=" + this.f24981i + ", parameterValue=" + this.f24982j + ", templateVersion=" + this.f24983k + "}";
    }
}
