package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CMapToUnicode extends AbstractCMap {

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, String> f26822e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private Map<Integer, String> f26823f = new HashMap();

    private int p(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-16BE");
        int i2 = 0;
        for (int i3 = 0; i3 < bytes.length - 1; i3++) {
            i2 = (i2 + (bytes[i3] & 255)) << 8;
        }
        return i2 + (bytes[bytes.length - 1] & 255);
    }

    private String s(byte[] bArr) throws IOException {
        return bArr.length == 1 ? new String(bArr) : new String(bArr, "UTF-16BE");
    }

    public static CMapToUnicode t() {
        CMapToUnicode cMapToUnicode = new CMapToUnicode();
        for (int i2 = 0; i2 < 65537; i2++) {
            cMapToUnicode.o(i2, Utilities.c(i2));
        }
        return cMapToUnicode;
    }

    /* access modifiers changed from: package-private */
    public void a(PdfString pdfString, PdfObject pdfObject) {
        Map<Integer, String> map;
        Integer valueOf;
        try {
            byte[] k2 = pdfString.k();
            String s = s(pdfObject.k());
            if (k2.length == 1) {
                map = this.f26822e;
                valueOf = Integer.valueOf(k2[0] & 255);
            } else if (k2.length == 2) {
                byte b2 = (k2[1] & 255) | ((k2[0] & 255) << 8);
                map = this.f26823f;
                valueOf = Integer.valueOf(b2);
            } else {
                throw new IOException(MessageLocalization.a("mapping.code.should.be.1.or.two.bytes.and.not.1", k2.length));
            }
            map.put(valueOf, s);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void o(int i2, String str) {
        this.f26823f.put(Integer.valueOf(i2), str);
    }

    public Map<Integer, Integer> q() throws IOException {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f26822e.entrySet()) {
            hashMap.put(next.getKey(), Integer.valueOf(p((String) next.getValue())));
        }
        for (Map.Entry next2 : this.f26823f.entrySet()) {
            hashMap.put(next2.getKey(), Integer.valueOf(p((String) next2.getValue())));
        }
        return hashMap;
    }

    public Map<Integer, Integer> r() throws IOException {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f26822e.entrySet()) {
            hashMap.put(Integer.valueOf(p((String) next.getValue())), next.getKey());
        }
        for (Map.Entry next2 : this.f26823f.entrySet()) {
            hashMap.put(Integer.valueOf(p((String) next2.getValue())), next2.getKey());
        }
        return hashMap;
    }

    public boolean u() {
        return !this.f26822e.isEmpty();
    }

    public boolean v() {
        return !this.f26823f.isEmpty();
    }

    public String w(byte[] bArr, int i2, int i3) {
        Integer valueOf;
        Map<Integer, String> map;
        if (i3 == 1) {
            valueOf = Integer.valueOf(bArr[i2] & 255);
            map = this.f26822e;
        } else if (i3 != 2) {
            return null;
        } else {
            valueOf = Integer.valueOf(((bArr[i2] & 255) << 8) + (bArr[i2 + 1] & 255));
            map = this.f26823f;
        }
        return map.get(valueOf);
    }
}
