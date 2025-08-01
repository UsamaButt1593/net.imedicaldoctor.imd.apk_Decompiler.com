package com.google.firebase.sessions;

import android.os.Message;
import android.util.Log;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSessionLifecycleClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionLifecycleClient.kt\ncom/google/firebase/sessions/SessionLifecycleClient$sendLifecycleEvents$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n2624#2,3:219\n1045#2:222\n1855#2,2:223\n*S KotlinDebug\n*F\n+ 1 SessionLifecycleClient.kt\ncom/google/firebase/sessions/SessionLifecycleClient$sendLifecycleEvents$1\n*L\n157#1:219,3\n165#1:222\n166#1:223,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1", f = "SessionLifecycleClient.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
final class SessionLifecycleClient$sendLifecycleEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int X2;
    final /* synthetic */ SessionLifecycleClient Y2;
    final /* synthetic */ List<Message> Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SessionLifecycleClient$sendLifecycleEvents$1(SessionLifecycleClient sessionLifecycleClient, List<Message> list, Continuation<? super SessionLifecycleClient$sendLifecycleEvents$1> continuation) {
        super(2, continuation);
        this.Y2 = sessionLifecycleClient;
        this.Z2 = list;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        String str;
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.f25140a;
            this.X2 = 1;
            obj = firebaseSessionsDependencies.c(this);
            if (obj == l2) {
                return l2;
            }
        } else if (i2 == 1) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map map = (Map) obj;
        if (map.isEmpty()) {
            str = "Sessions SDK did not have any dependent SDKs register as dependencies. Events will not be sent.";
        } else {
            Collection<SessionSubscriber> values = map.values();
            if (!(values instanceof Collection) || !values.isEmpty()) {
                for (SessionSubscriber a2 : values) {
                    if (a2.a()) {
                        List<Message> r5 = CollectionsKt.r5(CollectionsKt.p2(CollectionsKt.P(this.Y2.l(this.Z2, 2), this.Y2.l(this.Z2, 1))), new SessionLifecycleClient$sendLifecycleEvents$1$invokeSuspend$$inlined$sortedBy$1());
                        SessionLifecycleClient sessionLifecycleClient = this.Y2;
                        for (Message e2 : r5) {
                            sessionLifecycleClient.p(e2);
                        }
                        return Unit.f28779a;
                    }
                }
            }
            str = "Data Collection is disabled for all subscribers. Skipping this Event";
        }
        Log.d(SessionLifecycleClient.f25124g, str);
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SessionLifecycleClient$sendLifecycleEvents$1) v(coroutineScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SessionLifecycleClient$sendLifecycleEvents$1(this.Y2, this.Z2, continuation);
    }
}
