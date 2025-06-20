package net.imedicaldoctor.imd.Views;

import android.content.Context;
import android.util.AttributeSet;
import net.imedicaldoctor.imd.R;

public class GreenHighlightButton extends HighlightButton {
    public GreenHighlightButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void h() {
        setBackgroundResource(R.drawable.f547background_highlight_green);
        setRippleColor(getResources().getColor(R.color.f172highlight_ripple_green));
    }
}
