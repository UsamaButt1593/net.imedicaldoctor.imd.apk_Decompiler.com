package net.imedicaldoctor.imd.Views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.itextpdf.tool.xml.css.CSS;
import net.imedicaldoctor.imd.R;

public class Card extends CustomView {
    TextView c3;
    int d3;
    int e3;
    int f3;
    int g3;
    int h3 = Color.parseColor("#FFFFFF");

    public Card(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setAttributes(attributeSet);
    }

    /* access modifiers changed from: protected */
    public void setAttributes(AttributeSet attributeSet) {
        int parseColor;
        setBackgroundResource(R.drawable.f545background_button_rectangle);
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", CSS.Property.f27458a, -1);
        if (attributeResourceValue != -1) {
            parseColor = getResources().getColor(attributeResourceValue);
        } else {
            String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", CSS.Property.f27458a);
            parseColor = attributeValue != null ? Color.parseColor(attributeValue) : this.h3;
        }
        setBackgroundColor(parseColor);
    }

    public void setBackgroundColor(int i2) {
        this.h3 = i2;
        if (isEnabled()) {
            this.X2 = this.h3;
        }
        ((GradientDrawable) ((LayerDrawable) getBackground()).findDrawableByLayerId(R.id.f1072shape_bacground)).setColor(this.h3);
    }
}
