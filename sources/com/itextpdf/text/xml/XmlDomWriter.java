package com.itextpdf.text.xml;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;

public class XmlDomWriter {

    /* renamed from: a  reason: collision with root package name */
    protected PrintWriter f27374a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f27375b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f27376c;

    public XmlDomWriter() {
    }

    /* access modifiers changed from: protected */
    public void a(char c2, boolean z) {
        PrintWriter printWriter;
        String str;
        if (c2 == 10) {
            if (this.f27375b) {
                printWriter = this.f27374a;
                str = "&#xA;";
            }
            if (this.f27376c) {
            }
            this.f27374a.print(c2);
            return;
        } else if (c2 == 13) {
            printWriter = this.f27374a;
            str = "&#xD;";
        } else if (c2 == '\"') {
            printWriter = this.f27374a;
            str = z ? "&quot;" : "\"";
        } else if (c2 == '&') {
            printWriter = this.f27374a;
            str = "&amp;";
        } else if (c2 != '<') {
            if (c2 == '>') {
                printWriter = this.f27374a;
                str = "&gt;";
            }
            if ((this.f27376c || ((c2 < 1 || c2 > 31 || c2 == 9 || c2 == 10) && ((c2 < 127 || c2 > 159) && c2 != 8232))) && (!z || !(c2 == 9 || c2 == 10))) {
                this.f27374a.print(c2);
                return;
            }
            this.f27374a.print("&#x");
            this.f27374a.print(Integer.toHexString(c2).toUpperCase());
            printWriter = this.f27374a;
            str = ";";
        } else {
            printWriter = this.f27374a;
            str = "&lt;";
        }
        printWriter.print(str);
    }

    /* access modifiers changed from: protected */
    public void b(String str, boolean z) {
        int length = str != null ? str.length() : 0;
        for (int i2 = 0; i2 < length; i2++) {
            a(str.charAt(i2), z);
        }
    }

    public void c(boolean z) {
        this.f27375b = z;
    }

    public void d(OutputStream outputStream, String str) throws UnsupportedEncodingException {
        if (str == null) {
            str = "UTF8";
        }
        this.f27374a = new PrintWriter(new OutputStreamWriter(outputStream, str));
    }

    public void e(Writer writer) {
        this.f27374a = writer instanceof PrintWriter ? (PrintWriter) writer : new PrintWriter(writer);
    }

