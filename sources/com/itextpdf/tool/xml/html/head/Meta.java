package com.itextpdf.tool.xml.html.head;

import com.google.common.net.HttpHeaders;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.Element;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Meta extends AbstractTagProcessor {
    private static final Logger X2 = LoggerFactory.b(Meta.class);

    public List<Element> r(WorkerContext workerContext, Tag tag) {
        String str;
        if (!(tag.d().get("http-equiv") == null || !HttpHeaders.f22875c.equalsIgnoreCase(tag.d().get("http-equiv")) || (str = tag.d().get(Annotation.i3)) == null)) {
            for (String str2 : str.split(";")) {
                if (str2.contains("charset")) {
                    String[] split = str2.split("=");
                    if (split.length > 1) {
                        String str3 = split[1];
                        try {
                            if (Charset.isSupported(str3)) {
                                m(workerContext).l(Charset.forName(str3));
                                Logger logger = X2;
                                if (logger.b(Level.DEBUG)) {
                                    logger.a(String.format(LocaleMessages.a().b(LocaleMessages.y), new Object[]{str3}));
                                }
                            } else {
                                Logger logger2 = X2;
                                if (logger2.b(Level.DEBUG)) {
                                    logger2.a(String.format(LocaleMessages.a().b(LocaleMessages.z), new Object[]{m(workerContext).m()}));
                                }
                            }
                        } catch (NoCustomContextException e2) {
                            X2.i("", e2);
                        }
                    }
                }
            }
        }
        return new ArrayList(0);
    }
}
