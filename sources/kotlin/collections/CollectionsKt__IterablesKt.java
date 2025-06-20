package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.TuplesKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\b\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0001¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004¢\u0006\u0004\b\u000e\u0010\u000f\u001aG\u0010\u0012\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u0011\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0010*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00110\u0004¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0014"}, d2 = {"T", "Lkotlin/Function0;", "", "iterator", "", "X", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Iterable;", "", "Z", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "default", "Y", "(Ljava/lang/Iterable;I)I", "", "a0", "(Ljava/lang/Iterable;)Ljava/util/List;", "R", "Lkotlin/Pair;", "b0", "(Ljava/lang/Iterable;)Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__IterablesKt extends CollectionsKt__CollectionsKt {
    @InlineOnly
    private static final <T> Iterable<T> X(Function0<? extends Iterator<? extends T>> function0) {
        Intrinsics.p(function0, "iterator");
        return new CollectionsKt__IterablesKt$Iterable$1(function0);
    }

    @PublishedApi
    public static <T> int Y(@NotNull Iterable<? extends T> iterable, int i2) {
        Intrinsics.p(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }

    @Nullable
    @PublishedApi
    public static final <T> Integer Z(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    @NotNull
    public static final <T> List<T> a0(@NotNull Iterable<? extends Iterable<? extends T>> iterable) {
        Intrinsics.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Iterable n0 : iterable) {
            CollectionsKt.n0(arrayList, n0);
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> b0(@NotNull Iterable<? extends Pair<? extends T, ? extends R>> iterable) {
        Intrinsics.p(iterable, "<this>");
        int Y = CollectionsKt.Y(iterable, 10);
        ArrayList arrayList = new ArrayList(Y);
        ArrayList arrayList2 = new ArrayList(Y);
        for (Pair pair : iterable) {
            arrayList.add(pair.e());
            arrayList2.add(pair.f());
        }
        return TuplesKt.a(arrayList, arrayList2);
    }
}
