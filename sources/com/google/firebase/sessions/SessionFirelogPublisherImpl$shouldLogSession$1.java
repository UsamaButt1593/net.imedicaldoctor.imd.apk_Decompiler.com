package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl", f = "SessionFirelogPublisher.kt", i = {0}, l = {94}, m = "shouldLogSession", n = {"this"}, s = {"L$0"})
final class SessionFirelogPublisherImpl$shouldLogSession$1 extends ContinuationImpl {
    /* synthetic */ Object X2;
    final /* synthetic */ SessionFirelogPublisherImpl Y2;
    Object Z;
    int Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SessionFirelogPublisherImpl$shouldLogSession$1(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, Continuation<? super SessionFirelogPublisherImpl$shouldLogSession$1> continuation) {
        super(continuation);
        this.Y2 = sessionFirelogPublisherImpl;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.X2 = obj;
        this.Z2 |= Integer.MIN_VALUE;
        return this.Y2.i(this);
    }
}
