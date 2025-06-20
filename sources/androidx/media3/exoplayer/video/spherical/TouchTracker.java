package androidx.media3.exoplayer.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.BinderThread;
import androidx.media3.exoplayer.video.spherical.OrientationListener;

final class TouchTracker extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, OrientationListener.Listener {
    static final float Z2 = 45.0f;
    private final PointF X = new PointF();
    private final GestureDetector X2;
    private final Listener Y;
    private volatile float Y2;
    private final float Z;
    private final PointF s = new PointF();

    public interface Listener {
        void b(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public TouchTracker(Context context, Listener listener, float f2) {
        this.Y = listener;
        this.Z = f2;
        this.X2 = new GestureDetector(context, this);
        this.Y2 = 3.1415927f;
    }

    @BinderThread
    public void a(float[] fArr, float f2) {
        this.Y2 = -f2;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.s.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        float x = (motionEvent2.getX() - this.s.x) / this.Z;
        float y = motionEvent2.getY();
        PointF pointF = this.s;
        float f4 = (y - pointF.y) / this.Z;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d2 = (double) this.Y2;
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        PointF pointF2 = this.X;
        pointF2.x -= (cos * x) - (sin * f4);
        float f5 = pointF2.y + (sin * x) + (cos * f4);
        pointF2.y = f5;
        pointF2.y = Math.max(-45.0f, Math.min(Z2, f5));
        this.Y.b(this.X);
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.Y.onSingleTapUp(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.X2.onTouchEvent(motionEvent);
    }
}
