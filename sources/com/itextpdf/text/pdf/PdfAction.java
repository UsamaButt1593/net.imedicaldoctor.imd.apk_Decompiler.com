package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.collection.PdfTargetDictionary;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import kotlinx.coroutines.DebugKt;

public class PdfAction extends PdfDictionary {
    public static final int A3 = 64;
    public static final int B3 = 128;
    public static final int C3 = 256;
    public static final int D3 = 512;
    public static final int E3 = 1024;
    public static final int F3 = 2048;
    public static final int G3 = 8196;
    public static final int H3 = 1;
    public static final int p3 = 1;
    public static final int q3 = 2;
    public static final int r3 = 3;
    public static final int s3 = 4;
    public static final int t3 = 5;
    public static final int u3 = 1;
    public static final int v3 = 2;
    public static final int w3 = 4;
    public static final int x3 = 8;
    public static final int y3 = 16;
    public static final int z3 = 32;

    public PdfAction() {
    }

    public static PdfAction B1(int i2, PdfDestination pdfDestination, PdfWriter pdfWriter) {
        PdfIndirectReference A1 = pdfWriter.A1(i2);
        PdfDestination pdfDestination2 = new PdfDestination(pdfDestination);
        pdfDestination2.X0(A1);
        PdfAction pdfAction = new PdfAction();
        pdfAction.V0(PdfName.Ce, PdfName.N8);
        pdfAction.V0(PdfName.f6, pdfDestination2);
        return pdfAction;
    }

    public static PdfAction E1(String str, boolean z) {
        PdfName pdfName;
        PdfObject pdfString;
        PdfAction pdfAction = new PdfAction();
        pdfAction.V0(PdfName.Ce, PdfName.N8);
        if (z) {
            pdfName = PdfName.f6;
            pdfString = new PdfName(str);
        } else {
            pdfName = PdfName.f6;
            pdfString = new PdfString(str, PdfObject.h3);
        }
        pdfAction.V0(pdfName, pdfString);
        return pdfAction;
    }

