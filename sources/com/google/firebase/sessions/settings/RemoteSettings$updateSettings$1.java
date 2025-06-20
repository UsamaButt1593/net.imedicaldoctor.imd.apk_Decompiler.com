package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings", f = "RemoteSettings.kt", i = {0, 0, 1, 1, 2}, l = {170, 76, 94}, m = "updateSettings", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
final class RemoteSettings$updateSettings$1 extends ContinuationImpl {
    Object X2;
    /* synthetic */ Object Y2;
    Object Z;
    final /* synthetic */ RemoteSettings Z2;
    int a3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteSettings$updateSettings$1(RemoteSettings remoteSettings, Continuation<? super RemoteSettings$updateSettings$1> continuation) {
        super(continuation);
        this.Z2 = remoteSettings;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Y2 = obj;
        this.a3 |= Integer.MIN_VALUE;
        return this.Z2.e(this);
    }
}
