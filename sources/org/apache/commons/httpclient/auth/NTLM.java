package org.apache.commons.httpclient.auth;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.util.EncodingUtil;

final class NTLM {
    public static final String DEFAULT_CHARSET = "ASCII";
    private String credentialCharset = DEFAULT_CHARSET;
    private int currentPosition = 0;
    private byte[] currentResponse;

    NTLM() {
    }

    private void addByte(byte b2) {
        byte[] bArr = this.currentResponse;
        int i2 = this.currentPosition;
        bArr[i2] = b2;
        this.currentPosition = i2 + 1;
    }

    private void addBytes(byte[] bArr) {
        for (byte b2 : bArr) {
            byte[] bArr2 = this.currentResponse;
            int i2 = this.currentPosition;
            bArr2[i2] = b2;
            this.currentPosition = i2 + 1;
        }
    }

    private void calcResp(byte[] bArr, byte[] bArr2, byte[] bArr3) throws AuthenticationException {
        byte[] bArr4 = new byte[7];
        byte[] bArr5 = new byte[7];
        byte[] bArr6 = new byte[7];
        for (int i2 = 0; i2 < 7; i2++) {
            bArr4[i2] = bArr[i2];
        }
        for (int i3 = 0; i3 < 7; i3++) {
            bArr5[i3] = bArr[i3 + 7];
        }
        for (int i4 = 0; i4 < 7; i4++) {
            bArr6[i4] = bArr[i4 + 14];
        }
        byte[] encrypt = encrypt(bArr4, bArr2);
        byte[] encrypt2 = encrypt(bArr5, bArr2);
        byte[] encrypt3 = encrypt(bArr6, bArr2);
        for (int i5 = 0; i5 < 8; i5++) {
            bArr3[i5] = encrypt[i5];
        }
        for (int i6 = 0; i6 < 8; i6++) {
            bArr3[i6 + 8] = encrypt2[i6];
        }
        for (int i7 = 0; i7 < 8; i7++) {
            bArr3[i7 + 16] = encrypt3[i7];
        }
    }

