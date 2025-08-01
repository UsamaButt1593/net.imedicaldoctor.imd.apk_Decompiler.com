package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;

@Module
public abstract class TimeModule {
    @Provides
    @WallTime
    static Clock a() {
        return new WallTimeClock();
    }

    @Provides
    @Monotonic
    static Clock b() {
        return new UptimeClock();
    }
}
