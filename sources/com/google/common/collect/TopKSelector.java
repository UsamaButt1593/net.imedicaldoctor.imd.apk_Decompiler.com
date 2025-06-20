package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class TopKSelector<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f22498a;

    /* renamed from: b  reason: collision with root package name */
    private final Comparator<? super T> f22499b;

    /* renamed from: c  reason: collision with root package name */
    private final T[] f22500c;

    /* renamed from: d  reason: collision with root package name */
    private int f22501d;
    @CheckForNull

    /* renamed from: e  reason: collision with root package name */
    private T f22502e;

    private TopKSelector(Comparator<? super T> comparator, int i2) {
        this.f22499b = (Comparator) Preconditions.F(comparator, "comparator");
        this.f22498a = i2;
        boolean z = true;
        Preconditions.k(i2 >= 0, "k (%s) must be >= 0", i2);
        Preconditions.k(i2 > 1073741823 ? false : z, "k (%s) must be <= Integer.MAX_VALUE / 2", i2);
        this.f22500c = new Object[IntMath.d(i2, 2)];
        this.f22501d = 0;
        this.f22502e = null;
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> a(int i2) {
        return b(i2, Ordering.z());
    }

    public static <T> TopKSelector<T> b(int i2, Comparator<? super T> comparator) {
        return new TopKSelector<>(Ordering.i(comparator).E(), i2);
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> c(int i2) {
        return d(i2, Ordering.z());
    }

    public static <T> TopKSelector<T> d(int i2, Comparator<? super T> comparator) {
        return new TopKSelector<>(comparator, i2);
    }

    private int h(int i2, int i3, int i4) {
        T a2 = NullnessCasts.a(this.f22500c[i4]);
        T[] tArr = this.f22500c;
        tArr[i4] = tArr[i3];
        int i5 = i2;
        while (i2 < i3) {
            if (this.f22499b.compare(NullnessCasts.a(this.f22500c[i2]), a2) < 0) {
                i(i5, i2);
                i5++;
            }
            i2++;
        }
        T[] tArr2 = this.f22500c;
        tArr2[i3] = tArr2[i5];
        tArr2[i5] = a2;
        return i5;
    }

    private void i(int i2, int i3) {
        T[] tArr = this.f22500c;
        T t = tArr[i2];
        tArr[i2] = tArr[i3];
        tArr[i3] = t;
    }

    private void k() {
        int i2 = (this.f22498a * 2) - 1;
        int p = IntMath.p(i2, RoundingMode.CEILING) * 3;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 < i2) {
                int h2 = h(i3, i2, ((i3 + i2) + 1) >>> 1);
                int i6 = this.f22498a;
                if (h2 <= i6) {
                    if (h2 >= i6) {
                        break;
                    }
                    i3 = Math.max(h2, i3 + 1);
                    i5 = h2;
                } else {
                    i2 = h2 - 1;
                }
                i4++;
                if (i4 >= p) {
                    Arrays.sort(this.f22500c, i3, i2 + 1, this.f22499b);
                    break;
                }
            } else {
                break;
            }
        }
        this.f22501d = this.f22498a;
        this.f22502e = NullnessCasts.a(this.f22500c[i5]);
        while (true) {
            i5++;
            if (i5 >= this.f22498a) {
                return;
            }
            if (this.f22499b.compare(NullnessCasts.a(this.f22500c[i5]), NullnessCasts.a(this.f22502e)) > 0) {
                this.f22502e = this.f22500c[i5];
            }
        }
    }

    public void e(@ParametricNullness T t) {
        int i2 = this.f22498a;
        if (i2 != 0) {
            int i3 = this.f22501d;
            if (i3 == 0) {
                this.f22500c[0] = t;
                this.f22502e = t;
                this.f22501d = 1;
            } else if (i3 < i2) {
                T[] tArr = this.f22500c;
                this.f22501d = i3 + 1;
                tArr[i3] = t;
                if (this.f22499b.compare(t, NullnessCasts.a(this.f22502e)) > 0) {
                    this.f22502e = t;
                }
            } else if (this.f22499b.compare(t, NullnessCasts.a(this.f22502e)) < 0) {
                T[] tArr2 = this.f22500c;
                int i4 = this.f22501d;
                int i5 = i4 + 1;
                this.f22501d = i5;
                tArr2[i4] = t;
                if (i5 == this.f22498a * 2) {
                    k();
                }
            }
        }
    }

    public void f(Iterable<? extends T> iterable) {
        g(iterable.iterator());
    }

    public void g(Iterator<? extends T> it2) {
        while (it2.hasNext()) {
            e(it2.next());
        }
    }

    public List<T> j() {
        T[] tArr = this.f22500c;
        Arrays.sort(tArr, 0, this.f22501d, this.f22499b);
        int i2 = this.f22501d;
        int i3 = this.f22498a;
        if (i2 > i3) {
            T[] tArr2 = this.f22500c;
            Arrays.fill(tArr2, i3, tArr2.length, (Object) null);
            int i4 = this.f22498a;
            this.f22501d = i4;
            this.f22502e = this.f22500c[i4 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(tArr, this.f22501d)));
    }
}
