package com.itextpdf.tool.xml.css.parser.state;

import com.itextpdf.tool.xml.css.parser.CssStateController;
import com.itextpdf.tool.xml.css.parser.State;

public class Rule implements State {

    /* renamed from: a  reason: collision with root package name */
    private final CssStateController f27567a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f27568b;

    /* renamed from: c  reason: collision with root package name */
    private int f27569c = 0;

    public Rule(CssStateController cssStateController) {
        this.f27567a = cssStateController;
    }

    public void a(char c2) {
        if ('}' == c2 && this.f27568b) {
            int i2 = this.f27569c - 1;
            this.f27569c = i2;
            if (i2 == 0) {
                this.f27567a.l();
                this.f27568b = false;
            }
        } else if (';' == c2 && !this.f27568b) {
            this.f27567a.l();
        } else if ('{' == c2) {
            this.f27569c++;
            this.f27568b = true;
        }
    }
}
