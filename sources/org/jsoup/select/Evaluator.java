package org.jsoup.select;

import java.util.Iterator;
import java.util.regex.Pattern;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.XmlDeclaration;

public abstract class Evaluator {

    public static final class AllElements extends Evaluator {
        public boolean a(Element element, Element element2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    public static final class Attribute extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f31737a;

        public Attribute(String str) {
            this.f31737a = str;
        }

        public boolean a(Element element, Element element2) {
            return element2.z(this.f31737a);
        }

        public String toString() {
            return String.format("[%s]", new Object[]{this.f31737a});
        }
    }

    public static abstract class AttributeKeyPair extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        String f31738a;

        /* renamed from: b  reason: collision with root package name */
        String f31739b;

        public AttributeKeyPair(String str, String str2) {
            Validate.h(str);
            Validate.h(str2);
            this.f31738a = Normalizer.b(str);
            if ((str2.startsWith("\"") && str2.endsWith("\"")) || (str2.startsWith("'") && str2.endsWith("'"))) {
                str2 = str2.substring(1, str2.length() - 1);
            }
            this.f31739b = Normalizer.b(str2);
        }
    }

    public static final class AttributeStarting extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f31740a;

        public AttributeStarting(String str) {
            Validate.h(str);
            this.f31740a = Normalizer.a(str);
        }

        public boolean a(Element element, Element element2) {
            for (org.jsoup.nodes.Attribute c2 : element2.i().h()) {
                if (Normalizer.a(c2.getKey()).startsWith(this.f31740a)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", new Object[]{this.f31740a});
        }
    }

    public static final class AttributeWithValue extends AttributeKeyPair {
        public AttributeWithValue(String str, String str2) {
            super(str, str2);
        }

        public boolean a(Element element, Element element2) {
            return element2.z(this.f31738a) && this.f31739b.equalsIgnoreCase(element2.g(this.f31738a).trim());
        }

        public String toString() {
            return String.format("[%s=%s]", new Object[]{this.f31738a, this.f31739b});
        }
    }

    public static final class AttributeWithValueContaining extends AttributeKeyPair {
        public AttributeWithValueContaining(String str, String str2) {
            super(str, str2);
        }

        public boolean a(Element element, Element element2) {
            return element2.z(this.f31738a) && Normalizer.a(element2.g(this.f31738a)).contains(this.f31739b);
        }

        public String toString() {
            return String.format("[%s*=%s]", new Object[]{this.f31738a, this.f31739b});
        }
    }

    public static final class AttributeWithValueEnding extends AttributeKeyPair {
        public AttributeWithValueEnding(String str, String str2) {
            super(str, str2);
        }

        public boolean a(Element element, Element element2) {
            return element2.z(this.f31738a) && Normalizer.a(element2.g(this.f31738a)).endsWith(this.f31739b);
        }

        public String toString() {
            return String.format("[%s$=%s]", new Object[]{this.f31738a, this.f31739b});
        }
    }

    public static final class AttributeWithValueMatching extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        String f31741a;

        /* renamed from: b  reason: collision with root package name */
        Pattern f31742b;

        public AttributeWithValueMatching(String str, Pattern pattern) {
            this.f31741a = Normalizer.b(str);
            this.f31742b = pattern;
        }

        public boolean a(Element element, Element element2) {
            return element2.z(this.f31741a) && this.f31742b.matcher(element2.g(this.f31741a)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", new Object[]{this.f31741a, this.f31742b.toString()});
        }
    }

    public static final class AttributeWithValueNot extends AttributeKeyPair {
        public AttributeWithValueNot(String str, String str2) {
            super(str, str2);
        }

        public boolean a(Element element, Element element2) {
            return !this.f31739b.equalsIgnoreCase(element2.g(this.f31738a));
        }

        public String toString() {
            return String.format("[%s!=%s]", new Object[]{this.f31738a, this.f31739b});
        }
    }

    public static final class AttributeWithValueStarting extends AttributeKeyPair {
        public AttributeWithValueStarting(String str, String str2) {
            super(str, str2);
        }

        public boolean a(Element element, Element element2) {
            return element2.z(this.f31738a) && Normalizer.a(element2.g(this.f31738a)).startsWith(this.f31739b);
        }

        public String toString() {
            return String.format("[%s^=%s]", new Object[]{this.f31738a, this.f31739b});
        }
    }

    public static final class Class extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f31743a;

        public Class(String str) {
            this.f31743a = str;
        }

        public boolean a(Element element, Element element2) {
            return element2.n2(this.f31743a);
        }

        public String toString() {
            return String.format(".%s", new Object[]{this.f31743a});
        }
    }

    public static final class ContainsData extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f31744a;

