package com.google.firebase.sessions;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0010J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0010JV\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0010J\u0010\u0010\u001d\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0013J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b$\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\u0015R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b*\u0010\u0017R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b+\u0010\u0010R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\"\u001a\u0004\b,\u0010\u0010¨\u0006-"}, d2 = {"Lcom/google/firebase/sessions/SessionInfo;", "", "", "sessionId", "firstSessionId", "", "sessionIndex", "", "eventTimestampUs", "Lcom/google/firebase/sessions/DataCollectionStatus;", "dataCollectionStatus", "firebaseInstallationId", "firebaseAuthenticationToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJLcom/google/firebase/sessions/DataCollectionStatus;Ljava/lang/String;Ljava/lang/String;)V", "a", "()Ljava/lang/String;", "b", "c", "()I", "d", "()J", "e", "()Lcom/google/firebase/sessions/DataCollectionStatus;", "f", "g", "h", "(Ljava/lang/String;Ljava/lang/String;IJLcom/google/firebase/sessions/DataCollectionStatus;Ljava/lang/String;Ljava/lang/String;)Lcom/google/firebase/sessions/SessionInfo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "o", "n", "I", "p", "J", "k", "Lcom/google/firebase/sessions/DataCollectionStatus;", "j", "m", "l", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class SessionInfo {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f25116a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f25117b;

    /* renamed from: c  reason: collision with root package name */
    private final int f25118c;

    /* renamed from: d  reason: collision with root package name */
    private final long f25119d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final DataCollectionStatus f25120e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final String f25121f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final String f25122g;

    public SessionInfo(@NotNull String str, @NotNull String str2, int i2, long j2, @NotNull DataCollectionStatus dataCollectionStatus, @NotNull String str3, @NotNull String str4) {
        Intrinsics.p(str, "sessionId");
        Intrinsics.p(str2, "firstSessionId");
        Intrinsics.p(dataCollectionStatus, "dataCollectionStatus");
        Intrinsics.p(str3, "firebaseInstallationId");
        Intrinsics.p(str4, "firebaseAuthenticationToken");
        this.f25116a = str;
        this.f25117b = str2;
        this.f25118c = i2;
        this.f25119d = j2;
        this.f25120e = dataCollectionStatus;
        this.f25121f = str3;
        this.f25122g = str4;
    }

    public static /* synthetic */ SessionInfo i(SessionInfo sessionInfo, String str, String str2, int i2, long j2, DataCollectionStatus dataCollectionStatus, String str3, String str4, int i3, Object obj) {
        SessionInfo sessionInfo2 = sessionInfo;
        return sessionInfo.h((i3 & 1) != 0 ? sessionInfo2.f25116a : str, (i3 & 2) != 0 ? sessionInfo2.f25117b : str2, (i3 & 4) != 0 ? sessionInfo2.f25118c : i2, (i3 & 8) != 0 ? sessionInfo2.f25119d : j2, (i3 & 16) != 0 ? sessionInfo2.f25120e : dataCollectionStatus, (i3 & 32) != 0 ? sessionInfo2.f25121f : str3, (i3 & 64) != 0 ? sessionInfo2.f25122g : str4);
    }

    @NotNull
    public final String a() {
        return this.f25116a;
    }

    @NotNull
    public final String b() {
        return this.f25117b;
    }

    public final int c() {
        return this.f25118c;
    }

    public final long d() {
        return this.f25119d;
    }

    @NotNull
    public final DataCollectionStatus e() {
        return this.f25120e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionInfo)) {
            return false;
        }
        SessionInfo sessionInfo = (SessionInfo) obj;
        return Intrinsics.g(this.f25116a, sessionInfo.f25116a) && Intrinsics.g(this.f25117b, sessionInfo.f25117b) && this.f25118c == sessionInfo.f25118c && this.f25119d == sessionInfo.f25119d && Intrinsics.g(this.f25120e, sessionInfo.f25120e) && Intrinsics.g(this.f25121f, sessionInfo.f25121f) && Intrinsics.g(this.f25122g, sessionInfo.f25122g);
    }

    @NotNull
    public final String f() {
        return this.f25121f;
    }

    @NotNull
    public final String g() {
        return this.f25122g;
    }

    @NotNull
    public final SessionInfo h(@NotNull String str, @NotNull String str2, int i2, long j2, @NotNull DataCollectionStatus dataCollectionStatus, @NotNull String str3, @NotNull String str4) {
        Intrinsics.p(str, "sessionId");
        Intrinsics.p(str2, "firstSessionId");
        DataCollectionStatus dataCollectionStatus2 = dataCollectionStatus;
        Intrinsics.p(dataCollectionStatus2, "dataCollectionStatus");
        String str5 = str3;
        Intrinsics.p(str5, "firebaseInstallationId");
        String str6 = str4;
        Intrinsics.p(str6, "firebaseAuthenticationToken");
        return new SessionInfo(str, str2, i2, j2, dataCollectionStatus2, str5, str6);
    }

    public int hashCode() {
        return (((((((((((this.f25116a.hashCode() * 31) + this.f25117b.hashCode()) * 31) + this.f25118c) * 31) + j.a(this.f25119d)) * 31) + this.f25120e.hashCode()) * 31) + this.f25121f.hashCode()) * 31) + this.f25122g.hashCode();
    }

    @NotNull
    public final DataCollectionStatus j() {
        return this.f25120e;
    }

    public final long k() {
        return this.f25119d;
    }

    @NotNull
    public final String l() {
        return this.f25122g;
    }

    @NotNull
    public final String m() {
        return this.f25121f;
    }

    @NotNull
    public final String n() {
        return this.f25117b;
    }

    @NotNull
    public final String o() {
        return this.f25116a;
    }

    public final int p() {
        return this.f25118c;
    }

    @NotNull
    public String toString() {
        return "SessionInfo(sessionId=" + this.f25116a + ", firstSessionId=" + this.f25117b + ", sessionIndex=" + this.f25118c + ", eventTimestampUs=" + this.f25119d + ", dataCollectionStatus=" + this.f25120e + ", firebaseInstallationId=" + this.f25121f + ", firebaseAuthenticationToken=" + this.f25122g + ASCIIPropertyListParser.f18650h;
    }
}
