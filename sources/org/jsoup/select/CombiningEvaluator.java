package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;

abstract class CombiningEvaluator extends Evaluator {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<Evaluator> f31735a;

    /* renamed from: b  reason: collision with root package name */
    int f31736b;

    static final class And extends CombiningEvaluator {
        And(Collection<Evaluator> collection) {
            super(collection);
        }

        public boolean a(Element element, Element element2) {
            for (int i2 = 0; i2 < this.f31736b; i2++) {
                if (!this.f31735a.get(i2).a(element, element2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return StringUtil.g(this.f31735a, StringUtils.SPACE);
        }

        And(Evaluator... evaluatorArr) {
            this((Collection<Evaluator>) Arrays.asList(evaluatorArr));
        }
    }

    static final class Or extends CombiningEvaluator {
        Or() {
        }

        public boolean a(Element element, Element element2) {
            for (int i2 = 0; i2 < this.f31736b; i2++) {
                if (this.f31735a.get(i2).a(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public void e(Evaluator evaluator) {
            this.f31735a.add(evaluator);
            d();
        }

        public String toString() {
            return String.format(":or%s", new Object[]{this.f31735a});
        }

        Or(Collection<Evaluator> collection) {
            if (this.f31736b > 1) {
                this.f31735a.add(new And(collection));
            } else {
                this.f31735a.addAll(collection);
            }
            d();
        }

        Or(Evaluator... evaluatorArr) {
            this((Collection<Evaluator>) Arrays.asList(evaluatorArr));
        }
    }

    CombiningEvaluator() {
        this.f31736b = 0;
        this.f31735a = new ArrayList<>();
    }

    /* access modifiers changed from: package-private */
    public void b(Evaluator evaluator) {
        this.f31735a.set(this.f31736b - 1, evaluator);
    }

    /* access modifiers changed from: package-private */
    public Evaluator c() {
        int i2 = this.f31736b;
        if (i2 > 0) {
            return this.f31735a.get(i2 - 1);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f31736b = this.f31735a.size();
    }

    CombiningEvaluator(Collection<Evaluator> collection) {
        this();
        this.f31735a.addAll(collection);
        d();
    }
}
