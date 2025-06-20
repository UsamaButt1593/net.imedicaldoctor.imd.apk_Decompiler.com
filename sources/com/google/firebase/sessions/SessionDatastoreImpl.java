package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSessionDatastore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionDatastore.kt\ncom/google/firebase/sessions/SessionDatastoreImpl\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,122:1\n47#2:123\n49#2:127\n50#3:124\n55#3:126\n106#4:125\n*S KotlinDebug\n*F\n+ 1 SessionDatastore.kt\ncom/google/firebase/sessions/SessionDatastoreImpl\n*L\n78#1:123\n78#1:127\n78#1:124\n78#1:126\n78#1:125\n*E\n"})
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0002 !B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/google/firebase/sessions/SessionDatastoreImpl;", "Lcom/google/firebase/sessions/SessionDatastore;", "Landroid/content/Context;", "context", "Lkotlin/coroutines/CoroutineContext;", "backgroundDispatcher", "<init>", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "Landroidx/datastore/preferences/core/Preferences;", "preferences", "Lcom/google/firebase/sessions/FirebaseSessionsData;", "i", "(Landroidx/datastore/preferences/core/Preferences;)Lcom/google/firebase/sessions/FirebaseSessionsData;", "", "sessionId", "", "b", "(Ljava/lang/String;)V", "a", "()Ljava/lang/String;", "Landroid/content/Context;", "c", "Lkotlin/coroutines/CoroutineContext;", "Ljava/util/concurrent/atomic/AtomicReference;", "d", "Ljava/util/concurrent/atomic/AtomicReference;", "currentSessionFromDatastore", "Lkotlinx/coroutines/flow/Flow;", "e", "Lkotlinx/coroutines/flow/Flow;", "firebaseSessionDataFlow", "f", "Companion", "FirebaseSessionDataKeys", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class SessionDatastoreImpl implements SessionDatastore {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f25081f = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final String f25082g = "FirebaseSessionsRepo";
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public static final ReadOnlyProperty<Context, DataStore<Preferences>> f25083h = PreferenceDataStoreDelegateKt.b(SessionDataStoreConfigs.f25075a.a(), new ReplaceFileCorruptionHandler(SessionDatastoreImpl$Companion$dataStore$2.X), (Function1) null, (CoroutineScope) null, 12, (Object) null);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final Context f25084b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineContext f25085c;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<FirebaseSessionsData> f25086d = new AtomicReference<>();
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final Flow<FirebaseSessionsData> f25087e;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$1", f = "SessionDatastore.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.google.firebase.sessions.SessionDatastoreImpl$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int X2;
        final /* synthetic */ SessionDatastoreImpl Y2;

        {
            this.Y2 = r1;
        }

        @Nullable
        public final Object D(@NotNull Object obj) {
            Object l2 = IntrinsicsKt.l();
            int i2 = this.X2;
            if (i2 == 0) {
                ResultKt.n(obj);
                Flow g2 = this.Y2.f25087e;
                final SessionDatastoreImpl sessionDatastoreImpl = this.Y2;
                AnonymousClass1 r1 = new FlowCollector() {
                    @Nullable
                    /* renamed from: a */
                    public final Object h(@NotNull FirebaseSessionsData firebaseSessionsData, @NotNull Continuation<? super Unit> continuation) {
                        sessionDatastoreImpl.f25086d.set(firebaseSessionsData);
                        return Unit.f28779a;
                    }
                };
                this.X2 = 1;
                if (g2.a(r1, this) == l2) {
                    return l2;
                }
            } else if (i2 == 1) {
                ResultKt.n(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f28779a;
        }

        @Nullable
        /* renamed from: U */
        public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) v(coroutineScope, continuation)).D(Unit.f28779a);
        }

        @NotNull
        public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.Y2, continuation);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/google/firebase/sessions/SessionDatastoreImpl$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "dataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "b", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "dataStore", "", "TAG", "Ljava/lang/String;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    private static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f25088a = {Reflection.v(new PropertyReference2Impl(Companion.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final DataStore<Preferences> b(Context context) {
            return (DataStore) SessionDatastoreImpl.f25083h.a(context, f25088a[0]);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/google/firebase/sessions/SessionDatastoreImpl$FirebaseSessionDataKeys;", "", "<init>", "()V", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "b", "Landroidx/datastore/preferences/core/Preferences$Key;", "a", "()Landroidx/datastore/preferences/core/Preferences$Key;", "SESSION_ID", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    private static final class FirebaseSessionDataKeys {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final FirebaseSessionDataKeys f25089a = new FirebaseSessionDataKeys();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private static final Preferences.Key<String> f25090b = PreferencesKeys.f("session_id");

        private FirebaseSessionDataKeys() {
        }

        @NotNull
        public final Preferences.Key<String> a() {
            return f25090b;
        }
    }

    public SessionDatastoreImpl(@NotNull Context context, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.p(context, "context");
        Intrinsics.p(coroutineContext, "backgroundDispatcher");
        this.f25084b = context;
        this.f25085c = coroutineContext;
        this.f25087e = new SessionDatastoreImpl$special$$inlined$map$1(FlowKt.u(f25081f.b(context).getData(), new SessionDatastoreImpl$firebaseSessionDataFlow$1((Continuation<? super SessionDatastoreImpl$firebaseSessionDataFlow$1>) null)), this);
        Job unused = BuildersKt__Builders_commonKt.f(CoroutineScopeKt.a(coroutineContext), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final FirebaseSessionsData i(Preferences preferences) {
        return new FirebaseSessionsData((String) preferences.c(FirebaseSessionDataKeys.f25089a.a()));
    }

    @Nullable
    public String a() {
        FirebaseSessionsData firebaseSessionsData = this.f25086d.get();
        if (firebaseSessionsData != null) {
            return firebaseSessionsData.d();
        }
        return null;
    }

    public void b(@NotNull String str) {
        Intrinsics.p(str, "sessionId");
        Job unused = BuildersKt__Builders_commonKt.f(CoroutineScopeKt.a(this.f25085c), (CoroutineContext) null, (CoroutineStart) null, new SessionDatastoreImpl$updateSessionId$1(this, str, (Continuation<? super SessionDatastoreImpl$updateSessionId$1>) null), 3, (Object) null);
    }
}
