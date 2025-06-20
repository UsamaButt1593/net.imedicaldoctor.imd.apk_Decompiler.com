package com.itextpdf.tool.xml.css.parser.state;

import com.itextpdf.tool.xml.css.parser.CssStateController;
import com.itextpdf.tool.xml.css.parser.State;

public class CommentStart implements State {

    /* renamed from: a  reason: collision with root package name */
    private final CssStateController f27565a;

    public CommentStart(CssStateController cssStateController) {
        this.f27565a = cssStateController;
    }

    public void a(char c2) {
        if ('*' == c2) {
            this.f27565a.h();
            return;
        }
        this.f27565a.a('/');
        this.f27565a.a(c2);
        this.f27565a.b();
    }
}
