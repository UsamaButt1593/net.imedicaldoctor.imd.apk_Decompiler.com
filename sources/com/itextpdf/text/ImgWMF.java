package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.codec.wmf.InputMeta;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImgWMF extends Image {
    ImgWMF(Image image) {
        super(image);
    }

    private void y2() throws BadElementException, IOException {
        String str;
        this.s3 = 35;
        this.Y3 = 6;
        InputStream inputStream = null;
        try {
            if (this.u3 == null) {
                inputStream = this.t3.openStream();
                str = this.t3.toString();
            } else {
                str = "Byte array";
                inputStream = new ByteArrayInputStream(this.u3);
            }
            InputMeta inputMeta = new InputMeta(inputStream);
            if (inputMeta.d() == -1698247209) {
                inputMeta.f();
                int e2 = inputMeta.e();
                int e3 = inputMeta.e();
                int e4 = inputMeta.e();
                int e5 = inputMeta.e();
                int f2 = inputMeta.f();
                this.b4 = 72;
                this.c4 = 72;
                float f3 = (float) f2;
                float f4 = (((float) (e5 - e3)) / f3) * 72.0f;
                this.E3 = f4;
                z0(f4);
                float f5 = (((float) (e4 - e2)) / f3) * 72.0f;
                this.D3 = f5;
                x0(f5);
                if (inputStream != null) {
                    inputStream.close();
                }
                this.B3 = a0();
                this.C3 = N();
                return;
            }
            throw new BadElementException(MessageLocalization.b("1.is.not.a.valid.placeable.windows.metafile", str));
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            this.B3 = a0();
            this.C3 = N();
            throw th;
        }
    }

    public void z2(PdfTemplate pdfTemplate) throws IOException, DocumentException {
        q2(pdfTemplate);
        pdfTemplate.Z3(a0());
        pdfTemplate.V3(N());
        InputStream inputStream = null;
        try {
            InputStream openStream = this.u3 == null ? this.t3.openStream() : new ByteArrayInputStream(this.u3);
            new MetaDo(openStream, pdfTemplate).e();
            if (openStream != null) {
                openStream.close();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public ImgWMF(String str) throws BadElementException, MalformedURLException, IOException {
        this(Utilities.w(str));
    }

    public ImgWMF(URL url) throws BadElementException, IOException {
        super(url);
        y2();
    }

    public ImgWMF(byte[] bArr) throws BadElementException, IOException {
        super((URL) null);
        this.u3 = bArr;
        this.Z3 = bArr;
        y2();
    }
}
