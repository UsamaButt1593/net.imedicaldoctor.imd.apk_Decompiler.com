package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001 B\u001a\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u001c\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0015ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006!"}, d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "<init>", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "value", "", "o", "(I)Z", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "q", "r", "()V", "endExclusive", "z", "t", "X2", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class UIntRange extends UIntProgression implements ClosedRange<UInt>, OpenEndRange<UInt> {
    @NotNull
    public static final Companion X2 = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final UIntRange Y2 = new UIntRange(-1, 0, (DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/ranges/UIntRange$Companion;", "", "<init>", "()V", "Lkotlin/ranges/UIntRange;", "EMPTY", "Lkotlin/ranges/UIntRange;", "a", "()Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final UIntRange a() {
            return UIntRange.Y2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private UIntRange(int i2, int i3) {
        super(i2, i3, 1, (DefaultConstructorMarker) null);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* synthetic */ void r() {
    }

    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return o(((UInt) comparable).v0());
    }

    public /* bridge */ /* synthetic */ Comparable c() {
        return UInt.b(z());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof UIntRange) {
            if (!isEmpty() || !((UIntRange) obj).isEmpty()) {
                UIntRange uIntRange = (UIntRange) obj;
                if (!(j() == uIntRange.j() && k() == uIntRange.k())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public /* bridge */ /* synthetic */ Comparable g() {
        return UInt.b(q());
    }

    public /* bridge */ /* synthetic */ Comparable h() {
        return UInt.b(t());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (j() * 31) + k();
    }

    public boolean isEmpty() {
        return Integer.compare(j() ^ Integer.MIN_VALUE, k() ^ Integer.MIN_VALUE) > 0;
    }

    public boolean o(int i2) {
        return Integer.compare(j() ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) <= 0 && Integer.compare(i2 ^ Integer.MIN_VALUE, k() ^ Integer.MIN_VALUE) <= 0;
    }

    public int q() {
        if (k() != -1) {
            return UInt.i(k() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    public int t() {
        return k();
    }

    @NotNull
    public String toString() {
        return UInt.m0(j()) + ".." + UInt.m0(k());
    }

    public int z() {
        return j();
    }

    public /* synthetic */ UIntRange(int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3);
    }
}
