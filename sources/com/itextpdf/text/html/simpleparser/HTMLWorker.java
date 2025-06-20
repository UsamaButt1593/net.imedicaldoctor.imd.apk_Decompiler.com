package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.TextElementArray;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandlerComment;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.apache.commons.lang3.StringUtils;

@Deprecated
public class HTMLWorker implements SimpleXMLDocHandler, DocListener {
    private static Logger i3 = LoggerFactory.b(HTMLWorker.class);
    public static final String j3 = "img_provider";
    public static final String k3 = "img_interface";
    public static final String l3 = "img_static";
    public static final String m3 = "img_baseurl";
    public static final String n3 = "font_factory";
    public static final String o3 = "alink_interface";
    protected Map<String, HTMLTagProcessor> X;
    protected Paragraph X2;
    private StyleSheet Y;
    private final ChainedProperties Y2;
    protected Stack<Element> Z;
    private Map<String, Object> Z2;
    private final ElementFactory a3;
    private final Stack<boolean[]> b3;
    private boolean c3;
    private boolean d3;
    private boolean e3;
    private boolean f3;
    protected boolean g3;
    protected List<Element> h3;
    protected DocListener s;

    public HTMLWorker(DocListener docListener) {
        this(docListener, (Map<String, HTMLTagProcessor>) null, (StyleSheet) null);
    }

    public static List<Element> C(Reader reader, StyleSheet styleSheet) throws IOException {
        return D(reader, styleSheet, (HashMap<String, Object>) null);
    }

    public static List<Element> D(Reader reader, StyleSheet styleSheet, HashMap<String, Object> hashMap) throws IOException {
        return E(reader, styleSheet, (Map<String, HTMLTagProcessor>) null, hashMap);
    }

    public static List<Element> E(Reader reader, StyleSheet styleSheet, Map<String, HTMLTagProcessor> map, HashMap<String, Object> hashMap) throws IOException {
        HTMLWorker hTMLWorker = new HTMLWorker((DocListener) null, map, styleSheet);
        hTMLWorker.s = hTMLWorker;
        hTMLWorker.T(hashMap);
        hTMLWorker.h3 = new ArrayList();
        hTMLWorker.B(reader);
        return hTMLWorker.h3;
    }

    public void A() {
        if (this.X2 == null) {
            this.X2 = new Paragraph();
        }
        this.X2.add(l(StringUtils.LF));
    }

    public void B(Reader reader) throws IOException {
        i3.f("Please note, there is a more extended version of the HTMLWorker available in the iText XMLWorker");
        SimpleXMLParser.g(this, (SimpleXMLDocHandlerComment) null, reader, true);
    }

    public void F() {
        boolean[] pop = this.b3.pop();
        this.c3 = pop[0];
        this.d3 = pop[1];
    }

    public void G(Image image, Map<String, String> map) throws DocumentException {
        ImageProcessor imageProcessor = (ImageProcessor) this.Z2.get(k3);
        if (imageProcessor == null || !imageProcessor.a(image, map, this.Y2, this.s)) {
            String str = map.get("align");
            if (str != null) {
                h();
            }
            if (this.X2 == null) {
                this.X2 = q();
            }
            this.X2.add(new Chunk(image, 0.0f, 0.0f, true));
            this.X2.O1(HtmlUtilities.a(str));
            if (str != null) {
                h();
            }
        }
    }

    public void H() {
        Paragraph paragraph;
        String c2;
        if (this.X2 == null) {
            this.X2 = new Paragraph();
        }
        LinkProcessor linkProcessor = (LinkProcessor) this.Z2.get(o3);
        if ((linkProcessor == null || !linkProcessor.a(this.X2, this.Y2)) && (c2 = this.Y2.c("href")) != null) {
            for (Chunk F : this.X2.Y()) {
                F.F(c2);
            }
        }
        if (this.Z.isEmpty()) {
            paragraph = new Paragraph(new Phrase((Phrase) this.X2));
        } else {
            paragraph = (Paragraph) this.Z.pop();
            paragraph.add(new Phrase((Phrase) this.X2));
        }
        this.X2 = paragraph;
    }

