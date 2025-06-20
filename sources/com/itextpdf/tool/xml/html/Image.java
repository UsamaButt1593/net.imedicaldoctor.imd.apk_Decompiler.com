package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.net.ImageRetrieve;
import com.itextpdf.tool.xml.net.exc.NoImageException;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Image extends AbstractTagProcessor {
    private static final Logger Y2 = LoggerFactory.b(Image.class);
    private final CssUtils X2 = CssUtils.g();

    public boolean a() {
        return false;
    }

    public List<Element> k(WorkerContext workerContext, Tag tag, List<Element> list) {
        com.itextpdf.text.Image image;
        Map<String, String> d2 = tag.d();
        String str = d2.get("src");
        ArrayList arrayList = new ArrayList(1);
        if (str != null && str.length() > 0) {
            String trim = XMLUtil.g(str).trim();
            try {
                Logger logger = Y2;
                if (logger.b(Level.TRACE)) {
                    logger.h(String.format(LocaleMessages.a().b(LocaleMessages.o), new Object[]{trim}));
                }
                HtmlPipelineContext m2 = m(workerContext);
                image = new ImageRetrieve(m2.s(), m2.p()).b(trim);
            } catch (NoImageException e2) {
                Logger logger2 = Y2;
                if (logger2.b(Level.ERROR)) {
                    logger2.i(String.format(LocaleMessages.a().b(LocaleMessages.p), new Object[]{trim}), e2);
                }
                image = null;
            } catch (NoCustomContextException e3) {
                throw new RuntimeWorkerException(LocaleMessages.a().b(LocaleMessages.f27573d), e3);
            }
            if (image != null) {
                try {
                    if (d2.get(HTML.Attribute.f27590a) != null) {
                        image.U(PdfName.J3, new PdfString(d2.get(HTML.Attribute.f27590a)));
                    }
                    HtmlPipelineContext m3 = m(workerContext);
                    arrayList.add(b().b(new Chunk((com.itextpdf.text.Image) b().b(image, tag, m3), 0.0f, 0.0f, true), tag, m3));
                } catch (NoCustomContextException e4) {
                    throw new RuntimeWorkerException((Throwable) e4);
                }
            }
        }
        return arrayList;
    }
}
