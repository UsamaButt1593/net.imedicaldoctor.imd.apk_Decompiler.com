package org.jsoup.nodes;

import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class FormElement extends Element {
    private final Elements c3 = new Elements();

    public FormElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
    }

    public FormElement m3(Element element) {
        this.c3.add(element);
        return this;
    }

    public Elements n3() {
        return this.c3;
    }

    public List<Connection.KeyVal> o3() {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator it2 = this.c3.iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (element.c3().h() && !element.z("disabled")) {
                String g2 = element.g("name");
                if (g2.length() != 0) {
                    String g3 = element.g("type");
                    if (HTML.Tag.L0.equals(element.d3())) {
                        Iterator it3 = element.a3("option[selected]").iterator();
                        boolean z = false;
                        while (it3.hasNext()) {
                            arrayList.add(HttpConnection.KeyVal.f(g2, ((Element) it3.next()).j3()));
                            z = true;
                        }
                        if (!z) {
                            element = element.a3("option").x();
                            if (element == null) {
                            }
                        }
                    } else if ("checkbox".equalsIgnoreCase(g3) || "radio".equalsIgnoreCase(g3)) {
                        if (element.z("checked")) {
                            if (element.j3().length() <= 0) {
                                str = DebugKt.f29173d;
                                arrayList.add(HttpConnection.KeyVal.f(g2, str));
                            }
                        }
                    }
                    str = element.j3();
                    arrayList.add(HttpConnection.KeyVal.f(g2, str));
                }
            }
        }
        return arrayList;
    }

    public Connection p3() {
        String a2 = z("action") ? a("action") : l();
        Validate.i(a2, "Could not determine a form action URL for submit. Ensure you set a base URI when parsing.");
        return Jsoup.d(a2).j(o3()).c(g(XMLWriter.A).toUpperCase().equals("POST") ? Connection.Method.POST : Connection.Method.GET);
    }
}
