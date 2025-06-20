package com.google.firebase.sessions.api;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002\u000f\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/google/firebase/sessions/api/SessionSubscriber;", "", "Lcom/google/firebase/sessions/api/SessionSubscriber$SessionDetails;", "sessionDetails", "", "c", "(Lcom/google/firebase/sessions/api/SessionSubscriber$SessionDetails;)V", "", "a", "()Z", "isDataCollectionEnabled", "Lcom/google/firebase/sessions/api/SessionSubscriber$Name;", "b", "()Lcom/google/firebase/sessions/api/SessionSubscriber$Name;", "sessionSubscriberName", "Name", "SessionDetails", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public interface SessionSubscriber {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/api/SessionSubscriber$Name;", "", "<init>", "(Ljava/lang/String;I)V", "s", "X", "Y", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    public enum Name {
        CRASHLYTICS,
        PERFORMANCE,
        MATT_SAYS_HI
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/google/firebase/sessions/api/SessionSubscriber$SessionDetails;", "", "", "sessionId", "<init>", "(Ljava/lang/String;)V", "a", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)Lcom/google/firebase/sessions/api/SessionSubscriber$SessionDetails;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "d", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    public static final class SessionDetails {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f25145a;

        public SessionDetails(@NotNull String str) {
            Intrinsics.p(str, "sessionId");
            this.f25145a = str;
        }

        public static /* synthetic */ SessionDetails c(SessionDetails sessionDetails, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = sessionDetails.f25145a;
            }
            return sessionDetails.b(str);
        }

        @NotNull
        public final String a() {
            return this.f25145a;
        }

        @NotNull
        public final SessionDetails b(@NotNull String str) {
            Intrinsics.p(str, "sessionId");
            return new SessionDetails(str);
        }

        @NotNull
        public final String d() {
            return this.f25145a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SessionDetails) && Intrinsics.g(this.f25145a, ((SessionDetails) obj).f25145a);
        }

        public int hashCode() {
            return this.f25145a.hashCode();
        }

        @NotNull
        public String toString() {
            return "SessionDetails(sessionId=" + this.f25145a + ASCIIPropertyListParser.f18650h;
        }
    }

    boolean a();

    @NotNull
    Name b();

    void c(@NotNull SessionDetails sessionDetails);
}
