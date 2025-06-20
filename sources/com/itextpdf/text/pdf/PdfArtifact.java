package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PdfArtifact implements IAccessibleElement {
    private static final HashSet<String> Z = new HashSet<>(Arrays.asList(new String[]{"Pagination", "Layout", "Page", "Background"}));
    protected HashMap<PdfName, PdfObject> X = null;
    protected AccessibleElementId Y = new AccessibleElementId();
    protected PdfName s = PdfName.X3;

    /* renamed from: com.itextpdf.text.pdf.PdfArtifact$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26129a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.itextpdf.text.pdf.PdfArtifact$ArtifactType[] r0 = com.itextpdf.text.pdf.PdfArtifact.ArtifactType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26129a = r0
                com.itextpdf.text.pdf.PdfArtifact$ArtifactType r1 = com.itextpdf.text.pdf.PdfArtifact.ArtifactType.Z     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f26129a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.PdfArtifact$ArtifactType r1 = com.itextpdf.text.pdf.PdfArtifact.ArtifactType.LAYOUT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f26129a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.pdf.PdfArtifact$ArtifactType r1 = com.itextpdf.text.pdf.PdfArtifact.ArtifactType.PAGE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f26129a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.itextpdf.text.pdf.PdfArtifact$ArtifactType r1 = com.itextpdf.text.pdf.PdfArtifact.ArtifactType.PAGINATION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfArtifact.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ArtifactType {
        PAGINATION,
        LAYOUT,
        PAGE,
        Z
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.Y = accessibleElementId;
    }

    public PdfName L() {
        return this.s;
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (this.X == null) {
            this.X = new HashMap<>();
        }
        this.X.put(pdfName, pdfObject);
    }

    public PdfArray a() {
        HashMap<PdfName, PdfObject> hashMap = this.X;
        if (hashMap == null) {
            return null;
        }
        return (PdfArray) hashMap.get(PdfName.e4);
    }

    public PdfArray b() {
        HashMap<PdfName, PdfObject> hashMap = this.X;
        if (hashMap == null) {
            return null;
        }
        return (PdfArray) hashMap.get(PdfName.n4);
    }

    public PdfString c() {
        HashMap<PdfName, PdfObject> hashMap = this.X;
        if (hashMap == null) {
            return null;
        }
        return (PdfString) hashMap.get(PdfName.Kg);
    }

    public void d(PdfArray pdfArray) {
        U(PdfName.e4, pdfArray);
    }

    public void e(PdfArray pdfArray) {
        U(PdfName.n4, pdfArray);
    }

    public void f(ArtifactType artifactType) {
        int i2 = AnonymousClass1.f26129a[artifactType.ordinal()];
        U(PdfName.Kg, i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : new PdfString("Pagination") : new PdfString("Page") : new PdfString("Layout") : new PdfString("Background"));
    }

    public void g(PdfString pdfString) {
        if (Z.contains(pdfString.toString())) {
            U(PdfName.Kg, pdfString);
        } else {
            throw new IllegalArgumentException(MessageLocalization.b("the.artifact.type.1.is.invalid", pdfString));
        }
    }

    public AccessibleElementId getId() {
        return this.Y;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.X;
    }

    public boolean n() {
        return true;
    }

    public void o(PdfName pdfName) {
    }

    public PdfObject r(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.X;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }
}
