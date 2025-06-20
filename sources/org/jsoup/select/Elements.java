package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;

public class Elements extends ArrayList<Element> {
    public Elements() {
    }

    private Elements F0(String str, boolean z, boolean z2) {
        Elements elements = new Elements();
        Evaluator t = str != null ? QueryParser.t(str) : null;
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            do {
                element = z ? element.M2() : element.Y2();
                if (element == null) {
                    break;
                } else if (t == null || element.I2(t)) {
                    elements.add(element);
                    continue;
                }
            } while (z2);
        }
        return elements;
    }

    public boolean B(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            if (((Element) it2.next()).z(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean D(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            if (((Element) it2.next()).n2(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean E() {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            if (((Element) it2.next()).p2()) {
                return true;
            }
        }
        return false;
    }

    public Elements E0(String str) {
        return Selector.c(str, this);
    }

    public Elements G0(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).e3(str);
        }
        return this;
    }

    public String H0() {
        StringBuilder sb = new StringBuilder();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (sb.length() != 0) {
                sb.append(StringUtils.SPACE);
            }
            sb.append(element.f3());
        }
        return sb.toString();
    }

    public String K() {
        StringBuilder sb = new StringBuilder();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (sb.length() != 0) {
                sb.append(StringUtils.LF);
            }
            sb.append(element.q2());
        }
        return sb.toString();
    }

    public Elements L(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).r2(str);
        }
        return this;
    }

    public boolean M(String str) {
        Evaluator t = QueryParser.t(str);
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            if (((Element) it2.next()).I2(t)) {
                return true;
            }
        }
        return false;
    }

    public Elements M0(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).i3(str);
        }
        return this;
    }

    public Elements O0(NodeVisitor nodeVisitor) {
        Validate.j(nodeVisitor);
        NodeTraversor nodeTraversor = new NodeTraversor(nodeVisitor);
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            nodeTraversor.a((Element) it2.next());
        }
        return this;
    }

    public Element U() {
        if (isEmpty()) {
            return null;
        }
        return (Element) get(size() - 1);
    }

    public Elements V() {
        return F0((String) null, true, false);
    }

    public Elements W0() {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).t0();
        }
        return this;
    }

    public Elements X(String str) {
        return F0(str, true, false);
    }

    public Elements Y() {
        return F0((String) null, true, true);
    }

    public Elements b(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).z0(str);
        }
        return this;
    }

    public Elements b0(String str) {
        return F0(str, true, true);
    }

    public String b1() {
        return size() > 0 ? x().j3() : "";
    }

    public Elements c(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).e(str);
        }
        return this;
    }

    public Elements d(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).E0(str);
        }
        return this;
    }

    public Elements f0(String str) {
        return Selector.a(this, Selector.c(str, this));
    }

    public String g(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (element.z(str)) {
                return element.g(str);
            }
        }
        return "";
    }

    public Elements g1(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).k3(str);
        }
        return this;
    }

    public Elements h(String str, String str2) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).h(str, str2);
        }
        return this;
    }

    public String k0() {
        StringBuilder sb = new StringBuilder();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (sb.length() != 0) {
                sb.append(StringUtils.LF);
            }
            sb.append(element.J());
        }
        return sb.toString();
    }

    public Elements l0() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            linkedHashSet.addAll(((Element) it2.next()).S2());
        }
        return new Elements((Collection<Element>) linkedHashSet);
    }

    public Elements m(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).m(str);
        }
        return this;
    }

    /* renamed from: n */
    public Elements clone() {
        Elements elements = new Elements(size());
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            elements.add(((Element) it2.next()).u());
        }
        return elements;
    }

    public Elements n0(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).T2(str);
        }
        return this;
    }

    public List<String> o(String str) {
        ArrayList arrayList = new ArrayList(size());
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (element.z(str)) {
                arrayList.add(element.g(str));
            }
        }
        return arrayList;
    }

    public Elements o0() {
        return F0((String) null, false, false);
    }

    public List<String> q() {
        ArrayList arrayList = new ArrayList(size());
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (element.p2()) {
                arrayList.add(element.f3());
            }
        }
        return arrayList;
    }

    public Elements q0(String str) {
        return F0(str, false, false);
    }

    public Elements r() {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).t1();
        }
        return this;
    }

    public Elements r1(String str) {
        Validate.h(str);
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).u0(str);
        }
        return this;
    }

    public Elements t(int i2) {
        if (size() <= i2) {
            return new Elements();
        }
        return new Elements((Element) get(i2));
    }

    public Elements t0() {
        return F0((String) null, false, true);
    }

    public String toString() {
        return k0();
    }

    public Elements u0(String str) {
        return F0(str, false, true);
    }

    public Elements w0() {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).Y();
        }
        return this;
    }

    public Element x() {
        if (isEmpty()) {
            return null;
        }
        return (Element) get(0);
    }

    public Elements y0(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).b0(str);
        }
        return this;
    }

    public List<FormElement> z() {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (element instanceof FormElement) {
                arrayList.add((FormElement) element);
            }
        }
        return arrayList;
    }

    public Elements z0(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).Z2(str);
        }
        return this;
    }

    public Elements(int i2) {
        super(i2);
    }

    public Elements(Collection<Element> collection) {
        super(collection);
    }

    public Elements(List<Element> list) {
        super(list);
    }

    public Elements(Element... elementArr) {
        super(Arrays.asList(elementArr));
    }
}
