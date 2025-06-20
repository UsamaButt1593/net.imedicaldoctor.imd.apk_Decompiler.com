package com.google.firebase.sessions;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b`\u0018\u0000 \u00072\u00020\u0001:\u0001\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/google/firebase/sessions/SessionDatastore;", "", "", "sessionId", "", "b", "(Ljava/lang/String;)V", "a", "()Ljava/lang/String;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public interface SessionDatastore {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f25079a = Companion.f25080a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/google/firebase/sessions/SessionDatastore$Companion;", "", "<init>", "()V", "Lcom/google/firebase/sessions/SessionDatastore;", "a", "()Lcom/google/firebase/sessions/SessionDatastore;", "instance", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f25080a = new Companion();

        private Companion() {
        }

        @NotNull
        public final SessionDatastore a() {
            Object l2 = FirebaseKt.c(Firebase.f23274a).l(SessionDatastore.class);
            Intrinsics.o(l2, "Firebase.app[SessionDatastore::class.java]");
            return (SessionDatastore) l2;
        }
    }

    @Nullable
    String a();

    void b(@NotNull String str);
}
