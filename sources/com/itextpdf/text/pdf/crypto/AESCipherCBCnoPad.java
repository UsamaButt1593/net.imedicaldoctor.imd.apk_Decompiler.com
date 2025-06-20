package com.itextpdf.text.pdf.crypto;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.engines.AESFastEngine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;

public class AESCipherCBCnoPad {

    /* renamed from: a  reason: collision with root package name */
    private BlockCipher f26775a = new CBCBlockCipher(new AESFastEngine());

    public AESCipherCBCnoPad(boolean z, byte[] bArr) {
        this.f26775a.init(z, new KeyParameter(bArr));
    }

    public byte[] a(byte[] bArr, int i2, int i3) {
        if (i3 % this.f26775a.getBlockSize() == 0) {
            byte[] bArr2 = new byte[i3];
            int i4 = 0;
            while (i3 > 0) {
                this.f26775a.processBlock(bArr, i2, bArr2, i4);
                i3 -= this.f26775a.getBlockSize();
                i4 += this.f26775a.getBlockSize();
                i2 += this.f26775a.getBlockSize();
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Not multiple of block: " + i3);
    }
}
