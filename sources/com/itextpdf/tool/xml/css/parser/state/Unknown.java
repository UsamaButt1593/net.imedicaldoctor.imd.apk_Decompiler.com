package com.itextpdf.tool.xml.css.parser.state;

import com.itextpdf.tool.xml.css.parser.CssStateController;
import com.itextpdf.tool.xml.css.parser.State;

public class Unknown implements State {

    /* renamed from: a  reason: collision with root package name */
    private final CssStateController f27570a;

    public Unknown(CssStateController cssStateController) {
        this.f27570a = cssStateController;
    }

    public void a(char c2) {
        if ('/' == c2) {
            this.f27570a.i();
        } else if ('{' == c2) {
            this.f27570a.n();
            this.f27570a.j();
        } else if ('@' == c2) {
            this.f27570a.k();
        } else {
            this.f27570a.a(c2);
        }
    }
}
