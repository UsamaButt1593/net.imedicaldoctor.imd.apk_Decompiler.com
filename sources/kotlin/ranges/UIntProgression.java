package kotlin.ranges;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0017\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B$\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0014R\u001d\u0010\u001e\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u0014ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006#"}, d2 = {"Lkotlin/ranges/UIntProgression;", "", "Lkotlin/UInt;", "start", "endInclusive", "", "step", "<init>", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "iterator", "()Ljava/util/Iterator;", "", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "s", "I", "j", "first", "X", "k", "last", "Y", "m", "Z", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public class UIntProgression implements Iterable<UInt>, KMappedMarker {
    @NotNull
    public static final Companion Z = new Companion((DefaultConstructorMarker) null);
    private final int X;
    private final int Y;
    private final int s;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lkotlin/ranges/UIntProgression$Companion;", "", "<init>", "()V", "Lkotlin/UInt;", "rangeStart", "rangeEnd", "", "step", "Lkotlin/ranges/UIntProgression;", "a", "(III)Lkotlin/ranges/UIntProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final UIntProgression a(int i2, int i3, int i4) {
            return new UIntProgression(i2, i3, i4, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private UIntProgression(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i4 != Integer.MIN_VALUE) {
            this.s = i2;
            this.X = UProgressionUtilKt.d(i2, i3, i4);
            this.Y = i4;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof UIntProgression) {
            if (!isEmpty() || !((UIntProgression) obj).isEmpty()) {
                UIntProgression uIntProgression = (UIntProgression) obj;
                if (!(this.s == uIntProgression.s && this.X == uIntProgression.X && this.Y == uIntProgression.Y)) {
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

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0010 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEmpty() {
        /*
            r4 = this;
            int r0 = r4.Y
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x0012
            int r0 = r4.s
            int r3 = r4.X
            int r0 = java.lang.Integer.compare(r0 ^ Integer.MIN_VALUE, r3 ^ Integer.MIN_VALUE)
            if (r0 <= 0) goto L_0x001d
        L_0x0010:
            r1 = 1
            goto L_0x001d
        L_0x0012:
            int r0 = r4.s
            int r3 = r4.X
            int r0 = java.lang.Integer.compare(r0 ^ Integer.MIN_VALUE, r3 ^ Integer.MIN_VALUE)
            if (r0 >= 0) goto L_0x001d
            goto L_0x0010
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.UIntProgression.isEmpty():boolean");
    }

    @NotNull
    public final Iterator<UInt> iterator() {
        return new UIntProgressionIterator(this.s, this.X, this.Y, (DefaultConstructorMarker) null);
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
    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.Y > 0) {
            sb = new StringBuilder();
            sb.append(UInt.m0(this.s));
            sb.append("..");
            sb.append(UInt.m0(this.X));
            sb.append(" step ");
            i2 = this.Y;
        } else {
            sb = new StringBuilder();
            sb.append(UInt.m0(this.s));
            sb.append(" downTo ");
            sb.append(UInt.m0(this.X));
            sb.append(" step ");
            i2 = -this.Y;
        }
        sb.append(i2);
        return sb.toString();
    }

    public /* synthetic */ UIntProgression(int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, i4);
    }
}
