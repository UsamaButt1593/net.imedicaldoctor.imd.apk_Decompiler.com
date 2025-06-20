package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H@"}, d2 = {"<anonymous>", "", "E", "it"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1", f = "Deprecated.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
final class ChannelsKt__DeprecatedKt$filterNot$1 extends SuspendLambda implements Function2<Object, Continuation<? super Boolean>, Object> {
    int X2;
    /* synthetic */ Object Y2;
    final /* synthetic */ Function2<Object, Continuation<? super Boolean>, Object> Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$filterNot$1(Function2<Object, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$filterNot$1> continuation) {
        super(2, continuation);
        this.Z2 = function2;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            Object obj2 = this.Y2;
            Function2<Object, Continuation<? super Boolean>, Object> function2 = this.Z2;
            this.X2 = 1;
            obj = function2.d0(obj2, this);
            if (obj == l2) {
                return l2;
            }
        } else if (i2 == 1) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.a(!((Boolean) obj).booleanValue());
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(Object obj, @Nullable Continuation<? super Boolean> continuation) {
        return ((ChannelsKt__DeprecatedKt$filterNot$1) v(obj, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filterNot$1 channelsKt__DeprecatedKt$filterNot$1 = new ChannelsKt__DeprecatedKt$filterNot$1(this.Z2, continuation);
        channelsKt__DeprecatedKt$filterNot$1.Y2 = obj;
        return channelsKt__DeprecatedKt$filterNot$1;
    }
}
