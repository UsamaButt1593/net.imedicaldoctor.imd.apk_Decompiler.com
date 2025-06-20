package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Image;
import com.itextpdf.text.LargeElement;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.events.PdfPTableEventForwarder;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PdfPTable implements LargeElement, Spaceable, IAccessibleElement {
    public static final int F3 = 0;
    public static final int G3 = 1;
    public static final int H3 = 2;
    public static final int I3 = 3;
    static final /* synthetic */ boolean J3 = false;
    protected AccessibleElementId A3;
    private PdfPTableHeader B3;
    private PdfPTableBody C3;
    private PdfPTableFooter D3;
    private int E3;
    protected ArrayList<PdfPRow> X;
    protected int X2;
    protected float Y;
    protected PdfPCell Y2;
    protected PdfPCell[] Z;
    protected float Z2;
    protected float[] a3;
    protected float[] b3;
    protected PdfPTableEvent c3;
    protected int d3;
    protected float e3;
    private int f3;
    private boolean g3;
    private boolean h3;
    protected boolean i3;
    protected int j3;
    private boolean k3;
    private boolean l3;
    protected float m3;
    protected float n3;
    protected float o3;
    private boolean[] p3;
    private boolean q3;
    private boolean r3;
    private final Logger s;
    private boolean s3;
    protected boolean t3;
    private int u3;
    protected boolean v3;
    protected boolean w3;
    protected boolean x3;
    protected PdfName y3;
    protected HashMap<PdfName, PdfObject> z3;

    public static class ColumnMeasurementState {

        /* renamed from: a  reason: collision with root package name */
        public float f26254a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        public int f26255b = 1;

        /* renamed from: c  reason: collision with root package name */
        public int f26256c = 1;

        public void a(PdfPCell pdfPCell, float f2, float f3) {
            this.f26255b = pdfPCell.g1();
            this.f26256c = pdfPCell.J0();
            this.f26254a = f2 + Math.max(pdfPCell.l1() ? pdfPCell.G0() : pdfPCell.Y0(), f3);
        }

        public boolean b() {
            return this.f26255b == 1;
        }

        public void c(float f2, float f3) {
            this.f26255b--;
        }
    }

    public static class FittingRows {

        /* renamed from: a  reason: collision with root package name */
        public final int f26257a;

        /* renamed from: b  reason: collision with root package name */
        public final int f26258b;

        /* renamed from: c  reason: collision with root package name */
        public final float f26259c;

        /* renamed from: d  reason: collision with root package name */
        public final float f26260d;

        /* renamed from: e  reason: collision with root package name */
        private final Map<Integer, Float> f26261e;

        public FittingRows(int i2, int i3, float f2, float f3, Map<Integer, Float> map) {
            this.f26257a = i2;
            this.f26258b = i3;
            this.f26259c = f2;
            this.f26260d = f3;
            this.f26261e = map;
        }

        public void a(PdfPTable pdfPTable, int i2) {
            PdfPRow b0 = pdfPTable.b0(i2);
            Float f2 = this.f26261e.get(Integer.valueOf(i2));
            if (f2 != null) {
                b0.u(f2.floatValue());
            }
        }
    }

    protected PdfPTable() {
        this.s = LoggerFactory.b(PdfPTable.class);
        this.X = new ArrayList<>();
        this.Y = 0.0f;
        this.X2 = 0;
        this.Y2 = new PdfPCell((Phrase) null);
        this.Z2 = 0.0f;
        this.e3 = 80.0f;
        this.f3 = 1;
        this.g3 = false;
        this.h3 = false;
        this.i3 = false;
        this.j3 = 0;
        this.k3 = false;
        this.l3 = true;
        this.p3 = new boolean[]{false, false};
        this.r3 = true;
        this.t3 = true;
        this.v3 = true;
        this.w3 = true;
        this.x3 = true;
        this.y3 = PdfName.Kf;
        this.z3 = null;
        this.A3 = new AccessibleElementId();
        this.B3 = null;
        this.C3 = null;
        this.D3 = null;
    }

    public static void B(PdfContentByte[] pdfContentByteArr) {
        PdfContentByte pdfContentByte = pdfContentByteArr[0];
        PdfArtifact pdfArtifact = new PdfArtifact();
        pdfContentByte.B1(pdfArtifact);
        pdfContentByte.a2();
        pdfContentByte.c(pdfContentByteArr[1]);
        pdfContentByte.U1();
        pdfContentByte.a2();
        pdfContentByte.y2(2);
        pdfContentByte.S1();
        pdfContentByte.c(pdfContentByteArr[2]);
        pdfContentByte.U1();
        pdfContentByte.c0(pdfArtifact);
        pdfContentByte.c(pdfContentByteArr[3]);
    }

    private PdfPTableBody D0(PdfPTableBody pdfPTableBody, PdfContentByte pdfContentByte) {
        if (!pdfContentByte.Y.K1().contains(pdfPTableBody.L())) {
            return null;
        }
        pdfContentByte.B1(pdfPTableBody);
        return pdfPTableBody;
    }

    public static PdfPTable d1(PdfPTable pdfPTable) {
        PdfPTable pdfPTable2 = new PdfPTable();
        pdfPTable2.v(pdfPTable);
        return pdfPTable2;
    }

    private void f1() {
        int i2 = this.j3 == 3 ? -1 : 1;
        while (F0(this.X.size(), this.X2)) {
            this.X2 += i2;
        }
    }

    public static PdfContentByte[] l(PdfContentByte pdfContentByte) {
        return new PdfContentByte[]{pdfContentByte, pdfContentByte.U0(), pdfContentByte.U0(), pdfContentByte.U0()};
    }

    private PdfPTableBody s(PdfPTableBody pdfPTableBody, PdfContentByte pdfContentByte) {
        if (!pdfContentByte.Y.K1().contains(pdfPTableBody.L())) {
            return null;
        }
        pdfContentByte.c0(pdfPTableBody);
        return null;
    }

    public boolean A(int i2) {
        PdfPRow pdfPRow;
        if (i2 < 0 || i2 >= this.X.size()) {
            return false;
        }
        if (this.Z2 > 0.0f && (pdfPRow = this.X.get(i2)) != null) {
            this.Y -= pdfPRow.e();
        }
        this.X.remove(i2);
        int i4 = this.d3;
        if (i2 < i4) {
            int i5 = i4 - 1;
            this.d3 = i5;
            int i6 = this.u3;
            if (i2 >= i5 - i6) {
                this.u3 = i6 - 1;
            }
        }
        return true;
    }

    public void A0(int i2, int i4) {
        if (i2 < i4) {
            while (i2 < i4) {
                b0(i2).w(true);
                i2++;
            }
        }
    }

    public void B0(int[] iArr) {
        for (int b0 : iArr) {
            b0(b0).w(true);
        }
    }

    public float[] C() {
        return this.b3;
    }

    public void C0() {
        int i2 = this.u3;
        int i4 = this.d3;
        if (i2 > i4) {
            this.u3 = i4;
        }
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.A3 = accessibleElementId;
    }

    public float E() {
        return this.m3;
    }

    public void E0(int i2) {
        if (i2 > 0) {
            this.a3 = new float[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                this.a3[i4] = 1.0f;
            }
            this.b3 = new float[this.a3.length];
            p();
            this.Z = new PdfPCell[this.b3.length];
            this.Y = 0.0f;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("the.number.of.columns.in.pdfptable.constructor.must.be.greater.than.zero", new Object[0]));
    }

    public PdfPTableBody F() {
        if (this.C3 == null) {
            this.C3 = new PdfPTableBody();
        }
        return this.C3;
    }

    /* access modifiers changed from: package-private */
    public boolean F0(int i2, int i4) {
        if (i4 >= a0() || i4 < 0 || i2 < 1) {
            return false;
        }
        int i5 = i2 - 1;
        if (this.X.get(i5) == null) {
            return false;
        }
        do {
            PdfPCell q = q(i5, i4);
            if (q != null || i5 <= 0) {
                int i6 = i2 - i5;
                if (q.g1() == 1 && i6 > 1) {
                    int i7 = i4 - 1;
                    PdfPRow pdfPRow = this.X.get(i5 + 1);
                    i6--;
                    q = pdfPRow.c()[i7];
                    while (q == null && i7 > 0) {
                        i7--;
                        q = pdfPRow.c()[i7];
                    }
                }
                return q != null && q.g1() > i6;
            }
            i5--;
        } while (this.X.get(i5) != null);
        return false;
    }

    public int G(int i2, int i4) {
        while (b0(i2).c()[i4] == null && i2 > 0) {
            i2--;
        }
        return i2;
    }

    public void G0(int... iArr) {
        A0(0, this.X.size());
        for (int b0 : iArr) {
            b0(b0).w(false);
        }
    }

    public PdfPCell H() {
        return this.Y2;
    }

    public void H0(boolean z) {
        boolean[] zArr = this.p3;
        zArr[0] = z;
        zArr[1] = z;
    }

    /* access modifiers changed from: package-private */
    public float[][] I(float f2, int i2, int i4, boolean z) {
        int i5;
        if (z) {
            i2 = Math.max(i2, this.d3);
            i4 = Math.max(i4, this.d3);
        }
        int i6 = 0;
        int i7 = ((z ? this.d3 : 0) + i4) - i2;
        float[][] fArr = new float[i7][];
        if (this.i3) {
            if (z) {
                int i8 = 0;
                while (i6 < this.d3) {
                    PdfPRow pdfPRow = this.X.get(i6);
                    if (pdfPRow == null) {
                        i8++;
                    } else {
                        fArr[i8] = pdfPRow.d(f2, this.b3);
                        i8++;
                    }
                    i6++;
                }
                i6 = i8;
            }
            while (i2 < i4) {
                PdfPRow pdfPRow2 = this.X.get(i2);
                if (pdfPRow2 == null) {
                    i5++;
                } else {
                    fArr[i5] = pdfPRow2.d(f2, this.b3);
                    i5++;
                }
                i2++;
            }
        } else {
            int a0 = a0();
            float[] fArr2 = new float[(a0 + 1)];
            fArr2[0] = f2;
            int i9 = 0;
            while (i9 < a0) {
                int i10 = i9 + 1;
                fArr2[i10] = fArr2[i9] + this.b3[i9];
                i9 = i10;
            }
            while (i6 < i7) {
                fArr[i6] = fArr2;
                i6++;
            }
        }
        return fArr;
    }

    public void I0(boolean z, boolean z2) {
        boolean[] zArr = this.p3;
        zArr[0] = z;
        zArr[1] = z2;
    }

    public FittingRows J(float f2, int i2) {
        boolean z;
        float f4;
        int i4;
        this.s.f(String.format("getFittingRows(%s, %s)", new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}));
        if (i2 > 0) {
            this.X.size();
        }
        int a0 = a0();
        ColumnMeasurementState[] columnMeasurementStateArr = new ColumnMeasurementState[a0];
        for (int i5 = 0; i5 < a0; i5++) {
            columnMeasurementStateArr[i5] = new ColumnMeasurementState();
        }
        HashMap hashMap = new HashMap();
        int i6 = i2;
        float f5 = 0.0f;
        float f6 = 0.0f;
        while (true) {
            if (i6 >= e1()) {
                z = false;
                break;
            }
            PdfPRow b0 = b0(i6);
            float f7 = b0.f();
            int i7 = 0;
            float f8 = 0.0f;
            while (i7 < a0) {
                PdfPCell pdfPCell = b0.c()[i7];
                ColumnMeasurementState columnMeasurementState = columnMeasurementStateArr[i7];
                if (pdfPCell == null) {
                    columnMeasurementState.c(f6, f7);
                    f4 = f7;
                } else {
                    columnMeasurementState.a(pdfPCell, f6, f7);
                    f4 = f7;
                    this.s.f(String.format("Height after beginCell: %s (cell: %s)", new Object[]{Float.valueOf(columnMeasurementState.f26254a), Float.valueOf(pdfPCell.G0())}));
                }
                if (columnMeasurementState.b()) {
                    float f9 = columnMeasurementState.f26254a;
                    if (f9 > f8) {
                        f8 = f9;
                    }
                }
                int i8 = 1;
                while (true) {
                    i4 = columnMeasurementState.f26256c;
                    if (i8 >= i4) {
                        break;
                    }
                    columnMeasurementStateArr[i7 + i8].f26254a = columnMeasurementState.f26254a;
                    i8++;
                }
                i7 += i4;
                f7 = f4;
            }
            float f10 = 0.0f;
            for (int i9 = 0; i9 < a0; i9++) {
                float f11 = columnMeasurementStateArr[i9].f26254a;
                if (f11 > f10) {
                    f10 = f11;
                }
            }
            b0.u(f8 - f6);
            if (f2 - (x0() ? f10 : f8) < 0.0f) {
                z = false;
                break;
            }
            hashMap.put(Integer.valueOf(i6), Float.valueOf(f10 - f6));
            i6++;
            f5 = f10;
            f6 = f8;
        }
        this.x3 = z;
        return new FittingRows(i2, i6 - 1, f5, f6, hashMap);
    }

    public void J0(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.u3 = i2;
    }

    public float K() {
        return this.n3;
    }

    public void K0(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.d3 = i2;
    }

    public PdfName L() {
        return this.y3;
    }

    public void L0(boolean z) {
        this.q3 = z;
    }

    public void M(float f2) {
        this.o3 = f2;
    }

    public void M0(int i2) {
        this.f3 = i2;
    }

    public PdfPTableFooter N() {
        if (this.D3 == null) {
            this.D3 = new PdfPTableFooter();
        }
        return this.D3;
    }

    public void N0(boolean z) {
        this.s3 = z;
    }

    public float O() {
        int min = Math.min(this.X.size(), this.d3);
        float f2 = 0.0f;
        for (int max = Math.max(0, this.d3 - this.u3); max < min; max++) {
            PdfPRow pdfPRow = this.X.get(max);
            if (pdfPRow != null) {
                f2 += pdfPRow.e();
            }
        }
        return f2;
    }

    public void O0(boolean z) {
        this.k3 = z;
    }

    public int P() {
        return this.u3;
    }

    public void P0(boolean z) {
        this.w3 = z;
    }

    public PdfPTableHeader Q() {
        if (this.B3 == null) {
            this.B3 = new PdfPTableHeader();
        }
        return this.B3;
    }

    public void Q0(int i2) {
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3) {
            this.j3 = i2;
            return;
        }
        throw new RuntimeException(MessageLocalization.a("invalid.run.direction.1", i2));
    }

    public float R() {
        int min = Math.min(this.X.size(), this.d3);
        float f2 = 0.0f;
        for (int i2 = 0; i2 < min; i2++) {
            PdfPRow pdfPRow = this.X.get(i2);
            if (pdfPRow != null) {
                f2 += pdfPRow.e();
            }
        }
        return f2;
    }

    public void R0(boolean z) {
        this.g3 = z;
    }

    public int S() {
        return this.d3;
    }

    public void S0(boolean z) {
        this.h3 = z;
    }

    public int T() {
        return this.f3;
    }

    public void T0(boolean z) {
        this.r3 = z;
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (this.z3 == null) {
            this.z3 = new HashMap<>();
        }
        this.z3.put(pdfName, pdfObject);
    }

    public void U0(boolean z) {
        this.l3 = z;
    }

    public boolean V() {
        return true;
    }

    public void V0(String str) {
        U(PdfName.Df, new PdfString(str));
    }

    public boolean W() {
        return this.s3;
    }

    public void W0(PdfPTableEvent pdfPTableEvent) {
        if (pdfPTableEvent == null) {
            pdfPTableEvent = null;
        } else {
            PdfPTableEvent pdfPTableEvent2 = this.c3;
            if (pdfPTableEvent2 != null) {
                if (pdfPTableEvent2 instanceof PdfPTableEventForwarder) {
                    ((PdfPTableEventForwarder) pdfPTableEvent2).d(pdfPTableEvent);
                    return;
                }
                PdfPTableEventForwarder pdfPTableEventForwarder = new PdfPTableEventForwarder();
                pdfPTableEventForwarder.d(this.c3);
                pdfPTableEventForwarder.d(pdfPTableEvent);
                this.c3 = pdfPTableEventForwarder;
                return;
            }
        }
        this.c3 = pdfPTableEvent;
    }

    public float X() {
        return this.o3;
    }

    public void X0(float f2) {
        if (this.Z2 != f2) {
            this.Z2 = f2;
            this.Y = 0.0f;
            p();
            m();
        }
    }

    public List<Chunk> Y() {
        return new ArrayList();
    }

    public void Y0(float[] fArr) throws DocumentException {
        if (fArr.length == a0()) {
            this.Z2 = 0.0f;
            for (int i2 = 0; i2 < fArr.length; i2++) {
                this.Z2 += fArr[i2];
            }
            b1(fArr);
            return;
        }
        throw new DocumentException(MessageLocalization.b("wrong.number.of.columns", new Object[0]));
    }

    public int Z() {
        return this.X.size() - 1;
    }

    public void Z0(float f2) {
        this.e3 = f2;
    }

    public PdfPCell a(PdfPCell pdfPCell) {
        boolean z;
        int i2;
        PdfPCell[] pdfPCellArr;
        this.v3 = false;
        PdfPCell pdfPHeaderCell = pdfPCell instanceof PdfPHeaderCell ? new PdfPHeaderCell((PdfPHeaderCell) pdfPCell) : new PdfPCell(pdfPCell);
        int min = Math.min(Math.max(pdfPHeaderCell.J0(), 1), this.Z.length - this.X2);
        pdfPHeaderCell.w1(min);
        if (min != 1) {
            this.i3 = true;
        }
        if (pdfPHeaderCell.h1() == 0) {
            pdfPHeaderCell.O1(this.j3);
        }
        f1();
        int i4 = this.X2;
        PdfPCell[] pdfPCellArr2 = this.Z;
        if (i4 < pdfPCellArr2.length) {
            pdfPCellArr2[i4] = pdfPHeaderCell;
            this.X2 = i4 + min;
            z = true;
        } else {
            z = false;
        }
        f1();
        while (true) {
            i2 = this.X2;
            pdfPCellArr = this.Z;
            if (i2 < pdfPCellArr.length) {
                break;
            }
            int a0 = a0();
            if (this.j3 == 3) {
                PdfPCell[] pdfPCellArr3 = new PdfPCell[a0];
                int length = this.Z.length;
                int i5 = 0;
                while (true) {
                    PdfPCell[] pdfPCellArr4 = this.Z;
                    if (i5 >= pdfPCellArr4.length) {
                        break;
                    }
                    PdfPCell pdfPCell2 = pdfPCellArr4[i5];
                    int J0 = pdfPCell2.J0();
                    length -= J0;
                    pdfPCellArr3[length] = pdfPCell2;
                    i5 = i5 + (J0 - 1) + 1;
                }
                this.Z = pdfPCellArr3;
            }
            PdfPRow pdfPRow = new PdfPRow(this.Z);
            if (this.Z2 > 0.0f) {
                pdfPRow.x(this.b3);
                this.Y += pdfPRow.e();
            }
            this.X.add(pdfPRow);
            this.Z = new PdfPCell[a0];
            this.X2 = 0;
            f1();
            this.v3 = true;
        }
        if (!z) {
            pdfPCellArr[i2] = pdfPHeaderCell;
            this.X2 = i2 + min;
        }
        return pdfPHeaderCell;
    }

    public int a0() {
        return this.a3.length;
    }

    public void a1(float[] fArr, Rectangle rectangle) throws DocumentException {
        if (fArr.length == a0()) {
            Y0(fArr);
            this.e3 = (this.Z2 / (rectangle.Q() - rectangle.O())) * 100.0f;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("wrong.number.of.columns", new Object[0]));
    }

    public PdfPRow b0(int i2) {
        return this.X.get(i2);
    }

    public void b1(float[] fArr) throws DocumentException {
        if (fArr.length == a0()) {
            float[] fArr2 = new float[fArr.length];
            this.a3 = fArr2;
            System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
            this.b3 = new float[fArr.length];
            this.Y = 0.0f;
            p();
            m();
            return;
        }
        throw new DocumentException(MessageLocalization.b("wrong.number.of.columns", new Object[0]));
    }

    public void c(float f2) {
        this.n3 = f2;
    }

    public float c0(int i2) {
        return d0(i2, false);
    }

    public void c1(int[] iArr) throws DocumentException {
        float[] fArr = new float[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            fArr[i2] = (float) iArr[i2];
        }
        b1(fArr);
    }

    public void d() {
        w();
        if (this.E3 > 0) {
            R0(true);
        }
    }

    /* access modifiers changed from: protected */
    public float d0(int i2, boolean z) {
        PdfPRow pdfPRow;
        int i4;
        float f2;
        if (this.Z2 <= 0.0f || i2 < 0 || i2 >= this.X.size() || (pdfPRow = this.X.get(i2)) == null) {
            return 0.0f;
        }
        if (z) {
            pdfPRow.x(this.b3);
        }
        float e2 = pdfPRow.e();
        for (int i5 = 0; i5 < this.a3.length; i5++) {
            if (F0(i2, i5)) {
                int i6 = 1;
                while (true) {
                    i4 = i2 - i6;
                    if (!F0(i4, i5)) {
                        break;
                    }
                    i6++;
                }
                PdfPCell pdfPCell = this.X.get(i4).c()[i5];
                if (pdfPCell == null || pdfPCell.g1() != i6 + 1) {
                    f2 = 0.0f;
                } else {
                    f2 = pdfPCell.Y0();
                    while (i6 > 0) {
                        f2 -= c0(i2 - i6);
                        i6--;
                    }
                }
                if (f2 > e2) {
                    e2 = f2;
                }
            }
        }
        pdfPRow.v(e2);
        return e2;
    }

    public void e(Image image) {
        this.Y2.C1(image);
        a(this.Y2).O3 = new AccessibleElementId();
        this.Y2.C1((Image) null);
    }

    public ArrayList<PdfPRow> e0() {
        return this.X;
    }

    public int e1() {
        return this.X.size();
    }

    public void f(Phrase phrase) {
        this.Y2.L1(phrase);
        a(this.Y2).O3 = new AccessibleElementId();
        this.Y2.L1((Phrase) null);
    }

    public ArrayList<PdfPRow> f0(int i2, int i4) {
        ArrayList<PdfPRow> arrayList = new ArrayList<>();
        if (i2 >= 0 && i4 <= e1()) {
            while (i2 < i4) {
                arrayList.add(k(i2, i4));
                i2++;
            }
        }
        return arrayList;
    }

    public void g(PdfPTable pdfPTable) {
        this.Y2.Q1(pdfPTable);
        a(this.Y2).O3 = new AccessibleElementId();
        this.Y2.Q1((PdfPTable) null);
    }

    public float g0(int i2, int i4) {
        PdfPRow pdfPRow;
        float f2 = 0.0f;
        if (this.Z2 > 0.0f && i2 >= 0 && i2 < this.X.size() && (pdfPRow = this.X.get(i2)) != null && i4 < pdfPRow.c().length) {
            PdfPCell pdfPCell = pdfPRow.c()[i4];
            if (pdfPCell == null) {
                return 0.0f;
            }
            for (int i5 = 0; i5 < pdfPCell.g1(); i5++) {
                f2 += c0(i2 + i5);
            }
        }
        return f2;
    }

    public float g1() {
        return this.n3;
    }

    public AccessibleElementId getId() {
        return this.A3;
    }

    public void h(float f2) {
        this.m3 = f2;
    }

    public int h0() {
        return this.j3;
    }

    public float h1() {
        return this.m3;
    }

    public void i(String str) {
        f(new Phrase(str));
    }

    public String i0() {
        return r(PdfName.Df).toString();
    }

    public float i1(int i2, int i4, float f2, float f4, PdfContentByte pdfContentByte) {
        return k1(0, -1, i2, i4, f2, f4, pdfContentByte);
    }

    public boolean isComplete() {
        return this.t3;
    }

    /* access modifiers changed from: package-private */
    public void j(int i2) {
        this.E3 += i2;
    }

    public PdfPTableEvent j0() {
        return this.c3;
    }

    public float j1(int i2, int i4, float f2, float f4, PdfContentByte[] pdfContentByteArr) {
        return m1(0, -1, i2, i4, f2, f4, pdfContentByteArr);
    }

    /* access modifiers changed from: protected */
    public PdfPRow k(int i2, int i4) {
        PdfPRow b0 = b0(i2);
        if (b0.i()) {
            return b0;
        }
        PdfPRow pdfPRow = new PdfPRow(b0);
        PdfPCell[] c2 = pdfPRow.c();
        for (int i5 = 0; i5 < c2.length; i5++) {
            PdfPCell pdfPCell = c2[i5];
            if (!(pdfPCell == null || pdfPCell.g1() == 1)) {
                int min = Math.min(i4, pdfPCell.g1() + i2);
                float f2 = 0.0f;
                for (int i6 = 1 + i2; i6 < min; i6++) {
                    f2 += b0(i6).e();
                }
                pdfPRow.t(i5, f2);
            }
        }
        pdfPRow.q(true);
        return pdfPRow;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.z3;
    }

    public float k1(int i2, int i4, int i5, int i6, float f2, float f4, PdfContentByte pdfContentByte) {
        return l1(i2, i4, i5, i6, f2, f4, pdfContentByte, true);
    }

    public float l0() {
        return this.Y;
    }

    public float l1(int i2, int i4, int i5, int i6, float f2, float f4, PdfContentByte pdfContentByte, boolean z) {
        int i7 = i2;
        int i8 = i4;
        int a0 = a0();
        boolean z2 = false;
        int min = i7 < 0 ? 0 : Math.min(i7, a0);
        int min2 = i8 < 0 ? a0 : Math.min(i8, a0);
        if (!(min == 0 && min2 == a0)) {
            z2 = true;
        }
        if (z2) {
            float f5 = 0.0f;
            int i9 = min;
            float f6 = 0.0f;
            while (true) {
                if (i9 >= min2) {
                    break;
                }
                f6 += this.b3[i9];
                i9++;
            }
            pdfContentByte.a2();
            float f7 = min == 0 ? 10000.0f : 0.0f;
            if (min2 == a0) {
                f5 = 10000.0f;
            }
            pdfContentByte.H1(f2 - f7, -10000.0f, f6 + f7 + f5, 20000.0f);
            pdfContentByte.b0();
            pdfContentByte.x1();
        } else {
            PdfContentByte pdfContentByte2 = pdfContentByte;
        }
        PdfContentByte[] l2 = l(pdfContentByte);
        float n1 = n1(min, min2, i5, i6, f2, f4, l2, z);
        B(l2);
        if (z2) {
            pdfContentByte.U1();
        }
        return n1;
    }

    public float m() {
        if (this.Z2 <= 0.0f) {
            return 0.0f;
        }
        this.Y = 0.0f;
        for (int i2 = 0; i2 < this.X.size(); i2++) {
            this.Y += d0(i2, true);
        }
        return this.Y;
    }

    public float m0() {
        return this.Z2;
    }

    public float m1(int i2, int i4, int i5, int i6, float f2, float f4, PdfContentByte[] pdfContentByteArr) {
        return n1(i2, i4, i5, i6, f2, f4, pdfContentByteArr, true);
    }

    public boolean n() {
        return false;
    }

    public float n0() {
        return this.e3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float n1(int r21, int r22, int r23, int r24, float r25, float r26, com.itextpdf.text.pdf.PdfContentByte[] r27, boolean r28) {
        /*
            r20 = this;
            r7 = r20
            r0 = r21
            r1 = r22
            r2 = r24
            r8 = 3
            r9 = 1
            float r3 = r7.Z2
            r10 = 0
            r11 = 0
            int r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r3 <= 0) goto L_0x01fd
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r3 = r7.X
            int r3 = r3.size()
            if (r23 >= 0) goto L_0x001c
            r12 = 0
            goto L_0x001e
        L_0x001c:
            r12 = r23
        L_0x001e:
            if (r2 >= 0) goto L_0x0022
        L_0x0020:
            r13 = r3
            goto L_0x0027
        L_0x0022:
            int r3 = java.lang.Math.min(r2, r3)
            goto L_0x0020
        L_0x0027:
            if (r12 < r13) goto L_0x002a
            return r26
        L_0x002a:
            int r14 = r20.a0()
            if (r0 >= 0) goto L_0x0032
            r15 = 0
            goto L_0x0037
        L_0x0032:
            int r0 = java.lang.Math.min(r0, r14)
            r15 = r0
        L_0x0037:
            if (r1 >= 0) goto L_0x003b
            r6 = r14
            goto L_0x0040
        L_0x003b:
            int r0 = java.lang.Math.min(r1, r14)
            r6 = r0
        L_0x0040:
            com.itextpdf.text.log.Logger r0 = r7.s
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r15)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r10] = r1
            r5[r9] = r2
            r1 = 2
            r5[r1] = r3
            r5[r8] = r4
            java.lang.String r1 = "Writing row %s to %s; column %s to %s"
            java.lang.String r1 = java.lang.String.format(r1, r5)
            r0.f(r1)
            boolean r0 = r7.x3
            if (r0 == 0) goto L_0x0071
            r0 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r7.J(r0, r12)
        L_0x0071:
            java.util.ArrayList r5 = r7.f0(r12, r13)
            java.util.Iterator r16 = r5.iterator()
            r0 = 0
            r17 = r26
            r4 = r12
        L_0x007d:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x01b0
            java.lang.Object r1 = r16.next()
            r3 = r1
            com.itextpdf.text.pdf.PdfPRow r3 = (com.itextpdf.text.pdf.PdfPRow) r3
            com.itextpdf.text.pdf.PdfPTableHeader r1 = r20.Q()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r1 = r1.X
            if (r1 == 0) goto L_0x00ad
            com.itextpdf.text.pdf.PdfPTableHeader r1 = r20.Q()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r1 = r1.X
            boolean r1 = r1.contains(r3)
            if (r1 == 0) goto L_0x00ad
            if (r0 != 0) goto L_0x00ad
            com.itextpdf.text.pdf.PdfPTableHeader r0 = r20.Q()
            r1 = r27[r8]
        L_0x00a6:
            com.itextpdf.text.pdf.PdfPTableBody r0 = r7.D0(r0, r1)
        L_0x00aa:
            r18 = r0
            goto L_0x00e7
        L_0x00ad:
            com.itextpdf.text.pdf.PdfPTableBody r1 = r20.F()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r1 = r1.X
            if (r1 == 0) goto L_0x00ca
            com.itextpdf.text.pdf.PdfPTableBody r1 = r20.F()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r1 = r1.X
            boolean r1 = r1.contains(r3)
            if (r1 == 0) goto L_0x00ca
            if (r0 != 0) goto L_0x00ca
            com.itextpdf.text.pdf.PdfPTableBody r0 = r20.F()
            r1 = r27[r8]
            goto L_0x00a6
        L_0x00ca:
            com.itextpdf.text.pdf.PdfPTableFooter r1 = r20.N()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r1 = r1.X
            if (r1 == 0) goto L_0x00aa
            com.itextpdf.text.pdf.PdfPTableFooter r1 = r20.N()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r1 = r1.X
            boolean r1 = r1.contains(r3)
            if (r1 == 0) goto L_0x00aa
            if (r0 != 0) goto L_0x00aa
            com.itextpdf.text.pdf.PdfPTableFooter r0 = r20.N()
            r1 = r27[r8]
            goto L_0x00a6
        L_0x00e7:
            if (r3 == 0) goto L_0x0104
            r0 = r3
            r1 = r15
            r2 = r6
            r21 = r3
            r3 = r25
            r11 = r4
            r4 = r17
            r10 = r5
            r5 = r27
            r19 = r6
            r6 = r28
            r0.B(r1, r2, r3, r4, r5, r6)
            float r0 = r21.e()
            float r17 = r17 - r0
            goto L_0x010a
        L_0x0104:
            r21 = r3
            r11 = r4
            r10 = r5
            r19 = r6
        L_0x010a:
            com.itextpdf.text.pdf.PdfPTableHeader r0 = r20.Q()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r0 = r0.X
            if (r0 == 0) goto L_0x0141
            com.itextpdf.text.pdf.PdfPTableHeader r0 = r20.Q()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r0 = r0.X
            r1 = r21
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0143
            int r0 = r13 + -1
            if (r11 == r0) goto L_0x0136
            com.itextpdf.text.pdf.PdfPTableHeader r0 = r20.Q()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r0 = r0.X
            int r4 = r11 + 1
            java.lang.Object r2 = r10.get(r4)
            boolean r0 = r0.contains(r2)
            if (r0 != 0) goto L_0x0143
        L_0x0136:
            com.itextpdf.text.pdf.PdfPTableHeader r0 = r20.Q()
            r1 = r27[r8]
        L_0x013c:
            com.itextpdf.text.pdf.PdfPTableBody r0 = r7.s(r0, r1)
            goto L_0x01a7
        L_0x0141:
            r1 = r21
        L_0x0143:
            com.itextpdf.text.pdf.PdfPTableBody r0 = r20.F()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r0 = r0.X
            if (r0 == 0) goto L_0x0174
            com.itextpdf.text.pdf.PdfPTableBody r0 = r20.F()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r0 = r0.X
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0174
            int r0 = r13 + -1
            if (r11 == r0) goto L_0x016d
            com.itextpdf.text.pdf.PdfPTableBody r0 = r20.F()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r0 = r0.X
            int r4 = r11 + 1
            java.lang.Object r2 = r10.get(r4)
            boolean r0 = r0.contains(r2)
            if (r0 != 0) goto L_0x0174
        L_0x016d:
            com.itextpdf.text.pdf.PdfPTableBody r0 = r20.F()
            r1 = r27[r8]
            goto L_0x013c
        L_0x0174:
            com.itextpdf.text.pdf.PdfPTableFooter r0 = r20.N()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r0 = r0.X
            if (r0 == 0) goto L_0x01a5
            com.itextpdf.text.pdf.PdfPTableFooter r0 = r20.N()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r0 = r0.X
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x01a5
            int r0 = r13 + -1
            if (r11 == r0) goto L_0x019e
            com.itextpdf.text.pdf.PdfPTableFooter r0 = r20.N()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfPRow> r0 = r0.X
            int r4 = r11 + 1
            java.lang.Object r1 = r10.get(r4)
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x01a5
        L_0x019e:
            com.itextpdf.text.pdf.PdfPTableFooter r0 = r20.N()
            r1 = r27[r8]
            goto L_0x013c
        L_0x01a5:
            r0 = r18
        L_0x01a7:
            int r4 = r11 + 1
            r5 = r10
            r6 = r19
            r10 = 0
            r11 = 0
            goto L_0x007d
        L_0x01b0:
            r10 = r5
            r19 = r6
            com.itextpdf.text.pdf.PdfPTableEvent r0 = r7.c3
            if (r0 == 0) goto L_0x01fc
            if (r15 != 0) goto L_0x01fc
            r0 = r19
            if (r0 != r14) goto L_0x01fc
            int r0 = r13 - r12
            int r0 = r0 + r9
            float[] r3 = new float[r0]
            r0 = 0
            r3[r0] = r26
            r0 = r12
        L_0x01c6:
            if (r0 >= r13) goto L_0x01e1
            java.lang.Object r1 = r10.get(r0)
            com.itextpdf.text.pdf.PdfPRow r1 = (com.itextpdf.text.pdf.PdfPRow) r1
            if (r1 == 0) goto L_0x01d5
            float r1 = r1.e()
            goto L_0x01d6
        L_0x01d5:
            r1 = 0
        L_0x01d6:
            int r2 = r0 - r12
            int r4 = r2 + 1
            r2 = r3[r2]
            float r2 = r2 - r1
            r3[r4] = r2
            int r0 = r0 + r9
            goto L_0x01c6
        L_0x01e1:
            com.itextpdf.text.pdf.PdfPTableEvent r0 = r7.c3
            boolean r1 = r7.q3
            r2 = r25
            float[][] r2 = r7.I(r2, r12, r13, r1)
            boolean r1 = r7.q3
            if (r1 == 0) goto L_0x01f3
            int r1 = r7.d3
            r4 = r1
            goto L_0x01f4
        L_0x01f3:
            r4 = 0
        L_0x01f4:
            r1 = r20
            r5 = r12
            r6 = r27
            r0.b(r1, r2, r3, r4, r5, r6)
        L_0x01fc:
            return r17
        L_0x01fd:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "the.table.width.must.be.greater.than.zero"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r2)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfPTable.n1(int, int, int, int, float, float, com.itextpdf.text.pdf.PdfContentByte[], boolean):float");
    }

    public void o(PdfName pdfName) {
        this.y3 = pdfName;
    }

    public boolean o0(int i2) {
        if (i2 < this.X.size() && b0(i2).g()) {
            return true;
        }
        PdfPRow b0 = i2 > 0 ? b0(i2 - 1) : null;
        if (b0 != null && b0.g()) {
            return true;
        }
        for (int i4 = 0; i4 < a0(); i4++) {
            if (F0(i2 - 1, i4)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void p() {
        float f2 = 0.0f;
        if (this.Z2 > 0.0f) {
            int a0 = a0();
            for (int i2 = 0; i2 < a0; i2++) {
                f2 += this.a3[i2];
            }
            for (int i4 = 0; i4 < a0; i4++) {
                this.b3[i4] = (this.Z2 * this.a3[i4]) / f2;
            }
        }
    }

    public void p0() {
        this.s.f("Initialize row and cell heights");
        Iterator<PdfPRow> it2 = e0().iterator();
        while (it2.hasNext()) {
            PdfPRow next = it2.next();
            if (next != null) {
                next.Z2 = false;
                for (PdfPCell pdfPCell : next.c()) {
                    if (pdfPCell != null) {
                        pdfPCell.u1(0.0f);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public PdfPCell q(int i2, int i4) {
        PdfPCell[] c2 = this.X.get(i2).c();
        for (int i5 = 0; i5 < c2.length; i5++) {
            PdfPCell pdfPCell = c2[i5];
            if (pdfPCell != null && i4 >= i5 && i4 < pdfPCell.J0() + i5) {
                return c2[i5];
            }
        }
        return null;
    }

    public boolean q0() {
        return this.p3[0];
    }

    public PdfObject r(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.z3;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }

    public boolean r0(boolean z) {
        return z ? this.p3[0] : this.p3[1];
    }

    public boolean s0() {
        return this.q3;
    }

    public boolean t(ElementListener elementListener) {
        try {
            return elementListener.b(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public boolean t0() {
        return this.k3;
    }

    public int type() {
        return 23;
    }

    public void u() {
        while (!this.v3) {
            a(this.Y2);
        }
    }

    public boolean u0() {
        return this.w3;
    }

    /* access modifiers changed from: protected */
    public void v(PdfPTable pdfPTable) {
        this.x3 = pdfPTable.x3;
        this.a3 = new float[pdfPTable.a0()];
        this.b3 = new float[pdfPTable.a0()];
        System.arraycopy(pdfPTable.a3, 0, this.a3, 0, a0());
        System.arraycopy(pdfPTable.b3, 0, this.b3, 0, a0());
        this.Z2 = pdfPTable.Z2;
        this.Y = pdfPTable.Y;
        this.X2 = 0;
        this.c3 = pdfPTable.c3;
        this.j3 = pdfPTable.j3;
        PdfPCell pdfPCell = pdfPTable.Y2;
        this.Y2 = pdfPCell instanceof PdfPHeaderCell ? new PdfPHeaderCell((PdfPHeaderCell) pdfPCell) : new PdfPCell(pdfPCell);
        this.Z = new PdfPCell[pdfPTable.Z.length];
        this.i3 = pdfPTable.i3;
        this.l3 = pdfPTable.l3;
        this.n3 = pdfPTable.n3;
        this.m3 = pdfPTable.m3;
        this.d3 = pdfPTable.d3;
        this.u3 = pdfPTable.u3;
        this.k3 = pdfPTable.k3;
        this.p3 = pdfPTable.p3;
        this.q3 = pdfPTable.q3;
        this.e3 = pdfPTable.e3;
        this.r3 = pdfPTable.r3;
        this.g3 = pdfPTable.g3;
        this.h3 = pdfPTable.h3;
        this.f3 = pdfPTable.f3;
        this.s3 = pdfPTable.s3;
        this.t3 = pdfPTable.t3;
        this.w3 = pdfPTable.w3;
        this.A3 = pdfPTable.A3;
        this.y3 = pdfPTable.y3;
        if (pdfPTable.z3 != null) {
            this.z3 = new HashMap<>(pdfPTable.z3);
        }
        this.B3 = pdfPTable.Q();
        this.C3 = pdfPTable.F();
        this.D3 = pdfPTable.N();
    }

    public boolean v0() {
        return this.g3;
    }

    public void w() {
        ArrayList<PdfPRow> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < this.d3; i2++) {
            arrayList.add(this.X.get(i2));
        }
        this.X = arrayList;
        this.Y = 0.0f;
        if (this.Z2 > 0.0f) {
            this.Y = R();
        }
    }

    public boolean w0() {
        return this.h3;
    }

    public boolean x() {
        return true;
    }

    public boolean x0() {
        return this.r3;
    }

    public boolean y() {
        return A(this.X.size() - 1);
    }

    public boolean y0() {
        return this.l3;
    }

    public void z(boolean z) {
        this.t3 = z;
    }

    public void z0(int i2) {
        A0(i2, this.X.size());
    }

    public PdfPTable(int i2) {
        this.s = LoggerFactory.b(PdfPTable.class);
        this.X = new ArrayList<>();
        this.Y = 0.0f;
        this.X2 = 0;
        this.Y2 = new PdfPCell((Phrase) null);
        this.Z2 = 0.0f;
        this.e3 = 80.0f;
        this.f3 = 1;
        this.g3 = false;
        this.h3 = false;
        this.i3 = false;
        this.j3 = 0;
        this.k3 = false;
        this.l3 = true;
        this.p3 = new boolean[]{false, false};
        this.r3 = true;
        this.t3 = true;
        this.v3 = true;
        this.w3 = true;
        this.x3 = true;
        this.y3 = PdfName.Kf;
        this.z3 = null;
        this.A3 = new AccessibleElementId();
        this.B3 = null;
        this.C3 = null;
        this.D3 = null;
        if (i2 > 0) {
            this.a3 = new float[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                this.a3[i4] = 1.0f;
            }
            this.b3 = new float[this.a3.length];
            p();
            this.Z = new PdfPCell[this.b3.length];
            this.s3 = false;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("the.number.of.columns.in.pdfptable.constructor.must.be.greater.than.zero", new Object[0]));
    }

    public PdfPTable(PdfPTable pdfPTable) {
        PdfPCell pdfPCell;
        this.s = LoggerFactory.b(PdfPTable.class);
        this.X = new ArrayList<>();
        this.Y = 0.0f;
        this.X2 = 0;
        this.Y2 = new PdfPCell((Phrase) null);
        this.Z2 = 0.0f;
        this.e3 = 80.0f;
        this.f3 = 1;
        this.g3 = false;
        this.h3 = false;
        this.i3 = false;
        this.j3 = 0;
        this.k3 = false;
        this.l3 = true;
        this.p3 = new boolean[]{false, false};
        this.r3 = true;
        this.t3 = true;
        this.v3 = true;
        this.w3 = true;
        this.x3 = true;
        this.y3 = PdfName.Kf;
        this.z3 = null;
        this.A3 = new AccessibleElementId();
        this.B3 = null;
        this.C3 = null;
        this.D3 = null;
        v(pdfPTable);
        int i2 = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.Z;
            if (i2 < pdfPCellArr.length && (pdfPCell = pdfPTable.Z[i2]) != null) {
                pdfPCellArr[i2] = new PdfPCell(pdfPCell);
                i2++;
            }
        }
        for (int i4 = 0; i4 < pdfPTable.X.size(); i4++) {
            PdfPRow pdfPRow = pdfPTable.X.get(i4);
            if (pdfPRow != null) {
                pdfPRow = new PdfPRow(pdfPRow);
            }
            this.X.add(pdfPRow);
        }
    }

    public PdfPTable(float[] fArr) {
        this.s = LoggerFactory.b(PdfPTable.class);
        this.X = new ArrayList<>();
        this.Y = 0.0f;
        this.X2 = 0;
        this.Y2 = new PdfPCell((Phrase) null);
        this.Z2 = 0.0f;
        this.e3 = 80.0f;
        this.f3 = 1;
        this.g3 = false;
        this.h3 = false;
        this.i3 = false;
        this.j3 = 0;
        this.k3 = false;
        this.l3 = true;
        this.p3 = new boolean[]{false, false};
        this.r3 = true;
        this.t3 = true;
        this.v3 = true;
        this.w3 = true;
        this.x3 = true;
        this.y3 = PdfName.Kf;
        this.z3 = null;
        this.A3 = new AccessibleElementId();
        this.B3 = null;
        this.C3 = null;
        this.D3 = null;
        if (fArr == null) {
            throw new NullPointerException(MessageLocalization.b("the.widths.array.in.pdfptable.constructor.can.not.be.null", new Object[0]));
        } else if (fArr.length != 0) {
            float[] fArr2 = new float[fArr.length];
            this.a3 = fArr2;
            System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
            this.b3 = new float[fArr.length];
            p();
            this.Z = new PdfPCell[this.b3.length];
            this.s3 = false;
        } else {
            throw new IllegalArgumentException(MessageLocalization.b("the.widths.array.in.pdfptable.constructor.can.not.have.zero.length", new Object[0]));
        }
    }
}
