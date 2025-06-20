package org.ccil.cowan.tagsoup.jaxp;

import java.util.Map;
import javax.xml.parsers.SAXParser;
import org.ccil.cowan.tagsoup.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

public class SAXParserImpl extends SAXParser {

    /* renamed from: a  reason: collision with root package name */
    final Parser f31548a = new Parser();

    protected SAXParserImpl() {
    }

    public static SAXParserImpl b(Map map) throws SAXException {
        SAXParserImpl sAXParserImpl = new SAXParserImpl();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                sAXParserImpl.c((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
            }
        }
        return sAXParserImpl;
    }

    public boolean a(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        return this.f31548a.getFeature(str);
    }

    public void c(String str, boolean z) throws SAXNotRecognizedException, SAXNotSupportedException {
        this.f31548a.setFeature(str, z);
    }

    public org.xml.sax.Parser getParser() throws SAXException {
        return new SAX1ParserAdapter(this.f31548a);
    }

    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        return this.f31548a.getProperty(str);
    }

    public XMLReader getXMLReader() {
        return this.f31548a;
    }

    public boolean isNamespaceAware() {
        try {
            return this.f31548a.getFeature(Parser.O);
        } catch (SAXException e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    public boolean isValidating() {
        try {
            return this.f31548a.getFeature(Parser.Z);
        } catch (SAXException e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        this.f31548a.setProperty(str, obj);
    }
}
