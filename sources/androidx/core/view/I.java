package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.ViewCompat;

public final /* synthetic */ class I implements View.OnUnhandledKeyEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewCompat.OnUnhandledKeyEventListenerCompat f6404a;

    public /* synthetic */ I(ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        this.f6404a = onUnhandledKeyEventListenerCompat;
    }

    public final boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
        return this.f6404a.onUnhandledKeyEvent(view, keyEvent);
    }
}
