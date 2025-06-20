package com.itextpdf.text.pdf.parser;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.CMapAwareDocumentFont;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfContentParser;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfLiteral;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfStream;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

public class PdfContentStreamProcessor {

    /* renamed from: j  reason: collision with root package name */
    public static final String f27003j = "DefaultOperator";

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, ContentOperator> f27004a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ResourceDictionary f27005b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Stack<GraphicsState> f27006c = new Stack<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Matrix f27007d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Matrix f27008e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final RenderListener f27009f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<PdfName, XObjectDoHandler> f27010g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Integer, CMapAwareDocumentFont> f27011h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private final Stack<MarkedContentInfo> f27012i = new Stack<>();

    private static class BeginMarkedContent implements ContentOperator {
        private BeginMarkedContent() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            pdfContentStreamProcessor.w((PdfName) arrayList.get(0), new PdfDictionary());
        }
    }

    private static class BeginMarkedContentDictionary implements ContentOperator {
        private BeginMarkedContentDictionary() {
        }

        private PdfDictionary b(PdfObject pdfObject, ResourceDictionary resourceDictionary) {
            return pdfObject.z() ? (PdfDictionary) pdfObject : resourceDictionary.j0((PdfName) pdfObject);
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            pdfContentStreamProcessor.w((PdfName) arrayList.get(0), b(arrayList.get(1), pdfContentStreamProcessor.f27005b));
        }
    }

    private static class BeginText implements ContentOperator {
        private BeginText() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            Matrix unused = pdfContentStreamProcessor.f27007d = new Matrix();
            Matrix unused2 = pdfContentStreamProcessor.f27008e = pdfContentStreamProcessor.f27007d;
            pdfContentStreamProcessor.x();
        }
    }

    private static class ClipPath implements ContentOperator {

        /* renamed from: a  reason: collision with root package name */
        private int f27013a;

        public ClipPath(int i2) {
            this.f27013a = i2;
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            pdfContentStreamProcessor.y(this.f27013a);
        }
    }

    private static class CloseSubpath implements ContentOperator {
        private CloseSubpath() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            pdfContentStreamProcessor.M(6, (List<Float>) null);
        }
    }

    private static class Curve implements ContentOperator {
        private Curve() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            float a0 = ((PdfNumber) arrayList.get(0)).a0();
            float a02 = ((PdfNumber) arrayList.get(1)).a0();
            float a03 = ((PdfNumber) arrayList.get(2)).a0();
            float a04 = ((PdfNumber) arrayList.get(3)).a0();
            float a05 = ((PdfNumber) arrayList.get(4)).a0();
            float a06 = ((PdfNumber) arrayList.get(5)).a0();
            pdfContentStreamProcessor.M(3, Arrays.asList(new Float[]{Float.valueOf(a0), Float.valueOf(a02), Float.valueOf(a03), Float.valueOf(a04), Float.valueOf(a05), Float.valueOf(a06)}));
        }
    }

    private static class CurveFirstPointDuplicated implements ContentOperator {
        private CurveFirstPointDuplicated() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            float a0 = ((PdfNumber) arrayList.get(0)).a0();
            float a02 = ((PdfNumber) arrayList.get(1)).a0();
            float a03 = ((PdfNumber) arrayList.get(2)).a0();
            float a04 = ((PdfNumber) arrayList.get(3)).a0();
            pdfContentStreamProcessor.M(4, Arrays.asList(new Float[]{Float.valueOf(a0), Float.valueOf(a02), Float.valueOf(a03), Float.valueOf(a04)}));
        }
    }

    private static class CurveFourhPointDuplicated implements ContentOperator {
        private CurveFourhPointDuplicated() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            float a0 = ((PdfNumber) arrayList.get(0)).a0();
            float a02 = ((PdfNumber) arrayList.get(1)).a0();
            float a03 = ((PdfNumber) arrayList.get(2)).a0();
            float a04 = ((PdfNumber) arrayList.get(3)).a0();
            pdfContentStreamProcessor.M(5, Arrays.asList(new Float[]{Float.valueOf(a0), Float.valueOf(a02), Float.valueOf(a03), Float.valueOf(a04)}));
        }
    }

    private static class Do implements ContentOperator {
        private Do() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws IOException {
            pdfContentStreamProcessor.A((PdfName) arrayList.get(0));
        }
    }

    private static class EndMarkedContent implements ContentOperator {
        private EndMarkedContent() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            pdfContentStreamProcessor.B();
        }
    }

    private static class EndPath implements ContentOperator {
        private EndPath() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            pdfContentStreamProcessor.N(0, -1, false);
        }
    }

    private static class EndText implements ContentOperator {
        private EndText() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            Matrix unused = pdfContentStreamProcessor.f27007d = null;
            Matrix unused2 = pdfContentStreamProcessor.f27008e = null;
            pdfContentStreamProcessor.C();
        }
    }

    private static class FormXObjectDoHandler implements XObjectDoHandler {
        private FormXObjectDoHandler() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfStream pdfStream, PdfIndirectReference pdfIndirectReference) {
            PdfDictionary j0 = pdfStream.j0(PdfName.Wd);
            try {
                byte[] b2 = ContentByteUtils.b(pdfStream);
                PdfArray e0 = pdfStream.e0(PdfName.Qa);
                new PushGraphicsState().a(pdfContentStreamProcessor, (PdfLiteral) null, (ArrayList<PdfObject>) null);
                if (e0 != null) {
                    Matrix matrix = new Matrix(e0.J0(0).a0(), e0.J0(1).a0(), e0.J0(2).a0(), e0.J0(3).a0(), e0.J0(4).a0(), e0.J0(5).a0());
                    pdfContentStreamProcessor.J().f26927a = matrix.c(pdfContentStreamProcessor.J().f26927a);
                }
                pdfContentStreamProcessor.Q(b2, j0);
                new PopGraphicsState().a(pdfContentStreamProcessor, (PdfLiteral) null, (ArrayList<PdfObject>) null);
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        }
    }

    private static class IgnoreOperatorContentOperator implements ContentOperator {
        private IgnoreOperatorContentOperator() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
        }
    }

    private static class IgnoreXObjectDoHandler implements XObjectDoHandler {
        private IgnoreXObjectDoHandler() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfStream pdfStream, PdfIndirectReference pdfIndirectReference) {
        }
    }

    private static class ImageXObjectDoHandler implements XObjectDoHandler {
        private ImageXObjectDoHandler() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfStream pdfStream, PdfIndirectReference pdfIndirectReference) {
            pdfContentStreamProcessor.f27009f.c(ImageRenderInfo.b(pdfContentStreamProcessor.J(), pdfIndirectReference, pdfContentStreamProcessor.f27005b.j0(PdfName.w5)));
        }
    }

    private static class LineTo implements ContentOperator {
        private LineTo() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            float a0 = ((PdfNumber) arrayList.get(0)).a0();
            float a02 = ((PdfNumber) arrayList.get(1)).a0();
            pdfContentStreamProcessor.M(2, Arrays.asList(new Float[]{Float.valueOf(a0), Float.valueOf(a02)}));
        }
    }

    private static class ModifyCurrentTransformationMatrix implements ContentOperator {
        private ModifyCurrentTransformationMatrix() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            Matrix matrix = new Matrix(((PdfNumber) arrayList.get(0)).a0(), ((PdfNumber) arrayList.get(1)).a0(), ((PdfNumber) arrayList.get(2)).a0(), ((PdfNumber) arrayList.get(3)).a0(), ((PdfNumber) arrayList.get(4)).a0(), ((PdfNumber) arrayList.get(5)).a0());
            GraphicsState graphicsState = (GraphicsState) pdfContentStreamProcessor.f27006c.peek();
            graphicsState.f26927a = matrix.c(graphicsState.f26927a);
        }
    }

    private static class MoveNextLineAndShowText implements ContentOperator {

        /* renamed from: a  reason: collision with root package name */
        private final TextMoveNextLine f27014a;

        /* renamed from: b  reason: collision with root package name */
        private final ShowText f27015b;

        public MoveNextLineAndShowText(TextMoveNextLine textMoveNextLine, ShowText showText) {
            this.f27014a = textMoveNextLine;
            this.f27015b = showText;
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            this.f27014a.a(pdfContentStreamProcessor, (PdfLiteral) null, new ArrayList(0));
            this.f27015b.a(pdfContentStreamProcessor, (PdfLiteral) null, arrayList);
        }
    }

    private static class MoveNextLineAndShowTextWithSpacing implements ContentOperator {

        /* renamed from: a  reason: collision with root package name */
        private final SetTextWordSpacing f27016a;

        /* renamed from: b  reason: collision with root package name */
        private final SetTextCharacterSpacing f27017b;

        /* renamed from: c  reason: collision with root package name */
        private final MoveNextLineAndShowText f27018c;

        public MoveNextLineAndShowTextWithSpacing(SetTextWordSpacing setTextWordSpacing, SetTextCharacterSpacing setTextCharacterSpacing, MoveNextLineAndShowText moveNextLineAndShowText) {
            this.f27016a = setTextWordSpacing;
            this.f27017b = setTextCharacterSpacing;
            this.f27018c = moveNextLineAndShowText;
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(0, (PdfNumber) arrayList.get(0));
            this.f27016a.a(pdfContentStreamProcessor, (PdfLiteral) null, arrayList2);
            ArrayList arrayList3 = new ArrayList(1);
            arrayList3.add(0, (PdfNumber) arrayList.get(1));
            this.f27017b.a(pdfContentStreamProcessor, (PdfLiteral) null, arrayList3);
            ArrayList arrayList4 = new ArrayList(1);
            arrayList4.add(0, (PdfString) arrayList.get(2));
            this.f27018c.a(pdfContentStreamProcessor, (PdfLiteral) null, arrayList4);
        }
    }

    private static class MoveTo implements ContentOperator {
        private MoveTo() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            float a0 = ((PdfNumber) arrayList.get(0)).a0();
            float a02 = ((PdfNumber) arrayList.get(1)).a0();
            pdfContentStreamProcessor.M(1, Arrays.asList(new Float[]{Float.valueOf(a0), Float.valueOf(a02)}));
        }
    }

    private static class PaintPath implements ContentOperator {

        /* renamed from: a  reason: collision with root package name */
        private int f27019a;

        /* renamed from: b  reason: collision with root package name */
        private int f27020b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f27021c;

        public PaintPath(int i2, int i3, boolean z) {
            this.f27019a = i2;
            this.f27020b = i3;
            this.f27021c = z;
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            pdfContentStreamProcessor.N(this.f27019a, this.f27020b, this.f27021c);
        }
    }

    private static class PopGraphicsState implements ContentOperator {
        private PopGraphicsState() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.f27006c.pop();
        }
    }

    private static class ProcessGraphicsStateResource implements ContentOperator {
        private ProcessGraphicsStateResource() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            PdfName pdfName = (PdfName) arrayList.get(0);
            PdfDictionary j0 = pdfContentStreamProcessor.f27005b.j0(PdfName.B7);
            if (j0 != null) {
                PdfDictionary j02 = j0.j0(pdfName);
                if (j02 != null) {
                    PdfArray e0 = j02.e0(PdfName.l8);
                    if (e0 != null) {
                        CMapAwareDocumentFont i2 = pdfContentStreamProcessor.F((PRIndirectReference) e0.T0(0));
                        float a0 = e0.J0(1).a0();
                        pdfContentStreamProcessor.J().f26932f = i2;
                        pdfContentStreamProcessor.J().f26933g = a0;
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(MessageLocalization.b("1.is.an.unknown.graphics.state.dictionary", pdfName));
            }
            throw new IllegalArgumentException(MessageLocalization.b("resources.do.not.contain.extgstate.entry.unable.to.process.operator.1", pdfLiteral));
        }
    }

    private static class PushGraphicsState implements ContentOperator {
        private PushGraphicsState() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.f27006c.push(new GraphicsState((GraphicsState) pdfContentStreamProcessor.f27006c.peek()));
        }
    }

    private static class Rectangle implements ContentOperator {
        private Rectangle() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
            float a0 = ((PdfNumber) arrayList.get(0)).a0();
            float a02 = ((PdfNumber) arrayList.get(1)).a0();
            float a03 = ((PdfNumber) arrayList.get(2)).a0();
            float a04 = ((PdfNumber) arrayList.get(3)).a0();
            pdfContentStreamProcessor.M(7, Arrays.asList(new Float[]{Float.valueOf(a0), Float.valueOf(a02), Float.valueOf(a03), Float.valueOf(a04)}));
        }
    }

    private static class ResourceDictionary extends PdfDictionary {
        private final List<PdfDictionary> p3 = new ArrayList();

        public PdfObject B0(PdfName pdfName) {
            PdfObject B0;
            for (int size = this.p3.size() - 1; size >= 0; size--) {
                PdfDictionary pdfDictionary = this.p3.get(size);
                if (pdfDictionary != null && (B0 = pdfDictionary.B0(pdfName)) != null) {
                    return B0;
                }
            }
            return super.B0(pdfName);
        }

        public void f1() {
            List<PdfDictionary> list = this.p3;
            list.remove(list.size() - 1);
        }

        public void i1(PdfDictionary pdfDictionary) {
            this.p3.add(pdfDictionary);
        }
    }

    private static class SetCMYKFill implements ContentOperator {
        private SetCMYKFill() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26939m = PdfContentStreamProcessor.D(4, arrayList);
        }
    }

    private static class SetCMYKStroke implements ContentOperator {
        private SetCMYKStroke() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26940n = PdfContentStreamProcessor.D(4, arrayList);
        }
    }

    private static class SetColorFill implements ContentOperator {
        private SetColorFill() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26939m = PdfContentStreamProcessor.E(pdfContentStreamProcessor.J().f26937k, arrayList);
        }
    }

    private static class SetColorSpaceFill implements ContentOperator {
        private SetColorSpaceFill() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26937k = (PdfName) arrayList.get(0);
        }
    }

    private static class SetColorSpaceStroke implements ContentOperator {
        private SetColorSpaceStroke() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26938l = (PdfName) arrayList.get(0);
        }
    }

    private static class SetColorStroke implements ContentOperator {
        private SetColorStroke() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26940n = PdfContentStreamProcessor.E(pdfContentStreamProcessor.J().f26938l, arrayList);
        }
    }

    private static class SetGrayFill implements ContentOperator {
        private SetGrayFill() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26939m = PdfContentStreamProcessor.D(1, arrayList);
        }
    }

    private static class SetGrayStroke implements ContentOperator {
        private SetGrayStroke() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26940n = PdfContentStreamProcessor.D(1, arrayList);
        }
    }

    private class SetLineCap implements ContentOperator {
        private SetLineCap() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().t(((PdfNumber) arrayList.get(0)).e0());
        }
    }

    private class SetLineDashPattern implements ContentOperator {
        private SetLineDashPattern() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().u(new LineDashPattern((PdfArray) arrayList.get(0), ((PdfNumber) arrayList.get(1)).a0()));
        }
    }

    private class SetLineJoin implements ContentOperator {
        private SetLineJoin() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().v(((PdfNumber) arrayList.get(0)).e0());
        }
    }

    private static class SetLineWidth implements ContentOperator {
        private SetLineWidth() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().w(((PdfNumber) arrayList.get(0)).a0());
        }
    }

    private class SetMiterLimit implements ContentOperator {
        private SetMiterLimit() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().x(((PdfNumber) arrayList.get(0)).a0());
        }
    }

    private static class SetRGBFill implements ContentOperator {
        private SetRGBFill() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26939m = PdfContentStreamProcessor.D(3, arrayList);
        }
    }

    private static class SetRGBStroke implements ContentOperator {
        private SetRGBStroke() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26940n = PdfContentStreamProcessor.D(3, arrayList);
        }
    }

    private static class SetTextCharacterSpacing implements ContentOperator {
        private SetTextCharacterSpacing() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26928b = ((PdfNumber) arrayList.get(0)).a0();
        }
    }

    private static class SetTextFont implements ContentOperator {
        private SetTextFont() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            float a0 = ((PdfNumber) arrayList.get(1)).a0();
            PdfObject d0 = pdfContentStreamProcessor.f27005b.j0(PdfName.l8).d0((PdfName) arrayList.get(0));
            pdfContentStreamProcessor.J().f26932f = d0 instanceof PdfDictionary ? pdfContentStreamProcessor.G((PdfDictionary) d0) : pdfContentStreamProcessor.F((PRIndirectReference) d0);
            pdfContentStreamProcessor.J().f26933g = a0;
        }
    }

    private static class SetTextHorizontalScaling implements ContentOperator {
        private SetTextHorizontalScaling() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26930d = ((PdfNumber) arrayList.get(0)).a0() / 100.0f;
        }
    }

    private static class SetTextLeading implements ContentOperator {
        private SetTextLeading() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26931e = ((PdfNumber) arrayList.get(0)).a0();
        }
    }

    private static class SetTextRenderMode implements ContentOperator {
        private SetTextRenderMode() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26934h = ((PdfNumber) arrayList.get(0)).e0();
        }
    }

    private static class SetTextRise implements ContentOperator {
        private SetTextRise() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26935i = ((PdfNumber) arrayList.get(0)).a0();
        }
    }

    private static class SetTextWordSpacing implements ContentOperator {
        private SetTextWordSpacing() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.J().f26929c = ((PdfNumber) arrayList.get(0)).a0();
        }
    }

    private static class ShowText implements ContentOperator {
        private ShowText() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            pdfContentStreamProcessor.z((PdfString) arrayList.get(0));
        }
    }

    private static class ShowTextArray implements ContentOperator {
        private ShowTextArray() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            ListIterator<PdfObject> listIterator = ((PdfArray) arrayList.get(0)).listIterator();
            while (listIterator.hasNext()) {
                PdfObject next = listIterator.next();
                if (next instanceof PdfString) {
                    pdfContentStreamProcessor.z((PdfString) next);
                } else {
                    pdfContentStreamProcessor.v(((PdfNumber) next).a0());
                }
            }
        }
    }

    private static class TextMoveNextLine implements ContentOperator {

        /* renamed from: a  reason: collision with root package name */
        private final TextMoveStartNextLine f27026a;

        public TextMoveNextLine(TextMoveStartNextLine textMoveStartNextLine) {
            this.f27026a = textMoveStartNextLine;
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            ArrayList arrayList2 = new ArrayList(2);
            arrayList2.add(0, new PdfNumber(0));
            arrayList2.add(1, new PdfNumber(-pdfContentStreamProcessor.J().f26931e));
            this.f27026a.a(pdfContentStreamProcessor, (PdfLiteral) null, arrayList2);
        }
    }

    private static class TextMoveStartNextLine implements ContentOperator {
        private TextMoveStartNextLine() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            Matrix unused = pdfContentStreamProcessor.f27007d = new Matrix(((PdfNumber) arrayList.get(0)).a0(), ((PdfNumber) arrayList.get(1)).a0()).c(pdfContentStreamProcessor.f27008e);
            Matrix unused2 = pdfContentStreamProcessor.f27008e = pdfContentStreamProcessor.f27007d;
        }
    }

    private static class TextMoveStartNextLineWithLeading implements ContentOperator {

        /* renamed from: a  reason: collision with root package name */
        private final TextMoveStartNextLine f27027a;

        /* renamed from: b  reason: collision with root package name */
        private final SetTextLeading f27028b;

        public TextMoveStartNextLineWithLeading(TextMoveStartNextLine textMoveStartNextLine, SetTextLeading setTextLeading) {
            this.f27027a = textMoveStartNextLine;
            this.f27028b = setTextLeading;
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            float a0 = ((PdfNumber) arrayList.get(1)).a0();
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(0, new PdfNumber(-a0));
            this.f27028b.a(pdfContentStreamProcessor, (PdfLiteral) null, arrayList2);
            this.f27027a.a(pdfContentStreamProcessor, (PdfLiteral) null, arrayList);
        }
    }

    private static class TextSetTextMatrix implements ContentOperator {
        private TextSetTextMatrix() {
        }

        public void a(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) {
            Matrix unused = pdfContentStreamProcessor.f27008e = new Matrix(((PdfNumber) arrayList.get(0)).a0(), ((PdfNumber) arrayList.get(1)).a0(), ((PdfNumber) arrayList.get(2)).a0(), ((PdfNumber) arrayList.get(3)).a0(), ((PdfNumber) arrayList.get(4)).a0(), ((PdfNumber) arrayList.get(5)).a0());
            Matrix unused2 = pdfContentStreamProcessor.f27007d = pdfContentStreamProcessor.f27008e;
        }
    }

    public PdfContentStreamProcessor(RenderListener renderListener) {
        this.f27009f = renderListener;
        this.f27004a = new HashMap();
        O();
        this.f27010g = new HashMap();
        P();
        T();
    }

    /* access modifiers changed from: private */
    public void A(PdfName pdfName) throws IOException {
        PdfDictionary j0 = this.f27005b.j0(PdfName.ai);
        PdfObject B0 = j0.B0(pdfName);
        PdfStream pdfStream = (PdfStream) B0;
        PdfName p0 = pdfStream.p0(PdfName.Cf);
        if (B0.K()) {
            XObjectDoHandler xObjectDoHandler = this.f27010g.get(p0);
            if (xObjectDoHandler == null) {
                xObjectDoHandler = this.f27010g.get(PdfName.p6);
            }
            xObjectDoHandler.a(this, pdfStream, j0.m0(pdfName));
            return;
        }
        throw new IllegalStateException(MessageLocalization.b("XObject.1.is.not.a.stream", pdfName));
    }

    /* access modifiers changed from: private */
    public void B() {
        this.f27012i.pop();
    }

    /* access modifiers changed from: private */
    public void C() {
        this.f27009f.h();
    }

    /* access modifiers changed from: private */
    public static BaseColor D(int i2, List<PdfObject> list) {
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            float a0 = ((PdfNumber) list.get(i3)).a0();
            fArr[i3] = a0;
            if (a0 > 1.0f) {
                fArr[i3] = 1.0f;
            } else if (a0 < 0.0f) {
                fArr[i3] = 0.0f;
            }
        }
        if (i2 == 1) {
            return new GrayColor(fArr[0]);
        }
        if (i2 == 3) {
            return new BaseColor(fArr[0], fArr[1], fArr[2]);
        }
        if (i2 != 4) {
            return null;
        }
        return new CMYKColor(fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    /* access modifiers changed from: private */
    public static BaseColor E(PdfName pdfName, List<PdfObject> list) {
        int i2;
        if (PdfName.A6.equals(pdfName)) {
            i2 = 1;
        } else if (PdfName.B6.equals(pdfName)) {
            i2 = 3;
        } else if (!PdfName.C6.equals(pdfName)) {
            return null;
        } else {
            i2 = 4;
        }
        return D(i2, list);
    }

    /* access modifiers changed from: private */
    public CMapAwareDocumentFont F(PRIndirectReference pRIndirectReference) {
        Integer valueOf = Integer.valueOf(pRIndirectReference.d());
        CMapAwareDocumentFont cMapAwareDocumentFont = this.f27011h.get(valueOf);
        if (cMapAwareDocumentFont != null) {
            return cMapAwareDocumentFont;
        }
        CMapAwareDocumentFont cMapAwareDocumentFont2 = new CMapAwareDocumentFont(pRIndirectReference);
        this.f27011h.put(valueOf, cMapAwareDocumentFont2);
        return cMapAwareDocumentFont2;
    }

    /* access modifiers changed from: private */
    public CMapAwareDocumentFont G(PdfDictionary pdfDictionary) {
        return new CMapAwareDocumentFont(pdfDictionary);
    }

    private void L(PdfLiteral pdfLiteral, ArrayList<PdfObject> arrayList) throws Exception {
        ContentOperator contentOperator = this.f27004a.get(pdfLiteral.toString());
        if (contentOperator == null) {
            contentOperator = this.f27004a.get(f27003j);
        }
        contentOperator.a(this, pdfLiteral, arrayList);
    }

    /* access modifiers changed from: private */
    public void M(int i2, List<Float> list) {
        ((ExtRenderListener) this.f27009f).d(new PathConstructionRenderInfo(i2, list, J().d()));
    }

    /* access modifiers changed from: private */
    public void N(int i2, int i3, boolean z) {
        if (z) {
            M(6, (List<Float>) null);
        }
        ((ExtRenderListener) this.f27009f).f(new PathPaintingRenderInfo(i2, i3, J()));
    }

    private void O() {
        R(f27003j, new IgnoreOperatorContentOperator());
        R(HTML.Tag.C0, new PushGraphicsState());
        R("Q", new PopGraphicsState());
        R("g", new SetGrayFill());
        R("G", new SetGrayStroke());
        R("rg", new SetRGBFill());
        R("RG", new SetRGBStroke());
        R("k", new SetCMYKFill());
        R("K", new SetCMYKStroke());
        R("cs", new SetColorSpaceFill());
        R("CS", new SetColorSpaceStroke());
        R("sc", new SetColorFill());
        R("SC", new SetColorStroke());
        R("scn", new SetColorFill());
        R("SCN", new SetColorStroke());
        R(CSS.Value.j0, new ModifyCurrentTransformationMatrix());
        R("gs", new ProcessGraphicsStateResource());
        SetTextCharacterSpacing setTextCharacterSpacing = new SetTextCharacterSpacing();
        R("Tc", setTextCharacterSpacing);
        SetTextWordSpacing setTextWordSpacing = new SetTextWordSpacing();
        R("Tw", setTextWordSpacing);
        R("Tz", new SetTextHorizontalScaling());
        SetTextLeading setTextLeading = new SetTextLeading();
        R("TL", setTextLeading);
        R("Tf", new SetTextFont());
        R("Tr", new SetTextRenderMode());
        R("Ts", new SetTextRise());
        R("BT", new BeginText());
        R("ET", new EndText());
        R("BMC", new BeginMarkedContent());
        R("BDC", new BeginMarkedContentDictionary());
        R("EMC", new EndMarkedContent());
        TextMoveStartNextLine textMoveStartNextLine = new TextMoveStartNextLine();
        R("Td", textMoveStartNextLine);
        R("TD", new TextMoveStartNextLineWithLeading(textMoveStartNextLine, setTextLeading));
        R("Tm", new TextSetTextMatrix());
        TextMoveNextLine textMoveNextLine = new TextMoveNextLine(textMoveStartNextLine);
        R("T*", textMoveNextLine);
        ShowText showText = new ShowText();
        R("Tj", showText);
        MoveNextLineAndShowText moveNextLineAndShowText = new MoveNextLineAndShowText(textMoveNextLine, showText);
        R("'", moveNextLineAndShowText);
        R("\"", new MoveNextLineAndShowTextWithSpacing(setTextWordSpacing, setTextCharacterSpacing, moveNextLineAndShowText));
        R("TJ", new ShowTextArray());
        R("Do", new Do());
        R("w", new SetLineWidth());
        R("J", new SetLineCap());
        R("j", new SetLineJoin());
        R("M", new SetMiterLimit());
        R("d", new SetLineDashPattern());
        if (this.f27009f instanceof ExtRenderListener) {
            R("m", new MoveTo());
            R(CmcdData.Factory.q, new LineTo());
            R("c", new Curve());
            R("v", new CurveFirstPointDuplicated());
            R("y", new CurveFourhPointDuplicated());
            R(CmcdData.Factory.f12510n, new CloseSubpath());
            R("re", new Rectangle());
            R(ExifInterface.R4, new PaintPath(1, -1, false));
            R("s", new PaintPath(1, -1, true));
            R("f", new PaintPath(2, 1, false));
            R("F", new PaintPath(2, 1, false));
            R("f*", new PaintPath(2, 2, false));
            R("B", new PaintPath(3, 1, false));
            R("B*", new PaintPath(3, 2, false));
            R("b", new PaintPath(3, 1, true));
            R("b*", new PaintPath(3, 2, true));
            R("n", new PaintPath(0, -1, false));
            R(ExifInterface.T4, new ClipPath(1));
            R("W*", new ClipPath(2));
        }
    }

    private void P() {
        S(PdfName.p6, new IgnoreXObjectDoHandler());
        S(PdfName.w8, new FormXObjectDoHandler());
        S(PdfName.F9, new ImageXObjectDoHandler());
    }

    /* access modifiers changed from: private */
    public void v(float f2) {
        this.f27007d = new Matrix(((-f2) / 1000.0f) * J().f26933g * J().f26930d, 0.0f).c(this.f27007d);
    }

    /* access modifiers changed from: private */
    public void w(PdfName pdfName, PdfDictionary pdfDictionary) {
        this.f27012i.push(new MarkedContentInfo(pdfName, pdfDictionary));
    }

    /* access modifiers changed from: private */
    public void x() {
        this.f27009f.a();
    }

    /* access modifiers changed from: private */
    public void y(int i2) {
        ((ExtRenderListener) this.f27009f).b(i2);
    }

    /* access modifiers changed from: private */
    public void z(PdfString pdfString) {
        TextRenderInfo textRenderInfo = new TextRenderInfo(pdfString, J(), this.f27007d, this.f27012i);
        this.f27009f.e(textRenderInfo);
        this.f27007d = new Matrix(textRenderInfo.w(), 0.0f).c(this.f27007d);
    }

    public Collection<String> H() {
        return new ArrayList(this.f27004a.keySet());
    }

    public RenderListener I() {
        return this.f27009f;
    }

    public GraphicsState J() {
        return this.f27006c.peek();
    }

    /* access modifiers changed from: protected */
    public void K(InlineImageInfo inlineImageInfo, PdfDictionary pdfDictionary) {
        this.f27009f.c(ImageRenderInfo.a(J(), inlineImageInfo, pdfDictionary));
    }

    public void Q(byte[] bArr, PdfDictionary pdfDictionary) {
        this.f27005b.i1(pdfDictionary);
        try {
            PdfContentParser pdfContentParser = new PdfContentParser(new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().j(bArr))));
            ArrayList arrayList = new ArrayList();
            while (pdfContentParser.c(arrayList).size() > 0) {
                PdfLiteral pdfLiteral = (PdfLiteral) arrayList.get(arrayList.size() - 1);
                if ("BI".equals(pdfLiteral.toString())) {
                    PdfDictionary j0 = pdfDictionary != null ? pdfDictionary.j0(PdfName.w5) : null;
                    K(InlineImageUtils.e(pdfContentParser, j0), j0);
                } else {
                    L(pdfLiteral, arrayList);
                }
            }
            this.f27005b.f1();
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public ContentOperator R(String str, ContentOperator contentOperator) {
        return this.f27004a.put(str, contentOperator);
    }

    public XObjectDoHandler S(PdfName pdfName, XObjectDoHandler xObjectDoHandler) {
        return this.f27010g.put(pdfName, xObjectDoHandler);
    }

    public void T() {
        this.f27006c.removeAllElements();
        this.f27006c.add(new GraphicsState());
        this.f27007d = null;
        this.f27008e = null;
        this.f27005b = new ResourceDictionary();
    }
}
