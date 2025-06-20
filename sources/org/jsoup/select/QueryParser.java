package org.jsoup.select;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.parser.TokenQueue;
import org.jsoup.select.CombiningEvaluator;
import org.jsoup.select.Evaluator;
import org.jsoup.select.Selector;
import org.jsoup.select.StructuralEvaluator;

public class QueryParser {

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f31756d = {",", ">", "+", "~", StringUtils.SPACE};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f31757e = {"=", "!=", "^=", "$=", "*=", "~="};

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f31758f = Pattern.compile("((\\+|-)?(\\d+)?)n(\\s*(\\+|-)?\\s*\\d+)?", 2);

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f31759g = Pattern.compile("(\\+|-)?(\\d+)");

    /* renamed from: a  reason: collision with root package name */
    private TokenQueue f31760a;

    /* renamed from: b  reason: collision with root package name */
    private String f31761b;

    /* renamed from: c  reason: collision with root package name */
    private List<Evaluator> f31762c = new ArrayList();

    private QueryParser(String str) {
        this.f31761b = str;
        this.f31760a = new TokenQueue(str);
    }

    private void a() {
        this.f31762c.add(new Evaluator.AllElements());
    }

    private void b() {
        List<Evaluator> list;
        Object attributeWithValueMatching;
        TokenQueue tokenQueue = new TokenQueue(this.f31760a.d('[', ']'));
        String n2 = tokenQueue.n(f31757e);
        Validate.h(n2);
        tokenQueue.p();
        if (!tokenQueue.r()) {
            if (tokenQueue.s("=")) {
                list = this.f31762c;
                attributeWithValueMatching = new Evaluator.AttributeWithValue(n2, tokenQueue.B());
            } else if (tokenQueue.s("!=")) {
                list = this.f31762c;
                attributeWithValueMatching = new Evaluator.AttributeWithValueNot(n2, tokenQueue.B());
            } else if (tokenQueue.s("^=")) {
                list = this.f31762c;
                attributeWithValueMatching = new Evaluator.AttributeWithValueStarting(n2, tokenQueue.B());
            } else if (tokenQueue.s("$=")) {
                list = this.f31762c;
                attributeWithValueMatching = new Evaluator.AttributeWithValueEnding(n2, tokenQueue.B());
            } else if (tokenQueue.s("*=")) {
                list = this.f31762c;
                attributeWithValueMatching = new Evaluator.AttributeWithValueContaining(n2, tokenQueue.B());
            } else if (tokenQueue.s("~=")) {
                list = this.f31762c;
                attributeWithValueMatching = new Evaluator.AttributeWithValueMatching(n2, Pattern.compile(tokenQueue.B()));
            } else {
                throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.f31761b, tokenQueue.B());
            }
            list.add(attributeWithValueMatching);
        } else if (n2.startsWith("^")) {
            this.f31762c.add(new Evaluator.AttributeStarting(n2.substring(1)));
        } else {
            this.f31762c.add(new Evaluator.Attribute(n2));
        }
    }

    private void c() {
        String j2 = this.f31760a.j();
        Validate.h(j2);
        this.f31762c.add(new Evaluator.Class(j2.trim()));
    }

    private void d() {
        String j2 = this.f31760a.j();
        Validate.h(j2);
        this.f31762c.add(new Evaluator.Id(j2));
    }

    private void e() {
        String k2 = this.f31760a.k();
        Validate.h(k2);
        if (k2.startsWith("*|")) {
            this.f31762c.add(new CombiningEvaluator.Or(new Evaluator.Tag(Normalizer.b(k2)), new Evaluator.TagEndsWith(Normalizer.b(k2.replace("*|", ":")))));
            return;
        }
        if (k2.contains("|")) {
            k2 = k2.replace("|", ":");
        }
        this.f31762c.add(new Evaluator.Tag(k2.trim()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(char r11) {
        /*
            r10 = this;
            r0 = 2
            org.jsoup.parser.TokenQueue r1 = r10.f31760a
            r1.p()
            java.lang.String r1 = r10.h()
            org.jsoup.select.Evaluator r1 = t(r1)
            java.util.List<org.jsoup.select.Evaluator> r2 = r10.f31762c
            int r2 = r2.size()
            r3 = 44
            r4 = 0
            r5 = 1
            if (r2 != r5) goto L_0x0037
            java.util.List<org.jsoup.select.Evaluator> r2 = r10.f31762c
            java.lang.Object r2 = r2.get(r4)
            org.jsoup.select.Evaluator r2 = (org.jsoup.select.Evaluator) r2
            boolean r6 = r2 instanceof org.jsoup.select.CombiningEvaluator.Or
            if (r6 == 0) goto L_0x0034
            if (r11 == r3) goto L_0x0034
            r6 = r2
            org.jsoup.select.CombiningEvaluator$Or r6 = (org.jsoup.select.CombiningEvaluator.Or) r6
            org.jsoup.select.Evaluator r6 = r6.c()
            r7 = 1
            r9 = r6
            r6 = r2
            r2 = r9
            goto L_0x003f
        L_0x0034:
            r6 = r2
            r7 = 0
            goto L_0x003f
        L_0x0037:
            org.jsoup.select.CombiningEvaluator$And r2 = new org.jsoup.select.CombiningEvaluator$And
            java.util.List<org.jsoup.select.Evaluator> r6 = r10.f31762c
            r2.<init>((java.util.Collection<org.jsoup.select.Evaluator>) r6)
            goto L_0x0034
        L_0x003f:
            java.util.List<org.jsoup.select.Evaluator> r8 = r10.f31762c
            r8.clear()
            r8 = 62
            if (r11 != r8) goto L_0x0059
            org.jsoup.select.CombiningEvaluator$And r11 = new org.jsoup.select.CombiningEvaluator$And
            org.jsoup.select.StructuralEvaluator$ImmediateParent r3 = new org.jsoup.select.StructuralEvaluator$ImmediateParent
            r3.<init>(r2)
            org.jsoup.select.Evaluator[] r0 = new org.jsoup.select.Evaluator[r0]
            r0[r4] = r1
            r0[r5] = r3
            r11.<init>((org.jsoup.select.Evaluator[]) r0)
            goto L_0x00b0
        L_0x0059:
            r8 = 32
            if (r11 != r8) goto L_0x006e
            org.jsoup.select.CombiningEvaluator$And r11 = new org.jsoup.select.CombiningEvaluator$And
            org.jsoup.select.StructuralEvaluator$Parent r3 = new org.jsoup.select.StructuralEvaluator$Parent
            r3.<init>(r2)
            org.jsoup.select.Evaluator[] r0 = new org.jsoup.select.Evaluator[r0]
            r0[r4] = r1
            r0[r5] = r3
            r11.<init>((org.jsoup.select.Evaluator[]) r0)
            goto L_0x00b0
        L_0x006e:
            r8 = 43
            if (r11 != r8) goto L_0x0083
            org.jsoup.select.CombiningEvaluator$And r11 = new org.jsoup.select.CombiningEvaluator$And
            org.jsoup.select.StructuralEvaluator$ImmediatePreviousSibling r3 = new org.jsoup.select.StructuralEvaluator$ImmediatePreviousSibling
            r3.<init>(r2)
            org.jsoup.select.Evaluator[] r0 = new org.jsoup.select.Evaluator[r0]
            r0[r4] = r1
            r0[r5] = r3
            r11.<init>((org.jsoup.select.Evaluator[]) r0)
            goto L_0x00b0
        L_0x0083:
            r8 = 126(0x7e, float:1.77E-43)
            if (r11 != r8) goto L_0x0098
            org.jsoup.select.CombiningEvaluator$And r11 = new org.jsoup.select.CombiningEvaluator$And
            org.jsoup.select.StructuralEvaluator$PreviousSibling r3 = new org.jsoup.select.StructuralEvaluator$PreviousSibling
            r3.<init>(r2)
            org.jsoup.select.Evaluator[] r0 = new org.jsoup.select.Evaluator[r0]
            r0[r4] = r1
            r0[r5] = r3
            r11.<init>((org.jsoup.select.Evaluator[]) r0)
            goto L_0x00b0
        L_0x0098:
            if (r11 != r3) goto L_0x00c0
            boolean r11 = r2 instanceof org.jsoup.select.CombiningEvaluator.Or
            if (r11 == 0) goto L_0x00a5
            org.jsoup.select.CombiningEvaluator$Or r2 = (org.jsoup.select.CombiningEvaluator.Or) r2
            r2.e(r1)
            r11 = r2
            goto L_0x00b0
        L_0x00a5:
            org.jsoup.select.CombiningEvaluator$Or r11 = new org.jsoup.select.CombiningEvaluator$Or
            r11.<init>()
            r11.e(r2)
            r11.e(r1)
        L_0x00b0:
            if (r7 == 0) goto L_0x00b9
            r0 = r6
            org.jsoup.select.CombiningEvaluator$Or r0 = (org.jsoup.select.CombiningEvaluator.Or) r0
            r0.b(r11)
            goto L_0x00ba
        L_0x00b9:
            r6 = r11
        L_0x00ba:
            java.util.List<org.jsoup.select.Evaluator> r11 = r10.f31762c
            r11.add(r6)
            return
        L_0x00c0:
            org.jsoup.select.Selector$SelectorParseException r0 = new org.jsoup.select.Selector$SelectorParseException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown combinator: "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r0.<init>(r11, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.QueryParser.f(char):void");
    }

    private int g() {
        String trim = this.f31760a.e(")").trim();
        Validate.e(StringUtil.e(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    private String h() {
        String str;
        StringBuilder sb = new StringBuilder();
        while (!this.f31760a.r()) {
            if (this.f31760a.t("(")) {
                sb.append("(");
                sb.append(this.f31760a.d(ASCIIPropertyListParser.f18649g, ASCIIPropertyListParser.f18650h));
                str = ")";
            } else if (this.f31760a.t("[")) {
                sb.append("[");
                sb.append(this.f31760a.d('[', ']'));
                str = "]";
            } else if (this.f31760a.v(f31756d)) {
                break;
            } else {
                sb.append(this.f31760a.g());
            }
            sb.append(str);
        }
        return sb.toString();
    }

    private void i(boolean z) {
        List<Evaluator> list;
        Object containsText;
        this.f31760a.h(z ? ":containsOwn" : ":contains");
        String D = TokenQueue.D(this.f31760a.d(ASCIIPropertyListParser.f18649g, ASCIIPropertyListParser.f18650h));
        Validate.i(D, ":contains(text) query must not be empty");
        if (z) {
            list = this.f31762c;
            containsText = new Evaluator.ContainsOwnText(D);
        } else {
            list = this.f31762c;
            containsText = new Evaluator.ContainsText(D);
        }
        list.add(containsText);
    }

    private void j() {
        this.f31760a.h(":containsData");
        String D = TokenQueue.D(this.f31760a.d(ASCIIPropertyListParser.f18649g, ASCIIPropertyListParser.f18650h));
        Validate.i(D, ":containsData(text) query must not be empty");
        this.f31762c.add(new Evaluator.ContainsData(D));
    }

    private void k(boolean z, boolean z2) {
        int i2;
        List<Evaluator> list;
        Object isNthChild;
        int i3 = 0;
        String b2 = Normalizer.b(this.f31760a.e(")"));
        Matcher matcher = f31758f.matcher(b2);
        Matcher matcher2 = f31759g.matcher(b2);
        int i4 = 1;
        if ("odd".equals(b2)) {
            i3 = 2;
            i2 = 1;
        } else if ("even".equals(b2)) {
            i3 = 2;
            i2 = 0;
        } else if (matcher.matches()) {
            if (matcher.group(3) != null) {
                i4 = Integer.parseInt(matcher.group(1).replaceFirst("^\\+", ""));
            }
            if (matcher.group(4) != null) {
                i3 = Integer.parseInt(matcher.group(4).replaceFirst("^\\+", ""));
            }
            i2 = i3;
            i3 = i4;
        } else if (matcher2.matches()) {
            i2 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
        } else {
            throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", b2);
        }
        if (z2) {
            if (z) {
                list = this.f31762c;
                isNthChild = new Evaluator.IsNthLastOfType(i3, i2);
            } else {
                list = this.f31762c;
                isNthChild = new Evaluator.IsNthOfType(i3, i2);
            }
        } else if (z) {
            list = this.f31762c;
            isNthChild = new Evaluator.IsNthLastChild(i3, i2);
        } else {
            list = this.f31762c;
            isNthChild = new Evaluator.IsNthChild(i3, i2);
        }
        list.add(isNthChild);
    }

    private void l() {
        List<Evaluator> list;
        Object isRoot;
        if (this.f31760a.s("#")) {
            d();
        } else if (this.f31760a.s(".")) {
            c();
        } else if (this.f31760a.z() || this.f31760a.t("*|")) {
            e();
        } else if (this.f31760a.t("[")) {
            b();
        } else if (this.f31760a.s("*")) {
            a();
        } else if (this.f31760a.s(":lt(")) {
            p();
        } else if (this.f31760a.s(":gt(")) {
            o();
        } else if (this.f31760a.s(":eq(")) {
            n();
        } else if (this.f31760a.t(":has(")) {
            m();
        } else if (this.f31760a.t(":contains(")) {
            i(false);
        } else if (this.f31760a.t(":containsOwn(")) {
            i(true);
        } else if (this.f31760a.t(":containsData(")) {
            j();
        } else if (this.f31760a.t(":matches(")) {
            q(false);
        } else if (this.f31760a.t(":matchesOwn(")) {
            q(true);
        } else if (this.f31760a.t(":not(")) {
            r();
        } else if (this.f31760a.s(":nth-child(")) {
            k(false, false);
        } else if (this.f31760a.s(":nth-last-child(")) {
            k(true, false);
        } else if (this.f31760a.s(":nth-of-type(")) {
            k(false, true);
        } else if (this.f31760a.s(":nth-last-of-type(")) {
            k(true, true);
        } else {
            if (this.f31760a.s(":first-child")) {
                list = this.f31762c;
                isRoot = new Evaluator.IsFirstChild();
            } else if (this.f31760a.s(":last-child")) {
                list = this.f31762c;
                isRoot = new Evaluator.IsLastChild();
            } else if (this.f31760a.s(":first-of-type")) {
                list = this.f31762c;
                isRoot = new Evaluator.IsFirstOfType();
            } else if (this.f31760a.s(":last-of-type")) {
                list = this.f31762c;
                isRoot = new Evaluator.IsLastOfType();
            } else if (this.f31760a.s(":only-child")) {
                list = this.f31762c;
                isRoot = new Evaluator.IsOnlyChild();
            } else if (this.f31760a.s(":only-of-type")) {
                list = this.f31762c;
                isRoot = new Evaluator.IsOnlyOfType();
            } else if (this.f31760a.s(":empty")) {
                list = this.f31762c;
                isRoot = new Evaluator.IsEmpty();
            } else if (this.f31760a.s(":root")) {
                list = this.f31762c;
                isRoot = new Evaluator.IsRoot();
            } else {
                throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.f31761b, this.f31760a.B());
            }
            list.add(isRoot);
        }
    }

    private void m() {
        this.f31760a.h(":has");
        String d2 = this.f31760a.d(ASCIIPropertyListParser.f18649g, ASCIIPropertyListParser.f18650h);
        Validate.i(d2, ":has(el) subselect must not be empty");
        this.f31762c.add(new StructuralEvaluator.Has(t(d2)));
    }

    private void n() {
        this.f31762c.add(new Evaluator.IndexEquals(g()));
    }

    private void o() {
        this.f31762c.add(new Evaluator.IndexGreaterThan(g()));
    }

    private void p() {
        this.f31762c.add(new Evaluator.IndexLessThan(g()));
    }

    private void q(boolean z) {
        List<Evaluator> list;
        Object matches;
        this.f31760a.h(z ? ":matchesOwn" : ":matches");
        String d2 = this.f31760a.d(ASCIIPropertyListParser.f18649g, ASCIIPropertyListParser.f18650h);
        Validate.i(d2, ":matches(regex) query must not be empty");
        if (z) {
            list = this.f31762c;
            matches = new Evaluator.MatchesOwn(Pattern.compile(d2));
        } else {
            list = this.f31762c;
            matches = new Evaluator.Matches(Pattern.compile(d2));
        }
        list.add(matches);
    }

    private void r() {
        this.f31760a.h(":not");
        String d2 = this.f31760a.d(ASCIIPropertyListParser.f18649g, ASCIIPropertyListParser.f18650h);
        Validate.i(d2, ":not(selector) subselect must not be empty");
        this.f31762c.add(new StructuralEvaluator.Not(t(d2)));
    }

    public static Evaluator t(String str) {
        try {
            return new QueryParser(str).s();
        } catch (IllegalArgumentException e2) {
            throw new Selector.SelectorParseException(e2.getMessage(), new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jsoup.select.Evaluator s() {
        /*
            r3 = this;
            org.jsoup.parser.TokenQueue r0 = r3.f31760a
            r0.p()
            org.jsoup.parser.TokenQueue r0 = r3.f31760a
            java.lang.String[] r1 = f31756d
            boolean r0 = r0.v(r1)
            if (r0 == 0) goto L_0x0023
            java.util.List<org.jsoup.select.Evaluator> r0 = r3.f31762c
            org.jsoup.select.StructuralEvaluator$Root r1 = new org.jsoup.select.StructuralEvaluator$Root
            r1.<init>()
            r0.add(r1)
        L_0x0019:
            org.jsoup.parser.TokenQueue r0 = r3.f31760a
            char r0 = r0.g()
        L_0x001f:
            r3.f(r0)
            goto L_0x0026
        L_0x0023:
            r3.l()
        L_0x0026:
            org.jsoup.parser.TokenQueue r0 = r3.f31760a
            boolean r0 = r0.r()
            if (r0 != 0) goto L_0x0044
            org.jsoup.parser.TokenQueue r0 = r3.f31760a
            boolean r0 = r0.p()
            org.jsoup.parser.TokenQueue r1 = r3.f31760a
            java.lang.String[] r2 = f31756d
            boolean r1 = r1.v(r2)
            if (r1 == 0) goto L_0x003f
            goto L_0x0019
        L_0x003f:
            if (r0 == 0) goto L_0x0023
            r0 = 32
            goto L_0x001f
        L_0x0044:
            java.util.List<org.jsoup.select.Evaluator> r0 = r3.f31762c
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L_0x0057
            java.util.List<org.jsoup.select.Evaluator> r0 = r3.f31762c
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            org.jsoup.select.Evaluator r0 = (org.jsoup.select.Evaluator) r0
            return r0
        L_0x0057:
            org.jsoup.select.CombiningEvaluator$And r0 = new org.jsoup.select.CombiningEvaluator$And
            java.util.List<org.jsoup.select.Evaluator> r1 = r3.f31762c
            r0.<init>((java.util.Collection<org.jsoup.select.Evaluator>) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.QueryParser.s():org.jsoup.select.Evaluator");
    }
}
