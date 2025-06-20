package okio;

import com.itextpdf.tool.xml.css.CSS;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f*\n\u0010\u000e\"\u00020\r2\u00020\r*\n\u0010\u0010\"\u00020\u000f2\u00020\u000f*\n\u0010\u0012\"\u00020\u00112\u00020\u0011*\n\u0010\u0014\"\u00020\u00132\u00020\u0013*\n\u0010\u0016\"\u00020\u00152\u00020\u0015\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0017"}, d2 = {"", "", "c", "([B)Ljava/lang/String;", "a", "(Ljava/lang/String;)[B", "R", "", "lock", "Lkotlin/Function0;", "block", "b", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Ljava/lang/ArrayIndexOutOfBoundsException;", "ArrayIndexOutOfBoundsException", "Ljava/io/Closeable;", "Closeable", "Ljava/io/EOFException;", "EOFException", "Ljava/io/FileNotFoundException;", "FileNotFoundException", "Ljava/io/IOException;", "IOException", "okio"}, k = 2, mv = {1, 5, 1})
public final class _JvmPlatformKt {
    @NotNull
    public static final byte[] a(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.f29053b);
        Intrinsics.o(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final <R> R b(@NotNull Object obj, @NotNull Function0<? extends R> function0) {
        R o;
        Intrinsics.p(obj, "lock");
        Intrinsics.p(function0, CSS.Value.v0);
        synchronized (obj) {
            try {
                o = function0.o();
                InlineMarker.d(1);
            } catch (Throwable th) {
                InlineMarker.d(1);
                InlineMarker.c(1);
                throw th;
            }
        }
        InlineMarker.c(1);
        return o;
    }

    @NotNull
    public static final String c(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "<this>");
        return new String(bArr, Charsets.f29053b);
    }
}
