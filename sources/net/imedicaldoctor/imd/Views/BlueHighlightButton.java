package net.imedicaldoctor.imd.Views;

import android.content.Context;
import android.util.AttributeSet;
import net.imedicaldoctor.imd.R;

public class BlueHighlightButton extends HighlightButton {
    public BlueHighlightButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void h() {
        setBackgroundResource(R.drawable.f546background_highlight_blue);
        setRippleColor(getResources().getColor(R.color.f171highlight_ripple_blue));
    }
}
