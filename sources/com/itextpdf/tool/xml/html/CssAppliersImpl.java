package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.apply.ChunkCssApplier;
import com.itextpdf.tool.xml.css.apply.DivCssApplier;
import com.itextpdf.tool.xml.css.apply.HtmlCellCssApplier;
import com.itextpdf.tool.xml.css.apply.ImageCssApplier;
import com.itextpdf.tool.xml.css.apply.LineSeparatorCssApplier;
import com.itextpdf.tool.xml.css.apply.ListStyleTypeCssApplier;
import com.itextpdf.tool.xml.css.apply.MarginMemory;
import com.itextpdf.tool.xml.css.apply.NoNewLineParagraphCssApplier;
import com.itextpdf.tool.xml.css.apply.PageSizeContainable;
import com.itextpdf.tool.xml.css.apply.ParagraphCssApplier;
import com.itextpdf.tool.xml.html.pdfelement.HtmlCell;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CssAppliersImpl implements CssAppliers {

    /* renamed from: a  reason: collision with root package name */
    private Map<Class<?>, CssApplier<? extends Element>> f27585a;

    public CssAppliersImpl() {
        HashMap hashMap = new HashMap();
        this.f27585a = hashMap;
        hashMap.put(Chunk.class, new ChunkCssApplier((FontProvider) null));
        this.f27585a.put(Paragraph.class, new ParagraphCssApplier(this));
        this.f27585a.put(NoNewLineParagraph.class, new NoNewLineParagraphCssApplier());
        this.f27585a.put(HtmlCell.class, new HtmlCellCssApplier());
        this.f27585a.put(List.class, new ListStyleTypeCssApplier());
        this.f27585a.put(LineSeparator.class, new LineSeparatorCssApplier());
        this.f27585a.put(Image.class, new ImageCssApplier());
        this.f27585a.put(PdfDiv.class, new DivCssApplier());
    }

    public Element a(Element element, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext) {
        CssApplier cssApplier;
        Iterator<Map.Entry<Class<?>, CssApplier<? extends Element>>> it2 = this.f27585a.entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                cssApplier = null;
                break;
            }
            Map.Entry next = it2.next();
            if (((Class) next.getKey()).isInstance(element)) {
                cssApplier = (CssApplier) next.getValue();
                break;
            }
        }
        CssApplier cssApplier2 = cssApplier;
        if (cssApplier2 != null) {
            return cssApplier2.a(element, tag, marginMemory, pageSizeContainable, htmlPipelineContext);
        }
        throw new RuntimeException();
    }

    public Element b(Element element, Tag tag, HtmlPipelineContext htmlPipelineContext) {
        return a(element, tag, htmlPipelineContext, htmlPipelineContext, htmlPipelineContext);
    }

    public ChunkCssApplier c() {
        return (ChunkCssApplier) this.f27585a.get(Chunk.class);
    }

    public CssAppliers clone() {
        CssAppliersImpl e2 = e();
        e2.f27585a = new HashMap(this.f27585a);
        return e2;
    }

    public void d(ChunkCssApplier chunkCssApplier) {
        this.f27585a.put(Chunk.class, chunkCssApplier);
    }

    /* access modifiers changed from: protected */
    public CssAppliersImpl e() {
        return new CssAppliersImpl();
    }

    public CssApplier f(Class<?> cls) {
        return this.f27585a.get(cls);
    }

    public void g(Class<?> cls, CssApplier cssApplier) {
        this.f27585a.put(cls, cssApplier);
    }

    public CssAppliersImpl(FontProvider fontProvider) {
        this();
        ((ChunkCssApplier) this.f27585a.get(Chunk.class)).i(fontProvider);
    }
}
