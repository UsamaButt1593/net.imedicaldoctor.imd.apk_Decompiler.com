package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.HashMap;

class EnumerateTTC extends TrueTypeFont {
    protected String[] b5;

    EnumerateTTC(String str) throws DocumentException, IOException {
        this.z4 = str;
        this.y4 = new RandomAccessFileOrArray(str);
        V0();
    }

    /* access modifiers changed from: package-private */
    public void V0() throws DocumentException, IOException {
        this.x4 = new HashMap<>();
        try {
            if (T0(4).equals("ttcf")) {
                this.y4.skipBytes(4);
                int readInt = this.y4.readInt();
                this.b5 = new String[readInt];
                int d2 = (int) this.y4.d();
                int i2 = 0;
                while (i2 < readInt) {
                    this.x4.clear();
                    this.y4.r((long) d2);
                    this.y4.skipBytes(i2 * 4);
                    int readInt2 = this.y4.readInt();
                    this.D4 = readInt2;
                    this.y4.r((long) readInt2);
                    if (this.y4.readInt() == 65536) {
                        int readUnsignedShort = this.y4.readUnsignedShort();
                        this.y4.skipBytes(6);
                        for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                            String T0 = T0(4);
                            this.y4.skipBytes(4);
                            this.x4.put(T0, new int[]{this.y4.readInt(), this.y4.readInt()});
                        }
                        this.b5[i2] = A0();
                        i2++;
                    } else {
                        throw new DocumentException(MessageLocalization.b("1.is.not.a.valid.ttf.file", this.z4));
                    }
                }
                RandomAccessFileOrArray randomAccessFileOrArray = this.y4;
                if (randomAccessFileOrArray != null) {
                    randomAccessFileOrArray.close();
                    return;
                }
                return;
            }
            throw new DocumentException(MessageLocalization.b("1.is.not.a.valid.ttc.file", this.z4));
        } catch (Throwable th) {
            RandomAccessFileOrArray randomAccessFileOrArray2 = this.y4;
            if (randomAccessFileOrArray2 != null) {
                randomAccessFileOrArray2.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public String[] W0() {
        return this.b5;
    }

    EnumerateTTC(byte[] bArr) throws DocumentException, IOException {
        this.z4 = "Byte array TTC";
        this.y4 = new RandomAccessFileOrArray(bArr);
        V0();
    }
}
