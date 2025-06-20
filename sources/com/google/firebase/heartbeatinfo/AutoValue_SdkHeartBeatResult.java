package com.google.firebase.heartbeatinfo;

final class AutoValue_SdkHeartBeatResult extends SdkHeartBeatResult {
    private final long X;
    private final String s;

    AutoValue_SdkHeartBeatResult(String str, long j2) {
        if (str != null) {
            this.s = str;
            this.X = j2;
            return;
        }
        throw new NullPointerException("Null sdkName");
    }

    public long c() {
        return this.X;
    }

    public String e() {
        return this.s;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SdkHeartBeatResult)) {
            return false;
        }
        SdkHeartBeatResult sdkHeartBeatResult = (SdkHeartBeatResult) obj;
        return this.s.equals(sdkHeartBeatResult.e()) && this.X == sdkHeartBeatResult.c();
    }

    public int hashCode() {
        long j2 = this.X;
        return ((this.s.hashCode() ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "SdkHeartBeatResult{sdkName=" + this.s + ", millis=" + this.X + "}";
    }
}
