package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;

public class CidLocationFromByte implements CidLocation {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f26825a;

    public CidLocationFromByte(byte[] bArr) {
        this.f26825a = bArr;
    }

    public PRTokeniser a(String str) throws IOException {
        return new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().j(this.f26825a)));
    }
}
