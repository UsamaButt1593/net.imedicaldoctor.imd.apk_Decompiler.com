package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class Collector {

    private static class Accumulator implements NodeVisitor {

        /* renamed from: a  reason: collision with root package name */
        private final Element f31732a;

        /* renamed from: b  reason: collision with root package name */
        private final Elements f31733b;

        /* renamed from: c  reason: collision with root package name */
        private final Evaluator f31734c;

        Accumulator(Element element, Elements elements, Evaluator evaluator) {
            this.f31732a = element;
            this.f31733b = elements;
            this.f31734c = evaluator;
        }

        public void a(Node node, int i2) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (this.f31734c.a(this.f31732a, element)) {
                    this.f31733b.add(element);
                }
            }
        }

        public void b(Node node, int i2) {
        }
    }

    private Collector() {
    }

    public static Elements a(Evaluator evaluator, Element element) {
        Elements elements = new Elements();
        new NodeTraversor(new Accumulator(element, elements, evaluator)).a(element);
        return elements;
    }
}
