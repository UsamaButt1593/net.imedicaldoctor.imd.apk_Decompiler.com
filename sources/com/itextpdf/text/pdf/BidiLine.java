package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.TabStop;
import com.itextpdf.text.Utilities;
import java.util.ArrayList;
import java.util.Iterator;

public class BidiLine {
    protected static final IntHashtable x;

    /* renamed from: a  reason: collision with root package name */
    protected int f25938a;

    /* renamed from: b  reason: collision with root package name */
    protected int f25939b = 256;

    /* renamed from: c  reason: collision with root package name */
    protected char[] f25940c = new char[256];

    /* renamed from: d  reason: collision with root package name */
    protected PdfChunk[] f25941d = new PdfChunk[256];

    /* renamed from: e  reason: collision with root package name */
    protected int f25942e = 0;

    /* renamed from: f  reason: collision with root package name */
    protected byte[] f25943f = new byte[256];

    /* renamed from: g  reason: collision with root package name */
    protected int[] f25944g = new int[256];

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList<PdfChunk> f25945h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    protected int f25946i = 0;

    /* renamed from: j  reason: collision with root package name */
    protected int f25947j = 0;

    /* renamed from: k  reason: collision with root package name */
    protected int f25948k = 0;

    /* renamed from: l  reason: collision with root package name */
    protected int f25949l;

    /* renamed from: m  reason: collision with root package name */
    protected char[] f25950m = new char[0];

    /* renamed from: n  reason: collision with root package name */
    protected PdfChunk[] f25951n = new PdfChunk[0];
    protected int o = 0;
    protected byte[] p = new byte[0];
    protected int[] q = new int[0];
    protected int r = 0;
    protected int s = 0;
    protected int t = 0;
    protected boolean u = false;
    protected boolean v;
    protected int w;

