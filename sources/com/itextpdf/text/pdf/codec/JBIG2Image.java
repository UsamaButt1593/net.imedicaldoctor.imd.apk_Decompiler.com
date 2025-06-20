package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgJBIG2;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.codec.JBIG2SegmentReader;

public class JBIG2Image {
    public static byte[] a(RandomAccessFileOrArray randomAccessFileOrArray) {
        try {
            JBIG2SegmentReader jBIG2SegmentReader = new JBIG2SegmentReader(randomAccessFileOrArray);
            jBIG2SegmentReader.g();
            return jBIG2SegmentReader.b(true);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Image b(RandomAccessFileOrArray randomAccessFileOrArray, int i2) {
        if (i2 >= 1) {
            try {
                JBIG2SegmentReader jBIG2SegmentReader = new JBIG2SegmentReader(randomAccessFileOrArray);
                jBIG2SegmentReader.g();
                JBIG2SegmentReader.JBIG2Page c2 = jBIG2SegmentReader.c(i2);
                return new ImgJBIG2(c2.f26603d, c2.f26604e, c2.b(true), jBIG2SegmentReader.b(true));
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            throw new IllegalArgumentException(MessageLocalization.b("the.page.number.must.be.gt.eq.1", new Object[0]));
        }
    }

    public static int c(RandomAccessFileOrArray randomAccessFileOrArray) {
        try {
            JBIG2SegmentReader jBIG2SegmentReader = new JBIG2SegmentReader(randomAccessFileOrArray);
            jBIG2SegmentReader.g();
            return jBIG2SegmentReader.f();
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }
}
