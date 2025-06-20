package com.itextpdf.tool.xml.pipeline.html;

import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.tool.xml.CustomContext;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.css.apply.MarginMemory;
import com.itextpdf.tool.xml.css.apply.PageSizeContainable;
import com.itextpdf.tool.xml.exceptions.NoDataException;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersAware;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.TagProcessor;
import com.itextpdf.tool.xml.html.TagProcessorFactory;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class HtmlPipelineContext implements CustomContext, Cloneable, MarginMemory, PageSizeContainable, CssAppliersAware {
    public static final String g3 = "header.autobookmark.RootNode";
    public static final String h3 = "lastMarginBottom";
    private boolean X = true;
    private ImageProvider X2;
    private TagProcessorFactory Y;
    private String Y2;
    private final List<Element> Z = new ArrayList();
    private Rectangle Z2 = PageSize.f25718k;
    private Charset a3;
    private List<String> b3 = Arrays.asList(new String[]{"body", "div"});
    private LinkProvider c3;
    private boolean d3 = true;
    private final Map<String, Object> e3 = new HashMap();
    private CssAppliers f3;
    private final LinkedList<StackKeeper> s = new LinkedList<>();

    public HtmlPipelineContext(CssAppliers cssAppliers) {
        this.f3 = cssAppliers;
        if (cssAppliers == null) {
            this.f3 = new CssAppliersImpl(new XMLWorkerFontProvider());
        }
    }

    public HtmlPipelineContext A(LinkProvider linkProvider) {
        this.c3 = linkProvider;
        return this;
    }

    public HtmlPipelineContext B(Rectangle rectangle) {
        this.Z2 = rectangle;
        return this;
    }

    public void D(String str) {
        this.Y2 = str;
    }

    public HtmlPipelineContext E(List<String> list) {
        this.b3 = list;
        return this;
    }

    public HtmlPipelineContext F(TagProcessorFactory tagProcessorFactory) {
        this.Y = tagProcessorFactory;
        return this;
    }

    public List<String> a() {
        return this.b3;
    }

    public CssAppliers b() {
        return this.f3;
    }

    public Float c() throws NoDataException {
        Object obj = r().get(h3);
        if (obj != null) {
            return (Float) obj;
        }
        throw new NoDataException();
    }

    public void d(CssAppliers cssAppliers) {
        this.f3 = cssAppliers;
    }

    public void e(Float f2) {
        r().put(h3, f2);
    }

    public boolean f() {
        return this.X;
    }

    /* access modifiers changed from: protected */
    public void g(StackKeeper stackKeeper) {
        this.s.addFirst(stackKeeper);
    }

    public Rectangle getPageSize() {
        return this.Z2;
    }

    public HtmlPipelineContext h(boolean z) {
        this.d3 = z;
        return this;
    }

    public boolean i() {
        return this.d3;
    }

    public HtmlPipelineContext l(Charset charset) {
        this.a3 = charset;
        return this;
    }

    public Charset m() {
        return this.a3;
    }

    /* renamed from: n */
    public HtmlPipelineContext clone() throws CloneNotSupportedException {
        CssAppliers clone = this.f3.clone();
        HtmlPipelineContext htmlPipelineContext = new HtmlPipelineContext(clone);
        ImageProvider imageProvider = this.X2;
        if (imageProvider != null) {
            htmlPipelineContext.z(imageProvider);
        }
        String str = this.Y2;
        if (str != null) {
            htmlPipelineContext.D(str);
        }
        Charset charset = this.a3;
        if (charset != null) {
            htmlPipelineContext.l(Charset.forName(charset.name()));
        }
        htmlPipelineContext.B(new Rectangle(this.Z2)).A(this.c3).E(new ArrayList(this.b3)).h(this.d3).F(this.Y).x(this.X).y(clone);
        return htmlPipelineContext;
    }

    /* access modifiers changed from: protected */
    public List<Element> o() {
        return this.Z;
    }

    public ImageProvider p() {
        return this.X2;
    }

    public LinkProvider q() {
        return this.c3;
    }

    public Map<String, Object> r() {
        return this.e3;
    }

    public String s() {
        return this.Y2;
    }

    /* access modifiers changed from: protected */
    public boolean t() {
        return this.s.isEmpty();
    }

    /* access modifiers changed from: protected */
    public StackKeeper u() {
        if (!this.s.isEmpty()) {
            return this.s.getFirst();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public StackKeeper v() throws NoStackException {
        try {
            return this.s.removeFirst();
        } catch (NoSuchElementException unused) {
            throw new NoStackException();
        }
    }

    /* access modifiers changed from: protected */
    public TagProcessor w(String str, String str2) {
        TagProcessor c2 = this.Y.c(str, str2);
        if (c2 instanceof CssAppliersAware) {
            ((CssAppliersAware) c2).d(this.f3);
        }
        return c2;
    }

    public HtmlPipelineContext x(boolean z) {
        this.X = z;
        return this;
    }

    public HtmlPipelineContext y(CssAppliers cssAppliers) {
        this.f3 = cssAppliers;
        return this;
    }

    public HtmlPipelineContext z(ImageProvider imageProvider) {
        this.X2 = imageProvider;
        return this;
    }
}
