package net.imedicaldoctor.imd.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.itextpdf.tool.xml.css.CSS;
import net.imedicaldoctor.imd.R;

public class ButtonFlat extends Button {
    TextView q3;

    public ButtonFlat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public int b() {
        return Color.parseColor("#88DDDDDD");
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.d3 = 36;
        this.c3 = 88;
        this.g3 = 3;
        setMinimumHeight(Utils.a((float) 36, getResources()));
        setMinimumWidth(Utils.a((float) this.c3, getResources()));
        setBackgroundResource(R.drawable.f552background_transparent);
    }

    public String getText() {
        return this.q3.getText().toString();
    }

    public TextView getTextView() {
        return this.q3;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.m3 != -1.0f) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(b());
            canvas.drawCircle(this.m3, this.n3, this.o3, paint);
            if (this.o3 > ((float) (getHeight() / this.g3))) {
                this.o3 += this.f3;
            }
            if (this.o3 >= ((float) getWidth())) {
                this.m3 = -1.0f;
                this.n3 = -1.0f;
                this.o3 = (float) (getHeight() / this.g3);
                View.OnClickListener onClickListener = this.i3;
                if (onClickListener != null && this.j3) {
                    onClickListener.onClick(this);
                }
            }
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void setAttributes(AttributeSet attributeSet) {
        int attributeIntValue;
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "text", -1);
        String string = attributeResourceValue != -1 ? getResources().getString(attributeResourceValue) : attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
        if (string != null) {
            TextView textView = new TextView(getContext());
            this.q3 = textView;
            textView.setText(string.toUpperCase());
            this.q3.setTextColor(this.k3);
            this.q3.setTypeface((Typeface) null, 1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, -1);
            this.q3.setLayoutParams(layoutParams);
            addView(this.q3);
        }
        int attributeResourceValue2 = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", CSS.Property.f27458a, -1);
        if (attributeResourceValue2 != -1) {
            attributeIntValue = getResources().getColor(attributeResourceValue2);
        } else {
            attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", CSS.Property.f27458a, -1);
            this.e3 = attributeIntValue;
            if (attributeIntValue == -1) {
                return;
            }
        }
        setBackgroundColor(attributeIntValue);
    }

    public void setBackgroundColor(int i2) {
        this.k3 = i2;
        if (isEnabled()) {
            this.X2 = this.k3;
        }
        this.q3.setTextColor(i2);
    }

    public void setText(String str) {
        this.q3.setText(str.toUpperCase());
    }
}
