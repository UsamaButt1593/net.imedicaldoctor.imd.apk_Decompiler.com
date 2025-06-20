package okio;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"Lokio/ForwardingSink;", "Lokio/Sink;", "delegate", "<init>", "(Lokio/Sink;)V", "Lokio/Buffer;", "source", "", "byteCount", "", "u1", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "close", "", "toString", "()Ljava/lang/String;", "b", "()Lokio/Sink;", "s", "Lokio/Sink;", "c", "okio"}, k = 1, mv = {1, 5, 1})
public abstract class ForwardingSink implements Sink {
    @NotNull
    private final Sink s;

    public ForwardingSink(@NotNull Sink sink) {
        Intrinsics.p(sink, "delegate");
        this.s = sink;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "delegate", imports = {}))
    @JvmName(name = "-deprecated_delegate")
    public final Sink b() {
        return this.s;
    }

    @NotNull
    @JvmName(name = "delegate")
    public final Sink c() {
        return this.s;
    }

    public void close() throws IOException {
        this.s.close();
    }

    public void flush() throws IOException {
        this.s.flush();
    }

    @NotNull
    public Timeout j() {
        return this.s.j();
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + ASCIIPropertyListParser.f18649g + this.s + ASCIIPropertyListParser.f18650h;
    }

    public void u1(@NotNull Buffer buffer, long j2) throws IOException {
        Intrinsics.p(buffer, "source");
        this.s.u1(buffer, j2);
    }
}
