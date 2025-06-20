package kotlin.time;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.firebase.sessions.j;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u00032\u00020\u0001:\u0003\u0005\u0006\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lkotlin/time/TimeSource;", "", "Lkotlin/time/TimeMark;", "a", "()Lkotlin/time/TimeMark;", "Companion", "Monotonic", "WithComparableMarks", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalTime.class})
public interface TimeSource {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f29142a = Companion.f29143a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/time/TimeSource$Companion;", "", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f29143a = new Companion();

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "b", "()J", "", "toString", "()Ljava/lang/String;", "ValueTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Monotonic implements WithComparableMarks {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final Monotonic f29144b = new Monotonic();

        @JvmInline
        @SinceKotlin(version = "1.9")
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\b@\u0018\u00002\u00020\u0001B\u0018\b\u0000\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u0007H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000bJ\u001b\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0000X\u0004¢\u0006\u0006\n\u0004\b \u0010!\u0001\u0004\u0001\u00060\u0002j\u0002`\u0003ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\""}, d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/ComparableTimeMark;", "", "Lkotlin/time/ValueTimeMarkReading;", "reading", "h", "(J)J", "Lkotlin/time/Duration;", "i", "duration", "u", "(JJ)J", "q", "", "m", "(J)Z", "l", "other", "r", "(JLkotlin/time/ComparableTimeMark;)J", "o", "", "f", "(JJ)I", "", "v", "(J)Ljava/lang/String;", "n", "(J)I", "", "j", "(JLjava/lang/Object;)Z", "s", "J", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
        @WasExperimental(markerClass = {ExperimentalTime.class})
        public static final class ValueTimeMark implements ComparableTimeMark {
            private final long s;

            private /* synthetic */ ValueTimeMark(long j2) {
                this.s = j2;
            }

            public static final /* synthetic */ ValueTimeMark e(long j2) {
                return new ValueTimeMark(j2);
            }

            public static final int f(long j2, long j3) {
                return Duration.i(o(j2, j3), Duration.X.W());
            }

            public static int g(long j2, @NotNull ComparableTimeMark comparableTimeMark) {
                Intrinsics.p(comparableTimeMark, "other");
                return e(j2).compareTo(comparableTimeMark);
            }

            public static long h(long j2) {
                return j2;
            }

            public static long i(long j2) {
                return MonotonicTimeSource.f29139b.d(j2);
            }

            public static boolean j(long j2, Object obj) {
                return (obj instanceof ValueTimeMark) && j2 == ((ValueTimeMark) obj).w();
            }

            public static final boolean k(long j2, long j3) {
                return j2 == j3;
            }

            public static boolean l(long j2) {
                return Duration.j0(i(j2));
            }

            public static boolean m(long j2) {
                return !Duration.j0(i(j2));
            }

            public static int n(long j2) {
                return j.a(j2);
            }

            public static final long o(long j2, long j3) {
                return MonotonicTimeSource.f29139b.c(j2, j3);
            }

            public static long q(long j2, long j3) {
                return MonotonicTimeSource.f29139b.b(j2, Duration.Q0(j3));
            }

            public static long r(long j2, @NotNull ComparableTimeMark comparableTimeMark) {
                Intrinsics.p(comparableTimeMark, "other");
                if (comparableTimeMark instanceof ValueTimeMark) {
                    return o(j2, ((ValueTimeMark) comparableTimeMark).w());
                }
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + v(j2) + " and " + comparableTimeMark);
            }

            public static long u(long j2, long j3) {
                return MonotonicTimeSource.f29139b.b(j2, j3);
            }

            public static String v(long j2) {
                return "ValueTimeMark(reading=" + j2 + ASCIIPropertyListParser.f18650h;
            }

            /* renamed from: H1 */
            public int compareTo(@NotNull ComparableTimeMark comparableTimeMark) {
                return ComparableTimeMark.DefaultImpls.a(this, comparableTimeMark);
            }

            public boolean a() {
                return m(this.s);
            }

            public long b() {
                return i(this.s);
            }

            public boolean c() {
                return l(this.s);
            }

            public boolean equals(Object obj) {
                return j(this.s, obj);
            }

            public int hashCode() {
                return n(this.s);
            }

            public long p(long j2) {
                return q(this.s, j2);
            }

            public long s(long j2) {
                return u(this.s, j2);
            }

            public String toString() {
                return v(this.s);
            }

            public final /* synthetic */ long w() {
                return this.s;
            }

            public long w0(@NotNull ComparableTimeMark comparableTimeMark) {
                Intrinsics.p(comparableTimeMark, "other");
                return r(this.s, comparableTimeMark);
            }
        }

        private Monotonic() {
        }

        public long b() {
            return MonotonicTimeSource.f29139b.e();
        }

        @NotNull
        public String toString() {
            return MonotonicTimeSource.f29139b.toString();
        }
    }

    @SinceKotlin(version = "1.9")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource;", "Lkotlin/time/ComparableTimeMark;", "a", "()Lkotlin/time/ComparableTimeMark;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public interface WithComparableMarks extends TimeSource {
        @NotNull
        ComparableTimeMark a();
    }

    @NotNull
    TimeMark a();
}
