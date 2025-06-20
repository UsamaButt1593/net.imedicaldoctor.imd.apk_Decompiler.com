package com.google.firebase.installations;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

public class RandomFidGenerator {

    /* renamed from: a  reason: collision with root package name */
    private static final byte f24432a = Byte.parseByte("01110000", 2);

    /* renamed from: b  reason: collision with root package name */
    private static final byte f24433b = Byte.parseByte("00001111", 2);

    /* renamed from: c  reason: collision with root package name */
    private static final int f24434c = 22;

    private static String b(byte[] bArr) {
        return new String(Base64.encode(bArr, 11), Charset.defaultCharset()).substring(0, 22);
    }

    private static byte[] c(UUID uuid, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        return wrap.array();
    }

    @NonNull
    public String a() {
        byte[] c2 = c(UUID.randomUUID(), new byte[17]);
        byte b2 = c2[0];
        c2[16] = b2;
        c2[0] = (byte) ((b2 & f24433b) | f24432a);
        return b(c2);
    }
}