        public ContainsData(String str) {
            this.f31744a = Normalizer.a(str);
        }

        public boolean a(Element element, Element element2) {
            return Normalizer.a(element2.j1()).contains(this.f31744a);
        }

        public String toString() {
            return String.format(":containsData(%s)", new Object[]{this.f31744a});
        }
    }

    public static final class ContainsOwnText extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f31745a;

        public ContainsOwnText(String str) {
            this.f31745a = Normalizer.a(str);
        }

        public boolean a(Element element, Element element2) {
            return Normalizer.a(element2.N2()).contains(this.f31745a);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", new Object[]{this.f31745a});
        }
    }

    public static final class ContainsText extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f31746a;

        public ContainsText(String str) {
            this.f31746a = Normalizer.a(str);
        }

        public boolean a(Element element, Element element2) {
            return Normalizer.a(element2.f3()).contains(this.f31746a);
        }

        public String toString() {
            return String.format(":contains(%s)", new Object[]{this.f31746a});
        }
    }

    public static abstract class CssNthEvaluator extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        protected final int f31747a;

        /* renamed from: b  reason: collision with root package name */
        protected final int f31748b;

        public CssNthEvaluator(int i2) {
            this(0, i2);
        }

        public boolean a(Element element, Element element2) {
            Element Q2 = element2.S();
            if (Q2 == null || (Q2 instanceof Document)) {
                return false;
            }
            int b2 = b(element, element2);
            int i2 = this.f31747a;
            if (i2 == 0) {
                return b2 == this.f31748b;
            }
            int i3 = this.f31748b;
            return (b2 - i3) * i2 >= 0 && (b2 - i3) % i2 == 0;
        }

        /* access modifiers changed from: protected */
        public abstract int b(Element element, Element element2);

        /* access modifiers changed from: protected */
        public abstract String c();

        public String toString() {
            if (this.f31747a == 0) {
                return String.format(":%s(%d)", new Object[]{c(), Integer.valueOf(this.f31748b)});
            } else if (this.f31748b == 0) {
                return String.format(":%s(%dn)", new Object[]{c(), Integer.valueOf(this.f31747a)});
            } else {
                return String.format(":%s(%dn%+d)", new Object[]{c(), Integer.valueOf(this.f31747a), Integer.valueOf(this.f31748b)});
            }
        }

        public CssNthEvaluator(int i2, int i3) {
            this.f31747a = i2;
            this.f31748b = i3;
        }
    }

    public static final class Id extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f31749a;

        public Id(String str) {
            this.f31749a = str;
        }

        public boolean a(Element element, Element element2) {
            return this.f31749a.equals(element2.w2());
        }

        public String toString() {
            return String.format("#%s", new Object[]{this.f31749a});
        }
    }

    public static final class IndexEquals extends IndexEvaluator {
        public IndexEquals(int i2) {
            super(i2);
        }

        public boolean a(Element element, Element element2) {
            return element2.r1() == this.f31750a;
        }

        public String toString() {
            return String.format(":eq(%d)", new Object[]{Integer.valueOf(this.f31750a)});
        }
    }

    public static abstract class IndexEvaluator extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        int f31750a;

        public IndexEvaluator(int i2) {
            this.f31750a = i2;
        }
    }

    public static final class IndexGreaterThan extends IndexEvaluator {
        public IndexGreaterThan(int i2) {
            super(i2);
        }

        public boolean a(Element element, Element element2) {
            return element2.r1() > this.f31750a;
        }

        public String toString() {
            return String.format(":gt(%d)", new Object[]{Integer.valueOf(this.f31750a)});
        }
    }

    public static final class IndexLessThan extends IndexEvaluator {
        public IndexLessThan(int i2) {
            super(i2);
        }

        public boolean a(Element element, Element element2) {
            return element2.r1() < this.f31750a;
        }

        public String toString() {
            return String.format(":lt(%d)", new Object[]{Integer.valueOf(this.f31750a)});
        }
    }

    public static final class IsEmpty extends Evaluator {
        public boolean a(Element element, Element element2) {
            for (Node next : element2.q()) {
                if (!(next instanceof Comment) && !(next instanceof XmlDeclaration) && !(next instanceof DocumentType)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    public static final class IsFirstChild extends Evaluator {
        public boolean a(Element element, Element element2) {
            Element Q2 = element2.S();
            return Q2 != null && !(Q2 instanceof Document) && element2.r1() == 0;
        }

        public String toString() {
            return ":first-child";
        }
    }

    public static final class IsFirstOfType extends IsNthOfType {
        public IsFirstOfType() {
            super(0, 1);
        }

        public String toString() {
            return ":first-of-type";
        }
    }

    public static final class IsLastChild extends Evaluator {
        public boolean a(Element element, Element element2) {
            Element Q2 = element2.S();
            return Q2 != null && !(Q2 instanceof Document) && element2.r1() == Q2.b1().size() - 1;
        }

        public String toString() {
            return ":last-child";
        }
    }

    public static final class IsLastOfType extends IsNthLastOfType {
        public IsLastOfType() {
            super(0, 1);
        }

        public String toString() {
            return ":last-of-type";
        }
    }

    public static final class IsNthChild extends CssNthEvaluator {
        public IsNthChild(int i2, int i3) {
            super(i2, i3);
        }

        /* access modifiers changed from: protected */
        public int b(Element element, Element element2) {
            return element2.r1() + 1;
        }

        /* access modifiers changed from: protected */
        public String c() {
            return "nth-child";
        }
    }

    public static final class IsNthLastChild extends CssNthEvaluator {
        public IsNthLastChild(int i2, int i3) {
            super(i2, i3);
        }

        /* access modifiers changed from: protected */
        public int b(Element element, Element element2) {
            return element2.S().b1().size() - element2.r1();
        }

        /* access modifiers changed from: protected */
        public String c() {
            return "nth-last-child";
        }
    }

    public static class IsNthLastOfType extends CssNthEvaluator {
        public IsNthLastOfType(int i2, int i3) {
            super(i2, i3);
        }

        /* access modifiers changed from: protected */
        public int b(Element element, Element element2) {
            Elements b1 = element2.S().b1();
            int i2 = 0;
            for (int r1 = element2.r1(); r1 < b1.size(); r1++) {
                if (((Element) b1.get(r1)).c3().equals(element2.c3())) {
                    i2++;
                }
            }
            return i2;
        }

        /* access modifiers changed from: protected */
        public String c() {
            return "nth-last-of-type";
        }
    }

    public static class IsNthOfType extends CssNthEvaluator {
        public IsNthOfType(int i2, int i3) {
            super(i2, i3);
        }

        /* access modifiers changed from: protected */
        public int b(Element element, Element element2) {
            Iterator it2 = element2.S().b1().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                Element element3 = (Element) it2.next();
                if (element3.c3().equals(element2.c3())) {
                    i2++;
                    continue;
                }
                if (element3 == element2) {
                    break;
                }
            }
            return i2;
        }

        /* access modifiers changed from: protected */
        public String c() {
            return "nth-of-type";
        }
    }

    public static final class IsOnlyChild extends Evaluator {
        public boolean a(Element element, Element element2) {
            Element Q2 = element2.S();
            return Q2 != null && !(Q2 instanceof Document) && element2.b3().size() == 0;
        }

        public String toString() {
            return ":only-child";
        }
    }

    public static final class IsOnlyOfType extends Evaluator {
        public boolean a(Element element, Element element2) {
            Element Q2 = element2.S();
            if (Q2 == null || (Q2 instanceof Document)) {
                return false;
            }
            Iterator it2 = Q2.b1().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                if (((Element) it2.next()).c3().equals(element2.c3())) {
                    i2++;
                }
            }
            return i2 == 1;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    public static final class IsRoot extends Evaluator {
        public boolean a(Element element, Element element2) {
            if (element instanceof Document) {
                element = element.W0(0);
            }
            return element2 == element;
        }

        public String toString() {
            return ":root";
        }
    }

    public static final class Matches extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private Pattern f31751a;

        public Matches(Pattern pattern) {
            this.f31751a = pattern;
        }

        public boolean a(Element element, Element element2) {
            return this.f31751a.matcher(element2.f3()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", new Object[]{this.f31751a});
        }
    }

    public static final class MatchesOwn extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private Pattern f31752a;

        public MatchesOwn(Pattern pattern) {
            this.f31752a = pattern;
        }

        public boolean a(Element element, Element element2) {
            return this.f31752a.matcher(element2.N2()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", new Object[]{this.f31752a});
        }
    }

    public static final class Tag extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f31753a;

        public Tag(String str) {
            this.f31753a = str;
        }

        public boolean a(Element element, Element element2) {
            return element2.d3().equalsIgnoreCase(this.f31753a);
        }

        public String toString() {
            return String.format("%s", new Object[]{this.f31753a});
        }
    }

    public static final class TagEndsWith extends Evaluator {

        /* renamed from: a  reason: collision with root package name */
        private String f31754a;

        public TagEndsWith(String str) {
            this.f31754a = str;
        }

        public boolean a(Element element, Element element2) {
            return element2.d3().endsWith(this.f31754a);
        }

        public String toString() {
            return String.format("%s", new Object[]{this.f31754a});
        }
    }

    protected Evaluator() {
    }

    public abstract boolean a(Element element, Element element2);
}
