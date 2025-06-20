package org.apache.commons.codec.binary;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class Hex implements BinaryEncoder, BinaryDecoder {
    public static final Charset DEFAULT_CHARSET = Charsets.UTF_8;
    public static final String DEFAULT_CHARSET_NAME = "UTF-8";
    private static final char[] DIGITS_LOWER = {'0', '1', PdfWriter.p4, PdfWriter.q4, PdfWriter.r4, PdfWriter.s4, PdfWriter.t4, PdfWriter.u4, '8', '9', 'a', 'b', Barcode128.F, Barcode128.G, Barcode128.H, Barcode128.I};
    private static final char[] DIGITS_UPPER = {'0', '1', PdfWriter.p4, PdfWriter.q4, PdfWriter.r4, PdfWriter.s4, PdfWriter.t4, PdfWriter.u4, '8', '9', 'A', ASCIIPropertyListParser.u, 'C', ASCIIPropertyListParser.t, 'E', 'F'};
    private final Charset charset;

    public Hex() {
        this.charset = DEFAULT_CHARSET;
    }

    public static byte[] decodeHex(String str) throws DecoderException {
        return decodeHex(str.toCharArray());
    }

    public static char[] encodeHex(ByteBuffer byteBuffer) {
        return encodeHex(byteBuffer, true);
    }

    public static String encodeHexString(ByteBuffer byteBuffer) {
        return new String(encodeHex(byteBuffer));
    }

    protected static int toDigit(char c2, int i2) throws DecoderException {
        int digit = Character.digit(c2, 16);
        if (digit != -1) {
            return digit;
        }
        throw new DecoderException("Illegal hexadecimal character " + c2 + " at index " + i2);
    }

    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof String) {
            return decode((Object) ((String) obj).toCharArray());
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof ByteBuffer) {
            return decode((ByteBuffer) obj);
        }
        try {
            return decodeHex((char[]) obj);
        } catch (ClassCastException e2) {
            throw new DecoderException(e2.getMessage(), e2);
        }
    }

    public Object encode(Object obj) throws EncoderException {
        byte[] bArr;
        if (obj instanceof String) {
            bArr = ((String) obj).getBytes(getCharset());
        } else if (obj instanceof ByteBuffer) {
            bArr = ((ByteBuffer) obj).array();
        } else {
            try {
                bArr = (byte[]) obj;
            } catch (ClassCastException e2) {
                throw new EncoderException(e2.getMessage(), e2);
            }
        }
        return encodeHex(bArr);
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getCharsetName() {
        return this.charset.name();
    }

    public String toString() {
        return super.toString() + "[charsetName=" + this.charset + "]";
    }

    public Hex(String str) {
        this(Charset.forName(str));
    }

    public static byte[] decodeHex(char[] cArr) throws DecoderException {
        int length = cArr.length;
        if ((length & 1) == 0) {
            byte[] bArr = new byte[(length >> 1)];
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i2 + 1;
                i2 += 2;
                bArr[i3] = (byte) (((toDigit(cArr[i2], i2) << 4) | toDigit(cArr[i4], i4)) & 255);
                i3++;
            }
            return bArr;
        }
        throw new DecoderException("Odd number of characters.");
    }

    public static char[] encodeHex(ByteBuffer byteBuffer, boolean z) {
        return encodeHex(byteBuffer, z ? DIGITS_LOWER : DIGITS_UPPER);
    }

    public static String encodeHexString(ByteBuffer byteBuffer, boolean z) {
        return new String(encodeHex(byteBuffer, z));
    }

    public byte[] decode(ByteBuffer byteBuffer) throws DecoderException {
        return decodeHex(new String(byteBuffer.array(), getCharset()).toCharArray());
    }

    public byte[] encode(ByteBuffer byteBuffer) {
        return encodeHexString(byteBuffer).getBytes(getCharset());
    }

    public Hex(Charset charset2) {
        this.charset = charset2;
    }

    protected static char[] encodeHex(ByteBuffer byteBuffer, char[] cArr) {
        return encodeHex(byteBuffer.array(), cArr);
    }

    public static String encodeHexString(byte[] bArr) {
        return new String(encodeHex(bArr));
    }

    public byte[] decode(byte[] bArr) throws DecoderException {
        return decodeHex(new String(bArr, getCharset()).toCharArray());
    }

    public byte[] encode(byte[] bArr) {
        return encodeHexString(bArr).getBytes(getCharset());
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    public static String encodeHexString(byte[] bArr, boolean z) {
        return new String(encodeHex(bArr, z));
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        return encodeHex(bArr, z ? DIGITS_LOWER : DIGITS_UPPER);
    }

    protected static char[] encodeHex(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[(r0 << 1)];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            cArr2[i2] = cArr[(b2 & 240) >>> 4];
            i2 += 2;
            cArr2[i3] = cArr[b2 & 15];
        }
        return cArr2;
    }
}
