package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ Provider X;
    public final /* synthetic */ OptionalProvider s;

    public /* synthetic */ l(OptionalProvider optionalProvider, Provider provider) {
        this.s = optionalProvider;
        this.X = provider;
    }

    public final void run() {
        this.s.j(this.X);
    }
}
