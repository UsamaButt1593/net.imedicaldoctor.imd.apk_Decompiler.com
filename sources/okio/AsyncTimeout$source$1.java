package okio;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"okio/AsyncTimeout$source$1", "Lokio/Source;", "Lokio/Buffer;", "sink", "", "byteCount", "n2", "(Lokio/Buffer;J)J", "", "close", "()V", "Lokio/AsyncTimeout;", "b", "()Lokio/AsyncTimeout;", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 5, 1})
public final class AsyncTimeout$source$1 implements Source {
    final /* synthetic */ Source X;
    final /* synthetic */ AsyncTimeout s;

    AsyncTimeout$source$1(AsyncTimeout asyncTimeout, Source source) {
        this.s = asyncTimeout;
        this.X = source;
    }

    @NotNull
    /* renamed from: b */
    public AsyncTimeout j() {
        return this.s;
    }

    public void close() {
        AsyncTimeout asyncTimeout = this.s;
        Source source = this.X;
        asyncTimeout.w();
        try {
            source.close();
            Unit unit = Unit.f28779a;
            if (asyncTimeout.x()) {
                throw asyncTimeout.q((IOException) null);
            }
        } catch (IOException e2) {
            e = e2;
            if (asyncTimeout.x()) {
                e = asyncTimeout.q(e);
            }
            throw e;
        } finally {
            asyncTimeout.x();
        }
    }

    public long n2(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "sink");
        AsyncTimeout asyncTimeout = this.s;
        Source source = this.X;
        asyncTimeout.w();
        try {
            long n2 = source.n2(buffer, j2);
            if (!asyncTimeout.x()) {
                return n2;
            }
            throw asyncTimeout.q((IOException) null);
        } catch (IOException e2) {
            e = e2;
            if (asyncTimeout.x()) {
                e = asyncTimeout.q(e);
            }
            throw e;
        } finally {
            asyncTimeout.x();
        }
    }

    @NotNull
    public String toString() {
        return "AsyncTimeout.source(" + this.X + ASCIIPropertyListParser.f18650h;
    }
}
