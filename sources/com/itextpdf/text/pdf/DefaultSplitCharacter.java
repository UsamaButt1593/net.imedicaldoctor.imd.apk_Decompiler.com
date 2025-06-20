package com.itextpdf.text.pdf;

import com.itextpdf.text.SplitCharacter;

public class DefaultSplitCharacter implements SplitCharacter {

    /* renamed from: b  reason: collision with root package name */
    public static final SplitCharacter f26030b = new DefaultSplitCharacter();

    /* renamed from: a  reason: collision with root package name */
    protected char[] f26031a;

    public DefaultSplitCharacter() {
    }

    public boolean a(int i2, int i3, int i4, char[] cArr, PdfChunk[] pdfChunkArr) {
        char b2 = b(i3, cArr, pdfChunkArr);
        if (this.f26031a != null) {
            int i5 = 0;
            while (true) {
                char[] cArr2 = this.f26031a;
                if (i5 >= cArr2.length) {
                    return false;
                }
                if (b2 == cArr2[i5]) {
                    return true;
                }
                i5++;
            }
        } else if (b2 <= ' ' || b2 == '-' || b2 == 8208) {
            return true;
        } else {
            if (b2 < 8194) {
                return false;
            }
            if (b2 >= 8194 && b2 <= 8203) {
                return true;
            }
            if (b2 >= 11904 && b2 < 55200) {
                return true;
            }
            if (b2 >= 63744 && b2 < 64256) {
                return true;
            }
            if (b2 < 65072 || b2 >= 65104) {
                return b2 >= 65377 && b2 < 65440;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public char b(int i2, char[] cArr, PdfChunk[] pdfChunkArr) {
        return pdfChunkArr == null ? cArr[i2] : (char) pdfChunkArr[Math.min(i2, pdfChunkArr.length - 1)].r(cArr[i2]);
    }

    public DefaultSplitCharacter(char c2) {
        this(new char[]{c2});
    }

    public DefaultSplitCharacter(char[] cArr) {
        this.f26031a = cArr;
    }
}
