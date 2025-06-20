package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.StrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

public class ShapeStroke implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f17219a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableFloatValue f17220b;

    /* renamed from: c  reason: collision with root package name */
    private final List<AnimatableFloatValue> f17221c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableColorValue f17222d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableIntegerValue f17223e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatableFloatValue f17224f;

    /* renamed from: g  reason: collision with root package name */
    private final LineCapType f17225g;

    /* renamed from: h  reason: collision with root package name */
    private final LineJoinType f17226h;

    /* renamed from: i  reason: collision with root package name */
    private final float f17227i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f17228j;

    /* renamed from: com.airbnb.lottie.model.content.ShapeStroke$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17229a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f17230b;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r0 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17230b = r0
                r1 = 1
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r2 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.BEVEL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f17230b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r3 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.MITER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f17230b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r4 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.ROUND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r3 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f17229a = r3
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType r4 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.BUTT     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f17229a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType r3 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.ROUND     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f17229a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.airbnb.lottie.model.content.ShapeStroke$LineCapType r1 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.content.ShapeStroke.AnonymousClass1.<clinit>():void");
        }
    }

    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap a() {
            int i2 = AnonymousClass1.f17229a[ordinal()];
            if (i2 != 1) {
                return i2 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join a() {
            int i2 = AnonymousClass1.f17230b[ordinal()];
            if (i2 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i2 == 2) {
                return Paint.Join.MITER;
            }
            if (i2 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public ShapeStroke(String str, @Nullable AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, LineCapType lineCapType, LineJoinType lineJoinType, float f2, boolean z) {
        this.f17219a = str;
        this.f17220b = animatableFloatValue;
        this.f17221c = list;
        this.f17222d = animatableColorValue;
        this.f17223e = animatableIntegerValue;
        this.f17224f = animatableFloatValue2;
        this.f17225g = lineCapType;
        this.f17226h = lineJoinType;
        this.f17227i = f2;
        this.f17228j = z;
    }

    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new StrokeContent(lottieDrawable, baseLayer, this);
    }

    public LineCapType b() {
        return this.f17225g;
    }

    public AnimatableColorValue c() {
        return this.f17222d;
    }

    public AnimatableFloatValue d() {
        return this.f17220b;
    }

    public LineJoinType e() {
        return this.f17226h;
    }

    public List<AnimatableFloatValue> f() {
        return this.f17221c;
    }

    public float g() {
        return this.f17227i;
    }

    public String h() {
        return this.f17219a;
    }

    public AnimatableIntegerValue i() {
        return this.f17223e;
    }

    public AnimatableFloatValue j() {
        return this.f17224f;
    }

    public boolean k() {
        return this.f17228j;
    }
}
