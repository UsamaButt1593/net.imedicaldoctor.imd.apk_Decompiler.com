package com.google.android.datatransport.runtime.time;

import android.os.SystemClock;

public class UptimeClock implements Clock {
    public long a() {
        return SystemClock.elapsedRealtime();
    }
}
