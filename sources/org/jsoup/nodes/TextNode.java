package org.jsoup.nodes;

import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;

public class TextNode extends Node {
    private static final String a3 = "text";
    String Z2;

    public TextNode(String str, String str2) {
        this.Z = str2;
        this.Z2 = str;
    }

    static boolean C0(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }

    static String D0(String str) {
        return StringUtil.i(str);
    }

    static String F0(String str) {
        return str.replaceFirst("^\\s+", "");
    }

    public static TextNode v0(String str, String str2) {
        return new TextNode(Entities.l(str), str2);
    }

    private void w0() {
        if (this.Y == null) {
            Attributes attributes = new Attributes();
            this.Y = attributes;
            attributes.D("text", this.Z2);
        }
    }

    public TextNode E0(int i2) {
        Validate.e(i2 >= 0, "Split offset must be not be negative");
        Validate.e(i2 < this.Z2.length(), "Split offset must not be greater than current text length");
        String substring = y0().substring(0, i2);
        String substring2 = y0().substring(i2);
        H0(substring);
        TextNode textNode = new TextNode(substring2, l());
        if (S() != null) {
            S().b(q0() + 1, textNode);
        }
        return textNode;
    }

    public String F() {
        return "#text";
    }

    public String G0() {
        return D0(y0());
    }

    public TextNode H0(String str) {
        this.Z2 = str;
        Attributes attributes = this.Y;
        if (attributes != null) {
            attributes.D("text", str);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (z0() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        D(r7, r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (z0() == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void L(java.lang.Appendable r7, int r8, org.jsoup.nodes.Document.OutputSettings r9) throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r9.o()
            if (r0 == 0) goto L_0x003d
            int r0 = r6.q0()
            if (r0 != 0) goto L_0x0024
            org.jsoup.nodes.Node r0 = r6.s
            boolean r1 = r0 instanceof org.jsoup.nodes.Element
            if (r1 == 0) goto L_0x0024
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            org.jsoup.parser.Tag r0 = r0.c3()
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x0024
            boolean r0 = r6.z0()
            if (r0 == 0) goto L_0x003a
        L_0x0024:
            boolean r0 = r9.m()
            if (r0 == 0) goto L_0x003d
            java.util.List r0 = r6.r0()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x003d
            boolean r0 = r6.z0()
            if (r0 != 0) goto L_0x003d
        L_0x003a:
            r6.D(r7, r8, r9)
        L_0x003d:
            boolean r8 = r9.o()
            if (r8 == 0) goto L_0x0058
            org.jsoup.nodes.Node r8 = r6.S()
            boolean r8 = r8 instanceof org.jsoup.nodes.Element
            if (r8 == 0) goto L_0x0058
            org.jsoup.nodes.Node r8 = r6.S()
            boolean r8 = org.jsoup.nodes.Element.X2(r8)
            if (r8 != 0) goto L_0x0058
            r8 = 1
            r4 = 1
            goto L_0x005a
        L_0x0058:
            r8 = 0
            r4 = 0
        L_0x005a:
            java.lang.String r1 = r6.y0()
            r3 = 0
            r5 = 0
            r0 = r7
            r2 = r9
            org.jsoup.nodes.Entities.f(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.TextNode.L(java.lang.Appendable, int, org.jsoup.nodes.Document$OutputSettings):void");
    }

    /* access modifiers changed from: package-private */
    public void M(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }

    public String a(String str) {
        w0();
        return super.a(str);
    }

    public Node b0(String str) {
        w0();
        return super.b0(str);
    }

    public String g(String str) {
        w0();
        return super.g(str);
    }

    public Node h(String str, String str2) {
        w0();
        return super.h(str, str2);
    }

    public Attributes i() {
        w0();
        return super.i();
    }

    public String toString() {
        return J();
    }

    public String y0() {
        Attributes attributes = this.Y;
        return attributes == null ? this.Z2 : attributes.q("text");
    }

    public boolean z(String str) {
        w0();
        return super.z(str);
    }

    public boolean z0() {
        return StringUtil.d(y0());
    }
}
