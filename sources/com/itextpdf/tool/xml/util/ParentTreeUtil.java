package com.itextpdf.tool.xml.util;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import java.util.List;

public class ParentTreeUtil {
    public List<Tag> a(Tag tag, List<Tag> list) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            tag = tag.r();
            if (tag == null || tag.o().equals(HTML.Tag.y)) {
                return arrayList;
            }
            arrayList.add(tag);
        }
        return arrayList;
    }

    public List<String> b(Tag tag) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            tag = tag.r();
            if (tag == null || tag.o().equals("body")) {
                return arrayList;
            }
            arrayList.add(tag.o());
        }
        return arrayList;
    }
}
