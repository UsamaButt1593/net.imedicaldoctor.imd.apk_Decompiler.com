package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nRemoteSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteSettings.kt\ncom/google/firebase/sessions/settings/RemoteSettings$updateSettings$2$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,164:1\n1#2:165\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", i = {0, 0, 0, 1, 1, 2}, l = {125, 128, 131, 133, 134, 136}, m = "invokeSuspend", n = {"sessionSamplingRate", "sessionTimeoutSeconds", "cacheDuration", "sessionSamplingRate", "cacheDuration", "cacheDuration"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
final class RemoteSettings$updateSettings$2$1 extends SuspendLambda implements Function2<JSONObject, Continuation<? super Unit>, Object> {
    Object X2;
    Object Y2;
    int Z2;
    /* synthetic */ Object a3;
    final /* synthetic */ RemoteSettings b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, Continuation<? super RemoteSettings$updateSettings$2$1> continuation) {
        super(2, continuation);
        this.b3 = remoteSettings;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f9, code lost:
        if (((java.lang.Integer) r8.s) == null) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fb, code lost:
        r12.a3 = r1;
        r12.X2 = r0;
        r12.Y2 = null;
        r12.Z2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0112, code lost:
        if (r12.b3.h().s((java.lang.Integer) r8.s, r12) != r4) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0114, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0119, code lost:
        if (((java.lang.Double) r1.s) == null) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x011b, code lost:
        r12.a3 = r0;
        r12.X2 = null;
        r12.Y2 = null;
        r12.Z2 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0132, code lost:
        if (r12.b3.h().o((java.lang.Double) r1.s, r12) != r4) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0134, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0139, code lost:
        if (((java.lang.Integer) r0.s) == null) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013b, code lost:
        r12.a3 = null;
        r12.X2 = null;
        r12.Y2 = null;
        r12.Z2 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0152, code lost:
        if (r12.b3.h().p((java.lang.Integer) r0.s, r12) != r4) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0154, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0155, code lost:
        r13 = kotlin.Unit.f28779a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0158, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0159, code lost:
        if (r13 != null) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x015b, code lost:
        r13 = r12.b3.h();
        r0 = kotlin.coroutines.jvm.internal.Boxing.f(86400);
        r12.a3 = null;
        r12.X2 = null;
        r12.Y2 = null;
        r12.Z2 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0175, code lost:
        if (r13.p(r0, r12) != r4) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0177, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0178, code lost:
        r13 = r12.b3.h();
        r0 = kotlin.coroutines.jvm.internal.Boxing.g(java.lang.System.currentTimeMillis());
        r12.a3 = null;
        r12.X2 = null;
        r12.Y2 = null;
        r12.Z2 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0193, code lost:
        if (r13.q(r0, r12) != r4) goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0195, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0198, code lost:
        return kotlin.Unit.f28779a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f3  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.String r0 = "cache_duration"
            java.lang.String r1 = "session_timeout_seconds"
            java.lang.String r2 = "sampling_rate"
            java.lang.String r3 = "sessions_enabled"
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r5 = r12.Z2
            r6 = 0
            switch(r5) {
                case 0: goto L_0x0050;
                case 1: goto L_0x003f;
                case 2: goto L_0x0032;
                case 3: goto L_0x0029;
                case 4: goto L_0x0024;
                case 5: goto L_0x001f;
                case 6: goto L_0x001a;
                default: goto L_0x0012;
            }
        L_0x0012:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x001a:
            kotlin.ResultKt.n(r13)
            goto L_0x0196
        L_0x001f:
            kotlin.ResultKt.n(r13)
            goto L_0x0178
        L_0x0024:
            kotlin.ResultKt.n(r13)
            goto L_0x0155
        L_0x0029:
            java.lang.Object r0 = r12.a3
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.n(r13)
            goto L_0x0135
        L_0x0032:
            java.lang.Object r0 = r12.X2
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r12.a3
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.n(r13)
            goto L_0x0115
        L_0x003f:
            java.lang.Object r0 = r12.Y2
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r12.X2
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r2 = r12.a3
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            kotlin.ResultKt.n(r13)
            goto L_0x00f0
        L_0x0050:
            kotlin.ResultKt.n(r13)
            java.lang.Object r13 = r12.a3
            org.json.JSONObject r13 = (org.json.JSONObject) r13
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Fetched settings: "
            r5.append(r7)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            java.lang.String r7 = "SessionConfigFetcher"
            android.util.Log.d(r7, r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
            r9.<init>()
            java.lang.String r10 = "app_quality"
            boolean r11 = r13.has(r10)
            if (r11 == 0) goto L_0x00d4
            java.lang.Object r13 = r13.get(r10)
            java.lang.String r10 = "null cannot be cast to non-null type org.json.JSONObject"
            kotlin.jvm.internal.Intrinsics.n(r13, r10)
            org.json.JSONObject r13 = (org.json.JSONObject) r13
            boolean r10 = r13.has(r3)     // Catch:{ JSONException -> 0x009c }
            if (r10 == 0) goto L_0x009f
            java.lang.Object r3 = r13.get(r3)     // Catch:{ JSONException -> 0x009c }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r13 = move-exception
            r3 = r6
            goto L_0x00ce
        L_0x009f:
            r3 = r6
        L_0x00a0:
            boolean r10 = r13.has(r2)     // Catch:{ JSONException -> 0x00af }
            if (r10 == 0) goto L_0x00b1
            java.lang.Object r2 = r13.get(r2)     // Catch:{ JSONException -> 0x00af }
            java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ JSONException -> 0x00af }
            r5.s = r2     // Catch:{ JSONException -> 0x00af }
            goto L_0x00b1
        L_0x00af:
            r13 = move-exception
            goto L_0x00ce
        L_0x00b1:
            boolean r2 = r13.has(r1)     // Catch:{ JSONException -> 0x00af }
            if (r2 == 0) goto L_0x00bf
            java.lang.Object r1 = r13.get(r1)     // Catch:{ JSONException -> 0x00af }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ JSONException -> 0x00af }
            r8.s = r1     // Catch:{ JSONException -> 0x00af }
        L_0x00bf:
            boolean r1 = r13.has(r0)     // Catch:{ JSONException -> 0x00af }
            if (r1 == 0) goto L_0x00d5
            java.lang.Object r13 = r13.get(r0)     // Catch:{ JSONException -> 0x00af }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ JSONException -> 0x00af }
            r9.s = r13     // Catch:{ JSONException -> 0x00af }
            goto L_0x00d5
        L_0x00ce:
            java.lang.String r0 = "Error parsing the configs remotely fetched: "
            android.util.Log.e(r7, r0, r13)
            goto L_0x00d5
        L_0x00d4:
            r3 = r6
        L_0x00d5:
            if (r3 == 0) goto L_0x00f3
            com.google.firebase.sessions.settings.RemoteSettings r13 = r12.b3
            com.google.firebase.sessions.settings.SettingsCache r13 = r13.h()
            r12.a3 = r5
            r12.X2 = r8
            r12.Y2 = r9
            r0 = 1
            r12.Z2 = r0
            java.lang.Object r13 = r13.t(r3, r12)
            if (r13 != r4) goto L_0x00ed
            return r4
        L_0x00ed:
            r2 = r5
            r1 = r8
            r0 = r9
        L_0x00f0:
            r8 = r1
            r1 = r2
            goto L_0x00f5
        L_0x00f3:
            r1 = r5
            r0 = r9
        L_0x00f5:
            T r13 = r8.s
            java.lang.Integer r13 = (java.lang.Integer) r13
            if (r13 == 0) goto L_0x0115
            com.google.firebase.sessions.settings.RemoteSettings r13 = r12.b3
            com.google.firebase.sessions.settings.SettingsCache r13 = r13.h()
            T r2 = r8.s
            java.lang.Integer r2 = (java.lang.Integer) r2
            r12.a3 = r1
            r12.X2 = r0
            r12.Y2 = r6
            r3 = 2
            r12.Z2 = r3
            java.lang.Object r13 = r13.s(r2, r12)
            if (r13 != r4) goto L_0x0115
            return r4
        L_0x0115:
            T r13 = r1.s
            java.lang.Double r13 = (java.lang.Double) r13
            if (r13 == 0) goto L_0x0135
            com.google.firebase.sessions.settings.RemoteSettings r13 = r12.b3
            com.google.firebase.sessions.settings.SettingsCache r13 = r13.h()
            T r1 = r1.s
            java.lang.Double r1 = (java.lang.Double) r1
            r12.a3 = r0
            r12.X2 = r6
            r12.Y2 = r6
            r2 = 3
            r12.Z2 = r2
            java.lang.Object r13 = r13.o(r1, r12)
            if (r13 != r4) goto L_0x0135
            return r4
        L_0x0135:
            T r13 = r0.s
            java.lang.Integer r13 = (java.lang.Integer) r13
            if (r13 == 0) goto L_0x0158
            com.google.firebase.sessions.settings.RemoteSettings r13 = r12.b3
            com.google.firebase.sessions.settings.SettingsCache r13 = r13.h()
            T r0 = r0.s
            java.lang.Integer r0 = (java.lang.Integer) r0
            r12.a3 = r6
            r12.X2 = r6
            r12.Y2 = r6
            r1 = 4
            r12.Z2 = r1
            java.lang.Object r13 = r13.p(r0, r12)
            if (r13 != r4) goto L_0x0155
            return r4
        L_0x0155:
            kotlin.Unit r13 = kotlin.Unit.f28779a
            goto L_0x0159
        L_0x0158:
            r13 = r6
        L_0x0159:
            if (r13 != 0) goto L_0x0178
            com.google.firebase.sessions.settings.RemoteSettings r13 = r12.b3
            com.google.firebase.sessions.settings.SettingsCache r13 = r13.h()
            r0 = 86400(0x15180, float:1.21072E-40)
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.f(r0)
            r12.a3 = r6
            r12.X2 = r6
            r12.Y2 = r6
            r1 = 5
            r12.Z2 = r1
            java.lang.Object r13 = r13.p(r0, r12)
            if (r13 != r4) goto L_0x0178
            return r4
        L_0x0178:
            com.google.firebase.sessions.settings.RemoteSettings r13 = r12.b3
            com.google.firebase.sessions.settings.SettingsCache r13 = r13.h()
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.g(r0)
            r12.a3 = r6
            r12.X2 = r6
            r12.Y2 = r6
            r1 = 6
            r12.Z2 = r1
            java.lang.Object r13 = r13.q(r0, r12)
            if (r13 != r4) goto L_0x0196
            return r4
        L_0x0196:
            kotlin.Unit r13 = kotlin.Unit.f28779a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull JSONObject jSONObject, @Nullable Continuation<? super Unit> continuation) {
        return ((RemoteSettings$updateSettings$2$1) v(jSONObject, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.b3, continuation);
        remoteSettings$updateSettings$2$1.a3 = obj;
        return remoteSettings$updateSettings$2$1;
    }
}
