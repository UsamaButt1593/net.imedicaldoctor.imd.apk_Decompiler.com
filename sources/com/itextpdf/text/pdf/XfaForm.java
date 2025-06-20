package com.itextpdf.text.pdf;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.xml.XmlDomWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.lang3.ClassUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XfaForm {

    /* renamed from: j  reason: collision with root package name */
    public static final String f26478j = "http://www.xfa.org/schema/xfa-data/1.0/";

    /* renamed from: a  reason: collision with root package name */
    private Xml2SomTemplate f26479a;

    /* renamed from: b  reason: collision with root package name */
    private Node f26480b;

    /* renamed from: c  reason: collision with root package name */
    private Xml2SomDatasets f26481c;

    /* renamed from: d  reason: collision with root package name */
    private Node f26482d;

    /* renamed from: e  reason: collision with root package name */
    private AcroFieldsSearch f26483e;

    /* renamed from: f  reason: collision with root package name */
    private PdfReader f26484f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f26485g;

    /* renamed from: h  reason: collision with root package name */
    private Document f26486h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f26487i;

    public static class AcroFieldsSearch extends Xml2Som {

        /* renamed from: f  reason: collision with root package name */
        private HashMap<String, String> f26488f = new HashMap<>();

        public AcroFieldsSearch(Collection<String> collection) {
            this.f26493c = new HashMap<>();
            for (String next : collection) {
                String e2 = Xml2Som.e(next);
                this.f26488f.put(e2, next);
                Xml2Som.g(this.f26493c, Xml2Som.m(e2), next);
            }
        }

        public HashMap<String, String> o() {
            return this.f26488f;
        }

        public void p(HashMap<String, String> hashMap) {
            this.f26488f = hashMap;
        }
    }

    public static class InverseStore {

        /* renamed from: a  reason: collision with root package name */
        protected ArrayList<String> f26489a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        protected ArrayList<Object> f26490b = new ArrayList<>();

        public String a() {
            InverseStore inverseStore = this;
            while (true) {
                Object obj = inverseStore.f26490b.get(0);
                if (obj instanceof String) {
                    return (String) obj;
                }
                inverseStore = (InverseStore) obj;
            }
        }

        public boolean b(String str) {
            String substring = str.substring(0, str.indexOf(91) + 1);
            for (int i2 = 0; i2 < this.f26489a.size(); i2++) {
                if (this.f26489a.get(i2).startsWith(substring)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class Stack2<T> extends ArrayList<T> {
        private static final long s = -7451476576174095212L;

        public boolean b() {
            return size() == 0;
        }

        public T c(T t) {
            add(t);
            return t;
        }

        public T peek() {
            if (size() != 0) {
                return get(size() - 1);
            }
            throw new EmptyStackException();
        }

        public T pop() {
            if (size() != 0) {
                T t = get(size() - 1);
                remove(size() - 1);
                return t;
            }
            throw new EmptyStackException();
        }
    }

    public static class Xml2Som {

        /* renamed from: a  reason: collision with root package name */
        protected ArrayList<String> f26491a;

        /* renamed from: b  reason: collision with root package name */
        protected HashMap<String, Node> f26492b;

        /* renamed from: c  reason: collision with root package name */
        protected HashMap<String, InverseStore> f26493c;

        /* renamed from: d  reason: collision with root package name */
        protected Stack2<String> f26494d;

        /* renamed from: e  reason: collision with root package name */
        protected int f26495e;

        public static String a(String str) {
            if (str == null) {
                return "";
            }
            int indexOf = str.indexOf(46);
            if (indexOf < 0) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            while (indexOf >= 0) {
                stringBuffer.append(str.substring(i2, indexOf));
                stringBuffer.append(ASCIIPropertyListParser.p);
                i2 = indexOf;
                indexOf = str.indexOf(46, indexOf + 1);
            }
            stringBuffer.append(str.substring(i2));
            return stringBuffer.toString();
        }

        public static String e(String str) {
            int indexOf = str.indexOf(".#subform[");
            if (indexOf < 0) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            while (indexOf >= 0) {
                stringBuffer.append(str.substring(i2, indexOf));
                int indexOf2 = str.indexOf("]", indexOf + 10);
                if (indexOf2 < 0) {
                    return stringBuffer.toString();
                }
                i2 = indexOf2 + 1;
                indexOf = str.indexOf(".#subform[", i2);
            }
            stringBuffer.append(str.substring(i2));
            return stringBuffer.toString();
        }

        public static void g(HashMap<String, InverseStore> hashMap, Stack2<String> stack2, String str) {
            InverseStore inverseStore;
            String peek = stack2.peek();
            InverseStore inverseStore2 = hashMap.get(peek);
            if (inverseStore2 == null) {
                inverseStore2 = new InverseStore();
                hashMap.put(peek, inverseStore2);
            }
            for (int size = stack2.size() - 2; size >= 0; size--) {
                String str2 = (String) stack2.get(size);
                int indexOf = inverseStore2.f26489a.indexOf(str2);
                if (indexOf < 0) {
                    inverseStore2.f26489a.add(str2);
                    inverseStore = new InverseStore();
                    inverseStore2.f26490b.add(inverseStore);
                } else {
                    inverseStore = (InverseStore) inverseStore2.f26490b.get(indexOf);
                }
                inverseStore2 = inverseStore;
            }
            inverseStore2.f26489a.add("");
            inverseStore2.f26490b.add(str);
        }

        public static Stack2<String> m(String str) {
            int indexOf;
            while (str.startsWith(".")) {
                str = str.substring(1);
            }
            Stack2<String> stack2 = new Stack2<>();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                while (true) {
                    indexOf = str.indexOf(46, i3);
                    if (indexOf >= 0 && str.charAt(indexOf - 1) == '\\') {
                        i3 = indexOf + 1;
                    }
                }
                if (indexOf < 0) {
                    break;
                }
                String substring = str.substring(i2, indexOf);
                if (!substring.endsWith("]")) {
                    substring = substring + "[0]";
                }
                stack2.add(substring);
                i2 = indexOf + 1;
            }
            String substring2 = str.substring(i2);
            if (!substring2.endsWith("]")) {
                substring2 = substring2 + "[0]";
            }
            stack2.add(substring2);
            return stack2;
        }

        public static String n(String str) {
            int indexOf = str.indexOf(92);
            if (indexOf < 0) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            while (indexOf >= 0) {
                stringBuffer.append(str.substring(i2, indexOf));
                i2 = indexOf + 1;
                indexOf = str.indexOf(92, i2);
            }
            stringBuffer.append(str.substring(i2));
            return stringBuffer.toString();
        }

        public HashMap<String, InverseStore> b() {
            return this.f26493c;
        }

        public HashMap<String, Node> c() {
            return this.f26492b;
        }

        public ArrayList<String> d() {
            return this.f26491a;
        }

        public void f(String str) {
            g(this.f26493c, this.f26494d, str);
        }

        public String h(ArrayList<String> arrayList) {
            InverseStore inverseStore;
            if (arrayList.isEmpty() || (inverseStore = this.f26493c.get(arrayList.get(arrayList.size() - 1))) == null) {
                return null;
            }
            int size = arrayList.size() - 2;
            while (size >= 0) {
                String str = arrayList.get(size);
                int indexOf = inverseStore.f26489a.indexOf(str);
                if (indexOf >= 0) {
                    inverseStore = (InverseStore) inverseStore.f26490b.get(indexOf);
                    size--;
                } else if (inverseStore.b(str)) {
                    return null;
                } else {
                    return inverseStore.a();
                }
            }
            return inverseStore.a();
        }

        /* access modifiers changed from: protected */
        public String i() {
            if (this.f26494d.b()) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < this.f26494d.size(); i2++) {
                stringBuffer.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                stringBuffer.append((String) this.f26494d.get(i2));
            }
            return stringBuffer.substring(1);
        }

        public void j(HashMap<String, InverseStore> hashMap) {
            this.f26493c = hashMap;
        }

        public void k(HashMap<String, Node> hashMap) {
            this.f26492b = hashMap;
        }

        public void l(ArrayList<String> arrayList) {
            this.f26491a = arrayList;
        }
    }

    public static class Xml2SomDatasets extends Xml2Som {
        public Xml2SomDatasets(Node node) {
            this.f26491a = new ArrayList<>();
            this.f26492b = new HashMap<>();
            this.f26494d = new Stack2<>();
            this.f26495e = 0;
            this.f26493c = new HashMap<>();
            q(node);
        }

        private static boolean o(Node node) {
            Node namedItemNS = node.getAttributes().getNamedItemNS(XfaForm.f26478j, "dataNode");
            if (namedItemNS != null) {
                String nodeValue = namedItemNS.getNodeValue();
                if ("dataGroup".equals(nodeValue)) {
                    return true;
                }
                if ("dataValue".equals(nodeValue)) {
                    return false;
                }
            }
            if (!node.hasChildNodes()) {
                return false;
            }
            for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                if (firstChild.getNodeType() == 1) {
                    return true;
                }
            }
            return false;
        }

        private void q(Node node) {
            if (node != null) {
                HashMap hashMap = new HashMap();
                for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                    if (firstChild.getNodeType() == 1) {
                        String a2 = Xml2Som.a(firstChild.getLocalName());
                        Integer num = (Integer) hashMap.get(a2);
                        Integer valueOf = num == null ? 0 : Integer.valueOf(num.intValue() + 1);
                        hashMap.put(a2, valueOf);
                        if (o(firstChild)) {
                            Stack2<String> stack2 = this.f26494d;
                            stack2.c(a2 + "[" + valueOf.toString() + "]");
                            q(firstChild);
                        } else {
                            Stack2<String> stack22 = this.f26494d;
                            stack22.c(a2 + "[" + valueOf.toString() + "]");
                            String i2 = i();
                            this.f26491a.add(i2);
                            f(i2);
                            this.f26492b.put(i2, firstChild);
                        }
                        this.f26494d.pop();
                    }
                }
            }
        }

        public Node p(Node node, String str) {
            Stack2<String> m2 = Xml2Som.m(str);
            Document ownerDocument = node.getOwnerDocument();
            Node firstChild = node.getFirstChild();
            while (firstChild.getNodeType() != 1) {
                firstChild = firstChild.getNextSibling();
            }
            Node node2 = null;
            int i2 = 0;
            while (i2 < m2.size()) {
                String str2 = (String) m2.get(i2);
                int lastIndexOf = str2.lastIndexOf(91);
                String substring = str2.substring(0, lastIndexOf);
                int parseInt = Integer.parseInt(str2.substring(lastIndexOf + 1, str2.length() - 1));
                Node firstChild2 = firstChild.getFirstChild();
                int i3 = -1;
                while (firstChild2 != null && (firstChild2.getNodeType() != 1 || !Xml2Som.a(firstChild2.getLocalName()).equals(substring) || (i3 = i3 + 1) != parseInt)) {
                    firstChild2 = firstChild2.getNextSibling();
                }
                while (i3 < parseInt) {
                    firstChild2 = firstChild.appendChild(ownerDocument.createElementNS((String) null, substring));
                    Attr createAttributeNS = ownerDocument.createAttributeNS(XfaForm.f26478j, "dataNode");
                    createAttributeNS.setNodeValue("dataGroup");
                    firstChild2.getAttributes().setNamedItemNS(createAttributeNS);
                    i3++;
                }
                i2++;
                firstChild = firstChild2;
                node2 = firstChild;
            }
            Xml2Som.g(this.f26493c, m2, str);
            this.f26492b.put(str, node2);
            this.f26491a.add(str);
            return node2;
        }
    }

    public static class Xml2SomTemplate extends Xml2Som {

        /* renamed from: f  reason: collision with root package name */
        private boolean f26496f;

        /* renamed from: g  reason: collision with root package name */
        private int f26497g = 0;

        public Xml2SomTemplate(Node node) {
            this.f26491a = new ArrayList<>();
            this.f26492b = new HashMap<>();
            this.f26494d = new Stack2<>();
            this.f26495e = 0;
            this.f26493c = new HashMap<>();
            q(node, (HashMap<String, Integer>) null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x00eb A[SYNTHETIC, Splitter:B:43:0x00eb] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0106 A[SYNTHETIC, Splitter:B:49:0x0106] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0117 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void q(org.w3c.dom.Node r10, java.util.HashMap<java.lang.String, java.lang.Integer> r11) {
            /*
                r9 = this;
                if (r11 != 0) goto L_0x0007
                java.util.HashMap r11 = new java.util.HashMap
                r11.<init>()
            L_0x0007:
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                org.w3c.dom.Node r10 = r10.getFirstChild()
            L_0x0010:
                if (r10 == 0) goto L_0x017e
                short r1 = r10.getNodeType()
                r2 = 1
                if (r1 != r2) goto L_0x0178
                java.lang.String r1 = r10.getLocalName()
                java.lang.String r3 = "subform"
                boolean r3 = r3.equals(r1)
                java.lang.String r4 = "]"
                java.lang.String r5 = "["
                java.lang.String r6 = "name"
                r7 = 0
                if (r3 == 0) goto L_0x00a3
                org.w3c.dom.NamedNodeMap r1 = r10.getAttributes()
                org.w3c.dom.Node r1 = r1.getNamedItem(r6)
                if (r1 == 0) goto L_0x0040
                java.lang.String r1 = r1.getNodeValue()
                java.lang.String r1 = com.itextpdf.text.pdf.XfaForm.Xml2Som.a(r1)
                r3 = 0
                goto L_0x0043
            L_0x0040:
                java.lang.String r1 = "#subform"
                r3 = 1
            L_0x0043:
                if (r3 == 0) goto L_0x0051
                int r6 = r9.f26495e
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                int r7 = r9.f26495e
                int r7 = r7 + r2
                r9.f26495e = r7
                goto L_0x006a
            L_0x0051:
                java.lang.Object r6 = r0.get(r1)
                java.lang.Integer r6 = (java.lang.Integer) r6
                if (r6 != 0) goto L_0x005e
                java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
                goto L_0x0067
            L_0x005e:
                int r6 = r6.intValue()
                int r6 = r6 + r2
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            L_0x0067:
                r0.put(r1, r6)
            L_0x006a:
                com.itextpdf.text.pdf.XfaForm$Stack2<java.lang.String> r7 = r9.f26494d
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                r8.append(r1)
                r8.append(r5)
                java.lang.String r1 = r6.toString()
                r8.append(r1)
                r8.append(r4)
                java.lang.String r1 = r8.toString()
                r7.c(r1)
                int r1 = r9.f26497g
                int r1 = r1 + r2
                r9.f26497g = r1
                if (r3 == 0) goto L_0x0093
                r9.q(r10, r11)
                goto L_0x0097
            L_0x0093:
                r1 = 0
                r9.q(r10, r1)
            L_0x0097:
                int r1 = r9.f26497g
                int r1 = r1 - r2
                r9.f26497g = r1
            L_0x009c:
                com.itextpdf.text.pdf.XfaForm$Stack2<java.lang.String> r1 = r9.f26494d
                r1.pop()
                goto L_0x0178
            L_0x00a3:
                java.lang.String r3 = "field"
                boolean r3 = r3.equals(r1)
                if (r3 != 0) goto L_0x011c
                java.lang.String r3 = "exclGroup"
                boolean r3 = r3.equals(r1)
                if (r3 == 0) goto L_0x00b4
                goto L_0x011c
            L_0x00b4:
                boolean r3 = r9.f26496f
                if (r3 != 0) goto L_0x0178
                int r3 = r9.f26497g
                if (r3 <= 0) goto L_0x0178
                java.lang.String r3 = "occur"
                boolean r1 = r3.equals(r1)
                if (r1 == 0) goto L_0x0178
                org.w3c.dom.NamedNodeMap r1 = r10.getAttributes()
                java.lang.String r3 = "initial"
                org.w3c.dom.Node r1 = r1.getNamedItem(r3)
                if (r1 == 0) goto L_0x00de
                java.lang.String r1 = r1.getNodeValue()     // Catch:{ Exception -> 0x00dd }
                java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x00dd }
                int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x00dd }
                goto L_0x00df
            L_0x00dd:
            L_0x00de:
                r1 = 1
            L_0x00df:
                org.w3c.dom.NamedNodeMap r3 = r10.getAttributes()
                java.lang.String r4 = "min"
                org.w3c.dom.Node r3 = r3.getNamedItem(r4)
                if (r3 == 0) goto L_0x00f9
                java.lang.String r3 = r3.getNodeValue()     // Catch:{ Exception -> 0x00f8 }
                java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x00f8 }
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x00f8 }
                goto L_0x00fa
            L_0x00f8:
            L_0x00f9:
                r3 = 1
            L_0x00fa:
                org.w3c.dom.NamedNodeMap r4 = r10.getAttributes()
                java.lang.String r5 = "max"
                org.w3c.dom.Node r4 = r4.getNamedItem(r5)
                if (r4 == 0) goto L_0x0114
                java.lang.String r4 = r4.getNodeValue()     // Catch:{ Exception -> 0x0113 }
                java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x0113 }
                int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0113 }
                goto L_0x0115
            L_0x0113:
            L_0x0114:
                r4 = 1
            L_0x0115:
                if (r1 != r3) goto L_0x0119
                if (r3 == r4) goto L_0x0178
            L_0x0119:
                r9.f26496f = r2
                goto L_0x0178
            L_0x011c:
                org.w3c.dom.NamedNodeMap r1 = r10.getAttributes()
                org.w3c.dom.Node r1 = r1.getNamedItem(r6)
                if (r1 == 0) goto L_0x0178
                java.lang.String r1 = r1.getNodeValue()
                java.lang.String r1 = com.itextpdf.text.pdf.XfaForm.Xml2Som.a(r1)
                java.lang.Object r3 = r11.get(r1)
                java.lang.Integer r3 = (java.lang.Integer) r3
                if (r3 != 0) goto L_0x013b
                java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
                goto L_0x0144
            L_0x013b:
                int r3 = r3.intValue()
                int r3 = r3 + r2
                java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            L_0x0144:
                r11.put(r1, r2)
                com.itextpdf.text.pdf.XfaForm$Stack2<java.lang.String> r3 = r9.f26494d
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r1)
                r6.append(r5)
                java.lang.String r1 = r2.toString()
                r6.append(r1)
                r6.append(r4)
                java.lang.String r1 = r6.toString()
                r3.c(r1)
                java.lang.String r1 = r9.i()
                java.util.ArrayList<java.lang.String> r2 = r9.f26491a
                r2.add(r1)
                r9.f(r1)
                java.util.HashMap<java.lang.String, org.w3c.dom.Node> r2 = r9.f26492b
                r2.put(r1, r10)
                goto L_0x009c
            L_0x0178:
                org.w3c.dom.Node r10 = r10.getNextSibling()
                goto L_0x0010
            L_0x017e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.XfaForm.Xml2SomTemplate.q(org.w3c.dom.Node, java.util.HashMap):void");
        }

        public String o(String str) {
            Node node = this.f26492b.get(str);
            if (node == null) {
                return null;
            }
            if ("exclGroup".equals(node.getLocalName())) {
                return "exclGroup";
            }
            Node firstChild = node.getFirstChild();
            while (firstChild != null && (firstChild.getNodeType() != 1 || !"ui".equals(firstChild.getLocalName()))) {
                firstChild = firstChild.getNextSibling();
            }
            if (firstChild == null) {
                return null;
            }
            for (Node firstChild2 = firstChild.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNextSibling()) {
                if (firstChild2.getNodeType() == 1 && (!"extras".equals(firstChild2.getLocalName()) || !"picture".equals(firstChild2.getLocalName()))) {
                    return firstChild2.getLocalName();
                }
            }
            return null;
        }

        public boolean p() {
            return this.f26496f;
        }

        public void r(boolean z) {
            this.f26496f = z;
        }
    }

    public XfaForm() {
    }

    public static byte[] A(Node node) throws IOException {
        XmlDomWriter xmlDomWriter = new XmlDomWriter();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlDomWriter.d(byteArrayOutputStream, (String) null);
        xmlDomWriter.c(false);
        xmlDomWriter.g(node);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void J(XfaForm xfaForm, PdfReader pdfReader, PdfWriter pdfWriter) throws IOException {
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.w0(pdfReader.F().d0(PdfName.p3));
        if (pdfDictionary != null) {
            PdfObject x = x(pdfReader);
            if (x.q()) {
                PdfArray pdfArray = (PdfArray) x;
                int i2 = -1;
                int i3 = -1;
                for (int i4 = 0; i4 < pdfArray.size(); i4 += 2) {
                    PdfString P0 = pdfArray.P0(i4);
                    if ("template".equals(P0.toString())) {
                        i2 = i4 + 1;
                    }
                    if ("datasets".equals(P0.toString())) {
                        i3 = i4 + 1;
                    }
                }
                if (i2 > -1 && i3 > -1) {
                    pdfReader.X0(pdfArray.G0(i2));
                    pdfReader.X0(pdfArray.G0(i3));
                    PdfStream pdfStream = new PdfStream(A(xfaForm.f26480b));
                    pdfStream.i1(pdfWriter.a1());
                    pdfArray.V0(i2, pdfWriter.v0(pdfStream).a());
                    PdfStream pdfStream2 = new PdfStream(A(xfaForm.f26482d));
                    pdfStream2.i1(pdfWriter.a1());
                    pdfArray.V0(i3, pdfWriter.v0(pdfStream2).a());
                    pdfDictionary.V0(PdfName.Yh, new PdfArray(pdfArray));
                    return;
                }
            }
            PdfName pdfName = PdfName.Yh;
            pdfReader.X0(pdfDictionary.d0(pdfName));
            PdfStream pdfStream3 = new PdfStream(A(xfaForm.f26486h));
            pdfStream3.i1(pdfWriter.a1());
            pdfDictionary.V0(pdfName, pdfWriter.v0(pdfStream3).a());
        }
    }

    private void a(Node node) {
        while (node.getChildNodes().getLength() == 0) {
            node = node.getNextSibling();
        }
        Element createElement = node.getOwnerDocument().createElement("xfa:datasets");
        createElement.setAttribute("xmlns:xfa", f26478j);
        this.f26482d = createElement;
        node.appendChild(createElement);
    }

    private void b() {
        Map<String, Node> c2 = c(this.f26486h);
        if (c2.containsKey("template")) {
            Node node = c2.get("template");
            this.f26480b = node;
            this.f26479a = new Xml2SomTemplate(node);
        }
        if (c2.containsKey("datasets")) {
            Node node2 = c2.get("datasets");
            this.f26482d = node2;
            this.f26481c = new Xml2SomDatasets(node2.getFirstChild());
        }
        if (this.f26482d == null) {
            a(this.f26486h.getFirstChild());
        }
    }

    public static Map<String, Node> c(Document document) {
        HashMap hashMap = new HashMap();
        Node firstChild = document.getFirstChild();
        while (firstChild.getChildNodes().getLength() == 0) {
            firstChild = firstChild.getNextSibling();
        }
        for (Node firstChild2 = firstChild.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNextSibling()) {
            if (firstChild2.getNodeType() == 1) {
                hashMap.put(firstChild2.getLocalName(), firstChild2);
            }
        }
        return hashMap;
    }

    private Node s(Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            if (childNodes.item(i2).getNodeType() == 1) {
                return childNodes.item(i2);
            }
        }
        return null;
    }

    public static String t(Node node) {
        return node == null ? "" : u(node, "");
    }

    private static String u(Node node, String str) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 1) {
                str = u(firstChild, str);
            } else if (firstChild.getNodeType() == 3) {
                str = str + firstChild.getNodeValue();
            }
        }
        return str;
    }

    public static PdfObject x(PdfReader pdfReader) {
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.w0(pdfReader.F().d0(PdfName.p3));
        if (pdfDictionary == null) {
            return null;
        }
        return PdfReader.w0(pdfDictionary.d0(PdfName.Yh));
    }

    public void B(AcroFieldsSearch acroFieldsSearch) {
        this.f26483e = acroFieldsSearch;
    }

    public void C(boolean z) {
        this.f26487i = z;
    }

    public void D(Xml2SomDatasets xml2SomDatasets) {
        this.f26481c = xml2SomDatasets;
    }

    public void E(Document document) {
        this.f26486h = document;
        b();
    }

    public void F(Node node, String str) {
        if (node != null) {
            while (true) {
                Node firstChild = node.getFirstChild();
                if (firstChild == null) {
                    break;
                }
                node.removeChild(firstChild);
            }
            if (node.getAttributes().getNamedItemNS(f26478j, "dataNode") != null) {
                node.getAttributes().removeNamedItemNS(f26478j, "dataNode");
            }
            node.appendChild(this.f26486h.createTextNode(str));
            this.f26487i = true;
        }
    }

    public void G(PdfReader pdfReader) {
        this.f26484f = pdfReader;
    }

    public void H(Xml2SomTemplate xml2SomTemplate) {
        this.f26479a = xml2SomTemplate;
    }

    public void I(PdfWriter pdfWriter) throws IOException {
        J(this, this.f26484f, pdfWriter);
    }

    public void K(boolean z) {
        this.f26485g = z;
    }

    public void d(File file) throws IOException {
        e(file, false);
    }

    public void e(File file, boolean z) throws IOException {
        g(new FileInputStream(file), z);
    }

    public void f(InputStream inputStream) throws IOException {
        g(inputStream, false);
    }

    public void g(InputStream inputStream, boolean z) throws IOException {
        k(new InputSource(inputStream), z);
    }

    public void h(Node node) {
        i(node, false);
    }

    public void i(Node node, boolean z) {
        Node node2;
        int i2 = 0;
        if (z) {
            NodeList elementsByTagName = this.f26486h.getElementsByTagName("field");
            for (int i3 = 0; i3 < elementsByTagName.getLength(); i3++) {
                ((Element) elementsByTagName.item(i3)).setAttribute("access", "readOnly");
            }
        }
        NodeList childNodes = this.f26482d.getChildNodes();
        int length = childNodes.getLength();
        while (true) {
            if (i2 >= length) {
                node2 = null;
                break;
            }
            node2 = childNodes.item(i2);
            if (node2.getNodeType() == 1 && node2.getLocalName().equals("data") && f26478j.equals(node2.getNamespaceURI())) {
                break;
            }
            i2++;
        }
        if (node2 == null) {
            node2 = this.f26482d.getOwnerDocument().createElementNS(f26478j, "xfa:data");
            this.f26482d.appendChild(node2);
        }
        if (node2.getChildNodes().getLength() == 0) {
            node2.appendChild(this.f26486h.importNode(node, true));
        } else {
            Node s = s(node2);
            if (s != null) {
                node2.replaceChild(this.f26486h.importNode(node, true), s);
            }
        }
        b();
        C(true);
    }

    public void j(InputSource inputSource) throws IOException {
        k(inputSource, false);
    }

    public void k(InputSource inputSource, boolean z) throws IOException {
        try {
            i(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource).getDocumentElement(), z);
        } catch (ParserConfigurationException e2) {
            throw new ExceptionConverter(e2);
        } catch (SAXException e3) {
            throw new ExceptionConverter(e3);
        }
    }

    public String l(String str) {
        return this.f26481c.c().containsKey(str) ? str : this.f26481c.h(Xml2Som.m(str));
    }

    public Node m(String str) {
        String l2;
        if (str == null || (l2 = l(str)) == null) {
            return null;
        }
        return this.f26481c.c().get(l2);
    }

    public String n(String str, AcroFields acroFields) {
        Map<String, AcroFields.Item> t = acroFields.t();
        if (t.containsKey(str)) {
            return str;
        }
        if (this.f26483e == null) {
            if (!t.isEmpty() || !this.f26485g) {
                this.f26483e = new AcroFieldsSearch(t.keySet());
            } else {
                this.f26483e = new AcroFieldsSearch(this.f26481c.c().keySet());
            }
        }
        return this.f26483e.o().containsKey(str) ? this.f26483e.o().get(str) : this.f26483e.h(Xml2Som.m(str));
    }

    public AcroFieldsSearch o() {
        return this.f26483e;
    }

    public Node p() {
        return this.f26482d;
    }

    public Xml2SomDatasets q() {
        return this.f26481c;
    }

    public Document r() {
        return this.f26486h;
    }

    public PdfReader v() {
        return this.f26484f;
    }

    public Xml2SomTemplate w() {
        return this.f26479a;
    }

    public boolean y() {
        return this.f26487i;
    }

    public boolean z() {
        return this.f26485g;
    }

    public XfaForm(PdfReader pdfReader) throws IOException, ParserConfigurationException, SAXException {
        this.f26484f = pdfReader;
        PdfObject x = x(pdfReader);
        if (x == null) {
            this.f26485g = false;
            return;
        }
        this.f26485g = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (x.q()) {
            PdfArray pdfArray = (PdfArray) x;
            for (int i2 = 1; i2 < pdfArray.size(); i2 += 2) {
                PdfObject Q0 = pdfArray.Q0(i2);
                if (Q0 instanceof PRStream) {
                    byteArrayOutputStream.write(PdfReader.D0((PRStream) Q0));
                }
            }
        } else if (x instanceof PRStream) {
            byteArrayOutputStream.write(PdfReader.D0((PRStream) x));
        }
        byteArrayOutputStream.close();
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        this.f26486h = newInstance.newDocumentBuilder().parse(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        b();
    }
}
