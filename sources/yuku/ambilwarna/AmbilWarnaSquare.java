package yuku.ambilwarna;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;

public class AmbilWarnaSquare extends View {
    Shader X2;
    final float[] Y2 = {1.0f, 1.0f, 1.0f};
    Paint s;

    public AmbilWarnaSquare(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.s == null) {
            this.s = new Paint();
            this.X2 = new LinearGradient(0.0f, 0.0f, 0.0f, (float) getMeasuredHeight(), -1, ViewCompat.y, Shader.TileMode.CLAMP);
        }
        this.s.setShader(new ComposeShader(this.X2, new LinearGradient(0.0f, 0.0f, (float) getMeasuredWidth(), 0.0f, -1, Color.HSVToColor(this.Y2), Shader.TileMode.CLAMP), PorterDuff.Mode.MULTIPLY));
        canvas.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), this.s);
    }

    /* access modifiers changed from: package-private */
    public void setHue(float f2) {
        this.Y2[0] = f2;
        invalidate();
    }

    public AmbilWarnaSquare(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
