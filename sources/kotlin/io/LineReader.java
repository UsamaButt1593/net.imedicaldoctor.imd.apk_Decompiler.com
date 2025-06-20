package kotlin.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\r\u0010\u001eR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00103\u001a\u00060/j\u0002`08\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00064"}, d2 = {"Lkotlin/io/LineReader;", "", "<init>", "()V", "", "endOfInput", "", "b", "(Z)I", "a", "()I", "nBytes", "nChars", "c", "(II)I", "Ljava/nio/charset/Charset;", "charset", "", "g", "(Ljava/nio/charset/Charset;)V", "e", "f", "Ljava/io/InputStream;", "inputStream", "", "d", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;", "I", "BUFFER_SIZE", "Ljava/nio/charset/CharsetDecoder;", "Ljava/nio/charset/CharsetDecoder;", "decoder", "Z", "directEOL", "", "[B", "bytes", "", "[C", "chars", "Ljava/nio/ByteBuffer;", "Ljava/nio/ByteBuffer;", "byteBuf", "Ljava/nio/CharBuffer;", "h", "Ljava/nio/CharBuffer;", "charBuf", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "i", "Ljava/lang/StringBuilder;", "sb", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nConsole.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Console.kt\nkotlin/io/LineReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,299:1\n1#2:300\n*E\n"})
public final class LineReader {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final LineReader f28844a = new LineReader();

    /* renamed from: b  reason: collision with root package name */
    private static final int f28845b = 32;

    /* renamed from: c  reason: collision with root package name */
    private static CharsetDecoder f28846c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f28847d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f28848e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final char[] f28849f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final ByteBuffer f28850g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final CharBuffer f28851h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final StringBuilder f28852i = new StringBuilder();

    static {
        byte[] bArr = new byte[32];
        f28848e = bArr;
        char[] cArr = new char[32];
        f28849f = cArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.o(wrap, "wrap(bytes)");
        f28850g = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(cArr);
        Intrinsics.o(wrap2, "wrap(chars)");
        f28851h = wrap2;
    }

    private LineReader() {
    }

    private final int a() {
        ByteBuffer byteBuffer = f28850g;
        byteBuffer.compact();
        int position = byteBuffer.position();
        byteBuffer.position(0);
        return position;
    }

    private final int b(boolean z) {
        while (true) {
            CharsetDecoder charsetDecoder = f28846c;
            if (charsetDecoder == null) {
                Intrinsics.S("decoder");
                charsetDecoder = null;
            }
            ByteBuffer byteBuffer = f28850g;
            CharBuffer charBuffer = f28851h;
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, z);
            Intrinsics.o(decode, "decoder.decode(byteBuf, charBuf, endOfInput)");
            if (decode.isError()) {
                e();
                decode.throwException();
            }
            int position = charBuffer.position();
            if (!decode.isOverflow()) {
                return position;
            }
            StringBuilder sb = f28852i;
            char[] cArr = f28849f;
            int i2 = position - 1;
            sb.append(cArr, 0, i2);
            charBuffer.position(0);
            charBuffer.limit(32);
            charBuffer.put(cArr[i2]);
        }
    }

    private final int c(int i2, int i3) {
        ByteBuffer byteBuffer = f28850g;
        byteBuffer.limit(i2);
        f28851h.position(i3);
        int b2 = b(true);
        CharsetDecoder charsetDecoder = f28846c;
        if (charsetDecoder == null) {
            Intrinsics.S("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuffer.position(0);
        return b2;
    }

    private final void e() {
        CharsetDecoder charsetDecoder = f28846c;
        if (charsetDecoder == null) {
            Intrinsics.S("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        f28850g.position(0);
        f28852i.setLength(0);
    }

    private final void f() {
        StringBuilder sb = f28852i;
        sb.setLength(32);
        sb.trimToSize();
    }

    private final void g(Charset charset) {
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.o(newDecoder, "charset.newDecoder()");
        f28846c = newDecoder;
        ByteBuffer byteBuffer = f28850g;
        byteBuffer.clear();
        CharBuffer charBuffer = f28851h;
        charBuffer.clear();
        byteBuffer.put((byte) 10);
        byteBuffer.flip();
        CharsetDecoder charsetDecoder = f28846c;
        if (charsetDecoder == null) {
            Intrinsics.S("decoder");
            charsetDecoder = null;
        }
        boolean z = false;
        charsetDecoder.decode(byteBuffer, charBuffer, false);
        if (charBuffer.position() == 1 && charBuffer.get(0) == 10) {
            z = true;
        }
        f28847d = z;
        e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.g(r0.charset(), r11) == false) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (f28852i.length() != 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r0 != 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r2 != 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r10 = c(r0, r2);
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String d(@org.jetbrains.annotations.NotNull java.io.InputStream r10, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = "inputStream"
            kotlin.jvm.internal.Intrinsics.p(r10, r0)     // Catch:{ all -> 0x0019 }
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.p(r11, r0)     // Catch:{ all -> 0x0019 }
            java.nio.charset.CharsetDecoder r0 = f28846c     // Catch:{ all -> 0x0019 }
            r1 = 0
            if (r0 == 0) goto L_0x0026
            if (r0 != 0) goto L_0x001c
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.S(r0)     // Catch:{ all -> 0x0019 }
            r0 = r1
            goto L_0x001c
        L_0x0019:
            r10 = move-exception
            goto L_0x00c5
        L_0x001c:
            java.nio.charset.Charset r0 = r0.charset()     // Catch:{ all -> 0x0019 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.g(r0, r11)     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x0029
        L_0x0026:
            r9.g(r11)     // Catch:{ all -> 0x0019 }
        L_0x0029:
            r11 = 0
            r0 = 0
            r2 = 0
        L_0x002c:
            int r3 = r10.read()     // Catch:{ all -> 0x0019 }
            r4 = 32
            r5 = -1
            r6 = 10
            if (r3 != r5) goto L_0x004a
            java.lang.StringBuilder r10 = f28852i     // Catch:{ all -> 0x0019 }
            int r10 = r10.length()     // Catch:{ all -> 0x0019 }
            if (r10 != 0) goto L_0x0045
            if (r0 != 0) goto L_0x0045
            if (r2 != 0) goto L_0x0045
            monitor-exit(r9)
            return r1
        L_0x0045:
            int r10 = r9.c(r0, r2)     // Catch:{ all -> 0x0019 }
            goto L_0x0078
        L_0x004a:
            byte[] r5 = f28848e     // Catch:{ all -> 0x0019 }
            int r7 = r0 + 1
            byte r8 = (byte) r3     // Catch:{ all -> 0x0019 }
            r5[r0] = r8     // Catch:{ all -> 0x0019 }
            if (r3 == r6) goto L_0x005c
            if (r7 == r4) goto L_0x005c
            boolean r0 = f28847d     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r0 = r7
            goto L_0x002c
        L_0x005c:
            java.nio.ByteBuffer r0 = f28850g     // Catch:{ all -> 0x0019 }
            r0.limit(r7)     // Catch:{ all -> 0x0019 }
            java.nio.CharBuffer r3 = f28851h     // Catch:{ all -> 0x0019 }
            r3.position(r2)     // Catch:{ all -> 0x0019 }
            int r2 = r9.b(r11)     // Catch:{ all -> 0x0019 }
            if (r2 <= 0) goto L_0x00bf
            char[] r3 = f28849f     // Catch:{ all -> 0x0019 }
            int r5 = r2 + -1
            char r3 = r3[r5]     // Catch:{ all -> 0x0019 }
            if (r3 != r6) goto L_0x00bf
            r0.position(r11)     // Catch:{ all -> 0x0019 }
            r10 = r2
        L_0x0078:
            if (r10 <= 0) goto L_0x0092
            char[] r0 = f28849f     // Catch:{ all -> 0x0019 }
            int r1 = r10 + -1
            char r1 = r0[r1]     // Catch:{ all -> 0x0019 }
            if (r1 != r6) goto L_0x0092
            int r1 = r10 + -1
            if (r1 <= 0) goto L_0x0091
            int r2 = r10 + -2
            char r0 = r0[r2]     // Catch:{ all -> 0x0019 }
            r2 = 13
            if (r0 != r2) goto L_0x0091
            int r10 = r10 + -2
            goto L_0x0092
        L_0x0091:
            r10 = r1
        L_0x0092:
            java.lang.StringBuilder r0 = f28852i     // Catch:{ all -> 0x0019 }
            int r1 = r0.length()     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x00a3
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0019 }
            char[] r1 = f28849f     // Catch:{ all -> 0x0019 }
            r0.<init>(r1, r11, r10)     // Catch:{ all -> 0x0019 }
            monitor-exit(r9)
            return r0
        L_0x00a3:
            char[] r1 = f28849f     // Catch:{ all -> 0x0019 }
            r0.append(r1, r11, r10)     // Catch:{ all -> 0x0019 }
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x0019 }
            java.lang.String r1 = "sb.toString()"
            kotlin.jvm.internal.Intrinsics.o(r10, r1)     // Catch:{ all -> 0x0019 }
            int r1 = r0.length()     // Catch:{ all -> 0x0019 }
            if (r1 <= r4) goto L_0x00ba
            r9.f()     // Catch:{ all -> 0x0019 }
        L_0x00ba:
            r0.setLength(r11)     // Catch:{ all -> 0x0019 }
            monitor-exit(r9)
            return r10
        L_0x00bf:
            int r0 = r9.a()     // Catch:{ all -> 0x0019 }
            goto L_0x002c
        L_0x00c5:
            monitor-exit(r9)     // Catch:{ all -> 0x0019 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.LineReader.d(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }
}
