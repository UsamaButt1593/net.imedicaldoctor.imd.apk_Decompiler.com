package androidx.constraintlayout.motion.widget;

import android.view.View;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ View[] X;
    public final /* synthetic */ ViewTransition s;

    public /* synthetic */ a(ViewTransition viewTransition, View[] viewArr) {
        this.s = viewTransition;
        this.X = viewArr;
    }

    public final void run() {
        this.s.l(this.X);
    }
}
