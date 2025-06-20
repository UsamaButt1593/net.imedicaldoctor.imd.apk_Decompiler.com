package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0003\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00060\u0005j\u0002`\u0006B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lkotlin/enums/EnumEntriesList;", "", "T", "Lkotlin/enums/EnumEntries;", "Lkotlin/collections/AbstractList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "entries", "<init>", "([Ljava/lang/Enum;)V", "", "j", "()Ljava/lang/Object;", "", "index", "d", "(I)Ljava/lang/Enum;", "element", "", "c", "(Ljava/lang/Enum;)Z", "g", "(Ljava/lang/Enum;)I", "h", "X", "[Ljava/lang/Enum;", "b", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SinceKotlin(version = "1.8")
final class EnumEntriesList<T extends Enum<T>> extends AbstractList<T> implements EnumEntries<T>, Serializable {
    @NotNull
    private final T[] X;

    public EnumEntriesList(@NotNull T[] tArr) {
        Intrinsics.p(tArr, "entries");
        this.X = tArr;
    }

    private final Object j() {
        return new EnumEntriesSerializationProxy(this.X);
    }

    public int b() {
        return this.X.length;
    }

    public boolean c(@NotNull T t) {
        Intrinsics.p(t, "element");
        return ((Enum) ArraysKt.Pe(this.X, t.ordinal())) == t;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        return c((Enum) obj);
    }

    @NotNull
    /* renamed from: d */
    public T get(int i2) {
        AbstractList.s.b(i2, this.X.length);
        return this.X[i2];
    }

    public int g(@NotNull T t) {
        Intrinsics.p(t, "element");
        int ordinal = t.ordinal();
        if (((Enum) ArraysKt.Pe(this.X, ordinal)) == t) {
            return ordinal;
        }
        return -1;
    }

    public int h(@NotNull T t) {
        Intrinsics.p(t, "element");
        return indexOf(t);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return g((Enum) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return h((Enum) obj);
    }
}
