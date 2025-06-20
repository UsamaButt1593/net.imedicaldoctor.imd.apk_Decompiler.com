package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "S", "T", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2395, 2399}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", "index"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
final class SequencesKt___SequencesKt$runningReduceIndexed$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {
    int X2;
    Object Y;
    int Y2;
    Object Z;
    private /* synthetic */ Object Z2;
    final /* synthetic */ Sequence<T> a3;
    final /* synthetic */ Function3<Integer, S, T, S> b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningReduceIndexed$1(Sequence<? extends T> sequence, Function3<? super Integer, ? super S, ? super T, ? extends S> function3, Continuation<? super SequencesKt___SequencesKt$runningReduceIndexed$1> continuation) {
        super(2, continuation);
        this.a3 = sequence;
        this.b3 = function3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: kotlin.sequences.SequenceScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r9.Y2
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 == r3) goto L_0x0029
            if (r1 != r2) goto L_0x0021
            int r1 = r9.X2
            java.lang.Object r3 = r9.Z
            java.lang.Object r4 = r9.Y
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r9.Z2
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.ResultKt.n(r10)
            r8 = r3
            r3 = r1
            r1 = r8
            goto L_0x005e
        L_0x0021:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0029:
            java.lang.Object r1 = r9.Z
            java.lang.Object r4 = r9.Y
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r9.Z2
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.ResultKt.n(r10)
            goto L_0x005e
        L_0x0037:
            kotlin.ResultKt.n(r10)
            java.lang.Object r10 = r9.Z2
            r5 = r10
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.sequences.Sequence<T> r10 = r9.a3
            java.util.Iterator r4 = r10.iterator()
            boolean r10 = r4.hasNext()
            if (r10 == 0) goto L_0x008d
            java.lang.Object r1 = r4.next()
            r9.Z2 = r5
            r9.Y = r4
            r9.Z = r1
            r9.Y2 = r3
            java.lang.Object r10 = r5.a(r1, r9)
            if (r10 != r0) goto L_0x005e
            return r0
        L_0x005e:
            boolean r10 = r4.hasNext()
            if (r10 == 0) goto L_0x008d
            kotlin.jvm.functions.Function3<java.lang.Integer, S, T, S> r10 = r9.b3
            int r6 = r3 + 1
            if (r3 >= 0) goto L_0x006d
            kotlin.collections.CollectionsKt.W()
        L_0x006d:
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.f(r3)
            java.lang.Object r7 = r4.next()
            java.lang.Object r3 = r10.A(r3, r1, r7)
            r9.Z2 = r5
            r9.Y = r4
            r9.Z = r3
            r9.X2 = r6
            r9.Y2 = r2
            java.lang.Object r10 = r5.a(r3, r9)
            if (r10 != r0) goto L_0x008a
            return r0
        L_0x008a:
            r1 = r3
            r3 = r6
            goto L_0x005e
        L_0x008d:
            kotlin.Unit r10 = kotlin.Unit.f28779a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: J */
    public final Object d0(@NotNull SequenceScope<? super S> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1) v(sequenceScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.a3, this.b3, continuation);
        sequencesKt___SequencesKt$runningReduceIndexed$1.Z2 = obj;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }
}
