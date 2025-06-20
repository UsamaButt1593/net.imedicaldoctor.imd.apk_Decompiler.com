package com.google.firebase.heartbeatinfo;

import androidx.annotation.NonNull;

public interface HeartBeatInfo {

    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        
        private final int s;

        private HeartBeat(int i2) {
            this.s = i2;
        }

        public int b() {
            return this.s;
        }
    }

    @NonNull
    HeartBeat b(@NonNull String str);
}
