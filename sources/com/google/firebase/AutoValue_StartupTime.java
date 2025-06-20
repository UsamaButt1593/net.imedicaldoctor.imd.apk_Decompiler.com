package com.google.firebase;

final class AutoValue_StartupTime extends StartupTime {

    /* renamed from: a  reason: collision with root package name */
    private final long f23266a;

    /* renamed from: b  reason: collision with root package name */
    private final long f23267b;

    /* renamed from: c  reason: collision with root package name */
    private final long f23268c;

    AutoValue_StartupTime(long j2, long j3, long j4) {
        this.f23266a = j2;
        this.f23267b = j3;
        this.f23268c = j4;
    }

    public long b() {
        return this.f23267b;
    }

    public long c() {
        return this.f23266a;
    }

    public long d() {
        return this.f23268c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StartupTime)) {
            return false;
        }
        StartupTime startupTime = (StartupTime) obj;
        return this.f23266a == startupTime.c() && this.f23267b == startupTime.b() && this.f23268c == startupTime.d();
    }

    public int hashCode() {
        long j2 = this.f23266a;
        long j3 = this.f23267b;
        long j4 = this.f23268c;
        return ((int) ((j4 >>> 32) ^ j4)) ^ ((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f23266a + ", elapsedRealtime=" + this.f23267b + ", uptimeMillis=" + this.f23268c + "}";
    }
}
