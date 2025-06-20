package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010 \u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH&¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\nH&¢\u0006\u0004\b#\u0010$J\u001f\u0010'\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020%H&¢\u0006\u0004\b'\u0010(J/\u0010)\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H&¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\nH&¢\u0006\u0004\b,\u0010$J\u0017\u0010.\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\nH&¢\u0006\u0004\b.\u0010$J\u0017\u0010/\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\nH&¢\u0006\u0004\b/\u0010$J\u0017\u00101\u001a\u00020\u00002\u0006\u00100\u001a\u00020\nH&¢\u0006\u0004\b1\u0010$J\u0017\u00102\u001a\u00020\u00002\u0006\u00100\u001a\u00020\nH&¢\u0006\u0004\b2\u0010$J\u0017\u00104\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0015H&¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0015H&¢\u0006\u0004\b6\u00105J\u0017\u00107\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0015H&¢\u0006\u0004\b7\u00105J\u0017\u00108\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0015H&¢\u0006\u0004\b8\u00105J\u000f\u0010:\u001a\u000209H&¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0000H&¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0000H&¢\u0006\u0004\b>\u0010=J\u000f\u0010@\u001a\u00020?H&¢\u0006\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006DÀ\u0006\u0001"}, d2 = {"Lokio/BufferedSink;", "Lokio/Sink;", "Ljava/nio/channels/WritableByteChannel;", "Lokio/Buffer;", "g", "()Lokio/Buffer;", "Lokio/ByteString;", "byteString", "g2", "(Lokio/ByteString;)Lokio/BufferedSink;", "", "offset", "byteCount", "V", "(Lokio/ByteString;II)Lokio/BufferedSink;", "", "source", "write", "([B)Lokio/BufferedSink;", "([BII)Lokio/BufferedSink;", "Lokio/Source;", "", "y1", "(Lokio/Source;)J", "H1", "(Lokio/Source;J)Lokio/BufferedSink;", "", "string", "W0", "(Ljava/lang/String;)Lokio/BufferedSink;", "beginIndex", "endIndex", "w1", "(Ljava/lang/String;II)Lokio/BufferedSink;", "codePoint", "U", "(I)Lokio/BufferedSink;", "Ljava/nio/charset/Charset;", "charset", "C1", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/BufferedSink;", "E2", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Lokio/BufferedSink;", "b", "writeByte", "s", "writeShort", "O0", "i", "writeInt", "n0", "v", "writeLong", "(J)Lokio/BufferedSink;", "Y", "L2", "z1", "", "flush", "()V", "M", "()Lokio/BufferedSink;", "F0", "Ljava/io/OutputStream;", "M2", "()Ljava/io/OutputStream;", "m", "buffer", "okio"}, k = 1, mv = {1, 5, 1})
public interface BufferedSink extends Sink, WritableByteChannel {
    @NotNull
    BufferedSink C1(@NotNull String str, @NotNull Charset charset) throws IOException;

    @NotNull
    BufferedSink E2(@NotNull String str, int i2, int i3, @NotNull Charset charset) throws IOException;

    @NotNull
    BufferedSink F0() throws IOException;

    @NotNull
    BufferedSink H1(@NotNull Source source, long j2) throws IOException;

    @NotNull
    BufferedSink L2(long j2) throws IOException;

    @NotNull
    BufferedSink M() throws IOException;

    @NotNull
    OutputStream M2();

    @NotNull
    BufferedSink O0(int i2) throws IOException;

    @NotNull
    BufferedSink U(int i2) throws IOException;

    @NotNull
    BufferedSink V(@NotNull ByteString byteString, int i2, int i3) throws IOException;

    @NotNull
    BufferedSink W0(@NotNull String str) throws IOException;

    @NotNull
    BufferedSink Y(long j2) throws IOException;

    void flush() throws IOException;

    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @ReplaceWith(expression = "buffer", imports = {}))
    Buffer g();

    @NotNull
    BufferedSink g2(@NotNull ByteString byteString) throws IOException;

    @NotNull
    Buffer m();

    @NotNull
    BufferedSink n0(int i2) throws IOException;

    @NotNull
    BufferedSink w1(@NotNull String str, int i2, int i3) throws IOException;

    @NotNull
    BufferedSink write(@NotNull byte[] bArr) throws IOException;

    @NotNull
    BufferedSink write(@NotNull byte[] bArr, int i2, int i3) throws IOException;

    @NotNull
    BufferedSink writeByte(int i2) throws IOException;

    @NotNull
    BufferedSink writeInt(int i2) throws IOException;

    @NotNull
    BufferedSink writeLong(long j2) throws IOException;

    @NotNull
    BufferedSink writeShort(int i2) throws IOException;

    long y1(@NotNull Source source) throws IOException;

    @NotNull
    BufferedSink z1(long j2) throws IOException;
}