    private byte[] convertShort(int i2) {
        String num = Integer.toString(i2, 16);
        while (num.length() < 4) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("0");
            stringBuffer.append(num);
            num = stringBuffer.toString();
        }
        return new byte[]{(byte) Integer.parseInt(num.substring(2, 4), 16), (byte) Integer.parseInt(num.substring(0, 2), 16)};
    }

    private byte[] encrypt(byte[] bArr, byte[] bArr2) throws AuthenticationException {
        try {
            return getCipher(bArr).doFinal(bArr2);
        } catch (IllegalBlockSizeException e2) {
            throw new AuthenticationException("Invalid block size for DES encryption.", e2);
        } catch (BadPaddingException e3) {
            throw new AuthenticationException("Data not padded correctly for DES encryption.", e3);
        }
    }

    private Cipher getCipher(byte[] bArr) throws AuthenticationException {
        try {
            Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
            instance.init(1, new SecretKeySpec(setupKey(bArr), "DES"));
            return instance;
        } catch (NoSuchAlgorithmException e2) {
            throw new AuthenticationException("DES encryption is not available.", e2);
        } catch (InvalidKeyException e3) {
            throw new AuthenticationException("Invalid key for DES encryption.", e3);
        } catch (NoSuchPaddingException e4) {
            throw new AuthenticationException("NoPadding option for DES is not available.", e4);
        }
    }

    private String getResponse() {
        byte[] bArr = this.currentResponse;
        int length = bArr.length;
        int i2 = this.currentPosition;
        if (length > i2) {
            bArr = new byte[i2];
            for (int i3 = 0; i3 < this.currentPosition; i3++) {
                bArr[i3] = this.currentResponse[i3];
            }
        }
        return EncodingUtil.getAsciiString(Base64.encodeBase64(bArr));
    }

    private byte[] hashPassword(String str, byte[] bArr) throws AuthenticationException {
        byte[] bytes = EncodingUtil.getBytes(str.toUpperCase(), this.credentialCharset);
        byte[] bArr2 = new byte[7];
        byte[] bArr3 = new byte[7];
        int length = bytes.length;
        if (length > 7) {
            length = 7;
        }
        int i2 = 0;
        while (i2 < length) {
            bArr2[i2] = bytes[i2];
            i2++;
        }
        while (i2 < 7) {
            bArr2[i2] = 0;
            i2++;
        }
        int length2 = bytes.length;
        if (length2 > 14) {
            length2 = 14;
        }
        int i3 = 7;
        while (i3 < length2) {
            bArr3[i3 - 7] = bytes[i3];
            i3++;
        }
        while (i3 < 14) {
            bArr3[i3 - 7] = 0;
            i3++;
        }
        byte[] bArr4 = {75, 71, 83, 33, SignedBytes.f22967a, 35, 36, 37};
        byte[] encrypt = encrypt(bArr2, bArr4);
        byte[] encrypt2 = encrypt(bArr3, bArr4);
        byte[] bArr5 = new byte[21];
        for (int i4 = 0; i4 < encrypt.length; i4++) {
            bArr5[i4] = encrypt[i4];
        }
        for (int i5 = 0; i5 < encrypt2.length; i5++) {
            bArr5[i5 + 8] = encrypt2[i5];
        }
        for (int i6 = 0; i6 < 5; i6++) {
            bArr5[i6 + 16] = 0;
        }
        byte[] bArr6 = new byte[24];
        calcResp(bArr5, bArr, bArr6);
        return bArr6;
    }

    private void prepareResponse(int i2) {
        this.currentResponse = new byte[i2];
        this.currentPosition = 0;
    }

    private byte[] setupKey(byte[] bArr) {
        byte[] bArr2 = {(byte) ((bArr[0] >> 1) & 255), (byte) ((((bArr[0] & 1) << 6) | (((bArr[1] & 255) >> 2) & 255)) & 255), (byte) ((((bArr[1] & 3) << 5) | (((bArr[2] & 255) >> 3) & 255)) & 255), (byte) ((((bArr[2] & 7) << 4) | (((bArr[3] & 255) >> 4) & 255)) & 255), (byte) ((((bArr[3] & 15) << 3) | (((bArr[4] & 255) >> 5) & 255)) & 255), (byte) ((((bArr[4] & Ascii.I) << 2) | (((bArr[5] & 255) >> 6) & 255)) & 255), (byte) ((((bArr[5] & Utf8.f31404a) << 1) | (((bArr[6] & 255) >> 7) & 255)) & 255), (byte) (bArr[6] & Byte.MAX_VALUE)};
        for (int i2 = 0; i2 < 8; i2++) {
            bArr2[i2] = (byte) (bArr2[i2] << 1);
        }
        return bArr2;
    }

    public String getCredentialCharset() {
        return this.credentialCharset;
    }

    public final String getResponseFor(String str, String str2, String str3, String str4, String str5) throws AuthenticationException {
        if (str == null || str.trim().equals("")) {
            return getType1Message(str4, str5);
        }
        return getType3Message(str2, str3, str4, str5, parseType2Message(str));
    }

    public String getType1Message(String str, String str2) {
        String upperCase = str.toUpperCase();
        String upperCase2 = str2.toUpperCase();
        byte[] bytes = EncodingUtil.getBytes(upperCase, DEFAULT_CHARSET);
        byte[] bytes2 = EncodingUtil.getBytes(upperCase2, DEFAULT_CHARSET);
        prepareResponse(bytes.length + 32 + bytes2.length);
        addBytes(EncodingUtil.getBytes("NTLMSSP", DEFAULT_CHARSET));
        addByte((byte) 0);
        addByte((byte) 1);
        addByte((byte) 0);
        addByte((byte) 0);
        addByte((byte) 0);
        addByte((byte) 6);
        addByte((byte) 82);
        addByte((byte) 0);
        addByte((byte) 0);
        byte[] convertShort = convertShort(bytes2.length);
        addByte(convertShort[0]);
        addByte(convertShort[1]);
        addByte(convertShort[0]);
        addByte(convertShort[1]);
        byte[] convertShort2 = convertShort(bytes.length + 32);
        addByte(convertShort2[0]);
        addByte(convertShort2[1]);
        addByte((byte) 0);
        addByte((byte) 0);
        byte[] convertShort3 = convertShort(bytes.length);
        addByte(convertShort3[0]);
        addByte(convertShort3[1]);
        addByte(convertShort3[0]);
        addByte(convertShort3[1]);
        byte[] convertShort4 = convertShort(32);
        addByte(convertShort4[0]);
        addByte(convertShort4[1]);
        addByte((byte) 0);
        addByte((byte) 0);
        addBytes(bytes);
        addBytes(bytes2);
        return getResponse();
    }

    public String getType3Message(String str, String str2, String str3, String str4, byte[] bArr) throws AuthenticationException {
        String upperCase = str4.toUpperCase();
        String upperCase2 = str3.toUpperCase();
        String upperCase3 = str.toUpperCase();
        byte[] bytes = EncodingUtil.getBytes(upperCase, DEFAULT_CHARSET);
        byte[] bytes2 = EncodingUtil.getBytes(upperCase2, DEFAULT_CHARSET);
        byte[] bytes3 = EncodingUtil.getBytes(upperCase3, this.credentialCharset);
        int length = bytes.length;
        int length2 = bytes2.length;
        int length3 = bytes3.length;
        int i2 = 88 + length + length3 + length2;
        prepareResponse(i2);
        addBytes(EncodingUtil.getBytes("NTLMSSP", DEFAULT_CHARSET));
        addByte((byte) 0);
        addByte((byte) 3);
        addByte((byte) 0);
        addByte((byte) 0);
        addByte((byte) 0);
        addBytes(convertShort(24));
        addBytes(convertShort(24));
        addBytes(convertShort(i2 - 24));
        addByte((byte) 0);
        addByte((byte) 0);
        addBytes(convertShort(0));
        addBytes(convertShort(0));
        addBytes(convertShort(i2));
        addByte((byte) 0);
        addByte((byte) 0);
        addBytes(convertShort(length));
        addBytes(convertShort(length));
        addBytes(convertShort(64));
        addByte((byte) 0);
        addByte((byte) 0);
        addBytes(convertShort(length3));
        addBytes(convertShort(length3));
        int i3 = length + 64;
        addBytes(convertShort(i3));
        addByte((byte) 0);
        addByte((byte) 0);
        addBytes(convertShort(length2));
        addBytes(convertShort(length2));
        addBytes(convertShort(i3 + length3));
        for (int i4 = 0; i4 < 6; i4++) {
            addByte((byte) 0);
        }
        addBytes(convertShort(i2));
        addByte((byte) 0);
        addByte((byte) 0);
        addByte((byte) 6);
        addByte((byte) 82);
        addByte((byte) 0);
        addByte((byte) 0);
        addBytes(bytes);
        addBytes(bytes3);
        addBytes(bytes2);
        addBytes(hashPassword(str2, bArr));
        return getResponse();
    }

    public byte[] parseType2Message(String str) {
        byte[] decodeBase64 = Base64.decodeBase64(EncodingUtil.getBytes(str, DEFAULT_CHARSET));
        byte[] bArr = new byte[8];
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2] = decodeBase64[i2 + 24];
        }
        return bArr;
    }

    public void setCredentialCharset(String str) {
        this.credentialCharset = str;
    }
}
