package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Token;

enum HtmlTreeBuilderState {
    Initial {
        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.j(token)) {
                return true;
            }
            if (token.g()) {
                htmlTreeBuilder.O(token.b());
            } else if (token.h()) {
                Token.Doctype c2 = token.c();
                htmlTreeBuilder.w().F0(new DocumentType(htmlTreeBuilder.f31715h.c(c2.o()), c2.p(), c2.q(), c2.r(), htmlTreeBuilder.v()));
                if (c2.s()) {
                    htmlTreeBuilder.w().C3(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.D0(HtmlTreeBuilderState.BeforeHtml);
            } else {
                htmlTreeBuilder.D0(HtmlTreeBuilderState.BeforeHtml);
                return htmlTreeBuilder.e(token);
            }
            return true;
        }
    },
    BeforeHtml {
        private boolean l(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.V(HTML.Tag.y);
            htmlTreeBuilder.D0(HtmlTreeBuilderState.BeforeHead);
            return htmlTreeBuilder.e(token);
        }

        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.h()) {
                htmlTreeBuilder.p(this);
                return false;
            }
            if (token.g()) {
                htmlTreeBuilder.O(token.b());
            } else if (HtmlTreeBuilderState.j(token)) {
                return true;
            } else {
                if (token.k() && token.e().D().equals(HTML.Tag.y)) {
                    htmlTreeBuilder.L(token.e());
                    htmlTreeBuilder.D0(HtmlTreeBuilderState.BeforeHead);
                } else if (token.j() && StringUtil.b(token.d().D(), "head", "body", HTML.Tag.y, "br")) {
                    return l(token, htmlTreeBuilder);
                } else {
                    if (!token.j()) {
                        return l(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.p(this);
                    return false;
                }
            }
            return true;
        }
    },
    BeforeHead {
        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.j(token)) {
                return true;
            }
            if (token.g()) {
                htmlTreeBuilder.O(token.b());
            } else if (token.h()) {
                htmlTreeBuilder.p(this);
                return false;
            } else if (token.k() && token.e().D().equals(HTML.Tag.y)) {
                return HtmlTreeBuilderState.InBody.k(token, htmlTreeBuilder);
            } else {
                if (token.k() && token.e().D().equals("head")) {
                    htmlTreeBuilder.A0(htmlTreeBuilder.L(token.e()));
                    htmlTreeBuilder.D0(HtmlTreeBuilderState.InHead);
                } else if (token.j() && StringUtil.b(token.d().D(), "head", "body", HTML.Tag.y, "br")) {
                    htmlTreeBuilder.g("head");
                    return htmlTreeBuilder.e(token);
                } else if (token.j()) {
                    htmlTreeBuilder.p(this);
                    return false;
                } else {
                    htmlTreeBuilder.g("head");
                    return htmlTreeBuilder.e(token);
                }
            }
            return true;
        }
    },
    InHead {
        private boolean l(Token token, TreeBuilder treeBuilder) {
            treeBuilder.f("head");
            return treeBuilder.e(token);
        }

        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.j(token)) {
                htmlTreeBuilder.N(token.a());
                return true;
            }
            int i2 = AnonymousClass24.f31633a[token.f31673a.ordinal()];
            if (i2 == 1) {
                htmlTreeBuilder.O(token.b());
            } else if (i2 != 2) {
                if (i2 == 3) {
                    Token.StartTag e2 = token.e();
                    String D = e2.D();
                    if (D.equals(HTML.Tag.y)) {
                        return HtmlTreeBuilderState.InBody.k(token, htmlTreeBuilder);
                    }
                    if (StringUtil.b(D, "base", "basefont", "bgsound", HTML.Tag.Y, HTML.Tag.C)) {
                        Element P = htmlTreeBuilder.P(e2);
                        if (D.equals("base") && P.z("href")) {
                            htmlTreeBuilder.e0(P);
                        }
                    } else if (D.equals(HTML.Tag.D)) {
                        htmlTreeBuilder.P(e2);
                    } else if (D.equals("title")) {
                        HtmlTreeBuilderState.h(e2, htmlTreeBuilder);
                    } else if (StringUtil.b(D, "noframes", "style")) {
                        HtmlTreeBuilderState.g(e2, htmlTreeBuilder);
                    } else if (D.equals(HTML.Tag.T)) {
                        htmlTreeBuilder.L(e2);
                        htmlTreeBuilderState = HtmlTreeBuilderState.InHeadNoscript;
                    } else if (D.equals(HTML.Tag.A)) {
                        htmlTreeBuilder.f31709b.y(TokeniserState.ScriptData);
                        htmlTreeBuilder.d0();
                        htmlTreeBuilder.D0(HtmlTreeBuilderState.Text);
                        htmlTreeBuilder.L(e2);
                    } else if (!D.equals("head")) {
                        return l(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder.p(this);
                        return false;
                    }
                } else if (i2 != 4) {
                    return l(token, htmlTreeBuilder);
                } else {
                    String D2 = token.d().D();
                    if (D2.equals("head")) {
                        htmlTreeBuilder.j0();
                        htmlTreeBuilderState = HtmlTreeBuilderState.AfterHead;
                    } else if (StringUtil.b(D2, "body", HTML.Tag.y, "br")) {
                        return l(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder.p(this);
                        return false;
                    }
                }
                htmlTreeBuilder.D0(htmlTreeBuilderState);
            } else {
                htmlTreeBuilder.p(this);
                return false;
            }
            return true;
        }
    },
    InHeadNoscript {
        private boolean l(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.p(this);
            htmlTreeBuilder.N(new Token.Character().o(token.toString()));
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.h()) {
                htmlTreeBuilder.p(this);
                return true;
            } else if (token.k() && token.e().D().equals(HTML.Tag.y)) {
                return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InBody);
            } else {
                if (token.j() && token.d().D().equals(HTML.Tag.T)) {
                    htmlTreeBuilder.j0();
                    htmlTreeBuilder.D0(HtmlTreeBuilderState.InHead);
                    return true;
                } else if (HtmlTreeBuilderState.j(token) || token.g() || (token.k() && StringUtil.b(token.e().D(), "basefont", "bgsound", HTML.Tag.C, HTML.Tag.D, "noframes", "style"))) {
                    return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InHead);
                } else {
                    if (token.j() && token.d().D().equals("br")) {
                        return l(token, htmlTreeBuilder);
                    }
                    if ((!token.k() || !StringUtil.b(token.e().D(), "head", HTML.Tag.T)) && !token.j()) {
                        return l(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.p(this);
                    return false;
                }
            }
        }
    },
    AfterHead {
        private boolean l(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.g("body");
            htmlTreeBuilder.q(true);
            return htmlTreeBuilder.e(token);
        }

        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            Token token2 = token;
            HtmlTreeBuilder htmlTreeBuilder2 = htmlTreeBuilder;
            if (HtmlTreeBuilderState.j(token)) {
                htmlTreeBuilder2.N(token.a());
                return true;
            } else if (token.g()) {
                htmlTreeBuilder2.O(token.b());
                return true;
            } else if (token.h()) {
                htmlTreeBuilder2.p(this);
                return true;
            } else {
                if (token.k()) {
                    Token.StartTag e2 = token.e();
                    String D = e2.D();
                    if (D.equals(HTML.Tag.y)) {
                        return htmlTreeBuilder2.n0(token2, HtmlTreeBuilderState.InBody);
                    }
                    if (D.equals("body")) {
                        htmlTreeBuilder2.L(e2);
                        htmlTreeBuilder2.q(false);
                        htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
                    } else if (D.equals("frameset")) {
                        htmlTreeBuilder2.L(e2);
                        htmlTreeBuilderState = HtmlTreeBuilderState.InFrameset;
                    } else if (StringUtil.b(D, "base", "basefont", "bgsound", HTML.Tag.C, HTML.Tag.D, "noframes", HTML.Tag.A, "style", "title")) {
                        htmlTreeBuilder2.p(this);
                        Element z = htmlTreeBuilder.z();
                        htmlTreeBuilder2.o0(z);
                        htmlTreeBuilder2.n0(token2, HtmlTreeBuilderState.InHead);
                        htmlTreeBuilder2.s0(z);
                        return true;
                    } else if (D.equals("head")) {
                        htmlTreeBuilder2.p(this);
                        return false;
                    }
                    htmlTreeBuilder2.D0(htmlTreeBuilderState);
                    return true;
                } else if (token.j() && !StringUtil.b(token.d().D(), "body", HTML.Tag.y)) {
                    htmlTreeBuilder2.p(this);
                    return false;
                }
                l(token, htmlTreeBuilder);
                return true;
            }
        }
    },
    InBody {
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x01f2, code lost:
            if (r18.a().F().equals(r5) == false) goto L_0x01c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x0276, code lost:
            if (r18.a().F().equals(r5) == false) goto L_0x01c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x029d, code lost:
            if (r18.a().F().equals(r5) == false) goto L_0x01c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0381, code lost:
            if (r2.C("p") != false) goto L_0x0383;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:216:0x03da, code lost:
            if (r2.C("p") != false) goto L_0x0383;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:300:0x0592, code lost:
            if (r2.C("p") != false) goto L_0x0383;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:334:0x064d, code lost:
            if (r2.P(r3).g("type").equalsIgnoreCase(com.itextpdf.tool.xml.css.CSS.Value.f27476e) == false) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x01be, code lost:
            if (r18.a().F().equals(r5) == false) goto L_0x01c0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean k(org.jsoup.parser.Token r17, org.jsoup.parser.HtmlTreeBuilder r18) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                r2 = r18
                int[] r3 = org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.f31633a
                org.jsoup.parser.Token$TokenType r4 = r1.f31673a
                int r4 = r4.ordinal()
                r3 = r3[r4]
                r4 = 1
                if (r3 == r4) goto L_0x0830
                r5 = 2
                r6 = 0
                if (r3 == r5) goto L_0x082c
                java.lang.String r7 = "name"
                java.lang.String r8 = "html"
                java.lang.String r9 = "span"
                r10 = 3
                java.lang.String r11 = "form"
                java.lang.String r12 = "li"
                java.lang.String r13 = "body"
                java.lang.String r14 = "p"
                if (r3 == r10) goto L_0x032d
                r5 = 4
                if (r3 == r5) goto L_0x0064
                r5 = 5
                if (r3 == r5) goto L_0x0031
            L_0x002e:
                r1 = 1
                goto L_0x0839
            L_0x0031:
                org.jsoup.parser.Token$Character r1 = r17.a()
                java.lang.String r3 = r1.p()
                java.lang.String r5 = org.jsoup.parser.HtmlTreeBuilderState.q3
                boolean r3 = r3.equals(r5)
                if (r3 == 0) goto L_0x0047
                r2.p(r0)
                return r6
            L_0x0047:
                boolean r3 = r18.r()
                if (r3 == 0) goto L_0x005a
                boolean r3 = org.jsoup.parser.HtmlTreeBuilderState.j(r1)
                if (r3 == 0) goto L_0x005a
                r18.q0()
                r2.N(r1)
                goto L_0x002e
            L_0x005a:
                r18.q0()
                r2.N(r1)
            L_0x0060:
                r2.q(r6)
                goto L_0x002e
            L_0x0064:
                org.jsoup.parser.Token$EndTag r3 = r17.d()
                java.lang.String r5 = r3.D()
                java.lang.String[] r15 = org.jsoup.parser.HtmlTreeBuilderState.Constants.p
                boolean r15 = org.jsoup.helper.StringUtil.c(r5, r15)
                r10 = 0
                if (r15 == 0) goto L_0x019b
                r3 = 0
            L_0x0078:
                r7 = 8
                if (r3 >= r7) goto L_0x002e
                org.jsoup.nodes.Element r7 = r2.u(r5)
                if (r7 != 0) goto L_0x0087
                boolean r1 = r16.l(r17, r18)
                return r1
            L_0x0087:
                boolean r8 = r2.g0(r7)
                if (r8 != 0) goto L_0x0094
                r2.p(r0)
            L_0x0090:
                r2.r0(r7)
                return r4
            L_0x0094:
                java.lang.String r8 = r7.F()
                boolean r8 = r2.E(r8)
                if (r8 != 0) goto L_0x00a2
                r2.p(r0)
                return r6
            L_0x00a2:
                org.jsoup.nodes.Element r8 = r18.a()
                if (r8 == r7) goto L_0x00ab
                r2.p(r0)
            L_0x00ab:
                java.util.ArrayList r8 = r18.B()
                int r9 = r8.size()
                r13 = r10
                r11 = 0
                r12 = 0
            L_0x00b6:
                if (r11 >= r9) goto L_0x00db
                r14 = 64
                if (r11 >= r14) goto L_0x00db
                java.lang.Object r14 = r8.get(r11)
                org.jsoup.nodes.Element r14 = (org.jsoup.nodes.Element) r14
                if (r14 != r7) goto L_0x00cf
                int r12 = r11 + -1
                java.lang.Object r12 = r8.get(r12)
                r13 = r12
                org.jsoup.nodes.Element r13 = (org.jsoup.nodes.Element) r13
                r12 = 1
                goto L_0x00d8
            L_0x00cf:
                if (r12 == 0) goto L_0x00d8
                boolean r15 = r2.b0(r14)
                if (r15 == 0) goto L_0x00d8
                goto L_0x00dc
            L_0x00d8:
                int r11 = r11 + 1
                goto L_0x00b6
            L_0x00db:
                r14 = r10
            L_0x00dc:
                if (r14 != 0) goto L_0x00e6
                java.lang.String r1 = r7.F()
                r2.l0(r1)
                goto L_0x0090
            L_0x00e6:
                r11 = r14
                r12 = r11
                r8 = 3
                r9 = 0
            L_0x00ea:
                if (r9 >= r8) goto L_0x012f
                boolean r15 = r2.g0(r11)
                if (r15 == 0) goto L_0x00f6
                org.jsoup.nodes.Element r11 = r2.j(r11)
            L_0x00f6:
                boolean r15 = r2.Z(r11)
                if (r15 != 0) goto L_0x0100
                r2.s0(r11)
                goto L_0x012a
            L_0x0100:
                if (r11 != r7) goto L_0x0103
                goto L_0x012f
            L_0x0103:
                org.jsoup.nodes.Element r15 = new org.jsoup.nodes.Element
                java.lang.String r8 = r11.F()
                org.jsoup.parser.ParseSettings r4 = org.jsoup.parser.ParseSettings.f31651d
                org.jsoup.parser.Tag r4 = org.jsoup.parser.Tag.q(r8, r4)
                java.lang.String r8 = r18.v()
                r15.<init>(r4, r8)
                r2.u0(r11, r15)
                r2.w0(r11, r15)
                org.jsoup.nodes.Element r4 = r12.S()
                if (r4 == 0) goto L_0x0125
                r12.Y()
            L_0x0125:
                r15.F0(r12)
                r11 = r15
                r12 = r11
            L_0x012a:
                int r9 = r9 + 1
                r4 = 1
                r8 = 3
                goto L_0x00ea
            L_0x012f:
                java.lang.String r4 = r13.F()
                java.lang.String[] r8 = org.jsoup.parser.HtmlTreeBuilderState.Constants.q
                boolean r4 = org.jsoup.helper.StringUtil.c(r4, r8)
                if (r4 == 0) goto L_0x014a
                org.jsoup.nodes.Element r4 = r12.S()
                if (r4 == 0) goto L_0x0146
                r12.Y()
            L_0x0146:
                r2.R(r12)
                goto L_0x0156
            L_0x014a:
                org.jsoup.nodes.Element r4 = r12.S()
                if (r4 == 0) goto L_0x0153
                r12.Y()
            L_0x0153:
                r13.F0(r12)
            L_0x0156:
                org.jsoup.nodes.Element r4 = new org.jsoup.nodes.Element
                org.jsoup.parser.Tag r8 = r7.c3()
                java.lang.String r9 = r18.v()
                r4.<init>(r8, r9)
                org.jsoup.nodes.Attributes r8 = r4.i()
                org.jsoup.nodes.Attributes r9 = r7.i()
                r8.g(r9)
                java.util.List r8 = r14.q()
                int r9 = r14.p()
                org.jsoup.nodes.Node[] r9 = new org.jsoup.nodes.Node[r9]
                java.lang.Object[] r8 = r8.toArray(r9)
                org.jsoup.nodes.Node[] r8 = (org.jsoup.nodes.Node[]) r8
                int r9 = r8.length
                r11 = 0
            L_0x0180:
                if (r11 >= r9) goto L_0x018a
                r12 = r8[r11]
                r4.F0(r12)
                int r11 = r11 + 1
                goto L_0x0180
            L_0x018a:
                r14.F0(r4)
                r2.r0(r7)
                r2.s0(r7)
                r2.U(r14, r4)
                int r3 = r3 + 1
                r4 = 1
                goto L_0x0078
            L_0x019b:
                java.lang.String[] r4 = org.jsoup.parser.HtmlTreeBuilderState.Constants.o
                boolean r4 = org.jsoup.helper.StringUtil.c(r5, r4)
                if (r4 == 0) goto L_0x01c8
                boolean r1 = r2.E(r5)
                if (r1 != 0) goto L_0x01af
                r2.p(r0)
                return r6
            L_0x01af:
                r18.s()
                org.jsoup.nodes.Element r1 = r18.a()
                java.lang.String r1 = r1.F()
                boolean r1 = r1.equals(r5)
                if (r1 != 0) goto L_0x01c3
            L_0x01c0:
                r2.p(r0)
            L_0x01c3:
                r2.l0(r5)
                goto L_0x002e
            L_0x01c8:
                boolean r4 = r5.equals(r9)
                if (r4 == 0) goto L_0x01d3
                boolean r1 = r16.l(r17, r18)
                return r1
            L_0x01d3:
                boolean r4 = r5.equals(r12)
                if (r4 == 0) goto L_0x01f5
                boolean r1 = r2.D(r5)
                if (r1 != 0) goto L_0x01e3
                r2.p(r0)
                return r6
            L_0x01e3:
                r2.t(r5)
                org.jsoup.nodes.Element r1 = r18.a()
                java.lang.String r1 = r1.F()
                boolean r1 = r1.equals(r5)
                if (r1 != 0) goto L_0x01c3
                goto L_0x01c0
            L_0x01f5:
                boolean r4 = r5.equals(r13)
                if (r4 == 0) goto L_0x020c
                boolean r1 = r2.E(r13)
                if (r1 != 0) goto L_0x0205
                r2.p(r0)
                return r6
            L_0x0205:
                org.jsoup.parser.HtmlTreeBuilderState r1 = org.jsoup.parser.HtmlTreeBuilderState.AfterBody
            L_0x0207:
                r2.D0(r1)
                goto L_0x002e
            L_0x020c:
                boolean r4 = r5.equals(r8)
                if (r4 == 0) goto L_0x021d
                boolean r1 = r2.f(r13)
                if (r1 == 0) goto L_0x002e
                boolean r1 = r2.e(r3)
                return r1
            L_0x021d:
                boolean r4 = r5.equals(r11)
                if (r4 == 0) goto L_0x0250
                org.jsoup.nodes.FormElement r1 = r18.x()
                r2.y0(r10)
                if (r1 == 0) goto L_0x024c
                boolean r3 = r2.E(r5)
                if (r3 != 0) goto L_0x0233
                goto L_0x024c
            L_0x0233:
                r18.s()
                org.jsoup.nodes.Element r3 = r18.a()
                java.lang.String r3 = r3.F()
                boolean r3 = r3.equals(r5)
                if (r3 != 0) goto L_0x0247
                r2.p(r0)
            L_0x0247:
                r2.s0(r1)
                goto L_0x002e
            L_0x024c:
                r2.p(r0)
                return r6
            L_0x0250:
                boolean r4 = r5.equals(r14)
                if (r4 == 0) goto L_0x027a
                boolean r1 = r2.C(r5)
                if (r1 != 0) goto L_0x0267
                r2.p(r0)
                r2.g(r5)
                boolean r1 = r2.e(r3)
                return r1
            L_0x0267:
                r2.t(r5)
                org.jsoup.nodes.Element r1 = r18.a()
                java.lang.String r1 = r1.F()
                boolean r1 = r1.equals(r5)
                if (r1 != 0) goto L_0x01c3
                goto L_0x01c0
            L_0x027a:
                java.lang.String[] r3 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31639f
                boolean r3 = org.jsoup.helper.StringUtil.c(r5, r3)
                if (r3 == 0) goto L_0x02a1
                boolean r1 = r2.E(r5)
                if (r1 != 0) goto L_0x028e
                r2.p(r0)
                return r6
            L_0x028e:
                r2.t(r5)
                org.jsoup.nodes.Element r1 = r18.a()
                java.lang.String r1 = r1.F()
                boolean r1 = r1.equals(r5)
                if (r1 != 0) goto L_0x01c3
                goto L_0x01c0
            L_0x02a1:
                java.lang.String[] r3 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31636c
                boolean r3 = org.jsoup.helper.StringUtil.c(r5, r3)
                if (r3 == 0) goto L_0x02d6
                java.lang.String[] r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31636c
                boolean r1 = r2.G(r1)
                if (r1 != 0) goto L_0x02b9
                r2.p(r0)
                return r6
            L_0x02b9:
                r2.t(r5)
                org.jsoup.nodes.Element r1 = r18.a()
                java.lang.String r1 = r1.F()
                boolean r1 = r1.equals(r5)
                if (r1 != 0) goto L_0x02cd
                r2.p(r0)
            L_0x02cd:
                java.lang.String[] r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31636c
                r2.m0(r1)
                goto L_0x002e
            L_0x02d6:
                java.lang.String r3 = "sarcasm"
                boolean r3 = r5.equals(r3)
                if (r3 == 0) goto L_0x02e3
                boolean r1 = r16.l(r17, r18)
                return r1
            L_0x02e3:
                java.lang.String[] r3 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31641h
                boolean r3 = org.jsoup.helper.StringUtil.c(r5, r3)
                if (r3 == 0) goto L_0x0319
                boolean r1 = r2.E(r7)
                if (r1 != 0) goto L_0x002e
                boolean r1 = r2.E(r5)
                if (r1 != 0) goto L_0x02fd
                r2.p(r0)
                return r6
            L_0x02fd:
                r18.s()
                org.jsoup.nodes.Element r1 = r18.a()
                java.lang.String r1 = r1.F()
                boolean r1 = r1.equals(r5)
                if (r1 != 0) goto L_0x0311
                r2.p(r0)
            L_0x0311:
                r2.l0(r5)
                r18.k()
                goto L_0x002e
            L_0x0319:
                java.lang.String r3 = "br"
                boolean r4 = r5.equals(r3)
                if (r4 == 0) goto L_0x0328
                r2.p(r0)
                r2.g(r3)
                return r6
            L_0x0328:
                boolean r1 = r16.l(r17, r18)
                return r1
            L_0x032d:
                org.jsoup.parser.Token$StartTag r3 = r17.e()
                java.lang.String r4 = r3.D()
                java.lang.String r10 = "a"
                boolean r15 = r4.equals(r10)
                if (r15 == 0) goto L_0x0361
                org.jsoup.nodes.Element r1 = r2.u(r10)
                if (r1 == 0) goto L_0x0355
                r2.p(r0)
                r2.f(r10)
                org.jsoup.nodes.Element r1 = r2.y(r10)
                if (r1 == 0) goto L_0x0355
                r2.r0(r1)
                r2.s0(r1)
            L_0x0355:
                r18.q0()
            L_0x0358:
                org.jsoup.nodes.Element r1 = r2.L(r3)
                r2.p0(r1)
                goto L_0x002e
            L_0x0361:
                java.lang.String[] r10 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31642i
                boolean r10 = org.jsoup.helper.StringUtil.c(r4, r10)
                if (r10 == 0) goto L_0x0373
                r18.q0()
            L_0x036e:
                r2.P(r3)
                goto L_0x0060
            L_0x0373:
                java.lang.String[] r10 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31635b
                boolean r10 = org.jsoup.helper.StringUtil.c(r4, r10)
                if (r10 == 0) goto L_0x038b
                boolean r1 = r2.C(r14)
                if (r1 == 0) goto L_0x0386
            L_0x0383:
                r2.f(r14)
            L_0x0386:
                r2.L(r3)
                goto L_0x002e
            L_0x038b:
                boolean r9 = r4.equals(r9)
                if (r9 == 0) goto L_0x0395
            L_0x0391:
                r18.q0()
                goto L_0x0386
            L_0x0395:
                boolean r9 = r4.equals(r12)
                if (r9 == 0) goto L_0x03dd
                r2.q(r6)
                java.util.ArrayList r1 = r18.B()
                int r4 = r1.size()
                r5 = 1
                int r4 = r4 - r5
            L_0x03a8:
                if (r4 <= 0) goto L_0x03d6
                java.lang.Object r5 = r1.get(r4)
                org.jsoup.nodes.Element r5 = (org.jsoup.nodes.Element) r5
                java.lang.String r6 = r5.F()
                boolean r6 = r6.equals(r12)
                if (r6 == 0) goto L_0x03be
                r2.f(r12)
                goto L_0x03d6
            L_0x03be:
                boolean r6 = r2.b0(r5)
                if (r6 == 0) goto L_0x03d3
                java.lang.String r5 = r5.F()
                java.lang.String[] r6 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31638e
                boolean r5 = org.jsoup.helper.StringUtil.c(r5, r6)
                if (r5 != 0) goto L_0x03d3
                goto L_0x03d6
            L_0x03d3:
                int r4 = r4 + -1
                goto L_0x03a8
            L_0x03d6:
                boolean r1 = r2.C(r14)
                if (r1 == 0) goto L_0x0386
                goto L_0x0383
            L_0x03dd:
                boolean r8 = r4.equals(r8)
                if (r8 == 0) goto L_0x0416
                r2.p(r0)
                java.util.ArrayList r1 = r18.B()
                java.lang.Object r1 = r1.get(r6)
                org.jsoup.nodes.Element r1 = (org.jsoup.nodes.Element) r1
                org.jsoup.nodes.Attributes r2 = r3.y()
                java.util.Iterator r2 = r2.iterator()
            L_0x03f8:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x002e
                java.lang.Object r3 = r2.next()
                org.jsoup.nodes.Attribute r3 = (org.jsoup.nodes.Attribute) r3
                java.lang.String r4 = r3.getKey()
                boolean r4 = r1.z(r4)
                if (r4 != 0) goto L_0x03f8
                org.jsoup.nodes.Attributes r4 = r1.i()
                r4.G(r3)
                goto L_0x03f8
            L_0x0416:
                java.lang.String[] r8 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31634a
                boolean r8 = org.jsoup.helper.StringUtil.c(r4, r8)
                if (r8 == 0) goto L_0x0427
                org.jsoup.parser.HtmlTreeBuilderState r3 = org.jsoup.parser.HtmlTreeBuilderState.InHead
                boolean r1 = r2.n0(r1, r3)
                return r1
            L_0x0427:
                boolean r1 = r4.equals(r13)
                if (r1 == 0) goto L_0x0482
                r2.p(r0)
                java.util.ArrayList r1 = r18.B()
                int r4 = r1.size()
                r7 = 1
                if (r4 == r7) goto L_0x0481
                int r4 = r1.size()
                if (r4 <= r5) goto L_0x0452
                java.lang.Object r4 = r1.get(r7)
                org.jsoup.nodes.Element r4 = (org.jsoup.nodes.Element) r4
                java.lang.String r4 = r4.F()
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x0452
                goto L_0x0481
            L_0x0452:
                r2.q(r6)
                java.lang.Object r1 = r1.get(r7)
                org.jsoup.nodes.Element r1 = (org.jsoup.nodes.Element) r1
                org.jsoup.nodes.Attributes r2 = r3.y()
                java.util.Iterator r2 = r2.iterator()
            L_0x0463:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x002e
                java.lang.Object r3 = r2.next()
                org.jsoup.nodes.Attribute r3 = (org.jsoup.nodes.Attribute) r3
                java.lang.String r4 = r3.getKey()
                boolean r4 = r1.z(r4)
                if (r4 != 0) goto L_0x0463
                org.jsoup.nodes.Attributes r4 = r1.i()
                r4.G(r3)
                goto L_0x0463
            L_0x0481:
                return r6
            L_0x0482:
                java.lang.String r1 = "frameset"
                boolean r1 = r4.equals(r1)
                if (r1 == 0) goto L_0x04dd
                r2.p(r0)
                java.util.ArrayList r1 = r18.B()
                int r4 = r1.size()
                r7 = 1
                if (r4 == r7) goto L_0x04dc
                int r4 = r1.size()
                if (r4 <= r5) goto L_0x04af
                java.lang.Object r4 = r1.get(r7)
                org.jsoup.nodes.Element r4 = (org.jsoup.nodes.Element) r4
                java.lang.String r4 = r4.F()
                boolean r4 = r4.equals(r13)
                if (r4 != 0) goto L_0x04af
                goto L_0x04dc
            L_0x04af:
                boolean r4 = r18.r()
                if (r4 != 0) goto L_0x04b6
                return r6
            L_0x04b6:
                java.lang.Object r4 = r1.get(r7)
                org.jsoup.nodes.Element r4 = (org.jsoup.nodes.Element) r4
                org.jsoup.nodes.Element r5 = r4.S()
                if (r5 == 0) goto L_0x04c5
                r4.Y()
            L_0x04c5:
                int r4 = r1.size()
                if (r4 <= r7) goto L_0x04d5
                int r4 = r1.size()
                int r4 = r4 - r7
                r1.remove(r4)
                r7 = 1
                goto L_0x04c5
            L_0x04d5:
                r2.L(r3)
                org.jsoup.parser.HtmlTreeBuilderState r1 = org.jsoup.parser.HtmlTreeBuilderState.InFrameset
                goto L_0x0207
            L_0x04dc:
                return r6
            L_0x04dd:
                java.lang.String[] r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31636c
                boolean r1 = org.jsoup.helper.StringUtil.c(r4, r1)
                if (r1 == 0) goto L_0x050a
                boolean r1 = r2.C(r14)
                if (r1 == 0) goto L_0x04f0
                r2.f(r14)
            L_0x04f0:
                org.jsoup.nodes.Element r1 = r18.a()
                java.lang.String r1 = r1.F()
                java.lang.String[] r4 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31636c
                boolean r1 = org.jsoup.helper.StringUtil.c(r1, r4)
                if (r1 == 0) goto L_0x0386
                r2.p(r0)
                r18.j0()
                goto L_0x0386
            L_0x050a:
                java.lang.String[] r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31637d
                boolean r1 = org.jsoup.helper.StringUtil.c(r4, r1)
                if (r1 == 0) goto L_0x0522
                boolean r1 = r2.C(r14)
                if (r1 == 0) goto L_0x051d
                r2.f(r14)
            L_0x051d:
                r2.L(r3)
                goto L_0x0060
            L_0x0522:
                boolean r1 = r4.equals(r11)
                if (r1 == 0) goto L_0x0541
                org.jsoup.nodes.FormElement r1 = r18.x()
                if (r1 == 0) goto L_0x0532
                r2.p(r0)
                return r6
            L_0x0532:
                boolean r1 = r2.C(r14)
                if (r1 == 0) goto L_0x053b
                r2.f(r14)
            L_0x053b:
                r1 = 1
                r2.Q(r3, r1)
                goto L_0x0839
            L_0x0541:
                r1 = 1
                java.lang.String[] r5 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31639f
                boolean r5 = org.jsoup.helper.StringUtil.c(r4, r5)
                if (r5 == 0) goto L_0x0596
                r2.q(r6)
                java.util.ArrayList r4 = r18.B()
                int r5 = r4.size()
                int r5 = r5 - r1
            L_0x0558:
                if (r5 <= 0) goto L_0x058e
                java.lang.Object r1 = r4.get(r5)
                org.jsoup.nodes.Element r1 = (org.jsoup.nodes.Element) r1
                java.lang.String r6 = r1.F()
                java.lang.String[] r7 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31639f
                boolean r6 = org.jsoup.helper.StringUtil.c(r6, r7)
                if (r6 == 0) goto L_0x0576
                java.lang.String r1 = r1.F()
                r2.f(r1)
                goto L_0x058e
            L_0x0576:
                boolean r6 = r2.b0(r1)
                if (r6 == 0) goto L_0x058b
                java.lang.String r1 = r1.F()
                java.lang.String[] r6 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31638e
                boolean r1 = org.jsoup.helper.StringUtil.c(r1, r6)
                if (r1 != 0) goto L_0x058b
                goto L_0x058e
            L_0x058b:
                int r5 = r5 + -1
                goto L_0x0558
            L_0x058e:
                boolean r1 = r2.C(r14)
                if (r1 == 0) goto L_0x0386
                goto L_0x0383
            L_0x0596:
                java.lang.String r1 = "plaintext"
                boolean r1 = r4.equals(r1)
                if (r1 == 0) goto L_0x05b3
                boolean r1 = r2.C(r14)
                if (r1 == 0) goto L_0x05a7
                r2.f(r14)
            L_0x05a7:
                r2.L(r3)
                org.jsoup.parser.Tokeniser r1 = r2.f31709b
                org.jsoup.parser.TokeniserState r2 = org.jsoup.parser.TokeniserState.PLAINTEXT
                r1.y(r2)
                goto L_0x002e
            L_0x05b3:
                java.lang.String r1 = "button"
                boolean r5 = r4.equals(r1)
                if (r5 == 0) goto L_0x05d1
                boolean r4 = r2.C(r1)
                if (r4 == 0) goto L_0x05cc
                r2.p(r0)
                r2.f(r1)
                r2.e(r3)
                goto L_0x002e
            L_0x05cc:
                r18.q0()
                goto L_0x051d
            L_0x05d1:
                java.lang.String[] r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31640g
                boolean r1 = org.jsoup.helper.StringUtil.c(r4, r1)
                if (r1 == 0) goto L_0x05dd
                goto L_0x0355
            L_0x05dd:
                java.lang.String r1 = "nobr"
                boolean r5 = r4.equals(r1)
                if (r5 == 0) goto L_0x05f6
                r18.q0()
                boolean r4 = r2.E(r1)
                if (r4 == 0) goto L_0x0358
                r2.p(r0)
                r2.f(r1)
                goto L_0x0355
            L_0x05f6:
                java.lang.String[] r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31641h
                boolean r1 = org.jsoup.helper.StringUtil.c(r4, r1)
                if (r1 == 0) goto L_0x060b
                r18.q0()
                r2.L(r3)
                r18.S()
                goto L_0x0060
            L_0x060b:
                java.lang.String r1 = "table"
                boolean r1 = r4.equals(r1)
                if (r1 == 0) goto L_0x0632
                org.jsoup.nodes.Document r1 = r18.w()
                org.jsoup.nodes.Document$QuirksMode r1 = r1.B3()
                org.jsoup.nodes.Document$QuirksMode r4 = org.jsoup.nodes.Document.QuirksMode.quirks
                if (r1 == r4) goto L_0x0628
                boolean r1 = r2.C(r14)
                if (r1 == 0) goto L_0x0628
                r2.f(r14)
            L_0x0628:
                r2.L(r3)
                r2.q(r6)
                org.jsoup.parser.HtmlTreeBuilderState r1 = org.jsoup.parser.HtmlTreeBuilderState.InTable
                goto L_0x0207
            L_0x0632:
                java.lang.String r1 = "input"
                boolean r5 = r4.equals(r1)
                if (r5 == 0) goto L_0x0651
                r18.q0()
                org.jsoup.nodes.Element r1 = r2.P(r3)
                java.lang.String r3 = "type"
                java.lang.String r1 = r1.g(r3)
                java.lang.String r3 = "hidden"
                boolean r1 = r1.equalsIgnoreCase(r3)
                if (r1 != 0) goto L_0x002e
                goto L_0x0060
            L_0x0651:
                java.lang.String[] r5 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31643j
                boolean r5 = org.jsoup.helper.StringUtil.c(r4, r5)
                if (r5 == 0) goto L_0x0660
                r2.P(r3)
                goto L_0x002e
            L_0x0660:
                java.lang.String r5 = "hr"
                boolean r8 = r4.equals(r5)
                if (r8 == 0) goto L_0x0673
                boolean r1 = r2.C(r14)
                if (r1 == 0) goto L_0x036e
                r2.f(r14)
                goto L_0x036e
            L_0x0673:
                java.lang.String r8 = "image"
                boolean r8 = r4.equals(r8)
                java.lang.String r9 = "svg"
                if (r8 == 0) goto L_0x068e
                org.jsoup.nodes.Element r1 = r2.y(r9)
                if (r1 != 0) goto L_0x0386
                java.lang.String r1 = "img"
                org.jsoup.parser.Token$Tag r1 = r3.B(r1)
                boolean r1 = r2.e(r1)
                return r1
            L_0x068e:
                java.lang.String r8 = "isindex"
                boolean r8 = r4.equals(r8)
                if (r8 == 0) goto L_0x0726
                r2.p(r0)
                org.jsoup.nodes.FormElement r4 = r18.x()
                if (r4 == 0) goto L_0x06a0
                return r6
            L_0x06a0:
                org.jsoup.parser.Tokeniser r4 = r2.f31709b
                r4.a()
                r2.g(r11)
                org.jsoup.nodes.Attributes r4 = r3.f31690j
                java.lang.String r6 = "action"
                boolean r4 = r4.t(r6)
                if (r4 == 0) goto L_0x06bf
                org.jsoup.nodes.FormElement r4 = r18.x()
                org.jsoup.nodes.Attributes r8 = r3.f31690j
                java.lang.String r8 = r8.q(r6)
                r4.h(r6, r8)
            L_0x06bf:
                r2.g(r5)
                java.lang.String r4 = "label"
                r2.g(r4)
                org.jsoup.nodes.Attributes r4 = r3.f31690j
                java.lang.String r6 = "prompt"
                boolean r4 = r4.t(r6)
                if (r4 == 0) goto L_0x06da
                org.jsoup.nodes.Attributes r4 = r3.f31690j
                java.lang.String r6 = "prompt"
                java.lang.String r4 = r4.q(r6)
                goto L_0x06dc
            L_0x06da:
                java.lang.String r4 = "This is a searchable index. Enter search keywords: "
            L_0x06dc:
                org.jsoup.parser.Token$Character r6 = new org.jsoup.parser.Token$Character
                r6.<init>()
                org.jsoup.parser.Token$Character r4 = r6.o(r4)
                r2.e(r4)
                org.jsoup.nodes.Attributes r4 = new org.jsoup.nodes.Attributes
                r4.<init>()
                org.jsoup.nodes.Attributes r3 = r3.f31690j
                java.util.Iterator r3 = r3.iterator()
            L_0x06f3:
                boolean r6 = r3.hasNext()
                if (r6 == 0) goto L_0x0711
                java.lang.Object r6 = r3.next()
                org.jsoup.nodes.Attribute r6 = (org.jsoup.nodes.Attribute) r6
                java.lang.String r8 = r6.getKey()
                java.lang.String[] r9 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31644k
                boolean r8 = org.jsoup.helper.StringUtil.c(r8, r9)
                if (r8 != 0) goto L_0x06f3
                r4.G(r6)
                goto L_0x06f3
            L_0x0711:
                java.lang.String r3 = "isindex"
                r4.D(r7, r3)
                r2.h(r1, r4)
                java.lang.String r1 = "label"
                r2.f(r1)
                r2.g(r5)
                r2.f(r11)
                goto L_0x002e
            L_0x0726:
                java.lang.String r1 = "textarea"
                boolean r1 = r4.equals(r1)
                if (r1 == 0) goto L_0x0742
                r2.L(r3)
                org.jsoup.parser.Tokeniser r1 = r2.f31709b
                org.jsoup.parser.TokeniserState r3 = org.jsoup.parser.TokeniserState.Rcdata
                r1.y(r3)
                r18.d0()
                r2.q(r6)
                org.jsoup.parser.HtmlTreeBuilderState r1 = org.jsoup.parser.HtmlTreeBuilderState.Text
                goto L_0x0207
            L_0x0742:
                java.lang.String r1 = "xmp"
                boolean r1 = r4.equals(r1)
                if (r1 == 0) goto L_0x075e
                boolean r1 = r2.C(r14)
                if (r1 == 0) goto L_0x0753
                r2.f(r14)
            L_0x0753:
                r18.q0()
            L_0x0756:
                r2.q(r6)
            L_0x0759:
                org.jsoup.parser.HtmlTreeBuilderState.g(r3, r2)
                goto L_0x002e
            L_0x075e:
                java.lang.String r1 = "iframe"
                boolean r1 = r4.equals(r1)
                if (r1 == 0) goto L_0x0767
                goto L_0x0756
            L_0x0767:
                java.lang.String r1 = "noembed"
                boolean r1 = r4.equals(r1)
                if (r1 == 0) goto L_0x0770
                goto L_0x0759
            L_0x0770:
                java.lang.String r1 = "select"
                boolean r1 = r4.equals(r1)
                if (r1 == 0) goto L_0x07b6
                r18.q0()
                r2.L(r3)
                r2.q(r6)
                org.jsoup.parser.HtmlTreeBuilderState r1 = r18.C0()
                org.jsoup.parser.HtmlTreeBuilderState r3 = org.jsoup.parser.HtmlTreeBuilderState.InTable
                boolean r3 = r1.equals(r3)
                if (r3 != 0) goto L_0x07b2
                org.jsoup.parser.HtmlTreeBuilderState r3 = org.jsoup.parser.HtmlTreeBuilderState.InCaption
                boolean r3 = r1.equals(r3)
                if (r3 != 0) goto L_0x07b2
                org.jsoup.parser.HtmlTreeBuilderState r3 = org.jsoup.parser.HtmlTreeBuilderState.InTableBody
                boolean r3 = r1.equals(r3)
                if (r3 != 0) goto L_0x07b2
                org.jsoup.parser.HtmlTreeBuilderState r3 = org.jsoup.parser.HtmlTreeBuilderState.InRow
                boolean r3 = r1.equals(r3)
                if (r3 != 0) goto L_0x07b2
                org.jsoup.parser.HtmlTreeBuilderState r3 = org.jsoup.parser.HtmlTreeBuilderState.InCell
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x07ae
                goto L_0x07b2
            L_0x07ae:
                org.jsoup.parser.HtmlTreeBuilderState r1 = org.jsoup.parser.HtmlTreeBuilderState.InSelect
                goto L_0x0207
            L_0x07b2:
                org.jsoup.parser.HtmlTreeBuilderState r1 = org.jsoup.parser.HtmlTreeBuilderState.InSelectInTable
                goto L_0x0207
            L_0x07b6:
                java.lang.String[] r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31645l
                boolean r1 = org.jsoup.helper.StringUtil.c(r4, r1)
                if (r1 == 0) goto L_0x07d7
                org.jsoup.nodes.Element r1 = r18.a()
                java.lang.String r1 = r1.F()
                java.lang.String r4 = "option"
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x0391
                java.lang.String r1 = "option"
                r2.f(r1)
                goto L_0x0391
            L_0x07d7:
                java.lang.String[] r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31646m
                boolean r1 = org.jsoup.helper.StringUtil.c(r4, r1)
                if (r1 == 0) goto L_0x0802
                java.lang.String r1 = "ruby"
                boolean r4 = r2.E(r1)
                if (r4 == 0) goto L_0x002e
                r18.s()
                org.jsoup.nodes.Element r4 = r18.a()
                java.lang.String r4 = r4.F()
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x0386
                r2.p(r0)
                r2.k0(r1)
                goto L_0x0386
            L_0x0802:
                java.lang.String r1 = "math"
                boolean r1 = r4.equals(r1)
                if (r1 == 0) goto L_0x0817
            L_0x080a:
                r18.q0()
                r2.L(r3)
                org.jsoup.parser.Tokeniser r1 = r2.f31709b
                r1.a()
                goto L_0x002e
            L_0x0817:
                boolean r1 = r4.equals(r9)
                if (r1 == 0) goto L_0x081e
                goto L_0x080a
            L_0x081e:
                java.lang.String[] r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.f31647n
                boolean r1 = org.jsoup.helper.StringUtil.c(r4, r1)
                if (r1 == 0) goto L_0x0391
                r2.p(r0)
                return r6
            L_0x082c:
                r2.p(r0)
                return r6
            L_0x0830:
                org.jsoup.parser.Token$Comment r1 = r17.b()
                r2.O(r1)
                goto L_0x002e
            L_0x0839:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass7.k(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }

        /* access modifiers changed from: package-private */
        public boolean l(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String A = token.d().A();
            ArrayList<Element> B = htmlTreeBuilder.B();
            int size = B.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Element element = B.get(size);
                if (element.F().equals(A)) {
                    htmlTreeBuilder.t(A);
                    if (!A.equals(htmlTreeBuilder.a().F())) {
                        htmlTreeBuilder.p(this);
                    }
                    htmlTreeBuilder.l0(A);
                } else if (htmlTreeBuilder.b0(element)) {
                    htmlTreeBuilder.p(this);
                    return false;
                } else {
                    size--;
                }
            }
            return true;
        }
    },
    Text {
        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.f()) {
                htmlTreeBuilder.N(token.a());
                return true;
            } else if (token.i()) {
                htmlTreeBuilder.p(this);
                htmlTreeBuilder.j0();
                htmlTreeBuilder.D0(htmlTreeBuilder.h0());
                return htmlTreeBuilder.e(token);
            } else if (!token.j()) {
                return true;
            } else {
                htmlTreeBuilder.j0();
                htmlTreeBuilder.D0(htmlTreeBuilder.h0());
                return true;
            }
        }
    },
    InTable {
        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            Token token2 = token;
            HtmlTreeBuilder htmlTreeBuilder2 = htmlTreeBuilder;
            if (token.f()) {
                htmlTreeBuilder.f0();
                htmlTreeBuilder.d0();
                htmlTreeBuilder2.D0(HtmlTreeBuilderState.InTableText);
                return htmlTreeBuilder2.e(token2);
            } else if (token.g()) {
                htmlTreeBuilder2.O(token.b());
                return true;
            } else if (token.h()) {
                htmlTreeBuilder2.p(this);
                return false;
            } else if (token.k()) {
                Token.StartTag e2 = token.e();
                String D = e2.D();
                if (D.equals(HTML.Tag.f27619g)) {
                    htmlTreeBuilder.n();
                    htmlTreeBuilder.S();
                    htmlTreeBuilder2.L(e2);
                    htmlTreeBuilderState = HtmlTreeBuilderState.InCaption;
                } else if (D.equals("colgroup")) {
                    htmlTreeBuilder.n();
                    htmlTreeBuilder2.L(e2);
                    htmlTreeBuilderState = HtmlTreeBuilderState.InColumnGroup;
                } else if (D.equals("col")) {
                    htmlTreeBuilder2.g("colgroup");
                    return htmlTreeBuilder2.e(token2);
                } else if (StringUtil.b(D, HTML.Tag.f27615c, HTML.Tag.f27616d, HTML.Tag.f27614b)) {
                    htmlTreeBuilder.n();
                    htmlTreeBuilder2.L(e2);
                    htmlTreeBuilderState = HtmlTreeBuilderState.InTableBody;
                } else if (StringUtil.b(D, "td", "th", "tr")) {
                    htmlTreeBuilder2.g(HTML.Tag.f27615c);
                    return htmlTreeBuilder2.e(token2);
                } else {
                    if (D.equals("table")) {
                        htmlTreeBuilder2.p(this);
                        if (htmlTreeBuilder2.f("table")) {
                            return htmlTreeBuilder2.e(token2);
                        }
                    } else if (StringUtil.b(D, "style", HTML.Tag.A)) {
                        return htmlTreeBuilder2.n0(token2, HtmlTreeBuilderState.InHead);
                    } else {
                        if (D.equals(HTML.Tag.q0)) {
                            if (!e2.f31690j.q("type").equalsIgnoreCase(CSS.Value.f27476e)) {
                                return l(token, htmlTreeBuilder);
                            }
                            htmlTreeBuilder2.P(e2);
                        } else if (!D.equals(HTML.Tag.Q)) {
                            return l(token, htmlTreeBuilder);
                        } else {
                            htmlTreeBuilder2.p(this);
                            if (htmlTreeBuilder.x() != null) {
                                return false;
                            }
                            htmlTreeBuilder2.Q(e2, false);
                        }
                    }
                    return true;
                }
                htmlTreeBuilder2.D0(htmlTreeBuilderState);
                return true;
            } else if (token.j()) {
                String D2 = token.d().D();
                if (D2.equals("table")) {
                    if (!htmlTreeBuilder2.K(D2)) {
                        htmlTreeBuilder2.p(this);
                        return false;
                    }
                    htmlTreeBuilder2.l0("table");
                    htmlTreeBuilder.x0();
                    return true;
                } else if (!StringUtil.b(D2, "body", HTML.Tag.f27619g, "col", "colgroup", HTML.Tag.y, HTML.Tag.f27615c, "td", HTML.Tag.f27616d, "th", HTML.Tag.f27614b, "tr")) {
                    return l(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder2.p(this);
                    return false;
                }
            } else if (!token.i()) {
                return l(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.a().F().equals(HTML.Tag.y)) {
                    htmlTreeBuilder2.p(this);
                }
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean l(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.p(this);
            if (!StringUtil.b(htmlTreeBuilder.a().F(), "table", HTML.Tag.f27615c, HTML.Tag.f27616d, HTML.Tag.f27614b, "tr")) {
                return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InBody);
            }
            htmlTreeBuilder.z0(true);
            boolean n0 = htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InBody);
            htmlTreeBuilder.z0(false);
            return n0;
        }
    },
    InTableText {
        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (AnonymousClass24.f31633a[token.f31673a.ordinal()] != 5) {
                if (htmlTreeBuilder.A().size() > 0) {
                    for (String next : htmlTreeBuilder.A()) {
                        if (!HtmlTreeBuilderState.i(next)) {
                            htmlTreeBuilder.p(this);
                            if (StringUtil.b(htmlTreeBuilder.a().F(), "table", HTML.Tag.f27615c, HTML.Tag.f27616d, HTML.Tag.f27614b, "tr")) {
                                htmlTreeBuilder.z0(true);
                                htmlTreeBuilder.n0(new Token.Character().o(next), HtmlTreeBuilderState.InBody);
                                htmlTreeBuilder.z0(false);
                            } else {
                                htmlTreeBuilder.n0(new Token.Character().o(next), HtmlTreeBuilderState.InBody);
                            }
                        } else {
                            htmlTreeBuilder.N(new Token.Character().o(next));
                        }
                    }
                    htmlTreeBuilder.f0();
                }
                htmlTreeBuilder.D0(htmlTreeBuilder.h0());
                return htmlTreeBuilder.e(token);
            }
            Token.Character a2 = token.a();
            if (a2.p().equals(HtmlTreeBuilderState.q3)) {
                htmlTreeBuilder.p(this);
                return false;
            }
            htmlTreeBuilder.A().add(a2.p());
            return true;
        }
    },
    InCaption {
        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!token.j() || !token.d().D().equals(HTML.Tag.f27619g)) {
                if ((token.k() && StringUtil.b(token.e().D(), HTML.Tag.f27619g, "col", "colgroup", HTML.Tag.f27615c, "td", HTML.Tag.f27616d, "th", HTML.Tag.f27614b, "tr")) || (token.j() && token.d().D().equals("table"))) {
                    htmlTreeBuilder.p(this);
                    if (htmlTreeBuilder.f(HTML.Tag.f27619g)) {
                        return htmlTreeBuilder.e(token);
                    }
                    return true;
                } else if (!token.j() || !StringUtil.b(token.d().D(), "body", "col", "colgroup", HTML.Tag.y, HTML.Tag.f27615c, "td", HTML.Tag.f27616d, "th", HTML.Tag.f27614b, "tr")) {
                    return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InBody);
                } else {
                    htmlTreeBuilder.p(this);
                    return false;
                }
            } else if (!htmlTreeBuilder.K(token.d().D())) {
                htmlTreeBuilder.p(this);
                return false;
            } else {
                htmlTreeBuilder.s();
                if (!htmlTreeBuilder.a().F().equals(HTML.Tag.f27619g)) {
                    htmlTreeBuilder.p(this);
                }
                htmlTreeBuilder.l0(HTML.Tag.f27619g);
                htmlTreeBuilder.k();
                htmlTreeBuilder.D0(HtmlTreeBuilderState.InTable);
                return true;
            }
        }
    },
    InColumnGroup {
        private boolean l(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.f("colgroup")) {
                return treeBuilder.e(token);
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.j(token)) {
                htmlTreeBuilder.N(token.a());
                return true;
            }
            int i2 = AnonymousClass24.f31633a[token.f31673a.ordinal()];
            if (i2 == 1) {
                htmlTreeBuilder.O(token.b());
            } else if (i2 == 2) {
                htmlTreeBuilder.p(this);
            } else if (i2 == 3) {
                Token.StartTag e2 = token.e();
                String D = e2.D();
                if (D.equals(HTML.Tag.y)) {
                    return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InBody);
                }
                if (!D.equals("col")) {
                    return l(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.P(e2);
            } else if (i2 != 4) {
                if (i2 != 6) {
                    return l(token, htmlTreeBuilder);
                }
                if (htmlTreeBuilder.a().F().equals(HTML.Tag.y)) {
                    return true;
                }
                return l(token, htmlTreeBuilder);
            } else if (!token.d().D().equals("colgroup")) {
                return l(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.a().F().equals(HTML.Tag.y)) {
                    htmlTreeBuilder.p(this);
                    return false;
                }
                htmlTreeBuilder.j0();
                htmlTreeBuilder.D0(HtmlTreeBuilderState.InTable);
            }
            return true;
        }
    },
    InTableBody {
        private boolean l(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InTable);
        }

        private boolean m(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.K(HTML.Tag.f27615c) || htmlTreeBuilder.K(HTML.Tag.f27614b) || htmlTreeBuilder.E(HTML.Tag.f27616d)) {
                htmlTreeBuilder.m();
                htmlTreeBuilder.f(htmlTreeBuilder.a().F());
                return htmlTreeBuilder.e(token);
            }
            htmlTreeBuilder.p(this);
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            int i2 = AnonymousClass24.f31633a[token.f31673a.ordinal()];
            if (i2 == 3) {
                Token.StartTag e2 = token.e();
                String D = e2.D();
                if (D.equals("tr")) {
                    htmlTreeBuilder.m();
                    htmlTreeBuilder.L(e2);
                    htmlTreeBuilderState = HtmlTreeBuilderState.InRow;
                } else if (!StringUtil.b(D, "th", "td")) {
                    return StringUtil.b(D, HTML.Tag.f27619g, "col", "colgroup", HTML.Tag.f27615c, HTML.Tag.f27616d, HTML.Tag.f27614b) ? m(token, htmlTreeBuilder) : l(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.p(this);
                    htmlTreeBuilder.g("tr");
                    return htmlTreeBuilder.e(e2);
                }
            } else if (i2 != 4) {
                return l(token, htmlTreeBuilder);
            } else {
                String D2 = token.d().D();
                if (StringUtil.b(D2, HTML.Tag.f27615c, HTML.Tag.f27616d, HTML.Tag.f27614b)) {
                    if (!htmlTreeBuilder.K(D2)) {
                        htmlTreeBuilder.p(this);
                        return false;
                    }
                    htmlTreeBuilder.m();
                    htmlTreeBuilder.j0();
                    htmlTreeBuilderState = HtmlTreeBuilderState.InTable;
                } else if (D2.equals("table")) {
                    return m(token, htmlTreeBuilder);
                } else {
                    if (!StringUtil.b(D2, "body", HTML.Tag.f27619g, "col", "colgroup", HTML.Tag.y, "td", "th", "tr")) {
                        return l(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.p(this);
                    return false;
                }
            }
            htmlTreeBuilder.D0(htmlTreeBuilderState);
            return true;
        }
    },
    InRow {
        private boolean l(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InTable);
        }

        private boolean m(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.f("tr")) {
                return treeBuilder.e(token);
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.k()) {
                Token.StartTag e2 = token.e();
                String D = e2.D();
                if (!StringUtil.b(D, "th", "td")) {
                    return StringUtil.b(D, HTML.Tag.f27619g, "col", "colgroup", HTML.Tag.f27615c, HTML.Tag.f27616d, HTML.Tag.f27614b, "tr") ? m(token, htmlTreeBuilder) : l(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.o();
                htmlTreeBuilder.L(e2);
                htmlTreeBuilder.D0(HtmlTreeBuilderState.InCell);
                htmlTreeBuilder.S();
                return true;
            } else if (!token.j()) {
                return l(token, htmlTreeBuilder);
            } else {
                String D2 = token.d().D();
                if (D2.equals("tr")) {
                    if (!htmlTreeBuilder.K(D2)) {
                        htmlTreeBuilder.p(this);
                        return false;
                    }
                    htmlTreeBuilder.o();
                    htmlTreeBuilder.j0();
                    htmlTreeBuilder.D0(HtmlTreeBuilderState.InTableBody);
                    return true;
                } else if (D2.equals("table")) {
                    return m(token, htmlTreeBuilder);
                } else {
                    if (StringUtil.b(D2, HTML.Tag.f27615c, HTML.Tag.f27616d, HTML.Tag.f27614b)) {
                        if (!htmlTreeBuilder.K(D2)) {
                            htmlTreeBuilder.p(this);
                            return false;
                        }
                        htmlTreeBuilder.f("tr");
                        return htmlTreeBuilder.e(token);
                    } else if (!StringUtil.b(D2, "body", HTML.Tag.f27619g, "col", "colgroup", HTML.Tag.y, "td", "th")) {
                        return l(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder.p(this);
                        return false;
                    }
                }
            }
        }
    },
    InCell {
        private boolean l(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InBody);
        }

        private void m(HtmlTreeBuilder htmlTreeBuilder) {
            String str = "td";
            if (!htmlTreeBuilder.K(str)) {
                str = "th";
            }
            htmlTreeBuilder.f(str);
        }

        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.j()) {
                String D = token.d().D();
                if (StringUtil.b(D, "td", "th")) {
                    if (!htmlTreeBuilder.K(D)) {
                        htmlTreeBuilder.p(this);
                        htmlTreeBuilder.D0(HtmlTreeBuilderState.InRow);
                        return false;
                    }
                    htmlTreeBuilder.s();
                    if (!htmlTreeBuilder.a().F().equals(D)) {
                        htmlTreeBuilder.p(this);
                    }
                    htmlTreeBuilder.l0(D);
                    htmlTreeBuilder.k();
                    htmlTreeBuilder.D0(HtmlTreeBuilderState.InRow);
                    return true;
                } else if (StringUtil.b(D, "body", HTML.Tag.f27619g, "col", "colgroup", HTML.Tag.y)) {
                    htmlTreeBuilder.p(this);
                    return false;
                } else if (!StringUtil.b(D, "table", HTML.Tag.f27615c, HTML.Tag.f27616d, HTML.Tag.f27614b, "tr")) {
                    return l(token, htmlTreeBuilder);
                } else {
                    if (!htmlTreeBuilder.K(D)) {
                        htmlTreeBuilder.p(this);
                        return false;
                    }
                }
            } else if (!token.k() || !StringUtil.b(token.e().D(), HTML.Tag.f27619g, "col", "colgroup", HTML.Tag.f27615c, "td", HTML.Tag.f27616d, "th", HTML.Tag.f27614b, "tr")) {
                return l(token, htmlTreeBuilder);
            } else {
                if (!htmlTreeBuilder.K("td") && !htmlTreeBuilder.K("th")) {
                    htmlTreeBuilder.p(this);
                    return false;
                }
            }
            m(htmlTreeBuilder);
            return htmlTreeBuilder.e(token);
        }
    },
    InSelect {
        private boolean l(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.p(this);
            return false;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
            if (r9.a().F().equals("optgroup") != false) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a9, code lost:
            if (r9.a().F().equals("option") != false) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f0, code lost:
            if (r9.a().F().equals("option") != false) goto L_0x00f2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean k(org.jsoup.parser.Token r8, org.jsoup.parser.HtmlTreeBuilder r9) {
            /*
                r7 = this;
                int[] r0 = org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.f31633a
                org.jsoup.parser.Token$TokenType r1 = r8.f31673a
                int r1 = r1.ordinal()
                r0 = r0[r1]
                java.lang.String r1 = "html"
                r2 = 0
                java.lang.String r3 = "select"
                java.lang.String r4 = "optgroup"
                java.lang.String r5 = "option"
                switch(r0) {
                    case 1: goto L_0x0169;
                    case 2: goto L_0x0165;
                    case 3: goto L_0x00c9;
                    case 4: goto L_0x0049;
                    case 5: goto L_0x002e;
                    case 6: goto L_0x001b;
                    default: goto L_0x0016;
                }
            L_0x0016:
                boolean r8 = r7.l(r8, r9)
                return r8
            L_0x001b:
                org.jsoup.nodes.Element r8 = r9.a()
                java.lang.String r8 = r8.F()
                boolean r8 = r8.equals(r1)
                if (r8 != 0) goto L_0x0170
            L_0x0029:
                r9.p(r7)
                goto L_0x0170
            L_0x002e:
                org.jsoup.parser.Token$Character r8 = r8.a()
                java.lang.String r0 = r8.p()
                java.lang.String r1 = org.jsoup.parser.HtmlTreeBuilderState.q3
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0044
                r9.p(r7)
                return r2
            L_0x0044:
                r9.N(r8)
                goto L_0x0170
            L_0x0049:
                org.jsoup.parser.Token$EndTag r0 = r8.d()
                java.lang.String r0 = r0.D()
                boolean r1 = r0.equals(r4)
                if (r1 == 0) goto L_0x0097
                org.jsoup.nodes.Element r8 = r9.a()
                java.lang.String r8 = r8.F()
                boolean r8 = r8.equals(r5)
                if (r8 == 0) goto L_0x0084
                org.jsoup.nodes.Element r8 = r9.a()
                org.jsoup.nodes.Element r8 = r9.j(r8)
                if (r8 == 0) goto L_0x0084
                org.jsoup.nodes.Element r8 = r9.a()
                org.jsoup.nodes.Element r8 = r9.j(r8)
                java.lang.String r8 = r8.F()
                boolean r8 = r8.equals(r4)
                if (r8 == 0) goto L_0x0084
                r9.f(r5)
            L_0x0084:
                org.jsoup.nodes.Element r8 = r9.a()
                java.lang.String r8 = r8.F()
                boolean r8 = r8.equals(r4)
                if (r8 == 0) goto L_0x0029
            L_0x0092:
                r9.j0()
                goto L_0x0170
            L_0x0097:
                boolean r1 = r0.equals(r5)
                if (r1 == 0) goto L_0x00ac
                org.jsoup.nodes.Element r8 = r9.a()
                java.lang.String r8 = r8.F()
                boolean r8 = r8.equals(r5)
                if (r8 == 0) goto L_0x0029
                goto L_0x0092
            L_0x00ac:
                boolean r1 = r0.equals(r3)
                if (r1 == 0) goto L_0x00c4
                boolean r8 = r9.H(r0)
                if (r8 != 0) goto L_0x00bc
                r9.p(r7)
                return r2
            L_0x00bc:
                r9.l0(r0)
                r9.x0()
                goto L_0x0170
            L_0x00c4:
                boolean r8 = r7.l(r8, r9)
                return r8
            L_0x00c9:
                org.jsoup.parser.Token$StartTag r0 = r8.e()
                java.lang.String r6 = r0.D()
                boolean r1 = r6.equals(r1)
                if (r1 == 0) goto L_0x00de
                org.jsoup.parser.HtmlTreeBuilderState r8 = org.jsoup.parser.HtmlTreeBuilderState.InBody
                boolean r8 = r9.n0(r0, r8)
                return r8
            L_0x00de:
                boolean r1 = r6.equals(r5)
                if (r1 == 0) goto L_0x00fa
                org.jsoup.nodes.Element r8 = r9.a()
                java.lang.String r8 = r8.F()
                boolean r8 = r8.equals(r5)
                if (r8 == 0) goto L_0x00f5
            L_0x00f2:
                r9.f(r5)
            L_0x00f5:
                r9.L(r0)
                goto L_0x0170
            L_0x00fa:
                boolean r1 = r6.equals(r4)
                if (r1 == 0) goto L_0x0121
                org.jsoup.nodes.Element r8 = r9.a()
                java.lang.String r8 = r8.F()
                boolean r8 = r8.equals(r5)
                if (r8 == 0) goto L_0x010f
                goto L_0x00f2
            L_0x010f:
                org.jsoup.nodes.Element r8 = r9.a()
                java.lang.String r8 = r8.F()
                boolean r8 = r8.equals(r4)
                if (r8 == 0) goto L_0x00f5
                r9.f(r4)
                goto L_0x00f5
            L_0x0121:
                boolean r1 = r6.equals(r3)
                if (r1 == 0) goto L_0x012f
                r9.p(r7)
                boolean r8 = r9.f(r3)
                return r8
            L_0x012f:
                java.lang.String r1 = "keygen"
                java.lang.String r4 = "textarea"
                java.lang.String r5 = "input"
                java.lang.String[] r1 = new java.lang.String[]{r5, r1, r4}
                boolean r1 = org.jsoup.helper.StringUtil.b(r6, r1)
                if (r1 == 0) goto L_0x0151
                r9.p(r7)
                boolean r8 = r9.H(r3)
                if (r8 != 0) goto L_0x0149
                return r2
            L_0x0149:
                r9.f(r3)
                boolean r8 = r9.e(r0)
                return r8
            L_0x0151:
                java.lang.String r0 = "script"
                boolean r0 = r6.equals(r0)
                if (r0 == 0) goto L_0x0160
                org.jsoup.parser.HtmlTreeBuilderState r0 = org.jsoup.parser.HtmlTreeBuilderState.InHead
                boolean r8 = r9.n0(r8, r0)
                return r8
            L_0x0160:
                boolean r8 = r7.l(r8, r9)
                return r8
            L_0x0165:
                r9.p(r7)
                return r2
            L_0x0169:
                org.jsoup.parser.Token$Comment r8 = r8.b()
                r9.O(r8)
            L_0x0170:
                r8 = 1
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass16.k(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }
    },
    InSelectInTable {
        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.k() && StringUtil.b(token.e().D(), HTML.Tag.f27619g, "table", HTML.Tag.f27615c, HTML.Tag.f27616d, HTML.Tag.f27614b, "tr", "td", "th")) {
                htmlTreeBuilder.p(this);
                htmlTreeBuilder.f(HTML.Tag.L0);
                return htmlTreeBuilder.e(token);
            } else if (!token.j() || !StringUtil.b(token.d().D(), HTML.Tag.f27619g, "table", HTML.Tag.f27615c, HTML.Tag.f27616d, HTML.Tag.f27614b, "tr", "td", "th")) {
                return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InSelect);
            } else {
                htmlTreeBuilder.p(this);
                if (!htmlTreeBuilder.K(token.d().D())) {
                    return false;
                }
                htmlTreeBuilder.f(HTML.Tag.L0);
                return htmlTreeBuilder.e(token);
            }
        }
    },
    AfterBody {
        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.j(token)) {
                return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.g()) {
                htmlTreeBuilder.O(token.b());
                return true;
            } else if (token.h()) {
                htmlTreeBuilder.p(this);
                return false;
            } else if (token.k() && token.e().D().equals(HTML.Tag.y)) {
                return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InBody);
            } else {
                if (!token.j() || !token.d().D().equals(HTML.Tag.y)) {
                    if (token.i()) {
                        return true;
                    }
                    htmlTreeBuilder.p(this);
                    htmlTreeBuilder.D0(HtmlTreeBuilderState.InBody);
                    return htmlTreeBuilder.e(token);
                } else if (htmlTreeBuilder.Y()) {
                    htmlTreeBuilder.p(this);
                    return false;
                } else {
                    htmlTreeBuilder.D0(HtmlTreeBuilderState.AfterAfterBody);
                    return true;
                }
            }
        }
    },
    InFrameset {
        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.j(token)) {
                htmlTreeBuilder.N(token.a());
            } else if (token.g()) {
                htmlTreeBuilder.O(token.b());
            } else if (token.h()) {
                htmlTreeBuilder.p(this);
                return false;
            } else if (token.k()) {
                Token.StartTag e2 = token.e();
                String D = e2.D();
                if (D.equals(HTML.Tag.y)) {
                    htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
                } else if (D.equals("frameset")) {
                    htmlTreeBuilder.L(e2);
                } else if (D.equals(TypedValues.AttributesType.L)) {
                    htmlTreeBuilder.P(e2);
                } else if (D.equals("noframes")) {
                    htmlTreeBuilderState = HtmlTreeBuilderState.InHead;
                } else {
                    htmlTreeBuilder.p(this);
                    return false;
                }
                return htmlTreeBuilder.n0(e2, htmlTreeBuilderState);
            } else if (!token.j() || !token.d().D().equals("frameset")) {
                if (!token.i()) {
                    htmlTreeBuilder.p(this);
                    return false;
                } else if (!htmlTreeBuilder.a().F().equals(HTML.Tag.y)) {
                    htmlTreeBuilder.p(this);
                }
            } else if (htmlTreeBuilder.a().F().equals(HTML.Tag.y)) {
                htmlTreeBuilder.p(this);
                return false;
            } else {
                htmlTreeBuilder.j0();
                if (!htmlTreeBuilder.Y() && !htmlTreeBuilder.a().F().equals("frameset")) {
                    htmlTreeBuilder.D0(HtmlTreeBuilderState.AfterFrameset);
                }
            }
            return true;
        }
    },
    AfterFrameset {
        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.j(token)) {
                htmlTreeBuilder.N(token.a());
                return true;
            } else if (token.g()) {
                htmlTreeBuilder.O(token.b());
                return true;
            } else if (token.h()) {
                htmlTreeBuilder.p(this);
                return false;
            } else {
                if (token.k() && token.e().D().equals(HTML.Tag.y)) {
                    htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
                } else if (token.j() && token.d().D().equals(HTML.Tag.y)) {
                    htmlTreeBuilder.D0(HtmlTreeBuilderState.AfterAfterFrameset);
                    return true;
                } else if (token.k() && token.e().D().equals("noframes")) {
                    htmlTreeBuilderState = HtmlTreeBuilderState.InHead;
                } else if (token.i()) {
                    return true;
                } else {
                    htmlTreeBuilder.p(this);
                    return false;
                }
                return htmlTreeBuilder.n0(token, htmlTreeBuilderState);
            }
        }
    },
    AfterAfterBody {
        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.g()) {
                htmlTreeBuilder.O(token.b());
                return true;
            } else if (token.h() || HtmlTreeBuilderState.j(token) || (token.k() && token.e().D().equals(HTML.Tag.y))) {
                return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InBody);
            } else {
                if (token.i()) {
                    return true;
                }
                htmlTreeBuilder.p(this);
                htmlTreeBuilder.D0(HtmlTreeBuilderState.InBody);
                return htmlTreeBuilder.e(token);
            }
        }
    },
    AfterAfterFrameset {
        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.g()) {
                htmlTreeBuilder.O(token.b());
                return true;
            } else if (token.h() || HtmlTreeBuilderState.j(token) || (token.k() && token.e().D().equals(HTML.Tag.y))) {
                return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InBody);
            } else {
                if (token.i()) {
                    return true;
                }
                if (token.k() && token.e().D().equals("noframes")) {
                    return htmlTreeBuilder.n0(token, HtmlTreeBuilderState.InHead);
                }
                htmlTreeBuilder.p(this);
                return false;
            }
        }
    },
    ForeignContent {
        /* access modifiers changed from: package-private */
        public boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };
    
    /* access modifiers changed from: private */
    public static String q3;

    /* renamed from: org.jsoup.parser.HtmlTreeBuilderState$24  reason: invalid class name */
    static /* synthetic */ class AnonymousClass24 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31633a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jsoup.parser.Token$TokenType[] r0 = org.jsoup.parser.Token.TokenType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31633a = r0
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Comment     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31633a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Doctype     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31633a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.StartTag     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31633a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EndTag     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31633a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Character     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31633a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EOF     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.<clinit>():void");
        }
    }

    private static final class Constants {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f31634a = null;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f31635b = null;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final String[] f31636c = null;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public static final String[] f31637d = null;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public static final String[] f31638e = null;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static final String[] f31639f = null;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public static final String[] f31640g = null;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public static final String[] f31641h = null;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public static final String[] f31642i = null;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public static final String[] f31643j = null;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public static final String[] f31644k = null;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public static final String[] f31645l = null;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public static final String[] f31646m = null;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public static final String[] f31647n = null;
        /* access modifiers changed from: private */
        public static final String[] o = null;
        /* access modifiers changed from: private */
        public static final String[] p = null;
        /* access modifiers changed from: private */
        public static final String[] q = null;

        static {
            f31634a = new String[]{"base", "basefont", "bgsound", HTML.Tag.Y, HTML.Tag.C, HTML.Tag.D, "noframes", HTML.Tag.A, "style", "title"};
            f31635b = new String[]{HTML.Tag.F, HTML.Tag.G, HTML.Tag.H, "blockquote", "center", HTML.Tag.f0, HTML.Attribute.u, "div", "dl", HTML.Tag.L, HTML.Tag.M, HTML.Tag.N, HTML.Tag.O, HTML.Tag.R, HTML.Tag.S, HTML.Tag.w0, HTML.Tag.x0, "ol", "p", HTML.Tag.V, "summary", "ul"};
            f31636c = new String[]{"h1", "h2", "h3", "h4", "h5", "h6"};
            f31637d = new String[]{"pre", "listing"};
            f31638e = new String[]{HTML.Tag.F, "div", "p"};
            f31639f = new String[]{HTML.Tag.t, HTML.Tag.u};
            f31640g = new String[]{"b", HTML.Tag.T0, HTML.Tag.g0, "em", "font", "i", "s", "small", "strike", "strong", "tt", "u"};
            f31641h = new String[]{"applet", "marquee", HTML.Tag.G0};
            f31642i = new String[]{"area", "br", HTML.Tag.k0, "img", HTML.Tag.u0, HTML.Tag.O0};
            f31643j = new String[]{"param", "source", "track"};
            f31644k = new String[]{"name", "action", "prompt"};
            f31645l = new String[]{"optgroup", "option"};
            f31646m = new String[]{"rp", "rt"};
            f31647n = new String[]{HTML.Tag.f27619g, "col", "colgroup", TypedValues.AttributesType.L, "head", HTML.Tag.f27615c, "td", HTML.Tag.f27616d, "th", HTML.Tag.f27614b, "tr"};
            o = new String[]{HTML.Tag.F, HTML.Tag.G, HTML.Tag.H, "blockquote", HTML.Tag.e0, "center", HTML.Tag.f0, HTML.Attribute.u, "div", "dl", HTML.Tag.L, HTML.Tag.M, HTML.Tag.N, HTML.Tag.O, HTML.Tag.R, HTML.Tag.S, "listing", HTML.Tag.w0, HTML.Tag.x0, "ol", "pre", HTML.Tag.V, "summary", "ul"};
            p = new String[]{"a", "b", HTML.Tag.T0, HTML.Tag.g0, "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};
            q = new String[]{"table", HTML.Tag.f27615c, HTML.Tag.f27616d, HTML.Tag.f27614b, "tr"};
        }

        private Constants() {
        }
    }

    static {
        q3 = String.valueOf(0);
    }

    /* access modifiers changed from: private */
    public static void g(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.L(startTag);
        htmlTreeBuilder.f31709b.y(TokeniserState.Rawtext);
        htmlTreeBuilder.d0();
        htmlTreeBuilder.D0(Text);
    }

    /* access modifiers changed from: private */
    public static void h(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.L(startTag);
        htmlTreeBuilder.f31709b.y(TokeniserState.Rcdata);
        htmlTreeBuilder.d0();
        htmlTreeBuilder.D0(Text);
    }

    /* access modifiers changed from: private */
    public static boolean i(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (!StringUtil.f(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean j(Token token) {
        if (token.f()) {
            return i(token.a().p());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean k(Token token, HtmlTreeBuilder htmlTreeBuilder);
}
