package com.itextpdf.tool.xml;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.pipeline.WritableElement;
import java.util.ArrayList;

public class ElementList extends ArrayList<Element> implements ElementHandler {
    private static final long s = -3943194552607332537L;

    public void b(Writable writable) {
        if (writable instanceof WritableElement) {
            addAll(((WritableElement) writable).c());
        }
    }
}
