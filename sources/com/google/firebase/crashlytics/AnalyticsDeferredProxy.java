package com.google.firebase.crashlytics;

import android.os.Bundle;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AnalyticsDeferredProxy {

    /* renamed from: a  reason: collision with root package name */
    private final Deferred<AnalyticsConnector> f23464a;

    /* renamed from: b  reason: collision with root package name */
    private volatile AnalyticsEventLogger f23465b;

    /* renamed from: c  reason: collision with root package name */
    private volatile BreadcrumbSource f23466c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private final List<BreadcrumbHandler> f23467d;

    public AnalyticsDeferredProxy(Deferred<AnalyticsConnector> deferred) {
        this(deferred, new DisabledBreadcrumbSource(), new UnavailableAnalyticsEventLogger());
    }

    private void f() {
        this.f23464a.a(new c(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(String str, Bundle bundle) {
        this.f23465b.a(str, bundle);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(BreadcrumbHandler breadcrumbHandler) {
        synchronized (this) {
            try {
                if (this.f23466c instanceof DisabledBreadcrumbSource) {
                    this.f23467d.add(breadcrumbHandler);
                }
                this.f23466c.a(breadcrumbHandler);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(Provider provider) {
        Logger.f().b("AnalyticsConnector now available.");
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) provider.get();
        CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger(analyticsConnector);
        CrashlyticsAnalyticsListener crashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
        if (j(analyticsConnector, crashlyticsAnalyticsListener) != null) {
            Logger.f().b("Registered Firebase Analytics listener.");
            BreadcrumbAnalyticsEventReceiver breadcrumbAnalyticsEventReceiver = new BreadcrumbAnalyticsEventReceiver();
            BlockingAnalyticsEventLogger blockingAnalyticsEventLogger = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger, 500, TimeUnit.MILLISECONDS);
            synchronized (this) {
                try {
                    for (BreadcrumbHandler a2 : this.f23467d) {
                        breadcrumbAnalyticsEventReceiver.a(a2);
                    }
                    crashlyticsAnalyticsListener.d(breadcrumbAnalyticsEventReceiver);
                    crashlyticsAnalyticsListener.e(blockingAnalyticsEventLogger);
                    this.f23466c = breadcrumbAnalyticsEventReceiver;
                    this.f23465b = blockingAnalyticsEventLogger;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        Logger.f().m("Could not register Firebase Analytics listener; a listener is already registered.");
    }

    @DeferredApi
    private static AnalyticsConnector.AnalyticsConnectorHandle j(@NonNull AnalyticsConnector analyticsConnector, @NonNull CrashlyticsAnalyticsListener crashlyticsAnalyticsListener) {
        AnalyticsConnector.AnalyticsConnectorHandle h2 = analyticsConnector.h("clx", crashlyticsAnalyticsListener);
        if (h2 == null) {
            Logger.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            h2 = analyticsConnector.h("crash", crashlyticsAnalyticsListener);
            if (h2 != null) {
                Logger.f().m("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return h2;
    }

    public AnalyticsEventLogger d() {
        return new b(this);
    }

    public BreadcrumbSource e() {
        return new a(this);
    }

    public AnalyticsDeferredProxy(Deferred<AnalyticsConnector> deferred, @NonNull BreadcrumbSource breadcrumbSource, @NonNull AnalyticsEventLogger analyticsEventLogger) {
        this.f23464a = deferred;
        this.f23466c = breadcrumbSource;
        this.f23467d = new ArrayList();
        this.f23465b = analyticsEventLogger;
        f();
    }
}
