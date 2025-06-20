package net.imedicaldoctor.imd.Views;

import android.content.Context;
import android.util.AttributeSet;
import net.imedicaldoctor.imd.R;

public class RedHighlightButton extends HighlightButton {
    public RedHighlightButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void h() {
        setBackgroundResource(R.drawable.f548background_highlight_red);
        setRippleColor(getResources().getColor(R.color.f173highlight_ripple_red));
    }
}
