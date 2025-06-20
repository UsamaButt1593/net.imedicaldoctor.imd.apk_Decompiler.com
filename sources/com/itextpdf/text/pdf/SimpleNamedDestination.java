package com.itextpdf.text.pdf;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.simpleparser.IanaEncodings;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public final class SimpleNamedDestination implements SimpleXMLDocHandler {
    private HashMap<String, String> X;
    private HashMap<String, String> s;

    private SimpleNamedDestination() {
    }

    static PdfArray b(String str, PdfWriter pdfWriter) {
        PdfArray pdfArray = new PdfArray();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        pdfArray.a0(pdfWriter.A1(Integer.parseInt(stringTokenizer.nextToken())));
        if (!stringTokenizer.hasMoreTokens()) {
            pdfArray.a0(PdfName.f26251fi);
            pdfArray.d0(new float[]{0.0f, 10000.0f, 0.0f});
        } else {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.startsWith("/")) {
                nextToken = nextToken.substring(1);
            }
            pdfArray.a0(new PdfName(nextToken));
            for (int i2 = 0; i2 < 4 && stringTokenizer.hasMoreTokens(); i2++) {
                String nextToken2 = stringTokenizer.nextToken();
                if (nextToken2.equals("null")) {
                    pdfArray.a0(PdfNull.i3);
                } else {
                    pdfArray.a0(new PdfNumber(nextToken2));
                }
            }
        }
        return pdfArray;
    }

    public static String c(String str) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        for (char c2 : str.toCharArray()) {
            if (c2 < ' ') {
                stringBuffer.append(ASCIIPropertyListParser.p);
                String str3 = "00" + Integer.toOctalString(c2);
                str2 = str3.substring(str3.length() - 3);
            } else if (c2 == '\\') {
                str2 = "\\\\";
            } else {
                stringBuffer.append(c2);
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    public static void f(HashMap<String, String> hashMap, OutputStream outputStream, String str, boolean z) throws IOException {
        g(hashMap, new BufferedWriter(new OutputStreamWriter(outputStream, IanaEncodings.a(str))), str, z);
    }

    public static void g(HashMap<String, String> hashMap, Writer writer, String str, boolean z) throws IOException {
        writer.write("<?xml version=\"1.0\" encoding=\"");
        writer.write(XMLUtil.a(str, z));
        writer.write("\"?>\n<Destination>\n");
        for (Map.Entry next : hashMap.entrySet()) {
            writer.write("  <Name Page=\"");
            writer.write(XMLUtil.a((String) next.getValue(), z));
            writer.write("\">");
            writer.write(XMLUtil.a(c((String) next.getKey()), z));
            writer.write("</Name>\n");
        }
        writer.write("</Destination>\n");
        writer.flush();
    }

    public static HashMap<String, String> h(PdfReader pdfReader, boolean z) {
        IntHashtable intHashtable = new IntHashtable();
        int c0 = pdfReader.c0();
        for (int i2 = 1; i2 <= c0; i2++) {
            intHashtable.l(pdfReader.j0(i2).d(), i2);
        }
        HashMap<String, PdfObject> Y = z ? pdfReader.Y() : pdfReader.a0();
        HashMap<String, String> hashMap = new HashMap<>(Y.size());
        for (Map.Entry next : Y.entrySet()) {
            PdfArray pdfArray = (PdfArray) next.getValue();
            StringBuffer stringBuffer = new StringBuffer();
            try {
                stringBuffer.append(intHashtable.e(pdfArray.G0(0).d()));
                stringBuffer.append(' ');
                stringBuffer.append(pdfArray.T0(1).toString().substring(1));
                for (int i3 = 2; i3 < pdfArray.size(); i3++) {
                    stringBuffer.append(' ');
                    stringBuffer.append(pdfArray.T0(i3).toString());
                }
                hashMap.put(next.getKey(), stringBuffer.toString());
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    public static HashMap<String, String> i(InputStream inputStream) throws IOException {
        SimpleNamedDestination simpleNamedDestination = new SimpleNamedDestination();
        SimpleXMLParser.h(simpleNamedDestination, inputStream);
        return simpleNamedDestination.s;
    }

    public static HashMap<String, String> j(Reader reader) throws IOException {
        SimpleNamedDestination simpleNamedDestination = new SimpleNamedDestination();
        SimpleXMLParser.i(simpleNamedDestination, reader);
        return simpleNamedDestination.s;
    }

    public static PdfDictionary k(HashMap<String, String> hashMap, PdfWriter pdfWriter) {
        PdfDictionary pdfDictionary = new PdfDictionary();
        for (Map.Entry next : hashMap.entrySet()) {
            try {
                pdfDictionary.V0(new PdfName((String) next.getKey()), b((String) next.getValue(), pdfWriter));
            } catch (Exception unused) {
            }
        }
        return pdfDictionary;
    }

    public static PdfDictionary l(HashMap<String, String> hashMap, PdfWriter pdfWriter) throws IOException {
        HashMap hashMap2 = new HashMap(hashMap.size());
        for (Map.Entry next : hashMap.entrySet()) {
            try {
                hashMap2.put(next.getKey(), pdfWriter.v0(b((String) next.getValue(), pdfWriter)).a());
            } catch (Exception unused) {
            }
        }
        return PdfNameTree.c(hashMap2, pdfWriter);
    }

    public static String m(String str) {
        char c2;
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char c3 = charArray[i2];
            if (c3 == '\\') {
                int i3 = i2 + 1;
                if (i3 >= length) {
                    stringBuffer.append(ASCIIPropertyListParser.p);
                    break;
                }
                char c4 = charArray[i3];
                if (c4 < '0' || c4 > '7') {
                    stringBuffer.append(c4);
                    i2 = i3;
                    i2++;
                } else {
                    int i4 = c4 - '0';
                    int i5 = i2 + 2;
                    for (int i6 = 0; i6 < 2 && i5 < length && (c2 = charArray[i5]) >= '0' && c2 <= '7'; i6++) {
                        i5++;
                        i4 = ((i4 * 8) + c2) - 48;
                    }
                    i2 = i5 - 1;
                    c3 = (char) i4;
                }
            }
            stringBuffer.append(c3);
            i2++;
        }
        return stringBuffer.toString();
    }

    public void a(String str) {
        HashMap<String, String> hashMap = this.X;
        if (hashMap != null) {
            this.X.put("Name", hashMap.get("Name") + str);
        }
    }

    public void d(String str) {
        if (str.equals("Destination")) {
            if (this.X != null || this.s == null) {
                throw new RuntimeException(MessageLocalization.b("destination.end.tag.out.of.place", new Object[0]));
            }
        } else if (str.equals("Name")) {
            HashMap<String, String> hashMap = this.X;
            if (hashMap == null || this.s == null) {
                throw new RuntimeException(MessageLocalization.b("name.end.tag.out.of.place", new Object[0]));
            } else if (hashMap.containsKey("Page")) {
                this.s.put(m(this.X.get("Name")), this.X.get("Page"));
                this.X = null;
            } else {
                throw new RuntimeException(MessageLocalization.b("page.attribute.missing", new Object[0]));
            }
        } else {
            throw new RuntimeException(MessageLocalization.b("invalid.end.tag.1", str));
        }
    }

    public void e(String str, Map<String, String> map) {
        if (this.s == null) {
            if (str.equals("Destination")) {
                this.s = new HashMap<>();
                return;
            }
            throw new RuntimeException(MessageLocalization.b("root.element.is.not.destination", new Object[0]));
        } else if (!str.equals("Name")) {
            throw new RuntimeException(MessageLocalization.b("tag.1.not.allowed", str));
        } else if (this.X == null) {
            HashMap<String, String> hashMap = new HashMap<>(map);
            this.X = hashMap;
            hashMap.put("Name", "");
        } else {
            throw new RuntimeException(MessageLocalization.b("nested.tags.are.not.allowed", new Object[0]));
        }
    }

    public void endDocument() {
    }

    public void startDocument() {
    }
}
