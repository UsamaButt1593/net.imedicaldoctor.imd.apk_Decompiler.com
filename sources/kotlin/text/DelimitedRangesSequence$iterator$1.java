package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011¨\u0006%"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "", "a", "()V", "g", "()Lkotlin/ranges/IntRange;", "", "hasNext", "()Z", "", "s", "I", "f", "()I", "m", "(I)V", "nextState", "X", "c", "j", "currentStartIndex", "Y", "e", "l", "nextSearchIndex", "Z", "Lkotlin/ranges/IntRange;", "d", "k", "(Lkotlin/ranges/IntRange;)V", "nextItem", "X2", "b", "h", "counter", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker {
    private int X;
    private int X2;
    private int Y;
    final /* synthetic */ DelimitedRangesSequence Y2;
    @Nullable
    private IntRange Z;
    private int s = -1;

    DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        this.Y2 = delimitedRangesSequence;
        int I = RangesKt.I(delimitedRangesSequence.f29063b, 0, delimitedRangesSequence.f29062a.length());
        this.X = I;
        this.Y = I;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        if (r0 < r6.Y2.f29064c) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r6 = this;
            int r0 = r6.Y
            r1 = 0
            if (r0 >= 0) goto L_0x000c
            r6.s = r1
            r0 = 0
            r6.Z = r0
            goto L_0x0099
        L_0x000c:
            kotlin.text.DelimitedRangesSequence r0 = r6.Y2
            int r0 = r0.f29064c
            r2 = -1
            r3 = 1
            if (r0 <= 0) goto L_0x0023
            int r0 = r6.X2
            int r0 = r0 + r3
            r6.X2 = r0
            kotlin.text.DelimitedRangesSequence r4 = r6.Y2
            int r4 = r4.f29064c
            if (r0 >= r4) goto L_0x0031
        L_0x0023:
            int r0 = r6.Y
            kotlin.text.DelimitedRangesSequence r4 = r6.Y2
            java.lang.CharSequence r4 = r4.f29062a
            int r4 = r4.length()
            if (r0 <= r4) goto L_0x0047
        L_0x0031:
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r6.X
            kotlin.text.DelimitedRangesSequence r4 = r6.Y2
            java.lang.CharSequence r4 = r4.f29062a
            int r4 = kotlin.text.StringsKt.g3(r4)
            r0.<init>(r1, r4)
        L_0x0042:
            r6.Z = r0
        L_0x0044:
            r6.Y = r2
            goto L_0x0097
        L_0x0047:
            kotlin.text.DelimitedRangesSequence r0 = r6.Y2
            kotlin.jvm.functions.Function2 r0 = r0.f29065d
            kotlin.text.DelimitedRangesSequence r4 = r6.Y2
            java.lang.CharSequence r4 = r4.f29062a
            int r5 = r6.Y
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.d0(r4, r5)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 != 0) goto L_0x0073
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r6.X
            kotlin.text.DelimitedRangesSequence r4 = r6.Y2
            java.lang.CharSequence r4 = r4.f29062a
            int r4 = kotlin.text.StringsKt.g3(r4)
            r0.<init>(r1, r4)
            goto L_0x0042
        L_0x0073:
            java.lang.Object r2 = r0.a()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.b()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r4 = r6.X
            kotlin.ranges.IntRange r4 = kotlin.ranges.RangesKt.W1(r4, r2)
            r6.Z = r4
            int r2 = r2 + r0
            r6.X = r2
            if (r0 != 0) goto L_0x0095
            r1 = 1
        L_0x0095:
            int r2 = r2 + r1
            goto L_0x0044
        L_0x0097:
            r6.s = r3
        L_0x0099:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence$iterator$1.a():void");
    }

    public final int b() {
        return this.X2;
    }

    public final int c() {
        return this.X;
    }

    @Nullable
    public final IntRange d() {
        return this.Z;
    }

    public final int e() {
        return this.Y;
    }

    public final int f() {
        return this.s;
    }

    @NotNull
    /* renamed from: g */
    public IntRange next() {
        if (this.s == -1) {
            a();
        }
        if (this.s != 0) {
            IntRange intRange = this.Z;
            Intrinsics.n(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.Z = null;
            this.s = -1;
            return intRange;
        }
        throw new NoSuchElementException();
    }

    public final void h(int i2) {
        this.X2 = i2;
    }

    public boolean hasNext() {
        if (this.s == -1) {
            a();
        }
        return this.s == 1;
    }

    public final void j(int i2) {
        this.X = i2;
    }

    public final void k(@Nullable IntRange intRange) {
        this.Z = intRange;
    }

    public final void l(int i2) {
        this.Y = i2;
    }

    public final void m(int i2) {
        this.s = i2;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
