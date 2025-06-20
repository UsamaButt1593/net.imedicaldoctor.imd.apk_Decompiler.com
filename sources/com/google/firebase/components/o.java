package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map;

public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ Event X;
    public final /* synthetic */ Map.Entry s;

    public /* synthetic */ o(Map.Entry entry, Event event) {
        this.s = entry;
        this.X = event;
    }

    public final void run() {
        ((EventHandler) this.s.getKey()).a(this.X);
    }
}
