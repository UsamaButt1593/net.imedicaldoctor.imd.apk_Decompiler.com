package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;

class CallbackWithHandler {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FontsContractCompat.FontRequestCallback f6084a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Handler f6085b;

    CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback fontRequestCallback) {
        this.f6084a = fontRequestCallback;
        this.f6085b = CalleeHandler.a();
    }

    private void a(final int i2) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.f6084a;
        this.f6085b.post(new Runnable() {
            public void run() {
                fontRequestCallback.a(i2);
            }
        });
    }

    private void c(@NonNull final Typeface typeface) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.f6084a;
        this.f6085b.post(new Runnable() {
            public void run() {
                fontRequestCallback.b(typeface);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.a()) {
            c(typefaceResult.f6101a);
        } else {
            a(typefaceResult.f6102b);
        }
    }

    CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        this.f6084a = fontRequestCallback;
        this.f6085b = handler;
    }
}
