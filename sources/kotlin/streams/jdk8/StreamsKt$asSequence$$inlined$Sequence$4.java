package kotlin.streams.jdk8;

import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.stream.DoubleStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,680:1\n55#2:681\n*E\n"})
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StreamsKt$asSequence$$inlined$Sequence$4 implements Sequence<Double> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DoubleStream f29050a;

    public StreamsKt$asSequence$$inlined$Sequence$4(DoubleStream doubleStream) {
        this.f29050a = doubleStream;
    }

    @NotNull
    public Iterator<Double> iterator() {
        PrimitiveIterator.OfDouble a2 = this.f29050a.iterator();
        Intrinsics.o(a2, "iterator()");
        return a2;
    }
}
