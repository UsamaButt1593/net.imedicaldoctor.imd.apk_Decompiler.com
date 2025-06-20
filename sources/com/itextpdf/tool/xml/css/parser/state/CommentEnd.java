package com.itextpdf.tool.xml.css.parser.state;

import com.itextpdf.tool.xml.css.parser.CssStateController;
import com.itextpdf.tool.xml.css.parser.State;

public class CommentEnd implements State {

    /* renamed from: a  reason: collision with root package name */
    private final CssStateController f27563a;

    public CommentEnd(CssStateController cssStateController) {
        this.f27563a = cssStateController;
    }

    public void a(char c2) {
        if ('/' == c2) {
            this.f27563a.b();
        } else {
            this.f27563a.h();
        }
    }
}
