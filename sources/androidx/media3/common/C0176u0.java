package androidx.media3.common;

import java.util.concurrent.Executor;

/* renamed from: androidx.media3.common.u0  reason: case insensitive filesystem */
public final /* synthetic */ class C0176u0 implements Executor {
    public final /* synthetic */ SimpleBasePlayer s;

    public /* synthetic */ C0176u0(SimpleBasePlayer simpleBasePlayer) {
        this.s = simpleBasePlayer;
    }

    public final void execute(Runnable runnable) {
        this.s.f6(runnable);
    }
}
