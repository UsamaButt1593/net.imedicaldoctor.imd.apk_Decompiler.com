package com.itextpdf.tool.xml.pipeline.end;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.PipelineException;
import com.itextpdf.tool.xml.ProcessObject;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.Writable;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.pipeline.AbstractPipeline;
import com.itextpdf.tool.xml.pipeline.WritableElement;
import com.itextpdf.tool.xml.pipeline.ctx.MapContext;

public class PdfWriterPipeline extends AbstractPipeline<MapContext> {

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f27719e = LoggerFactory.b(PdfWriterPipeline.class);

    /* renamed from: f  reason: collision with root package name */
    public static final String f27720f = "DOCUMENT";

    /* renamed from: g  reason: collision with root package name */
    public static final String f27721g = "WRITER";

    /* renamed from: h  reason: collision with root package name */
    public static final String f27722h = "CONTINUOUS";

    /* renamed from: b  reason: collision with root package name */
    private Document f27723b;

    /* renamed from: c  reason: collision with root package name */
    private PdfWriter f27724c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f27725d;

    public PdfWriterPipeline() {
        super((Pipeline<?>) null);
    }

    private void k(WorkerContext workerContext, ProcessObject processObject) throws PipelineException {
        MapContext mapContext = (MapContext) g(workerContext);
        if (processObject.c()) {
            Document document = (Document) mapContext.a(f27720f);
            boolean booleanValue = ((Boolean) mapContext.a(f27722h)).booleanValue();
            while (true) {
                Writable d2 = processObject.d();
                if (d2 == null) {
                    return;
                }
                if (d2 instanceof WritableElement) {
                    for (Element next : ((WritableElement) d2).c()) {
                        try {
                            if (!document.b(next)) {
                                f27719e.h(String.format(LocaleMessages.a().b(LocaleMessages.f27581l), new Object[]{next.toString()}));
                            }
                        } catch (DocumentException e2) {
                            if (booleanValue) {
                                f27719e.i(LocaleMessages.a().b(LocaleMessages.f27582m), e2);
                            } else {
                                throw new PipelineException((Exception) e2);
                            }
                        }
                    }
                    continue;
                }
            }
        }
    }

    public Pipeline<?> b(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        k(workerContext, processObject);
        return a();
    }

    public Pipeline<?> c(WorkerContext workerContext) throws PipelineException {
        MapContext mapContext = new MapContext();
        Boolean bool = Boolean.TRUE;
        this.f27725d = bool;
        mapContext.b(f27722h, bool);
        Document document = this.f27723b;
        if (document != null) {
            mapContext.b(f27720f, document);
        }
        PdfWriter pdfWriter = this.f27724c;
        if (pdfWriter != null) {
            mapContext.b(f27721g, pdfWriter);
        }
        workerContext.a(f(), mapContext);
        return super.c(workerContext);
    }

    public Pipeline<?> d(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        k(workerContext, processObject);
        return a();
    }

    public Pipeline<?> e(WorkerContext workerContext, Tag tag, String str, ProcessObject processObject) throws PipelineException {
        k(workerContext, processObject);
        return a();
    }

    public void i(Document document) {
        this.f27723b = document;
    }

    public void j(PdfWriter pdfWriter) {
        this.f27724c = pdfWriter;
    }

    public PdfWriterPipeline(Document document, PdfWriter pdfWriter) {
        super((Pipeline<?>) null);
        this.f27723b = document;
        this.f27724c = pdfWriter;
        this.f27725d = Boolean.TRUE;
    }

    public PdfWriterPipeline(Pipeline<?> pipeline) {
        super(pipeline);
    }
}
