package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import java.util.ArrayList;
import java.util.List;

public class DummyTagProcessor implements TagProcessor {
    public boolean a() {
        return false;
    }

    public List<Element> c(WorkerContext workerContext, Tag tag) {
        return new ArrayList(0);
    }

    public List<Element> e(WorkerContext workerContext, Tag tag, List<Element> list) {
        return new ArrayList(0);
    }

    public List<Element> f(WorkerContext workerContext, Tag tag, String str) {
        return new ArrayList(0);
    }
}
