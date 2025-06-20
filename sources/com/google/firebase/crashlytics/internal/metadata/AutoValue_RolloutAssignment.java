package com.google.firebase.crashlytics.internal.metadata;

final class AutoValue_RolloutAssignment extends RolloutAssignment {

    /* renamed from: c  reason: collision with root package name */
    private final String f23703c;

    /* renamed from: d  reason: collision with root package name */
    private final String f23704d;

    /* renamed from: e  reason: collision with root package name */
    private final String f23705e;

    /* renamed from: f  reason: collision with root package name */
    private final String f23706f;

    /* renamed from: g  reason: collision with root package name */
    private final long f23707g;

    AutoValue_RolloutAssignment(String str, String str2, String str3, String str4, long j2) {
        if (str != null) {
            this.f23703c = str;
            if (str2 != null) {
                this.f23704d = str2;
                if (str3 != null) {
                    this.f23705e = str3;
                    if (str4 != null) {
                        this.f23706f = str4;
                        this.f23707g = j2;
                        return;
                    }
                    throw new NullPointerException("Null variantId");
                }
                throw new NullPointerException("Null parameterValue");
            }
            throw new NullPointerException("Null parameterKey");
        }
        throw new NullPointerException("Null rolloutId");
    }

    public String c() {
        return this.f23704d;
    }

    public String d() {
        return this.f23705e;
    }

    public String e() {
        return this.f23703c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RolloutAssignment)) {
            return false;
        }
        RolloutAssignment rolloutAssignment = (RolloutAssignment) obj;
        return this.f23703c.equals(rolloutAssignment.e()) && this.f23704d.equals(rolloutAssignment.c()) && this.f23705e.equals(rolloutAssignment.d()) && this.f23706f.equals(rolloutAssignment.g()) && this.f23707g == rolloutAssignment.f();
    }

    public long f() {
        return this.f23707g;
    }

    public String g() {
        return this.f23706f;
    }

    public int hashCode() {
        long j2 = this.f23707g;
        return ((((((((this.f23703c.hashCode() ^ 1000003) * 1000003) ^ this.f23704d.hashCode()) * 1000003) ^ this.f23705e.hashCode()) * 1000003) ^ this.f23706f.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f23703c + ", parameterKey=" + this.f23704d + ", parameterValue=" + this.f23705e + ", variantId=" + this.f23706f + ", templateVersion=" + this.f23707g + "}";
    }
}
