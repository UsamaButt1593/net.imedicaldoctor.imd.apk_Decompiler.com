package com.google.firebase.sessions.settings;

import android.util.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "msg", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2", f = "RemoteSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RemoteSettings$updateSettings$2$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    int X2;
    /* synthetic */ Object Y2;

    RemoteSettings$updateSettings$2$2(Continuation<? super RemoteSettings$updateSettings$2$2> continuation) {
        super(2, continuation);
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        IntrinsicsKt.l();
        if (this.X2 == 0) {
            ResultKt.n(obj);
            Log.e(RemoteSettings.f25153h, "Error failing to fetch the remote configs: " + ((String) this.Y2));
            return Unit.f28779a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull String str, @Nullable Continuation<? super Unit> continuation) {
        return ((RemoteSettings$updateSettings$2$2) v(str, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(continuation);
        remoteSettings$updateSettings$2$2.Y2 = obj;
        return remoteSettings$updateSettings$2$2;
    }
}
