package kotlin.io.encoding;

import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u0019J'\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010%R\u0014\u0010*\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010.\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010)R\u0016\u00101\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00100R\u0014\u00105\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0019¨\u00066"}, d2 = {"Lkotlin/io/encoding/DecodeInputStream;", "Ljava/io/InputStream;", "input", "Lkotlin/io/encoding/Base64;", "base64", "<init>", "(Ljava/io/InputStream;Lkotlin/io/encoding/Base64;)V", "", "dst", "", "dstOffset", "dstEndIndex", "symbolBufferLength", "c", "([BIII)I", "length", "", "b", "([BII)V", "h", "()V", "i", "e", "(I)I", "f", "()I", "read", "destination", "offset", "([BII)I", "close", "s", "Ljava/io/InputStream;", "X", "Lkotlin/io/encoding/Base64;", "", "Y", "Z", "isClosed", "isEOF", "X2", "[B", "singleByteBuffer", "Y2", "symbolBuffer", "Z2", "byteBuffer", "a3", "I", "byteBufferStartIndex", "b3", "byteBufferEndIndex", "d", "byteBufferLength", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@ExperimentalEncodingApi
final class DecodeInputStream extends InputStream {
    @NotNull
    private final Base64 X;
    @NotNull
    private final byte[] X2 = new byte[1];
    private boolean Y;
    @NotNull
    private final byte[] Y2 = new byte[1024];
    private boolean Z;
    @NotNull
    private final byte[] Z2 = new byte[1024];
    private int a3;
    private int b3;
    @NotNull
    private final InputStream s;

    public DecodeInputStream(@NotNull InputStream inputStream, @NotNull Base64 base64) {
        Intrinsics.p(inputStream, HTML.Tag.q0);
        Intrinsics.p(base64, "base64");
        this.s = inputStream;
        this.X = base64;
    }

    private final void b(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.Z2;
        int i4 = this.a3;
        ArraysKt.v0(bArr2, bArr, i2, i4, i4 + i3);
        this.a3 += i3;
        h();
    }

    private final int c(byte[] bArr, int i2, int i3, int i4) {
        int i5 = this.b3;
        this.b3 = i5 + this.X.n(this.Y2, this.Z2, i5, 0, i4);
        int min = Math.min(d(), i3 - i2);
        b(bArr, i2, min);
        i();
        return min;
    }

    private final int d() {
        return this.b3 - this.a3;
    }

    private final int e(int i2) {
        this.Y2[i2] = 61;
        if ((i2 & 3) != 2) {
            return i2 + 1;
        }
        int f2 = f();
        if (f2 >= 0) {
            this.Y2[i2 + 1] = (byte) f2;
        }
        return i2 + 2;
    }

    private final int f() {
        int read;
        if (!this.X.D()) {
            return this.s.read();
        }
        do {
            read = this.s.read();
            if (read == -1 || Base64Kt.i(read)) {
                return read;
            }
            read = this.s.read();
            break;
        } while (Base64Kt.i(read));
        return read;
    }

    private final void h() {
        if (this.a3 == this.b3) {
            this.a3 = 0;
            this.b3 = 0;
        }
    }

    private final void i() {
        byte[] bArr = this.Z2;
        int length = bArr.length;
        int i2 = this.b3;
        if ((this.Y2.length / 4) * 3 > length - i2) {
            ArraysKt.v0(bArr, bArr, 0, this.a3, i2);
            this.b3 -= this.a3;
            this.a3 = 0;
        }
    }

    public void close() {
        if (!this.Y) {
            this.Y = true;
            this.s.close();
        }
    }

    public int read() {
        int i2 = this.a3;
        if (i2 < this.b3) {
            byte b2 = this.Z2[i2] & 255;
            this.a3 = i2 + 1;
            h();
            return b2;
        }
        int read = read(this.X2, 0, 1);
        if (read == -1) {
            return -1;
        }
        if (read == 1) {
            return this.X2[0] & 255;
        }
        throw new IllegalStateException("Unreachable".toString());
    }

    public int read(@NotNull byte[] bArr, int i2, int i3) {
        int i4;
        boolean z;
        Intrinsics.p(bArr, Annotation.l3);
        if (i2 < 0 || i3 < 0 || (i4 = i2 + i3) > bArr.length) {
            throw new IndexOutOfBoundsException("offset: " + i2 + ", length: " + i3 + ", buffer size: " + bArr.length);
        } else if (this.Y) {
            throw new IOException("The input stream is closed.");
        } else if (this.Z) {
            return -1;
        } else {
            if (i3 == 0) {
                return 0;
            }
            if (d() >= i3) {
                b(bArr, i2, i3);
                return i3;
            }
            int d2 = (((i3 - d()) + 2) / 3) * 4;
            int i5 = i2;
            while (true) {
                boolean z2 = this.Z;
                if (!z2 && d2 > 0) {
                    int min = Math.min(this.Y2.length, d2);
                    int i6 = 0;
                    while (true) {
                        z = this.Z;
                        if (!z && i6 < min) {
                            int f2 = f();
                            if (f2 != -1) {
                                if (f2 != 61) {
                                    this.Y2[i6] = (byte) f2;
                                    i6++;
                                } else {
                                    i6 = e(i6);
                                }
                            }
                            this.Z = true;
                        } else if (!z || i6 == min) {
                            d2 -= i6;
                            i5 += c(bArr, i5, i4, i6);
                        } else {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    }
                    if (!z) {
                    }
                    d2 -= i6;
                    i5 += c(bArr, i5, i4, i6);
                } else if (i5 == i2 || !z2) {
                    return i5 - i2;
                } else {
                    return -1;
                }
            }
            if (i5 == i2) {
            }
            return i5 - i2;
        }
    }
}
