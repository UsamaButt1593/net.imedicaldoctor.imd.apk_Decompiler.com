package com.google.firebase.sessions;

import android.util.Base64;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u0006\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/google/firebase/sessions/SessionDataStoreConfigs;", "", "<init>", "()V", "", "kotlin.jvm.PlatformType", "b", "Ljava/lang/String;", "PROCESS_NAME", "c", "a", "()Ljava/lang/String;", "SESSIONS_CONFIG_NAME", "d", "SETTINGS_CONFIG_NAME", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class SessionDataStoreConfigs {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final SessionDataStoreConfigs f25075a = new SessionDataStoreConfigs();

    /* renamed from: b  reason: collision with root package name */
    private static final String f25076b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final String f25077c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final String f25078d;

    static {
        String encodeToString = Base64.encodeToString(StringsKt.F1(ProcessDetailsProvider.f25074a.e()), 10);
        f25076b = encodeToString;
        f25077c = "firebase_session_" + encodeToString + "_data";
        f25078d = "firebase_session_" + encodeToString + "_settings";
    }

    private SessionDataStoreConfigs() {
    }

    @NotNull
    public final String a() {
        return f25077c;
    }

    @NotNull
    public final String b() {
        return f25078d;
    }
}
