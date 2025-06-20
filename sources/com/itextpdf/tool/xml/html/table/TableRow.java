package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.html.pdfelement.HtmlCell;
import com.itextpdf.tool.xml.html.table.TableRowElement;
import java.util.ArrayList;
import java.util.List;

public class TableRow extends AbstractTagProcessor {
    public boolean a() {
        return true;
    }

    public List<Element> k(WorkerContext workerContext, Tag tag, List<Element> list) {
        ArrayList arrayList = new ArrayList(1);
        TableRowElement tableRowElement = tag.r().o().equalsIgnoreCase(HTML.Tag.f27614b) ? new TableRowElement(list, TableRowElement.Place.HEADER) : tag.r().o().equalsIgnoreCase(HTML.Tag.f27615c) ? new TableRowElement(list, TableRowElement.Place.BODY) : tag.r().o().equalsIgnoreCase(HTML.Tag.f27616d) ? new TableRowElement(list, TableRowElement.Place.FOOTER) : new TableRowElement(list, TableRowElement.Place.BODY);
        int o = o(tag);
        if (o != 1) {
            for (HtmlCell next : tableRowElement.a()) {
                if (next.h1() == 1) {
                    next.O1(o);
                }
            }
        }
        arrayList.add(tableRowElement);
        return arrayList;
    }
}
