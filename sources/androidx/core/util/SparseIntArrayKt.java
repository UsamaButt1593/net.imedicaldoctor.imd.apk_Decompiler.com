package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a$\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\n¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\r\u0010\u0005\u001a\u001c\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001H\b¢\u0006\u0004\b\u000e\u0010\u0005\u001a$\u0010\u0010\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a*\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0014\u0010\u0017\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b\u0017\u0010\u0016\u001a!\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aL\u0010 \u001a\u00020\u0007*\u00020\u000026\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u001cH\b¢\u0006\u0004\b \u0010!\u001a\u0011\u0010#\u001a\u00020\"*\u00020\u0000¢\u0006\u0004\b#\u0010$\u001a\u0011\u0010%\u001a\u00020\"*\u00020\u0000¢\u0006\u0004\b%\u0010$\"\u0016\u0010(\u001a\u00020\u0001*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Landroid/util/SparseIntArray;", "", "key", "", "a", "(Landroid/util/SparseIntArray;I)Z", "value", "", "n", "(Landroid/util/SparseIntArray;II)V", "other", "k", "(Landroid/util/SparseIntArray;Landroid/util/SparseIntArray;)Landroid/util/SparseIntArray;", "b", "c", "defaultValue", "e", "(Landroid/util/SparseIntArray;II)I", "Lkotlin/Function0;", "f", "(Landroid/util/SparseIntArray;ILkotlin/jvm/functions/Function0;)I", "h", "(Landroid/util/SparseIntArray;)Z", "i", "m", "(Landroid/util/SparseIntArray;II)Z", "l", "(Landroid/util/SparseIntArray;Landroid/util/SparseIntArray;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "d", "(Landroid/util/SparseIntArray;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/collections/IntIterator;", "j", "(Landroid/util/SparseIntArray;)Lkotlin/collections/IntIterator;", "o", "g", "(Landroid/util/SparseIntArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSparseIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n75#1,4:95\n1#2:94\n*S KotlinDebug\n*F\n+ 1 SparseIntArray.kt\nandroidx/core/util/SparseIntArrayKt\n*L\n71#1:95,4\n*E\n"})
public final class SparseIntArrayKt {
    public static final boolean a(@NotNull SparseIntArray sparseIntArray, int i2) {
        return sparseIntArray.indexOfKey(i2) >= 0;
    }

    public static final boolean b(@NotNull SparseIntArray sparseIntArray, int i2) {
        return sparseIntArray.indexOfKey(i2) >= 0;
    }

    public static final boolean c(@NotNull SparseIntArray sparseIntArray, int i2) {
        return sparseIntArray.indexOfValue(i2) >= 0;
    }

    public static final void d(@NotNull SparseIntArray sparseIntArray, @NotNull Function2<? super Integer, ? super Integer, Unit> function2) {
        int size = sparseIntArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            function2.d0(Integer.valueOf(sparseIntArray.keyAt(i2)), Integer.valueOf(sparseIntArray.valueAt(i2)));
        }
    }

    public static final int e(@NotNull SparseIntArray sparseIntArray, int i2, int i3) {
        return sparseIntArray.get(i2, i3);
    }

    public static final int f(@NotNull SparseIntArray sparseIntArray, int i2, @NotNull Function0<Integer> function0) {
        int indexOfKey = sparseIntArray.indexOfKey(i2);
        return indexOfKey >= 0 ? sparseIntArray.valueAt(indexOfKey) : function0.o().intValue();
    }

    public static final int g(@NotNull SparseIntArray sparseIntArray) {
        return sparseIntArray.size();
    }

    public static final boolean h(@NotNull SparseIntArray sparseIntArray) {
        return sparseIntArray.size() == 0;
    }

    public static final boolean i(@NotNull SparseIntArray sparseIntArray) {
        return sparseIntArray.size() != 0;
    }

    @NotNull
    public static final IntIterator j(@NotNull SparseIntArray sparseIntArray) {
        return new SparseIntArrayKt$keyIterator$1(sparseIntArray);
    }

    @NotNull
    public static final SparseIntArray k(@NotNull SparseIntArray sparseIntArray, @NotNull SparseIntArray sparseIntArray2) {
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray.size() + sparseIntArray2.size());
        l(sparseIntArray3, sparseIntArray);
        l(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void l(@NotNull SparseIntArray sparseIntArray, @NotNull SparseIntArray sparseIntArray2) {
        int size = sparseIntArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i2), sparseIntArray2.valueAt(i2));
        }
    }

    public static final boolean m(@NotNull SparseIntArray sparseIntArray, int i2, int i3) {
        int indexOfKey = sparseIntArray.indexOfKey(i2);
        if (indexOfKey < 0 || i3 != sparseIntArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(indexOfKey);
        return true;
    }

    public static final void n(@NotNull SparseIntArray sparseIntArray, int i2, int i3) {
        sparseIntArray.put(i2, i3);
    }

    @NotNull
    public static final IntIterator o(@NotNull SparseIntArray sparseIntArray) {
        return new SparseIntArrayKt$valueIterator$1(sparseIntArray);
    }
}
