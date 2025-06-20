package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class DoubleQuotedAttrValueState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27697a;

    public DoubleQuotedAttrValueState(XMLParser xMLParser) {
        this.f27697a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '\"') {
            this.f27697a.r().o(this.f27697a.f());
            this.f27697a.p();
            this.f27697a.y().q();
        } else if (c2 == '&') {
            this.f27697a.y().o();
        } else {
            this.f27697a.b(c2);
        }
    }
}
