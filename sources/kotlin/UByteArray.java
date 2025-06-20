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
@SourceDebugExtension({"SMAP\nUByteArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n*L\n62#1:87,3\n*E\n"})
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0014\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\b\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001a\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0004¢\u0006\f\n\u0004\b'\u0010(\u0012\u0004\b)\u0010*R\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\"\u0001\b\u0001\u00020\u0007ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006-"}, d2 = {"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "", "size", "d", "(I)[B", "", "storage", "g", "([B)[B", "index", "o", "([BI)B", "value", "", "D", "([BIB)V", "", "C", "([B)Ljava/util/Iterator;", "element", "", "j", "([BB)Z", "elements", "k", "([BLjava/util/Collection;)Z", "B", "([B)Z", "", "E", "([B)Ljava/lang/String;", "z", "([B)I", "", "other", "m", "([BLjava/lang/Object;)Z", "s", "[B", "t", "()V", "r", "Iterator", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class UByteArray implements Collection<UByte>, KMappedMarker {
    @NotNull
    private final byte[] s;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010ø\u0001\u0001\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlin/UByteArray$Iterator;", "", "Lkotlin/UByte;", "", "array", "<init>", "([B)V", "", "hasNext", "()Z", "a", "()B", "s", "[B", "", "X", "I", "index", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    private static final class Iterator implements java.util.Iterator<UByte>, KMappedMarker {
        private int X;
        @NotNull
        private final byte[] s;

        public Iterator(@NotNull byte[] bArr) {
            Intrinsics.p(bArr, "array");
            this.s = bArr;
        }

        public byte a() {
            int i2 = this.X;
            byte[] bArr = this.s;
            if (i2 < bArr.length) {
                this.X = i2 + 1;
                return UByte.i(bArr[i2]);
            }
            throw new NoSuchElementException(String.valueOf(this.X));
        }

        public boolean hasNext() {
            return this.X < this.s.length;
        }

        public /* bridge */ /* synthetic */ Object next() {
            return UByte.b(a());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @PublishedApi
    private /* synthetic */ UByteArray(byte[] bArr) {
        this.s = bArr;
    }

    public static boolean B(byte[] bArr) {
        return bArr.length == 0;
    }

    @NotNull
    public static java.util.Iterator<UByte> C(byte[] bArr) {
        return new Iterator(bArr);
    }

    public static final void D(byte[] bArr, int i2, byte b2) {
        bArr[i2] = b2;
    }

    public static String E(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ASCIIPropertyListParser.f18650h;
    }

    public static final /* synthetic */ UByteArray c(byte[] bArr) {
        return new UByteArray(bArr);
    }

    @NotNull
    public static byte[] d(int i2) {
        return g(new byte[i2]);
    }

    @NotNull
    @PublishedApi
    public static byte[] g(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "storage");
        return bArr;
    }

    public static boolean j(byte[] bArr, byte b2) {
        return ArraysKt.m8(bArr, b2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean k(byte[] r3, @org.jetbrains.annotations.NotNull java.util.Collection<kotlin.UByte> r4) {
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
            boolean r2 = r0 instanceof kotlin.UByte
            if (r2 == 0) goto L_0x002c
            kotlin.UByte r0 = (kotlin.UByte) r0
            byte r0 = r0.r0()
            boolean r0 = kotlin.collections.ArraysKt.m8(r3, r0)
            if (r0 == 0) goto L_0x002c
            goto L_0x0011
        L_0x002c:
            r1 = 0
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.UByteArray.k(byte[], java.util.Collection):boolean");
    }

    public static boolean m(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.g(bArr, ((UByteArray) obj).G());
    }

    public static final boolean n(byte[] bArr, byte[] bArr2) {
        return Intrinsics.g(bArr, bArr2);
    }

    public static final byte o(byte[] bArr, int i2) {
        return UByte.i(bArr[i2]);
    }

    public static int r(byte[] bArr) {
        return bArr.length;
    }

    @PublishedApi
    public static /* synthetic */ void t() {
    }

    public static int z(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public final /* synthetic */ byte[] G() {
        return this.s;
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean b(byte b2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UByte)) {
            return false;
        }
        return h(((UByte) obj).r0());
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.p(collection, "elements");
        return k(this.s, collection);
    }

    public boolean equals(Object obj) {
        return m(this.s, obj);
    }

    public boolean h(byte b2) {
        return j(this.s, b2);
    }

    public int hashCode() {
        return z(this.s);
    }

    public boolean isEmpty() {
        return B(this.s);
    }

    @NotNull
    public java.util.Iterator<UByte> iterator() {
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
