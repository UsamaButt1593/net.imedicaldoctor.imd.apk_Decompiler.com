package org.jsoup.examples;

import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public class HtmlToPlainText {

    /* renamed from: a  reason: collision with root package name */
    private static final String f31556a = "Mozilla/5.0 (jsoup)";

    /* renamed from: b  reason: collision with root package name */
    private static final int f31557b = 5000;

    private class FormattingVisitor implements NodeVisitor {

        /* renamed from: d  reason: collision with root package name */
        private static final int f31558d = 80;

        /* renamed from: a  reason: collision with root package name */
        private int f31559a;

        /* renamed from: b  reason: collision with root package name */
        private StringBuilder f31560b;

        private FormattingVisitor() {
            this.f31559a = 0;
            this.f31560b = new StringBuilder();
        }

        private void c(String str) {
            if (str.startsWith(StringUtils.LF)) {
                this.f31559a = 0;
            }
            if (str.equals(StringUtils.SPACE)) {
                if (this.f31560b.length() != 0) {
                    StringBuilder sb = this.f31560b;
                    if (StringUtil.b(sb.substring(sb.length() - 1), StringUtils.SPACE, StringUtils.LF)) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (str.length() + this.f31559a > 80) {
                String[] split = str.split("\\s+");
                for (int i2 = 0; i2 < split.length; i2++) {
                    String str2 = split[i2];
                    if (i2 != split.length - 1) {
                        str2 = str2 + StringUtils.SPACE;
                    }
                    if (str2.length() + this.f31559a > 80) {
                        StringBuilder sb2 = this.f31560b;
                        sb2.append(StringUtils.LF);
                        sb2.append(str2);
                        this.f31559a = str2.length();
                    } else {
                        this.f31560b.append(str2);
                        this.f31559a += str2.length();
                    }
                }
                return;
            }
            this.f31560b.append(str);
            this.f31559a += str.length();
        }

        public void a(Node node, int i2) {
            String str;
            String F = node.F();
            if (node instanceof TextNode) {
                str = ((TextNode) node).G0();
            } else if (F.equals("li")) {
                str = "\n * ";
            } else if (F.equals(HTML.Tag.u)) {
                str = "  ";
            } else if (StringUtil.b(F, "p", "h1", "h2", "h3", "h4", "h5", "tr")) {
                str = StringUtils.LF;
            } else {
                return;
            }
            c(str);
        }

        public void b(Node node, int i2) {
            String format;
            String F = node.F();
            if (StringUtil.b(F, "br", HTML.Tag.t, HTML.Tag.u, "p", "h1", "h2", "h3", "h4", "h5")) {
                format = StringUtils.LF;
            } else if (F.equals("a")) {
                format = String.format(" <%s>", new Object[]{node.a("href")});
            } else {
                return;
            }
            c(format);
        }

        public String toString() {
            return this.f31560b.toString();
        }
    }

    public static void b(String... strArr) throws IOException {
        Validate.e(strArr.length == 1 || strArr.length == 2, "usage: java -cp jsoup.jar org.jsoup.examples.HtmlToPlainText url [selector]");
        String str = strArr[0];
        String str2 = strArr.length == 2 ? strArr[1] : null;
        Document document = Jsoup.d(str).i(f31556a).g(5000).get();
        HtmlToPlainText htmlToPlainText = new HtmlToPlainText();
        if (str2 != null) {
            Iterator it2 = document.a3(str2).iterator();
            while (it2.hasNext()) {
                System.out.println(htmlToPlainText.a((Element) it2.next()));
            }
            return;
        }
        System.out.println(htmlToPlainText.a(document));
    }

    public String a(Element element) {
        FormattingVisitor formattingVisitor = new FormattingVisitor();
        new NodeTraversor(formattingVisitor).a(element);
        return formattingVisitor.toString();
    }
}
