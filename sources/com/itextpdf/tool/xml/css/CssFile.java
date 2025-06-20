package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import java.util.List;
import java.util.Map;

public interface CssFile {
    List<CssRule> a(Tag tag);

    void b(boolean z);

    boolean c(String str, Map<String, String> map);

    boolean d();
}
