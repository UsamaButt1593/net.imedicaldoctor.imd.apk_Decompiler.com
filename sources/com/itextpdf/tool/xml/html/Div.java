package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.ArrayList;
import java.util.List;

public class Div extends AbstractTagProcessor {
    private void u(PdfDiv pdfDiv) {
        int I = pdfDiv.I();
        if (I != -1 && I != 8 && I != 1) {
            if (I == 2) {
                pdfDiv.q0(0);
            } else if (I != 3) {
                pdfDiv.q0(2);
            }
        }
    }

    public boolean a() {
        return true;
    }

    public List<Element> f(WorkerContext workerContext, Tag tag, String str) {
        List<Chunk> a2 = HTMLUtils.a(str, false);
        NoNewLineParagraph noNewLineParagraph = new NoNewLineParagraph();
        ArrayList arrayList = new ArrayList(1);
        try {
            HtmlPipelineContext m2 = m(workerContext);
            for (Chunk b2 : a2) {
                noNewLineParagraph.add(b().b(b2, tag, m2));
            }
            if (noNewLineParagraph.size() > 0) {
                arrayList.add(b().b(noNewLineParagraph, tag, m2));
            }
            return arrayList;
        } catch (NoCustomContextException e2) {
            throw new RuntimeWorkerException((Throwable) e2);
        }
    }

    public List<Element> k(WorkerContext workerContext, Tag tag, List<Element> list) {
        try {
            PdfDiv pdfDiv = (PdfDiv) b().b(new PdfDiv(), tag, m(workerContext));
            int o = o(tag);
            if (o != 1) {
                pdfDiv.p0(o);
            }
            Paragraph paragraph = null;
            for (Element next : list) {
                if (!(next instanceof Paragraph) && !(next instanceof PdfPTable)) {
                    if (!(next instanceof PdfDiv)) {
                        if (paragraph == null) {
                            paragraph = new Paragraph();
                            paragraph.O1(pdfDiv.I());
                            if (o == 3) {
                                p(paragraph);
                            }
                            paragraph.g1(1.2f);
                        }
                        paragraph.add(next);
                    }
                }
                if (paragraph != null) {
                    if (paragraph.t1()) {
                        pdfDiv.a(paragraph);
                    }
                    paragraph = null;
                }
                pdfDiv.a(next);
            }
            if (paragraph != null && paragraph.t1()) {
                pdfDiv.a(paragraph);
            }
            if (o == 3) {
                u(pdfDiv);
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(pdfDiv);
            return arrayList;
        } catch (NoCustomContextException e2) {
            throw new RuntimeWorkerException(LocaleMessages.a().b(LocaleMessages.f27573d), e2);
        }
    }
}
