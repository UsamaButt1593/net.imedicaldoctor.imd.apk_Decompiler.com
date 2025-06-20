package com.google.firebase.sessions;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.firebase.encoders.annotations.Encodable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\u000f¨\u0006\""}, d2 = {"Lcom/google/firebase/sessions/SessionEvent;", "", "Lcom/google/firebase/sessions/EventType;", "eventType", "Lcom/google/firebase/sessions/SessionInfo;", "sessionData", "Lcom/google/firebase/sessions/ApplicationInfo;", "applicationInfo", "<init>", "(Lcom/google/firebase/sessions/EventType;Lcom/google/firebase/sessions/SessionInfo;Lcom/google/firebase/sessions/ApplicationInfo;)V", "a", "()Lcom/google/firebase/sessions/EventType;", "b", "()Lcom/google/firebase/sessions/SessionInfo;", "c", "()Lcom/google/firebase/sessions/ApplicationInfo;", "d", "(Lcom/google/firebase/sessions/EventType;Lcom/google/firebase/sessions/SessionInfo;Lcom/google/firebase/sessions/ApplicationInfo;)Lcom/google/firebase/sessions/SessionEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/google/firebase/sessions/EventType;", "g", "Lcom/google/firebase/sessions/SessionInfo;", "h", "Lcom/google/firebase/sessions/ApplicationInfo;", "f", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
@Encodable
public final class SessionEvent {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final EventType f25095a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final SessionInfo f25096b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ApplicationInfo f25097c;

    public SessionEvent(@NotNull EventType eventType, @NotNull SessionInfo sessionInfo, @NotNull ApplicationInfo applicationInfo) {
        Intrinsics.p(eventType, "eventType");
        Intrinsics.p(sessionInfo, "sessionData");
        Intrinsics.p(applicationInfo, "applicationInfo");
        this.f25095a = eventType;
        this.f25096b = sessionInfo;
        this.f25097c = applicationInfo;
    }

    public static /* synthetic */ SessionEvent e(SessionEvent sessionEvent, EventType eventType, SessionInfo sessionInfo, ApplicationInfo applicationInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            eventType = sessionEvent.f25095a;
        }
        if ((i2 & 2) != 0) {
            sessionInfo = sessionEvent.f25096b;
        }
        if ((i2 & 4) != 0) {
            applicationInfo = sessionEvent.f25097c;
        }
        return sessionEvent.d(eventType, sessionInfo, applicationInfo);
    }

    @NotNull
    public final EventType a() {
        return this.f25095a;
    }

    @NotNull
    public final SessionInfo b() {
        return this.f25096b;
    }

    @NotNull
    public final ApplicationInfo c() {
        return this.f25097c;
    }

    @NotNull
    public final SessionEvent d(@NotNull EventType eventType, @NotNull SessionInfo sessionInfo, @NotNull ApplicationInfo applicationInfo) {
        Intrinsics.p(eventType, "eventType");
        Intrinsics.p(sessionInfo, "sessionData");
        Intrinsics.p(applicationInfo, "applicationInfo");
        return new SessionEvent(eventType, sessionInfo, applicationInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionEvent)) {
            return false;
        }
        SessionEvent sessionEvent = (SessionEvent) obj;
        return this.f25095a == sessionEvent.f25095a && Intrinsics.g(this.f25096b, sessionEvent.f25096b) && Intrinsics.g(this.f25097c, sessionEvent.f25097c);
    }

    @NotNull
    public final ApplicationInfo f() {
        return this.f25097c;
    }

    @NotNull
    public final EventType g() {
        return this.f25095a;
    }

    @NotNull
    public final SessionInfo h() {
        return this.f25096b;
    }

    public int hashCode() {
        return (((this.f25095a.hashCode() * 31) + this.f25096b.hashCode()) * 31) + this.f25097c.hashCode();
    }

    @NotNull
    public String toString() {
        return "SessionEvent(eventType=" + this.f25095a + ", sessionData=" + this.f25096b + ", applicationInfo=" + this.f25097c + ASCIIPropertyListParser.f18650h;
    }
}
