package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a>\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aF\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\r2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0005H\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0018H\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a%\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b \u0010!\u001a$\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\"H\b¢\u0006\u0004\b&\u0010'\u001a6\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000$\"\u0004\b\u0000\u0010\u00002\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\"2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000$H\b¢\u0006\u0004\b)\u0010*\u001a3\u0010-\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010%0$\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000$2\u0006\u0010,\u001a\u00020+H\u0000¢\u0006\u0004\b-\u0010.\u001a\u0018\u00100\u001a\u00020\r2\u0006\u0010/\u001a\u00020\rH\b¢\u0006\u0004\b0\u00101\u001a\u0018\u00103\u001a\u00020\r2\u0006\u00102\u001a\u00020\rH\b¢\u0006\u0004\b3\u00101\u0002\u0007\n\u0005\b20\u0001¨\u00064"}, d2 = {"T", "element", "", "k", "(Ljava/lang/Object;)Ljava/util/List;", "E", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "c", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "", "capacity", "b", "(ILkotlin/jvm/functions/Function1;)Ljava/util/List;", "i", "()Ljava/util/List;", "j", "(I)Ljava/util/List;", "builder", "a", "(Ljava/util/List;)Ljava/util/List;", "Ljava/util/Enumeration;", "n", "(Ljava/util/Enumeration;)Ljava/util/List;", "", "l", "(Ljava/lang/Iterable;)Ljava/util/List;", "Ljava/util/Random;", "random", "m", "(Ljava/lang/Iterable;Ljava/util/Random;)Ljava/util/List;", "", "collection", "", "", "f", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "g", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "", "isVarargs", "h", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "index", "e", "(I)I", "count", "d", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/CollectionsKt")
@SourceDebugExtension({"SMAP\nCollectionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionsJVM.kt\nkotlin/collections/CollectionsKt__CollectionsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,122:1\n1#2:123\n*E\n"})
class CollectionsKt__CollectionsJVMKt {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> List<E> a(@NotNull List<E> list) {
        Intrinsics.p(list, "builder");
        return ((ListBuilder) list).m();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> List<E> b(int i2, Function1<? super List<E>, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        List j2 = CollectionsKt.j(i2);
        function1.f(j2);
        return CollectionsKt.a(j2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <E> List<E> c(Function1<? super List<E>, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        List i2 = CollectionsKt.i();
        function1.f(i2);
        return CollectionsKt.a(i2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final int d(int i2) {
        if (i2 < 0) {
            if (PlatformImplementationsKt.a(1, 3, 0)) {
                CollectionsKt.V();
            } else {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i2;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final int e(int i2) {
        if (i2 < 0) {
            if (PlatformImplementationsKt.a(1, 3, 0)) {
                CollectionsKt.W();
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        return i2;
    }

    @InlineOnly
    private static final Object[] f(Collection<?> collection) {
        Intrinsics.p(collection, "collection");
        return CollectionToArray.a(collection);
    }

    @InlineOnly
    private static final <T> T[] g(Collection<?> collection, T[] tArr) {
        Intrinsics.p(collection, "collection");
        Intrinsics.p(tArr, "array");
        return CollectionToArray.b(collection, tArr);
    }

    @NotNull
    public static final <T> Object[] h(@NotNull T[] tArr, boolean z) {
        Intrinsics.p(tArr, "<this>");
        Class<Object[]> cls = Object[].class;
        if (z && Intrinsics.g(tArr.getClass(), cls)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, cls);
        Intrinsics.o(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> List<E> i() {
        return new ListBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <E> List<E> j(int i2) {
        return new ListBuilder(i2);
    }

    @NotNull
    public static <T> List<T> k(T t) {
        List<T> singletonList = Collections.singletonList(t);
        Intrinsics.o(singletonList, "singletonList(element)");
        return singletonList;
    }

    @NotNull
    @SinceKotlin(version = "1.2")
    public static final <T> List<T> l(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.p(iterable, "<this>");
        List<T> U5 = CollectionsKt___CollectionsKt.U5(iterable);
        Collections.shuffle(U5);
        return U5;
    }

    @NotNull
    @SinceKotlin(version = "1.2")
    public static final <T> List<T> m(@NotNull Iterable<? extends T> iterable, @NotNull Random random) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(random, "random");
        List<T> U5 = CollectionsKt___CollectionsKt.U5(iterable);
        Collections.shuffle(U5, random);
        return U5;
    }

    @InlineOnly
    private static final <T> List<T> n(Enumeration<T> enumeration) {
        Intrinsics.p(enumeration, "<this>");
        ArrayList<T> list = Collections.list(enumeration);
        Intrinsics.o(list, "list(this)");
        return list;
    }
}
