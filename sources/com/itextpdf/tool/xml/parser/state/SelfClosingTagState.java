package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class SelfClosingTagState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27703a;

    public SelfClosingTagState(XMLParser xMLParser) {
        this.f27703a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '>') {
            this.f27703a.B();
            this.f27703a.o();
            this.f27703a.p();
            this.f27703a.r().f();
            this.f27703a.y().i();
        }
    }
}
