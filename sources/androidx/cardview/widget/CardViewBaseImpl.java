package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

class CardViewBaseImpl implements CardViewImpl {

    /* renamed from: a  reason: collision with root package name */
    final RectF f3515a = new RectF();

    CardViewBaseImpl() {
    }

    private RoundRectDrawableWithShadow p(Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f2, f3, f4);
    }

    private RoundRectDrawableWithShadow q(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.f();
    }

    public void a(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        RoundRectDrawableWithShadow p = p(context, colorStateList, f2, f3, f4);
        p.m(cardViewDelegate.d());
        cardViewDelegate.c(p);
        i(cardViewDelegate);
    }

    public void b(CardViewDelegate cardViewDelegate, float f2) {
        q(cardViewDelegate).p(f2);
        i(cardViewDelegate);
    }

    public float c(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).l();
    }

    public float d(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).g();
    }

    public void e(CardViewDelegate cardViewDelegate) {
    }

    public void f(CardViewDelegate cardViewDelegate, float f2) {
        q(cardViewDelegate).r(f2);
    }

    public float g(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).i();
    }

    public ColorStateList h(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).f();
    }

    public void i(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        q(cardViewDelegate).h(rect);
        cardViewDelegate.b((int) Math.ceil((double) l(cardViewDelegate)), (int) Math.ceil((double) k(cardViewDelegate)));
        cardViewDelegate.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void j() {
        RoundRectDrawableWithShadow.s = new RoundRectDrawableWithShadow.RoundRectHelper() {
            public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
                Canvas canvas2 = canvas;
                RectF rectF2 = rectF;
                float f3 = 2.0f * f2;
                float width = (rectF.width() - f3) - 1.0f;
                float height = (rectF.height() - f3) - 1.0f;
                if (f2 >= 1.0f) {
                    float f4 = f2 + 0.5f;
                    float f5 = -f4;
                    CardViewBaseImpl.this.f3515a.set(f5, f5, f4, f4);
                    int save = canvas.save();
                    canvas2.translate(rectF2.left + f4, rectF2.top + f4);
                    Paint paint2 = paint;
                    canvas.drawArc(CardViewBaseImpl.this.f3515a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f3515a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(height, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f3515a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f3515a, 180.0f, 90.0f, true, paint2);
                    canvas2.restoreToCount(save);
                    float f6 = rectF2.top;
                    canvas.drawRect((rectF2.left + f4) - 1.0f, f6, (rectF2.right - f4) + 1.0f, f6 + f4, paint2);
                    float f7 = rectF2.bottom;
                    Canvas canvas3 = canvas;
                    canvas3.drawRect((rectF2.left + f4) - 1.0f, f7 - f4, (rectF2.right - f4) + 1.0f, f7, paint2);
                }
                canvas.drawRect(rectF2.left, rectF2.top + f2, rectF2.right, rectF2.bottom - f2, paint);
            }
        };
    }

    public float k(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).j();
    }

    public float l(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).k();
    }

    public void m(CardViewDelegate cardViewDelegate) {
        q(cardViewDelegate).m(cardViewDelegate.d());
        i(cardViewDelegate);
    }

    public void n(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
        q(cardViewDelegate).o(colorStateList);
    }

    public void o(CardViewDelegate cardViewDelegate, float f2) {
        q(cardViewDelegate).q(f2);
        i(cardViewDelegate);
    }
}