    /* access modifiers changed from: protected */
    public Attr[] f(NamedNodeMap namedNodeMap) {
        int i2 = 0;
        int length = namedNodeMap != null ? namedNodeMap.getLength() : 0;
        Attr[] attrArr = new Attr[length];
        for (int i3 = 0; i3 < length; i3++) {
            attrArr[i3] = (Attr) namedNodeMap.item(i3);
        }
        while (i2 < length - 1) {
            String nodeName = attrArr[i2].getNodeName();
            int i4 = i2 + 1;
            int i5 = i2;
            for (int i6 = i4; i6 < length; i6++) {
                String nodeName2 = attrArr[i6].getNodeName();
                if (nodeName2.compareTo(nodeName) < 0) {
                    i5 = i6;
                    nodeName = nodeName2;
                }
            }
            if (i5 != i2) {
                Attr attr = attrArr[i2];
                attrArr[i2] = attrArr[i5];
                attrArr[i5] = attr;
            }
            i2 = i4;
        }
        return attrArr;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bb, code lost:
        r1.print(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00be, code lost:
        r9.f27374a.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0134, code lost:
        b(r10.getNodeValue(), false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0197, code lost:
        if (r0 != 1) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0199, code lost:
        r9.f27374a.print("</");
        r9.f27374a.print(r10.getNodeName());
        r9.f27374a.print('>');
        r9.f27374a.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(org.w3c.dom.Node r10) {
        /*
            r9 = this;
            if (r10 != 0) goto L_0x0003
            return
        L_0x0003:
            short r0 = r10.getNodeType()
            r1 = 32
            r2 = 1
            r3 = 62
            r4 = 0
            switch(r0) {
                case 1: goto L_0x013c;
                case 2: goto L_0x0010;
                case 3: goto L_0x0134;
                case 4: goto L_0x011a;
                case 5: goto L_0x00f0;
                case 6: goto L_0x0010;
                case 7: goto L_0x00c5;
                case 8: goto L_0x009b;
                case 9: goto L_0x0076;
                case 10: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0197
        L_0x0012:
            r1 = r10
            org.w3c.dom.DocumentType r1 = (org.w3c.dom.DocumentType) r1
            java.io.PrintWriter r4 = r9.f27374a
            java.lang.String r5 = "<!DOCTYPE "
            r4.print(r5)
            java.io.PrintWriter r4 = r9.f27374a
            java.lang.String r5 = r1.getName()
            r4.print(r5)
            java.lang.String r4 = r1.getPublicId()
            java.lang.String r5 = r1.getSystemId()
            r6 = 39
            if (r4 == 0) goto L_0x004f
            java.io.PrintWriter r7 = r9.f27374a
            java.lang.String r8 = " PUBLIC '"
            r7.print(r8)
            java.io.PrintWriter r7 = r9.f27374a
            r7.print(r4)
            java.io.PrintWriter r4 = r9.f27374a
            java.lang.String r7 = "' '"
        L_0x0041:
            r4.print(r7)
            java.io.PrintWriter r4 = r9.f27374a
            r4.print(r5)
            java.io.PrintWriter r4 = r9.f27374a
            r4.print(r6)
            goto L_0x0056
        L_0x004f:
            if (r5 == 0) goto L_0x0056
            java.io.PrintWriter r4 = r9.f27374a
            java.lang.String r7 = " SYSTEM '"
            goto L_0x0041
        L_0x0056:
            java.lang.String r1 = r1.getInternalSubset()
            if (r1 == 0) goto L_0x006f
            java.io.PrintWriter r4 = r9.f27374a
            java.lang.String r5 = " ["
            r4.println(r5)
            java.io.PrintWriter r4 = r9.f27374a
            r4.print(r1)
            java.io.PrintWriter r1 = r9.f27374a
            r4 = 93
            r1.print(r4)
        L_0x006f:
            java.io.PrintWriter r1 = r9.f27374a
            r1.println(r3)
            goto L_0x0197
        L_0x0076:
            r1 = r10
            org.w3c.dom.Document r1 = (org.w3c.dom.Document) r1
            r9.f27376c = r4
            boolean r4 = r9.f27375b
            if (r4 != 0) goto L_0x0092
            java.io.PrintWriter r4 = r9.f27374a
            java.lang.String r5 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            r4.println(r5)
            java.io.PrintWriter r4 = r9.f27374a
            r4.flush()
            org.w3c.dom.DocumentType r4 = r1.getDoctype()
            r9.g(r4)
        L_0x0092:
            org.w3c.dom.Element r1 = r1.getDocumentElement()
            r9.g(r1)
            goto L_0x0197
        L_0x009b:
            boolean r1 = r9.f27375b
            if (r1 != 0) goto L_0x0197
            java.io.PrintWriter r1 = r9.f27374a
            java.lang.String r4 = "<!--"
            r1.print(r4)
            java.lang.String r1 = r10.getNodeValue()
            if (r1 == 0) goto L_0x00b7
            int r4 = r1.length()
            if (r4 <= 0) goto L_0x00b7
            java.io.PrintWriter r4 = r9.f27374a
            r4.print(r1)
        L_0x00b7:
            java.io.PrintWriter r1 = r9.f27374a
            java.lang.String r4 = "-->"
        L_0x00bb:
            r1.print(r4)
        L_0x00be:
            java.io.PrintWriter r1 = r9.f27374a
            r1.flush()
            goto L_0x0197
        L_0x00c5:
            java.io.PrintWriter r4 = r9.f27374a
            java.lang.String r5 = "<?"
            r4.print(r5)
            java.io.PrintWriter r4 = r9.f27374a
            java.lang.String r5 = r10.getNodeName()
            r4.print(r5)
            java.lang.String r4 = r10.getNodeValue()
            if (r4 == 0) goto L_0x00eb
            int r5 = r4.length()
            if (r5 <= 0) goto L_0x00eb
            java.io.PrintWriter r5 = r9.f27374a
            r5.print(r1)
            java.io.PrintWriter r1 = r9.f27374a
            r1.print(r4)
        L_0x00eb:
            java.io.PrintWriter r1 = r9.f27374a
            java.lang.String r4 = "?>"
            goto L_0x00bb
        L_0x00f0:
            boolean r1 = r9.f27375b
            if (r1 == 0) goto L_0x0102
            org.w3c.dom.Node r1 = r10.getFirstChild()
        L_0x00f8:
            if (r1 == 0) goto L_0x0197
            r9.g(r1)
            org.w3c.dom.Node r1 = r1.getNextSibling()
            goto L_0x00f8
        L_0x0102:
            java.io.PrintWriter r1 = r9.f27374a
            r4 = 38
            r1.print(r4)
            java.io.PrintWriter r1 = r9.f27374a
            java.lang.String r4 = r10.getNodeName()
            r1.print(r4)
            java.io.PrintWriter r1 = r9.f27374a
            r4 = 59
            r1.print(r4)
            goto L_0x00be
        L_0x011a:
            boolean r1 = r9.f27375b
            if (r1 == 0) goto L_0x011f
            goto L_0x0134
        L_0x011f:
            java.io.PrintWriter r1 = r9.f27374a
            java.lang.String r4 = "<![CDATA["
            r1.print(r4)
            java.io.PrintWriter r1 = r9.f27374a
            java.lang.String r4 = r10.getNodeValue()
            r1.print(r4)
            java.io.PrintWriter r1 = r9.f27374a
            java.lang.String r4 = "]]>"
            goto L_0x00bb
        L_0x0134:
            java.lang.String r1 = r10.getNodeValue()
            r9.b(r1, r4)
            goto L_0x00be
        L_0x013c:
            java.io.PrintWriter r5 = r9.f27374a
            r6 = 60
            r5.print(r6)
            java.io.PrintWriter r5 = r9.f27374a
            java.lang.String r6 = r10.getNodeName()
            r5.print(r6)
            org.w3c.dom.NamedNodeMap r5 = r10.getAttributes()
            org.w3c.dom.Attr[] r5 = r9.f(r5)
        L_0x0154:
            int r6 = r5.length
            if (r4 >= r6) goto L_0x017f
            r6 = r5[r4]
            java.io.PrintWriter r7 = r9.f27374a
            r7.print(r1)
            java.io.PrintWriter r7 = r9.f27374a
            java.lang.String r8 = r6.getNodeName()
            r7.print(r8)
            java.io.PrintWriter r7 = r9.f27374a
            java.lang.String r8 = "=\""
            r7.print(r8)
            java.lang.String r6 = r6.getNodeValue()
            r9.b(r6, r2)
            java.io.PrintWriter r6 = r9.f27374a
            r7 = 34
            r6.print(r7)
            int r4 = r4 + 1
            goto L_0x0154
        L_0x017f:
            java.io.PrintWriter r1 = r9.f27374a
            r1.print(r3)
            java.io.PrintWriter r1 = r9.f27374a
            r1.flush()
            org.w3c.dom.Node r1 = r10.getFirstChild()
        L_0x018d:
            if (r1 == 0) goto L_0x0197
            r9.g(r1)
            org.w3c.dom.Node r1 = r1.getNextSibling()
            goto L_0x018d
        L_0x0197:
            if (r0 != r2) goto L_0x01b3
            java.io.PrintWriter r0 = r9.f27374a
            java.lang.String r1 = "</"
            r0.print(r1)
            java.io.PrintWriter r0 = r9.f27374a
            java.lang.String r10 = r10.getNodeName()
            r0.print(r10)
            java.io.PrintWriter r10 = r9.f27374a
            r10.print(r3)
            java.io.PrintWriter r10 = r9.f27374a
            r10.flush()
        L_0x01b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.xml.XmlDomWriter.g(org.w3c.dom.Node):void");
    }

    public XmlDomWriter(boolean z) {
        this.f27375b = z;
    }
}
