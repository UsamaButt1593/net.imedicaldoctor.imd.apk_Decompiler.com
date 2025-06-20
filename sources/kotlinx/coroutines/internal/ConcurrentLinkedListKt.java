package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ao\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u000228\u0010\b\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00028\u00000\u0004H\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\u000e\u001a\u00028\u0000\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\f*\u00028\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0013\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u001a\u0010\u0018\u001a\u00020\u00148\u0002X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0015\u0012\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/internal/Segment;", "S", "", "id", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "prev", "createNewSegment", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "c", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "b", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "", "a", "I", "POINTERS_SHIFT", "Lkotlinx/coroutines/internal/Symbol;", "Lkotlinx/coroutines/internal/Symbol;", "d", "()V", "CLOSED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class ConcurrentLinkedListKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f29337a = 16;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final Symbol f29338b = new Symbol("CLOSED");

    @NotNull
    public static final <N extends ConcurrentLinkedListNode<N>> N b(@NotNull N n2) {
        while (true) {
            N a2 = n2.e();
            if (a2 == f29338b) {
                return n2;
            }
            N n3 = (ConcurrentLinkedListNode) a2;
            if (n3 != null) {
                n2 = n3;
            } else if (n2.j()) {
                return n2;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super S, ? extends S>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <S extends kotlinx.coroutines.internal.Segment<S>> java.lang.Object c(S r4, long r5, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super S, ? extends S> r7) {
        /*
        L_0x0000:
            long r0 = r4.o()
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 < 0) goto L_0x0014
            boolean r0 = r4.g()
            if (r0 == 0) goto L_0x000f
            goto L_0x0014
        L_0x000f:
            java.lang.Object r4 = kotlinx.coroutines.internal.SegmentOrClosed.b(r4)
            return r4
        L_0x0014:
            java.lang.Object r0 = r4.e()
            kotlinx.coroutines.internal.Symbol r1 = f29338b
            if (r0 != r1) goto L_0x0027
            kotlinx.coroutines.internal.Symbol r4 = f29338b
            java.lang.Object r4 = kotlinx.coroutines.internal.SegmentOrClosed.b(r4)
            return r4
        L_0x0027:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r0
            kotlinx.coroutines.internal.Segment r0 = (kotlinx.coroutines.internal.Segment) r0
            if (r0 == 0) goto L_0x002f
        L_0x002d:
            r4 = r0
            goto L_0x0000
        L_0x002f:
            long r0 = r4.o()
            r2 = 1
            long r0 = r0 + r2
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.Object r0 = r7.d0(r0, r4)
            kotlinx.coroutines.internal.Segment r0 = (kotlinx.coroutines.internal.Segment) r0
            boolean r1 = r4.m(r0)
            if (r1 == 0) goto L_0x0000
            boolean r1 = r4.g()
            if (r1 == 0) goto L_0x002d
            r4.l()
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ConcurrentLinkedListKt.c(kotlinx.coroutines.internal.Segment, long, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    private static /* synthetic */ void d() {
    }
}
