package com.itextpdf.tool.xml.css.parser.state;

import com.itextpdf.tool.xml.css.parser.CssStateController;
import com.itextpdf.tool.xml.css.parser.State;

public class Properties implements State {

    /* renamed from: a  reason: collision with root package name */
    private final CssStateController f27566a;

    public Properties(CssStateController cssStateController) {
        this.f27566a = cssStateController;
    }

    public void a(char c2) {
        if ('}' == c2) {
            this.f27566a.m();
            this.f27566a.l();
        } else if ('/' == c2) {
            this.f27566a.i();
        } else {
            this.f27566a.a(c2);
        }
    }
}
