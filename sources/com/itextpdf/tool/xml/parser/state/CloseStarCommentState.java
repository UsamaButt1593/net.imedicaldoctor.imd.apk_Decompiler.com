package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class CloseStarCommentState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27693a;

    public CloseStarCommentState(XMLParser xMLParser) {
        this.f27693a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '*') {
            this.f27693a.r().a().append(c2);
        } else if (c2 == '/') {
            this.f27693a.r().a().setLength(0);
            this.f27693a.h();
            this.f27693a.p();
            XMLParser xMLParser = this.f27693a;
            xMLParser.c(xMLParser.r().j());
            this.f27693a.y().i();
        } else {
            XMLParser xMLParser2 = this.f27693a;
            xMLParser2.c(xMLParser2.r().a().toString());
            this.f27693a.r().a().setLength(0);
            this.f27693a.y().p();
        }
    }
}
