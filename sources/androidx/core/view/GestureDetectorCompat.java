package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Deprecated
public final class GestureDetectorCompat {

    /* renamed from: a  reason: collision with root package name */
    private final GestureDetector f6385a;

    public GestureDetectorCompat(@NonNull Context context, @NonNull GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    public boolean a() {
        return this.f6385a.isLongpressEnabled();
    }

    public boolean b(@NonNull MotionEvent motionEvent) {
        return this.f6385a.onTouchEvent(motionEvent);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void c(boolean z) {
        this.f6385a.setIsLongpressEnabled(z);
    }

    public void d(@Nullable GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f6385a.setOnDoubleTapListener(onDoubleTapListener);
    }

    public GestureDetectorCompat(@NonNull Context context, @NonNull GestureDetector.OnGestureListener onGestureListener, @Nullable Handler handler) {
        this.f6385a = new GestureDetector(context, onGestureListener, handler);
    }
}
