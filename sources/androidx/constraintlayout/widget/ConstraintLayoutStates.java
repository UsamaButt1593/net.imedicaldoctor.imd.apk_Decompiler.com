package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintLayoutStates {

    /* renamed from: h  reason: collision with root package name */
    public static final String f4662h = "ConstraintLayoutStates";

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f4663i = false;

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f4664a;

    /* renamed from: b  reason: collision with root package name */
    ConstraintSet f4665b;

    /* renamed from: c  reason: collision with root package name */
    int f4666c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f4667d = -1;

    /* renamed from: e  reason: collision with root package name */
    private SparseArray<State> f4668e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private SparseArray<ConstraintSet> f4669f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    private ConstraintsChangedListener f4670g = null;

    static class State {

        /* renamed from: a  reason: collision with root package name */
        int f4671a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<Variant> f4672b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f4673c = -1;

        /* renamed from: d  reason: collision with root package name */
        ConstraintSet f4674d;

        public State(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Tl);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Ul) {
                    this.f4671a = obtainStyledAttributes.getResourceId(index, this.f4671a);
                } else if (index == R.styleable.Vl) {
                    this.f4673c = obtainStyledAttributes.getResourceId(index, this.f4673c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4673c);
                    context.getResources().getResourceName(this.f4673c);
                    if (TtmlNode.w.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f4674d = constraintSet;
                        constraintSet.G(context, this.f4673c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(Variant variant) {
            this.f4672b.add(variant);
        }

        public int b(float f2, float f3) {
            for (int i2 = 0; i2 < this.f4672b.size(); i2++) {
                if (this.f4672b.get(i2).a(f2, f3)) {
                    return i2;
                }
            }
            return -1;
        }
    }

    static class Variant {

        /* renamed from: a  reason: collision with root package name */
        int f4675a;

        /* renamed from: b  reason: collision with root package name */
        float f4676b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        float f4677c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        float f4678d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        float f4679e = Float.NaN;

        /* renamed from: f  reason: collision with root package name */
        int f4680f = -1;

        /* renamed from: g  reason: collision with root package name */
        ConstraintSet f4681g;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.ho);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.f4958io) {
                    this.f4680f = obtainStyledAttributes.getResourceId(index, this.f4680f);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4680f);
                    context.getResources().getResourceName(this.f4680f);
                    if (TtmlNode.w.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f4681g = constraintSet;
                        constraintSet.G(context, this.f4680f);
                    }
                } else if (index == R.styleable.jo) {
                    this.f4679e = obtainStyledAttributes.getDimension(index, this.f4679e);
                } else if (index == R.styleable.ko) {
                    this.f4677c = obtainStyledAttributes.getDimension(index, this.f4677c);
                } else if (index == R.styleable.lo) {
                    this.f4678d = obtainStyledAttributes.getDimension(index, this.f4678d);
                } else if (index == R.styleable.mo) {
                    this.f4676b = obtainStyledAttributes.getDimension(index, this.f4676b);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean a(float f2, float f3) {
            if (!Float.isNaN(this.f4676b) && f2 < this.f4676b) {
                return false;
            }
            if (!Float.isNaN(this.f4677c) && f3 < this.f4677c) {
                return false;
            }
            if (Float.isNaN(this.f4678d) || f2 <= this.f4678d) {
                return Float.isNaN(this.f4679e) || f3 <= this.f4679e;
            }
            return false;
        }
    }

    ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i2) {
        this.f4664a = constraintLayout;
        a(context, i2);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r8, int r9) {
        /*
            r7 = this;
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r0.getXml(r9)
            int r0 = r9.getEventType()     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            r1 = 0
        L_0x000d:
            r2 = 1
            if (r0 == r2) goto L_0x008d
            if (r0 == 0) goto L_0x007e
            r3 = 2
            if (r0 == r3) goto L_0x0017
            goto L_0x0081
        L_0x0017:
            java.lang.String r0 = r9.getName()     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            int r4 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L_0x0050;
                case 80204913: goto L_0x0046;
                case 1382829617: goto L_0x003d;
                case 1657696882: goto L_0x0033;
                case 1901439077: goto L_0x0025;
                default: goto L_0x0024;
            }     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
        L_0x0024:
            goto L_0x005a
        L_0x0025:
            java.lang.String r2 = "Variant"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            if (r0 == 0) goto L_0x005a
            r2 = 3
            goto L_0x005b
        L_0x002f:
            r8 = move-exception
            goto L_0x0086
        L_0x0031:
            r8 = move-exception
            goto L_0x008a
        L_0x0033:
            java.lang.String r2 = "layoutDescription"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            if (r0 == 0) goto L_0x005a
            r2 = 0
            goto L_0x005b
        L_0x003d:
            java.lang.String r4 = "StateSet"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            if (r0 == 0) goto L_0x005a
            goto L_0x005b
        L_0x0046:
            java.lang.String r2 = "State"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            if (r0 == 0) goto L_0x005a
            r2 = 2
            goto L_0x005b
        L_0x0050:
            java.lang.String r2 = "ConstraintSet"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            if (r0 == 0) goto L_0x005a
            r2 = 4
            goto L_0x005b
        L_0x005a:
            r2 = -1
        L_0x005b:
            if (r2 == r3) goto L_0x0071
            if (r2 == r6) goto L_0x0066
            if (r2 == r5) goto L_0x0062
            goto L_0x0081
        L_0x0062:
            r7.c(r8, r9)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            goto L_0x0081
        L_0x0066:
            androidx.constraintlayout.widget.ConstraintLayoutStates$Variant r0 = new androidx.constraintlayout.widget.ConstraintLayoutStates$Variant     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            r0.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            if (r1 == 0) goto L_0x0081
            r1.a(r0)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            goto L_0x0081
        L_0x0071:
            androidx.constraintlayout.widget.ConstraintLayoutStates$State r1 = new androidx.constraintlayout.widget.ConstraintLayoutStates$State     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            r1.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintLayoutStates$State> r0 = r7.f4668e     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            int r2 = r1.f4671a     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            r0.put(r2, r1)     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            goto L_0x0081
        L_0x007e:
            r9.getName()     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
        L_0x0081:
            int r0 = r9.next()     // Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x002f }
            goto L_0x000d
        L_0x0086:
            r8.printStackTrace()
            goto L_0x008d
        L_0x008a:
            r8.printStackTrace()
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayoutStates.a(android.content.Context, int):void");
    }

    private void c(Context context, XmlPullParser xmlPullParser) {
        int i2;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        int i3 = 0;
        while (i3 < attributeCount) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if (attributeName == null || attributeValue == null || !"id".equals(attributeName)) {
                i3++;
            } else {
                if (attributeValue.contains("/")) {
                    i2 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i2 = -1;
                }
                if (i2 == -1) {
                    if (attributeValue.length() > 1) {
                        i2 = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                constraintSet.x0(context, xmlPullParser);
                this.f4669f.put(i2, constraintSet);
                return;
            }
        }
    }

    public boolean b(int i2, float f2, float f3) {
        int i3 = this.f4666c;
        if (i3 != i2) {
            return true;
        }
        State state = (State) (i2 == -1 ? this.f4668e.valueAt(0) : this.f4668e.get(i3));
        int i4 = this.f4667d;
        return (i4 == -1 || !state.f4672b.get(i4).a(f2, f3)) && this.f4667d != state.b(f2, f3);
    }

    public void d(ConstraintsChangedListener constraintsChangedListener) {
        this.f4670g = constraintsChangedListener;
    }

    public void e(int i2, float f2, float f3) {
        int b2;
        int i3 = this.f4666c;
        if (i3 == i2) {
            State state = (State) (i2 == -1 ? this.f4668e.valueAt(0) : this.f4668e.get(i3));
            int i4 = this.f4667d;
            if ((i4 == -1 || !state.f4672b.get(i4).a(f2, f3)) && this.f4667d != (b2 = state.b(f2, f3))) {
                ConstraintSet constraintSet = b2 == -1 ? this.f4665b : state.f4672b.get(b2).f4681g;
                int i5 = b2 == -1 ? state.f4673c : state.f4672b.get(b2).f4680f;
                if (constraintSet != null) {
                    this.f4667d = b2;
                    ConstraintsChangedListener constraintsChangedListener = this.f4670g;
                    if (constraintsChangedListener != null) {
                        constraintsChangedListener.b(-1, i5);
                    }
                    constraintSet.r(this.f4664a);
                    ConstraintsChangedListener constraintsChangedListener2 = this.f4670g;
                    if (constraintsChangedListener2 != null) {
                        constraintsChangedListener2.a(-1, i5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.f4666c = i2;
        State state2 = this.f4668e.get(i2);
        int b3 = state2.b(f2, f3);
        ConstraintSet constraintSet2 = b3 == -1 ? state2.f4674d : state2.f4672b.get(b3).f4681g;
        int i6 = b3 == -1 ? state2.f4673c : state2.f4672b.get(b3).f4680f;
        if (constraintSet2 == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i2 + ", dim =" + f2 + ", " + f3);
            return;
        }
        this.f4667d = b3;
        ConstraintsChangedListener constraintsChangedListener3 = this.f4670g;
        if (constraintsChangedListener3 != null) {
            constraintsChangedListener3.b(i2, i6);
        }
        constraintSet2.r(this.f4664a);
        ConstraintsChangedListener constraintsChangedListener4 = this.f4670g;
        if (constraintsChangedListener4 != null) {
            constraintsChangedListener4.a(i2, i6);
        }
    }
}
