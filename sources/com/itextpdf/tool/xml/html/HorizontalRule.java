package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HorizontalRule extends AbstractTagProcessor {
    public List<Element> r(WorkerContext workerContext, Tag tag) {
        try {
            ArrayList arrayList = new ArrayList();
            LineSeparator lineSeparator = (LineSeparator) b().b(new LineSeparator(), tag, m(workerContext));
            Paragraph paragraph = new Paragraph();
            Map<String, String> g2 = tag.g();
            float p = g2.get("font-size") != null ? CssUtils.g().p(g2.get("font-size")) : 12.0f;
            String str = g2.get(CSS.Property.o);
            String str2 = "0.5em";
            if (str == null) {
                str = str2;
            }
            String str3 = g2.get(CSS.Property.p);
            if (str3 != null) {
                str2 = str3;
            }
            paragraph.h(paragraph.E() + CssUtils.g().s(str, p));
            paragraph.c(paragraph.K() + CssUtils.g().s(str2, p));
            paragraph.W0(0.0f);
            paragraph.add(lineSeparator);
            arrayList.add(paragraph);
            return arrayList;
        } catch (NoCustomContextException e2) {
            throw new RuntimeWorkerException(LocaleMessages.a().b(LocaleMessages.f27573d), e2);
        }
    }
}
