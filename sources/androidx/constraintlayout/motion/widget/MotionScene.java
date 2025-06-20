package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MotionScene {
    private static final int A = -1;
    private static final int B = -2;
    public static final int C = -1;
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = 2;
    private static final String G = "MotionScene";
    private static final String H = "Transition";
    private static final String I = "OnSwipe";
    private static final String J = "OnClick";
    private static final String K = "StateSet";
    private static final String L = "Include";
    private static final String M = "include";
    private static final String N = "KeyFrameSet";
    private static final String O = "ConstraintSet";
    private static final String P = "ViewTransition";
    static final int Q = 0;
    static final int R = 1;
    static final int S = 2;
    static final int T = 3;
    static final int U = 4;
    static final int V = 5;
    static final int W = 6;
    private static final String v = "MotionScene";
    private static final boolean w = false;
    private static final int x = 8;
    static final int y = 0;
    static final int z = 1;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final MotionLayout f4507a;

    /* renamed from: b  reason: collision with root package name */
    StateSet f4508b = null;

    /* renamed from: c  reason: collision with root package name */
    Transition f4509c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4510d = false;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Transition> f4511e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private Transition f4512f = null;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<Transition> f4513g = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<ConstraintSet> f4514h = new SparseArray<>();

    /* renamed from: i  reason: collision with root package name */
    private HashMap<String, Integer> f4515i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private SparseIntArray f4516j = new SparseIntArray();

    /* renamed from: k  reason: collision with root package name */
    private boolean f4517k = false;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f4518l = 400;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f4519m = 0;

    /* renamed from: n  reason: collision with root package name */
    private MotionEvent f4520n;
    private boolean o = false;
    private boolean p = false;
    private MotionLayout.MotionTracker q;
    private boolean r;
    final ViewTransitionController s;
    float t;
    float u;

    public static class Transition {
        public static final int A = -2;
        public static final int B = -1;
        public static final int C = 0;
        public static final int D = 1;
        public static final int E = 2;
        public static final int F = 3;
        public static final int G = 4;
        public static final int H = 5;
        public static final int I = 6;
        public static final int s = 0;
        public static final int t = 1;
        public static final int u = 2;
        public static final int v = 3;
        public static final int w = 4;
        static final int x = 1;
        static final int y = 2;
        static final int z = 4;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f4522a = -1;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f4523b = false;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f4524c = -1;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f4525d = -1;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f4526e = 0;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public String f4527f = null;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f4528g = -1;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f4529h = 400;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public float f4530i = 0.0f;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public final MotionScene f4531j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public ArrayList<KeyFrames> f4532k = new ArrayList<>();
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public TouchResponse f4533l = null;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public ArrayList<TransitionOnClick> f4534m = new ArrayList<>();
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public int f4535n = 0;
        /* access modifiers changed from: private */
        public boolean o = false;
        /* access modifiers changed from: private */
        public int p = -1;
        private int q = 0;
        private int r = 0;

        public static class TransitionOnClick implements View.OnClickListener {
            public static final int X2 = 17;
            public static final int Y2 = 16;
            public static final int Z = 1;
            public static final int Z2 = 256;
            public static final int a3 = 4096;
            int X;
            int Y;
            private final Transition s;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.X = -1;
                this.Y = 17;
                this.s = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.xk);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = obtainStyledAttributes.getIndex(i2);
                    if (index == R.styleable.zk) {
                        this.X = obtainStyledAttributes.getResourceId(index, this.X);
                    } else if (index == R.styleable.yk) {
                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public void a(MotionLayout motionLayout, int i2, Transition transition) {
                int i3 = this.X;
                View view = motionLayout;
                if (i3 != -1) {
                    view = motionLayout.findViewById(i3);
                }
                if (view == null) {
                    Log.e(TypedValues.MotionScene.f3976a, "OnClick could not find id " + this.X);
                    return;
                }
                int c2 = transition.f4525d;
                int a2 = transition.f4524c;
                if (c2 == -1) {
                    view.setOnClickListener(this);
                    return;
                }
                int i4 = this.Y;
                boolean z = false;
                boolean z2 = ((i4 & 1) != 0 && i2 == c2) | ((i4 & 1) != 0 && i2 == c2) | ((i4 & 256) != 0 && i2 == c2) | ((i4 & 16) != 0 && i2 == a2);
                if ((i4 & 4096) != 0 && i2 == a2) {
                    z = true;
                }
                if (z2 || z) {
                    view.setOnClickListener(this);
                }
            }

            /* access modifiers changed from: package-private */
            public boolean b(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.s;
                if (transition2 == transition) {
                    return true;
                }
                int a2 = transition2.f4524c;
                int c2 = this.s.f4525d;
                int i2 = motionLayout.J3;
                return c2 == -1 ? i2 != a2 : i2 == c2 || i2 == a2;
            }

            public void c(MotionLayout motionLayout) {
                int i2 = this.X;
                if (i2 != -1) {
                    View findViewById = motionLayout.findViewById(i2);
                    if (findViewById == null) {
                        Log.e(TypedValues.MotionScene.f3976a, " (*)  could not find id " + this.X);
                        return;
                    }
                    findViewById.setOnClickListener((View.OnClickListener) null);
                }
            }

            public void onClick(View view) {
                float f2;
                MotionLayout d2 = this.s.f4531j.f4507a;
                if (d2.L0()) {
                    if (this.s.f4525d == -1) {
                        int currentState = d2.getCurrentState();
                        if (currentState == -1) {
                            d2.g1(this.s.f4524c);
                            return;
                        }
                        Transition transition = new Transition(this.s.f4531j, this.s);
                        int unused = transition.f4525d = currentState;
                        int unused2 = transition.f4524c = this.s.f4524c;
                        d2.setTransition(transition);
                        d2.d1();
                        return;
                    }
                    Transition transition2 = this.s.f4531j.f4509c;
                    int i2 = this.Y;
                    boolean z = false;
                    boolean z2 = ((i2 & 1) == 0 && (i2 & 256) == 0) ? false : true;
                    boolean z3 = ((i2 & 16) == 0 && (i2 & 4096) == 0) ? false : true;
                    if (!z2 || !z3) {
                        z = z2;
                    } else {
                        Transition transition3 = this.s.f4531j.f4509c;
                        Transition transition4 = this.s;
                        if (transition3 != transition4) {
                            d2.setTransition(transition4);
                        }
                        if (d2.getCurrentState() != d2.getEndState() && d2.getProgress() <= 0.5f) {
                            z = z2;
                            z3 = false;
                        }
                    }
                    if (!b(transition2, d2)) {
                        return;
                    }
                    if (z && (this.Y & 1) != 0) {
                        d2.setTransition(this.s);
                        d2.d1();
                    } else if (!z3 || (this.Y & 16) == 0) {
                        if (z && (this.Y & 256) != 0) {
                            d2.setTransition(this.s);
                            f2 = 1.0f;
                        } else if (z3 && (this.Y & 4096) != 0) {
                            d2.setTransition(this.s);
                            f2 = 0.0f;
                        } else {
                            return;
                        }
                        d2.setProgress(f2);
                    } else {
                        d2.setTransition(this.s);
                        d2.f1();
                    }
                }
            }

            public TransitionOnClick(Transition transition, int i2, int i3) {
                this.s = transition;
                this.X = i2;
                this.Y = i3;
            }
        }

        public Transition(int i2, MotionScene motionScene, int i3, int i4) {
            this.f4522a = i2;
            this.f4531j = motionScene;
            this.f4525d = i3;
            this.f4524c = i4;
            this.f4529h = motionScene.f4518l;
            this.q = motionScene.f4519m;
        }

        private void x(MotionScene motionScene, Context context, TypedArray typedArray) {
            ConstraintSet constraintSet;
            SparseArray b2;
            int i2;
            int indexCount = typedArray.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArray.getIndex(i3);
                if (index == R.styleable.Xn) {
                    this.f4524c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4524c);
                    if (TtmlNode.w.equals(resourceTypeName)) {
                        constraintSet = new ConstraintSet();
                        constraintSet.w0(context, this.f4524c);
                        b2 = motionScene.f4514h;
                        i2 = this.f4524c;
                    } else {
                        if (HTML.Tag.f27613a.equals(resourceTypeName)) {
                            this.f4524c = motionScene.a0(context, this.f4524c);
                        }
                    }
                } else {
                    if (index == R.styleable.Yn) {
                        this.f4525d = typedArray.getResourceId(index, this.f4525d);
                        String resourceTypeName2 = context.getResources().getResourceTypeName(this.f4525d);
                        if (TtmlNode.w.equals(resourceTypeName2)) {
                            constraintSet = new ConstraintSet();
                            constraintSet.w0(context, this.f4525d);
                            b2 = motionScene.f4514h;
                            i2 = this.f4525d;
                        } else if (HTML.Tag.f27613a.equals(resourceTypeName2)) {
                            this.f4525d = motionScene.a0(context, this.f4525d);
                        }
                    } else if (index == R.styleable.bo) {
                        int i4 = typedArray.peekValue(index).type;
                        if (i4 == 1) {
                            int resourceId = typedArray.getResourceId(index, -1);
                            this.f4528g = resourceId;
                            if (resourceId == -1) {
                            }
                        } else if (i4 == 3) {
                            String string = typedArray.getString(index);
                            this.f4527f = string;
                            if (string != null) {
                                if (string.indexOf("/") > 0) {
                                    this.f4528g = typedArray.getResourceId(index, -1);
                                } else {
                                    this.f4526e = -1;
                                }
                            }
                        } else {
                            this.f4526e = typedArray.getInteger(index, this.f4526e);
                        }
                        this.f4526e = -2;
                    } else if (index == R.styleable.Zn) {
                        int i5 = typedArray.getInt(index, this.f4529h);
                        this.f4529h = i5;
                        if (i5 < 8) {
                            this.f4529h = 8;
                        }
                    } else if (index == R.styleable.eo) {
                        this.f4530i = typedArray.getFloat(index, this.f4530i);
                    } else if (index == R.styleable.Wn) {
                        this.f4535n = typedArray.getInteger(index, this.f4535n);
                    } else if (index == R.styleable.Vn) {
                        this.f4522a = typedArray.getResourceId(index, this.f4522a);
                    } else if (index == R.styleable.fo) {
                        this.o = typedArray.getBoolean(index, this.o);
                    } else if (index == R.styleable.co) {
                        this.p = typedArray.getInteger(index, -1);
                    } else if (index == R.styleable.ao) {
                        this.q = typedArray.getInteger(index, 0);
                    } else if (index == R.styleable.go) {
                        this.r = typedArray.getInteger(index, 0);
                    }
                }
                b2.append(i2, constraintSet);
            }
            if (this.f4525d == -1) {
                this.f4523b = true;
            }
        }

        private void y(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Un);
            x(motionScene, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public int A() {
            return this.f4529h;
        }

        public int B() {
            return this.f4524c;
        }

        public int C() {
            return this.f4522a;
        }

        public List<KeyFrames> D() {
            return this.f4532k;
        }

        public int E() {
            return this.q;
        }

        public List<TransitionOnClick> F() {
            return this.f4534m;
        }

        public int G() {
            return this.p;
        }

        public float H() {
            return this.f4530i;
        }

        public int I() {
            return this.f4525d;
        }

        public TouchResponse J() {
            return this.f4533l;
        }

        public boolean K() {
            return !this.o;
        }

        public boolean L(int i2) {
            return (i2 & this.r) != 0;
        }

        public void M(int i2) {
            TransitionOnClick transitionOnClick;
            Iterator<TransitionOnClick> it2 = this.f4534m.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    transitionOnClick = null;
                    break;
                }
                transitionOnClick = it2.next();
                if (transitionOnClick.X == i2) {
                    break;
                }
            }
            if (transitionOnClick != null) {
                this.f4534m.remove(transitionOnClick);
            }
        }

        public void N(int i2) {
            this.f4535n = i2;
        }

        public void O(int i2) {
            this.f4529h = Math.max(i2, 8);
        }

        public void P(boolean z2) {
            Q(z2);
        }

        public void Q(boolean z2) {
            this.o = !z2;
        }

        public void R(int i2, String str, int i3) {
            this.f4526e = i2;
            this.f4527f = str;
            this.f4528g = i3;
        }

        public void S(int i2) {
            this.q = i2;
        }

        public void T(OnSwipe onSwipe) {
            this.f4533l = onSwipe == null ? null : new TouchResponse(this.f4531j.f4507a, onSwipe);
        }

        public void U(int i2) {
            TouchResponse J = J();
            if (J != null) {
                J.F(i2);
            }
        }

        public void V(int i2) {
            this.p = i2;
        }

        public void W(float f2) {
            this.f4530i = f2;
        }

        public void X(int i2) {
            this.r = i2;
        }

        public void t(KeyFrames keyFrames) {
            this.f4532k.add(keyFrames);
        }

        public void u(int i2, int i3) {
            Iterator<TransitionOnClick> it2 = this.f4534m.iterator();
            while (it2.hasNext()) {
                TransitionOnClick next = it2.next();
                if (next.X == i2) {
                    next.Y = i3;
                    return;
                }
            }
            this.f4534m.add(new TransitionOnClick(this, i2, i3));
        }

        public void v(Context context, XmlPullParser xmlPullParser) {
            this.f4534m.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        public String w(Context context) {
            String resourceEntryName = this.f4525d == -1 ? "null" : context.getResources().getResourceEntryName(this.f4525d);
            if (this.f4524c == -1) {
                return resourceEntryName + " -> null";
            }
            return resourceEntryName + " -> " + context.getResources().getResourceEntryName(this.f4524c);
        }

        public int z() {
            return this.f4535n;
        }

        Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.f4529h = motionScene.f4518l;
            this.q = motionScene.f4519m;
            this.f4531j = motionScene;
            y(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }

        Transition(MotionScene motionScene, Transition transition) {
            this.f4531j = motionScene;
            this.f4529h = motionScene.f4518l;
            if (transition != null) {
                this.p = transition.p;
                this.f4526e = transition.f4526e;
                this.f4527f = transition.f4527f;
                this.f4528g = transition.f4528g;
                this.f4529h = transition.f4529h;
                this.f4532k = transition.f4532k;
                this.f4530i = transition.f4530i;
                this.q = transition.q;
            }
        }
    }

    MotionScene(Context context, MotionLayout motionLayout, int i2) {
        this.f4507a = motionLayout;
        this.s = new ViewTransitionController(motionLayout);
        V(context, i2);
        SparseArray<ConstraintSet> sparseArray = this.f4514h;
        int i3 = R.id.V1;
        sparseArray.put(i3, new ConstraintSet());
        this.f4515i.put("motion_base", Integer.valueOf(i3));
    }

    static String A(Context context, int i2, XmlPullParser xmlPullParser) {
        return ".(" + Debug.i(context, i2) + ".xml:" + xmlPullParser.getLineNumber() + ") \"" + xmlPullParser.getName() + "\"";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.e(r3, -1, -1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int G(int r3) {
        /*
            r2 = this;
            androidx.constraintlayout.widget.StateSet r0 = r2.f4508b
            if (r0 == 0) goto L_0x000c
            r1 = -1
            int r0 = r0.e(r3, r1, r1)
            if (r0 == r1) goto L_0x000c
            return r0
        L_0x000c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.G(int):int");
    }

    private boolean R(int i2) {
        int i3 = this.f4516j.get(i2);
        int size = this.f4516j.size();
        while (i3 > 0) {
            if (i3 == i2) {
                return true;
            }
            int i4 = size - 1;
            if (size < 0) {
                return true;
            }
            i3 = this.f4516j.get(i3);
            size = i4;
        }
        return false;
    }

    private boolean T() {
        return this.q != null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void V(android.content.Context r9, int r10) {
        /*
            r8 = this;
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.XmlResourceParser r0 = r0.getXml(r10)
            int r1 = r0.getEventType()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r2 = 0
        L_0x000d:
            r3 = 1
            if (r1 == r3) goto L_0x0178
            if (r1 == 0) goto L_0x0168
            r4 = 2
            if (r1 == r4) goto L_0x0017
            goto L_0x016b
        L_0x0017:
            java.lang.String r1 = r0.getName()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            boolean r5 = r8.f4517k     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r5 == 0) goto L_0x003c
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r7 = "parsing = "
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r6.append(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r6 = r6.toString()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r5.println(r6)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x003c
        L_0x0036:
            r9 = move-exception
            goto L_0x0171
        L_0x0039:
            r9 = move-exception
            goto L_0x0175
        L_0x003c:
            int r5 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r6 = "MotionScene"
            r7 = -1
            switch(r5) {
                case -1349929691: goto L_0x00a1;
                case -1239391468: goto L_0x0096;
                case -687739768: goto L_0x008c;
                case 61998586: goto L_0x0081;
                case 269306229: goto L_0x0078;
                case 312750793: goto L_0x006e;
                case 327855227: goto L_0x0064;
                case 793277014: goto L_0x005c;
                case 1382829617: goto L_0x0052;
                case 1942574248: goto L_0x0048;
                default: goto L_0x0046;
            }
        L_0x0046:
            goto L_0x00ab
        L_0x0048:
            java.lang.String r3 = "include"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 6
            goto L_0x00ac
        L_0x0052:
            java.lang.String r3 = "StateSet"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 4
            goto L_0x00ac
        L_0x005c:
            boolean r1 = r1.equals(r6)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 0
            goto L_0x00ac
        L_0x0064:
            java.lang.String r3 = "OnSwipe"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 2
            goto L_0x00ac
        L_0x006e:
            java.lang.String r3 = "OnClick"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 3
            goto L_0x00ac
        L_0x0078:
            java.lang.String r4 = "Transition"
            boolean r1 = r1.equals(r4)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            goto L_0x00ac
        L_0x0081:
            java.lang.String r3 = "ViewTransition"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 9
            goto L_0x00ac
        L_0x008c:
            java.lang.String r3 = "Include"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 7
            goto L_0x00ac
        L_0x0096:
            java.lang.String r3 = "KeyFrameSet"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 8
            goto L_0x00ac
        L_0x00a1:
            java.lang.String r3 = "ConstraintSet"
            boolean r1 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x00ab
            r3 = 5
            goto L_0x00ac
        L_0x00ab:
            r3 = -1
        L_0x00ac:
            switch(r3) {
                case 0: goto L_0x0164;
                case 1: goto L_0x0123;
                case 2: goto L_0x00e7;
                case 3: goto L_0x00e0;
                case 4: goto L_0x00d7;
                case 5: goto L_0x00d2;
                case 6: goto L_0x00cd;
                case 7: goto L_0x00cd;
                case 8: goto L_0x00bd;
                case 9: goto L_0x00b1;
                default: goto L_0x00af;
            }     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x00af:
            goto L_0x016b
        L_0x00b1:
            androidx.constraintlayout.motion.widget.ViewTransition r1 = new androidx.constraintlayout.motion.widget.ViewTransition     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.ViewTransitionController r3 = r8.s     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r3.b(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x00bd:
            androidx.constraintlayout.motion.widget.KeyFrames r1 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r2 == 0) goto L_0x016b
            java.util.ArrayList r3 = r2.f4532k     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r3.add(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x00cd:
            r8.b0(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x00d2:
            r8.Z(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x00d7:
            androidx.constraintlayout.widget.StateSet r1 = new androidx.constraintlayout.widget.StateSet     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r8.f4508b = r1     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x00e0:
            if (r2 == 0) goto L_0x016b
            r2.v(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x00e7:
            if (r2 != 0) goto L_0x0116
            android.content.res.Resources r1 = r9.getResources()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r1 = r1.getResourceEntryName(r10)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            int r3 = r0.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r5 = " OnSwipe ("
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r4.append(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r1 = ".xml:"
            r4.append(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r4.append(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r1 = ")"
            r4.append(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r1 = r4.toString()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            android.util.Log.v(r6, r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x0116:
            if (r2 == 0) goto L_0x016b
            androidx.constraintlayout.motion.widget.TouchResponse r1 = new androidx.constraintlayout.motion.widget.TouchResponse     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r8.f4507a     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.<init>(r9, r3, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.TouchResponse unused = r2.f4533l = r1     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x0123:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r1 = r8.f4511e     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r2 = new androidx.constraintlayout.motion.widget.MotionScene$Transition     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r2.<init>(r8, r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r8.f4509c     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 != 0) goto L_0x014a
            boolean r1 = r2.f4523b     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 != 0) goto L_0x014a
            r8.f4509c = r2     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.TouchResponse r1 = r2.f4533l     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x014a
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r8.f4509c     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.TouchResponse r1 = r1.f4533l     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            boolean r3 = r8.r     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.D(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x014a:
            boolean r1 = r2.f4523b     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x016b
            int r1 = r2.f4524c     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 != r7) goto L_0x0159
            r8.f4512f = r2     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x015e
        L_0x0159:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r1 = r8.f4513g     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x015e:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r1 = r8.f4511e     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.remove(r2)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x0164:
            r8.c0(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x016b
        L_0x0168:
            r0.getName()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x016b:
            int r1 = r0.next()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x000d
        L_0x0171:
            r9.printStackTrace()
            goto L_0x0178
        L_0x0175:
            r9.printStackTrace()
        L_0x0178:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.V(android.content.Context, int):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int Z(android.content.Context r17, org.xmlpull.v1.XmlPullParser r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r4 = 3
            r6 = 1
            androidx.constraintlayout.widget.ConstraintSet r7 = new androidx.constraintlayout.widget.ConstraintSet
            r7.<init>()
            r8 = 0
            r7.a1(r8)
            int r9 = r18.getAttributeCount()
            r11 = 0
            r12 = -1
            r13 = -1
        L_0x0018:
            if (r11 >= r9) goto L_0x00f0
            java.lang.String r14 = r2.getAttributeName(r11)
            java.lang.String r15 = r2.getAttributeValue(r11)
            boolean r10 = r0.f4517k
            if (r10 == 0) goto L_0x003c
            java.io.PrintStream r10 = java.lang.System.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "id string = "
            r3.append(r5)
            r3.append(r15)
            java.lang.String r3 = r3.toString()
            r10.println(r3)
        L_0x003c:
            r14.hashCode()
            int r3 = r14.hashCode()
            switch(r3) {
                case -1496482599: goto L_0x005e;
                case -1153153640: goto L_0x0053;
                case 3355: goto L_0x0048;
                default: goto L_0x0046;
            }
        L_0x0046:
            r3 = -1
            goto L_0x0068
        L_0x0048:
            java.lang.String r3 = "id"
            boolean r3 = r14.equals(r3)
            if (r3 != 0) goto L_0x0051
            goto L_0x0046
        L_0x0051:
            r3 = 2
            goto L_0x0068
        L_0x0053:
            java.lang.String r3 = "constraintRotate"
            boolean r3 = r14.equals(r3)
            if (r3 != 0) goto L_0x005c
            goto L_0x0046
        L_0x005c:
            r3 = 1
            goto L_0x0068
        L_0x005e:
            java.lang.String r3 = "deriveConstraintsFrom"
            boolean r3 = r14.equals(r3)
            if (r3 != 0) goto L_0x0067
            goto L_0x0046
        L_0x0067:
            r3 = 0
        L_0x0068:
            switch(r3) {
                case 0: goto L_0x00e7;
                case 1: goto L_0x0087;
                case 2: goto L_0x006c;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x0083
        L_0x006c:
            int r12 = r0.v(r1, r15)
            java.util.HashMap<java.lang.String, java.lang.Integer> r3 = r0.f4515i
            java.lang.String r5 = q0(r15)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r12)
            r3.put(r5, r10)
            java.lang.String r3 = androidx.constraintlayout.motion.widget.Debug.i(r1, r12)
            r7.f4704b = r3
        L_0x0083:
            r3 = 2
        L_0x0084:
            r5 = 4
            goto L_0x00ed
        L_0x0087:
            int r3 = java.lang.Integer.parseInt(r15)     // Catch:{ NumberFormatException -> 0x008e }
            r7.f4706d = r3     // Catch:{ NumberFormatException -> 0x008e }
            goto L_0x0083
        L_0x008e:
            r15.hashCode()
            int r3 = r15.hashCode()
            switch(r3) {
                case -768416914: goto L_0x00c7;
                case 3317767: goto L_0x00bc;
                case 3387192: goto L_0x00b1;
                case 108511772: goto L_0x00a6;
                case 1954540437: goto L_0x009b;
                default: goto L_0x0099;
            }
        L_0x0099:
            r3 = -1
            goto L_0x00d1
        L_0x009b:
            java.lang.String r3 = "x_right"
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00a4
            goto L_0x0099
        L_0x00a4:
            r3 = 4
            goto L_0x00d1
        L_0x00a6:
            java.lang.String r3 = "right"
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00af
            goto L_0x0099
        L_0x00af:
            r3 = 3
            goto L_0x00d1
        L_0x00b1:
            java.lang.String r3 = "none"
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00ba
            goto L_0x0099
        L_0x00ba:
            r3 = 2
            goto L_0x00d1
        L_0x00bc:
            java.lang.String r3 = "left"
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00c5
            goto L_0x0099
        L_0x00c5:
            r3 = 1
            goto L_0x00d1
        L_0x00c7:
            java.lang.String r3 = "x_left"
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00d0
            goto L_0x0099
        L_0x00d0:
            r3 = 0
        L_0x00d1:
            switch(r3) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00de;
                case 2: goto L_0x00db;
                case 3: goto L_0x00d8;
                case 4: goto L_0x00d5;
                default: goto L_0x00d4;
            }
        L_0x00d4:
            goto L_0x006b
        L_0x00d5:
            r7.f4706d = r4
            goto L_0x0083
        L_0x00d8:
            r7.f4706d = r6
            goto L_0x0083
        L_0x00db:
            r7.f4706d = r8
            goto L_0x0083
        L_0x00de:
            r3 = 2
            r7.f4706d = r3
            goto L_0x0084
        L_0x00e2:
            r3 = 2
            r5 = 4
            r7.f4706d = r5
            goto L_0x00ed
        L_0x00e7:
            r3 = 2
            r5 = 4
            int r13 = r0.v(r1, r15)
        L_0x00ed:
            int r11 = r11 + r6
            goto L_0x0018
        L_0x00f0:
            r10 = -1
            if (r12 == r10) goto L_0x010b
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.f4507a
            int r3 = r3.b4
            if (r3 == 0) goto L_0x00fc
            r7.z1(r6)
        L_0x00fc:
            r7.x0(r1, r2)
            if (r13 == r10) goto L_0x0106
            android.util.SparseIntArray r1 = r0.f4516j
            r1.put(r12, r13)
        L_0x0106:
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> r1 = r0.f4514h
            r1.put(r12, r7)
        L_0x010b:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.Z(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    /* access modifiers changed from: private */
    public int a0(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && O.equals(name)) {
                    return Z(context, xml);
                }
            }
            return -1;
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
            return -1;
        } catch (IOException e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    private void b0(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Ro);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.So) {
                a0(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void c0(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.qk);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.rk) {
                int i3 = obtainStyledAttributes.getInt(index, this.f4518l);
                this.f4518l = i3;
                if (i3 < 8) {
                    this.f4518l = 8;
                }
            } else if (index == R.styleable.sk) {
                this.f4519m = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void g0(int i2, MotionLayout motionLayout) {
        ConstraintSet constraintSet = this.f4514h.get(i2);
        constraintSet.f4705c = constraintSet.f4704b;
        int i3 = this.f4516j.get(i2);
        if (i3 > 0) {
            g0(i3, motionLayout);
            ConstraintSet constraintSet2 = this.f4514h.get(i3);
            if (constraintSet2 == null) {
                Log.e(TypedValues.MotionScene.f3976a, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.i(this.f4507a.getContext(), i3));
                return;
            }
            constraintSet.f4705c += "/" + constraintSet2.f4705c;
            constraintSet.J0(constraintSet2);
        } else {
            constraintSet.f4705c += "  layout";
            constraintSet.I0(motionLayout);
        }
        constraintSet.q(constraintSet);
    }

    public static String q0(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        return indexOf < 0 ? str : str.substring(indexOf + 1);
    }

    private int v(Context context, String str) {
        int i2;
        if (str.contains("/")) {
            i2 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.f4517k) {
                PrintStream printStream = System.out;
                printStream.println("id getMap res = " + i2);
            }
        } else {
            i2 = -1;
        }
        if (i2 != -1) {
            return i2;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e(TypedValues.MotionScene.f3976a, "error in parsing id");
        return i2;
    }

    private int w(Transition transition) {
        int o2 = transition.f4522a;
        if (o2 != -1) {
            for (int i2 = 0; i2 < this.f4511e.size(); i2++) {
                if (this.f4511e.get(i2).f4522a == o2) {
                    return i2;
                }
            }
            return -1;
        }
        throw new IllegalArgumentException("The transition must have an id");
    }

    /* access modifiers changed from: package-private */
    public float B() {
        Transition transition = this.f4509c;
        if (transition == null || transition.f4533l == null) {
            return 0.0f;
        }
        return this.f4509c.f4533l.i();
    }

    /* access modifiers changed from: package-private */
    public float C() {
        Transition transition = this.f4509c;
        if (transition == null || transition.f4533l == null) {
            return 0.0f;
        }
        return this.f4509c.f4533l.j();
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        Transition transition = this.f4509c;
        if (transition == null || transition.f4533l == null) {
            return false;
        }
        return this.f4509c.f4533l.k();
    }

    public float E(View view, int i2) {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float F(float f2, float f3) {
        Transition transition = this.f4509c;
        if (transition == null || transition.f4533l == null) {
            return 0.0f;
        }
        return this.f4509c.f4533l.l(f2, f3);
    }

    /* access modifiers changed from: package-private */
    public int H() {
        Transition transition = this.f4509c;
        if (transition == null || transition.f4533l == null) {
            return 0;
        }
        return this.f4509c.f4533l.m();
    }

    /* access modifiers changed from: package-private */
    public float I() {
        Transition transition = this.f4509c;
        if (transition == null || transition.f4533l == null) {
            return 0.0f;
        }
        return this.f4509c.f4533l.n();
    }

    /* access modifiers changed from: package-private */
    public float J() {
        Transition transition = this.f4509c;
        if (transition == null || transition.f4533l == null) {
            return 0.0f;
        }
        return this.f4509c.f4533l.o();
    }

    /* access modifiers changed from: package-private */
    public float K() {
        Transition transition = this.f4509c;
        if (transition == null || transition.f4533l == null) {
            return 0.0f;
        }
        return this.f4509c.f4533l.p();
    }

    /* access modifiers changed from: package-private */
    public float L() {
        Transition transition = this.f4509c;
        if (transition == null || transition.f4533l == null) {
            return 0.0f;
        }
        return this.f4509c.f4533l.q();
    }

    public float M() {
        Transition transition = this.f4509c;
        if (transition != null) {
            return transition.f4530i;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int N() {
        Transition transition = this.f4509c;
        if (transition == null) {
            return -1;
        }
        return transition.f4525d;
    }

    public Transition O(int i2) {
        Iterator<Transition> it2 = this.f4511e.iterator();
        while (it2.hasNext()) {
            Transition next = it2.next();
            if (next.f4522a == i2) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int P(int i2) {
        Iterator<Transition> it2 = this.f4511e.iterator();
        while (it2.hasNext()) {
            if (it2.next().f4525d == i2) {
                return 0;
            }
        }
        return 1;
    }

    public List<Transition> Q(int i2) {
        int G2 = G(i2);
        ArrayList arrayList = new ArrayList();
        Iterator<Transition> it2 = this.f4511e.iterator();
        while (it2.hasNext()) {
            Transition next = it2.next();
            if (next.f4525d == G2 || next.f4524c == G2) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public boolean S(View view, int i2) {
        Transition transition = this.f4509c;
        if (transition == null) {
            return false;
        }
        Iterator it2 = transition.f4532k.iterator();
        while (it2.hasNext()) {
            Iterator<Key> it3 = ((KeyFrames) it2.next()).d(view.getId()).iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (it3.next().f4375a == i2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean U(int i2) {
        return this.s.h(i2);
    }

    public int W(String str) {
        Integer num = this.f4515i.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String X(int i2) {
        for (Map.Entry next : this.f4515i.entrySet()) {
            Integer num = (Integer) next.getValue();
            if (num != null && num.intValue() == i2) {
                return (String) next.getKey();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void Y(boolean z2, int i2, int i3, int i4, int i5) {
    }

    /* access modifiers changed from: package-private */
    public void d0(float f2, float f3) {
        Transition transition = this.f4509c;
        if (transition != null && transition.f4533l != null) {
            this.f4509c.f4533l.w(f2, f3);
        }
    }

    /* access modifiers changed from: package-private */
    public void e0(float f2, float f3) {
        Transition transition = this.f4509c;
        if (transition != null && transition.f4533l != null) {
            this.f4509c.f4533l.x(f2, f3);
        }
    }

    public void f(MotionLayout motionLayout, int i2) {
        Iterator<Transition> it2 = this.f4511e.iterator();
        while (it2.hasNext()) {
            Transition next = it2.next();
            if (next.f4534m.size() > 0) {
                Iterator it3 = next.f4534m.iterator();
                while (it3.hasNext()) {
                    ((Transition.TransitionOnClick) it3.next()).c(motionLayout);
                }
            }
        }
        Iterator<Transition> it4 = this.f4513g.iterator();
        while (it4.hasNext()) {
            Transition next2 = it4.next();
            if (next2.f4534m.size() > 0) {
                Iterator it5 = next2.f4534m.iterator();
                while (it5.hasNext()) {
                    ((Transition.TransitionOnClick) it5.next()).c(motionLayout);
                }
            }
        }
        Iterator<Transition> it6 = this.f4511e.iterator();
        while (it6.hasNext()) {
            Transition next3 = it6.next();
            if (next3.f4534m.size() > 0) {
                Iterator it7 = next3.f4534m.iterator();
                while (it7.hasNext()) {
                    ((Transition.TransitionOnClick) it7.next()).a(motionLayout, i2, next3);
                }
            }
        }
        Iterator<Transition> it8 = this.f4513g.iterator();
        while (it8.hasNext()) {
            Transition next4 = it8.next();
            if (next4.f4534m.size() > 0) {
                Iterator it9 = next4.f4534m.iterator();
                while (it9.hasNext()) {
                    ((Transition.TransitionOnClick) it9.next()).a(motionLayout, i2, next4);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f0(MotionEvent motionEvent, int i2, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.q == null) {
            this.q = this.f4507a.P0();
        }
        this.q.d(motionEvent);
        if (i2 != -1) {
            int action = motionEvent.getAction();
            boolean z2 = false;
            if (action == 0) {
                this.t = motionEvent.getRawX();
                this.u = motionEvent.getRawY();
                this.f4520n = motionEvent;
                this.o = false;
                if (this.f4509c.f4533l != null) {
                    RectF g2 = this.f4509c.f4533l.g(this.f4507a, rectF);
                    if (g2 == null || g2.contains(this.f4520n.getX(), this.f4520n.getY())) {
                        RectF r2 = this.f4509c.f4533l.r(this.f4507a, rectF);
                        if (r2 == null || r2.contains(this.f4520n.getX(), this.f4520n.getY())) {
                            this.p = false;
                        } else {
                            this.p = true;
                        }
                        this.f4509c.f4533l.A(this.t, this.u);
                        return;
                    }
                    this.f4520n = null;
                    this.o = true;
                    return;
                }
                return;
            } else if (action == 2 && !this.o) {
                float rawY = motionEvent.getRawY() - this.u;
                float rawX = motionEvent.getRawX() - this.t;
                if ((((double) rawX) != 0.0d || ((double) rawY) != 0.0d) && (motionEvent2 = this.f4520n) != null) {
                    Transition j2 = j(i2, rawX, rawY, motionEvent2);
                    if (j2 != null) {
                        motionLayout.setTransition(j2);
                        RectF r3 = this.f4509c.f4533l.r(this.f4507a, rectF);
                        if (r3 != null && !r3.contains(this.f4520n.getX(), this.f4520n.getY())) {
                            z2 = true;
                        }
                        this.p = z2;
                        this.f4509c.f4533l.G(this.t, this.u);
                    }
                } else {
                    return;
                }
            }
        }
        if (!this.o) {
            Transition transition = this.f4509c;
            if (!(transition == null || transition.f4533l == null || this.p)) {
                this.f4509c.f4533l.u(motionEvent, this.q, i2, this);
            }
            this.t = motionEvent.getRawX();
            this.u = motionEvent.getRawY();
            if (motionEvent.getAction() == 1 && (motionTracker = this.q) != null) {
                motionTracker.recycle();
                this.q = null;
                int i3 = motionLayout.J3;
                if (i3 != -1) {
                    i(motionLayout, i3);
                }
            }
        }
    }

    public void g(Transition transition) {
        int w2 = w(transition);
        if (w2 == -1) {
            this.f4511e.add(transition);
        } else {
            this.f4511e.set(w2, transition);
        }
    }

    public boolean h(int i2, MotionController motionController) {
        return this.s.e(i2, motionController);
    }

    /* access modifiers changed from: package-private */
    public void h0(MotionLayout motionLayout) {
        int i2 = 0;
        while (i2 < this.f4514h.size()) {
            int keyAt = this.f4514h.keyAt(i2);
            if (R(keyAt)) {
                Log.e(TypedValues.MotionScene.f3976a, "Cannot be derived from yourself");
                return;
            } else {
                g0(keyAt, motionLayout);
                i2++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean i(MotionLayout motionLayout, int i2) {
        Transition transition;
        if (T() || this.f4510d) {
            return false;
        }
        Iterator<Transition> it2 = this.f4511e.iterator();
        while (it2.hasNext()) {
            Transition next = it2.next();
            if (next.f4535n != 0 && ((transition = this.f4509c) != next || !transition.L(2))) {
                if (i2 == next.f4525d && (next.f4535n == 4 || next.f4535n == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(next);
                    if (next.f4535n == 4) {
                        motionLayout.d1();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.u0(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.Q0();
                    }
                    return true;
                } else if (i2 == next.f4524c && (next.f4535n == 3 || next.f4535n == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(next);
                    if (next.f4535n == 3) {
                        motionLayout.f1();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.u0(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.Q0();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void i0(Transition transition) {
        int w2 = w(transition);
        if (w2 != -1) {
            this.f4511e.remove(w2);
        }
    }

    public Transition j(int i2, float f2, float f3, MotionEvent motionEvent) {
        RectF g2;
        int i3 = i2;
        float f4 = f2;
        float f5 = f3;
        if (i3 == -1) {
            return this.f4509c;
        }
        List<Transition> Q2 = Q(i2);
        RectF rectF = new RectF();
        float f6 = 0.0f;
        Transition transition = null;
        for (Transition next : Q2) {
            if (!next.o && next.f4533l != null) {
                next.f4533l.D(this.r);
                RectF r2 = next.f4533l.r(this.f4507a, rectF);
                if ((r2 == null || motionEvent == null || r2.contains(motionEvent.getX(), motionEvent.getY())) && ((g2 = next.f4533l.g(this.f4507a, rectF)) == null || motionEvent == null || g2.contains(motionEvent.getX(), motionEvent.getY()))) {
                    float a2 = next.f4533l.a(f4, f5);
                    if (next.f4533l.f4561l && motionEvent != null) {
                        float x2 = motionEvent.getX() - next.f4533l.f4558i;
                        float y2 = motionEvent.getY() - next.f4533l.f4559j;
                        a2 = ((float) (Math.atan2((double) (f5 + y2), (double) (f4 + x2)) - Math.atan2((double) x2, (double) y2))) * 10.0f;
                    }
                    float f7 = a2 * (next.f4524c == i3 ? -1.0f : 1.1f);
                    if (f7 > f6) {
                        transition = next;
                        f6 = f7;
                    }
                }
            }
        }
        return transition;
    }

    public void j0(int i2, ConstraintSet constraintSet) {
        this.f4514h.put(i2, constraintSet);
    }

    public void k(boolean z2) {
        this.f4510d = z2;
    }

    public void k0(int i2) {
        Transition transition = this.f4509c;
        if (transition != null) {
            transition.O(i2);
        } else {
            this.f4518l = i2;
        }
    }

    public void l(int i2, boolean z2) {
        this.s.f(i2, z2);
    }

    public void l0(View view, int i2, String str, Object obj) {
        Transition transition = this.f4509c;
        if (transition != null) {
            Iterator it2 = transition.f4532k.iterator();
            while (it2.hasNext()) {
                Iterator<Key> it3 = ((KeyFrames) it2.next()).d(view.getId()).iterator();
                while (it3.hasNext()) {
                    if (it3.next().f4375a == i2) {
                        if (obj != null) {
                            Float f2 = (Float) obj;
                        }
                        str.equalsIgnoreCase("app:PerpendicularPath_percent");
                    }
                }
            }
        }
    }

    public int m() {
        Transition transition = this.f4509c;
        if (transition != null) {
            return transition.p;
        }
        return -1;
    }

    public void m0(boolean z2) {
        this.r = z2;
        Transition transition = this.f4509c;
        if (transition != null && transition.f4533l != null) {
            this.f4509c.f4533l.D(this.r);
        }
    }

    /* access modifiers changed from: package-private */
    public int n() {
        Transition transition = this.f4509c;
        if (transition == null || transition.f4533l == null) {
            return 0;
        }
        return this.f4509c.f4533l.e();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n0(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.StateSet r0 = r6.f4508b
            r1 = -1
            if (r0 == 0) goto L_0x0018
            int r0 = r0.e(r7, r1, r1)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r7
        L_0x000d:
            androidx.constraintlayout.widget.StateSet r2 = r6.f4508b
            int r2 = r2.e(r8, r1, r1)
            if (r2 == r1) goto L_0x0016
            goto L_0x001a
        L_0x0016:
            r2 = r8
            goto L_0x001a
        L_0x0018:
            r0 = r7
            goto L_0x0016
        L_0x001a:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r6.f4509c
            if (r3 == 0) goto L_0x002d
            int r3 = r3.f4524c
            if (r3 != r8) goto L_0x002d
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r6.f4509c
            int r3 = r3.f4525d
            if (r3 != r7) goto L_0x002d
            return
        L_0x002d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.f4511e
            java.util.Iterator r3 = r3.iterator()
        L_0x0033:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x006d
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.f4524c
            if (r5 != r2) goto L_0x004b
            int r5 = r4.f4525d
            if (r5 == r0) goto L_0x0057
        L_0x004b:
            int r5 = r4.f4524c
            if (r5 != r8) goto L_0x0033
            int r5 = r4.f4525d
            if (r5 != r7) goto L_0x0033
        L_0x0057:
            r6.f4509c = r4
            if (r4 == 0) goto L_0x006c
            androidx.constraintlayout.motion.widget.TouchResponse r7 = r4.f4533l
            if (r7 == 0) goto L_0x006c
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.f4509c
            androidx.constraintlayout.motion.widget.TouchResponse r7 = r7.f4533l
            boolean r8 = r6.r
            r7.D(r8)
        L_0x006c:
            return
        L_0x006d:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.f4512f
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.f4513g
            java.util.Iterator r3 = r3.iterator()
        L_0x0075:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0089
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.f4524c
            if (r5 != r8) goto L_0x0075
            r7 = r4
            goto L_0x0075
        L_0x0089:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r8.<init>(r6, r7)
            int unused = r8.f4525d = r0
            int unused = r8.f4524c = r2
            if (r0 == r1) goto L_0x009b
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r7 = r6.f4511e
            r7.add(r8)
        L_0x009b:
            r6.f4509c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.n0(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public ConstraintSet o(int i2) {
        return p(i2, -1, -1);
    }

    public void o0(Transition transition) {
        this.f4509c = transition;
        if (transition != null && transition.f4533l != null) {
            this.f4509c.f4533l.D(this.r);
        }
    }

    /* access modifiers changed from: package-private */
    public ConstraintSet p(int i2, int i3, int i4) {
        Object obj;
        int e2;
        if (this.f4517k) {
            PrintStream printStream = System.out;
            printStream.println("id " + i2);
            printStream.println("size " + this.f4514h.size());
        }
        StateSet stateSet = this.f4508b;
        if (!(stateSet == null || (e2 = stateSet.e(i2, i3, i4)) == -1)) {
            i2 = e2;
        }
        if (this.f4514h.get(i2) == null) {
            Log.e(TypedValues.MotionScene.f3976a, "Warning could not find ConstraintSet id/" + Debug.i(this.f4507a.getContext(), i2) + " In MotionScene");
            SparseArray sparseArray = this.f4514h;
            obj = sparseArray.get(sparseArray.keyAt(0));
        } else {
            obj = this.f4514h.get(i2);
        }
        return (ConstraintSet) obj;
    }

    /* access modifiers changed from: package-private */
    public void p0() {
        Transition transition = this.f4509c;
        if (transition != null && transition.f4533l != null) {
            this.f4509c.f4533l.H();
        }
    }

    public ConstraintSet q(Context context, String str) {
        if (this.f4517k) {
            PrintStream printStream = System.out;
            printStream.println("id " + str);
            printStream.println("size " + this.f4514h.size());
        }
        for (int i2 = 0; i2 < this.f4514h.size(); i2++) {
            int keyAt = this.f4514h.keyAt(i2);
            String resourceName = context.getResources().getResourceName(keyAt);
            if (this.f4517k) {
                PrintStream printStream2 = System.out;
                printStream2.println("Id for <" + i2 + "> is <" + resourceName + "> looking for <" + str + ">");
            }
            if (str.equals(resourceName)) {
                return this.f4514h.get(keyAt);
            }
        }
        return null;
    }

    public int[] r() {
        int size = this.f4514h.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = this.f4514h.keyAt(i2);
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public boolean r0() {
        Iterator<Transition> it2 = this.f4511e.iterator();
        while (it2.hasNext()) {
            if (it2.next().f4533l != null) {
                return true;
            }
        }
        Transition transition = this.f4509c;
        return (transition == null || transition.f4533l == null) ? false : true;
    }

    public ArrayList<Transition> s() {
        return this.f4511e;
    }

    public boolean s0(MotionLayout motionLayout) {
        return motionLayout == this.f4507a && motionLayout.E3 == this;
    }

    public int t() {
        Transition transition = this.f4509c;
        return transition != null ? transition.f4529h : this.f4518l;
    }

    public void t0(int i2, View... viewArr) {
        this.s.m(i2, viewArr);
    }

    /* access modifiers changed from: package-private */
    public int u() {
        Transition transition = this.f4509c;
        if (transition == null) {
            return -1;
        }
        return transition.f4524c;
    }

    public Interpolator x() {
        int g2 = this.f4509c.f4526e;
        if (g2 == -2) {
            return AnimationUtils.loadInterpolator(this.f4507a.getContext(), this.f4509c.f4528g);
        }
        if (g2 == -1) {
            final Easing c2 = Easing.c(this.f4509c.f4527f);
            return new Interpolator(this) {
                public float getInterpolation(float f2) {
                    return (float) c2.a((double) f2);
                }
            };
        } else if (g2 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (g2 == 1) {
                return new AccelerateInterpolator();
            }
            if (g2 == 2) {
                return new DecelerateInterpolator();
            }
            if (g2 == 4) {
                return new BounceInterpolator();
            }
            if (g2 == 5) {
                return new OvershootInterpolator();
            }
            if (g2 != 6) {
                return null;
            }
            return new AnticipateInterpolator();
        }
    }

    /* access modifiers changed from: package-private */
    public Key y(Context context, int i2, int i3, int i4) {
        Transition transition = this.f4509c;
        if (transition == null) {
            return null;
        }
        Iterator it2 = transition.f4532k.iterator();
        while (it2.hasNext()) {
            KeyFrames keyFrames = (KeyFrames) it2.next();
            Iterator<Integer> it3 = keyFrames.e().iterator();
            while (true) {
                if (it3.hasNext()) {
                    Integer next = it3.next();
                    if (i3 == next.intValue()) {
                        Iterator<Key> it4 = keyFrames.d(next.intValue()).iterator();
                        while (it4.hasNext()) {
                            Key next2 = it4.next();
                            if (next2.f4375a == i4 && next2.f4378d == i2) {
                                return next2;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public void z(MotionController motionController) {
        Transition transition = this.f4509c;
        if (transition == null) {
            Transition transition2 = this.f4512f;
            if (transition2 != null) {
                Iterator it2 = transition2.f4532k.iterator();
                while (it2.hasNext()) {
                    ((KeyFrames) it2.next()).b(motionController);
                }
                return;
            }
            return;
        }
        Iterator it3 = transition.f4532k.iterator();
        while (it3.hasNext()) {
            ((KeyFrames) it3.next()).b(motionController);
        }
    }

    public MotionScene(MotionLayout motionLayout) {
        this.f4507a = motionLayout;
        this.s = new ViewTransitionController(motionLayout);
    }
}
