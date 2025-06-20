package com.google.firebase.concurrent;

/* renamed from: com.google.firebase.concurrent.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0483a implements Runnable {
    public final /* synthetic */ Runnable X;
    public final /* synthetic */ CustomThreadFactory s;

    public /* synthetic */ C0483a(CustomThreadFactory customThreadFactory, Runnable runnable) {
        this.s = customThreadFactory;
        this.X = runnable;
    }

    public final void run() {
        this.s.b(this.X);
    }
}
