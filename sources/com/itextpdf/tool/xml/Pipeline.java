package com.itextpdf.tool.xml;

import com.itextpdf.tool.xml.CustomContext;

public interface Pipeline<T extends CustomContext> {
    Pipeline<?> a();

    Pipeline<?> b(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException;

    Pipeline<?> c(WorkerContext workerContext) throws PipelineException;

    Pipeline<?> d(WorkerContext workerContext, Tag tag, ProcessObject processObject) throws PipelineException;

    Pipeline<?> e(WorkerContext workerContext, Tag tag, String str, ProcessObject processObject) throws PipelineException;
}
