package okio;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"okio/Pipe$source$1", "Lokio/Source;", "Lokio/Buffer;", "sink", "", "byteCount", "n2", "(Lokio/Buffer;J)J", "", "close", "()V", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "s", "Lokio/Timeout;", "timeout", "okio"}, k = 1, mv = {1, 5, 1})
public final class Pipe$source$1 implements Source {
    final /* synthetic */ Pipe X;
    @NotNull
    private final Timeout s = new Timeout();

    Pipe$source$1(Pipe pipe) {
        this.X = pipe;
    }

    public void close() {
        Buffer f2 = this.X.f();
        Pipe pipe = this.X;
        synchronized (f2) {
            pipe.o(true);
            pipe.f().notifyAll();
            Unit unit = Unit.f28779a;
        }
    }

    @NotNull
    public Timeout j() {
        return this.s;
    }

    public long n2(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "sink");
        Buffer f2 = this.X.f();
        Pipe pipe = this.X;
        synchronized (f2) {
            try {
                if (!(!pipe.k())) {
                    throw new IllegalStateException("closed".toString());
                } else if (!pipe.g()) {
                    while (pipe.f().L0() == 0) {
                        if (pipe.j()) {
                            return -1;
                        }
                        this.s.k(pipe.f());
                        if (pipe.g()) {
                            throw new IOException("canceled");
                        }
                    }
                    long n2 = pipe.f().n2(buffer, j2);
                    pipe.f().notifyAll();
                    return n2;
                } else {
                    throw new IOException("canceled");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
