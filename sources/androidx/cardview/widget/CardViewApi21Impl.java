package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class CardViewApi21Impl implements CardViewImpl {
    CardViewApi21Impl() {
    }

    private RoundRectDrawable p(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) cardViewDelegate.f();
    }

    public void a(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        cardViewDelegate.c(new RoundRectDrawable(colorStateList, f2));
        View g2 = cardViewDelegate.g();
        g2.setClipToOutline(true);
        g2.setElevation(f3);
        o(cardViewDelegate, f4);
    }

    public void b(CardViewDelegate cardViewDelegate, float f2) {
        p(cardViewDelegate).h(f2);
    }

    public float c(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.g().getElevation();
    }

    public float d(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).d();
    }

    public void e(CardViewDelegate cardViewDelegate) {
        o(cardViewDelegate, g(cardViewDelegate));
    }

    public void f(CardViewDelegate cardViewDelegate, float f2) {
        cardViewDelegate.g().setElevation(f2);
    }

    public float g(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).c();
    }

    public ColorStateList h(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).b();
    }

    public void i(CardViewDelegate cardViewDelegate) {
        if (!cardViewDelegate.e()) {
            cardViewDelegate.a(0, 0, 0, 0);
            return;
        }
        float g2 = g(cardViewDelegate);
        float d2 = d(cardViewDelegate);
        int ceil = (int) Math.ceil((double) RoundRectDrawableWithShadow.c(g2, d2, cardViewDelegate.d()));
        int ceil2 = (int) Math.ceil((double) RoundRectDrawableWithShadow.d(g2, d2, cardViewDelegate.d()));
        cardViewDelegate.a(ceil, ceil2, ceil, ceil2);
    }

    public void j() {
    }

    public float k(CardViewDelegate cardViewDelegate) {
        return d(cardViewDelegate) * 2.0f;
    }

    public float l(CardViewDelegate cardViewDelegate) {
        return d(cardViewDelegate) * 2.0f;
    }

    public void m(CardViewDelegate cardViewDelegate) {
        o(cardViewDelegate, g(cardViewDelegate));
    }

    public void n(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
        p(cardViewDelegate).f(colorStateList);
    }

    public void o(CardViewDelegate cardViewDelegate, float f2) {
        p(cardViewDelegate).g(f2, cardViewDelegate.e(), cardViewDelegate.d());
        i(cardViewDelegate);
    }
}
