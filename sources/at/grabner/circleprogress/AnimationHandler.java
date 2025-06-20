package at.grabner.circleprogress;

import android.animation.TimeInterpolator;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.lang.ref.WeakReference;

public class AnimationHandler extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<CircleProgressView> f16603a;

    /* renamed from: b  reason: collision with root package name */
    private float f16604b;

    /* renamed from: c  reason: collision with root package name */
    private long f16605c;

    /* renamed from: d  reason: collision with root package name */
    private long f16606d;

    /* renamed from: e  reason: collision with root package name */
    private TimeInterpolator f16607e = new DecelerateInterpolator();

    /* renamed from: f  reason: collision with root package name */
    private TimeInterpolator f16608f = new AccelerateDecelerateInterpolator();

    /* renamed from: g  reason: collision with root package name */
    private double f16609g;

    /* renamed from: h  reason: collision with root package name */
    private long f16610h = 0;

    /* renamed from: at.grabner.circleprogress.AnimationHandler$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16611a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f16612b;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0061 */
        static {
            /*
                at.grabner.circleprogress.AnimationState[] r0 = at.grabner.circleprogress.AnimationState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16612b = r0
                r1 = 1
                at.grabner.circleprogress.AnimationState r2 = at.grabner.circleprogress.AnimationState.IDLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f16612b     // Catch:{ NoSuchFieldError -> 0x001d }
                at.grabner.circleprogress.AnimationState r3 = at.grabner.circleprogress.AnimationState.SPINNING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f16612b     // Catch:{ NoSuchFieldError -> 0x0028 }
                at.grabner.circleprogress.AnimationState r4 = at.grabner.circleprogress.AnimationState.END_SPINNING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f16612b     // Catch:{ NoSuchFieldError -> 0x0033 }
                at.grabner.circleprogress.AnimationState r5 = at.grabner.circleprogress.AnimationState.END_SPINNING_START_ANIMATING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f16612b     // Catch:{ NoSuchFieldError -> 0x003e }
                at.grabner.circleprogress.AnimationState r6 = at.grabner.circleprogress.AnimationState.ANIMATING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r5 = at.grabner.circleprogress.AnimationMsg.a()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f16611a = r5
                int r6 = at.grabner.circleprogress.AnimationMsg.s     // Catch:{ NoSuchFieldError -> 0x004c }
                int r6 = r6 - r1
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                int[] r5 = f16611a     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r6 = at.grabner.circleprogress.AnimationMsg.X     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r6 = r6 - r1
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = f16611a     // Catch:{ NoSuchFieldError -> 0x005a }
                int r5 = at.grabner.circleprogress.AnimationMsg.Y     // Catch:{ NoSuchFieldError -> 0x005a }
                int r5 = r5 - r1
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r0 = f16611a     // Catch:{ NoSuchFieldError -> 0x0061 }
                int r2 = at.grabner.circleprogress.AnimationMsg.Z     // Catch:{ NoSuchFieldError -> 0x0061 }
                int r2 = r2 - r1
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0061 }
            L_0x0061:
                int[] r0 = f16611a     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r2 = at.grabner.circleprogress.AnimationMsg.X2     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r2 = r2 - r1
                r0[r2] = r4     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: at.grabner.circleprogress.AnimationHandler.AnonymousClass1.<clinit>():void");
        }
    }

    AnimationHandler(CircleProgressView circleProgressView) {
        super(circleProgressView.getContext().getMainLooper());
        this.f16603a = new WeakReference<>(circleProgressView);
    }

    private boolean a(CircleProgressView circleProgressView) {
        float currentTimeMillis = (float) (((double) (System.currentTimeMillis() - this.f16605c)) / circleProgressView.t3);
        if (currentTimeMillis > 1.0f) {
            currentTimeMillis = 1.0f;
        }
        float interpolation = this.f16608f.getInterpolation(currentTimeMillis);
        float f2 = circleProgressView.k3;
        circleProgressView.i3 = f2 + ((circleProgressView.j3 - f2) * interpolation);
        return currentTimeMillis >= 1.0f;
    }

    private void b(CircleProgressView circleProgressView, Message message) {
        AnimationState animationState = AnimationState.END_SPINNING_START_ANIMATING;
        circleProgressView.x3 = animationState;
        AnimationStateChangedListener animationStateChangedListener = circleProgressView.y3;
        if (animationStateChangedListener != null) {
            animationStateChangedListener.a(animationState);
        }
        circleProgressView.k3 = 0.0f;
        circleProgressView.j3 = ((float[]) message.obj)[1];
        this.f16606d = System.currentTimeMillis();
        this.f16604b = circleProgressView.o3;
        sendEmptyMessageDelayed(AnimationMsg.X2 - 1, ((long) circleProgressView.u3) - (SystemClock.uptimeMillis() - this.f16610h));
    }

    private void c(CircleProgressView circleProgressView) {
        AnimationState animationState = AnimationState.SPINNING;
        circleProgressView.x3 = animationState;
        AnimationStateChangedListener animationStateChangedListener = circleProgressView.y3;
        if (animationStateChangedListener != null) {
            animationStateChangedListener.a(animationState);
        }
        float f2 = circleProgressView.l3;
        float f3 = circleProgressView.i3;
        circleProgressView.o3 = (360.0f / f2) * f3;
        circleProgressView.q3 = (360.0f / f2) * f3;
        this.f16606d = System.currentTimeMillis();
        this.f16604b = circleProgressView.o3;
        int i2 = circleProgressView.u3;
        this.f16609g = (double) ((circleProgressView.p3 / circleProgressView.r3) * ((float) i2) * 2.0f);
        sendEmptyMessageDelayed(AnimationMsg.X2 - 1, ((long) i2) - (SystemClock.uptimeMillis() - this.f16610h));
    }

    private void d(CircleProgressView circleProgressView) {
        this.f16609g = (double) ((circleProgressView.o3 / circleProgressView.r3) * ((float) circleProgressView.u3) * 2.0f);
        this.f16606d = System.currentTimeMillis();
        this.f16604b = circleProgressView.o3;
    }

    private static void f(Message message, CircleProgressView circleProgressView) {
        circleProgressView.k3 = circleProgressView.j3;
        float f2 = ((float[]) message.obj)[0];
        circleProgressView.j3 = f2;
        circleProgressView.i3 = f2;
        AnimationState animationState = AnimationState.IDLE;
        circleProgressView.x3 = animationState;
        AnimationStateChangedListener animationStateChangedListener = circleProgressView.y3;
        if (animationStateChangedListener != null) {
            animationStateChangedListener.a(animationState);
        }
        circleProgressView.invalidate();
    }

    public void e(TimeInterpolator timeInterpolator) {
        this.f16607e = timeInterpolator;
    }

    public void g(TimeInterpolator timeInterpolator) {
        this.f16608f = timeInterpolator;
    }

    public void handleMessage(Message message) {
        float f2;
        CircleProgressView circleProgressView = this.f16603a.get();
        if (circleProgressView != null) {
            int i2 = AnimationMsg.a()[message.what];
            int i3 = AnimationMsg.X2;
            if (i2 == i3) {
                removeMessages(i3 - 1);
            }
            this.f16610h = SystemClock.uptimeMillis();
            int i4 = AnonymousClass1.f16612b[circleProgressView.x3.ordinal()];
            if (i4 == 1) {
                int i5 = AnonymousClass1.f16611a[i2 - 1];
                if (i5 == 1) {
                    c(circleProgressView);
                } else if (i5 == 3) {
                    f(message, circleProgressView);
                } else if (i5 == 4) {
                    Object obj = message.obj;
                    circleProgressView.k3 = ((float[]) obj)[0];
                    circleProgressView.j3 = ((float[]) obj)[1];
                    this.f16605c = System.currentTimeMillis();
                    AnimationState animationState = AnimationState.ANIMATING;
                    circleProgressView.x3 = animationState;
                    AnimationStateChangedListener animationStateChangedListener = circleProgressView.y3;
                    if (animationStateChangedListener != null) {
                        animationStateChangedListener.a(animationState);
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.u3) - (SystemClock.uptimeMillis() - this.f16610h));
                } else if (i5 == 5) {
                    removeMessages(i3 - 1);
                }
            } else if (i4 == 2) {
                int i6 = AnonymousClass1.f16611a[i2 - 1];
                if (i6 == 2) {
                    circleProgressView.x3 = AnimationState.END_SPINNING;
                    d(circleProgressView);
                    AnimationStateChangedListener animationStateChangedListener2 = circleProgressView.y3;
                    if (animationStateChangedListener2 != null) {
                        animationStateChangedListener2.a(circleProgressView.x3);
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.u3) - (SystemClock.uptimeMillis() - this.f16610h));
                } else if (i6 == 3) {
                    f(message, circleProgressView);
                } else if (i6 == 4) {
                    b(circleProgressView, message);
                } else if (i6 == 5) {
                    float f3 = circleProgressView.o3 - circleProgressView.p3;
                    float currentTimeMillis = (float) (((double) (System.currentTimeMillis() - this.f16606d)) / this.f16609g);
                    if (currentTimeMillis > 1.0f) {
                        currentTimeMillis = 1.0f;
                    }
                    float interpolation = this.f16607e.getInterpolation(currentTimeMillis);
                    if (Math.abs(f3) < 1.0f) {
                        f2 = circleProgressView.p3;
                    } else {
                        float f4 = circleProgressView.o3;
                        float f5 = circleProgressView.p3;
                        if (f4 < f5) {
                            float f6 = this.f16604b;
                            f2 = f6 + ((f5 - f6) * interpolation);
                        } else {
                            float f7 = this.f16604b;
                            f2 = f7 - ((f7 - f5) * interpolation);
                        }
                    }
                    circleProgressView.o3 = f2;
                    float f8 = circleProgressView.q3 + circleProgressView.r3;
                    circleProgressView.q3 = f8;
                    if (f8 > 360.0f) {
                        circleProgressView.q3 = 0.0f;
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.u3) - (SystemClock.uptimeMillis() - this.f16610h));
                    circleProgressView.invalidate();
                }
            } else if (i4 == 3) {
                int i7 = AnonymousClass1.f16611a[i2 - 1];
                if (i7 == 1) {
                    AnimationState animationState2 = AnimationState.SPINNING;
                    circleProgressView.x3 = animationState2;
                    AnimationStateChangedListener animationStateChangedListener3 = circleProgressView.y3;
                    if (animationStateChangedListener3 != null) {
                        animationStateChangedListener3.a(animationState2);
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.u3) - (SystemClock.uptimeMillis() - this.f16610h));
                } else if (i7 == 3) {
                    f(message, circleProgressView);
                } else if (i7 == 4) {
                    b(circleProgressView, message);
                } else if (i7 == 5) {
                    float currentTimeMillis2 = (float) (((double) (System.currentTimeMillis() - this.f16606d)) / this.f16609g);
                    if (currentTimeMillis2 > 1.0f) {
                        currentTimeMillis2 = 1.0f;
                    }
                    float interpolation2 = this.f16604b * (1.0f - this.f16607e.getInterpolation(currentTimeMillis2));
                    circleProgressView.o3 = interpolation2;
                    circleProgressView.q3 += circleProgressView.r3;
                    if (interpolation2 < 0.01f) {
                        AnimationState animationState3 = AnimationState.IDLE;
                        circleProgressView.x3 = animationState3;
                        AnimationStateChangedListener animationStateChangedListener4 = circleProgressView.y3;
                        if (animationStateChangedListener4 != null) {
                            animationStateChangedListener4.a(animationState3);
                        }
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.u3) - (SystemClock.uptimeMillis() - this.f16610h));
                    circleProgressView.invalidate();
                }
            } else if (i4 == 4) {
                int i8 = AnonymousClass1.f16611a[i2 - 1];
                if (i8 == 1) {
                    circleProgressView.v3 = false;
                    c(circleProgressView);
                } else if (i8 == 3) {
                    circleProgressView.v3 = false;
                    f(message, circleProgressView);
                } else if (i8 == 4) {
                    circleProgressView.k3 = 0.0f;
                    circleProgressView.j3 = ((float[]) message.obj)[1];
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.u3) - (SystemClock.uptimeMillis() - this.f16610h));
                } else if (i8 == 5) {
                    if (circleProgressView.o3 > circleProgressView.p3 && !circleProgressView.v3) {
                        float currentTimeMillis3 = (float) (((double) (System.currentTimeMillis() - this.f16606d)) / this.f16609g);
                        if (currentTimeMillis3 > 1.0f) {
                            currentTimeMillis3 = 1.0f;
                        }
                        circleProgressView.o3 = this.f16604b * (1.0f - this.f16607e.getInterpolation(currentTimeMillis3));
                    }
                    float f9 = circleProgressView.q3 + circleProgressView.r3;
                    circleProgressView.q3 = f9;
                    if (f9 > 360.0f && !circleProgressView.v3) {
                        this.f16605c = System.currentTimeMillis();
                        circleProgressView.v3 = true;
                        d(circleProgressView);
                        AnimationStateChangedListener animationStateChangedListener5 = circleProgressView.y3;
                        if (animationStateChangedListener5 != null) {
                            animationStateChangedListener5.a(AnimationState.START_ANIMATING_AFTER_SPINNING);
                        }
                    }
                    if (circleProgressView.v3) {
                        circleProgressView.q3 = 360.0f;
                        circleProgressView.o3 -= circleProgressView.r3;
                        a(circleProgressView);
                        float currentTimeMillis4 = (float) (((double) (System.currentTimeMillis() - this.f16606d)) / this.f16609g);
                        if (currentTimeMillis4 > 1.0f) {
                            currentTimeMillis4 = 1.0f;
                        }
                        circleProgressView.o3 = this.f16604b * (1.0f - this.f16607e.getInterpolation(currentTimeMillis4));
                    }
                    if (((double) circleProgressView.o3) < 0.1d) {
                        AnimationState animationState4 = AnimationState.ANIMATING;
                        circleProgressView.x3 = animationState4;
                        AnimationStateChangedListener animationStateChangedListener6 = circleProgressView.y3;
                        if (animationStateChangedListener6 != null) {
                            animationStateChangedListener6.a(animationState4);
                        }
                        circleProgressView.invalidate();
                        circleProgressView.v3 = false;
                        circleProgressView.o3 = circleProgressView.p3;
                    } else {
                        circleProgressView.invalidate();
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.u3) - (SystemClock.uptimeMillis() - this.f16610h));
                }
            } else if (i4 == 5) {
                int i9 = AnonymousClass1.f16611a[i2 - 1];
                if (i9 == 1) {
                    c(circleProgressView);
                } else if (i9 == 3) {
                    f(message, circleProgressView);
                } else if (i9 == 4) {
                    this.f16605c = System.currentTimeMillis();
                    circleProgressView.k3 = circleProgressView.i3;
                    circleProgressView.j3 = ((float[]) message.obj)[1];
                } else if (i9 == 5) {
                    if (a(circleProgressView)) {
                        AnimationState animationState5 = AnimationState.IDLE;
                        circleProgressView.x3 = animationState5;
                        AnimationStateChangedListener animationStateChangedListener7 = circleProgressView.y3;
                        if (animationStateChangedListener7 != null) {
                            animationStateChangedListener7.a(animationState5);
                        }
                        circleProgressView.i3 = circleProgressView.j3;
                    }
                    sendEmptyMessageDelayed(i3 - 1, ((long) circleProgressView.u3) - (SystemClock.uptimeMillis() - this.f16610h));
                    circleProgressView.invalidate();
                }
            }
        }
    }
}
