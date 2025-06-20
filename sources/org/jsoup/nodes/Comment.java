package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.nodes.Document;

public class Comment extends Node {
    private static final String Z2 = "comment";

    public Comment(String str, String str2) {
        super(str2);
        this.Y.D("comment", str);
    }

    public String F() {
        return "#comment";
    }

    /* access modifiers changed from: package-private */
    public void L(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.o()) {
            D(appendable, i2, outputSettings);
        }
        appendable.append("<!--").append(v0()).append("-->");
    }

    /* access modifiers changed from: package-private */
    public void M(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }

    public String toString() {
        return J();
    }

    public String v0() {
        return this.Y.q("comment");
    }
}
