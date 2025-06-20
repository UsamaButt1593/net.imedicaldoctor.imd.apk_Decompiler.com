package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a-\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001aI\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0005*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a+\u0010\n\u001a\u00020\t*\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a=\u0010\u000f\u001a\u00028\u0001\"\u0010\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\u0001*\u00028\u0001\"\u0004\b\u0001\u0010\u0005*\u00028\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a5\u0010\u0012\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u00012\u0010\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a#\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a?\u0010\u001d\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u00182\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001f"}, d2 = {"T", "", "", "j", "([[Ljava/lang/Object;)Ljava/util/List;", "R", "Lkotlin/Pair;", "m", "([Lkotlin/Pair;)Lkotlin/Pair;", "", "l", "([Ljava/lang/Object;)Z", "C", "Lkotlin/Function0;", "defaultValue", "k", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "other", "g", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "", "h", "([Ljava/lang/Object;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "result", "", "processed", "", "i", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/ArraysKt")
@SourceDebugExtension({"SMAP\nArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Arrays.kt\nkotlin/collections/ArraysKt__ArraysKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepEquals")
    public static final <T> boolean g(@Nullable T[] tArr, @Nullable T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == null || tArr2 == null || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            T t = tArr[i2];
            T t2 = tArr2[i2];
            if (t != t2) {
                if (t == null || t2 == null) {
                    return false;
                }
                if (!(t instanceof Object[]) || !(t2 instanceof Object[])) {
                    if (!(t instanceof byte[]) || !(t2 instanceof byte[])) {
                        if (!(t instanceof short[]) || !(t2 instanceof short[])) {
                            if (!(t instanceof int[]) || !(t2 instanceof int[])) {
                                if (!(t instanceof long[]) || !(t2 instanceof long[])) {
                                    if (!(t instanceof float[]) || !(t2 instanceof float[])) {
                                        if (!(t instanceof double[]) || !(t2 instanceof double[])) {
                                            if (!(t instanceof char[]) || !(t2 instanceof char[])) {
                                                if (!(t instanceof boolean[]) || !(t2 instanceof boolean[])) {
                                                    if (!(t instanceof UByteArray) || !(t2 instanceof UByteArray)) {
                                                        if (!(t instanceof UShortArray) || !(t2 instanceof UShortArray)) {
                                                            if (!(t instanceof UIntArray) || !(t2 instanceof UIntArray)) {
                                                                if (!(t instanceof ULongArray) || !(t2 instanceof ULongArray)) {
                                                                    if (!Intrinsics.g(t, t2)) {
                                                                        return false;
                                                                    }
                                                                } else if (!UArraysKt.V0(((ULongArray) t).G(), ((ULongArray) t2).G())) {
                                                                    return false;
                                                                }
                                                            } else if (!UArraysKt.T0(((UIntArray) t).G(), ((UIntArray) t2).G())) {
                                                                return false;
                                                            }
                                                        } else if (!UArraysKt.S0(((UShortArray) t).G(), ((UShortArray) t2).G())) {
                                                            return false;
                                                        }
                                                    } else if (!UArraysKt.U0(((UByteArray) t).G(), ((UByteArray) t2).G())) {
                                                        return false;
                                                    }
                                                } else if (!Arrays.equals((boolean[]) t, (boolean[]) t2)) {
                                                    return false;
                                                }
                                            } else if (!Arrays.equals((char[]) t, (char[]) t2)) {
                                                return false;
                                            }
                                        } else if (!Arrays.equals((double[]) t, (double[]) t2)) {
                                            return false;
                                        }
                                    } else if (!Arrays.equals((float[]) t, (float[]) t2)) {
                                        return false;
                                    }
                                } else if (!Arrays.equals((long[]) t, (long[]) t2)) {
                                    return false;
                                }
                            } else if (!Arrays.equals((int[]) t, (int[]) t2)) {
                                return false;
                            }
                        } else if (!Arrays.equals((short[]) t, (short[]) t2)) {
                            return false;
                        }
                    } else if (!Arrays.equals((byte[]) t, (byte[]) t2)) {
                        return false;
                    }
                } else if (!g((Object[]) t, (Object[]) t2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    @JvmName(name = "contentDeepToString")
    public static final <T> String h(@Nullable T[] tArr) {
        if (tArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder((RangesKt.B(tArr.length, 429496729) * 5) + 2);
        i(tArr, sb, new ArrayList());
        String sb2 = sb.toString();
        Intrinsics.o(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    private static final <T> void i(T[] tArr, StringBuilder sb, List<Object[]> list) {
        String a1;
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(", ");
            }
            T t = tArr[i2];
            if (t == null) {
                a1 = "null";
            } else if (t instanceof Object[]) {
                i((Object[]) t, sb, list);
            } else {
                if (t instanceof byte[]) {
                    a1 = Arrays.toString((byte[]) t);
                } else if (t instanceof short[]) {
                    a1 = Arrays.toString((short[]) t);
                } else if (t instanceof int[]) {
                    a1 = Arrays.toString((int[]) t);
                } else if (t instanceof long[]) {
                    a1 = Arrays.toString((long[]) t);
                } else if (t instanceof float[]) {
                    a1 = Arrays.toString((float[]) t);
                } else if (t instanceof double[]) {
                    a1 = Arrays.toString((double[]) t);
                } else if (t instanceof char[]) {
                    a1 = Arrays.toString((char[]) t);
                } else if (t instanceof boolean[]) {
                    a1 = Arrays.toString((boolean[]) t);
                } else {
                    a1 = t instanceof UByteArray ? UArraysKt.a1(((UByteArray) t).G()) : t instanceof UShortArray ? UArraysKt.c1(((UShortArray) t).G()) : t instanceof UIntArray ? UArraysKt.b1(((UIntArray) t).G()) : t instanceof ULongArray ? UArraysKt.d1(((ULongArray) t).G()) : t.toString();
                }
                Intrinsics.o(a1, "toString(this)");
            }
            sb.append(a1);
        }
        sb.append(']');
        list.remove(CollectionsKt.G(list));
    }

    @NotNull
    public static final <T> List<T> j(@NotNull T[][] tArr) {
        Intrinsics.p(tArr, "<this>");
        int i2 = 0;
        for (T[] length : tArr) {
            i2 += length.length;
        }
        ArrayList arrayList = new ArrayList(i2);
        for (T[] p0 : tArr) {
            CollectionsKt__MutableCollectionsKt.p0(arrayList, p0);
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [R, C] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.internal.InlineOnly
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <C extends java.lang.Object & R, R> R k(C r1, kotlin.jvm.functions.Function0<? extends R> r2) {
        /*
            java.lang.String r0 = "defaultValue"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            int r0 = r1.length
            if (r0 != 0) goto L_0x000c
            java.lang.Object r1 = r2.o()
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArraysKt__ArraysKt.k(java.lang.Object[], kotlin.jvm.functions.Function0):java.lang.Object");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean l(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> m(@NotNull Pair<? extends T, ? extends R>[] pairArr) {
        Intrinsics.p(pairArr, "<this>");
        ArrayList arrayList = new ArrayList(pairArr.length);
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair<? extends T, ? extends R> pair : pairArr) {
            arrayList.add(pair.e());
            arrayList2.add(pair.f());
        }
        return TuplesKt.a(arrayList, arrayList2);
    }
}
