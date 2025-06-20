package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nCollectionToArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionToArray.kt\nkotlin/jvm/internal/CollectionToArray\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,82:1\n57#1,22:83\n57#1,22:105\n26#2:127\n*S KotlinDebug\n*F\n+ 1 CollectionToArray.kt\nkotlin/jvm/internal/CollectionToArray\n*L\n19#1:83,22\n31#1:105,22\n14#1:127\n*E\n"})
@Metadata(d1 = {"\u0000*\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0001\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\b2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\n2(\u0010\u000e\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\rH\b¢\u0006\u0004\b\u000f\u0010\u0010\"\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011\"\u0014\u0010\u0014\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013¨\u0006\u0015"}, d2 = {"", "collection", "", "", "a", "(Ljava/util/Collection;)[Ljava/lang/Object;", "b", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "Lkotlin/Function0;", "empty", "Lkotlin/Function1;", "", "alloc", "Lkotlin/Function2;", "trim", "c", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "[Ljava/lang/Object;", "EMPTY", "I", "MAX_SIZE", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "CollectionToArray")
public final class CollectionToArray {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final Object[] f28924a = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    private static final int f28925b = 2147483645;

    @NotNull
    @JvmName(name = "toArray")
    public static final Object[] a(@NotNull Collection<?> collection) {
        Intrinsics.p(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it2 = collection.iterator();
            if (it2.hasNext()) {
                Object[] objArr = new Object[size];
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    objArr[i2] = it2.next();
                    if (i3 >= objArr.length) {
                        if (!it2.hasNext()) {
                            return objArr;
                        }
                        int i4 = ((i3 * 3) + 1) >>> 1;
                        if (i4 <= i3) {
                            i4 = f28925b;
                            if (i3 >= f28925b) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr = Arrays.copyOf(objArr, i4);
                        Intrinsics.o(objArr, "copyOf(result, newSize)");
                    } else if (!it2.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i3);
                        Intrinsics.o(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i2 = i3;
                }
            }
        }
        return f28924a;
    }

    @NotNull
    @JvmName(name = "toArray")
    public static final Object[] b(@NotNull Collection<?> collection, @Nullable Object[] objArr) {
        Object[] objArr2;
        Intrinsics.p(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i2 = 0;
        if (size != 0) {
            Iterator<?> it2 = collection.iterator();
            if (it2.hasNext()) {
                if (size <= objArr.length) {
                    objArr2 = objArr;
                } else {
                    Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    Intrinsics.n(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    objArr2 = (Object[]) newInstance;
                }
                while (true) {
                    int i3 = i2 + 1;
                    objArr2[i2] = it2.next();
                    if (i3 >= objArr2.length) {
                        if (!it2.hasNext()) {
                            return objArr2;
                        }
                        int i4 = ((i3 * 3) + 1) >>> 1;
                        if (i4 <= i3) {
                            i4 = f28925b;
                            if (i3 >= f28925b) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr2 = Arrays.copyOf(objArr2, i4);
                        Intrinsics.o(objArr2, "copyOf(result, newSize)");
                    } else if (!it2.hasNext()) {
                        if (objArr2 == objArr) {
                            objArr[i3] = null;
                            return objArr;
                        }
                        Object[] copyOf = Arrays.copyOf(objArr2, i3);
                        Intrinsics.o(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i2 = i3;
                }
            } else if (objArr.length <= 0) {
                return objArr;
            } else {
                objArr[0] = null;
                return objArr;
            }
        } else if (objArr.length <= 0) {
            return objArr;
        } else {
            objArr[0] = null;
            return objArr;
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [kotlin.jvm.functions.Function0<java.lang.Object[]>, kotlin.jvm.functions.Function0] */
    /* JADX WARNING: type inference failed for: r5v0, types: [kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super java.lang.Object[], ? super java.lang.Integer, java.lang.Object[]>] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.Object[] c(java.util.Collection<?> r2, kotlin.jvm.functions.Function0<java.lang.Object[]> r3, kotlin.jvm.functions.Function1<? super java.lang.Integer, java.lang.Object[]> r4, kotlin.jvm.functions.Function2<? super java.lang.Object[], ? super java.lang.Integer, java.lang.Object[]> r5) {
        /*
            int r0 = r2.size()
            if (r0 != 0) goto L_0x000d
        L_0x0006:
            java.lang.Object r2 = r3.o()
        L_0x000a:
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            return r2
        L_0x000d:
            java.util.Iterator r2 = r2.iterator()
            boolean r1 = r2.hasNext()
            if (r1 != 0) goto L_0x0018
            goto L_0x0006
        L_0x0018:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r4.f(r3)
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            r4 = 0
        L_0x0023:
            int r0 = r4 + 1
            java.lang.Object r1 = r2.next()
            r3[r4] = r1
            int r4 = r3.length
            if (r0 < r4) goto L_0x0054
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x0035
            return r3
        L_0x0035:
            int r4 = r0 * 3
            int r4 = r4 + 1
            int r4 = r4 >>> 1
            if (r4 > r0) goto L_0x0049
            r4 = 2147483645(0x7ffffffd, float:NaN)
            if (r0 >= r4) goto L_0x0043
            goto L_0x0049
        L_0x0043:
            java.lang.OutOfMemoryError r2 = new java.lang.OutOfMemoryError
            r2.<init>()
            throw r2
        L_0x0049:
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r4)
            java.lang.String r4 = "copyOf(result, newSize)"
            kotlin.jvm.internal.Intrinsics.o(r3, r4)
        L_0x0052:
            r4 = r0
            goto L_0x0023
        L_0x0054:
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x0052
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            java.lang.Object r2 = r5.d0(r3, r2)
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.CollectionToArray.c(java.util.Collection, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2):java.lang.Object[]");
    }
}
