package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$clearCachedSettings$1", f = "RemoteSettings.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
final class RemoteSettings$clearCachedSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int X2;
    final /* synthetic */ RemoteSettings Y2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoteSettings$clearCachedSettings$1(RemoteSettings remoteSettings, Continuation<? super RemoteSettings$clearCachedSettings$1> continuation) {
        super(2, continuation);
        this.Y2 = remoteSettings;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            SettingsCache f2 = this.Y2.h();
            this.X2 = 1;
            if (f2.j(this) == l2) {
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
        return ((RemoteSettings$clearCachedSettings$1) v(coroutineScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RemoteSettings$clearCachedSettings$1(this.Y2, continuation);
    }
}
