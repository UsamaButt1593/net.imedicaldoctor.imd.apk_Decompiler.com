package com.google.firebase.sessions;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.google.firebase.FirebaseApp;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJO\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\u001b8\u0000X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/google/firebase/sessions/SessionEvents;", "", "<init>", "()V", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "subscriber", "Lcom/google/firebase/sessions/DataCollectionState;", "e", "(Lcom/google/firebase/sessions/api/SessionSubscriber;)Lcom/google/firebase/sessions/DataCollectionState;", "Lcom/google/firebase/FirebaseApp;", "firebaseApp", "Lcom/google/firebase/sessions/SessionDetails;", "sessionDetails", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "sessionsSettings", "", "Lcom/google/firebase/sessions/api/SessionSubscriber$Name;", "subscribers", "", "firebaseInstallationId", "firebaseAuthenticationToken", "Lcom/google/firebase/sessions/SessionEvent;", "a", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/sessions/SessionDetails;Lcom/google/firebase/sessions/settings/SessionsSettings;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/google/firebase/sessions/SessionEvent;", "Lcom/google/firebase/sessions/ApplicationInfo;", "c", "(Lcom/google/firebase/FirebaseApp;)Lcom/google/firebase/sessions/ApplicationInfo;", "Lcom/google/firebase/encoders/DataEncoder;", "b", "Lcom/google/firebase/encoders/DataEncoder;", "d", "()Lcom/google/firebase/encoders/DataEncoder;", "SESSION_EVENT_ENCODER", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class SessionEvents {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final SessionEvents f25098a = new SessionEvents();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final DataEncoder f25099b;

    static {
        DataEncoder j2 = new JsonDataEncoderBuilder().k(AutoSessionEventEncoder.f25014b).l(true).j();
        Intrinsics.o(j2, "JsonDataEncoderBuilder()…lues(true)\n      .build()");
        f25099b = j2;
    }

    private SessionEvents() {
    }

    public static /* synthetic */ SessionEvent b(SessionEvents sessionEvents, FirebaseApp firebaseApp, SessionDetails sessionDetails, SessionsSettings sessionsSettings, Map map, String str, String str2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            map = MapsKt.z();
        }
        return sessionEvents.a(firebaseApp, sessionDetails, sessionsSettings, map, (i2 & 16) != 0 ? "" : str, (i2 & 32) != 0 ? "" : str2);
    }

    private final DataCollectionState e(SessionSubscriber sessionSubscriber) {
        if (sessionSubscriber == null) {
            return DataCollectionState.COLLECTION_SDK_NOT_INSTALLED;
        }
        return sessionSubscriber.a() ? DataCollectionState.COLLECTION_ENABLED : DataCollectionState.COLLECTION_DISABLED;
    }

    @NotNull
    public final SessionEvent a(@NotNull FirebaseApp firebaseApp, @NotNull SessionDetails sessionDetails, @NotNull SessionsSettings sessionsSettings, @NotNull Map<SessionSubscriber.Name, ? extends SessionSubscriber> map, @NotNull String str, @NotNull String str2) {
        Map<SessionSubscriber.Name, ? extends SessionSubscriber> map2 = map;
        Intrinsics.p(firebaseApp, "firebaseApp");
        Intrinsics.p(sessionDetails, "sessionDetails");
        Intrinsics.p(sessionsSettings, "sessionsSettings");
        Intrinsics.p(map2, "subscribers");
        Intrinsics.p(str, "firebaseInstallationId");
        Intrinsics.p(str2, "firebaseAuthenticationToken");
        return new SessionEvent(EventType.SESSION_START, new SessionInfo(sessionDetails.h(), sessionDetails.g(), sessionDetails.i(), sessionDetails.j(), new DataCollectionStatus(e((SessionSubscriber) map2.get(SessionSubscriber.Name.PERFORMANCE)), e((SessionSubscriber) map2.get(SessionSubscriber.Name.CRASHLYTICS)), sessionsSettings.b()), str, str2), c(firebaseApp));
    }

    @NotNull
    public final ApplicationInfo c(@NotNull FirebaseApp firebaseApp) {
        Intrinsics.p(firebaseApp, "firebaseApp");
        Context n2 = firebaseApp.n();
        Intrinsics.o(n2, "firebaseApp.applicationContext");
        String packageName = n2.getPackageName();
        PackageInfo packageInfo = n2.getPackageManager().getPackageInfo(packageName, 0);
        String valueOf = Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfo.getLongVersionCode()) : String.valueOf(packageInfo.versionCode);
        String j2 = firebaseApp.s().j();
        Intrinsics.o(j2, "firebaseApp.options.applicationId");
        String str = Build.MODEL;
        Intrinsics.o(str, "MODEL");
        String str2 = Build.VERSION.RELEASE;
        Intrinsics.o(str2, "RELEASE");
        LogEnvironment logEnvironment = LogEnvironment.LOG_ENVIRONMENT_PROD;
        Intrinsics.o(packageName, "packageName");
        String str3 = packageInfo.versionName;
        String str4 = str3 == null ? valueOf : str3;
        String str5 = Build.MANUFACTURER;
        Intrinsics.o(str5, "MANUFACTURER");
        ProcessDetailsProvider processDetailsProvider = ProcessDetailsProvider.f25074a;
        Context n3 = firebaseApp.n();
        Intrinsics.o(n3, "firebaseApp.applicationContext");
        ProcessDetails d2 = processDetailsProvider.d(n3);
        Context n4 = firebaseApp.n();
        Intrinsics.o(n4, "firebaseApp.applicationContext");
        return new ApplicationInfo(j2, str, BuildConfig.f25053d, str2, logEnvironment, new AndroidApplicationInfo(packageName, str4, valueOf, str5, d2, processDetailsProvider.c(n4)));
    }

    @NotNull
    public final DataEncoder d() {
        return f25099b;
    }
}
