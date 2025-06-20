package org.ccil.cowan.tagsoup.jaxp;

import java.io.IOException;
import java.util.Locale;
import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

public class SAX1ParserAdapter implements Parser {

    /* renamed from: a  reason: collision with root package name */
    final XMLReader f31542a;

    static final class AttributesWrapper implements AttributeList {

        /* renamed from: a  reason: collision with root package name */
        Attributes f31543a;

        public void a(Attributes attributes) {
            this.f31543a = attributes;
        }

        public int getLength() {
            return this.f31543a.getLength();
        }

        public String getName(int i2) {
            String qName = this.f31543a.getQName(i2);
            return qName == null ? this.f31543a.getLocalName(i2) : qName;
        }

        public String getType(int i2) {
            return this.f31543a.getType(i2);
        }

        public String getValue(int i2) {
            return this.f31543a.getValue(i2);
        }

        public String getType(String str) {
            return this.f31543a.getType(str);
        }

        public String getValue(String str) {
            return this.f31543a.getValue(str);
        }
    }

    static final class DocHandlerWrapper implements ContentHandler {

        /* renamed from: a  reason: collision with root package name */
        final DocumentHandler f31544a;

        /* renamed from: b  reason: collision with root package name */
        final AttributesWrapper f31545b = new AttributesWrapper();

        DocHandlerWrapper(DocumentHandler documentHandler) {
            this.f31544a = documentHandler;
        }

        public void characters(char[] cArr, int i2, int i3) throws SAXException {
            this.f31544a.characters(cArr, i2, i3);
        }

        public void endDocument() throws SAXException {
            this.f31544a.endDocument();
        }

        public void endElement(String str, String str2, String str3) throws SAXException {
            if (str3 != null) {
                str2 = str3;
            }
            this.f31544a.endElement(str2);
        }

        public void endPrefixMapping(String str) {
        }

        public void ignorableWhitespace(char[] cArr, int i2, int i3) throws SAXException {
            this.f31544a.ignorableWhitespace(cArr, i2, i3);
        }

        public void processingInstruction(String str, String str2) throws SAXException {
            this.f31544a.processingInstruction(str, str2);
        }

        public void setDocumentLocator(Locator locator) {
            this.f31544a.setDocumentLocator(locator);
        }

        public void skippedEntity(String str) {
        }

        public void startDocument() throws SAXException {
            this.f31544a.startDocument();
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (str3 != null) {
                str2 = str3;
            }
            this.f31545b.a(attributes);
            this.f31544a.startElement(str2, this.f31545b);
        }

        public void startPrefixMapping(String str, String str2) {
        }
    }

    public SAX1ParserAdapter(XMLReader xMLReader) {
        this.f31542a = xMLReader;
    }

    public void parse(String str) throws SAXException {
        try {
            this.f31542a.parse(str);
        } catch (IOException e2) {
            throw new SAXException(e2);
        }
    }

    public void setDTDHandler(DTDHandler dTDHandler) {
        this.f31542a.setDTDHandler(dTDHandler);
    }

    public void setDocumentHandler(DocumentHandler documentHandler) {
        this.f31542a.setContentHandler(new DocHandlerWrapper(documentHandler));
    }

    public void setEntityResolver(EntityResolver entityResolver) {
        this.f31542a.setEntityResolver(entityResolver);
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        this.f31542a.setErrorHandler(errorHandler);
    }

    public void setLocale(Locale locale) throws SAXException {
        throw new SAXNotSupportedException("TagSoup does not implement setLocale() method");
    }

    public void parse(InputSource inputSource) throws SAXException {
        try {
            this.f31542a.parse(inputSource);
        } catch (IOException e2) {
            throw new SAXException(e2);
        }
    }
}
