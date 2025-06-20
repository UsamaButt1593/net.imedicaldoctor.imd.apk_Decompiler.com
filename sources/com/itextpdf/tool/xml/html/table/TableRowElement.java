package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.tool.xml.exceptions.NotImplementedException;
import com.itextpdf.tool.xml.html.pdfelement.HtmlCell;
import java.util.ArrayList;
import java.util.List;

public class TableRowElement implements Element {
    private final List<HtmlCell> X;
    private final Place s;

    public enum Place {
        CAPTION_TOP(-2, -2),
        HEADER(-1, -1),
        BODY(0, 1),
        FOOTER(1, 0),
        CAPTION_BOTTOM(2, 2);
        
        private Integer X;
        private Integer s;

        private Place(Integer num, Integer num2) {
            this.s = num;
            this.X = num2;
        }

        public Integer a() {
            return this.s;
        }

        public Integer b() {
            return this.X;
        }
    }

    public TableRowElement(List<Element> list, Place place) {
        this.X = new ArrayList(list.size());
        for (Element next : list) {
            if (next instanceof HtmlCell) {
                this.X.add((HtmlCell) next);
            }
        }
        this.s = place;
    }

    public boolean V() {
        throw new NotImplementedException();
    }

    public List<Chunk> Y() {
        throw new NotImplementedException();
    }

    public List<HtmlCell> a() {
        return this.X;
    }

    public Place c() {
        return this.s;
    }

    public boolean t(ElementListener elementListener) {
        throw new NotImplementedException();
    }

    public int type() {
        throw new NotImplementedException();
    }

    public boolean x() {
        throw new NotImplementedException();
    }
}
