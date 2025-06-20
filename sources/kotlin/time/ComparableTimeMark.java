package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeMark;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002J\u001b\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H¦\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006J\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0000H¦\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u000eH¦\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH&¢\u0006\u0004\b\u0012\u0010\u0013\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0014"}, d2 = {"Lkotlin/time/ComparableTimeMark;", "Lkotlin/time/TimeMark;", "", "Lkotlin/time/Duration;", "duration", "B", "(J)Lkotlin/time/ComparableTimeMark;", "t", "other", "w0", "(Lkotlin/time/ComparableTimeMark;)J", "", "H1", "(Lkotlin/time/ComparableTimeMark;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalTime.class})
public interface ComparableTimeMark extends TimeMark, Comparable<ComparableTimeMark> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int a(@NotNull ComparableTimeMark comparableTimeMark, @NotNull ComparableTimeMark comparableTimeMark2) {
            Intrinsics.p(comparableTimeMark2, "other");
            return Duration.i(comparableTimeMark.w0(comparableTimeMark2), Duration.X.W());
        }

        public static boolean b(@NotNull ComparableTimeMark comparableTimeMark) {
            return TimeMark.DefaultImpls.a(comparableTimeMark);
        }

        public static boolean c(@NotNull ComparableTimeMark comparableTimeMark) {
            return TimeMark.DefaultImpls.b(comparableTimeMark);
        }

        @NotNull
        public static ComparableTimeMark d(@NotNull ComparableTimeMark comparableTimeMark, long j2) {
            return comparableTimeMark.B(Duration.Q0(j2));
        }
    }

    @NotNull
    ComparableTimeMark B(long j2);

    int H1(@NotNull ComparableTimeMark comparableTimeMark);

    boolean equals(@Nullable Object obj);

    int hashCode();

    @NotNull
    ComparableTimeMark t(long j2);

    long w0(@NotNull ComparableTimeMark comparableTimeMark);
}
