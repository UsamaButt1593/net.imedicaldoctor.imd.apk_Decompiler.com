package org.apache.commons.codec.digest;

import java.util.Random;

class B64 {
    static final String B64T = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    B64() {
    }

    static void b64from24bit(byte b2, byte b3, byte b4, int i2, StringBuilder sb) {
        int i3 = ((b2 << 16) & 16777215) | ((b3 << 8) & 65535) | (b4 & 255);
        while (true) {
            int i4 = i2 - 1;
            if (i2 > 0) {
                sb.append(B64T.charAt(i3 & 63));
                i3 >>= 6;
                i2 = i4;
            } else {
                return;
            }
        }
    }

    static String getRandomSalt(int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 1; i3 <= i2; i3++) {
            sb.append(B64T.charAt(new Random().nextInt(64)));
        }
        return sb.toString();
    }
}
