package com.itextpdf.text.xml;

import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandlerComment;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class XmlToTxt implements SimpleXMLDocHandler {
    protected StringBuffer s = new StringBuffer();

    protected XmlToTxt() {
    }

    public static String b(InputStream inputStream) throws IOException {
        XmlToTxt xmlToTxt = new XmlToTxt();
        SimpleXMLParser.g(xmlToTxt, (SimpleXMLDocHandlerComment) null, new InputStreamReader(inputStream), true);
        return xmlToTxt.toString();
    }

    public void a(String str) {
        this.s.append(str);
    }

    public void d(String str) {
    }

    public void e(String str, Map<String, String> map) {
    }

    public void endDocument() {
    }

    public void startDocument() {
    }

    public String toString() {
        return this.s.toString();
    }
}
