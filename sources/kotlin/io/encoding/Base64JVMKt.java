package kotlin.io.encoding;

import com.itextpdf.text.Annotation;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u001a,\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0007\u0010\b\u001a,\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\b¢\u0006\u0004\b\n\u0010\u000b\u001a<\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a,\u0010\u0010\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlin/io/encoding/Base64;", "", "source", "", "startIndex", "endIndex", "", "a", "(Lkotlin/io/encoding/Base64;Ljava/lang/CharSequence;II)[B", "", "d", "(Lkotlin/io/encoding/Base64;[BII)Ljava/lang/String;", "destination", "destinationOffset", "b", "(Lkotlin/io/encoding/Base64;[B[BIII)I", "c", "(Lkotlin/io/encoding/Base64;[BII)[B", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class Base64JVMKt {
    @SinceKotlin(version = "1.8")
    @ExperimentalEncodingApi
    @InlineOnly
    private static final byte[] a(Base64 base64, CharSequence charSequence, int i2, int i3) {
        Intrinsics.p(base64, "<this>");
        Intrinsics.p(charSequence, "source");
        if (!(charSequence instanceof String)) {
            return base64.e(charSequence, i2, i3);
        }
        base64.g(charSequence.length(), i2, i3);
        String substring = ((String) charSequence).substring(i2, i3);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        Charset charset = Charsets.f29058g;
        Intrinsics.n(substring, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = substring.getBytes(charset);
        Intrinsics.o(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalEncodingApi
    @InlineOnly
    private static final int b(Base64 base64, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        Intrinsics.p(base64, "<this>");
        Intrinsics.p(bArr, "source");
        Intrinsics.p(bArr2, Annotation.l3);
        return base64.v(bArr, bArr2, i2, i3, i4);
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalEncodingApi
    @InlineOnly
    private static final byte[] c(Base64 base64, byte[] bArr, int i2, int i3) {
        Intrinsics.p(base64, "<this>");
        Intrinsics.p(bArr, "source");
        return base64.B(bArr, i2, i3);
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalEncodingApi
    @InlineOnly
    private static final String d(Base64 base64, byte[] bArr, int i2, int i3) {
        Intrinsics.p(base64, "<this>");
        Intrinsics.p(bArr, "source");
        return new String(base64.B(bArr, i2, i3), Charsets.f29058g);
    }
}
