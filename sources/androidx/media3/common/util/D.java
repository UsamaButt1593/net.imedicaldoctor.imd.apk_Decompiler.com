package androidx.media3.common.util;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class D implements ThreadFactory {
    public final /* synthetic */ String s;

    public /* synthetic */ D(String str) {
        this.s = str;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.t1(this.s, runnable);
    }
}
