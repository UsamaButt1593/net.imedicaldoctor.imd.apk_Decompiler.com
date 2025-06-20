package kotlin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.collections.ByteIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\b\u001a\u00020\u0007*\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\b¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\u000b\u001a\u00020\u0007*\u00020\nH\b¢\u0006\u0004\b\u000b\u0010\f\u001a$\u0010\u0010\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001e\u0010\u0014\u001a\u00020\u0000*\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\rH\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001e\u0010\u0017\u001a\u00020\u0016*\u00020\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001e\u0010\u001a\u001a\u00020\u0019*\u00020\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u0010\u001e\u001a\u00020\u001d*\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\rH\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001e\u0010!\u001a\u00020 *\u00020\u001c2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\b¢\u0006\u0004\b!\u0010\"\u001a\u001e\u0010$\u001a\u00020#*\u00020\u001c2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\b¢\u0006\u0004\b$\u0010%\u001a#\u0010(\u001a\u00020'*\u00020\u00122\u0006\u0010&\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b(\u0010)\u001a\u001d\u0010+\u001a\u00020\n*\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\rH\u0007¢\u0006\u0004\b+\u0010,\u001a\u0013\u0010-\u001a\u00020\n*\u00020\u0012H\u0007¢\u0006\u0004\b-\u0010.¨\u0006/"}, d2 = {"Ljava/io/BufferedInputStream;", "Lkotlin/collections/ByteIterator;", "o", "(Ljava/io/BufferedInputStream;)Lkotlin/collections/ByteIterator;", "", "Ljava/nio/charset/Charset;", "charset", "Ljava/io/ByteArrayInputStream;", "i", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Ljava/io/ByteArrayInputStream;", "", "m", "([B)Ljava/io/ByteArrayInputStream;", "", "offset", "length", "n", "([BII)Ljava/io/ByteArrayInputStream;", "Ljava/io/InputStream;", "bufferSize", "a", "(Ljava/io/InputStream;I)Ljava/io/BufferedInputStream;", "Ljava/io/InputStreamReader;", "s", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/io/InputStreamReader;", "Ljava/io/BufferedReader;", "e", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/io/BufferedReader;", "Ljava/io/OutputStream;", "Ljava/io/BufferedOutputStream;", "b", "(Ljava/io/OutputStream;I)Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStreamWriter;", "u", "(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)Ljava/io/OutputStreamWriter;", "Ljava/io/BufferedWriter;", "g", "(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)Ljava/io/BufferedWriter;", "out", "", "k", "(Ljava/io/InputStream;Ljava/io/OutputStream;I)J", "estimatedSize", "q", "(Ljava/io/InputStream;I)[B", "p", "(Ljava/io/InputStream;)[B", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "ByteStreamsKt")
public final class ByteStreamsKt {
    @InlineOnly
    private static final BufferedInputStream a(InputStream inputStream, int i2) {
        Intrinsics.p(inputStream, "<this>");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    @InlineOnly
    private static final BufferedOutputStream b(OutputStream outputStream, int i2) {
        Intrinsics.p(outputStream, "<this>");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }

    static /* synthetic */ BufferedInputStream c(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        Intrinsics.p(inputStream, "<this>");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    static /* synthetic */ BufferedOutputStream d(OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        Intrinsics.p(outputStream, "<this>");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }

    @InlineOnly
    private static final BufferedReader e(InputStream inputStream, Charset charset) {
        Intrinsics.p(inputStream, "<this>");
        Intrinsics.p(charset, "charset");
        return new BufferedReader(new InputStreamReader(inputStream, charset), 8192);
    }

    static /* synthetic */ BufferedReader f(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(inputStream, "<this>");
        Intrinsics.p(charset, "charset");
        return new BufferedReader(new InputStreamReader(inputStream, charset), 8192);
    }

    @InlineOnly
    private static final BufferedWriter g(OutputStream outputStream, Charset charset) {
        Intrinsics.p(outputStream, "<this>");
        Intrinsics.p(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(outputStream, charset), 8192);
    }

    static /* synthetic */ BufferedWriter h(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(outputStream, "<this>");
        Intrinsics.p(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(outputStream, charset), 8192);
    }

    @InlineOnly
    private static final ByteArrayInputStream i(String str, Charset charset) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.o(bytes, "this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    static /* synthetic */ ByteArrayInputStream j(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(str, "<this>");
        Intrinsics.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.o(bytes, "this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    public static final long k(@NotNull InputStream inputStream, @NotNull OutputStream outputStream, int i2) {
        Intrinsics.p(inputStream, "<this>");
        Intrinsics.p(outputStream, "out");
        byte[] bArr = new byte[i2];
        int read = inputStream.read(bArr);
        long j2 = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j2 += (long) read;
            read = inputStream.read(bArr);
        }
        return j2;
    }

    public static /* synthetic */ long l(InputStream inputStream, OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return k(inputStream, outputStream, i2);
    }

    @InlineOnly
    private static final ByteArrayInputStream m(byte[] bArr) {
        Intrinsics.p(bArr, "<this>");
        return new ByteArrayInputStream(bArr);
    }

    @InlineOnly
    private static final ByteArrayInputStream n(byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "<this>");
        return new ByteArrayInputStream(bArr, i2, i3);
    }

    @NotNull
    public static final ByteIterator o(@NotNull BufferedInputStream bufferedInputStream) {
        Intrinsics.p(bufferedInputStream, "<this>");
        return new ByteStreamsKt$iterator$1(bufferedInputStream);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final byte[] p(@NotNull InputStream inputStream) {
        Intrinsics.p(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, (Object) null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.o(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    @NotNull
    @Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(expression = "readBytes()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = "1.3")
    public static final byte[] q(@NotNull InputStream inputStream, int i2) {
        Intrinsics.p(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i2, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, (Object) null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.o(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    public static /* synthetic */ byte[] r(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return q(inputStream, i2);
    }

    @InlineOnly
    private static final InputStreamReader s(InputStream inputStream, Charset charset) {
        Intrinsics.p(inputStream, "<this>");
        Intrinsics.p(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    static /* synthetic */ InputStreamReader t(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(inputStream, "<this>");
        Intrinsics.p(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    @InlineOnly
    private static final OutputStreamWriter u(OutputStream outputStream, Charset charset) {
        Intrinsics.p(outputStream, "<this>");
        Intrinsics.p(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }

    static /* synthetic */ OutputStreamWriter v(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(outputStream, "<this>");
        Intrinsics.p(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }
}
