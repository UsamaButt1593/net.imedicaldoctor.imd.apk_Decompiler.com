package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class StarCommentState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27706a;

    public StarCommentState(XMLParser xMLParser) {
        this.f27706a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '*') {
            this.f27706a.r().a().append(c2);
            this.f27706a.y().d();
            return;
        }
        this.f27706a.b(c2);
    }
}
