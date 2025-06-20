package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class AttributeValueState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27690a;

    public AttributeValueState(XMLParser xMLParser) {
        this.f27690a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '\'') {
            this.f27690a.y().n();
        } else if (c2 == '\"') {
            this.f27690a.y().h();
        } else if (!Character.isWhitespace(c2)) {
            this.f27690a.b(c2);
            this.f27690a.y().t();
        }
    }
}
