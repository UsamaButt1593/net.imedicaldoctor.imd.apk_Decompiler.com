package com.itextpdf.tool.xml.css.parser.state;

import com.itextpdf.tool.xml.css.parser.CssStateController;
import com.itextpdf.tool.xml.css.parser.State;

public class CommentInside implements State {

    /* renamed from: a  reason: collision with root package name */
    private final CssStateController f27564a;

    public CommentInside(CssStateController cssStateController) {
        this.f27564a = cssStateController;
    }

    public void a(char c2) {
        if ('*' == c2) {
            this.f27564a.g();
        }
    }
}
