package com.itextpdf.tool.xml.html.head;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.WritableDirectElement;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import java.util.ArrayList;
import java.util.List;

public class Title extends AbstractTagProcessor {
    public List<Element> f(WorkerContext workerContext, Tag tag, final String str) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new WritableDirectElement() {
            public void a(PdfWriter pdfWriter, Document document) throws DocumentException {
                document.u(str);
            }
        });
        return arrayList;
    }
}
