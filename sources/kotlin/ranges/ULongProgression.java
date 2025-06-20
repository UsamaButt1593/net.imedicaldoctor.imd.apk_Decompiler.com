package kotlin.ranges;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0017\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B$\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001d\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006%"}, d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "", "step", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "iterator", "()Ljava/util/Iterator;", "", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "s", "J", "j", "()J", "first", "X", "k", "last", "Y", "m", "Z", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public class ULongProgression implements Iterable<ULong>, KMappedMarker {
    @NotNull
    public static final Companion Z = new Companion((DefaultConstructorMarker) null);
    private final long X;
    private final long Y;
    private final long s;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lkotlin/ranges/ULongProgression$Companion;", "", "<init>", "()V", "Lkotlin/ULong;", "rangeStart", "rangeEnd", "", "step", "Lkotlin/ranges/ULongProgression;", "a", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ULongProgression a(long j2, long j3, long j4) {
            return new ULongProgression(j2, j3, j4, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private ULongProgression(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (j4 != Long.MIN_VALUE) {
            this.s = j2;
            this.X = UProgressionUtilKt.c(j2, j3, j4);
            this.Y = j4;
        } else {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ULongProgression) {
            if (!isEmpty() || !((ULongProgression) obj).isEmpty()) {
                ULongProgression uLongProgression = (ULongProgression) obj;
                if (!(this.s == uLongProgression.s && this.X == uLongProgression.X && this.Y == uLongProgression.Y)) {
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
        long j2 = this.s;
        long j3 = this.X;
        long j4 = this.Y;
        return ((int) (j4 ^ (j4 >>> 32))) + (((((int) ULong.i(j2 ^ ULong.i(j2 >>> 32))) * 31) + ((int) ULong.i(j3 ^ ULong.i(j3 >>> 32)))) * 31);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0014 A[RETURN, SYNTHETIC] */
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
            int r0 = java.lang.Long.compare(r0 ^ Long.MIN_VALUE, r2 ^ Long.MIN_VALUE)
            if (r6 <= 0) goto L_0x0016
            if (r0 <= 0) goto L_0x0019
        L_0x0014:
            r4 = 1
            goto L_0x0019
        L_0x0016:
            if (r0 >= 0) goto L_0x0019
            goto L_0x0014
        L_0x0019:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.ULongProgression.isEmpty():boolean");
    }

    @NotNull
    public final Iterator<ULong> iterator() {
        return new ULongProgressionIterator(this.s, this.X, this.Y, (DefaultConstructorMarker) null);
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
    public String toString() {
        StringBuilder sb;
        long j2;
        if (this.Y > 0) {
            sb.append(ULong.m0(this.s));
            sb.append("..");
            sb.append(ULong.m0(this.X));
            sb.append(" step ");
            j2 = this.Y;
        } else {
            sb = new StringBuilder();
            sb.append(ULong.m0(this.s));
            sb.append(" downTo ");
            sb.append(ULong.m0(this.X));
            sb.append(" step ");
            j2 = -this.Y;
        }
        sb.append(j2);
        return sb.toString();
    }

    public /* synthetic */ ULongProgression(long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, j3, j4);
    }
}
