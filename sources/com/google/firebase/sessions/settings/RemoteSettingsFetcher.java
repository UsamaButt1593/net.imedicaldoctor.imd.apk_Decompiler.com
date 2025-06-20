package com.google.firebase.sessions.settings;

import android.net.Uri;
import com.google.firebase.sessions.ApplicationInfo;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJo\u0010\u0016\u001a\u00020\u00122\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r2\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000f2\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000fH@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettingsFetcher;", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "Lcom/google/firebase/sessions/ApplicationInfo;", "appInfo", "Lkotlin/coroutines/CoroutineContext;", "blockingDispatcher", "", "baseUrl", "<init>", "(Lcom/google/firebase/sessions/ApplicationInfo;Lkotlin/coroutines/CoroutineContext;Ljava/lang/String;)V", "Ljava/net/URL;", "c", "()Ljava/net/URL;", "", "headerOptions", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "Lkotlin/coroutines/Continuation;", "", "", "onSuccess", "onFailure", "a", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/firebase/sessions/ApplicationInfo;", "b", "Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/String;", "d", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class RemoteSettingsFetcher implements CrashlyticsSettingsFetcher {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f25161d = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final String f25162e = "firebase-settings.crashlytics.com";
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final String f25163f = "android";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ApplicationInfo f25164a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineContext f25165b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f25166c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettingsFetcher$Companion;", "", "()V", "FIREBASE_PLATFORM", "", "FIREBASE_SESSIONS_BASE_URL_STRING", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RemoteSettingsFetcher(@NotNull ApplicationInfo applicationInfo, @NotNull CoroutineContext coroutineContext, @NotNull String str) {
        Intrinsics.p(applicationInfo, "appInfo");
        Intrinsics.p(coroutineContext, "blockingDispatcher");
        Intrinsics.p(str, "baseUrl");
        this.f25164a = applicationInfo;
        this.f25165b = coroutineContext;
        this.f25166c = str;
    }

    /* access modifiers changed from: private */
    public final URL c() {
        return new URL(new Uri.Builder().scheme("https").authority(this.f25166c).appendPath("spi").appendPath("v2").appendPath("platforms").appendPath(f25163f).appendPath("gmp").appendPath(this.f25164a.j()).appendPath("settings").appendQueryParameter("build_version", this.f25164a.i().i()).appendQueryParameter("display_version", this.f25164a.i().n()).build().toString());
    }

    @Nullable
    public Object a(@NotNull Map<String, String> map, @NotNull Function2<? super JSONObject, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function22, @NotNull Continuation<? super Unit> continuation) {
        Object h2 = BuildersKt.h(this.f25165b, new RemoteSettingsFetcher$doConfigFetch$2(this, map, function2, function22, (Continuation<? super RemoteSettingsFetcher$doConfigFetch$2>) null), continuation);
        return h2 == IntrinsicsKt.l() ? h2 : Unit.f28779a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RemoteSettingsFetcher(ApplicationInfo applicationInfo, CoroutineContext coroutineContext, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(applicationInfo, coroutineContext, (i2 & 4) != 0 ? f25162e : str);
    }
}
