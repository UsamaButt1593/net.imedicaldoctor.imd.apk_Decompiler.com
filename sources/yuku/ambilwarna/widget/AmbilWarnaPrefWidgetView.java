package yuku.ambilwarna.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class AmbilWarnaPrefWidgetView extends View {
    float X2;
    float Y2;
    Paint s;

    public AmbilWarnaPrefWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.X2 = (float) Math.floor((double) ((24.0f * f2) + 0.5f));
        this.Y2 = (float) Math.floor((double) ((f2 * 1.0f) + 0.5f));
        Paint paint = new Paint();
        this.s = paint;
        paint.setColor(-1);
        this.s.setStyle(Paint.Style.STROKE);
        this.s.setStrokeWidth(this.Y2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.Y2;
        float f3 = this.X2;
        canvas.drawRect(f2, f2, f3 - f2, f3 - f2, this.s);
    }
}
