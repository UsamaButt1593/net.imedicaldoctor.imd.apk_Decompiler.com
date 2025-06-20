package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.HyphenationEvent;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.draw.DrawInterface;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Chunk implements Element, IAccessibleElement {
    public static final String A3 = "ENCODING";
    public static final String B3 = "CHAR_SPACING";
    public static final String C3 = "WORD_SPACING";
    public static final String D3 = "WHITESPACE";
    public static final String a3 = "￼";
    public static final Chunk b3;
    public static final Chunk c3;
    public static final Chunk d3;
    public static final Chunk e3;
    public static final String f3 = "SEPARATOR";
    public static final String g3 = "TAB";
    public static final String h3 = "TABSETTINGS";
    public static final String i3 = "HSCALE";
    public static final String j3 = "UNDERLINE";
    public static final String k3 = "SUBSUPSCRIPT";
    public static final String l3 = "SKEW";
    public static final String m3 = "BACKGROUND";
    public static final String n3 = "TEXTRENDERMODE";
    public static final String o3 = "SPLITCHARACTER";
    public static final String p3 = "HYPHENATION";
    public static final String q3 = "REMOTEGOTO";
    public static final String r3 = "LOCALGOTO";
    public static final String s3 = "LOCALDESTINATION";
    public static final String t3 = "GENERICTAG";
    public static final String u3 = "LINEHEIGHT";
    public static final String v3 = "IMAGE";
    public static final String w3 = "ACTION";
    public static final String x3 = "NEWPAGE";
    public static final String y3 = "PDFANNOTATION";
    public static final String z3 = "COLOR";
    protected Font X;
    protected HashMap<PdfName, PdfObject> X2;
    protected HashMap<String, Object> Y;
    private AccessibleElementId Y2;
    protected PdfName Z;
    private String Z2;
    protected StringBuffer s;

    static {
        Chunk chunk = new Chunk(StringUtils.LF);
        b3 = chunk;
        chunk.o(PdfName.tc);
        Chunk chunk2 = new Chunk("");
        c3 = chunk2;
        chunk2.X();
        Float valueOf = Float.valueOf(Float.NaN);
        d3 = new Chunk(valueOf, false);
        e3 = new Chunk(valueOf, true);
    }

    public Chunk() {
        this.s = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.X2 = null;
        this.Y2 = null;
        this.Z2 = null;
        this.s = new StringBuffer();
        this.X = new Font();
        this.Z = PdfName.cf;
    }

    private Chunk I(String str, Object obj) {
        if (this.Y == null) {
            this.Y = new HashMap<>();
        }
        this.Y.put(str, obj);
        return this;
    }

    @Deprecated
    public static Chunk c() {
        return e(60.0f);
    }

    @Deprecated
    public static Chunk e(float f2) {
        return new Chunk(Float.valueOf(f2), true);
    }

    public static Chunk f(String str) {
        return g(str, false);
    }

    public static Chunk g(String str, boolean z) {
        if (z) {
            return new Chunk(str);
        }
        Chunk chunk = new Chunk(' ');
        chunk.I(D3, str);
        return chunk;
    }

    public boolean A() {
        return this.s.toString().trim().length() == 0 && this.s.toString().indexOf(StringUtils.LF) == -1 && this.Y == null;
    }

    @Deprecated
    public boolean B() {
        HashMap<String, Object> hashMap = this.Y;
        return hashMap != null && hashMap.containsKey(g3);
    }

    public boolean C() {
        HashMap<String, Object> hashMap = this.Y;
        return hashMap != null && hashMap.containsKey(D3);
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.Y2 = accessibleElementId;
    }

    public Chunk E(PdfAction pdfAction) {
        o(PdfName.Ca);
        return I(w3, pdfAction);
    }

    public Chunk F(String str) {
        o(PdfName.Ca);
        U(PdfName.J3, new PdfString(str));
        return I(w3, new PdfAction(str));
    }

    public Chunk G(URL url) {
        o(PdfName.Ca);
        String externalForm = url.toExternalForm();
        U(PdfName.J3, new PdfString(externalForm));
        return I(w3, new PdfAction(externalForm));
    }

    public Chunk H(PdfAnnotation pdfAnnotation) {
        return I(y3, pdfAnnotation);
    }

    public void J(HashMap<String, Object> hashMap) {
        this.Y = hashMap;
    }

    public Chunk K(BaseColor baseColor) {
        return M(baseColor, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public PdfName L() {
        return p() != null ? p().L() : this.Z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Chunk M(com.itextpdf.text.BaseColor r3, float r4, float r5, float r6, float r7) {
        /*
            r2 = this;
            r0 = 4
            float[] r0 = new float[r0]
            r1 = 0
            r0[r1] = r4
            r4 = 1
            r0[r4] = r5
            r5 = 2
            r0[r5] = r6
            r6 = 3
            r0[r6] = r7
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r1] = r3
            r5[r4] = r0
            java.lang.String r3 = "BACKGROUND"
            com.itextpdf.text.Chunk r3 = r2.I(r3, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Chunk.M(com.itextpdf.text.BaseColor, float, float, float, float):com.itextpdf.text.Chunk");
    }

    public Chunk N(float f2) {
        return I(B3, new Float(f2));
    }

    public void O(Font font) {
        this.X = font;
    }

    public Chunk P(String str) {
        return I(t3, str);
    }

    public Chunk Q(float f2) {
        return I(i3, new Float(f2));
    }

    public Chunk R(HyphenationEvent hyphenationEvent) {
        return I(p3, hyphenationEvent);
    }

    public Chunk S(float f2) {
        return I(u3, Float.valueOf(f2));
    }

    public Chunk T(String str) {
        return I(s3, str);
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (p() != null) {
            p().U(pdfName, pdfObject);
            return;
        }
        if (this.X2 == null) {
            this.X2 = new HashMap<>();
        }
        this.X2.put(pdfName, pdfObject);
    }

    public boolean V() {
        return true;
    }

    public Chunk W(String str) {
        return I(r3, str);
    }

    public Chunk X() {
        return I(x3, (Object) null);
    }

    public List<Chunk> Y() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        return arrayList;
    }

    public Chunk Z(String str, int i2) {
        return I(q3, new Object[]{str, Integer.valueOf(i2)});
    }

    public StringBuffer a(String str) {
        this.Z2 = null;
        StringBuffer stringBuffer = this.s;
        stringBuffer.append(str);
        return stringBuffer;
    }

    public Chunk a0(String str, String str2) {
        return I(q3, new Object[]{str, str2});
    }

    public Chunk b0(float f2, float f4) {
        return I(l3, new float[]{(float) Math.tan((((double) f2) * 3.141592653589793d) / 180.0d), (float) Math.tan((((double) f4) * 3.141592653589793d) / 180.0d)});
    }

    public Chunk c0(SplitCharacter splitCharacter) {
        return I(o3, splitCharacter);
    }

    public void d0(String str) {
        U(PdfName.c7, new PdfString(str));
    }

    public Chunk e0(int i2, float f2, BaseColor baseColor) {
        return I(n3, new Object[]{Integer.valueOf(i2), new Float(f2), baseColor});
    }

    public Chunk f0(float f2) {
        return I(k3, new Float(f2));
    }

    public Chunk g0(float f2, float f4) {
        return h0((BaseColor) null, f2, 0.0f, f4, 0.0f, 0);
    }

    public AccessibleElementId getId() {
        if (this.Y2 == null) {
            this.Y2 = new AccessibleElementId();
        }
        return this.Y2;
    }

    public HashMap<String, Object> h() {
        return this.Y;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Chunk h0(com.itextpdf.text.BaseColor r5, float r6, float r7, float r8, float r9, int r10) {
        /*
            r4 = this;
            r0 = 2
            r1 = 1
            r2 = 0
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r4.Y
            if (r3 != 0) goto L_0x000e
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r4.Y = r3
        L_0x000e:
            float r10 = (float) r10
            r3 = 5
            float[] r3 = new float[r3]
            r3[r2] = r6
            r3[r1] = r7
            r3[r0] = r8
            r6 = 3
            r3[r6] = r9
            r6 = 4
            r3[r6] = r10
            java.lang.Object[] r6 = new java.lang.Object[r0]
            r6[r2] = r5
            r6[r1] = r3
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r4.Y
            java.lang.String r7 = "UNDERLINE"
            java.lang.Object r5 = r5.get(r7)
            java.lang.Object[][] r5 = (java.lang.Object[][]) r5
            java.lang.Object[][] r5 = com.itextpdf.text.Utilities.a(r5, r6)
            com.itextpdf.text.Chunk r5 = r4.I(r7, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Chunk.h0(com.itextpdf.text.BaseColor, float, float, float, float, int):com.itextpdf.text.Chunk");
    }

    public float i() {
        HashMap<String, Object> hashMap = this.Y;
        if (hashMap == null || !hashMap.containsKey(B3)) {
            return 0.0f;
        }
        return ((Float) this.Y.get(B3)).floatValue();
    }

    public Chunk i0(float f2) {
        return I(C3, new Float(f2));
    }

    public String j() {
        if (this.Z2 == null) {
            this.Z2 = this.s.toString().replaceAll("\t", "");
        }
        return this.Z2;
    }

    public Font k() {
        return this.X;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return p() != null ? p().k0() : this.X2;
    }

    public float l() {
        Float f2;
        HashMap<String, Object> hashMap = this.Y;
        if (hashMap == null || (f2 = (Float) hashMap.get(i3)) == null) {
            return 1.0f;
        }
        return f2.floatValue();
    }

    public HyphenationEvent m() {
        HashMap<String, Object> hashMap = this.Y;
        if (hashMap == null) {
            return null;
        }
        return (HyphenationEvent) hashMap.get(p3);
    }

    public boolean n() {
        return true;
    }

    public void o(PdfName pdfName) {
        if (p() != null) {
            p().o(pdfName);
        } else {
            this.Z = pdfName;
        }
    }

    public Image p() {
        Object[] objArr;
        HashMap<String, Object> hashMap = this.Y;
        if (hashMap == null || (objArr = (Object[]) hashMap.get(v3)) == null) {
            return null;
        }
        return (Image) objArr[0];
    }

    public String q() {
        PdfObject r = r(PdfName.c7);
        if (r instanceof PdfString) {
            return ((PdfString) r).m0();
        }
        return null;
    }

    public PdfObject r(PdfName pdfName) {
        if (p() != null) {
            return p().r(pdfName);
        }
        HashMap<PdfName, PdfObject> hashMap = this.X2;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }

    public float s() {
        HashMap<String, Object> hashMap = this.Y;
        if (hashMap == null || !hashMap.containsKey(k3)) {
            return 0.0f;
        }
        return ((Float) this.Y.get(k3)).floatValue();
    }

    public boolean t(ElementListener elementListener) {
        try {
            return elementListener.b(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public String toString() {
        return j();
    }

    public int type() {
        return 10;
    }

    public float u() {
        return p() != null ? p().p1() : this.X.e(true).Z(j(), this.X.g()) * l();
    }

    public float v() {
        HashMap<String, Object> hashMap = this.Y;
        if (hashMap == null || !hashMap.containsKey(C3)) {
            return 0.0f;
        }
        return ((Float) this.Y.get(C3)).floatValue();
    }

    public boolean w() {
        HashMap<PdfName, PdfObject> hashMap = this.X2;
        return hashMap != null && !hashMap.isEmpty();
    }

    public boolean x() {
        return true;
    }

    public boolean y() {
        HashMap<String, Object> hashMap = this.Y;
        return hashMap != null && !hashMap.isEmpty();
    }

    public Chunk(char c2) {
        this(c2, new Font());
    }

    public Chunk(char c2, Font font) {
        this.s = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.X2 = null;
        this.Y2 = null;
        this.Z2 = null;
        StringBuffer stringBuffer = new StringBuffer();
        this.s = stringBuffer;
        stringBuffer.append(c2);
        this.X = font;
        this.Z = PdfName.cf;
    }

    public Chunk(Chunk chunk) {
        this.s = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.X2 = null;
        this.Y2 = null;
        this.Z2 = null;
        StringBuffer stringBuffer = chunk.s;
        if (stringBuffer != null) {
            this.s = new StringBuffer(stringBuffer.toString());
        }
        Font font = chunk.X;
        if (font != null) {
            this.X = new Font(font);
        }
        if (chunk.Y != null) {
            this.Y = new HashMap<>(chunk.Y);
        }
        this.Z = chunk.Z;
        if (chunk.X2 != null) {
            this.X2 = new HashMap<>(chunk.X2);
        }
        this.Y2 = chunk.getId();
    }

    public Chunk(Image image, float f2, float f4) {
        this("￼", new Font());
        Image Y0 = Image.Y0(image);
        Y0.V1(Float.NaN, Float.NaN);
        I(v3, new Object[]{Y0, new Float(f2), new Float(f4), Boolean.FALSE});
        this.Z = null;
    }

    public Chunk(Image image, float f2, float f4, boolean z) {
        this("￼", new Font());
        I(v3, new Object[]{image, new Float(f2), new Float(f4), Boolean.valueOf(z)});
        this.Z = PdfName.X3;
    }

    public Chunk(DrawInterface drawInterface) {
        this(drawInterface, false);
    }

    @Deprecated
    public Chunk(DrawInterface drawInterface, float f2) {
        this(drawInterface, f2, false);
    }

    @Deprecated
    public Chunk(DrawInterface drawInterface, float f2, boolean z) {
        this("￼", new Font());
        if (f2 >= 0.0f) {
            I(g3, new Object[]{drawInterface, new Float(f2), Boolean.valueOf(z), new Float(0.0f)});
            this.Z = PdfName.X3;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("a.tab.position.may.not.be.lower.than.0.yours.is.1", String.valueOf(f2)));
    }

    public Chunk(DrawInterface drawInterface, boolean z) {
        this("￼", new Font());
        I(f3, new Object[]{drawInterface, Boolean.valueOf(z)});
        this.Z = null;
    }

    private Chunk(Float f2, boolean z) {
        this("￼", new Font());
        if (f2.floatValue() >= 0.0f) {
            I(g3, new Object[]{f2, Boolean.valueOf(z)});
            I(o3, TabSplitCharacter.f25725a);
            I(h3, (Object) null);
            this.Z = PdfName.X3;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("a.tab.position.may.not.be.lower.than.0.yours.is.1", String.valueOf(f2)));
    }

    public Chunk(String str) {
        this(str, new Font());
    }

    public Chunk(String str, Font font) {
        this.s = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.X2 = null;
        this.Y2 = null;
        this.Z2 = null;
        this.s = new StringBuffer(str);
        this.X = font;
        this.Z = PdfName.cf;
    }
}
