package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final CrashListener f23635a;

    /* renamed from: b  reason: collision with root package name */
    private final SettingsProvider f23636b;

    /* renamed from: c  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f23637c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsNativeComponent f23638d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f23639e = new AtomicBoolean(false);

    interface CrashListener {
        void a(SettingsProvider settingsProvider, Thread thread, Throwable th);
    }

    public CrashlyticsUncaughtExceptionHandler(CrashListener crashListener, SettingsProvider settingsProvider, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, CrashlyticsNativeComponent crashlyticsNativeComponent) {
        this.f23635a = crashListener;
        this.f23636b = settingsProvider;
        this.f23637c = uncaughtExceptionHandler;
        this.f23638d = crashlyticsNativeComponent;
    }

    private boolean b(Thread thread, Throwable th) {
        if (thread == null) {
            Logger.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        } else if (th == null) {
            Logger.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        } else if (!this.f23638d.b()) {
            return true;
        } else {
            Logger.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f23639e.get();
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.f23639e.set(true);
        try {
            if (b(thread, th)) {
                this.f23635a.a(this.f23636b, thread, th);
            } else {
                Logger.f().b("Uncaught exception will not be recorded by Crashlytics.");
            }
        } catch (Exception e2) {
            Logger.f().e("An error occurred in the uncaught exception handler", e2);
        } catch (Throwable th2) {
            Logger.f().b("Completed exception processing. Invoking default exception handler.");
            this.f23637c.uncaughtException(thread, th);
            this.f23639e.set(false);
            throw th2;
        }
        Logger.f().b("Completed exception processing. Invoking default exception handler.");
        this.f23637c.uncaughtException(thread, th);
        this.f23639e.set(false);
    }
}
