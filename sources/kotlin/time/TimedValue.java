package kotlin.time;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.9")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001a\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u0004HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lkotlin/time/TimedValue;", "T", "", "value", "Lkotlin/time/Duration;", "duration", "<init>", "(Ljava/lang/Object;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "a", "()Ljava/lang/Object;", "b", "()J", "c", "(Ljava/lang/Object;J)Lkotlin/time/TimedValue;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "f", "J", "e", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalTime.class})
public final class TimedValue<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f29145a;

    /* renamed from: b  reason: collision with root package name */
    private final long f29146b;

    private TimedValue(T t, long j2) {
        this.f29145a = t;
        this.f29146b = j2;
    }

    public static /* synthetic */ TimedValue d(TimedValue timedValue, T t, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            t = timedValue.f29145a;
        }
        if ((i2 & 2) != 0) {
            j2 = timedValue.f29146b;
        }
        return timedValue.c(t, j2);
    }

    public final T a() {
        return this.f29145a;
    }

    public final long b() {
        return this.f29146b;
    }

    @NotNull
    public final TimedValue<T> c(T t, long j2) {
        return new TimedValue<>(t, j2, (DefaultConstructorMarker) null);
    }

    public final long e() {
        return this.f29146b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimedValue)) {
            return false;
        }
        TimedValue timedValue = (TimedValue) obj;
        return Intrinsics.g(this.f29145a, timedValue.f29145a) && Duration.o(this.f29146b, timedValue.f29146b);
    }

    public final T f() {
        return this.f29145a;
    }

    public int hashCode() {
        T t = this.f29145a;
        return ((t == null ? 0 : t.hashCode()) * 31) + Duration.d0(this.f29146b);
    }

    @NotNull
    public String toString() {
        return "TimedValue(value=" + this.f29145a + ", duration=" + Duration.K0(this.f29146b) + ASCIIPropertyListParser.f18650h;
    }

    public /* synthetic */ TimedValue(Object obj, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, j2);
    }
}
