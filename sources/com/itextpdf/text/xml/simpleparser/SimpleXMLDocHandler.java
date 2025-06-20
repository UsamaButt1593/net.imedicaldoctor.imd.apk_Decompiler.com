package com.itextpdf.text.xml.simpleparser;

import java.util.Map;

public interface SimpleXMLDocHandler {
    void a(String str);

    void d(String str);

    void e(String str, Map<String, String> map);

    void endDocument();

    void startDocument();
}
