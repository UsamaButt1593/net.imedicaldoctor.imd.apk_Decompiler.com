package com.itextpdf.text.pdf.fonts.otf;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class OpenTypeFontTableReader {

    /* renamed from: d  reason: collision with root package name */
    protected static final Logger f26838d = LoggerFactory.b(OpenTypeFontTableReader.class);

    /* renamed from: a  reason: collision with root package name */
    protected final RandomAccessFileOrArray f26839a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f26840b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f26841c;

    public OpenTypeFontTableReader(RandomAccessFileOrArray randomAccessFileOrArray, int i2) throws IOException {
        this.f26839a = randomAccessFileOrArray;
        this.f26840b = i2;
    }

    private void c(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        Logger logger = f26838d;
        logger.a("featureCount=" + readShort);
        LinkedHashMap linkedHashMap = new LinkedHashMap(readShort);
        for (int i3 = 0; i3 < readShort; i3++) {
            linkedHashMap.put(this.f26839a.n(4, "utf-8"), Short.valueOf(this.f26839a.readShort()));
        }
        for (String str : linkedHashMap.keySet()) {
            Logger logger2 = f26838d;
            logger2.a("*************featureName=" + str);
            d(((Short) linkedHashMap.get(str)).shortValue() + i2);
        }
    }

    private void d(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        Logger logger = f26838d;
        logger.a("featureParamsOffset=" + readShort);
        short readShort2 = this.f26839a.readShort();
        logger.a("lookupCount=" + readShort2);
        ArrayList arrayList = new ArrayList(readShort2);
        for (int i3 = 0; i3 < readShort2; i3++) {
            arrayList.add(Short.valueOf(this.f26839a.readShort()));
        }
    }

    private TableHeader e() throws IOException {
        this.f26839a.r((long) this.f26840b);
        return new TableHeader(this.f26839a.readInt(), this.f26839a.readUnsignedShort(), this.f26839a.readUnsignedShort(), this.f26839a.readUnsignedShort());
    }

    private void f(Map<String, Integer> map) throws IOException {
        map.put(this.f26839a.n(4, "utf-8"), Integer.valueOf(this.f26839a.readShort()));
    }

    private void g(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        Logger logger = f26838d;
        logger.a("lookupOrderOffset=" + readShort);
        short readShort2 = this.f26839a.readShort();
        logger.a("reqFeatureIndex=" + readShort2);
        short readShort3 = this.f26839a.readShort();
        ArrayList arrayList = new ArrayList(readShort3);
        for (int i3 = 0; i3 < readShort3; i3++) {
            arrayList.add(Short.valueOf(this.f26839a.readShort()));
        }
        Logger logger2 = f26838d;
        logger2.a("featureListIndices=" + arrayList);
    }

    private void h(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < readShort; i3++) {
            arrayList.add(Integer.valueOf(this.f26839a.readShort()));
        }
        for (int i4 = 0; i4 < readShort; i4++) {
            i(((Integer) arrayList.get(i4)).intValue() + i2);
        }
    }

    private void i(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        this.f26839a.skipBytes(2);
        short readShort2 = this.f26839a.readShort();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < readShort2; i3++) {
            arrayList.add(Integer.valueOf(this.f26839a.readShort()));
        }
        for (Integer intValue : arrayList) {
            n(readShort, intValue.intValue() + i2);
        }
    }

    private void j(List<Integer> list) throws IOException {
        short readShort = this.f26839a.readShort();
        this.f26839a.readShort();
        for (int readShort2 = this.f26839a.readShort(); readShort2 <= readShort; readShort2++) {
            list.add(Integer.valueOf(readShort2));
        }
    }

    private void k(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        HashMap hashMap = new HashMap(readShort);
        for (int i3 = 0; i3 < readShort; i3++) {
            l(i2, hashMap);
        }
        ArrayList arrayList = new ArrayList(readShort);
        for (String str : hashMap.keySet()) {
            m(((Integer) hashMap.get(str)).intValue());
            arrayList.add(str);
        }
        this.f26841c = Collections.unmodifiableList(arrayList);
    }

    private void l(int i2, Map<String, Integer> map) throws IOException {
        map.put(this.f26839a.n(4, "utf-8"), Integer.valueOf(i2 + this.f26839a.readShort()));
    }

    private void m(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        short readShort2 = this.f26839a.readShort();
        if (readShort2 > 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(readShort2);
            for (int i3 = 0; i3 < readShort2; i3++) {
                f(linkedHashMap);
            }
            for (String str : linkedHashMap.keySet()) {
                g(((Integer) linkedHashMap.get(str)).intValue() + i2);
            }
        }
        g(i2 + readShort);
    }

    public Language a() throws FontReadingException {
        Language[] values = Language.values();
        for (String next : this.f26841c) {
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    Language language = values[i2];
                    if (language.a(next)) {
                        return language;
                    }
                    i2++;
                }
            }
        }
        throw new FontReadingException("Unsupported languages " + this.f26841c);
    }

    /* access modifiers changed from: protected */
    public final List<Integer> b(int i2) throws IOException {
        ArrayList arrayList;
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        int i3 = 0;
        if (readShort == 1) {
            short readShort2 = this.f26839a.readShort();
            arrayList = new ArrayList(readShort2);
            while (i3 < readShort2) {
                arrayList.add(Integer.valueOf(this.f26839a.readShort()));
                i3++;
            }
        } else if (readShort == 2) {
            short readShort3 = this.f26839a.readShort();
            arrayList = new ArrayList();
            while (i3 < readShort3) {
                j(arrayList);
                i3++;
            }
        } else {
            throw new UnsupportedOperationException("Invalid coverage format: " + readShort);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: protected */
    public abstract void n(int i2, int i3) throws IOException;

    /* access modifiers changed from: protected */
    public final void o() throws FontReadingException {
        try {
            TableHeader e2 = e();
            k(this.f26840b + e2.f26843b);
            c(this.f26840b + e2.f26844c);
            h(this.f26840b + e2.f26845d);
        } catch (IOException e3) {
            throw new FontReadingException("Error reading font file", e3);
        }
    }
}
