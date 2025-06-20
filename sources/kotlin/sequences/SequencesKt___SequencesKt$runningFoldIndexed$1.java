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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2336, 2341}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "index"}, s = {"L$0", "L$0", "L$1", "I$0"})
final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    int X2;
    Object Y;
    int Y2;
    Object Z;
    private /* synthetic */ Object Z2;
    final /* synthetic */ R a3;
    final /* synthetic */ Sequence<T> b3;
    final /* synthetic */ Function3<Integer, R, T, R> c3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$runningFoldIndexed$1(R r, Sequence<? extends T> sequence, Function3<? super Integer, ? super R, ? super T, ? extends R> function3, Continuation<? super SequencesKt___SequencesKt$runningFoldIndexed$1> continuation) {
        super(2, continuation);
        this.a3 = r;
        this.b3 = sequence;
        this.c3 = function3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlin.sequences.SequenceScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0055  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r8.Y2
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0030
            if (r1 == r3) goto L_0x0028
            if (r1 != r2) goto L_0x0020
            int r1 = r8.X2
            java.lang.Object r3 = r8.Z
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r8.Y
            java.lang.Object r5 = r8.Z2
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.ResultKt.n(r9)
            r9 = r4
            r4 = r1
            goto L_0x004f
        L_0x0020:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0028:
            java.lang.Object r1 = r8.Z2
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            kotlin.ResultKt.n(r9)
            goto L_0x0045
        L_0x0030:
            kotlin.ResultKt.n(r9)
            java.lang.Object r9 = r8.Z2
            r1 = r9
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            R r9 = r8.a3
            r8.Z2 = r1
            r8.Y2 = r3
            java.lang.Object r9 = r1.a(r9, r8)
            if (r9 != r0) goto L_0x0045
            return r0
        L_0x0045:
            R r9 = r8.a3
            kotlin.sequences.Sequence<T> r3 = r8.b3
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
            r5 = r1
        L_0x004f:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x007e
            java.lang.Object r1 = r3.next()
            kotlin.jvm.functions.Function3<java.lang.Integer, R, T, R> r6 = r8.c3
            int r7 = r4 + 1
            if (r4 >= 0) goto L_0x0062
            kotlin.collections.CollectionsKt.W()
        L_0x0062:
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.f(r4)
            java.lang.Object r4 = r6.A(r4, r9, r1)
            r8.Z2 = r5
            r8.Y = r4
            r8.Z = r3
            r8.X2 = r7
            r8.Y2 = r2
            java.lang.Object r9 = r5.a(r4, r8)
            if (r9 != r0) goto L_0x007b
            return r0
        L_0x007b:
            r9 = r4
            r4 = r7
            goto L_0x004f
        L_0x007e:
            kotlin.Unit r9 = kotlin.Unit.f28779a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: J */
    public final Object d0(@NotNull SequenceScope<? super R> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) v(sequenceScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.a3, this.b3, this.c3, continuation);
        sequencesKt___SequencesKt$runningFoldIndexed$1.Z2 = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }
}
