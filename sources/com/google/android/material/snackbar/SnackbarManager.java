package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

class SnackbarManager {

    /* renamed from: e  reason: collision with root package name */
    static final int f21968e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final int f21969f = 1500;

    /* renamed from: g  reason: collision with root package name */
    private static final int f21970g = 2750;

    /* renamed from: h  reason: collision with root package name */
    private static SnackbarManager f21971h;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Object f21972a = new Object();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Handler f21973b = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager.this.d((SnackbarRecord) message.obj);
            return true;
        }
    });
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private SnackbarRecord f21974c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private SnackbarRecord f21975d;

    interface Callback {
        void a();

        void b(int i2);
    }

    private static class SnackbarRecord {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<Callback> f21976a;

        /* renamed from: b  reason: collision with root package name */
        int f21977b;

        /* renamed from: c  reason: collision with root package name */
        boolean f21978c;

        SnackbarRecord(int i2, Callback callback) {
            this.f21976a = new WeakReference<>(callback);
            this.f21977b = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean a(@Nullable Callback callback) {
            return callback != null && this.f21976a.get() == callback;
        }
    }

    private SnackbarManager() {
    }

    private boolean a(@NonNull SnackbarRecord snackbarRecord, int i2) {
        Callback callback = snackbarRecord.f21976a.get();
        if (callback == null) {
            return false;
        }
        this.f21973b.removeCallbacksAndMessages(snackbarRecord);
        callback.b(i2);
        return true;
    }

    static SnackbarManager c() {
        if (f21971h == null) {
            f21971h = new SnackbarManager();
        }
        return f21971h;
    }

    private boolean g(Callback callback) {
        SnackbarRecord snackbarRecord = this.f21974c;
        return snackbarRecord != null && snackbarRecord.a(callback);
    }

    private boolean h(Callback callback) {
        SnackbarRecord snackbarRecord = this.f21975d;
        return snackbarRecord != null && snackbarRecord.a(callback);
    }

    private void m(@NonNull SnackbarRecord snackbarRecord) {
        int i2 = snackbarRecord.f21977b;
        if (i2 != -2) {
            if (i2 <= 0) {
                i2 = i2 == -1 ? 1500 : f21970g;
            }
            this.f21973b.removeCallbacksAndMessages(snackbarRecord);
            Handler handler = this.f21973b;
            handler.sendMessageDelayed(Message.obtain(handler, 0, snackbarRecord), (long) i2);
        }
    }

    private void o() {
        SnackbarRecord snackbarRecord = this.f21975d;
        if (snackbarRecord != null) {
            this.f21974c = snackbarRecord;
            this.f21975d = null;
            Callback callback = snackbarRecord.f21976a.get();
            if (callback != null) {
                callback.a();
            } else {
                this.f21974c = null;
            }
        }
    }

    public void b(Callback callback, int i2) {
        SnackbarRecord snackbarRecord;
        synchronized (this.f21972a) {
            try {
                if (g(callback)) {
                    snackbarRecord = this.f21974c;
                } else if (h(callback)) {
                    snackbarRecord = this.f21975d;
                }
                a(snackbarRecord, i2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(@NonNull SnackbarRecord snackbarRecord) {
        synchronized (this.f21972a) {
            try {
                if (this.f21974c != snackbarRecord) {
                    if (this.f21975d == snackbarRecord) {
                    }
                }
                a(snackbarRecord, 2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean e(Callback callback) {
        boolean g2;
        synchronized (this.f21972a) {
            g2 = g(callback);
        }
        return g2;
    }

    public boolean f(Callback callback) {
        boolean z;
        synchronized (this.f21972a) {
            try {
                if (!g(callback)) {
                    if (!h(callback)) {
                        z = false;
                    }
                }
                z = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void i(Callback callback) {
        synchronized (this.f21972a) {
            try {
                if (g(callback)) {
                    this.f21974c = null;
                    if (this.f21975d != null) {
                        o();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j(Callback callback) {
        synchronized (this.f21972a) {
            try {
                if (g(callback)) {
                    m(this.f21974c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(Callback callback) {
        synchronized (this.f21972a) {
            try {
                if (g(callback)) {
                    SnackbarRecord snackbarRecord = this.f21974c;
                    if (!snackbarRecord.f21978c) {
                        snackbarRecord.f21978c = true;
                        this.f21973b.removeCallbacksAndMessages(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void l(Callback callback) {
        synchronized (this.f21972a) {
            try {
                if (g(callback)) {
                    SnackbarRecord snackbarRecord = this.f21974c;
                    if (snackbarRecord.f21978c) {
                        snackbarRecord.f21978c = false;
                        m(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n(int i2, Callback callback) {
        synchronized (this.f21972a) {
            try {
                if (g(callback)) {
                    SnackbarRecord snackbarRecord = this.f21974c;
                    snackbarRecord.f21977b = i2;
                    this.f21973b.removeCallbacksAndMessages(snackbarRecord);
                    m(this.f21974c);
                    return;
                }
                if (h(callback)) {
                    this.f21975d.f21977b = i2;
                } else {
                    this.f21975d = new SnackbarRecord(i2, callback);
                }
                SnackbarRecord snackbarRecord2 = this.f21974c;
                if (snackbarRecord2 == null || !a(snackbarRecord2, 4)) {
                    this.f21974c = null;
                    o();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
