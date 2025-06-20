package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,151:1\n52#1:152\n1#2:153\n1#2:156\n1313#3,2:154\n*S KotlinDebug\n*F\n+ 1 ReadWrite.kt\nkotlin/io/TextStreamsKt\n*L\n33#1:152\n33#1:153\n33#1:154,2\n*E\n"})
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\b\u001a\u00020\u0007*\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\b\u0010\t\u001a%\u0010\u000e\u001a\u00020\f*\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010*\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a7\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0013*\u00020\u00002\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0014\u0012\u0004\u0012\u00028\u00000\nH\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0019\u001a\u00020\u0018*\u00020\u000bH\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014*\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001d\u001a\u00020\u000b*\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010!\u001a\u00020 *\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b!\u0010\"\u001a\u001e\u0010&\u001a\u00020\u000b*\u00020#2\b\b\u0002\u0010%\u001a\u00020$H\b¢\u0006\u0004\b&\u0010'\u001a\u0011\u0010)\u001a\u00020(*\u00020#¢\u0006\u0004\b)\u0010*\u0002\u0007\n\u0005\b20\u0001¨\u0006+"}, d2 = {"Ljava/io/Reader;", "", "bufferSize", "Ljava/io/BufferedReader;", "a", "(Ljava/io/Reader;I)Ljava/io/BufferedReader;", "Ljava/io/Writer;", "Ljava/io/BufferedWriter;", "b", "(Ljava/io/Writer;I)Ljava/io/BufferedWriter;", "Lkotlin/Function1;", "", "", "action", "g", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)V", "", "j", "(Ljava/io/Reader;)Ljava/util/List;", "T", "Lkotlin/sequences/Sequence;", "block", "o", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/io/StringReader;", "n", "(Ljava/lang/String;)Ljava/io/StringReader;", "h", "(Ljava/io/BufferedReader;)Lkotlin/sequences/Sequence;", "k", "(Ljava/io/Reader;)Ljava/lang/String;", "out", "", "e", "(Ljava/io/Reader;Ljava/io/Writer;I)J", "Ljava/net/URL;", "Ljava/nio/charset/Charset;", "charset", "l", "(Ljava/net/URL;Ljava/nio/charset/Charset;)Ljava/lang/String;", "", "i", "(Ljava/net/URL;)[B", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "TextStreamsKt")
public final class TextStreamsKt {
    @InlineOnly
    private static final BufferedReader a(Reader reader, int i2) {
        Intrinsics.p(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i2);
    }

    @InlineOnly
    private static final BufferedWriter b(Writer writer, int i2) {
        Intrinsics.p(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i2);
    }

    static /* synthetic */ BufferedReader c(Reader reader, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        Intrinsics.p(reader, "<this>");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i2);
    }

    static /* synthetic */ BufferedWriter d(Writer writer, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        Intrinsics.p(writer, "<this>");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i2);
    }

    public static final long e(@NotNull Reader reader, @NotNull Writer writer, int i2) {
        Intrinsics.p(reader, "<this>");
        Intrinsics.p(writer, "out");
        char[] cArr = new char[i2];
        int read = reader.read(cArr);
        long j2 = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j2 += (long) read;
            read = reader.read(cArr);
        }
        return j2;
    }

    public static /* synthetic */ long f(Reader reader, Writer writer, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return e(reader, writer, i2);
    }

    public static final void g(@NotNull Reader reader, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.p(reader, "<this>");
        Intrinsics.p(function1, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            for (String f2 : h(bufferedReader)) {
                function1.f(f2);
            }
            Unit unit = Unit.f28779a;
            CloseableKt.a(bufferedReader, (Throwable) null);
        } catch (Throwable th) {
            CloseableKt.a(bufferedReader, th);
            throw th;
        }
    }

    @NotNull
    public static final Sequence<String> h(@NotNull BufferedReader bufferedReader) {
        Intrinsics.p(bufferedReader, "<this>");
        return SequencesKt.f(new LinesSequence(bufferedReader));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        kotlin.io.CloseableKt.a(r2, r0);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] i(@org.jetbrains.annotations.NotNull java.net.URL r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.io.InputStream r2 = r2.openStream()
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.o(r2, r0)     // Catch:{ all -> 0x0017 }
            byte[] r0 = kotlin.io.ByteStreamsKt.p(r2)     // Catch:{ all -> 0x0017 }
            r1 = 0
            kotlin.io.CloseableKt.a(r2, r1)
            return r0
        L_0x0017:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r1 = move-exception
            kotlin.io.CloseableKt.a(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.TextStreamsKt.i(java.net.URL):byte[]");
    }

    @NotNull
    public static final List<String> j(@NotNull Reader reader) {
        Intrinsics.p(reader, "<this>");
        ArrayList arrayList = new ArrayList();
        g(reader, new TextStreamsKt$readLines$1(arrayList));
        return arrayList;
    }

    @NotNull
    public static final String k(@NotNull Reader reader) {
        Intrinsics.p(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        f(reader, stringWriter, 0, 2, (Object) null);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.o(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    @InlineOnly
    private static final String l(URL url, Charset charset) {
        Intrinsics.p(url, "<this>");
        Intrinsics.p(charset, "charset");
        return new String(i(url), charset);
    }

    static /* synthetic */ String m(URL url, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(url, "<this>");
        Intrinsics.p(charset, "charset");
        return new String(i(url), charset);
    }

    @InlineOnly
    private static final StringReader n(String str) {
        Intrinsics.p(str, "<this>");
        return new StringReader(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        kotlin.jvm.internal.InlineMarker.d(1);
        kotlin.io.CloseableKt.a(r2, r3);
        kotlin.jvm.internal.InlineMarker.c(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T o(@org.jetbrains.annotations.NotNull java.io.Reader r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.sequences.Sequence<java.lang.String>, ? extends T> r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            boolean r0 = r2 instanceof java.io.BufferedReader
            if (r0 == 0) goto L_0x0011
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2
            goto L_0x0019
        L_0x0011:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r1 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r2, r1)
            r2 = r0
        L_0x0019:
            r0 = 1
            kotlin.sequences.Sequence r1 = h(r2)     // Catch:{ all -> 0x002d }
            java.lang.Object r3 = r3.f(r1)     // Catch:{ all -> 0x002d }
            kotlin.jvm.internal.InlineMarker.d(r0)
            r1 = 0
            kotlin.io.CloseableKt.a(r2, r1)
            kotlin.jvm.internal.InlineMarker.c(r0)
            return r3
        L_0x002d:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x002f }
        L_0x002f:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r0)
            kotlin.io.CloseableKt.a(r2, r3)
            kotlin.jvm.internal.InlineMarker.c(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.TextStreamsKt.o(java.io.Reader, kotlin.jvm.functions.Function1):java.lang.Object");
    }
}
