package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;

abstract class RFC1522Codec {
    protected static final String POSTFIX = "?=";
    protected static final String PREFIX = "=?";
    protected static final char SEP = '?';

    RFC1522Codec() {
    }

    /* access modifiers changed from: protected */
    public String decodeText(String str) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(PREFIX) || !str.endsWith(POSTFIX)) {
            throw new DecoderException("RFC 1522 violation: malformed encoded content");
        }
        int length = str.length() - 2;
        int indexOf = str.indexOf(63, 2);
        if (indexOf != length) {
            String substring = str.substring(2, indexOf);
            if (!substring.equals("")) {
                int i2 = indexOf + 1;
                int indexOf2 = str.indexOf(63, i2);
                if (indexOf2 != length) {
                    String substring2 = str.substring(i2, indexOf2);
                    if (getEncoding().equalsIgnoreCase(substring2)) {
                        int i3 = indexOf2 + 1;
                        return new String(doDecoding(StringUtils.getBytesUsAscii(str.substring(i3, str.indexOf(63, i3)))), substring);
                    }
                    throw new DecoderException("This codec cannot decode " + substring2 + " encoded content");
                }
                throw new DecoderException("RFC 1522 violation: encoding token not found");
            }
            throw new DecoderException("RFC 1522 violation: charset not specified");
        }
        throw new DecoderException("RFC 1522 violation: charset token not found");
    }

    /* access modifiers changed from: protected */
    public abstract byte[] doDecoding(byte[] bArr) throws DecoderException;

    /* access modifiers changed from: protected */
    public abstract byte[] doEncoding(byte[] bArr) throws EncoderException;

    /* access modifiers changed from: protected */
    public String encodeText(String str, String str2) throws EncoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return encodeText(str, Charset.forName(str2));
    }

    /* access modifiers changed from: protected */
    public abstract String getEncoding();

    /* access modifiers changed from: protected */
    public String encodeText(String str, Charset charset) throws EncoderException {
        if (str == null) {
            return null;
        }
        return PREFIX + charset + SEP + getEncoding() + SEP + StringUtils.newStringUsAscii(doEncoding(str.getBytes(charset))) + POSTFIX;
    }
}
