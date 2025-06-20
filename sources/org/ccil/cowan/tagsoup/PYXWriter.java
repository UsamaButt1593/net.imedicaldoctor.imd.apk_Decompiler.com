package org.ccil.cowan.tagsoup;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.PrintWriter;
import java.io.Writer;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

public class PYXWriter implements ScanHandler, ContentHandler, LexicalHandler {

    /* renamed from: c  reason: collision with root package name */
    private static char[] f31510c = new char[1];

    /* renamed from: a  reason: collision with root package name */
    private PrintWriter f31511a;

    /* renamed from: b  reason: collision with root package name */
    private String f31512b;

    public PYXWriter(Writer writer) {
        if (writer instanceof PrintWriter) {
            this.f31511a = (PrintWriter) writer;
        } else {
            this.f31511a = new PrintWriter(writer);
        }
    }

    public void a(char[] cArr, int i2, int i3) throws SAXException {
        PrintWriter printWriter;
        String str;
        if (i3 != 0) {
            int i4 = i3 + i2;
            boolean z = false;
            while (i2 < i4) {
                if (cArr[i2] == 10) {
                    if (z) {
                        this.f31511a.println();
                    }
                    this.f31511a.println("-\\n");
                    z = false;
                } else {
                    if (!z) {
                        this.f31511a.print('-');
                    }
                    char c2 = cArr[i2];
                    if (c2 == 9) {
                        printWriter = this.f31511a;
                        str = "\\t";
                    } else if (c2 != '\\') {
                        this.f31511a.print(c2);
                        z = true;
                    } else {
                        printWriter = this.f31511a;
                        str = "\\\\";
                    }
                    printWriter.print(str);
                    z = true;
                }
                i2++;
            }
            if (z) {
                this.f31511a.println();
            }
        }
    }

    public void b(char[] cArr, int i2, int i3) throws SAXException {
        this.f31511a.print('?');
        this.f31511a.write(cArr, i2, i3);
        this.f31511a.write(32);
    }

    public int c() {
        return 0;
    }

    public void characters(char[] cArr, int i2, int i3) throws SAXException {
        a(cArr, i2, i3);
    }

    public void comment(char[] cArr, int i2, int i3) throws SAXException {
        j(cArr, i2, i3);
    }

    public void d(char[] cArr, int i2, int i3) throws SAXException {
        this.f31511a.println("!");
    }

    public void e(char[] cArr, int i2, int i3) throws SAXException {
    }

    public void endCDATA() throws SAXException {
    }

    public void endDTD() throws SAXException {
    }

    public void endDocument() throws SAXException {
        this.f31511a.close();
    }

    public void endElement(String str, String str2, String str3) throws SAXException {
        if (str3.length() != 0) {
            str2 = str3;
        }
        this.f31511a.print(ASCIIPropertyListParser.f18650h);
        this.f31511a.println(str2);
    }

    public void endEntity(String str) throws SAXException {
    }

    public void endPrefixMapping(String str) throws SAXException {
    }

    public void f(char[] cArr, int i2, int i3) throws SAXException {
    }

    public void g(char[] cArr, int i2, int i3) throws SAXException {
        this.f31511a.close();
    }

    public void h(char[] cArr, int i2, int i3) throws SAXException {
        this.f31511a.write(cArr, i2, i3);
        this.f31511a.println();
    }

    public void i(char[] cArr, int i2, int i3) throws SAXException {
        this.f31511a.print(ASCIIPropertyListParser.f18650h);
        this.f31511a.write(cArr, i2, i3);
        this.f31511a.println();
    }

    public void ignorableWhitespace(char[] cArr, int i2, int i3) throws SAXException {
        characters(cArr, i2, i3);
    }

    public void j(char[] cArr, int i2, int i3) throws SAXException {
    }

    public void k(char[] cArr, int i2, int i3) throws SAXException {
        this.f31511a.print('A');
        this.f31511a.write(cArr, i2, i3);
        this.f31511a.print(' ');
        this.f31512b = new String(cArr, i2, i3);
    }

    public void l(char[] cArr, int i2, int i3) throws SAXException {
    }

    public void m(char[] cArr, int i2, int i3) throws SAXException {
        a(cArr, i2, i3);
    }

    public void n(char[] cArr, int i2, int i3) throws SAXException {
        this.f31511a.println(this.f31512b);
        this.f31512b = null;
    }

    public void o(char[] cArr, int i2, int i3) throws SAXException {
        this.f31511a.write(cArr, i2, i3);
        this.f31511a.println();
        this.f31512b = null;
    }

    public void p(char[] cArr, int i2, int i3) throws SAXException {
        this.f31511a.print(ASCIIPropertyListParser.f18649g);
        this.f31511a.write(cArr, i2, i3);
        this.f31511a.println();
    }

    public void processingInstruction(String str, String str2) throws SAXException {
        this.f31511a.print('?');
        this.f31511a.print(str);
        this.f31511a.print(' ');
        this.f31511a.println(str2);
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String str) throws SAXException {
    }

    public void startCDATA() throws SAXException {
    }

    public void startDTD(String str, String str2, String str3) throws SAXException {
    }

    public void startDocument() throws SAXException {
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (str3.length() != 0) {
            str2 = str3;
        }
        this.f31511a.print(ASCIIPropertyListParser.f18649g);
        this.f31511a.println(str2);
        int length = attributes.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            String qName = attributes.getQName(i2);
            if (qName.length() == 0) {
                qName = attributes.getLocalName(i2);
            }
            this.f31511a.print('A');
            this.f31511a.print(qName);
            this.f31511a.print(' ');
            this.f31511a.println(attributes.getValue(i2));
        }
    }

    public void startEntity(String str) throws SAXException {
    }

    public void startPrefixMapping(String str, String str2) throws SAXException {
    }
}
