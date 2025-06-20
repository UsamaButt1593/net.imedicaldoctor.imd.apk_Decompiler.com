package com.itextpdf.text.io;

import java.io.IOException;

public interface RandomAccessSource {
    int a(long j2, byte[] bArr, int i2, int i3) throws IOException;

    int b(long j2) throws IOException;

    void close() throws IOException;

    long length();
}
