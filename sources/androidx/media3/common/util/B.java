package androidx.media3.common.util;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class B implements ThreadFactory {
    public final /* synthetic */ String s;

    public /* synthetic */ B(String str) {
        this.s = str;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.s1(this.s, runnable);
    }
}
