package kotlin.io.path;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\n\u001a2\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\b¢\u0006\u0004\b\u0007\u0010\b\u001a<\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\b¢\u0006\u0004\b\f\u0010\r\u001a2\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a<\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0015\u001a\u00020\u0014*\u00020\u0000H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a0\u0010\u0019\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00142\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010\u001b\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0014H\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001d\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a9\u0010\"\u001a\u00020\u0018*\u00020\u00002\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0007¢\u0006\u0004\b\"\u0010#\u001a%\u0010$\u001a\u00020\u0018*\u00020\u00002\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b$\u0010%\u001aD\u0010+\u001a\u00020\u0018*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00180&H\bø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a(\u0010.\u001a\u00020-*\u00020\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\b¢\u0006\u0004\b.\u0010/\u001a(\u00101\u001a\u000200*\u00020\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\b¢\u0006\u0004\b1\u00102\u001a$\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d03*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b4\u00105\u001aA\u00109\u001a\u00028\u0000\"\u0004\b\u0000\u00106*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0018\u00108\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d07\u0012\u0004\u0012\u00028\u00000&H\bø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a@\u0010=\u001a\u00020\u0000*\u00020\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00020 0;2\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\b¢\u0006\u0004\b=\u0010>\u001a@\u0010?\u001a\u00020\u0000*\u00020\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00020 072\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\b¢\u0006\u0004\b?\u0010@\u001a,\u0010A\u001a\u00020\u0000*\u00020\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00020 0;2\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\bA\u0010B\u001a,\u0010C\u001a\u00020\u0000*\u00020\u00002\f\u0010<\u001a\b\u0012\u0004\u0012\u00020 072\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\bC\u0010D\u0002\u0007\n\u0005\b20\u0001¨\u0006E"}, d2 = {"Ljava/nio/file/Path;", "Ljava/nio/charset/Charset;", "charset", "", "Ljava/nio/file/OpenOption;", "options", "Ljava/io/InputStreamReader;", "u", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "", "bufferSize", "Ljava/io/BufferedReader;", "h", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "Ljava/io/OutputStreamWriter;", "F", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;", "Ljava/io/BufferedWriter;", "j", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "", "p", "(Ljava/nio/file/Path;)[B", "array", "", "y", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "a", "(Ljava/nio/file/Path;[B)V", "", "s", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;)Ljava/lang/String;", "", "text", "D", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "f", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "action", "l", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)V", "Ljava/io/InputStream;", "n", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "Ljava/io/OutputStream;", "o", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "", "q", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;)Ljava/util/List;", "T", "Lkotlin/sequences/Sequence;", "block", "w", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "lines", "z", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "A", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "b", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;)Ljava/nio/file/Path;", "c", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;)Ljava/nio/file/Path;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/io/path/PathsKt")
@SourceDebugExtension({"SMAP\nPathReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,326:1\n1#2:327\n1#2:329\n52#3:328\n1313#4,2:330\n*S KotlinDebug\n*F\n+ 1 PathReadWrite.kt\nkotlin/io/path/PathsKt__PathReadWriteKt\n*L\n202#1:329\n202#1:328\n202#1:330,2\n*E\n"})
class PathsKt__PathReadWriteKt {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path A(Path path, Sequence<? extends CharSequence> sequence, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(sequence, "lines");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(openOptionArr, "options");
        Path a2 = Files.write(path, SequencesKt.N(sequence), charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.o(a2, "write(this, lines.asIterable(), charset, *options)");
        return a2;
    }

    static /* synthetic */ Path B(Path path, Iterable iterable, Charset charset, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(path, "<this>");
        Intrinsics.p(iterable, "lines");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(openOptionArr, "options");
        Path a2 = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.o(a2, "write(this, lines, charset, *options)");
        return a2;
    }

    static /* synthetic */ Path C(Path path, Sequence sequence, Charset charset, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(path, "<this>");
        Intrinsics.p(sequence, "lines");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(openOptionArr, "options");
        Path a2 = Files.write(path, SequencesKt.N(sequence), charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.o(a2, "write(this, lines.asIterable(), charset, *options)");
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        kotlin.io.CloseableKt.a(r4, r1);
     */
    @kotlin.SinceKotlin(version = "1.5")
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void D(@org.jetbrains.annotations.NotNull java.nio.file.Path r1, @org.jetbrains.annotations.NotNull java.lang.CharSequence r2, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r3, @org.jetbrains.annotations.NotNull java.nio.file.OpenOption... r4) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r1, r0)
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.Intrinsics.p(r4, r0)
            int r0 = r4.length
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r0)
            java.nio.file.OpenOption[] r4 = (java.nio.file.OpenOption[]) r4
            java.io.OutputStream r1 = java.nio.file.Files.newOutputStream(r1, r4)
            java.lang.String r4 = "newOutputStream(this, *options)"
            kotlin.jvm.internal.Intrinsics.o(r1, r4)
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter
            r4.<init>(r1, r3)
            r4.append(r2)     // Catch:{ all -> 0x0031 }
            r1 = 0
            kotlin.io.CloseableKt.a(r4, r1)
            return
        L_0x0031:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r4, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathReadWriteKt.D(java.nio.file.Path, java.lang.CharSequence, java.nio.charset.Charset, java.nio.file.OpenOption[]):void");
    }

