package com.google.firebase.sessions;

import android.util.Log;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/datastore/preferences/core/Preferences;", "exception", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$firebaseSessionDataFlow$1", f = "SessionDatastore.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
final class SessionDatastoreImpl$firebaseSessionDataFlow$1 extends SuspendLambda implements Function3<FlowCollector<? super Preferences>, Throwable, Continuation<? super Unit>, Object> {
    int X2;
    private /* synthetic */ Object Y2;
    /* synthetic */ Object Z2;

    SessionDatastoreImpl$firebaseSessionDataFlow$1(Continuation<? super SessionDatastoreImpl$firebaseSessionDataFlow$1> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            Log.e("FirebaseSessionsRepo", "Error reading stored session data.", (Throwable) this.Z2);
            Preferences b2 = PreferencesFactory.b();
            this.Y2 = null;
            this.X2 = 1;
            if (((FlowCollector) this.Y2).h(b2, this) == l2) {
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
    public final Object A(@NotNull FlowCollector<? super Preferences> flowCollector, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
        SessionDatastoreImpl$firebaseSessionDataFlow$1 sessionDatastoreImpl$firebaseSessionDataFlow$1 = new SessionDatastoreImpl$firebaseSessionDataFlow$1(continuation);
        sessionDatastoreImpl$firebaseSessionDataFlow$1.Y2 = flowCollector;
        sessionDatastoreImpl$firebaseSessionDataFlow$1.Z2 = th;
        return sessionDatastoreImpl$firebaseSessionDataFlow$1.D(Unit.f28779a);
    }
}
