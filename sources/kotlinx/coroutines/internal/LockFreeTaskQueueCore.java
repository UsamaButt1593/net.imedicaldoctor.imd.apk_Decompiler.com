package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\b\u0000\u0018\u0000 \f*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u000201B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\f\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000b2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u001f\u0010 J-\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010$\"\u0004\b\u0001\u0010!2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0005¢\u0006\u0004\b'\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010(R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010)R\u0014\u0010*\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010(R\u0011\u0010,\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b+\u0010\u001aR\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00062"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "index", "element", "Lkotlinx/coroutines/internal/Core;", "e", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "oldHead", "newHead", "m", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "j", "()J", "state", "c", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "b", "d", "()Z", "a", "(Ljava/lang/Object;)I", "l", "()Ljava/lang/Object;", "k", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "R", "Lkotlin/Function1;", "transform", "", "i", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "g", "I", "Z", "mask", "h", "isEmpty", "f", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class LockFreeTaskQueueCore<E> {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f29368e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f29369f;

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f29370g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f29371h = 8;

    /* renamed from: i  reason: collision with root package name */
    public static final int f29372i = 30;

    /* renamed from: j  reason: collision with root package name */
    public static final int f29373j = 1073741823;

    /* renamed from: k  reason: collision with root package name */
    public static final int f29374k = 0;

    /* renamed from: l  reason: collision with root package name */
    public static final long f29375l = 1073741823;

    /* renamed from: m  reason: collision with root package name */
    public static final int f29376m = 30;

    /* renamed from: n  reason: collision with root package name */
    public static final long f29377n = 1152921503533105152L;
    public static final int o = 60;
    public static final long p = 1152921504606846976L;
    public static final int q = 61;
    public static final long r = 2305843009213693952L;
    public static final int s = 1024;
    @NotNull
    @JvmField
    public static final Symbol t = new Symbol("REMOVE_FROZEN");
    public static final int u = 0;
    public static final int v = 1;
    public static final int w = 2;
    @NotNull
    private volatile /* synthetic */ Object _next = null;
    @NotNull
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a  reason: collision with root package name */
    private final int f29378a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f29379b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29380c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ AtomicReferenceArray f29381d;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000bJR\u0010\u0015\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u000e*\u00020\u000426\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00028\u00010\u000fH\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\b*\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0014\u0010!\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0014\u0010#\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u0014\u0010$\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b$\u0010\u001aR\u0014\u0010%\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b%\u0010\u001aR\u0014\u0010&\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b&\u0010\u001aR\u0014\u0010'\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b'\u0010\u001aR\u0014\u0010)\u001a\u00020(8\u0006X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b+\u0010\u001fR\u0014\u0010,\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b,\u0010\u001a¨\u0006-"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "<init>", "()V", "", "other", "e", "(JJ)J", "", "newHead", "b", "(JI)J", "newTail", "c", "T", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "block", "d", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "a", "(J)I", "ADD_CLOSED", "I", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "J", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "Lkotlinx/coroutines/internal/Symbol;", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public final int a(long j2) {
            return (j2 & LockFreeTaskQueueCore.r) != 0 ? 2 : 1;
        }

        public final long b(long j2, int i2) {
            return e(j2, LockFreeTaskQueueCore.f29375l) | ((long) i2);
        }

        public final long c(long j2, int i2) {
            return e(j2, LockFreeTaskQueueCore.f29377n) | (((long) i2) << 30);
        }

        public final <T> T d(long j2, @NotNull Function2<? super Integer, ? super Integer, ? extends T> function2) {
            return function2.d0(Integer.valueOf((int) (LockFreeTaskQueueCore.f29375l & j2)), Integer.valueOf((int) ((j2 & LockFreeTaskQueueCore.f29377n) >> 30)));
        }

        public final long e(long j2, long j3) {
            return j2 & (~j3);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "", "index", "<init>", "(I)V", "a", "I", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class Placeholder {
        @JvmField

        /* renamed from: a  reason: collision with root package name */
        public final int f29382a;

        public Placeholder(int i2) {
            this.f29382a = i2;
        }
    }

    static {
        Class<LockFreeTaskQueueCore> cls = LockFreeTaskQueueCore.class;
        f29369f = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        f29370g = AtomicLongFieldUpdater.newUpdater(cls, "_state");
    }

    public LockFreeTaskQueueCore(int i2, boolean z) {
        this.f29378a = i2;
        this.f29379b = z;
        int i3 = i2 - 1;
        this.f29380c = i3;
        this.f29381d = new AtomicReferenceArray(i2);
        if (i3 > 1073741823) {
            throw new IllegalStateException("Check failed.".toString());
        } else if ((i2 & i3) != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    private final LockFreeTaskQueueCore<E> b(long j2) {
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<>(this.f29378a * 2, this.f29379b);
        int i2 = (int) (f29375l & j2);
        int i3 = (int) ((f29377n & j2) >> 30);
        while (true) {
            int i4 = this.f29380c;
            if ((i2 & i4) != (i3 & i4)) {
                Object obj = this.f29381d.get(i4 & i2);
                if (obj == null) {
                    obj = new Placeholder(i2);
                }
                lockFreeTaskQueueCore.f29381d.set(lockFreeTaskQueueCore.f29380c & i2, obj);
                i2++;
            } else {
                lockFreeTaskQueueCore._state = f29368e.e(j2, p);
                return lockFreeTaskQueueCore;
            }
        }
    }

    private final LockFreeTaskQueueCore<E> c(long j2) {
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._next;
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            a.a(f29369f, this, (Object) null, b(j2));
        }
    }

    private final LockFreeTaskQueueCore<E> e(int i2, E e2) {
        Object obj = this.f29381d.get(this.f29380c & i2);
        if (!(obj instanceof Placeholder) || ((Placeholder) obj).f29382a != i2) {
            return null;
        }
        this.f29381d.set(i2 & this.f29380c, e2);
        return this;
    }

    private final long j() {
        long j2;
        long j3;
        do {
            j2 = this._state;
            if ((j2 & p) != 0) {
                return j2;
            }
            j3 = j2 | p;
        } while (!f29370g.compareAndSet(this, j2, j3));
        return j3;
    }

    private final LockFreeTaskQueueCore<E> m(int i2, int i3) {
        long j2;
        int i4;
        do {
            j2 = this._state;
            i4 = (int) (f29375l & j2);
            if ((p & j2) != 0) {
                return k();
            }
        } while (!f29370g.compareAndSet(this, j2, f29368e.b(j2, i3)));
        this.f29381d.set(i4 & this.f29380c, (Object) null);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066 A[LOOP:1: B:19:0x0066->B:22:0x0077, LOOP_START, PHI: r0 
      PHI: (r0v14 kotlinx.coroutines.internal.LockFreeTaskQueueCore) = (r0v13 kotlinx.coroutines.internal.LockFreeTaskQueueCore), (r0v16 kotlinx.coroutines.internal.LockFreeTaskQueueCore) binds: [B:18:0x005e, B:22:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(@org.jetbrains.annotations.NotNull E r12) {
        /*
            r11 = this;
        L_0x0000:
            long r2 = r11._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x0012
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r12 = f29368e
            int r12 = r12.a(r2)
            return r12
        L_0x0012:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            int r1 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r0 = 30
            long r4 = r4 >> r0
            int r8 = (int) r4
            int r9 = r11.f29380c
            int r0 = r8 + 2
            r0 = r0 & r9
            r4 = r1 & r9
            r5 = 1
            if (r0 != r4) goto L_0x002c
            return r5
        L_0x002c:
            boolean r0 = r11.f29379b
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 != 0) goto L_0x004b
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r11.f29381d
            r10 = r8 & r9
            java.lang.Object r0 = r0.get(r10)
            if (r0 == 0) goto L_0x004b
            int r0 = r11.f29378a
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L_0x004a
            int r8 = r8 - r1
            r1 = r8 & r4
            int r0 = r0 >> 1
            if (r1 <= r0) goto L_0x0000
        L_0x004a:
            return r5
        L_0x004b:
            int r0 = r8 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f29370g
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r4 = f29368e
            long r4 = r4.c(r2, r0)
            r0 = r1
            r1 = r11
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L_0x0000
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r11.f29381d
            r1 = r8 & r9
            r0.set(r1, r12)
            r0 = r11
        L_0x0066:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x0079
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.k()
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.e(r8, r12)
            if (r0 != 0) goto L_0x0066
        L_0x0079:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueueCore.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j2;
        do {
            j2 = this._state;
            if ((j2 & r) != 0) {
                return true;
            }
            if ((p & j2) != 0) {
                return false;
            }
        } while (!f29370g.compareAndSet(this, j2, j2 | r));
        return true;
    }

    public final int f() {
        long j2 = this._state;
        return 1073741823 & (((int) ((j2 & f29377n) >> 30)) - ((int) (f29375l & j2)));
    }

    public final boolean g() {
        return (this._state & r) != 0;
    }

    public final boolean h() {
        long j2 = this._state;
        return ((int) (f29375l & j2)) == ((int) ((j2 & f29377n) >> 30));
    }

    @NotNull
    public final <R> List<R> i(@NotNull Function1<? super E, ? extends R> function1) {
        ArrayList arrayList = new ArrayList(this.f29378a);
        long j2 = this._state;
        int i2 = (int) (f29375l & j2);
        int i3 = (int) ((j2 & f29377n) >> 30);
        while (true) {
            int i4 = this.f29380c;
            if ((i2 & i4) == (i3 & i4)) {
                return arrayList;
            }
            Object obj = this.f29381d.get(i4 & i2);
            if (obj != null && !(obj instanceof Placeholder)) {
                arrayList.add(function1.f(obj));
            }
            i2++;
        }
    }

    @NotNull
    public final LockFreeTaskQueueCore<E> k() {
        return c(j());
    }

    @Nullable
    public final Object l() {
        while (true) {
            long j2 = this._state;
            if ((p & j2) != 0) {
                return t;
            }
            int i2 = (int) (f29375l & j2);
            int i3 = (int) ((f29377n & j2) >> 30);
            int i4 = this.f29380c;
            if ((i3 & i4) == (i2 & i4)) {
                return null;
            }
            Object obj = this.f29381d.get(i4 & i2);
            if (obj == null) {
                if (this.f29379b) {
                    return null;
                }
            } else if (obj instanceof Placeholder) {
                return null;
            } else {
                int i5 = (i2 + 1) & f29373j;
                if (f29370g.compareAndSet(this, j2, f29368e.b(j2, i5))) {
                    this.f29381d.set(this.f29380c & i2, (Object) null);
                    return obj;
                } else if (this.f29379b) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
                    do {
                        lockFreeTaskQueueCore = lockFreeTaskQueueCore.m(i2, i5);
                    } while (lockFreeTaskQueueCore != null);
                    return obj;
                }
            }
        }
    }
}
