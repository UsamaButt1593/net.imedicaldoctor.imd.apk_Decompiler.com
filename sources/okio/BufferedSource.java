package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H&¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\tH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH&¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\tH&¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\tH&¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b \u0010\rJ\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020!2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00172\u0006\u0010'\u001a\u00020&H&¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H&¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020*2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00172\u0006\u0010/\u001a\u00020*H&¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020*H&¢\u0006\u0004\b2\u00103J'\u00100\u001a\u00020\u00172\u0006\u0010/\u001a\u00020*2\u0006\u00104\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017H&¢\u0006\u0004\b0\u00105J\u001f\u00106\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\t2\u0006\u0010/\u001a\u000208H&¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020;H&¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020;2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b>\u0010?J\u0011\u0010@\u001a\u0004\u0018\u00010;H&¢\u0006\u0004\b@\u0010=J\u000f\u0010A\u001a\u00020;H&¢\u0006\u0004\bA\u0010=J\u0017\u0010C\u001a\u00020;2\u0006\u0010B\u001a\u00020\tH&¢\u0006\u0004\bC\u0010?J\u000f\u0010D\u001a\u00020\u0017H&¢\u0006\u0004\bD\u0010\u0019J\u0017\u0010G\u001a\u00020;2\u0006\u0010F\u001a\u00020EH&¢\u0006\u0004\bG\u0010HJ\u001f\u0010I\u001a\u00020;2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010F\u001a\u00020EH&¢\u0006\u0004\bI\u0010JJ\u0017\u0010L\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u0010H&¢\u0006\u0004\bL\u0010MJ\u001f\u0010O\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\tH&¢\u0006\u0004\bO\u0010PJ'\u0010R\u001a\u00020\t2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH&¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\t2\u0006\u0010T\u001a\u00020!H&¢\u0006\u0004\bU\u0010VJ\u001f\u0010W\u001a\u00020\t2\u0006\u0010T\u001a\u00020!2\u0006\u0010N\u001a\u00020\tH&¢\u0006\u0004\bW\u0010XJ\u0017\u0010Z\u001a\u00020\t2\u0006\u0010Y\u001a\u00020!H&¢\u0006\u0004\bZ\u0010VJ\u001f\u0010[\u001a\u00020\t2\u0006\u0010Y\u001a\u00020!2\u0006\u0010N\u001a\u00020\tH&¢\u0006\u0004\b[\u0010XJ\u001f\u0010\\\u001a\u00020\u00062\u0006\u00104\u001a\u00020\t2\u0006\u0010T\u001a\u00020!H&¢\u0006\u0004\b\\\u0010]J/\u0010_\u001a\u00020\u00062\u0006\u00104\u001a\u00020\t2\u0006\u0010T\u001a\u00020!2\u0006\u0010^\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017H&¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\u0000H&¢\u0006\u0004\ba\u0010bJ\u000f\u0010d\u001a\u00020cH&¢\u0006\u0004\bd\u0010eR\u0014\u0010g\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\bf\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006hÀ\u0006\u0001"}, d2 = {"Lokio/BufferedSource;", "Lokio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "Lokio/Buffer;", "g", "()Lokio/Buffer;", "", "o0", "()Z", "", "byteCount", "", "I2", "(J)V", "request", "(J)Z", "", "readByte", "()B", "", "readShort", "()S", "j2", "", "readInt", "()I", "R1", "readLong", "()J", "p2", "H0", "Q2", "skip", "Lokio/ByteString;", "A1", "()Lokio/ByteString;", "K", "(J)Lokio/ByteString;", "Lokio/Options;", "options", "S2", "(Lokio/Options;)I", "", "b0", "()[B", "U1", "(J)[B", "sink", "read", "([B)I", "readFully", "([B)V", "offset", "([BII)I", "w0", "(Lokio/Buffer;J)V", "Lokio/Sink;", "r2", "(Lokio/Sink;)J", "", "a2", "()Ljava/lang/String;", "B", "(J)Ljava/lang/String;", "E0", "O1", "limit", "M0", "t1", "Ljava/nio/charset/Charset;", "charset", "g1", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "d2", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "b", "N2", "(B)J", "fromIndex", "u0", "(BJ)J", "toIndex", "y0", "(BJJ)J", "bytes", "l0", "(Lokio/ByteString;)J", "E", "(Lokio/ByteString;J)J", "targetBytes", "z0", "G2", "b1", "(JLokio/ByteString;)Z", "bytesOffset", "S1", "(JLokio/ByteString;II)Z", "peek", "()Lokio/BufferedSource;", "Ljava/io/InputStream;", "z", "()Ljava/io/InputStream;", "m", "buffer", "okio"}, k = 1, mv = {1, 5, 1})
public interface BufferedSource extends Source, ReadableByteChannel {
    @NotNull
    ByteString A1() throws IOException;

    @NotNull
    String B(long j2) throws IOException;

    long E(@NotNull ByteString byteString, long j2) throws IOException;

    @Nullable
    String E0() throws IOException;

    long G2(@NotNull ByteString byteString, long j2) throws IOException;

    long H0() throws IOException;

    void I2(long j2) throws IOException;

    @NotNull
    ByteString K(long j2) throws IOException;

    @NotNull
    String M0(long j2) throws IOException;

    long N2(byte b2) throws IOException;

    @NotNull
    String O1() throws IOException;

    long Q2() throws IOException;

    int R1() throws IOException;

    boolean S1(long j2, @NotNull ByteString byteString, int i2, int i3) throws IOException;

    int S2(@NotNull Options options) throws IOException;

    @NotNull
    byte[] U1(long j2) throws IOException;

    @NotNull
    String a2() throws IOException;

    @NotNull
    byte[] b0() throws IOException;

    boolean b1(long j2, @NotNull ByteString byteString) throws IOException;

    @NotNull
    String d2(long j2, @NotNull Charset charset) throws IOException;

    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @ReplaceWith(expression = "buffer", imports = {}))
    Buffer g();

    @NotNull
    String g1(@NotNull Charset charset) throws IOException;

    short j2() throws IOException;

    long l0(@NotNull ByteString byteString) throws IOException;

    @NotNull
    Buffer m();

    boolean o0() throws IOException;

    long p2() throws IOException;

    @NotNull
    BufferedSource peek();

    long r2(@NotNull Sink sink) throws IOException;

    int read(@NotNull byte[] bArr) throws IOException;

    int read(@NotNull byte[] bArr, int i2, int i3) throws IOException;

    byte readByte() throws IOException;

    void readFully(@NotNull byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    boolean request(long j2) throws IOException;

    void skip(long j2) throws IOException;

    int t1() throws IOException;

    long u0(byte b2, long j2) throws IOException;

    void w0(@NotNull Buffer buffer, long j2) throws IOException;

    long y0(byte b2, long j2, long j3) throws IOException;

    @NotNull
    InputStream z();

    long z0(@NotNull ByteString byteString) throws IOException;
}
