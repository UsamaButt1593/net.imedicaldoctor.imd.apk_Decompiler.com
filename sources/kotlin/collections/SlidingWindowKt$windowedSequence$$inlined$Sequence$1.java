package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 SlidingWindow.kt\nkotlin/collections/SlidingWindowKt\n*L\n1#1,680:1\n19#2:681\n*E\n"})
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SlidingWindowKt$windowedSequence$$inlined$Sequence$1 implements Sequence<List<? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Sequence f28800a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f28801b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f28802c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f28803d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f28804e;

    public SlidingWindowKt$windowedSequence$$inlined$Sequence$1(Sequence sequence, int i2, int i3, boolean z, boolean z2) {
        this.f28800a = sequence;
        this.f28801b = i2;
        this.f28802c = i3;
        this.f28803d = z;
        this.f28804e = z2;
    }

    @NotNull
    public Iterator<List<? extends T>> iterator() {
        return SlidingWindowKt.b(this.f28800a.iterator(), this.f28801b, this.f28802c, this.f28803d, this.f28804e);
    }
}
