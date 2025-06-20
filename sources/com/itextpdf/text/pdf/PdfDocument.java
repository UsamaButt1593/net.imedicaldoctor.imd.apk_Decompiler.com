package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListLabel;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.Version;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.TempFileCache;
import com.itextpdf.text.pdf.collection.PdfCollection;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.internal.PdfAnnotationsImp;
import com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp;
import com.itextpdf.text.xml.xmp.PdfProperties;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;

public class PdfDocument extends Document {
    static final String q4 = ".,;:'";
    protected static final DecimalFormat r4 = new DecimalFormat("0000000000000000");
    protected int A3 = 0;
    protected float B3 = 0.0f;
    protected boolean C3 = false;
    protected PdfAction D3 = null;
    protected TabSettings E3;
    private Stack<Float> F3 = new Stack<>();
    private PdfBody G3;
    protected int H3;
    protected float I3;
    protected float J3;
    protected float K3;
    protected float L3;
    protected boolean M3 = true;
    protected PdfLine N3 = null;
    protected ArrayList<PdfLine> O3 = new ArrayList<>();
    protected int P3 = -1;
    protected Indentation Q3 = new Indentation();
    protected PdfInfo R3 = new PdfInfo();
    protected PdfOutline S3;
    protected PdfOutline T3;
    protected PdfViewerPreferencesImp U3 = new PdfViewerPreferencesImp();
    protected PdfPageLabels V3;
    protected TreeMap<String, Destination> W3 = new TreeMap<>();
    int X3;
    protected HashMap<String, PdfObject> Y3 = new HashMap<>();
    protected HashMap<String, PdfObject> Z3 = new HashMap<>();
    protected String a4;
    protected PdfAction b4;
    protected PdfDictionary c4;
    protected PdfCollection d4;
    PdfAnnotationsImp e4;
    protected PdfString f4;
    protected Rectangle g4 = null;
    protected HashMap<String, PdfRectangle> h4 = new HashMap<>();
    protected HashMap<String, PdfRectangle> i4 = new HashMap<>();
    private boolean j4 = true;
    protected PdfDictionary k4 = null;
    protected PageResources l4;
    protected boolean m4 = false;
    protected float n4 = -1.0f;
    protected PdfWriter o3;
    protected Image o4 = null;
    private HashMap<AccessibleElementId, PdfStructureElement> p3 = new HashMap<>();
    private ArrayList<Element> p4 = new ArrayList<>();
    private TempFileCache q3;
    private HashMap<AccessibleElementId, TempFileCache.ObjectPosition> r3 = new HashMap<>();
    private HashMap<AccessibleElementId, AccessibleElementId> s3 = new HashMap<>();
    private boolean t3 = false;
    protected boolean u3 = false;
    protected HashMap<Object, int[]> v3 = new HashMap<>();
    protected HashMap<Object, Integer> w3 = new HashMap<>();
    protected PdfContentByte x3;
    protected PdfContentByte y3;
    protected float z3 = 0.0f;

    public class Destination {

        /* renamed from: a  reason: collision with root package name */
        public PdfAction f26183a;

        /* renamed from: b  reason: collision with root package name */
        public PdfIndirectReference f26184b;

        /* renamed from: c  reason: collision with root package name */
        public PdfDestination f26185c;

        public Destination() {
        }
    }

    public static class Indentation {

        /* renamed from: a  reason: collision with root package name */
        float f26187a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        float f26188b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        float f26189c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        float f26190d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        float f26191e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        float f26192f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        float f26193g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        float f26194h = 0.0f;

        /* renamed from: i  reason: collision with root package name */
        float f26195i = 0.0f;
    }

    static class PdfCatalog extends PdfDictionary {
        PdfWriter p3;

        PdfCatalog(PdfIndirectReference pdfIndirectReference, PdfWriter pdfWriter) {
            super(PdfDictionary.o3);
            this.p3 = pdfWriter;
            V0(PdfName.zc, pdfIndirectReference);
        }

