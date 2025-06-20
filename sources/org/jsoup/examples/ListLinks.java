package org.jsoup.examples;

import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListLinks {
    public static void a(String[] strArr) throws IOException {
        Validate.e(strArr.length == 1, "usage: supply url to fetch");
        String str = strArr[0];
        b("Fetching %s...", str);
        Document document = Jsoup.d(str).get();
        Elements a3 = document.a3("a[href]");
        Elements a32 = document.a3("[src]");
        Elements a33 = document.a3("link[href]");
        b("\nMedia: (%d)", Integer.valueOf(a32.size()));
        Iterator it2 = a32.iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (element.d3().equals("img")) {
                b(" * %s: <%s> %sx%s (%s)", element.d3(), element.g("abs:src"), element.g("width"), element.g("height"), c(element.g(HTML.Attribute.f27590a), 20));
            } else {
                b(" * %s: <%s>", element.d3(), element.g("abs:src"));
            }
        }
        b("\nImports: (%d)", Integer.valueOf(a33.size()));
        Iterator it3 = a33.iterator();
        while (it3.hasNext()) {
            Element element2 = (Element) it3.next();
            b(" * %s <%s> (%s)", element2.d3(), element2.g("abs:href"), element2.g("rel"));
        }
        b("\nLinks: (%d)", Integer.valueOf(a3.size()));
        Iterator it4 = a3.iterator();
        while (it4.hasNext()) {
            Element element3 = (Element) it4.next();
            b(" * a: <%s>  (%s)", element3.g("abs:href"), c(element3.f3(), 35));
        }
    }

    private static void b(String str, Object... objArr) {
        System.out.println(String.format(str, objArr));
    }

    private static String c(String str, int i2) {
        if (str.length() <= i2) {
            return str;
        }
        return str.substring(0, i2 - 1) + ".";
    }
}
