package com.itextpdf.tool.xml.pipeline.ctx;

import com.itextpdf.tool.xml.CustomContext;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;

public class WorkerContextImpl implements WorkerContext {

    /* renamed from: a  reason: collision with root package name */
    private final MapContext f27716a = new MapContext();

    /* renamed from: b  reason: collision with root package name */
    private Tag f27717b;

    public void a(String str, CustomContext customContext) {
        this.f27716a.b(str, customContext);
    }

    public Tag b() {
        return this.f27717b;
    }

    public void c(Tag tag) {
        this.f27717b = tag;
    }

    public CustomContext i(String str) throws NoCustomContextException {
        Object a2 = this.f27716a.a(str);
        if (a2 != null) {
            return (CustomContext) a2;
        }
        throw new NoCustomContextException();
    }
}
