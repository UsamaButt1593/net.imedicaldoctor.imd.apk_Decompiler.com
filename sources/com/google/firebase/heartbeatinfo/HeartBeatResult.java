package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
public abstract class HeartBeatResult {
    public static HeartBeatResult a(String str, List<String> list) {
        return new AutoValue_HeartBeatResult(str, list);
    }

    public abstract List<String> b();

    public abstract String c();
}
