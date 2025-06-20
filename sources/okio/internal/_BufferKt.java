package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.extractor.ts.PsExtractor;
import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.base.Ascii;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import net.lingala.zip4j.util.InternalZipConstants;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio._JvmPlatformKt;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\u001a7\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aA\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0011*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\f2\u001a\u0010\u0014\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\u0013H\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a%\u0010\u001a\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a,\u0010\u001f\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0014\u0010!\u001a\u00020\f*\u00020\u000bH\b¢\u0006\u0004\b!\u0010\"\u001a\u0014\u0010$\u001a\u00020#*\u00020\u000bH\b¢\u0006\u0004\b$\u0010%\u001a\u0014\u0010'\u001a\u00020&*\u00020\u000bH\b¢\u0006\u0004\b'\u0010(\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u000bH\b¢\u0006\u0004\b)\u0010*\u001a\u0014\u0010+\u001a\u00020\f*\u00020\u000bH\b¢\u0006\u0004\b+\u0010\"\u001a\u001c\u0010-\u001a\u00020#*\u00020\u000b2\u0006\u0010,\u001a\u00020\fH\b¢\u0006\u0004\b-\u0010.\u001a\u0014\u00100\u001a\u00020/*\u00020\u000bH\b¢\u0006\u0004\b0\u00101\u001a\u001c\u00102\u001a\u00020/*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\b2\u00103\u001a0\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u00105\u001a\u0002042\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u0002H\b¢\u0006\u0004\b6\u00107\u001a\u001c\u00109\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\b¢\u0006\u0004\b9\u0010:\u001a\u001c\u0010;\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\b¢\u0006\u0004\b;\u0010:\u001a\u001c\u0010=\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010<\u001a\u00020\u0002H\b¢\u0006\u0004\b=\u0010>\u001a\u001c\u0010\u0011\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0011\u0010@\u001a,\u0010A\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\b¢\u0006\u0004\bA\u0010B\u001a\u0014\u0010C\u001a\u00020\u0004*\u00020\u000bH\b¢\u0006\u0004\bC\u0010D\u001a\u001c\u00108\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\b8\u0010E\u001a\u001c\u0010G\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010F\u001a\u00020\u0004H\b¢\u0006\u0004\bG\u0010H\u001a\u001c\u0010I\u001a\u00020/*\u00020\u000b2\u0006\u0010F\u001a\u00020\u0004H\b¢\u0006\u0004\bI\u0010J\u001a,\u0010K\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\b¢\u0006\u0004\bK\u0010L\u001a\u0014\u0010M\u001a\u00020\f*\u00020\u000bH\b¢\u0006\u0004\bM\u0010\"\u001a\u0014\u0010N\u001a\u00020\f*\u00020\u000bH\b¢\u0006\u0004\bN\u0010\"\u001a\u0014\u0010O\u001a\u000204*\u00020\u000bH\b¢\u0006\u0004\bO\u0010P\u001a\u001c\u0010Q\u001a\u000204*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\bQ\u0010R\u001a\u001c\u0010S\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\b¢\u0006\u0004\bS\u0010T\u001a$\u0010U\u001a\u00020/*\u00020\u000b2\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\bU\u0010V\u001a\u001c\u0010X\u001a\u00020\f*\u00020\u000b2\u0006\u0010F\u001a\u00020WH\b¢\u0006\u0004\bX\u0010Y\u001a\u001c\u0010Z\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\bZ\u0010\u0010\u001a\u0016\u0010[\u001a\u0004\u0018\u00010\u000e*\u00020\u000bH\b¢\u0006\u0004\b[\u0010\\\u001a\u001c\u0010^\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010]\u001a\u00020\fH\b¢\u0006\u0004\b^\u0010\u0010\u001a\u0014\u0010_\u001a\u00020\u0002*\u00020\u000bH\b¢\u0006\u0004\b_\u0010*\u001a,\u0010c\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010`\u001a\u00020\u000e2\u0006\u0010a\u001a\u00020\u00022\u0006\u0010b\u001a\u00020\u0002H\b¢\u0006\u0004\bc\u0010d\u001a\u001c\u0010f\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010e\u001a\u00020\u0002H\b¢\u0006\u0004\bf\u0010g\u001a\u001c\u0010i\u001a\u00020\f*\u00020\u000b2\u0006\u0010?\u001a\u00020hH\b¢\u0006\u0004\bi\u0010j\u001a$\u0010k\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020h2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\bk\u0010l\u001a\u001c\u0010n\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010m\u001a\u00020\u0002H\b¢\u0006\u0004\bn\u0010g\u001a\u001c\u0010p\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010o\u001a\u00020\u0002H\b¢\u0006\u0004\bp\u0010g\u001a\u001c\u0010r\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010q\u001a\u00020\u0002H\b¢\u0006\u0004\br\u0010g\u001a\u001c\u0010s\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\b¢\u0006\u0004\bs\u0010:\u001a$\u0010t\u001a\u00020/*\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\bt\u0010V\u001a$\u0010u\u001a\u00020\f*\u00020\u000b2\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\bu\u0010v\u001a,\u0010x\u001a\u00020\f*\u00020\u000b2\u0006\u0010m\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010w\u001a\u00020\fH\b¢\u0006\u0004\bx\u0010y\u001a$\u0010z\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u0005\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\fH\b¢\u0006\u0004\bz\u0010{\u001a$\u0010}\u001a\u00020\f*\u00020\u000b2\u0006\u0010|\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\fH\b¢\u0006\u0004\b}\u0010{\u001a4\u0010~\u001a\u00020\b*\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0005\u001a\u0002042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\b¢\u0006\u0004\b~\u0010\u001a#\u0010\u0001\u001a\u00020\b*\u00020\u000b2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u0014\u0010q\u001a\u00020\u0002*\u00020\u000bH\b¢\u0006\u0004\bq\u0010*\u001a\u0017\u0010\u0001\u001a\u00020\u000b*\u00020\u000bH\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u0016\u0010\u0001\u001a\u000204*\u00020\u000bH\b¢\u0006\u0005\b\u0001\u0010P\u001a\u001f\u0010\u0001\u001a\u000204*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0002H\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a!\u0010\u0001\u001a\u00030\u0001*\u00020\u000b2\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u001f\u0010o\u001a\u00030\u0001*\u00020\u000b2\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0005\bo\u0010\u0001\u001a\u0018\u0010\u0001\u001a\u00020\u0002*\u00030\u0001H\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\u0002*\u00030\u00012\u0006\u0010\u001d\u001a\u00020\fH\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a!\u0010\u0001\u001a\u00020\f*\u00030\u00012\u0007\u0010\u0001\u001a\u00020\fH\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a!\u0010\u0001\u001a\u00020\f*\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0002H\b¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u0016\u0010m\u001a\u00020/*\u00030\u0001H\b¢\u0006\u0005\bm\u0010\u0001\"&\u0010\u0001\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0017\n\u0005\b0\u0010\u0001\u0012\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0015\u0010\u0001\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\bm\u0010[\"\u0015\u0010\u0001\u001a\u00020\f8\u0000XT¢\u0006\u0006\n\u0004\b!\u0010^\"\u0016\u0010 \u0001\u001a\u00020\f8\u0000XT¢\u0006\u0007\n\u0005\b\u0001\u0010^\u0002\u0007\n\u0005\b20\u0001¨\u0006¡\u0001"}, d2 = {"Lokio/Segment;", "segment", "", "segmentPos", "", "bytes", "bytesOffset", "bytesLimit", "", "i0", "(Lokio/Segment;I[BII)Z", "Lokio/Buffer;", "", "newline", "", "j0", "(Lokio/Buffer;J)Ljava/lang/String;", "T", "fromIndex", "Lkotlin/Function2;", "lambda", "k0", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lokio/Options;", "options", "selectTruncated", "l0", "(Lokio/Buffer;Lokio/Options;Z)I", "out", "offset", "byteCount", "e", "(Lokio/Buffer;Lokio/Buffer;JJ)Lokio/Buffer;", "c", "(Lokio/Buffer;)J", "", "t", "(Lokio/Buffer;)B", "", "E", "(Lokio/Buffer;)S", "C", "(Lokio/Buffer;)I", "D", "pos", "h", "(Lokio/Buffer;J)B", "", "a", "(Lokio/Buffer;)V", "N", "(Lokio/Buffer;J)V", "Lokio/ByteString;", "byteString", "R", "(Lokio/Buffer;Lokio/ByteString;II)Lokio/Buffer;", "v", "Z", "(Lokio/Buffer;J)Lokio/Buffer;", "a0", "minimumCapacity", "Q", "(Lokio/Buffer;I)Lokio/Segment;", "source", "(Lokio/Buffer;[B)Lokio/Buffer;", "U", "(Lokio/Buffer;[BII)Lokio/Buffer;", "u", "(Lokio/Buffer;)[B", "(Lokio/Buffer;J)[B", "sink", "o", "(Lokio/Buffer;[B)I", "A", "(Lokio/Buffer;[B)V", "p", "(Lokio/Buffer;[BII)I", "y", "B", "w", "(Lokio/Buffer;)Lokio/ByteString;", "x", "(Lokio/Buffer;J)Lokio/ByteString;", "M", "(Lokio/Buffer;Lokio/Options;)I", "z", "(Lokio/Buffer;Lokio/Buffer;J)V", "Lokio/Sink;", "r", "(Lokio/Buffer;Lokio/Sink;)J", "G", "I", "(Lokio/Buffer;)Ljava/lang/String;", "limit", "J", "H", "string", "beginIndex", "endIndex", "e0", "(Lokio/Buffer;Ljava/lang/String;II)Lokio/Buffer;", "codePoint", "f0", "(Lokio/Buffer;I)Lokio/Buffer;", "Lokio/Source;", "X", "(Lokio/Buffer;Lokio/Source;)J", "S", "(Lokio/Buffer;Lokio/Source;J)Lokio/Buffer;", "b", "Y", "s", "d0", "i", "b0", "c0", "V", "q", "(Lokio/Buffer;Lokio/Buffer;J)J", "toIndex", "j", "(Lokio/Buffer;BJJ)J", "k", "(Lokio/Buffer;Lokio/ByteString;J)J", "targetBytes", "l", "n", "(Lokio/Buffer;JLokio/ByteString;II)Z", "", "other", "f", "(Lokio/Buffer;Ljava/lang/Object;)Z", "d", "(Lokio/Buffer;)Lokio/Buffer;", "O", "P", "(Lokio/Buffer;I)Lokio/ByteString;", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "F", "(Lokio/Buffer;Lokio/Buffer$UnsafeCursor;)Lokio/Buffer$UnsafeCursor;", "m", "(Lokio/Buffer$UnsafeCursor;)I", "L", "(Lokio/Buffer$UnsafeCursor;J)I", "newSize", "K", "(Lokio/Buffer$UnsafeCursor;J)J", "minByteCount", "g", "(Lokio/Buffer$UnsafeCursor;I)J", "(Lokio/Buffer$UnsafeCursor;)V", "[B", "g0", "()[B", "h0", "()V", "HEX_DIGIT_BYTES", "SEGMENTING_THRESHOLD", "OVERFLOW_ZONE", "OVERFLOW_DIGIT_START", "okio"}, k = 2, mv = {1, 5, 1})
public final class _BufferKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f31450a = _JvmPlatformKt.a("0123456789abcdef");

    /* renamed from: b  reason: collision with root package name */
    public static final int f31451b = 4096;

    /* renamed from: c  reason: collision with root package name */
    public static final long f31452c = -922337203685477580L;

    /* renamed from: d  reason: collision with root package name */
    public static final long f31453d = -7;

    public static final void A(@NotNull Buffer buffer, @NotNull byte[] bArr) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(bArr, "sink");
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = buffer.read(bArr, i2, bArr.length - i2);
            if (read != -1) {
                i2 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0089 A[EDGE_INSN: B:44:0x0089->B:28:0x0089 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long B(@org.jetbrains.annotations.NotNull okio.Buffer r15) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r15, r0)
            long r0 = r15.L0()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00a7
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x0012:
            okio.Segment r6 = r15.s
            kotlin.jvm.internal.Intrinsics.m(r6)
            byte[] r7 = r6.f31382a
            int r8 = r6.f31383b
            int r9 = r6.f31384c
        L_0x001d:
            if (r8 >= r9) goto L_0x0089
            byte r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x002e
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x002e
            int r11 = r10 - r11
            goto L_0x0048
        L_0x002e:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x003d
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x003d
        L_0x0038:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L_0x0048
        L_0x003d:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0075
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0075
            goto L_0x0038
        L_0x0048:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x0058
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x001d
        L_0x0058:
            okio.Buffer r15 = new okio.Buffer
            r15.<init>()
            okio.Buffer r15 = r15.z1(r4)
            okio.Buffer r15 = r15.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Number too large: "
            java.lang.String r15 = r15.a2()
            java.lang.String r15 = kotlin.jvm.internal.Intrinsics.C(r1, r15)
            r0.<init>(r15)
            throw r0
        L_0x0075:
            if (r0 == 0) goto L_0x0079
            r1 = 1
            goto L_0x0089
        L_0x0079:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = okio._UtilKt.t(r10)
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.C(r0, r1)
            r15.<init>(r0)
            throw r15
        L_0x0089:
            if (r8 != r9) goto L_0x0095
            okio.Segment r7 = r6.b()
            r15.s = r7
            okio.SegmentPool.d(r6)
            goto L_0x0097
        L_0x0095:
            r6.f31383b = r8
        L_0x0097:
            if (r1 != 0) goto L_0x009d
            okio.Segment r6 = r15.s
            if (r6 != 0) goto L_0x0012
        L_0x009d:
            long r1 = r15.L0()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.C0(r1)
            return r4
        L_0x00a7:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.B(okio.Buffer):long");
    }

    public static final int C(@NotNull Buffer buffer) {
        Intrinsics.p(buffer, "<this>");
        if (buffer.L0() >= 4) {
            Segment segment = buffer.s;
            Intrinsics.m(segment);
            int i2 = segment.f31383b;
            int i3 = segment.f31384c;
            if (((long) (i3 - i2)) < 4) {
                return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << Ascii.B) | ((buffer.readByte() & 255) << 16) | ((buffer.readByte() & 255) << 8);
            }
            byte[] bArr = segment.f31382a;
            byte b2 = ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2] & 255) << Ascii.B);
            int i4 = i2 + 3;
            int i5 = i2 + 4;
            byte b3 = (bArr[i4] & 255) | b2 | ((bArr[i2 + 2] & 255) << 8);
            buffer.C0(buffer.L0() - 4);
            if (i5 == i3) {
                buffer.s = segment.b();
                SegmentPool.d(segment);
            } else {
                segment.f31383b = i5;
            }
            return b3;
        }
        throw new EOFException();
    }

    public static final long D(@NotNull Buffer buffer) {
        Intrinsics.p(buffer, "<this>");
        if (buffer.L0() >= 8) {
            Segment segment = buffer.s;
            Intrinsics.m(segment);
            int i2 = segment.f31383b;
            int i3 = segment.f31384c;
            if (((long) (i3 - i2)) < 8) {
                return ((((long) buffer.readInt()) & InternalZipConstants.f30717k) << 32) | (InternalZipConstants.f30717k & ((long) buffer.readInt()));
            }
            byte[] bArr = segment.f31382a;
            long j2 = ((((long) bArr[i2 + 3]) & 255) << 32) | ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i2 + 1]) & 255) << 48) | ((((long) bArr[i2 + 2]) & 255) << 40);
            int i4 = i2 + 7;
            int i5 = i2 + 8;
            long j3 = j2 | ((((long) bArr[i2 + 4]) & 255) << 24) | ((((long) bArr[i2 + 5]) & 255) << 16) | ((((long) bArr[i2 + 6]) & 255) << 8) | (((long) bArr[i4]) & 255);
            buffer.C0(buffer.L0() - 8);
            if (i5 == i3) {
                buffer.s = segment.b();
                SegmentPool.d(segment);
            } else {
                segment.f31383b = i5;
            }
            return j3;
        }
        throw new EOFException();
    }

    public static final short E(@NotNull Buffer buffer) {
        Intrinsics.p(buffer, "<this>");
        if (buffer.L0() >= 2) {
            Segment segment = buffer.s;
            Intrinsics.m(segment);
            int i2 = segment.f31383b;
            int i3 = segment.f31384c;
            if (i3 - i2 < 2) {
                return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
            }
            byte[] bArr = segment.f31382a;
            int i4 = i2 + 1;
            int i5 = i2 + 2;
            byte b2 = (bArr[i4] & 255) | ((bArr[i2] & 255) << 8);
            buffer.C0(buffer.L0() - 2);
            if (i5 == i3) {
                buffer.s = segment.b();
                SegmentPool.d(segment);
            } else {
                segment.f31383b = i5;
            }
            return (short) b2;
        }
        throw new EOFException();
    }

    @NotNull
    public static final Buffer.UnsafeCursor F(@NotNull Buffer buffer, @NotNull Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor m2 = _UtilKt.m(unsafeCursor);
        if (m2.s == null) {
            m2.s = buffer;
            m2.X = false;
            return m2;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    @NotNull
    public static final String G(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "<this>");
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (!(i2 >= 0 && j2 <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount: ", Long.valueOf(j2)).toString());
        } else if (buffer.L0() < j2) {
            throw new EOFException();
        } else if (i2 == 0) {
            return "";
        } else {
            Segment segment = buffer.s;
            Intrinsics.m(segment);
            int i3 = segment.f31383b;
            if (((long) i3) + j2 > ((long) segment.f31384c)) {
                return _Utf8Kt.c(buffer.U1(j2), 0, 0, 3, (Object) null);
            }
            int i4 = (int) j2;
            String b2 = _Utf8Kt.b(segment.f31382a, i3, i3 + i4);
            segment.f31383b += i4;
            buffer.C0(buffer.L0() - j2);
            if (segment.f31383b == segment.f31384c) {
                buffer.s = segment.b();
                SegmentPool.d(segment);
            }
            return b2;
        }
    }

    public static final int H(@NotNull Buffer buffer) {
        byte b2;
        int i2;
        byte b3;
        Intrinsics.p(buffer, "<this>");
        if (buffer.L0() != 0) {
            byte y = buffer.y(0);
            int i3 = 1;
            if ((y & 128) == 0) {
                b3 = y & Byte.MAX_VALUE;
                i2 = 1;
                b2 = 0;
            } else if ((y & 224) == 192) {
                b3 = y & Ascii.I;
                i2 = 2;
                b2 = 128;
            } else if ((y & 240) == 224) {
                b3 = y & 15;
                i2 = 3;
                b2 = 2048;
            } else if ((y & 248) == 240) {
                b3 = y & 7;
                i2 = 4;
                b2 = 65536;
            } else {
                buffer.skip(1);
                return Utf8.f31406c;
            }
            long j2 = (long) i2;
            if (buffer.L0() >= j2) {
                if (1 < i2) {
                    while (true) {
                        int i4 = i3 + 1;
                        long j3 = (long) i3;
                        byte y2 = buffer.y(j3);
                        if ((y2 & 192) == 128) {
                            b3 = (b3 << 6) | (y2 & Utf8.f31404a);
                            if (i4 >= i2) {
                                break;
                            }
                            i3 = i4;
                        } else {
                            buffer.skip(j3);
                            return Utf8.f31406c;
                        }
                    }
                }
                buffer.skip(j2);
                if (b3 > 1114111) {
                    return Utf8.f31406c;
                }
                return ((55296 > b3 || b3 > 57343) && b3 >= b2) ? b3 : Utf8.f31406c;
            }
            throw new EOFException("size < " + i2 + ": " + buffer.L0() + " (to read code point prefixed 0x" + _UtilKt.t(y) + ASCIIPropertyListParser.f18650h);
        }
        throw new EOFException();
    }

    @Nullable
    public static final String I(@NotNull Buffer buffer) {
        Intrinsics.p(buffer, "<this>");
        long N2 = buffer.N2((byte) 10);
        if (N2 != -1) {
            return j0(buffer, N2);
        }
        if (buffer.L0() != 0) {
            return buffer.B(buffer.L0());
        }
        return null;
    }

    @NotNull
    public static final String J(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "<this>");
        if (j2 >= 0) {
            long j3 = Long.MAX_VALUE;
            if (j2 != Long.MAX_VALUE) {
                j3 = j2 + 1;
            }
            byte b2 = (byte) 10;
            long y0 = buffer.y0(b2, 0, j3);
            if (y0 != -1) {
                return j0(buffer, y0);
            }
            if (j3 < buffer.L0() && buffer.y(j3 - 1) == ((byte) 13) && buffer.y(j3) == b2) {
                return j0(buffer, j3);
            }
            Buffer buffer2 = new Buffer();
            buffer.r(buffer2, 0, Math.min((long) 32, buffer.L0()));
            throw new EOFException("\\n not found: limit=" + Math.min(buffer.L0(), j2) + " content=" + buffer2.A1().w() + Typography.F);
        }
        throw new IllegalArgumentException(Intrinsics.C("limit < 0: ", Long.valueOf(j2)).toString());
    }

    public static final long K(@NotNull Buffer.UnsafeCursor unsafeCursor, long j2) {
        Buffer.UnsafeCursor unsafeCursor2 = unsafeCursor;
        long j3 = j2;
        Intrinsics.p(unsafeCursor2, "<this>");
        Buffer buffer = unsafeCursor2.s;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        } else if (unsafeCursor2.X) {
            long L0 = buffer.L0();
            int i2 = 1;
            int i3 = (j3 > L0 ? 1 : (j3 == L0 ? 0 : -1));
            if (i3 <= 0) {
                if (j3 >= 0) {
                    long j4 = L0 - j3;
                    while (true) {
                        if (j4 <= 0) {
                            break;
                        }
                        Segment segment = buffer.s;
                        Intrinsics.m(segment);
                        Segment segment2 = segment.f31388g;
                        Intrinsics.m(segment2);
                        int i4 = segment2.f31384c;
                        long j5 = (long) (i4 - segment2.f31383b);
                        if (j5 > j4) {
                            segment2.f31384c = i4 - ((int) j4);
                            break;
                        }
                        buffer.s = segment2.b();
                        SegmentPool.d(segment2);
                        j4 -= j5;
                    }
                    unsafeCursor2.h((Segment) null);
                    unsafeCursor2.Z = j3;
                    unsafeCursor2.X2 = null;
                    unsafeCursor2.Y2 = -1;
                    unsafeCursor2.Z2 = -1;
                } else {
                    throw new IllegalArgumentException(Intrinsics.C("newSize < 0: ", Long.valueOf(j2)).toString());
                }
            } else if (i3 > 0) {
                long j6 = j3 - L0;
                boolean z = true;
                while (j6 > 0) {
                    Segment Y0 = buffer.Y0(i2);
                    int min = (int) Math.min(j6, (long) (8192 - Y0.f31384c));
                    Y0.f31384c += min;
                    j6 -= (long) min;
                    if (z) {
                        unsafeCursor2.h(Y0);
                        unsafeCursor2.Z = L0;
                        unsafeCursor2.X2 = Y0.f31382a;
                        int i5 = Y0.f31384c;
                        unsafeCursor2.Y2 = i5 - min;
                        unsafeCursor2.Z2 = i5;
                        i2 = 1;
                        z = false;
                    } else {
                        i2 = 1;
                    }
                }
            }
            buffer.C0(j3);
            return L0;
        } else {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
    }

    public static final int L(@NotNull Buffer.UnsafeCursor unsafeCursor, long j2) {
        Segment segment;
        Intrinsics.p(unsafeCursor, "<this>");
        Buffer buffer = unsafeCursor.s;
        if (buffer != null) {
            int i2 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
            if (i2 < 0 || j2 > buffer.L0()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j2 + " > size=" + buffer.L0());
            } else if (i2 == 0 || j2 == buffer.L0()) {
                unsafeCursor.h((Segment) null);
                unsafeCursor.Z = j2;
                unsafeCursor.X2 = null;
                unsafeCursor.Y2 = -1;
                unsafeCursor.Z2 = -1;
                return -1;
            } else {
                long L0 = buffer.L0();
                Segment segment2 = buffer.s;
                long j3 = 0;
                if (unsafeCursor.c() != null) {
                    long j4 = unsafeCursor.Z;
                    int i3 = unsafeCursor.Y2;
                    Segment c2 = unsafeCursor.c();
                    Intrinsics.m(c2);
                    long j5 = j4 - ((long) (i3 - c2.f31383b));
                    if (j5 > j2) {
                        segment = segment2;
                        segment2 = unsafeCursor.c();
                        L0 = j5;
                    } else {
                        segment = unsafeCursor.c();
                        j3 = j5;
                    }
                } else {
                    segment = segment2;
                }
                if (L0 - j2 > j2 - j3) {
                    while (true) {
                        Intrinsics.m(segment);
                        int i4 = segment.f31384c;
                        int i5 = segment.f31383b;
                        if (j2 < ((long) (i4 - i5)) + j3) {
                            break;
                        }
                        j3 += (long) (i4 - i5);
                        segment = segment.f31387f;
                    }
                } else {
                    while (L0 > j2) {
                        Intrinsics.m(segment2);
                        segment2 = segment2.f31388g;
                        Intrinsics.m(segment2);
                        L0 -= (long) (segment2.f31384c - segment2.f31383b);
                    }
                    j3 = L0;
                    segment = segment2;
                }
                if (unsafeCursor.X) {
                    Intrinsics.m(segment);
                    if (segment.f31385d) {
                        Segment f2 = segment.f();
                        if (buffer.s == segment) {
                            buffer.s = f2;
                        }
                        segment = segment.c(f2);
                        Segment segment3 = segment.f31388g;
                        Intrinsics.m(segment3);
                        segment3.b();
                    }
                }
                unsafeCursor.h(segment);
                unsafeCursor.Z = j2;
                Intrinsics.m(segment);
                unsafeCursor.X2 = segment.f31382a;
                int i6 = segment.f31383b + ((int) (j2 - j3));
                unsafeCursor.Y2 = i6;
                int i7 = segment.f31384c;
                unsafeCursor.Z2 = i7;
                return i7 - i6;
            }
        } else {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    public static final int M(@NotNull Buffer buffer, @NotNull Options options) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(options, "options");
        int m0 = m0(buffer, options, false, 2, (Object) null);
        if (m0 == -1) {
            return -1;
        }
        buffer.skip((long) options.g()[m0].m0());
        return m0;
    }

    public static final void N(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "<this>");
        while (j2 > 0) {
            Segment segment = buffer.s;
            if (segment != null) {
                int min = (int) Math.min(j2, (long) (segment.f31384c - segment.f31383b));
                long j3 = (long) min;
                buffer.C0(buffer.L0() - j3);
                j2 -= j3;
                int i2 = segment.f31383b + min;
                segment.f31383b = i2;
                if (i2 == segment.f31384c) {
                    buffer.s = segment.b();
                    SegmentPool.d(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @NotNull
    public static final ByteString O(@NotNull Buffer buffer) {
        Intrinsics.p(buffer, "<this>");
        if (buffer.L0() <= 2147483647L) {
            return buffer.S0((int) buffer.L0());
        }
        throw new IllegalStateException(Intrinsics.C("size > Int.MAX_VALUE: ", Long.valueOf(buffer.L0())).toString());
    }

    @NotNull
    public static final ByteString P(@NotNull Buffer buffer, int i2) {
        Intrinsics.p(buffer, "<this>");
        if (i2 == 0) {
            return ByteString.Y2;
        }
        _UtilKt.e(buffer.L0(), 0, (long) i2);
        Segment segment = buffer.s;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Intrinsics.m(segment);
            int i6 = segment.f31384c;
            int i7 = segment.f31383b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                segment = segment.f31387f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i5][];
        int[] iArr = new int[(i5 * 2)];
        Segment segment2 = buffer.s;
        int i8 = 0;
        while (i3 < i2) {
            Intrinsics.m(segment2);
            bArr[i8] = segment2.f31382a;
            i3 += segment2.f31384c - segment2.f31383b;
            iArr[i8] = Math.min(i3, i2);
            iArr[i8 + i5] = segment2.f31383b;
            segment2.f31385d = true;
            i8++;
            segment2 = segment2.f31387f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public static final Segment Q(@NotNull Buffer buffer, int i2) {
        Intrinsics.p(buffer, "<this>");
        boolean z = true;
        if (i2 < 1 || i2 > 8192) {
            z = false;
        }
        if (z) {
            Segment segment = buffer.s;
            if (segment == null) {
                Segment e2 = SegmentPool.e();
                buffer.s = e2;
                e2.f31388g = e2;
                e2.f31387f = e2;
                return e2;
            }
            Intrinsics.m(segment);
            Segment segment2 = segment.f31388g;
            Intrinsics.m(segment2);
            return (segment2.f31384c + i2 > 8192 || !segment2.f31386e) ? segment2.c(SegmentPool.e()) : segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @NotNull
    public static final Buffer R(@NotNull Buffer buffer, @NotNull ByteString byteString, int i2, int i3) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(byteString, "byteString");
        byteString.K0(buffer, i2, i3);
        return buffer;
    }

    @NotNull
    public static final Buffer S(@NotNull Buffer buffer, @NotNull Source source, long j2) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(source, "source");
        while (j2 > 0) {
            long n2 = source.n2(buffer, j2);
            if (n2 != -1) {
                j2 -= n2;
            } else {
                throw new EOFException();
            }
        }
        return buffer;
    }

    @NotNull
    public static final Buffer T(@NotNull Buffer buffer, @NotNull byte[] bArr) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(bArr, "source");
        return buffer.write(bArr, 0, bArr.length);
    }

    @NotNull
    public static final Buffer U(@NotNull Buffer buffer, @NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(bArr, "source");
        long j2 = (long) i3;
        _UtilKt.e((long) bArr.length, (long) i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            Segment Y0 = buffer.Y0(1);
            int min = Math.min(i4 - i2, 8192 - Y0.f31384c);
            int i5 = i2 + min;
            ArraysKt.v0(bArr, Y0.f31382a, Y0.f31384c, i2, i5);
            Y0.f31384c += min;
            i2 = i5;
        }
        buffer.C0(buffer.L0() + j2);
        return buffer;
    }

    public static final void V(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j2) {
        Segment segment;
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(buffer2, "source");
        if (buffer2 != buffer) {
            _UtilKt.e(buffer2.L0(), 0, j2);
            while (j2 > 0) {
                Segment segment2 = buffer2.s;
                Intrinsics.m(segment2);
                int i2 = segment2.f31384c;
                Segment segment3 = buffer2.s;
                Intrinsics.m(segment3);
                if (j2 < ((long) (i2 - segment3.f31383b))) {
                    Segment segment4 = buffer.s;
                    if (segment4 != null) {
                        Intrinsics.m(segment4);
                        segment = segment4.f31388g;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.f31386e) {
                        if ((((long) segment.f31384c) + j2) - ((long) (segment.f31385d ? 0 : segment.f31383b)) <= PlaybackStateCompat.s3) {
                            Segment segment5 = buffer2.s;
                            Intrinsics.m(segment5);
                            segment5.g(segment, (int) j2);
                            buffer2.C0(buffer2.L0() - j2);
                            buffer.C0(buffer.L0() + j2);
                            return;
                        }
                    }
                    Segment segment6 = buffer2.s;
                    Intrinsics.m(segment6);
                    buffer2.s = segment6.e((int) j2);
                }
                Segment segment7 = buffer2.s;
                Intrinsics.m(segment7);
                long j3 = (long) (segment7.f31384c - segment7.f31383b);
                buffer2.s = segment7.b();
                Segment segment8 = buffer.s;
                if (segment8 == null) {
                    buffer.s = segment7;
                    segment7.f31388g = segment7;
                    segment7.f31387f = segment7;
                } else {
                    Intrinsics.m(segment8);
                    Segment segment9 = segment8.f31388g;
                    Intrinsics.m(segment9);
                    segment9.c(segment7).a();
                }
                buffer2.C0(buffer2.L0() - j3);
                buffer.C0(buffer.L0() + j3);
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static /* synthetic */ Buffer W(Buffer buffer, ByteString byteString, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = byteString.m0();
        }
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(byteString, "byteString");
        byteString.K0(buffer, i2, i3);
        return buffer;
    }

    public static final long X(@NotNull Buffer buffer, @NotNull Source source) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(source, "source");
        long j2 = 0;
        while (true) {
            long n2 = source.n2(buffer, PlaybackStateCompat.s3);
            if (n2 == -1) {
                return j2;
            }
            j2 += n2;
        }
    }

    @NotNull
    public static final Buffer Y(@NotNull Buffer buffer, int i2) {
        Intrinsics.p(buffer, "<this>");
        Segment Y0 = buffer.Y0(1);
        byte[] bArr = Y0.f31382a;
        int i3 = Y0.f31384c;
        Y0.f31384c = i3 + 1;
        bArr[i3] = (byte) i2;
        buffer.C0(buffer.L0() + 1);
        return buffer;
    }

    @NotNull
    public static final Buffer Z(@NotNull Buffer buffer, long j2) {
        boolean z;
        Intrinsics.p(buffer, "<this>");
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 == 0) {
            return buffer.writeByte(48);
        }
        int i3 = 1;
        if (i2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return buffer.W0("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j2 >= 100000000) {
            i3 = j2 < MediaPeriodQueue.o ? j2 < 10000000000L ? j2 < C.f9093k ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i3 = j2 < 1000000 ? j2 < SilenceSkippingAudioProcessor.A ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i3 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i3 = 2;
        }
        if (z) {
            i3++;
        }
        Segment Y0 = buffer.Y0(i3);
        byte[] bArr = Y0.f31382a;
        int i4 = Y0.f31384c + i3;
        while (j2 != 0) {
            long j3 = (long) 10;
            i4--;
            bArr[i4] = g0()[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z) {
            bArr[i4 - 1] = (byte) 45;
        }
        Y0.f31384c += i3;
        buffer.C0(buffer.L0() + ((long) i3));
        return buffer;
    }

    public static final void a(@NotNull Buffer buffer) {
        Intrinsics.p(buffer, "<this>");
        buffer.skip(buffer.L0());
    }

    @NotNull
    public static final Buffer a0(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "<this>");
        if (j2 == 0) {
            return buffer.writeByte(48);
        }
        long j3 = (j2 >>> 1) | j2;
        long j4 = j3 | (j3 >>> 2);
        long j5 = j4 | (j4 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i2 = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment Y0 = buffer.Y0(i2);
        byte[] bArr = Y0.f31382a;
        int i3 = Y0.f31384c;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            bArr[i4] = g0()[(int) (15 & j2)];
            j2 >>>= 4;
        }
        Y0.f31384c += i2;
        buffer.C0(buffer.L0() + ((long) i2));
        return buffer;
    }

    public static final void b(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.p(unsafeCursor, "<this>");
        if (unsafeCursor.s != null) {
            unsafeCursor.s = null;
            unsafeCursor.h((Segment) null);
            unsafeCursor.Z = -1;
            unsafeCursor.X2 = null;
            unsafeCursor.Y2 = -1;
            unsafeCursor.Z2 = -1;
            return;
        }
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    @NotNull
    public static final Buffer b0(@NotNull Buffer buffer, int i2) {
        Intrinsics.p(buffer, "<this>");
        Segment Y0 = buffer.Y0(4);
        byte[] bArr = Y0.f31382a;
        int i3 = Y0.f31384c;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >>> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
        Y0.f31384c = i3 + 4;
        buffer.C0(buffer.L0() + 4);
        return buffer;
    }

    public static final long c(@NotNull Buffer buffer) {
        Intrinsics.p(buffer, "<this>");
        long L0 = buffer.L0();
        if (L0 == 0) {
            return 0;
        }
        Segment segment = buffer.s;
        Intrinsics.m(segment);
        Segment segment2 = segment.f31388g;
        Intrinsics.m(segment2);
        int i2 = segment2.f31384c;
        return (i2 >= 8192 || !segment2.f31386e) ? L0 : L0 - ((long) (i2 - segment2.f31383b));
    }

    @NotNull
    public static final Buffer c0(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "<this>");
        Segment Y0 = buffer.Y0(8);
        byte[] bArr = Y0.f31382a;
        int i2 = Y0.f31384c;
        bArr[i2] = (byte) ((int) ((j2 >>> 56) & 255));
        bArr[i2 + 1] = (byte) ((int) ((j2 >>> 48) & 255));
        bArr[i2 + 2] = (byte) ((int) ((j2 >>> 40) & 255));
        bArr[i2 + 3] = (byte) ((int) ((j2 >>> 32) & 255));
        bArr[i2 + 4] = (byte) ((int) ((j2 >>> 24) & 255));
        bArr[i2 + 5] = (byte) ((int) ((j2 >>> 16) & 255));
        bArr[i2 + 6] = (byte) ((int) ((j2 >>> 8) & 255));
        bArr[i2 + 7] = (byte) ((int) (j2 & 255));
        Y0.f31384c = i2 + 8;
        buffer.C0(buffer.L0() + 8);
        return buffer;
    }

    @NotNull
    public static final Buffer d(@NotNull Buffer buffer) {
        Intrinsics.p(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        if (buffer.L0() == 0) {
            return buffer2;
        }
        Segment segment = buffer.s;
        Intrinsics.m(segment);
        Segment d2 = segment.d();
        buffer2.s = d2;
        d2.f31388g = d2;
        d2.f31387f = d2;
        for (Segment segment2 = segment.f31387f; segment2 != segment; segment2 = segment2.f31387f) {
            Segment segment3 = d2.f31388g;
            Intrinsics.m(segment3);
            Intrinsics.m(segment2);
            segment3.c(segment2.d());
        }
        buffer2.C0(buffer.L0());
        return buffer2;
    }

    @NotNull
    public static final Buffer d0(@NotNull Buffer buffer, int i2) {
        Intrinsics.p(buffer, "<this>");
        Segment Y0 = buffer.Y0(2);
        byte[] bArr = Y0.f31382a;
        int i3 = Y0.f31384c;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 1] = (byte) (i2 & 255);
        Y0.f31384c = i3 + 2;
        buffer.C0(buffer.L0() + 2);
        return buffer;
    }

    @NotNull
    public static final Buffer e(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j2, long j3) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(buffer2, "out");
        _UtilKt.e(buffer.L0(), j2, j3);
        if (j3 == 0) {
            return buffer;
        }
        buffer2.C0(buffer2.L0() + j3);
        Segment segment = buffer.s;
        while (true) {
            Intrinsics.m(segment);
            int i2 = segment.f31384c;
            int i3 = segment.f31383b;
            if (j2 < ((long) (i2 - i3))) {
                break;
            }
            j2 -= (long) (i2 - i3);
            segment = segment.f31387f;
        }
        while (j3 > 0) {
            Intrinsics.m(segment);
            Segment d2 = segment.d();
            int i4 = d2.f31383b + ((int) j2);
            d2.f31383b = i4;
            d2.f31384c = Math.min(i4 + ((int) j3), d2.f31384c);
            Segment segment2 = buffer2.s;
            if (segment2 == null) {
                d2.f31388g = d2;
                d2.f31387f = d2;
                buffer2.s = d2;
            } else {
                Intrinsics.m(segment2);
                Segment segment3 = segment2.f31388g;
                Intrinsics.m(segment3);
                segment3.c(d2);
            }
            j3 -= (long) (d2.f31384c - d2.f31383b);
            segment = segment.f31387f;
            j2 = 0;
        }
        return buffer;
    }

    @NotNull
    public static final Buffer e0(@NotNull Buffer buffer, @NotNull String str, int i2, int i3) {
        long L0;
        long j2;
        char charAt;
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        if (i2 >= 0) {
            if (i3 >= i2) {
                if (i3 <= str.length()) {
                    while (i2 < i3) {
                        char charAt2 = str.charAt(i2);
                        if (charAt2 < 128) {
                            Segment Y0 = buffer.Y0(1);
                            byte[] bArr = Y0.f31382a;
                            int i4 = Y0.f31384c - i2;
                            int min = Math.min(i3, 8192 - i4);
                            int i5 = i2 + 1;
                            bArr[i2 + i4] = (byte) charAt2;
                            while (true) {
                                i2 = i5;
                                if (i2 >= min || (charAt = str.charAt(i2)) >= 128) {
                                    int i6 = Y0.f31384c;
                                    int i7 = (i4 + i2) - i6;
                                    Y0.f31384c = i6 + i7;
                                    buffer.C0(buffer.L0() + ((long) i7));
                                } else {
                                    i5 = i2 + 1;
                                    bArr[i2 + i4] = (byte) charAt;
                                }
                            }
                            int i62 = Y0.f31384c;
                            int i72 = (i4 + i2) - i62;
                            Y0.f31384c = i62 + i72;
                            buffer.C0(buffer.L0() + ((long) i72));
                        } else {
                            if (charAt2 < 2048) {
                                Segment Y02 = buffer.Y0(2);
                                byte[] bArr2 = Y02.f31382a;
                                int i8 = Y02.f31384c;
                                bArr2[i8] = (byte) ((charAt2 >> 6) | PsExtractor.x);
                                bArr2[i8 + 1] = (byte) ((charAt2 & '?') | 128);
                                Y02.f31384c = i8 + 2;
                                L0 = buffer.L0();
                                j2 = 2;
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                Segment Y03 = buffer.Y0(3);
                                byte[] bArr3 = Y03.f31382a;
                                int i9 = Y03.f31384c;
                                bArr3[i9] = (byte) ((charAt2 >> 12) | 224);
                                bArr3[i9 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr3[i9 + 2] = (byte) ((charAt2 & '?') | 128);
                                Y03.f31384c = i9 + 3;
                                L0 = buffer.L0();
                                j2 = 3;
                            } else {
                                int i10 = i2 + 1;
                                char charAt3 = i10 < i3 ? str.charAt(i10) : 0;
                                if (charAt2 > 56319 || 56320 > charAt3 || charAt3 > 57343) {
                                    buffer.writeByte(63);
                                    i2 = i10;
                                } else {
                                    int i11 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 0;
                                    Segment Y04 = buffer.Y0(4);
                                    byte[] bArr4 = Y04.f31382a;
                                    int i12 = Y04.f31384c;
                                    bArr4[i12] = (byte) ((i11 >> 18) | PsExtractor.A);
                                    bArr4[i12 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                                    bArr4[i12 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                                    bArr4[i12 + 3] = (byte) ((i11 & 63) | 128);
                                    Y04.f31384c = i12 + 4;
                                    buffer.C0(buffer.L0() + 4);
                                    i2 += 2;
                                }
                            }
                            buffer.C0(L0 + j2);
                            i2++;
                        }
                    }
                    return buffer;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
        }
        throw new IllegalArgumentException(Intrinsics.C("beginIndex < 0: ", Integer.valueOf(i2)).toString());
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean f(@org.jetbrains.annotations.NotNull okio.Buffer r18, @org.jetbrains.annotations.Nullable java.lang.Object r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r0, r2)
            r2 = 1
            if (r0 != r1) goto L_0x000d
            return r2
        L_0x000d:
            boolean r3 = r1 instanceof okio.Buffer
            r4 = 0
            if (r3 != 0) goto L_0x0013
            return r4
        L_0x0013:
            long r5 = r18.L0()
            okio.Buffer r1 = (okio.Buffer) r1
            long r7 = r1.L0()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0022
            return r4
        L_0x0022:
            long r5 = r18.L0()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x002d
            return r2
        L_0x002d:
            okio.Segment r3 = r0.s
            kotlin.jvm.internal.Intrinsics.m(r3)
            okio.Segment r1 = r1.s
            kotlin.jvm.internal.Intrinsics.m(r1)
            int r5 = r3.f31383b
            int r6 = r1.f31383b
            r9 = r7
        L_0x003c:
            long r11 = r18.L0()
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x008c
            int r11 = r3.f31384c
            int r11 = r11 - r5
            int r12 = r1.f31384c
            int r12 = r12 - r6
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0074
            r13 = r7
        L_0x0054:
            r15 = 1
            long r13 = r13 + r15
            byte[] r15 = r3.f31382a
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.f31382a
            int r17 = r6 + 1
            byte r6 = r15[r6]
            if (r5 == r6) goto L_0x0066
            return r4
        L_0x0066:
            int r5 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r5 < 0) goto L_0x006f
            r5 = r16
            r6 = r17
            goto L_0x0074
        L_0x006f:
            r5 = r16
            r6 = r17
            goto L_0x0054
        L_0x0074:
            int r13 = r3.f31384c
            if (r5 != r13) goto L_0x007f
            okio.Segment r3 = r3.f31387f
            kotlin.jvm.internal.Intrinsics.m(r3)
            int r5 = r3.f31383b
        L_0x007f:
            int r13 = r1.f31384c
            if (r6 != r13) goto L_0x008a
            okio.Segment r1 = r1.f31387f
            kotlin.jvm.internal.Intrinsics.m(r1)
            int r6 = r1.f31383b
        L_0x008a:
            long r9 = r9 + r11
            goto L_0x003c
        L_0x008c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.f(okio.Buffer, java.lang.Object):boolean");
    }

    @NotNull
    public static final Buffer f0(@NotNull Buffer buffer, int i2) {
        long L0;
        long j2;
        Intrinsics.p(buffer, "<this>");
        if (i2 < 128) {
            buffer.writeByte(i2);
        } else {
            if (i2 < 2048) {
                Segment Y0 = buffer.Y0(2);
                byte[] bArr = Y0.f31382a;
                int i3 = Y0.f31384c;
                bArr[i3] = (byte) ((i2 >> 6) | PsExtractor.x);
                bArr[i3 + 1] = (byte) ((i2 & 63) | 128);
                Y0.f31384c = i3 + 2;
                L0 = buffer.L0();
                j2 = 2;
            } else if (55296 <= i2 && i2 <= 57343) {
                buffer.writeByte(63);
            } else if (i2 < 65536) {
                Segment Y02 = buffer.Y0(3);
                byte[] bArr2 = Y02.f31382a;
                int i4 = Y02.f31384c;
                bArr2[i4] = (byte) ((i2 >> 12) | 224);
                bArr2[i4 + 1] = (byte) (((i2 >> 6) & 63) | 128);
                bArr2[i4 + 2] = (byte) ((i2 & 63) | 128);
                Y02.f31384c = i4 + 3;
                L0 = buffer.L0();
                j2 = 3;
            } else if (i2 <= 1114111) {
                Segment Y03 = buffer.Y0(4);
                byte[] bArr3 = Y03.f31382a;
                int i5 = Y03.f31384c;
                bArr3[i5] = (byte) ((i2 >> 18) | PsExtractor.A);
                bArr3[i5 + 1] = (byte) (((i2 >> 12) & 63) | 128);
                bArr3[i5 + 2] = (byte) (((i2 >> 6) & 63) | 128);
                bArr3[i5 + 3] = (byte) ((i2 & 63) | 128);
                Y03.f31384c = i5 + 4;
                L0 = buffer.L0();
                j2 = 4;
            } else {
                throw new IllegalArgumentException(Intrinsics.C("Unexpected code point: 0x", _UtilKt.u(i2)));
            }
            buffer.C0(L0 + j2);
        }
        return buffer;
    }

    public static final long g(@NotNull Buffer.UnsafeCursor unsafeCursor, int i2) {
        Intrinsics.p(unsafeCursor, "<this>");
        boolean z = false;
        if (i2 > 0) {
            if (i2 <= 8192) {
                z = true;
            }
            if (z) {
                Buffer buffer = unsafeCursor.s;
                if (buffer == null) {
                    throw new IllegalStateException("not attached to a buffer".toString());
                } else if (unsafeCursor.X) {
                    long L0 = buffer.L0();
                    Segment Y0 = buffer.Y0(i2);
                    int i3 = 8192 - Y0.f31384c;
                    Y0.f31384c = 8192;
                    long j2 = (long) i3;
                    buffer.C0(L0 + j2);
                    unsafeCursor.h(Y0);
                    unsafeCursor.Z = L0;
                    unsafeCursor.X2 = Y0.f31382a;
                    unsafeCursor.Y2 = 8192 - i3;
                    unsafeCursor.Z2 = 8192;
                    return j2;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                }
            } else {
                throw new IllegalArgumentException(Intrinsics.C("minByteCount > Segment.SIZE: ", Integer.valueOf(i2)).toString());
            }
        } else {
            throw new IllegalArgumentException(Intrinsics.C("minByteCount <= 0: ", Integer.valueOf(i2)).toString());
        }
    }

    @NotNull
    public static final byte[] g0() {
        return f31450a;
    }

    public static final byte h(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "<this>");
        _UtilKt.e(buffer.L0(), j2, 1);
        Segment segment = buffer.s;
        if (segment == null) {
            Intrinsics.m((Object) null);
            throw null;
        } else if (buffer.L0() - j2 < j2) {
            long L0 = buffer.L0();
            while (L0 > j2) {
                segment = segment.f31388g;
                Intrinsics.m(segment);
                L0 -= (long) (segment.f31384c - segment.f31383b);
            }
            Intrinsics.m(segment);
            return segment.f31382a[(int) ((((long) segment.f31383b) + j2) - L0)];
        } else {
            long j3 = 0;
            while (true) {
                long j4 = ((long) (segment.f31384c - segment.f31383b)) + j3;
                if (j4 > j2) {
                    Intrinsics.m(segment);
                    return segment.f31382a[(int) ((((long) segment.f31383b) + j2) - j3)];
                }
                segment = segment.f31387f;
                Intrinsics.m(segment);
                j3 = j4;
            }
        }
    }

    public static /* synthetic */ void h0() {
    }

    public static final int i(@NotNull Buffer buffer) {
        Intrinsics.p(buffer, "<this>");
        Segment segment = buffer.s;
        if (segment == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = segment.f31384c;
            for (int i4 = segment.f31383b; i4 < i3; i4++) {
                i2 = (i2 * 31) + segment.f31382a[i4];
            }
            segment = segment.f31387f;
            Intrinsics.m(segment);
        } while (segment != buffer.s);
        return i2;
    }

    public static final boolean i0(@NotNull Segment segment, int i2, @NotNull byte[] bArr, int i3, int i4) {
        Intrinsics.p(segment, "segment");
        Intrinsics.p(bArr, "bytes");
        int i5 = segment.f31384c;
        byte[] bArr2 = segment.f31382a;
        while (i3 < i4) {
            if (i2 == i5) {
                segment = segment.f31387f;
                Intrinsics.m(segment);
                byte[] bArr3 = segment.f31382a;
                int i6 = segment.f31383b;
                bArr2 = bArr3;
                i2 = i6;
                i5 = segment.f31384c;
            }
            if (bArr2[i2] != bArr[i3]) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    public static final long j(@NotNull Buffer buffer, byte b2, long j2, long j3) {
        Segment segment;
        Buffer buffer2 = buffer;
        byte b3 = b2;
        long j4 = j2;
        long j5 = j3;
        Intrinsics.p(buffer, "<this>");
        boolean z = false;
        long j6 = 0;
        if (0 <= j4 && j4 <= j5) {
            z = true;
        }
        if (z) {
            if (j5 > buffer.L0()) {
                j5 = buffer.L0();
            }
            long j7 = j5;
            if (j4 == j7 || (segment = buffer2.s) == null) {
                return -1;
            }
            if (buffer.L0() - j4 < j4) {
                long L0 = buffer.L0();
                while (L0 > j4) {
                    segment = segment.f31388g;
                    Intrinsics.m(segment);
                    L0 -= (long) (segment.f31384c - segment.f31383b);
                }
                while (L0 < j7) {
                    byte[] bArr = segment.f31382a;
                    int min = (int) Math.min((long) segment.f31384c, (((long) segment.f31383b) + j7) - L0);
                    for (int i2 = (int) ((((long) segment.f31383b) + j4) - L0); i2 < min; i2++) {
                        if (bArr[i2] == b3) {
                            return ((long) (i2 - segment.f31383b)) + L0;
                        }
                    }
                    L0 += (long) (segment.f31384c - segment.f31383b);
                    segment = segment.f31387f;
                    Intrinsics.m(segment);
                    j4 = L0;
                }
                return -1;
            }
            while (true) {
                long j8 = ((long) (segment.f31384c - segment.f31383b)) + j6;
                if (j8 > j4) {
                    break;
                }
                segment = segment.f31387f;
                Intrinsics.m(segment);
                j6 = j8;
            }
            while (j6 < j7) {
                byte[] bArr2 = segment.f31382a;
                int min2 = (int) Math.min((long) segment.f31384c, (((long) segment.f31383b) + j7) - j6);
                for (int i3 = (int) ((((long) segment.f31383b) + j4) - j6); i3 < min2; i3++) {
                    if (bArr2[i3] == b3) {
                        return ((long) (i3 - segment.f31383b)) + j6;
                    }
                }
                j6 += (long) (segment.f31384c - segment.f31383b);
                segment = segment.f31387f;
                Intrinsics.m(segment);
                j4 = j6;
            }
            return -1;
        }
        throw new IllegalArgumentException(("size=" + buffer.L0() + " fromIndex=" + j4 + " toIndex=" + j5).toString());
    }

    @NotNull
    public static final String j0(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "<this>");
        if (j2 > 0) {
            long j3 = j2 - 1;
            if (buffer.y(j3) == ((byte) 13)) {
                String B = buffer.B(j3);
                buffer.skip(2);
                return B;
            }
        }
        String B2 = buffer.B(j2);
        buffer.skip(1);
        return B2;
    }

    public static final long k(@NotNull Buffer buffer, @NotNull ByteString byteString, long j2) {
        Buffer buffer2 = buffer;
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(byteString, "bytes");
        if (byteString.m0() > 0) {
            long j3 = 0;
            if (j2 >= 0) {
                Segment segment = buffer2.s;
                if (segment == null) {
                    return -1;
                }
                if (buffer.L0() - j2 < j2) {
                    long L0 = buffer.L0();
                    while (L0 > j2) {
                        segment = segment.f31388g;
                        Intrinsics.m(segment);
                        L0 -= (long) (segment.f31384c - segment.f31383b);
                    }
                    byte[] J = byteString.J();
                    byte b2 = J[0];
                    int m0 = byteString.m0();
                    long L02 = (buffer.L0() - ((long) m0)) + 1;
                    long j4 = L0;
                    Segment segment2 = segment;
                    long j5 = j2;
                    while (j4 < L02) {
                        byte[] bArr = segment2.f31382a;
                        Segment segment3 = segment2;
                        int min = (int) Math.min((long) segment2.f31384c, (((long) segment2.f31383b) + L02) - j4);
                        Segment segment4 = segment3;
                        int i2 = (int) ((((long) segment4.f31383b) + j5) - j4);
                        if (i2 < min) {
                            while (true) {
                                int i3 = i2 + 1;
                                if (bArr[i2] == b2 && i0(segment4, i3, J, 1, m0)) {
                                    return ((long) (i2 - segment4.f31383b)) + j4;
                                }
                                if (i3 >= min) {
                                    break;
                                }
                                i2 = i3;
                            }
                        }
                        j4 += (long) (segment4.f31384c - segment4.f31383b);
                        segment2 = segment4.f31387f;
                        Intrinsics.m(segment2);
                        j5 = j4;
                    }
                    return -1;
                }
                while (true) {
                    long j6 = ((long) (segment.f31384c - segment.f31383b)) + j3;
                    if (j6 > j2) {
                        break;
                    }
                    segment = segment.f31387f;
                    Intrinsics.m(segment);
                    j3 = j6;
                }
                byte[] J2 = byteString.J();
                byte b3 = J2[0];
                int m02 = byteString.m0();
                long L03 = (buffer.L0() - ((long) m02)) + 1;
                long j7 = j3;
                Segment segment5 = segment;
                long j8 = j2;
                while (j7 < L03) {
                    byte[] bArr2 = segment5.f31382a;
                    long j9 = L03;
                    int min2 = (int) Math.min((long) segment5.f31384c, (((long) segment5.f31383b) + L03) - j7);
                    int i4 = (int) ((((long) segment5.f31383b) + j8) - j7);
                    if (i4 < min2) {
                        while (true) {
                            int i5 = i4 + 1;
                            if (bArr2[i4] == b3 && i0(segment5, i5, J2, 1, m02)) {
                                return ((long) (i4 - segment5.f31383b)) + j7;
                            }
                            if (i5 >= min2) {
                                break;
                            }
                            i4 = i5;
                        }
                    }
                    j7 += (long) (segment5.f31384c - segment5.f31383b);
                    segment5 = segment5.f31387f;
                    Intrinsics.m(segment5);
                    L03 = j9;
                    j8 = j7;
                }
                return -1;
            }
            throw new IllegalArgumentException(Intrinsics.C("fromIndex < 0: ", Long.valueOf(j2)).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    public static final <T> T k0(@NotNull Buffer buffer, long j2, @NotNull Function2<? super Segment, ? super Long, ? extends T> function2) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(function2, "lambda");
        Segment segment = buffer.s;
        if (segment == null) {
            return function2.d0(null, -1L);
        }
        if (buffer.L0() - j2 < j2) {
            long L0 = buffer.L0();
            while (L0 > j2) {
                segment = segment.f31388g;
                Intrinsics.m(segment);
                L0 -= (long) (segment.f31384c - segment.f31383b);
            }
            return function2.d0(segment, Long.valueOf(L0));
        }
        long j3 = 0;
        while (true) {
            long j4 = ((long) (segment.f31384c - segment.f31383b)) + j3;
            if (j4 > j2) {
                return function2.d0(segment, Long.valueOf(j3));
            }
            segment = segment.f31387f;
            Intrinsics.m(segment);
            j3 = j4;
        }
    }

    public static final long l(@NotNull Buffer buffer, @NotNull ByteString byteString, long j2) {
        long j3;
        int i2;
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(byteString, "targetBytes");
        long j4 = 0;
        if (j2 >= 0) {
            Segment segment = buffer.s;
            if (segment == null) {
                return -1;
            }
            if (buffer.L0() - j2 < j2) {
                j3 = buffer.L0();
                while (j3 > j2) {
                    segment = segment.f31388g;
                    Intrinsics.m(segment);
                    j3 -= (long) (segment.f31384c - segment.f31383b);
                }
                if (byteString.m0() == 2) {
                    byte q = byteString.q(0);
                    byte q2 = byteString.q(1);
                    while (j3 < buffer.L0()) {
                        byte[] bArr = segment.f31382a;
                        i2 = (int) ((((long) segment.f31383b) + j2) - j3);
                        int i3 = segment.f31384c;
                        while (i2 < i3) {
                            byte b2 = bArr[i2];
                            if (!(b2 == q || b2 == q2)) {
                                i2++;
                            }
                        }
                        j3 += (long) (segment.f31384c - segment.f31383b);
                        segment = segment.f31387f;
                        Intrinsics.m(segment);
                        j2 = j3;
                    }
                } else {
                    byte[] J = byteString.J();
                    while (j3 < buffer.L0()) {
                        byte[] bArr2 = segment.f31382a;
                        int i4 = (int) ((((long) segment.f31383b) + j2) - j3);
                        int i5 = segment.f31384c;
                        while (i2 < i5) {
                            byte b3 = bArr2[i2];
                            int length = J.length;
                            int i6 = 0;
                            while (i6 < length) {
                                byte b4 = J[i6];
                                i6++;
                                if (b3 == b4) {
                                }
                            }
                            i4 = i2 + 1;
                        }
                        j3 += (long) (segment.f31384c - segment.f31383b);
                        segment = segment.f31387f;
                        Intrinsics.m(segment);
                        j2 = j3;
                    }
                }
                return -1;
            }
            while (true) {
                long j5 = ((long) (segment.f31384c - segment.f31383b)) + j4;
                if (j5 > j2) {
                    break;
                }
                segment = segment.f31387f;
                Intrinsics.m(segment);
                j4 = j5;
            }
            if (byteString.m0() == 2) {
                byte q3 = byteString.q(0);
                byte q4 = byteString.q(1);
                while (j3 < buffer.L0()) {
                    byte[] bArr3 = segment.f31382a;
                    int i7 = (int) ((((long) segment.f31383b) + j2) - j3);
                    int i8 = segment.f31384c;
                    while (i2 < i8) {
                        byte b5 = bArr3[i2];
                        if (!(b5 == q3 || b5 == q4)) {
                            i7 = i2 + 1;
                        }
                    }
                    j4 = j3 + ((long) (segment.f31384c - segment.f31383b));
                    segment = segment.f31387f;
                    Intrinsics.m(segment);
                    j2 = j4;
                }
            } else {
                byte[] J2 = byteString.J();
                while (j3 < buffer.L0()) {
                    byte[] bArr4 = segment.f31382a;
                    int i9 = (int) ((((long) segment.f31383b) + j2) - j3);
                    int i10 = segment.f31384c;
                    while (i2 < i10) {
                        byte b6 = bArr4[i2];
                        int length2 = J2.length;
                        int i11 = 0;
                        while (i11 < length2) {
                            byte b7 = J2[i11];
                            i11++;
                            if (b6 == b7) {
                            }
                        }
                        i9 = i2 + 1;
                    }
                    j4 = j3 + ((long) (segment.f31384c - segment.f31383b));
                    segment = segment.f31387f;
                    Intrinsics.m(segment);
                    j2 = j4;
                }
            }
            return -1;
            return ((long) (i2 - segment.f31383b)) + j3;
        }
        throw new IllegalArgumentException(Intrinsics.C("fromIndex < 0: ", Long.valueOf(j2)).toString());
    }

    public static final int l0(@NotNull Buffer buffer, @NotNull Options options, boolean z) {
        int i2;
        int i3;
        int i4;
        Segment segment;
        int i5;
        Buffer buffer2 = buffer;
        Intrinsics.p(buffer2, "<this>");
        Intrinsics.p(options, "options");
        Segment segment2 = buffer2.s;
        if (segment2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = segment2.f31382a;
        int i6 = segment2.f31383b;
        int i7 = segment2.f31384c;
        int[] h2 = options.h();
        Segment segment3 = segment2;
        int i8 = 0;
        int i9 = -1;
        loop0:
        while (true) {
            int i10 = i8 + 1;
            int i11 = h2[i8];
            int i12 = i8 + 2;
            int i13 = h2[i10];
            if (i13 != -1) {
                i9 = i13;
            }
            if (segment3 == null) {
                break;
            }
            if (i11 < 0) {
                int i14 = i12 + (i11 * -1);
                while (true) {
                    int i15 = i6 + 1;
                    int i16 = i12 + 1;
                    if ((bArr[i6] & 255) != h2[i12]) {
                        return i9;
                    }
                    boolean z2 = i16 == i14;
                    if (i15 == i7) {
                        Intrinsics.m(segment3);
                        Segment segment4 = segment3.f31387f;
                        Intrinsics.m(segment4);
                        i5 = segment4.f31383b;
                        byte[] bArr2 = segment4.f31382a;
                        i4 = segment4.f31384c;
                        if (segment4 != segment2) {
                            byte[] bArr3 = bArr2;
                            segment = segment4;
                            bArr = bArr3;
                        } else if (!z2) {
                            break loop0;
                        } else {
                            bArr = bArr2;
                            segment = null;
                        }
                    } else {
                        segment = segment3;
                        i4 = i7;
                        i5 = i15;
                    }
                    if (z2) {
                        i3 = h2[i16];
                        i2 = i5;
                        i7 = i4;
                        segment3 = segment;
                        break;
                    }
                    i6 = i5;
                    i7 = i4;
                    segment3 = segment;
                    i12 = i16;
                }
            } else {
                i2 = i6 + 1;
                byte b2 = bArr[i6] & 255;
                int i17 = i12 + i11;
                while (i12 != i17) {
                    if (b2 == h2[i12]) {
                        i3 = h2[i12 + i11];
                        if (i2 == i7) {
                            segment3 = segment3.f31387f;
                            Intrinsics.m(segment3);
                            i2 = segment3.f31383b;
                            bArr = segment3.f31382a;
                            i7 = segment3.f31384c;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                    } else {
                        i12++;
                    }
                }
                return i9;
            }
            if (i3 >= 0) {
                return i3;
            }
            i8 = -i3;
            i6 = i2;
        }
        if (z) {
            return -2;
        }
        return i9;
    }

    public static final int m(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.p(unsafeCursor, "<this>");
        long j2 = unsafeCursor.Z;
        Buffer buffer = unsafeCursor.s;
        Intrinsics.m(buffer);
        if (j2 != buffer.L0()) {
            long j3 = unsafeCursor.Z;
            return unsafeCursor.f(j3 == -1 ? 0 : j3 + ((long) (unsafeCursor.Z2 - unsafeCursor.Y2)));
        }
        throw new IllegalStateException("no more bytes".toString());
    }

    public static /* synthetic */ int m0(Buffer buffer, Options options, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return l0(buffer, options, z);
    }

    public static final boolean n(@NotNull Buffer buffer, long j2, @NotNull ByteString byteString, int i2, int i3) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(byteString, "bytes");
        if (j2 < 0 || i2 < 0 || i3 < 0 || buffer.L0() - j2 < ((long) i3) || byteString.m0() - i2 < i3) {
            return false;
        }
        if (i3 <= 0) {
            return true;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            if (buffer.y(((long) i4) + j2) != byteString.q(i4 + i2)) {
                return false;
            }
            if (i5 >= i3) {
                return true;
            }
            i4 = i5;
        }
    }

    public static final int o(@NotNull Buffer buffer, @NotNull byte[] bArr) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(bArr, "sink");
        return buffer.read(bArr, 0, bArr.length);
    }

    public static final int p(@NotNull Buffer buffer, @NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(bArr, "sink");
        _UtilKt.e((long) bArr.length, (long) i2, (long) i3);
        Segment segment = buffer.s;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i3, segment.f31384c - segment.f31383b);
        byte[] bArr2 = segment.f31382a;
        int i4 = segment.f31383b;
        ArraysKt.v0(bArr2, bArr, i2, i4, i4 + min);
        segment.f31383b += min;
        buffer.C0(buffer.L0() - ((long) min));
        if (segment.f31383b == segment.f31384c) {
            buffer.s = segment.b();
            SegmentPool.d(segment);
        }
        return min;
    }

    public static final long q(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j2) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(buffer2, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount < 0: ", Long.valueOf(j2)).toString());
        } else if (buffer.L0() == 0) {
            return -1;
        } else {
            if (j2 > buffer.L0()) {
                j2 = buffer.L0();
            }
            buffer2.u1(buffer, j2);
            return j2;
        }
    }

    public static final long r(@NotNull Buffer buffer, @NotNull Sink sink) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(sink, "sink");
        long L0 = buffer.L0();
        if (L0 > 0) {
            sink.u1(buffer, L0);
        }
        return L0;
    }

    @NotNull
    public static final Buffer.UnsafeCursor s(@NotNull Buffer buffer, @NotNull Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(unsafeCursor, "unsafeCursor");
        Buffer.UnsafeCursor m2 = _UtilKt.m(unsafeCursor);
        if (m2.s == null) {
            m2.s = buffer;
            m2.X = true;
            return m2;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final byte t(@NotNull Buffer buffer) {
        Intrinsics.p(buffer, "<this>");
        if (buffer.L0() != 0) {
            Segment segment = buffer.s;
            Intrinsics.m(segment);
            int i2 = segment.f31383b;
            int i3 = segment.f31384c;
            int i4 = i2 + 1;
            byte b2 = segment.f31382a[i2];
            buffer.C0(buffer.L0() - 1);
            if (i4 == i3) {
                buffer.s = segment.b();
                SegmentPool.d(segment);
            } else {
                segment.f31383b = i4;
            }
            return b2;
        }
        throw new EOFException();
    }

    @NotNull
    public static final byte[] u(@NotNull Buffer buffer) {
        Intrinsics.p(buffer, "<this>");
        return buffer.U1(buffer.L0());
    }

    @NotNull
    public static final byte[] v(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "<this>");
        if (!(j2 >= 0 && j2 <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount: ", Long.valueOf(j2)).toString());
        } else if (buffer.L0() >= j2) {
            byte[] bArr = new byte[((int) j2)];
            buffer.readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    @NotNull
    public static final ByteString w(@NotNull Buffer buffer) {
        Intrinsics.p(buffer, "<this>");
        return buffer.K(buffer.L0());
    }

    @NotNull
    public static final ByteString x(@NotNull Buffer buffer, long j2) {
        Intrinsics.p(buffer, "<this>");
        if (!(j2 >= 0 && j2 <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.C("byteCount: ", Long.valueOf(j2)).toString());
        } else if (buffer.L0() < j2) {
            throw new EOFException();
        } else if (j2 < PlaybackStateCompat.r3) {
            return new ByteString(buffer.U1(j2));
        } else {
            ByteString S0 = buffer.S0((int) j2);
            buffer.skip(j2);
            return S0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
        if (r12 != r13) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0081, code lost:
        r0.s = r10.b();
        okio.SegmentPool.d(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008b, code lost:
        r10.f31383b = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008d, code lost:
        if (r5 != false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0091, code lost:
        if (r0.s != null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0097, code lost:
        r0.C0(r17.L0() - ((long) r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a0, code lost:
        if (r2 == false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a2, code lost:
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a5, code lost:
        if (r1 >= r14) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00af, code lost:
        if (r17.L0() == 0) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b1, code lost:
        if (r2 == false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b3, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b6, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00db, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio._UtilKt.t(r0.y(0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e1, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e2, code lost:
        if (r2 == false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return -r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long y(@org.jetbrains.annotations.NotNull okio.Buffer r17) {
        /*
            r0 = r17
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r0, r1)
            long r1 = r17.L0()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00e7
            r1 = 0
            r5 = -7
            r8 = r3
            r6 = r5
            r2 = 0
            r5 = 0
        L_0x0018:
            okio.Segment r10 = r0.s
            kotlin.jvm.internal.Intrinsics.m(r10)
            byte[] r11 = r10.f31382a
            int r12 = r10.f31383b
            int r13 = r10.f31384c
        L_0x0023:
            if (r12 >= r13) goto L_0x007f
            byte r15 = r11[r12]
            r14 = 48
            byte r14 = (byte) r14
            if (r15 < r14) goto L_0x006c
            r3 = 57
            byte r3 = (byte) r3
            if (r15 > r3) goto L_0x006c
            int r14 = r14 - r15
            r3 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r16 < 0) goto L_0x004a
            if (r16 != 0) goto L_0x0043
            long r3 = (long) r14
            int r16 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r16 >= 0) goto L_0x0043
            goto L_0x004a
        L_0x0043:
            r3 = 10
            long r8 = r8 * r3
            long r3 = (long) r14
            long r8 = r8 + r3
            goto L_0x0077
        L_0x004a:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.L2(r8)
            okio.Buffer r0 = r0.writeByte(r15)
            if (r2 != 0) goto L_0x005c
            r0.readByte()
        L_0x005c:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r0.a2()
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.C(r2, r0)
            r1.<init>(r0)
            throw r1
        L_0x006c:
            r3 = 45
            byte r3 = (byte) r3
            if (r15 != r3) goto L_0x007e
            if (r1 != 0) goto L_0x007e
            r2 = 1
            long r6 = r6 - r2
            r2 = 1
        L_0x0077:
            int r12 = r12 + 1
            int r1 = r1 + 1
            r3 = 0
            goto L_0x0023
        L_0x007e:
            r5 = 1
        L_0x007f:
            if (r12 != r13) goto L_0x008b
            okio.Segment r3 = r10.b()
            r0.s = r3
            okio.SegmentPool.d(r10)
            goto L_0x008d
        L_0x008b:
            r10.f31383b = r12
        L_0x008d:
            if (r5 != 0) goto L_0x0097
            okio.Segment r3 = r0.s
            if (r3 != 0) goto L_0x0094
            goto L_0x0097
        L_0x0094:
            r3 = 0
            goto L_0x0018
        L_0x0097:
            long r3 = r17.L0()
            long r5 = (long) r1
            long r3 = r3 - r5
            r0.C0(r3)
            if (r2 == 0) goto L_0x00a4
            r14 = 2
            goto L_0x00a5
        L_0x00a4:
            r14 = 1
        L_0x00a5:
            if (r1 >= r14) goto L_0x00e2
            long r3 = r17.L0()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x00dc
            if (r2 == 0) goto L_0x00b6
            java.lang.String r1 = "Expected a digit"
            goto L_0x00b8
        L_0x00b6:
            java.lang.String r1 = "Expected a digit or '-'"
        L_0x00b8:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " but was 0x"
            r3.append(r1)
            r4 = 0
            byte r0 = r0.y(r4)
            java.lang.String r0 = okio._UtilKt.t(r0)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x00dc:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        L_0x00e2:
            if (r2 == 0) goto L_0x00e5
            goto L_0x00e6
        L_0x00e5:
            long r8 = -r8
        L_0x00e6:
            return r8
        L_0x00e7:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._BufferKt.y(okio.Buffer):long");
    }

    public static final void z(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j2) {
        Intrinsics.p(buffer, "<this>");
        Intrinsics.p(buffer2, "sink");
        if (buffer.L0() >= j2) {
            buffer2.u1(buffer, j2);
        } else {
            buffer2.u1(buffer, buffer.L0());
            throw new EOFException();
        }
    }
}
