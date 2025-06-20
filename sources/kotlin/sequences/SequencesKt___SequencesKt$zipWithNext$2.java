package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0, 0, 0}, l = {2873}, m = "invokeSuspend", n = {"$this$result", "iterator", "next"}, s = {"L$0", "L$1", "L$2"})
final class SequencesKt___SequencesKt$zipWithNext$2 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    int X2;
    Object Y;
    private /* synthetic */ Object Y2;
    Object Z;
    final /* synthetic */ Sequence<T> Z2;
    final /* synthetic */ Function2<T, T, R> a3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$zipWithNext$2(Sequence<? extends T> sequence, Function2<? super T, ? super T, ? extends R> function2, Continuation<? super SequencesKt___SequencesKt$zipWithNext$2> continuation) {
        super(2, continuation);
        this.Z2 = sequence;
        this.a3 = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r6.X2
            r2 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            java.lang.Object r1 = r6.Z
            java.lang.Object r3 = r6.Y
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r6.Y2
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.ResultKt.n(r7)
        L_0x0018:
            r7 = r1
            goto L_0x003f
        L_0x001a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0022:
            kotlin.ResultKt.n(r7)
            java.lang.Object r7 = r6.Y2
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            kotlin.sequences.Sequence<T> r1 = r6.Z2
            java.util.Iterator r1 = r1.iterator()
            boolean r3 = r1.hasNext()
            if (r3 != 0) goto L_0x0038
            kotlin.Unit r7 = kotlin.Unit.f28779a
            return r7
        L_0x0038:
            java.lang.Object r3 = r1.next()
            r4 = r7
            r7 = r3
            r3 = r1
        L_0x003f:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x005e
            java.lang.Object r1 = r3.next()
            kotlin.jvm.functions.Function2<T, T, R> r5 = r6.a3
            java.lang.Object r7 = r5.d0(r7, r1)
            r6.Y2 = r4
            r6.Y = r3
            r6.Z = r1
            r6.X2 = r2
            java.lang.Object r7 = r4.a(r7, r6)
            if (r7 != r0) goto L_0x0018
            return r0
        L_0x005e:
            kotlin.Unit r7 = kotlin.Unit.f28779a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: J */
    public final Object d0(@NotNull SequenceScope<? super R> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) v(sequenceScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.Z2, this.a3, continuation);
        sequencesKt___SequencesKt$zipWithNext$2.Y2 = obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }
}
