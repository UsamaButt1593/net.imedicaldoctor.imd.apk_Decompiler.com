package net.imedicaldoctor.imd.Views;

import android.content.Context;
import android.util.AttributeSet;
import net.imedicaldoctor.imd.R;

public class YellowHighlightButton extends HighlightButton {
    public YellowHighlightButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void h() {
        setBackgroundResource(R.drawable.f550background_highlight_yellow);
        setRippleColor(getResources().getColor(R.color.f175highlight_ripple_yellow));
    }
}
