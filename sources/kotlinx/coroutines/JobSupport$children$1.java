package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/Job;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {952, 954}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object> {
    int X2;
    Object Y;
    private /* synthetic */ Object Y2;
    Object Z;
    final /* synthetic */ JobSupport Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JobSupport$children$1(JobSupport jobSupport, Continuation<? super JobSupport$children$1> continuation) {
        super(2, continuation);
        this.Z2 = jobSupport;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r6.X2
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002a
            if (r1 == r3) goto L_0x0026
            if (r1 != r2) goto L_0x001e
            java.lang.Object r1 = r6.Z
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            java.lang.Object r3 = r6.Y
            kotlinx.coroutines.internal.LockFreeLinkedListHead r3 = (kotlinx.coroutines.internal.LockFreeLinkedListHead) r3
            java.lang.Object r4 = r6.Y2
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.ResultKt.n(r7)
            goto L_0x007c
        L_0x001e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0026:
            kotlin.ResultKt.n(r7)
            goto L_0x0081
        L_0x002a:
            kotlin.ResultKt.n(r7)
            java.lang.Object r7 = r6.Y2
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            kotlinx.coroutines.JobSupport r1 = r6.Z2
            java.lang.Object r1 = r1.T0()
            boolean r4 = r1 instanceof kotlinx.coroutines.ChildHandleNode
            if (r4 == 0) goto L_0x0048
            kotlinx.coroutines.ChildHandleNode r1 = (kotlinx.coroutines.ChildHandleNode) r1
            kotlinx.coroutines.ChildJob r1 = r1.X2
            r6.X2 = r3
            java.lang.Object r7 = r7.a(r1, r6)
            if (r7 != r0) goto L_0x0081
            return r0
        L_0x0048:
            boolean r3 = r1 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto L_0x0081
            kotlinx.coroutines.Incomplete r1 = (kotlinx.coroutines.Incomplete) r1
            kotlinx.coroutines.NodeList r1 = r1.B()
            if (r1 == 0) goto L_0x0081
            java.lang.Object r3 = r1.I0()
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r4 = r7
            r5 = r3
            r3 = r1
            r1 = r5
        L_0x005e:
            boolean r7 = kotlin.jvm.internal.Intrinsics.g(r1, r3)
            if (r7 != 0) goto L_0x0081
            boolean r7 = r1 instanceof kotlinx.coroutines.ChildHandleNode
            if (r7 == 0) goto L_0x007c
            r7 = r1
            kotlinx.coroutines.ChildHandleNode r7 = (kotlinx.coroutines.ChildHandleNode) r7
            kotlinx.coroutines.ChildJob r7 = r7.X2
            r6.Y2 = r4
            r6.Y = r3
            r6.Z = r1
            r6.X2 = r2
            java.lang.Object r7 = r4.a(r7, r6)
            if (r7 != r0) goto L_0x007c
            return r0
        L_0x007c:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = r1.J0()
            goto L_0x005e
        L_0x0081:
            kotlin.Unit r7 = kotlin.Unit.f28779a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: J */
    public final Object d0(@NotNull SequenceScope<? super Job> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((JobSupport$children$1) v(sequenceScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.Z2, continuation);
        jobSupport$children$1.Y2 = obj;
        return jobSupport$children$1;
    }
}
