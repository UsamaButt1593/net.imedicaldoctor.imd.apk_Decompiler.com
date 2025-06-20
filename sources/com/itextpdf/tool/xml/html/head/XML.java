package com.itextpdf.tool.xml.html.head;

import com.itextpdf.text.Element;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class XML extends AbstractTagProcessor {
    private static final Logger X2 = LoggerFactory.b(XML.class);

    public List<Element> r(WorkerContext workerContext, Tag tag) {
        String str = tag.d().get("encoding");
        if (str != null) {
            try {
                if (Charset.isSupported(str)) {
                    m(workerContext).l(Charset.forName(str));
                    Logger logger = X2;
                    if (logger.b(Level.DEBUG)) {
                        logger.a(String.format(LocaleMessages.a().b(LocaleMessages.y), new Object[]{str}));
                    }
                } else {
                    Logger logger2 = X2;
                    if (logger2.b(Level.DEBUG)) {
                        logger2.a(String.format(LocaleMessages.a().b(LocaleMessages.z), new Object[]{m(workerContext).m()}));
                    }
                }
            } catch (NoCustomContextException unused) {
                throw new RuntimeWorkerException(LocaleMessages.a().b(LocaleMessages.f27573d));
            }
        }
        return new ArrayList(0);
    }
}
