package com.itextpdf.text.pdf.security;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import org.w3c.dom.Document;

public interface XmlLocator {
    void a(Document document) throws IOException, DocumentException;

    String b();

    Document c();
}
