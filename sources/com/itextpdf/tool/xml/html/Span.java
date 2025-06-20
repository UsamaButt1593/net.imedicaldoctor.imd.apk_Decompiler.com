package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import java.util.List;

public class Span extends AbstractTagProcessor {
    public boolean a() {
        return true;
    }

    public List<Element> f(WorkerContext workerContext, Tag tag, String str) {
        return s(workerContext, tag, str);
    }

    public List<Element> k(WorkerContext workerContext, Tag tag, List<Element> list) {
        return i(list, false, true, tag, workerContext);
    }
}
