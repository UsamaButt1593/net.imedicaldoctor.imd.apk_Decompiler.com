package com.google.firebase.sessions.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.api.FirebaseSessionsDependencies", f = "FirebaseSessionsDependencies.kt", i = {0, 0, 0}, l = {124}, m = "getRegisteredSubscribers$com_google_firebase_firebase_sessions", n = {"destination$iv$iv", "subscriberName", "$this$withLock_u24default$iv"}, s = {"L$0", "L$2", "L$3"})
final class FirebaseSessionsDependencies$getRegisteredSubscribers$1 extends ContinuationImpl {
    Object X2;
    Object Y2;
    Object Z;
    Object Z2;
    Object a3;
    Object b3;
    /* synthetic */ Object c3;
    final /* synthetic */ FirebaseSessionsDependencies d3;
    int e3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FirebaseSessionsDependencies$getRegisteredSubscribers$1(FirebaseSessionsDependencies firebaseSessionsDependencies, Continuation<? super FirebaseSessionsDependencies$getRegisteredSubscribers$1> continuation) {
        super(continuation);
        this.d3 = firebaseSessionsDependencies;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.c3 = obj;
        this.e3 |= Integer.MIN_VALUE;
        return this.d3.c(this);
    }
}
