package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class InsideTagState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27701a;

    public InsideTagState(XMLParser xMLParser) {
        this.f27701a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '<') {
            if (this.f27701a.e() > 0) {
                XMLParser xMLParser = this.f27701a;
                xMLParser.C(xMLParser.i());
            }
            this.f27701a.p();
            this.f27701a.y().r();
        } else if (c2 == '&') {
            this.f27701a.y().o();
        } else {
            this.f27701a.b(c2);
        }
    }
}
