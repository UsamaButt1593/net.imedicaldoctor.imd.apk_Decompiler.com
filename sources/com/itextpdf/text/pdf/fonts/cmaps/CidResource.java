package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.io.StreamUtil;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;
import java.io.InputStream;

public class CidResource implements CidLocation {
    public PRTokeniser a(String str) throws IOException {
        String str2 = CJKFont.Q4 + str;
        InputStream b2 = StreamUtil.b(str2);
        if (b2 != null) {
            return new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().g(b2)));
        }
        throw new IOException(MessageLocalization.b("the.cmap.1.was.not.found", str2));
    }
}
