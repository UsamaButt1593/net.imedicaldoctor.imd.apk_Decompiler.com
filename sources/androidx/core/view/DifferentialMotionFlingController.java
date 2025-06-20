package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

public class DifferentialMotionFlingController {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6360a;

    /* renamed from: b  reason: collision with root package name */
    private final DifferentialMotionFlingTarget f6361b;

    /* renamed from: c  reason: collision with root package name */
    private final FlingVelocityThresholdCalculator f6362c;

    /* renamed from: d  reason: collision with root package name */
    private final DifferentialVelocityProvider f6363d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private VelocityTracker f6364e;

    /* renamed from: f  reason: collision with root package name */
    private float f6365f;

    /* renamed from: g  reason: collision with root package name */
    private int f6366g;

    /* renamed from: h  reason: collision with root package name */
    private int f6367h;

    /* renamed from: i  reason: collision with root package name */
    private int f6368i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f6369j;

    @VisibleForTesting
    interface DifferentialVelocityProvider {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i2);
    }

    @VisibleForTesting
    interface FlingVelocityThresholdCalculator {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i2);
    }

    public DifferentialMotionFlingController(@NonNull Context context, @NonNull DifferentialMotionFlingTarget differentialMotionFlingTarget) {
        this(context, differentialMotionFlingTarget, new C0119q(), new r());
    }

    /* access modifiers changed from: private */
    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = ViewConfigurationCompat.i(context, viewConfiguration, motionEvent.getDeviceId(), i2, motionEvent.getSource());
        iArr[1] = ViewConfigurationCompat.h(context, viewConfiguration, motionEvent.getDeviceId(), i2, motionEvent.getSource());
    }

    private boolean d(MotionEvent motionEvent, int i2) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f6367h == source && this.f6368i == deviceId && this.f6366g == i2) {
            return false;
        }
        this.f6362c.a(this.f6360a, this.f6369j, motionEvent, i2);
        this.f6367h = source;
        this.f6368i = deviceId;
        this.f6366g = i2;
        return true;
    }

    private float e(MotionEvent motionEvent, int i2) {
        if (this.f6364e == null) {
            this.f6364e = VelocityTracker.obtain();
        }
        return this.f6363d.a(this.f6364e, motionEvent, i2);
    }

    /* access modifiers changed from: private */
    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i2) {
        VelocityTrackerCompat.a(velocityTracker, motionEvent);
        VelocityTrackerCompat.c(velocityTracker, 1000);
        return VelocityTrackerCompat.e(velocityTracker, i2);
    }

    public void g(@NonNull MotionEvent motionEvent, int i2) {
        boolean d2 = d(motionEvent, i2);
        if (this.f6369j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f6364e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f6364e = null;
                return;
            }
            return;
        }
        float e2 = e(motionEvent, i2) * this.f6361b.b();
        float signum = Math.signum(e2);
        float f2 = 0.0f;
        if (d2 || !(signum == Math.signum(this.f6365f) || signum == 0.0f)) {
            this.f6361b.c();
        }
        float abs = Math.abs(e2);
        int[] iArr = this.f6369j;
        if (abs >= ((float) iArr[0])) {
            int i3 = iArr[1];
            float max = Math.max((float) (-i3), Math.min(e2, (float) i3));
            if (this.f6361b.a(max)) {
                f2 = max;
            }
            this.f6365f = f2;
        }
    }

    @VisibleForTesting
    DifferentialMotionFlingController(Context context, DifferentialMotionFlingTarget differentialMotionFlingTarget, FlingVelocityThresholdCalculator flingVelocityThresholdCalculator, DifferentialVelocityProvider differentialVelocityProvider) {
        this.f6366g = -1;
        this.f6367h = -1;
        this.f6368i = -1;
        this.f6369j = new int[]{Integer.MAX_VALUE, 0};
        this.f6360a = context;
        this.f6361b = differentialMotionFlingTarget;
        this.f6362c = flingVelocityThresholdCalculator;
        this.f6363d = differentialVelocityProvider;
    }
}
