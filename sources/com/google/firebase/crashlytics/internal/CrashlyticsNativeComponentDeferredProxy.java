package com.google.firebase.crashlytics.internal;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

public final class CrashlyticsNativeComponentDeferredProxy implements CrashlyticsNativeComponent {

    /* renamed from: c  reason: collision with root package name */
    private static final NativeSessionFileProvider f23491c = new MissingNativeSessionFileProvider();

    /* renamed from: a  reason: collision with root package name */
    private final Deferred<CrashlyticsNativeComponent> f23492a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<CrashlyticsNativeComponent> f23493b = new AtomicReference<>((Object) null);

    private static final class MissingNativeSessionFileProvider implements NativeSessionFileProvider {
        private MissingNativeSessionFileProvider() {
        }

        public File a() {
            return null;
        }

        public File b() {
            return null;
        }

        public File c() {
            return null;
        }

        public CrashlyticsReport.ApplicationExitInfo d() {
            return null;
        }

        public File e() {
            return null;
        }

        public File f() {
            return null;
        }

        public File g() {
            return null;
        }

        public File h() {
            return null;
        }
    }

    public CrashlyticsNativeComponentDeferredProxy(Deferred<CrashlyticsNativeComponent> deferred) {
        this.f23492a = deferred;
        deferred.a(new a(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(Provider provider) {
        Logger.f().b("Crashlytics native component now available.");
        this.f23493b.set((CrashlyticsNativeComponent) provider.get());
    }

    @NonNull
    public NativeSessionFileProvider a(@NonNull String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.f23493b.get();
        return crashlyticsNativeComponent == null ? f23491c : crashlyticsNativeComponent.a(str);
    }

    public boolean b() {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.f23493b.get();
        return crashlyticsNativeComponent != null && crashlyticsNativeComponent.b();
    }

    public void c(@NonNull String str, @NonNull String str2, long j2, @NonNull StaticSessionData staticSessionData) {
        Logger f2 = Logger.f();
        f2.k("Deferring native open session: " + str);
        this.f23492a.a(new b(str, str2, j2, staticSessionData));
    }

    public boolean d(@NonNull String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.f23493b.get();
        return crashlyticsNativeComponent != null && crashlyticsNativeComponent.d(str);
    }
}
