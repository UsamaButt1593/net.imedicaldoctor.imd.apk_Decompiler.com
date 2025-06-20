package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1", f = "SessionFirelogPublisher.kt", i = {2}, l = {63, 64, 70}, m = "invokeSuspend", n = {"installationId"}, s = {"L$0"})
final class SessionFirelogPublisherImpl$logSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object X2;
    Object Y2;
    Object Z2;
    Object a3;
    Object b3;
    Object c3;
    int d3;
    final /* synthetic */ SessionFirelogPublisherImpl e3;
    final /* synthetic */ SessionDetails f3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SessionFirelogPublisherImpl$logSession$1(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, SessionDetails sessionDetails, Continuation<? super SessionFirelogPublisherImpl$logSession$1> continuation) {
        super(2, continuation);
        this.e3 = sessionFirelogPublisherImpl;
        this.f3 = sessionDetails;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0095 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0096  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r10.d3
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0045
            if (r1 == r4) goto L_0x0041
            if (r1 == r3) goto L_0x003d
            if (r1 != r2) goto L_0x0035
            java.lang.Object r0 = r10.c3
            com.google.firebase.sessions.settings.SessionsSettings r0 = (com.google.firebase.sessions.settings.SessionsSettings) r0
            java.lang.Object r1 = r10.b3
            com.google.firebase.sessions.SessionDetails r1 = (com.google.firebase.sessions.SessionDetails) r1
            java.lang.Object r2 = r10.a3
            com.google.firebase.FirebaseApp r2 = (com.google.firebase.FirebaseApp) r2
            java.lang.Object r3 = r10.Z2
            com.google.firebase.sessions.SessionEvents r3 = (com.google.firebase.sessions.SessionEvents) r3
            java.lang.Object r4 = r10.Y2
            com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r4
            java.lang.Object r5 = r10.X2
            com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
            kotlin.ResultKt.n(r11)
            r7 = r4
            r8 = r3
            r3 = r0
            r0 = r8
            r9 = r2
            r2 = r1
            r1 = r9
            goto L_0x009d
        L_0x0035:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x003d:
            kotlin.ResultKt.n(r11)
            goto L_0x006c
        L_0x0041:
            kotlin.ResultKt.n(r11)
            goto L_0x0053
        L_0x0045:
            kotlin.ResultKt.n(r11)
            com.google.firebase.sessions.SessionFirelogPublisherImpl r11 = r10.e3
            r10.d3 = r4
            java.lang.Object r11 = r11.i(r10)
            if (r11 != r0) goto L_0x0053
            return r0
        L_0x0053:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00b0
            com.google.firebase.sessions.InstallationId$Companion r11 = com.google.firebase.sessions.InstallationId.f25066c
            com.google.firebase.sessions.SessionFirelogPublisherImpl r1 = r10.e3
            com.google.firebase.installations.FirebaseInstallationsApi r1 = r1.f25106c
            r10.d3 = r3
            java.lang.Object r11 = r11.a(r1, r10)
            if (r11 != r0) goto L_0x006c
            return r0
        L_0x006c:
            r5 = r11
            com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
            com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = r10.e3
            com.google.firebase.sessions.SessionEvents r3 = com.google.firebase.sessions.SessionEvents.f25098a
            com.google.firebase.FirebaseApp r11 = r4.f25105b
            com.google.firebase.sessions.SessionDetails r1 = r10.f3
            com.google.firebase.sessions.SessionFirelogPublisherImpl r6 = r10.e3
            com.google.firebase.sessions.settings.SessionsSettings r6 = r6.f25107d
            com.google.firebase.sessions.api.FirebaseSessionsDependencies r7 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f25140a
            r10.X2 = r5
            r10.Y2 = r4
            r10.Z2 = r3
            r10.a3 = r11
            r10.b3 = r1
            r10.c3 = r6
            r10.d3 = r2
            java.lang.Object r2 = r7.c(r10)
            if (r2 != r0) goto L_0x0096
            return r0
        L_0x0096:
            r0 = r3
            r7 = r4
            r3 = r6
            r8 = r1
            r1 = r11
            r11 = r2
            r2 = r8
        L_0x009d:
            r4 = r11
            java.util.Map r4 = (java.util.Map) r4
            java.lang.String r11 = r5.b()
            java.lang.String r6 = r5.a()
            r5 = r11
            com.google.firebase.sessions.SessionEvent r11 = r0.a(r1, r2, r3, r4, r5, r6)
            r7.g(r11)
        L_0x00b0:
            kotlin.Unit r11 = kotlin.Unit.f28779a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SessionFirelogPublisherImpl$logSession$1) v(coroutineScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SessionFirelogPublisherImpl$logSession$1(this.e3, this.f3, continuation);
    }
}
