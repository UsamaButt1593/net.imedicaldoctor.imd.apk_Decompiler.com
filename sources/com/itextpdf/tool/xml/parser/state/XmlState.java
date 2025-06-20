package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class XmlState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27711a;

    public XmlState(XMLParser xMLParser) {
        this.f27711a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '>') {
            this.f27711a.o();
            this.f27711a.y().s();
        }
    }
}
