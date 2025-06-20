package okio;

import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lokio/Sink;", "Ljava/util/zip/Deflater;", "deflater", "Lokio/DeflaterSink;", "a", "(Lokio/Sink;Ljava/util/zip/Deflater;)Lokio/DeflaterSink;", "okio"}, k = 2, mv = {1, 5, 1})
@JvmName(name = "-DeflaterSinkExtensions")
/* renamed from: okio.-DeflaterSinkExtensions  reason: invalid class name */
public final class DeflaterSinkExtensions {
    @NotNull
    public static final DeflaterSink a(@NotNull Sink sink, @NotNull Deflater deflater) {
        Intrinsics.p(sink, "<this>");
        Intrinsics.p(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }

    public static /* synthetic */ DeflaterSink b(Sink sink, Deflater deflater, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            deflater = new Deflater();
        }
        Intrinsics.p(sink, "<this>");
        Intrinsics.p(deflater, "deflater");
        return new DeflaterSink(sink, deflater);
    }
}
