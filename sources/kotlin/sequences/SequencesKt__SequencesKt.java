package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\t\u001a5\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t\"\u00028\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a9\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004¢\u0006\u0004\b\u0014\u0010\u0010\u001a+\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00150\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\u0010\u001aE\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001aG\u0010\u001d\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001c0\u001b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0017*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b0\u0004¢\u0006\u0004\b\u001d\u0010\u001e\u001a%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b\u001f\u0010\u0010\u001a-\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b\"\u0010#\u001ai\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010$\"\u0004\b\u0002\u0010\u00172\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00020\u0018H\u0000¢\u0006\u0004\b)\u0010*\u001a#\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b+\u0010\u0010\u001a-\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020,2\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b.\u0010\u0006\u001a?\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020,2\b\u0010/\u001a\u0004\u0018\u00018\u00002\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0018H\u0007¢\u0006\u0004\b0\u00101\u001aC\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0000*\u00020,2\u000e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00012\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0018¢\u0006\u0004\b3\u00104\u0002\u0007\n\u0005\b20\u0001¨\u00065"}, d2 = {"T", "Lkotlin/Function0;", "", "iterator", "Lkotlin/sequences/Sequence;", "d", "(Lkotlin/jvm/functions/Function0;)Lkotlin/sequences/Sequence;", "e", "(Ljava/util/Iterator;)Lkotlin/sequences/Sequence;", "", "elements", "q", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "g", "()Lkotlin/sequences/Sequence;", "p", "(Lkotlin/sequences/Sequence;)Lkotlin/sequences/Sequence;", "defaultValue", "o", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function0;)Lkotlin/sequences/Sequence;", "i", "", "k", "R", "Lkotlin/Function1;", "j", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "", "t", "(Lkotlin/sequences/Sequence;)Lkotlin/Pair;", "r", "Lkotlin/random/Random;", "random", "s", "(Lkotlin/sequences/Sequence;Lkotlin/random/Random;)Lkotlin/sequences/Sequence;", "C", "source", "Lkotlin/Function2;", "", "transform", "h", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "f", "", "nextFunction", "m", "seed", "l", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "seedFunction", "n", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/sequences/SequencesKt")
class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {
    @InlineOnly
    private static final <T> Sequence<T> d(Function0<? extends Iterator<? extends T>> function0) {
        Intrinsics.p(function0, "iterator");
        return new SequencesKt__SequencesKt$Sequence$1(function0);
    }

    @NotNull
    public static <T> Sequence<T> e(@NotNull Iterator<? extends T> it2) {
        Intrinsics.p(it2, "<this>");
        return SequencesKt.f(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(it2));
    }

    @NotNull
    public static <T> Sequence<T> f(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.p(sequence, "<this>");
        return sequence instanceof ConstrainedOnceSequence ? sequence : new ConstrainedOnceSequence(sequence);
    }

    @NotNull
    public static <T> Sequence<T> g() {
        return EmptySequence.f29001a;
    }

    @NotNull
    public static final <T, C, R> Sequence<R> h(@NotNull Sequence<? extends T> sequence, @NotNull Function2<? super Integer, ? super T, ? extends C> function2, @NotNull Function1<? super C, ? extends Iterator<? extends R>> function1) {
        Intrinsics.p(sequence, "source");
        Intrinsics.p(function2, "transform");
        Intrinsics.p(function1, "iterator");
        return SequencesKt.b(new SequencesKt__SequencesKt$flatMapIndexed$1(sequence, function2, function1, (Continuation<? super SequencesKt__SequencesKt$flatMapIndexed$1>) null));
    }

    @NotNull
    public static final <T> Sequence<T> i(@NotNull Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics.p(sequence, "<this>");
        return j(sequence, SequencesKt__SequencesKt$flatten$1.X);
    }

    private static final <T, R> Sequence<R> j(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        return sequence instanceof TransformingSequence ? ((TransformingSequence) sequence).e(function1) : new FlatteningSequence(sequence, SequencesKt__SequencesKt$flatten$3.X, function1);
    }

    @NotNull
    @JvmName(name = "flattenSequenceOfIterable")
    public static final <T> Sequence<T> k(@NotNull Sequence<? extends Iterable<? extends T>> sequence) {
        Intrinsics.p(sequence, "<this>");
        return j(sequence, SequencesKt__SequencesKt$flatten$2.X);
    }

    @NotNull
    @LowPriorityInOverloadResolution
    public static <T> Sequence<T> l(@Nullable T t, @NotNull Function1<? super T, ? extends T> function1) {
        Intrinsics.p(function1, "nextFunction");
        return t == null ? EmptySequence.f29001a : new GeneratorSequence(new SequencesKt__SequencesKt$generateSequence$2(t), function1);
    }

    @NotNull
    public static final <T> Sequence<T> m(@NotNull Function0<? extends T> function0) {
        Intrinsics.p(function0, "nextFunction");
        return SequencesKt.f(new GeneratorSequence(function0, new SequencesKt__SequencesKt$generateSequence$1(function0)));
    }

    @NotNull
    public static <T> Sequence<T> n(@NotNull Function0<? extends T> function0, @NotNull Function1<? super T, ? extends T> function1) {
        Intrinsics.p(function0, "seedFunction");
        Intrinsics.p(function1, "nextFunction");
        return new GeneratorSequence(function0, function1);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final <T> Sequence<T> o(@NotNull Sequence<? extends T> sequence, @NotNull Function0<? extends Sequence<? extends T>> function0) {
        Intrinsics.p(sequence, "<this>");
        Intrinsics.p(function0, "defaultValue");
        return SequencesKt.b(new SequencesKt__SequencesKt$ifEmpty$1(sequence, function0, (Continuation<? super SequencesKt__SequencesKt$ifEmpty$1>) null));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Sequence<T> p(Sequence<? extends T> sequence) {
        return sequence == null ? SequencesKt.g() : sequence;
    }

    @NotNull
    public static <T> Sequence<T> q(@NotNull T... tArr) {
        Intrinsics.p(tArr, "elements");
        return tArr.length == 0 ? SequencesKt.g() : ArraysKt.K5(tArr);
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    public static final <T> Sequence<T> r(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.p(sequence, "<this>");
        return s(sequence, Random.s);
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    public static final <T> Sequence<T> s(@NotNull Sequence<? extends T> sequence, @NotNull Random random) {
        Intrinsics.p(sequence, "<this>");
        Intrinsics.p(random, "random");
        return SequencesKt.b(new SequencesKt__SequencesKt$shuffled$1(sequence, random, (Continuation<? super SequencesKt__SequencesKt$shuffled$1>) null));
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> t(@NotNull Sequence<? extends Pair<? extends T, ? extends R>> sequence) {
        Intrinsics.p(sequence, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : sequence) {
            arrayList.add(pair.e());
            arrayList2.add(pair.f());
        }
        return TuplesKt.a(arrayList, arrayList2);
    }
}
