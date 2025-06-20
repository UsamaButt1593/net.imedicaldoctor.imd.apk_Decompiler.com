package com.itextpdf.text;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class FontFactoryImp implements FontProvider {

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f25702e = LoggerFactory.b(FontFactoryImp.class);

    /* renamed from: f  reason: collision with root package name */
    private static String[] f25703f = {ExifInterface.Z4, IcyHeaders.a3, "1033", ExifInterface.Z4, "0", "1033", IcyHeaders.a3, "0", "0", "0", ExifInterface.Z4, "0"};

    /* renamed from: a  reason: collision with root package name */
    private final Hashtable<String, String> f25704a;

    /* renamed from: b  reason: collision with root package name */
    private final Hashtable<String, ArrayList<String>> f25705b;

    /* renamed from: c  reason: collision with root package name */
    public String f25706c = "Cp1252";

    /* renamed from: d  reason: collision with root package name */
    public boolean f25707d = false;

    public FontFactoryImp() {
        Hashtable<String, String> hashtable = new Hashtable<>();
        this.f25704a = hashtable;
        Hashtable<String, ArrayList<String>> hashtable2 = new Hashtable<>();
        this.f25705b = hashtable2;
        hashtable.put("Courier".toLowerCase(), "Courier");
        hashtable.put("Courier-Bold".toLowerCase(), "Courier-Bold");
        hashtable.put("Courier-Oblique".toLowerCase(), "Courier-Oblique");
        hashtable.put("Courier-BoldOblique".toLowerCase(), "Courier-BoldOblique");
        hashtable.put("Helvetica".toLowerCase(), "Helvetica");
        hashtable.put("Helvetica-Bold".toLowerCase(), "Helvetica-Bold");
        hashtable.put("Helvetica-Oblique".toLowerCase(), "Helvetica-Oblique");
        hashtable.put("Helvetica-BoldOblique".toLowerCase(), "Helvetica-BoldOblique");
        hashtable.put("Symbol".toLowerCase(), "Symbol");
        hashtable.put("Times-Roman".toLowerCase(), "Times-Roman");
        hashtable.put("Times-Bold".toLowerCase(), "Times-Bold");
        hashtable.put("Times-Italic".toLowerCase(), "Times-Italic");
        hashtable.put("Times-BoldItalic".toLowerCase(), "Times-BoldItalic");
        hashtable.put("ZapfDingbats".toLowerCase(), "ZapfDingbats");
        ArrayList arrayList = new ArrayList();
        arrayList.add("Courier");
        arrayList.add("Courier-Bold");
        arrayList.add("Courier-Oblique");
        arrayList.add("Courier-BoldOblique");
        hashtable2.put("Courier".toLowerCase(), arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("Helvetica");
        arrayList2.add("Helvetica-Bold");
        arrayList2.add("Helvetica-Oblique");
        arrayList2.add("Helvetica-BoldOblique");
        hashtable2.put("Helvetica".toLowerCase(), arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add("Symbol");
        hashtable2.put("Symbol".toLowerCase(), arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add("Times-Roman");
        arrayList4.add("Times-Bold");
        arrayList4.add("Times-Italic");
        arrayList4.add("Times-BoldItalic");
        hashtable2.put(FontFactory.f25697j.toLowerCase(), arrayList4);
        hashtable2.put("Times-Roman".toLowerCase(), arrayList4);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add("ZapfDingbats");
        hashtable2.put("ZapfDingbats".toLowerCase(), arrayList5);
    }

    public Font a(String str, String str2, boolean z, float f2, int i2, BaseColor baseColor) {
        return p(str, str2, z, f2, i2, baseColor, true);
    }

    public boolean b(String str) {
        return this.f25704a.containsKey(str.toLowerCase());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r1 = r7.f25704a.get(r8.toLowerCase());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.BaseFont c(java.lang.String r8, java.lang.String r9, boolean r10, boolean r11) throws java.io.IOException, com.itextpdf.text.DocumentException {
        /*
            r7 = this;
            r5 = 0
            r6 = 1
            r4 = 0
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            com.itextpdf.text.pdf.BaseFont r0 = com.itextpdf.text.pdf.BaseFont.m(r0, r1, r2, r3, r4, r5, r6)     // Catch:{ DocumentException -> 0x000c }
            goto L_0x000d
        L_0x000c:
            r0 = 0
        L_0x000d:
            if (r0 != 0) goto L_0x0027
            java.util.Hashtable<java.lang.String, java.lang.String> r1 = r7.f25704a
            java.lang.String r8 = r8.toLowerCase()
            java.lang.Object r8 = r1.get(r8)
            r1 = r8
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0027
            r5 = 0
            r6 = 0
            r2 = r9
            r3 = r10
            r4 = r11
            com.itextpdf.text.pdf.BaseFont r0 = com.itextpdf.text.pdf.BaseFont.l(r1, r2, r3, r4, r5, r6)
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.FontFactoryImp.c(java.lang.String, java.lang.String, boolean, boolean):com.itextpdf.text.pdf.BaseFont");
    }

    public Font d(String str) {
        return a(str, this.f25706c, this.f25707d, -1.0f, -1, (BaseColor) null);
    }

    public Font e(String str, float f2) {
        return a(str, this.f25706c, this.f25707d, f2, -1, (BaseColor) null);
    }

    public Font f(String str, float f2, int i2) {
        return a(str, this.f25706c, this.f25707d, f2, i2, (BaseColor) null);
    }

    public Font g(String str, float f2, int i2, BaseColor baseColor) {
        return a(str, this.f25706c, this.f25707d, f2, i2, baseColor);
    }

    public Font h(String str, float f2, BaseColor baseColor) {
        return a(str, this.f25706c, this.f25707d, f2, -1, baseColor);
    }

    public Font i(String str, String str2) {
        return a(str, str2, this.f25707d, -1.0f, -1, (BaseColor) null);
    }

    public Font j(String str, String str2, float f2) {
        return a(str, str2, this.f25707d, f2, -1, (BaseColor) null);
    }

    public Font k(String str, String str2, float f2, int i2) {
        return a(str, str2, this.f25707d, f2, i2, (BaseColor) null);
    }

    public Font l(String str, String str2, float f2, int i2, BaseColor baseColor) {
        return a(str, str2, this.f25707d, f2, i2, baseColor);
    }

    public Font m(String str, String str2, boolean z) {
        return a(str, str2, z, -1.0f, -1, (BaseColor) null);
    }

    public Font n(String str, String str2, boolean z, float f2) {
        return a(str, str2, z, f2, -1, (BaseColor) null);
    }

    public Font o(String str, String str2, boolean z, float f2, int i2) {
        return a(str, str2, z, f2, i2, (BaseColor) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065 A[Catch:{ all -> 0x005b }, LOOP:0: B:13:0x002c->B:31:0x0065, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0063 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Font p(java.lang.String r15, java.lang.String r16, boolean r17, float r18, int r19, com.itextpdf.text.BaseColor r20, boolean r21) {
        /*
            r14 = this;
            r1 = r14
            r0 = r18
            r2 = r19
            r3 = r20
            if (r15 != 0) goto L_0x0011
            com.itextpdf.text.Font r4 = new com.itextpdf.text.Font
            com.itextpdf.text.Font$FontFamily r5 = com.itextpdf.text.Font.FontFamily.UNDEFINED
            r4.<init>((com.itextpdf.text.Font.FontFamily) r5, (float) r0, (int) r2, (com.itextpdf.text.BaseColor) r3)
            return r4
        L_0x0011:
            java.lang.String r4 = r15.toLowerCase()
            java.util.Hashtable<java.lang.String, java.util.ArrayList<java.lang.String>> r5 = r1.f25705b
            java.lang.Object r4 = r5.get(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            if (r4 == 0) goto L_0x0079
            monitor-enter(r4)
            r5 = 0
            r6 = -1
            if (r2 != r6) goto L_0x0026
            r7 = 0
            goto L_0x0027
        L_0x0026:
            r7 = r2
        L_0x0027:
            java.util.Iterator r8 = r4.iterator()     // Catch:{ all -> 0x005b }
            r9 = 0
        L_0x002c:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x005b }
            if (r10 == 0) goto L_0x0067
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x005b }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x005b }
            java.lang.String r10 = r9.toLowerCase()     // Catch:{ all -> 0x005b }
            java.lang.String r11 = "bold"
            int r11 = r10.indexOf(r11)     // Catch:{ all -> 0x005b }
            r12 = 1
            if (r11 == r6) goto L_0x0047
            r11 = 1
            goto L_0x0048
        L_0x0047:
            r11 = 0
        L_0x0048:
            java.lang.String r13 = "italic"
            int r13 = r10.indexOf(r13)     // Catch:{ all -> 0x005b }
            if (r13 != r6) goto L_0x005d
            java.lang.String r13 = "oblique"
            int r10 = r10.indexOf(r13)     // Catch:{ all -> 0x005b }
            if (r10 == r6) goto L_0x0059
            goto L_0x005d
        L_0x0059:
            r10 = r11
            goto L_0x005f
        L_0x005b:
            r0 = move-exception
            goto L_0x0077
        L_0x005d:
            r10 = r11 | 2
        L_0x005f:
            r11 = r7 & 3
            if (r11 != r10) goto L_0x0065
            r5 = 1
            goto L_0x0069
        L_0x0065:
            r9 = r10
            goto L_0x002c
        L_0x0067:
            r10 = r9
            r9 = r15
        L_0x0069:
            if (r2 == r6) goto L_0x006f
            if (r5 == 0) goto L_0x006f
            int r5 = ~r10     // Catch:{ all -> 0x005b }
            r2 = r2 & r5
        L_0x006f:
            monitor-exit(r4)     // Catch:{ all -> 0x005b }
        L_0x0070:
            r4 = r16
            r5 = r17
            r6 = r21
            goto L_0x007b
        L_0x0077:
            monitor-exit(r4)     // Catch:{ all -> 0x005b }
            throw r0
        L_0x0079:
            r9 = r15
            goto L_0x0070
        L_0x007b:
            com.itextpdf.text.pdf.BaseFont r4 = r14.c(r9, r4, r5, r6)     // Catch:{ DocumentException -> 0x0089, IOException -> 0x0099, NullPointerException -> 0x0091 }
            if (r4 != 0) goto L_0x008b
            com.itextpdf.text.Font r4 = new com.itextpdf.text.Font     // Catch:{ DocumentException -> 0x0089, IOException -> 0x0099, NullPointerException -> 0x0091 }
            com.itextpdf.text.Font$FontFamily r5 = com.itextpdf.text.Font.FontFamily.UNDEFINED     // Catch:{ DocumentException -> 0x0089, IOException -> 0x0099, NullPointerException -> 0x0091 }
            r4.<init>((com.itextpdf.text.Font.FontFamily) r5, (float) r0, (int) r2, (com.itextpdf.text.BaseColor) r3)     // Catch:{ DocumentException -> 0x0089, IOException -> 0x0099, NullPointerException -> 0x0091 }
            return r4
        L_0x0089:
            r0 = move-exception
            goto L_0x00a1
        L_0x008b:
            com.itextpdf.text.Font r5 = new com.itextpdf.text.Font
            r5.<init>((com.itextpdf.text.pdf.BaseFont) r4, (float) r0, (int) r2, (com.itextpdf.text.BaseColor) r3)
            return r5
        L_0x0091:
            com.itextpdf.text.Font r4 = new com.itextpdf.text.Font
            com.itextpdf.text.Font$FontFamily r5 = com.itextpdf.text.Font.FontFamily.UNDEFINED
            r4.<init>((com.itextpdf.text.Font.FontFamily) r5, (float) r0, (int) r2, (com.itextpdf.text.BaseColor) r3)
            return r4
        L_0x0099:
            com.itextpdf.text.Font r4 = new com.itextpdf.text.Font
            com.itextpdf.text.Font$FontFamily r5 = com.itextpdf.text.Font.FontFamily.UNDEFINED
            r4.<init>((com.itextpdf.text.Font.FontFamily) r5, (float) r0, (int) r2, (com.itextpdf.text.BaseColor) r3)
            return r4
        L_0x00a1:
            com.itextpdf.text.ExceptionConverter r2 = new com.itextpdf.text.ExceptionConverter
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.FontFactoryImp.p(java.lang.String, java.lang.String, boolean, float, int, com.itextpdf.text.BaseColor, boolean):com.itextpdf.text.Font");
    }

    public Set<String> q() {
        return this.f25705b.keySet();
    }

    public Set<String> r() {
        return this.f25704a.keySet();
    }

    public void s(String str) {
        t(str, (String) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0199 A[Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t(java.lang.String r14, java.lang.String r15) {
        /*
            r13 = this;
            r0 = 0
            r1 = 3
            r2 = 2
            r3 = 1
            java.lang.String r4 = r14.toLowerCase()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r5 = ".ttf"
            boolean r4 = r4.endsWith(r5)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r5 = "Cp1252"
            r6 = 0
            if (r4 != 0) goto L_0x00b5
            java.lang.String r4 = r14.toLowerCase()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r7 = ".otf"
            boolean r4 = r4.endsWith(r7)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r4 != 0) goto L_0x00b5
            java.lang.String r4 = r14.toLowerCase()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r7 = ".ttc,"
            int r4 = r4.indexOf(r7)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r4 <= 0) goto L_0x002d
            goto L_0x00b5
        L_0x002d:
            java.lang.String r2 = r14.toLowerCase()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r4 = ".ttc"
            boolean r2 = r2.endsWith(r4)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r2 == 0) goto L_0x006a
            if (r15 == 0) goto L_0x0049
            com.itextpdf.text.log.Logger r15 = f25702e     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r1 = "You can't define an alias for a true type collection."
            r15.c(r1)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            goto L_0x0049
        L_0x0043:
            r14 = move-exception
            goto L_0x01a7
        L_0x0046:
            r14 = move-exception
            goto L_0x01ad
        L_0x0049:
            java.lang.String[] r15 = com.itextpdf.text.pdf.BaseFont.p(r14)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r1 = 0
        L_0x004e:
            int r2 = r15.length     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r1 >= r2) goto L_0x018f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r2.<init>()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r2.append(r14)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r4 = ","
            r2.append(r4)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r2.append(r1)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r2 = r2.toString()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r13.s(r2)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            int r1 = r1 + r3
            goto L_0x004e
        L_0x006a:
            java.lang.String r15 = r14.toLowerCase()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r2 = ".afm"
            boolean r15 = r15.endsWith(r2)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r15 != 0) goto L_0x0082
            java.lang.String r15 = r14.toLowerCase()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r2 = ".pfm"
            boolean r15 = r15.endsWith(r2)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r15 == 0) goto L_0x018f
        L_0x0082:
            com.itextpdf.text.pdf.BaseFont r15 = com.itextpdf.text.pdf.BaseFont.j(r14, r5, r0)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String[][] r2 = r15.L()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r2 = r2[r0]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r2 = r2[r1]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r2 = r2.toLowerCase()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String[][] r4 = r15.H()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r4 = r4[r0]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r1 = r4[r1]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r15 = r15.P()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r15 = r15.toLowerCase()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r13.x(r1, r2, r6)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.util.Hashtable<java.lang.String, java.lang.String> r1 = r13.f25704a     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r1.put(r15, r14)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.util.Hashtable<java.lang.String, java.lang.String> r15 = r13.f25704a     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r15.put(r2, r14)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            goto L_0x018f
        L_0x00b5:
            java.lang.Object[] r4 = com.itextpdf.text.pdf.BaseFont.r(r14, r5, r6)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.util.Hashtable<java.lang.String, java.lang.String> r5 = r13.f25704a     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r7 = r4[r0]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r7 = r7.toLowerCase()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r5.put(r7, r14)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r5 = "regular"
            if (r15 == 0) goto L_0x00dc
            java.lang.String r15 = r15.toLowerCase()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.util.Hashtable<java.lang.String, java.lang.String> r7 = r13.f25704a     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r7.put(r15, r14)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            boolean r7 = r15.endsWith(r5)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r7 == 0) goto L_0x00dc
            r13.y(r15, r14)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
        L_0x00dc:
            r15 = r4[r2]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String[][] r15 = (java.lang.String[][]) r15     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            int r7 = r15.length     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r8 = 0
        L_0x00e2:
            if (r8 >= r7) goto L_0x00fc
            r9 = r15[r8]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r9 = r9[r1]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.util.Hashtable<java.lang.String, java.lang.String> r10 = r13.f25704a     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r10.put(r9, r14)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            boolean r10 = r9.endsWith(r5)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r10 == 0) goto L_0x00fa
            r13.y(r9, r14)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
        L_0x00fa:
            int r8 = r8 + r3
            goto L_0x00e2
        L_0x00fc:
            r15 = r4[r3]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String[][] r15 = (java.lang.String[][]) r15     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r7 = r6
            r5 = 0
        L_0x0102:
            java.lang.String[] r8 = f25703f     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            int r8 = r8.length     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r5 >= r8) goto L_0x0143
            int r8 = r15.length     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r9 = 0
        L_0x0109:
            if (r9 >= r8) goto L_0x0141
            r10 = r15[r9]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String[] r11 = f25703f     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r11 = r11[r5]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r12 = r10[r0]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            boolean r11 = r11.equals(r12)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r11 == 0) goto L_0x013f
            java.lang.String[] r11 = f25703f     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            int r12 = r5 + 1
            r11 = r11[r12]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r12 = r10[r3]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            boolean r11 = r11.equals(r12)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r11 == 0) goto L_0x013f
            java.lang.String[] r11 = f25703f     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            int r12 = r5 + 2
            r11 = r11[r12]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r12 = r10[r2]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            boolean r11 = r11.equals(r12)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r11 == 0) goto L_0x013f
            r5 = r10[r1]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r7 = r5.toLowerCase()     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String[] r5 = f25703f     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            int r5 = r5.length     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            goto L_0x0141
        L_0x013f:
            int r9 = r9 + r3
            goto L_0x0109
        L_0x0141:
            int r5 = r5 + r1
            goto L_0x0102
        L_0x0143:
            if (r7 == 0) goto L_0x018f
            java.lang.String r15 = ""
            r4 = r4[r2]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String[][] r4 = (java.lang.String[][]) r4     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            int r5 = r4.length     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r8 = 0
        L_0x014d:
            if (r8 >= r5) goto L_0x018f
            r9 = r4[r8]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r10 = 0
        L_0x0152:
            java.lang.String[] r11 = f25703f     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            int r12 = r11.length     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r10 >= r12) goto L_0x018d
            r11 = r11[r10]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r12 = r9[r0]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            boolean r11 = r11.equals(r12)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r11 == 0) goto L_0x018b
            java.lang.String[] r11 = f25703f     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            int r12 = r10 + 1
            r11 = r11[r12]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r12 = r9[r3]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            boolean r11 = r11.equals(r12)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r11 == 0) goto L_0x018b
            java.lang.String[] r11 = f25703f     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            int r12 = r10 + 2
            r11 = r11[r12]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r12 = r9[r2]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            boolean r11 = r11.equals(r12)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r11 == 0) goto L_0x018b
            r11 = r9[r1]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            boolean r12 = r11.equals(r15)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r12 == 0) goto L_0x0186
            goto L_0x018b
        L_0x0186:
            r13.x(r7, r11, r6)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r15 = r11
            goto L_0x018d
        L_0x018b:
            int r10 = r10 + r1
            goto L_0x0152
        L_0x018d:
            int r8 = r8 + r3
            goto L_0x014d
        L_0x018f:
            com.itextpdf.text.log.Logger r15 = f25702e     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            com.itextpdf.text.log.Level r1 = com.itextpdf.text.log.Level.TRACE     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            boolean r1 = r15.b(r1)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            if (r1 == 0) goto L_0x01a6
            java.lang.String r1 = "Registered %s"
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r2[r0] = r14     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            java.lang.String r14 = java.lang.String.format(r1, r2)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
            r15.h(r14)     // Catch:{ DocumentException -> 0x0046, IOException -> 0x0043 }
        L_0x01a6:
            return
        L_0x01a7:
            com.itextpdf.text.ExceptionConverter r15 = new com.itextpdf.text.ExceptionConverter
            r15.<init>(r14)
            throw r15
        L_0x01ad:
            com.itextpdf.text.ExceptionConverter r15 = new com.itextpdf.text.ExceptionConverter
            r15.<init>(r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.FontFactoryImp.t(java.lang.String, java.lang.String):void");
    }

    public int u() {
        int i2;
        String str = System.getenv("windir");
        String property = System.getProperty("file.separator");
        if (str == null || property == null) {
            i2 = 0;
        } else {
            i2 = v(str + property + "fonts");
        }
        return i2 + w("/usr/share/X11/fonts", true) + w("/usr/X/lib/X11/fonts", true) + w("/usr/openwin/lib/X11/fonts", true) + w("/usr/share/fonts", true) + w("/usr/X11R6/lib/X11/fonts", true) + v("/Library/Fonts") + v("/System/Library/Fonts");
    }

    public int v(String str) {
        return w(str, false);
    }

    public int w(String str, boolean z) {
        int i2 = 0;
        Logger logger = f25702e;
        if (logger.b(Level.DEBUG)) {
            logger.a(String.format("Registering directory %s, looking for fonts", new Object[]{str}));
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory()) {
                    String[] list = file.list();
                    if (list == null) {
                        return 0;
                    }
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < list.length) {
                        try {
                            try {
                                File file2 = new File(str, list[i3]);
                                if (!file2.isDirectory()) {
                                    String path = file2.getPath();
                                    String lowerCase = path.length() < 4 ? null : path.substring(path.length() - 4).toLowerCase();
                                    if (!".afm".equals(lowerCase)) {
                                        if (!".pfm".equals(lowerCase)) {
                                            if (!".ttf".equals(lowerCase) && !".otf".equals(lowerCase)) {
                                                if (".ttc".equals(lowerCase)) {
                                                }
                                            }
                                            t(path, (String) null);
                                            i4++;
                                        }
                                    }
                                    if (!new File(path.substring(0, path.length() - 4) + ".pfb").exists()) {
                                    }
                                    t(path, (String) null);
                                    i4++;
                                } else if (z) {
                                    i4 += w(file2.getAbsolutePath(), true);
                                }
                            } catch (Exception unused) {
                            }
                            i3++;
                        } catch (Exception unused2) {
                            i2 = i4;
                            return i2;
                        }
                    }
                    return i4;
                }
            }
            return 0;
        } catch (Exception unused3) {
            return i2;
        }
    }

    public void x(String str, String str2, String str3) {
        ArrayList arrayList;
        if (str3 != null) {
            this.f25704a.put(str2, str3);
        }
        synchronized (this.f25705b) {
            try {
                arrayList = this.f25705b.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f25705b.put(str, arrayList);
                }
            } finally {
                while (true) {
                }
            }
        }
        synchronized (arrayList) {
            try {
                if (!arrayList.contains(str2)) {
                    int length = str2.length();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            arrayList.add(str2);
                            String lowerCase = str2.toLowerCase();
                            if (lowerCase.endsWith("regular")) {
                                arrayList.add(0, str2.substring(0, lowerCase.substring(0, lowerCase.length() - 7).trim().length()));
                            }
                        } else if (((String) arrayList.get(i2)).length() >= length) {
                            arrayList.add(i2, str2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean y(String str, String str2) {
        String trim = str.substring(0, str.length() - 7).trim();
        if (this.f25704a.containsKey(trim)) {
            return false;
        }
        this.f25704a.put(trim, str2);
        return true;
    }
}