    static {
        IntHashtable intHashtable = new IntHashtable();
        x = intHashtable;
        intHashtable.l(40, 41);
        intHashtable.l(41, 40);
        intHashtable.l(60, 62);
        intHashtable.l(62, 60);
        intHashtable.l(91, 93);
        intHashtable.l(93, 91);
        intHashtable.l(123, 125);
        intHashtable.l(125, 123);
        intHashtable.l(171, 187);
        intHashtable.l(187, 171);
        intHashtable.l(8249, 8250);
        intHashtable.l(8250, 8249);
        intHashtable.l(8261, 8262);
        intHashtable.l(8262, 8261);
        intHashtable.l(8317, 8318);
        intHashtable.l(8318, 8317);
        intHashtable.l(8333, 8334);
        intHashtable.l(8334, 8333);
        intHashtable.l(8712, 8715);
        intHashtable.l(8713, 8716);
        intHashtable.l(8714, 8717);
        intHashtable.l(8715, 8712);
        intHashtable.l(8716, 8713);
        intHashtable.l(8717, 8714);
        intHashtable.l(8725, 10741);
        intHashtable.l(8764, 8765);
        intHashtable.l(8765, 8764);
        intHashtable.l(8771, 8909);
        intHashtable.l(8786, 8787);
        intHashtable.l(8787, 8786);
        intHashtable.l(8788, 8789);
        intHashtable.l(8789, 8788);
        intHashtable.l(8804, 8805);
        intHashtable.l(8805, 8804);
        intHashtable.l(8806, 8807);
        intHashtable.l(8807, 8806);
        intHashtable.l(8808, 8809);
        intHashtable.l(8809, 8808);
        intHashtable.l(8810, 8811);
        intHashtable.l(8811, 8810);
        intHashtable.l(8814, 8815);
        intHashtable.l(8815, 8814);
        intHashtable.l(8816, 8817);
        intHashtable.l(8817, 8816);
        intHashtable.l(8818, 8819);
        intHashtable.l(8819, 8818);
        intHashtable.l(8820, 8821);
        intHashtable.l(8821, 8820);
        intHashtable.l(8822, 8823);
        intHashtable.l(8823, 8822);
        intHashtable.l(8824, 8825);
        intHashtable.l(8825, 8824);
        intHashtable.l(8826, 8827);
        intHashtable.l(8827, 8826);
        intHashtable.l(8828, 8829);
        intHashtable.l(8829, 8828);
        intHashtable.l(8830, 8831);
        intHashtable.l(8831, 8830);
        intHashtable.l(8832, 8833);
        intHashtable.l(8833, 8832);
        intHashtable.l(8834, 8835);
        intHashtable.l(8835, 8834);
        intHashtable.l(8836, 8837);
        intHashtable.l(8837, 8836);
        intHashtable.l(8838, 8839);
        intHashtable.l(8839, 8838);
        intHashtable.l(8840, 8841);
        intHashtable.l(8841, 8840);
        intHashtable.l(8842, 8843);
        intHashtable.l(8843, 8842);
        intHashtable.l(8847, 8848);
        intHashtable.l(8848, 8847);
        intHashtable.l(8849, 8850);
        intHashtable.l(8850, 8849);
        intHashtable.l(8856, 10680);
        intHashtable.l(8866, 8867);
        intHashtable.l(8867, 8866);
        intHashtable.l(8870, 10974);
        intHashtable.l(8872, 10980);
        intHashtable.l(8873, 10979);
        intHashtable.l(8875, 10981);
        intHashtable.l(8880, 8881);
        intHashtable.l(8881, 8880);
        intHashtable.l(8882, 8883);
        intHashtable.l(8883, 8882);
        intHashtable.l(8884, 8885);
        intHashtable.l(8885, 8884);
        intHashtable.l(8886, 8887);
        intHashtable.l(8887, 8886);
        intHashtable.l(8905, 8906);
        intHashtable.l(8906, 8905);
        intHashtable.l(8907, 8908);
        intHashtable.l(8908, 8907);
        intHashtable.l(8909, 8771);
        intHashtable.l(8912, 8913);
        intHashtable.l(8913, 8912);
        intHashtable.l(8918, 8919);
        intHashtable.l(8919, 8918);
        intHashtable.l(8920, 8921);
        intHashtable.l(8921, 8920);
        intHashtable.l(8922, 8923);
        intHashtable.l(8923, 8922);
        intHashtable.l(8924, 8925);
        intHashtable.l(8925, 8924);
        intHashtable.l(8926, 8927);
        intHashtable.l(8927, 8926);
        intHashtable.l(8928, 8929);
        intHashtable.l(8929, 8928);
        intHashtable.l(8930, 8931);
        intHashtable.l(8931, 8930);
        intHashtable.l(8932, 8933);
        intHashtable.l(8933, 8932);
        intHashtable.l(8934, 8935);
        intHashtable.l(8935, 8934);
        intHashtable.l(8936, 8937);
        intHashtable.l(8937, 8936);
        intHashtable.l(8938, 8939);
        intHashtable.l(8939, 8938);
        intHashtable.l(8940, 8941);
        intHashtable.l(8941, 8940);
        intHashtable.l(8944, 8945);
        intHashtable.l(8945, 8944);
        intHashtable.l(8946, 8954);
        intHashtable.l(8947, 8955);
        intHashtable.l(8948, 8956);
        intHashtable.l(8950, 8957);
        intHashtable.l(8951, 8958);
        intHashtable.l(8954, 8946);
        intHashtable.l(8955, 8947);
        intHashtable.l(8956, 8948);
        intHashtable.l(8957, 8950);
        intHashtable.l(8958, 8951);
        intHashtable.l(8968, 8969);
        intHashtable.l(8969, 8968);
        intHashtable.l(8970, 8971);
        intHashtable.l(8971, 8970);
        intHashtable.l(9001, 9002);
        intHashtable.l(9002, 9001);
        intHashtable.l(10088, 10089);
        intHashtable.l(10089, 10088);
        intHashtable.l(10090, 10091);
        intHashtable.l(10091, 10090);
        intHashtable.l(10092, 10093);
        intHashtable.l(10093, 10092);
        intHashtable.l(10094, 10095);
        intHashtable.l(10095, 10094);
        intHashtable.l(10096, 10097);
        intHashtable.l(10097, 10096);
        intHashtable.l(10098, 10099);
        intHashtable.l(10099, 10098);
        intHashtable.l(10100, 10101);
        intHashtable.l(10101, 10100);
        intHashtable.l(10197, 10198);
        intHashtable.l(10198, 10197);
        intHashtable.l(10205, 10206);
        intHashtable.l(10206, 10205);
        intHashtable.l(10210, 10211);
        intHashtable.l(10211, 10210);
        intHashtable.l(10212, 10213);
        intHashtable.l(10213, 10212);
        intHashtable.l(10214, 10215);
        intHashtable.l(10215, 10214);
        intHashtable.l(10216, 10217);
        intHashtable.l(10217, 10216);
        intHashtable.l(10218, 10219);
        intHashtable.l(10219, 10218);
        intHashtable.l(10627, 10628);
        intHashtable.l(10628, 10627);
        intHashtable.l(10629, 10630);
        intHashtable.l(10630, 10629);
        intHashtable.l(10631, 10632);
        intHashtable.l(10632, 10631);
        intHashtable.l(10633, 10634);
        intHashtable.l(10634, 10633);
        intHashtable.l(10635, 10636);
        intHashtable.l(10636, 10635);
        intHashtable.l(10637, 10640);
        intHashtable.l(10638, 10639);
        intHashtable.l(10639, 10638);
        intHashtable.l(10640, 10637);
        intHashtable.l(10641, 10642);
        intHashtable.l(10642, 10641);
        intHashtable.l(10643, 10644);
        intHashtable.l(10644, 10643);
        intHashtable.l(10645, 10646);
        intHashtable.l(10646, 10645);
        intHashtable.l(10647, 10648);
        intHashtable.l(10648, 10647);
        intHashtable.l(10680, 8856);
        intHashtable.l(10688, 10689);
        intHashtable.l(10689, 10688);
        intHashtable.l(10692, 10693);
        intHashtable.l(10693, 10692);
        intHashtable.l(10703, 10704);
        intHashtable.l(10704, 10703);
        intHashtable.l(10705, 10706);
        intHashtable.l(10706, 10705);
        intHashtable.l(10708, 10709);
        intHashtable.l(10709, 10708);
        intHashtable.l(10712, 10713);
        intHashtable.l(10713, 10712);
        intHashtable.l(10714, 10715);
        intHashtable.l(10715, 10714);
        intHashtable.l(10741, 8725);
        intHashtable.l(10744, 10745);
        intHashtable.l(10745, 10744);
        intHashtable.l(10748, 10749);
        intHashtable.l(10749, 10748);
        intHashtable.l(10795, 10796);
        intHashtable.l(10796, 10795);
        intHashtable.l(10797, 10796);
        intHashtable.l(10798, 10797);
        intHashtable.l(10804, 10805);
        intHashtable.l(10805, 10804);
        intHashtable.l(10812, 10813);
        intHashtable.l(10813, 10812);
        intHashtable.l(10852, 10853);
        intHashtable.l(10853, 10852);
        intHashtable.l(10873, 10874);
        intHashtable.l(10874, 10873);
        intHashtable.l(10877, 10878);
        intHashtable.l(10878, 10877);
        intHashtable.l(10879, 10880);
        intHashtable.l(10880, 10879);
        intHashtable.l(10881, 10882);
        intHashtable.l(10882, 10881);
        intHashtable.l(10883, 10884);
        intHashtable.l(10884, 10883);
        intHashtable.l(10891, 10892);
        intHashtable.l(10892, 10891);
        intHashtable.l(10897, 10898);
        intHashtable.l(10898, 10897);
        intHashtable.l(10899, 10900);
        intHashtable.l(10900, 10899);
        intHashtable.l(10901, 10902);
        intHashtable.l(10902, 10901);
        intHashtable.l(10903, 10904);
        intHashtable.l(10904, 10903);
        intHashtable.l(10905, 10906);
        intHashtable.l(10906, 10905);
        intHashtable.l(10907, 10908);
        intHashtable.l(10908, 10907);
        intHashtable.l(10913, 10914);
        intHashtable.l(10914, 10913);
        intHashtable.l(10918, 10919);
        intHashtable.l(10919, 10918);
        intHashtable.l(10920, 10921);
        intHashtable.l(10921, 10920);
        intHashtable.l(10922, 10923);
        intHashtable.l(10923, 10922);
        intHashtable.l(10924, 10925);
        intHashtable.l(10925, 10924);
        intHashtable.l(10927, 10928);
        intHashtable.l(10928, 10927);
        intHashtable.l(10931, 10932);
        intHashtable.l(10932, 10931);
        intHashtable.l(10939, 10940);
        intHashtable.l(10940, 10939);
        intHashtable.l(10941, 10942);
        intHashtable.l(10942, 10941);
        intHashtable.l(10943, 10944);
        intHashtable.l(10944, 10943);
        intHashtable.l(10945, 10946);
        intHashtable.l(10946, 10945);
        intHashtable.l(10947, 10948);
        intHashtable.l(10948, 10947);
        intHashtable.l(10949, 10950);
        intHashtable.l(10950, 10949);
        intHashtable.l(10957, 10958);
        intHashtable.l(10958, 10957);
        intHashtable.l(10959, 10960);
        intHashtable.l(10960, 10959);
        intHashtable.l(10961, 10962);
        intHashtable.l(10962, 10961);
        intHashtable.l(10963, 10964);
        intHashtable.l(10964, 10963);
        intHashtable.l(10965, 10966);
        intHashtable.l(10966, 10965);
        intHashtable.l(10974, 8870);
        intHashtable.l(10979, 8873);
        intHashtable.l(10980, 8872);
        intHashtable.l(10981, 8875);
        intHashtable.l(10988, 10989);
        intHashtable.l(10989, 10988);
        intHashtable.l(10999, 11000);
        intHashtable.l(11000, 10999);
        intHashtable.l(11001, 11002);
        intHashtable.l(11002, 11001);
        intHashtable.l(12296, 12297);
        intHashtable.l(12297, 12296);
        intHashtable.l(12298, 12299);
        intHashtable.l(12299, 12298);
        intHashtable.l(12300, 12301);
        intHashtable.l(12301, 12300);
        intHashtable.l(12302, 12303);
        intHashtable.l(12303, 12302);
        intHashtable.l(12304, 12305);
        intHashtable.l(12305, 12304);
        intHashtable.l(12308, 12309);
        intHashtable.l(12309, 12308);
        intHashtable.l(12310, 12311);
        intHashtable.l(12311, 12310);
        intHashtable.l(12312, 12313);
        intHashtable.l(12313, 12312);
        intHashtable.l(12314, 12315);
        intHashtable.l(12315, 12314);
        intHashtable.l(65288, 65289);
        intHashtable.l(65289, 65288);
        intHashtable.l(65308, 65310);
        intHashtable.l(65310, 65308);
        intHashtable.l(65339, 65341);
        intHashtable.l(65341, 65339);
        intHashtable.l(65371, 65373);
        intHashtable.l(65373, 65371);
        intHashtable.l(65375, 65376);
        intHashtable.l(65376, 65375);
        intHashtable.l(65378, 65379);
        intHashtable.l(65379, 65378);
    }

