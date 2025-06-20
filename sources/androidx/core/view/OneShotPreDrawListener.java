package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;

public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    private ViewTreeObserver X;
    private final Runnable Y;
    private final View s;

    private OneShotPreDrawListener(View view, Runnable runnable) {
        this.s = view;
        this.X = view.getViewTreeObserver();
        this.Y = runnable;
    }

    @NonNull
    public static OneShotPreDrawListener a(@NonNull View view, @NonNull Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
            view.addOnAttachStateChangeListener(oneShotPreDrawListener);
            return oneShotPreDrawListener;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public void b() {
        (this.X.isAlive() ? this.X : this.s.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.s.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.Y.run();
        return true;
    }

    public void onViewAttachedToWindow(@NonNull View view) {
        this.X = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(@NonNull View view) {
        b();
    }
}
