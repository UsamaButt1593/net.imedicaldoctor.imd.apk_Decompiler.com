package kotlin.time;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.firebase.sessions.j;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.time.ComparableTimeMark;
import kotlin.time.TimeSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H$¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/DurationUnit;", "unit", "<init>", "(Lkotlin/time/DurationUnit;)V", "", "c", "()J", "f", "Lkotlin/time/ComparableTimeMark;", "a", "()Lkotlin/time/ComparableTimeMark;", "b", "Lkotlin/time/DurationUnit;", "d", "()Lkotlin/time/DurationUnit;", "Lkotlin/Lazy;", "e", "zero", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalTime.class})
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final DurationUnit f29129b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f29130c = LazyKt.c(new AbstractLongTimeSource$zero$2(this));

    @SourceDebugExtension({"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,199:1\n80#2:200\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/AbstractLongTimeSource$LongTimeMark\n*L\n67#1:200\n*E\n"})
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u00068\u0002X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b \u0010\u001d\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006!"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "", "startedAt", "Lkotlin/time/AbstractLongTimeSource;", "timeSource", "Lkotlin/time/Duration;", "offset", "<init>", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "b", "()J", "duration", "B", "(J)Lkotlin/time/ComparableTimeMark;", "other", "w0", "(Lkotlin/time/ComparableTimeMark;)J", "", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "s", "J", "X", "Lkotlin/time/AbstractLongTimeSource;", "Y", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    private static final class LongTimeMark implements ComparableTimeMark {
        @NotNull
        private final AbstractLongTimeSource X;
        private final long Y;
        private final long s;

        private LongTimeMark(long j2, AbstractLongTimeSource abstractLongTimeSource, long j3) {
            Intrinsics.p(abstractLongTimeSource, "timeSource");
            this.s = j2;
            this.X = abstractLongTimeSource;
            this.Y = j3;
        }

        @NotNull
        public ComparableTimeMark B(long j2) {
            DurationUnit d2 = this.X.d();
            if (Duration.i0(j2)) {
                return new LongTimeMark(LongSaturatedMathKt.d(this.s, d2, j2), this.X, Duration.X.W(), (DefaultConstructorMarker) null);
            }
            long P0 = Duration.P0(j2, d2);
            long p0 = Duration.p0(Duration.m0(j2, P0), this.Y);
            long d3 = LongSaturatedMathKt.d(this.s, d2, P0);
            long P02 = Duration.P0(p0, d2);
            long d4 = LongSaturatedMathKt.d(d3, d2, P02);
            long m0 = Duration.m0(p0, P02);
            long O = Duration.O(m0);
            if (!(d4 == 0 || O == 0 || (d4 ^ O) >= 0)) {
                long m02 = DurationKt.m0(MathKt.V(O), d2);
                d4 = LongSaturatedMathKt.d(d4, d2, m02);
                m0 = Duration.m0(m0, m02);
            }
            if ((1 | (d4 - 1)) == Long.MAX_VALUE) {
                m0 = Duration.X.W();
            }
            return new LongTimeMark(d4, this.X, m0, (DefaultConstructorMarker) null);
        }

        /* renamed from: H1 */
        public int compareTo(@NotNull ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.a(this, comparableTimeMark);
        }

        public boolean a() {
            return ComparableTimeMark.DefaultImpls.c(this);
        }

        public long b() {
            return Duration.m0(LongSaturatedMathKt.h(this.X.c(), this.s, this.X.d()), this.Y);
        }

        public boolean c() {
            return ComparableTimeMark.DefaultImpls.b(this);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof LongTimeMark) && Intrinsics.g(this.X, ((LongTimeMark) obj).X) && Duration.o(w0((ComparableTimeMark) obj), Duration.X.W());
        }

        public int hashCode() {
            return (Duration.d0(this.Y) * 37) + j.a(this.s);
        }

        @NotNull
        public ComparableTimeMark t(long j2) {
            return ComparableTimeMark.DefaultImpls.d(this, j2);
        }

        @NotNull
        public String toString() {
            return "LongTimeMark(" + this.s + DurationUnitKt__DurationUnitKt.h(this.X.d()) + " + " + Duration.K0(this.Y) + ", " + this.X + ASCIIPropertyListParser.f18650h;
        }

        public long w0(@NotNull ComparableTimeMark comparableTimeMark) {
            Intrinsics.p(comparableTimeMark, "other");
            if (comparableTimeMark instanceof LongTimeMark) {
                LongTimeMark longTimeMark = (LongTimeMark) comparableTimeMark;
                if (Intrinsics.g(this.X, longTimeMark.X)) {
                    return Duration.p0(LongSaturatedMathKt.h(this.s, longTimeMark.s, this.X.d()), Duration.m0(this.Y, longTimeMark.Y));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + comparableTimeMark);
        }

        public /* synthetic */ LongTimeMark(long j2, AbstractLongTimeSource abstractLongTimeSource, long j3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j2, abstractLongTimeSource, j3);
        }
    }

    public AbstractLongTimeSource(@NotNull DurationUnit durationUnit) {
        Intrinsics.p(durationUnit, "unit");
        this.f29129b = durationUnit;
    }

    /* access modifiers changed from: private */
    public final long c() {
        return f() - e();
    }

    private final long e() {
        return ((Number) this.f29130c.getValue()).longValue();
    }

    @NotNull
    public ComparableTimeMark a() {
        return new LongTimeMark(c(), this, Duration.X.W(), (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final DurationUnit d() {
        return this.f29129b;
    }

    /* access modifiers changed from: protected */
    public abstract long f();
}
