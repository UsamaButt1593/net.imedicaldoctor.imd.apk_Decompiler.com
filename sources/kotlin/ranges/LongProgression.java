package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.LongIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0016\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001b¨\u0006$"}, d2 = {"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "<init>", "(JJJ)V", "Lkotlin/collections/LongIterator;", "n", "()Lkotlin/collections/LongIterator;", "", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "s", "J", "j", "()J", "first", "X", "k", "last", "Y", "m", "Z", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public class LongProgression implements Iterable<Long>, KMappedMarker {
    @NotNull
    public static final Companion Z = new Companion((DefaultConstructorMarker) null);
    private final long X;
    private final long Y;
    private final long s;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/ranges/LongProgression$Companion;", "", "<init>", "()V", "", "rangeStart", "rangeEnd", "step", "Lkotlin/ranges/LongProgression;", "a", "(JJJ)Lkotlin/ranges/LongProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final LongProgression a(long j2, long j3, long j4) {
            return new LongProgression(j2, j3, j4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LongProgression(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (j4 != Long.MIN_VALUE) {
            this.s = j2;
            this.X = ProgressionUtilKt.d(j2, j3, j4);
            this.Y = j4;
        } else {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof LongProgression) {
            if (!isEmpty() || !((LongProgression) obj).isEmpty()) {
                LongProgression longProgression = (LongProgression) obj;
                if (!(this.s == longProgression.s && this.X == longProgression.X && this.Y == longProgression.Y)) {
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
        long j2 = (long) 31;
        long j3 = this.s;
        long j4 = this.X;
        long j5 = j2 * (((j3 ^ (j3 >>> 32)) * j2) + (j4 ^ (j4 >>> 32)));
        long j6 = this.Y;
        return (int) (j5 + (j6 ^ (j6 >>> 32)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0012 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEmpty() {
        /*
            r7 = this;
            long r0 = r7.Y
            r2 = 0
            r4 = 0
            r5 = 1
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            long r0 = r7.s
            long r2 = r7.X
            if (r6 <= 0) goto L_0x0014
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0019
        L_0x0012:
            r4 = 1
            goto L_0x0019
        L_0x0014:
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0019
            goto L_0x0012
        L_0x0019:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.LongProgression.isEmpty():boolean");
    }

    public final long j() {
        return this.s;
    }

    public final long k() {
        return this.X;
    }

    public final long m() {
        return this.Y;
    }

    @NotNull
    /* renamed from: n */
    public LongIterator iterator() {
        return new LongProgressionIterator(this.s, this.X, this.Y);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        long j2;
        if (this.Y > 0) {
            sb.append(this.s);
            sb.append("..");
            sb.append(this.X);
            sb.append(" step ");
            j2 = this.Y;
        } else {
            sb = new StringBuilder();
            sb.append(this.s);
            sb.append(" downTo ");
            sb.append(this.X);
            sb.append(" step ");
            j2 = -this.Y;
        }
        sb.append(j2);
        return sb.toString();
    }
}