        /* access modifiers changed from: package-private */
        public void f1(TreeMap<String, Destination> treeMap, HashMap<String, PdfObject> hashMap, HashMap<String, PdfObject> hashMap2, PdfWriter pdfWriter) {
            if (!treeMap.isEmpty() || !hashMap.isEmpty() || !hashMap2.isEmpty()) {
                try {
                    PdfDictionary pdfDictionary = new PdfDictionary();
                    if (!treeMap.isEmpty()) {
                        HashMap hashMap3 = new HashMap();
                        for (Map.Entry next : treeMap.entrySet()) {
                            String str = (String) next.getKey();
                            Destination destination = (Destination) next.getValue();
                            if (destination.f26185c != null) {
                                hashMap3.put(str, destination.f26184b);
                            }
                        }
                        if (hashMap3.size() > 0) {
                            pdfDictionary.V0(PdfName.z6, pdfWriter.v0(PdfNameTree.c(hashMap3, pdfWriter)).a());
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        pdfDictionary.V0(PdfName.aa, pdfWriter.v0(PdfNameTree.c(hashMap, pdfWriter)).a());
                    }
                    if (!hashMap2.isEmpty()) {
                        pdfDictionary.V0(PdfName.j7, pdfWriter.v0(PdfNameTree.c(hashMap2, pdfWriter)).a());
                    }
                    if (pdfDictionary.size() > 0) {
                        V0(PdfName.sb, pdfWriter.v0(pdfDictionary).a());
                    }
                } catch (IOException e2) {
                    throw new ExceptionConverter(e2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void i1(PdfDictionary pdfDictionary) {
            try {
                V0(PdfName.m3, this.p3.v0(pdfDictionary).a());
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        }

        /* access modifiers changed from: package-private */
        public void m1(PdfAction pdfAction) {
            V0(PdfName.cc, pdfAction);
        }
    }

    public static class PdfInfo extends PdfDictionary {
        PdfInfo() {
            o1();
            i1();
        }

        /* access modifiers changed from: package-private */
        public void f1(String str) {
            V0(PdfName.g4, new PdfString(str, PdfObject.h3));
        }

        /* access modifiers changed from: package-private */
        public void i1() {
            PdfDate pdfDate = new PdfDate();
            V0(PdfName.U5, pdfDate);
            V0(PdfName.ib, pdfDate);
        }

        /* access modifiers changed from: package-private */
        public void m1(String str) {
            V0(PdfName.V5, new PdfString(str, PdfObject.h3));
        }

        /* access modifiers changed from: package-private */
        public void n1(String str) {
            V0(PdfName.ha, new PdfString(str, PdfObject.h3));
        }

        /* access modifiers changed from: package-private */
        public void o1() {
            V0(PdfName.sd, new PdfString(Version.a().e()));
        }

        /* access modifiers changed from: package-private */
        public void p1(String str) {
            V0(PdfName.Af, new PdfString(str, PdfObject.h3));
        }

        /* access modifiers changed from: package-private */
        public void q1(String str) {
            V0(PdfName.ig, new PdfString(str, PdfObject.h3));
        }

        /* access modifiers changed from: package-private */
        public void s1(String str, String str2) {
            if (!str.equals(PdfProperties.f27411c) && !str.equals("CreationDate")) {
                V0(new PdfName(str), new PdfString(str2, PdfObject.h3));
            }
        }

        PdfInfo(String str, String str2, String str3) {
            this();
            q1(str2);
            p1(str3);
            f1(str);
        }
    }

    public PdfDocument() {
        p();
        d();
    }

    private PdfLine A0() {
        if (this.O3.size() <= 0) {
            return null;
        }
        ArrayList<PdfLine> arrayList = this.O3;
        return arrayList.get(arrayList.size() - 1);
    }

    private static boolean V0(PdfWriter pdfWriter) {
        return pdfWriter != null && pdfWriter.X1();
    }

    private void Z(PdfDiv pdfDiv) throws DocumentException {
        if (this.p4 == null) {
            this.p4 = new ArrayList<>();
        }
        this.p4.add(pdfDiv);
    }

    private void r0() throws DocumentException {
        ArrayList<Element> arrayList = this.p4;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<Element> arrayList2 = this.p4;
            this.p4 = null;
            FloatLayout floatLayout = new FloatLayout(arrayList2, false);
            int i2 = 0;
            while (true) {
                P0();
                floatLayout.h(P0(), O0(), Q0(), R0() - this.B3);
                try {
                    if ((floatLayout.e(V0(this.o3) ? this.x3 : this.o3.g1(), false) & 1) != 0) {
                        if (V0(this.o3)) {
                            this.x3.e3(P0(), floatLayout.d());
                        } else {
                            this.x3.t1(0.0f, (floatLayout.d() - R0()) + this.B3);
                        }
                        this.B3 = R0() - floatLayout.d();
                        return;
                    }
                    i2 = (R0() - this.B3 == floatLayout.d() || T0()) ? i2 + 1 : 0;
                    if (i2 != 2) {
                        f();
                    } else {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void A1(TempFileCache tempFileCache) {
        this.t3 = true;
        this.q3 = tempFileCache;
    }

    public float B0() {
        return this.z3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v4, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r55v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v27, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v4, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v49, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v50, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v56, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v57, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v66, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v67, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v68, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: com.itextpdf.text.pdf.PdfAction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v62, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v63, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v36, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r42v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: float[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v11, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v42, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v65, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v67, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v81, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v82, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v89, resolved type: float[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v83, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v84, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v17, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v85, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v9, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v90, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v91, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v93, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v20, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v21, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v22, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v23, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v24, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v44, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v36, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v76, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v46, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v37, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v77, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v7, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v10, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v78, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v47, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v38, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v8, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v9, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v46, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v106, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v56, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v47, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v109, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v56, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v4, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v54, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v66, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v58, resolved type: float} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03d8  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0491  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x049b  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0533  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0546  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x054f  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0584  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x05cf  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x05d8  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x05dc  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x05e2  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x05f5  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x061e  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0626  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x06af  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0754  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x078e  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x0796  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x079d  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x07a2  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x07a9  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x07b2  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x07c0  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x08b1  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x08b7  */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x08bc  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x08c2  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x08cb  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x08dc  */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x08df  */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x08e9  */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x0934  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x0946  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float B1(com.itextpdf.text.pdf.PdfLine r61, com.itextpdf.text.pdf.PdfContentByte r62, com.itextpdf.text.pdf.PdfContentByte r63, java.lang.Object[] r64, float r65) throws com.itextpdf.text.DocumentException {
        /*
            r60 = this;
            r7 = r60
            r8 = r61
            r9 = r62
            r14 = r63
            r15 = 0
            r0 = r64[r15]
            com.itextpdf.text.pdf.PdfFont r0 = (com.itextpdf.text.pdf.PdfFont) r0
            r12 = 1
            r1 = r64[r12]
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            float r2 = r62.l1()
            float r3 = r61.k()
            float r2 = r2 + r3
            int r13 = r61.w()
            int r3 = r61.i()
            boolean r4 = r61.n()
            if (r4 == 0) goto L_0x0034
            if (r13 != 0) goto L_0x0031
            if (r3 <= r12) goto L_0x0034
        L_0x0031:
            r26 = 1
            goto L_0x0036
        L_0x0034:
            r26 = 0
        L_0x0036:
            int r4 = r61.l()
            r11 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            if (r4 <= 0) goto L_0x0050
            float r3 = r61.B()
            float r4 = (float) r4
            float r3 = r3 / r4
            r27 = r1
            r28 = r2
            r4 = r3
        L_0x004a:
            r5 = 0
            r6 = 0
        L_0x004c:
            r29 = 0
            goto L_0x00eb
        L_0x0050:
            if (r26 == 0) goto L_0x00d6
            if (r4 != 0) goto L_0x00d6
            boolean r4 = r61.q()
            if (r4 == 0) goto L_0x0082
            float r4 = r61.B()
            float r5 = (float) r13
            float r5 = r5 * r65
            float r6 = (float) r3
            float r5 = r5 + r6
            float r5 = r5 - r11
            float r5 = r5 * r1
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0082
            boolean r3 = r61.r()
            if (r3 == 0) goto L_0x0078
            float r3 = r61.B()
            float r3 = r3 - r5
            r9.t1(r3, r10)
        L_0x0078:
            float r3 = r65 * r1
            r6 = r1
            r27 = r6
            r28 = r2
            r5 = r3
            r4 = 0
            goto L_0x004c
        L_0x0082:
            float r1 = r61.B()
            int r4 = r61.A()
            int r4 = r4 - r12
            com.itextpdf.text.pdf.PdfChunk r4 = r8.f(r4)
            if (r4 == 0) goto L_0x00c2
            java.lang.String r5 = r4.toString()
            int r6 = r5.length()
            if (r6 <= 0) goto L_0x00c2
            int r6 = r5.length()
            int r6 = r6 - r12
            char r5 = r5.charAt(r6)
            java.lang.String r6 = ".,;:'"
            int r6 = r6.indexOf(r5)
            if (r6 < 0) goto L_0x00c2
            com.itextpdf.text.pdf.PdfFont r4 = r4.d()
            float r4 = r4.i(r5)
            r5 = 1053609165(0x3ecccccd, float:0.4)
            float r4 = r4 * r5
            float r4 = r4 + r1
            float r1 = r4 - r1
            r59 = r4
            r4 = r1
            r1 = r59
            goto L_0x00c3
        L_0x00c2:
            r4 = 0
        L_0x00c3:
            float r5 = (float) r13
            float r5 = r5 * r65
            float r3 = (float) r3
            float r5 = r5 + r3
            float r5 = r5 - r11
            float r1 = r1 / r5
            float r3 = r65 * r1
            r6 = r1
            r27 = r6
            r28 = r2
            r5 = r3
            r29 = r4
            r4 = 0
            goto L_0x00eb
        L_0x00d6:
            int r3 = r8.f26240d
            if (r3 == 0) goto L_0x00e5
            r4 = -1
            if (r3 != r4) goto L_0x00de
            goto L_0x00e5
        L_0x00de:
            r27 = r1
            r28 = r2
            r4 = 0
            goto L_0x004a
        L_0x00e5:
            float r3 = r61.B()
            float r2 = r2 - r3
            goto L_0x00de
        L_0x00eb:
            int r3 = r61.h()
            float r30 = r62.l1()
            float r2 = r62.m1()
            java.util.Iterator r31 = r61.s()
            r1 = 2143289344(0x7fc00000, float:NaN)
            r1 = r0
            r16 = r30
            r0 = 0
            r17 = 0
            r18 = 0
            r32 = 2143289344(0x7fc00000, float:NaN)
            r33 = 0
        L_0x0109:
            boolean r19 = r31.hasNext()
            if (r19 == 0) goto L_0x092e
            java.lang.Object r19 = r31.next()
            r11 = r19
            com.itextpdf.text.pdf.PdfChunk r11 = (com.itextpdf.text.pdf.PdfChunk) r11
            com.itextpdf.text.pdf.PdfWriter r10 = r7.o3
            boolean r10 = V0(r10)
            if (r10 == 0) goto L_0x0129
            com.itextpdf.text.pdf.interfaces.IAccessibleElement r10 = r11.o
            if (r10 == 0) goto L_0x0129
            r9.B1(r10)
            r34 = 1
            goto L_0x012b
        L_0x0129:
            r34 = r18
        L_0x012b:
            com.itextpdf.text.BaseColor r10 = r11.c()
            com.itextpdf.text.pdf.PdfFont r18 = r11.d()
            float r15 = r18.g()
            boolean r18 = r11.y()
            if (r18 == 0) goto L_0x014d
            float r15 = r11.u()
            float r18 = r11.u()
            r23 = r4
            r24 = r18
            r12 = 0
            r18 = r1
            goto L_0x016f
        L_0x014d:
            com.itextpdf.text.pdf.PdfFont r18 = r11.d()
            com.itextpdf.text.pdf.BaseFont r12 = r18.c()
            r18 = r1
            r1 = 1
            float r12 = r12.I(r1, r15)
            com.itextpdf.text.pdf.PdfFont r1 = r11.d()
            com.itextpdf.text.pdf.BaseFont r1 = r1.c()
            r23 = r4
            r4 = 3
            float r1 = r1.I(r4, r15)
            r24 = r15
            r15 = r12
            r12 = r1
        L_0x016f:
            java.lang.String r4 = "HSCALE"
            java.lang.String r1 = "SKEW"
            r25 = r13
            java.lang.String r13 = "CHAR_SPACING"
            r35 = r10
            java.lang.String r10 = "WORD_SPACING"
            r36 = r13
            if (r0 > r3) goto L_0x06f5
            if (r26 == 0) goto L_0x0186
            float r37 = r11.s(r6, r5)
            goto L_0x018a
        L_0x0186:
            float r37 = r11.R()
        L_0x018a:
            boolean r38 = r11.C()
            if (r38 == 0) goto L_0x06cb
            int r13 = r0 + 1
            com.itextpdf.text.pdf.PdfChunk r13 = r8.f(r13)
            boolean r39 = r11.A()
            if (r39 == 0) goto L_0x0207
            r39 = r0
            java.lang.String r0 = "SEPARATOR"
            java.lang.Object r0 = r11.e(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r21 = 0
            r37 = r0[r21]
            com.itextpdf.text.pdf.draw.DrawInterface r37 = (com.itextpdf.text.pdf.draw.DrawInterface) r37
            r22 = 1
            r0 = r0[r22]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x01e5
            float r40 = r2 + r12
            float r0 = r61.k()
            float r41 = r30 + r0
            float r42 = r15 - r12
            r0 = r37
            r8 = r1
            r43 = r18
            r1 = r63
            r44 = r2
            r2 = r30
            r45 = r3
            r3 = r40
            r46 = r4
            r18 = r10
            r10 = r23
            r4 = r41
            r47 = r5
            r5 = r42
            r48 = r6
            r6 = r44
        L_0x01e1:
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x0204
        L_0x01e5:
            r8 = r1
            r45 = r3
            r46 = r4
            r47 = r5
            r48 = r6
            r43 = r18
            r6 = r2
            r18 = r10
            r10 = r23
            float r3 = r6 + r12
            float r4 = r16 + r10
            float r5 = r15 - r12
            r0 = r37
            r1 = r63
            r2 = r16
            r44 = r6
            goto L_0x01e1
        L_0x0204:
            r37 = r10
            goto L_0x021a
        L_0x0207:
            r39 = r0
            r8 = r1
            r44 = r2
            r45 = r3
            r46 = r4
            r47 = r5
            r48 = r6
            r43 = r18
            r18 = r10
            r10 = r23
        L_0x021a:
            boolean r0 = r11.D()
            if (r0 == 0) goto L_0x0284
            java.lang.String r0 = "TABSETTINGS"
            boolean r0 = r11.v(r0)
            if (r0 == 0) goto L_0x0251
            com.itextpdf.text.TabStop r0 = r11.o()
            if (r0 == 0) goto L_0x024e
            float r1 = r0.d()
            float r17 = r1 + r30
            com.itextpdf.text.pdf.draw.DrawInterface r1 = r0.c()
            if (r1 == 0) goto L_0x027f
            com.itextpdf.text.pdf.draw.DrawInterface r0 = r0.c()
            r6 = r44
            float r3 = r6 + r12
            float r5 = r15 - r12
        L_0x0244:
            r1 = r63
            r2 = r16
            r4 = r17
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x027f
        L_0x024e:
            r17 = r16
            goto L_0x027f
        L_0x0251:
            java.lang.String r0 = "TAB"
            java.lang.Object r0 = r11.e(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r1 = 0
            r2 = r0[r1]
            r1 = r2
            com.itextpdf.text.pdf.draw.DrawInterface r1 = (com.itextpdf.text.pdf.draw.DrawInterface) r1
            r2 = 1
            r3 = r0[r2]
            java.lang.Float r3 = (java.lang.Float) r3
            float r2 = r3.floatValue()
            r3 = 3
            r0 = r0[r3]
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            float r17 = r2 + r0
            int r0 = (r17 > r16 ? 1 : (r17 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x027f
            r6 = r44
            float r3 = r6 + r12
            float r5 = r15 - r12
            r0 = r1
            goto L_0x0244
        L_0x027f:
            r40 = r16
            r6 = r17
            goto L_0x0288
        L_0x0284:
            r6 = r16
            r40 = r17
        L_0x0288:
            java.lang.String r0 = "BACKGROUND"
            boolean r1 = r11.v(r0)
            if (r1 == 0) goto L_0x0316
            java.lang.Object r1 = r11.e(r0)
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            r2 = 0
            r3 = r1[r2]
            if (r3 == 0) goto L_0x0316
            boolean r2 = r63.Z0()
            if (r2 == 0) goto L_0x02ac
            com.itextpdf.text.pdf.PdfWriter r3 = r7.o3
            boolean r3 = V0(r3)
            if (r3 == 0) goto L_0x02ac
            r63.L0()
        L_0x02ac:
            r63.a2()
            if (r13 == 0) goto L_0x02b9
            boolean r0 = r13.v(r0)
            if (r0 == 0) goto L_0x02b9
            r0 = 0
            goto L_0x02bb
        L_0x02b9:
            r0 = r27
        L_0x02bb:
            if (r13 != 0) goto L_0x02bf
            float r0 = r0 + r29
        L_0x02bf:
            r3 = 0
            r4 = r1[r3]
            com.itextpdf.text.BaseColor r4 = (com.itextpdf.text.BaseColor) r4
            r14.h2(r4)
            r4 = 1
            r1 = r1[r4]
            float[] r1 = (float[]) r1
            r5 = r1[r3]
            float r5 = r6 - r5
            r3 = r44
            float r16 = r3 + r12
            r17 = r1[r4]
            float r16 = r16 - r17
            float r17 = r11.q()
            float r4 = r16 + r17
            float r0 = r37 - r0
            r16 = 0
            r17 = r1[r16]
            float r0 = r0 + r17
            r16 = 2
            r17 = r1[r16]
            float r0 = r0 + r17
            float r16 = r15 - r12
            r17 = 1
            r23 = r1[r17]
            float r16 = r16 + r23
            r17 = 3
            r1 = r1[r17]
            float r1 = r16 + r1
            r14.H1(r5, r4, r0, r1)
            r63.Q0()
            r0 = 0
            r14.u2(r0)
            r63.U1()
            if (r2 == 0) goto L_0x0318
            com.itextpdf.text.pdf.PdfWriter r0 = r7.o3
            boolean r0 = V0(r0)
            if (r0 == 0) goto L_0x0318
            r0 = 1
            r14.S(r0)
            goto L_0x0318
        L_0x0316:
            r3 = r44
        L_0x0318:
            java.lang.String r0 = "UNDERLINE"
            boolean r1 = r11.v(r0)
            r16 = 4
            if (r1 == 0) goto L_0x03d8
            boolean r1 = r63.Z0()
            if (r1 == 0) goto L_0x0333
            com.itextpdf.text.pdf.PdfWriter r2 = r7.o3
            boolean r2 = V0(r2)
            if (r2 == 0) goto L_0x0333
            r63.L0()
        L_0x0333:
            if (r13 == 0) goto L_0x033d
            boolean r2 = r13.v(r0)
            if (r2 == 0) goto L_0x033d
            r2 = 0
            goto L_0x033f
        L_0x033d:
            r2 = r27
        L_0x033f:
            if (r13 != 0) goto L_0x0343
            float r2 = r2 + r29
        L_0x0343:
            java.lang.Object r0 = r11.e(r0)
            java.lang.Object[][] r0 = (java.lang.Object[][]) r0
            r4 = 0
        L_0x034a:
            int r5 = r0.length
            if (r4 >= r5) goto L_0x03c0
            r5 = r0[r4]
            r17 = 0
            r21 = r5[r17]
            com.itextpdf.text.BaseColor r21 = (com.itextpdf.text.BaseColor) r21
            r22 = 1
            r5 = r5[r22]
            float[] r5 = (float[]) r5
            r23 = r0
            if (r21 != 0) goto L_0x0362
            r0 = r35
            goto L_0x0364
        L_0x0362:
            r0 = r21
        L_0x0364:
            if (r0 == 0) goto L_0x0369
            r14.l2(r0)
        L_0x0369:
            r41 = r5[r17]
            com.itextpdf.text.pdf.PdfFont r17 = r11.d()
            float r17 = r17.g()
            r22 = 1
            r42 = r5[r22]
            float r17 = r17 * r42
            r42 = r10
            float r10 = r41 + r17
            r14.J2(r10)
            r10 = 2
            r17 = r5[r10]
            com.itextpdf.text.pdf.PdfFont r10 = r11.d()
            float r10 = r10.g()
            r41 = 3
            r44 = r5[r41]
            float r10 = r10 * r44
            float r17 = r17 + r10
            r5 = r5[r16]
            int r5 = (int) r5
            if (r5 == 0) goto L_0x039b
            r14.y2(r5)
        L_0x039b:
            float r10 = r3 + r17
            r14.w1(r6, r10)
            float r17 = r6 + r37
            r41 = r8
            float r8 = r17 - r2
            r14.q1(r8, r10)
            r63.v3()
            if (r0 == 0) goto L_0x03b1
            r63.Q1()
        L_0x03b1:
            if (r5 == 0) goto L_0x03b7
            r0 = 0
            r14.y2(r0)
        L_0x03b7:
            int r4 = r4 + 1
            r0 = r23
            r8 = r41
            r10 = r42
            goto L_0x034a
        L_0x03c0:
            r41 = r8
            r42 = r10
            r8 = 1065353216(0x3f800000, float:1.0)
            r14.J2(r8)
            if (r1 == 0) goto L_0x03de
            com.itextpdf.text.pdf.PdfWriter r0 = r7.o3
            boolean r0 = V0(r0)
            if (r0 == 0) goto L_0x03de
            r0 = 1
            r14.S(r0)
            goto L_0x03de
        L_0x03d8:
            r41 = r8
            r42 = r10
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x03de:
            java.lang.String r0 = "ACTION"
            boolean r1 = r11.v(r0)
            if (r1 == 0) goto L_0x0491
            if (r13 == 0) goto L_0x03f0
            boolean r1 = r13.v(r0)
            if (r1 == 0) goto L_0x03f0
            r1 = 0
            goto L_0x03f2
        L_0x03f0:
            r1 = r27
        L_0x03f2:
            if (r13 != 0) goto L_0x03f6
            float r1 = r1 + r29
        L_0x03f6:
            boolean r2 = r11.y()
            if (r2 == 0) goto L_0x042d
            com.itextpdf.text.pdf.PdfWriter r2 = r7.o3
            float r4 = r11.k()
            float r4 = r4 + r3
            float r5 = r6 + r37
            float r5 = r5 - r1
            float r1 = r11.i()
            float r1 = r1 + r3
            float r10 = r11.k()
            float r10 = r10 + r1
            java.lang.Object r0 = r11.e(r0)
            r17 = r0
            com.itextpdf.text.pdf.PdfAction r17 = (com.itextpdf.text.pdf.PdfAction) r17
            r20 = 0
            r0 = r2
            r1 = r6
            r2 = r4
            r4 = r3
            r3 = r5
            r5 = r4
            r4 = r10
            r10 = r5
            r5 = r17
            r8 = r6
        L_0x0425:
            r6 = r20
            com.itextpdf.text.pdf.PdfAnnotation r0 = r0.K0(r1, r2, r3, r4, r5, r6)
            r1 = 1
            goto L_0x0453
        L_0x042d:
            r10 = r3
            r8 = r6
            com.itextpdf.text.pdf.PdfWriter r2 = r7.o3
            float r3 = r10 + r12
            float r4 = r11.q()
            float r3 = r3 + r4
            float r6 = r8 + r37
            float r4 = r6 - r1
            float r1 = r10 + r15
            float r5 = r11.q()
            float r5 = r5 + r1
            java.lang.Object r0 = r11.e(r0)
            r6 = r0
            com.itextpdf.text.pdf.PdfAction r6 = (com.itextpdf.text.pdf.PdfAction) r6
            r20 = 0
            r0 = r2
            r1 = r8
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            goto L_0x0425
        L_0x0453:
            r9.e(r0, r1)
            com.itextpdf.text.pdf.PdfWriter r1 = r7.o3
            boolean r1 = V0(r1)
            if (r1 == 0) goto L_0x0493
            com.itextpdf.text.pdf.interfaces.IAccessibleElement r1 = r11.o
            if (r1 == 0) goto L_0x0493
            com.itextpdf.text.AccessibleElementId r1 = r1.getId()
            com.itextpdf.text.pdf.PdfStructureElement r1 = r7.H0(r1)
            if (r1 == 0) goto L_0x0493
            int r2 = r7.K0(r0)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.vf
            com.itextpdf.text.pdf.PdfNumber r4 = new com.itextpdf.text.pdf.PdfNumber
            r4.<init>((int) r2)
            r0.V0(r3, r4)
            com.itextpdf.text.pdf.PdfWriter r3 = r7.o3
            com.itextpdf.text.pdf.PdfIndirectReference r3 = r3.d1()
            r1.v1(r0, r3)
            com.itextpdf.text.pdf.PdfWriter r0 = r7.o3
            com.itextpdf.text.pdf.PdfStructureTreeRoot r0 = r0.L1()
            com.itextpdf.text.pdf.PdfIndirectReference r1 = r1.p1()
            r0.w1(r2, r1)
            goto L_0x0493
        L_0x0491:
            r10 = r3
            r8 = r6
        L_0x0493:
            java.lang.String r0 = "REMOTEGOTO"
            boolean r1 = r11.v(r0)
            if (r1 == 0) goto L_0x04fe
            if (r13 == 0) goto L_0x04a5
            boolean r1 = r13.v(r0)
            if (r1 == 0) goto L_0x04a5
            r1 = 0
            goto L_0x04a7
        L_0x04a5:
            r1 = r27
        L_0x04a7:
            if (r13 != 0) goto L_0x04ab
            float r1 = r1 + r29
        L_0x04ab:
            java.lang.Object r0 = r11.e(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r2 = 0
            r3 = r0[r2]
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2
            r3 = 1
            r0 = r0[r3]
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L_0x04dd
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            float r0 = r10 + r12
            float r4 = r11.q()
            float r4 = r4 + r0
            float r6 = r8 + r37
            float r5 = r6 - r1
            float r0 = r10 + r15
            float r1 = r11.q()
            float r6 = r0 + r1
            r0 = r60
            r1 = r2
            r2 = r3
            r3 = r8
            r0.d1(r1, r2, r3, r4, r5, r6)
            goto L_0x04fe
        L_0x04dd:
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r3 = r0.intValue()
            float r0 = r10 + r12
            float r4 = r11.q()
            float r4 = r4 + r0
            float r6 = r8 + r37
            float r5 = r6 - r1
            float r0 = r10 + r15
            float r1 = r11.q()
            float r6 = r0 + r1
            r0 = r60
            r1 = r2
            r2 = r3
            r3 = r8
            r0.c1(r1, r2, r3, r4, r5, r6)
        L_0x04fe:
            java.lang.String r0 = "LOCALGOTO"
            boolean r1 = r11.v(r0)
            if (r1 == 0) goto L_0x052b
            if (r13 == 0) goto L_0x0510
            boolean r1 = r13.v(r0)
            if (r1 == 0) goto L_0x0510
            r1 = 0
            goto L_0x0512
        L_0x0510:
            r1 = r27
        L_0x0512:
            if (r13 != 0) goto L_0x0516
            float r1 = r1 + r29
        L_0x0516:
            java.lang.Object r0 = r11.e(r0)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            float r6 = r8 + r37
            float r4 = r6 - r1
            float r5 = r10 + r24
            r0 = r60
            r1 = r2
            r2 = r8
            r3 = r10
            r0.X0(r1, r2, r3, r4, r5)
        L_0x052b:
            java.lang.String r0 = "LOCALDESTINATION"
            boolean r1 = r11.v(r0)
            if (r1 == 0) goto L_0x0546
            java.lang.Object r0 = r11.e(r0)
            java.lang.String r0 = (java.lang.String) r0
            com.itextpdf.text.pdf.PdfDestination r1 = new com.itextpdf.text.pdf.PdfDestination
            float r2 = r10 + r24
            r3 = 0
            r6 = 0
            r1.<init>(r3, r8, r2, r6)
            r7.W0(r0, r1)
            goto L_0x0547
        L_0x0546:
            r6 = 0
        L_0x0547:
            java.lang.String r0 = "GENERICTAG"
            boolean r1 = r11.v(r0)
            if (r1 == 0) goto L_0x057c
            if (r13 == 0) goto L_0x0559
            boolean r1 = r13.v(r0)
            if (r1 == 0) goto L_0x0559
            r1 = 0
            goto L_0x055b
        L_0x0559:
            r1 = r27
        L_0x055b:
            if (r13 != 0) goto L_0x055f
            float r1 = r1 + r29
        L_0x055f:
            com.itextpdf.text.Rectangle r2 = new com.itextpdf.text.Rectangle
            float r3 = r8 + r37
            float r3 = r3 - r1
            float r1 = r10 + r24
            r2.<init>(r8, r10, r3, r1)
            com.itextpdf.text.pdf.PdfWriter r1 = r7.o3
            com.itextpdf.text.pdf.PdfPageEvent r1 = r1.y1()
            if (r1 == 0) goto L_0x057c
            com.itextpdf.text.pdf.PdfWriter r3 = r7.o3
            java.lang.Object r0 = r11.e(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1.e(r3, r7, r2, r0)
        L_0x057c:
            java.lang.String r0 = "PDFANNOTATION"
            boolean r1 = r11.v(r0)
            if (r1 == 0) goto L_0x05b3
            if (r13 == 0) goto L_0x058e
            boolean r1 = r13.v(r0)
            if (r1 == 0) goto L_0x058e
            r1 = 0
            goto L_0x0590
        L_0x058e:
            r1 = r27
        L_0x0590:
            if (r13 != 0) goto L_0x0594
            float r1 = r1 + r29
        L_0x0594:
            java.lang.Object r0 = r11.e(r0)
            com.itextpdf.text.pdf.PdfAnnotation r0 = (com.itextpdf.text.pdf.PdfAnnotation) r0
            com.itextpdf.text.pdf.PdfAnnotation r0 = com.itextpdf.text.pdf.PdfFormField.s3(r0)
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Nd
            com.itextpdf.text.pdf.PdfRectangle r3 = new com.itextpdf.text.pdf.PdfRectangle
            float r4 = r10 + r12
            float r5 = r8 + r37
            float r5 = r5 - r1
            float r1 = r10 + r15
            r3.<init>(r8, r4, r5, r1)
            r0.V0(r2, r3)
            r1 = 1
            r9.e(r0, r1)
        L_0x05b3:
            r15 = r41
            java.lang.Object r0 = r11.e(r15)
            float[] r0 = (float[]) r0
            r12 = r46
            java.lang.Object r1 = r11.e(r12)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r0 != 0) goto L_0x05cd
            if (r1 == 0) goto L_0x05c8
            goto L_0x05cd
        L_0x05c8:
            r0 = 1065353216(0x3f800000, float:1.0)
            r19 = 0
            goto L_0x05f1
        L_0x05cd:
            if (r0 == 0) goto L_0x05d8
            r2 = 0
            r3 = r0[r2]
            r2 = 1
            r0 = r0[r2]
            r2 = r3
            r3 = r0
            goto L_0x05da
        L_0x05d8:
            r2 = 0
            r3 = 0
        L_0x05da:
            if (r1 == 0) goto L_0x05e2
            float r0 = r1.floatValue()
            r13 = r0
            goto L_0x05e4
        L_0x05e2:
            r13 = 1065353216(0x3f800000, float:1.0)
        L_0x05e4:
            r4 = 1065353216(0x3f800000, float:1.0)
            r0 = r62
            r1 = r13
            r5 = r8
            r19 = 0
            r6 = r10
            r0.f3(r1, r2, r3, r4, r5, r6)
            r0 = r13
        L_0x05f1:
            r1 = r18
            if (r26 != 0) goto L_0x061e
            boolean r2 = r11.v(r1)
            if (r2 == 0) goto L_0x0608
            java.lang.Object r2 = r11.e(r1)
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            r9.k3(r2)
        L_0x0608:
            r2 = r36
            boolean r3 = r11.v(r2)
            if (r3 == 0) goto L_0x0620
            java.lang.Object r3 = r11.e(r2)
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            r9.g2(r3)
            goto L_0x0620
        L_0x061e:
            r2 = r36
        L_0x0620:
            boolean r3 = r11.y()
            if (r3 == 0) goto L_0x06af
            com.itextpdf.text.Image r3 = r11.h()
            float r37 = r11.m()
            float r4 = r11.l()
            float[] r4 = r3.M1(r4)
            float r5 = r11.j()
            float r6 = r8 + r5
            r5 = r4[r16]
            float r6 = r6 - r5
            r4[r16] = r6
            float r5 = r11.k()
            float r5 = r5 + r10
            r6 = 5
            r13 = r4[r6]
            float r5 = r5 - r13
            r4[r6] = r5
            r6 = 0
            r13 = r4[r6]
            double r6 = (double) r13
            r36 = r0
            r13 = 1
            r0 = r4[r13]
            r18 = r1
            double r0 = (double) r0
            r20 = 2
            r13 = r4[r20]
            r38 = r8
            double r8 = (double) r13
            r23 = r2
            r13 = 3
            r2 = r4[r13]
            r49 = r8
            double r8 = (double) r2
            r2 = r4[r16]
            r51 = r8
            double r8 = (double) r2
            double r4 = (double) r5
            r24 = 0
            r55 = r10
            r56 = r18
            r53 = r35
            r54 = r42
            r2 = 0
            r10 = r63
            r65 = r11
            r11 = r3
            r57 = r12
            r58 = r23
            r35 = r25
            r3 = 1
            r41 = 3
            r12 = r6
            r7 = r15
            r6 = 0
            r14 = r0
            r16 = r49
            r18 = r51
            r20 = r8
            r22 = r4
            r25 = r34
            r10.k(r11, r12, r14, r16, r18, r20, r22, r24, r25)
            float r0 = r38 + r27
            float r1 = r65.m()
            float r0 = r0 + r1
            float r1 = r62.l1()
            float r0 = r0 - r1
            r1 = r62
            r1.t1(r0, r2)
        L_0x06a8:
            r11 = r36
            r16 = r38
            r17 = r40
            goto L_0x06ee
        L_0x06af:
            r36 = r0
            r56 = r1
            r58 = r2
            r38 = r8
            r1 = r9
            r55 = r10
            r65 = r11
            r57 = r12
            r7 = r15
            r53 = r35
            r54 = r42
            r2 = 0
            r3 = 1
            r6 = 0
            r41 = 3
            r35 = r25
            goto L_0x06a8
        L_0x06cb:
            r39 = r0
            r7 = r1
            r55 = r2
            r45 = r3
            r57 = r4
            r47 = r5
            r48 = r6
            r1 = r9
            r56 = r10
            r65 = r11
            r43 = r18
            r54 = r23
            r53 = r35
            r58 = r36
            r2 = 0
            r3 = 1
            r6 = 0
            r41 = 3
            r35 = r25
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x06ee:
            float r16 = r16 + r37
            int r0 = r39 + 1
            r4 = r16
            goto L_0x071a
        L_0x06f5:
            r39 = r0
            r7 = r1
            r55 = r2
            r45 = r3
            r57 = r4
            r47 = r5
            r48 = r6
            r1 = r9
            r56 = r10
            r65 = r11
            r43 = r18
            r54 = r23
            r53 = r35
            r58 = r36
            r2 = 0
            r3 = 1
            r6 = 0
            r41 = 3
            r35 = r25
            r4 = r16
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x071a:
            boolean r5 = r65.y()
            if (r5 != 0) goto L_0x073c
            com.itextpdf.text.pdf.PdfFont r5 = r65.d()
            r8 = r43
            int r5 = r5.compareTo(r8)
            if (r5 == 0) goto L_0x073e
            com.itextpdf.text.pdf.PdfFont r5 = r65.d()
            com.itextpdf.text.pdf.BaseFont r8 = r5.c()
            float r9 = r5.g()
            r1.s2(r8, r9)
            goto L_0x073f
        L_0x073c:
            r8 = r43
        L_0x073e:
            r5 = r8
        L_0x073f:
            java.lang.String r8 = "TEXTRENDERMODE"
            r9 = r65
            java.lang.Object r8 = r9.e(r8)
            java.lang.Object[] r8 = (java.lang.Object[]) r8
            java.lang.String r10 = "SUBSUPSCRIPT"
            java.lang.Object r10 = r9.e(r10)
            java.lang.Float r10 = (java.lang.Float) r10
            r12 = 0
            if (r8 == 0) goto L_0x078e
            r13 = r8[r6]
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            r15 = r13 & 3
            if (r15 == 0) goto L_0x0763
            r1.h3(r15)
        L_0x0763:
            r13 = 2
            if (r15 == r3) goto L_0x076f
            if (r15 != r13) goto L_0x0769
            goto L_0x076f
        L_0x0769:
            r8 = r12
            r12 = 1065353216(0x3f800000, float:1.0)
            r14 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0794
        L_0x076f:
            r12 = r8[r3]
            java.lang.Float r12 = (java.lang.Float) r12
            float r12 = r12.floatValue()
            r14 = 1065353216(0x3f800000, float:1.0)
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 == 0) goto L_0x0780
            r1.J2(r12)
        L_0x0780:
            r8 = r8[r13]
            com.itextpdf.text.BaseColor r8 = (com.itextpdf.text.BaseColor) r8
            if (r8 != 0) goto L_0x0788
            r8 = r53
        L_0x0788:
            if (r8 == 0) goto L_0x0794
            r1.l2(r8)
            goto L_0x0794
        L_0x078e:
            r14 = 1065353216(0x3f800000, float:1.0)
            r8 = r12
            r12 = 1065353216(0x3f800000, float:1.0)
            r15 = 0
        L_0x0794:
            if (r10 == 0) goto L_0x079d
            float r10 = r10.floatValue()
            r13 = r53
            goto L_0x07a0
        L_0x079d:
            r13 = r53
            r10 = 0
        L_0x07a0:
            if (r13 == 0) goto L_0x07a5
            r1.h2(r13)
        L_0x07a5:
            int r16 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r16 == 0) goto L_0x07ac
            r1.j3(r10)
        L_0x07ac:
            boolean r10 = r9.y()
            if (r10 == 0) goto L_0x07c0
            r65 = r0
            r18 = r5
            r10 = r47
            r2 = r48
            r23 = r54
            r33 = 1
            goto L_0x08af
        L_0x07c0:
            boolean r10 = r9.x()
            r18 = 1148846080(0x447a0000, float:1000.0)
            if (r10 == 0) goto L_0x07e1
            com.itextpdf.text.pdf.PdfTextArray r10 = new com.itextpdf.text.pdf.PdfTextArray
            r10.<init>()
            r3 = r54
            float r14 = -r3
            float r14 = r14 * r18
            com.itextpdf.text.pdf.PdfFont r2 = r9.f26132c
            float r2 = r2.g()
            float r14 = r14 / r2
            float r14 = r14 / r11
            r10.a(r14)
            r1.l3(r10)
            goto L_0x0804
        L_0x07e1:
            r3 = r54
            boolean r2 = r9.D()
            if (r2 == 0) goto L_0x0810
            int r2 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0810
            com.itextpdf.text.pdf.PdfTextArray r2 = new com.itextpdf.text.pdf.PdfTextArray
            r2.<init>()
            float r10 = r17 - r4
            float r10 = r10 * r18
            com.itextpdf.text.pdf.PdfFont r14 = r9.f26132c
            float r14 = r14.g()
            float r10 = r10 / r14
            float r10 = r10 / r11
            r2.a(r10)
            r1.l3(r2)
        L_0x0804:
            r65 = r0
            r23 = r3
            r18 = r5
            r10 = r47
            r2 = r48
            goto L_0x08af
        L_0x0810:
            if (r26 == 0) goto L_0x0887
            if (r35 <= 0) goto L_0x0887
            boolean r2 = r9.B()
            if (r2 == 0) goto L_0x0887
            int r2 = (r11 > r32 ? 1 : (r11 == r32 ? 0 : -1))
            r10 = r47
            if (r2 == 0) goto L_0x0835
            float r2 = r10 / r11
            r1.k3(r2)
            r2 = r48
            float r14 = r2 / r11
            float r20 = r62.S0()
            float r14 = r14 + r20
            r1.g2(r14)
            r32 = r11
            goto L_0x0837
        L_0x0835:
            r2 = r48
        L_0x0837:
            java.lang.String r14 = r9.toString()
            r6 = 32
            r65 = r0
            int r0 = r14.indexOf(r6)
            if (r0 >= 0) goto L_0x084d
            r1.m3(r14)
            r23 = r3
            r18 = r5
            goto L_0x08af
        L_0x084d:
            float r6 = -r10
            float r6 = r6 * r18
            r23 = r3
            com.itextpdf.text.pdf.PdfFont r3 = r9.f26132c
            float r3 = r3.g()
            float r6 = r6 / r3
            float r6 = r6 / r11
            com.itextpdf.text.pdf.PdfTextArray r3 = new com.itextpdf.text.pdf.PdfTextArray
            r18 = r5
            r11 = 0
            java.lang.String r5 = r14.substring(r11, r0)
            r3.<init>(r5)
        L_0x0866:
            int r5 = r0 + 1
            r11 = 32
            int r5 = r14.indexOf(r11, r5)
            r3.a(r6)
            if (r5 < 0) goto L_0x087c
            java.lang.String r0 = r14.substring(r0, r5)
            r3.c(r0)
            r0 = r5
            goto L_0x0866
        L_0x087c:
            java.lang.String r0 = r14.substring(r0)
            r3.c(r0)
            r1.l3(r3)
            goto L_0x08af
        L_0x0887:
            r65 = r0
            r23 = r3
            r18 = r5
            r10 = r47
            r2 = r48
            if (r26 == 0) goto L_0x08a8
            int r0 = (r11 > r32 ? 1 : (r11 == r32 ? 0 : -1))
            if (r0 == 0) goto L_0x08a8
            float r5 = r10 / r11
            r1.k3(r5)
            float r6 = r2 / r11
            float r0 = r62.S0()
            float r6 = r6 + r0
            r1.g2(r6)
            r32 = r11
        L_0x08a8:
            java.lang.String r0 = r9.toString()
            r1.m3(r0)
        L_0x08af:
            if (r16 == 0) goto L_0x08b5
            r0 = 0
            r1.j3(r0)
        L_0x08b5:
            if (r13 == 0) goto L_0x08ba
            r62.R1()
        L_0x08ba:
            if (r15 == 0) goto L_0x08c0
            r0 = 0
            r1.h3(r0)
        L_0x08c0:
            if (r8 == 0) goto L_0x08c5
            r62.S1()
        L_0x08c5:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r3 == 0) goto L_0x08ce
            r1.J2(r0)
        L_0x08ce:
            boolean r3 = r9.v(r7)
            if (r3 != 0) goto L_0x08dc
            r3 = r57
            boolean r3 = r9.v(r3)
            if (r3 == 0) goto L_0x08df
        L_0x08dc:
            r3 = r55
            goto L_0x08e2
        L_0x08df:
            r3 = r55
            goto L_0x08e7
        L_0x08e2:
            r1.e3(r4, r3)
            r33 = 1
        L_0x08e7:
            if (r26 != 0) goto L_0x08ff
            r5 = r58
            boolean r5 = r9.v(r5)
            if (r5 == 0) goto L_0x08f4
            r1.g2(r2)
        L_0x08f4:
            r5 = r56
            boolean r5 = r9.v(r5)
            if (r5 == 0) goto L_0x08ff
            r1.k3(r10)
        L_0x08ff:
            r5 = r60
            com.itextpdf.text.pdf.PdfWriter r6 = r5.o3
            boolean r6 = V0(r6)
            if (r6 == 0) goto L_0x0910
            com.itextpdf.text.pdf.interfaces.IAccessibleElement r6 = r9.o
            if (r6 == 0) goto L_0x0910
            r1.c0(r6)
        L_0x0910:
            r8 = r61
            r14 = r63
            r0 = r65
            r9 = r1
            r6 = r2
            r2 = r3
            r16 = r4
            r7 = r5
            r5 = r10
            r1 = r18
            r4 = r23
            r18 = r34
            r13 = r35
            r3 = r45
            r10 = 0
            r11 = 1065353216(0x3f800000, float:1.0)
            r12 = 1
            r15 = 0
            goto L_0x0109
        L_0x092e:
            r8 = r1
            r5 = r7
            r1 = r9
            r0 = 0
            if (r26 == 0) goto L_0x0942
            r1.k3(r0)
            r1.g2(r0)
            boolean r2 = r61.q()
            if (r2 == 0) goto L_0x0942
            r10 = 0
            goto L_0x0944
        L_0x0942:
            r10 = r27
        L_0x0944:
            if (r33 == 0) goto L_0x094f
            float r2 = r62.l1()
            float r2 = r30 - r2
            r1.t1(r2, r0)
        L_0x094f:
            r0 = 0
            r64[r0] = r8
            java.lang.Float r0 = new java.lang.Float
            r0.<init>(r10)
            r1 = 1
            r64[r1] = r0
            return r28
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfDocument.B1(com.itextpdf.text.pdf.PdfLine, com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.pdf.PdfContentByte, java.lang.Object[], float):float");
    }

    /* access modifiers changed from: package-private */
    public PdfAction C0(String str) {
        Destination destination = this.W3.get(str);
        if (destination == null) {
            destination = new Destination();
        }
        PdfAction pdfAction = destination.f26183a;
        if (pdfAction != null) {
            return pdfAction;
        }
        if (destination.f26184b == null) {
            destination.f26184b = this.o3.D1();
        }
        PdfAction pdfAction2 = new PdfAction(destination.f26184b);
        destination.f26183a = pdfAction2;
        this.W3.put(str, destination);
        return pdfAction2;
    }

    /* access modifiers changed from: package-private */
    public void C1() throws IOException {
        if (this.S3.m1().size() != 0) {
            Z0(this.S3);
            PdfWriter pdfWriter = this.o3;
            PdfOutline pdfOutline = this.S3;
            pdfWriter.y0(pdfOutline, pdfOutline.s1());
        }
    }

    public int D0(Object obj) {
        int[] iArr = this.v3.get(obj);
        if (iArr == null) {
            iArr = new int[]{this.v3.size(), 0};
            this.v3.put(obj, iArr);
        }
        int i2 = iArr[1];
        iArr[1] = i2 + 1;
        return i2;
    }

    public PdfPageLabels E0() {
        return this.V3;
    }

    /* access modifiers changed from: package-private */
    public PageResources F0() {
        return this.l4;
    }

    public PdfOutline G0() {
        return this.S3;
    }

    /* access modifiers changed from: protected */
    public PdfStructureElement H0(AccessibleElementId accessibleElementId) {
        return I0(accessibleElementId, true);
    }

    /* access modifiers changed from: protected */
    public PdfStructureElement I0(AccessibleElementId accessibleElementId, boolean z) {
        TempFileCache.ObjectPosition objectPosition;
        PdfStructureElement pdfStructureElement = this.p3.get(accessibleElementId);
        if (this.t3 && pdfStructureElement == null && (objectPosition = this.r3.get(accessibleElementId)) != null) {
            try {
                pdfStructureElement = (PdfStructureElement) this.q3.b(objectPosition);
                pdfStructureElement.E1(this.o3.L1());
                pdfStructureElement.B1(I0(this.s3.get(pdfStructureElement.i1()), z));
                if (z) {
                    this.r3.remove(accessibleElementId);
                    this.p3.put(accessibleElementId, pdfStructureElement);
                }
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            } catch (ClassNotFoundException e3) {
                throw new ExceptionConverter(e3);
            }
        }
        return pdfStructureElement;
    }

    public Set<AccessibleElementId> J0() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.r3.keySet());
        hashSet.addAll(this.p3.keySet());
        return hashSet;
    }

    public int K0(Object obj) {
        int[] iArr = this.v3.get(obj);
        if (iArr == null) {
            iArr = new int[]{this.v3.size(), 0};
            this.v3.put(obj, iArr);
        }
        return iArr[0];
    }

    public int[] L0(Object obj) {
        int[] iArr = this.v3.get(obj);
        if (iArr == null) {
            iArr = new int[]{this.v3.size(), 0};
            this.v3.put(obj, iArr);
        }
        int i2 = iArr[1];
        iArr[1] = i2 + 1;
        return new int[]{iArr[0], i2};
    }

    public TabSettings M0() {
        return this.E3;
    }

    public float N0(boolean z) {
        if (z) {
            p0();
        }
        return (R() - this.B3) - this.Q3.f26194h;
    }

    /* access modifiers changed from: package-private */
    public float O0() {
        return w(this.Q3.f26195i);
    }

    /* access modifiers changed from: protected */
    public float P0() {
        Indentation indentation = this.Q3;
        return H(indentation.f26187a + indentation.f26189c + indentation.f26190d + indentation.f26188b);
    }

    /* access modifiers changed from: protected */
    public float Q0() {
        Indentation indentation = this.Q3;
        return M(indentation.f26191e + indentation.f26192f + indentation.f26193g);
    }

    /* access modifiers changed from: protected */
    public float R0() {
        return S(this.Q3.f26194h);
    }

    /* access modifiers changed from: protected */
    public void S0() throws DocumentException {
        this.g3++;
        this.l4 = new PageResources();
        if (V0(this.o3)) {
            this.y3 = this.o3.h1().U0();
            this.o3.g1().e3 = this.y3;
        } else {
            this.y3 = new PdfContentByte(this.o3);
        }
        m1();
        this.n4 = -1.0f;
        Indentation indentation = this.Q3;
        indentation.f26193g = 0.0f;
        indentation.f26190d = 0.0f;
        indentation.f26195i = 0.0f;
        indentation.f26194h = 0.0f;
        this.B3 = 0.0f;
        this.h4 = new HashMap<>(this.i4);
        if (!(this.Z.k() == null && !this.Z.c0() && this.Z.p() == null)) {
            b(this.Z);
        }
        float f2 = this.z3;
        int i2 = this.A3;
        this.j4 = true;
        try {
            Image image = this.o4;
            if (image != null) {
                V(image);
                this.o4 = null;
            }
            this.z3 = f2;
            this.A3 = i2;
            m0();
            PdfPageEvent y1 = this.o3.y1();
            if (y1 != null) {
                if (this.M3) {
                    y1.c(this.o3, this);
                }
                y1.k(this.o3, this);
            }
            this.M3 = false;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean T0() {
        if (V0(this.o3)) {
            PdfWriter pdfWriter = this.o3;
            if (pdfWriter != null) {
                return pdfWriter.g1().u3(false) == 0 && this.o3.h1().u3(false) == 0 && this.x3.u3(false) - this.H3 == 0 && (this.j4 || this.o3.G());
            }
            return true;
        }
        PdfWriter pdfWriter2 = this.o3;
        if (pdfWriter2 != null) {
            return pdfWriter2.g1().t3() == 0 && this.o3.h1().t3() == 0 && (this.j4 || this.o3.G());
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean U0() {
        return this.m4;
    }

    /* access modifiers changed from: protected */
    public void V(Image image) throws PdfException, DocumentException {
        Image image2 = image;
        if (image.x1()) {
            this.y3.h(image2);
            this.j4 = false;
            return;
        }
        if (this.B3 != 0.0f && (R0() - this.B3) - image.o1() < O0()) {
            if (this.m4 || this.o4 != null) {
                f();
                if (this.B3 != 0.0f && (R0() - this.B3) - image.o1() < O0()) {
                    this.o4 = image2;
                    return;
                }
            } else {
                this.o4 = image2;
                return;
            }
        }
        this.j4 = false;
        if (image2 == this.o4) {
            this.o4 = null;
        }
        boolean z = (image.G0() & 4) == 4 && (image.G0() & 1) != 1;
        boolean z2 = (image.G0() & 8) == 8;
        float f2 = this.z3;
        float f3 = f2 / 2.0f;
        if (z) {
            f3 += f2;
        }
        float f5 = f3;
        float R0 = ((R0() - this.B3) - image.o1()) - f5;
        float[] L1 = image.L1();
        float P0 = P0() - L1[4];
        if ((image.G0() & 2) == 2) {
            P0 = (Q0() - image.p1()) - L1[4];
        }
        if ((image.G0() & 1) == 1) {
            P0 = (P0() + (((Q0() - P0()) - image.p1()) / 2.0f)) - L1[4];
        }
        if (image.w1()) {
            P0 = image.D0();
        }
        if (z) {
            float f6 = this.n4;
            if (f6 < 0.0f || f6 < this.B3 + image.o1() + f5) {
                this.n4 = this.B3 + image.o1() + f5;
            }
            if ((image.G0() & 2) == 2) {
                this.Q3.f26193g += image.p1() + image.m();
            } else {
                this.Q3.f26190d += image.p1() + image.q();
            }
        } else if ((image.G0() & 2) == 2) {
            P0 -= image.q();
        } else {
            P0 += (image.G0() & 1) == 1 ? image.m() - image.q() : image.m();
        }
        this.y3.l(image, L1[0], L1[1], L1[2], L1[3], P0, R0 - L1[5]);
        if (!z && !z2) {
            this.B3 += image.o1() + f5;
            s0();
            this.x3.t1(0.0f, -(image.o1() + f5));
            Y0();
        }
    }

    /* access modifiers changed from: package-private */
    public void W(PdfName pdfName, PdfAction pdfAction) {
        if (this.c4 == null) {
            this.c4 = new PdfDictionary();
        }
        if (pdfAction == null) {
            this.c4.a1(pdfName);
        } else {
            this.c4.V0(pdfName, pdfAction);
        }
        if (this.c4.size() == 0) {
            this.c4 = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean W0(String str, PdfDestination pdfDestination) {
        Destination destination = this.W3.get(str);
        if (destination == null) {
            destination = new Destination();
        }
        if (destination.f26185c != null) {
            return false;
        }
        destination.f26185c = pdfDestination;
        this.W3.put(str, destination);
        if (pdfDestination.Z0()) {
            return true;
        }
        pdfDestination.X0(this.o3.d1());
        return true;
    }

    /* access modifiers changed from: package-private */
    public void X(PdfAnnotation pdfAnnotation) {
        this.j4 = false;
        this.e4.a(pdfAnnotation);
    }

    /* access modifiers changed from: package-private */
    public void X0(String str, float f2, float f3, float f5, float f6) {
        this.e4.d(this.o3.K0(f2, f3, f5, f6, C0(str), (PdfName) null));
    }

    /* access modifiers changed from: package-private */
    public void Y(PdfFormField pdfFormField) {
        this.e4.b(pdfFormField);
    }

    /* access modifiers changed from: protected */
    public void Y0() throws DocumentException {
        this.P3 = -1;
        m0();
        ArrayList<PdfLine> arrayList = this.O3;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.O3.add(this.N3);
            this.B3 += this.N3.o();
        }
        this.N3 = new PdfLine(P0(), Q0(), this.A3, this.z3);
    }

    /* access modifiers changed from: package-private */
    public void Z0(PdfOutline pdfOutline) throws IOException {
        pdfOutline.J1(this.o3.D1());
        if (pdfOutline.B1() != null) {
            pdfOutline.V0(PdfName.Dc, pdfOutline.B1().s1());
        }
        ArrayList<PdfOutline> m1 = pdfOutline.m1();
        int size = m1.size();
        for (int i2 = 0; i2 < size; i2++) {
            Z0(m1.get(i2));
        }
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 > 0) {
                m1.get(i3).V0(PdfName.gd, m1.get(i3 - 1).s1());
            }
            if (i3 < size - 1) {
                m1.get(i3).V0(PdfName.Ab, m1.get(i3 + 1).s1());
            }
        }
        if (size > 0) {
            pdfOutline.V0(PdfName.U7, m1.get(0).s1());
            pdfOutline.V0(PdfName.oa, m1.get(size - 1).s1());
        }
        for (int i5 = 0; i5 < size; i5++) {
            PdfOutline pdfOutline2 = m1.get(i5);
            this.o3.y0(pdfOutline2, pdfOutline2.s1());
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(String str, PdfFileSpecification pdfFileSpecification) throws IOException {
        if (str == null) {
            PdfString pdfString = (PdfString) pdfFileSpecification.d0(PdfName.u6);
            str = pdfString == null ? "" : PdfEncodings.d(pdfString.k(), (String) null);
        }
        pdfFileSpecification.i1(str, true);
        if (str.length() == 0) {
            str = "Unnamed";
        }
        String d2 = PdfEncodings.d(new PdfString(str, PdfObject.h3).k(), (String) null);
        int i2 = 0;
        while (this.Z3.containsKey(d2)) {
            i2++;
            d2 = PdfEncodings.d(new PdfString(str + StringUtils.SPACE + i2, PdfObject.h3).k(), (String) null);
        }
        this.Z3.put(d2, pdfFileSpecification.v1());
    }

    /* access modifiers changed from: protected */
    public void a1() {
        this.z3 = this.F3.pop().floatValue();
        if (this.F3.size() > 0) {
            this.z3 = this.F3.peek().floatValue();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: com.itextpdf.text.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: com.itextpdf.text.ListItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v77, resolved type: com.itextpdf.text.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v78, resolved type: com.itextpdf.text.List} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bc, code lost:
        a1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x015f, code lost:
        r1.c0(r0);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(com.itextpdf.text.Element r13) throws com.itextpdf.text.DocumentException {
        /*
            r12 = this;
            com.itextpdf.text.pdf.PdfWriter r0 = r12.o3
            r1 = 0
            if (r0 == 0) goto L_0x000c
            boolean r0 = r0.G()
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            int r0 = r13.type()     // Catch:{ Exception -> 0x0018 }
            r2 = 37
            if (r0 == r2) goto L_0x001b
            r12.r0()     // Catch:{ Exception -> 0x0018 }
            goto L_0x001b
        L_0x0018:
            r13 = move-exception
            goto L_0x05f8
        L_0x001b:
            int r0 = r13.type()     // Catch:{ Exception -> 0x0018 }
            r2 = 23
            r3 = 1
            if (r0 == r2) goto L_0x05d5
            r2 = 50
            if (r0 == r2) goto L_0x05be
            r2 = 55
            r4 = 0
            if (r0 == r2) goto L_0x0590
            r2 = 666(0x29a, float:9.33E-43)
            if (r0 == r2) goto L_0x0585
            r2 = 29
            if (r0 == r2) goto L_0x0528
            r2 = 30
            if (r0 == r2) goto L_0x051e
            switch(r0) {
                case 0: goto L_0x0509;
                case 1: goto L_0x04fb;
                case 2: goto L_0x04ed;
                case 3: goto L_0x04df;
                case 4: goto L_0x04d1;
                case 5: goto L_0x04ca;
                case 6: goto L_0x04c3;
                case 7: goto L_0x04b5;
                case 8: goto L_0x04a9;
                default: goto L_0x003c;
            }     // Catch:{ Exception -> 0x0018 }
        L_0x003c:
            switch(r0) {
                case 10: goto L_0x046f;
                case 11: goto L_0x0448;
                case 12: goto L_0x02e0;
                case 13: goto L_0x01c0;
                case 14: goto L_0x0164;
                case 15: goto L_0x00c1;
                case 16: goto L_0x01c0;
                case 17: goto L_0x009d;
                default: goto L_0x003f;
            }     // Catch:{ Exception -> 0x0018 }
        L_0x003f:
            switch(r0) {
                case 32: goto L_0x005d;
                case 33: goto L_0x005d;
                case 34: goto L_0x005d;
                case 35: goto L_0x005d;
                case 36: goto L_0x005d;
                case 37: goto L_0x004d;
                case 38: goto L_0x0043;
                default: goto L_0x0042;
            }     // Catch:{ Exception -> 0x0018 }
        L_0x0042:
            goto L_0x004c
        L_0x0043:
            com.itextpdf.text.pdf.PdfBody r13 = (com.itextpdf.text.pdf.PdfBody) r13     // Catch:{ Exception -> 0x0018 }
            r12.G3 = r13     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfContentByte r0 = r12.y3     // Catch:{ Exception -> 0x0018 }
            r0.I1(r13)     // Catch:{ Exception -> 0x0018 }
        L_0x004c:
            return r1
        L_0x004d:
            r12.p0()     // Catch:{ Exception -> 0x0018 }
            r12.s0()     // Catch:{ Exception -> 0x0018 }
            r0 = r13
            com.itextpdf.text.pdf.PdfDiv r0 = (com.itextpdf.text.pdf.PdfDiv) r0     // Catch:{ Exception -> 0x0018 }
            r12.Z(r0)     // Catch:{ Exception -> 0x0018 }
        L_0x0059:
            r12.j4 = r1     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x005d:
            com.itextpdf.text.pdf.PdfWriter r0 = r12.o3     // Catch:{ Exception -> 0x0018 }
            boolean r0 = V0(r0)     // Catch:{ Exception -> 0x0018 }
            if (r0 == 0) goto L_0x0079
            r0 = r13
            com.itextpdf.text.Image r0 = (com.itextpdf.text.Image) r0     // Catch:{ Exception -> 0x0018 }
            boolean r0 = r0.B1()     // Catch:{ Exception -> 0x0018 }
            if (r0 != 0) goto L_0x0079
            r12.s0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfContentByte r0 = r12.x3     // Catch:{ Exception -> 0x0018 }
            r1 = r13
            com.itextpdf.text.Image r1 = (com.itextpdf.text.Image) r1     // Catch:{ Exception -> 0x0018 }
            r0.B1(r1)     // Catch:{ Exception -> 0x0018 }
        L_0x0079:
            r0 = r13
            com.itextpdf.text.Image r0 = (com.itextpdf.text.Image) r0     // Catch:{ Exception -> 0x0018 }
            r12.V(r0)     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfWriter r0 = r12.o3     // Catch:{ Exception -> 0x0018 }
            boolean r0 = V0(r0)     // Catch:{ Exception -> 0x0018 }
            if (r0 == 0) goto L_0x05f1
            r0 = r13
            com.itextpdf.text.Image r0 = (com.itextpdf.text.Image) r0     // Catch:{ Exception -> 0x0018 }
            boolean r0 = r0.B1()     // Catch:{ Exception -> 0x0018 }
            if (r0 != 0) goto L_0x05f1
            r12.s0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfContentByte r0 = r12.x3     // Catch:{ Exception -> 0x0018 }
            r1 = r13
            com.itextpdf.text.Image r1 = (com.itextpdf.text.Image) r1     // Catch:{ Exception -> 0x0018 }
            r0.c0(r1)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x009d:
            r0 = r13
            com.itextpdf.text.Anchor r0 = (com.itextpdf.text.Anchor) r0     // Catch:{ Exception -> 0x0018 }
            java.lang.String r1 = r0.y1()     // Catch:{ Exception -> 0x0018 }
            float r0 = r0.z0()     // Catch:{ Exception -> 0x0018 }
            r12.z3 = r0     // Catch:{ Exception -> 0x0018 }
            r12.b1()     // Catch:{ Exception -> 0x0018 }
            if (r1 == 0) goto L_0x00b6
            com.itextpdf.text.pdf.PdfAction r0 = new com.itextpdf.text.pdf.PdfAction     // Catch:{ Exception -> 0x0018 }
            r0.<init>((java.lang.String) r1)     // Catch:{ Exception -> 0x0018 }
            r12.D3 = r0     // Catch:{ Exception -> 0x0018 }
        L_0x00b6:
            r13.t(r12)     // Catch:{ Exception -> 0x0018 }
            r0 = 0
            r12.D3 = r0     // Catch:{ Exception -> 0x0018 }
        L_0x00bc:
            r12.a1()     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x00c1:
            r0 = r13
            com.itextpdf.text.ListItem r0 = (com.itextpdf.text.ListItem) r0     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfWriter r1 = r12.o3     // Catch:{ Exception -> 0x0018 }
            boolean r1 = V0(r1)     // Catch:{ Exception -> 0x0018 }
            if (r1 == 0) goto L_0x00d4
            r12.s0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfContentByte r1 = r12.x3     // Catch:{ Exception -> 0x0018 }
            r1.B1(r0)     // Catch:{ Exception -> 0x0018 }
        L_0x00d4:
            float r1 = r0.E()     // Catch:{ Exception -> 0x0018 }
            float r2 = r12.z3     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.Font r4 = r0.q0()     // Catch:{ Exception -> 0x0018 }
            r12.f0(r1, r2, r4)     // Catch:{ Exception -> 0x0018 }
            int r1 = r0.y1()     // Catch:{ Exception -> 0x0018 }
            r12.A3 = r1     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r1 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r2 = r1.f26189c     // Catch:{ Exception -> 0x0018 }
            float r4 = r0.m()     // Catch:{ Exception -> 0x0018 }
            float r2 = r2 + r4
            r1.f26189c = r2     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r1 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r2 = r1.f26191e     // Catch:{ Exception -> 0x0018 }
            float r4 = r0.q()     // Catch:{ Exception -> 0x0018 }
            float r2 = r2 + r4
            r1.f26191e = r2     // Catch:{ Exception -> 0x0018 }
            float r1 = r0.G0()     // Catch:{ Exception -> 0x0018 }
            r12.z3 = r1     // Catch:{ Exception -> 0x0018 }
            r12.b1()     // Catch:{ Exception -> 0x0018 }
            r12.m0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfLine r1 = r12.N3     // Catch:{ Exception -> 0x0018 }
            r1.z(r0)     // Catch:{ Exception -> 0x0018 }
            r13.t(r12)     // Catch:{ Exception -> 0x0018 }
            float r1 = r0.K()     // Catch:{ Exception -> 0x0018 }
            float r2 = r0.G0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.Font r4 = r0.q0()     // Catch:{ Exception -> 0x0018 }
            r12.g0(r1, r2, r4, r3)     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfLine r1 = r12.N3     // Catch:{ Exception -> 0x0018 }
            boolean r1 = r1.n()     // Catch:{ Exception -> 0x0018 }
            if (r1 == 0) goto L_0x012d
            com.itextpdf.text.pdf.PdfLine r1 = r12.N3     // Catch:{ Exception -> 0x0018 }
            r1.x()     // Catch:{ Exception -> 0x0018 }
        L_0x012d:
            r12.m0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r1 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r2 = r1.f26189c     // Catch:{ Exception -> 0x0018 }
            float r4 = r0.m()     // Catch:{ Exception -> 0x0018 }
            float r2 = r2 - r4
            r1.f26189c = r2     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r1 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r2 = r1.f26191e     // Catch:{ Exception -> 0x0018 }
            float r4 = r0.q()     // Catch:{ Exception -> 0x0018 }
            float r2 = r2 - r4
            r1.f26191e = r2     // Catch:{ Exception -> 0x0018 }
            r12.a1()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfWriter r1 = r12.o3     // Catch:{ Exception -> 0x0018 }
            boolean r1 = V0(r1)     // Catch:{ Exception -> 0x0018 }
            if (r1 == 0) goto L_0x05f1
            r12.s0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfContentByte r1 = r12.x3     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.ListBody r2 = r0.g2()     // Catch:{ Exception -> 0x0018 }
            r1.c0(r2)     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfContentByte r1 = r12.x3     // Catch:{ Exception -> 0x0018 }
        L_0x015f:
            r1.c0(r0)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x0164:
            r0 = r13
            com.itextpdf.text.List r0 = (com.itextpdf.text.List) r0     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfWriter r1 = r12.o3     // Catch:{ Exception -> 0x0018 }
            boolean r1 = V0(r1)     // Catch:{ Exception -> 0x0018 }
            if (r1 == 0) goto L_0x0177
            r12.s0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfContentByte r1 = r12.x3     // Catch:{ Exception -> 0x0018 }
            r1.B1(r0)     // Catch:{ Exception -> 0x0018 }
        L_0x0177:
            boolean r1 = r0.u()     // Catch:{ Exception -> 0x0018 }
            if (r1 == 0) goto L_0x0180
            r0.E()     // Catch:{ Exception -> 0x0018 }
        L_0x0180:
            com.itextpdf.text.pdf.PdfDocument$Indentation r1 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r2 = r1.f26189c     // Catch:{ Exception -> 0x0018 }
            float r4 = r0.m()     // Catch:{ Exception -> 0x0018 }
            float r2 = r2 + r4
            r1.f26189c = r2     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r1 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r2 = r1.f26191e     // Catch:{ Exception -> 0x0018 }
            float r4 = r0.q()     // Catch:{ Exception -> 0x0018 }
            float r2 = r2 + r4
            r1.f26191e = r2     // Catch:{ Exception -> 0x0018 }
            r13.t(r12)     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r1 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r2 = r1.f26189c     // Catch:{ Exception -> 0x0018 }
            float r4 = r0.m()     // Catch:{ Exception -> 0x0018 }
            float r2 = r2 - r4
            r1.f26189c = r2     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r1 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r2 = r1.f26191e     // Catch:{ Exception -> 0x0018 }
            float r4 = r0.q()     // Catch:{ Exception -> 0x0018 }
            float r2 = r2 - r4
            r1.f26191e = r2     // Catch:{ Exception -> 0x0018 }
            r12.m0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfWriter r1 = r12.o3     // Catch:{ Exception -> 0x0018 }
            boolean r1 = V0(r1)     // Catch:{ Exception -> 0x0018 }
            if (r1 == 0) goto L_0x05f1
            r12.s0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfContentByte r1 = r12.x3     // Catch:{ Exception -> 0x0018 }
            goto L_0x015f
        L_0x01c0:
            r0 = r13
            com.itextpdf.text.Section r0 = (com.itextpdf.text.Section) r0     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfWriter r2 = r12.o3     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfPageEvent r2 = r2.y1()     // Catch:{ Exception -> 0x0018 }
            boolean r4 = r0.H0()     // Catch:{ Exception -> 0x0018 }
            if (r4 == 0) goto L_0x01d7
            com.itextpdf.text.Paragraph r4 = r0.z0()     // Catch:{ Exception -> 0x0018 }
            if (r4 == 0) goto L_0x01d7
            r10 = 1
            goto L_0x01d8
        L_0x01d7:
            r10 = 0
        L_0x01d8:
            boolean r4 = r0.O0()     // Catch:{ Exception -> 0x0018 }
            if (r4 == 0) goto L_0x01e1
            r12.f()     // Catch:{ Exception -> 0x0018 }
        L_0x01e1:
            if (r10 == 0) goto L_0x022c
            float r4 = r12.R0()     // Catch:{ Exception -> 0x0018 }
            float r5 = r12.B3     // Catch:{ Exception -> 0x0018 }
            float r4 = r4 - r5
            com.itextpdf.text.Rectangle r5 = r12.Z     // Catch:{ Exception -> 0x0018 }
            int r5 = r5.S()     // Catch:{ Exception -> 0x0018 }
            r6 = 90
            if (r5 == r6) goto L_0x01f8
            r6 = 180(0xb4, float:2.52E-43)
            if (r5 != r6) goto L_0x0200
        L_0x01f8:
            com.itextpdf.text.Rectangle r5 = r12.Z     // Catch:{ Exception -> 0x0018 }
            float r5 = r5.N()     // Catch:{ Exception -> 0x0018 }
            float r4 = r5 - r4
        L_0x0200:
            com.itextpdf.text.pdf.PdfDestination r5 = new com.itextpdf.text.pdf.PdfDestination     // Catch:{ Exception -> 0x0018 }
            r6 = 2
            r5.<init>(r6, r4)     // Catch:{ Exception -> 0x0018 }
        L_0x0206:
            com.itextpdf.text.pdf.PdfOutline r4 = r12.T3     // Catch:{ Exception -> 0x0018 }
            int r4 = r4.x1()     // Catch:{ Exception -> 0x0018 }
            int r6 = r0.t0()     // Catch:{ Exception -> 0x0018 }
            if (r4 < r6) goto L_0x021b
            com.itextpdf.text.pdf.PdfOutline r4 = r12.T3     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfOutline r4 = r4.B1()     // Catch:{ Exception -> 0x0018 }
            r12.T3 = r4     // Catch:{ Exception -> 0x0018 }
            goto L_0x0206
        L_0x021b:
            com.itextpdf.text.pdf.PdfOutline r4 = new com.itextpdf.text.pdf.PdfOutline     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfOutline r6 = r12.T3     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.Paragraph r7 = r0.q0()     // Catch:{ Exception -> 0x0018 }
            boolean r8 = r0.F0()     // Catch:{ Exception -> 0x0018 }
            r4.<init>((com.itextpdf.text.pdf.PdfOutline) r6, (com.itextpdf.text.pdf.PdfDestination) r5, (com.itextpdf.text.Paragraph) r7, (boolean) r8)     // Catch:{ Exception -> 0x0018 }
            r12.T3 = r4     // Catch:{ Exception -> 0x0018 }
        L_0x022c:
            r12.m0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r4 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r5 = r4.f26188b     // Catch:{ Exception -> 0x0018 }
            float r6 = r0.m()     // Catch:{ Exception -> 0x0018 }
            float r5 = r5 + r6
            r4.f26188b = r5     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r4 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r5 = r4.f26192f     // Catch:{ Exception -> 0x0018 }
            float r6 = r0.q()     // Catch:{ Exception -> 0x0018 }
            float r5 = r5 + r6
            r4.f26192f = r5     // Catch:{ Exception -> 0x0018 }
            boolean r4 = r0.H0()     // Catch:{ Exception -> 0x0018 }
            r11 = 16
            if (r4 == 0) goto L_0x027d
            if (r2 == 0) goto L_0x027d
            int r4 = r13.type()     // Catch:{ Exception -> 0x0018 }
            if (r4 != r11) goto L_0x0266
            com.itextpdf.text.pdf.PdfWriter r4 = r12.o3     // Catch:{ Exception -> 0x0018 }
            float r5 = r12.R0()     // Catch:{ Exception -> 0x0018 }
            float r6 = r12.B3     // Catch:{ Exception -> 0x0018 }
            float r5 = r5 - r6
            com.itextpdf.text.Paragraph r6 = r0.z0()     // Catch:{ Exception -> 0x0018 }
            r2.b(r4, r12, r5, r6)     // Catch:{ Exception -> 0x0018 }
            goto L_0x027d
        L_0x0266:
            com.itextpdf.text.pdf.PdfWriter r5 = r12.o3     // Catch:{ Exception -> 0x0018 }
            float r4 = r12.R0()     // Catch:{ Exception -> 0x0018 }
            float r6 = r12.B3     // Catch:{ Exception -> 0x0018 }
            float r7 = r4 - r6
            int r8 = r0.t0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.Paragraph r9 = r0.z0()     // Catch:{ Exception -> 0x0018 }
            r4 = r2
            r6 = r12
            r4.f(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0018 }
        L_0x027d:
            if (r10 == 0) goto L_0x028a
            r12.C3 = r3     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.Paragraph r4 = r0.z0()     // Catch:{ Exception -> 0x0018 }
            r12.b(r4)     // Catch:{ Exception -> 0x0018 }
            r12.C3 = r1     // Catch:{ Exception -> 0x0018 }
        L_0x028a:
            com.itextpdf.text.pdf.PdfDocument$Indentation r1 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r4 = r1.f26188b     // Catch:{ Exception -> 0x0018 }
            float r5 = r0.u0()     // Catch:{ Exception -> 0x0018 }
            float r4 = r4 + r5
            r1.f26188b = r4     // Catch:{ Exception -> 0x0018 }
            r13.t(r12)     // Catch:{ Exception -> 0x0018 }
            r12.s0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r1 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r4 = r1.f26188b     // Catch:{ Exception -> 0x0018 }
            float r5 = r0.m()     // Catch:{ Exception -> 0x0018 }
            float r6 = r0.u0()     // Catch:{ Exception -> 0x0018 }
            float r5 = r5 + r6
            float r4 = r4 - r5
            r1.f26188b = r4     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r1 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r4 = r1.f26192f     // Catch:{ Exception -> 0x0018 }
            float r5 = r0.q()     // Catch:{ Exception -> 0x0018 }
            float r4 = r4 - r5
            r1.f26192f = r4     // Catch:{ Exception -> 0x0018 }
            boolean r0 = r0.isComplete()     // Catch:{ Exception -> 0x0018 }
            if (r0 == 0) goto L_0x05f1
            if (r2 == 0) goto L_0x05f1
            int r0 = r13.type()     // Catch:{ Exception -> 0x0018 }
            if (r0 != r11) goto L_0x02d2
            com.itextpdf.text.pdf.PdfWriter r0 = r12.o3     // Catch:{ Exception -> 0x0018 }
            float r1 = r12.R0()     // Catch:{ Exception -> 0x0018 }
            float r4 = r12.B3     // Catch:{ Exception -> 0x0018 }
            float r1 = r1 - r4
            r2.i(r0, r12, r1)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x02d2:
            com.itextpdf.text.pdf.PdfWriter r0 = r12.o3     // Catch:{ Exception -> 0x0018 }
            float r1 = r12.R0()     // Catch:{ Exception -> 0x0018 }
            float r4 = r12.B3     // Catch:{ Exception -> 0x0018 }
            float r1 = r1 - r4
            r2.j(r0, r12, r1)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x02e0:
            com.itextpdf.text.TabSettings r0 = r12.E3     // Catch:{ Exception -> 0x0018 }
            r2 = r13
            com.itextpdf.text.Phrase r2 = (com.itextpdf.text.Phrase) r2     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.TabSettings r2 = r2.F0()     // Catch:{ Exception -> 0x0018 }
            if (r2 == 0) goto L_0x02f4
            r2 = r13
            com.itextpdf.text.Phrase r2 = (com.itextpdf.text.Phrase) r2     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.TabSettings r2 = r2.F0()     // Catch:{ Exception -> 0x0018 }
            r12.E3 = r2     // Catch:{ Exception -> 0x0018 }
        L_0x02f4:
            r2 = r13
            com.itextpdf.text.Paragraph r2 = (com.itextpdf.text.Paragraph) r2     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfWriter r5 = r12.o3     // Catch:{ Exception -> 0x0018 }
            boolean r5 = V0(r5)     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x0307
            r12.s0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfContentByte r5 = r12.x3     // Catch:{ Exception -> 0x0018 }
            r5.B1(r2)     // Catch:{ Exception -> 0x0018 }
        L_0x0307:
            float r5 = r2.E()     // Catch:{ Exception -> 0x0018 }
            float r6 = r12.z3     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.Font r7 = r2.q0()     // Catch:{ Exception -> 0x0018 }
            r12.f0(r5, r6, r7)     // Catch:{ Exception -> 0x0018 }
            int r5 = r2.y1()     // Catch:{ Exception -> 0x0018 }
            r12.A3 = r5     // Catch:{ Exception -> 0x0018 }
            float r5 = r2.G0()     // Catch:{ Exception -> 0x0018 }
            r12.z3 = r5     // Catch:{ Exception -> 0x0018 }
            r12.b1()     // Catch:{ Exception -> 0x0018 }
            r12.m0()     // Catch:{ Exception -> 0x0018 }
            float r5 = r12.B3     // Catch:{ Exception -> 0x0018 }
            float r6 = r12.j0()     // Catch:{ Exception -> 0x0018 }
            float r5 = r5 + r6
            float r6 = r12.R0()     // Catch:{ Exception -> 0x0018 }
            float r7 = r12.O0()     // Catch:{ Exception -> 0x0018 }
            float r6 = r6 - r7
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x033d
            r12.f()     // Catch:{ Exception -> 0x0018 }
        L_0x033d:
            com.itextpdf.text.pdf.PdfDocument$Indentation r5 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r6 = r5.f26187a     // Catch:{ Exception -> 0x0018 }
            float r7 = r2.m()     // Catch:{ Exception -> 0x0018 }
            float r6 = r6 + r7
            r5.f26187a = r6     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r5 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r6 = r5.f26191e     // Catch:{ Exception -> 0x0018 }
            float r7 = r2.q()     // Catch:{ Exception -> 0x0018 }
            float r6 = r6 + r7
            r5.f26191e = r6     // Catch:{ Exception -> 0x0018 }
            r12.m0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfWriter r5 = r12.o3     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfPageEvent r5 = r5.y1()     // Catch:{ Exception -> 0x0018 }
            if (r5 == 0) goto L_0x036e
            boolean r6 = r12.C3     // Catch:{ Exception -> 0x0018 }
            if (r6 != 0) goto L_0x036e
            com.itextpdf.text.pdf.PdfWriter r6 = r12.o3     // Catch:{ Exception -> 0x0018 }
            float r7 = r12.R0()     // Catch:{ Exception -> 0x0018 }
            float r8 = r12.B3     // Catch:{ Exception -> 0x0018 }
            float r7 = r7 - r8
            r5.h(r6, r12, r7)     // Catch:{ Exception -> 0x0018 }
        L_0x036e:
            boolean r6 = r2.C1()     // Catch:{ Exception -> 0x0018 }
            if (r6 == 0) goto L_0x03c9
            r12.m0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfPTable r6 = new com.itextpdf.text.pdf.PdfPTable     // Catch:{ Exception -> 0x0018 }
            r6.<init>((int) r3)     // Catch:{ Exception -> 0x0018 }
            boolean r7 = r2.C1()     // Catch:{ Exception -> 0x0018 }
            r6.N0(r7)     // Catch:{ Exception -> 0x0018 }
            r7 = 1120403456(0x42c80000, float:100.0)
            r6.Z0(r7)     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfPCell r7 = new com.itextpdf.text.pdf.PdfPCell     // Catch:{ Exception -> 0x0018 }
            r7.<init>()     // Catch:{ Exception -> 0x0018 }
            r7.D0(r2)     // Catch:{ Exception -> 0x0018 }
            r7.i0(r1)     // Catch:{ Exception -> 0x0018 }
            r7.H1(r4)     // Catch:{ Exception -> 0x0018 }
            r6.a(r7)     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r4 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r7 = r4.f26187a     // Catch:{ Exception -> 0x0018 }
            float r8 = r2.m()     // Catch:{ Exception -> 0x0018 }
            float r7 = r7 - r8
            r4.f26187a = r7     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r4 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r7 = r4.f26191e     // Catch:{ Exception -> 0x0018 }
            float r8 = r2.q()     // Catch:{ Exception -> 0x0018 }
            float r7 = r7 - r8
            r4.f26191e = r7     // Catch:{ Exception -> 0x0018 }
            r12.b(r6)     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r4 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r6 = r4.f26187a     // Catch:{ Exception -> 0x0018 }
            float r7 = r2.m()     // Catch:{ Exception -> 0x0018 }
            float r6 = r6 + r7
            r4.f26187a = r6     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r4 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r6 = r4.f26191e     // Catch:{ Exception -> 0x0018 }
            float r7 = r2.q()     // Catch:{ Exception -> 0x0018 }
            float r6 = r6 + r7
            r4.f26191e = r6     // Catch:{ Exception -> 0x0018 }
            goto L_0x03f7
        L_0x03c9:
            com.itextpdf.text.pdf.PdfLine r4 = r12.N3     // Catch:{ Exception -> 0x0018 }
            float r6 = r2.A1()     // Catch:{ Exception -> 0x0018 }
            r4.y(r6)     // Catch:{ Exception -> 0x0018 }
            float r4 = r12.B3     // Catch:{ Exception -> 0x0018 }
            r13.t(r12)     // Catch:{ Exception -> 0x0018 }
            r12.m0()     // Catch:{ Exception -> 0x0018 }
            float r6 = r12.B3     // Catch:{ Exception -> 0x0018 }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x03e8
            java.util.ArrayList<com.itextpdf.text.pdf.PdfLine> r4 = r12.O3     // Catch:{ Exception -> 0x0018 }
            int r4 = r4.size()     // Catch:{ Exception -> 0x0018 }
            if (r4 <= 0) goto L_0x03f7
        L_0x03e8:
            float r4 = r2.K()     // Catch:{ Exception -> 0x0018 }
            float r6 = r2.G0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.Font r7 = r2.q0()     // Catch:{ Exception -> 0x0018 }
            r12.g0(r4, r6, r7, r3)     // Catch:{ Exception -> 0x0018 }
        L_0x03f7:
            if (r5 == 0) goto L_0x0409
            boolean r4 = r12.C3     // Catch:{ Exception -> 0x0018 }
            if (r4 != 0) goto L_0x0409
            com.itextpdf.text.pdf.PdfWriter r4 = r12.o3     // Catch:{ Exception -> 0x0018 }
            float r6 = r12.R0()     // Catch:{ Exception -> 0x0018 }
            float r7 = r12.B3     // Catch:{ Exception -> 0x0018 }
            float r6 = r6 - r7
            r5.l(r4, r12, r6)     // Catch:{ Exception -> 0x0018 }
        L_0x0409:
            r12.A3 = r1     // Catch:{ Exception -> 0x0018 }
            java.util.ArrayList<com.itextpdf.text.Element> r1 = r12.p4     // Catch:{ Exception -> 0x0018 }
            if (r1 == 0) goto L_0x0418
            int r1 = r1.size()     // Catch:{ Exception -> 0x0018 }
            if (r1 == 0) goto L_0x0418
            r12.r0()     // Catch:{ Exception -> 0x0018 }
        L_0x0418:
            com.itextpdf.text.pdf.PdfDocument$Indentation r1 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r4 = r1.f26187a     // Catch:{ Exception -> 0x0018 }
            float r5 = r2.m()     // Catch:{ Exception -> 0x0018 }
            float r4 = r4 - r5
            r1.f26187a = r4     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfDocument$Indentation r1 = r12.Q3     // Catch:{ Exception -> 0x0018 }
            float r4 = r1.f26191e     // Catch:{ Exception -> 0x0018 }
            float r5 = r2.q()     // Catch:{ Exception -> 0x0018 }
            float r4 = r4 - r5
            r1.f26191e = r4     // Catch:{ Exception -> 0x0018 }
            r12.m0()     // Catch:{ Exception -> 0x0018 }
            r12.E3 = r0     // Catch:{ Exception -> 0x0018 }
            r12.a1()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfWriter r0 = r12.o3     // Catch:{ Exception -> 0x0018 }
            boolean r0 = V0(r0)     // Catch:{ Exception -> 0x0018 }
            if (r0 == 0) goto L_0x05f1
            r12.s0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfContentByte r0 = r12.x3     // Catch:{ Exception -> 0x0018 }
            r0.c0(r2)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x0448:
            com.itextpdf.text.TabSettings r0 = r12.E3     // Catch:{ Exception -> 0x0018 }
            r1 = r13
            com.itextpdf.text.Phrase r1 = (com.itextpdf.text.Phrase) r1     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.TabSettings r1 = r1.F0()     // Catch:{ Exception -> 0x0018 }
            if (r1 == 0) goto L_0x045c
            r1 = r13
            com.itextpdf.text.Phrase r1 = (com.itextpdf.text.Phrase) r1     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.TabSettings r1 = r1.F0()     // Catch:{ Exception -> 0x0018 }
            r12.E3 = r1     // Catch:{ Exception -> 0x0018 }
        L_0x045c:
            r1 = r13
            com.itextpdf.text.Phrase r1 = (com.itextpdf.text.Phrase) r1     // Catch:{ Exception -> 0x0018 }
            float r1 = r1.G0()     // Catch:{ Exception -> 0x0018 }
            r12.z3 = r1     // Catch:{ Exception -> 0x0018 }
            r12.b1()     // Catch:{ Exception -> 0x0018 }
            r13.t(r12)     // Catch:{ Exception -> 0x0018 }
            r12.E3 = r0     // Catch:{ Exception -> 0x0018 }
            goto L_0x00bc
        L_0x046f:
            com.itextpdf.text.pdf.PdfLine r0 = r12.N3     // Catch:{ Exception -> 0x0018 }
            if (r0 != 0) goto L_0x0476
            r12.m0()     // Catch:{ Exception -> 0x0018 }
        L_0x0476:
            com.itextpdf.text.pdf.PdfChunk r0 = new com.itextpdf.text.pdf.PdfChunk     // Catch:{ Exception -> 0x0018 }
            r2 = r13
            com.itextpdf.text.Chunk r2 = (com.itextpdf.text.Chunk) r2     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfAction r4 = r12.D3     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.TabSettings r5 = r12.E3     // Catch:{ Exception -> 0x0018 }
            r0.<init>(r2, r4, r5)     // Catch:{ Exception -> 0x0018 }
        L_0x0482:
            com.itextpdf.text.pdf.PdfLine r2 = r12.N3     // Catch:{ Exception -> 0x0018 }
            float r4 = r12.z3     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfChunk r2 = r2.b(r0, r4)     // Catch:{ Exception -> 0x0018 }
            if (r2 == 0) goto L_0x049a
            r12.m0()     // Catch:{ Exception -> 0x0018 }
            boolean r0 = r0.z()     // Catch:{ Exception -> 0x0018 }
            if (r0 != 0) goto L_0x0498
            r2.O()     // Catch:{ Exception -> 0x0018 }
        L_0x0498:
            r0 = r2
            goto L_0x0482
        L_0x049a:
            r12.j4 = r1     // Catch:{ Exception -> 0x0018 }
            java.lang.String r1 = "NEWPAGE"
            boolean r0 = r0.v(r1)     // Catch:{ Exception -> 0x0018 }
            if (r0 == 0) goto L_0x05f1
            r12.f()     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x04a9:
            r0 = r13
            com.itextpdf.text.Meta r0 = (com.itextpdf.text.Meta) r0     // Catch:{ Exception -> 0x0018 }
            java.lang.String r0 = r0.c()     // Catch:{ Exception -> 0x0018 }
            r12.k1(r0)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x04b5:
            com.itextpdf.text.pdf.PdfDocument$PdfInfo r0 = r12.R3     // Catch:{ Exception -> 0x0018 }
            r1 = r13
            com.itextpdf.text.Meta r1 = (com.itextpdf.text.Meta) r1     // Catch:{ Exception -> 0x0018 }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x0018 }
            r0.m1(r1)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x04c3:
            com.itextpdf.text.pdf.PdfDocument$PdfInfo r0 = r12.R3     // Catch:{ Exception -> 0x0018 }
            r0.i1()     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x04ca:
            com.itextpdf.text.pdf.PdfDocument$PdfInfo r0 = r12.R3     // Catch:{ Exception -> 0x0018 }
            r0.o1()     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x04d1:
            com.itextpdf.text.pdf.PdfDocument$PdfInfo r0 = r12.R3     // Catch:{ Exception -> 0x0018 }
            r1 = r13
            com.itextpdf.text.Meta r1 = (com.itextpdf.text.Meta) r1     // Catch:{ Exception -> 0x0018 }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x0018 }
            r0.f1(r1)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x04df:
            com.itextpdf.text.pdf.PdfDocument$PdfInfo r0 = r12.R3     // Catch:{ Exception -> 0x0018 }
            r1 = r13
            com.itextpdf.text.Meta r1 = (com.itextpdf.text.Meta) r1     // Catch:{ Exception -> 0x0018 }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x0018 }
            r0.n1(r1)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x04ed:
            com.itextpdf.text.pdf.PdfDocument$PdfInfo r0 = r12.R3     // Catch:{ Exception -> 0x0018 }
            r1 = r13
            com.itextpdf.text.Meta r1 = (com.itextpdf.text.Meta) r1     // Catch:{ Exception -> 0x0018 }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x0018 }
            r0.p1(r1)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x04fb:
            com.itextpdf.text.pdf.PdfDocument$PdfInfo r0 = r12.R3     // Catch:{ Exception -> 0x0018 }
            r1 = r13
            com.itextpdf.text.Meta r1 = (com.itextpdf.text.Meta) r1     // Catch:{ Exception -> 0x0018 }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x0018 }
            r0.q1(r1)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x0509:
            com.itextpdf.text.pdf.PdfDocument$PdfInfo r0 = r12.R3     // Catch:{ Exception -> 0x0018 }
            r1 = r13
            com.itextpdf.text.Meta r1 = (com.itextpdf.text.Meta) r1     // Catch:{ Exception -> 0x0018 }
            java.lang.String r1 = r1.e()     // Catch:{ Exception -> 0x0018 }
            r2 = r13
            com.itextpdf.text.Meta r2 = (com.itextpdf.text.Meta) r2     // Catch:{ Exception -> 0x0018 }
            java.lang.String r2 = r2.c()     // Catch:{ Exception -> 0x0018 }
            r0.s1(r1, r2)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x051e:
            r0 = r13
            com.itextpdf.text.Rectangle r0 = (com.itextpdf.text.Rectangle) r0     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfContentByte r2 = r12.y3     // Catch:{ Exception -> 0x0018 }
            r2.I1(r0)     // Catch:{ Exception -> 0x0018 }
            goto L_0x0059
        L_0x0528:
            com.itextpdf.text.pdf.PdfLine r0 = r12.N3     // Catch:{ Exception -> 0x0018 }
            if (r0 != 0) goto L_0x052f
            r12.m0()     // Catch:{ Exception -> 0x0018 }
        L_0x052f:
            r0 = r13
            com.itextpdf.text.Annotation r0 = (com.itextpdf.text.Annotation) r0     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.Rectangle r2 = new com.itextpdf.text.Rectangle     // Catch:{ Exception -> 0x0018 }
            r2.<init>(r4, r4)     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfLine r4 = r12.N3     // Catch:{ Exception -> 0x0018 }
            if (r4 == 0) goto L_0x0578
            com.itextpdf.text.Rectangle r2 = new com.itextpdf.text.Rectangle     // Catch:{ Exception -> 0x0018 }
            float r4 = r12.Q0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfLine r5 = r12.N3     // Catch:{ Exception -> 0x0018 }
            float r5 = r5.B()     // Catch:{ Exception -> 0x0018 }
            float r4 = r4 - r5
            float r4 = r0.g(r4)     // Catch:{ Exception -> 0x0018 }
            float r5 = r12.R0()     // Catch:{ Exception -> 0x0018 }
            float r6 = r12.B3     // Catch:{ Exception -> 0x0018 }
            float r5 = r5 - r6
            r6 = 1101004800(0x41a00000, float:20.0)
            float r5 = r5 - r6
            float r5 = r0.o(r5)     // Catch:{ Exception -> 0x0018 }
            float r7 = r12.Q0()     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfLine r8 = r12.N3     // Catch:{ Exception -> 0x0018 }
            float r8 = r8.B()     // Catch:{ Exception -> 0x0018 }
            float r7 = r7 - r8
            float r7 = r7 + r6
            float r6 = r0.m(r7)     // Catch:{ Exception -> 0x0018 }
            float r7 = r12.R0()     // Catch:{ Exception -> 0x0018 }
            float r8 = r12.B3     // Catch:{ Exception -> 0x0018 }
            float r7 = r7 - r8
            float r7 = r0.i(r7)     // Catch:{ Exception -> 0x0018 }
            r2.<init>(r4, r5, r6, r7)     // Catch:{ Exception -> 0x0018 }
        L_0x0578:
            com.itextpdf.text.pdf.PdfWriter r4 = r12.o3     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfAnnotation r0 = com.itextpdf.text.pdf.internal.PdfAnnotationsImp.e(r4, r0, r2)     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.internal.PdfAnnotationsImp r2 = r12.e4     // Catch:{ Exception -> 0x0018 }
            r2.d(r0)     // Catch:{ Exception -> 0x0018 }
            goto L_0x0059
        L_0x0585:
            com.itextpdf.text.pdf.PdfWriter r0 = r12.o3     // Catch:{ Exception -> 0x0018 }
            if (r0 == 0) goto L_0x05f1
            r1 = r13
            com.itextpdf.text.api.WriterOperation r1 = (com.itextpdf.text.api.WriterOperation) r1     // Catch:{ Exception -> 0x0018 }
            r1.a(r0, r12)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x0590:
            r0 = r13
            com.itextpdf.text.pdf.draw.DrawInterface r0 = (com.itextpdf.text.pdf.draw.DrawInterface) r0     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.pdf.PdfContentByte r5 = r12.y3     // Catch:{ Exception -> 0x0018 }
            float r6 = r12.P0()     // Catch:{ Exception -> 0x0018 }
            float r7 = r12.O0()     // Catch:{ Exception -> 0x0018 }
            float r8 = r12.Q0()     // Catch:{ Exception -> 0x0018 }
            float r9 = r12.R0()     // Catch:{ Exception -> 0x0018 }
            float r2 = r12.R0()     // Catch:{ Exception -> 0x0018 }
            float r10 = r12.B3     // Catch:{ Exception -> 0x0018 }
            float r2 = r2 - r10
            java.util.Stack<java.lang.Float> r10 = r12.F3     // Catch:{ Exception -> 0x0018 }
            int r10 = r10.size()     // Catch:{ Exception -> 0x0018 }
            if (r10 <= 0) goto L_0x05b6
            float r4 = r12.z3     // Catch:{ Exception -> 0x0018 }
        L_0x05b6:
            float r10 = r2 - r4
            r4 = r0
            r4.a(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0018 }
            goto L_0x0059
        L_0x05be:
            boolean r0 = r13 instanceof com.itextpdf.text.MarkedSection     // Catch:{ Exception -> 0x0018 }
            if (r0 == 0) goto L_0x05ce
            r0 = r13
            com.itextpdf.text.MarkedSection r0 = (com.itextpdf.text.MarkedSection) r0     // Catch:{ Exception -> 0x0018 }
            com.itextpdf.text.MarkedObject r0 = r0.l()     // Catch:{ Exception -> 0x0018 }
            if (r0 == 0) goto L_0x05ce
            r0.t(r12)     // Catch:{ Exception -> 0x0018 }
        L_0x05ce:
            r0 = r13
            com.itextpdf.text.MarkedObject r0 = (com.itextpdf.text.MarkedObject) r0     // Catch:{ Exception -> 0x0018 }
            r0.t(r12)     // Catch:{ Exception -> 0x0018 }
            goto L_0x05f1
        L_0x05d5:
            r0 = r13
            com.itextpdf.text.pdf.PdfPTable r0 = (com.itextpdf.text.pdf.PdfPTable) r0     // Catch:{ Exception -> 0x0018 }
            int r2 = r0.e1()     // Catch:{ Exception -> 0x0018 }
            int r4 = r0.S()     // Catch:{ Exception -> 0x0018 }
            if (r2 > r4) goto L_0x05e3
            goto L_0x05f1
        L_0x05e3:
            r12.p0()     // Catch:{ Exception -> 0x0018 }
            r12.s0()     // Catch:{ Exception -> 0x0018 }
            r12.e0(r0)     // Catch:{ Exception -> 0x0018 }
            r12.j4 = r1     // Catch:{ Exception -> 0x0018 }
            r12.Y0()     // Catch:{ Exception -> 0x0018 }
        L_0x05f1:
            int r13 = r13.type()     // Catch:{ Exception -> 0x0018 }
            r12.P3 = r13     // Catch:{ Exception -> 0x0018 }
            return r3
        L_0x05f8:
            com.itextpdf.text.DocumentException r0 = new com.itextpdf.text.DocumentException
            r0.<init>((java.lang.Exception) r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfDocument.b(com.itextpdf.text.Element):boolean");
    }

    /* access modifiers changed from: package-private */
    public void b0(PdfAction pdfAction) {
        if (pdfAction.d0(PdfName.ea) != null) {
            try {
                HashMap<String, PdfObject> hashMap = this.Y3;
                DecimalFormat decimalFormat = r4;
                int i2 = this.X3;
                this.X3 = i2 + 1;
                hashMap.put(decimalFormat.format((long) i2), this.o3.v0(pdfAction).a());
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            throw new RuntimeException(MessageLocalization.b("only.javascript.actions.are.allowed", new Object[0]));
        }
    }

    /* access modifiers changed from: protected */
    public void b1() {
        this.F3.push(Float.valueOf(this.z3));
    }

    public boolean c(boolean z) {
        PdfWriter pdfWriter = this.o3;
        if (pdfWriter == null || !pdfWriter.G()) {
            return super.c(z);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void c0(String str, PdfAction pdfAction) {
        if (pdfAction.d0(PdfName.ea) != null) {
            try {
                this.Y3.put(str, this.o3.v0(pdfAction).a());
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            throw new RuntimeException(MessageLocalization.b("only.javascript.actions.are.allowed", new Object[0]));
        }
    }

    /* access modifiers changed from: package-private */
    public void c1(String str, int i2, float f2, float f3, float f5, float f6) {
        X(this.o3.K0(f2, f3, f5, f6, new PdfAction(str, i2), (PdfName) null));
    }

    public void close() {
        int size;
        if (!this.Y) {
            try {
                if (V0(this.o3)) {
                    r0();
                    s0();
                    this.o3.S0();
                    this.o3.T0();
                    if (T0() && (size = this.o3.o3.size()) > 0) {
                        PdfWriter pdfWriter = this.o3;
                        if (pdfWriter.p3 == size) {
                            pdfWriter.o3.remove(size - 1);
                        }
                    }
                } else {
                    this.o3.S0();
                }
                if (this.o4 != null) {
                    f();
                }
                o0();
                if (V0(this.o3)) {
                    this.o3.g1().c0(this);
                }
                if (!this.e4.g()) {
                    PdfPageEvent y1 = this.o3.y1();
                    if (y1 != null) {
                        y1.g(this.o3, this);
                    }
                    super.close();
                    this.o3.h0(this.W3);
                    l0();
                    C1();
                    this.o3.close();
                    return;
                }
                throw new RuntimeException(MessageLocalization.b("not.all.annotations.could.be.added.to.the.document.the.document.doesn.t.have.enough.pages", new Object[0]));
            } catch (Exception e2) {
                throw ExceptionConverter.a(e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d0(PdfOutline pdfOutline, String str) {
        W0(str, pdfOutline.n1());
    }

    /* access modifiers changed from: package-private */
    public void d1(String str, String str2, float f2, float f3, float f5, float f6) {
        this.e4.d(this.o3.K0(f2, f3, f5, f6, new PdfAction(str, str2), (PdfName) null));
    }

    /* access modifiers changed from: package-private */
    public void e0(PdfPTable pdfPTable) throws DocumentException {
        ColumnText columnText = new ColumnText(V0(this.o3) ? this.x3 : this.o3.g1());
        columnText.k0(pdfPTable.h0());
        if (pdfPTable.W() && !q0(pdfPTable, 0.0f) && this.B3 > 0.0f) {
            f();
            if (V0(this.o3)) {
                columnText.X(this.x3);
            }
        }
        if (this.B3 == 0.0f) {
            columnText.U(false);
        }
        columnText.a(pdfPTable);
        boolean s0 = pdfPTable.s0();
        pdfPTable.L0(true);
        int i2 = 0;
        while (true) {
            columnText.l0(P0(), O0(), Q0(), R0() - this.B3);
            if ((columnText.I() & 1) != 0) {
                if (V0(this.o3)) {
                    this.x3.e3(P0(), columnText.H());
                } else {
                    this.x3.t1(0.0f, (columnText.H() - R0()) + this.B3);
                }
                this.B3 = R0() - columnText.H();
                pdfPTable.L0(s0);
                return;
            }
            i2 = R0() - this.B3 == columnText.H() ? i2 + 1 : 0;
            if (i2 != 3) {
                this.B3 = R0() - columnText.H();
                f();
                if (V0(this.o3)) {
                    columnText.X(this.x3);
                }
            } else {
                throw new DocumentException(MessageLocalization.b("infinite.table.loop", new Object[0]));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void e1(AccessibleElementId accessibleElementId, PdfStructureElement pdfStructureElement) {
        this.p3.put(accessibleElementId, pdfStructureElement);
    }

    public boolean f() {
        if (T0()) {
            m1();
            return false;
        } else if (!this.X || this.Y) {
            throw new RuntimeException(MessageLocalization.b("the.document.is.not.open", new Object[0]));
        } else {
            ArrayList<IAccessibleElement> o0 = o0();
            super.f();
            Indentation indentation = this.Q3;
            indentation.f26190d = 0.0f;
            indentation.f26193g = 0.0f;
            try {
                if (V0(this.o3)) {
                    t0();
                    this.o3.h1().T1(o0);
                }
                S0();
                PdfBody pdfBody = this.G3;
                if (pdfBody == null || pdfBody.k() == null) {
                    return true;
                }
                this.y3.I1(this.G3);
                return true;
            } catch (DocumentException e2) {
                throw new ExceptionConverter(e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void f0(float f2, float f3, Font font) {
        g0(f2, f3, font, false);
    }

    /* access modifiers changed from: package-private */
    public void f1(PdfAction pdfAction, float f2, float f3, float f5, float f6) {
        X(this.o3.K0(f2, f3, f5, f6, pdfAction, (PdfName) null));
    }

    public boolean g(boolean z) {
        PdfWriter pdfWriter = this.o3;
        if (pdfWriter == null || !pdfWriter.G()) {
            return super.g(z);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void g0(float f2, float f3, Font font, boolean z) {
        if (f2 != 0.0f && !this.j4) {
            if (this.B3 + (z ? f2 : j0()) > R0() - O0()) {
                f();
                return;
            }
            this.z3 = f2;
            m0();
            if (font.u() || font.s()) {
                Font font2 = new Font(font);
                font2.z(font2.n() & -13);
                font = font2;
            }
            Chunk chunk = new Chunk(StringUtils.SPACE, font);
            if (z && this.j4) {
                chunk = new Chunk("", font);
            }
            chunk.t(this);
            m0();
            this.z3 = f3;
        }
    }

    /* access modifiers changed from: package-private */
    public void g1(String str, Rectangle rectangle) {
        if (rectangle == null) {
            this.i4.remove(str);
        } else {
            this.i4.put(str, new PdfRectangle(rectangle));
        }
    }

    /* access modifiers changed from: package-private */
    public void h0(PdfName pdfName, PdfObject pdfObject) {
        this.U3.v(pdfName, pdfObject);
    }

    public void h1(PdfCollection pdfCollection) {
        this.d4 = pdfCollection;
    }

    public void i0(PdfWriter pdfWriter) throws DocumentException {
        if (this.o3 == null) {
            this.o3 = pdfWriter;
            this.e4 = new PdfAnnotationsImp(pdfWriter);
            return;
        }
        throw new DocumentException(MessageLocalization.b("you.can.only.add.a.writer.to.a.pdfdocument.once", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void i1(Rectangle rectangle) {
        g1("crop", rectangle);
    }

    public boolean j(Rectangle rectangle) {
        PdfWriter pdfWriter = this.o3;
        if (pdfWriter != null && pdfWriter.G()) {
            return false;
        }
        this.g4 = new Rectangle(rectangle);
        return true;
    }

    /* access modifiers changed from: protected */
    public float j0() {
        float o = this.N3.o();
        float f2 = this.z3;
        return o != f2 ? o + f2 : o;
    }

    /* access modifiers changed from: package-private */
    public void j1(int i2) {
        if (i2 > 0) {
            this.o3.l0(PdfName.W6, new PdfNumber(i2));
        }
    }

    public boolean k(float f2, float f3, float f5, float f6) {
        PdfWriter pdfWriter = this.o3;
        if (pdfWriter != null && pdfWriter.G()) {
            return false;
        }
        this.I3 = f2;
        this.J3 = f3;
        this.K3 = f5;
        this.L3 = f6;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void k1(String str) {
        this.f4 = new PdfString(str);
    }

    /* access modifiers changed from: package-private */
    public void l0() {
        if (this.S3.m1().size() != 0) {
            z1(this.S3);
        }
    }

    /* access modifiers changed from: package-private */
    public void l1(float f2) {
        this.z3 = f2;
    }

    /* access modifiers changed from: protected */
    public void m0() {
        if (this.O3 == null) {
            this.O3 = new ArrayList<>();
        }
        PdfLine pdfLine = this.N3;
        if (pdfLine != null && pdfLine.A() > 0) {
            if (this.B3 + j0() > R0() - O0() && this.B3 != 0.0f) {
                PdfLine pdfLine2 = this.N3;
                this.N3 = null;
                f();
                this.N3 = pdfLine2;
                pdfLine2.f26238b = P0();
            }
            this.B3 += this.N3.o();
            this.O3.add(this.N3);
            this.j4 = false;
        }
        float f2 = this.n4;
        if (f2 > -1.0f && this.B3 > f2) {
            this.n4 = -1.0f;
            Indentation indentation = this.Q3;
            indentation.f26193g = 0.0f;
            indentation.f26190d = 0.0f;
        }
        this.N3 = new PdfLine(P0(), Q0(), this.A3, this.z3);
    }

    /* access modifiers changed from: protected */
    public void m1() {
        float f2;
        this.Z = this.g4;
        if (!this.b3 || (B() & 1) != 0) {
            this.X2 = this.I3;
            this.Y2 = this.J3;
        } else {
            this.Y2 = this.I3;
            this.X2 = this.J3;
        }
        if (!this.c3 || (B() & 1) != 0) {
            this.Z2 = this.K3;
            f2 = this.L3;
        } else {
            this.Z2 = this.L3;
            f2 = this.K3;
        }
        this.a3 = f2;
        if (!V0(this.o3)) {
            PdfContentByte pdfContentByte = new PdfContentByte(this.o3);
            this.x3 = pdfContentByte;
            pdfContentByte.L1();
        } else {
            this.x3 = this.y3;
        }
        this.x3.R();
        this.x3.t1(G(), R());
        if (V0(this.o3)) {
            this.H3 = this.x3.t3();
        }
    }

    public void n0() {
        float f2 = this.n4 - this.B3;
        PdfLine pdfLine = this.N3;
        if (pdfLine != null) {
            f2 += pdfLine.o();
        }
        if (this.n4 > -1.0f && f2 > 0.0f) {
            m0();
            this.B3 += f2;
        }
    }

    /* access modifiers changed from: package-private */
    public void n1(PdfAction pdfAction) {
        this.b4 = pdfAction;
        this.a4 = null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x015a A[Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0165 A[Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x017a A[Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.itextpdf.text.pdf.interfaces.IAccessibleElement> o0() {
        /*
            r11 = this;
            java.lang.String r0 = "crop"
            java.lang.String r1 = "art"
            boolean r2 = r11.T0()
            r3 = 0
            if (r2 == 0) goto L_0x000c
            return r3
        L_0x000c:
            r11.r0()     // Catch:{ DocumentException -> 0x01a3 }
            r2 = -1
            r11.P3 = r2
            com.itextpdf.text.pdf.PdfWriter r2 = r11.o3
            com.itextpdf.text.pdf.PdfPageEvent r2 = r2.y1()
            if (r2 == 0) goto L_0x001f
            com.itextpdf.text.pdf.PdfWriter r4 = r11.o3
            r2.d(r4, r11)
        L_0x001f:
            r11.s0()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.Rectangle r2 = r11.Z     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            int r2 = r2.S()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfWriter r4 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            boolean r4 = r4.T1()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r4 == 0) goto L_0x008a
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.PdfRectangle> r4 = r11.h4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            boolean r4 = r4.containsKey(r1)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            java.lang.String r5 = "trim"
            if (r4 == 0) goto L_0x0058
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.PdfRectangle> r4 = r11.h4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            boolean r4 = r4.containsKey(r5)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r4 != 0) goto L_0x0043
            goto L_0x0058
        L_0x0043:
            com.itextpdf.text.pdf.PdfXConformanceException r0 = new com.itextpdf.text.pdf.PdfXConformanceException     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            java.lang.String r1 = "only.one.of.artbox.or.trimbox.can.exist.in.the.page"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r2)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r0.<init>(r1)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            throw r0     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
        L_0x0052:
            r0 = move-exception
            goto L_0x0197
        L_0x0055:
            r0 = move-exception
            goto L_0x019d
        L_0x0058:
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.PdfRectangle> r4 = r11.h4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            boolean r1 = r4.containsKey(r1)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r1 != 0) goto L_0x008a
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.PdfRectangle> r1 = r11.h4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r1 != 0) goto L_0x008a
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.PdfRectangle> r1 = r11.h4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r1 == 0) goto L_0x007a
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.PdfRectangle> r1 = r11.h4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r1.put(r5, r0)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            goto L_0x008a
        L_0x007a:
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.PdfRectangle> r0 = r11.h4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfRectangle r1 = new com.itextpdf.text.pdf.PdfRectangle     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.Rectangle r4 = r11.Z     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            int r6 = r4.S()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r1.<init>((com.itextpdf.text.Rectangle) r4, (int) r6)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r0.put(r5, r1)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
        L_0x008a:
            com.itextpdf.text.pdf.PageResources r0 = r11.l4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfWriter r1 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfDictionary r1 = r1.f1()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r0.d(r1)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfWriter r0 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            boolean r0 = r0.V1()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r0 == 0) goto L_0x00ae
            com.itextpdf.text.pdf.PdfDictionary r0 = new com.itextpdf.text.pdf.PdfDictionary     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r0.<init>()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.b6     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.B6     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r0.V0(r1, r4)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PageResources r1 = r11.l4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r1.d(r0)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
        L_0x00ae:
            com.itextpdf.text.pdf.PageResources r0 = r11.l4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfDictionary r0 = r0.k()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfPage r1 = new com.itextpdf.text.pdf.PdfPage     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfRectangle r4 = new com.itextpdf.text.pdf.PdfRectangle     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.Rectangle r5 = r11.Z     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r4.<init>((com.itextpdf.text.Rectangle) r5, (int) r2)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.PdfRectangle> r5 = r11.h4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r1.<init>(r4, r5, r0, r2)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfWriter r0 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            boolean r0 = V0(r0)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r0 == 0) goto L_0x00d2
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Lf     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Ce     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
        L_0x00ce:
            r1.V0(r0, r2)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            goto L_0x00db
        L_0x00d2:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Lf     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfWriter r2 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfName r2 = r2.M1()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            goto L_0x00ce
        L_0x00db:
            com.itextpdf.text.pdf.PdfWriter r0 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfDictionary r0 = r0.x1()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r1.X0(r0)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfWriter r0 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r0.g2()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfDictionary r0 = r11.k4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r0 == 0) goto L_0x00fe
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.m3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfWriter r4 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfIndirectObject r0 = r4.v0(r0)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfIndirectReference r0 = r0.a()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r1.V0(r2, r0)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r11.k4 = r3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
        L_0x00fe:
            com.itextpdf.text.pdf.internal.PdfAnnotationsImp r0 = r11.e4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            boolean r0 = r0.g()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r0 == 0) goto L_0x011b
            com.itextpdf.text.pdf.internal.PdfAnnotationsImp r0 = r11.e4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfWriter r2 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.Rectangle r4 = r11.Z     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfArray r0 = r0.j(r2, r4)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            int r2 = r0.size()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r2 == 0) goto L_0x011b
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Q3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r1.V0(r2, r0)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
        L_0x011b:
            com.itextpdf.text.pdf.PdfWriter r0 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            boolean r0 = V0(r0)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r0 == 0) goto L_0x0137
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.wf     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfWriter r4 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfIndirectReference r4 = r4.d1()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            int r4 = r11.K0(r4)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r2.<init>((int) r4)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r1.V0(r0, r2)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
        L_0x0137:
            com.itextpdf.text.pdf.PdfContentByte r0 = r11.x3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            int r0 = r0.t3()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            int r2 = r11.H3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r0 > r2) goto L_0x014d
            com.itextpdf.text.pdf.PdfWriter r0 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            boolean r0 = V0(r0)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r0 == 0) goto L_0x014a
            goto L_0x014d
        L_0x014a:
            r11.x3 = r3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            goto L_0x0152
        L_0x014d:
            com.itextpdf.text.pdf.PdfContentByte r0 = r11.x3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r0.L0()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
        L_0x0152:
            com.itextpdf.text.pdf.PdfWriter r0 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            boolean r0 = V0(r0)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r0 == 0) goto L_0x0165
            com.itextpdf.text.pdf.PdfWriter r0 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfContentByte r0 = r0.g1()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            java.util.ArrayList r0 = r0.Z1()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            goto L_0x0166
        L_0x0165:
            r0 = r3
        L_0x0166:
            com.itextpdf.text.pdf.PdfWriter r2 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfContents r10 = new com.itextpdf.text.pdf.PdfContents     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfWriter r4 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfContentByte r5 = r4.h1()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfContentByte r6 = r11.y3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfWriter r4 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            boolean r4 = V0(r4)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            if (r4 != 0) goto L_0x017c
            com.itextpdf.text.pdf.PdfContentByte r3 = r11.x3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
        L_0x017c:
            r7 = r3
            com.itextpdf.text.pdf.PdfWriter r3 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfContentByte r8 = r3.g1()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.Rectangle r9 = r11.Z     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r4 = r10
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r2.S(r1, r10)     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.internal.PdfAnnotationsImp r1 = r11.e4     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r1.i()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            com.itextpdf.text.pdf.PdfWriter r1 = r11.o3     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            r1.f2()     // Catch:{ DocumentException -> 0x0055, IOException -> 0x0052 }
            return r0
        L_0x0197:
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        L_0x019d:
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        L_0x01a3:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfDocument.o0():java.util.ArrayList");
    }

    /* access modifiers changed from: package-private */
    public void o1(String str) {
        this.a4 = str;
        this.b4 = null;
    }

    public void open() {
        if (!this.X) {
            super.open();
            this.o3.open();
            PdfOutline pdfOutline = new PdfOutline(this.o3);
            this.S3 = pdfOutline;
            this.T3 = pdfOutline;
        }
        try {
            if (V0(this.o3)) {
                this.u3 = true;
            }
            S0();
        } catch (DocumentException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void p0() {
        try {
            int i2 = this.P3;
            if (i2 == 11 || i2 == 10) {
                Y0();
                s0();
            }
        } catch (DocumentException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void p1(PdfName pdfName, PdfAction pdfAction) {
        if (this.k4 == null) {
            this.k4 = new PdfDictionary();
        }
        this.k4.V0(pdfName, pdfAction);
    }

    /* access modifiers changed from: package-private */
    public boolean q0(PdfPTable pdfPTable, float f2) {
        if (!pdfPTable.t0()) {
            pdfPTable.X0(((Q0() - P0()) * pdfPTable.n0()) / 100.0f);
        }
        p0();
        float l0 = pdfPTable.v0() ? pdfPTable.l0() - pdfPTable.R() : pdfPTable.l0();
        float f3 = 0.0f;
        if (this.B3 > 0.0f) {
            f3 = pdfPTable.h1();
        }
        return l0 + f3 <= ((R0() - this.B3) - O0()) - f2;
    }

    /* access modifiers changed from: package-private */
    public void q1(boolean z) {
        this.j4 = z;
    }

    /* access modifiers changed from: package-private */
    public void r1(PdfPageLabels pdfPageLabels) {
        this.V3 = pdfPageLabels;
    }

    public void s() {
        PdfWriter pdfWriter = this.o3;
        if (pdfWriter == null || !pdfWriter.G()) {
            super.s();
        }
    }

    /* access modifiers changed from: protected */
    public float s0() throws DocumentException {
        ListLabel listLabel;
        if (this.O3 == null) {
            return 0.0f;
        }
        PdfLine pdfLine = this.N3;
        if (pdfLine != null && pdfLine.A() > 0) {
            this.O3.add(this.N3);
            this.N3 = new PdfLine(P0(), Q0(), this.A3, this.z3);
        }
        if (this.O3.isEmpty()) {
            return 0.0f;
        }
        Object[] objArr = new Object[2];
        objArr[1] = new Float(0.0f);
        Iterator<PdfLine> it2 = this.O3.iterator();
        PdfFont pdfFont = null;
        float f2 = 0.0f;
        while (it2.hasNext()) {
            PdfLine next = it2.next();
            float p = next.p() - P0();
            Indentation indentation = this.Q3;
            float f3 = p + indentation.f26187a + indentation.f26189c + indentation.f26188b;
            this.x3.t1(f3, -next.o());
            next.d();
            if (next.v() != null) {
                Chunk v = next.v();
                if (V0(this.o3)) {
                    listLabel = next.u().i2();
                    this.y3.B1(listLabel);
                    Chunk chunk = new Chunk(v);
                    chunk.o((PdfName) null);
                    v = chunk;
                } else {
                    listLabel = null;
                }
                ColumnText.u0(this.y3, 0, new Phrase(v), this.x3.l1() - next.t(), this.x3.m1(), 0.0f);
                if (listLabel != null) {
                    this.y3.c0(listLabel);
                }
            }
            objArr[0] = pdfFont;
            if (V0(this.o3) && next.u() != null) {
                this.x3.B1(next.u().g2());
            }
            B1(next, this.x3, this.y3, objArr, this.o3.J1());
            pdfFont = (PdfFont) objArr[0];
            f2 += next.o();
            this.x3.t1(-f3, 0.0f);
        }
        this.O3 = new ArrayList<>();
        return f2;
    }

    /* access modifiers changed from: package-private */
    public void s1(int i2) {
        this.e4.k(i2);
    }

    public void t(int i2) {
        PdfWriter pdfWriter = this.o3;
        if (pdfWriter == null || !pdfWriter.G()) {
            super.t(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void t0() {
        if (this.t3) {
            Iterator<Map.Entry<AccessibleElementId, PdfStructureElement>> it2 = this.p3.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                if (!((PdfStructureElement) next.getValue()).q1().equals(PdfName.P6)) {
                    try {
                        PdfStructureElement pdfStructureElement = (PdfStructureElement) next.getValue();
                        PdfDictionary m1 = pdfStructureElement.m1();
                        PdfStructureElement pdfStructureElement2 = m1 instanceof PdfStructureElement ? (PdfStructureElement) m1 : null;
                        if (pdfStructureElement2 != null) {
                            this.s3.put(next.getKey(), pdfStructureElement2.i1());
                        }
                        this.r3.put(next.getKey(), this.q3.d(pdfStructureElement));
                        it2.remove();
                    } catch (IOException e2) {
                        throw new ExceptionConverter(e2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void t1(boolean z) {
        this.m4 = z;
    }

    /* access modifiers changed from: package-private */
    public PdfAcroForm u0() {
        return this.e4.f();
    }

    public void u1(TabSettings tabSettings) {
        this.E3 = tabSettings;
    }

    /* access modifiers changed from: package-private */
    public Rectangle v0(String str) {
        PdfRectangle pdfRectangle = this.h4.get(str);
        if (pdfRectangle != null) {
            return pdfRectangle.a1();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void v1(Image image) throws PdfException, DocumentException {
        PdfWriter pdfWriter = this.o3;
        pdfWriter.l0(PdfName.Zf, pdfWriter.l1(pdfWriter.V(image)));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005d, code lost:
        if (r5 != null) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfDocument.PdfCatalog w0(com.itextpdf.text.pdf.PdfIndirectReference r5) {
        /*
            r4 = this;
            com.itextpdf.text.pdf.PdfDocument$PdfCatalog r0 = new com.itextpdf.text.pdf.PdfDocument$PdfCatalog
            com.itextpdf.text.pdf.PdfWriter r1 = r4.o3
            r0.<init>(r5, r1)
            com.itextpdf.text.pdf.PdfOutline r5 = r4.S3
            java.util.ArrayList r5 = r5.m1()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x0025
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.yc
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.eh
            r0.V0(r5, r1)
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.nc
            com.itextpdf.text.pdf.PdfOutline r1 = r4.S3
            com.itextpdf.text.pdf.PdfIndirectReference r1 = r1.s1()
            r0.V0(r5, r1)
        L_0x0025:
            com.itextpdf.text.pdf.PdfWriter r5 = r4.o3
            com.itextpdf.text.pdf.internal.PdfVersionImp r5 = r5.F1()
            r5.a(r0)
            com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp r5 = r4.U3
            r5.b(r0)
            com.itextpdf.text.pdf.PdfPageLabels r5 = r4.V3
            if (r5 == 0) goto L_0x0042
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.wc
            com.itextpdf.text.pdf.PdfWriter r2 = r4.o3
            com.itextpdf.text.pdf.PdfDictionary r5 = r5.f(r2)
            r0.V0(r1, r5)
        L_0x0042:
            java.util.TreeMap<java.lang.String, com.itextpdf.text.pdf.PdfDocument$Destination> r5 = r4.W3
            java.util.HashMap r1 = r4.y0()
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.PdfObject> r2 = r4.Z3
            com.itextpdf.text.pdf.PdfWriter r3 = r4.o3
            r0.f1(r5, r1, r2, r3)
            java.lang.String r5 = r4.a4
            if (r5 == 0) goto L_0x005b
            com.itextpdf.text.pdf.PdfAction r5 = r4.C0(r5)
        L_0x0057:
            r0.m1(r5)
            goto L_0x0060
        L_0x005b:
            com.itextpdf.text.pdf.PdfAction r5 = r4.b4
            if (r5 == 0) goto L_0x0060
            goto L_0x0057
        L_0x0060:
            com.itextpdf.text.pdf.PdfDictionary r5 = r4.c4
            if (r5 == 0) goto L_0x0067
            r0.i1(r5)
        L_0x0067:
            com.itextpdf.text.pdf.collection.PdfCollection r5 = r4.d4
            if (r5 == 0) goto L_0x0070
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.y5
            r0.V0(r1, r5)
        L_0x0070:
            com.itextpdf.text.pdf.internal.PdfAnnotationsImp r5 = r4.e4
            boolean r5 = r5.h()
            if (r5 == 0) goto L_0x0095
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.p3     // Catch:{ IOException -> 0x008e }
            com.itextpdf.text.pdf.PdfWriter r1 = r4.o3     // Catch:{ IOException -> 0x008e }
            com.itextpdf.text.pdf.internal.PdfAnnotationsImp r2 = r4.e4     // Catch:{ IOException -> 0x008e }
            com.itextpdf.text.pdf.PdfAcroForm r2 = r2.f()     // Catch:{ IOException -> 0x008e }
            com.itextpdf.text.pdf.PdfIndirectObject r1 = r1.v0(r2)     // Catch:{ IOException -> 0x008e }
            com.itextpdf.text.pdf.PdfIndirectReference r1 = r1.a()     // Catch:{ IOException -> 0x008e }
            r0.V0(r5, r1)     // Catch:{ IOException -> 0x008e }
            goto L_0x0095
        L_0x008e:
            r5 = move-exception
            com.itextpdf.text.ExceptionConverter r0 = new com.itextpdf.text.ExceptionConverter
            r0.<init>(r5)
            throw r0
        L_0x0095:
            com.itextpdf.text.pdf.PdfString r5 = r4.f4
            if (r5 == 0) goto L_0x009e
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.ma
            r0.V0(r1, r5)
        L_0x009e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfDocument.w0(com.itextpdf.text.pdf.PdfIndirectReference):com.itextpdf.text.pdf.PdfDocument$PdfCatalog");
    }

    /* access modifiers changed from: package-private */
    public void w1(PdfTransition pdfTransition) {
        this.o3.l0(PdfName.sg, pdfTransition.b());
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, PdfObject> x0() {
        return this.Z3;
    }

    /* access modifiers changed from: package-private */
    public void x1(int i2) {
        this.U3.a(i2);
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, PdfObject> y0() {
        return this.Y3;
    }

    public void y1(byte[] bArr) throws IOException {
        PdfStream pdfStream = new PdfStream(bArr);
        PdfName pdfName = PdfName.Kg;
        PdfName pdfName2 = PdfName.db;
        pdfStream.V0(pdfName, pdfName2);
        pdfStream.V0(PdfName.Cf, PdfName.Zh);
        PdfEncryption i1 = this.o3.i1();
        if (i1 != null && !i1.q()) {
            PdfArray pdfArray = new PdfArray();
            pdfArray.a0(PdfName.a6);
            pdfStream.V0(PdfName.T7, pdfArray);
        }
        PdfWriter pdfWriter = this.o3;
        pdfWriter.l0(pdfName2, pdfWriter.v0(pdfStream).a());
    }

    /* access modifiers changed from: package-private */
    public PdfInfo z0() {
        return this.R3;
    }

    /* access modifiers changed from: package-private */
    public void z1(PdfOutline pdfOutline) {
        int count;
        ArrayList<PdfOutline> m1 = pdfOutline.m1();
        PdfOutline B1 = pdfOutline.B1();
        if (!m1.isEmpty()) {
            for (int i2 = 0; i2 < m1.size(); i2++) {
                z1(m1.get(i2));
            }
            if (B1 == null) {
                return;
            }
            if (pdfOutline.w1()) {
                count = pdfOutline.getCount() + B1.getCount();
            } else {
                B1.G1(B1.getCount() + 1);
                pdfOutline.G1(-pdfOutline.getCount());
                return;
            }
        } else if (B1 != null) {
            count = B1.getCount();
        } else {
            return;
        }
        B1.G1(count + 1);
    }
}
