package kotlin;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@ExperimentalUnsignedTypes
@JvmInline
@SinceKotlin(version = "1.3")
@SourceDebugExtension({"SMAP\nUShortArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n*L\n62#1:87,3\n*E\n"})
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0014\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\b\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001a\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0004¢\u0006\f\n\u0004\b'\u0010(\u0012\u0004\b)\u0010*R\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\"\u0001\b\u0001\u00020\u0007ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006-"}, d2 = {"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "", "size", "d", "(I)[S", "", "storage", "g", "([S)[S", "index", "o", "([SI)S", "value", "", "D", "([SIS)V", "", "C", "([S)Ljava/util/Iterator;", "element", "", "j", "([SS)Z", "elements", "k", "([SLjava/util/Collection;)Z", "B", "([S)Z", "", "E", "([S)Ljava/lang/String;", "z", "([S)I", "", "other", "m", "([SLjava/lang/Object;)Z", "s", "[S", "t", "()V", "r", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class UShortArray implements Collection<UShort>, KMappedMarker {
    @NotNull
    private final short[] s;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010ø\u0001\u0001\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlin/UShortArray$Iterator;", "", "Lkotlin/UShort;", "", "array", "<init>", "([S)V", "", "hasNext", "()Z", "a", "()S", "s", "[S", "", "X", "I", "index", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    private static final class Iterator implements java.util.Iterator<UShort>, KMappedMarker {
        private int X;
        @NotNull
        private final short[] s;

        public Iterator(@NotNull short[] sArr) {
            Intrinsics.p(sArr, "array");
            this.s = sArr;
        }

        public short a() {
            int i2 = this.X;
            short[] sArr = this.s;
            if (i2 < sArr.length) {
                this.X = i2 + 1;
                return UShort.i(sArr[i2]);
            }
            throw new NoSuchElementException(String.valueOf(this.X));
        }

        public boolean hasNext() {
            return this.X < this.s.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return UShort.b(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    private /* synthetic */ UShortArray(short[] sArr) {
        this.s = sArr;
    }

    public static boolean B(short[] sArr) {
        return sArr.length == 0;
    }

    @NotNull
    public static java.util.Iterator<UShort> C(short[] sArr) {
        return new Iterator(sArr);
    }

    public static final void D(short[] sArr, int i2, short s2) {
        sArr[i2] = s2;
    }

    public static String E(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ASCIIPropertyListParser.f18650h;
    }

    public static final /* synthetic */ UShortArray c(short[] sArr) {
        return new UShortArray(sArr);
    }

    @NotNull
    public static short[] d(int i2) {
        return g(new short[i2]);
    }

    @NotNull
    @PublishedApi
    public static short[] g(@NotNull short[] sArr) {
        Intrinsics.p(sArr, "storage");
        return sArr;
    }

    public static boolean j(short[] sArr, short s2) {
        return ArraysKt.t8(sArr, s2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean k(short[] r3, @org.jetbrains.annotations.NotNull java.util.Collection<kotlin.UShort> r4) {
        /*
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.p(r4, r0)
            boolean r0 = r4.isEmpty()
            r1 = 1
            if (r0 == 0) goto L_0x000d
            goto L_0x002d
        L_0x000d:
            java.util.Iterator r4 = r4.iterator()
        L_0x0011:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x002d
            java.lang.Object r0 = r4.next()
            boolean r2 = r0 instanceof kotlin.UShort
            if (r2 == 0) goto L_0x002c
            kotlin.UShort r0 = (kotlin.UShort) r0
            short r0 = r0.r0()
            boolean r0 = kotlin.collections.ArraysKt.t8(r3, r0)
            if (r0 == 0) goto L_0x002c
            goto L_0x0011
        L_0x002c:
            r1 = 0
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.UShortArray.k(short[], java.util.Collection):boolean");
    }

    public static boolean m(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.g(sArr, ((UShortArray) obj).G());
    }

    public static final boolean n(short[] sArr, short[] sArr2) {
        return Intrinsics.g(sArr, sArr2);
    }

    public static final short o(short[] sArr, int i2) {
        return UShort.i(sArr[i2]);
    }

    public static int r(short[] sArr) {
        return sArr.length;
    }

    @PublishedApi
    public static /* synthetic */ void t() {
    }

    public static int z(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public final /* synthetic */ short[] G() {
        return this.s;
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean b(short s2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UShort)) {
            return false;
        }
        return h(((UShort) obj).r0());
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.p(collection, "elements");
        return k(this.s, collection);
    }

    public boolean equals(Object obj) {
        return m(this.s, obj);
    }

    public boolean h(short s2) {
        return j(this.s, s2);
    }

    public int hashCode() {
        return z(this.s);
    }

    public boolean isEmpty() {
        return B(this.s);
    }

    @NotNull
    public java.util.Iterator<UShort> iterator() {
        return C(this.s);
    }

    /* renamed from: q */
    public int size() {
        return r(this.s);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public String toString() {
        return E(this.s);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.p(tArr, "array");
        return CollectionToArray.b(this, tArr);
    }
}
