package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0002\u001a\u00020\u00018\u0007@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0004¨\u0006\u001f"}, d2 = {"Lokio/ForwardingTimeout;", "Lokio/Timeout;", "delegate", "<init>", "(Lokio/Timeout;)V", "m", "(Lokio/Timeout;)Lokio/ForwardingTimeout;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "i", "(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;", "j", "()J", "", "f", "()Z", "d", "deadlineNanoTime", "e", "(J)Lokio/Timeout;", "b", "()Lokio/Timeout;", "a", "", "h", "()V", "Lokio/Timeout;", "l", "n", "okio"}, k = 1, mv = {1, 5, 1})
public class ForwardingTimeout extends Timeout {
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private Timeout f31369f;

    public ForwardingTimeout(@NotNull Timeout timeout) {
        Intrinsics.p(timeout, "delegate");
        this.f31369f = timeout;
    }

    @NotNull
    public Timeout a() {
        return this.f31369f.a();
    }

    @NotNull
    public Timeout b() {
        return this.f31369f.b();
    }

    public long d() {
        return this.f31369f.d();
    }

    @NotNull
    public Timeout e(long j2) {
        return this.f31369f.e(j2);
    }

    public boolean f() {
        return this.f31369f.f();
    }

    public void h() throws IOException {
        this.f31369f.h();
    }

    @NotNull
    public Timeout i(long j2, @NotNull TimeUnit timeUnit) {
        Intrinsics.p(timeUnit, "unit");
        return this.f31369f.i(j2, timeUnit);
    }

    public long j() {
        return this.f31369f.j();
    }

    @NotNull
    @JvmName(name = "delegate")
    public final Timeout l() {
        return this.f31369f;
    }

    @NotNull
    public final ForwardingTimeout m(@NotNull Timeout timeout) {
        Intrinsics.p(timeout, "delegate");
        this.f31369f = timeout;
        return this;
    }

    public final /* synthetic */ void n(Timeout timeout) {
        Intrinsics.p(timeout, "<set-?>");
        this.f31369f = timeout;
    }
}
