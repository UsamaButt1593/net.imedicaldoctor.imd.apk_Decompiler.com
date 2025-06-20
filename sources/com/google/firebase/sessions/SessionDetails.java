package com.google.firebase.sessions;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001c\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0011¨\u0006!"}, d2 = {"Lcom/google/firebase/sessions/SessionDetails;", "", "", "sessionId", "firstSessionId", "", "sessionIndex", "", "sessionStartTimestampUs", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJ)V", "a", "()Ljava/lang/String;", "b", "c", "()I", "d", "()J", "e", "(Ljava/lang/String;Ljava/lang/String;IJ)Lcom/google/firebase/sessions/SessionDetails;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "h", "g", "I", "i", "J", "j", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class SessionDetails {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f25091a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f25092b;

    /* renamed from: c  reason: collision with root package name */
    private final int f25093c;

    /* renamed from: d  reason: collision with root package name */
    private final long f25094d;

    public SessionDetails(@NotNull String str, @NotNull String str2, int i2, long j2) {
        Intrinsics.p(str, "sessionId");
        Intrinsics.p(str2, "firstSessionId");
        this.f25091a = str;
        this.f25092b = str2;
        this.f25093c = i2;
        this.f25094d = j2;
    }

    public static /* synthetic */ SessionDetails f(SessionDetails sessionDetails, String str, String str2, int i2, long j2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = sessionDetails.f25091a;
        }
        if ((i3 & 2) != 0) {
            str2 = sessionDetails.f25092b;
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            i2 = sessionDetails.f25093c;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            j2 = sessionDetails.f25094d;
        }
        return sessionDetails.e(str, str3, i4, j2);
    }

    @NotNull
    public final String a() {
        return this.f25091a;
    }

    @NotNull
    public final String b() {
        return this.f25092b;
    }

    public final int c() {
        return this.f25093c;
    }

    public final long d() {
        return this.f25094d;
    }

    @NotNull
    public final SessionDetails e(@NotNull String str, @NotNull String str2, int i2, long j2) {
        Intrinsics.p(str, "sessionId");
        Intrinsics.p(str2, "firstSessionId");
        return new SessionDetails(str, str2, i2, j2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionDetails)) {
            return false;
        }
        SessionDetails sessionDetails = (SessionDetails) obj;
        return Intrinsics.g(this.f25091a, sessionDetails.f25091a) && Intrinsics.g(this.f25092b, sessionDetails.f25092b) && this.f25093c == sessionDetails.f25093c && this.f25094d == sessionDetails.f25094d;
    }

    @NotNull
    public final String g() {
        return this.f25092b;
    }

    @NotNull
    public final String h() {
        return this.f25091a;
    }

    public int hashCode() {
        return (((((this.f25091a.hashCode() * 31) + this.f25092b.hashCode()) * 31) + this.f25093c) * 31) + j.a(this.f25094d);
    }

    public final int i() {
        return this.f25093c;
    }

    public final long j() {
        return this.f25094d;
    }

    @NotNull
    public String toString() {
        return "SessionDetails(sessionId=" + this.f25091a + ", firstSessionId=" + this.f25092b + ", sessionIndex=" + this.f25093c + ", sessionStartTimestampUs=" + this.f25094d + ASCIIPropertyListParser.f18650h;
    }
}
