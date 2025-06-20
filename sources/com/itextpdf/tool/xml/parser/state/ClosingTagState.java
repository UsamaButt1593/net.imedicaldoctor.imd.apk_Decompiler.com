package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class ClosingTagState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27694a;

    public ClosingTagState(XMLParser xMLParser) {
        this.f27694a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '>') {
            this.f27694a.r().e(this.f27694a.f());
            this.f27694a.o();
            this.f27694a.p();
            this.f27694a.r().f();
            this.f27694a.y().i();
        } else if (c2 == ':') {
            this.f27694a.r().n(this.f27694a.f());
            this.f27694a.p();
        } else if (!Character.isWhitespace(c2)) {
            this.f27694a.b(c2);
        }
    }
}
