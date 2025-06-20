package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.nodes.Document;

public class DataNode extends Node {
    private static final String Z2 = "data";

    public DataNode(String str, String str2) {
        super(str2);
        this.Y.D("data", str);
    }

    public static DataNode v0(String str, String str2) {
        return new DataNode(Entities.l(str), str2);
    }

    public String F() {
        return "#data";
    }

    /* access modifiers changed from: package-private */
    public void L(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(w0());
    }

    /* access modifiers changed from: package-private */
    public void M(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }

    public String toString() {
        return J();
    }

    public String w0() {
        return this.Y.q("data");
    }

    public DataNode y0(String str) {
        this.Y.D("data", str);
        return this;
    }
}
