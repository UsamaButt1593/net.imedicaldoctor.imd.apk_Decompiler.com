package org.ccil.cowan.tagsoup;

import com.itextpdf.tool.xml.html.HTML;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

public class CommandLine {

    /* renamed from: a  reason: collision with root package name */
    static Hashtable f31465a;

    /* renamed from: b  reason: collision with root package name */
    private static Parser f31466b = null;

    /* renamed from: c  reason: collision with root package name */
    private static HTMLSchema f31467c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f31468d = null;

    static {
        Hashtable hashtable = new Hashtable();
        f31465a = hashtable;
        Boolean bool = Boolean.FALSE;
        hashtable.put("--nocdata", bool);
        f31465a.put("--files", bool);
        f31465a.put("--reuse", bool);
        f31465a.put("--nons", bool);
        f31465a.put("--nobogons", bool);
        f31465a.put("--any", bool);
        f31465a.put("--emptybogons", bool);
        f31465a.put("--norootbogons", bool);
        f31465a.put("--pyxin", bool);
        f31465a.put("--lexical", bool);
        f31465a.put("--pyx", bool);
        f31465a.put("--html", bool);
        f31465a.put("--method=", bool);
        f31465a.put("--doctype-public=", bool);
        f31465a.put("--doctype-system=", bool);
        f31465a.put("--output-encoding=", bool);
        f31465a.put("--omit-xml-declaration", bool);
        f31465a.put("--encoding=", bool);
        f31465a.put("--help", bool);
        f31465a.put("--version", bool);
        f31465a.put("--nodefaults", bool);
        f31465a.put("--nocolons", bool);
        f31465a.put("--norestart", bool);
        f31465a.put("--ignorable", bool);
    }

    private static ContentHandler a(Writer writer) {
        String str;
        String str2;
        String str3;
        if (d(f31465a, "--pyx")) {
            return new PYXWriter(writer);
        }
        XMLWriter xMLWriter = new XMLWriter(writer);
        if (d(f31465a, "--html")) {
            xMLWriter.u(XMLWriter.A, HTML.Tag.y);
            xMLWriter.u(XMLWriter.B, "yes");
        }
        if (d(f31465a, "--method=") && (str3 = (String) f31465a.get("--method=")) != null) {
            xMLWriter.u(XMLWriter.A, str3);
        }
        if (d(f31465a, "--doctype-public=") && (str2 = (String) f31465a.get("--doctype-public=")) != null) {
            xMLWriter.u(XMLWriter.v, str2);
        }
        if (d(f31465a, "--doctype-system=") && (str = (String) f31465a.get("--doctype-system=")) != null) {
            xMLWriter.u(XMLWriter.w, str);
        }
        if (d(f31465a, "--output-encoding=")) {
            String str4 = (String) f31465a.get("--output-encoding=");
            f31468d = str4;
            if (str4 != null) {
                xMLWriter.u("encoding", str4);
            }
        }
        if (d(f31465a, "--omit-xml-declaration")) {
            xMLWriter.u(XMLWriter.B, "yes");
        }
        xMLWriter.v(f31467c.g(), "");
        return xMLWriter;
    }

    private static void b() {
        PrintStream printStream = System.err;
        printStream.print("usage: java -jar tagsoup-*.jar ");
        printStream.print(" [ ");
        Enumeration keys = f31465a.keys();
        boolean z = true;
        while (keys.hasMoreElements()) {
            if (!z) {
                System.err.print("| ");
            }
            String str = (String) keys.nextElement();
            PrintStream printStream2 = System.err;
            printStream2.print(str);
            if (str.endsWith("=")) {
                printStream2.print("?");
            }
            printStream2.print(StringUtils.SPACE);
            z = false;
        }
        System.err.println("]*");
    }

    private static int c(Hashtable hashtable, String[] strArr) {
        String str;
        int i2 = 0;
        while (i2 < strArr.length) {
            String str2 = strArr[i2];
            if (str2.charAt(0) != '-') {
                break;
            }
            int indexOf = str2.indexOf(61);
            if (indexOf != -1) {
                int i3 = indexOf + 1;
                str = str2.substring(i3, str2.length());
                str2 = str2.substring(0, i3);
            } else {
                str = null;
            }
            if (!hashtable.containsKey(str2)) {
                PrintStream printStream = System.err;
                printStream.print("Unknown option ");
                printStream.println(str2);
                System.exit(1);
            } else if (str == null) {
                hashtable.put(str2, Boolean.TRUE);
            } else {
                hashtable.put(str2, str);
            }
            i2++;
        }
        return i2;
    }

