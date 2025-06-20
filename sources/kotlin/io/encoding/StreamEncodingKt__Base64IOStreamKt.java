package kotlin.io.encoding;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ljava/io/InputStream;", "Lkotlin/io/encoding/Base64;", "base64", "a", "(Ljava/io/InputStream;Lkotlin/io/encoding/Base64;)Ljava/io/InputStream;", "Ljava/io/OutputStream;", "b", "(Ljava/io/OutputStream;Lkotlin/io/encoding/Base64;)Ljava/io/OutputStream;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/io/encoding/StreamEncodingKt")
class StreamEncodingKt__Base64IOStreamKt {
    @NotNull
    @SinceKotlin(version = "1.8")
    @ExperimentalEncodingApi
    public static final InputStream a(@NotNull InputStream inputStream, @NotNull Base64 base64) {
        Intrinsics.p(inputStream, "<this>");
        Intrinsics.p(base64, "base64");
        return new DecodeInputStream(inputStream, base64);
    }

    @NotNull
    @SinceKotlin(version = "1.8")
    @ExperimentalEncodingApi
    public static final OutputStream b(@NotNull OutputStream outputStream, @NotNull Base64 base64) {
        Intrinsics.p(outputStream, "<this>");
        Intrinsics.p(base64, "base64");
        return new EncodeOutputStream(outputStream, base64);
    }
}
