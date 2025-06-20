package com.itextpdf.tool.xml.pipeline.css;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.exceptions.CssResolverException;
import com.itextpdf.tool.xml.net.FileRetrieve;

public interface CSSResolver {
    void a(CssFile cssFile);

    void b(Tag tag);

    void c(FileRetrieve fileRetrieve);

    CSSResolver clear() throws CssResolverException;

    void d(String str, boolean z) throws CssResolverException;

    void e(String str, boolean z) throws CssResolverException;

    void f(String str, String str2, boolean z) throws CssResolverException;
}
