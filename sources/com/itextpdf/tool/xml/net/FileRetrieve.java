package com.itextpdf.tool.xml.net;

import java.io.IOException;
import java.io.InputStream;

public interface FileRetrieve {
    void a(InputStream inputStream, ReadingProcessor readingProcessor) throws IOException;

    void b(String str, ReadingProcessor readingProcessor) throws IOException;
}