    public static PdfAction G1(String str, String str2, boolean z, boolean z2) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.V0(PdfName.F7, new PdfString(str));
        pdfAction.V0(PdfName.Ce, PdfName.Q8);
        pdfAction.V0(PdfName.f6, z ? new PdfName(str2) : new PdfString(str2, PdfObject.h3));
        if (z2) {
            pdfAction.V0(PdfName.zb, PdfBoolean.j3);
        }
        return pdfAction;
    }

    public static PdfAction I1(String str, PdfWriter pdfWriter) {
        return J1(str, pdfWriter, false);
    }

    public static PdfAction J1(String str, PdfWriter pdfWriter, boolean z) {
        PdfName pdfName;
        PdfString pdfString;
        PdfAction pdfAction = new PdfAction();
        pdfAction.V0(PdfName.Ce, PdfName.aa);
        String str2 = PdfObject.h3;
        if (z && str.length() < 50) {
            pdfName = PdfName.ea;
            pdfString = new PdfString(str, str2);
        } else if (z || str.length() >= 100) {
            if (!z) {
                str2 = PdfObject.g3;
            }
            try {
                PdfStream pdfStream = new PdfStream(PdfEncodings.c(str, str2));
                pdfStream.i1(pdfWriter.a1());
                pdfAction.V0(PdfName.ea, pdfWriter.v0(pdfStream).a());
            } catch (Exception unused) {
                pdfName = PdfName.ea;
                pdfString = new PdfString(str);
            }
            return pdfAction;
        } else {
            pdfName = PdfName.ea;
            pdfString = new PdfString(str);
        }
        pdfAction.V0(pdfName, pdfString);
        return pdfAction;
    }

    public static PdfAction L1(String str, PdfFileSpecification pdfFileSpecification, String str2, PdfIndirectReference pdfIndirectReference) throws IOException {
        PdfAction pdfAction = new PdfAction();
        pdfAction.V0(PdfName.Ce, PdfName.Td);
        pdfAction.V0(PdfName.Dd, new PdfRendition(str, pdfFileSpecification, str2));
        pdfAction.V0(new PdfName("OP"), new PdfNumber(0));
        pdfAction.V0(new PdfName("AN"), pdfIndirectReference);
        return pdfAction;
    }

    public static PdfAction M1(ArrayList<Object> arrayList, boolean z) {
        PdfObject pdfObject;
        PdfAction pdfAction = new PdfAction();
        pdfAction.V0(PdfName.Ce, PdfName.Ke);
        PdfArray pdfArray = new PdfArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Object obj = arrayList.get(i2);
            if (obj != null) {
                if (obj instanceof PdfIndirectReference) {
                    pdfObject = (PdfIndirectReference) obj;
                } else if (obj instanceof PdfLayer) {
                    pdfObject = ((PdfLayer) obj).g();
                } else if (obj instanceof PdfName) {
                    pdfObject = (PdfName) obj;
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.equalsIgnoreCase(DebugKt.f29173d)) {
                        pdfObject = PdfName.Zb;
                    } else if (str.equalsIgnoreCase(DebugKt.f29174e)) {
                        pdfObject = PdfName.Yb;
                    } else if (str.equalsIgnoreCase("toggle")) {
                        pdfObject = PdfName.ng;
                    } else {
                        throw new IllegalArgumentException(MessageLocalization.b("a.string.1.was.passed.in.state.only.on.off.and.toggle.are.allowed", str));
                    }
                } else {
                    throw new IllegalArgumentException(MessageLocalization.b("invalid.type.was.passed.in.state.1", obj.getClass().getName()));
                }
                pdfArray.a0(pdfObject);
            }
        }
        pdfAction.V0(PdfName.of, pdfArray);
        if (!z) {
            pdfAction.V0(PdfName.ed, PdfBoolean.k3);
        }
        return pdfAction;
    }

    static PdfArray f1(Object[] objArr) {
        PdfArray pdfArray = new PdfArray();
        for (String str : objArr) {
            if (str instanceof String) {
                pdfArray.a0(new PdfString(str));
            } else if (str instanceof PdfAnnotation) {
                pdfArray.a0(((PdfAnnotation) str).L1());
            } else {
                throw new RuntimeException(MessageLocalization.b("the.array.must.contain.string.or.pdfannotation", new Object[0]));
            }
        }
        return pdfArray;
    }

    public static PdfAction i1(PdfAnnotation pdfAnnotation, boolean z) {
        return m1(pdfAnnotation.L1(), z);
    }

    static PdfAction m1(PdfObject pdfObject, boolean z) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.V0(PdfName.Ce, PdfName.p9);
        pdfAction.V0(PdfName.If, pdfObject);
        if (!z) {
            pdfAction.V0(PdfName.W8, PdfBoolean.k3);
        }
        return pdfAction;
    }

    public static PdfAction n1(String str, boolean z) {
        return m1(new PdfString(str), z);
    }

    public static PdfAction o1(Object[] objArr, boolean z) {
        return m1(f1(objArr), z);
    }

    public static PdfAction p1(String str) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.V0(PdfName.Ce, PdfName.S9);
        pdfAction.V0(PdfName.F7, new PdfString(str));
        return pdfAction;
    }

    public static PdfAction q1(String str, String str2, String str3, String str4) {
        return new PdfAction(str, str2, str3, str4);
    }

    public static PdfAction s1(Object[] objArr, int i2) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.V0(PdfName.Ce, PdfName.Vd);
        if (objArr != null) {
            pdfAction.V0(PdfName.P7, f1(objArr));
        }
        pdfAction.V0(PdfName.g8, new PdfNumber(i2));
        return pdfAction;
    }

    public static PdfAction v1(String str, Object[] objArr, int i2) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.V0(PdfName.Ce, PdfName.Bf);
        PdfDictionary pdfDictionary = new PdfDictionary();
        PdfName pdfName = PdfName.F7;
        pdfDictionary.V0(pdfName, new PdfString(str));
        pdfDictionary.V0(PdfName.B8, PdfName.Zg);
        pdfAction.V0(pdfName, pdfDictionary);
        if (objArr != null) {
            pdfAction.V0(PdfName.P7, f1(objArr));
        }
        pdfAction.V0(PdfName.g8, new PdfNumber(i2));
        return pdfAction;
    }

    public static PdfAction w1(String str, PdfTargetDictionary pdfTargetDictionary, PdfObject pdfObject, boolean z) {
        PdfAction pdfAction = new PdfAction();
        pdfAction.V0(PdfName.Ce, PdfName.P8);
        pdfAction.V0(PdfName.If, pdfTargetDictionary);
        pdfAction.V0(PdfName.f6, pdfObject);
        pdfAction.V0(PdfName.zb, new PdfBoolean(z));
        if (str != null) {
            pdfAction.V0(PdfName.F7, new PdfString(str));
        }
        return pdfAction;
    }

    public static PdfAction x1(String str, PdfTargetDictionary pdfTargetDictionary, String str2, boolean z, boolean z2) {
        return w1(str, pdfTargetDictionary, z ? new PdfName(str2) : new PdfString(str2, PdfObject.h3), z2);
    }

    public void K1(PdfAction pdfAction) {
        PdfName pdfName = PdfName.Ab;
        PdfObject d0 = d0(pdfName);
        if (d0 == null) {
            V0(pdfName, pdfAction);
        } else if (d0.z()) {
            PdfArray pdfArray = new PdfArray(d0);
            pdfArray.a0(pdfAction);
            V0(pdfName, pdfArray);
        } else {
            ((PdfArray) d0).a0(pdfAction);
        }
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        PdfWriter.G0(pdfWriter, 14, this);
        super.T(pdfWriter, outputStream);
    }

    public PdfAction(int i2) {
        PdfName pdfName;
        PdfObject pdfObject;
        PdfName pdfName2 = PdfName.Ce;
        V0(pdfName2, PdfName.rb);
        if (i2 == 1) {
            pdfName = PdfName.kb;
            pdfObject = PdfName.W7;
        } else if (i2 == 2) {
            pdfName = PdfName.kb;
            pdfObject = PdfName.hd;
        } else if (i2 == 3) {
            pdfName = PdfName.kb;
            pdfObject = PdfName.Bb;
        } else if (i2 == 4) {
            pdfName = PdfName.kb;
            pdfObject = PdfName.qa;
        } else if (i2 == 5) {
            V0(pdfName2, PdfName.aa);
            pdfName = PdfName.ea;
            pdfObject = new PdfString("this.print(true);\r");
        } else {
            throw new RuntimeException(MessageLocalization.b("invalid.named.action", new Object[0]));
        }
        V0(pdfName, pdfObject);
    }

    PdfAction(PdfIndirectReference pdfIndirectReference) {
        V0(PdfName.Ce, PdfName.N8);
        V0(PdfName.f6, pdfIndirectReference);
    }

    public PdfAction(String str) {
        this(str, false);
    }

    public PdfAction(String str, int i2) {
        V0(PdfName.Ce, PdfName.Q8);
        V0(PdfName.F7, new PdfString(str));
        PdfName pdfName = PdfName.f6;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(i2 - 1);
        sb.append(" /FitH 10000]");
        V0(pdfName, new PdfLiteral(sb.toString()));
    }

    public PdfAction(String str, String str2) {
        V0(PdfName.Ce, PdfName.Q8);
        V0(PdfName.F7, new PdfString(str));
        V0(PdfName.f6, new PdfString(str2));
    }

    public PdfAction(String str, String str2, String str3, String str4) {
        V0(PdfName.Ce, PdfName.ra);
        if (str2 == null && str3 == null && str4 == null) {
            V0(PdfName.F7, new PdfString(str));
            return;
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(PdfName.F7, new PdfString(str));
        if (str2 != null) {
            pdfDictionary.V0(PdfName.tc, new PdfString(str2));
        }
        if (str3 != null) {
            pdfDictionary.V0(PdfName.Lb, new PdfString(str3));
        }
        if (str4 != null) {
            pdfDictionary.V0(PdfName.f6, new PdfString(str4));
        }
        V0(PdfName.Lh, pdfDictionary);
    }

    public PdfAction(String str, boolean z) {
        PdfName pdfName = PdfName.Ce;
        PdfName pdfName2 = PdfName.Yg;
        V0(pdfName, pdfName2);
        V0(pdfName2, new PdfString(str));
        if (z) {
            V0(PdfName.V9, PdfBoolean.j3);
        }
    }

    public PdfAction(URL url) {
        this(url.toExternalForm());
    }

    public PdfAction(URL url, boolean z) {
        this(url.toExternalForm(), z);
    }
}
