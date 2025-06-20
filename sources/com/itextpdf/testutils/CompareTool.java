package com.itextpdf.testutils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Meta;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfContentParser;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfLiteral;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.RefKey;
import com.itextpdf.text.pdf.parser.ContentByteUtils;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.InlineImageInfo;
import com.itextpdf.text.pdf.parser.InlineImageUtils;
import com.itextpdf.text.pdf.parser.PdfContentStreamProcessor;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TaggedPdfReaderTool;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.xmp.PdfProperties;
import com.itextpdf.text.xml.xmp.XmpBasicProperties;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMeta;
import com.itextpdf.xmp.XMPMetaFactory;
import com.itextpdf.xmp.XMPUtils;
import com.itextpdf.xmp.options.SerializeOptions;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class CompareTool {
    private static final String t = "Cannot open target directory for <filename>.";
    private static final String u = "GhostScript failed for <filename>.";
    private static final String v = "Unexpected number of pages for <filename>.";
    private static final String w = "File <filename> differs on page <pagenumber>.";
    private static final String x = "Path to GhostScript is not specified. Please use -DgsExec=<path_to_ghostscript> (e.g. -DgsExec=\"C:/Program Files/gs/gs9.14/bin/gswin32c.exe\")";
    private static final String y = "ignored_areas_";

    /* renamed from: a  reason: collision with root package name */
    private String f25634a = System.getProperty("gsExec");

    /* renamed from: b  reason: collision with root package name */
    private String f25635b = System.getProperty("compareExec");

    /* renamed from: c  reason: collision with root package name */
    private final String f25636c = " -dNOPAUSE -dBATCH -sDEVICE=png16m -r150 -sOutputFile=<outputfile> <inputfile>";

    /* renamed from: d  reason: collision with root package name */
    private final String f25637d = " \"<image1>\" \"<image2>\" \"<difference>\"";

    /* renamed from: e  reason: collision with root package name */
    private String f25638e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f25639f;

    /* renamed from: g  reason: collision with root package name */
    private String f25640g;

    /* renamed from: h  reason: collision with root package name */
    private String f25641h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f25642i;

    /* renamed from: j  reason: collision with root package name */
    private String f25643j;

    /* renamed from: k  reason: collision with root package name */
    List<PdfDictionary> f25644k;

    /* renamed from: l  reason: collision with root package name */
    List<RefKey> f25645l;

    /* renamed from: m  reason: collision with root package name */
    List<PdfDictionary> f25646m;

    /* renamed from: n  reason: collision with root package name */
    List<RefKey> f25647n;
    private int o = 1;
    private boolean p = false;
    private String q = "report";
    private double r = 0.0d;
    private boolean s = true;

    class CmpMarkedContentRenderFilter implements RenderListener {

        /* renamed from: a  reason: collision with root package name */
        Map<Integer, TextExtractionStrategy> f25648a = new HashMap();

        CmpMarkedContentRenderFilter() {
        }

        public void a() {
            for (Integer next : this.f25648a.keySet()) {
                next.intValue();
                this.f25648a.get(next).a();
            }
        }

        public void c(ImageRenderInfo imageRenderInfo) {
        }

        public void e(TextRenderInfo textRenderInfo) {
            Integer k2 = textRenderInfo.k();
            if (k2 == null || !this.f25648a.containsKey(k2)) {
                if (k2 != null) {
                    this.f25648a.put(k2, new SimpleTextExtractionStrategy());
                } else {
                    return;
                }
            }
            this.f25648a.get(k2).e(textRenderInfo);
        }

        public void h() {
            for (Integer next : this.f25648a.keySet()) {
                next.intValue();
                this.f25648a.get(next).h();
            }
        }

        public Map<Integer, String> i() {
            HashMap hashMap = new HashMap();
            for (Integer next : this.f25648a.keySet()) {
                next.intValue();
                hashMap.put(next, this.f25648a.get(next).g());
            }
            return hashMap;
        }
    }

    class CmpPngFileFilter implements FileFilter {
        CmpPngFileFilter() {
        }

        public boolean accept(File file) {
            String absolutePath = file.getAbsolutePath();
            return absolutePath.endsWith(".png") && absolutePath.contains("cmp_") && absolutePath.contains(CompareTool.this.f25639f);
        }
    }

    class CmpTaggedPdfReaderTool extends TaggedPdfReaderTool {

        /* renamed from: c  reason: collision with root package name */
        Map<PdfDictionary, Map<Integer, String>> f25651c = new HashMap();

        CmpTaggedPdfReaderTool() {
        }

        public void f(PdfDictionary pdfDictionary) throws IOException {
            g(pdfDictionary, true);
        }

        public void h(String str, PdfObject pdfObject, PdfDictionary pdfDictionary) throws IOException {
            if (pdfObject instanceof PdfNumber) {
                if (!this.f25651c.containsKey(pdfDictionary)) {
                    CmpMarkedContentRenderFilter cmpMarkedContentRenderFilter = new CmpMarkedContentRenderFilter();
                    new PdfContentStreamProcessor(cmpMarkedContentRenderFilter).Q(PdfReader.g0(pdfDictionary), pdfDictionary.j0(PdfName.Wd));
                    this.f25651c.put(pdfDictionary, cmpMarkedContentRenderFilter.i());
                }
                PdfNumber pdfNumber = (PdfNumber) pdfObject;
                this.f27051b.print(XMLUtil.a(this.f25651c.get(pdfDictionary).containsKey(Integer.valueOf(pdfNumber.e0())) ? (String) this.f25651c.get(pdfDictionary).get(Integer.valueOf(pdfNumber.e0())) : "", true));
                return;
            }
            super.h(str, pdfObject, pdfDictionary);
        }
    }

    protected class CompareResult {

        /* renamed from: a  reason: collision with root package name */
        protected Map<ObjectPath, String> f25653a = new LinkedHashMap();

        /* renamed from: b  reason: collision with root package name */
        protected int f25654b;

        public CompareResult(int i2) {
            this.f25654b = i2;
        }

        /* access modifiers changed from: protected */
        public void a(ObjectPath objectPath, String str) {
            if (this.f25653a.size() < this.f25654b) {
                this.f25653a.put((ObjectPath) objectPath.clone(), str);
            }
        }

        public int b() {
            return this.f25653a.size();
        }

        public String c() {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (Map.Entry next : this.f25653a.entrySet()) {
                if (!z) {
                    sb.append("-----------------------------");
                    sb.append(StringUtils.LF);
                }
                sb.append((String) next.getValue());
                sb.append(StringUtils.LF);
                sb.append(((ObjectPath) next.getKey()).toString());
                sb.append(StringUtils.LF);
                z = false;
            }
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public boolean d() {
            return this.f25653a.size() >= this.f25654b;
        }

        public boolean e() {
            return this.f25653a.size() == 0;
        }

        public void f(OutputStream outputStream) throws ParserConfigurationException, TransformerException {
            Document newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element createElement = newDocument.createElement("report");
            Element createElement2 = newDocument.createElement("errors");
            createElement2.setAttribute("count", String.valueOf(this.f25653a.size()));
            createElement.appendChild(createElement2);
            for (Map.Entry next : this.f25653a.entrySet()) {
                Element createElement3 = newDocument.createElement("error");
                Element createElement4 = newDocument.createElement("message");
                createElement4.appendChild(newDocument.createTextNode((String) next.getValue()));
                Node g2 = ((ObjectPath) next.getKey()).g(newDocument);
                createElement3.appendChild(createElement4);
                createElement3.appendChild(g2);
                createElement2.appendChild(createElement3);
            }
            newDocument.appendChild(createElement);
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.transform(new DOMSource(newDocument), new StreamResult(outputStream));
        }
    }

    class ImageNameComparator implements Comparator<File> {
        ImageNameComparator() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return file.getAbsolutePath().compareTo(file2.getAbsolutePath());
        }
    }

    private class ObjectPath {

        /* renamed from: a  reason: collision with root package name */
        protected RefKey f25656a;

        /* renamed from: b  reason: collision with root package name */
        protected RefKey f25657b;

        /* renamed from: c  reason: collision with root package name */
        protected Stack<PathItem> f25658c = new Stack<>();

        /* renamed from: d  reason: collision with root package name */
        protected Stack<Pair<RefKey>> f25659d = new Stack<>();

        private class ArrayPathItem extends PathItem {

            /* renamed from: b  reason: collision with root package name */
            int f25661b;

            public ArrayPathItem(int i2) {
                super();
                this.f25661b = i2;
            }

            /* access modifiers changed from: protected */
            public Node a(Document document) {
                Element createElement = document.createElement("arrayIndex");
                createElement.appendChild(document.createTextNode(String.valueOf(this.f25661b)));
                return createElement;
            }

            public boolean equals(Object obj) {
                return (obj instanceof ArrayPathItem) && this.f25661b == ((ArrayPathItem) obj).f25661b;
            }

            public int hashCode() {
                return this.f25661b;
            }

            public String toString() {
                return "Array index: " + String.valueOf(this.f25661b);
            }
        }

        private class DictPathItem extends PathItem {

            /* renamed from: b  reason: collision with root package name */
            String f25663b;

            public DictPathItem(String str) {
                super();
                this.f25663b = str;
            }

            /* access modifiers changed from: protected */
            public Node a(Document document) {
                Element createElement = document.createElement("dictKey");
                createElement.appendChild(document.createTextNode(this.f25663b));
                return createElement;
            }

            public boolean equals(Object obj) {
                return (obj instanceof DictPathItem) && this.f25663b.equals(((DictPathItem) obj).f25663b);
            }

            public int hashCode() {
                return this.f25663b.hashCode();
            }

            public String toString() {
                return "Dict key: " + this.f25663b;
            }
        }

        private class OffsetPathItem extends PathItem {

            /* renamed from: b  reason: collision with root package name */
            int f25665b;

            public OffsetPathItem(int i2) {
                super();
                this.f25665b = i2;
            }

            /* access modifiers changed from: protected */
            public Node a(Document document) {
                Element createElement = document.createElement(TypedValues.CycleType.R);
                createElement.appendChild(document.createTextNode(String.valueOf(this.f25665b)));
                return createElement;
            }

            public boolean equals(Object obj) {
                return (obj instanceof OffsetPathItem) && this.f25665b == ((OffsetPathItem) obj).f25665b;
            }

            public int hashCode() {
                return this.f25665b;
            }

            public String toString() {
                return "Offset: " + String.valueOf(this.f25665b);
            }
        }

        private class Pair<T> {

            /* renamed from: a  reason: collision with root package name */
            private T f25667a;

            /* renamed from: b  reason: collision with root package name */
            private T f25668b;

            public Pair(T t, T t2) {
                this.f25667a = t;
                this.f25668b = t2;
            }

            public boolean equals(Object obj) {
                if (obj instanceof Pair) {
                    Pair pair = (Pair) obj;
                    return this.f25667a.equals(pair.f25667a) && this.f25668b.equals(pair.f25668b);
                }
            }

            public int hashCode() {
                return (this.f25667a.hashCode() * 31) + this.f25668b.hashCode();
            }
        }

        private abstract class PathItem {
            private PathItem() {
            }

            /* access modifiers changed from: protected */
            public abstract Node a(Document document);
        }

        public ObjectPath() {
        }

        public boolean a(RefKey refKey, RefKey refKey2) {
            return this.f25659d.contains(new Pair(refKey, refKey2));
        }

        public void b() {
            this.f25658c.pop();
        }

        public void c(int i2) {
            this.f25658c.add(new ArrayPathItem(i2));
        }

        /* access modifiers changed from: protected */
        public Object clone() {
            return new ObjectPath(this.f25656a, this.f25657b, (Stack) this.f25658c.clone());
        }

        public void d(String str) {
            this.f25658c.add(new DictPathItem(str));
        }

        public void e(int i2) {
            this.f25658c.add(new OffsetPathItem(i2));
        }

        public boolean equals(Object obj) {
            if (obj instanceof ObjectPath) {
                ObjectPath objectPath = (ObjectPath) obj;
                return this.f25656a.equals(objectPath.f25656a) && this.f25657b.equals(objectPath.f25657b) && this.f25658c.equals(objectPath.f25658c);
            }
        }

        public ObjectPath f(RefKey refKey, RefKey refKey2) {
            ObjectPath objectPath = new ObjectPath(refKey, refKey2);
            Stack<Pair<RefKey>> stack = (Stack) this.f25659d.clone();
            objectPath.f25659d = stack;
            stack.add(new Pair(refKey, refKey2));
            return objectPath;
        }

        public Node g(Document document) {
            Element createElement = document.createElement(Cookie2.PATH);
            Element createElement2 = document.createElement("base");
            createElement2.setAttribute("cmp", this.f25656a.toString() + " obj");
            createElement2.setAttribute("out", this.f25657b.toString() + " obj");
            createElement.appendChild(createElement2);
            Iterator<PathItem> it2 = this.f25658c.iterator();
            while (it2.hasNext()) {
                createElement.appendChild(it2.next().a(document));
            }
            return createElement;
        }

        public int hashCode() {
            RefKey refKey = this.f25656a;
            int i2 = 1;
            int hashCode = refKey != null ? refKey.hashCode() : 1;
            RefKey refKey2 = this.f25657b;
            if (refKey2 != null) {
                i2 = refKey2.hashCode();
            }
            int i3 = (hashCode * 31) + i2;
            Iterator<PathItem> it2 = this.f25658c.iterator();
            while (it2.hasNext()) {
                i3 = (i3 * 31) + it2.next().hashCode();
            }
            return i3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Base cmp object: %s obj. Base out object: %s obj", new Object[]{this.f25656a, this.f25657b}));
            Iterator<PathItem> it2 = this.f25658c.iterator();
            while (it2.hasNext()) {
                sb.append(StringUtils.LF);
                sb.append(it2.next().toString());
            }
            return sb.toString();
        }

        protected ObjectPath(RefKey refKey, RefKey refKey2) {
            this.f25656a = refKey;
            this.f25657b = refKey2;
        }

        private ObjectPath(RefKey refKey, RefKey refKey2, Stack<PathItem> stack) {
            this.f25656a = refKey;
            this.f25657b = refKey2;
            this.f25658c = stack;
        }
    }

    class PngFileFilter implements FileFilter {
        PngFileFilter() {
        }

        public boolean accept(File file) {
            String absolutePath = file.getAbsolutePath();
            return absolutePath.endsWith(".png") && !absolutePath.contains("cmp_") && absolutePath.contains(CompareTool.this.f25642i);
        }
    }

    private boolean B(PdfNumber pdfNumber, PdfNumber pdfNumber2, ObjectPath objectPath, CompareResult compareResult) {
        if (A(pdfNumber, pdfNumber2)) {
            return true;
        }
        if (!(compareResult == null || objectPath == null)) {
            compareResult.a(objectPath, String.format("PdfNumber. Expected: %s. Found: %s", new Object[]{pdfNumber2, pdfNumber}));
        }
        return false;
    }

    private boolean C(PdfObject pdfObject, PdfObject pdfObject2, ObjectPath objectPath, CompareResult compareResult) throws IOException {
        String format;
        PdfObject t0 = PdfReader.t0(pdfObject);
        PdfObject t02 = PdfReader.t0(pdfObject2);
        if (t02 == null && t0 == null) {
            return true;
        }
        if (t0 == null) {
            format = "Expected object was not found.";
        } else if (t02 == null) {
            format = "Found object which was not expected to be found.";
        } else if (t02.W() != t0.W()) {
            format = String.format("Types do not match. Expected: %s. Found: %s.", new Object[]{t02.getClass().getSimpleName(), t0.getClass().getSimpleName()});
        } else {
            if (pdfObject2.C() && pdfObject.C()) {
                PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) pdfObject2;
                PdfIndirectReference pdfIndirectReference2 = (PdfIndirectReference) pdfObject;
                if (objectPath.a(new RefKey(pdfIndirectReference), new RefKey(pdfIndirectReference2))) {
                    return true;
                }
                objectPath = objectPath.f(new RefKey(pdfIndirectReference), new RefKey(pdfIndirectReference2));
            }
            if (!t02.z() || !((PdfDictionary) t02).P0()) {
                if (t02.z()) {
                    if (!s((PdfDictionary) t0, (PdfDictionary) t02, objectPath, compareResult)) {
                        return false;
                    }
                } else if (t02.K()) {
                    if (!F((PRStream) t0, (PRStream) t02, objectPath, compareResult)) {
                        return false;
                    }
                } else if (t02.q()) {
                    if (!i((PdfArray) t0, (PdfArray) t02, objectPath, compareResult)) {
                        return false;
                    }
                } else if (t02.E()) {
                    if (!z((PdfName) t0, (PdfName) t02, objectPath, compareResult)) {
                        return false;
                    }
                } else if (t02.I()) {
                    if (!B((PdfNumber) t0, (PdfNumber) t02, objectPath, compareResult)) {
                        return false;
                    }
                } else if (t02.N()) {
                    if (!H((PdfString) t0, (PdfString) t02, objectPath, compareResult)) {
                        return false;
                    }
                } else if (t02.x()) {
                    if (!k((PdfBoolean) t0, (PdfBoolean) t02, objectPath, compareResult)) {
                        return false;
                    }
                } else if (t02 instanceof PdfLiteral) {
                    if (!x((PdfLiteral) t0, (PdfLiteral) t02, objectPath, compareResult)) {
                        return false;
                    }
                } else if (!t0.H() || !t02.H()) {
                    throw new UnsupportedOperationException();
                }
                return true;
            } else if (!t0.z() || !((PdfDictionary) t0).P0()) {
                if (!(compareResult == null || objectPath == null)) {
                    compareResult.a(objectPath, "Expected a page. Found not a page.");
                }
                return false;
            } else {
                RefKey refKey = new RefKey((PdfIndirectReference) (PRIndirectReference) pdfObject2);
                RefKey refKey2 = new RefKey((PdfIndirectReference) (PRIndirectReference) pdfObject);
                if (this.f25647n.contains(refKey) && this.f25647n.indexOf(refKey) == this.f25645l.indexOf(refKey2)) {
                    return true;
                }
                if (!(compareResult == null || objectPath == null)) {
                    compareResult.a(objectPath, String.format("The dictionaries refer to different pages. Expected page number: %s. Found: %s", new Object[]{Integer.valueOf(this.f25647n.indexOf(refKey)), Integer.valueOf(this.f25645l.indexOf(refKey2))}));
                }
                return false;
            }
        }
        compareResult.a(objectPath, format);
        return false;
    }

    private boolean E(InputStream inputStream, InputStream inputStream2) throws IOException {
        int read;
        byte[] bArr = new byte[65536];
        byte[] bArr2 = new byte[65536];
        do {
            read = inputStream.read(bArr);
            if (read != inputStream2.read(bArr2) || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } while (read != -1);
        return true;
    }

    private boolean F(PRStream pRStream, PRStream pRStream2, ObjectPath objectPath, CompareResult compareResult) throws IOException {
        byte[] bArr;
        PRStream pRStream3 = pRStream;
        PRStream pRStream4 = pRStream2;
        ObjectPath objectPath2 = objectPath;
        CompareResult compareResult2 = compareResult;
        boolean equals = PdfName.j8.equals(pRStream3.d0(PdfName.T7));
        byte[] F0 = PdfReader.F0(pRStream);
        byte[] F02 = PdfReader.F0(pRStream2);
        if (equals) {
            F0 = PdfReader.q(F0, pRStream3);
            F02 = PdfReader.q(F02, pRStream4);
        }
        if (this.r != 0.0d) {
            PdfName pdfName = PdfName.ai;
            PdfName pdfName2 = PdfName.Kg;
            if (pdfName.equals(pRStream4.B0(pdfName2)) && pdfName.equals(pRStream3.B0(pdfName2))) {
                PdfName pdfName3 = PdfName.w8;
                PdfName pdfName4 = PdfName.Cf;
                if (pdfName3.equals(pRStream4.B0(pdfName4)) && pdfName3.equals(pRStream3.B0(pdfName4))) {
                    PdfName pdfName5 = PdfName.Wd;
                    return q(pRStream, pRStream2, pRStream3.j0(pdfName5), pRStream4.j0(pdfName5), objectPath, compareResult) && s(pRStream, pRStream2, objectPath, compareResult);
                }
            }
        }
        if (Arrays.equals(F0, F02)) {
            return s(pRStream, pRStream2, objectPath, compareResult);
        }
        if (F02.length == F0.length) {
            int i2 = 0;
            while (i2 < F02.length) {
                if (F02[i2] != F0[i2]) {
                    int max = Math.max(0, i2 - 10);
                    int min = Math.min(F02.length, i2 + 10);
                    if (!(compareResult2 == null || objectPath2 == null)) {
                        objectPath2.e(i2);
                        int i3 = min - max;
                        bArr = F02;
                        compareResult2.a(objectPath2, String.format("PRStream. The bytes differ at index %s. Expected: %s (%s). Found: %s (%s)", new Object[]{Integer.valueOf(i2), new String(new byte[]{F02[i2]}), new String(F02, max, i3).replaceAll("\\n", "\\\\n"), new String(new byte[]{F0[i2]}), new String(F0, max, i3).replaceAll("\\n", "\\\\n")}));
                        objectPath.b();
                        i2++;
                        F02 = bArr;
                    }
                }
                bArr = F02;
                i2++;
                F02 = bArr;
            }
        } else if (!(compareResult2 == null || objectPath2 == null)) {
            compareResult2.a(objectPath2, String.format("PRStream. Lengths are different. Expected: %s. Found: %s", new Object[]{Integer.valueOf(F02.length), Integer.valueOf(F0.length)}));
        }
        return false;
    }

    private boolean H(PdfString pdfString, PdfString pdfString2, ObjectPath objectPath, CompareResult compareResult) {
        if (Arrays.equals(pdfString2.k(), pdfString.k())) {
            return true;
        }
        String m0 = pdfString2.m0();
        String m02 = pdfString.m0();
        if (m0.length() == m02.length()) {
            int i2 = 0;
            while (true) {
                if (i2 >= m0.length()) {
                    break;
                } else if (m0.charAt(i2) != m02.charAt(i2)) {
                    int max = Math.max(0, i2 - 10);
                    int min = Math.min(m0.length(), i2 + 10);
                    if (compareResult != null && objectPath != null) {
                        objectPath.e(i2);
                        compareResult.a(objectPath, String.format("PdfString. Characters differ at position %s. Expected: %s (%s). Found: %s (%s).", new Object[]{Integer.valueOf(i2), Character.toString(m0.charAt(i2)), m0.substring(max, min).replace(StringUtils.LF, "\\n"), Character.toString(m02.charAt(i2)), m02.substring(max, min).replace(StringUtils.LF, "\\n")}));
                        objectPath.b();
                    }
                } else {
                    i2++;
                }
            }
        } else if (!(compareResult == null || objectPath == null)) {
            compareResult.a(objectPath, String.format("PdfString. Lengths are different. Expected: %s. Found: %s", new Object[]{Integer.valueOf(m0.length()), Integer.valueOf(m02.length())}));
        }
        return false;
    }

    private String[] P(HashMap<String, String> hashMap) {
        String[] strArr = {"", "", "", ""};
        for (Map.Entry next : hashMap.entrySet()) {
            if ("title".equalsIgnoreCase((String) next.getKey())) {
                strArr[0] = (String) next.getValue();
            } else if (Meta.Y2.equalsIgnoreCase((String) next.getKey())) {
                strArr[1] = (String) next.getValue();
            } else if ("subject".equalsIgnoreCase((String) next.getKey())) {
                strArr[2] = (String) next.getValue();
            } else if (Meta.Z2.equalsIgnoreCase((String) next.getKey())) {
                strArr[3] = (String) next.getValue();
            }
        }
        return strArr;
    }

    private void R(String str, String str2) {
        StringBuilder sb;
        this.f25641h = str;
        this.f25638e = str2;
        this.f25642i = new File(str).getName();
        this.f25639f = new File(str2).getName();
        this.f25643j = this.f25642i + "-%03d.png";
        if (this.f25639f.startsWith("cmp_")) {
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder();
            sb.append("cmp_");
        }
        sb.append(this.f25639f);
        sb.append("-%03d.png");
        this.f25640g = sb.toString();
    }

    private boolean S(PdfAnnotation.PdfImportedLink pdfImportedLink, PdfAnnotation.PdfImportedLink pdfImportedLink2) {
        if (pdfImportedLink.c() != pdfImportedLink2.c() || !pdfImportedLink.e().toString().equals(pdfImportedLink2.e().toString())) {
            return false;
        }
        Map<PdfName, PdfObject> d2 = pdfImportedLink.d();
        Map<PdfName, PdfObject> d3 = pdfImportedLink2.d();
        if (d2.size() != d3.size()) {
            return false;
        }
        for (Map.Entry next : d2.entrySet()) {
            PdfObject pdfObject = (PdfObject) next.getValue();
            if (!d3.containsKey(next.getKey())) {
                return false;
            }
            PdfObject pdfObject2 = d3.get(next.getKey());
            if (pdfObject.W() != pdfObject2.W()) {
                return false;
            }
            int W = pdfObject.W();
            if ((W == 1 || W == 2 || W == 3 || W == 4 || W == 8) && !pdfObject.toString().equals(pdfObject2.toString())) {
                return false;
            }
        }
        return true;
    }

    private void T(PdfReader pdfReader, List<PdfDictionary> list, List<RefKey> list2) {
        c(pdfReader.F().d0(PdfName.zc), list, list2);
    }

    private Process U(String str, String str2) throws IOException, InterruptedException {
        StringTokenizer stringTokenizer = new StringTokenizer(str2);
        String[] strArr = new String[(stringTokenizer.countTokens() + 1)];
        strArr[0] = str;
        int i2 = 1;
        while (stringTokenizer.hasMoreTokens()) {
            strArr[i2] = stringTokenizer.nextToken();
            i2++;
        }
        return Runtime.getRuntime().exec(strArr);
    }

    private void c(PdfObject pdfObject, List<PdfDictionary> list, List<RefKey> list2) {
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.t0(pdfObject);
        if (pdfDictionary.Q0()) {
            PdfArray e0 = pdfDictionary.e0(PdfName.ia);
            if (e0 != null) {
                Iterator<PdfObject> it2 = e0.iterator();
                while (it2.hasNext()) {
                    c(it2.next(), list, list2);
                }
            }
        } else if (pdfDictionary.P0()) {
            list.add(pdfDictionary);
            list2.add(new RefKey((PdfIndirectReference) (PRIndirectReference) pdfObject));
        }
    }

    private String f(String str, String str2, Map<Integer, List<Rectangle>> map) throws IOException, InterruptedException, DocumentException {
        return g(str, str2, map, (List<Integer>) null);
    }

    private String g(String str, String str2, Map<Integer, List<Rectangle>> map, List<Integer> list) throws IOException, InterruptedException, DocumentException {
        File[] fileArr;
        int i2;
        String replace;
        String str3 = str;
        String str4 = str2;
        List<Integer> list2 = list;
        if (this.f25634a == null) {
            return x;
        }
        if (!new File(this.f25634a).exists()) {
            return new File(this.f25634a).getAbsolutePath() + " does not exist";
        }
        if (!str3.endsWith("/")) {
            str3 = str3 + "/";
        }
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        } else {
            for (File delete : file.listFiles(new PngFileFilter())) {
                delete.delete();
            }
            for (File delete2 : file.listFiles(new CmpPngFileFilter())) {
                delete2.delete();
            }
        }
        File file2 = new File(str3 + str4);
        if (file2.exists()) {
            file2.delete();
        }
        if (map != null && !map.isEmpty()) {
            PdfReader pdfReader = new PdfReader(this.f25638e);
            PdfReader pdfReader2 = new PdfReader(this.f25641h);
            PdfStamper pdfStamper = new PdfStamper(pdfReader2, new FileOutputStream(str3 + y + this.f25642i));
            PdfStamper pdfStamper2 = new PdfStamper(pdfReader, new FileOutputStream(str3 + y + this.f25639f));
            for (Map.Entry next : map.entrySet()) {
                int intValue = ((Integer) next.getKey()).intValue();
                List<Rectangle> list3 = (List) next.getValue();
                if (list3 != null && !list3.isEmpty()) {
                    PdfContentByte x2 = pdfStamper.x(intValue);
                    PdfContentByte x3 = pdfStamper2.x(intValue);
                    for (Rectangle rectangle : list3) {
                        rectangle.h0(BaseColor.f25677f);
                        x2.I1(rectangle);
                        x3.I1(rectangle);
                    }
                }
            }
            pdfStamper.j();
            pdfStamper2.j();
            pdfReader2.l();
            pdfReader.l();
            R(str3 + y + this.f25642i, str3 + y + this.f25639f);
        }
        if (!file.exists()) {
            return t.replace("<filename>", this.f25641h);
        }
        Process U = U(this.f25634a, " -dNOPAUSE -dBATCH -sDEVICE=png16m -r150 -sOutputFile=<outputfile> <inputfile>".replace("<outputfile>", str3 + this.f25640g).replace("<inputfile>", this.f25638e));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(U.getInputStream()));
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(U.getErrorStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            System.out.println(readLine);
        }
        bufferedReader.close();
        while (true) {
            String readLine2 = bufferedReader2.readLine();
            if (readLine2 == null) {
                break;
            }
            System.out.println(readLine2);
        }
        bufferedReader2.close();
        if (U.waitFor() != 0) {
            return u.replace("<filename>", this.f25638e);
        }
        Process U2 = U(this.f25634a, " -dNOPAUSE -dBATCH -sDEVICE=png16m -r150 -sOutputFile=<outputfile> <inputfile>".replace("<outputfile>", str3 + this.f25643j).replace("<inputfile>", this.f25641h));
        BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(U2.getInputStream()));
        BufferedReader bufferedReader4 = new BufferedReader(new InputStreamReader(U2.getErrorStream()));
        while (true) {
            String readLine3 = bufferedReader3.readLine();
            if (readLine3 == null) {
                break;
            }
            System.out.println(readLine3);
        }
        bufferedReader3.close();
        while (true) {
            String readLine4 = bufferedReader4.readLine();
            if (readLine4 == null) {
                break;
            }
            System.out.println(readLine4);
        }
        bufferedReader4.close();
        if (U2.waitFor() != 0) {
            return u.replace("<filename>", this.f25641h);
        }
        File[] listFiles = file.listFiles(new PngFileFilter());
        File[] listFiles2 = file.listFiles(new CmpPngFileFilter());
        boolean z = listFiles.length != listFiles2.length;
        int min = Math.min(listFiles.length, listFiles2.length);
        if (min < 1) {
            return "No files for comparing!!!\nThe result or sample pdf file is not processed by GhostScript.";
        }
        Arrays.sort(listFiles, new ImageNameComparator());
        Arrays.sort(listFiles2, new ImageNameComparator());
        int i3 = 0;
        String str5 = null;
        while (true) {
            if (i3 >= min) {
                break;
            }
            if (list2 == null || !list2.contains(Integer.valueOf(i3))) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("Comparing page ");
                i2 = i3 + 1;
                sb.append(Integer.toString(i2));
                sb.append(" (");
                sb.append(listFiles[i3].getAbsolutePath());
                sb.append(")...");
                printStream.print(sb.toString());
                FileInputStream fileInputStream = new FileInputStream(listFiles[i3]);
                FileInputStream fileInputStream2 = new FileInputStream(listFiles2[i3]);
                boolean E = E(fileInputStream, fileInputStream2);
                fileInputStream.close();
                fileInputStream2.close();
                if (E) {
                    fileArr = listFiles2;
                    printStream.println("done.");
                } else if (this.f25635b == null || !new File(this.f25635b).exists()) {
                    str5 = w.replace("<filename>", this.f25641h).replace("<pagenumber>", Integer.toString(i2)) + "\nYou can optionally specify path to ImageMagick compare tool (e.g. -DcompareExec=\"C:/Program Files/ImageMagick-6.5.4-2/compare.exe\") to visualize differences.";
                } else {
                    Process U3 = U(this.f25635b, " \"<image1>\" \"<image2>\" \"<difference>\"".replace("<image1>", listFiles[i3].getAbsolutePath()).replace("<image2>", listFiles2[i3].getAbsolutePath()).replace("<difference>", str3 + str4 + Integer.toString(i2) + ".png"));
                    fileArr = listFiles2;
                    BufferedReader bufferedReader5 = new BufferedReader(new InputStreamReader(U3.getErrorStream()));
                    while (true) {
                        String readLine5 = bufferedReader5.readLine();
                        if (readLine5 == null) {
                            break;
                        }
                        System.out.println(readLine5);
                    }
                    bufferedReader5.close();
                    if (U3.waitFor() != 0) {
                        replace = w.replace("<filename>", this.f25641h).replace("<pagenumber>", Integer.toString(i2));
                    } else if (str5 == null) {
                        replace = w.replace("<filename>", this.f25641h).replace("<pagenumber>", Integer.toString(i2)) + "\nPlease, examine " + str3 + str4 + Integer.toString(i2) + ".png for more details.";
                    } else {
                        replace = "File " + this.f25641h + " differs.\nPlease, examine difference images for more details.";
                    }
                    str5 = replace;
                    System.out.println(str5);
                }
            } else {
                fileArr = listFiles2;
            }
            i3++;
            listFiles2 = fileArr;
            list2 = list;
        }
        str5 = w.replace("<filename>", this.f25641h).replace("<pagenumber>", Integer.toString(i2)) + "\nYou can optionally specify path to ImageMagick compare tool (e.g. -DcompareExec=\"C:/Program Files/ImageMagick-6.5.4-2/compare.exe\") to visualize differences.";
        if (str5 != null) {
            return str5;
        }
        if (z) {
            return v.replace("<filename>", this.f25641h);
        }
        return null;
    }

    private boolean i(PdfArray pdfArray, PdfArray pdfArray2, ObjectPath objectPath, CompareResult compareResult) throws IOException {
        if (pdfArray == null) {
            if (!(compareResult == null || objectPath == null)) {
                compareResult.a(objectPath, "Found null. Expected PdfArray.");
            }
            return false;
        } else if (pdfArray.size() != pdfArray2.size()) {
            if (!(compareResult == null || objectPath == null)) {
                compareResult.a(objectPath, String.format("PdfArrays. Lengths are different. Expected: %s. Found: %s.", new Object[]{Integer.valueOf(pdfArray2.size()), Integer.valueOf(pdfArray.size())}));
            }
            return false;
        } else {
            boolean z = true;
            for (int i2 = 0; i2 < pdfArray2.size(); i2++) {
                if (objectPath != null) {
                    objectPath.c(i2);
                }
                z = C(pdfArray.T0(i2), pdfArray2.T0(i2), objectPath, compareResult) && z;
                if (objectPath != null) {
                    objectPath.b();
                }
                if (!z && (objectPath == null || compareResult == null || compareResult.d())) {
                    return false;
                }
            }
            return z;
        }
    }

    private boolean k(PdfBoolean pdfBoolean, PdfBoolean pdfBoolean2, ObjectPath objectPath, CompareResult compareResult) {
        if (pdfBoolean2.Z() == pdfBoolean.Z()) {
            return true;
        }
        if (!(compareResult == null || objectPath == null)) {
            compareResult.a(objectPath, String.format("PdfBoolean. Expected: %s. Found: %s.", new Object[]{Boolean.valueOf(pdfBoolean2.Z()), Boolean.valueOf(pdfBoolean.Z())}));
        }
        return false;
    }

    private boolean q(PdfObject pdfObject, PdfObject pdfObject2, PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, ObjectPath objectPath, CompareResult compareResult) throws IOException {
        String format;
        ObjectPath objectPath2 = objectPath;
        CompareResult compareResult2 = compareResult;
        int i2 = 2;
        if (pdfObject.W() != pdfObject.W()) {
            format = String.format("PdfObject. Types are different. Expected: %s. Found: %s", new Object[]{Integer.valueOf(pdfObject2.W()), Integer.valueOf(pdfObject.W())});
        } else {
            if (pdfObject.q()) {
                PdfArray pdfArray = (PdfArray) pdfObject;
                PdfArray pdfArray2 = (PdfArray) pdfObject2;
                if (pdfArray2.size() != pdfArray.size()) {
                    format = String.format("PdfArray. Sizes are different. Expected: %s. Found: %s", new Object[]{Integer.valueOf(pdfArray2.size()), Integer.valueOf(pdfArray.size())});
                } else {
                    for (int i3 = 0; i3 < pdfArray2.size(); i3++) {
                        if (!q(pdfArray.T0(i3), pdfArray2.T0(i3), pdfDictionary, pdfDictionary2, objectPath, compareResult)) {
                            return false;
                        }
                    }
                }
            }
            PRTokeniser pRTokeniser = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().j(ContentByteUtils.b(pdfObject2))));
            PRTokeniser pRTokeniser2 = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().j(ContentByteUtils.b(pdfObject))));
            PdfContentParser pdfContentParser = new PdfContentParser(pRTokeniser);
            PdfContentParser pdfContentParser2 = new PdfContentParser(pRTokeniser2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            PdfDictionary pdfDictionary3 = pdfDictionary;
            PdfDictionary pdfDictionary4 = pdfDictionary2;
            while (pdfContentParser.c(arrayList).size() > 0) {
                pdfContentParser2.c(arrayList2);
                if (arrayList.size() != arrayList2.size()) {
                    Integer valueOf = Integer.valueOf(arrayList.size());
                    Integer valueOf2 = Integer.valueOf(arrayList2.size());
                    Object[] objArr = new Object[i2];
                    objArr[0] = valueOf;
                    objArr[1] = valueOf2;
                    format = String.format("PdfObject. Different commands lengths. Expected: %s. Found: %s", objArr);
                } else {
                    if (arrayList.size() != 1 || !w((PdfLiteral) arrayList.get(0), new PdfLiteral("BI")) || !w((PdfLiteral) arrayList2.get(0), new PdfLiteral("BI"))) {
                        ArrayList arrayList3 = arrayList2;
                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                            if (!C((PdfObject) arrayList3.get(i4), (PdfObject) arrayList.get(i4), objectPath2, compareResult2)) {
                                return false;
                            }
                        }
                        arrayList2 = arrayList3;
                    } else {
                        PRStream pRStream = (PRStream) pdfObject2;
                        PRStream pRStream2 = (PRStream) pdfObject;
                        PdfName pdfName = PdfName.Wd;
                        if (!(pRStream2.B0(pdfName) == null || pRStream.B0(pdfName) == null)) {
                            pdfDictionary3 = (PdfDictionary) pRStream2.B0(pdfName);
                            pdfDictionary4 = (PdfDictionary) pRStream.B0(pdfName);
                        }
                        PdfDictionary pdfDictionary5 = pdfDictionary3;
                        PdfDictionary pdfDictionary6 = pdfDictionary4;
                        ArrayList arrayList4 = arrayList2;
                        if (!u(pdfContentParser2, pdfContentParser, pdfDictionary5, pdfDictionary6, objectPath, compareResult)) {
                            return false;
                        }
                        arrayList2 = arrayList4;
                        pdfDictionary3 = pdfDictionary5;
                        pdfDictionary4 = pdfDictionary6;
                    }
                    i2 = 2;
                }
            }
            return true;
        }
        compareResult2.a(objectPath2, format);
        return false;
    }

    private boolean s(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, ObjectPath objectPath, CompareResult compareResult) throws IOException {
        PdfDictionary pdfDictionary3 = pdfDictionary;
        PdfDictionary pdfDictionary4 = pdfDictionary2;
        ObjectPath objectPath2 = objectPath;
        CompareResult compareResult2 = compareResult;
        char c2 = 2;
        if ((pdfDictionary4 == null || pdfDictionary3 != null) && (pdfDictionary3 == null || pdfDictionary4 != null)) {
            TreeSet<PdfName> treeSet = new TreeSet<>(pdfDictionary2.G0());
            treeSet.addAll(pdfDictionary.G0());
            boolean z = true;
            for (PdfName pdfName : treeSet) {
                if (!(pdfName.compareTo(PdfName.Dc) == 0 || pdfName.compareTo(PdfName.tc) == 0)) {
                    if (!pdfDictionary.K() || !pdfDictionary2.K() || (!pdfName.equals(PdfName.T7) && !pdfName.equals(PdfName.va))) {
                        if (pdfName.compareTo(PdfName.l4) == 0 || pdfName.compareTo(PdfName.t8) == 0) {
                            PdfObject B0 = pdfDictionary4.B0(pdfName);
                            if (B0.E() && B0.toString().indexOf(43) > 0) {
                                PdfObject B02 = pdfDictionary3.B0(pdfName);
                                if (!B02.E() || B02.toString().indexOf(43) == -1) {
                                    if (!(compareResult2 == null || objectPath2 == null)) {
                                        String pdfObject = pdfName.toString();
                                        String pdfObject2 = B0.toString();
                                        String pdfObject3 = B02.toString();
                                        Object[] objArr = new Object[3];
                                        objArr[0] = pdfObject;
                                        objArr[1] = pdfObject2;
                                        objArr[c2] = pdfObject3;
                                        compareResult2.a(objectPath2, String.format("PdfDictionary %s entry: Expected: %s. Found: %s", objArr));
                                    }
                                    z = false;
                                }
                                if (!B0.toString().substring(B0.toString().indexOf(43)).equals(B02.toString().substring(B02.toString().indexOf(43)))) {
                                    if (compareResult2 == null || objectPath2 == null) {
                                        c2 = 2;
                                    } else {
                                        c2 = 2;
                                        compareResult2.a(objectPath2, String.format("PdfDictionary %s entry: Expected: %s. Found: %s", new Object[]{pdfName.toString(), B0.toString(), B02.toString()}));
                                    }
                                    z = false;
                                } else {
                                    c2 = 2;
                                }
                            }
                        }
                        if (this.r == 0.0d || !pdfDictionary2.P0() || !pdfDictionary.P0() || !pdfName.equals(PdfName.N5)) {
                            if (objectPath2 != null) {
                                objectPath2.d(pdfName.toString());
                            }
                            z = C(pdfDictionary3.d0(pdfName), pdfDictionary4.d0(pdfName), objectPath2, compareResult2) && z;
                            if (objectPath2 != null) {
                                objectPath.b();
                            }
                            if (!z && (objectPath2 == null || compareResult2 == null || compareResult.d())) {
                                return false;
                            }
                        } else {
                            PdfObject B03 = pdfDictionary3.B0(pdfName);
                            PdfObject B04 = pdfDictionary4.B0(pdfName);
                            PdfName pdfName2 = PdfName.Wd;
                            if (q(B03, B04, (PdfDictionary) pdfDictionary3.B0(pdfName2), (PdfDictionary) pdfDictionary4.B0(pdfName2), objectPath, compareResult)) {
                            }
                            z = false;
                        }
                    }
                }
            }
            return z;
        }
        compareResult2.a(objectPath2, "One of the dictionaries is null, the other is not.");
        return false;
    }

    private boolean u(PdfContentParser pdfContentParser, PdfContentParser pdfContentParser2, PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, ObjectPath objectPath, CompareResult compareResult) throws IOException {
        InlineImageInfo e2 = InlineImageUtils.e(pdfContentParser2, pdfDictionary2);
        InlineImageInfo e3 = InlineImageUtils.e(pdfContentParser, pdfDictionary);
        return C(e3.a(), e2.a(), objectPath, compareResult) && Arrays.equals(e3.b(), e2.b());
    }

    private boolean x(PdfLiteral pdfLiteral, PdfLiteral pdfLiteral2, ObjectPath objectPath, CompareResult compareResult) {
        if (w(pdfLiteral, pdfLiteral2)) {
            return true;
        }
        if (!(compareResult == null || objectPath == null)) {
            compareResult.a(objectPath, String.format("PdfLiteral. Expected: %s. Found: %s", new Object[]{pdfLiteral2, pdfLiteral}));
        }
        return false;
    }

    private boolean z(PdfName pdfName, PdfName pdfName2, ObjectPath objectPath, CompareResult compareResult) {
        if (pdfName2.compareTo(pdfName) == 0) {
            return true;
        }
        if (!(compareResult == null || objectPath == null)) {
            compareResult.a(objectPath, String.format("PdfName. Expected: %s. Found: %s", new Object[]{pdfName2.toString(), pdfName.toString()}));
        }
        return false;
    }

    public boolean A(PdfNumber pdfNumber, PdfNumber pdfNumber2) {
        double abs = Math.abs(pdfNumber.Z() - pdfNumber2.Z());
        if (!this.s && pdfNumber2.Z() != 0.0d) {
            abs /= pdfNumber2.Z();
        }
        return abs <= this.r;
    }

    public boolean D(PRStream pRStream, PRStream pRStream2) throws IOException {
        return F(pRStream, pRStream2, (ObjectPath) null, (CompareResult) null);
    }

    public boolean G(PdfString pdfString, PdfString pdfString2) {
        return Arrays.equals(pdfString2.k(), pdfString.k());
    }

    public String I(String str, String str2) throws IOException, ParserConfigurationException, SAXException {
        PrintStream printStream = System.out;
        printStream.print("[itext] INFO  Comparing tag structures......");
        String replace = str.replace(".pdf", ".xml");
        String replace2 = str.replace(".pdf", ".cmp.xml");
        PdfReader pdfReader = new PdfReader(str);
        FileOutputStream fileOutputStream = new FileOutputStream(replace);
        new CmpTaggedPdfReaderTool().a(pdfReader, fileOutputStream);
        pdfReader.l();
        PdfReader pdfReader2 = new PdfReader(str2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(replace2);
        new CmpTaggedPdfReaderTool().a(pdfReader2, fileOutputStream2);
        pdfReader2.l();
        String str3 = !J(replace, replace2) ? "The tag structures are different." : null;
        fileOutputStream.close();
        fileOutputStream2.close();
        printStream.println(str3 == null ? "OK" : "Fail");
        printStream.flush();
        return str3;
    }

    public boolean J(String str, String str2) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        newInstance.setCoalescing(true);
        newInstance.setIgnoringElementContentWhitespace(true);
        newInstance.setIgnoringComments(true);
        DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
        Document parse = newDocumentBuilder.parse(new File(str));
        parse.normalizeDocument();
        Document parse2 = newDocumentBuilder.parse(new File(str2));
        parse2.normalizeDocument();
        return parse2.isEqualNode(parse);
    }

    public boolean K(byte[] bArr, byte[] bArr2) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        newInstance.setCoalescing(true);
        newInstance.setIgnoringElementContentWhitespace(true);
        newInstance.setIgnoringComments(true);
        DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
        Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(bArr));
        parse.normalizeDocument();
        Document parse2 = newDocumentBuilder.parse(new ByteArrayInputStream(bArr2));
        parse2.normalizeDocument();
        return parse2.isEqualNode(parse);
    }

    public String L(String str, String str2) {
        return M(str, str2, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String M(java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            r3 = this;
            r3.R(r4, r5)
            r4 = 0
            com.itextpdf.text.pdf.PdfReader r5 = new com.itextpdf.text.pdf.PdfReader     // Catch:{ IOException -> 0x0034, all -> 0x002f }
            java.lang.String r0 = r3.f25638e     // Catch:{ IOException -> 0x0034, all -> 0x002f }
            r5.<init>((java.lang.String) r0)     // Catch:{ IOException -> 0x0034, all -> 0x002f }
            com.itextpdf.text.pdf.PdfReader r0 = new com.itextpdf.text.pdf.PdfReader     // Catch:{ IOException -> 0x002d, all -> 0x0029 }
            java.lang.String r1 = r3.f25641h     // Catch:{ IOException -> 0x002d, all -> 0x0029 }
            r0.<init>((java.lang.String) r1)     // Catch:{ IOException -> 0x002d, all -> 0x0029 }
            byte[] r4 = r5.U()     // Catch:{ IOException -> 0x0027, all -> 0x0025 }
            byte[] r1 = r0.U()     // Catch:{ IOException -> 0x0027, all -> 0x0025 }
            java.lang.String r4 = r3.O(r4, r1, r6)     // Catch:{ IOException -> 0x0027, all -> 0x0025 }
            r5.l()
            r0.l()
            return r4
        L_0x0025:
            r4 = move-exception
            goto L_0x0046
        L_0x0027:
            r4 = r5
            goto L_0x0035
        L_0x0029:
            r6 = move-exception
            r0 = r4
            r4 = r6
            goto L_0x0046
        L_0x002d:
            r0 = r4
            goto L_0x0027
        L_0x002f:
            r5 = move-exception
            r0 = r4
            r4 = r5
            r5 = r0
            goto L_0x0046
        L_0x0034:
            r0 = r4
        L_0x0035:
            java.lang.String r5 = "XMP parsing failure!"
            if (r4 == 0) goto L_0x003c
            r4.l()
        L_0x003c:
            if (r0 == 0) goto L_0x0041
            r0.l()
        L_0x0041:
            return r5
        L_0x0042:
            r5 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0046:
            if (r5 == 0) goto L_0x004b
            r5.l()
        L_0x004b:
            if (r0 == 0) goto L_0x0050
            r0.l()
        L_0x0050:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.testutils.CompareTool.M(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public String N(byte[] bArr, byte[] bArr2) {
        return O(bArr, bArr2, false);
    }

    public String O(byte[] bArr, byte[] bArr2, boolean z) {
        if (z) {
            try {
                XMPMeta g2 = XMPMetaFactory.g(bArr);
                XMPUtils.p(g2, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27415c, true, true);
                XMPUtils.p(g2, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27419g, true, true);
                XMPUtils.p(g2, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27418f, true, true);
                XMPUtils.p(g2, "http://ns.adobe.com/pdf/1.3/", PdfProperties.f27411c, true, true);
                bArr = XMPMetaFactory.n(g2, new SerializeOptions(8192));
                XMPMeta g3 = XMPMetaFactory.g(bArr2);
                XMPUtils.p(g3, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27415c, true, true);
                XMPUtils.p(g3, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27419g, true, true);
                XMPUtils.p(g3, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27418f, true, true);
                XMPUtils.p(g3, "http://ns.adobe.com/pdf/1.3/", PdfProperties.f27411c, true, true);
                bArr2 = XMPMetaFactory.n(g3, new SerializeOptions(8192));
            } catch (XMPException | IOException | ParserConfigurationException | SAXException unused) {
                return "XMP parsing failure!";
            }
        }
        if (!K(bArr, bArr2)) {
            return "The XMP packages different!";
        }
        return null;
    }

    public String Q() {
        return this.q;
    }

    public CompareTool V(int i2) {
        this.o = i2;
        return this;
    }

    public CompareTool W(float f2) {
        this.r = (double) f2;
        this.s = true;
        return this;
    }

    public CompareTool X(float f2) {
        this.r = (double) f2;
        this.s = false;
        return this;
    }

    public void Y(boolean z) {
        this.p = z;
    }

    public void Z(String str) {
        this.q = str;
    }

    public String d(String str, String str2, String str3, String str4) throws IOException, InterruptedException, DocumentException {
        return e(str, str2, str3, str4, (Map<Integer, List<Rectangle>>) null);
    }

    public String e(String str, String str2, String str3, String str4, Map<Integer, List<Rectangle>> map) throws IOException, InterruptedException, DocumentException {
        R(str, str2);
        return f(str3, str4, map);
    }

    public boolean h(PdfArray pdfArray, PdfArray pdfArray2) throws IOException {
        return i(pdfArray, pdfArray2, (ObjectPath) null, (CompareResult) null);
    }

    public boolean j(PdfBoolean pdfBoolean, PdfBoolean pdfBoolean2) {
        return Arrays.equals(pdfBoolean2.k(), pdfBoolean.k());
    }

    public String l(String str, String str2, String str3, String str4) throws DocumentException, InterruptedException, IOException {
        return m(str, str2, str3, str4, (Map<Integer, List<Rectangle>>) null);
    }

    public String m(String str, String str2, String str3, String str4, Map<Integer, List<Rectangle>> map) throws DocumentException, InterruptedException, IOException {
        R(str, str2);
        return n(str3, str4, map);
    }

    /* access modifiers changed from: protected */
    public String n(String str, String str2, Map<Integer, List<Rectangle>> map) throws DocumentException, InterruptedException, IOException {
        System.out.print("[itext] INFO  Comparing by content..........");
        PdfReader pdfReader = new PdfReader(this.f25641h);
        this.f25644k = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f25645l = arrayList;
        T(pdfReader, this.f25644k, arrayList);
        PdfReader pdfReader2 = new PdfReader(this.f25638e);
        this.f25646m = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f25647n = arrayList2;
        T(pdfReader2, this.f25646m, arrayList2);
        if (this.f25644k.size() != this.f25646m.size()) {
            return f(str, str2, map);
        }
        CompareResult compareResult = new CompareResult(this.o);
        ArrayList arrayList3 = new ArrayList(this.f25646m.size());
        for (int i2 = 0; i2 < this.f25646m.size(); i2++) {
            if (s(this.f25644k.get(i2), this.f25646m.get(i2), new ObjectPath(this.f25647n.get(i2), this.f25645l.get(i2)), compareResult)) {
                arrayList3.add(Integer.valueOf(i2));
            }
        }
        PdfDictionary F = pdfReader.F();
        PdfName pdfName = PdfName.xf;
        PdfObject d0 = F.d0(pdfName);
        PdfObject d02 = pdfReader2.F().d0(pdfName);
        C(d0, d02, new ObjectPath(d0 == null ? null : new RefKey((PdfIndirectReference) d0), d02 == null ? null : new RefKey((PdfIndirectReference) d02)), compareResult);
        PdfDictionary F2 = pdfReader.F();
        PdfName pdfName2 = PdfName.Tb;
        PdfObject d03 = F2.d0(pdfName2);
        PdfObject d04 = pdfReader2.F().d0(pdfName2);
        C(d03, d04, new ObjectPath(d03 instanceof PdfIndirectReference ? new RefKey((PdfIndirectReference) d03) : null, d04 instanceof PdfIndirectReference ? new RefKey((PdfIndirectReference) d04) : null), compareResult);
        pdfReader.l();
        pdfReader2.l();
        if (this.p) {
            try {
                compareResult.f(new FileOutputStream(str + "/" + this.q + ".xml"));
            } catch (Exception unused) {
            }
        }
        if (arrayList3.size() != this.f25646m.size() || !compareResult.e()) {
            PrintStream printStream = System.out;
            printStream.println("Fail");
            printStream.flush();
            printStream.println("Compare by content report:\n" + compareResult.c());
            printStream.flush();
            String g2 = g(str, str2, map, arrayList3);
            return (g2 == null || g2.length() == 0) ? "Compare by content fails. No visual differences" : g2;
        }
        PrintStream printStream2 = System.out;
        printStream2.println("OK");
        printStream2.flush();
        return null;
    }

    public boolean o(PdfObject pdfObject, PdfObject pdfObject2) throws IOException {
        return q(pdfObject, pdfObject2, (PdfDictionary) null, (PdfDictionary) null, (ObjectPath) null, (CompareResult) null);
    }

    public boolean p(PdfObject pdfObject, PdfObject pdfObject2, PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) throws IOException {
        return q(pdfObject, pdfObject2, pdfDictionary, pdfDictionary2, (ObjectPath) null, (CompareResult) null);
    }

    public boolean r(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) throws IOException {
        return s(pdfDictionary, pdfDictionary2, (ObjectPath) null, (CompareResult) null);
    }

    public String t(String str, String str2) throws IOException {
        String str3;
        System.out.print("[itext] INFO  Comparing document info.......");
        PdfReader pdfReader = new PdfReader(str);
        PdfReader pdfReader2 = new PdfReader(str2);
        String[] P = P(pdfReader2.P());
        String[] P2 = P(pdfReader.P());
        int i2 = 0;
        while (true) {
            if (i2 >= P.length) {
                str3 = null;
                break;
            } else if (!P[i2].equals(P2[i2])) {
                str3 = "Document info fail";
                break;
            } else {
                i2++;
            }
        }
        pdfReader.l();
        pdfReader2.l();
        System.out.println(str3 == null ? "OK" : "Fail");
        System.out.flush();
        return str3;
    }

    public String v(String str, String str2) throws IOException {
        System.out.print("[itext] INFO  Comparing link annotations....");
        PdfReader pdfReader = new PdfReader(str);
        PdfReader pdfReader2 = new PdfReader(str2);
        String str3 = null;
        int i2 = 0;
        while (true) {
            if (i2 >= pdfReader.c0() || i2 >= pdfReader2.c0()) {
                break;
            }
            i2++;
            ArrayList<PdfAnnotation.PdfImportedLink> T = pdfReader.T(i2);
            ArrayList<PdfAnnotation.PdfImportedLink> T2 = pdfReader2.T(i2);
            if (T2.size() != T.size()) {
                str3 = String.format("Different number of links on page %d.", new Object[]{Integer.valueOf(i2)});
                break;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= T2.size()) {
                    break;
                } else if (!S(T2.get(i3), T.get(i3))) {
                    str3 = String.format("Different links on page %d.\n%s\n%s", new Object[]{Integer.valueOf(i2), T2.get(i3).toString(), T.get(i3).toString()});
                    break;
                } else {
                    i3++;
                }
            }
        }
        pdfReader.l();
        pdfReader2.l();
        System.out.println(str3 == null ? "OK" : "Fail");
        System.out.flush();
        return str3;
    }

    public boolean w(PdfLiteral pdfLiteral, PdfLiteral pdfLiteral2) {
        return Arrays.equals(pdfLiteral2.k(), pdfLiteral.k());
    }

    public boolean y(PdfName pdfName, PdfName pdfName2) {
        return pdfName2.compareTo(pdfName) == 0;
    }
}
