package okio;

import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lokio/Source;", "Ljava/util/zip/Inflater;", "inflater", "Lokio/InflaterSource;", "a", "(Lokio/Source;Ljava/util/zip/Inflater;)Lokio/InflaterSource;", "okio"}, k = 2, mv = {1, 5, 1})
@JvmName(name = "-InflaterSourceExtensions")
/* renamed from: okio.-InflaterSourceExtensions  reason: invalid class name */
public final class InflaterSourceExtensions {
    @NotNull
    public static final InflaterSource a(@NotNull Source source, @NotNull Inflater inflater) {
        Intrinsics.p(source, "<this>");
        Intrinsics.p(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }

    public static /* synthetic */ InflaterSource b(Source source, Inflater inflater, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            inflater = new Inflater();
        }
        Intrinsics.p(source, "<this>");
        Intrinsics.p(inflater, "inflater");
        return new InflaterSource(source, inflater);
    }
}
