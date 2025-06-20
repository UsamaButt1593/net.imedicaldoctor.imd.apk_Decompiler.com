package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;

public final class PreloadTarget<Z> extends CustomTarget<Z> {
    private static final int X2 = 1;
    private static final Handler Y2 = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((PreloadTarget) message.obj).f();
            return true;
        }
    });
    private final RequestManager Z;

    private PreloadTarget(RequestManager requestManager, int i2, int i3) {
        super(i2, i3);
        this.Z = requestManager;
    }

    public static <Z> PreloadTarget<Z> g(RequestManager requestManager, int i2, int i3) {
        return new PreloadTarget<>(requestManager, i2, i3);
    }

    public void e(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        Y2.obtainMessage(1, this).sendToTarget();
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.Z.C(this);
    }

    public void r(@Nullable Drawable drawable) {
    }
}
