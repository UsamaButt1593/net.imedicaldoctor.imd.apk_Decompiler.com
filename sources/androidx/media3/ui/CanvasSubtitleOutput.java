package androidx.media3.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.media3.common.text.Cue;
import androidx.media3.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class CanvasSubtitleOutput extends View implements SubtitleView.Output {
    private List<Cue> X2;
    private int Y2;
    private float Z2;
    private CaptionStyleCompat a3;
    private float b3;
    private final List<SubtitlePainter> s;

    public CanvasSubtitleOutput(Context context) {
        this(context, (AttributeSet) null);
    }

    private static Cue b(Cue cue) {
        Cue.Builder B = cue.b().w(-3.4028235E38f).x(Integer.MIN_VALUE).B((Layout.Alignment) null);
        if (cue.Y2 == 0) {
            B.t(1.0f - cue.X2, 0);
        } else {
            B.t((-cue.X2) - 1.0f, 1);
        }
        int i2 = cue.Z2;
        if (i2 == 0) {
            B.u(2);
        } else if (i2 == 2) {
            B.u(0);
        }
        return B.a();
    }

    public void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f2, int i2, float f3) {
        this.X2 = list;
        this.a3 = captionStyleCompat;
        this.Z2 = f2;
        this.Y2 = i2;
        this.b3 = f3;
        while (this.s.size() < list.size()) {
            this.s.add(new SubtitlePainter(getContext()));
        }
        invalidate();
    }

    public void dispatchDraw(Canvas canvas) {
        List<Cue> list = this.X2;
        if (!list.isEmpty()) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int paddingBottom = height - getPaddingBottom();
            if (paddingBottom > paddingTop && width > paddingLeft) {
                int i2 = paddingBottom - paddingTop;
                float h2 = SubtitleViewUtils.h(this.Y2, this.Z2, height, i2);
                if (h2 > 0.0f) {
                    int size = list.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Cue cue = list.get(i3);
                        if (cue.i3 != Integer.MIN_VALUE) {
                            cue = b(cue);
                        }
                        Cue cue2 = cue;
                        float f2 = h2;
                        int i4 = paddingBottom;
                        this.s.get(i3).b(cue2, this.a3, f2, SubtitleViewUtils.h(cue2.g3, cue2.h3, height, i2), this.b3, canvas, paddingLeft, paddingTop, width, i4);
                        i3++;
                        size = size;
                        i2 = i2;
                        paddingBottom = i4;
                        width = width;
                    }
                }
            }
        }
    }

    public CanvasSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = new ArrayList();
        this.X2 = Collections.emptyList();
        this.Y2 = 0;
        this.Z2 = 0.0533f;
        this.a3 = CaptionStyleCompat.f14618m;
        this.b3 = 0.08f;
    }
}
