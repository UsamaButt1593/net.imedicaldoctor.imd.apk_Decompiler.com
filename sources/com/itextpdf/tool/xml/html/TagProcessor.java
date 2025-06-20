package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import java.util.List;

public interface TagProcessor {
    boolean a();

    List<Element> c(WorkerContext workerContext, Tag tag);

    List<Element> e(WorkerContext workerContext, Tag tag, List<Element> list);

    List<Element> f(WorkerContext workerContext, Tag tag, String str);
}
