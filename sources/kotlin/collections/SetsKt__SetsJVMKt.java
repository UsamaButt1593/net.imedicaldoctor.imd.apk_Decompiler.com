package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.builders.SetBuilder;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a>\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aF\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\r2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0005H\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0018\"\u00028\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001aI\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0004\b\u0000\u0010\u00002\u001a\u0010\u001f\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u001dj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u001e2\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0018\"\u00028\u0000¢\u0006\u0004\b \u0010!\u0002\u0007\n\u0005\b20\u0001¨\u0006\""}, d2 = {"T", "element", "", "f", "(Ljava/lang/Object;)Ljava/util/Set;", "E", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "c", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Set;", "", "capacity", "b", "(ILkotlin/jvm/functions/Function1;)Ljava/util/Set;", "d", "()Ljava/util/Set;", "e", "(I)Ljava/util/Set;", "builder", "a", "(Ljava/util/Set;)Ljava/util/Set;", "", "elements", "Ljava/util/TreeSet;", "h", "([Ljava/lang/Object;)Ljava/util/TreeSet;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "g", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/SetsKt")
class SetsKt__SetsJVMKt {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> Set<E> a(@NotNull Set<E> set) {
        Intrinsics.p(set, "builder");
        return ((SetBuilder) set).c();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> Set<E> b(int i2, Function1<? super Set<E>, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        Set e2 = SetsKt.e(i2);
        function1.f(e2);
        return SetsKt.a(e2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> Set<E> c(Function1<? super Set<E>, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        Set d2 = d();
        function1.f(d2);
        return SetsKt.a(d2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final <E> Set<E> d() {
        return new SetBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> Set<E> e(int i2) {
        return new SetBuilder(i2);
    }

    @NotNull
    public static <T> Set<T> f(T t) {
        Set<T> singleton = Collections.singleton(t);
        Intrinsics.o(singleton, "singleton(element)");
        return singleton;
    }

    @NotNull
    public static final <T> TreeSet<T> g(@NotNull Comparator<? super T> comparator, @NotNull T... tArr) {
        Intrinsics.p(comparator, "comparator");
        Intrinsics.p(tArr, "elements");
        return (TreeSet) ArraysKt___ArraysKt.py(tArr, new TreeSet(comparator));
    }

    @NotNull
    public static final <T> TreeSet<T> h(@NotNull T... tArr) {
        Intrinsics.p(tArr, "elements");
        return (TreeSet) ArraysKt___ArraysKt.py(tArr, new TreeSet());
    }
}
