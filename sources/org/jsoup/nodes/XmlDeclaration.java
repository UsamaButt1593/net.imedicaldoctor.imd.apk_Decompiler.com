package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;

public class XmlDeclaration extends Node {
    private final String Z2;
    private final boolean a3;

    public XmlDeclaration(String str, String str2, boolean z) {
        super(str2);
        Validate.j(str);
        this.Z2 = str;
        this.a3 = z;
    }

    public String F() {
        return "#declaration";
    }

    /* access modifiers changed from: package-private */
    public void L(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        String str = "?";
        appendable.append("<").append(this.a3 ? "!" : str).append(this.Z2);
        this.Y.B(appendable, outputSettings);
        if (this.a3) {
            str = "!";
        }
        appendable.append(str).append(">");
    }

    /* access modifiers changed from: package-private */
    public void M(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }

    public String toString() {
        return J();
    }

    public String v0() {
        return this.Y.z().trim();
    }

    public String w0() {
        return this.Z2;
    }
}
