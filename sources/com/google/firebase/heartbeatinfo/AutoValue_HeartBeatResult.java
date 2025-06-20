package com.google.firebase.heartbeatinfo;

import java.util.List;

final class AutoValue_HeartBeatResult extends HeartBeatResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f24378a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f24379b;

    AutoValue_HeartBeatResult(String str, List<String> list) {
        if (str != null) {
            this.f24378a = str;
            if (list != null) {
                this.f24379b = list;
                return;
            }
            throw new NullPointerException("Null usedDates");
        }
        throw new NullPointerException("Null userAgent");
    }

    public List<String> b() {
        return this.f24379b;
    }

    public String c() {
        return this.f24378a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeartBeatResult)) {
            return false;
        }
        HeartBeatResult heartBeatResult = (HeartBeatResult) obj;
        return this.f24378a.equals(heartBeatResult.c()) && this.f24379b.equals(heartBeatResult.b());
    }

    public int hashCode() {
        return ((this.f24378a.hashCode() ^ 1000003) * 1000003) ^ this.f24379b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f24378a + ", usedDates=" + this.f24379b + "}";
    }
}
