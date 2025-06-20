package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.pdf.PdfBody;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import com.itextpdf.tool.xml.pipeline.ctx.MapContext;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Body extends AbstractTagProcessor {
    public List<Element> f(WorkerContext workerContext, Tag tag, String str) {
        List<Chunk> a2 = HTMLUtils.a(str, false);
        ArrayList arrayList = new ArrayList(1);
        NoNewLineParagraph noNewLineParagraph = new NoNewLineParagraph();
        for (Chunk b2 : a2) {
            noNewLineParagraph.add(b().c().b(b2, tag));
        }
        if (noNewLineParagraph.size() > 0) {
            try {
                arrayList.add(b().b(noNewLineParagraph, tag, m(workerContext)));
            } catch (NoCustomContextException e2) {
                throw new RuntimeWorkerException(LocaleMessages.a().b(LocaleMessages.f27573d), e2);
            }
        }
        return arrayList;
    }

    public List<Element> r(WorkerContext workerContext, Tag tag) {
        MapContext mapContext;
        ArrayList arrayList = new ArrayList(1);
        try {
            Map<String, String> g2 = tag.g();
            if (g2.containsKey(CSS.Property.f27463f) && (mapContext = (MapContext) workerContext.i(PdfWriterPipeline.class.getName())) != null) {
                Document document = (Document) mapContext.a(PdfWriterPipeline.f27720f);
                Rectangle rectangle = new Rectangle(document.G(), document.v(), document.K(), document.R(), document.C().S());
                rectangle.h0(HtmlUtilities.b(g2.get(CSS.Property.f27463f)));
                arrayList.add(new PdfBody(rectangle));
            }
        } catch (NoCustomContextException unused) {
        }
        return arrayList;
    }
}