    public static /* synthetic */ void E(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = Charsets.f29053b;
        }
        D(path, charSequence, charset, openOptionArr);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final OutputStreamWriter F(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(openOptionArr, "options");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    static /* synthetic */ OutputStreamWriter G(Path path, Charset charset, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(path, "<this>");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(openOptionArr, "options");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final void a(Path path, byte[] bArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(bArr, "array");
        Path unused = Files.write(path, bArr, new OpenOption[]{StandardOpenOption.APPEND});
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path b(Path path, Iterable<? extends CharSequence> iterable, Charset charset) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(iterable, "lines");
        Intrinsics.p(charset, "charset");
        Path a2 = Files.write(path, iterable, charset, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.o(a2, "write(this, lines, chars…tandardOpenOption.APPEND)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path c(Path path, Sequence<? extends CharSequence> sequence, Charset charset) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(sequence, "lines");
        Intrinsics.p(charset, "charset");
        Path a2 = Files.write(path, SequencesKt.N(sequence), charset, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.o(a2, "write(this, lines.asIter…tandardOpenOption.APPEND)");
        return a2;
    }

    static /* synthetic */ Path d(Path path, Iterable iterable, Charset charset, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(path, "<this>");
        Intrinsics.p(iterable, "lines");
        Intrinsics.p(charset, "charset");
        Path a2 = Files.write(path, iterable, charset, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.o(a2, "write(this, lines, chars…tandardOpenOption.APPEND)");
        return a2;
    }

    static /* synthetic */ Path e(Path path, Sequence sequence, Charset charset, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(path, "<this>");
        Intrinsics.p(sequence, "lines");
        Intrinsics.p(charset, "charset");
        Path a2 = Files.write(path, SequencesKt.N(sequence), charset, new OpenOption[]{StandardOpenOption.APPEND});
        Intrinsics.o(a2, "write(this, lines.asIter…tandardOpenOption.APPEND)");
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0031, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        kotlin.io.CloseableKt.a(r0, r3);
     */
    @kotlin.SinceKotlin(version = "1.5")
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void f(@org.jetbrains.annotations.NotNull java.nio.file.Path r3, @org.jetbrains.annotations.NotNull java.lang.CharSequence r4, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r5) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.p(r4, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.p(r5, r0)
            r0 = 1
            java.nio.file.OpenOption[] r0 = new java.nio.file.OpenOption[r0]
            r1 = 0
            java.nio.file.StandardOpenOption r2 = java.nio.file.StandardOpenOption.APPEND
            r0[r1] = r2
            java.io.OutputStream r3 = java.nio.file.Files.newOutputStream(r3, r0)
            java.lang.String r0 = "newOutputStream(this, StandardOpenOption.APPEND)"
            kotlin.jvm.internal.Intrinsics.o(r3, r0)
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter
            r0.<init>(r3, r5)
            r0.append(r4)     // Catch:{ all -> 0x002f }
            r3 = 0
            kotlin.io.CloseableKt.a(r0, r3)
            return
        L_0x002f:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r4 = move-exception
            kotlin.io.CloseableKt.a(r0, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathReadWriteKt.f(java.nio.file.Path, java.lang.CharSequence, java.nio.charset.Charset):void");
    }

    public static /* synthetic */ void g(Path path, CharSequence charSequence, Charset charset, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = Charsets.f29053b;
        }
        f(path, charSequence, charset);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final BufferedReader h(Path path, Charset charset, int i2, OpenOption... openOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(openOptionArr, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i2);
    }

    static /* synthetic */ BufferedReader i(Path path, Charset charset, int i2, OpenOption[] openOptionArr, int i3, Object obj) throws IOException {
        if ((i3 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        Intrinsics.p(path, "<this>");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(openOptionArr, "options");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final BufferedWriter j(Path path, Charset charset, int i2, OpenOption... openOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(openOptionArr, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i2);
    }

    static /* synthetic */ BufferedWriter k(Path path, Charset charset, int i2, OpenOption[] openOptionArr, int i3, Object obj) throws IOException {
        if ((i3 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        Intrinsics.p(path, "<this>");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(openOptionArr, "options");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final void l(Path path, Charset charset, Function1<? super String, Unit> function1) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(function1, "action");
        BufferedReader a2 = Files.newBufferedReader(path, charset);
        Intrinsics.o(a2, "newBufferedReader(this, charset)");
        try {
            for (String f2 : TextStreamsKt.h(a2)) {
                function1.f(f2);
            }
            Unit unit = Unit.f28779a;
            InlineMarker.d(1);
            CloseableKt.a(a2, (Throwable) null);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.d(1);
            CloseableKt.a(a2, th);
            InlineMarker.c(1);
            throw th;
        }
    }

    static /* synthetic */ void m(Path path, Charset charset, Function1 function1, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(path, "<this>");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(function1, "action");
        BufferedReader a2 = Files.newBufferedReader(path, charset);
        Intrinsics.o(a2, "newBufferedReader(this, charset)");
        try {
            for (String f2 : TextStreamsKt.h(a2)) {
                function1.f(f2);
            }
            Unit unit = Unit.f28779a;
            InlineMarker.d(1);
            CloseableKt.a(a2, (Throwable) null);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.d(1);
            CloseableKt.a(a2, th);
            InlineMarker.c(1);
            throw th;
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final InputStream n(Path path, OpenOption... openOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(openOptionArr, "options");
        InputStream a2 = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.o(a2, "newInputStream(this, *options)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final OutputStream o(Path path, OpenOption... openOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(openOptionArr, "options");
        OutputStream a2 = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.o(a2, "newOutputStream(this, *options)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final byte[] p(Path path) throws IOException {
        Intrinsics.p(path, "<this>");
        byte[] a2 = Files.readAllBytes(path);
        Intrinsics.o(a2, "readAllBytes(this)");
        return a2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final List<String> q(Path path, Charset charset) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(charset, "charset");
        List<String> a2 = Files.readAllLines(path, charset);
        Intrinsics.o(a2, "readAllLines(this, charset)");
        return a2;
    }

    static /* synthetic */ List r(Path path, Charset charset, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(path, "<this>");
        Intrinsics.p(charset, "charset");
        List a2 = Files.readAllLines(path, charset);
        Intrinsics.o(a2, "readAllLines(this, charset)");
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        kotlin.io.CloseableKt.a(r2, r3);
     */
    @kotlin.SinceKotlin(version = "1.5")
    @org.jetbrains.annotations.NotNull
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String s(@org.jetbrains.annotations.NotNull java.nio.file.Path r3, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r4) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.p(r4, r0)
            r0 = 0
            java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r0]
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r0)
            java.nio.file.OpenOption[] r0 = (java.nio.file.OpenOption[]) r0
            java.io.InputStream r3 = java.nio.file.Files.newInputStream(r3, r0)
            r2.<init>(r3, r4)
            java.lang.String r3 = kotlin.io.TextStreamsKt.k(r2)     // Catch:{ all -> 0x0025 }
            r4 = 0
            kotlin.io.CloseableKt.a(r2, r4)
            return r3
        L_0x0025:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r4 = move-exception
            kotlin.io.CloseableKt.a(r2, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathReadWriteKt.s(java.nio.file.Path, java.nio.charset.Charset):java.lang.String");
    }

    public static /* synthetic */ String t(Path path, Charset charset, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        return s(path, charset);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final InputStreamReader u(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(openOptionArr, "options");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    static /* synthetic */ InputStreamReader v(Path path, Charset charset, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(path, "<this>");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(openOptionArr, "options");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        kotlin.jvm.internal.InlineMarker.d(1);
        kotlin.io.CloseableKt.a(r1, r3);
        kotlin.jvm.internal.InlineMarker.c(1);
     */
    @kotlin.SinceKotlin(version = "1.5")
    @kotlin.internal.InlineOnly
    @kotlin.WasExperimental(markerClass = {kotlin.io.path.ExperimentalPathApi.class})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> T w(java.nio.file.Path r1, java.nio.charset.Charset r2, kotlin.jvm.functions.Function1<? super kotlin.sequences.Sequence<java.lang.String>, ? extends T> r3) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r1, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            java.io.BufferedReader r1 = java.nio.file.Files.newBufferedReader(r1, r2)
            r2 = 1
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.o(r1, r0)     // Catch:{ all -> 0x002c }
            kotlin.sequences.Sequence r0 = kotlin.io.TextStreamsKt.h(r1)     // Catch:{ all -> 0x002c }
            java.lang.Object r3 = r3.f(r0)     // Catch:{ all -> 0x002c }
            kotlin.jvm.internal.InlineMarker.d(r2)
            r0 = 0
            kotlin.io.CloseableKt.a(r1, r0)
            kotlin.jvm.internal.InlineMarker.c(r2)
            return r3
        L_0x002c:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x002e }
        L_0x002e:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r2)
            kotlin.io.CloseableKt.a(r1, r3)
            kotlin.jvm.internal.InlineMarker.c(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathReadWriteKt.w(java.nio.file.Path, java.nio.charset.Charset, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        kotlin.jvm.internal.InlineMarker.d(1);
        kotlin.io.CloseableKt.a(r0, r1);
        kotlin.jvm.internal.InlineMarker.c(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object x(java.nio.file.Path r0, java.nio.charset.Charset r1, kotlin.jvm.functions.Function1 r2, int r3, java.lang.Object r4) throws java.io.IOException {
        /*
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0006
            java.nio.charset.Charset r1 = kotlin.text.Charsets.f29053b
        L_0x0006:
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r0, r3)
            java.lang.String r3 = "charset"
            kotlin.jvm.internal.Intrinsics.p(r1, r3)
            java.lang.String r3 = "block"
            kotlin.jvm.internal.Intrinsics.p(r2, r3)
            java.io.BufferedReader r0 = java.nio.file.Files.newBufferedReader(r0, r1)
            java.lang.String r1 = "it"
            kotlin.jvm.internal.Intrinsics.o(r0, r1)     // Catch:{ all -> 0x0031 }
            kotlin.sequences.Sequence r1 = kotlin.io.TextStreamsKt.h(r0)     // Catch:{ all -> 0x0031 }
            java.lang.Object r1 = r2.f(r1)     // Catch:{ all -> 0x0031 }
            kotlin.jvm.internal.InlineMarker.d(r4)
            r2 = 0
            kotlin.io.CloseableKt.a(r0, r2)
            kotlin.jvm.internal.InlineMarker.c(r4)
            return r1
        L_0x0031:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r2 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r4)
            kotlin.io.CloseableKt.a(r0, r1)
            kotlin.jvm.internal.InlineMarker.c(r4)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathsKt__PathReadWriteKt.x(java.nio.file.Path, java.nio.charset.Charset, kotlin.jvm.functions.Function1, int, java.lang.Object):java.lang.Object");
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final void y(Path path, byte[] bArr, OpenOption... openOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(bArr, "array");
        Intrinsics.p(openOptionArr, "options");
        Path unused = Files.write(path, bArr, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path z(Path path, Iterable<? extends CharSequence> iterable, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(iterable, "lines");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(openOptionArr, "options");
        Path a2 = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.o(a2, "write(this, lines, charset, *options)");
        return a2;
    }
}
