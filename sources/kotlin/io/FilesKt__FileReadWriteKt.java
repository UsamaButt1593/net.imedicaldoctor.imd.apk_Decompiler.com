package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a(\u0010\t\u001a\u00020\b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\b¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\f\u0010\r\u001a(\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0015\u001a\u00020\u0014*\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0019\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u001b\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001a\u001a\u001b\u0010\u001d\u001a\u00020\u001c*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010 \u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b \u0010!\u001a#\u0010\"\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\"\u0010!\u001aI\u0010)\u001a\u00020\u0018*\u00020\u000026\u0010(\u001a2\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00180#¢\u0006\u0004\b)\u0010*\u001aQ\u0010,\u001a\u00020\u0018*\u00020\u00002\u0006\u0010+\u001a\u00020\u000626\u0010(\u001a2\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00180#¢\u0006\u0004\b,\u0010-\u001a>\u00100\u001a\u00020\u0018*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012!\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00180.¢\u0006\u0004\b0\u00101\u001a\u0014\u00103\u001a\u000202*\u00020\u0000H\b¢\u0006\u0004\b3\u00104\u001a\u0014\u00106\u001a\u000205*\u00020\u0000H\b¢\u0006\u0004\b6\u00107\u001a!\u00109\u001a\b\u0012\u0004\u0012\u00020\u001c08*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b9\u0010:\u001aA\u0010>\u001a\u00028\u0000\"\u0004\b\u0000\u0010;*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0018\u0010=\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0<\u0012\u0004\u0012\u00028\u00000.H\bø\u0001\u0000¢\u0006\u0004\b>\u0010?\u0002\u0007\n\u0005\b20\u0001¨\u0006@"}, d2 = {"Ljava/io/File;", "Ljava/nio/charset/Charset;", "charset", "Ljava/io/InputStreamReader;", "A", "(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/io/InputStreamReader;", "", "bufferSize", "Ljava/io/BufferedReader;", "j", "(Ljava/io/File;Ljava/nio/charset/Charset;I)Ljava/io/BufferedReader;", "Ljava/io/OutputStreamWriter;", "H", "(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/io/OutputStreamWriter;", "Ljava/io/BufferedWriter;", "l", "(Ljava/io/File;Ljava/nio/charset/Charset;I)Ljava/io/BufferedWriter;", "Ljava/io/PrintWriter;", "t", "(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/io/PrintWriter;", "", "v", "(Ljava/io/File;)[B", "array", "", "E", "(Ljava/io/File;[B)V", "g", "", "y", "(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/lang/String;", "text", "F", "(Ljava/io/File;Ljava/lang/String;Ljava/nio/charset/Charset;)V", "h", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "action", "o", "(Ljava/io/File;Lkotlin/jvm/functions/Function2;)V", "blockSize", "n", "(Ljava/io/File;ILkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "line", "p", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)V", "Ljava/io/FileInputStream;", "r", "(Ljava/io/File;)Ljava/io/FileInputStream;", "Ljava/io/FileOutputStream;", "s", "(Ljava/io/File;)Ljava/io/FileOutputStream;", "", "w", "(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/util/List;", "T", "Lkotlin/sequences/Sequence;", "block", "C", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/io/FilesKt")
@SourceDebugExtension({"SMAP\nFileReadWrite.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileReadWrite.kt\nkotlin/io/FilesKt__FileReadWriteKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,232:1\n231#1:234\n1#2:233\n1#2:235\n*S KotlinDebug\n*F\n+ 1 FileReadWrite.kt\nkotlin/io/FilesKt__FileReadWriteKt\n*L\n230#1:234\n230#1:235\n*E\n"})
class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    @InlineOnly
    private static final InputStreamReader A(File file, Charset charset) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    static /* synthetic */ InputStreamReader B(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(file, "<this>");
        Intrinsics.p(charset, "charset");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        kotlin.jvm.internal.InlineMarker.d(1);
        kotlin.io.CloseableKt.a(r2, r4);
        kotlin.jvm.internal.InlineMarker.c(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T C(@org.jetbrains.annotations.NotNull java.io.File r2, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.sequences.Sequence<java.lang.String>, ? extends T> r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.p(r4, r0)
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r2)
            r0.<init>(r1, r3)
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r3 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r0, r3)
            r3 = 1
            kotlin.sequences.Sequence r0 = kotlin.io.TextStreamsKt.h(r2)     // Catch:{ all -> 0x0034 }
            java.lang.Object r4 = r4.f(r0)     // Catch:{ all -> 0x0034 }
            kotlin.jvm.internal.InlineMarker.d(r3)
            r0 = 0
            kotlin.io.CloseableKt.a(r2, r0)
            kotlin.jvm.internal.InlineMarker.c(r3)
            return r4
        L_0x0034:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r3)
            kotlin.io.CloseableKt.a(r2, r4)
            kotlin.jvm.internal.InlineMarker.c(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.C(java.io.File, java.nio.charset.Charset, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        kotlin.jvm.internal.InlineMarker.d(1);
        kotlin.io.CloseableKt.a(r1, r2);
        kotlin.jvm.internal.InlineMarker.c(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object D(java.io.File r1, java.nio.charset.Charset r2, kotlin.jvm.functions.Function1 r3, int r4, java.lang.Object r5) {
        /*
            r5 = 1
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0006
            java.nio.charset.Charset r2 = kotlin.text.Charsets.f29053b
        L_0x0006:
            java.io.InputStreamReader r4 = new java.io.InputStreamReader
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r1)
            r4.<init>(r0, r2)
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r4, r2)
            kotlin.sequences.Sequence r2 = kotlin.io.TextStreamsKt.h(r1)     // Catch:{ all -> 0x002a }
            java.lang.Object r2 = r3.f(r2)     // Catch:{ all -> 0x002a }
            kotlin.jvm.internal.InlineMarker.d(r5)
            r3 = 0
            kotlin.io.CloseableKt.a(r1, r3)
            kotlin.jvm.internal.InlineMarker.c(r5)
            return r2
        L_0x002a:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x002c }
        L_0x002c:
            r3 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r5)
            kotlin.io.CloseableKt.a(r1, r2)
            kotlin.jvm.internal.InlineMarker.c(r5)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.D(java.io.File, java.nio.charset.Charset, kotlin.jvm.functions.Function1, int, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        kotlin.io.CloseableKt.a(r0, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void E(@org.jetbrains.annotations.NotNull java.io.File r1, @org.jetbrains.annotations.NotNull byte[] r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r1, r0)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r1)
            r0.write(r2)     // Catch:{ all -> 0x0019 }
            kotlin.Unit r1 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0019 }
            r1 = 0
            kotlin.io.CloseableKt.a(r0, r1)
            return
        L_0x0019:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x001b }
        L_0x001b:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.E(java.io.File, byte[]):void");
    }

    public static final void F(@NotNull File file, @NotNull String str, @NotNull Charset charset) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(str, "text");
        Intrinsics.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.o(bytes, "this as java.lang.String).getBytes(charset)");
        E(file, bytes);
    }

    public static /* synthetic */ void G(File file, String str, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.f29053b;
        }
        F(file, str, charset);
    }

    @InlineOnly
    private static final OutputStreamWriter H(File file, Charset charset) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    static /* synthetic */ OutputStreamWriter I(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(file, "<this>");
        Intrinsics.p(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        kotlin.io.CloseableKt.a(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void g(@org.jetbrains.annotations.NotNull java.io.File r2, @org.jetbrains.annotations.NotNull byte[] r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r1 = 1
            r0.<init>(r2, r1)
            r0.write(r3)     // Catch:{ all -> 0x001a }
            kotlin.Unit r2 = kotlin.Unit.f28779a     // Catch:{ all -> 0x001a }
            r2 = 0
            kotlin.io.CloseableKt.a(r0, r2)
            return
        L_0x001a:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001c }
        L_0x001c:
            r3 = move-exception
            kotlin.io.CloseableKt.a(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.g(java.io.File, byte[]):void");
    }

    public static final void h(@NotNull File file, @NotNull String str, @NotNull Charset charset) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(str, "text");
        Intrinsics.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.o(bytes, "this as java.lang.String).getBytes(charset)");
        g(file, bytes);
    }

    public static /* synthetic */ void i(File file, String str, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.f29053b;
        }
        h(file, str, charset);
    }

    @InlineOnly
    private static final BufferedReader j(File file, Charset charset, int i2) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(charset, "charset");
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), i2);
    }

    static /* synthetic */ BufferedReader k(File file, Charset charset, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        Intrinsics.p(file, "<this>");
        Intrinsics.p(charset, "charset");
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), i2);
    }

    @InlineOnly
    private static final BufferedWriter l(File file, Charset charset, int i2) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), i2);
    }

    static /* synthetic */ BufferedWriter m(File file, Charset charset, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        Intrinsics.p(file, "<this>");
        Intrinsics.p(charset, "charset");
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        kotlin.io.CloseableKt.a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void n(@org.jetbrains.annotations.NotNull java.io.File r1, int r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super byte[], ? super java.lang.Integer, kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r1, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            r0 = 512(0x200, float:7.175E-43)
            int r2 = kotlin.ranges.RangesKt.u(r2, r0)
            byte[] r2 = new byte[r2]
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r1)
        L_0x0017:
            int r1 = r0.read(r2)     // Catch:{ all -> 0x0024 }
            if (r1 > 0) goto L_0x0026
            kotlin.Unit r1 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0024 }
            r1 = 0
            kotlin.io.CloseableKt.a(r0, r1)
            return
        L_0x0024:
            r1 = move-exception
            goto L_0x002e
        L_0x0026:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0024 }
            r3.d0(r2, r1)     // Catch:{ all -> 0x0024 }
            goto L_0x0017
        L_0x002e:
            throw r1     // Catch:{ all -> 0x002f }
        L_0x002f:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.n(java.io.File, int, kotlin.jvm.functions.Function2):void");
    }

    public static final void o(@NotNull File file, @NotNull Function2<? super byte[], ? super Integer, Unit> function2) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(function2, "action");
        n(file, 4096, function2);
    }

    public static final void p(@NotNull File file, @NotNull Charset charset, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(charset, "charset");
        Intrinsics.p(function1, "action");
        TextStreamsKt.g(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), function1);
    }

    public static /* synthetic */ void q(File file, Charset charset, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        p(file, charset, function1);
    }

    @InlineOnly
    private static final FileInputStream r(File file) {
        Intrinsics.p(file, "<this>");
        return new FileInputStream(file);
    }

    @InlineOnly
    private static final FileOutputStream s(File file) {
        Intrinsics.p(file, "<this>");
        return new FileOutputStream(file);
    }

    @InlineOnly
    private static final PrintWriter t(File file, Charset charset) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(charset, "charset");
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), 8192));
    }

    static /* synthetic */ PrintWriter u(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        Intrinsics.p(file, "<this>");
        Intrinsics.p(charset, "charset");
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), 8192));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a9, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00aa, code lost:
        kotlin.io.CloseableKt.a(r0, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ad, code lost:
        throw r1;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] v(@org.jetbrains.annotations.NotNull java.io.File r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r10, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r10)
            long r1 = r10.length()     // Catch:{ all -> 0x0028 }
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            java.lang.String r5 = "File "
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x0086
            int r2 = (int) r1
            byte[] r1 = new byte[r2]     // Catch:{ all -> 0x0028 }
            r3 = 0
            r4 = r2
            r6 = 0
        L_0x001d:
            if (r4 <= 0) goto L_0x002b
            int r7 = r0.read(r1, r6, r4)     // Catch:{ all -> 0x0028 }
            if (r7 < 0) goto L_0x002b
            int r4 = r4 - r7
            int r6 = r6 + r7
            goto L_0x001d
        L_0x0028:
            r10 = move-exception
            goto L_0x00a8
        L_0x002b:
            java.lang.String r7 = "copyOf(this, newSize)"
            r8 = 0
            if (r4 <= 0) goto L_0x0038
            byte[] r1 = java.util.Arrays.copyOf(r1, r6)     // Catch:{ all -> 0x0028 }
            kotlin.jvm.internal.Intrinsics.o(r1, r7)     // Catch:{ all -> 0x0028 }
            goto L_0x0068
        L_0x0038:
            int r4 = r0.read()     // Catch:{ all -> 0x0028 }
            r6 = -1
            if (r4 != r6) goto L_0x0040
            goto L_0x0068
        L_0x0040:
            kotlin.io.ExposingBufferByteArrayOutputStream r6 = new kotlin.io.ExposingBufferByteArrayOutputStream     // Catch:{ all -> 0x0028 }
            r9 = 8193(0x2001, float:1.1481E-41)
            r6.<init>(r9)     // Catch:{ all -> 0x0028 }
            r6.write(r4)     // Catch:{ all -> 0x0028 }
            r4 = 2
            kotlin.io.ByteStreamsKt.l(r0, r6, r3, r4, r8)     // Catch:{ all -> 0x0028 }
            int r4 = r6.size()     // Catch:{ all -> 0x0028 }
            int r4 = r4 + r2
            if (r4 < 0) goto L_0x006c
            byte[] r10 = r6.b()     // Catch:{ all -> 0x0028 }
            byte[] r1 = java.util.Arrays.copyOf(r1, r4)     // Catch:{ all -> 0x0028 }
            kotlin.jvm.internal.Intrinsics.o(r1, r7)     // Catch:{ all -> 0x0028 }
            int r4 = r6.size()     // Catch:{ all -> 0x0028 }
            byte[] r1 = kotlin.collections.ArraysKt.v0(r10, r1, r2, r3, r4)     // Catch:{ all -> 0x0028 }
        L_0x0068:
            kotlin.io.CloseableKt.a(r0, r8)
            return r1
        L_0x006c:
            java.lang.OutOfMemoryError r1 = new java.lang.OutOfMemoryError     // Catch:{ all -> 0x0028 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
            r2.<init>()     // Catch:{ all -> 0x0028 }
            r2.append(r5)     // Catch:{ all -> 0x0028 }
            r2.append(r10)     // Catch:{ all -> 0x0028 }
            java.lang.String r10 = " is too big to fit in memory."
            r2.append(r10)     // Catch:{ all -> 0x0028 }
            java.lang.String r10 = r2.toString()     // Catch:{ all -> 0x0028 }
            r1.<init>(r10)     // Catch:{ all -> 0x0028 }
            throw r1     // Catch:{ all -> 0x0028 }
        L_0x0086:
            java.lang.OutOfMemoryError r3 = new java.lang.OutOfMemoryError     // Catch:{ all -> 0x0028 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
            r4.<init>()     // Catch:{ all -> 0x0028 }
            r4.append(r5)     // Catch:{ all -> 0x0028 }
            r4.append(r10)     // Catch:{ all -> 0x0028 }
            java.lang.String r10 = " is too big ("
            r4.append(r10)     // Catch:{ all -> 0x0028 }
            r4.append(r1)     // Catch:{ all -> 0x0028 }
            java.lang.String r10 = " bytes) to fit in memory."
            r4.append(r10)     // Catch:{ all -> 0x0028 }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x0028 }
            r3.<init>(r10)     // Catch:{ all -> 0x0028 }
            throw r3     // Catch:{ all -> 0x0028 }
        L_0x00a8:
            throw r10     // Catch:{ all -> 0x00a9 }
        L_0x00a9:
            r1 = move-exception
            kotlin.io.CloseableKt.a(r0, r10)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.v(java.io.File):byte[]");
    }

    @NotNull
    public static final List<String> w(@NotNull File file, @NotNull Charset charset) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(charset, "charset");
        ArrayList arrayList = new ArrayList();
        p(file, charset, new FilesKt__FileReadWriteKt$readLines$1(arrayList));
        return arrayList;
    }

    public static /* synthetic */ List x(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        return w(file, charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        kotlin.io.CloseableKt.a(r0, r2);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String y(@org.jetbrains.annotations.NotNull java.io.File r2, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r2)
            r0.<init>(r1, r3)
            java.lang.String r2 = kotlin.io.TextStreamsKt.k(r0)     // Catch:{ all -> 0x001d }
            r3 = 0
            kotlin.io.CloseableKt.a(r0, r3)
            return r2
        L_0x001d:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001f }
        L_0x001f:
            r3 = move-exception
            kotlin.io.CloseableKt.a(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.y(java.io.File, java.nio.charset.Charset):java.lang.String");
    }

    public static /* synthetic */ String z(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        return y(file, charset);
    }
}
