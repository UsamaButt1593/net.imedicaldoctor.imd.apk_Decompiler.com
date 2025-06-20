package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.dd.plist.ASCIIPropertyListParser;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"okio/AsyncTimeout$sink$1", "Lokio/Sink;", "Lokio/Buffer;", "source", "", "byteCount", "", "u1", "(Lokio/Buffer;J)V", "flush", "()V", "close", "Lokio/AsyncTimeout;", "b", "()Lokio/AsyncTimeout;", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 5, 1})
public final class AsyncTimeout$sink$1 implements Sink {
    final /* synthetic */ Sink X;
    final /* synthetic */ AsyncTimeout s;

    AsyncTimeout$sink$1(AsyncTimeout asyncTimeout, Sink sink) {
        this.s = asyncTimeout;
        this.X = sink;
    }

    @NotNull
    /* renamed from: b */
    public AsyncTimeout j() {
        return this.s;
    }

    public void close() {
        AsyncTimeout asyncTimeout = this.s;
        Sink sink = this.X;
        asyncTimeout.w();
        try {
            sink.close();
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

    public void flush() {
        AsyncTimeout asyncTimeout = this.s;
        Sink sink = this.X;
        asyncTimeout.w();
        try {
            sink.flush();
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

    @NotNull
    public String toString() {
        return "AsyncTimeout.sink(" + this.X + ASCIIPropertyListParser.f18650h;
    }

    public void u1(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "source");
        _UtilKt.e(buffer.L0(), 0, j2);
        while (true) {
            long j3 = 0;
            if (j2 > 0) {
                Segment segment = buffer.s;
                while (true) {
                    Intrinsics.m(segment);
                    if (j3 >= PlaybackStateCompat.v3) {
                        break;
                    }
                    j3 += (long) (segment.f31384c - segment.f31383b);
                    if (j3 >= j2) {
                        j3 = j2;
                        break;
                    }
                    segment = segment.f31387f;
                }
                AsyncTimeout asyncTimeout = this.s;
                Sink sink = this.X;
                asyncTimeout.w();
                try {
                    sink.u1(buffer, j3);
                    Unit unit = Unit.f28779a;
                    if (!asyncTimeout.x()) {
                        j2 -= j3;
                    } else {
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
            } else {
                return;
            }
        }
    }
}
