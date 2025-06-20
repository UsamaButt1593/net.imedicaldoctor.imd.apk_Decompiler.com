package org.jsoup.select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;

public class Selector {

    /* renamed from: a  reason: collision with root package name */
    private final Evaluator f31763a;

    /* renamed from: b  reason: collision with root package name */
    private final Element f31764b;

    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    private Selector(String str, Element element) {
        Validate.j(str);
        String trim = str.trim();
        Validate.h(trim);
        Validate.j(element);
        this.f31763a = QueryParser.t(trim);
        this.f31764b = element;
    }

    static Elements a(Collection<Element> collection, Collection<Element> collection2) {
        Elements elements = new Elements();
        for (Element next : collection) {
            Iterator<Element> it2 = collection2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (next.equals(it2.next())) {
                        break;
                    }
                } else {
                    elements.add(next);
                    break;
                }
            }
        }
        return elements;
    }

    private Elements b() {
        return Collector.a(this.f31763a, this.f31764b);
    }

    public static Elements c(String str, Iterable<Element> iterable) {
        Validate.h(str);
        Validate.j(iterable);
        Evaluator t = QueryParser.t(str);
        ArrayList arrayList = new ArrayList();
        IdentityHashMap identityHashMap = new IdentityHashMap();
        for (Element e2 : iterable) {
            Iterator it2 = e(t, e2).iterator();
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                if (!identityHashMap.containsKey(element)) {
                    arrayList.add(element);
                    identityHashMap.put(element, Boolean.TRUE);
                }
            }
        }
        return new Elements((List<Element>) arrayList);
    }

    public static Elements d(String str, Element element) {
        return new Selector(str, element).b();
    }

    public static Elements e(Evaluator evaluator, Element element) {
        return new Selector(evaluator, element).b();
    }

    private Selector(Evaluator evaluator, Element element) {
        Validate.j(evaluator);
        Validate.j(element);
        this.f31763a = evaluator;
        this.f31764b = element;
    }
}
