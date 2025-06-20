package kotlin.io.encoding;

import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u0019\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\"R\u0014\u0010&\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010*\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010\"¨\u0006+"}, d2 = {"Lkotlin/io/encoding/EncodeOutputStream;", "Ljava/io/OutputStream;", "output", "Lkotlin/io/encoding/Base64;", "base64", "<init>", "(Ljava/io/OutputStream;Lkotlin/io/encoding/Base64;)V", "", "source", "", "startIndex", "endIndex", "c", "([BII)I", "", "d", "()V", "e", "b", "write", "(I)V", "offset", "length", "([BII)V", "flush", "close", "s", "Ljava/io/OutputStream;", "X", "Lkotlin/io/encoding/Base64;", "", "Y", "Z", "isClosed", "I", "lineLength", "X2", "[B", "symbolBuffer", "Y2", "byteBuffer", "Z2", "byteBufferLength", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@ExperimentalEncodingApi
final class EncodeOutputStream extends OutputStream {
    @NotNull
    private final Base64 X;
    @NotNull
    private final byte[] X2;
    private boolean Y;
    @NotNull
    private final byte[] Y2;
    private int Z;
    private int Z2;
    @NotNull
    private final OutputStream s;

    public EncodeOutputStream(@NotNull OutputStream outputStream, @NotNull Base64 base64) {
        Intrinsics.p(outputStream, HTML.Tag.U);
        Intrinsics.p(base64, "base64");
        this.s = outputStream;
        this.X = base64;
        this.Z = base64.D() ? 76 : -1;
        this.X2 = new byte[1024];
        this.Y2 = new byte[3];
    }

    private final void b() {
        if (this.Y) {
            throw new IOException("The output stream is closed.");
        }
    }

    private final int c(byte[] bArr, int i2, int i3) {
        int min = Math.min(3 - this.Z2, i3 - i2);
        ArraysKt.v0(bArr, this.Y2, this.Z2, i2, i2 + min);
        int i4 = this.Z2 + min;
        this.Z2 = i4;
        if (i4 == 3) {
            d();
        }
        return min;
    }

    private final void d() {
        if (e(this.Y2, 0, this.Z2) == 4) {
            this.Z2 = 0;
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final int e(byte[] bArr, int i2, int i3) {
        int t = this.X.t(bArr, this.X2, 0, i2, i3);
        if (this.Z == 0) {
            this.s.write(Base64.f28854c.H());
            this.Z = 76;
            if (t > 76) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        this.s.write(this.X2, 0, t);
        this.Z -= t;
        return t;
    }

    public void close() {
        if (!this.Y) {
            this.Y = true;
            if (this.Z2 != 0) {
                d();
            }
            this.s.close();
        }
    }

    public void flush() {
        b();
        this.s.flush();
    }

    public void write(int i2) {
        b();
        byte[] bArr = this.Y2;
        int i3 = this.Z2;
        int i4 = i3 + 1;
        this.Z2 = i4;
        bArr[i3] = (byte) i2;
        if (i4 == 3) {
            d();
        }
    }

    public void write(@NotNull byte[] bArr, int i2, int i3) {
        int i4;
        Intrinsics.p(bArr, "source");
        b();
        if (i2 < 0 || i3 < 0 || (i4 = i2 + i3) > bArr.length) {
            throw new IndexOutOfBoundsException("offset: " + i2 + ", length: " + i3 + ", source size: " + bArr.length);
        } else if (i3 != 0) {
            int i5 = this.Z2;
            if (i5 < 3) {
                if (i5 != 0) {
                    i2 += c(bArr, i2, i4);
                    if (this.Z2 != 0) {
                        return;
                    }
                }
                while (i2 + 3 <= i4) {
                    int min = Math.min((this.X.D() ? this.Z : this.X2.length) / 4, (i4 - i2) / 3);
                    int i6 = (min * 3) + i2;
                    if (e(bArr, i2, i6) == min * 4) {
                        i2 = i6;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
                ArraysKt.v0(bArr, this.Y2, 0, i2, i4);
                this.Z2 = i4 - i2;
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }
}
