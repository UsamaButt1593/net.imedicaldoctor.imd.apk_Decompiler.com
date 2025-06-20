package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import java.util.ArrayList;
import java.util.List;

public class NonSanitizedTag extends AbstractTagProcessor {
    public List<Element> f(WorkerContext workerContext, Tag tag, String str) {
        ArrayList arrayList = new ArrayList(1);
        if (str != null && str.length() > 0) {
            try {
                arrayList.add(b().b(new Chunk(str), tag, m(workerContext)));
            } catch (NoCustomContextException e2) {
                throw new RuntimeWorkerException((Throwable) e2);
            }
        }
        return arrayList;
    }

    public List<Element> k(WorkerContext workerContext, Tag tag, List<Element> list) {
        return i(list, false, true, tag, workerContext);
    }
}
