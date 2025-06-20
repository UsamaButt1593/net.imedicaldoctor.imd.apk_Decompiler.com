package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* renamed from: androidx.core.view.y  reason: case insensitive filesystem */
public final /* synthetic */ class C0133y implements Runnable {
    public final /* synthetic */ View s;

    public /* synthetic */ C0133y(View view) {
        this.s = view;
    }

    public final void run() {
        ((InputMethodManager) this.s.getContext().getSystemService("input_method")).showSoftInput(this.s, 0);
    }
}
