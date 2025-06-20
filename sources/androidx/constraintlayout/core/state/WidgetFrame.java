package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.HashMap;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class WidgetFrame {
    private static final boolean u = true;
    public static float v = Float.NaN;

    /* renamed from: a  reason: collision with root package name */
    public ConstraintWidget f4135a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f4136b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f4137c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f4138d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f4139e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f4140f = Float.NaN;

    /* renamed from: g  reason: collision with root package name */
    public float f4141g = Float.NaN;

    /* renamed from: h  reason: collision with root package name */
    public float f4142h = Float.NaN;

    /* renamed from: i  reason: collision with root package name */
    public float f4143i = Float.NaN;

    /* renamed from: j  reason: collision with root package name */
    public float f4144j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    public float f4145k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public float f4146l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public float f4147m = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    public float f4148n = Float.NaN;
    public float o = Float.NaN;
    public float p = Float.NaN;
    public float q = Float.NaN;
    public int r = 0;
    public final HashMap<String, CustomVariable> s = new HashMap<>();
    public String t = null;

    public WidgetFrame() {
    }

    private static void a(StringBuilder sb, String str, float f2) {
        if (!Float.isNaN(f2)) {
            sb.append(str);
            sb.append(": ");
            sb.append(f2);
            sb.append(",\n");
        }
    }

    private static void b(StringBuilder sb, String str, int i2) {
        sb.append(str);
        sb.append(": ");
        sb.append(i2);
        sb.append(",\n");
    }

    private static float m(float f2, float f3, float f4, float f5) {
        boolean isNaN = Float.isNaN(f2);
        boolean isNaN2 = Float.isNaN(f3);
        if (isNaN && isNaN2) {
            return Float.NaN;
        }
        if (isNaN) {
            f2 = f4;
        }
        if (isNaN2) {
            f3 = f4;
        }
        return f2 + (f5 * (f3 - f2));
    }

    public static void n(int i2, int i3, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f2) {
        int i4;
        float f3;
        int i5;
        int i6;
        float f4;
        float f5;
        int i7;
        float f6;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = i2;
        int i15 = i3;
        WidgetFrame widgetFrame4 = widgetFrame;
        WidgetFrame widgetFrame5 = widgetFrame2;
        WidgetFrame widgetFrame6 = widgetFrame3;
        Transition transition2 = transition;
        float f7 = 100.0f * f2;
        int i16 = (int) f7;
        int i17 = widgetFrame5.f4136b;
        int i18 = widgetFrame5.f4137c;
        int i19 = widgetFrame6.f4136b;
        int i20 = widgetFrame6.f4137c;
        int i21 = widgetFrame6.f4138d - i19;
        int i22 = widgetFrame5.f4138d - i17;
        int i23 = widgetFrame6.f4139e - i20;
        int i24 = widgetFrame5.f4139e - i18;
        float f8 = widgetFrame5.p;
        float f9 = widgetFrame6.p;
        float f10 = f7;
        if (widgetFrame5.r == 8) {
            i18 = (int) (((float) i18) - (((float) i23) / 2.0f));
            i4 = (int) (((float) i17) - (((float) i21) / 2.0f));
            if (Float.isNaN(f8)) {
                i5 = i23;
                i6 = i21;
                f3 = 0.0f;
            } else {
                f3 = f8;
                i6 = i21;
                i5 = i23;
            }
        } else {
            i6 = i22;
            f3 = f8;
            i5 = i24;
            i4 = i17;
        }
        if (widgetFrame6.r == 8) {
            i19 = (int) (((float) i19) - (((float) i6) / 2.0f));
            i20 = (int) (((float) i20) - (((float) i5) / 2.0f));
            i21 = i6;
            i23 = i5;
            if (Float.isNaN(f9)) {
                f9 = 0.0f;
            }
        }
        if (Float.isNaN(f3) && !Float.isNaN(f9)) {
            f3 = 1.0f;
        }
        if (!Float.isNaN(f3) && Float.isNaN(f9)) {
            f9 = 1.0f;
        }
        if (widgetFrame5.r == 4) {
            f4 = f9;
            f5 = 0.0f;
        } else {
            f5 = f3;
            f4 = f9;
        }
        float f11 = widgetFrame6.r == 4 ? 0.0f : f4;
        if (widgetFrame4.f4135a == null || !transition.N()) {
            i7 = i18;
            f6 = f2;
            i8 = i4;
            i9 = i19;
        } else {
            Transition.KeyPosition x = transition2.x(widgetFrame4.f4135a.o, i16);
            i7 = i18;
            Transition.KeyPosition w = transition2.w(widgetFrame4.f4135a.o, i16);
            if (x == w) {
                w = null;
            }
            if (x != null) {
                int i25 = (int) (x.f4123d * ((float) i14));
                i10 = i19;
                i12 = i3;
                i7 = (int) (x.f4124e * ((float) i12));
                i11 = x.f4120a;
                i8 = i25;
            } else {
                i12 = i3;
                i10 = i19;
                i8 = i4;
                i11 = 0;
            }
            if (w != null) {
                i9 = (int) (w.f4123d * ((float) i14));
                i20 = (int) (w.f4124e * ((float) i12));
                i13 = w.f4120a;
            } else {
                i13 = 100;
                i9 = i10;
            }
            f6 = (f10 - ((float) i11)) / ((float) (i13 - i11));
        }
        int i26 = i7;
        widgetFrame4.f4135a = widgetFrame5.f4135a;
        int i27 = (int) (((float) i8) + (((float) (i9 - i8)) * f6));
        widgetFrame4.f4136b = i27;
        int i28 = (int) (((float) i26) + (f6 * ((float) (i20 - i26))));
        widgetFrame4.f4137c = i28;
        float f12 = f2;
        float f13 = 1.0f - f12;
        widgetFrame4.f4138d = i27 + ((int) ((((float) i6) * f13) + (((float) i21) * f12)));
        widgetFrame4.f4139e = i28 + ((int) ((f13 * ((float) i5)) + (((float) i23) * f12)));
        widgetFrame4.f4140f = m(widgetFrame5.f4140f, widgetFrame6.f4140f, 0.5f, f12);
        widgetFrame4.f4141g = m(widgetFrame5.f4141g, widgetFrame6.f4141g, 0.5f, f12);
        widgetFrame4.f4142h = m(widgetFrame5.f4142h, widgetFrame6.f4142h, 0.0f, f12);
        widgetFrame4.f4143i = m(widgetFrame5.f4143i, widgetFrame6.f4143i, 0.0f, f12);
        widgetFrame4.f4144j = m(widgetFrame5.f4144j, widgetFrame6.f4144j, 0.0f, f12);
        widgetFrame4.f4148n = m(widgetFrame5.f4148n, widgetFrame6.f4148n, 1.0f, f12);
        widgetFrame4.o = m(widgetFrame5.o, widgetFrame6.o, 1.0f, f12);
        widgetFrame4.f4145k = m(widgetFrame5.f4145k, widgetFrame6.f4145k, 0.0f, f12);
        widgetFrame4.f4146l = m(widgetFrame5.f4146l, widgetFrame6.f4146l, 0.0f, f12);
        widgetFrame4.f4147m = m(widgetFrame5.f4147m, widgetFrame6.f4147m, 0.0f, f12);
        widgetFrame4.p = m(f5, f11, 1.0f, f12);
        Set<String> keySet = widgetFrame6.s.keySet();
        widgetFrame4.s.clear();
        for (String next : keySet) {
            if (widgetFrame5.s.containsKey(next)) {
                CustomVariable customVariable = widgetFrame5.s.get(next);
                CustomVariable customVariable2 = widgetFrame6.s.get(next);
                CustomVariable customVariable3 = new CustomVariable(customVariable);
                widgetFrame4.s.put(next, customVariable3);
                if (customVariable.r() == 1) {
                    customVariable3.y(Float.valueOf(m(customVariable.n(), customVariable2.n(), 0.0f, f12)));
                } else {
                    int r2 = customVariable.r();
                    float[] fArr = new float[r2];
                    float[] fArr2 = new float[r2];
                    customVariable.o(fArr);
                    customVariable2.o(fArr2);
                    for (int i29 = 0; i29 < r2; i29++) {
                        fArr[i29] = m(fArr[i29], fArr2[i29], 0.0f, f12);
                        customVariable3.z(fArr);
                    }
                }
            }
        }
    }

    private void u(StringBuilder sb, ConstraintAnchor.Type type) {
        ConstraintAnchor r2 = this.f4135a.r(type);
        if (r2 != null && r2.f4183f != null) {
            sb.append("Anchor");
            sb.append(type.name());
            sb.append(": ['");
            String str = r2.f4183f.i().o;
            if (str == null) {
                str = "#PARENT";
            }
            sb.append(str);
            sb.append("', '");
            sb.append(r2.f4183f.l().name());
            sb.append("', '");
            sb.append(r2.f4184g);
            sb.append("'],\n");
        }
    }

    public boolean A(String str, CLElement cLElement) throws CLParsingException {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1881940865:
                if (str.equals("phone_orientation")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1349088399:
                if (str.equals(SchedulerSupport.N)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 7;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 8;
                    break;
                }
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c2 = 9;
                    break;
                }
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c2 = 10;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 11;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 12;
                    break;
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    c2 = 13;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c2 = 14;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 15;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c2 = 16;
                    break;
                }
                break;
            case 642850769:
                if (str.equals("interpolatedPos")) {
                    c2 = 17;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                v = cLElement.j();
                break;
            case 1:
                this.f4139e = cLElement.k();
                break;
            case 2:
                q(cLElement);
                break;
            case 3:
                this.f4142h = cLElement.j();
                break;
            case 4:
                this.f4143i = cLElement.j();
                break;
            case 5:
                this.f4144j = cLElement.j();
                break;
            case 6:
                this.f4145k = cLElement.j();
                break;
            case 7:
                this.f4146l = cLElement.j();
                break;
            case 8:
                this.f4147m = cLElement.j();
                break;
            case 9:
                this.f4140f = cLElement.j();
                break;
            case 10:
                this.f4141g = cLElement.j();
                break;
            case 11:
                this.f4148n = cLElement.j();
                break;
            case 12:
                this.o = cLElement.j();
                break;
            case 13:
                this.f4137c = cLElement.k();
                break;
            case 14:
                this.f4136b = cLElement.k();
                break;
            case 15:
                this.p = cLElement.j();
                break;
            case 16:
                this.f4138d = cLElement.k();
                break;
            case 17:
                this.q = cLElement.j();
                break;
            default:
                return false;
        }
        return true;
    }

    public WidgetFrame B() {
        ConstraintWidget constraintWidget = this.f4135a;
        if (constraintWidget != null) {
            this.f4136b = constraintWidget.L();
            this.f4137c = this.f4135a.e0();
            this.f4138d = this.f4135a.X();
            this.f4139e = this.f4135a.v();
            D(this.f4135a.f4201n);
        }
        return this;
    }

    public WidgetFrame C(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.f4135a = constraintWidget;
        B();
        return this;
    }

    public void D(WidgetFrame widgetFrame) {
        this.f4140f = widgetFrame.f4140f;
        this.f4141g = widgetFrame.f4141g;
        this.f4142h = widgetFrame.f4142h;
        this.f4143i = widgetFrame.f4143i;
        this.f4144j = widgetFrame.f4144j;
        this.f4145k = widgetFrame.f4145k;
        this.f4146l = widgetFrame.f4146l;
        this.f4147m = widgetFrame.f4147m;
        this.f4148n = widgetFrame.f4148n;
        this.o = widgetFrame.o;
        this.p = widgetFrame.p;
        this.r = widgetFrame.r;
        this.s.clear();
        for (CustomVariable next : widgetFrame.s.values()) {
            this.s.put(next.k(), next.d());
        }
    }

    public int E() {
        return Math.max(0, this.f4138d - this.f4136b);
    }

    public void c(String str, int i2) {
        w(str, TypedValues.Custom.f3959l, i2);
    }

    public void d(String str, float f2) {
        v(str, TypedValues.Custom.f3958k, f2);
    }

    public float e() {
        int i2 = this.f4136b;
        return ((float) i2) + (((float) (this.f4138d - i2)) / 2.0f);
    }

    public float f() {
        int i2 = this.f4137c;
        return ((float) i2) + (((float) (this.f4139e - i2)) / 2.0f);
    }

    public CustomVariable g(String str) {
        return this.s.get(str);
    }

    public Set<String> h() {
        return this.s.keySet();
    }

    public int i(String str) {
        if (this.s.containsKey(str)) {
            return this.s.get(str).g();
        }
        return -21880;
    }

    public float j(String str) {
        if (this.s.containsKey(str)) {
            return this.s.get(str).h();
        }
        return Float.NaN;
    }

    public String k() {
        ConstraintWidget constraintWidget = this.f4135a;
        return constraintWidget == null ? "unknown" : constraintWidget.o;
    }

    public int l() {
        return Math.max(0, this.f4139e - this.f4137c);
    }

    public boolean o() {
        return Float.isNaN(this.f4142h) && Float.isNaN(this.f4143i) && Float.isNaN(this.f4144j) && Float.isNaN(this.f4145k) && Float.isNaN(this.f4146l) && Float.isNaN(this.f4147m) && Float.isNaN(this.f4148n) && Float.isNaN(this.o) && Float.isNaN(this.p);
    }

    /* access modifiers changed from: package-private */
    public void p(String str) {
        StringBuilder sb;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = (".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + StringUtils.SPACE + (hashCode() % 1000);
        if (this.f4135a != null) {
            sb = new StringBuilder();
            sb.append(str2);
            sb.append("/");
            sb.append(this.f4135a.hashCode() % 1000);
        } else {
            sb = new StringBuilder();
            sb.append(str2);
            sb.append("/NULL");
        }
        String sb2 = sb.toString();
        System.out.println(sb2 + StringUtils.SPACE + str);
    }

    /* access modifiers changed from: package-private */
    public void q(CLElement cLElement) throws CLParsingException {
        CLObject cLObject = (CLObject) cLElement;
        int size = cLObject.size();
        for (int i2 = 0; i2 < size; i2++) {
            CLKey cLKey = (CLKey) cLObject.I(i2);
            cLKey.c();
            CLElement m0 = cLKey.m0();
            String c2 = m0.c();
            if (c2.matches("#[0-9a-fA-F]+")) {
                w(cLKey.c(), TypedValues.Custom.f3959l, Integer.parseInt(c2.substring(1), 16));
            } else {
                boolean z = m0 instanceof CLNumber;
                String c3 = cLKey.c();
                if (z) {
                    v(c3, TypedValues.Custom.f3958k, m0.j());
                } else {
                    x(c3, TypedValues.Custom.f3960m, c2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r() {
        String str;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = (".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + StringUtils.SPACE + (hashCode() % 1000);
        if (this.f4135a != null) {
            str = str2 + "/" + (this.f4135a.hashCode() % 1000) + StringUtils.SPACE;
        } else {
            str = str2 + "/NULL ";
        }
        HashMap<String, CustomVariable> hashMap = this.s;
        if (hashMap != null) {
            for (String str3 : hashMap.keySet()) {
                System.out.println(str + this.s.get(str3).toString());
            }
        }
    }

    public StringBuilder s(StringBuilder sb) {
        return t(sb, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ed, code lost:
        r7.append("',\n");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00f8, code lost:
        r7.append(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x010f, code lost:
        r7.append(",\n");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.StringBuilder t(java.lang.StringBuilder r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "{\n"
            r7.append(r0)
            java.lang.String r0 = "left"
            int r1 = r6.f4136b
            b(r7, r0, r1)
            java.lang.String r0 = "top"
            int r1 = r6.f4137c
            b(r7, r0, r1)
            java.lang.String r0 = "right"
            int r1 = r6.f4138d
            b(r7, r0, r1)
            java.lang.String r0 = "bottom"
            int r1 = r6.f4139e
            b(r7, r0, r1)
            java.lang.String r0 = "pivotX"
            float r1 = r6.f4140f
            a(r7, r0, r1)
            java.lang.String r0 = "pivotY"
            float r1 = r6.f4141g
            a(r7, r0, r1)
            java.lang.String r0 = "rotationX"
            float r1 = r6.f4142h
            a(r7, r0, r1)
            java.lang.String r0 = "rotationY"
            float r1 = r6.f4143i
            a(r7, r0, r1)
            java.lang.String r0 = "rotationZ"
            float r1 = r6.f4144j
            a(r7, r0, r1)
            java.lang.String r0 = "translationX"
            float r1 = r6.f4145k
            a(r7, r0, r1)
            java.lang.String r0 = "translationY"
            float r1 = r6.f4146l
            a(r7, r0, r1)
            java.lang.String r0 = "translationZ"
            float r1 = r6.f4147m
            a(r7, r0, r1)
            java.lang.String r0 = "scaleX"
            float r1 = r6.f4148n
            a(r7, r0, r1)
            java.lang.String r0 = "scaleY"
            float r1 = r6.o
            a(r7, r0, r1)
            java.lang.String r0 = "alpha"
            float r1 = r6.p
            a(r7, r0, r1)
            java.lang.String r0 = "visibility"
            int r1 = r6.r
            b(r7, r0, r1)
            java.lang.String r0 = "interpolatedPos"
            float r1 = r6.q
            a(r7, r0, r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r6.f4135a
            if (r0 == 0) goto L_0x0090
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
            int r1 = r0.length
            r2 = 0
        L_0x0086:
            if (r2 >= r1) goto L_0x0090
            r3 = r0[r2]
            r6.u(r7, r3)
            int r2 = r2 + 1
            goto L_0x0086
        L_0x0090:
            java.lang.String r0 = "phone_orientation"
            if (r8 == 0) goto L_0x0099
            float r1 = v
            a(r7, r0, r1)
        L_0x0099:
            if (r8 == 0) goto L_0x00a0
            float r8 = v
            a(r7, r0, r8)
        L_0x00a0:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r8 = r6.s
            int r8 = r8.size()
            java.lang.String r0 = "}\n"
            if (r8 == 0) goto L_0x011e
            java.lang.String r8 = "custom : {\n"
            r7.append(r8)
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r8 = r6.s
            java.util.Set r8 = r8.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x00b9:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x011b
            java.lang.Object r1 = r8.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.CustomVariable> r2 = r6.s
            java.lang.Object r2 = r2.get(r1)
            androidx.constraintlayout.core.motion.CustomVariable r2 = (androidx.constraintlayout.core.motion.CustomVariable) r2
            r7.append(r1)
            java.lang.String r1 = ": "
            r7.append(r1)
            int r1 = r2.m()
            java.lang.String r3 = ",\n"
            java.lang.String r4 = "',\n"
            java.lang.String r5 = "'"
            switch(r1) {
                case 900: goto L_0x0113;
                case 901: goto L_0x0108;
                case 902: goto L_0x00fc;
                case 903: goto L_0x00f1;
                case 904: goto L_0x00e3;
                case 905: goto L_0x0108;
                default: goto L_0x00e2;
            }
        L_0x00e2:
            goto L_0x00b9
        L_0x00e3:
            r7.append(r5)
            boolean r1 = r2.f()
            r7.append(r1)
        L_0x00ed:
            r7.append(r4)
            goto L_0x00b9
        L_0x00f1:
            r7.append(r5)
            java.lang.String r1 = r2.l()
        L_0x00f8:
            r7.append(r1)
            goto L_0x00ed
        L_0x00fc:
            r7.append(r5)
            int r1 = r2.i()
            java.lang.String r1 = androidx.constraintlayout.core.motion.CustomVariable.c(r1)
            goto L_0x00f8
        L_0x0108:
            float r1 = r2.h()
            r7.append(r1)
        L_0x010f:
            r7.append(r3)
            goto L_0x00b9
        L_0x0113:
            int r1 = r2.i()
            r7.append(r1)
            goto L_0x010f
        L_0x011b:
            r7.append(r0)
        L_0x011e:
            r7.append(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.WidgetFrame.t(java.lang.StringBuilder, boolean):java.lang.StringBuilder");
    }

    public void v(String str, int i2, float f2) {
        if (this.s.containsKey(str)) {
            this.s.get(str).u(f2);
        } else {
            this.s.put(str, new CustomVariable(str, i2, f2));
        }
    }

    public void w(String str, int i2, int i3) {
        if (this.s.containsKey(str)) {
            this.s.get(str).v(i3);
        } else {
            this.s.put(str, new CustomVariable(str, i2, i3));
        }
    }

    public void x(String str, int i2, String str2) {
        if (this.s.containsKey(str)) {
            this.s.get(str).x(str2);
        } else {
            this.s.put(str, new CustomVariable(str, i2, str2));
        }
    }

    public void y(String str, int i2, boolean z) {
        if (this.s.containsKey(str)) {
            this.s.get(str).t(z);
        } else {
            this.s.put(str, new CustomVariable(str, i2, z));
        }
    }

    public void z(CustomAttribute customAttribute, float[] fArr) {
    }

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.f4135a = widgetFrame.f4135a;
        this.f4136b = widgetFrame.f4136b;
        this.f4137c = widgetFrame.f4137c;
        this.f4138d = widgetFrame.f4138d;
        this.f4139e = widgetFrame.f4139e;
        D(widgetFrame);
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.f4135a = constraintWidget;
    }
}
