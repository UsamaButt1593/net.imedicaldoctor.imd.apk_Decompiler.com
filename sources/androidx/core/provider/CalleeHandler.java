package androidx.core.provider;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

class CalleeHandler {
    private CalleeHandler() {
    }

    @NonNull
    static Handler a() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}
