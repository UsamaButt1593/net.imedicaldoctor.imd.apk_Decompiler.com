package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.security.XmlLocator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XfaXmlLocator implements XmlLocator {

    /* renamed from: a  reason: collision with root package name */
    private PdfStamper f26498a;

    /* renamed from: b  reason: collision with root package name */
    private XfaForm f26499b;

    /* renamed from: c  reason: collision with root package name */
    private String f26500c;

    public XfaXmlLocator(PdfStamper pdfStamper) throws DocumentException, IOException {
        this.f26498a = pdfStamper;
        try {
            d();
        } catch (ParserConfigurationException e2) {
            throw new DocumentException((Exception) e2);
        } catch (SAXException e3) {
            throw new DocumentException((Exception) e3);
        }
    }

    public void a(Document document) throws IOException, DocumentException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(byteArrayOutputStream));
            this.f26498a.z().D().V0(PdfName.Yh, this.f26498a.C().v0(new PdfStream(byteArrayOutputStream.toByteArray())).a());
        } catch (TransformerConfigurationException e2) {
            throw new DocumentException((Exception) e2);
        } catch (TransformerException e3) {
            throw new DocumentException((Exception) e3);
        }
    }

    public String b() {
        return this.f26500c;
    }

    public Document c() {
        return this.f26499b.r();
    }

    /* access modifiers changed from: protected */
    public void d() throws ParserConfigurationException, SAXException, IOException {
        this.f26499b = new XfaForm(this.f26498a.z());
    }

    public void e(String str) {
        this.f26500c = str;
    }
}
