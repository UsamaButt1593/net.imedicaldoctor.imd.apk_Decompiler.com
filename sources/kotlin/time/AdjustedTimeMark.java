package kotlin.time;

import com.itextpdf.tool.xml.html.HTML;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeMark;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B\u001a\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\u00020\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\b\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "mark", "Lkotlin/time/Duration;", "adjustment", "<init>", "(Lkotlin/time/TimeMark;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "b", "()J", "duration", "B", "(J)Lkotlin/time/TimeMark;", "s", "Lkotlin/time/TimeMark;", "e", "()Lkotlin/time/TimeMark;", "X", "J", "d", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class AdjustedTimeMark implements TimeMark {
    private final long X;
    @NotNull
    private final TimeMark s;

    private AdjustedTimeMark(TimeMark timeMark, long j2) {
        Intrinsics.p(timeMark, HTML.Tag.A0);
        this.s = timeMark;
        this.X = j2;
    }

    @NotNull
    public TimeMark B(long j2) {
        return new AdjustedTimeMark(this.s, Duration.p0(this.X, j2), (DefaultConstructorMarker) null);
    }

    public boolean a() {
        return TimeMark.DefaultImpls.b(this);
    }

    public long b() {
        return Duration.m0(this.s.b(), this.X);
    }

    public boolean c() {
        return TimeMark.DefaultImpls.a(this);
    }

    public final long d() {
        return this.X;
    }

    @NotNull
    public final TimeMark e() {
        return this.s;
    }

    @NotNull
    public TimeMark t(long j2) {
        return TimeMark.DefaultImpls.c(this, j2);
    }

    public /* synthetic */ AdjustedTimeMark(TimeMark timeMark, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(timeMark, j2);
    }
}
