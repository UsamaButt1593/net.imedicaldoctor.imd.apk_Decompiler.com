package com.itextpdf.tool.xml.pipeline.end;

import com.itextpdf.tool.xml.ElementHandler;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.PipelineException;
import com.itextpdf.tool.xml.ProcessObject;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.Writable;
import com.itextpdf.tool.xml.pipeline.AbstractPipeline;

public class ElementHandlerPipeline extends AbstractPipeline {

    /* renamed from: b  reason: collision with root package name */
    private final ElementHandler f27718b;

    public ElementHandlerPipeline(ElementHandler elementHandler, Pipeline pipeline) {
        super(pipeline);
        this.f27718b = elementHandler;
    }

    private void i(ProcessObject processObject) {
        if (processObject.c()) {
            while (true) {
                Writable d2 = processObject.d();
                if (d2 != null) {
                    this.f27718b.b(d2);
                } else {
                    return;
                }
            }
        }
    }

    public Pipeline b(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        i(processObject);
        return a();
    }

    public Pipeline d(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException {
        i(processObject);
        return a();
    }

    public Pipeline<?> e(WorkerContext workerContext, Tag tag, String str, ProcessObject processObject) throws PipelineException {
        i(processObject);
        return a();
    }
}
