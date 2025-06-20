package com.itextpdf.tool.xml.pipeline.html;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.PipelineException;
import com.itextpdf.tool.xml.ProcessObject;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.NoTagProcessorException;
import com.itextpdf.tool.xml.html.TagProcessor;
import com.itextpdf.tool.xml.pipeline.AbstractPipeline;
import com.itextpdf.tool.xml.pipeline.WritableElement;
import java.util.List;

public class HtmlPipeline extends AbstractPipeline<HtmlPipelineContext> {

    /* renamed from: b  reason: collision with root package name */
    private final HtmlPipelineContext f27731b;

    public HtmlPipeline(HtmlPipelineContext htmlPipelineContext, Pipeline<?> pipeline) {
        super(pipeline);
        this.f27731b = htmlPipelineContext;
    }

    public Pipeline<?> b(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        HtmlPipelineContext htmlPipelineContext = (HtmlPipelineContext) g(workerContext);
        try {
            tag.H(htmlPipelineContext.r().get(HtmlPipelineContext.h3));
            htmlPipelineContext.r().remove(HtmlPipelineContext.h3);
            TagProcessor w = htmlPipelineContext.w(tag.o(), tag.q());
            i(tag, htmlPipelineContext, w);
            List<Element> c2 = w.c(workerContext, tag);
            if (c2.size() > 0) {
                if (w.a()) {
                    StackKeeper u = htmlPipelineContext.u();
                    if (u != null) {
                        for (Element a2 : c2) {
                            u.a(a2);
                        }
                    } else {
                        throw new PipelineException(String.format(LocaleMessages.f27579j, new Object[]{tag.toString()}));
                    }
                } else {
                    for (Element next : c2) {
                        htmlPipelineContext.o().add(next);
                        if (next.type() == 38) {
                            WritableElement writableElement = new WritableElement();
                            writableElement.a(next);
                            processObject.a(writableElement);
                            htmlPipelineContext.o().remove(next);
                        }
                    }
                }
            }
        } catch (NoTagProcessorException e2) {
            if (!htmlPipelineContext.f()) {
                throw e2;
            }
        }
        return a();
    }

    public Pipeline<?> c(WorkerContext workerContext) throws PipelineException {
        try {
            workerContext.a(f(), this.f27731b.clone());
            return a();
        } catch (CloneNotSupportedException e2) {
            throw new PipelineException(String.format(LocaleMessages.a().b(LocaleMessages.f27575f), new Object[]{this.f27731b.getClass().toString()}), e2);
        }
    }

    public Pipeline<?> d(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        List<Element> list;
        HtmlPipelineContext htmlPipelineContext = (HtmlPipelineContext) g(workerContext);
        try {
            if (tag.n() != null) {
                htmlPipelineContext.r().put(HtmlPipelineContext.h3, tag.n());
            } else {
                htmlPipelineContext.r().remove(HtmlPipelineContext.h3);
            }
            TagProcessor w = htmlPipelineContext.w(tag.o(), tag.q());
            if (w.a()) {
                list = w.e(workerContext, tag, htmlPipelineContext.v().c());
            } else {
                list = w.e(workerContext, tag, htmlPipelineContext.o());
                htmlPipelineContext.o().clear();
            }
            if (list.size() > 0) {
                StackKeeper u = htmlPipelineContext.u();
                if (u != null) {
                    for (Element a2 : list) {
                        u.a(a2);
                    }
                } else {
                    WritableElement writableElement = new WritableElement();
                    processObject.a(writableElement);
                    writableElement.b(list);
                }
            }
        } catch (NoStackException e2) {
            throw new PipelineException(String.format(LocaleMessages.a().b(LocaleMessages.f27579j), new Object[]{tag.toString()}), e2);
        } catch (NoTagProcessorException e3) {
            if (!htmlPipelineContext.f()) {
                throw e3;
            }
        }
        return a();
    }

    public Pipeline<?> e(WorkerContext workerContext, Tag tag, String str, ProcessObject processObject) throws PipelineException {
        HtmlPipelineContext htmlPipelineContext = (HtmlPipelineContext) g(workerContext);
        try {
            List<Element> f2 = htmlPipelineContext.w(tag.o(), tag.q()).f(workerContext, tag, str);
            if (f2.size() > 0) {
                StackKeeper u = htmlPipelineContext.u();
                if (u != null) {
                    for (Element a2 : f2) {
                        u.a(a2);
                    }
                } else {
                    WritableElement writableElement = new WritableElement();
                    for (Element a3 : f2) {
                        writableElement.a(a3);
                    }
                    processObject.a(writableElement);
                }
            }
        } catch (NoTagProcessorException e2) {
            if (!htmlPipelineContext.f()) {
                throw e2;
            }
        }
        return a();
    }

    public String f() {
        return HtmlPipeline.class.getName();
    }

    /* access modifiers changed from: protected */
    public void i(Tag tag, HtmlPipelineContext htmlPipelineContext, TagProcessor tagProcessor) {
        if (tagProcessor.a()) {
            htmlPipelineContext.g(new StackKeeper(tag));
        }
    }
}
