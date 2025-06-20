package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.nodes.Element;

abstract class StructuralEvaluator extends Evaluator {

    /* renamed from: a  reason: collision with root package name */
    Evaluator f31765a;

    static class Has extends StructuralEvaluator {
        public Has(Evaluator evaluator) {
            this.f31765a = evaluator;
        }

        public boolean a(Element element, Element element2) {
            Iterator it2 = element2.w1().iterator();
            while (it2.hasNext()) {
                Element element3 = (Element) it2.next();
                if (element3 != element2 && this.f31765a.a(element, element3)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":has(%s)", new Object[]{this.f31765a});
        }
    }

    static class ImmediateParent extends StructuralEvaluator {
        public ImmediateParent(Evaluator evaluator) {
            this.f31765a = evaluator;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
            r4 = r4.S();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(org.jsoup.nodes.Element r3, org.jsoup.nodes.Element r4) {
            /*
                r2 = this;
                r0 = 0
                if (r3 != r4) goto L_0x0004
                return r0
            L_0x0004:
                org.jsoup.nodes.Element r4 = r4.S()
                if (r4 == 0) goto L_0x0013
                org.jsoup.select.Evaluator r1 = r2.f31765a
                boolean r3 = r1.a(r3, r4)
                if (r3 == 0) goto L_0x0013
                r0 = 1
            L_0x0013:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.StructuralEvaluator.ImmediateParent.a(org.jsoup.nodes.Element, org.jsoup.nodes.Element):boolean");
        }

        public String toString() {
            return String.format(":ImmediateParent%s", new Object[]{this.f31765a});
        }
    }

    static class ImmediatePreviousSibling extends StructuralEvaluator {
        public ImmediatePreviousSibling(Evaluator evaluator) {
            this.f31765a = evaluator;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
            r4 = r4.Y2();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(org.jsoup.nodes.Element r3, org.jsoup.nodes.Element r4) {
            /*
                r2 = this;
                r0 = 0
                if (r3 != r4) goto L_0x0004
                return r0
            L_0x0004:
                org.jsoup.nodes.Element r4 = r4.Y2()
                if (r4 == 0) goto L_0x0013
                org.jsoup.select.Evaluator r1 = r2.f31765a
                boolean r3 = r1.a(r3, r4)
                if (r3 == 0) goto L_0x0013
                r0 = 1
            L_0x0013:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.StructuralEvaluator.ImmediatePreviousSibling.a(org.jsoup.nodes.Element, org.jsoup.nodes.Element):boolean");
        }

        public String toString() {
            return String.format(":prev%s", new Object[]{this.f31765a});
        }
    }

    static class Not extends StructuralEvaluator {
        public Not(Evaluator evaluator) {
            this.f31765a = evaluator;
        }

        public boolean a(Element element, Element element2) {
            return !this.f31765a.a(element, element2);
        }

        public String toString() {
            return String.format(":not%s", new Object[]{this.f31765a});
        }
    }

    static class Parent extends StructuralEvaluator {
        public Parent(Evaluator evaluator) {
            this.f31765a = evaluator;
        }

        public boolean a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            do {
                element2 = element2.S();
                if (this.f31765a.a(element, element2)) {
                    return true;
                }
            } while (element2 != element);
            return false;
        }

        public String toString() {
            return String.format(":parent%s", new Object[]{this.f31765a});
        }
    }

    static class PreviousSibling extends StructuralEvaluator {
        public PreviousSibling(Evaluator evaluator) {
            this.f31765a = evaluator;
        }

        public boolean a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            do {
                element2 = element2.Y2();
                if (element2 == null) {
                    return false;
                }
            } while (!this.f31765a.a(element, element2));
            return true;
        }

        public String toString() {
            return String.format(":prev*%s", new Object[]{this.f31765a});
        }
    }

    static class Root extends Evaluator {
        Root() {
        }

        public boolean a(Element element, Element element2) {
            return element == element2;
        }
    }

    StructuralEvaluator() {
    }
}
