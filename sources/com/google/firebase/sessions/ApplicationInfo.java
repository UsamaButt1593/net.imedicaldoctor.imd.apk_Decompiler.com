package com.google.firebase.sessions;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015JL\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000eJ\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b\"\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b#\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b$\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0013R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\u0015¨\u0006)"}, d2 = {"Lcom/google/firebase/sessions/ApplicationInfo;", "", "", "appId", "deviceModel", "sessionSdkVersion", "osVersion", "Lcom/google/firebase/sessions/LogEnvironment;", "logEnvironment", "Lcom/google/firebase/sessions/AndroidApplicationInfo;", "androidAppInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/sessions/LogEnvironment;Lcom/google/firebase/sessions/AndroidApplicationInfo;)V", "a", "()Ljava/lang/String;", "b", "c", "d", "e", "()Lcom/google/firebase/sessions/LogEnvironment;", "f", "()Lcom/google/firebase/sessions/AndroidApplicationInfo;", "g", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/sessions/LogEnvironment;Lcom/google/firebase/sessions/AndroidApplicationInfo;)Lcom/google/firebase/sessions/ApplicationInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "j", "k", "n", "m", "Lcom/google/firebase/sessions/LogEnvironment;", "l", "Lcom/google/firebase/sessions/AndroidApplicationInfo;", "i", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class ApplicationInfo {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f25007a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f25008b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f25009c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f25010d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final LogEnvironment f25011e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final AndroidApplicationInfo f25012f;

    public ApplicationInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull LogEnvironment logEnvironment, @NotNull AndroidApplicationInfo androidApplicationInfo) {
        Intrinsics.p(str, "appId");
        Intrinsics.p(str2, "deviceModel");
        Intrinsics.p(str3, "sessionSdkVersion");
        Intrinsics.p(str4, "osVersion");
        Intrinsics.p(logEnvironment, "logEnvironment");
        Intrinsics.p(androidApplicationInfo, "androidAppInfo");
        this.f25007a = str;
        this.f25008b = str2;
        this.f25009c = str3;
        this.f25010d = str4;
        this.f25011e = logEnvironment;
        this.f25012f = androidApplicationInfo;
    }

    public static /* synthetic */ ApplicationInfo h(ApplicationInfo applicationInfo, String str, String str2, String str3, String str4, LogEnvironment logEnvironment, AndroidApplicationInfo androidApplicationInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = applicationInfo.f25007a;
        }
        if ((i2 & 2) != 0) {
            str2 = applicationInfo.f25008b;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = applicationInfo.f25009c;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = applicationInfo.f25010d;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            logEnvironment = applicationInfo.f25011e;
        }
        LogEnvironment logEnvironment2 = logEnvironment;
        if ((i2 & 32) != 0) {
            androidApplicationInfo = applicationInfo.f25012f;
        }
        return applicationInfo.g(str, str5, str6, str7, logEnvironment2, androidApplicationInfo);
    }

    @NotNull
    public final String a() {
        return this.f25007a;
    }

    @NotNull
    public final String b() {
        return this.f25008b;
    }

    @NotNull
    public final String c() {
        return this.f25009c;
    }

    @NotNull
    public final String d() {
        return this.f25010d;
    }

    @NotNull
    public final LogEnvironment e() {
        return this.f25011e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationInfo)) {
            return false;
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) obj;
        return Intrinsics.g(this.f25007a, applicationInfo.f25007a) && Intrinsics.g(this.f25008b, applicationInfo.f25008b) && Intrinsics.g(this.f25009c, applicationInfo.f25009c) && Intrinsics.g(this.f25010d, applicationInfo.f25010d) && this.f25011e == applicationInfo.f25011e && Intrinsics.g(this.f25012f, applicationInfo.f25012f);
    }

    @NotNull
    public final AndroidApplicationInfo f() {
        return this.f25012f;
    }

    @NotNull
    public final ApplicationInfo g(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull LogEnvironment logEnvironment, @NotNull AndroidApplicationInfo androidApplicationInfo) {
        Intrinsics.p(str, "appId");
        Intrinsics.p(str2, "deviceModel");
        Intrinsics.p(str3, "sessionSdkVersion");
        Intrinsics.p(str4, "osVersion");
        Intrinsics.p(logEnvironment, "logEnvironment");
        Intrinsics.p(androidApplicationInfo, "androidAppInfo");
        return new ApplicationInfo(str, str2, str3, str4, logEnvironment, androidApplicationInfo);
    }

    public int hashCode() {
        return (((((((((this.f25007a.hashCode() * 31) + this.f25008b.hashCode()) * 31) + this.f25009c.hashCode()) * 31) + this.f25010d.hashCode()) * 31) + this.f25011e.hashCode()) * 31) + this.f25012f.hashCode();
    }

    @NotNull
    public final AndroidApplicationInfo i() {
        return this.f25012f;
    }

    @NotNull
    public final String j() {
        return this.f25007a;
    }

    @NotNull
    public final String k() {
        return this.f25008b;
    }

    @NotNull
    public final LogEnvironment l() {
        return this.f25011e;
    }

    @NotNull
    public final String m() {
        return this.f25010d;
    }

    @NotNull
    public final String n() {
        return this.f25009c;
    }

    @NotNull
    public String toString() {
        return "ApplicationInfo(appId=" + this.f25007a + ", deviceModel=" + this.f25008b + ", sessionSdkVersion=" + this.f25009c + ", osVersion=" + this.f25010d + ", logEnvironment=" + this.f25011e + ", androidAppInfo=" + this.f25012f + ASCIIPropertyListParser.f18650h;
    }
}
