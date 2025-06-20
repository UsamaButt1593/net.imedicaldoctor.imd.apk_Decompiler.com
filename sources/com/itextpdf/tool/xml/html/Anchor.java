package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.WritableDirectElement;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Anchor extends AbstractTagProcessor {
    private static final Logger X2 = LoggerFactory.b(Anchor.class);

    public boolean a() {
        return true;
    }

    public List<Element> f(WorkerContext workerContext, Tag tag, String str) {
        return s(workerContext, tag, str);
    }

    public List<Element> k(WorkerContext workerContext, Tag tag, List<Element> list) {
        Object r13;
        try {
            final String str = tag.d().get("name");
            ArrayList arrayList = new ArrayList(0);
            if (list.size() > 0) {
                NoNewLineParagraph noNewLineParagraph = new NoNewLineParagraph();
                String str2 = tag.d().get("href");
                for (Element next : list) {
                    if (next instanceof Chunk) {
                        if (str2 != null) {
                            if (str2.startsWith("#")) {
                                Logger logger = X2;
                                if (logger.b(Level.TRACE)) {
                                    logger.h(String.format(LocaleMessages.a().b(LocaleMessages.s), new Object[]{str2}));
                                }
                                ((Chunk) next).W(str2.replaceFirst("#", ""));
                            } else {
                                if (m(workerContext).q() != null && !str2.startsWith("http")) {
                                    String a2 = m(workerContext).q().a();
                                    if (a2.endsWith("/") && str2.startsWith("/")) {
                                        a2 = a2.substring(0, a2.length() - 1);
                                    }
                                    str2 = a2 + str2;
                                }
                                Logger logger2 = X2;
                                if (logger2.b(Level.TRACE)) {
                                    logger2.h(String.format(LocaleMessages.a().b(LocaleMessages.t), new Object[]{str2}));
                                }
                                ((Chunk) next).F(str2);
                            }
                        } else if (str != null) {
                            ((Chunk) next).T(str);
                            Logger logger3 = X2;
                            if (logger3.b(Level.TRACE)) {
                                logger3.h(String.format(LocaleMessages.a().b(LocaleMessages.u), new Object[]{str}));
                            }
                        }
                    }
                    noNewLineParagraph.add(next);
                }
                r13 = b().b(noNewLineParagraph, tag, m(workerContext));
            } else {
                if (str != null) {
                    Logger logger4 = X2;
                    if (logger4.b(Level.TRACE)) {
                        logger4.h(String.format(LocaleMessages.a().b(LocaleMessages.v), new Object[]{str}));
                    }
                    r13 = new WritableDirectElement() {
                        public void a(PdfWriter pdfWriter, Document document) throws DocumentException {
                            ColumnText columnText = new ColumnText(pdfWriter.g1());
                            float O1 = pdfWriter.O1(false);
                            columnText.n0(new Phrase(new Chunk(StringUtils.SPACE).T(str)), 1.0f, O1 - 5.0f, 6.0f, O1, 5.0f, 0);
                            try {
                                columnText.I();
                            } catch (DocumentException e2) {
                                throw new RuntimeWorkerException((Throwable) e2);
                            }
                        }
                    };
                }
                return arrayList;
            }
            arrayList.add(r13);
            return arrayList;
        } catch (NoCustomContextException e2) {
            throw new RuntimeWorkerException(LocaleMessages.a().b(LocaleMessages.f27573d), e2);
        }
    }
}
