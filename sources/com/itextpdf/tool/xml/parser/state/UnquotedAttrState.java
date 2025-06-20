package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class UnquotedAttrState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27710a;

    public UnquotedAttrState(XMLParser xMLParser) {
        this.f27710a = xMLParser;
    }

    public void a(char c2) {
        if (Character.isWhitespace(c2)) {
            this.f27710a.r().o(this.f27710a.f());
            this.f27710a.p();
            this.f27710a.y().q();
        } else if (c2 == '>') {
            this.f27710a.r().o(this.f27710a.f());
            this.f27710a.B();
            this.f27710a.y().i();
        } else if (c2 == '/') {
            this.f27710a.r().o(this.f27710a.f());
            this.f27710a.p();
            this.f27710a.y().l();
        } else {
            this.f27710a.b(c2);
        }
    }
}