    public BidiLine() {
    }

    public static boolean n(char c2) {
        return c2 <= ' ';
    }

    public static String q(String str, int i2, int i3) {
        BidiLine bidiLine = new BidiLine();
        bidiLine.a(new PdfChunk(new Chunk(str), (PdfAction) null));
        bidiLine.w = i3;
        bidiLine.i(i2);
        ArrayList<PdfChunk> e2 = bidiLine.e(0, bidiLine.f25942e - 1);
        StringBuilder sb = new StringBuilder();
        Iterator<PdfChunk> it2 = e2.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next().toString());
        }
        return sb.toString();
    }

    public void a(PdfChunk pdfChunk) {
        this.f25945h.add(pdfChunk);
    }

    public void b(ArrayList<PdfChunk> arrayList) {
        this.f25945h.addAll(arrayList);
    }

    public void c(char c2, PdfChunk pdfChunk) {
        int i2 = this.f25942e;
        int i3 = this.f25939b;
        if (i2 >= i3) {
            char[] cArr = this.f25940c;
            PdfChunk[] pdfChunkArr = this.f25941d;
            int i4 = i3 * 2;
            this.f25939b = i4;
            char[] cArr2 = new char[i4];
            this.f25940c = cArr2;
            this.f25941d = new PdfChunk[i4];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            System.arraycopy(pdfChunkArr, 0, this.f25941d, 0, this.f25942e);
        }
        char[] cArr3 = this.f25940c;
        int i5 = this.f25942e;
        cArr3[i5] = c2;
        PdfChunk[] pdfChunkArr2 = this.f25941d;
        this.f25942e = i5 + 1;
        pdfChunkArr2[i5] = pdfChunk;
    }

    public void d() {
        this.f25945h.clear();
        this.f25942e = 0;
        this.f25948k = 0;
    }

    public ArrayList<PdfChunk> e(int i2, int i3) {
        return f(i2, i3, (PdfChunk) null);
    }

    public ArrayList<PdfChunk> f(int i2, int i3, PdfChunk pdfChunk) {
        int i4 = this.f25938a;
        boolean z = i4 == 2 || i4 == 3;
        if (z) {
            s(i2, i3);
        }
        ArrayList<PdfChunk> arrayList = new ArrayList<>();
        PdfChunk pdfChunk2 = this.f25941d[i2];
        StringBuffer stringBuffer = new StringBuffer();
        while (i2 <= i3) {
            int i5 = z ? this.f25944g[i2] : i2;
            char c2 = this.f25940c[i5];
            PdfChunk pdfChunk3 = this.f25941d[i5];
            if (!PdfChunk.G(pdfChunk3.r(c2))) {
                if (pdfChunk3.y() || pdfChunk3.A() || pdfChunk3.D()) {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(new PdfChunk(stringBuffer.toString(), pdfChunk2));
                        stringBuffer = new StringBuffer();
                    }
                    arrayList.add(pdfChunk3);
                } else if (pdfChunk3 == pdfChunk2) {
                    stringBuffer.append(c2);
                } else {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(new PdfChunk(stringBuffer.toString(), pdfChunk2));
                        stringBuffer = new StringBuffer();
                    }
                    if (!pdfChunk3.y() && !pdfChunk3.A() && !pdfChunk3.D()) {
                        stringBuffer.append(c2);
                    }
                    pdfChunk2 = pdfChunk3;
                }
            }
            i2++;
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(new PdfChunk(stringBuffer.toString(), pdfChunk2));
        }
        if (pdfChunk != null) {
            arrayList.add(pdfChunk);
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        r4 = r11.f25940c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g() {
        /*
            r11 = this;
            r0 = 0
            r8 = 0
            r9 = 0
        L_0x0003:
            int r1 = r11.f25942e
            r2 = 1791(0x6ff, float:2.51E-42)
            r3 = 1536(0x600, float:2.152E-42)
            if (r8 >= r1) goto L_0x0029
            char[] r4 = r11.f25940c
            char r5 = r4[r8]
            if (r5 < r3) goto L_0x0014
            if (r5 > r2) goto L_0x0014
            goto L_0x0029
        L_0x0014:
            if (r8 == r9) goto L_0x0024
            r4[r9] = r5
            com.itextpdf.text.pdf.PdfChunk[] r1 = r11.f25941d
            r2 = r1[r8]
            r1[r9] = r2
            byte[] r1 = r11.f25943f
            byte r2 = r1[r8]
            r1[r9] = r2
        L_0x0024:
            int r8 = r8 + 1
            int r9 = r9 + 1
            goto L_0x0003
        L_0x0029:
            if (r8 < r1) goto L_0x002e
            r11.f25942e = r9
            return
        L_0x002e:
            int r1 = r8 + 1
            r10 = r1
        L_0x0031:
            int r1 = r11.f25942e
            if (r10 >= r1) goto L_0x0041
            char[] r1 = r11.f25940c
            char r1 = r1[r10]
            if (r1 < r3) goto L_0x0041
            if (r1 <= r2) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            int r10 = r10 + 1
            goto L_0x0031
        L_0x0041:
            int r6 = r10 - r8
            char[] r4 = r11.f25940c
            int r7 = r11.w
            r1 = r4
            r2 = r8
            r3 = r6
            r5 = r9
            int r1 = com.itextpdf.text.pdf.languages.ArabicLigaturizer.c(r1, r2, r3, r4, r5, r6, r7)
            if (r8 == r9) goto L_0x0069
            r2 = 0
        L_0x0052:
            if (r2 >= r1) goto L_0x006a
            com.itextpdf.text.pdf.PdfChunk[] r3 = r11.f25941d
            r4 = r3[r8]
            r3[r9] = r4
            byte[] r3 = r11.f25943f
            int r4 = r9 + 1
            int r5 = r8 + 1
            byte r6 = r3[r8]
            r3[r9] = r6
            int r2 = r2 + 1
            r9 = r4
            r8 = r5
            goto L_0x0052
        L_0x0069:
            int r9 = r9 + r1
        L_0x006a:
            r8 = r10
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BidiLine.g():void");
    }

    public void h(int i2, int i3) {
        int i4 = (i2 + i3) / 2;
        while (true) {
            i3--;
            if (i2 < i4) {
                int[] iArr = this.f25944g;
                int i5 = iArr[i2];
                iArr[i2] = iArr[i3];
                iArr[i3] = i5;
                i2++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0061, code lost:
        r1 = r11.f25947j + 1;
        r11.f25947j = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        if (r1 < r6) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        r11.f25947j = 0;
        r11.f25946i++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0071, code lost:
        if (r11.f25942e != 0) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        r11.f25941d[0] = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i(int r12) {
        /*
            r11 = this;
            r11.f25938a = r12
            r0 = 0
            r11.f25948k = r0
            r11.f25942e = r0
            r1 = 0
        L_0x0008:
            int r2 = r11.f25946i
            java.util.ArrayList<com.itextpdf.text.pdf.PdfChunk> r3 = r11.f25945h
            int r3 = r3.size()
            r4 = 1
            if (r2 >= r3) goto L_0x0083
            java.util.ArrayList<com.itextpdf.text.pdf.PdfChunk> r2 = r11.f25945h
            int r3 = r11.f25946i
            java.lang.Object r2 = r2.get(r3)
            com.itextpdf.text.pdf.PdfChunk r2 = (com.itextpdf.text.pdf.PdfChunk) r2
            com.itextpdf.text.pdf.PdfFont r3 = r2.d()
            com.itextpdf.text.pdf.BaseFont r3 = r3.c()
            java.lang.String r5 = r2.toString()
            int r6 = r5.length()
        L_0x002d:
            int r7 = r11.f25947j
            if (r7 >= r6) goto L_0x0078
            char r7 = r5.charAt(r7)
            int r8 = r3.V(r7)
            char r8 = (char) r8
            r9 = 10
            r10 = 13
            if (r8 == r10) goto L_0x004c
            if (r8 != r9) goto L_0x0043
            goto L_0x004c
        L_0x0043:
            r11.c(r7, r2)
            int r7 = r11.f25947j
            int r7 = r7 + r4
            r11.f25947j = r7
            goto L_0x002d
        L_0x004c:
            if (r8 != r10) goto L_0x0061
            int r1 = r11.f25947j
            int r3 = r1 + 1
            if (r3 >= r6) goto L_0x0061
            int r1 = r1 + 1
            char r1 = r5.charAt(r1)
            if (r1 != r9) goto L_0x0061
            int r1 = r11.f25947j
            int r1 = r1 + r4
            r11.f25947j = r1
        L_0x0061:
            int r1 = r11.f25947j
            int r1 = r1 + r4
            r11.f25947j = r1
            if (r1 < r6) goto L_0x006f
            r11.f25947j = r0
            int r1 = r11.f25946i
            int r1 = r1 + r4
            r11.f25946i = r1
        L_0x006f:
            int r1 = r11.f25942e
            if (r1 != 0) goto L_0x0077
            com.itextpdf.text.pdf.PdfChunk[] r1 = r11.f25941d
            r1[r0] = r2
        L_0x0077:
            r1 = 1
        L_0x0078:
            if (r1 == 0) goto L_0x007b
            goto L_0x0083
        L_0x007b:
            r11.f25947j = r0
            int r2 = r11.f25946i
            int r2 = r2 + r4
            r11.f25946i = r2
            goto L_0x0008
        L_0x0083:
            int r2 = r11.f25942e
            if (r2 != 0) goto L_0x0088
            return r1
        L_0x0088:
            int r2 = r2 - r4
            int r1 = r11.x(r0, r2)
            int r1 = r1 + r4
            r11.f25942e = r1
            if (r1 != 0) goto L_0x0093
            return r4
        L_0x0093:
            r2 = 2
            r3 = 3
            if (r12 == r2) goto L_0x0099
            if (r12 != r3) goto L_0x00da
        L_0x0099:
            byte[] r2 = r11.f25943f
            int r2 = r2.length
            if (r2 >= r1) goto L_0x00a8
            int r2 = r11.f25939b
            byte[] r5 = new byte[r2]
            r11.f25943f = r5
            int[] r2 = new int[r2]
            r11.f25944g = r2
        L_0x00a8:
            char[] r2 = r11.f25940c
            int r5 = r11.w
            com.itextpdf.text.pdf.languages.ArabicLigaturizer.k(r2, r0, r1, r5)
            com.itextpdf.text.pdf.BidiOrder r1 = new com.itextpdf.text.pdf.BidiOrder
            char[] r2 = r11.f25940c
            int r5 = r11.f25942e
            if (r12 != r3) goto L_0x00b9
            r12 = 1
            goto L_0x00ba
        L_0x00b9:
            r12 = 0
        L_0x00ba:
            byte r12 = (byte) r12
            r1.<init>(r2, r0, r5, r12)
            byte[] r12 = r1.i()
            r1 = 0
        L_0x00c3:
            int r2 = r11.f25942e
            if (r1 >= r2) goto L_0x00d4
            byte[] r2 = r11.f25943f
            byte r3 = r12[r1]
            r2[r1] = r3
            int[] r2 = r11.f25944g
            r2[r1] = r1
            int r1 = r1 + 1
            goto L_0x00c3
        L_0x00d4:
            r11.g()
            r11.p()
        L_0x00da:
            int r12 = r11.f25942e
            int r12 = r12 - r4
            int r12 = r11.y(r0, r12)
            int r12 = r12 + r4
            r11.f25942e = r12
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BidiLine.i(int):boolean");
    }

    public float j(int i2, int i3) {
        return k(i2, i3, 0.0f);
    }

    public float k(int i2, int i3, float f2) {
        float f3 = 0.0f;
        TabStop tabStop = null;
        float f4 = Float.NaN;
        float f5 = Float.NaN;
        while (i2 <= i3) {
            boolean o2 = Utilities.o(this.f25940c, i2);
            if (this.f25941d[i2].D() && this.f25941d[i2].v(Chunk.h3)) {
                if (tabStop != null) {
                    float e2 = tabStop.e(f4, f3, f5);
                    f3 = (f3 - f4) + e2;
                    tabStop.j(e2);
                }
                TabStop o3 = this.f25941d[i2].o();
                if (o3 == null) {
                    tabStop = PdfChunk.p(this.f25941d[i2], f3);
                    f4 = f3;
                } else {
                    f3 = this.f25938a == 3 ? f2 - o3.d() : o3.d();
                    tabStop = null;
                    f4 = Float.NaN;
                }
                f5 = Float.NaN;
            } else if (o2) {
                f3 += this.f25941d[i2].f(Utilities.g(this.f25940c, i2));
                i2++;
            } else {
                char c2 = this.f25940c[i2];
                PdfChunk pdfChunk = this.f25941d[i2];
                if (!PdfChunk.G(pdfChunk.r(c2))) {
                    if (tabStop != null && tabStop.a() != TabStop.Alignment.ANCHOR && Float.isNaN(f5) && tabStop.b() == ((char) pdfChunk.r(c2))) {
                        f5 = f3;
                    }
                    f3 += this.f25941d[i2].f(c2);
                }
            }
            i2++;
        }
        if (tabStop == null) {
            return f3;
        }
        float e3 = tabStop.e(f4, f3, f5);
        float f6 = (f3 - f4) + e3;
        tabStop.j(e3);
        return f6;
    }

    public int[] l(int i2, int i3) {
        int i4 = i3;
        while (i4 < this.f25942e && (Character.isLetter(this.f25940c[i4]) || Character.isDigit(this.f25940c[i4]))) {
            i4++;
        }
        if (i4 == i3) {
            return null;
        }
        while (i3 >= i2 && (Character.isLetter(this.f25940c[i3]) || Character.isDigit(this.f25940c[i3]))) {
            i3--;
        }
        return new int[]{i3 + 1, i4};
    }

    public boolean m() {
        return this.f25948k >= this.f25942e && this.f25946i >= this.f25945h.size();
    }

    public boolean o() {
        return this.u;
    }

    public void p() {
        int e2;
        for (int i2 = 0; i2 < this.f25942e; i2++) {
            if ((this.f25943f[i2] & 1) == 1 && (e2 = x.e(this.f25940c[i2])) != 0) {
                this.f25940c[i2] = (char) e2;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v53, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v54, resolved type: char} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfLine r(float r25, float r26, int r27, int r28, int r29, float r30, float r31, float r32) {
        /*
            r24 = this;
            r0 = r24
            r4 = r26
            r1 = r28
            r2 = 0
            r0.u = r2
            r3 = r29
            r0.w = r3
            r24.u()
            r3 = 3
            r5 = 1
            if (r1 != r3) goto L_0x0016
            r8 = 1
            goto L_0x0017
        L_0x0016:
            r8 = 0
        L_0x0017:
            int r3 = r0.f25948k
            int r6 = r0.f25942e
            r7 = 0
            if (r3 < r6) goto L_0x004a
            boolean r1 = r0.i(r1)
            if (r1 != 0) goto L_0x0025
            return r7
        L_0x0025:
            int r1 = r0.f25942e
            if (r1 != 0) goto L_0x004a
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            com.itextpdf.text.pdf.PdfChunk r1 = new com.itextpdf.text.pdf.PdfChunk
            com.itextpdf.text.pdf.PdfChunk[] r3 = r0.f25941d
            r2 = r3[r2]
            java.lang.String r3 = ""
            r1.<init>((java.lang.String) r3, (com.itextpdf.text.pdf.PdfChunk) r2)
            r7.add(r1)
            com.itextpdf.text.pdf.PdfLine r9 = new com.itextpdf.text.pdf.PdfLine
            r3 = 0
            r6 = 1
            r2 = 0
            r1 = r9
            r4 = r26
            r5 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x004a:
            int r1 = r0.f25948k
            if (r1 == 0) goto L_0x0057
            int r3 = r0.f25942e
            int r3 = r3 - r5
            int r1 = r0.w(r1, r3)
            r0.f25948k = r1
        L_0x0057:
            int r1 = r0.f25948k
            r15 = r4
            r13 = r7
            r14 = r13
            r9 = 0
            r11 = 2143289344(0x7fc00000, float:NaN)
            r12 = 2143289344(0x7fc00000, float:NaN)
            r16 = -1
        L_0x0063:
            int r10 = r0.f25948k
            int r6 = r0.f25942e
            r17 = 2
            r18 = 0
            if (r10 >= r6) goto L_0x0284
            com.itextpdf.text.pdf.PdfChunk[] r6 = r0.f25941d
            r6 = r6[r10]
            boolean r9 = r6.y()
            if (r9 == 0) goto L_0x00b7
            int r9 = (r30 > r31 ? 1 : (r30 == r31 ? 0 : -1))
            if (r9 >= 0) goto L_0x00b7
            com.itextpdf.text.Image r9 = r6.h()
            boolean r10 = r9.H1()
            if (r10 == 0) goto L_0x00b7
            r10 = 1073741824(0x40000000, float:2.0)
            float r10 = r10 * r32
            float r10 = r31 + r10
            float r19 = r9.o1()
            float r19 = r10 - r19
            float r20 = r6.k()
            float r19 = r19 - r20
            float r20 = r9.E()
            float r19 = r19 - r20
            int r19 = (r19 > r30 ? 1 : (r19 == r30 ? 0 : -1))
            if (r19 >= 0) goto L_0x00b7
            float r19 = r6.k()
            float r10 = r10 - r19
            float r19 = r9.E()
            float r10 = r10 - r19
            float r10 = r10 - r30
            float r9 = r9.o1()
            float r10 = r10 / r9
            r6.J(r10)
        L_0x00b7:
            char[] r9 = r0.f25940c
            int r10 = r0.f25948k
            boolean r19 = com.itextpdf.text.Utilities.o(r9, r10)
            char[] r9 = r0.f25940c
            int r10 = r0.f25948k
            if (r19 == 0) goto L_0x00cf
            int r9 = com.itextpdf.text.Utilities.g(r9, r10)
        L_0x00c9:
            int r9 = r6.r(r9)
            r10 = r9
            goto L_0x00d2
        L_0x00cf:
            char r9 = r9[r10]
            goto L_0x00c9
        L_0x00d2:
            boolean r9 = com.itextpdf.text.pdf.PdfChunk.G(r10)
            if (r9 == 0) goto L_0x00dd
            r23 = r1
            r2 = 1
            goto L_0x0276
        L_0x00dd:
            if (r19 == 0) goto L_0x00e4
            float r9 = r6.f(r10)
            goto L_0x00f9
        L_0x00e4:
            boolean r9 = r6.y()
            if (r9 == 0) goto L_0x00ef
            float r9 = r6.m()
            goto L_0x00f9
        L_0x00ef:
            char[] r9 = r0.f25940c
            int r7 = r0.f25948k
            char r7 = r9[r7]
            float r9 = r6.f(r7)
        L_0x00f9:
            float r7 = r15 - r9
            int r7 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r7 >= 0) goto L_0x011c
            if (r14 != 0) goto L_0x011c
            boolean r7 = r6.y()
            if (r7 == 0) goto L_0x011c
            com.itextpdf.text.Image r7 = r6.h()
            boolean r20 = r7.I1()
            if (r20 == 0) goto L_0x011c
            float r7 = r7.a0()
            float r7 = r15 / r7
            r6.J(r7)
            r7 = r15
            goto L_0x011d
        L_0x011c:
            r7 = r9
        L_0x011d:
            boolean r9 = r6.D()
            if (r9 == 0) goto L_0x01d3
            java.lang.String r7 = "TABSETTINGS"
            boolean r7 = r6.v(r7)
            if (r7 == 0) goto L_0x018a
            int r7 = r0.f25948k
            if (r13 == 0) goto L_0x0144
            float r9 = r4 - r15
            float r10 = r13.e(r11, r9, r12)
            float r9 = r9 - r11
            float r9 = r9 + r10
            float r9 = r4 - r9
            int r15 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r15 >= 0) goto L_0x0140
            float r10 = r10 + r9
            r15 = 0
            goto L_0x0141
        L_0x0140:
            r15 = r9
        L_0x0141:
            r13.j(r10)
        L_0x0144:
            float r9 = r4 - r15
            com.itextpdf.text.TabStop r13 = com.itextpdf.text.pdf.PdfChunk.p(r6, r9)
            float r10 = r13.d()
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x015e
            r23 = r1
            r3 = r7
            r1 = r11
            r21 = r12
            r2 = r14
            r9 = r19
            r7 = 0
            goto L_0x028e
        L_0x015e:
            r6.K(r13)
            if (r8 != 0) goto L_0x017f
            com.itextpdf.text.TabStop$Alignment r10 = r13.a()
            com.itextpdf.text.TabStop$Alignment r11 = com.itextpdf.text.TabStop.Alignment.LEFT
            if (r10 != r11) goto L_0x017f
            float r9 = r13.d()
            float r9 = r4 - r9
            r23 = r1
            r22 = r6
            r16 = r7
            r15 = r9
            r11 = 2143289344(0x7fc00000, float:NaN)
            r12 = 2143289344(0x7fc00000, float:NaN)
            r13 = 0
            goto L_0x026a
        L_0x017f:
            r23 = r1
            r22 = r6
            r16 = r7
            r11 = r9
            r12 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x026a
        L_0x018a:
            java.lang.String r7 = "TAB"
            java.lang.Object r7 = r6.e(r7)
            java.lang.Object[] r7 = (java.lang.Object[]) r7
            r9 = r7[r5]
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
            r7 = r7[r17]
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x01bf
            float r7 = r4 - r15
            int r7 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x01bf
            com.itextpdf.text.pdf.PdfLine r9 = new com.itextpdf.text.pdf.PdfLine
            int r2 = r0.f25948k
            int r2 = r2 - r5
            java.util.ArrayList r7 = r0.e(r1, r2)
            r2 = 0
            r6 = 1
            r1 = r9
            r3 = r26
            r4 = r15
            r5 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x01bf:
            com.itextpdf.text.pdf.PdfChunk[] r7 = r0.f25941d
            int r10 = r0.f25948k
            r7 = r7[r10]
            r10 = r25
            r7.a(r10)
            float r7 = r4 - r9
            r23 = r1
            r22 = r6
        L_0x01d0:
            r15 = r7
            goto L_0x026a
        L_0x01d3:
            boolean r9 = r6.A()
            if (r9 == 0) goto L_0x020a
            java.lang.String r7 = "SEPARATOR"
            java.lang.Object r7 = r6.e(r7)
            java.lang.Object[] r7 = (java.lang.Object[]) r7
            r9 = r7[r2]
            com.itextpdf.text.pdf.draw.DrawInterface r9 = (com.itextpdf.text.pdf.draw.DrawInterface) r9
            r7 = r7[r5]
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0204
            boolean r7 = r9 instanceof com.itextpdf.text.pdf.draw.LineSeparator
            if (r7 == 0) goto L_0x0204
            com.itextpdf.text.pdf.draw.LineSeparator r9 = (com.itextpdf.text.pdf.draw.LineSeparator) r9
            float r7 = r9.l()
            float r7 = r7 * r4
            r9 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 / r9
            float r15 = r15 - r7
            int r7 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r7 >= 0) goto L_0x0204
            r15 = 0
        L_0x0204:
            r23 = r1
            r22 = r6
            goto L_0x026a
        L_0x020a:
            int r9 = r0.f25948k
            int r3 = r0.f25942e
            char[] r2 = r0.f25940c
            com.itextpdf.text.pdf.PdfChunk[] r5 = r0.f25941d
            r21 = r9
            r9 = r6
            r22 = r6
            r6 = r10
            r10 = r1
            r23 = r1
            r1 = r11
            r11 = r21
            r21 = r12
            r12 = r3
            r3 = r13
            r13 = r2
            r2 = r14
            r14 = r5
            boolean r5 = r9.w(r10, r11, r12, r13, r14)
            if (r5 == 0) goto L_0x0236
            char r9 = (char) r6
            boolean r9 = java.lang.Character.isWhitespace(r9)
            if (r9 == 0) goto L_0x0236
            int r9 = r0.f25948k
            r16 = r9
        L_0x0236:
            float r7 = r15 - r7
            int r9 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r9 >= 0) goto L_0x0242
            r7 = r3
            r3 = r16
            r9 = r19
            goto L_0x028e
        L_0x0242:
            if (r3 == 0) goto L_0x025c
            com.itextpdf.text.TabStop$Alignment r2 = r3.a()
            com.itextpdf.text.TabStop$Alignment r9 = com.itextpdf.text.TabStop.Alignment.ANCHOR
            if (r2 != r9) goto L_0x025c
            boolean r2 = java.lang.Float.isNaN(r21)
            if (r2 == 0) goto L_0x025c
            char r2 = r3.b()
            char r6 = (char) r6
            if (r2 != r6) goto L_0x025c
            float r12 = r4 - r15
            goto L_0x025e
        L_0x025c:
            r12 = r21
        L_0x025e:
            if (r5 == 0) goto L_0x0268
            int r2 = r0.f25948k
            r11 = r1
            r16 = r2
        L_0x0265:
            r13 = r3
            goto L_0x01d0
        L_0x0268:
            r11 = r1
            goto L_0x0265
        L_0x026a:
            if (r19 == 0) goto L_0x0273
            int r1 = r0.f25948k
            r2 = 1
            int r1 = r1 + r2
            r0.f25948k = r1
            goto L_0x0274
        L_0x0273:
            r2 = 1
        L_0x0274:
            r14 = r22
        L_0x0276:
            int r1 = r0.f25948k
            int r1 = r1 + r2
            r0.f25948k = r1
            r9 = r19
            r1 = r23
            r2 = 0
            r5 = 1
            r7 = 0
            goto L_0x0063
        L_0x0284:
            r23 = r1
            r1 = r11
            r21 = r12
            r3 = r13
            r2 = r14
            r7 = r3
            r3 = r16
        L_0x028e:
            if (r2 != 0) goto L_0x02b5
            int r1 = r0.f25948k
            int r2 = r1 + 1
            r0.f25948k = r2
            if (r9 == 0) goto L_0x029c
            int r1 = r1 + 2
            r0.f25948k = r1
        L_0x029c:
            com.itextpdf.text.pdf.PdfLine r9 = new com.itextpdf.text.pdf.PdfLine
            int r1 = r0.f25948k
            int r2 = r1 + -1
            r3 = 1
            int r1 = r1 - r3
            java.util.ArrayList r7 = r0.e(r2, r1)
            r2 = 0
            r5 = 0
            r6 = 0
            r1 = r9
            r3 = r26
            r4 = r5
            r5 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x02b5:
            if (r7 == 0) goto L_0x02d6
            float r5 = r4 - r15
            r12 = r21
            float r5 = r7.e(r1, r5, r12)
            float r6 = r5 - r1
            float r15 = r15 - r6
            int r6 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r6 >= 0) goto L_0x02c8
            float r5 = r5 + r15
            goto L_0x02ca
        L_0x02c8:
            r18 = r15
        L_0x02ca:
            if (r8 != 0) goto L_0x02d0
        L_0x02cc:
            r7.j(r5)
            goto L_0x02d4
        L_0x02d0:
            float r5 = r4 - r18
            float r5 = r5 - r1
            goto L_0x02cc
        L_0x02d4:
            r15 = r18
        L_0x02d6:
            int r1 = r0.f25948k
            int r5 = r0.f25942e
            if (r1 < r5) goto L_0x02f2
            com.itextpdf.text.pdf.PdfLine r9 = new com.itextpdf.text.pdf.PdfLine
            r1 = 1
            int r5 = r5 - r1
            r6 = r23
            java.util.ArrayList r7 = r0.e(r6, r5)
            r2 = 0
            r6 = 1
            r1 = r9
            r3 = r26
            r4 = r15
            r5 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x02f2:
            r6 = r23
            r5 = 1
            int r1 = r1 - r5
            int r1 = r0.y(r6, r1)
            if (r1 >= r6) goto L_0x0311
            com.itextpdf.text.pdf.PdfLine r9 = new com.itextpdf.text.pdf.PdfLine
            int r1 = r0.f25948k
            int r1 = r1 - r5
            java.util.ArrayList r7 = r0.e(r6, r1)
            r2 = 0
            r6 = 0
            r1 = r9
            r3 = r26
            r4 = r15
            r5 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x0311:
            int r5 = r0.f25948k
            r7 = 1
            int r5 = r5 - r7
            if (r1 != r5) goto L_0x0387
            java.lang.String r5 = "HYPHENATION"
            java.lang.Object r5 = r2.e(r5)
            com.itextpdf.text.pdf.HyphenationEvent r5 = (com.itextpdf.text.pdf.HyphenationEvent) r5
            if (r5 == 0) goto L_0x0387
            int[] r9 = r0.l(r6, r1)
            if (r9 == 0) goto L_0x0387
            r10 = 0
            r11 = r9[r10]
            int r12 = r0.f25948k
            int r12 = r12 - r7
            float r11 = r0.j(r11, r12)
            float r11 = r11 + r15
            java.lang.String r12 = new java.lang.String
            char[] r13 = r0.f25940c
            r14 = r9[r10]
            r10 = r9[r7]
            int r10 = r10 - r14
            r12.<init>(r13, r14, r10)
            com.itextpdf.text.pdf.PdfFont r7 = r2.d()
            com.itextpdf.text.pdf.BaseFont r7 = r7.c()
            com.itextpdf.text.pdf.PdfFont r10 = r2.d()
            float r10 = r10.g()
            java.lang.String r7 = r5.c(r12, r7, r10, r11)
            java.lang.String r5 = r5.b()
            int r10 = r7.length()
            if (r10 <= 0) goto L_0x0387
            com.itextpdf.text.pdf.PdfChunk r1 = new com.itextpdf.text.pdf.PdfChunk
            r1.<init>((java.lang.String) r7, (com.itextpdf.text.pdf.PdfChunk) r2)
            r3 = 1
            r10 = r9[r3]
            int r5 = r5.length()
            int r10 = r10 - r5
            r0.f25948k = r10
            com.itextpdf.text.pdf.PdfLine r10 = new com.itextpdf.text.pdf.PdfLine
            float r2 = r2.S(r7)
            float r5 = r11 - r2
            r2 = 0
            r2 = r9[r2]
            int r2 = r2 - r3
            java.util.ArrayList r7 = r0.f(r6, r2, r1)
            r2 = 0
            r6 = 0
            r1 = r10
            r3 = r26
            r4 = r5
            r5 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r10
        L_0x0387:
            r2 = -1
            if (r3 != r2) goto L_0x038d
            r5 = 1
            r0.u = r5
        L_0x038d:
            if (r3 == r2) goto L_0x03ba
            if (r3 < r1) goto L_0x0392
            goto L_0x03ba
        L_0x0392:
            int r1 = r3 + 1
            r0.f25948k = r1
            int r1 = r0.y(r6, r3)
            if (r1 >= r6) goto L_0x03a0
            int r1 = r0.f25948k
            r2 = 1
            int r1 = r1 - r2
        L_0x03a0:
            com.itextpdf.text.pdf.PdfLine r9 = new com.itextpdf.text.pdf.PdfLine
            float r2 = r0.k(r6, r1, r4)
            float r5 = r4 - r2
            r7 = 0
            java.util.ArrayList r10 = r0.e(r6, r1)
            r2 = 0
            r1 = r9
            r3 = r26
            r4 = r5
            r5 = r27
            r6 = r7
            r7 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x03ba:
            com.itextpdf.text.pdf.PdfLine r9 = new com.itextpdf.text.pdf.PdfLine
            int r2 = r1 + 1
            int r3 = r0.f25948k
            r5 = 1
            int r3 = r3 - r5
            float r2 = r0.k(r2, r3, r4)
            float r5 = r15 + r2
            r7 = 0
            java.util.ArrayList r10 = r0.e(r6, r1)
            r2 = 0
            r1 = r9
            r3 = r26
            r4 = r5
            r5 = r27
            r6 = r7
            r7 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BidiLine.r(float, float, int, int, int, float, float, float):com.itextpdf.text.pdf.PdfLine");
    }

    public void s(int i2, int i3) {
        byte b2 = this.f25943f[i2];
        byte b3 = b2;
        byte b4 = b3;
        byte b5 = b4;
        for (int i4 = i2 + 1; i4 <= i3; i4++) {
            byte b6 = this.f25943f[i4];
            if (b6 > b5) {
                b5 = b6;
            } else if (b6 < b4) {
                b4 = b6;
            }
            b3 = (byte) (b3 & b6);
            b2 = (byte) (b2 | b6);
        }
        if ((b2 & 1) != 0) {
            if ((b3 & 1) == 1) {
                h(i2, i3 + 1);
                return;
            }
            byte b7 = (byte) (b4 | 1);
            while (b5 >= b7) {
                int i5 = i2;
                while (true) {
                    if (i5 <= i3 && this.f25943f[i5] < b5) {
                        i5++;
                    } else if (i5 > i3) {
                        break;
                    } else {
                        int i6 = i5 + 1;
                        while (i6 <= i3 && this.f25943f[i6] >= b5) {
                            i6++;
                        }
                        h(i5, i6);
                        i5 = i6 + 1;
                    }
                }
                b5 = (byte) (b5 - 1);
            }
        }
    }

    public void t() {
        this.f25938a = this.f25949l;
        int i2 = this.o;
        this.f25942e = i2;
        this.f25946i = this.r;
        this.f25947j = this.s;
        this.f25948k = this.t;
        if (!this.v) {
            System.arraycopy(this.f25950m, 0, this.f25940c, 0, i2);
            System.arraycopy(this.f25951n, 0, this.f25941d, 0, this.f25942e);
        }
        int i3 = this.f25938a;
        if (i3 == 2 || i3 == 3) {
            byte[] bArr = this.p;
            int i4 = this.f25948k;
            System.arraycopy(bArr, i4, this.f25943f, i4, this.f25942e - i4);
            int[] iArr = this.q;
            int i5 = this.f25948k;
            System.arraycopy(iArr, i5, this.f25944g, i5, this.f25942e - i5);
        }
    }

    public void u() {
        int i2 = this.f25946i;
        boolean z = true;
        if (i2 > 0) {
            if (i2 < this.f25945h.size()) {
                while (true) {
                    this.f25946i--;
                    int i3 = this.f25946i;
                    if (i3 < 0) {
                        break;
                    }
                    this.f25945h.remove(i3);
                }
            } else {
                this.f25945h.clear();
            }
            this.f25946i = 0;
        }
        this.f25949l = this.f25938a;
        int i4 = this.f25942e;
        this.o = i4;
        this.r = this.f25946i;
        this.s = this.f25947j;
        int i5 = this.f25948k;
        this.t = i5;
        if (i5 >= i4) {
            z = false;
        }
        this.v = z;
        if (!z) {
            if (this.f25950m.length < i4) {
                this.f25950m = new char[i4];
                this.f25951n = new PdfChunk[i4];
            }
            System.arraycopy(this.f25940c, 0, this.f25950m, 0, i4);
            System.arraycopy(this.f25941d, 0, this.f25951n, 0, this.f25942e);
        }
        int i6 = this.f25938a;
        if (i6 == 2 || i6 == 3) {
            int length = this.p.length;
            int i7 = this.f25942e;
            if (length < i7) {
                this.p = new byte[i7];
                this.q = new int[i7];
            }
            byte[] bArr = this.f25943f;
            int i8 = this.f25948k;
            System.arraycopy(bArr, i8, this.p, i8, i7 - i8);
            int[] iArr = this.f25944g;
            int i9 = this.f25948k;
            System.arraycopy(iArr, i9, this.q, i9, this.f25942e - i9);
        }
    }

    public int v(int i2, int i3) {
        while (i2 <= i3 && n((char) this.f25941d[i2].r(this.f25940c[i2]))) {
            i2++;
        }
        return i2;
    }

    public int w(int i2, int i3) {
        while (i2 <= i3) {
            char r2 = (char) this.f25941d[i2].r(this.f25940c[i2]);
            if (!n(r2) && !PdfChunk.G(r2) && (!this.f25941d[i2].D() || !this.f25941d[i2].v(Chunk.h3) || !((Boolean) ((Object[]) this.f25941d[i2].e(Chunk.g3))[1]).booleanValue())) {
                break;
            }
            i2++;
        }
        return i2;
    }

    public int x(int i2, int i3) {
        while (i3 >= i2 && n((char) this.f25941d[i3].r(this.f25940c[i3]))) {
            i3--;
        }
        return i3;
    }

    public int y(int i2, int i3) {
        while (i3 >= i2) {
            char r2 = (char) this.f25941d[i3].r(this.f25940c[i3]);
            if (!n(r2) && !PdfChunk.G(r2) && (!this.f25941d[i3].D() || !this.f25941d[i3].v(Chunk.h3) || !((Boolean) ((Object[]) this.f25941d[i3].e(Chunk.g3))[1]).booleanValue())) {
                break;
            }
            i3--;
        }
        return i3;
    }

    public BidiLine(BidiLine bidiLine) {
        this.f25938a = bidiLine.f25938a;
        this.f25939b = bidiLine.f25939b;
        this.f25940c = (char[]) bidiLine.f25940c.clone();
        this.f25941d = (PdfChunk[]) bidiLine.f25941d.clone();
        this.f25942e = bidiLine.f25942e;
        this.f25943f = (byte[]) bidiLine.f25943f.clone();
        this.f25944g = (int[]) bidiLine.f25944g.clone();
        this.f25945h = new ArrayList<>(bidiLine.f25945h);
        this.f25946i = bidiLine.f25946i;
        this.f25947j = bidiLine.f25947j;
        this.f25948k = bidiLine.f25948k;
        this.f25949l = bidiLine.f25949l;
        this.f25950m = (char[]) bidiLine.f25950m.clone();
        this.f25951n = (PdfChunk[]) bidiLine.f25951n.clone();
        this.o = bidiLine.o;
        this.p = (byte[]) bidiLine.p.clone();
        this.q = (int[]) bidiLine.q.clone();
        this.r = bidiLine.r;
        this.s = bidiLine.s;
        this.t = bidiLine.t;
        this.v = bidiLine.v;
        this.w = bidiLine.w;
    }
}
