package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Element;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.apply.MarginMemory;
import com.itextpdf.tool.xml.css.apply.PageSizeContainable;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

public interface CssApplier<T extends Element> {
    T a(T t, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext);
}
