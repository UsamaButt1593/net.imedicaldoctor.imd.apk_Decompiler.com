package com.google.android.material.motion;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.BackEventCompat;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.Objects;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialBackOrchestrator {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final BackCallbackDelegate f21605a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final MaterialBackHandler f21606b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final View f21607c;

    @RequiresApi(33)
    private static class Api33BackCallbackDelegate implements BackCallbackDelegate {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private OnBackInvokedCallback f21608a;

        private Api33BackCallbackDelegate() {
        }

        @DoNotInline
        public void a(@NonNull MaterialBackHandler materialBackHandler, @NonNull View view, boolean z) {
            OnBackInvokedDispatcher a2;
            if (this.f21608a == null && (a2 = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback c2 = c(materialBackHandler);
                this.f21608a = c2;
                a2.registerOnBackInvokedCallback(z ? 1000000 : 0, c2);
            }
        }

        @DoNotInline
        public void b(@NonNull View view) {
            OnBackInvokedDispatcher a2 = view.findOnBackInvokedDispatcher();
            if (a2 != null) {
                a2.unregisterOnBackInvokedCallback(this.f21608a);
                this.f21608a = null;
            }
        }

        /* access modifiers changed from: package-private */
        public OnBackInvokedCallback c(@NonNull MaterialBackHandler materialBackHandler) {
            Objects.requireNonNull(materialBackHandler);
            return new b(materialBackHandler);
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return this.f21608a != null;
        }
    }

    @RequiresApi(34)
    private static class Api34BackCallbackDelegate extends Api33BackCallbackDelegate {
        private Api34BackCallbackDelegate() {
            super();
        }

        /* access modifiers changed from: package-private */
        public OnBackInvokedCallback c(@NonNull final MaterialBackHandler materialBackHandler) {
            return new OnBackAnimationCallback() {
                public void onBackCancelled() {
                    if (Api34BackCallbackDelegate.this.d()) {
                        materialBackHandler.g();
                    }
                }

                public void onBackInvoked() {
                    materialBackHandler.e();
                }

                public void onBackProgressed(@NonNull BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.d()) {
                        materialBackHandler.d(new BackEventCompat(backEvent));
                    }
                }

                public void onBackStarted(@NonNull BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.d()) {
                        materialBackHandler.c(new BackEventCompat(backEvent));
                    }
                }
            };
        }
    }

    private interface BackCallbackDelegate {
        void a(@NonNull MaterialBackHandler materialBackHandler, @NonNull View view, boolean z);

        void b(@NonNull View view);
    }

    public <T extends View & MaterialBackHandler> MaterialBackOrchestrator(@NonNull T t) {
        this((MaterialBackHandler) t, t);
    }

    @Nullable
    private static BackCallbackDelegate a() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            return new Api34BackCallbackDelegate();
        }
        if (i2 >= 33) {
            return new Api33BackCallbackDelegate();
        }
        return null;
    }

    private void d(boolean z) {
        BackCallbackDelegate backCallbackDelegate = this.f21605a;
        if (backCallbackDelegate != null) {
            backCallbackDelegate.a(this.f21606b, this.f21607c, z);
        }
    }

    public boolean b() {
        return this.f21605a != null;
    }

    public void c() {
        d(false);
    }

    public void e() {
        d(true);
    }

    public void f() {
        BackCallbackDelegate backCallbackDelegate = this.f21605a;
        if (backCallbackDelegate != null) {
            backCallbackDelegate.b(this.f21607c);
        }
    }

    public MaterialBackOrchestrator(@NonNull MaterialBackHandler materialBackHandler, @NonNull View view) {
        this.f21605a = a();
        this.f21606b = materialBackHandler;
        this.f21607c = view;
    }
}
