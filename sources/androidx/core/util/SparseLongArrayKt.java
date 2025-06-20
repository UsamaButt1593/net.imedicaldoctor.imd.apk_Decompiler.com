package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a$\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u000e\u0010\u0005\u001a\u001c\u0010\u000f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a$\u0010\u0012\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0006H\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a*\u0010\u0015\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0014\u0010\u0017\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b\u0019\u0010\u0018\u001a!\u0010\u001a\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0019\u0010\u001c\u001a\u00020\b*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001aL\u0010\"\u001a\u00020\b*\u00020\u000026\u0010!\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u001eH\b¢\u0006\u0004\b\"\u0010#\u001a\u0011\u0010%\u001a\u00020$*\u00020\u0000¢\u0006\u0004\b%\u0010&\u001a\u0011\u0010(\u001a\u00020'*\u00020\u0000¢\u0006\u0004\b(\u0010)\"\u0016\u0010,\u001a\u00020\u0001*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Landroid/util/SparseLongArray;", "", "key", "", "a", "(Landroid/util/SparseLongArray;I)Z", "", "value", "", "n", "(Landroid/util/SparseLongArray;IJ)V", "other", "k", "(Landroid/util/SparseLongArray;Landroid/util/SparseLongArray;)Landroid/util/SparseLongArray;", "b", "c", "(Landroid/util/SparseLongArray;J)Z", "defaultValue", "e", "(Landroid/util/SparseLongArray;IJ)J", "Lkotlin/Function0;", "f", "(Landroid/util/SparseLongArray;ILkotlin/jvm/functions/Function0;)J", "h", "(Landroid/util/SparseLongArray;)Z", "i", "m", "(Landroid/util/SparseLongArray;IJ)Z", "l", "(Landroid/util/SparseLongArray;Landroid/util/SparseLongArray;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "d", "(Landroid/util/SparseLongArray;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/collections/IntIterator;", "j", "(Landroid/util/SparseLongArray;)Lkotlin/collections/IntIterator;", "Lkotlin/collections/LongIterator;", "o", "(Landroid/util/SparseLongArray;)Lkotlin/collections/LongIterator;", "g", "(Landroid/util/SparseLongArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSparseLongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n75#1,4:95\n1#2:94\n*S KotlinDebug\n*F\n+ 1 SparseLongArray.kt\nandroidx/core/util/SparseLongArrayKt\n*L\n71#1:95,4\n*E\n"})
public final class SparseLongArrayKt {
    public static final boolean a(@NotNull SparseLongArray sparseLongArray, int i2) {
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    public static final boolean b(@NotNull SparseLongArray sparseLongArray, int i2) {
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    public static final boolean c(@NotNull SparseLongArray sparseLongArray, long j2) {
        return sparseLongArray.indexOfValue(j2) >= 0;
    }

    public static final void d(@NotNull SparseLongArray sparseLongArray, @NotNull Function2<? super Integer, ? super Long, Unit> function2) {
        int size = sparseLongArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            function2.d0(Integer.valueOf(sparseLongArray.keyAt(i2)), Long.valueOf(sparseLongArray.valueAt(i2)));
        }
    }

    public static final long e(@NotNull SparseLongArray sparseLongArray, int i2, long j2) {
        return sparseLongArray.get(i2, j2);
    }

    public static final long f(@NotNull SparseLongArray sparseLongArray, int i2, @NotNull Function0<Long> function0) {
        int indexOfKey = sparseLongArray.indexOfKey(i2);
        return indexOfKey >= 0 ? sparseLongArray.valueAt(indexOfKey) : function0.o().longValue();
    }

    public static final int g(@NotNull SparseLongArray sparseLongArray) {
        return sparseLongArray.size();
    }

    public static final boolean h(@NotNull SparseLongArray sparseLongArray) {
        return sparseLongArray.size() == 0;
    }

    public static final boolean i(@NotNull SparseLongArray sparseLongArray) {
        return sparseLongArray.size() != 0;
    }

    @NotNull
    public static final IntIterator j(@NotNull SparseLongArray sparseLongArray) {
        return new SparseLongArrayKt$keyIterator$1(sparseLongArray);
    }

    @NotNull
    public static final SparseLongArray k(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray sparseLongArray2) {
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        l(sparseLongArray3, sparseLongArray);
        l(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    public static final void l(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray sparseLongArray2) {
        int size = sparseLongArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i2), sparseLongArray2.valueAt(i2));
        }
    }

    public static final boolean m(@NotNull SparseLongArray sparseLongArray, int i2, long j2) {
        int indexOfKey = sparseLongArray.indexOfKey(i2);
        if (indexOfKey < 0 || j2 != sparseLongArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(indexOfKey);
        return true;
    }

    public static final void n(@NotNull SparseLongArray sparseLongArray, int i2, long j2) {
        sparseLongArray.put(i2, j2);
    }

    @NotNull
    public static final LongIterator o(@NotNull SparseLongArray sparseLongArray) {
        return new SparseLongArrayKt$valueIterator$1(sparseLongArray);
    }
}
