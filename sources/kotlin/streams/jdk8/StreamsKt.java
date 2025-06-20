package kotlin.streams.jdk8;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002*\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002*\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002*\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0019\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013*\u00020\u0005H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0013*\u00020\tH\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0019\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013*\u00020\rH\u0007¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"T", "Ljava/util/stream/Stream;", "Lkotlin/sequences/Sequence;", "e", "(Ljava/util/stream/Stream;)Lkotlin/sequences/Sequence;", "Ljava/util/stream/IntStream;", "", "c", "(Ljava/util/stream/IntStream;)Lkotlin/sequences/Sequence;", "Ljava/util/stream/LongStream;", "", "d", "(Ljava/util/stream/LongStream;)Lkotlin/sequences/Sequence;", "Ljava/util/stream/DoubleStream;", "", "b", "(Ljava/util/stream/DoubleStream;)Lkotlin/sequences/Sequence;", "f", "(Lkotlin/sequences/Sequence;)Ljava/util/stream/Stream;", "", "k", "(Ljava/util/stream/Stream;)Ljava/util/List;", "i", "(Ljava/util/stream/IntStream;)Ljava/util/List;", "j", "(Ljava/util/stream/LongStream;)Ljava/util/List;", "h", "(Ljava/util/stream/DoubleStream;)Ljava/util/List;", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "StreamsKt")
public final class StreamsKt {
    @NotNull
    @SinceKotlin(version = "1.2")
    public static final Sequence<Double> b(@NotNull DoubleStream doubleStream) {
        Intrinsics.p(doubleStream, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$4(doubleStream);
    }

    @NotNull
    @SinceKotlin(version = "1.2")
    public static final Sequence<Integer> c(@NotNull IntStream intStream) {
        Intrinsics.p(intStream, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$2(intStream);
    }

    @NotNull
    @SinceKotlin(version = "1.2")
    public static final Sequence<Long> d(@NotNull LongStream longStream) {
        Intrinsics.p(longStream, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$3(longStream);
    }

    @NotNull
    @SinceKotlin(version = "1.2")
    public static final <T> Sequence<T> e(@NotNull Stream<T> stream) {
        Intrinsics.p(stream, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$1(stream);
    }

    @NotNull
    @SinceKotlin(version = "1.2")
    public static final <T> Stream<T> f(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.p(sequence, "<this>");
        Stream<T> a2 = StreamSupport.stream(new g(sequence), 16, false);
        Intrinsics.o(a2, "stream({ Spliterators.sp…literator.ORDERED, false)");
        return a2;
    }

    /* access modifiers changed from: private */
    public static final Spliterator g(Sequence sequence) {
        Intrinsics.p(sequence, "$this_asStream");
        return Spliterators.spliteratorUnknownSize(sequence.iterator(), 16);
    }

    @NotNull
    @SinceKotlin(version = "1.2")
    public static final List<Double> h(@NotNull DoubleStream doubleStream) {
        Intrinsics.p(doubleStream, "<this>");
        double[] a2 = doubleStream.toArray();
        Intrinsics.o(a2, "toArray()");
        return ArraysKt.p(a2);
    }

    @NotNull
    @SinceKotlin(version = "1.2")
    public static final List<Integer> i(@NotNull IntStream intStream) {
        Intrinsics.p(intStream, "<this>");
        int[] a2 = intStream.toArray();
        Intrinsics.o(a2, "toArray()");
        return ArraysKt.r(a2);
    }

    @NotNull
    @SinceKotlin(version = "1.2")
    public static final List<Long> j(@NotNull LongStream longStream) {
        Intrinsics.p(longStream, "<this>");
        long[] a2 = longStream.toArray();
        Intrinsics.o(a2, "toArray()");
        return ArraysKt.s(a2);
    }

    @NotNull
    @SinceKotlin(version = "1.2")
    public static final <T> List<T> k(@NotNull Stream<T> stream) {
        Intrinsics.p(stream, "<this>");
        Object a2 = stream.collect(Collectors.toList());
        Intrinsics.o(a2, "collect(Collectors.toList<T>())");
        return (List) a2;
    }
}
