package com.itextpdf.tool.xml.html;

import com.itextpdf.tool.xml.html.HTML;

public class Tags {

    /* renamed from: a  reason: collision with root package name */
    private static String f27630a = "com.itextpdf.tool.xml.html.";

    /* renamed from: b  reason: collision with root package name */
    private static String f27631b = (f27630a + "DummyTagProcessor");

    /* renamed from: c  reason: collision with root package name */
    private static String f27632c = (f27630a + "Header");

    /* renamed from: d  reason: collision with root package name */
    private static String f27633d = (f27630a + "Span");

    /* renamed from: e  reason: collision with root package name */
    private static String f27634e = (f27630a + "NonSanitizedTag");

    /* renamed from: f  reason: collision with root package name */
    private static String f27635f = (f27630a + "ParaGraph");

    public static final TagProcessorFactory a() {
        DefaultTagProcessorFactory defaultTagProcessorFactory = new DefaultTagProcessorFactory();
        defaultTagProcessorFactory.e(HTML.Tag.f27613a, f27631b);
        defaultTagProcessorFactory.e("!doctype", f27631b);
        defaultTagProcessorFactory.e(HTML.Tag.y, f27631b);
        defaultTagProcessorFactory.e("head", f27631b);
        defaultTagProcessorFactory.e(HTML.Tag.D, f27631b);
        defaultTagProcessorFactory.e(HTML.Tag.G0, f27631b);
        defaultTagProcessorFactory.e("title", f27630a + "head.Title");
        defaultTagProcessorFactory.e(HTML.Tag.C, f27630a + "head.Link");
        defaultTagProcessorFactory.e("style", f27630a + "head.Style");
        defaultTagProcessorFactory.e("body", f27630a + "Body");
        defaultTagProcessorFactory.e("div", f27630a + "Div");
        defaultTagProcessorFactory.e("a", f27630a + "Anchor");
        defaultTagProcessorFactory.e("table", f27630a + "table.Table");
        defaultTagProcessorFactory.e("tr", f27630a + "table.TableRow");
        defaultTagProcessorFactory.e("td", f27630a + "table.TableData");
        defaultTagProcessorFactory.e("th", f27630a + "table.TableData");
        defaultTagProcessorFactory.e(HTML.Tag.f27619g, f27635f);
        defaultTagProcessorFactory.e("p", f27635f);
        defaultTagProcessorFactory.e(HTML.Tag.u, f27635f);
        defaultTagProcessorFactory.e(HTML.Tag.t, f27635f);
        defaultTagProcessorFactory.e("blockquote", f27635f);
        defaultTagProcessorFactory.e("br", f27630a + "Break");
        defaultTagProcessorFactory.e("span", f27633d);
        defaultTagProcessorFactory.e("small", f27633d);
        defaultTagProcessorFactory.e(HTML.Tag.T0, f27633d);
        defaultTagProcessorFactory.e("s", f27633d);
        defaultTagProcessorFactory.e("strike", f27633d);
        defaultTagProcessorFactory.e(HTML.Tag.h0, f27633d);
        defaultTagProcessorFactory.e("sub", f27633d);
        defaultTagProcessorFactory.e("sup", f27633d);
        defaultTagProcessorFactory.e("b", f27633d);
        defaultTagProcessorFactory.e("strong", f27633d);
        defaultTagProcessorFactory.e("font", f27633d);
        defaultTagProcessorFactory.e("i", f27633d);
        defaultTagProcessorFactory.e(HTML.Tag.l0, f27633d);
        defaultTagProcessorFactory.e("em", f27633d);
        defaultTagProcessorFactory.e(HTML.Tag.F, f27633d);
        defaultTagProcessorFactory.e(HTML.Tag.j0, f27633d);
        defaultTagProcessorFactory.e(HTML.Tag.R0, f27633d);
        defaultTagProcessorFactory.e("pre", f27634e);
        defaultTagProcessorFactory.e("tt", f27634e);
        defaultTagProcessorFactory.e(HTML.Tag.g0, f27634e);
        defaultTagProcessorFactory.e(HTML.Tag.y0, f27634e);
        defaultTagProcessorFactory.e(HTML.Tag.D0, f27634e);
        defaultTagProcessorFactory.e("u", f27633d);
        defaultTagProcessorFactory.e(HTML.Tag.s0, f27633d);
        defaultTagProcessorFactory.e("img", f27630a + "Image");
        defaultTagProcessorFactory.e("ul", f27630a + "OrderedUnorderedList");
        defaultTagProcessorFactory.e("ol", f27630a + "OrderedUnorderedList");
        defaultTagProcessorFactory.e("li", f27630a + "OrderedUnorderedListItem");
        defaultTagProcessorFactory.e("h1", f27632c);
        defaultTagProcessorFactory.e("h2", f27632c);
        defaultTagProcessorFactory.e("h3", f27632c);
        defaultTagProcessorFactory.e("h4", f27632c);
        defaultTagProcessorFactory.e("h5", f27632c);
        defaultTagProcessorFactory.e("h6", f27632c);
        defaultTagProcessorFactory.e("hr", f27630a + "HorizontalRule");
        defaultTagProcessorFactory.e("label", f27633d);
        return defaultTagProcessorFactory;
    }
}
