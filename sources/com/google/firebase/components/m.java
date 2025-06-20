package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ Provider X;
    public final /* synthetic */ LazySet s;

    public /* synthetic */ m(LazySet lazySet, Provider provider) {
        this.s = lazySet;
        this.X = provider;
    }

    public final void run() {
        this.s.a(this.X);
    }
}
