package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintReference implements Reference {
    float A = Float.NaN;
    float B = Float.NaN;
    float C = Float.NaN;
    float D = Float.NaN;
    float E = Float.NaN;
    float F = Float.NaN;
    float G = Float.NaN;
    float H = Float.NaN;
    float I = Float.NaN;
    int J = 0;
    protected Object K = null;
    protected Object L = null;
    protected Object M = null;
    protected Object N = null;
    protected Object O = null;
    protected Object P = null;
    protected Object Q = null;
    protected Object R = null;
    protected Object S = null;
    protected Object T = null;
    protected Object U = null;
    protected Object V = null;
    Object W = null;
    Object X = null;
    Object Y = null;
    Object Z = null;

    /* renamed from: a  reason: collision with root package name */
    private Object f4071a;
    private float a0;

    /* renamed from: b  reason: collision with root package name */
    final State f4072b;
    private float b0;

    /* renamed from: c  reason: collision with root package name */
    String f4073c = null;
    State.Constraint c0 = null;

    /* renamed from: d  reason: collision with root package name */
    Facade f4074d = null;
    Dimension d0;

    /* renamed from: e  reason: collision with root package name */
    int f4075e = 0;
    Dimension e0;

    /* renamed from: f  reason: collision with root package name */
    int f4076f = 0;
    private Object f0;

    /* renamed from: g  reason: collision with root package name */
    float f4077g = -1.0f;
    private ConstraintWidget g0;

    /* renamed from: h  reason: collision with root package name */
    float f4078h = -1.0f;
    private HashMap<String, Integer> h0;

    /* renamed from: i  reason: collision with root package name */
    float f4079i = 0.5f;
    private HashMap<String, Float> i0;

    /* renamed from: j  reason: collision with root package name */
    float f4080j = 0.5f;

    /* renamed from: k  reason: collision with root package name */
    protected int f4081k = 0;

    /* renamed from: l  reason: collision with root package name */
    protected int f4082l = 0;

    /* renamed from: m  reason: collision with root package name */
    protected int f4083m = 0;

    /* renamed from: n  reason: collision with root package name */
    protected int f4084n = 0;
    protected int o = 0;
    protected int p = 0;
    protected int q = 0;
    protected int r = 0;
    protected int s = 0;
    protected int t = 0;
    protected int u = 0;
    protected int v = 0;
    int w = 0;
    int x = 0;
    float y = Float.NaN;
    float z = Float.NaN;

    /* renamed from: androidx.constraintlayout.core.state.ConstraintReference$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4085a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.state.State$Constraint[] r0 = androidx.constraintlayout.core.state.State.Constraint.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4085a = r0
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.LEFT_TO_LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.LEFT_TO_RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.RIGHT_TO_LEFT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.RIGHT_TO_RIGHT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.START_TO_START     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.START_TO_END     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.END_TO_START     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.END_TO_END     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.TOP_TO_TOP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.TOP_TO_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.BOTTOM_TO_TOP     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.BOTTOM_TO_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.BASELINE_TO_BOTTOM     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.BASELINE_TO_TOP     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.BASELINE_TO_BASELINE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.CIRCULAR_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.CENTER_HORIZONTALLY     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f4085a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                androidx.constraintlayout.core.state.State$Constraint r1 = androidx.constraintlayout.core.state.State.Constraint.CENTER_VERTICALLY     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintReference.AnonymousClass1.<clinit>():void");
        }
    }

    public interface ConstraintReferenceFactory {
        ConstraintReference a(State state);
    }

    static class IncorrectConstraintException extends Exception {
        private final ArrayList<String> s;

        public IncorrectConstraintException(ArrayList<String> arrayList) {
            this.s = arrayList;
        }

        public ArrayList<String> a() {
            return this.s;
        }

        public String toString() {
            return "IncorrectConstraintException: " + this.s.toString();
        }
    }

    public ConstraintReference(State state) {
        Object obj = Dimension.f4087j;
        this.d0 = Dimension.b(obj);
        this.e0 = Dimension.b(obj);
        this.h0 = new HashMap<>();
        this.i0 = new HashMap<>();
        this.f4072b = state;
    }

    private Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        return !(obj instanceof ConstraintReference) ? this.f4072b.r(obj) : obj;
    }

    private ConstraintWidget O(Object obj) {
        if (obj instanceof Reference) {
            return ((Reference) obj).a();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        r8 = r2.r(r8);
        r0 = r6.p;
        r1 = r6.v;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004f, code lost:
        r7.b(r8, r0, r1, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0065, code lost:
        r8 = r2.r(r8);
        r0 = r6.o;
        r1 = r6.u;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007b, code lost:
        r8 = r2.r(r8);
        r0 = r6.f4084n;
        r1 = r6.t;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0095, code lost:
        r8 = r2.r(r8);
        r0 = r6.f4083m;
        r1 = r6.s;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ab, code lost:
        r8 = r2.r(r8);
        r0 = r6.f4082l;
        r1 = r6.r;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c5, code lost:
        r8 = r2.r(r8);
        r0 = r6.f4081k;
        r1 = r6.q;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        r0.v0(r1, r2, r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        r4 = r6.w;
        r5 = r6.x;
        r0 = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h(androidx.constraintlayout.core.widgets.ConstraintWidget r7, java.lang.Object r8, androidx.constraintlayout.core.state.State.Constraint r9) {
        /*
            r6 = this;
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r6.O(r8)
            if (r2 != 0) goto L_0x0007
            return
        L_0x0007:
            int[] r8 = androidx.constraintlayout.core.state.ConstraintReference.AnonymousClass1.f4085a
            int r0 = r9.ordinal()
            r0 = r8[r0]
            int r9 = r9.ordinal()
            r8 = r8[r9]
            r9 = 0
            switch(r8) {
                case 1: goto L_0x00ce;
                case 2: goto L_0x00bd;
                case 3: goto L_0x00b4;
                case 4: goto L_0x00a5;
                case 5: goto L_0x009e;
                case 6: goto L_0x008d;
                case 7: goto L_0x0084;
                case 8: goto L_0x0075;
                case 9: goto L_0x006e;
                case 10: goto L_0x005d;
                case 11: goto L_0x0054;
                case 12: goto L_0x0041;
                case 13: goto L_0x003c;
                case 14: goto L_0x0032;
                case 15: goto L_0x0025;
                case 16: goto L_0x001b;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x00d5
        L_0x001b:
            float r8 = r6.a0
            float r9 = r6.b0
            int r9 = (int) r9
            r7.m(r2, r8, r9)
            goto L_0x00d5
        L_0x0025:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            int r4 = r6.w
            int r5 = r6.x
            r0 = r7
            r1 = r3
        L_0x002d:
            r0.v0(r1, r2, r3, r4, r5)
            goto L_0x00d5
        L_0x0032:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
        L_0x0036:
            int r4 = r6.w
            int r5 = r6.x
            r0 = r7
            goto L_0x002d
        L_0x003c:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            goto L_0x0036
        L_0x0041:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.r(r8)
        L_0x0047:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r2.r(r8)
            int r0 = r6.p
            int r1 = r6.v
        L_0x004f:
            r7.b(r8, r0, r1, r9)
            goto L_0x00d5
        L_0x0054:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.r(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            goto L_0x0047
        L_0x005d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.r(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
        L_0x0065:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r2.r(r8)
            int r0 = r6.o
            int r1 = r6.u
            goto L_0x004f
        L_0x006e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.r(r8)
            goto L_0x0065
        L_0x0075:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.r(r8)
        L_0x007b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r2.r(r8)
            int r0 = r6.f4084n
            int r1 = r6.t
            goto L_0x004f
        L_0x0084:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.r(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            goto L_0x007b
        L_0x008d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.r(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
        L_0x0095:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r2.r(r8)
            int r0 = r6.f4083m
            int r1 = r6.s
            goto L_0x004f
        L_0x009e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.r(r8)
            goto L_0x0095
        L_0x00a5:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.r(r8)
        L_0x00ab:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r2.r(r8)
            int r0 = r6.f4082l
            int r1 = r6.r
            goto L_0x004f
        L_0x00b4:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.r(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            goto L_0x00ab
        L_0x00bd:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.r(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
        L_0x00c5:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r2.r(r8)
            int r0 = r6.f4081k
            int r1 = r6.q
            goto L_0x004f
        L_0x00ce:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r8 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.r(r8)
            goto L_0x00c5
        L_0x00d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintReference.h(androidx.constraintlayout.core.widgets.ConstraintWidget, java.lang.Object, androidx.constraintlayout.core.state.State$Constraint):void");
    }

    private void x() {
        this.K = B(this.K);
        this.L = B(this.L);
        this.M = B(this.M);
        this.N = B(this.N);
        this.O = B(this.O);
        this.P = B(this.P);
        this.Q = B(this.Q);
        this.R = B(this.R);
        this.S = B(this.S);
        this.T = B(this.T);
        this.U = B(this.U);
        this.V = B(this.V);
        this.W = B(this.W);
        this.X = B(this.X);
        this.Y = B(this.Y);
    }

    public ConstraintReference A(Object obj) {
        this.c0 = State.Constraint.END_TO_START;
        this.Q = obj;
        return this;
    }

    public ConstraintReference A0(Object obj) {
        this.c0 = State.Constraint.START_TO_START;
        this.O = obj;
        return this;
    }

    public ConstraintReference B0() {
        this.c0 = this.S != null ? State.Constraint.TOP_TO_TOP : State.Constraint.TOP_TO_BOTTOM;
        return this;
    }

    public float C() {
        return this.G;
    }

    public ConstraintReference C0(Object obj) {
        this.c0 = State.Constraint.TOP_TO_BOTTOM;
        this.T = obj;
        return this;
    }

    public Dimension D() {
        return this.e0;
    }

    public ConstraintReference D0(Object obj) {
        this.c0 = State.Constraint.TOP_TO_TOP;
        this.S = obj;
        return this;
    }

    public int E() {
        return this.f4075e;
    }

    public ConstraintReference E0(float f2) {
        this.D = f2;
        return this;
    }

    public float F() {
        return this.f4077g;
    }

    public ConstraintReference F0(float f2) {
        this.E = f2;
        return this;
    }

    public float G() {
        return this.y;
    }

    public ConstraintReference G0(float f2) {
        this.F = f2;
        return this;
    }

    public float H() {
        return this.z;
    }

    public void H0() throws IncorrectConstraintException {
        ArrayList arrayList = new ArrayList();
        if (!(this.K == null || this.L == null)) {
            arrayList.add("LeftToLeft and LeftToRight both defined");
        }
        if (!(this.M == null || this.N == null)) {
            arrayList.add("RightToLeft and RightToRight both defined");
        }
        if (!(this.O == null || this.P == null)) {
            arrayList.add("StartToStart and StartToEnd both defined");
        }
        if (!(this.Q == null || this.R == null)) {
            arrayList.add("EndToStart and EndToEnd both defined");
        }
        if (!((this.K == null && this.L == null && this.M == null && this.N == null) || (this.O == null && this.P == null && this.Q == null && this.R == null))) {
            arrayList.add("Both left/right and start/end constraints defined");
        }
        if (arrayList.size() > 0) {
            throw new IncorrectConstraintException(arrayList);
        }
    }

    public float I() {
        return this.A;
    }

    public ConstraintReference I0(float f2) {
        this.f4080j = f2;
        return this;
    }

    public float J() {
        return this.B;
    }

    public ConstraintReference J0(int i2) {
        this.J = i2;
        return this;
    }

    public float K() {
        return this.C;
    }

    public ConstraintReference K0(Dimension dimension) {
        return x0(dimension);
    }

    public float L() {
        return this.H;
    }

    public float M() {
        return this.I;
    }

    public String N() {
        return this.f4073c;
    }

    public float P() {
        return this.D;
    }

    public float Q() {
        return this.E;
    }

    public float R() {
        return this.F;
    }

    public int S(int i2) {
        return this.f4076f;
    }

    public float T() {
        return this.f4078h;
    }

    public Object U() {
        return this.f0;
    }

    public Dimension V() {
        return this.d0;
    }

    public ConstraintReference W(Dimension dimension) {
        return q0(dimension);
    }

    public ConstraintReference X(float f2) {
        this.f4079i = f2;
        return this;
    }

    public ConstraintReference Y() {
        this.c0 = this.K != null ? State.Constraint.LEFT_TO_LEFT : State.Constraint.LEFT_TO_RIGHT;
        return this;
    }

    public ConstraintReference Z(Object obj) {
        this.c0 = State.Constraint.LEFT_TO_LEFT;
        this.K = obj;
        return this;
    }

    public ConstraintWidget a() {
        if (this.g0 == null) {
            ConstraintWidget w2 = w();
            this.g0 = w2;
            w2.h1(this.f0);
        }
        return this.g0;
    }

    public ConstraintReference a0(Object obj) {
        this.c0 = State.Constraint.LEFT_TO_RIGHT;
        this.L = obj;
        return this;
    }

    public void apply() {
        if (this.g0 != null) {
            Facade facade = this.f4074d;
            if (facade != null) {
                facade.apply();
            }
            this.d0.j(this.f4072b, this.g0, 0);
            this.e0.j(this.f4072b, this.g0, 1);
            x();
            h(this.g0, this.K, State.Constraint.LEFT_TO_LEFT);
            h(this.g0, this.L, State.Constraint.LEFT_TO_RIGHT);
            h(this.g0, this.M, State.Constraint.RIGHT_TO_LEFT);
            h(this.g0, this.N, State.Constraint.RIGHT_TO_RIGHT);
            h(this.g0, this.O, State.Constraint.START_TO_START);
            h(this.g0, this.P, State.Constraint.START_TO_END);
            h(this.g0, this.Q, State.Constraint.END_TO_START);
            h(this.g0, this.R, State.Constraint.END_TO_END);
            h(this.g0, this.S, State.Constraint.TOP_TO_TOP);
            h(this.g0, this.T, State.Constraint.TOP_TO_BOTTOM);
            h(this.g0, this.U, State.Constraint.BOTTOM_TO_TOP);
            h(this.g0, this.V, State.Constraint.BOTTOM_TO_BOTTOM);
            h(this.g0, this.W, State.Constraint.BASELINE_TO_BASELINE);
            h(this.g0, this.X, State.Constraint.BASELINE_TO_TOP);
            h(this.g0, this.Y, State.Constraint.BASELINE_TO_BOTTOM);
            h(this.g0, this.Z, State.Constraint.CIRCULAR_CONSTRAINT);
            int i2 = this.f4075e;
            if (i2 != 0) {
                this.g0.B1(i2);
            }
            int i3 = this.f4076f;
            if (i3 != 0) {
                this.g0.W1(i3);
            }
            float f2 = this.f4077g;
            if (f2 != -1.0f) {
                this.g0.F1(f2);
            }
            float f3 = this.f4078h;
            if (f3 != -1.0f) {
                this.g0.a2(f3);
            }
            this.g0.A1(this.f4079i);
            this.g0.V1(this.f4080j);
            ConstraintWidget constraintWidget = this.g0;
            WidgetFrame widgetFrame = constraintWidget.f4201n;
            widgetFrame.f4140f = this.y;
            widgetFrame.f4141g = this.z;
            widgetFrame.f4142h = this.A;
            widgetFrame.f4143i = this.B;
            widgetFrame.f4144j = this.C;
            widgetFrame.f4145k = this.D;
            widgetFrame.f4146l = this.E;
            widgetFrame.f4147m = this.F;
            widgetFrame.f4148n = this.H;
            widgetFrame.o = this.I;
            widgetFrame.p = this.G;
            int i4 = this.J;
            widgetFrame.r = i4;
            constraintWidget.b2(i4);
            HashMap<String, Integer> hashMap = this.h0;
            if (hashMap != null) {
                for (String next : hashMap.keySet()) {
                    this.g0.f4201n.w(next, TypedValues.Custom.f3959l, this.h0.get(next).intValue());
                }
            }
            HashMap<String, Float> hashMap2 = this.i0;
            if (hashMap2 != null) {
                for (String next2 : hashMap2.keySet()) {
                    this.g0.f4201n.v(next2, TypedValues.Custom.f3958k, this.i0.get(next2).floatValue());
                }
            }
        }
    }

    public void b(ConstraintWidget constraintWidget) {
        if (constraintWidget != null) {
            this.g0 = constraintWidget;
            constraintWidget.h1(this.f0);
        }
    }

    public ConstraintReference b0(int i2) {
        State.Constraint constraint = this.c0;
        if (constraint != null) {
            switch (AnonymousClass1.f4085a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.f4081k = i2;
                    break;
                case 3:
                case 4:
                    this.f4082l = i2;
                    break;
                case 5:
                case 6:
                    this.f4083m = i2;
                    break;
                case 7:
                case 8:
                    this.f4084n = i2;
                    break;
                case 9:
                case 10:
                    this.o = i2;
                    break;
                case 11:
                case 12:
                    break;
                case 13:
                case 14:
                case 15:
                    this.w = i2;
                    break;
                case 16:
                    this.b0 = (float) i2;
                    break;
            }
        } else {
            this.f4081k = i2;
            this.f4082l = i2;
            this.f4083m = i2;
            this.f4084n = i2;
            this.o = i2;
        }
        this.p = i2;
        return this;
    }

    public void c(Object obj) {
        this.f4071a = obj;
    }

    public ConstraintReference c0(Object obj) {
        return b0(this.f4072b.f(obj));
    }

    public Facade d() {
        return this.f4074d;
    }

    public ConstraintReference d0(int i2) {
        State.Constraint constraint = this.c0;
        if (constraint != null) {
            switch (AnonymousClass1.f4085a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.q = i2;
                    break;
                case 3:
                case 4:
                    this.r = i2;
                    break;
                case 5:
                case 6:
                    this.s = i2;
                    break;
                case 7:
                case 8:
                    this.t = i2;
                    break;
                case 9:
                case 10:
                    this.u = i2;
                    break;
                case 11:
                case 12:
                    break;
                case 13:
                case 14:
                case 15:
                    this.x = i2;
                    break;
            }
        } else {
            this.q = i2;
            this.r = i2;
            this.s = i2;
            this.t = i2;
            this.u = i2;
        }
        this.v = i2;
        return this;
    }

    public void e(String str, int i2) {
        this.h0.put(str, Integer.valueOf(i2));
    }

    public ConstraintReference e0(Object obj) {
        return d0(this.f4072b.f(obj));
    }

    public void f(String str, float f2) {
        if (this.i0 == null) {
            this.i0 = new HashMap<>();
        }
        this.i0.put(str, Float.valueOf(f2));
    }

    public ConstraintReference f0(float f2) {
        this.y = f2;
        return this;
    }

    public ConstraintReference g(float f2) {
        this.G = f2;
        return this;
    }

    public ConstraintReference g0(float f2) {
        this.z = f2;
        return this;
    }

    public Object getKey() {
        return this.f4071a;
    }

    public ConstraintReference h0() {
        this.c0 = this.M != null ? State.Constraint.RIGHT_TO_LEFT : State.Constraint.RIGHT_TO_RIGHT;
        return this;
    }

    public ConstraintReference i() {
        this.c0 = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference i0(Object obj) {
        this.c0 = State.Constraint.RIGHT_TO_LEFT;
        this.M = obj;
        return this;
    }

    public ConstraintReference j(Object obj) {
        this.c0 = State.Constraint.BASELINE_TO_BASELINE;
        this.W = obj;
        return this;
    }

    public ConstraintReference j0(Object obj) {
        this.c0 = State.Constraint.RIGHT_TO_RIGHT;
        this.N = obj;
        return this;
    }

    public ConstraintReference k(Object obj) {
        this.c0 = State.Constraint.BASELINE_TO_BOTTOM;
        this.Y = obj;
        return this;
    }

    public ConstraintReference k0(float f2) {
        this.A = f2;
        return this;
    }

    public ConstraintReference l(Object obj) {
        this.c0 = State.Constraint.BASELINE_TO_TOP;
        this.X = obj;
        return this;
    }

    public ConstraintReference l0(float f2) {
        this.B = f2;
        return this;
    }

    public ConstraintReference m(float f2) {
        State.Constraint constraint = this.c0;
        if (constraint == null) {
            return this;
        }
        int i2 = AnonymousClass1.f4085a[constraint.ordinal()];
        if (i2 != 17) {
            if (i2 != 18) {
                switch (i2) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        break;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        break;
                }
            }
            this.f4080j = f2;
            return this;
        }
        this.f4079i = f2;
        return this;
    }

    public ConstraintReference m0(float f2) {
        this.C = f2;
        return this;
    }

    public ConstraintReference n() {
        this.c0 = this.U != null ? State.Constraint.BOTTOM_TO_TOP : State.Constraint.BOTTOM_TO_BOTTOM;
        return this;
    }

    public ConstraintReference n0(float f2) {
        this.H = f2;
        return this;
    }

    public ConstraintReference o(Object obj) {
        this.c0 = State.Constraint.BOTTOM_TO_BOTTOM;
        this.V = obj;
        return this;
    }

    public ConstraintReference o0(float f2) {
        this.I = f2;
        return this;
    }

    public ConstraintReference p(Object obj) {
        this.c0 = State.Constraint.BOTTOM_TO_TOP;
        this.U = obj;
        return this;
    }

    public void p0(Facade facade) {
        this.f4074d = facade;
        if (facade != null) {
            b(facade.a());
        }
    }

    public ConstraintReference q(Object obj) {
        Object B2 = B(obj);
        this.O = B2;
        this.R = B2;
        this.c0 = State.Constraint.CENTER_HORIZONTALLY;
        this.f4079i = 0.5f;
        return this;
    }

    public ConstraintReference q0(Dimension dimension) {
        this.e0 = dimension;
        return this;
    }

    public ConstraintReference r(Object obj) {
        Object B2 = B(obj);
        this.S = B2;
        this.V = B2;
        this.c0 = State.Constraint.CENTER_VERTICALLY;
        this.f4080j = 0.5f;
        return this;
    }

    public void r0(int i2) {
        this.f4075e = i2;
    }

    public ConstraintReference s(Object obj, float f2, float f3) {
        this.Z = B(obj);
        this.a0 = f2;
        this.b0 = f3;
        this.c0 = State.Constraint.CIRCULAR_CONSTRAINT;
        return this;
    }

    public void s0(float f2) {
        this.f4077g = f2;
    }

    public ConstraintReference t() {
        State.Constraint constraint = this.c0;
        if (constraint != null) {
            switch (AnonymousClass1.f4085a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.K = null;
                    this.L = null;
                    this.f4081k = 0;
                    this.q = 0;
                    break;
                case 3:
                case 4:
                    this.M = null;
                    this.N = null;
                    this.f4082l = 0;
                    this.r = 0;
                    break;
                case 5:
                case 6:
                    this.O = null;
                    this.P = null;
                    this.f4083m = 0;
                    this.s = 0;
                    break;
                case 7:
                case 8:
                    this.Q = null;
                    this.R = null;
                    this.f4084n = 0;
                    this.t = 0;
                    break;
                case 9:
                case 10:
                    this.S = null;
                    this.T = null;
                    this.o = 0;
                    this.u = 0;
                    break;
                case 11:
                case 12:
                    this.U = null;
                    this.V = null;
                    this.p = 0;
                    break;
                case 15:
                    this.W = null;
                    break;
                case 16:
                    this.Z = null;
                    break;
            }
        } else {
            this.K = null;
            this.L = null;
            this.f4081k = 0;
            this.M = null;
            this.N = null;
            this.f4082l = 0;
            this.O = null;
            this.P = null;
            this.f4083m = 0;
            this.Q = null;
            this.R = null;
            this.f4084n = 0;
            this.S = null;
            this.T = null;
            this.o = 0;
            this.U = null;
            this.V = null;
            this.p = 0;
            this.W = null;
            this.Z = null;
            this.f4079i = 0.5f;
            this.f4080j = 0.5f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = 0;
        }
        this.v = 0;
        return this;
    }

    public void t0(String str) {
        this.f4073c = str;
    }

    public ConstraintReference u() {
        y0().t();
        y().t();
        Y().t();
        h0().t();
        return this;
    }

    public void u0(int i2) {
        this.f4076f = i2;
    }

    public ConstraintReference v() {
        B0().t();
        i().t();
        n().t();
        return this;
    }

    public void v0(float f2) {
        this.f4078h = f2;
    }

    public ConstraintWidget w() {
        return new ConstraintWidget(V().n(), D().n());
    }

    public void w0(Object obj) {
        this.f0 = obj;
        ConstraintWidget constraintWidget = this.g0;
        if (constraintWidget != null) {
            constraintWidget.h1(obj);
        }
    }

    public ConstraintReference x0(Dimension dimension) {
        this.d0 = dimension;
        return this;
    }

    public ConstraintReference y() {
        this.c0 = this.Q != null ? State.Constraint.END_TO_START : State.Constraint.END_TO_END;
        return this;
    }

    public ConstraintReference y0() {
        this.c0 = this.O != null ? State.Constraint.START_TO_START : State.Constraint.START_TO_END;
        return this;
    }

    public ConstraintReference z(Object obj) {
        this.c0 = State.Constraint.END_TO_END;
        this.R = obj;
        return this;
    }

    public ConstraintReference z0(Object obj) {
        this.c0 = State.Constraint.START_TO_END;
        this.P = obj;
        return this;
    }
}
