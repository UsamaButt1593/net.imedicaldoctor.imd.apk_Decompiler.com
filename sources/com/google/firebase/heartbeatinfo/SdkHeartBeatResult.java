package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SdkHeartBeatResult implements Comparable<SdkHeartBeatResult> {
    public static SdkHeartBeatResult b(String str, long j2) {
        return new AutoValue_SdkHeartBeatResult(str, j2);
    }

    /* renamed from: a */
    public int compareTo(SdkHeartBeatResult sdkHeartBeatResult) {
        return c() < sdkHeartBeatResult.c() ? -1 : 1;
    }

    public abstract long c();

    public abstract String e();
}
