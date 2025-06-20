package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.BooleanIterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a$\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\r\u0010\u0005\u001a\u001c\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a$\u0010\u0011\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a*\u0010\u0014\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b\u0018\u0010\u0017\u001a!\u0010\u0019\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u0012\u001a\u0019\u0010\u001a\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aL\u0010 \u001a\u00020\u0007*\u00020\u000026\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u001cH\b¢\u0006\u0004\b \u0010!\u001a\u0011\u0010#\u001a\u00020\"*\u00020\u0000¢\u0006\u0004\b#\u0010$\u001a\u0011\u0010&\u001a\u00020%*\u00020\u0000¢\u0006\u0004\b&\u0010'\"\u0016\u0010*\u001a\u00020\u0001*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Landroid/util/SparseBooleanArray;", "", "key", "", "a", "(Landroid/util/SparseBooleanArray;I)Z", "value", "", "n", "(Landroid/util/SparseBooleanArray;IZ)V", "other", "k", "(Landroid/util/SparseBooleanArray;Landroid/util/SparseBooleanArray;)Landroid/util/SparseBooleanArray;", "b", "c", "(Landroid/util/SparseBooleanArray;Z)Z", "defaultValue", "e", "(Landroid/util/SparseBooleanArray;IZ)Z", "Lkotlin/Function0;", "f", "(Landroid/util/SparseBooleanArray;ILkotlin/jvm/functions/Function0;)Z", "h", "(Landroid/util/SparseBooleanArray;)Z", "i", "m", "l", "(Landroid/util/SparseBooleanArray;Landroid/util/SparseBooleanArray;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "d", "(Landroid/util/SparseBooleanArray;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/collections/IntIterator;", "j", "(Landroid/util/SparseBooleanArray;)Lkotlin/collections/IntIterator;", "Lkotlin/collections/BooleanIterator;", "o", "(Landroid/util/SparseBooleanArray;)Lkotlin/collections/BooleanIterator;", "g", "(Landroid/util/SparseBooleanArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSparseBooleanArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n77#1,4:97\n1#2:96\n*S KotlinDebug\n*F\n+ 1 SparseBooleanArray.kt\nandroidx/core/util/SparseBooleanArrayKt\n*L\n73#1:97,4\n*E\n"})
public final class SparseBooleanArrayKt {
    public static final boolean a(@NotNull SparseBooleanArray sparseBooleanArray, int i2) {
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean b(@NotNull SparseBooleanArray sparseBooleanArray, int i2) {
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean c(@NotNull SparseBooleanArray sparseBooleanArray, boolean z) {
        return sparseBooleanArray.indexOfValue(z) >= 0;
    }

    public static final void d(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull Function2<? super Integer, ? super Boolean, Unit> function2) {
        int size = sparseBooleanArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            function2.d0(Integer.valueOf(sparseBooleanArray.keyAt(i2)), Boolean.valueOf(sparseBooleanArray.valueAt(i2)));
        }
    }

    public static final boolean e(@NotNull SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        return sparseBooleanArray.get(i2, z);
    }

    public static final boolean f(@NotNull SparseBooleanArray sparseBooleanArray, int i2, @NotNull Function0<Boolean> function0) {
        int indexOfKey = sparseBooleanArray.indexOfKey(i2);
        return indexOfKey >= 0 ? sparseBooleanArray.valueAt(indexOfKey) : function0.o().booleanValue();
    }

    public static final int g(@NotNull SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size();
    }

    public static final boolean h(@NotNull SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean i(@NotNull SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size() != 0;
    }

    @NotNull
    public static final IntIterator j(@NotNull SparseBooleanArray sparseBooleanArray) {
        return new SparseBooleanArrayKt$keyIterator$1(sparseBooleanArray);
    }

    @NotNull
    public static final SparseBooleanArray k(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull SparseBooleanArray sparseBooleanArray2) {
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        l(sparseBooleanArray3, sparseBooleanArray);
        l(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void l(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull SparseBooleanArray sparseBooleanArray2) {
        int size = sparseBooleanArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i2), sparseBooleanArray2.valueAt(i2));
        }
    }

    public static final boolean m(@NotNull SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        int indexOfKey = sparseBooleanArray.indexOfKey(i2);
        if (indexOfKey < 0 || z != sparseBooleanArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i2);
        return true;
    }

    public static final void n(@NotNull SparseBooleanArray sparseBooleanArray, int i2, boolean z) {
        sparseBooleanArray.put(i2, z);
    }

    @NotNull
    public static final BooleanIterator o(@NotNull SparseBooleanArray sparseBooleanArray) {
        return new SparseBooleanArrayKt$valueIterator$1(sparseBooleanArray);
    }
}
