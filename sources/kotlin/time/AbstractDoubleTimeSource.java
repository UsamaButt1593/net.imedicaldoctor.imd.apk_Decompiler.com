package kotlin.time;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import kotlin.time.TimeSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H$¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/DurationUnit;", "unit", "<init>", "(Lkotlin/time/DurationUnit;)V", "", "c", "()D", "Lkotlin/time/ComparableTimeMark;", "a", "()Lkotlin/time/ComparableTimeMark;", "b", "Lkotlin/time/DurationUnit;", "()Lkotlin/time/DurationUnit;", "DoubleTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@Deprecated(message = "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.")
@ExperimentalTime
public abstract class AbstractDoubleTimeSource implements TimeSource.WithComparableMarks {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final DurationUnit f29128b;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u00068\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b \u0010!\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\""}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/ComparableTimeMark;", "", "startedAt", "Lkotlin/time/AbstractDoubleTimeSource;", "timeSource", "Lkotlin/time/Duration;", "offset", "<init>", "(DLkotlin/time/AbstractDoubleTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "b", "()J", "duration", "B", "(J)Lkotlin/time/ComparableTimeMark;", "other", "w0", "(Lkotlin/time/ComparableTimeMark;)J", "", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "s", "D", "X", "Lkotlin/time/AbstractDoubleTimeSource;", "Y", "J", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    private static final class DoubleTimeMark implements ComparableTimeMark {
        @NotNull
        private final AbstractDoubleTimeSource X;
        private final long Y;
        private final double s;

        private DoubleTimeMark(double d2, AbstractDoubleTimeSource abstractDoubleTimeSource, long j2) {
            Intrinsics.p(abstractDoubleTimeSource, "timeSource");
            this.s = d2;
            this.X = abstractDoubleTimeSource;
            this.Y = j2;
        }

        @NotNull
        public ComparableTimeMark B(long j2) {
            return new DoubleTimeMark(this.s, this.X, Duration.p0(this.Y, j2), (DefaultConstructorMarker) null);
        }

        /* renamed from: H1 */
        public int compareTo(@NotNull ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.a(this, comparableTimeMark);
        }

        public boolean a() {
            return ComparableTimeMark.DefaultImpls.c(this);
        }

        public long b() {
            return Duration.m0(DurationKt.l0(this.X.c() - this.s, this.X.b()), this.Y);
        }

        public boolean c() {
            return ComparableTimeMark.DefaultImpls.b(this);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof DoubleTimeMark) && Intrinsics.g(this.X, ((DoubleTimeMark) obj).X) && Duration.o(w0((ComparableTimeMark) obj), Duration.X.W());
        }

        public int hashCode() {
            return Duration.d0(Duration.p0(DurationKt.l0(this.s, this.X.b()), this.Y));
        }

        @NotNull
        public ComparableTimeMark t(long j2) {
            return ComparableTimeMark.DefaultImpls.d(this, j2);
        }

        @NotNull
        public String toString() {
            return "DoubleTimeMark(" + this.s + DurationUnitKt__DurationUnitKt.h(this.X.b()) + " + " + Duration.K0(this.Y) + ", " + this.X + ASCIIPropertyListParser.f18650h;
        }

        public long w0(@NotNull ComparableTimeMark comparableTimeMark) {
            Intrinsics.p(comparableTimeMark, "other");
            if (comparableTimeMark instanceof DoubleTimeMark) {
                DoubleTimeMark doubleTimeMark = (DoubleTimeMark) comparableTimeMark;
                if (Intrinsics.g(this.X, doubleTimeMark.X)) {
                    if (Duration.o(this.Y, doubleTimeMark.Y) && Duration.i0(this.Y)) {
                        return Duration.X.W();
                    }
                    long m0 = Duration.m0(this.Y, doubleTimeMark.Y);
                    long l0 = DurationKt.l0(this.s - doubleTimeMark.s, this.X.b());
                    return Duration.o(l0, Duration.Q0(m0)) ? Duration.X.W() : Duration.p0(l0, m0);
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + comparableTimeMark);
        }

        public /* synthetic */ DoubleTimeMark(double d2, AbstractDoubleTimeSource abstractDoubleTimeSource, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(d2, abstractDoubleTimeSource, j2);
        }
    }

    public AbstractDoubleTimeSource(@NotNull DurationUnit durationUnit) {
        Intrinsics.p(durationUnit, "unit");
        this.f29128b = durationUnit;
    }

    @NotNull
    public ComparableTimeMark a() {
        return new DoubleTimeMark(c(), this, Duration.X.W(), (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final DurationUnit b() {
        return this.f29128b;
    }

    /* access modifiers changed from: protected */
    public abstract double c();
}
