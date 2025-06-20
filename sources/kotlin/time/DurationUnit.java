package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.6")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lkotlin/time/DurationUnit;", "", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "<init>", "(Ljava/lang/String;ILjava/util/concurrent/TimeUnit;)V", "s", "Ljava/util/concurrent/TimeUnit;", "c", "()Ljava/util/concurrent/TimeUnit;", "X", "Y", "Z", "X2", "Y2", "Z2", "a3", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalTime.class})
public enum DurationUnit {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);
    
    @NotNull
    private final TimeUnit s;

    static {
        DurationUnit[] a2;
        c3 = EnumEntriesKt.b(a2);
    }

    private DurationUnit(TimeUnit timeUnit) {
        this.s = timeUnit;
    }

    @NotNull
    public static EnumEntries<DurationUnit> b() {
        return c3;
    }

    @NotNull
    public final TimeUnit c() {
        return this.s;
    }
}
