package com.itextpdf.text.pdf.events;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IndexEvents extends PdfPageEventHelper {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Integer> f26785a = new TreeMap();

    /* renamed from: b  reason: collision with root package name */
    private long f26786b = 0;

    /* renamed from: c  reason: collision with root package name */
    private List<Entry> f26787c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private Comparator<Entry> f26788d = new Comparator<Entry>() {
        /* renamed from: a */
        public int compare(Entry entry, Entry entry2) {
            if (entry.b() == null || entry2.b() == null) {
                return 0;
            }
            int compareToIgnoreCase = entry.b().compareToIgnoreCase(entry2.b());
            if (compareToIgnoreCase != 0 || entry.c() == null || entry2.c() == null) {
                return compareToIgnoreCase;
            }
            int compareToIgnoreCase2 = entry.c().compareToIgnoreCase(entry2.c());
            return (compareToIgnoreCase2 != 0 || entry.d() == null || entry2.d() == null) ? compareToIgnoreCase2 : entry.d().compareToIgnoreCase(entry2.d());
        }
    };

    public class Entry {

        /* renamed from: a  reason: collision with root package name */
        private String f26789a;

        /* renamed from: b  reason: collision with root package name */
        private String f26790b;

        /* renamed from: c  reason: collision with root package name */
        private String f26791c;

        /* renamed from: d  reason: collision with root package name */
        private String f26792d;

        /* renamed from: e  reason: collision with root package name */
        private List<Integer> f26793e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        private List<String> f26794f = new ArrayList();

        public Entry(String str, String str2, String str3, String str4) {
            this.f26789a = str;
            this.f26790b = str2;
            this.f26791c = str3;
            this.f26792d = str4;
        }

        public void a(int i2, String str) {
            this.f26793e.add(Integer.valueOf(i2));
            this.f26794f.add(str);
        }

        public String b() {
            return this.f26789a;
        }

        public String c() {
            return this.f26790b;
        }

        public String d() {
            return this.f26791c;
        }

        public String e() {
            return this.f26789a + "!" + this.f26790b + "!" + this.f26791c;
        }

        public int f() {
            Integer num = (Integer) IndexEvents.this.f26785a.get(this.f26792d);
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }

        public List<Integer> g() {
            return this.f26793e;
        }

        public String h() {
            return this.f26792d;
        }

        public List<String> i() {
            return this.f26794f;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f26789a);
            stringBuffer.append(' ');
            stringBuffer.append(this.f26790b);
            stringBuffer.append(' ');
            stringBuffer.append(this.f26791c);
            stringBuffer.append(' ');
            for (int i2 = 0; i2 < this.f26793e.size(); i2++) {
                stringBuffer.append(this.f26793e.get(i2));
                stringBuffer.append(' ');
            }
            return stringBuffer.toString();
        }
    }

    public void e(PdfWriter pdfWriter, Document document, Rectangle rectangle, String str) {
        this.f26785a.put(str, Integer.valueOf(pdfWriter.z1()));
    }

    public Chunk n(String str, String str2) {
        return p(str, str2, "", "");
    }

    public Chunk o(String str, String str2, String str3) {
        return p(str, str2, str3, "");
    }

    public Chunk p(String str, String str2, String str3, String str4) {
        Chunk chunk = new Chunk(str);
        StringBuilder sb = new StringBuilder();
        sb.append("idx_");
        long j2 = this.f26786b;
        this.f26786b = 1 + j2;
        sb.append(j2);
        String sb2 = sb.toString();
        chunk.P(sb2);
        chunk.T(sb2);
        this.f26787c.add(new Entry(str2, str3, str4, sb2));
        return chunk;
    }

    public void q(Chunk chunk, String str) {
        s(chunk, str, "", "");
    }

    public void r(Chunk chunk, String str, String str2) {
        s(chunk, str, str2, "");
    }

    public void s(Chunk chunk, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("idx_");
        long j2 = this.f26786b;
        this.f26786b = 1 + j2;
        sb.append(j2);
        String sb2 = sb.toString();
        chunk.P(sb2);
        chunk.T(sb2);
        this.f26787c.add(new Entry(str, str2, str3, sb2));
    }

    public List<Entry> t() {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < this.f26787c.size(); i2++) {
            Entry entry = this.f26787c.get(i2);
            String e2 = entry.e();
            Entry entry2 = (Entry) hashMap.get(e2);
            if (entry2 != null) {
                entry2.a(entry.f(), entry.h());
            } else {
                entry.a(entry.f(), entry.h());
                hashMap.put(e2, entry);
            }
        }
        ArrayList arrayList = new ArrayList(hashMap.values());
        Collections.sort(arrayList, this.f26788d);
        return arrayList;
    }

    public void u(Comparator<Entry> comparator) {
        this.f26788d = comparator;
    }
}
