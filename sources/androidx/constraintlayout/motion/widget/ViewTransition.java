package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class ViewTransition {
    public static final String A = "ConstraintOverride";
    public static final String B = "CustomAttribute";
    public static final String C = "CustomMethod";
    private static final int D = -1;
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 3;
    public static final int H = 4;
    public static final int I = 5;
    static final int J = 0;
    static final int K = 1;
    static final int L = 2;
    private static final int M = -1;
    private static final int N = -2;
    static final int O = 0;
    static final int P = 1;
    static final int Q = 2;
    static final int R = 3;
    static final int S = 4;
    static final int T = 5;
    static final int U = 6;
    private static String x = "ViewTransition";
    public static final String y = "ViewTransition";
    public static final String z = "KeyFrameSet";

    /* renamed from: a  reason: collision with root package name */
    ConstraintSet f4565a;

    /* renamed from: b  reason: collision with root package name */
    private int f4566b;

    /* renamed from: c  reason: collision with root package name */
    private int f4567c = -1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4568d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f4569e = 0;

    /* renamed from: f  reason: collision with root package name */
    int f4570f;

    /* renamed from: g  reason: collision with root package name */
    KeyFrames f4571g;

    /* renamed from: h  reason: collision with root package name */
    ConstraintSet.Constraint f4572h;

    /* renamed from: i  reason: collision with root package name */
    private int f4573i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f4574j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f4575k;

    /* renamed from: l  reason: collision with root package name */
    private String f4576l;

    /* renamed from: m  reason: collision with root package name */
    private int f4577m = 0;

    /* renamed from: n  reason: collision with root package name */
    private String f4578n = null;
    private int o = -1;
    Context p;
    private int q = -1;
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;
    private int w = -1;

    static class Animate {

        /* renamed from: a  reason: collision with root package name */
        private final int f4580a;

        /* renamed from: b  reason: collision with root package name */
        private final int f4581b;

        /* renamed from: c  reason: collision with root package name */
        long f4582c;

        /* renamed from: d  reason: collision with root package name */
        MotionController f4583d;

        /* renamed from: e  reason: collision with root package name */
        int f4584e;

        /* renamed from: f  reason: collision with root package name */
        int f4585f;

        /* renamed from: g  reason: collision with root package name */
        KeyCache f4586g = new KeyCache();

        /* renamed from: h  reason: collision with root package name */
        ViewTransitionController f4587h;

        /* renamed from: i  reason: collision with root package name */
        Interpolator f4588i;

        /* renamed from: j  reason: collision with root package name */
        boolean f4589j = false;

        /* renamed from: k  reason: collision with root package name */
        float f4590k;

        /* renamed from: l  reason: collision with root package name */
        float f4591l;

        /* renamed from: m  reason: collision with root package name */
        long f4592m;

        /* renamed from: n  reason: collision with root package name */
        Rect f4593n = new Rect();
        boolean o = false;

        Animate(ViewTransitionController viewTransitionController, MotionController motionController, int i2, int i3, int i4, Interpolator interpolator, int i5, int i6) {
            this.f4587h = viewTransitionController;
            this.f4583d = motionController;
            this.f4584e = i2;
            this.f4585f = i3;
            long nanoTime = System.nanoTime();
            this.f4582c = nanoTime;
            this.f4592m = nanoTime;
            this.f4587h.c(this);
            this.f4588i = interpolator;
            this.f4580a = i5;
            this.f4581b = i6;
            if (i4 == 3) {
                this.o = true;
            }
            this.f4591l = i2 == 0 ? Float.MAX_VALUE : 1.0f / ((float) i2);
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.f4589j) {
                c();
            } else {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            long nanoTime = System.nanoTime();
            this.f4592m = nanoTime;
            float f2 = this.f4590k + (((float) (((double) (nanoTime - this.f4592m)) * 1.0E-6d)) * this.f4591l);
            this.f4590k = f2;
            if (f2 >= 1.0f) {
                this.f4590k = 1.0f;
            }
            Interpolator interpolator = this.f4588i;
            float interpolation = interpolator == null ? this.f4590k : interpolator.getInterpolation(this.f4590k);
            MotionController motionController = this.f4583d;
            boolean L = motionController.L(motionController.f4456b, interpolation, nanoTime, this.f4586g);
            if (this.f4590k >= 1.0f) {
                if (this.f4580a != -1) {
                    this.f4583d.J().setTag(this.f4580a, Long.valueOf(System.nanoTime()));
                }
                if (this.f4581b != -1) {
                    this.f4583d.J().setTag(this.f4581b, (Object) null);
                }
                if (!this.o) {
                    this.f4587h.k(this);
                }
            }
            if (this.f4590k < 1.0f || L) {
                this.f4587h.g();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            long nanoTime = System.nanoTime();
            this.f4592m = nanoTime;
            float f2 = this.f4590k - (((float) (((double) (nanoTime - this.f4592m)) * 1.0E-6d)) * this.f4591l);
            this.f4590k = f2;
            if (f2 < 0.0f) {
                this.f4590k = 0.0f;
            }
            Interpolator interpolator = this.f4588i;
            float interpolation = interpolator == null ? this.f4590k : interpolator.getInterpolation(this.f4590k);
            MotionController motionController = this.f4583d;
            boolean L = motionController.L(motionController.f4456b, interpolation, nanoTime, this.f4586g);
            if (this.f4590k <= 0.0f) {
                if (this.f4580a != -1) {
                    this.f4583d.J().setTag(this.f4580a, Long.valueOf(System.nanoTime()));
                }
                if (this.f4581b != -1) {
                    this.f4583d.J().setTag(this.f4581b, (Object) null);
                }
                this.f4587h.k(this);
            }
            if (this.f4590k > 0.0f || L) {
                this.f4587h.g();
            }
        }

        public void d(int i2, float f2, float f3) {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f4583d.J().getHitRect(this.f4593n);
                    if (!this.f4593n.contains((int) f2, (int) f3) && !this.f4589j) {
                        e(true);
                    }
                }
            } else if (!this.f4589j) {
                e(true);
            }
        }

        /* access modifiers changed from: package-private */
        public void e(boolean z) {
            int i2;
            this.f4589j = z;
            if (z && (i2 = this.f4585f) != -1) {
                this.f4591l = i2 == 0 ? Float.MAX_VALUE : 1.0f / ((float) i2);
            }
            this.f4587h.g();
            this.f4592m = System.nanoTime();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    ViewTransition(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            r9.<init>()
            r0 = -1
            r9.f4567c = r0
            r1 = 0
            r9.f4568d = r1
            r9.f4569e = r1
            r9.f4573i = r0
            r9.f4574j = r0
            r9.f4577m = r1
            r2 = 0
            r9.f4578n = r2
            r9.o = r0
            r9.q = r0
            r9.r = r0
            r9.s = r0
            r9.t = r0
            r9.u = r0
            r9.v = r0
            r9.w = r0
            r9.p = r10
            int r2 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
        L_0x002a:
            r3 = 1
            if (r2 == r3) goto L_0x00ef
            java.lang.String r4 = "ViewTransition"
            r5 = 3
            r6 = 2
            if (r2 == r6) goto L_0x0048
            if (r2 == r5) goto L_0x0037
            goto L_0x00e2
        L_0x0037:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            boolean r2 = r4.equals(r2)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            if (r2 == 0) goto L_0x00e2
            return
        L_0x0042:
            r10 = move-exception
            goto L_0x00e8
        L_0x0045:
            r10 = move-exception
            goto L_0x00ec
        L_0x0048:
            java.lang.String r2 = r11.getName()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            int r7 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r8 = 4
            switch(r7) {
                case -1962203927: goto L_0x007b;
                case -1239391468: goto L_0x0071;
                case 61998586: goto L_0x0069;
                case 366511058: goto L_0x005f;
                case 1791837707: goto L_0x0055;
                default: goto L_0x0054;
            }     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
        L_0x0054:
            goto L_0x0085
        L_0x0055:
            java.lang.String r4 = "CustomAttribute"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            if (r4 == 0) goto L_0x0085
            r4 = 3
            goto L_0x0086
        L_0x005f:
            java.lang.String r4 = "CustomMethod"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            if (r4 == 0) goto L_0x0085
            r4 = 4
            goto L_0x0086
        L_0x0069:
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            if (r4 == 0) goto L_0x0085
            r4 = 0
            goto L_0x0086
        L_0x0071:
            java.lang.String r4 = "KeyFrameSet"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            if (r4 == 0) goto L_0x0085
            r4 = 1
            goto L_0x0086
        L_0x007b:
            java.lang.String r4 = "ConstraintOverride"
            boolean r4 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            if (r4 == 0) goto L_0x0085
            r4 = 2
            goto L_0x0086
        L_0x0085:
            r4 = -1
        L_0x0086:
            if (r4 == 0) goto L_0x00df
            if (r4 == r3) goto L_0x00d7
            if (r4 == r6) goto L_0x00d0
            if (r4 == r5) goto L_0x00c8
            if (r4 == r8) goto L_0x00c8
            java.lang.String r3 = x     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.String r5 = androidx.constraintlayout.motion.widget.Debug.f()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.String r5 = " unknown tag "
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r4.append(r2)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.String r2 = r4.toString()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            android.util.Log.e(r3, r2)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.String r2 = x     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.String r4 = ".xml:"
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            int r4 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.lang.String r3 = r3.toString()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            android.util.Log.e(r2, r3)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            goto L_0x00e2
        L_0x00c8:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = r9.f4572h     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r2 = r2.f4716g     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            androidx.constraintlayout.widget.ConstraintAttribute.q(r10, r11, r2)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            goto L_0x00e2
        L_0x00d0:
            androidx.constraintlayout.widget.ConstraintSet$Constraint r2 = androidx.constraintlayout.widget.ConstraintSet.w(r10, r11)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r9.f4572h = r2     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            goto L_0x00e2
        L_0x00d7:
            androidx.constraintlayout.motion.widget.KeyFrames r2 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r2.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            r9.f4571g = r2     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            goto L_0x00e2
        L_0x00df:
            r9.n(r10, r11)     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
        L_0x00e2:
            int r2 = r11.next()     // Catch:{ XmlPullParserException -> 0x0045, IOException -> 0x0042 }
            goto L_0x002a
        L_0x00e8:
            r10.printStackTrace()
            goto L_0x00ef
        L_0x00ec:
            r10.printStackTrace()
        L_0x00ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.ViewTransition.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(View[] viewArr) {
        if (this.q != -1) {
            for (View tag : viewArr) {
                tag.setTag(this.q, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.r != -1) {
            for (View tag2 : viewArr) {
                tag2.setTag(this.r, (Object) null);
            }
        }
    }

    private void n(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Bo);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.Co) {
                this.f4566b = obtainStyledAttributes.getResourceId(index, this.f4566b);
            } else if (index == R.styleable.Ko) {
                if (MotionLayout.p5) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.f4575k);
                    this.f4575k = resourceId;
                    if (resourceId != -1) {
                    }
                } else if (obtainStyledAttributes.peekValue(index).type != 3) {
                    this.f4575k = obtainStyledAttributes.getResourceId(index, this.f4575k);
                }
                this.f4576l = obtainStyledAttributes.getString(index);
            } else if (index == R.styleable.Lo) {
                this.f4567c = obtainStyledAttributes.getInt(index, this.f4567c);
            } else if (index == R.styleable.Oo) {
                this.f4568d = obtainStyledAttributes.getBoolean(index, this.f4568d);
            } else if (index == R.styleable.Mo) {
                this.f4569e = obtainStyledAttributes.getInt(index, this.f4569e);
            } else if (index == R.styleable.Go) {
                this.f4573i = obtainStyledAttributes.getInt(index, this.f4573i);
            } else if (index == R.styleable.Po) {
                this.f4574j = obtainStyledAttributes.getInt(index, this.f4574j);
            } else if (index == R.styleable.Qo) {
                this.f4570f = obtainStyledAttributes.getInt(index, this.f4570f);
            } else if (index == R.styleable.Jo) {
                int i3 = obtainStyledAttributes.peekValue(index).type;
                if (i3 == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.o = resourceId2;
                    if (resourceId2 == -1) {
                    }
                } else if (i3 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f4578n = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.f4577m = -1;
                    } else {
                        this.o = obtainStyledAttributes.getResourceId(index, -1);
                    }
                } else {
                    this.f4577m = obtainStyledAttributes.getInteger(index, this.f4577m);
                }
                this.f4577m = -2;
            } else if (index == R.styleable.No) {
                this.q = obtainStyledAttributes.getResourceId(index, this.q);
            } else if (index == R.styleable.Fo) {
                this.r = obtainStyledAttributes.getResourceId(index, this.r);
            } else if (index == R.styleable.Io) {
                this.s = obtainStyledAttributes.getResourceId(index, this.s);
            } else if (index == R.styleable.Ho) {
                this.t = obtainStyledAttributes.getResourceId(index, this.t);
            } else if (index == R.styleable.Eo) {
                this.v = obtainStyledAttributes.getResourceId(index, this.v);
            } else if (index == R.styleable.Do) {
                this.u = obtainStyledAttributes.getInteger(index, this.u);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void v(MotionScene.Transition transition, View view) {
        int i2 = this.f4573i;
        if (i2 != -1) {
            transition.O(i2);
        }
        transition.V(this.f4569e);
        transition.R(this.f4577m, this.f4578n, this.o);
        int id = view.getId();
        KeyFrames keyFrames = this.f4571g;
        if (keyFrames != null) {
            ArrayList<Key> d2 = keyFrames.d(-1);
            KeyFrames keyFrames2 = new KeyFrames();
            Iterator<Key> it2 = d2.iterator();
            while (it2.hasNext()) {
                keyFrames2.c(it2.next().clone().k(id));
            }
            transition.t(keyFrames2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ViewTransitionController viewTransitionController, MotionLayout motionLayout, View view) {
        MotionController motionController = new MotionController(view);
        motionController.R(view);
        this.f4571g.a(motionController);
        motionController.a0(motionLayout.getWidth(), motionLayout.getHeight(), (float) this.f4573i, System.nanoTime());
        ViewTransitionController viewTransitionController2 = viewTransitionController;
        MotionController motionController2 = motionController;
        new Animate(viewTransitionController2, motionController2, this.f4573i, this.f4574j, this.f4567c, f(motionLayout.getContext()), this.q, this.r);
    }

    /* access modifiers changed from: package-private */
    public void c(ViewTransitionController viewTransitionController, MotionLayout motionLayout, int i2, ConstraintSet constraintSet, View... viewArr) {
        if (!this.f4568d) {
            int i3 = this.f4570f;
            if (i3 == 2) {
                b(viewTransitionController, motionLayout, viewArr[0]);
                return;
            }
            if (i3 == 1) {
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                for (int i4 : constraintSetIds) {
                    if (i4 != i2) {
                        ConstraintSet B0 = motionLayout.B0(i4);
                        for (View id : viewArr) {
                            ConstraintSet.Constraint k0 = B0.k0(id.getId());
                            ConstraintSet.Constraint constraint = this.f4572h;
                            if (constraint != null) {
                                constraint.h(k0);
                                k0.f4716g.putAll(this.f4572h.f4716g);
                            }
                        }
                    }
                }
            }
            ConstraintSet constraintSet2 = new ConstraintSet();
            constraintSet2.I(constraintSet);
            for (View id2 : viewArr) {
                ConstraintSet.Constraint k02 = constraintSet2.k0(id2.getId());
                ConstraintSet.Constraint constraint2 = this.f4572h;
                if (constraint2 != null) {
                    constraint2.h(k02);
                    k02.f4716g.putAll(this.f4572h.f4716g);
                }
            }
            motionLayout.l1(i2, constraintSet2);
            int i5 = R.id.N3;
            motionLayout.l1(i5, constraintSet);
            motionLayout.F(i5, -1, -1);
            MotionScene.Transition transition = new MotionScene.Transition(-1, motionLayout.E3, i5, i2);
            for (View v2 : viewArr) {
                v(transition, v2);
            }
            motionLayout.setTransition(transition);
            motionLayout.e1(new a(this, viewArr));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d(View view) {
        int i2 = this.s;
        boolean z2 = i2 == -1 || view.getTag(i2) != null;
        int i3 = this.t;
        return z2 && (i3 == -1 || view.getTag(i3) == null);
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f4566b;
    }

    /* access modifiers changed from: package-private */
    public Interpolator f(Context context) {
        int i2 = this.f4577m;
        if (i2 == -2) {
            return AnimationUtils.loadInterpolator(context, this.o);
        }
        if (i2 == -1) {
            final Easing c2 = Easing.c(this.f4578n);
            return new Interpolator(this) {
                public float getInterpolation(float f2) {
                    return (float) c2.a((double) f2);
                }
            };
        } else if (i2 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (i2 == 1) {
                return new AccelerateInterpolator();
            }
            if (i2 == 2) {
                return new DecelerateInterpolator();
            }
            if (i2 == 4) {
                return new BounceInterpolator();
            }
            if (i2 == 5) {
                return new OvershootInterpolator();
            }
            if (i2 != 6) {
                return null;
            }
            return new AnticipateInterpolator();
        }
    }

    public int g() {
        return this.u;
    }

    public int h() {
        return this.w;
    }

    public int i() {
        return this.v;
    }

    public int j() {
        return this.f4567c;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return !this.f4568d;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        r5 = ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r5.getLayoutParams()).c0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m(android.view.View r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r4.f4575k
            r2 = -1
            if (r1 != r2) goto L_0x000e
            java.lang.String r1 = r4.f4576l
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            boolean r1 = r4.d(r5)
            if (r1 != 0) goto L_0x0015
            return r0
        L_0x0015:
            int r1 = r5.getId()
            int r2 = r4.f4575k
            r3 = 1
            if (r1 != r2) goto L_0x001f
            return r3
        L_0x001f:
            java.lang.String r1 = r4.f4576l
            if (r1 != 0) goto L_0x0024
            return r0
        L_0x0024:
            android.view.ViewGroup$LayoutParams r1 = r5.getLayoutParams()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r1 == 0) goto L_0x003f
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r5 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r5
            java.lang.String r5 = r5.c0
            if (r5 == 0) goto L_0x003f
            java.lang.String r1 = r4.f4576l
            boolean r5 = r5.matches(r1)
            if (r5 == 0) goto L_0x003f
            return r3
        L_0x003f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.ViewTransition.m(android.view.View):boolean");
    }

    /* access modifiers changed from: package-private */
    public void o(boolean z2) {
        this.f4568d = !z2;
    }

    /* access modifiers changed from: package-private */
    public void p(int i2) {
        this.f4566b = i2;
    }

    public void q(int i2) {
        this.u = i2;
    }

    public void r(int i2) {
        this.w = i2;
    }

    public void s(int i2) {
        this.v = i2;
    }

    public void t(int i2) {
        this.f4567c = i2;
    }

    public String toString() {
        return "ViewTransition(" + Debug.i(this.p, this.f4566b) + ")";
    }

    /* access modifiers changed from: package-private */
    public boolean u(int i2) {
        int i3 = this.f4567c;
        return i3 == 1 ? i2 == 0 : i3 == 2 ? i2 == 1 : i3 == 3 && i2 == 0;
    }
}
