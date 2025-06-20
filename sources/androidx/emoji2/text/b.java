package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class b implements ThreadFactory {
    public final /* synthetic */ String s;

    public /* synthetic */ b(String str) {
        this.s = str;
    }

    public final Thread newThread(Runnable runnable) {
        return ConcurrencyHelpers.d(this.s, runnable);
    }
}
