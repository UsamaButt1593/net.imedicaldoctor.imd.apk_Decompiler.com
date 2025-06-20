package net.imedicaldoctor.imd;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;

public class AutoResizeTextView extends AppCompatTextView {
    private static final int p3 = -1;
    private final RectF d3;
    private final SparseIntArray e3;
    private final SizeTester f3;
    private float g3;
    /* access modifiers changed from: private */
    public float h3;
    /* access modifiers changed from: private */
    public float i3;
    private float j3;
    /* access modifiers changed from: private */
    public int k3;
    private int l3;
    private boolean m3;
    private boolean n3;
    /* access modifiers changed from: private */
    public TextPaint o3;

    private interface SizeTester {
        int a(int i2, RectF rectF);
    }

    public AutoResizeTextView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private int A(int i2, int i4, SizeTester sizeTester, RectF rectF) {
        int i5 = i4 - 1;
        int i6 = i2;
        while (i2 <= i5) {
            i6 = (i2 + i5) >>> 1;
            int a2 = sizeTester.a(i6, rectF);
            if (a2 >= 0) {
                if (a2 <= 0) {
                    break;
                }
                i6--;
                i5 = i6;
            } else {
                int i7 = i6 + 1;
                i6 = i2;
                i2 = i7;
            }
        }
        return i6;
    }

    private int B(int i2, int i4, SizeTester sizeTester, RectF rectF) {
        if (!this.m3) {
            return A(i2, i4, sizeTester, rectF);
        }
        String charSequence = getText().toString();
        int length = charSequence == null ? 0 : charSequence.length();
        int i5 = this.e3.get(length);
        if (i5 != 0) {
            return i5;
        }
        int A = A(i2, i4, sizeTester, rectF);
        this.e3.put(length, A);
        return A;
    }

    private void C() {
        z();
    }

    private void D(int i2) {
        super.setTextSize(0, (float) B(i2, (int) this.g3, this.f3, this.d3));
    }

    private void z() {
        if (this.n3) {
            int i2 = (int) this.j3;
            int measuredHeight = (getMeasuredHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop();
            int measuredWidth = (getMeasuredWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight();
            this.k3 = measuredWidth;
            if (measuredWidth > 0) {
                RectF rectF = this.d3;
                rectF.right = (float) measuredWidth;
                rectF.bottom = (float) measuredHeight;
                D(i2);
            }
        }
    }

    public int getMaxLines() {
        return this.l3;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i4, int i5, int i6) {
        this.e3.clear();
        super.onSizeChanged(i2, i4, i5, i6);
        if (i2 != i5 || i4 != i6) {
            C();
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
        super.onTextChanged(charSequence, i2, i4, i5);
        C();
    }

    public void setEnableSizeCache(boolean z) {
        this.m3 = z;
        this.e3.clear();
        z();
    }

    public void setLineSpacing(float f2, float f4) {
        super.setLineSpacing(f2, f4);
        this.h3 = f4;
        this.i3 = f2;
    }

    public void setLines(int i2) {
        super.setLines(i2);
        this.l3 = i2;
        C();
    }

    public void setMaxLines(int i2) {
        super.setMaxLines(i2);
        this.l3 = i2;
        C();
    }

    public void setMinTextSize(float f2) {
        this.j3 = f2;
        C();
    }

    public void setSingleLine() {
        super.setSingleLine();
        this.l3 = 1;
        C();
    }

    public void setTextSize(float f2) {
        this.g3 = f2;
        this.e3.clear();
        z();
    }

    public void setTypeface(Typeface typeface) {
        if (this.o3 == null) {
            this.o3 = new TextPaint(getPaint());
        }
        this.o3.setTypeface(typeface);
        z();
        super.setTypeface(typeface);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
        this.l3 = z ? 1 : -1;
        C();
    }

    public void setTextSize(int i2, float f2) {
        Context context = getContext();
        this.g3 = TypedValue.applyDimension(i2, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        this.e3.clear();
        z();
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d3 = new RectF();
        this.e3 = new SparseIntArray();
        this.h3 = 1.0f;
        this.i3 = 0.0f;
        this.m3 = true;
        this.n3 = false;
        this.j3 = TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics());
        this.g3 = getTextSize();
        if (this.l3 == 0) {
            this.l3 = -1;
        }
        this.f3 = new SizeTester() {

            /* renamed from: a  reason: collision with root package name */
            final RectF f29473a = new RectF();

            @TargetApi(16)
            public int a(int i2, RectF rectF) {
                RectF rectF2;
                float f2;
                AutoResizeTextView.this.o3.setTextSize((float) i2);
                String charSequence = AutoResizeTextView.this.getText().toString();
                if (AutoResizeTextView.this.getMaxLines() == 1) {
                    this.f29473a.bottom = AutoResizeTextView.this.o3.getFontSpacing();
                    rectF2 = this.f29473a;
                    f2 = AutoResizeTextView.this.o3.measureText(charSequence);
                } else {
                    StaticLayout staticLayout = new StaticLayout(charSequence, AutoResizeTextView.this.o3, AutoResizeTextView.this.k3, Layout.Alignment.ALIGN_NORMAL, AutoResizeTextView.this.h3, AutoResizeTextView.this.i3, true);
                    if (AutoResizeTextView.this.getMaxLines() != -1 && staticLayout.getLineCount() > AutoResizeTextView.this.getMaxLines()) {
                        return 1;
                    }
                    this.f29473a.bottom = (float) staticLayout.getHeight();
                    int i3 = -1;
                    for (int i4 = 0; i4 < staticLayout.getLineCount(); i4++) {
                        if (((float) i3) < staticLayout.getLineRight(i4) - staticLayout.getLineLeft(i4)) {
                            i3 = ((int) staticLayout.getLineRight(i4)) - ((int) staticLayout.getLineLeft(i4));
                        }
                    }
                    rectF2 = this.f29473a;
                    f2 = (float) i3;
                }
                rectF2.right = f2;
                this.f29473a.offsetTo(0.0f, 0.0f);
                return rectF.contains(this.f29473a) ? -1 : 1;
            }
        };
        this.n3 = true;
    }
}
