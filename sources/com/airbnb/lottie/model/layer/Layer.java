package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class Layer {

    /* renamed from: a  reason: collision with root package name */
    private final List<ContentModel> f17255a;

    /* renamed from: b  reason: collision with root package name */
    private final LottieComposition f17256b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17257c;

    /* renamed from: d  reason: collision with root package name */
    private final long f17258d;

    /* renamed from: e  reason: collision with root package name */
    private final LayerType f17259e;

    /* renamed from: f  reason: collision with root package name */
    private final long f17260f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final String f17261g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Mask> f17262h;

    /* renamed from: i  reason: collision with root package name */
    private final AnimatableTransform f17263i;

    /* renamed from: j  reason: collision with root package name */
    private final int f17264j;

    /* renamed from: k  reason: collision with root package name */
    private final int f17265k;

    /* renamed from: l  reason: collision with root package name */
    private final int f17266l;

    /* renamed from: m  reason: collision with root package name */
    private final float f17267m;

    /* renamed from: n  reason: collision with root package name */
    private final float f17268n;
    private final int o;
    private final int p;
    @Nullable
    private final AnimatableTextFrame q;
    @Nullable
    private final AnimatableTextProperties r;
    @Nullable
    private final AnimatableFloatValue s;
    private final List<Keyframe<Float>> t;
    private final MatteType u;
    private final boolean v;

    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j2, LayerType layerType, long j3, @Nullable String str2, List<Mask> list2, AnimatableTransform animatableTransform, int i2, int i3, int i4, float f2, float f3, int i5, int i6, @Nullable AnimatableTextFrame animatableTextFrame, @Nullable AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType, @Nullable AnimatableFloatValue animatableFloatValue, boolean z) {
        this.f17255a = list;
        this.f17256b = lottieComposition;
        this.f17257c = str;
        this.f17258d = j2;
        this.f17259e = layerType;
        this.f17260f = j3;
        this.f17261g = str2;
        this.f17262h = list2;
        this.f17263i = animatableTransform;
        this.f17264j = i2;
        this.f17265k = i3;
        this.f17266l = i4;
        this.f17267m = f2;
        this.f17268n = f3;
        this.o = i5;
        this.p = i6;
        this.q = animatableTextFrame;
        this.r = animatableTextProperties;
        this.t = list3;
        this.u = matteType;
        this.s = animatableFloatValue;
        this.v = z;
    }

    /* access modifiers changed from: package-private */
    public LottieComposition a() {
        return this.f17256b;
    }

    public long b() {
        return this.f17258d;
    }

    /* access modifiers changed from: package-private */
    public List<Keyframe<Float>> c() {
        return this.t;
    }

    public LayerType d() {
        return this.f17259e;
    }

    /* access modifiers changed from: package-private */
    public List<Mask> e() {
        return this.f17262h;
    }

    /* access modifiers changed from: package-private */
    public MatteType f() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return this.f17257c;
    }

    /* access modifiers changed from: package-private */
    public long h() {
        return this.f17260f;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String k() {
        return this.f17261g;
    }

    /* access modifiers changed from: package-private */
    public List<ContentModel> l() {
        return this.f17255a;
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return this.f17266l;
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.f17265k;
    }

    /* access modifiers changed from: package-private */
    public int o() {
        return this.f17264j;
    }

    /* access modifiers changed from: package-private */
    public float p() {
        return this.f17268n / this.f17256b.e();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public AnimatableTextFrame q() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public AnimatableTextProperties r() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public AnimatableFloatValue s() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public float t() {
        return this.f17267m;
    }

    public String toString() {
        return w("");
    }

    /* access modifiers changed from: package-private */
    public AnimatableTransform u() {
        return this.f17263i;
    }

    public boolean v() {
        return this.v;
    }

    public String w(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append(StringUtils.LF);
        Layer v2 = this.f17256b.v(h());
        if (v2 != null) {
            String str2 = "\t\tParents: ";
            while (true) {
                sb.append(str2);
                sb.append(v2.g());
                v2 = this.f17256b.v(v2.h());
                if (v2 == null) {
                    break;
                }
                str2 = "->";
            }
            sb.append(str);
            sb.append(StringUtils.LF);
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append(StringUtils.LF);
        }
        if (!(o() == 0 || n() == 0)) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())}));
        }
        if (!this.f17255a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (ContentModel next : this.f17255a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(next);
                sb.append(StringUtils.LF);
            }
        }
        return sb.toString();
    }
}
