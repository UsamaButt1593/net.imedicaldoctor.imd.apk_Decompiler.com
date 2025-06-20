package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u0013¨\u0006\""}, d2 = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "<init>", "(III)V", "Lkotlin/collections/IntIterator;", "n", "()Lkotlin/collections/IntIterator;", "", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "s", "I", "j", "first", "X", "k", "last", "Y", "m", "Z", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public class IntProgression implements Iterable<Integer>, KMappedMarker {
    @NotNull
    public static final Companion Z = new Companion((DefaultConstructorMarker) null);
    private final int X;
    private final int Y;
    private final int s;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/ranges/IntProgression$Companion;", "", "<init>", "()V", "", "rangeStart", "rangeEnd", "step", "Lkotlin/ranges/IntProgression;", "a", "(III)Lkotlin/ranges/IntProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final IntProgression a(int i2, int i3, int i4) {
            return new IntProgression(i2, i3, i4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public IntProgression(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i4 != Integer.MIN_VALUE) {
            this.s = i2;
            this.X = ProgressionUtilKt.c(i2, i3, i4);
            this.Y = i4;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof IntProgression) {
            if (!isEmpty() || !((IntProgression) obj).isEmpty()) {
                IntProgression intProgression = (IntProgression) obj;
                if (!(this.s == intProgression.s && this.X == intProgression.X && this.Y == intProgression.Y)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.s * 31) + this.X) * 31) + this.Y;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000c A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEmpty() {
        /*
            r4 = this;
            int r0 = r4.Y
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x000e
            int r0 = r4.s
            int r3 = r4.X
            if (r0 <= r3) goto L_0x0015
        L_0x000c:
            r1 = 1
            goto L_0x0015
        L_0x000e:
            int r0 = r4.s
            int r3 = r4.X
            if (r0 >= r3) goto L_0x0015
            goto L_0x000c
        L_0x0015:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.IntProgression.isEmpty():boolean");
    }

    public final int j() {
        return this.s;
    }

    public final int k() {
        return this.X;
    }

    public final int m() {
        return this.Y;
    }

    @NotNull
    /* renamed from: n */
    public IntIterator iterator() {
        return new IntProgressionIterator(this.s, this.X, this.Y);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.Y > 0) {
            sb = new StringBuilder();
            sb.append(this.s);
            sb.append("..");
            sb.append(this.X);
            sb.append(" step ");
            i2 = this.Y;
        } else {
            sb = new StringBuilder();
            sb.append(this.s);
            sb.append(" downTo ");
            sb.append(this.X);
            sb.append(" step ");
            i2 = -this.Y;
        }
        sb.append(i2);
        return sb.toString();
    }
}
