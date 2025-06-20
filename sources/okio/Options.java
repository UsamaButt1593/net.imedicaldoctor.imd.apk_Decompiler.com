package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u001bB!\b\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00058\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "byteStrings", "", "trie", "<init>", "([Lokio/ByteString;[I)V", "", "index", "d", "(I)Lokio/ByteString;", "X", "[Lokio/ByteString;", "g", "()[Lokio/ByteString;", "Y", "[I", "h", "()[I", "b", "()I", "size", "Z", "Companion", "okio"}, k = 1, mv = {1, 5, 1})
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    @NotNull
    public static final Companion Z = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final ByteString[] X;
    @NotNull
    private final int[] Y;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\u00142\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0013\"\u00020\u000bH\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u00020\u0004*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lokio/Options$Companion;", "", "<init>", "()V", "", "nodeOffset", "Lokio/Buffer;", "node", "", "byteStringOffset", "", "Lokio/ByteString;", "byteStrings", "fromIndex", "toIndex", "indexes", "", "a", "(JLokio/Buffer;ILjava/util/List;IILjava/util/List;)V", "", "Lokio/Options;", "d", "([Lokio/ByteString;)Lokio/Options;", "c", "(Lokio/Buffer;)J", "intCount", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        private final void a(long j2, Buffer buffer, int i2, List<? extends ByteString> list, int i3, int i4, List<Integer> list2) {
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            Buffer buffer2;
            Buffer buffer3 = buffer;
            int i10 = i2;
            List<? extends ByteString> list3 = list;
            int i11 = i3;
            int i12 = i4;
            List<Integer> list4 = list2;
            if (i11 < i12) {
                if (i11 < i12) {
                    int i13 = i11;
                    while (true) {
                        int i14 = i13 + 1;
                        if (!(((ByteString) list3.get(i13)).m0() >= i10)) {
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        } else if (i14 >= i12) {
                            break;
                        } else {
                            i13 = i14;
                        }
                    }
                }
                ByteString byteString = (ByteString) list.get(i3);
                ByteString byteString2 = (ByteString) list3.get(i12 - 1);
                if (i10 == byteString.m0()) {
                    int intValue = list4.get(i11).intValue();
                    int i15 = i11 + 1;
                    i5 = i15;
                    i6 = intValue;
                    byteString = (ByteString) list3.get(i15);
                } else {
                    i5 = i11;
                    i6 = -1;
                }
                if (byteString.q(i10) != byteString2.q(i10)) {
                    int i16 = i5 + 1;
                    int i17 = 1;
                    if (i16 < i12) {
                        while (true) {
                            int i18 = i16 + 1;
                            if (((ByteString) list3.get(i16 - 1)).q(i10) != ((ByteString) list3.get(i16)).q(i10)) {
                                i17++;
                            }
                            if (i18 >= i12) {
                                break;
                            }
                            i16 = i18;
                        }
                    }
                    long c2 = j2 + c(buffer3) + ((long) 2) + ((long) (i17 * 2));
                    buffer3.writeInt(i17);
                    buffer3.writeInt(i6);
                    if (i5 < i12) {
                        int i19 = i5;
                        while (true) {
                            int i20 = i19 + 1;
                            byte q = ((ByteString) list3.get(i19)).q(i10);
                            if (i19 == i5 || q != ((ByteString) list3.get(i19 - 1)).q(i10)) {
                                buffer3.writeInt(q & 255);
                            }
                            if (i20 >= i12) {
                                break;
                            }
                            i19 = i20;
                        }
                    }
                    Buffer buffer4 = new Buffer();
                    while (i5 < i12) {
                        byte q2 = ((ByteString) list3.get(i5)).q(i10);
                        int i21 = i5 + 1;
                        if (i21 < i12) {
                            int i22 = i21;
                            while (true) {
                                int i23 = i22 + 1;
                                if (q2 != ((ByteString) list3.get(i22)).q(i10)) {
                                    i8 = i22;
                                    break;
                                } else if (i23 >= i12) {
                                    break;
                                } else {
                                    i22 = i23;
                                }
                            }
                        }
                        i8 = i12;
                        if (i21 == i8 && i10 + 1 == ((ByteString) list3.get(i5)).m0()) {
                            buffer3.writeInt(list4.get(i5).intValue());
                            i9 = i8;
                            buffer2 = buffer4;
                        } else {
                            buffer3.writeInt(((int) (c2 + c(buffer4))) * -1);
                            i9 = i8;
                            buffer2 = buffer4;
                            a(c2, buffer4, i10 + 1, list, i5, i8, list2);
                        }
                        buffer4 = buffer2;
                        i5 = i9;
                    }
                    buffer3.y1(buffer4);
                    return;
                }
                int min = Math.min(byteString.m0(), byteString2.m0());
                if (i10 < min) {
                    int i24 = i10;
                    i7 = 0;
                    while (true) {
                        int i25 = i24 + 1;
                        if (byteString.q(i24) != byteString2.q(i24)) {
                            break;
                        }
                        i7++;
                        if (i25 >= min) {
                            break;
                        }
                        i24 = i25;
                    }
                } else {
                    i7 = 0;
                }
                long c3 = j2 + c(buffer3) + ((long) 2) + ((long) i7) + 1;
                buffer3.writeInt(-i7);
                buffer3.writeInt(i6);
                int i26 = i10 + i7;
                if (i10 < i26) {
                    while (true) {
                        int i27 = i10 + 1;
                        buffer3.writeInt(byteString.q(i10) & 255);
                        if (i27 >= i26) {
                            break;
                        }
                        i10 = i27;
                    }
                }
                if (i5 + 1 == i12) {
                    if (i26 == ((ByteString) list3.get(i5)).m0()) {
                        buffer3.writeInt(list4.get(i5).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                Buffer buffer5 = new Buffer();
                buffer3.writeInt(((int) (c(buffer5) + c3)) * -1);
                a(c3, buffer5, i26, list, i5, i4, list2);
                buffer3.y1(buffer5);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        static /* synthetic */ void b(Companion companion, long j2, Buffer buffer, int i2, List list, int i3, int i4, List list2, int i5, Object obj) {
            companion.a((i5 & 1) != 0 ? 0 : j2, buffer, (i5 & 4) != 0 ? 0 : i2, list, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? list.size() : i4, list2);
        }

        private final long c(Buffer buffer) {
            return buffer.L0() / ((long) 4);
        }

        @JvmStatic
        @NotNull
        public final Options d(@NotNull ByteString... byteStringArr) {
            ByteString[] byteStringArr2 = byteStringArr;
            Intrinsics.p(byteStringArr2, "byteStrings");
            int i2 = 0;
            if (byteStringArr2.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, (DefaultConstructorMarker) null);
            }
            List Uy = ArraysKt.Uy(byteStringArr);
            CollectionsKt.j0(Uy);
            ArrayList arrayList = new ArrayList(byteStringArr2.length);
            for (ByteString byteString : byteStringArr2) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array != null) {
                Integer[] numArr = (Integer[]) array;
                List P = CollectionsKt.P(Arrays.copyOf(numArr, numArr.length));
                int length = byteStringArr2.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    P.set(CollectionsKt.x(Uy, byteStringArr2[i3], 0, 0, 6, (Object) null), Integer.valueOf(i4));
                    i3++;
                    i4++;
                }
                if (((ByteString) Uy.get(0)).m0() > 0) {
                    int i5 = 0;
                    while (i5 < Uy.size()) {
                        ByteString byteString2 = (ByteString) Uy.get(i5);
                        int i6 = i5 + 1;
                        int i7 = i6;
                        while (i7 < Uy.size()) {
                            ByteString byteString3 = (ByteString) Uy.get(i7);
                            if (!byteString3.p0(byteString2)) {
                                continue;
                                break;
                            }
                            if (!(byteString3.m0() != byteString2.m0())) {
                                throw new IllegalArgumentException(Intrinsics.C("duplicate option: ", byteString3).toString());
                            } else if (((Number) P.get(i7)).intValue() > ((Number) P.get(i5)).intValue()) {
                                Uy.remove(i7);
                                P.remove(i7);
                            } else {
                                i7++;
                            }
                        }
                        i5 = i6;
                    }
                    Buffer buffer = new Buffer();
                    b(this, 0, buffer, 0, Uy, 0, 0, P, 53, (Object) null);
                    int[] iArr = new int[((int) c(buffer))];
                    while (!buffer.o0()) {
                        iArr[i2] = buffer.readInt();
                        i2++;
                    }
                    Object[] copyOf = Arrays.copyOf(byteStringArr2, byteStringArr2.length);
                    Intrinsics.o(copyOf, "java.util.Arrays.copyOf(this, size)");
                    return new Options((ByteString[]) copyOf, iArr, (DefaultConstructorMarker) null);
                }
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.X = byteStringArr;
        this.Y = iArr;
    }

    @JvmStatic
    @NotNull
    public static final Options m(@NotNull ByteString... byteStringArr) {
        return Z.d(byteStringArr);
    }

    public int b() {
        return this.X.length;
    }

    public /* bridge */ boolean c(ByteString byteString) {
        return super.contains(byteString);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ByteString)) {
            return false;
        }
        return c((ByteString) obj);
    }

    @NotNull
    /* renamed from: d */
    public ByteString get(int i2) {
        return this.X[i2];
    }

    @NotNull
    public final ByteString[] g() {
        return this.X;
    }

    @NotNull
    public final int[] h() {
        return this.Y;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return j((ByteString) obj);
    }

    public /* bridge */ int j(ByteString byteString) {
        return super.indexOf(byteString);
    }

    public /* bridge */ int k(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return k((ByteString) obj);
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }
}
