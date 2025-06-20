package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.apply.ChunkCssApplier;
import com.itextpdf.tool.xml.css.apply.MarginMemory;
import com.itextpdf.tool.xml.css.apply.PageSizeContainable;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

public interface CssAppliers {
    Element a(Element element, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext);

    Element b(Element element, Tag tag, HtmlPipelineContext htmlPipelineContext);

    ChunkCssApplier c();

    CssAppliers clone();

    void d(ChunkCssApplier chunkCssApplier);
}
