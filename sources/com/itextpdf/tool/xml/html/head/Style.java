package com.itextpdf.tool.xml.html.head;

import com.itextpdf.text.Element;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import java.util.ArrayList;
import java.util.List;

public class Style extends AbstractTagProcessor {
    private static final Logger X2 = LoggerFactory.b(Style.class);

    public List<Element> f(WorkerContext workerContext, Tag tag, String str) {
        try {
            l(workerContext).e(str, false);
        } catch (CssResolverException e2) {
            Logger logger = X2;
            logger.i(LocaleMessages.a().b(LocaleMessages.A), e2);
            if (logger.b(Level.TRACE)) {
                logger.h(str);
            }
        } catch (NoCustomContextException unused) {
            X2.g(String.format(LocaleMessages.a().b(LocaleMessages.f27574e), new Object[]{CssResolverPipeline.class.getName()}));
        }
        return new ArrayList(0);
    }
}
