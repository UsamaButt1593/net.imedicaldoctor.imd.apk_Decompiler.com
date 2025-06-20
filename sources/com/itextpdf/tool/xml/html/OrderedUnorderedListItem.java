package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ListItem;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import java.util.ArrayList;
import java.util.List;

public class OrderedUnorderedListItem extends AbstractTagProcessor {
    public boolean a() {
        return true;
    }

    public List<Element> f(WorkerContext workerContext, Tag tag, String str) {
        return s(workerContext, tag, str);
    }

    public List<Element> k(WorkerContext workerContext, Tag tag, List<Element> list) {
        ArrayList arrayList = new ArrayList(1);
        ListItem listItem = new ListItem();
        float f2 = -1.0f;
        for (Element next : list) {
            listItem.add(next);
            for (Chunk k2 : next.Y()) {
                float f3 = k2.k().f(1.3333334f);
                if (f2 < f3) {
                    f2 = f3;
                }
            }
        }
        if (listItem.z0() < f2) {
            listItem.W0(f2);
        }
        if (listItem.t1()) {
            arrayList.add(listItem);
        }
        return arrayList;
    }
}