    public void I() throws DocumentException {
        if (!this.Z.empty()) {
            Element pop = this.Z.pop();
            if (!(pop instanceof com.itextpdf.text.List)) {
                this.Z.push(pop);
            } else if (this.Z.empty()) {
                this.s.b(pop);
            } else {
                ((TextElementArray) this.Z.peek()).b(pop);
            }
        }
    }

    public void J() throws DocumentException {
        if (!this.Z.empty()) {
            Element pop = this.Z.pop();
            if (!(pop instanceof ListItem)) {
                this.Z.push(pop);
            } else if (this.Z.empty()) {
                this.s.b(pop);
            } else {
                ListItem listItem = (ListItem) pop;
                Element pop2 = this.Z.pop();
                if (!(pop2 instanceof com.itextpdf.text.List)) {
                    this.Z.push(pop2);
                    return;
                }
                ((com.itextpdf.text.List) pop2).b(listItem);
                listItem.d2();
                this.Z.push(pop2);
            }
        }
    }

    public void K() {
        Element pop;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        boolean z = false;
        float f2 = 0.0f;
        int i4 = 0;
        do {
            pop = this.Z.pop();
            if (pop instanceof CellWrapper) {
                CellWrapper cellWrapper = (CellWrapper) pop;
                float e2 = cellWrapper.e();
                arrayList2.add(new Float(e2));
                z |= cellWrapper.f();
                if (e2 == 0.0f) {
                    i4++;
                } else {
                    f2 += e2;
                }
                arrayList.add(cellWrapper.c());
            }
        } while (!(pop instanceof TableWrapper));
        TableWrapper tableWrapper = (TableWrapper) pop;
        tableWrapper.a(arrayList);
        if (arrayList2.size() > 0) {
            float f4 = 100.0f - f2;
            Collections.reverse(arrayList2);
            int size = arrayList2.size();
            float[] fArr = new float[size];
            while (true) {
                if (i2 >= size) {
                    tableWrapper.e(fArr);
                    break;
                }
                float floatValue = ((Float) arrayList2.get(i2)).floatValue();
                fArr[i2] = floatValue;
                if (floatValue == 0.0f && z && i4 > 0) {
                    fArr[i2] = f4 / ((float) i4);
                }
                if (fArr[i2] == 0.0f) {
                    break;
                }
                i2++;
            }
        }
        this.Z.push(tableWrapper);
    }

    public void L() throws DocumentException {
        PdfPTable c2 = ((TableWrapper) this.Z.pop()).c();
        c2.U0(true);
        if (this.Z.empty()) {
            this.s.b(c2);
        } else {
            ((TextElementArray) this.Z.peek()).b(c2);
        }
    }

    public void M() {
        this.b3.push(new boolean[]{this.c3, this.d3});
    }

    public void N(Element element) {
        if (element != null) {
            this.Z.push(element);
        }
    }

    public void O(boolean z) {
        this.f3 = z;
    }

    @Deprecated
    public void P(HashMap<String, Object> hashMap) {
        T(hashMap);
    }

    public void Q(boolean z) {
        this.e3 = z;
    }

    public void R(boolean z) {
        this.d3 = z;
    }

    public void S(boolean z) {
        this.c3 = z;
    }

    public void T(Map<String, Object> map) {
        if (map != null) {
            this.Z2 = map;
            FontProvider fontProvider = (FontProvider) map.get(n3);
            if (fontProvider != null) {
                this.a3.j(fontProvider);
            }
        }
    }

    public void U(boolean z) {
        this.g3 = z;
    }

    public void V(StyleSheet styleSheet) {
        if (styleSheet == null) {
            styleSheet = new StyleSheet();
        }
        this.Y = styleSheet;
    }

    public void W(Map<String, HTMLTagProcessor> map) {
        if (map == null) {
            map = new HTMLTagProcessors();
        }
        this.X = map;
    }

    public void X(String str) {
        this.Y2.e(str);
    }

    public void Y(String str, Map<String, String> map) {
        this.Y2.a(str, map);
    }

    public void a(String str) {
        if (!this.g3) {
            if (this.X2 == null) {
                this.X2 = q();
            }
            if (!this.f3) {
                if (str.trim().length() != 0 || str.indexOf(32) >= 0) {
                    str = HtmlUtilities.c(str);
                } else {
                    return;
                }
            }
            this.X2.add(l(str));
        }
    }

