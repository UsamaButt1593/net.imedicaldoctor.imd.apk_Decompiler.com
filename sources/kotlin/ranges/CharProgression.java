package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0016\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0014¨\u0006%"}, d2 = {"Lkotlin/ranges/CharProgression;", "", "", "start", "endInclusive", "", "step", "<init>", "(CCI)V", "Lkotlin/collections/CharIterator;", "n", "()Lkotlin/collections/CharIterator;", "", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "s", "C", "j", "()C", "first", "X", "k", "last", "Y", "I", "m", "Z", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public class CharProgression implements Iterable<Character>, KMappedMarker {
    @NotNull
    public static final Companion Z = new Companion((DefaultConstructorMarker) null);
    private final char X;
    private final int Y;
    private final char s;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/ranges/CharProgression$Companion;", "", "<init>", "()V", "", "rangeStart", "rangeEnd", "", "step", "Lkotlin/ranges/CharProgression;", "a", "(CCI)Lkotlin/ranges/CharProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final CharProgression a(char c2, char c3, int i2) {
            return new CharProgression(c2, c3, i2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CharProgression(char c2, char c3, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i2 != Integer.MIN_VALUE) {
            this.s = c2;
            this.X = (char) ProgressionUtilKt.c(c2, c3, i2);
            this.Y = i2;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof CharProgression) {
            if (!isEmpty() || !((CharProgression) obj).isEmpty()) {
                CharProgression charProgression = (CharProgression) obj;
                if (!(this.s == charProgression.s && this.X == charProgression.X && this.Y == charProgression.Y)) {
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
            char r0 = r4.s
            char r3 = r4.X
            int r0 = kotlin.jvm.internal.Intrinsics.t(r0, r3)
            if (r0 <= 0) goto L_0x001d
        L_0x0010:
            r1 = 1
            goto L_0x001d
        L_0x0012:
            char r0 = r4.s
            char r3 = r4.X
            int r0 = kotlin.jvm.internal.Intrinsics.t(r0, r3)
            if (r0 >= 0) goto L_0x001d
            goto L_0x0010
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.CharProgression.isEmpty():boolean");
    }

    public final char j() {
        return this.s;
    }

    public final char k() {
        return this.X;
    }

    public final int m() {
        return this.Y;
    }

    @NotNull
    /* renamed from: n */
    public CharIterator iterator() {
        return new CharProgressionIterator(this.s, this.X, this.Y);
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
