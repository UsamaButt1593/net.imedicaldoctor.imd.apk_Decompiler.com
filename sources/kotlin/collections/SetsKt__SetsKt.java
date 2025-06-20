package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\"\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\b¢\u0006\u0004\b\b\u0010\u0003\u001a\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000H\b¢\u0006\u0004\b\n\u0010\u0003\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\"\u00028\u0000¢\u0006\u0004\b\u000b\u0010\u0007\u001a&\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\fj\b\u0012\u0004\u0012\u00028\u0000`\r\"\u0004\b\u0000\u0010\u0000H\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a7\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00028\u00000\fj\b\u0012\u0004\u0012\u00028\u0000`\r\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\"\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0012j\b\u0012\u0004\u0012\u00028\u0000`\u0013\"\u0004\b\u0000\u0010\u0000H\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a7\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0012j\b\u0012\u0004\u0012\u00028\u0000`\u0013\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\"\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a)\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a7\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u00182\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0004\"\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u001c\u0010\u0007\u001aM\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u001d2\u001f\b\u0001\u0010!\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\"\u0010#\u001aU\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u001d2\u0006\u0010%\u001a\u00020$2\u001f\b\u0001\u0010!\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b&\u0010'\u001a(\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001H\b¢\u0006\u0004\b(\u0010)\u001a%\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b*\u0010)\u0002\u0007\n\u0005\b20\u0001¨\u0006+"}, d2 = {"T", "", "k", "()Ljava/util/Set;", "", "elements", "u", "([Ljava/lang/Object;)Ljava/util/Set;", "t", "", "p", "q", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "l", "()Ljava/util/HashSet;", "m", "([Ljava/lang/Object;)Ljava/util/HashSet;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "n", "()Ljava/util/LinkedHashSet;", "o", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "", "element", "v", "(Ljava/lang/Object;)Ljava/util/Set;", "w", "E", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "j", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Set;", "", "capacity", "i", "(ILkotlin/jvm/functions/Function1;)Ljava/util/Set;", "s", "(Ljava/util/Set;)Ljava/util/Set;", "r", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/SetsKt")
class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final <E> Set<E> i(int i2, @BuilderInference Function1<? super Set<E>, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        Set e2 = SetsKt.e(i2);
        function1.f(e2);
        return SetsKt.a(e2);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final <E> Set<E> j(@BuilderInference Function1<? super Set<E>, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        Set d2 = SetsKt__SetsJVMKt.d();
        function1.f(d2);
        return SetsKt.a(d2);
    }

    @NotNull
    public static <T> Set<T> k() {
        return EmptySet.s;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> HashSet<T> l() {
        return new HashSet<>();
    }

    @NotNull
    public static final <T> HashSet<T> m(@NotNull T... tArr) {
        Intrinsics.p(tArr, "elements");
        return (HashSet) ArraysKt___ArraysKt.py(tArr, new HashSet(MapsKt.j(tArr.length)));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> LinkedHashSet<T> n() {
        return new LinkedHashSet<>();
    }

    @NotNull
    public static final <T> LinkedHashSet<T> o(@NotNull T... tArr) {
        Intrinsics.p(tArr, "elements");
        return (LinkedHashSet) ArraysKt___ArraysKt.py(tArr, new LinkedHashSet(MapsKt.j(tArr.length)));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> Set<T> p() {
        return new LinkedHashSet();
    }

    @NotNull
    public static final <T> Set<T> q(@NotNull T... tArr) {
        Intrinsics.p(tArr, "elements");
        return (Set) ArraysKt___ArraysKt.py(tArr, new LinkedHashSet(MapsKt.j(tArr.length)));
    }

    @NotNull
    public static final <T> Set<T> r(@NotNull Set<? extends T> set) {
        Intrinsics.p(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : SetsKt.f(set.iterator().next());
        }
        return SetsKt.k();
    }

    @InlineOnly
    private static final <T> Set<T> s(Set<? extends T> set) {
        return set == null ? SetsKt.k() : set;
    }

    @InlineOnly
    private static final <T> Set<T> t() {
        return SetsKt.k();
    }

    @NotNull
    public static final <T> Set<T> u(@NotNull T... tArr) {
        Intrinsics.p(tArr, "elements");
        return tArr.length > 0 ? ArraysKt___ArraysKt.mz(tArr) : SetsKt.k();
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    public static final <T> Set<T> v(@Nullable T t) {
        return t != null ? SetsKt.f(t) : SetsKt.k();
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    public static final <T> Set<T> w(@NotNull T... tArr) {
        Intrinsics.p(tArr, "elements");
        return (Set) ArraysKt___ArraysKt.Ua(tArr, new LinkedHashSet());
    }
}
