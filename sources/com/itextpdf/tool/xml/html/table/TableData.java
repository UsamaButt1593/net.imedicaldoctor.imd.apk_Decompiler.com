package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import com.itextpdf.tool.xml.html.pdfelement.HtmlCell;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import java.util.ArrayList;
import java.util.List;

public class TableData extends AbstractTagProcessor {
    public boolean a() {
        return true;
    }

    public List<Element> f(WorkerContext workerContext, Tag tag, String str) {
        return s(workerContext, tag, str);
    }

    public List<Element> k(WorkerContext workerContext, Tag tag, List<Element> list) {
        WorkerContext workerContext2 = workerContext;
        Tag tag2 = tag;
        HtmlCell htmlCell = new HtmlCell();
        int o = o(tag2);
        int i2 = 1;
        if (o != 1) {
            htmlCell.O1(o);
        }
        if ("th".equalsIgnoreCase(tag.o())) {
            htmlCell.o(PdfName.Xf);
        }
        try {
            HtmlCell htmlCell2 = (HtmlCell) b().b(htmlCell, tag2, m(workerContext));
            ArrayList arrayList = new ArrayList(1);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i3 = -1;
            int i4 = -1;
            for (Element next : list) {
                int i5 = i4 + 1;
                boolean z = next instanceof Chunk;
                if (z || (next instanceof NoNewLineParagraph) || (next instanceof LineSeparator)) {
                    if (!arrayList3.isEmpty()) {
                        v(workerContext2, tag2, arrayList3, htmlCell2);
                    }
                    if (!z || !Chunk.b3.j().equals(((Chunk) next).j())) {
                        List<Element> list2 = list;
                        if (next instanceof LineSeparator) {
                            try {
                                arrayList2.add((Chunk) b().b(new Chunk(Chunk.b3), tag2, m(workerContext)));
                            } catch (NoCustomContextException e2) {
                                throw new RuntimeWorkerException(LocaleMessages.a().b(LocaleMessages.f27573d), e2);
                            }
                        }
                    } else if (i5 != list.size() - i2) {
                        Element element = list.get(i4 + 2);
                        if (!arrayList2.isEmpty() && !(element instanceof Chunk) && !(element instanceof NoNewLineParagraph)) {
                            i4 = i5;
                            i2 = 1;
                            i3 = -1;
                        }
                    }
                    arrayList2.add(next);
                    i4 = i5;
                    i2 = 1;
                    i3 = -1;
                } else if (next instanceof ListItem) {
                    if (!arrayList2.isEmpty()) {
                        u(arrayList2, htmlCell2);
                    }
                    arrayList3.add((ListItem) next);
                } else {
                    if (!arrayList2.isEmpty()) {
                        u(arrayList2, htmlCell2);
                    }
                    if (!arrayList3.isEmpty()) {
                        v(workerContext2, tag2, arrayList3, htmlCell2);
                    }
                    if (next instanceof Paragraph) {
                        Paragraph paragraph = (Paragraph) next;
                        if (paragraph.y1() == i3) {
                            paragraph.O1(htmlCell2.U0());
                        }
                    }
                    htmlCell2.D0(next);
                }
                List<Element> list3 = list;
                i4 = i5;
                i2 = 1;
                i3 = -1;
            }
            if (!arrayList2.isEmpty()) {
                u(arrayList2, htmlCell2);
            }
            arrayList.add(htmlCell2);
            return arrayList;
        } catch (NoCustomContextException e3) {
            throw new RuntimeWorkerException(LocaleMessages.a().b(LocaleMessages.f27573d), e3);
        }
    }

    /* access modifiers changed from: protected */
    public void u(List<Element> list, HtmlCell htmlCell) {
        Paragraph paragraph = new Paragraph();
        paragraph.g1(1.2f);
        paragraph.addAll(list);
        paragraph.O1(htmlCell.U0());
        if (paragraph.t1()) {
            htmlCell.D0(paragraph);
        }
        list.clear();
    }

    /* access modifiers changed from: protected */
    public void v(WorkerContext workerContext, Tag tag, List<ListItem> list, HtmlCell htmlCell) {
        try {
            com.itextpdf.text.List list2 = new com.itextpdf.text.List();
            list2.H(false);
            com.itextpdf.text.List list3 = (com.itextpdf.text.List) b().b(list2, tag, m(workerContext));
            list3.g(0.0f);
            for (ListItem b2 : list) {
                ListItem listItem = (ListItem) b().b(b2, tag, m(workerContext));
                listItem.c(0.0f);
                listItem.h(0.0f);
                listItem.g1(1.2f);
                list3.b(listItem);
            }
            htmlCell.D0(list3);
            list.clear();
        } catch (NoCustomContextException e2) {
            throw new RuntimeWorkerException(LocaleMessages.a().b(LocaleMessages.f27573d), e2);
        }
    }
}
