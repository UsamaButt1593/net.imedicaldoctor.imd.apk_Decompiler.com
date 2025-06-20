package net.imedicaldoctor.imd.Views;

import android.content.Context;
import android.util.AttributeSet;
import net.imedicaldoctor.imd.R;

public class WhiteHighlightButton extends HighlightButton {
    public WhiteHighlightButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void h() {
        setBackgroundResource(R.drawable.f549background_highlight_white);
        setRippleColor(getResources().getColor(R.color.f174highlight_ripple_white));
    }
}
