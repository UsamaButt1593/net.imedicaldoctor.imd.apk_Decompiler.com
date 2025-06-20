package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfTemplate;
import java.net.URL;

public class ImgTemplate extends Image {
    ImgTemplate(Image image) {
        super(image);
    }

    public ImgTemplate(PdfTemplate pdfTemplate) throws BadElementException {
        super((URL) null);
        if (pdfTemplate == null) {
            throw new BadElementException(MessageLocalization.b("the.template.can.not.be.null", new Object[0]));
        } else if (pdfTemplate.O3() != 3) {
            this.s3 = 35;
            float I3 = pdfTemplate.I3();
            this.E3 = I3;
            z0(I3);
            float P3 = pdfTemplate.P3();
            this.D3 = P3;
            x0(P3);
            q2(pdfTemplate);
            this.B3 = a0();
            this.C3 = N();
        } else {
            throw new BadElementException(MessageLocalization.b("a.pattern.can.not.be.used.as.a.template.to.create.an.image", new Object[0]));
        }
    }
}
