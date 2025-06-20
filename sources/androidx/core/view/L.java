package androidx.core.view;

import kotlin.jvm.functions.Function0;

public final /* synthetic */ class L implements Runnable {
    public final /* synthetic */ Function0 s;

    public /* synthetic */ L(Function0 function0) {
        this.s = function0;
    }

    public final void run() {
        ViewKt.v(this.s);
    }
}
