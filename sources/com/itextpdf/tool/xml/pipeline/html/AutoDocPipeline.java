package com.itextpdf.tool.xml.pipeline.html;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.PipelineException;
import com.itextpdf.tool.xml.ProcessObject;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.pipeline.AbstractPipeline;
import com.itextpdf.tool.xml.pipeline.ctx.MapContext;
import com.itextpdf.tool.xml.pipeline.ctx.WorkerContextImpl;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class AutoDocPipeline extends AbstractPipeline {

    /* renamed from: b  reason: collision with root package name */
    private final FileMaker f27727b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27728c;

    /* renamed from: d  reason: collision with root package name */
    private final String f27729d;

    /* renamed from: e  reason: collision with root package name */
    private final Rectangle f27730e;

    public AutoDocPipeline(FileMaker fileMaker, String str, String str2, Rectangle rectangle) {
        super((Pipeline<?>) null);
        this.f27727b = fileMaker;
        this.f27728c = str;
        this.f27729d = str2;
        this.f27730e = rectangle;
    }

    public Pipeline<?> b(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        try {
            Class<PdfWriterPipeline> cls = PdfWriterPipeline.class;
            if (this.f27728c.equals(tag.o())) {
                MapContext mapContext = (MapContext) workerContext.i(cls.getName());
                Document document = new Document(this.f27730e);
                OutputStream e2 = this.f27727b.e();
                mapContext.b(PdfWriterPipeline.f27720f, document);
                mapContext.b(PdfWriterPipeline.f27721g, PdfWriter.p1(document, e2));
            }
            if (tag.o().equalsIgnoreCase(this.f27729d)) {
                Document document2 = (Document) ((MapContext) workerContext.i(cls.getName())).a(PdfWriterPipeline.f27720f);
                CssUtils g2 = CssUtils.g();
                float a0 = document2.C().a0();
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                for (Map.Entry next : tag.g().entrySet()) {
                    String str = (String) next.getKey();
                    String str2 = (String) next.getValue();
                    if (str.equalsIgnoreCase(CSS.Property.f27470m)) {
                        f2 = g2.s(str2, a0);
                    } else if (str.equalsIgnoreCase(CSS.Property.f27471n)) {
                        f3 = g2.s(str2, a0);
                    } else if (str.equalsIgnoreCase(CSS.Property.o)) {
                        f4 = g2.s(str2, a0);
                    } else if (str.equalsIgnoreCase(CSS.Property.p)) {
                        f5 = g2.s(str2, a0);
                    }
                }
                document2.k(f2, f3, f4, f5);
                document2.open();
            }
            return a();
        } catch (IOException e3) {
            throw new PipelineException((Exception) e3);
        } catch (DocumentException e4) {
            throw new PipelineException((Exception) e4);
        } catch (NoCustomContextException e5) {
            throw new PipelineException(LocaleMessages.a().b(LocaleMessages.f27578i), e5);
        }
    }

    public Pipeline<?> d(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        Class<HtmlPipeline> cls = HtmlPipeline.class;
        if (this.f27728c.equals(tag.o())) {
            try {
                ((Document) ((MapContext) workerContext.i(PdfWriterPipeline.class.getName())).a(PdfWriterPipeline.f27720f)).close();
                try {
                    HtmlPipelineContext n2 = ((HtmlPipelineContext) workerContext.i(cls.getName())).clone();
                    n2.B(this.f27730e);
                    ((WorkerContextImpl) workerContext).a(cls.getName(), n2);
                } catch (NoCustomContextException | CloneNotSupportedException unused) {
                }
            } catch (NoCustomContextException e2) {
                throw new PipelineException("AutoDocPipeline depends on PdfWriterPipeline.", e2);
            }
        }
        return a();
    }
}
