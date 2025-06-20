package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class UnknownState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27709a;

    public UnknownState(XMLParser xMLParser) {
        this.f27709a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '<') {
            this.f27709a.D();
            this.f27709a.p();
            this.f27709a.y().r();
            return;
        }
        this.f27709a.b(c2);
    }
}
