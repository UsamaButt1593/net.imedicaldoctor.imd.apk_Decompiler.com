package com.itextpdf.text.pdf;

public class PdfSigLockDictionary extends PdfDictionary {

    public enum LockAction {
        ALL(PdfName.H3),
        INCLUDE(PdfName.K9),
        EXCLUDE(PdfName.x7);
        
        private PdfName s;

        private LockAction(PdfName pdfName) {
            this.s = pdfName;
        }

        public PdfName a() {
            return this.s;
        }
    }

    public enum LockPermissions {
        NO_CHANGES_ALLOWED(1),
        FORM_FILLING(2),
        FORM_FILLING_AND_ANNOTATION(3);
        
        private PdfNumber s;

        private LockPermissions(int i2) {
            this.s = new PdfNumber(i2);
        }

        public PdfNumber a() {
            return this.s;
        }
    }

    public PdfSigLockDictionary() {
        super(PdfName.Qe);
        V0(PdfName.q3, LockAction.ALL.a());
    }

    public PdfSigLockDictionary(LockAction lockAction, LockPermissions lockPermissions, String... strArr) {
        super(PdfName.Qe);
        V0(PdfName.q3, lockAction.a());
        if (lockPermissions != null) {
            V0(PdfName.tc, lockPermissions.a());
        }
        PdfArray pdfArray = new PdfArray();
        for (String pdfString : strArr) {
            pdfArray.a0(new PdfString(pdfString));
        }
        V0(PdfName.P7, pdfArray);
    }

    public PdfSigLockDictionary(LockAction lockAction, String... strArr) {
        this(lockAction, (LockPermissions) null, strArr);
    }

    public PdfSigLockDictionary(LockPermissions lockPermissions) {
        this();
        V0(PdfName.tc, lockPermissions.a());
    }
}
