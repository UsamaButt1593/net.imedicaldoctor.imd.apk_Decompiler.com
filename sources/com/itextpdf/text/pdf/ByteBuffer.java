package com.itextpdf.text.pdf;

import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import org.apache.commons.lang3.ClassUtils;

public class ByteBuffer extends OutputStream {
    public static final byte X2 = 48;
    private static int Y;
    private static final char[] Y2 = {'0', '1', PdfWriter.p4, PdfWriter.q4, PdfWriter.r4, PdfWriter.s4, PdfWriter.t4, PdfWriter.u4, '8', '9'};
    private static byte[][] Z = new byte[0][];
    private static final byte[] Z2 = {X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public static boolean a3 = false;
    private static final DecimalFormatSymbols b3 = new DecimalFormatSymbols(Locale.US);
    protected byte[] X;
    protected int s;

    public ByteBuffer() {
        this(128);
    }

    private static byte[] s(int i2) {
        double d2 = (double) i2;
        int floor = (int) Math.floor(Math.log(d2) / Math.log(10.0d));
        int i3 = i2 % 100;
        if (i3 != 0) {
            floor += 2;
        }
        int i4 = i2 % 10;
        if (i4 != 0) {
            floor++;
        }
        if (i2 < 100) {
            floor = i2 < 10 ? floor + 2 : floor + 1;
        }
        byte[] bArr = new byte[(floor - 1)];
        int i5 = floor - 2;
        if (i2 < 100) {
            bArr[0] = X2;
        }
        if (i4 != 0) {
            bArr[i5] = Z2[i4];
            i5 = floor - 3;
        }
        if (i3 != 0) {
            bArr[i5] = Z2[(i2 / 10) % 10];
            bArr[i5 - 1] = 46;
        }
        int floor2 = ((int) Math.floor(Math.log(d2) / Math.log(10.0d))) - 1;
        for (int i6 = 0; i6 < floor2; i6++) {
            bArr[i6] = Z2[(i2 / ((int) Math.pow(10.0d, (double) ((floor2 - i6) + 1)))) % 10];
        }
        return bArr;
    }

    public static void t(int i2) {
        int i3 = i2 != 0 ? i2 != 1 ? 1 : 10 : 100;
        for (int i4 = 1; i4 < Y; i4 += i3) {
            byte[][] bArr = Z;
            if (bArr[i4] == null) {
                bArr[i4] = s(i4);
            }
        }
    }

    public static String u(double d2) {
        return v(d2, (ByteBuffer) null);
    }

    public static String v(double d2, ByteBuffer byteBuffer) {
        boolean z;
        byte[] bArr;
        double d3 = d2;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (a3) {
            String format = new DecimalFormat("0.######", b3).format(d3);
            if (byteBuffer2 == null) {
                return format;
            }
            byteBuffer2.k(format);
            return null;
        } else if (Math.abs(d2) >= 1.5E-5d) {
            int i2 = 0;
            if (d3 < 0.0d) {
                d3 = -d3;
                z = true;
            } else {
                z = false;
            }
            int i3 = AacUtil.f12876f;
            if (d3 < 1.0d) {
                double d4 = d3 + 5.0E-6d;
                if (d4 >= 1.0d) {
                    if (z) {
                        if (byteBuffer2 == null) {
                            return "-1";
                        }
                        byteBuffer2.b((byte) 45);
                        byteBuffer2.b((byte) 49);
                        return null;
                    } else if (byteBuffer2 == null) {
                        return IcyHeaders.a3;
                    } else {
                        byteBuffer2.b((byte) 49);
                        return null;
                    }
                } else if (byteBuffer2 != null) {
                    int i4 = (int) (d4 * 100000.0d);
                    if (z) {
                        byteBuffer2.b((byte) 45);
                    }
                    byteBuffer2.b(X2);
                    byteBuffer2.b((byte) 46);
                    byteBuffer2.b((byte) ((i4 / 10000) + 48));
                    if (i4 % 10000 != 0) {
                        byteBuffer2.b((byte) (((i4 / 1000) % 10) + 48));
                        if (i4 % 1000 != 0) {
                            byteBuffer2.b((byte) (((i4 / 100) % 10) + 48));
                            if (i4 % 100 != 0) {
                                byteBuffer2.b((byte) (((i4 / 10) % 10) + 48));
                                int i5 = i4 % 10;
                                if (i5 != 0) {
                                    byteBuffer2.b((byte) (i5 + 48));
                                }
                            }
                        }
                    }
                    return null;
                } else {
                    int i6 = (int) (d4 * ((double) AacUtil.f12876f));
                    StringBuilder sb = new StringBuilder();
                    if (z) {
                        sb.append('-');
                    }
                    sb.append("0.");
                    while (true) {
                        i3 /= 10;
                        if (i6 >= i3) {
                            break;
                        }
                        sb.append('0');
                    }
                    sb.append(i6);
                    int length = sb.length() - 1;
                    while (sb.charAt(length) == '0') {
                        length--;
                    }
                    sb.setLength(length + 1);
                    return sb.toString();
                }
            } else if (d3 <= 32767.0d) {
                int i7 = (int) ((d3 + 0.005d) * 100.0d);
                int i8 = Y;
                if (i7 >= i8 || (bArr = Z[i7]) == null) {
                    if (byteBuffer2 != null) {
                        if (i7 < i8) {
                            int i9 = i7 >= 1000000 ? 5 : i7 >= 100000 ? 4 : i7 >= 10000 ? 3 : i7 >= 1000 ? 2 : i7 >= 100 ? 1 : 0;
                            int i10 = i7 % 100;
                            if (i10 != 0) {
                                i9 += 2;
                            }
                            int i11 = i7 % 10;
                            if (i11 != 0) {
                                i9++;
                            }
                            byte[] bArr2 = new byte[i9];
                            if (i7 >= 1000000) {
                                bArr2[0] = Z2[i7 / 1000000];
                                i2 = 1;
                            }
                            if (i7 >= 100000) {
                                bArr2[i2] = Z2[(i7 / AacUtil.f12876f) % 10];
                                i2++;
                            }
                            if (i7 >= 10000) {
                                bArr2[i2] = Z2[(i7 / 10000) % 10];
                                i2++;
                            }
                            if (i7 >= 1000) {
                                bArr2[i2] = Z2[(i7 / 1000) % 10];
                                i2++;
                            }
                            if (i7 >= 100) {
                                bArr2[i2] = Z2[(i7 / 100) % 10];
                                i2++;
                            }
                            if (i10 != 0) {
                                int i12 = i2 + 1;
                                bArr2[i2] = 46;
                                int i13 = i2 + 2;
                                byte[] bArr3 = Z2;
                                bArr2[i12] = bArr3[(i7 / 10) % 10];
                                if (i11 != 0) {
                                    bArr2[i13] = bArr3[i11];
                                }
                            }
                            Z[i7] = bArr2;
                        }
                        if (z) {
                            byteBuffer2.b((byte) 45);
                        }
                        if (i7 >= 1000000) {
                            byteBuffer2.b(Z2[i7 / 1000000]);
                        }
                        if (i7 >= 100000) {
                            byteBuffer2.b(Z2[(i7 / AacUtil.f12876f) % 10]);
                        }
                        if (i7 >= 10000) {
                            byteBuffer2.b(Z2[(i7 / 10000) % 10]);
                        }
                        if (i7 >= 1000) {
                            byteBuffer2.b(Z2[(i7 / 1000) % 10]);
                        }
                        if (i7 >= 100) {
                            byteBuffer2.b(Z2[(i7 / 100) % 10]);
                        }
                        if (i7 % 100 == 0) {
                            return null;
                        }
                        byteBuffer2.b((byte) 46);
                        byte[] bArr4 = Z2;
                        byteBuffer2.b(bArr4[(i7 / 10) % 10]);
                        int i14 = i7 % 10;
                        if (i14 == 0) {
                            return null;
                        }
                        byteBuffer2.b(bArr4[i14]);
                        return null;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    if (z) {
                        sb2.append('-');
                    }
                    if (i7 >= 1000000) {
                        sb2.append(Y2[i7 / 1000000]);
                    }
                    if (i7 >= 100000) {
                        sb2.append(Y2[(i7 / AacUtil.f12876f) % 10]);
                    }
                    if (i7 >= 10000) {
                        sb2.append(Y2[(i7 / 10000) % 10]);
                    }
                    if (i7 >= 1000) {
                        sb2.append(Y2[(i7 / 1000) % 10]);
                    }
                    if (i7 >= 100) {
                        sb2.append(Y2[(i7 / 100) % 10]);
                    }
                    if (i7 % 100 != 0) {
                        sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                        char[] cArr = Y2;
                        sb2.append(cArr[(i7 / 10) % 10]);
                        int i15 = i7 % 10;
                        if (i15 != 0) {
                            sb2.append(cArr[i15]);
                        }
                    }
                    return sb2.toString();
                } else if (byteBuffer2 != null) {
                    if (z) {
                        byteBuffer2.b((byte) 45);
                    }
                    byteBuffer2.n(Z[i7]);
                    return null;
                } else {
                    String d5 = PdfEncodings.d(bArr, (String) null);
                    if (!z) {
                        return d5;
                    }
                    return "-" + d5;
                }
            } else {
                long j2 = (long) (d3 + 0.5d);
                if (!z) {
                    return Long.toString(j2);
                }
                return "-" + Long.toString(j2);
            }
        } else if (byteBuffer2 == null) {
            return "0";
        } else {
            byteBuffer2.b(X2);
            return null;
        }
    }

    public static void y(int i2) {
        if (i2 > 3276700) {
            i2 = 3276700;
        }
        int i3 = Y;
        if (i2 > i3) {
            byte[][] bArr = new byte[i2][];
            System.arraycopy(Z, 0, bArr, 0, i3);
            Z = bArr;
            Y = i2;
        }
    }

    public void A(int i2) {
        if (i2 > this.s || i2 < 0) {
            throw new IndexOutOfBoundsException(MessageLocalization.b("the.new.size.must.be.positive.and.lt.eq.of.the.current.size", new Object[0]));
        }
        this.s = i2;
    }

    public int C() {
        return this.s;
    }

    public byte[] F() {
        int i2 = this.s;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.X, 0, bArr, 0, i2);
        return bArr;
    }

    public String G(String str) throws UnsupportedEncodingException {
        return new String(this.X, 0, this.s, str);
    }

    public void H(OutputStream outputStream) throws IOException {
        outputStream.write(this.X, 0, this.s);
    }

    public ByteBuffer b(byte b2) {
        return r(b2);
    }

    public ByteBuffer c(char c2) {
        return r(c2);
    }

    public ByteBuffer d(double d2) {
        k(v(d2, this));
        return this;
    }

    public ByteBuffer e(float f2) {
        return d((double) f2);
    }

    public ByteBuffer f(int i2) {
        return d((double) i2);
    }

    public ByteBuffer h(long j2) {
        return k(Long.toString(j2));
    }

    public ByteBuffer i(ByteBuffer byteBuffer) {
        return p(byteBuffer.X, 0, byteBuffer.s);
    }

    public ByteBuffer k(String str) {
        return str != null ? n(DocWriter.E(str)) : this;
    }

    public ByteBuffer n(byte[] bArr) {
        return p(bArr, 0, bArr.length);
    }

    public ByteBuffer p(byte[] bArr, int i2, int i3) {
        int i4;
        if (i2 >= 0 && i2 <= bArr.length && i3 >= 0 && (i4 = i2 + i3) <= bArr.length && i4 >= 0 && i3 != 0) {
            int i5 = this.s + i3;
            byte[] bArr2 = this.X;
            if (i5 > bArr2.length) {
                byte[] bArr3 = new byte[Math.max(bArr2.length << 1, i5)];
                System.arraycopy(this.X, 0, bArr3, 0, this.s);
                this.X = bArr3;
            }
            System.arraycopy(bArr, i2, this.X, this.s, i3);
            this.s = i5;
        }
        return this;
    }

    public ByteBuffer q(byte b2) {
        byte[] bArr = Z2;
        b(bArr[(b2 >> 4) & 15]);
        return b(bArr[b2 & 15]);
    }

    public ByteBuffer r(int i2) {
        int i3 = this.s + 1;
        byte[] bArr = this.X;
        if (i3 > bArr.length) {
            byte[] bArr2 = new byte[Math.max(bArr.length << 1, i3)];
            System.arraycopy(this.X, 0, bArr2, 0, this.s);
            this.X = bArr2;
        }
        this.X[this.s] = (byte) i2;
        this.s = i3;
        return this;
    }

    public String toString() {
        return new String(this.X, 0, this.s);
    }

    public byte[] w() {
        return this.X;
    }

    public void write(int i2) throws IOException {
        b((byte) i2);
    }

    public void x() {
        this.s = 0;
    }

    public ByteBuffer(int i2) {
        this.X = new byte[(i2 < 1 ? 128 : i2)];
    }

    public void write(byte[] bArr, int i2, int i3) {
        p(bArr, i2, i3);
    }
}
