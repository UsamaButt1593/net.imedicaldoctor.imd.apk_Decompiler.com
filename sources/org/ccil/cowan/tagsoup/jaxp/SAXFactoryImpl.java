package org.ccil.cowan.tagsoup.jaxp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public class SAXFactoryImpl extends SAXParserFactory {

    /* renamed from: a  reason: collision with root package name */
    private SAXParserImpl f31546a = null;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f31547b = null;

    private SAXParserImpl a() {
        if (this.f31546a == null) {
            this.f31546a = new SAXParserImpl();
        }
        return this.f31546a;
    }

    public boolean getFeature(String str) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException {
        return a().a(str);
    }

    public SAXParser newSAXParser() throws ParserConfigurationException {
        try {
            return SAXParserImpl.b(this.f31547b);
        } catch (SAXException e2) {
            throw new ParserConfigurationException(e2.getMessage());
        }
    }

    public void setFeature(String str, boolean z) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException {
        a().c(str, z);
        if (this.f31547b == null) {
            this.f31547b = new LinkedHashMap();
        }
        this.f31547b.put(str, z ? Boolean.TRUE : Boolean.FALSE);
    }
}
