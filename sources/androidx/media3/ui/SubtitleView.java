package androidx.media3.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.Nullable;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
public final class SubtitleView extends FrameLayout {
    public static final float g3 = 0.0533f;
    public static final float h3 = 0.08f;
    public static final int i3 = 1;
    public static final int j3 = 2;
    private CaptionStyleCompat X2;
    private int Y2;
    private float Z2;
    private float a3;
    private boolean b3;
    private boolean c3;
    private int d3;
    private Output e3;
    private View f3;
    private List<Cue> s;

    interface Output {
        void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f2, int i2, float f3);
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewType {
    }

    public SubtitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    private Cue a(Cue cue) {
        Cue.Builder b2 = cue.b();
        if (!this.b3) {
            SubtitleViewUtils.e(b2);
        } else if (!this.c3) {
            SubtitleViewUtils.f(b2);
        }
        return b2.a();
    }

    private void d(int i2, float f2) {
        this.Y2 = i2;
        this.Z2 = f2;
        g();
    }

    private void g() {
        this.e3.a(getCuesWithStylingPreferencesApplied(), this.X2, this.Z2, this.Y2, this.a3);
    }

    private List<Cue> getCuesWithStylingPreferencesApplied() {
        if (this.b3 && this.c3) {
            return this.s;
        }
        ArrayList arrayList = new ArrayList(this.s.size());
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            arrayList.add(a(this.s.get(i2)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (Util.f9646a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private CaptionStyleCompat getUserCaptionStyle() {
        if (Util.f9646a < 19 || isInEditMode()) {
            return CaptionStyleCompat.f14618m;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? CaptionStyleCompat.f14618m : CaptionStyleCompat.a(captioningManager.getUserStyle());
    }

    private <T extends View & Output> void setView(T t) {
        removeView(this.f3);
        View view = this.f3;
        if (view instanceof WebViewSubtitleOutput) {
            ((WebViewSubtitleOutput) view).g();
        }
        this.f3 = t;
        this.e3 = (Output) t;
        addView(t);
    }

    public void b(@Dimension int i2, float f2) {
        Context context = getContext();
        d(2, TypedValue.applyDimension(i2, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public void c(float f2, boolean z) {
        d(z ? 1 : 0, f2);
    }

    public void e() {
        setStyle(getUserCaptionStyle());
    }

    public void f() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.c3 = z;
        g();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.b3 = z;
        g();
    }

    public void setBottomPaddingFraction(float f2) {
        this.a3 = f2;
        g();
    }

    public void setCues(@Nullable List<Cue> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.s = list;
        g();
    }

    public void setFractionalTextSize(float f2) {
        c(f2, false);
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        this.X2 = captionStyleCompat;
        g();
    }

    public void setViewType(int i2) {
        View canvasSubtitleOutput;
        if (this.d3 != i2) {
            if (i2 == 1) {
                canvasSubtitleOutput = new CanvasSubtitleOutput(getContext());
            } else if (i2 == 2) {
                canvasSubtitleOutput = new WebViewSubtitleOutput(getContext());
            } else {
                throw new IllegalArgumentException();
            }
            setView(canvasSubtitleOutput);
            this.d3 = i2;
        }
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = Collections.emptyList();
        this.X2 = CaptionStyleCompat.f14618m;
        this.Y2 = 0;
        this.Z2 = 0.0533f;
        this.a3 = 0.08f;
        this.b3 = true;
        this.c3 = true;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context);
        this.e3 = canvasSubtitleOutput;
        this.f3 = canvasSubtitleOutput;
        addView(canvasSubtitleOutput);
        this.d3 = 1;
    }
}
