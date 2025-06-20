package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lokio/Sink;", "Lokio/GzipSink;", "a", "(Lokio/Sink;)Lokio/GzipSink;", "okio"}, k = 2, mv = {1, 5, 1})
@JvmName(name = "-GzipSinkExtensions")
/* renamed from: okio.-GzipSinkExtensions  reason: invalid class name */
public final class GzipSinkExtensions {
    @NotNull
    public static final GzipSink a(@NotNull Sink sink) {
        Intrinsics.p(sink, "<this>");
        return new GzipSink(sink);
    }
}
