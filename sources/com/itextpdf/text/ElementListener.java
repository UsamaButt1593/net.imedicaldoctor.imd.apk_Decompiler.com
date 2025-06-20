package com.itextpdf.text;

import java.util.EventListener;

public interface ElementListener extends EventListener {
    boolean b(Element element) throws DocumentException;
}
