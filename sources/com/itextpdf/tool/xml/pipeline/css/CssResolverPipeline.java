package com.itextpdf.tool.xml.pipeline.css;

import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.PipelineException;
import com.itextpdf.tool.xml.ProcessObject;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.itextpdf.tool.xml.pipeline.AbstractPipeline;
import com.itextpdf.tool.xml.pipeline.ctx.ObjectContext;

public class CssResolverPipeline extends AbstractPipeline<ObjectContext<CSSResolver>> {

    /* renamed from: c  reason: collision with root package name */
    public static final String f27714c = "CSS_RESOLVER";

    /* renamed from: b  reason: collision with root package name */
    private CSSResolver f27715b;

    public CssResolverPipeline(CSSResolver cSSResolver, Pipeline<?> pipeline) {
        super(pipeline);
        this.f27715b = cSSResolver;
    }

    public Pipeline<?> b(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        ((CSSResolver) ((ObjectContext) g(workerContext)).a()).b(tag);
        return a();
    }

    public Pipeline<?> c(WorkerContext workerContext) throws PipelineException {
        try {
            workerContext.a(f(), new ObjectContext(this.f27715b.clear()));
            return super.c(workerContext);
        } catch (CssResolverException e2) {
            throw new PipelineException((Exception) e2);
        }
    }

    public String f() {
        return CssResolverPipeline.class.getName();
    }

    public void i(CSSResolver cSSResolver) {
        this.f27715b = cSSResolver;
    }
}
