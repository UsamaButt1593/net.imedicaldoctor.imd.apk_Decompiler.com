package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.ArrayList;

public class FontSelector {

    /* renamed from: a  reason: collision with root package name */
    protected ArrayList<Font> f26062a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    protected Font f26063b = null;

    public void a(Font font) {
        if (font.c() != null) {
            this.f26062a.add(font);
            return;
        }
        this.f26062a.add(new Font(font.e(true), font.m(), font.h(), font.i()));
    }

    public Phrase b(String str) {
        if (this.f26062a.size() != 0) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            StringBuffer stringBuffer = new StringBuffer();
            Phrase phrase = new Phrase();
            this.f26063b = null;
            for (int i2 = 0; i2 < length; i2++) {
                Chunk c2 = c(charArray, i2, stringBuffer);
                if (c2 != null) {
                    phrase.add(c2);
                }
            }
            if (stringBuffer.length() > 0) {
                String stringBuffer2 = stringBuffer.toString();
                Font font = this.f26063b;
                if (font == null) {
                    font = this.f26062a.get(0);
                }
                phrase.add(new Chunk(stringBuffer2, font));
            }
            return phrase;
        }
        throw new IndexOutOfBoundsException(MessageLocalization.b("no.font.is.defined", new Object[0]));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008f, code lost:
        if (r8.f26063b == r10) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0095, code lost:
        if (r11.length() <= 0) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0099, code lost:
        if (r8.f26063b == null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009b, code lost:
        r2 = new com.itextpdf.text.Chunk(r11.toString(), r8.f26063b);
        r11.setLength(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a9, code lost:
        r8.f26063b = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Chunk c(char[] r9, int r10, java.lang.StringBuffer r11) {
        /*
            r8 = this;
            char r0 = r9[r10]
            r1 = 10
            r2 = 0
            if (r0 == r1) goto L_0x00ab
            r1 = 13
            if (r0 != r1) goto L_0x000d
            goto L_0x00ab
        L_0x000d:
            boolean r1 = com.itextpdf.text.Utilities.o(r9, r10)
            r3 = 16
            r4 = 0
            if (r1 == 0) goto L_0x0068
            int r1 = com.itextpdf.text.Utilities.g(r9, r10)
            r5 = 0
        L_0x001b:
            java.util.ArrayList<com.itextpdf.text.Font> r6 = r8.f26062a
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x00ae
            java.util.ArrayList<com.itextpdf.text.Font> r6 = r8.f26062a
            java.lang.Object r6 = r6.get(r5)
            com.itextpdf.text.Font r6 = (com.itextpdf.text.Font) r6
            com.itextpdf.text.pdf.BaseFont r7 = r6.c()
            boolean r7 = r7.c(r1)
            if (r7 != 0) goto L_0x003f
            int r7 = java.lang.Character.getType(r1)
            if (r7 != r3) goto L_0x003c
            goto L_0x003f
        L_0x003c:
            int r5 = r5 + 1
            goto L_0x001b
        L_0x003f:
            com.itextpdf.text.Font r1 = r8.f26063b
            if (r1 == r6) goto L_0x005d
            int r1 = r11.length()
            if (r1 <= 0) goto L_0x005b
            com.itextpdf.text.Font r1 = r8.f26063b
            if (r1 == 0) goto L_0x005b
            com.itextpdf.text.Chunk r2 = new com.itextpdf.text.Chunk
            java.lang.String r1 = r11.toString()
            com.itextpdf.text.Font r3 = r8.f26063b
            r2.<init>((java.lang.String) r1, (com.itextpdf.text.Font) r3)
            r11.setLength(r4)
        L_0x005b:
            r8.f26063b = r6
        L_0x005d:
            r11.append(r0)
            int r10 = r10 + 1
            char r9 = r9[r10]
            r11.append(r9)
            goto L_0x00ae
        L_0x0068:
            r9 = 0
        L_0x0069:
            java.util.ArrayList<com.itextpdf.text.Font> r10 = r8.f26062a
            int r10 = r10.size()
            if (r9 >= r10) goto L_0x00ae
            java.util.ArrayList<com.itextpdf.text.Font> r10 = r8.f26062a
            java.lang.Object r10 = r10.get(r9)
            com.itextpdf.text.Font r10 = (com.itextpdf.text.Font) r10
            com.itextpdf.text.pdf.BaseFont r1 = r10.c()
            boolean r1 = r1.c(r0)
            if (r1 != 0) goto L_0x008d
            int r1 = java.lang.Character.getType(r0)
            if (r1 != r3) goto L_0x008a
            goto L_0x008d
        L_0x008a:
            int r9 = r9 + 1
            goto L_0x0069
        L_0x008d:
            com.itextpdf.text.Font r9 = r8.f26063b
            if (r9 == r10) goto L_0x00ab
            int r9 = r11.length()
            if (r9 <= 0) goto L_0x00a9
            com.itextpdf.text.Font r9 = r8.f26063b
            if (r9 == 0) goto L_0x00a9
            com.itextpdf.text.Chunk r2 = new com.itextpdf.text.Chunk
            java.lang.String r9 = r11.toString()
            com.itextpdf.text.Font r1 = r8.f26063b
            r2.<init>((java.lang.String) r9, (com.itextpdf.text.Font) r1)
            r11.setLength(r4)
        L_0x00a9:
            r8.f26063b = r10
        L_0x00ab:
            r11.append(r0)
        L_0x00ae:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.FontSelector.c(char[], int, java.lang.StringBuffer):com.itextpdf.text.Chunk");
    }
}
