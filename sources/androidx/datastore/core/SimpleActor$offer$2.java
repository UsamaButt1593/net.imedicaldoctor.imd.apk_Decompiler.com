package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", i = {}, l = {122, 122}, m = "invokeSuspend", n = {}, s = {})
final class SimpleActor$offer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object X2;
    int Y2;
    final /* synthetic */ SimpleActor<T> Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleActor$offer$2(SimpleActor<T> simpleActor, Continuation<? super SimpleActor$offer$2> continuation) {
        super(2, continuation);
        this.Z2 = simpleActor;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e  */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r5.Y2
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.n(r6)
            goto L_0x0062
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            java.lang.Object r1 = r5.X2
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            kotlin.ResultKt.n(r6)
            goto L_0x0056
        L_0x0022:
            kotlin.ResultKt.n(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.Z2
            java.util.concurrent.atomic.AtomicInteger r6 = r6.f6910d
            int r6 = r6.get()
            if (r6 <= 0) goto L_0x0033
            r6 = 1
            goto L_0x0034
        L_0x0033:
            r6 = 0
        L_0x0034:
            if (r6 == 0) goto L_0x0071
        L_0x0036:
            androidx.datastore.core.SimpleActor<T> r6 = r5.Z2
            kotlinx.coroutines.CoroutineScope r6 = r6.f6907a
            kotlinx.coroutines.CoroutineScopeKt.j(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.Z2
            kotlin.jvm.functions.Function2 r1 = r6.f6908b
            androidx.datastore.core.SimpleActor<T> r6 = r5.Z2
            kotlinx.coroutines.channels.Channel r6 = r6.f6909c
            r5.X2 = r1
            r5.Y2 = r3
            java.lang.Object r6 = r6.Q(r5)
            if (r6 != r0) goto L_0x0056
            return r0
        L_0x0056:
            r4 = 0
            r5.X2 = r4
            r5.Y2 = r2
            java.lang.Object r6 = r1.d0(r6, r5)
            if (r6 != r0) goto L_0x0062
            return r0
        L_0x0062:
            androidx.datastore.core.SimpleActor<T> r6 = r5.Z2
            java.util.concurrent.atomic.AtomicInteger r6 = r6.f6910d
            int r6 = r6.decrementAndGet()
            if (r6 != 0) goto L_0x0036
            kotlin.Unit r6 = kotlin.Unit.f28779a
            return r6
        L_0x0071:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SimpleActor$offer$2) v(coroutineScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SimpleActor$offer$2(this.Z2, continuation);
    }
}
