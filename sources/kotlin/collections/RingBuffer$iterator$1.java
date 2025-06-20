package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer$iterator$1\n+ 2 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n1#1,207:1\n205#2:208\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer$iterator$1\n*L\n121#1:208\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"kotlin/collections/RingBuffer$iterator$1", "Lkotlin/collections/AbstractIterator;", "", "a", "()V", "", "Y", "I", "count", "Z", "index", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class RingBuffer$iterator$1 extends AbstractIterator<T> {
    final /* synthetic */ RingBuffer<T> X2;
    private int Y;
    private int Z;

    RingBuffer$iterator$1(RingBuffer<T> ringBuffer) {
        this.X2 = ringBuffer;
        this.Y = ringBuffer.size();
        this.Z = ringBuffer.Z;
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.Y == 0) {
            b();
            return;
        }
        c(this.X2.X[this.Z]);
        this.Z = (this.Z + 1) % this.X2.Y;
        this.Y--;
    }
}
