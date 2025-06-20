package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.ClassUtils;

@SourceDebugExtension({"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/TestTimeSource\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,199:1\n80#2:200\n80#2:201\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/TestTimeSource\n*L\n173#1:200\n180#1:201\n*E\n"})
@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\bR\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "<init>", "()V", "Lkotlin/time/Duration;", "duration", "", "g", "(J)V", "", "f", "()J", "h", "d", "J", "reading", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalTime.class})
public final class TestTimeSource extends AbstractLongTimeSource {

    /* renamed from: d  reason: collision with root package name */
    private long f29141d;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        a();
    }

    private final void g(long j2) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.f29141d + DurationUnitKt__DurationUnitKt.h(d()) + " is advanced by " + Duration.K0(j2) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    /* access modifiers changed from: protected */
    public long f() {
        return this.f29141d;
    }

    public final void h(long j2) {
        long G0 = Duration.G0(j2, d());
        if (((G0 - 1) | 1) == Long.MAX_VALUE) {
            long m2 = Duration.m(j2, 2);
            if ((1 | (Duration.G0(m2, d()) - 1)) == Long.MAX_VALUE) {
                g(j2);
                return;
            }
            long j3 = this.f29141d;
            try {
                h(m2);
                h(Duration.m0(j2, m2));
            } catch (IllegalStateException e2) {
                this.f29141d = j3;
                throw e2;
            }
        } else {
            long j4 = this.f29141d;
            long j5 = j4 + G0;
            if ((G0 ^ j4) >= 0 && (j4 ^ j5) < 0) {
                g(j2);
            }
            this.f29141d = j5;
        }
    }
}
