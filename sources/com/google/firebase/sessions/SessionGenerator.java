package com.google.firebase.sessions;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f8\u0006@BX.¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u001e\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u001d¨\u0006!"}, d2 = {"Lcom/google/firebase/sessions/SessionGenerator;", "", "Lcom/google/firebase/sessions/TimeProvider;", "timeProvider", "Lkotlin/Function0;", "Ljava/util/UUID;", "uuidGenerator", "<init>", "(Lcom/google/firebase/sessions/TimeProvider;Lkotlin/jvm/functions/Function0;)V", "", "b", "()Ljava/lang/String;", "Lcom/google/firebase/sessions/SessionDetails;", "a", "()Lcom/google/firebase/sessions/SessionDetails;", "Lcom/google/firebase/sessions/TimeProvider;", "Lkotlin/jvm/functions/Function0;", "c", "Ljava/lang/String;", "firstSessionId", "", "d", "I", "sessionIndex", "<set-?>", "e", "Lcom/google/firebase/sessions/SessionDetails;", "currentSession", "", "()Z", "hasGenerateSession", "f", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class SessionGenerator {
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f25110f = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final TimeProvider f25111a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function0<UUID> f25112b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f25113c;

    /* renamed from: d  reason: collision with root package name */
    private int f25114d;

    /* renamed from: e  reason: collision with root package name */
    private SessionDetails f25115e;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/google/firebase/sessions/SessionGenerator$Companion;", "", "<init>", "()V", "Lcom/google/firebase/sessions/SessionGenerator;", "a", "()Lcom/google/firebase/sessions/SessionGenerator;", "instance", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SessionGenerator a() {
            Object l2 = FirebaseKt.c(Firebase.f23274a).l(SessionGenerator.class);
            Intrinsics.o(l2, "Firebase.app[SessionGenerator::class.java]");
            return (SessionGenerator) l2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionGenerator(@NotNull TimeProvider timeProvider, @NotNull Function0<UUID> function0) {
        Intrinsics.p(timeProvider, "timeProvider");
        Intrinsics.p(function0, "uuidGenerator");
        this.f25111a = timeProvider;
        this.f25112b = function0;
        this.f25113c = b();
        this.f25114d = -1;
    }

    private final String b() {
        String uuid = this.f25112b.o().toString();
        Intrinsics.o(uuid, "uuidGenerator().toString()");
        String lowerCase = StringsKt.i2(uuid, "-", "", false, 4, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @NotNull
    @CanIgnoreReturnValue
    public final SessionDetails a() {
        int i2 = this.f25114d + 1;
        this.f25114d = i2;
        this.f25115e = new SessionDetails(i2 == 0 ? this.f25113c : b(), this.f25113c, this.f25114d, this.f25111a.b());
        return c();
    }

    @NotNull
    public final SessionDetails c() {
        SessionDetails sessionDetails = this.f25115e;
        if (sessionDetails != null) {
            return sessionDetails;
        }
        Intrinsics.S("currentSession");
        return null;
    }

    public final boolean d() {
        return this.f25115e != null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SessionGenerator(TimeProvider timeProvider, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(timeProvider, (i2 & 2) != 0 ? AnonymousClass1.c3 : function0);
    }
}
