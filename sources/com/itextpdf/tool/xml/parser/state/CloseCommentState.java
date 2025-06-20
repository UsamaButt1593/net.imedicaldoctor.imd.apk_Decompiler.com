package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class CloseCommentState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27692a;

    public CloseCommentState(XMLParser xMLParser) {
        this.f27692a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '-') {
            this.f27692a.r().a().append('-');
        } else if (c2 == '>' && this.f27692a.r().a().length() == 2) {
            this.f27692a.r().a().setLength(0);
            this.f27692a.h();
            this.f27692a.p();
            this.f27692a.y().i();
        } else {
            XMLParser xMLParser = this.f27692a;
            xMLParser.c(xMLParser.r().a().toString());
            this.f27692a.r().a().setLength(0);
            this.f27692a.y().f();
        }
    }
}
