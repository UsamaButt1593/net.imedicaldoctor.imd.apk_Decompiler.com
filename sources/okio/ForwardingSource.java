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

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "<init>", "(Lokio/Source;)V", "Lokio/Buffer;", "sink", "", "byteCount", "n2", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "", "close", "()V", "", "toString", "()Ljava/lang/String;", "b", "()Lokio/Source;", "s", "Lokio/Source;", "c", "okio"}, k = 1, mv = {1, 5, 1})
public abstract class ForwardingSource implements Source {
    @NotNull
    private final Source s;

    public ForwardingSource(@NotNull Source source) {
        Intrinsics.p(source, "delegate");
        this.s = source;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "delegate", imports = {}))
    @JvmName(name = "-deprecated_delegate")
    public final Source b() {
        return this.s;
    }

    @NotNull
    @JvmName(name = "delegate")
    public final Source c() {
        return this.s;
    }

    public void close() throws IOException {
        this.s.close();
    }

    @NotNull
    public Timeout j() {
        return this.s.j();
    }

    public long n2(@NotNull Buffer buffer, long j2) throws IOException {
        Intrinsics.p(buffer, "sink");
        return this.s.n2(buffer, j2);
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + ASCIIPropertyListParser.f18649g + this.s + ASCIIPropertyListParser.f18650h;
    }
}
