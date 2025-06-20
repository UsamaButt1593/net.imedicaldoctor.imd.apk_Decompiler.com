package com.google.firebase.sessions;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bà\u0001\u0018\u0000 \u00052\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/google/firebase/sessions/SessionFirelogPublisher;", "", "Lcom/google/firebase/sessions/SessionDetails;", "sessionDetails", "", "a", "(Lcom/google/firebase/sessions/SessionDetails;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public interface SessionFirelogPublisher {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f25100a = Companion.f25101a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/google/firebase/sessions/SessionFirelogPublisher$Companion;", "", "<init>", "()V", "Lcom/google/firebase/sessions/SessionFirelogPublisher;", "a", "()Lcom/google/firebase/sessions/SessionFirelogPublisher;", "instance", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f25101a = new Companion();

        private Companion() {
        }

        @NotNull
        public final SessionFirelogPublisher a() {
            Object l2 = FirebaseKt.c(Firebase.f23274a).l(SessionFirelogPublisher.class);
            Intrinsics.o(l2, "Firebase.app[SessionFirelogPublisher::class.java]");
            return (SessionFirelogPublisher) l2;
        }
    }

    void a(@NotNull SessionDetails sessionDetails);
}
