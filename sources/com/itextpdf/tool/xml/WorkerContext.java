package com.itextpdf.tool.xml;

public interface WorkerContext {
    void a(String str, CustomContext customContext);

    Tag b();

    void c(Tag tag);

    CustomContext i(String str) throws NoCustomContextException;
}
