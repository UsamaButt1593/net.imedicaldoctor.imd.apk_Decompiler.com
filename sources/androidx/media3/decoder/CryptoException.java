package androidx.media3.decoder;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public class CryptoException extends Exception {
    public final int s;

    public CryptoException(int i2, String str) {
        super(str);
        this.s = i2;
    }
}
