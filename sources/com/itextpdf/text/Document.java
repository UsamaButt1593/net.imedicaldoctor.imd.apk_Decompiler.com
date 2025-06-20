package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Document implements DocListener, IAccessibleElement {
    public static boolean l3 = true;
    public static boolean m3 = false;
    public static float n3 = 0.86f;
    protected boolean X;
    protected float X2;
    protected boolean Y;
    protected float Y2;
    protected Rectangle Z;
    protected float Z2;
    protected float a3;
    protected boolean b3;
    protected boolean c3;
    protected String d3;
    protected String e3;
    protected String f3;
    protected int g3;
    protected int h3;
    protected PdfName i3;
    protected HashMap<PdfName, PdfObject> j3;
    protected AccessibleElementId k3;
    protected ArrayList<DocListener> s;

    public Document() {
        this(PageSize.f25718k);
    }

    public String A() {
        return this.e3;
    }

    public int B() {
        return this.g3;
    }

    public Rectangle C() {
        return this.Z;
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.k3 = accessibleElementId;
    }

    public boolean E() {
        return this.b3;
    }

    public boolean F() {
        return this.X;
    }

    public float G() {
        return this.Z.P(this.X2);
    }

    public float H(float f2) {
        return this.Z.P(this.X2 + f2);
    }

    public float I() {
        return this.X2;
    }

    public void J(DocListener docListener) {
        this.s.remove(docListener);
    }

    public float K() {
        return this.Z.R(this.Y2);
    }

    public PdfName L() {
        return this.i3;
    }

    public float M(float f2) {
        return this.Z.R(this.Y2 + f2);
    }

    public float N() {
        return this.Y2;
    }

    public void O(String str) {
        this.f3 = str;
    }

    public void P(String str) {
        this.d3 = str;
    }

    public void Q(String str) {
        this.e3 = str;
    }

    public float R() {
        return this.Z.W(this.Z2);
    }

    public float S(float f2) {
        return this.Z.W(this.Z2 + f2);
    }

    public float T() {
        return this.Z2;
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (this.j3 == null) {
            this.j3 = new HashMap<>();
        }
        this.j3.put(pdfName, pdfObject);
    }

    public boolean a(String str) {
        try {
            return b(new Meta(4, str));
        } catch (DocumentException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public boolean b(Element element) throws DocumentException {
        boolean z = false;
        if (this.Y) {
            throw new DocumentException(MessageLocalization.b("the.document.has.been.closed.you.can.t.add.any.elements", new Object[0]));
        } else if (this.X || !element.V()) {
            if (element instanceof ChapterAutoNumber) {
                this.h3 = ((ChapterAutoNumber) element).O1(this.h3);
            }
            Iterator<DocListener> it2 = this.s.iterator();
            while (it2.hasNext()) {
                z |= it2.next().b(element);
            }
            if (element instanceof LargeElement) {
                LargeElement largeElement = (LargeElement) element;
                if (!largeElement.isComplete()) {
                    largeElement.d();
                }
            }
            return z;
        } else {
            throw new DocumentException(MessageLocalization.b("the.document.is.not.open.yet.you.can.only.add.meta.information", new Object[0]));
        }
    }

    public boolean c(boolean z) {
        this.c3 = z;
        Iterator<DocListener> it2 = this.s.iterator();
        while (it2.hasNext()) {
            it2.next().c(z);
        }
        return true;
    }

    public void close() {
        if (!this.Y) {
            this.X = false;
            this.Y = true;
        }
        Iterator<DocListener> it2 = this.s.iterator();
        while (it2.hasNext()) {
            it2.next().close();
        }
    }

    public boolean d() {
        try {
            return b(new Meta(6, new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date())));
        } catch (DocumentException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public boolean e(String str) {
        try {
            return b(new Meta(7, str));
        } catch (DocumentException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public boolean f() {
        if (!this.X || this.Y) {
            return false;
        }
        Iterator<DocListener> it2 = this.s.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        return true;
    }

    public boolean g(boolean z) {
        this.b3 = z;
        Iterator<DocListener> it2 = this.s.iterator();
        while (it2.hasNext()) {
            it2.next().g(z);
        }
        return true;
    }

    public AccessibleElementId getId() {
        return this.k3;
    }

    public void h(DocListener docListener) {
        this.s.add(docListener);
        if (docListener instanceof IAccessibleElement) {
            IAccessibleElement iAccessibleElement = (IAccessibleElement) docListener;
            iAccessibleElement.o(this.i3);
            iAccessibleElement.D(this.k3);
            HashMap<PdfName, PdfObject> hashMap = this.j3;
            if (hashMap != null) {
                for (PdfName next : hashMap.keySet()) {
                    iAccessibleElement.U(next, this.j3.get(next));
                }
            }
        }
    }

    public boolean i(String str, String str2) {
        try {
            return b(new Header(str, str2));
        } catch (DocumentException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public boolean j(Rectangle rectangle) {
        this.Z = rectangle;
        Iterator<DocListener> it2 = this.s.iterator();
        while (it2.hasNext()) {
            it2.next().j(rectangle);
        }
        return true;
    }

    public boolean k(float f2, float f4, float f5, float f6) {
        this.X2 = f2;
        this.Y2 = f4;
        this.Z2 = f5;
        this.a3 = f6;
        Iterator<DocListener> it2 = this.s.iterator();
        while (it2.hasNext()) {
            it2.next().k(f2, f4, f5, f6);
        }
        return true;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.j3;
    }

    public boolean l(String str) {
        try {
            return b(new Meta(3, str));
        } catch (DocumentException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public boolean m(String str) {
        try {
            return b(new Meta(8, str));
        } catch (DocumentException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public boolean n() {
        return false;
    }

    public void o(PdfName pdfName) {
        this.i3 = pdfName;
    }

    public void open() {
        if (!this.Y) {
            this.X = true;
        }
        Iterator<DocListener> it2 = this.s.iterator();
        while (it2.hasNext()) {
            DocListener next = it2.next();
            next.j(this.Z);
            next.k(this.X2, this.Y2, this.Z2, this.a3);
            next.open();
        }
    }

    public boolean p() {
        try {
            return b(new Meta(5, Version.a().e()));
        } catch (DocumentException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public boolean q(String str) {
        try {
            return b(new Meta(2, str));
        } catch (DocumentException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public PdfObject r(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.j3;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }

    public void s() {
        this.g3 = 0;
        Iterator<DocListener> it2 = this.s.iterator();
        while (it2.hasNext()) {
            it2.next().s();
        }
    }

    public void t(int i2) {
        this.g3 = i2;
        Iterator<DocListener> it2 = this.s.iterator();
        while (it2.hasNext()) {
            it2.next().t(i2);
        }
    }

    public boolean u(String str) {
        try {
            return b(new Meta(1, str));
        } catch (DocumentException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public float v() {
        return this.Z.I(this.a3);
    }

    public float w(float f2) {
        return this.Z.I(this.a3 + f2);
    }

    public float x() {
        return this.a3;
    }

    public String y() {
        return this.f3;
    }

    public String z() {
        return this.d3;
    }

    public Document(Rectangle rectangle) {
        this(rectangle, 36.0f, 36.0f, 36.0f, 36.0f);
    }

    public Document(Rectangle rectangle, float f2, float f4, float f5, float f6) {
        this.s = new ArrayList<>();
        this.X2 = 0.0f;
        this.Y2 = 0.0f;
        this.Z2 = 0.0f;
        this.a3 = 0.0f;
        this.b3 = false;
        this.c3 = false;
        this.d3 = null;
        this.e3 = null;
        this.f3 = null;
        this.g3 = 0;
        this.h3 = 0;
        this.i3 = PdfName.P6;
        this.j3 = null;
        this.k3 = new AccessibleElementId();
        this.Z = rectangle;
        this.X2 = f2;
        this.Y2 = f4;
        this.Z2 = f5;
        this.a3 = f6;
    }
}
