package okio;

import com.itextpdf.tool.xml.css.CSS;
import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u000f\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001aC\u0010\u0010\u001a\u00028\u0001\"\u0010\b\u0000\u0010\f*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\"\u0004\b\u0001\u0010\r*\u00028\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0012"}, d2 = {"Lokio/Source;", "Lokio/BufferedSource;", "c", "(Lokio/Source;)Lokio/BufferedSource;", "Lokio/Sink;", "Lokio/BufferedSink;", "b", "(Lokio/Sink;)Lokio/BufferedSink;", "a", "()Lokio/Sink;", "Ljava/io/Closeable;", "Lokio/Closeable;", "T", "R", "Lkotlin/Function1;", "block", "d", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "okio"}, k = 5, mv = {1, 5, 1}, xs = "okio/Okio")
final /* synthetic */ class Okio__OkioKt {
    @NotNull
    @JvmName(name = "blackhole")
    public static final Sink a() {
        return new BlackholeSink();
    }

    @NotNull
    public static final BufferedSink b(@NotNull Sink sink) {
        Intrinsics.p(sink, "<this>");
        return new RealBufferedSink(sink);
    }

    @NotNull
    public static final BufferedSource c(@NotNull Source source) {
        Intrinsics.p(source, "<this>");
        return new RealBufferedSource(source);
    }

    public static final <T extends Closeable, R> R d(T t, @NotNull Function1<? super T, ? extends R> function1) {
        R r;
        Intrinsics.p(function1, CSS.Value.v0);
        Throwable th = null;
        try {
            r = function1.f(t);
        } catch (Throwable th2) {
            th = th2;
            r = null;
        }
        if (t != null) {
            try {
                t.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ExceptionsKt.a(th, th3);
                }
            }
        }
        if (th == null) {
            Intrinsics.m(r);
            return r;
        }
        throw th;
    }
}