    public boolean b(Element element) throws DocumentException {
        this.h3.add(element);
        return true;
    }

    public boolean c(boolean z) {
        return false;
    }

    public void close() {
    }

    public void d(String str) {
        HTMLTagProcessor hTMLTagProcessor = this.X.get(str);
        if (hTMLTagProcessor != null) {
            try {
                hTMLTagProcessor.b(this, str);
            } catch (DocumentException e2) {
                throw new ExceptionConverter(e2);
            }
        }
    }

    public void e(String str, Map<String, String> map) {
        HTMLTagProcessor hTMLTagProcessor = this.X.get(str);
        if (hTMLTagProcessor != null) {
            this.Y.a(str, map);
            StyleSheet.f(map, this.Y2);
            try {
                hTMLTagProcessor.a(this, str, map);
            } catch (DocumentException e2) {
                throw new ExceptionConverter(e2);
            } catch (IOException e4) {
                throw new ExceptionConverter(e4);
            }
        }
    }

    public void endDocument() {
        int i2 = 0;
        while (i2 < this.Z.size()) {
            try {
                this.s.b(this.Z.elementAt(i2));
                i2++;
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        }
        Paragraph paragraph = this.X2;
        if (paragraph != null) {
            this.s.b(paragraph);
        }
        this.X2 = null;
    }

    public boolean f() {
        return true;
    }

    public boolean g(boolean z) {
        return false;
    }

    public void h() throws DocumentException {
        if (this.X2 != null) {
            if (this.Z.empty()) {
                this.s.b(this.X2);
            } else {
                Element pop = this.Z.pop();
                if (pop instanceof TextElementArray) {
                    ((TextElementArray) pop).b(this.X2);
                }
                this.Z.push(pop);
            }
            this.X2 = null;
        }
    }

    public CellWrapper i(String str) {
        return new CellWrapper(str, this.Y2);
    }

    public boolean j(Rectangle rectangle) {
        return true;
    }

    public boolean k(float f2, float f4, float f5, float f6) {
        return true;
    }

    public Chunk l(String str) {
        return this.a3.a(str, this.Y2);
    }

    public Image m(Map<String, String> map) throws DocumentException, IOException {
        String str = map.get("src");
        if (str == null) {
            return null;
        }
        return this.a3.b(str, map, this.Y2, this.s, (ImageProvider) this.Z2.get(j3), (ImageStore) this.Z2.get(l3), (String) this.Z2.get(m3));
    }

    public LineSeparator n(Map<String, String> map) {
        return this.a3.c(map, this.X2.z0() / 2.0f);
    }

    public com.itextpdf.text.List o(String str) {
        return this.a3.d(str, this.Y2);
    }

    public void open() {
    }

    public ListItem p() {
        return this.a3.e(this.Y2);
    }

    public Paragraph q() {
        return this.a3.f(this.Y2);
    }

    public void r() {
        N(this.X2);
        this.X2 = new Paragraph();
    }

    public void s() {
    }

    public void startDocument() {
        HashMap hashMap = new HashMap();
        this.Y.a("body", hashMap);
        this.Y2.a("body", hashMap);
    }

    public void t(int i2) {
    }

    @Deprecated
    public Map<String, Object> u() {
        return this.Z2;
    }

    public boolean v() {
        return this.f3;
    }

    public boolean w() {
        return this.e3;
    }

    public boolean x() {
        return this.d3;
    }

    public boolean y() {
        return this.c3;
    }

    public boolean z() {
        return this.g3;
    }

    public HTMLWorker(DocListener docListener, Map<String, HTMLTagProcessor> map, StyleSheet styleSheet) {
        this.Y = new StyleSheet();
        this.Z = new Stack<>();
        this.Y2 = new ChainedProperties();
        this.Z2 = new HashMap();
        this.a3 = new ElementFactory();
        this.b3 = new Stack<>();
        this.c3 = false;
        this.d3 = false;
        this.e3 = false;
        this.f3 = false;
        this.g3 = false;
        this.s = docListener;
        W(map);
        V(styleSheet);
    }
}
