package org.apache.commons.codec.net;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec implements BinaryEncoder, BinaryDecoder, StringEncoder, StringDecoder {
    protected static final byte ESCAPE_CHAR = 37;
    @Deprecated
    protected static final BitSet WWW_FORM_URL;
    private static final BitSet WWW_FORM_URL_SAFE = new BitSet(256);
    @Deprecated
    protected volatile String charset;

    static {
        for (int i2 = 97; i2 <= 122; i2++) {
            WWW_FORM_URL_SAFE.set(i2);
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            WWW_FORM_URL_SAFE.set(i3);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            WWW_FORM_URL_SAFE.set(i4);
        }
        BitSet bitSet = WWW_FORM_URL_SAFE;
        bitSet.set(45);
        bitSet.set(95);
        bitSet.set(46);
        bitSet.set(42);
        bitSet.set(32);
        WWW_FORM_URL = (BitSet) bitSet.clone();
    }

    public URLCodec() {
        this("UTF-8");
    }

    public static final byte[] decodeUrl(byte[] bArr) throws DecoderException {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < bArr.length) {
            byte b2 = bArr[i2];
            if (b2 == 43) {
                b2 = 32;
            } else if (b2 == 37) {
                try {
                    int digit16 = Utils.digit16(bArr[i2 + 1]);
                    i2 += 2;
                    byteArrayOutputStream.write((char) ((digit16 << 4) + Utils.digit16(bArr[i2])));
                    i2++;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new DecoderException("Invalid URL encoding: ", e2);
                }
            }
            byteArrayOutputStream.write(b2);
            i2++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] encodeUrl(java.util.BitSet r5, byte[] r6) {
        /*
            if (r6 != 0) goto L_0x0004
            r5 = 0
            return r5
        L_0x0004:
            if (r5 != 0) goto L_0x0008
            java.util.BitSet r5 = WWW_FORM_URL_SAFE
        L_0x0008:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            int r1 = r6.length
            r2 = 0
        L_0x000f:
            if (r2 >= r1) goto L_0x003d
            byte r3 = r6[r2]
            if (r3 >= 0) goto L_0x0017
            int r3 = r3 + 256
        L_0x0017:
            boolean r4 = r5.get(r3)
            if (r4 == 0) goto L_0x0027
            r4 = 32
            if (r3 != r4) goto L_0x0023
            r3 = 43
        L_0x0023:
            r0.write(r3)
            goto L_0x003a
        L_0x0027:
            r4 = 37
            r0.write(r4)
            int r4 = r3 >> 4
            char r4 = org.apache.commons.codec.net.Utils.hexDigit(r4)
            char r3 = org.apache.commons.codec.net.Utils.hexDigit(r3)
            r0.write(r4)
            goto L_0x0023
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x003d:
            byte[] r5 = r0.toByteArray()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.net.URLCodec.encodeUrl(java.util.BitSet, byte[]):byte[]");
    }

    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Objects of type " + obj.getClass().getName() + " cannot be URL decoded");
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be URL encoded");
    }

    public String getDefaultCharset() {
        return this.charset;
    }

    @Deprecated
    public String getEncoding() {
        return this.charset;
    }

    public URLCodec(String str) {
        this.charset = str;
    }

    public String decode(String str) throws DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return decode(str, getDefaultCharset());
        } catch (UnsupportedEncodingException e2) {
            throw new DecoderException(e2.getMessage(), e2);
        }
    }

    public String encode(String str) throws EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return encode(str, getDefaultCharset());
        } catch (UnsupportedEncodingException e2) {
            throw new EncoderException(e2.getMessage(), e2);
        }
    }

    public String decode(String str, String str2) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new String(decode(StringUtils.getBytesUsAscii(str)), str2);
    }

    public String encode(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return StringUtils.newStringUsAscii(encode(str.getBytes(str2)));
    }

    public byte[] decode(byte[] bArr) throws DecoderException {
        return decodeUrl(bArr);
    }

    public byte[] encode(byte[] bArr) {
        return encodeUrl(WWW_FORM_URL_SAFE, bArr);
    }
}
