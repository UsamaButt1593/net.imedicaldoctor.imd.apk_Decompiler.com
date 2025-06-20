package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class DocTypeState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27696a;

    public DocTypeState(XMLParser xMLParser) {
        this.f27696a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '>') {
            this.f27696a.y().s();
        }
    }
}
