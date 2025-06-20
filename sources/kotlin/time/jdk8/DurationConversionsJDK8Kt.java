package kotlin.time.jdk8;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.ExperimentalTime;

@SourceDebugExtension({"SMAP\nDurationConversions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n+ 2 Duration.kt\nkotlin/time/Duration\n*L\n1#1,33:1\n731#2,2:34\n*S KotlinDebug\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n*L\n33#1:34,2\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"Ljava/time/Duration;", "Lkotlin/time/Duration;", "b", "(Ljava/time/Duration;)J", "a", "(J)Ljava/time/Duration;", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "DurationConversionsJDK8Kt")
public final class DurationConversionsJDK8Kt {
    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalTime.class})
    private static final Duration a(long j2) {
        Duration a2 = Duration.ofSeconds(kotlin.time.Duration.P(j2), (long) kotlin.time.Duration.T(j2));
        Intrinsics.o(a2, "toJavaDuration-LRDsOJo");
        return a2;
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalTime.class})
    private static final long b(Duration duration) {
        Intrinsics.p(duration, "<this>");
        return kotlin.time.Duration.p0(DurationKt.n0(duration.getSeconds(), DurationUnit.SECONDS), DurationKt.m0(duration.getNano(), DurationUnit.NANOSECONDS));
    }
}
