package com.itextpdf.tool.xml.html.head;

import com.itextpdf.text.Element;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import java.util.ArrayList;
import java.util.List;

public class Link extends AbstractTagProcessor {
    private static final Logger X2 = LoggerFactory.b(Link.class);

    public List<Element> r(WorkerContext workerContext, Tag tag) {
        String str;
        if (HTML.Attribute.Value.f27604a.equalsIgnoreCase(tag.d().get("type")) && (str = tag.d().get("href")) != null) {
            try {
                l(workerContext).d(str, false);
            } catch (CssResolverException e2) {
                X2.i(String.format(LocaleMessages.a().b(LocaleMessages.x), new Object[]{str}), e2);
            } catch (NoCustomContextException unused) {
                X2.g(String.format(LocaleMessages.a().b(LocaleMessages.f27574e), new Object[]{CssResolverPipeline.class.getName()}));
            }
        }
        return new ArrayList(0);
    }
}
