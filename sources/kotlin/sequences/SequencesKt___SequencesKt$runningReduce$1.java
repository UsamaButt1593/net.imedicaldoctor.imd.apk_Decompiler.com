package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "S", "T", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {2366, 2369}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class SequencesKt___SequencesKt$runningReduce$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {
    int X2;
    Object Y;
    private /* synthetic */ Object Y2;
    Object Z;
    final /* synthetic */ Sequence<T> Z2;
    final /* synthetic */ Function2<S, T, S> a3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningReduce$1(Sequence<? extends T> sequence, Function2<? super S, ? super T, ? extends S> function2, Continuation<? super SequencesKt___SequencesKt$runningReduce$1> continuation) {
        super(2, continuation);
        this.Z2 = sequence;
        this.a3 = function2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: kotlin.sequences.SequenceScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r6.X2
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 == r3) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            goto L_0x0017
        L_0x000f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0017:
            java.lang.Object r1 = r6.Z
            java.lang.Object r3 = r6.Y
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r6.Y2
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.ResultKt.n(r7)
            goto L_0x004d
        L_0x0025:
            kotlin.ResultKt.n(r7)
            java.lang.Object r7 = r6.Y2
            r4 = r7
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.sequences.Sequence<T> r7 = r6.Z2
            java.util.Iterator r7 = r7.iterator()
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x006c
            java.lang.Object r1 = r7.next()
            r6.Y2 = r4
            r6.Y = r7
            r6.Z = r1
            r6.X2 = r3
            java.lang.Object r3 = r4.a(r1, r6)
            if (r3 != r0) goto L_0x004c
            return r0
        L_0x004c:
            r3 = r7
        L_0x004d:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x006c
            kotlin.jvm.functions.Function2<S, T, S> r7 = r6.a3
            java.lang.Object r5 = r3.next()
            java.lang.Object r1 = r7.d0(r1, r5)
            r6.Y2 = r4
            r6.Y = r3
            r6.Z = r1
            r6.X2 = r2
            java.lang.Object r7 = r4.a(r1, r6)
            if (r7 != r0) goto L_0x004d
            return r0
        L_0x006c:
            kotlin.Unit r7 = kotlin.Unit.f28779a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: J */
    public final Object d0(@NotNull SequenceScope<? super S> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$runningReduce$1) v(sequenceScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(this.Z2, this.a3, continuation);
        sequencesKt___SequencesKt$runningReduce$1.Y2 = obj;
        return sequencesKt___SequencesKt$runningReduce$1;
    }
}
