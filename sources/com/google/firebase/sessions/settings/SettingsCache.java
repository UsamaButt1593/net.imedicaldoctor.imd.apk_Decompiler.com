package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 32\u00020\u0001:\u00014B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000f\u001a\u00020\b\"\u0004\b\u0000\u0010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001d\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0016H@ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u001d\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0019H@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001d\u0010&\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0019H@ø\u0001\u0000¢\u0006\u0004\b&\u0010$J\u001d\u0010)\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'H@ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u0013\u0010+\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b+\u0010,R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b0\u00101\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCache;", "", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "dataStore", "<init>", "(Landroidx/datastore/core/DataStore;)V", "preferences", "", "r", "(Landroidx/datastore/preferences/core/Preferences;)V", "T", "Landroidx/datastore/preferences/core/Preferences$Key;", "key", "value", "n", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "i", "()Z", "m", "()Ljava/lang/Boolean;", "", "l", "()Ljava/lang/Double;", "", "k", "()Ljava/lang/Integer;", "enabled", "t", "(Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rate", "o", "(Ljava/lang/Double;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeoutInSeconds", "s", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheDurationInSeconds", "p", "", "cacheUpdatedTime", "q", "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Landroidx/datastore/core/DataStore;", "Lcom/google/firebase/sessions/settings/SessionConfigs;", "b", "Lcom/google/firebase/sessions/settings/SessionConfigs;", "sessionConfigs", "c", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class SettingsCache {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Companion f25178c = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final String f25179d = "SettingsCache";
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final Preferences.Key<Boolean> f25180e = PreferencesKeys.a(LocalOverrideSettings.f25148c);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final Preferences.Key<Double> f25181f = PreferencesKeys.b(LocalOverrideSettings.f25150e);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public static final Preferences.Key<Integer> f25182g = PreferencesKeys.d("firebase_sessions_restart_timeout");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public static final Preferences.Key<Integer> f25183h = PreferencesKeys.d("firebase_sessions_cache_duration");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public static final Preferences.Key<Long> f25184i = PreferencesKeys.e("firebase_sessions_cache_updated_time");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final DataStore<Preferences> f25185a;

    /* renamed from: b  reason: collision with root package name */
    private SessionConfigs f25186b;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.google.firebase.sessions.settings.SettingsCache$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object X2;
        int Y2;
        final /* synthetic */ SettingsCache Z2;

        {
            this.Z2 = r1;
        }

        @Nullable
        public final Object D(@NotNull Object obj) {
            SettingsCache settingsCache;
            Object l2 = IntrinsicsKt.l();
            int i2 = this.Y2;
            if (i2 == 0) {
                ResultKt.n(obj);
                SettingsCache settingsCache2 = this.Z2;
                Flow data = settingsCache2.f25185a.getData();
                this.X2 = settingsCache2;
                this.Y2 = 1;
                Object t0 = FlowKt.t0(data, this);
                if (t0 == l2) {
                    return l2;
                }
                settingsCache = settingsCache2;
                obj = t0;
            } else if (i2 == 1) {
                settingsCache = (SettingsCache) this.X2;
                ResultKt.n(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            settingsCache.r(((Preferences) obj).e());
            return Unit.f28779a;
        }

        @Nullable
        /* renamed from: U */
        public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) v(coroutineScope, continuation)).D(Unit.f28779a);
        }

        @NotNull
        public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.Z2, continuation);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\tR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00158\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCache$Companion;", "", "<init>", "()V", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "SESSIONS_ENABLED", "Landroidx/datastore/preferences/core/Preferences$Key;", "e", "()Landroidx/datastore/preferences/core/Preferences$Key;", "", "SAMPLING_RATE", "d", "", "RESTART_TIMEOUT_SECONDS", "c", "CACHE_DURATION_SECONDS", "a", "", "CACHE_UPDATED_TIME", "b", "", "TAG", "Ljava/lang/String;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    private static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Preferences.Key<Integer> a() {
            return SettingsCache.f25183h;
        }

        @NotNull
        public final Preferences.Key<Long> b() {
            return SettingsCache.f25184i;
        }

        @NotNull
        public final Preferences.Key<Integer> c() {
            return SettingsCache.f25182g;
        }

        @NotNull
        public final Preferences.Key<Double> d() {
            return SettingsCache.f25181f;
        }

        @NotNull
        public final Preferences.Key<Boolean> e() {
            return SettingsCache.f25180e;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SettingsCache(@NotNull DataStore<Preferences> dataStore) {
        Intrinsics.p(dataStore, "dataStore");
        this.f25185a = dataStore;
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object n(androidx.datastore.preferences.core.Preferences.Key<T> r6, T r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = (com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1) r0
            int r1 = r0.Y2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Y2 = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.Z
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Y2
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            kotlin.ResultKt.n(r8)     // Catch:{ IOException -> 0x0029 }
            goto L_0x005d
        L_0x0029:
            r6 = move-exception
            goto L_0x0047
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            kotlin.ResultKt.n(r8)
            androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> r8 = r5.f25185a     // Catch:{ IOException -> 0x0029 }
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2     // Catch:{ IOException -> 0x0029 }
            r4 = 0
            r2.<init>(r7, r6, r5, r4)     // Catch:{ IOException -> 0x0029 }
            r0.Y2 = r3     // Catch:{ IOException -> 0x0029 }
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.a(r8, r2, r0)     // Catch:{ IOException -> 0x0029 }
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x0047:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Failed to update cache config value: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "SettingsCache"
            android.util.Log.w(r7, r6)
        L_0x005d:
            kotlin.Unit r6 = kotlin.Unit.f28779a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.n(androidx.datastore.preferences.core.Preferences$Key, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void r(Preferences preferences) {
        this.f25186b = new SessionConfigs((Boolean) preferences.c(f25180e), (Double) preferences.c(f25181f), (Integer) preferences.c(f25182g), (Integer) preferences.c(f25183h), (Long) preferences.c(f25184i));
    }

    public final boolean i() {
        SessionConfigs sessionConfigs = this.f25186b;
        SessionConfigs sessionConfigs2 = null;
        if (sessionConfigs == null) {
            Intrinsics.S("sessionConfigs");
            sessionConfigs = null;
        }
        Long i2 = sessionConfigs.i();
        SessionConfigs sessionConfigs3 = this.f25186b;
        if (sessionConfigs3 == null) {
            Intrinsics.S("sessionConfigs");
        } else {
            sessionConfigs2 = sessionConfigs3;
        }
        Integer h2 = sessionConfigs2.h();
        return i2 == null || h2 == null || (System.currentTimeMillis() - i2.longValue()) / ((long) 1000) >= ((long) h2.intValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @androidx.annotation.VisibleForTesting
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1 r0 = (com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1) r0
            int r1 = r0.Y2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Y2 = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.Z
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Y2
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            kotlin.ResultKt.n(r6)     // Catch:{ IOException -> 0x0029 }
            goto L_0x005d
        L_0x0029:
            r6 = move-exception
            goto L_0x0047
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0033:
            kotlin.ResultKt.n(r6)
            androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> r6 = r5.f25185a     // Catch:{ IOException -> 0x0029 }
            com.google.firebase.sessions.settings.SettingsCache$removeConfigs$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$removeConfigs$2     // Catch:{ IOException -> 0x0029 }
            r4 = 0
            r2.<init>(r5, r4)     // Catch:{ IOException -> 0x0029 }
            r0.Y2 = r3     // Catch:{ IOException -> 0x0029 }
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.a(r6, r2, r0)     // Catch:{ IOException -> 0x0029 }
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x0047:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to remove config values: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "SettingsCache"
            android.util.Log.w(r0, r6)
        L_0x005d:
            kotlin.Unit r6 = kotlin.Unit.f28779a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.j(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Integer k() {
        SessionConfigs sessionConfigs = this.f25186b;
        if (sessionConfigs == null) {
            Intrinsics.S("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.k();
    }

    @Nullable
    public final Double l() {
        SessionConfigs sessionConfigs = this.f25186b;
        if (sessionConfigs == null) {
            Intrinsics.S("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.l();
    }

    @Nullable
    public final Boolean m() {
        SessionConfigs sessionConfigs = this.f25186b;
        if (sessionConfigs == null) {
            Intrinsics.S("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.j();
    }

    @Nullable
    public final Object o(@Nullable Double d2, @NotNull Continuation<? super Unit> continuation) {
        Object n2 = n(f25181f, d2, continuation);
        return n2 == IntrinsicsKt.l() ? n2 : Unit.f28779a;
    }

    @Nullable
    public final Object p(@Nullable Integer num, @NotNull Continuation<? super Unit> continuation) {
        Object n2 = n(f25183h, num, continuation);
        return n2 == IntrinsicsKt.l() ? n2 : Unit.f28779a;
    }

    @Nullable
    public final Object q(@Nullable Long l2, @NotNull Continuation<? super Unit> continuation) {
        Object n2 = n(f25184i, l2, continuation);
        return n2 == IntrinsicsKt.l() ? n2 : Unit.f28779a;
    }

    @Nullable
    public final Object s(@Nullable Integer num, @NotNull Continuation<? super Unit> continuation) {
        Object n2 = n(f25182g, num, continuation);
        return n2 == IntrinsicsKt.l() ? n2 : Unit.f28779a;
    }

    @Nullable
    public final Object t(@Nullable Boolean bool, @NotNull Continuation<? super Unit> continuation) {
        Object n2 = n(f25180e, bool, continuation);
        return n2 == IntrinsicsKt.l() ? n2 : Unit.f28779a;
    }
}
