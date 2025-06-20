package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class SingleQuotedAttrValueState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27704a;

    public SingleQuotedAttrValueState(XMLParser xMLParser) {
        this.f27704a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '\'') {
            this.f27704a.r().o(this.f27704a.f());
            this.f27704a.p();
            this.f27704a.y().q();
        } else if (c2 == '&') {
            this.f27704a.y().o();
        } else {
            this.f27704a.b(c2);
        }
    }
}
