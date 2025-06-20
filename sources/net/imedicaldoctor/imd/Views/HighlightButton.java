package net.imedicaldoctor.imd.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import net.imedicaldoctor.imd.R;

public class HighlightButton extends ButtonFloat {
    public HighlightButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r3 = 20;
        this.q3 = 20;
        c();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Utils.a((float) this.q3, getResources()), Utils.a((float) this.q3, getResources()));
        layoutParams.addRule(13, -1);
        this.s3.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.f3 = (float) Utils.a(2.0f, getResources());
        this.g3 = 10;
        setMinimumHeight(Utils.a((float) (this.r3 * 2), getResources()));
        setMinimumWidth(Utils.a((float) (this.r3 * 2), getResources()));
        h();
    }

    public void h() {
        setBackgroundResource(R.drawable.f542background_button_float);
        setRippleColor(getResources().getColor(this.h3.intValue()));
    }
}
