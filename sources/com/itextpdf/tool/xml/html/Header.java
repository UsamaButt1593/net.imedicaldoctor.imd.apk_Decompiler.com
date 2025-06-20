package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.WritableDirectElement;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfDestination;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfOutline;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.itextpdf.tool.xml.util.ParentTreeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Header extends AbstractTagProcessor {
    /* access modifiers changed from: private */
    public static final Logger X2 = LoggerFactory.b(Header.class);

    private PdfName w(int i2) {
        switch (i2) {
            case 1:
                return PdfName.X8;
            case 2:
                return PdfName.Y8;
            case 3:
                return PdfName.Z8;
            case 4:
                return PdfName.a9;
            case 5:
                return PdfName.b9;
            case 6:
                return PdfName.c9;
            default:
                return PdfName.W8;
        }
    }

    /* access modifiers changed from: private */
    public int x(Tag tag) {
        return Integer.parseInt(Character.toString(tag.o().charAt(1)));
    }

    public boolean a() {
        return true;
    }

    public List<Element> f(WorkerContext workerContext, Tag tag, String str) {
        return s(workerContext, tag, str);
    }

    public List<Element> k(WorkerContext workerContext, Tag tag, List<Element> list) {
        ArrayList arrayList = new ArrayList(1);
        ParentTreeUtil parentTreeUtil = new ParentTreeUtil();
        if (list.size() > 0) {
            List<Element> i2 = i(list, true, true, tag, workerContext);
            Iterator<Element> it2 = i2.iterator();
            while (it2.hasNext()) {
                ((Paragraph) it2.next()).o(w(x(tag)));
            }
            try {
                HtmlPipelineContext m2 = m(workerContext);
                boolean i3 = m2.i();
                if (!parentTreeUtil.b(tag).isEmpty() && parentTreeUtil.b(tag).contains("td")) {
                    m2.h(false);
                }
                if (m2.i()) {
                    final Paragraph paragraph = new Paragraph();
                    for (Element b2 : i2) {
                        paragraph.add(b2);
                    }
                    final HtmlPipelineContext htmlPipelineContext = m2;
                    final Tag tag2 = tag;
                    arrayList.add(new WritableDirectElement(1) {
                        public void a(PdfWriter pdfWriter, Document document) throws DocumentException {
                            PdfDestination pdfDestination = new PdfDestination(0, 20.0f, pdfWriter.O1(false), 0.0f);
                            Map<String, Object> r = htmlPipelineContext.r();
                            HeaderNode headerNode = (HeaderNode) r.get(HtmlPipelineContext.g3);
                            int u = Header.this.x(tag2);
                            if (headerNode == null) {
                                headerNode = new HeaderNode(0, pdfWriter.I1(), (HeaderNode) null);
                            } else {
                                int a2 = headerNode.a();
                                if (a2 == u) {
                                    headerNode = headerNode.c();
                                } else if (a2 > u) {
                                    while (a2 >= u) {
                                        a2 = headerNode.c().a();
                                        headerNode = headerNode.c();
                                    }
                                }
                            }
                            if (Header.X2.b(Level.TRACE)) {
                                Header.X2.h(String.format(LocaleMessages.a().b(LocaleMessages.q), new Object[]{paragraph.toString()}));
                            }
                            r.put(HtmlPipelineContext.g3, new HeaderNode(u, new PdfOutline(headerNode.b(), pdfDestination, paragraph), headerNode));
                        }
                    });
                }
                m2.h(i3);
            } catch (NoCustomContextException e2) {
                Logger logger = X2;
                if (logger.b(Level.ERROR)) {
                    logger.i(LocaleMessages.a().b(LocaleMessages.r), e2);
                }
            }
            arrayList.addAll(i2);
        }
        return arrayList;
    }
}
