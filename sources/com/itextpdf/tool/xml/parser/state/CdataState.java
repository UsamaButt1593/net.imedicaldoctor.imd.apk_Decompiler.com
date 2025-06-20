package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class CdataState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27691a;

    public CdataState(XMLParser xMLParser) {
        this.f27691a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '>' && "]]".equals(this.f27691a.r().a().toString())) {
            this.f27691a.r().a().setLength(0);
            XMLParser xMLParser = this.f27691a;
            xMLParser.C("<![CDATA[" + this.f27691a.f() + "]]>");
            this.f27691a.p();
            this.f27691a.y().i();
        } else if (c2 == ']') {
            this.f27691a.r().a().append(c2);
        } else {
            this.f27691a.b(c2);
            this.f27691a.r().a().setLength(0);
        }
    }
}
