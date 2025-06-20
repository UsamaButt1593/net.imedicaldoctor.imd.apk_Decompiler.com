package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.4")
@SourceDebugExtension({"SMAP\nArrayDeque.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,583:1\n467#1,51:586\n467#1,51:637\n37#2,2:584\n26#3:688\n*S KotlinDebug\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n*L\n462#1:586,51\n464#1:637,51\n47#1:584,2\n562#1:688\n*E\n"})
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 [*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\\B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007B\u0017\b\u0016\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0005\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u0018\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u0015J%\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\u001f\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0\u001cH\b¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001dH\u0016¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00028\u0000¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b%\u0010$J\r\u0010&\u001a\u00028\u0000¢\u0006\u0004\b&\u0010$J\u000f\u0010'\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b'\u0010$J\u0015\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00028\u0000¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\f2\u0006\u0010(\u001a\u00028\u0000¢\u0006\u0004\b+\u0010*J\r\u0010,\u001a\u00028\u0000¢\u0006\u0004\b,\u0010$J\u000f\u0010-\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b-\u0010$J\r\u0010.\u001a\u00028\u0000¢\u0006\u0004\b.\u0010$J\u000f\u0010/\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b/\u0010$J\u0017\u00100\u001a\u00020\u001d2\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0004\b0\u00101J\u001f\u00100\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0004\b0\u00102J\u001d\u00103\u001a\u00020\u001d2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b3\u00104J%\u00103\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b3\u00105J\u0018\u00106\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b6\u0010\u0012J \u00107\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010(\u001a\u00028\u0000H\u0002¢\u0006\u0004\b7\u00108J\u0018\u00109\u001a\u00020\u001d2\u0006\u0010(\u001a\u00028\u0000H\u0002¢\u0006\u0004\b9\u00101J\u0017\u0010:\u001a\u00020\u00032\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00032\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0004\b<\u0010;J\u0017\u0010=\u001a\u00020\u001d2\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0004\b=\u00101J\u0017\u0010>\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b>\u0010\u0012J\u001d\u0010?\u001a\u00020\u001d2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b?\u00104J\u001d\u0010@\u001a\u00020\u001d2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b@\u00104J\u000f\u0010A\u001a\u00020\fH\u0016¢\u0006\u0004\bA\u0010\u0007J)\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00010C\"\u0004\b\u0001\u0010B2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00010CH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010G0CH\u0016¢\u0006\u0004\bE\u0010HJ)\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00010C\"\u0004\b\u0001\u0010B2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00010CH\u0000¢\u0006\u0004\bI\u0010FJ\u0017\u0010\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010G0CH\u0000¢\u0006\u0004\b\u0001\u0010HJO\u0010O\u001a\u00020\f2>\u0010N\u001a:\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(M\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010G0C¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f0JH\u0000¢\u0006\u0004\bO\u0010PR\u0016\u0010M\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u001e\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010G0C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010TR$\u0010Z\u001a\u00020\u00032\u0006\u0010V\u001a\u00020\u00038\u0016@RX\u000e¢\u0006\f\n\u0004\bW\u0010R\u001a\u0004\bX\u0010Y¨\u0006]"}, d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "", "initialCapacity", "<init>", "(I)V", "()V", "", "elements", "(Ljava/util/Collection;)V", "minCapacity", "", "j", "newCapacity", "g", "internalIndex", "o", "(I)Ljava/lang/Object;", "index", "B", "(I)I", "z", "q", "n", "h", "d", "(ILjava/util/Collection;)V", "Lkotlin/Function1;", "", "predicate", "k", "(Lkotlin/jvm/functions/Function1;)Z", "isEmpty", "()Z", "first", "()Ljava/lang/Object;", "m", "last", "t", "element", "addFirst", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "C", "removeLast", "D", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "c", "removeAll", "retainAll", "clear", "T", "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "H", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "structure", "r", "(Lkotlin/jvm/functions/Function2;)V", "s", "I", "X", "[Ljava/lang/Object;", "elementData", "<set-?>", "Y", "b", "()I", "size", "Z", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    @NotNull
    private static final Object[] X2 = new Object[0];
    private static final int Y2 = 2147483639;
    @NotNull
    public static final Companion Z = new Companion((DefaultConstructorMarker) null);
    private static final int Z2 = 10;
    @NotNull
    private Object[] X;
    private int Y;
    private int s;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "<init>", "()V", "", "oldCapacity", "minCapacity", "a", "(II)I", "defaultMinCapacity", "I", "", "emptyElementData", "[Ljava/lang/Object;", "maxArraySize", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public final int a(int i2, int i3) {
            int i4 = i2 + (i2 >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            if (i4 - ArrayDeque.Y2 <= 0) {
                return i4;
            }
            if (i3 > ArrayDeque.Y2) {
                return Integer.MAX_VALUE;
            }
            return ArrayDeque.Y2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ArrayDeque() {
        this.X = X2;
    }

    private final int B(int i2) {
        Object[] objArr = this.X;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    private final void d(int i2, Collection<? extends E> collection) {
        Iterator<? extends E> it2 = collection.iterator();
        int length = this.X.length;
        while (i2 < length && it2.hasNext()) {
            this.X[i2] = it2.next();
            i2++;
        }
        int i3 = this.s;
        for (int i4 = 0; i4 < i3 && it2.hasNext(); i4++) {
            this.X[i4] = it2.next();
        }
        this.Y = size() + collection.size();
    }

    private final void g(int i2) {
        Object[] objArr = new Object[i2];
        Object[] objArr2 = this.X;
        ArraysKt.B0(objArr2, objArr, 0, this.s, objArr2.length);
        Object[] objArr3 = this.X;
        int length = objArr3.length;
        int i3 = this.s;
        ArraysKt.B0(objArr3, objArr, length - i3, 0, i3);
        this.s = 0;
        this.X = objArr;
    }

    private final int h(int i2) {
        return i2 == 0 ? ArraysKt___ArraysKt.we(this.X) : i2 - 1;
    }

    private final void j(int i2) {
        if (i2 >= 0) {
            Object[] objArr = this.X;
            if (i2 > objArr.length) {
                if (objArr == X2) {
                    this.X = new Object[RangesKt.u(i2, 10)];
                } else {
                    g(Z.a(objArr.length, i2));
                }
            }
        } else {
            throw new IllegalStateException("Deque is too big.");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean k(kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r12) {
        /*
            r11 = this;
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x009b
            java.lang.Object[] r0 = r11.X
            int r0 = r0.length
            if (r0 != 0) goto L_0x000e
            goto L_0x009b
        L_0x000e:
            int r0 = r11.s
            int r2 = r11.size()
            int r0 = r0 + r2
            int r0 = r11.B(r0)
            int r2 = r11.s
            r3 = 0
            r4 = 1
            if (r2 >= r0) goto L_0x0044
            r5 = r2
        L_0x0020:
            if (r2 >= r0) goto L_0x003e
            java.lang.Object[] r6 = r11.X
            r6 = r6[r2]
            java.lang.Object r7 = r12.f(r6)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x003a
            java.lang.Object[] r7 = r11.X
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003b
        L_0x003a:
            r1 = 1
        L_0x003b:
            int r2 = r2 + 1
            goto L_0x0020
        L_0x003e:
            java.lang.Object[] r12 = r11.X
            kotlin.collections.ArraysKt.M1(r12, r3, r5, r0)
            goto L_0x0090
        L_0x0044:
            java.lang.Object[] r5 = r11.X
            int r5 = r5.length
            r6 = r2
            r7 = 0
        L_0x0049:
            if (r2 >= r5) goto L_0x0069
            java.lang.Object[] r8 = r11.X
            r9 = r8[r2]
            r8[r2] = r3
            java.lang.Object r8 = r12.f(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0065
            java.lang.Object[] r8 = r11.X
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0066
        L_0x0065:
            r7 = 1
        L_0x0066:
            int r2 = r2 + 1
            goto L_0x0049
        L_0x0069:
            int r2 = r11.B(r6)
            r5 = r2
        L_0x006e:
            if (r1 >= r0) goto L_0x008f
            java.lang.Object[] r2 = r11.X
            r6 = r2[r1]
            r2[r1] = r3
            java.lang.Object r2 = r12.f(r6)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x008b
            java.lang.Object[] r2 = r11.X
            r2[r5] = r6
            int r5 = r11.n(r5)
            goto L_0x008c
        L_0x008b:
            r7 = 1
        L_0x008c:
            int r1 = r1 + 1
            goto L_0x006e
        L_0x008f:
            r1 = r7
        L_0x0090:
            if (r1 == 0) goto L_0x009b
            int r12 = r11.s
            int r5 = r5 - r12
            int r12 = r11.z(r5)
            r11.Y = r12
        L_0x009b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.k(kotlin.jvm.functions.Function1):boolean");
    }

    private final int n(int i2) {
        if (i2 == ArraysKt___ArraysKt.we(this.X)) {
            return 0;
        }
        return i2 + 1;
    }

    @InlineOnly
    private final E o(int i2) {
        return this.X[i2];
    }

    @InlineOnly
    private final int q(int i2) {
        return B(this.s + i2);
    }

    private final int z(int i2) {
        return i2 < 0 ? i2 + this.X.length : i2;
    }

    @Nullable
    public final E C() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Nullable
    public final E D() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @NotNull
    public final Object[] E() {
        return toArray();
    }

    @NotNull
    public final <T> T[] H(@NotNull T[] tArr) {
        Intrinsics.p(tArr, "array");
        return toArray(tArr);
    }

    public void add(int i2, E e2) {
        AbstractList.s.c(i2, size());
        if (i2 == size()) {
            addLast(e2);
        } else if (i2 == 0) {
            addFirst(e2);
        } else {
            j(size() + 1);
            int B = B(this.s + i2);
            if (i2 < ((size() + 1) >> 1)) {
                int h2 = h(B);
                int h3 = h(this.s);
                int i3 = this.s;
                if (h2 >= i3) {
                    Object[] objArr = this.X;
                    objArr[h3] = objArr[i3];
                    ArraysKt.B0(objArr, objArr, i3, i3 + 1, h2 + 1);
                } else {
                    Object[] objArr2 = this.X;
                    ArraysKt.B0(objArr2, objArr2, i3 - 1, i3, objArr2.length);
                    Object[] objArr3 = this.X;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    ArraysKt.B0(objArr3, objArr3, 0, 1, h2 + 1);
                }
                this.X[h2] = e2;
                this.s = h3;
            } else {
                int B2 = B(this.s + size());
                Object[] objArr4 = this.X;
                if (B < B2) {
                    ArraysKt.B0(objArr4, objArr4, B + 1, B, B2);
                } else {
                    ArraysKt.B0(objArr4, objArr4, 1, 0, B2);
                    Object[] objArr5 = this.X;
                    objArr5[0] = objArr5[objArr5.length - 1];
                    ArraysKt.B0(objArr5, objArr5, B + 1, B, objArr5.length - 1);
                }
                this.X[B] = e2;
            }
            this.Y = size() + 1;
        }
    }

    public boolean addAll(int i2, @NotNull Collection<? extends E> collection) {
        Intrinsics.p(collection, "elements");
        AbstractList.s.c(i2, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i2 == size()) {
            return addAll(collection);
        }
        j(size() + collection.size());
        int B = B(this.s + size());
        int B2 = B(this.s + i2);
        int size = collection.size();
        if (i2 < ((size() + 1) >> 1)) {
            int i3 = this.s;
            int i4 = i3 - size;
            if (B2 < i3) {
                Object[] objArr = this.X;
                ArraysKt.B0(objArr, objArr, i4, i3, objArr.length);
                Object[] objArr2 = this.X;
                if (size >= B2) {
                    ArraysKt.B0(objArr2, objArr2, objArr2.length - size, 0, B2);
                } else {
                    ArraysKt.B0(objArr2, objArr2, objArr2.length - size, 0, size);
                    Object[] objArr3 = this.X;
                    ArraysKt.B0(objArr3, objArr3, 0, size, B2);
                }
            } else if (i4 >= 0) {
                Object[] objArr4 = this.X;
                ArraysKt.B0(objArr4, objArr4, i4, i3, B2);
            } else {
                Object[] objArr5 = this.X;
                i4 += objArr5.length;
                int i5 = B2 - i3;
                int length = objArr5.length - i4;
                if (length >= i5) {
                    ArraysKt.B0(objArr5, objArr5, i4, i3, B2);
                } else {
                    ArraysKt.B0(objArr5, objArr5, i4, i3, i3 + length);
                    Object[] objArr6 = this.X;
                    ArraysKt.B0(objArr6, objArr6, 0, this.s + length, B2);
                }
            }
            this.s = i4;
            d(z(B2 - size), collection);
        } else {
            int i6 = B2 + size;
            if (B2 < B) {
                int i7 = size + B;
                Object[] objArr7 = this.X;
                if (i7 > objArr7.length) {
                    if (i6 >= objArr7.length) {
                        i6 -= objArr7.length;
                    } else {
                        int length2 = B - (i7 - objArr7.length);
                        ArraysKt.B0(objArr7, objArr7, 0, length2, B);
                        Object[] objArr8 = this.X;
                        ArraysKt.B0(objArr8, objArr8, i6, B2, length2);
                    }
                }
                ArraysKt.B0(objArr7, objArr7, i6, B2, B);
            } else {
                Object[] objArr9 = this.X;
                ArraysKt.B0(objArr9, objArr9, size, 0, B);
                Object[] objArr10 = this.X;
                if (i6 >= objArr10.length) {
                    ArraysKt.B0(objArr10, objArr10, i6 - objArr10.length, B2, objArr10.length);
                } else {
                    ArraysKt.B0(objArr10, objArr10, 0, objArr10.length - size, objArr10.length);
                    Object[] objArr11 = this.X;
                    ArraysKt.B0(objArr11, objArr11, i6, B2, objArr11.length - size);
                }
            }
            d(B2, collection);
        }
        return true;
    }

    public final void addFirst(E e2) {
        j(size() + 1);
        int h2 = h(this.s);
        this.s = h2;
        this.X[h2] = e2;
        this.Y = size() + 1;
    }

    public final void addLast(E e2) {
        j(size() + 1);
        this.X[B(this.s + size())] = e2;
        this.Y = size() + 1;
    }

    public int b() {
        return this.Y;
    }

    public E c(int i2) {
        AbstractList.s.b(i2, size());
        if (i2 == CollectionsKt.G(this)) {
            return removeLast();
        }
        if (i2 == 0) {
            return removeFirst();
        }
        int B = B(this.s + i2);
        E e2 = this.X[B];
        if (i2 < (size() >> 1)) {
            int i3 = this.s;
            if (B >= i3) {
                Object[] objArr = this.X;
                ArraysKt.B0(objArr, objArr, i3 + 1, i3, B);
            } else {
                Object[] objArr2 = this.X;
                ArraysKt.B0(objArr2, objArr2, 1, 0, B);
                Object[] objArr3 = this.X;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i4 = this.s;
                ArraysKt.B0(objArr3, objArr3, i4 + 1, i4, objArr3.length - 1);
            }
            Object[] objArr4 = this.X;
            int i5 = this.s;
            objArr4[i5] = null;
            this.s = n(i5);
        } else {
            int B2 = B(this.s + CollectionsKt.G(this));
            Object[] objArr5 = this.X;
            if (B <= B2) {
                ArraysKt.B0(objArr5, objArr5, B, B + 1, B2 + 1);
            } else {
                ArraysKt.B0(objArr5, objArr5, B, B + 1, objArr5.length);
                Object[] objArr6 = this.X;
                objArr6[objArr6.length - 1] = objArr6[0];
                ArraysKt.B0(objArr6, objArr6, 0, 1, B2 + 1);
            }
            this.X[B2] = null;
        }
        this.Y = size() - 1;
        return e2;
    }

    public void clear() {
        int B = B(this.s + size());
        int i2 = this.s;
        if (i2 < B) {
            ArraysKt.M1(this.X, null, i2, B);
        } else if (!isEmpty()) {
            Object[] objArr = this.X;
            ArraysKt.M1(objArr, null, this.s, objArr.length);
            ArraysKt.M1(this.X, null, 0, B);
        }
        this.s = 0;
        this.Y = 0;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final E first() {
        if (!isEmpty()) {
            return this.X[this.s];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public E get(int i2) {
        AbstractList.s.b(i2, size());
        return this.X[B(this.s + i2)];
    }

    public int indexOf(Object obj) {
        int B = B(this.s + size());
        int i2 = this.s;
        if (i2 < B) {
            while (i2 < B) {
                if (!Intrinsics.g(obj, this.X[i2])) {
                    i2++;
                }
            }
            return -1;
        } else if (i2 < B) {
            return -1;
        } else {
            int length = this.X.length;
            while (true) {
                if (i2 >= length) {
                    int i3 = 0;
                    while (i3 < B) {
                        if (Intrinsics.g(obj, this.X[i3])) {
                            i2 = i3 + this.X.length;
                        } else {
                            i3++;
                        }
                    }
                    return -1;
                } else if (Intrinsics.g(obj, this.X[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return i2 - this.s;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final E last() {
        if (!isEmpty()) {
            return this.X[B(this.s + CollectionsKt.G(this))];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public int lastIndexOf(Object obj) {
        int i2;
        int B = B(this.s + size());
        int i3 = this.s;
        if (i3 < B) {
            i2 = B - 1;
            if (i3 <= i2) {
                while (!Intrinsics.g(obj, this.X[i2])) {
                    if (i2 != i3) {
                        i2--;
                    }
                }
            }
            return -1;
        }
        if (i3 > B) {
            int i4 = B - 1;
            while (true) {
                if (-1 >= i4) {
                    int we = ArraysKt___ArraysKt.we(this.X);
                    int i5 = this.s;
                    if (i5 <= we) {
                        while (!Intrinsics.g(obj, this.X[i2])) {
                            if (i2 != i5) {
                                we = i2 - 1;
                            }
                        }
                    }
                } else if (Intrinsics.g(obj, this.X[i4])) {
                    i2 = i4 + this.X.length;
                    break;
                } else {
                    i4--;
                }
            }
        }
        return -1;
        return i2 - this.s;
    }

    @Nullable
    public final E m() {
        if (isEmpty()) {
            return null;
        }
        return this.X[this.s];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0016, code lost:
        r1 = r2.s;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Object[], kotlin.Unit> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "structure"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            int r0 = r2.s
            int r1 = r2.size()
            int r0 = r0 + r1
            int r0 = r2.B(r0)
            boolean r1 = r2.isEmpty()
            if (r1 != 0) goto L_0x0020
            int r1 = r2.s
            if (r1 >= r0) goto L_0x001b
            goto L_0x0020
        L_0x001b:
            java.lang.Object[] r0 = r2.X
            int r0 = r0.length
            int r1 = r1 - r0
            goto L_0x0022
        L_0x0020:
            int r1 = r2.s
        L_0x0022:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            java.lang.Object[] r1 = r2.toArray()
            r3.d0(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.r(kotlin.jvm.functions.Function2):void");
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeAll(@org.jetbrains.annotations.NotNull java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.p(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0091
            java.lang.Object[] r0 = r11.X
            int r0 = r0.length
            if (r0 != 0) goto L_0x0013
            goto L_0x0091
        L_0x0013:
            int r0 = r11.s
            int r2 = r11.size()
            int r0 = r0 + r2
            int r0 = r11.B(r0)
            int r2 = r11.s
            r3 = 0
            r4 = 1
            if (r2 >= r0) goto L_0x0044
            r5 = r2
        L_0x0025:
            if (r2 >= r0) goto L_0x003e
            java.lang.Object[] r6 = r11.X
            r6 = r6[r2]
            boolean r7 = r12.contains(r6)
            r7 = r7 ^ r4
            if (r7 == 0) goto L_0x003a
            java.lang.Object[] r7 = r11.X
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003b
        L_0x003a:
            r1 = 1
        L_0x003b:
            int r2 = r2 + 1
            goto L_0x0025
        L_0x003e:
            java.lang.Object[] r12 = r11.X
            kotlin.collections.ArraysKt.M1(r12, r3, r5, r0)
            goto L_0x0086
        L_0x0044:
            java.lang.Object[] r5 = r11.X
            int r5 = r5.length
            r6 = r2
            r7 = 0
        L_0x0049:
            if (r2 >= r5) goto L_0x0064
            java.lang.Object[] r8 = r11.X
            r9 = r8[r2]
            r8[r2] = r3
            boolean r8 = r12.contains(r9)
            r8 = r8 ^ r4
            if (r8 == 0) goto L_0x0060
            java.lang.Object[] r8 = r11.X
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0061
        L_0x0060:
            r7 = 1
        L_0x0061:
            int r2 = r2 + 1
            goto L_0x0049
        L_0x0064:
            int r2 = r11.B(r6)
            r5 = r2
        L_0x0069:
            if (r1 >= r0) goto L_0x0085
            java.lang.Object[] r2 = r11.X
            r6 = r2[r1]
            r2[r1] = r3
            boolean r2 = r12.contains(r6)
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x0081
            java.lang.Object[] r2 = r11.X
            r2[r5] = r6
            int r5 = r11.n(r5)
            goto L_0x0082
        L_0x0081:
            r7 = 1
        L_0x0082:
            int r1 = r1 + 1
            goto L_0x0069
        L_0x0085:
            r1 = r7
        L_0x0086:
            if (r1 == 0) goto L_0x0091
            int r12 = r11.s
            int r5 = r5 - r12
            int r12 = r11.z(r5)
            r11.Y = r12
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.removeAll(java.util.Collection):boolean");
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            E[] eArr = this.X;
            int i2 = this.s;
            E e2 = eArr[i2];
            eArr[i2] = null;
            this.s = n(i2);
            this.Y = size() - 1;
            return e2;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int B = B(this.s + CollectionsKt.G(this));
            E[] eArr = this.X;
            E e2 = eArr[B];
            eArr[B] = null;
            this.Y = size() - 1;
            return e2;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean retainAll(@org.jetbrains.annotations.NotNull java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.p(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x008e
            java.lang.Object[] r0 = r11.X
            int r0 = r0.length
            if (r0 != 0) goto L_0x0013
            goto L_0x008e
        L_0x0013:
            int r0 = r11.s
            int r2 = r11.size()
            int r0 = r0 + r2
            int r0 = r11.B(r0)
            int r2 = r11.s
            r3 = 0
            r4 = 1
            if (r2 >= r0) goto L_0x0043
            r5 = r2
        L_0x0025:
            if (r2 >= r0) goto L_0x003d
            java.lang.Object[] r6 = r11.X
            r6 = r6[r2]
            boolean r7 = r12.contains(r6)
            if (r7 == 0) goto L_0x0039
            java.lang.Object[] r7 = r11.X
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003a
        L_0x0039:
            r1 = 1
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0025
        L_0x003d:
            java.lang.Object[] r12 = r11.X
            kotlin.collections.ArraysKt.M1(r12, r3, r5, r0)
            goto L_0x0083
        L_0x0043:
            java.lang.Object[] r5 = r11.X
            int r5 = r5.length
            r6 = r2
            r7 = 0
        L_0x0048:
            if (r2 >= r5) goto L_0x0062
            java.lang.Object[] r8 = r11.X
            r9 = r8[r2]
            r8[r2] = r3
            boolean r8 = r12.contains(r9)
            if (r8 == 0) goto L_0x005e
            java.lang.Object[] r8 = r11.X
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x005f
        L_0x005e:
            r7 = 1
        L_0x005f:
            int r2 = r2 + 1
            goto L_0x0048
        L_0x0062:
            int r2 = r11.B(r6)
            r5 = r2
        L_0x0067:
            if (r1 >= r0) goto L_0x0082
            java.lang.Object[] r2 = r11.X
            r6 = r2[r1]
            r2[r1] = r3
            boolean r2 = r12.contains(r6)
            if (r2 == 0) goto L_0x007e
            java.lang.Object[] r2 = r11.X
            r2[r5] = r6
            int r5 = r11.n(r5)
            goto L_0x007f
        L_0x007e:
            r7 = 1
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x0067
        L_0x0082:
            r1 = r7
        L_0x0083:
            if (r1 == 0) goto L_0x008e
            int r12 = r11.s
            int r5 = r5 - r12
            int r12 = r11.z(r5)
            r11.Y = r12
        L_0x008e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.retainAll(java.util.Collection):boolean");
    }

    public E set(int i2, E e2) {
        AbstractList.s.b(i2, size());
        int B = B(this.s + i2);
        E[] eArr = this.X;
        E e3 = eArr[B];
        eArr[B] = e2;
        return e3;
    }

    @Nullable
    public final E t() {
        if (isEmpty()) {
            return null;
        }
        return this.X[B(this.s + CollectionsKt.G(this))];
    }

    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public ArrayDeque(int i2) {
        Object[] objArr;
        if (i2 == 0) {
            objArr = X2;
        } else if (i2 > 0) {
            objArr = new Object[i2];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + i2);
        }
        this.X = objArr;
    }

    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    public boolean addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.p(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        j(size() + collection.size());
        d(B(this.s + size()), collection);
        return true;
    }

    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        Intrinsics.p(tArr, "array");
        if (tArr.length < size()) {
            tArr = ArraysKt__ArraysJVMKt.a(tArr, size());
        }
        int B = B(this.s + size());
        int i2 = this.s;
        if (i2 < B) {
            ArraysKt.K0(this.X, tArr, 0, i2, B, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.X;
            ArraysKt.B0(objArr, tArr, 0, this.s, objArr.length);
            Object[] objArr2 = this.X;
            ArraysKt.B0(objArr2, tArr, objArr2.length - this.s, 0, B);
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }

    public ArrayDeque(@NotNull Collection<? extends E> collection) {
        Intrinsics.p(collection, "elements");
        Object[] array = collection.toArray(new Object[0]);
        this.X = array;
        this.Y = array.length;
        if (array.length == 0) {
            this.X = X2;
        }
    }
}
