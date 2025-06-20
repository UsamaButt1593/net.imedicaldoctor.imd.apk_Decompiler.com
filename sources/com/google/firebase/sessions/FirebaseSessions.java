package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseKt;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions;", "", "Lcom/google/firebase/FirebaseApp;", "firebaseApp", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "settings", "Lkotlin/coroutines/CoroutineContext;", "backgroundDispatcher", "Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;", "lifecycleServiceBinder", "<init>", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/sessions/settings/SessionsSettings;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;)V", "a", "Lcom/google/firebase/FirebaseApp;", "b", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "c", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class FirebaseSessions {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f25061c = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final String f25062d = "FirebaseSessions";
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final FirebaseApp f25063a;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final SessionsSettings f25064b;

    @SourceDebugExtension({"SMAP\nFirebaseSessions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirebaseSessions.kt\ncom/google/firebase/sessions/FirebaseSessions$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,82:1\n2624#2,3:83\n*S KotlinDebug\n*F\n+ 1 FirebaseSessions.kt\ncom/google/firebase/sessions/FirebaseSessions$1\n*L\n46#1:83,3\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.FirebaseSessions$1", f = "FirebaseSessions.kt", i = {}, l = {45, 49}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.google.firebase.sessions.FirebaseSessions$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int X2;
        final /* synthetic */ FirebaseSessions Y2;

        {
            this.Y2 = r1;
        }

        /* access modifiers changed from: private */
        public static final void i0(String str, FirebaseOptions firebaseOptions) {
            Log.w(FirebaseSessions.f25062d, "FirebaseApp instance deleted. Sessions library will stop collecting data.");
            SessionsActivityLifecycleCallbacks.s.e((SessionLifecycleClient) null);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object D(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
                int r1 = r5.X2
                java.lang.String r2 = "FirebaseSessions"
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 == r4) goto L_0x001c
                if (r1 != r3) goto L_0x0014
                kotlin.ResultKt.n(r6)
                goto L_0x0064
            L_0x0014:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001c:
                kotlin.ResultKt.n(r6)
                goto L_0x002e
            L_0x0020:
                kotlin.ResultKt.n(r6)
                com.google.firebase.sessions.api.FirebaseSessionsDependencies r6 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.f25140a
                r5.X2 = r4
                java.lang.Object r6 = r6.c(r5)
                if (r6 != r0) goto L_0x002e
                return r0
            L_0x002e:
                java.util.Map r6 = (java.util.Map) r6
                java.util.Collection r6 = r6.values()
                boolean r1 = r6 instanceof java.util.Collection
                if (r1 == 0) goto L_0x003f
                boolean r1 = r6.isEmpty()
                if (r1 == 0) goto L_0x003f
                goto L_0x0096
            L_0x003f:
                java.util.Iterator r6 = r6.iterator()
            L_0x0043:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L_0x0096
                java.lang.Object r1 = r6.next()
                com.google.firebase.sessions.api.SessionSubscriber r1 = (com.google.firebase.sessions.api.SessionSubscriber) r1
                boolean r1 = r1.a()
                if (r1 == 0) goto L_0x0043
                com.google.firebase.sessions.FirebaseSessions r6 = r5.Y2
                com.google.firebase.sessions.settings.SessionsSettings r6 = r6.f25064b
                r5.X2 = r3
                java.lang.Object r6 = r6.g(r5)
                if (r6 != r0) goto L_0x0064
                return r0
            L_0x0064:
                com.google.firebase.sessions.FirebaseSessions r6 = r5.Y2
                com.google.firebase.sessions.settings.SessionsSettings r6 = r6.f25064b
                boolean r6 = r6.d()
                if (r6 != 0) goto L_0x0076
                java.lang.String r6 = "Sessions SDK disabled. Not listening to lifecycle events."
            L_0x0072:
                android.util.Log.d(r2, r6)
                goto L_0x0099
            L_0x0076:
                com.google.firebase.sessions.SessionLifecycleClient r6 = new com.google.firebase.sessions.SessionLifecycleClient
                kotlin.coroutines.CoroutineContext r0 = r9
                r6.<init>(r0)
                com.google.firebase.sessions.SessionLifecycleServiceBinder r0 = r10
                r6.i(r0)
                com.google.firebase.sessions.SessionsActivityLifecycleCallbacks r0 = com.google.firebase.sessions.SessionsActivityLifecycleCallbacks.s
                r0.e(r6)
                com.google.firebase.sessions.FirebaseSessions r6 = r5.Y2
                com.google.firebase.FirebaseApp r6 = r6.f25063a
                com.google.firebase.sessions.c r0 = new com.google.firebase.sessions.c
                r0.<init>()
                r6.h(r0)
                goto L_0x0099
            L_0x0096:
                java.lang.String r6 = "No Sessions subscribers. Not listening to lifecycle events."
                goto L_0x0072
            L_0x0099:
                kotlin.Unit r6 = kotlin.Unit.f28779a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.FirebaseSessions.AnonymousClass1.D(java.lang.Object):java.lang.Object");
        }

        @Nullable
        /* renamed from: c0 */
        public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) v(coroutineScope, continuation)).D(Unit.f28779a);
        }

        @NotNull
        public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.Y2, coroutineContext, sessionLifecycleServiceBinder, continuation);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions$Companion;", "", "<init>", "()V", "Lcom/google/firebase/sessions/FirebaseSessions;", "a", "()Lcom/google/firebase/sessions/FirebaseSessions;", "instance", "", "TAG", "Ljava/lang/String;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final FirebaseSessions a() {
            Object l2 = FirebaseKt.c(Firebase.f23274a).l(FirebaseSessions.class);
            Intrinsics.o(l2, "Firebase.app[FirebaseSessions::class.java]");
            return (FirebaseSessions) l2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FirebaseSessions(@NotNull FirebaseApp firebaseApp, @NotNull SessionsSettings sessionsSettings, @NotNull final CoroutineContext coroutineContext, @NotNull final SessionLifecycleServiceBinder sessionLifecycleServiceBinder) {
        Intrinsics.p(firebaseApp, "firebaseApp");
        Intrinsics.p(sessionsSettings, "settings");
        Intrinsics.p(coroutineContext, "backgroundDispatcher");
        Intrinsics.p(sessionLifecycleServiceBinder, "lifecycleServiceBinder");
        this.f25063a = firebaseApp;
        this.f25064b = sessionsSettings;
        Log.d(f25062d, "Initializing Firebase Sessions SDK.");
        Context applicationContext = firebaseApp.n().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(SessionsActivityLifecycleCallbacks.s);
            Job unused = BuildersKt__Builders_commonKt.f(CoroutineScopeKt.a(coroutineContext), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return;
        }
        Log.e(f25062d, "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }
}
