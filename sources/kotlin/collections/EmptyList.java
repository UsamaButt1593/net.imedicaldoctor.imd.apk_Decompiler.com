package kotlin.collections;

import com.itextpdf.xmp.XMPConst;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010#J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020%H\u0002¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020(2\u0006\u0010\u001f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b)\u0010+J%\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0010H\u0016¢\u0006\u0004\b.\u0010/R\u0014\u00103\u001a\u0002008\u0002XT¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00105\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0012¨\u00066"}, d2 = {"Lkotlin/collections/EmptyList;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "<init>", "()V", "", "m", "()Ljava/lang/Object;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "isEmpty", "()Z", "element", "d", "(Ljava/lang/Void;)Z", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "index", "g", "(I)Ljava/lang/Void;", "j", "(Ljava/lang/Void;)I", "k", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "", "X", "J", "serialVersionUID", "h", "size", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class EmptyList implements List, Serializable, RandomAccess, KMappedMarker {
    private static final long X = -7390468764508069838L;
    @NotNull
    public static final EmptyList s = new EmptyList();

    private EmptyList() {
    }

    private final Object m() {
        return s;
    }

    public /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void b(int i2, Void voidR) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean c(Void voidR) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        return d((Void) obj);
    }

    public boolean containsAll(@NotNull Collection collection) {
        Intrinsics.p(collection, "elements");
        return collection.isEmpty();
    }

    public boolean d(@NotNull Void voidR) {
        Intrinsics.p(voidR, "element");
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    @NotNull
    /* renamed from: g */
    public Void get(int i2) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i2 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    public int h() {
        return 0;
    }

    public int hashCode() {
        return 1;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        return j((Void) obj);
    }

    public boolean isEmpty() {
        return true;
    }

    @NotNull
    public Iterator iterator() {
        return EmptyIterator.s;
    }

    public int j(@NotNull Void voidR) {
        Intrinsics.p(voidR, "element");
        return -1;
    }

    public int k(@NotNull Void voidR) {
        Intrinsics.p(voidR, "element");
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        return k((Void) obj);
    }

    @NotNull
    public ListIterator listIterator() {
        return EmptyIterator.s;
    }

    public Void n(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void o(int i2, Void voidR) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return h();
    }

    @NotNull
    public List subList(int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3);
    }

    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @NotNull
    public String toString() {
        return XMPConst.o2;
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public ListIterator listIterator(int i2) {
        if (i2 == 0) {
            return EmptyIterator.s;
        }
        throw new IndexOutOfBoundsException("Index: " + i2);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.p(tArr, "array");
        return CollectionToArray.b(this, tArr);
    }
}