    private static boolean d(Hashtable hashtable, String str) {
        return Boolean.getBoolean(str) || hashtable.get(str) != Boolean.FALSE;
    }

    public static void e(String[] strArr) throws IOException, SAXException {
        String str;
        StringBuffer stringBuffer;
        int c2 = c(f31465a, strArr);
        if (d(f31465a, "--help")) {
            b();
        } else if (d(f31465a, "--version")) {
            System.err.println("TagSoup version 1.2.1");
        } else if (strArr.length == c2) {
            f("", System.out);
        } else if (d(f31465a, "--files")) {
            while (c2 < strArr.length) {
                String str2 = strArr[c2];
                int lastIndexOf = str2.lastIndexOf(46);
                if (lastIndexOf == -1) {
                    stringBuffer = new StringBuffer();
                    stringBuffer.append(str2);
                    stringBuffer.append(".xhtml");
                } else if (str2.endsWith(".xhtml")) {
                    stringBuffer = new StringBuffer();
                    stringBuffer.append(str2);
                    stringBuffer.append("_");
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(str2.substring(0, lastIndexOf));
                    stringBuffer2.append(".xhtml");
                    str = stringBuffer2.toString();
                    PrintStream printStream = System.err;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("src: ");
                    stringBuffer3.append(str2);
                    stringBuffer3.append(" dst: ");
                    stringBuffer3.append(str);
                    printStream.println(stringBuffer3.toString());
                    f(str2, new FileOutputStream(str));
                    c2++;
                }
                str = stringBuffer.toString();
                PrintStream printStream2 = System.err;
                StringBuffer stringBuffer32 = new StringBuffer();
                stringBuffer32.append("src: ");
                stringBuffer32.append(str2);
                stringBuffer32.append(" dst: ");
                stringBuffer32.append(str);
                printStream2.println(stringBuffer32.toString());
                f(str2, new FileOutputStream(str));
                c2++;
            }
        } else {
            while (c2 < strArr.length) {
                PrintStream printStream3 = System.err;
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("src: ");
                stringBuffer4.append(strArr[c2]);
                printStream3.println(stringBuffer4.toString());
                f(strArr[c2], System.out);
                c2++;
            }
        }
    }

    private static void f(String str, OutputStream outputStream) throws IOException, SAXException {
        Parser parser;
        String str2;
        if (d(f31465a, "--reuse")) {
            if (f31466b == null) {
                f31466b = new Parser();
            }
            parser = f31466b;
        } else {
            parser = new Parser();
        }
        HTMLSchema hTMLSchema = new HTMLSchema();
        f31467c = hTMLSchema;
        parser.setProperty(Parser.n0, hTMLSchema);
        if (d(f31465a, "--nocdata")) {
            parser.setFeature(Parser.k0, false);
        }
        if (d(f31465a, "--nons") || d(f31465a, "--html")) {
            parser.setFeature(Parser.O, false);
        }
        if (d(f31465a, "--nobogons")) {
            parser.setFeature(Parser.d0, true);
        }
        if (d(f31465a, "--any")) {
            parser.setFeature(Parser.e0, false);
        } else if (d(f31465a, "--emptybogons")) {
            parser.setFeature(Parser.e0, true);
        }
        if (d(f31465a, "--norootbogons")) {
            parser.setFeature(Parser.f0, false);
        }
        if (d(f31465a, "--nodefaults")) {
            parser.setFeature(Parser.g0, false);
        }
        if (d(f31465a, "--nocolons")) {
            parser.setFeature(Parser.h0, true);
        }
        if (d(f31465a, "--norestart")) {
            parser.setFeature(Parser.i0, false);
        }
        if (d(f31465a, "--ignorable")) {
            parser.setFeature(Parser.j0, true);
        }
        if (d(f31465a, "--pyxin")) {
            parser.setProperty(Parser.m0, new PYXScanner());
        }
        ContentHandler a2 = a(f31468d == null ? new OutputStreamWriter(outputStream) : new OutputStreamWriter(outputStream, f31468d));
        parser.setContentHandler(a2);
        if (d(f31465a, "--lexical") && (a2 instanceof LexicalHandler)) {
            parser.setProperty(Parser.l0, a2);
        }
        InputSource inputSource = new InputSource();
        if (str != "") {
            inputSource.setSystemId(str);
        } else {
            inputSource.setByteStream(System.in);
        }
        if (d(f31465a, "--encoding=") && (str2 = (String) f31465a.get("--encoding=")) != null) {
            inputSource.setEncoding(str2);
        }
        parser.parse(inputSource);
    }
}
