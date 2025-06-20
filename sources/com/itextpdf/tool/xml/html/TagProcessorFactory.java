package com.itextpdf.tool.xml.html;

import com.itextpdf.tool.xml.exceptions.NoTagProcessorException;

public interface TagProcessorFactory {
    void a(String str);

    void b(TagProcessor tagProcessor, String... strArr);

    TagProcessor c(String str, String str2) throws NoTagProcessorException;
}
