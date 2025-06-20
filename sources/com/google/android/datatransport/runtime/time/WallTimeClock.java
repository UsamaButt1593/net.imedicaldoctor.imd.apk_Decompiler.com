package com.google.android.datatransport.runtime.time;

public class WallTimeClock implements Clock {
    public long a() {
        return System.currentTimeMillis();
    }
}
