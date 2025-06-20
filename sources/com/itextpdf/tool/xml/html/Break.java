package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import java.util.ArrayList;
import java.util.List;

public class Break extends AbstractTagProcessor {
    public List<Element> k(WorkerContext workerContext, Tag tag, List<Element> list) {
        ArrayList arrayList = new ArrayList(1);
        try {
            arrayList.add((Chunk) b().b(new Chunk(Chunk.b3), tag, m(workerContext)));
            return arrayList;
        } catch (NoCustomContextException e2) {
            throw new RuntimeWorkerException(LocaleMessages.a().b(LocaleMessages.f27573d), e2);
        }
    }
}
