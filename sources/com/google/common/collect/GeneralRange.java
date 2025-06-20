package com.google.common.collect;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class GeneralRange<T> implements Serializable {
    private final boolean X;
    private final boolean X2;
    @CheckForNull
    private final T Y;
    @CheckForNull
    private final T Y2;
    private final BoundType Z;
    private final BoundType Z2;
    @CheckForNull
    @LazyInit
    private transient GeneralRange<T> a3;
    private final Comparator<? super T> s;

    private GeneralRange(Comparator<? super T> comparator, boolean z, @CheckForNull T t, BoundType boundType, boolean z2, @CheckForNull T t2, BoundType boundType2) {
        this.s = (Comparator) Preconditions.E(comparator);
        this.X = z;
        this.X2 = z2;
        this.Y = t;
        this.Z = (BoundType) Preconditions.E(boundType);
        this.Y2 = t2;
        this.Z2 = (BoundType) Preconditions.E(boundType2);
        if (z) {
            comparator.compare(NullnessCasts.a(t), NullnessCasts.a(t));
        }
        if (z2) {
            comparator.compare(NullnessCasts.a(t2), NullnessCasts.a(t2));
        }
        if (z && z2) {
            int compare = comparator.compare(NullnessCasts.a(t), NullnessCasts.a(t2));
            boolean z3 = false;
            Preconditions.y(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (compare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                Preconditions.d((boundType == boundType3 && boundType2 == boundType3) ? z3 : true);
            }
        }
    }

    static <T> GeneralRange<T> a(Comparator<? super T> comparator) {
        BoundType boundType = BoundType.OPEN;
        return new GeneralRange(comparator, false, (Object) null, boundType, false, (Object) null, boundType);
    }

    static <T> GeneralRange<T> d(Comparator<? super T> comparator, @ParametricNullness T t, BoundType boundType) {
        return new GeneralRange(comparator, true, t, boundType, false, (T) null, BoundType.OPEN);
    }

    static <T extends Comparable> GeneralRange<T> e(Range<T> range) {
        T t = null;
        T y = range.q() ? range.y() : null;
        BoundType x = range.q() ? range.x() : BoundType.OPEN;
        if (range.r()) {
            t = range.L();
        }
        return new GeneralRange(Ordering.z(), range.q(), y, x, range.r(), t, range.r() ? range.K() : BoundType.OPEN);
    }

    static <T> GeneralRange<T> n(Comparator<? super T> comparator, @ParametricNullness T t, BoundType boundType, @ParametricNullness T t2, BoundType boundType2) {
        return new GeneralRange(comparator, true, t, boundType, true, t2, boundType2);
    }

    static <T> GeneralRange<T> r(Comparator<? super T> comparator, @ParametricNullness T t, BoundType boundType) {
        return new GeneralRange(comparator, false, (Object) null, BoundType.OPEN, true, t, boundType);
    }

    /* access modifiers changed from: package-private */
    public Comparator<? super T> b() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public boolean c(@ParametricNullness T t) {
        return !q(t) && !p(t);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof GeneralRange)) {
            return false;
        }
        GeneralRange generalRange = (GeneralRange) obj;
        return this.s.equals(generalRange.s) && this.X == generalRange.X && this.X2 == generalRange.X2 && f().equals(generalRange.f()) && h().equals(generalRange.h()) && Objects.a(g(), generalRange.g()) && Objects.a(i(), generalRange.i());
    }

    /* access modifiers changed from: package-private */
    public BoundType f() {
        return this.Z;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public T g() {
        return this.Y;
    }

    /* access modifiers changed from: package-private */
    public BoundType h() {
        return this.Z2;
    }

    public int hashCode() {
        return Objects.b(this.s, g(), f(), i(), h());
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public T i() {
        return this.Y2;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.X;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.X2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
        if (r12.f() == com.google.common.collect.BoundType.OPEN) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
        if (r12.h() == com.google.common.collect.BoundType.OPEN) goto L_0x005d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008b A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.collect.GeneralRange<T> l(com.google.common.collect.GeneralRange<T> r12) {
        /*
            r11 = this;
            com.google.common.base.Preconditions.E(r12)
            java.util.Comparator<? super T> r0 = r11.s
            java.util.Comparator<? super T> r1 = r12.s
            boolean r0 = r0.equals(r1)
            com.google.common.base.Preconditions.d(r0)
            boolean r0 = r11.X
            java.lang.Object r1 = r11.g()
            com.google.common.collect.BoundType r2 = r11.f()
            boolean r3 = r11.j()
            if (r3 != 0) goto L_0x002a
            boolean r0 = r12.X
        L_0x0020:
            java.lang.Object r1 = r12.g()
            com.google.common.collect.BoundType r2 = r12.f()
        L_0x0028:
            r5 = r0
            goto L_0x004b
        L_0x002a:
            boolean r3 = r12.j()
            if (r3 == 0) goto L_0x0028
            java.util.Comparator<? super T> r3 = r11.s
            java.lang.Object r4 = r11.g()
            java.lang.Object r5 = r12.g()
            int r3 = r3.compare(r4, r5)
            if (r3 < 0) goto L_0x0020
            if (r3 != 0) goto L_0x0028
            com.google.common.collect.BoundType r3 = r12.f()
            com.google.common.collect.BoundType r4 = com.google.common.collect.BoundType.OPEN
            if (r3 != r4) goto L_0x0028
            goto L_0x0020
        L_0x004b:
            boolean r0 = r11.X2
            java.lang.Object r3 = r11.i()
            com.google.common.collect.BoundType r4 = r11.h()
            boolean r6 = r11.k()
            if (r6 != 0) goto L_0x0068
            boolean r0 = r12.X2
        L_0x005d:
            java.lang.Object r3 = r12.i()
            com.google.common.collect.BoundType r4 = r12.h()
        L_0x0065:
            r8 = r0
            r9 = r3
            goto L_0x0089
        L_0x0068:
            boolean r6 = r12.k()
            if (r6 == 0) goto L_0x0065
            java.util.Comparator<? super T> r6 = r11.s
            java.lang.Object r7 = r11.i()
            java.lang.Object r8 = r12.i()
            int r6 = r6.compare(r7, r8)
            if (r6 > 0) goto L_0x005d
            if (r6 != 0) goto L_0x0065
            com.google.common.collect.BoundType r6 = r12.h()
            com.google.common.collect.BoundType r7 = com.google.common.collect.BoundType.OPEN
            if (r6 != r7) goto L_0x0065
            goto L_0x005d
        L_0x0089:
            if (r5 == 0) goto L_0x00a5
            if (r8 == 0) goto L_0x00a5
            java.util.Comparator<? super T> r12 = r11.s
            int r12 = r12.compare(r1, r9)
            if (r12 > 0) goto L_0x009d
            if (r12 != 0) goto L_0x00a5
            com.google.common.collect.BoundType r12 = com.google.common.collect.BoundType.OPEN
            if (r2 != r12) goto L_0x00a5
            if (r4 != r12) goto L_0x00a5
        L_0x009d:
            com.google.common.collect.BoundType r12 = com.google.common.collect.BoundType.OPEN
            com.google.common.collect.BoundType r0 = com.google.common.collect.BoundType.CLOSED
            r7 = r12
            r10 = r0
            r6 = r9
            goto L_0x00a8
        L_0x00a5:
            r6 = r1
            r7 = r2
            r10 = r4
        L_0x00a8:
            com.google.common.collect.GeneralRange r12 = new com.google.common.collect.GeneralRange
            java.util.Comparator<? super T> r4 = r11.s
            r3 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.GeneralRange.l(com.google.common.collect.GeneralRange):com.google.common.collect.GeneralRange");
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return (k() && q(NullnessCasts.a(i()))) || (j() && p(NullnessCasts.a(g())));
    }

    /* access modifiers changed from: package-private */
    public GeneralRange<T> o() {
        GeneralRange<T> generalRange = this.a3;
        if (generalRange != null) {
            return generalRange;
        }
        GeneralRange generalRange2 = new GeneralRange(Ordering.i(this.s).E(), this.X2, i(), h(), this.X, g(), f());
        generalRange2.a3 = this;
        this.a3 = generalRange2;
        return generalRange2;
    }

    /* access modifiers changed from: package-private */
    public boolean p(@ParametricNullness T t) {
        boolean z = false;
        if (!k()) {
            return false;
        }
        int compare = this.s.compare(t, NullnessCasts.a(i()));
        boolean z2 = compare > 0;
        boolean z3 = compare == 0;
        if (h() == BoundType.OPEN) {
            z = true;
        }
        return (z3 & z) | z2;
    }

    /* access modifiers changed from: package-private */
    public boolean q(@ParametricNullness T t) {
        boolean z = false;
        if (!j()) {
            return false;
        }
        int compare = this.s.compare(t, NullnessCasts.a(g()));
        boolean z2 = compare < 0;
        boolean z3 = compare == 0;
        if (f() == BoundType.OPEN) {
            z = true;
        }
        return (z3 & z) | z2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.s);
        sb.append(":");
        BoundType boundType = this.Z;
        BoundType boundType2 = BoundType.CLOSED;
        sb.append(boundType == boundType2 ? '[' : ASCIIPropertyListParser.f18649g);
        sb.append(this.X ? this.Y : "-∞");
        sb.append(ASCIIPropertyListParser.f18651i);
        sb.append(this.X2 ? this.Y2 : "∞");
        sb.append(this.Z2 == boundType2 ? ']' : ASCIIPropertyListParser.f18650h);
        return sb.toString();
    }
}
