package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class TextLayer extends BaseLayer {
    private final StringBuilder B = new StringBuilder(2);
    private final RectF C = new RectF();
    private final Matrix D = new Matrix();
    private final Paint E = new Paint(1) {
        {
            setStyle(Paint.Style.FILL);
        }
    };
    private final Paint F = new Paint(1) {
        {
            setStyle(Paint.Style.STROKE);
        }
    };
    private final Map<FontCharacter, List<ContentGroup>> G = new HashMap();
    private final LongSparseArray<String> H = new LongSparseArray<>();
    private final TextKeyframeAnimation I;
    private final LottieDrawable J;
    private final LottieComposition K;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> L;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> M;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> N;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> O;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> P;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> Q;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> R;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> S;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> T;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> U;

    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17271a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.airbnb.lottie.model.DocumentData$Justification[] r0 = com.airbnb.lottie.model.DocumentData.Justification.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17271a = r0
                com.airbnb.lottie.model.DocumentData$Justification r1 = com.airbnb.lottie.model.DocumentData.Justification.LEFT_ALIGN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f17271a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.DocumentData$Justification r1 = com.airbnb.lottie.model.DocumentData.Justification.RIGHT_ALIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f17271a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.DocumentData$Justification r1 = com.airbnb.lottie.model.DocumentData.Justification.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.TextLayer.AnonymousClass3.<clinit>():void");
        }
    }

    TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableColorValue animatableColorValue;
        AnimatableColorValue animatableColorValue2;
        this.J = lottieDrawable;
        this.K = layer.a();
        TextKeyframeAnimation d2 = layer.q().a();
        this.I = d2;
        d2.a(this);
        i(d2);
        AnimatableTextProperties r = layer.r();
        if (!(r == null || (animatableColorValue2 = r.f17132a) == null)) {
            BaseKeyframeAnimation<Integer, Integer> a2 = animatableColorValue2.a();
            this.L = a2;
            a2.a(this);
            i(this.L);
        }
        if (!(r == null || (animatableColorValue = r.f17133b) == null)) {
            BaseKeyframeAnimation<Integer, Integer> a3 = animatableColorValue.a();
            this.N = a3;
            a3.a(this);
            i(this.N);
        }
        if (!(r == null || (animatableFloatValue2 = r.f17134c) == null)) {
            BaseKeyframeAnimation<Float, Float> a4 = animatableFloatValue2.a();
            this.P = a4;
            a4.a(this);
            i(this.P);
        }
        if (r != null && (animatableFloatValue = r.f17135d) != null) {
            BaseKeyframeAnimation<Float, Float> a5 = animatableFloatValue.a();
            this.R = a5;
            a5.a(this);
            i(this.R);
        }
    }

    private void J(DocumentData.Justification justification, Canvas canvas, float f2) {
        float f3;
        int i2 = AnonymousClass3.f17271a[justification.ordinal()];
        if (i2 == 2) {
            f3 = -f2;
        } else if (i2 == 3) {
            f3 = (-f2) / 2.0f;
        } else {
            return;
        }
        canvas.translate(f3, 0.0f);
    }

    private String K(String str, int i2) {
        int codePointAt = str.codePointAt(i2);
        int charCount = Character.charCount(codePointAt) + i2;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!W(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j2 = (long) codePointAt;
        if (this.H.d(j2)) {
            return this.H.h(j2);
        }
        this.B.setLength(0);
        while (i2 < charCount) {
            int codePointAt3 = str.codePointAt(i2);
            this.B.appendCodePoint(codePointAt3);
            i2 += Character.charCount(codePointAt3);
        }
        String sb = this.B.toString();
        this.H.p(j2, sb);
        return sb;
    }

    private void L(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
            }
        }
    }

    private void M(FontCharacter fontCharacter, Matrix matrix, float f2, DocumentData documentData, Canvas canvas) {
        Paint paint;
        List<ContentGroup> T2 = T(fontCharacter);
        for (int i2 = 0; i2 < T2.size(); i2++) {
            Path path = T2.get(i2).getPath();
            path.computeBounds(this.C, false);
            this.D.set(matrix);
            this.D.preTranslate(0.0f, (-documentData.f17103g) * Utils.e());
            this.D.preScale(f2, f2);
            path.transform(this.D);
            if (documentData.f17107k) {
                P(path, this.E, canvas);
                paint = this.F;
            } else {
                P(path, this.F, canvas);
                paint = this.E;
            }
            P(path, paint, canvas);
        }
    }

    private void N(String str, DocumentData documentData, Canvas canvas) {
        Paint paint;
        if (documentData.f17107k) {
            L(str, this.E, canvas);
            paint = this.F;
        } else {
            L(str, this.F, canvas);
            paint = this.E;
        }
        L(str, paint, canvas);
    }

    private void O(String str, DocumentData documentData, Canvas canvas, float f2) {
        int i2 = 0;
        while (i2 < str.length()) {
            String K2 = K(str, i2);
            i2 += K2.length();
            N(K2, documentData, canvas);
            float measureText = this.E.measureText(K2, 0, 1);
            float f3 = ((float) documentData.f17101e) / 10.0f;
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.S;
            if (baseKeyframeAnimation != null || (baseKeyframeAnimation = this.R) != null) {
                f3 += baseKeyframeAnimation.h().floatValue();
            }
            canvas.translate(measureText + (f3 * f2), 0.0f);
        }
    }

    private void P(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void Q(String str, DocumentData documentData, Matrix matrix, Font font, Canvas canvas, float f2, float f3) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            FontCharacter h2 = this.K.c().h(FontCharacter.e(str.charAt(i2), font.b(), font.d()));
            if (h2 != null) {
                M(h2, matrix, f3, documentData, canvas);
                float d2 = ((float) h2.d()) * f3 * Utils.e() * f2;
                float f4 = ((float) documentData.f17101e) / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.S;
                if (!(baseKeyframeAnimation == null && (baseKeyframeAnimation = this.R) == null)) {
                    f4 += baseKeyframeAnimation.h().floatValue();
                }
                canvas.translate(d2 + (f4 * f2), 0.0f);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
        r0 = r8.T;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void R(com.airbnb.lottie.model.DocumentData r18, android.graphics.Matrix r19, com.airbnb.lottie.model.Font r20, android.graphics.Canvas r21) {
        /*
            r17 = this;
            r8 = r17
            r9 = r18
            r10 = r21
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r0 = r8.U
            if (r0 == 0) goto L_0x0015
        L_0x000a:
            java.lang.Object r0 = r0.h()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L_0x001c
        L_0x0015:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r0 = r8.T
            if (r0 == 0) goto L_0x001a
            goto L_0x000a
        L_0x001a:
            float r0 = r9.f17099c
        L_0x001c:
            r1 = 1120403456(0x42c80000, float:100.0)
            float r11 = r0 / r1
            float r12 = com.airbnb.lottie.utils.Utils.g(r19)
            java.lang.String r0 = r9.f17097a
            float r1 = r9.f17102f
            float r2 = com.airbnb.lottie.utils.Utils.e()
            float r13 = r1 * r2
            java.util.List r14 = r8.V(r0)
            int r15 = r14.size()
            r0 = 0
            r7 = 0
        L_0x0038:
            if (r7 >= r15) goto L_0x0076
            java.lang.Object r0 = r14.get(r7)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            r6 = r20
            float r0 = r8.U(r1, r6, r11, r12)
            r21.save()
            com.airbnb.lottie.model.DocumentData$Justification r2 = r9.f17100d
            r8.J(r2, r10, r0)
            int r0 = r15 + -1
            float r0 = (float) r0
            float r0 = r0 * r13
            r2 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r2
            float r2 = (float) r7
            float r2 = r2 * r13
            float r2 = r2 - r0
            r0 = 0
            r10.translate(r0, r2)
            r0 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r12
            r16 = r7
            r7 = r11
            r0.Q(r1, r2, r3, r4, r5, r6, r7)
            r21.restore()
            int r7 = r16 + 1
            goto L_0x0038
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.TextLayer.R(com.airbnb.lottie.model.DocumentData, android.graphics.Matrix, com.airbnb.lottie.model.Font, android.graphics.Canvas):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        r9 = r7.T;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void S(com.airbnb.lottie.model.DocumentData r8, com.airbnb.lottie.model.Font r9, android.graphics.Matrix r10, android.graphics.Canvas r11) {
        /*
            r7 = this;
            float r0 = com.airbnb.lottie.utils.Utils.g(r10)
            com.airbnb.lottie.LottieDrawable r1 = r7.J
            java.lang.String r2 = r9.b()
            java.lang.String r9 = r9.d()
            android.graphics.Typeface r9 = r1.K(r2, r9)
            if (r9 != 0) goto L_0x0015
            return
        L_0x0015:
            java.lang.String r1 = r8.f17097a
            com.airbnb.lottie.LottieDrawable r2 = r7.J
            com.airbnb.lottie.TextDelegate r2 = r2.J()
            if (r2 == 0) goto L_0x0023
            java.lang.String r1 = r2.b(r1)
        L_0x0023:
            android.graphics.Paint r2 = r7.E
            r2.setTypeface(r9)
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r9 = r7.U
            if (r9 == 0) goto L_0x0037
        L_0x002c:
            java.lang.Object r9 = r9.h()
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
            goto L_0x003e
        L_0x0037:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r9 = r7.T
            if (r9 == 0) goto L_0x003c
            goto L_0x002c
        L_0x003c:
            float r9 = r8.f17099c
        L_0x003e:
            android.graphics.Paint r2 = r7.E
            float r3 = com.airbnb.lottie.utils.Utils.e()
            float r9 = r9 * r3
            r2.setTextSize(r9)
            android.graphics.Paint r9 = r7.F
            android.graphics.Paint r2 = r7.E
            android.graphics.Typeface r2 = r2.getTypeface()
            r9.setTypeface(r2)
            android.graphics.Paint r9 = r7.F
            android.graphics.Paint r2 = r7.E
            float r2 = r2.getTextSize()
            r9.setTextSize(r2)
            float r9 = r8.f17102f
            float r2 = com.airbnb.lottie.utils.Utils.e()
            float r9 = r9 * r2
            java.util.List r1 = r7.V(r1)
            int r2 = r1.size()
            r3 = 0
        L_0x0070:
            if (r3 >= r2) goto L_0x009c
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            android.graphics.Paint r5 = r7.F
            float r5 = r5.measureText(r4)
            com.airbnb.lottie.model.DocumentData$Justification r6 = r8.f17100d
            r7.J(r6, r11, r5)
            int r5 = r2 + -1
            float r5 = (float) r5
            float r5 = r5 * r9
            r6 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r6
            float r6 = (float) r3
            float r6 = r6 * r9
            float r6 = r6 - r5
            r5 = 0
            r11.translate(r5, r6)
            r7.O(r4, r8, r11, r0)
            r11.setMatrix(r10)
            int r3 = r3 + 1
            goto L_0x0070
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.TextLayer.S(com.airbnb.lottie.model.DocumentData, com.airbnb.lottie.model.Font, android.graphics.Matrix, android.graphics.Canvas):void");
    }

    private List<ContentGroup> T(FontCharacter fontCharacter) {
        if (this.G.containsKey(fontCharacter)) {
            return this.G.get(fontCharacter);
        }
        List<ShapeGroup> a2 = fontCharacter.a();
        int size = a2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new ContentGroup(this.J, this, a2.get(i2)));
        }
        this.G.put(fontCharacter, arrayList);
        return arrayList;
    }

    private float U(String str, Font font, float f2, float f3) {
        float f4 = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            FontCharacter h2 = this.K.c().h(FontCharacter.e(str.charAt(i2), font.b(), font.d()));
            if (h2 != null) {
                f4 = (float) (((double) f4) + (h2.d() * ((double) f2) * ((double) Utils.e()) * ((double) f3)));
            }
        }
        return f4;
    }

    private List<String> V(String str) {
        return Arrays.asList(str.replaceAll("\r\n", StringUtils.CR).replaceAll(StringUtils.LF, StringUtils.CR).split(StringUtils.CR));
    }

    private boolean W(int i2) {
        return Character.getType(i2) == 16 || Character.getType(i2) == 27 || Character.getType(i2) == 6 || Character.getType(i2) == 28 || Character.getType(i2) == 19;
    }

    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, (float) this.K.b().width(), (float) this.K.b().height());
    }

    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation baseKeyframeAnimation;
        super.g(t, lottieValueCallback);
        if (t == LottieProperty.f16747a) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.M;
            if (baseKeyframeAnimation2 != null) {
                C(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.M = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.M = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            baseKeyframeAnimation = this.M;
        } else if (t == LottieProperty.f16748b) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.O;
            if (baseKeyframeAnimation3 != null) {
                C(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.O = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.O = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            baseKeyframeAnimation = this.O;
        } else if (t == LottieProperty.o) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.Q;
            if (baseKeyframeAnimation4 != null) {
                C(baseKeyframeAnimation4);
            }
            if (lottieValueCallback == null) {
                this.Q = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.Q = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.a(this);
            baseKeyframeAnimation = this.Q;
        } else if (t == LottieProperty.p) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.S;
            if (baseKeyframeAnimation5 != null) {
                C(baseKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.S = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.S = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.a(this);
            baseKeyframeAnimation = this.S;
        } else if (t == LottieProperty.B) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.U;
            if (baseKeyframeAnimation6 != null) {
                C(baseKeyframeAnimation6);
            }
            if (lottieValueCallback == null) {
                this.U = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.U = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.a(this);
            baseKeyframeAnimation = this.U;
        } else {
            return;
        }
        i(baseKeyframeAnimation);
    }

    /* access modifiers changed from: package-private */
    public void t(Canvas canvas, Matrix matrix, int i2) {
        canvas.save();
        if (!this.J.D0()) {
            canvas.setMatrix(matrix);
        }
        DocumentData documentData = (DocumentData) this.I.h();
        Font font = this.K.g().get(documentData.f17098b);
        if (font == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.M;
        if (baseKeyframeAnimation == null && (baseKeyframeAnimation = this.L) == null) {
            this.E.setColor(documentData.f17104h);
        } else {
            this.E.setColor(baseKeyframeAnimation.h().intValue());
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.O;
        if (baseKeyframeAnimation2 == null && (baseKeyframeAnimation2 = this.N) == null) {
            this.F.setColor(documentData.f17105i);
        } else {
            this.F.setColor(baseKeyframeAnimation2.h().intValue());
        }
        int intValue = ((this.v.h() == null ? 100 : this.v.h().h().intValue()) * 255) / 100;
        this.E.setAlpha(intValue);
        this.F.setAlpha(intValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.Q;
        if (baseKeyframeAnimation3 == null && (baseKeyframeAnimation3 = this.P) == null) {
            this.F.setStrokeWidth(documentData.f17106j * Utils.e() * Utils.g(matrix));
        } else {
            this.F.setStrokeWidth(baseKeyframeAnimation3.h().floatValue());
        }
        if (this.J.D0()) {
            R(documentData, matrix, font, canvas);
        } else {
            S(documentData, font, matrix, canvas);
        }
        canvas.restore();
    }
}
