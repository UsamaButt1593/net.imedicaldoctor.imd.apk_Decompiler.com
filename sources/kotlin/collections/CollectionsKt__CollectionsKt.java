package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.comparisons.ComparisonsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000H\b¢\u0006\u0004\b\u000b\u0010\u0007\u001a\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u0000H\b¢\u0006\u0004\b\r\u0010\u0007\u001a&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000ej\b\u0012\u0004\u0012\u00028\u0000`\u000f\"\u0004\b\u0000\u0010\u0000H\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a7\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000ej\b\u0012\u0004\u0012\u00028\u0000`\u000f\"\u0004\b\u0000\u0010\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a5\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00152\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0001\"\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0019\u0010\n\u001aJ\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u001b\u001a\u00020\u001a2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00028\u00000\u001cH\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001aJ\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u001b\u001a\u00020\u001a2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00028\u00000\u001cH\bø\u0001\u0000¢\u0006\u0004\b#\u0010\"\u001aM\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00062\u001f\b\u0001\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00020$0\u001c¢\u0006\u0002\b%H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b'\u0010(\u001aU\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010)\u001a\u00020\u001a2\u001f\b\u0001\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00020$0\u001c¢\u0006\u0002\b%H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b*\u0010\"\u001a \u0010,\u001a\u00020+\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\b¢\u0006\u0004\b,\u0010-\u001a3\u0010.\u001a\u00020+\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b.\u0010-\u001a(\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\b¢\u0006\u0004\b/\u00100\u001a(\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H\b¢\u0006\u0004\b1\u00102\u001a=\u00105\u001a\u00028\u0001\"\u0010\b\u0000\u0010'*\u0006\u0012\u0002\b\u00030\u0002*\u00028\u0001\"\u0004\b\u0001\u0010/*\u00028\u00002\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000103H\bø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a3\u00108\u001a\u00020+\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b7*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\b¢\u0006\u0004\b8\u00109\u001a-\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000:2\u0006\u0010<\u001a\u00020;H\u0007¢\u0006\u0004\b=\u0010>\u001a%\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000¢\u0006\u0004\b?\u00102\u001aG\u0010C\u001a\u00020\u001a\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000@*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00052\b\u0010\u0016\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010A\u001a\u00020\u001a2\b\b\u0002\u0010B\u001a\u00020\u001a¢\u0006\u0004\bC\u0010D\u001aU\u0010H\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0016\u001a\u00028\u00002\u001a\u0010G\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Ej\n\u0012\u0006\b\u0000\u0012\u00028\u0000`F2\b\b\u0002\u0010A\u001a\u00020\u001a2\b\b\u0002\u0010B\u001a\u00020\u001a¢\u0006\u0004\bH\u0010I\u001ai\u0010L\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00010@*\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0010J\u001a\u0004\u0018\u00018\u00012\b\b\u0002\u0010A\u001a\u00020\u001a2\b\b\u0002\u0010B\u001a\u00020\u001a2\u0016\b\u0004\u0010K\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u001cH\bø\u0001\u0000¢\u0006\u0004\bL\u0010M\u001aE\u0010O\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\b\b\u0002\u0010A\u001a\u00020\u001a2\b\b\u0002\u0010B\u001a\u00020\u001a2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\u0004\bO\u0010P\u001a'\u0010\u0000\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u0000\u0010Q\u001a\u000f\u0010R\u001a\u00020$H\u0001¢\u0006\u0004\bR\u0010S\u001a\u000f\u0010T\u001a\u00020$H\u0001¢\u0006\u0004\bT\u0010S\"\u0019\u0010X\u001a\u00020U*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\bV\u0010W\"!\u0010[\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00058F¢\u0006\u0006\u001a\u0004\bY\u0010Z\u0002\u0007\n\u0005\b20\u0001¨\u0006\\"}, d2 = {"T", "", "", "s", "([Ljava/lang/Object;)Ljava/util/Collection;", "", "E", "()Ljava/util/List;", "elements", "L", "([Ljava/lang/Object;)Ljava/util/List;", "K", "", "O", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "q", "()Ljava/util/ArrayList;", "P", "r", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "", "element", "M", "(Ljava/lang/Object;)Ljava/util/List;", "N", "", "size", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "init", "o", "(ILkotlin/jvm/functions/Function1;)Ljava/util/List;", "p", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "C", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "capacity", "B", "", "I", "(Ljava/util/Collection;)Z", "J", "R", "(Ljava/util/Collection;)Ljava/util/Collection;", "S", "(Ljava/util/List;)Ljava/util/List;", "Lkotlin/Function0;", "defaultValue", "H", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/internal/OnlyInputTypes;", "D", "(Ljava/util/Collection;Ljava/util/Collection;)Z", "", "Lkotlin/random/Random;", "random", "U", "(Ljava/lang/Iterable;Lkotlin/random/Random;)Ljava/util/List;", "Q", "", "fromIndex", "toIndex", "u", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "v", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "key", "selector", "z", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "comparison", "t", "(Ljava/util/List;IILkotlin/jvm/functions/Function1;)I", "(III)V", "W", "()V", "V", "Lkotlin/ranges/IntRange;", "F", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "indices", "G", "(Ljava/util/List;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/CollectionsKt")
@SourceDebugExtension({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,481:1\n404#1:483\n1#2:482\n*S KotlinDebug\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n*L\n398#1:483\n*E\n"})
class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public static /* synthetic */ int A(List list, Comparable comparable, int i2, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = list.size();
        }
        return t(list, i2, i3, new CollectionsKt__CollectionsKt$binarySearchBy$1(function1, comparable));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final <E> List<E> B(int i2, @BuilderInference Function1<? super List<E>, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        List j2 = CollectionsKt.j(i2);
        function1.f(j2);
        return CollectionsKt.a(j2);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final <E> List<E> C(@BuilderInference Function1<? super List<E>, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        List i2 = CollectionsKt.i();
        function1.f(i2);
        return CollectionsKt.a(i2);
    }

    @InlineOnly
    private static final <T> boolean D(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(collection2, "elements");
        return collection.containsAll(collection2);
    }

    @NotNull
    public static <T> List<T> E() {
        return EmptyList.s;
    }

    @NotNull
    public static IntRange F(@NotNull Collection<?> collection) {
        Intrinsics.p(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static <T> int G(@NotNull List<? extends T> list) {
        Intrinsics.p(list, "<this>");
        return list.size() - 1;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [R, C, java.util.Collection] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.internal.InlineOnly
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <C extends java.util.Collection<?> & R, R> R H(C r1, kotlin.jvm.functions.Function0<? extends R> r2) {
        /*
            java.lang.String r0 = "defaultValue"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x000f
            java.lang.Object r1 = r2.o()
        L_0x000f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt__CollectionsKt.H(java.util.Collection, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    @InlineOnly
    private static final <T> boolean I(Collection<? extends T> collection) {
        Intrinsics.p(collection, "<this>");
        return !collection.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> boolean J(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    @InlineOnly
    private static final <T> List<T> K() {
        return CollectionsKt.E();
    }

    @NotNull
    public static <T> List<T> L(@NotNull T... tArr) {
        Intrinsics.p(tArr, "elements");
        return tArr.length > 0 ? ArraysKt.t(tArr) : CollectionsKt.E();
    }

    @NotNull
    public static final <T> List<T> M(@Nullable T t) {
        return t != null ? CollectionsKt.k(t) : CollectionsKt.E();
    }

    @NotNull
    public static final <T> List<T> N(@NotNull T... tArr) {
        Intrinsics.p(tArr, "elements");
        return ArraysKt.Ta(tArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> O() {
        return new ArrayList();
    }

    @NotNull
    public static <T> List<T> P(@NotNull T... tArr) {
        Intrinsics.p(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(tArr, true));
    }

    @NotNull
    public static final <T> List<T> Q(@NotNull List<? extends T> list) {
        Intrinsics.p(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : CollectionsKt.k(list.get(0));
        }
        return CollectionsKt.E();
    }

    @InlineOnly
    private static final <T> Collection<T> R(Collection<? extends T> collection) {
        return collection == null ? CollectionsKt.E() : collection;
    }

    @InlineOnly
    private static final <T> List<T> S(List<? extends T> list) {
        return list == null ? CollectionsKt.E() : list;
    }

    private static final void T(int i2, int i3, int i4) {
        if (i3 > i4) {
            throw new IllegalArgumentException("fromIndex (" + i3 + ") is greater than toIndex (" + i4 + ").");
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i3 + ") is less than zero.");
        } else if (i4 > i2) {
            throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + i2 + ").");
        }
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final <T> List<T> U(@NotNull Iterable<? extends T> iterable, @NotNull Random random) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(random, "random");
        List<T> U5 = CollectionsKt___CollectionsKt.U5(iterable);
        CollectionsKt___CollectionsKt.b5(U5, random);
        return U5;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void V() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void W() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> o(int i2, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.p(function1, "init");
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(function1.f(Integer.valueOf(i3)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> p(int i2, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.p(function1, "init");
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(function1.f(Integer.valueOf(i3)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> ArrayList<T> q() {
        return new ArrayList<>();
    }

    @NotNull
    public static final <T> ArrayList<T> r(@NotNull T... tArr) {
        Intrinsics.p(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new ArrayAsCollection(tArr, true));
    }

    @NotNull
    public static final <T> Collection<T> s(@NotNull T[] tArr) {
        Intrinsics.p(tArr, "<this>");
        return new ArrayAsCollection(tArr, false);
    }

    public static final <T> int t(@NotNull List<? extends T> list, int i2, int i3, @NotNull Function1<? super T, Integer> function1) {
        Intrinsics.p(list, "<this>");
        Intrinsics.p(function1, "comparison");
        T(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int intValue = function1.f(list.get(i5)).intValue();
            if (intValue < 0) {
                i2 = i5 + 1;
            } else if (intValue <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final <T extends Comparable<? super T>> int u(@NotNull List<? extends T> list, @Nullable T t, int i2, int i3) {
        Intrinsics.p(list, "<this>");
        T(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int l2 = ComparisonsKt.l((Comparable) list.get(i5), t);
            if (l2 < 0) {
                i2 = i5 + 1;
            } else if (l2 <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final <T> int v(@NotNull List<? extends T> list, T t, @NotNull Comparator<? super T> comparator, int i2, int i3) {
        Intrinsics.p(list, "<this>");
        Intrinsics.p(comparator, "comparator");
        T(list.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int compare = comparator.compare(list.get(i5), t);
            if (compare < 0) {
                i2 = i5 + 1;
            } else if (compare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int w(List list, int i2, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = list.size();
        }
        return t(list, i2, i3, function1);
    }

    public static /* synthetic */ int x(List list, Comparable comparable, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = list.size();
        }
        return u(list, comparable, i2, i3);
    }

    public static /* synthetic */ int y(List list, Object obj, Comparator comparator, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = list.size();
        }
        return v(list, obj, comparator, i2, i3);
    }

    public static final <T, K extends Comparable<? super K>> int z(@NotNull List<? extends T> list, @Nullable K k2, int i2, int i3, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.p(list, "<this>");
        Intrinsics.p(function1, "selector");
        return t(list, i2, i3, new CollectionsKt__CollectionsKt$binarySearchBy$1(function1, k2));
    }
}
