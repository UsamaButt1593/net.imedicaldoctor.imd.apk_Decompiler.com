package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PRTokeniser;
import java.io.IOException;
import java.util.ArrayList;

public class PdfContentParser {

    /* renamed from: b  reason: collision with root package name */
    public static final int f26160b = 200;

    /* renamed from: a  reason: collision with root package name */
    private PRTokeniser f26161a;

    /* renamed from: com.itextpdf.text.pdf.PdfContentParser$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26162a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.itextpdf.text.pdf.PRTokeniser$TokenType[] r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26162a = r0
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.START_DIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f26162a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.START_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f26162a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f26162a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NAME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f26162a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NUMBER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f26162a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.OTHER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfContentParser.AnonymousClass1.<clinit>():void");
        }
    }

    public PdfContentParser(PRTokeniser pRTokeniser) {
        this.f26161a = pRTokeniser;
    }

    public PRTokeniser a() {
        return this.f26161a;
    }

    public boolean b() throws IOException {
        while (this.f26161a.x()) {
            if (this.f26161a.o() != PRTokeniser.TokenType.COMMENT) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<PdfObject> c(ArrayList<PdfObject> arrayList) throws IOException {
        PdfObject f2;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        do {
            f2 = f();
            if (f2 == null) {
                break;
            }
            arrayList.add(f2);
        } while (f2.W() != 200);
        return arrayList;
    }

    public PdfArray d() throws IOException {
        PdfArray pdfArray = new PdfArray();
        while (true) {
            PdfObject f2 = f();
            int i2 = -f2.W();
            if (i2 == PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                return pdfArray;
            }
            if (i2 != PRTokeniser.TokenType.END_DIC.ordinal()) {
                pdfArray.a0(f2);
            } else {
                throw new IOException(MessageLocalization.b("unexpected.gt.gt", new Object[0]));
            }
        }
    }

    public PdfDictionary e() throws IOException {
        PdfDictionary pdfDictionary = new PdfDictionary();
        while (b()) {
            PRTokeniser.TokenType o = this.f26161a.o();
            PRTokeniser.TokenType tokenType = PRTokeniser.TokenType.END_DIC;
            if (o == tokenType) {
                return pdfDictionary;
            }
            if (this.f26161a.o() != PRTokeniser.TokenType.OTHER || !"def".equals(this.f26161a.n())) {
                if (this.f26161a.o() == PRTokeniser.TokenType.NAME) {
                    PdfName pdfName = new PdfName(this.f26161a.n(), false);
                    PdfObject f2 = f();
                    int i2 = -f2.W();
                    if (i2 == tokenType.ordinal()) {
                        throw new IOException(MessageLocalization.b("unexpected.gt.gt", new Object[0]));
                    } else if (i2 != PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                        pdfDictionary.V0(pdfName, f2);
                    } else {
                        throw new IOException(MessageLocalization.b("unexpected.close.bracket", new Object[0]));
                    }
                } else {
                    throw new IOException(MessageLocalization.b("dictionary.key.1.is.not.a.name", this.f26161a.n()));
                }
            }
        }
        throw new IOException(MessageLocalization.b("unexpected.end.of.file", new Object[0]));
    }

    public PdfObject f() throws IOException {
        if (!b()) {
            return null;
        }
        PRTokeniser.TokenType o = this.f26161a.o();
        switch (AnonymousClass1.f26162a[o.ordinal()]) {
            case 1:
                return e();
            case 2:
                return d();
            case 3:
                return new PdfString(this.f26161a.n(), (String) null).i0(this.f26161a.s());
            case 4:
                return new PdfName(this.f26161a.n(), false);
            case 5:
                return new PdfNumber(this.f26161a.n());
            case 6:
                return new PdfLiteral(200, this.f26161a.n());
            default:
                return new PdfLiteral(-o.ordinal(), this.f26161a.n());
        }
    }

    public void g(PRTokeniser pRTokeniser) {
        this.f26161a = pRTokeniser;
    }
}
