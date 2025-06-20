package kotlin.time;

import com.itextpdf.tool.xml.css.CSS;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.TimeSource;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a1\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0007\u0010\b\u001a5\u0010\n\u001a\u00020\u0003*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\n\u0010\u000b\u001a:\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a>\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\f*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a>\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\f*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlin/Function0;", "", "block", "Lkotlin/time/Duration;", "a", "(Lkotlin/jvm/functions/Function0;)J", "Lkotlin/time/TimeSource;", "c", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)J", "Lkotlin/time/TimeSource$Monotonic;", "b", "(Lkotlin/time/TimeSource$Monotonic;Lkotlin/jvm/functions/Function0;)J", "T", "Lkotlin/time/TimedValue;", "d", "(Lkotlin/jvm/functions/Function0;)Lkotlin/time/TimedValue;", "f", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)Lkotlin/time/TimedValue;", "e", "(Lkotlin/time/TimeSource$Monotonic;Lkotlin/jvm/functions/Function0;)Lkotlin/time/TimedValue;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nmeasureTime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 measureTime.kt\nkotlin/time/MeasureTimeKt\n*L\n1#1,121:1\n50#1,7:122\n113#1,7:129\n*S KotlinDebug\n*F\n+ 1 measureTime.kt\nkotlin/time/MeasureTimeKt\n*L\n21#1:122,7\n83#1:129,7\n*E\n"})
public final class MeasureTimeKt {
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long a(@NotNull Function0<Unit> function0) {
        Intrinsics.p(function0, CSS.Value.v0);
        long b2 = TimeSource.Monotonic.f29144b.b();
        function0.o();
        return TimeSource.Monotonic.ValueTimeMark.i(b2);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long b(@NotNull TimeSource.Monotonic monotonic, @NotNull Function0<Unit> function0) {
        Intrinsics.p(monotonic, "<this>");
        Intrinsics.p(function0, CSS.Value.v0);
        long b2 = monotonic.b();
        function0.o();
        return TimeSource.Monotonic.ValueTimeMark.i(b2);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long c(@NotNull TimeSource timeSource, @NotNull Function0<Unit> function0) {
        Intrinsics.p(timeSource, "<this>");
        Intrinsics.p(function0, CSS.Value.v0);
        TimeMark a2 = timeSource.a();
        function0.o();
        return a2.b();
    }

    @SinceKotlin(version = "1.9")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final <T> TimedValue<T> d(@NotNull Function0<? extends T> function0) {
        Intrinsics.p(function0, CSS.Value.v0);
        return new TimedValue<>(function0.o(), TimeSource.Monotonic.ValueTimeMark.i(TimeSource.Monotonic.f29144b.b()), (DefaultConstructorMarker) null);
    }

    @SinceKotlin(version = "1.9")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final <T> TimedValue<T> e(@NotNull TimeSource.Monotonic monotonic, @NotNull Function0<? extends T> function0) {
        Intrinsics.p(monotonic, "<this>");
        Intrinsics.p(function0, CSS.Value.v0);
        return new TimedValue<>(function0.o(), TimeSource.Monotonic.ValueTimeMark.i(monotonic.b()), (DefaultConstructorMarker) null);
    }

    @SinceKotlin(version = "1.9")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final <T> TimedValue<T> f(@NotNull TimeSource timeSource, @NotNull Function0<? extends T> function0) {
        Intrinsics.p(timeSource, "<this>");
        Intrinsics.p(function0, CSS.Value.v0);
        return new TimedValue<>(function0.o(), timeSource.a().b(), (DefaultConstructorMarker) null);
    }
}
