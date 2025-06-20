package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\n\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\b¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\n\u001a\u00020\u00008\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\t\"\u0014\u0010\u000b\u001a\u00020\u00008\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\t\"\u0014\u0010\r\u001a\u00020\u00008\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\t\"\u0014\u0010\u000f\u001a\u00020\u00008\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\t\"\u0014\u0010\u0013\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0015\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012\"\u0014\u0010\u0017\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012\"\u0014\u0010\u0019\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012¨\u0006\u001a"}, d2 = {"", "bit", "", "a", "(II)Z", "Lokio/Source;", "Lokio/GzipSource;", "b", "(Lokio/Source;)Lokio/GzipSource;", "I", "FHCRC", "FEXTRA", "c", "FNAME", "d", "FCOMMENT", "", "e", "B", "SECTION_HEADER", "f", "SECTION_BODY", "g", "SECTION_TRAILER", "h", "SECTION_DONE", "okio"}, k = 2, mv = {1, 5, 1})
@JvmName(name = "-GzipSourceExtensions")
/* renamed from: okio.-GzipSourceExtensions  reason: invalid class name */
public final class GzipSourceExtensions {

    /* renamed from: a  reason: collision with root package name */
    private static final int f31340a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static final int f31341b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final int f31342c = 3;

    /* renamed from: d  reason: collision with root package name */
    private static final int f31343d = 4;

    /* renamed from: e  reason: collision with root package name */
    private static final byte f31344e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final byte f31345f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final byte f31346g = 2;

    /* renamed from: h  reason: collision with root package name */
    private static final byte f31347h = 3;

    private static final boolean a(int i2, int i3) {
        return ((i2 >> i3) & 1) == 1;
    }

    @NotNull
    public static final GzipSource b(@NotNull Source source) {
        Intrinsics.p(source, "<this>");
        return new GzipSource(source);
    }
}
