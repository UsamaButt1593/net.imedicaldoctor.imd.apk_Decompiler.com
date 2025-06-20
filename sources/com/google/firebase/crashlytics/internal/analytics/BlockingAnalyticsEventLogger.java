package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {

    /* renamed from: g  reason: collision with root package name */
    static final String f23511g = "_ae";

    /* renamed from: a  reason: collision with root package name */
    private final CrashlyticsOriginAnalyticsEventLogger f23512a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23513b;

    /* renamed from: c  reason: collision with root package name */
    private final TimeUnit f23514c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f23515d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private CountDownLatch f23516e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23517f = false;

    public BlockingAnalyticsEventLogger(@NonNull CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i2, TimeUnit timeUnit) {
        this.f23512a = crashlyticsOriginAnalyticsEventLogger;
        this.f23513b = i2;
        this.f23514c = timeUnit;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        com.google.firebase.crashlytics.internal.Logger.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0061 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@androidx.annotation.NonNull java.lang.String r6, @androidx.annotation.Nullable android.os.Bundle r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f23515d
            monitor-enter(r0)
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.f()     // Catch:{ all -> 0x0055 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r2.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r3 = "Logging event "
            r2.append(r3)     // Catch:{ all -> 0x0055 }
            r2.append(r6)     // Catch:{ all -> 0x0055 }
            java.lang.String r3 = " to Firebase Analytics with params "
            r2.append(r3)     // Catch:{ all -> 0x0055 }
            r2.append(r7)     // Catch:{ all -> 0x0055 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0055 }
            r1.k(r2)     // Catch:{ all -> 0x0055 }
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x0055 }
            r2 = 1
            r1.<init>(r2)     // Catch:{ all -> 0x0055 }
            r5.f23516e = r1     // Catch:{ all -> 0x0055 }
            r1 = 0
            r5.f23517f = r1     // Catch:{ all -> 0x0055 }
            com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger r1 = r5.f23512a     // Catch:{ all -> 0x0055 }
            r1.a(r6, r7)     // Catch:{ all -> 0x0055 }
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.f()     // Catch:{ all -> 0x0055 }
            java.lang.String r7 = "Awaiting app exception callback from Analytics..."
            r6.k(r7)     // Catch:{ all -> 0x0055 }
            java.util.concurrent.CountDownLatch r6 = r5.f23516e     // Catch:{ InterruptedException -> 0x0061 }
            int r7 = r5.f23513b     // Catch:{ InterruptedException -> 0x0061 }
            long r3 = (long) r7     // Catch:{ InterruptedException -> 0x0061 }
            java.util.concurrent.TimeUnit r7 = r5.f23514c     // Catch:{ InterruptedException -> 0x0061 }
            boolean r6 = r6.await(r3, r7)     // Catch:{ InterruptedException -> 0x0061 }
            if (r6 == 0) goto L_0x0057
            r5.f23517f = r2     // Catch:{ InterruptedException -> 0x0061 }
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.f()     // Catch:{ InterruptedException -> 0x0061 }
            java.lang.String r7 = "App exception callback received from Analytics listener."
            r6.k(r7)     // Catch:{ InterruptedException -> 0x0061 }
            goto L_0x006a
        L_0x0055:
            r6 = move-exception
            goto L_0x006f
        L_0x0057:
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.f()     // Catch:{ InterruptedException -> 0x0061 }
            java.lang.String r7 = "Timeout exceeded while awaiting app exception callback from Analytics listener."
            r6.m(r7)     // Catch:{ InterruptedException -> 0x0061 }
            goto L_0x006a
        L_0x0061:
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.f()     // Catch:{ all -> 0x0055 }
            java.lang.String r7 = "Interrupted while awaiting app exception callback from Analytics listener."
            r6.d(r7)     // Catch:{ all -> 0x0055 }
        L_0x006a:
            r6 = 0
            r5.f23516e = r6     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x006f:
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger.a(java.lang.String, android.os.Bundle):void");
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f23517f;
    }

    public void y(@NonNull String str, @NonNull Bundle bundle) {
        CountDownLatch countDownLatch = this.f23516e;
        if (countDownLatch != null && f23511g.equals(str)) {
            countDownLatch.countDown();
        }
    }
}
