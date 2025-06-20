package com.itextpdf.text.pdf.crypto;

import org.spongycastle.crypto.engines.AESFastEngine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class AESCipher {

    /* renamed from: a  reason: collision with root package name */
    private PaddedBufferedBlockCipher f26774a = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESFastEngine()));

    public AESCipher(boolean z, byte[] bArr, byte[] bArr2) {
        this.f26774a.init(z, new ParametersWithIV(new KeyParameter(bArr), bArr2));
    }

    public byte[] a() {
        int outputSize = this.f26774a.getOutputSize(0);
        byte[] bArr = new byte[outputSize];
        try {
            int doFinal = this.f26774a.doFinal(bArr, 0);
            if (doFinal != outputSize) {
                byte[] bArr2 = new byte[doFinal];
                System.arraycopy(bArr, 0, bArr2, 0, doFinal);
                return bArr2;
            }
        } catch (Exception unused) {
        }
        return bArr;
    }

    public byte[] b(byte[] bArr, int i2, int i3) {
        int updateOutputSize = this.f26774a.getUpdateOutputSize(i3);
        byte[] bArr2 = updateOutputSize > 0 ? new byte[updateOutputSize] : null;
        this.f26774a.processBytes(bArr, i2, i3, bArr2, 0);
        return bArr2;
    }
}
