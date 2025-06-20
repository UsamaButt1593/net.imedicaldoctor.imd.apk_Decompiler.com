package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.util.Map;

@Deprecated
public interface HTMLTagProcessor {
    void a(HTMLWorker hTMLWorker, String str, Map<String, String> map) throws DocumentException, IOException;

    void b(HTMLWorker hTMLWorker, String str) throws DocumentException;
}
