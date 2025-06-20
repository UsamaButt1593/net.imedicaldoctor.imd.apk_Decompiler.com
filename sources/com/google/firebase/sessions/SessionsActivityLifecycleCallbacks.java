package com.google.firebase.sessions;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ!\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\rR(\u0010\u001b\u001a\u00020\u00138\u0000@\u0000X\u000e¢\u0006\u0018\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/google/firebase/sessions/SessionsActivityLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "Landroid/app/Activity;", "activity", "", "onActivityResumed", "(Landroid/app/Activity;)V", "onActivityPaused", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "onActivityStopped", "onActivityDestroyed", "outState", "onActivitySaveInstanceState", "", "X", "Z", "a", "()Z", "d", "(Z)V", "b", "hasPendingForeground", "Lcom/google/firebase/sessions/SessionLifecycleClient;", "lifecycleClient", "Y", "Lcom/google/firebase/sessions/SessionLifecycleClient;", "c", "()Lcom/google/firebase/sessions/SessionLifecycleClient;", "e", "(Lcom/google/firebase/sessions/SessionLifecycleClient;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSessionsActivityLifecycleCallbacks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionsActivityLifecycleCallbacks.kt\ncom/google/firebase/sessions/SessionsActivityLifecycleCallbacks\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
public final class SessionsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private static boolean X;
    @Nullable
    private static SessionLifecycleClient Y;
    @NotNull
    public static final SessionsActivityLifecycleCallbacks s = new SessionsActivityLifecycleCallbacks();

    private SessionsActivityLifecycleCallbacks() {
    }

    @VisibleForTesting
    public static /* synthetic */ void b() {
    }

    public final boolean a() {
        return X;
    }

    @Nullable
    public final SessionLifecycleClient c() {
        return Y;
    }

    public final void d(boolean z) {
        X = z;
    }

    public final void e(@Nullable SessionLifecycleClient sessionLifecycleClient) {
        Y = sessionLifecycleClient;
        if (sessionLifecycleClient != null && X) {
            X = false;
            sessionLifecycleClient.k();
        }
    }

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.p(activity, "activity");
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.p(activity, "activity");
    }

    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.p(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = Y;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.h();
        }
    }

    public void onActivityResumed(@NotNull Activity activity) {
        Unit unit;
        Intrinsics.p(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = Y;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.k();
            unit = Unit.f28779a;
        } else {
            unit = null;
        }
        if (unit == null) {
            X = true;
        }
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        Intrinsics.p(activity, "activity");
        Intrinsics.p(bundle, "outState");
    }

    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.p(activity, "activity");
    }

    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.p(activity, "activity");
    }
}
