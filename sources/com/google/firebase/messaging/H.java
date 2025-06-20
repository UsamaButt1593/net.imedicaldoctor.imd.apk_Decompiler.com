package com.google.firebase.messaging;

public final /* synthetic */ class H implements Runnable {
    public final /* synthetic */ SharedPreferencesQueue s;

    public /* synthetic */ H(SharedPreferencesQueue sharedPreferencesQueue) {
        this.s = sharedPreferencesQueue;
    }

    public final void run() {
        this.s.r();
    }
}
