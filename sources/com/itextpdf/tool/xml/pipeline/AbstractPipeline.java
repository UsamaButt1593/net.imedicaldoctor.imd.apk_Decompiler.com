package com.itextpdf.tool.xml.pipeline;

import com.itextpdf.tool.xml.CustomContext;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.PipelineException;
import com.itextpdf.tool.xml.ProcessObject;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;

public abstract class AbstractPipeline<T extends CustomContext> implements Pipeline<T> {

    /* renamed from: a  reason: collision with root package name */
    private Pipeline<?> f27712a;

    public AbstractPipeline(Pipeline<?> pipeline) {
        h(pipeline);
    }

    public Pipeline<?> a() {
        return this.f27712a;
    }

    public Pipeline<?> b(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        return a();
    }

    public Pipeline<?> c(WorkerContext workerContext) throws PipelineException {
        return a();
    }

    public Pipeline<?> d(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        return a();
    }

    public Pipeline<?> e(WorkerContext workerContext, Tag tag, String str, ProcessObject processObject) throws PipelineException {
        return a();
    }

    public String f() {
        return getClass().getName();
    }

    public T g(WorkerContext workerContext) throws PipelineException {
        try {
            T i2 = workerContext.i(f());
            if (i2 != null) {
                return i2;
            }
            throw new PipelineException(String.format(LocaleMessages.a().b(LocaleMessages.f27580k), new Object[]{getClass().getName()}));
        } catch (NoCustomContextException e2) {
            throw new PipelineException(String.format(LocaleMessages.a().b(LocaleMessages.f27580k), new Object[]{getClass().getName()}), e2);
        }
    }

    public void h(Pipeline<?> pipeline) {
        this.f27712a = pipeline;
    }
}
