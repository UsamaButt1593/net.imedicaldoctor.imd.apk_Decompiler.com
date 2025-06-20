package com.google.firebase.sessions;

import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001&B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/google/firebase/sessions/SessionFirelogPublisherImpl;", "Lcom/google/firebase/sessions/SessionFirelogPublisher;", "Lcom/google/firebase/FirebaseApp;", "firebaseApp", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "firebaseInstallations", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "sessionSettings", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "eventGDTLogger", "Lkotlin/coroutines/CoroutineContext;", "backgroundDispatcher", "<init>", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/settings/SessionsSettings;Lcom/google/firebase/sessions/EventGDTLoggerInterface;Lkotlin/coroutines/CoroutineContext;)V", "Lcom/google/firebase/sessions/SessionEvent;", "sessionEvent", "", "g", "(Lcom/google/firebase/sessions/SessionEvent;)V", "", "i", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "()Z", "Lcom/google/firebase/sessions/SessionDetails;", "sessionDetails", "a", "(Lcom/google/firebase/sessions/SessionDetails;)V", "b", "Lcom/google/firebase/FirebaseApp;", "c", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "d", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "e", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "f", "Lkotlin/coroutines/CoroutineContext;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class SessionFirelogPublisherImpl implements SessionFirelogPublisher {
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f25102g = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final String f25103h = "SessionFirelogPublisher";

    /* renamed from: i  reason: collision with root package name */
    private static final double f25104i = Math.random();
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final FirebaseApp f25105b;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final FirebaseInstallationsApi f25106c;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final SessionsSettings f25107d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final EventGDTLoggerInterface f25108e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final CoroutineContext f25109f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/SessionFirelogPublisherImpl$Companion;", "", "()V", "TAG", "", "randomValueForSampling", "", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SessionFirelogPublisherImpl(@NotNull FirebaseApp firebaseApp, @NotNull FirebaseInstallationsApi firebaseInstallationsApi, @NotNull SessionsSettings sessionsSettings, @NotNull EventGDTLoggerInterface eventGDTLoggerInterface, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.p(firebaseApp, "firebaseApp");
        Intrinsics.p(firebaseInstallationsApi, "firebaseInstallations");
        Intrinsics.p(sessionsSettings, "sessionSettings");
        Intrinsics.p(eventGDTLoggerInterface, "eventGDTLogger");
        Intrinsics.p(coroutineContext, "backgroundDispatcher");
        this.f25105b = firebaseApp;
        this.f25106c = firebaseInstallationsApi;
        this.f25107d = sessionsSettings;
        this.f25108e = eventGDTLoggerInterface;
        this.f25109f = coroutineContext;
    }

    /* access modifiers changed from: private */
    public final void g(SessionEvent sessionEvent) {
        try {
            this.f25108e.a(sessionEvent);
            Log.d(f25103h, "Successfully logged Session Start event: " + sessionEvent.h().o());
        } catch (RuntimeException e2) {
            Log.e(f25103h, "Error logging Session Start event to DataTransport: ", e2);
        }
    }

    private final boolean h() {
        return f25104i <= this.f25107d.b();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1) r0
            int r1 = r0.Z2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Z2 = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = new com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.X2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Z2
            java.lang.String r3 = "SessionFirelogPublisher"
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r0 = r0.Z
            com.google.firebase.sessions.SessionFirelogPublisherImpl r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r0
            kotlin.ResultKt.n(r6)
            goto L_0x004d
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0037:
            kotlin.ResultKt.n(r6)
            java.lang.String r6 = "Data Collection is enabled for at least one Subscriber"
            android.util.Log.d(r3, r6)
            com.google.firebase.sessions.settings.SessionsSettings r6 = r5.f25107d
            r0.Z = r5
            r0.Z2 = r4
            java.lang.Object r6 = r6.g(r0)
            if (r6 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r0 = r5
        L_0x004d:
            com.google.firebase.sessions.settings.SessionsSettings r6 = r0.f25107d
            boolean r6 = r6.d()
            r1 = 0
            if (r6 != 0) goto L_0x0060
            java.lang.String r6 = "Sessions SDK disabled. Events will not be sent."
        L_0x0058:
            android.util.Log.d(r3, r6)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r1)
            return r6
        L_0x0060:
            boolean r6 = r0.h()
            if (r6 != 0) goto L_0x0069
            java.lang.String r6 = "Sessions SDK has dropped this session due to sampling."
            goto L_0x0058
        L_0x0069:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl.i(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void a(@NotNull SessionDetails sessionDetails) {
        Intrinsics.p(sessionDetails, "sessionDetails");
        Job unused = BuildersKt__Builders_commonKt.f(CoroutineScopeKt.a(this.f25109f), (CoroutineContext) null, (CoroutineStart) null, new SessionFirelogPublisherImpl$logSession$1(this, sessionDetails, (Continuation<? super SessionFirelogPublisherImpl$logSession$1>) null), 3, (Object) null);
    }
}
