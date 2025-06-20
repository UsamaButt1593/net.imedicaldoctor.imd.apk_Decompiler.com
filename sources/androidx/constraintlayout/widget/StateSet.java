package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class StateSet {

    /* renamed from: h  reason: collision with root package name */
    public static final String f4967h = "ConstraintLayoutStates";

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f4968i = false;

    /* renamed from: a  reason: collision with root package name */
    int f4969a = -1;

    /* renamed from: b  reason: collision with root package name */
    ConstraintSet f4970b;

    /* renamed from: c  reason: collision with root package name */
    int f4971c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f4972d = -1;

    /* renamed from: e  reason: collision with root package name */
    private SparseArray<State> f4973e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private SparseArray<ConstraintSet> f4974f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    private ConstraintsChangedListener f4975g = null;

    static class State {

        /* renamed from: a  reason: collision with root package name */
        int f4976a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<Variant> f4977b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f4978c = -1;

        /* renamed from: d  reason: collision with root package name */
        boolean f4979d;

        public State(Context context, XmlPullParser xmlPullParser) {
            this.f4979d = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Tl);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Ul) {
                    this.f4976a = obtainStyledAttributes.getResourceId(index, this.f4976a);
                } else if (index == R.styleable.Vl) {
                    this.f4978c = obtainStyledAttributes.getResourceId(index, this.f4978c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4978c);
                    context.getResources().getResourceName(this.f4978c);
                    if (TtmlNode.w.equals(resourceTypeName)) {
                        this.f4979d = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(Variant variant) {
            this.f4977b.add(variant);
        }

        public int b(float f2, float f3) {
            for (int i2 = 0; i2 < this.f4977b.size(); i2++) {
                if (this.f4977b.get(i2).a(f2, f3)) {
                    return i2;
                }
            }
            return -1;
        }
    }

    static class Variant {

        /* renamed from: a  reason: collision with root package name */
        int f4980a;

        /* renamed from: b  reason: collision with root package name */
        float f4981b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        float f4982c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        float f4983d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        float f4984e = Float.NaN;

        /* renamed from: f  reason: collision with root package name */
        int f4985f = -1;

        /* renamed from: g  reason: collision with root package name */
        boolean f4986g;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.f4986g = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.ho);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.f4958io) {
                    this.f4985f = obtainStyledAttributes.getResourceId(index, this.f4985f);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4985f);
                    context.getResources().getResourceName(this.f4985f);
                    if (TtmlNode.w.equals(resourceTypeName)) {
                        this.f4986g = true;
                    }
                } else if (index == R.styleable.jo) {
                    this.f4984e = obtainStyledAttributes.getDimension(index, this.f4984e);
                } else if (index == R.styleable.ko) {
                    this.f4982c = obtainStyledAttributes.getDimension(index, this.f4982c);
                } else if (index == R.styleable.lo) {
                    this.f4983d = obtainStyledAttributes.getDimension(index, this.f4983d);
                } else if (index == R.styleable.mo) {
                    this.f4981b = obtainStyledAttributes.getDimension(index, this.f4981b);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean a(float f2, float f3) {
            if (!Float.isNaN(this.f4981b) && f2 < this.f4981b) {
                return false;
            }
            if (!Float.isNaN(this.f4982c) && f3 < this.f4982c) {
                return false;
            }
            if (Float.isNaN(this.f4983d) || f2 <= this.f4983d) {
                return Float.isNaN(this.f4984e) || f3 <= this.f4984e;
            }
            return false;
        }
    }

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        b(context, xmlPullParser);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) {
        /*
            r8 = this;
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r10)
            int[] r1 = androidx.constraintlayout.widget.R.styleable.fm
            android.content.res.TypedArray r0 = r9.obtainStyledAttributes(r0, r1)
            int r1 = r0.getIndexCount()
            r2 = 0
            r3 = 0
        L_0x0010:
            if (r3 >= r1) goto L_0x0025
            int r4 = r0.getIndex(r3)
            int r5 = androidx.constraintlayout.widget.R.styleable.gm
            if (r4 != r5) goto L_0x0022
            int r5 = r8.f4969a
            int r4 = r0.getResourceId(r4, r5)
            r8.f4969a = r4
        L_0x0022:
            int r3 = r3 + 1
            goto L_0x0010
        L_0x0025:
            r0.recycle()
            int r0 = r10.getEventType()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r1 = 0
        L_0x002d:
            r3 = 1
            if (r0 == r3) goto L_0x00a9
            if (r0 == 0) goto L_0x009a
            java.lang.String r4 = "StateSet"
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L_0x004b
            if (r0 == r5) goto L_0x003c
            goto L_0x009d
        L_0x003c:
            java.lang.String r0 = r10.getName()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            boolean r0 = r4.equals(r0)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r0 == 0) goto L_0x009d
            return
        L_0x0047:
            r9 = move-exception
            goto L_0x00a2
        L_0x0049:
            r9 = move-exception
            goto L_0x00a6
        L_0x004b:
            java.lang.String r0 = r10.getName()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            int r7 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            switch(r7) {
                case 80204913: goto L_0x0072;
                case 1301459538: goto L_0x0068;
                case 1382829617: goto L_0x0061;
                case 1901439077: goto L_0x0057;
                default: goto L_0x0056;
            }     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
        L_0x0056:
            goto L_0x007c
        L_0x0057:
            java.lang.String r3 = "Variant"
            boolean r0 = r0.equals(r3)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r0 == 0) goto L_0x007c
            r3 = 3
            goto L_0x007d
        L_0x0061:
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r0 == 0) goto L_0x007c
            goto L_0x007d
        L_0x0068:
            java.lang.String r3 = "LayoutDescription"
            boolean r0 = r0.equals(r3)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r0 == 0) goto L_0x007c
            r3 = 0
            goto L_0x007d
        L_0x0072:
            java.lang.String r3 = "State"
            boolean r0 = r0.equals(r3)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r0 == 0) goto L_0x007c
            r3 = 2
            goto L_0x007d
        L_0x007c:
            r3 = -1
        L_0x007d:
            if (r3 == r6) goto L_0x008d
            if (r3 == r5) goto L_0x0082
            goto L_0x009d
        L_0x0082:
            androidx.constraintlayout.widget.StateSet$Variant r0 = new androidx.constraintlayout.widget.StateSet$Variant     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r0.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            if (r1 == 0) goto L_0x009d
            r1.a(r0)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            goto L_0x009d
        L_0x008d:
            androidx.constraintlayout.widget.StateSet$State r1 = new androidx.constraintlayout.widget.StateSet$State     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r1.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            android.util.SparseArray<androidx.constraintlayout.widget.StateSet$State> r0 = r8.f4973e     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            int r3 = r1.f4976a     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            r0.put(r3, r1)     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            goto L_0x009d
        L_0x009a:
            r10.getName()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
        L_0x009d:
            int r0 = r10.next()     // Catch:{ XmlPullParserException -> 0x0049, IOException -> 0x0047 }
            goto L_0x002d
        L_0x00a2:
            r9.printStackTrace()
            goto L_0x00a9
        L_0x00a6:
            r9.printStackTrace()
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.b(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int a(int i2, int i3, float f2, float f3) {
        State state = this.f4973e.get(i3);
        if (state == null) {
            return i3;
        }
        if (f2 != -1.0f && f3 != -1.0f) {
            Iterator<Variant> it2 = state.f4977b.iterator();
            Variant variant = null;
            while (it2.hasNext()) {
                Variant next = it2.next();
                if (next.a(f2, f3)) {
                    if (i2 == next.f4985f) {
                        return i2;
                    }
                    variant = next;
                }
            }
            return variant != null ? variant.f4985f : state.f4978c;
        } else if (state.f4978c == i2) {
            return i2;
        } else {
            Iterator<Variant> it3 = state.f4977b.iterator();
            while (it3.hasNext()) {
                if (i2 == it3.next().f4985f) {
                    return i2;
                }
            }
            return state.f4978c;
        }
    }

    public boolean c(int i2, float f2, float f3) {
        int i3 = this.f4971c;
        if (i3 != i2) {
            return true;
        }
        State state = (State) (i2 == -1 ? this.f4973e.valueAt(0) : this.f4973e.get(i3));
        int i4 = this.f4972d;
        return (i4 == -1 || !state.f4977b.get(i4).a(f2, f3)) && this.f4972d != state.b(f2, f3);
    }

    public void d(ConstraintsChangedListener constraintsChangedListener) {
        this.f4975g = constraintsChangedListener;
    }

    public int e(int i2, int i3, int i4) {
        return f(-1, i2, (float) i3, (float) i4);
    }

    public int f(int i2, int i3, float f2, float f3) {
        int b2;
        if (i2 == i3) {
            State state = (State) (i3 == -1 ? this.f4973e.valueAt(0) : this.f4973e.get(this.f4971c));
            if (state == null) {
                return -1;
            }
            if ((this.f4972d == -1 || !state.f4977b.get(i2).a(f2, f3)) && i2 != (b2 = state.b(f2, f3))) {
                return b2 == -1 ? state.f4978c : state.f4977b.get(b2).f4985f;
            }
            return i2;
        }
        State state2 = this.f4973e.get(i3);
        if (state2 == null) {
            return -1;
        }
        int b3 = state2.b(f2, f3);
        return b3 == -1 ? state2.f4978c : state2.f4977b.get(b3).f4985f;
    }
}
