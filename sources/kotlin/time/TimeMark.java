package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0003\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002H\u0002ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002H\u0002ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000b\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlin/time/TimeMark;", "", "Lkotlin/time/Duration;", "b", "()J", "duration", "B", "(J)Lkotlin/time/TimeMark;", "t", "", "a", "()Z", "c", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalTime.class})
public interface TimeMark {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean a(@NotNull TimeMark timeMark) {
            return Duration.j0(timeMark.b());
        }

        public static boolean b(@NotNull TimeMark timeMark) {
            return !Duration.j0(timeMark.b());
        }

        @NotNull
        public static TimeMark c(@NotNull TimeMark timeMark, long j2) {
            return timeMark.B(Duration.Q0(j2));
        }

        @NotNull
        public static TimeMark d(@NotNull TimeMark timeMark, long j2) {
            return new AdjustedTimeMark(timeMark, j2, (DefaultConstructorMarker) null);
        }
    }

    @NotNull
    TimeMark B(long j2);

    boolean a();

    long b();

    boolean c();

    @NotNull
    TimeMark t(long j2);
}
