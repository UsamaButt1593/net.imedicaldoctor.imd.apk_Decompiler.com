package com.itextpdf.tool.xml.parser.state;

import com.itextpdf.tool.xml.parser.State;
import com.itextpdf.tool.xml.parser.XMLParser;

public class CommentState implements State {

    /* renamed from: a  reason: collision with root package name */
    private final XMLParser f27695a;

    public CommentState(XMLParser xMLParser) {
        this.f27695a = xMLParser;
    }

    public void a(char c2) {
        if (c2 == '-') {
            this.f27695a.r().a().append('-');
            this.f27695a.y().c();
            return;
        }
        this.f27695a.b(c2);
    }
}
