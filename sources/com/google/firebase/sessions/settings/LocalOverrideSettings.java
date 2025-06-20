package com.google.firebase.sessions.settings;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.sessions.settings.SettingsProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u0012\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u000eR\u001f\u0010\u0013\u001a\u0004\u0018\u00010\u00108VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/google/firebase/sessions/settings/LocalOverrideSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "a", "Landroid/os/Bundle;", "f", "()V", "metadata", "", "()Ljava/lang/Boolean;", "sessionEnabled", "Lkotlin/time/Duration;", "b", "()Lkotlin/time/Duration;", "sessionRestartTimeout", "", "d", "()Ljava/lang/Double;", "samplingRate", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class LocalOverrideSettings implements SettingsProvider {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Companion f25147b = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final String f25148c = "firebase_sessions_enabled";
    @NotNull
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final String f25149d = "firebase_sessions_sessions_restart_timeout";
    @NotNull
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static final String f25150e = "firebase_sessions_sampling_rate";

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f25151a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/settings/LocalOverrideSettings$Companion;", "", "()V", "SAMPLING_RATE", "", "SESSIONS_ENABLED", "SESSION_RESTART_TIMEOUT", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LocalOverrideSettings(@NotNull Context context) {
        Intrinsics.p(context, "context");
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        this.f25151a = bundle == null ? Bundle.EMPTY : bundle;
    }

    private static /* synthetic */ void f() {
    }

    @Nullable
    public Boolean a() {
        if (this.f25151a.containsKey(f25148c)) {
            return Boolean.valueOf(this.f25151a.getBoolean(f25148c));
        }
        return null;
    }

    @Nullable
    public Duration b() {
        if (this.f25151a.containsKey(f25149d)) {
            return Duration.g(DurationKt.m0(this.f25151a.getInt(f25149d), DurationUnit.SECONDS));
        }
        return null;
    }

    public boolean c() {
        return SettingsProvider.DefaultImpls.a(this);
    }

    @Nullable
    public Double d() {
        if (this.f25151a.containsKey(f25150e)) {
            return Double.valueOf(this.f25151a.getDouble(f25150e));
        }
        return null;
    }

    @Nullable
    public Object e(@NotNull Continuation<? super Unit> continuation) {
        return SettingsProvider.DefaultImpls.b(this, continuation);
    }
}
