package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintAttribute {

    /* renamed from: i  reason: collision with root package name */
    private static final String f4615i = "TransitionLayout";

    /* renamed from: a  reason: collision with root package name */
    private boolean f4616a;

    /* renamed from: b  reason: collision with root package name */
    String f4617b;

    /* renamed from: c  reason: collision with root package name */
    private AttributeType f4618c;

    /* renamed from: d  reason: collision with root package name */
    private int f4619d;

    /* renamed from: e  reason: collision with root package name */
    private float f4620e;

    /* renamed from: f  reason: collision with root package name */
    private String f4621f;

    /* renamed from: g  reason: collision with root package name */
    boolean f4622g;

    /* renamed from: h  reason: collision with root package name */
    private int f4623h;

    /* renamed from: androidx.constraintlayout.widget.ConstraintAttribute$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4624a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType[] r0 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4624a = r0
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.REFERENCE_TYPE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4624a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.BOOLEAN_TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4624a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.STRING_TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4624a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4624a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f4624a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.INT_TYPE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f4624a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.FLOAT_TYPE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f4624a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.DIMENSION_TYPE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintAttribute.AnonymousClass1.<clinit>():void");
        }
    }

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.f4616a = false;
        this.f4617b = constraintAttribute.f4617b;
        this.f4618c = constraintAttribute.f4618c;
        w(obj);
    }

    private static int b(int i2) {
        int i3 = (i2 & (~(i2 >> 31))) - 255;
        return (i3 & (i3 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> d(HashMap<String, ConstraintAttribute> hashMap, View view) {
        ConstraintAttribute constraintAttribute;
        HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute2 = hashMap.get(next);
            try {
                if (next.equals("BackgroundColor")) {
                    constraintAttribute = new ConstraintAttribute(constraintAttribute2, (Object) Integer.valueOf(((ColorDrawable) view.getBackground()).getColor()));
                } else {
                    constraintAttribute = new ConstraintAttribute(constraintAttribute2, cls.getMethod("getMap" + next, (Class[]) null).invoke(view, (Object[]) null));
                }
                hashMap2.put(next, constraintAttribute);
            } catch (NoSuchMethodException e2) {
                e = e2;
                e.printStackTrace();
            } catch (IllegalAccessException e3) {
                e = e3;
                e.printStackTrace();
            } catch (InvocationTargetException e4) {
                e = e4;
                e.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void q(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        AttributeType attributeType;
        int resourceId;
        Object string;
        AttributeType attributeType2;
        float f2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.qd);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        AttributeType attributeType3 = null;
        boolean z = false;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.rd) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R.styleable.Bd) {
                str = obtainStyledAttributes.getString(index);
                z = true;
            } else if (index == R.styleable.sd) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType3 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.ud) {
                    attributeType = AttributeType.COLOR_TYPE;
                } else if (index == R.styleable.td) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                } else {
                    if (index == R.styleable.yd) {
                        attributeType2 = AttributeType.DIMENSION_TYPE;
                        f2 = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == R.styleable.vd) {
                        attributeType2 = AttributeType.DIMENSION_TYPE;
                        f2 = obtainStyledAttributes.getDimension(index, 0.0f);
                    } else if (index == R.styleable.wd) {
                        attributeType2 = AttributeType.FLOAT_TYPE;
                        f2 = obtainStyledAttributes.getFloat(index, Float.NaN);
                    } else {
                        if (index == R.styleable.xd) {
                            attributeType = AttributeType.INT_TYPE;
                            resourceId = obtainStyledAttributes.getInteger(index, -1);
                        } else if (index == R.styleable.Ad) {
                            attributeType = AttributeType.STRING_TYPE;
                            string = obtainStyledAttributes.getString(index);
                            Object obj2 = string;
                            attributeType3 = attributeType;
                            obj = obj2;
                        } else if (index == R.styleable.zd) {
                            attributeType = AttributeType.REFERENCE_TYPE;
                            resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            if (resourceId == -1) {
                                resourceId = obtainStyledAttributes.getInt(index, -1);
                            }
                        }
                        string = Integer.valueOf(resourceId);
                        Object obj22 = string;
                        attributeType3 = attributeType;
                        obj = obj22;
                    }
                    string = Float.valueOf(f2);
                    Object obj222 = string;
                    attributeType3 = attributeType;
                    obj = obj222;
                }
                resourceId = obtainStyledAttributes.getColor(index, 0);
                string = Integer.valueOf(resourceId);
                Object obj2222 = string;
                attributeType3 = attributeType;
                obj = obj2222;
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new ConstraintAttribute(str, attributeType3, obj, z));
        }
        obtainStyledAttributes.recycle();
    }

    public static void r(View view, HashMap<String, ConstraintAttribute> hashMap) {
        String str;
        StringBuilder sb;
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(next);
            if (!constraintAttribute.f4616a) {
                str = "set" + next;
            } else {
                str = next;
            }
            try {
                switch (AnonymousClass1.f4624a[constraintAttribute.f4618c.ordinal()]) {
                    case 1:
                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(constraintAttribute.f4619d)});
                        break;
                    case 2:
                        cls.getMethod(str, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(constraintAttribute.f4622g)});
                        break;
                    case 3:
                        cls.getMethod(str, new Class[]{CharSequence.class}).invoke(view, new Object[]{constraintAttribute.f4621f});
                        break;
                    case 4:
                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(constraintAttribute.f4623h)});
                        break;
                    case 5:
                        Method method = cls.getMethod(str, new Class[]{Drawable.class});
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.f4623h);
                        method.invoke(view, new Object[]{colorDrawable});
                        break;
                    case 6:
                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(constraintAttribute.f4619d)});
                        break;
                    case 7:
                        cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(constraintAttribute.f4620e)});
                        break;
                    case 8:
                        cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(constraintAttribute.f4620e)});
                        break;
                }
            } catch (NoSuchMethodException e2) {
                Log.e(f4615i, e2.getMessage());
                Log.e(f4615i, " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cls.getName());
                sb2.append(" must have a method ");
                sb2.append(str);
                Log.e(f4615i, sb2.toString());
            } catch (IllegalAccessException e3) {
                e = e3;
                sb = new StringBuilder();
                sb.append(" Custom Attribute \"");
                sb.append(next);
                sb.append("\" not found on ");
                sb.append(cls.getName());
                Log.e(f4615i, sb.toString());
                e.printStackTrace();
            } catch (InvocationTargetException e4) {
                e = e4;
                sb = new StringBuilder();
                sb.append(" Custom Attribute \"");
                sb.append(next);
                sb.append("\" not found on ");
                sb.append(cls.getName());
                Log.e(f4615i, sb.toString());
                e.printStackTrace();
            }
        }
    }

    public void a(View view) {
        String str;
        StringBuilder sb;
        Class<?> cls = view.getClass();
        String str2 = this.f4617b;
        if (!this.f4616a) {
            str = "set" + str2;
        } else {
            str = str2;
        }
        try {
            switch (AnonymousClass1.f4624a[this.f4618c.ordinal()]) {
                case 1:
                case 6:
                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(this.f4619d)});
                    return;
                case 2:
                    cls.getMethod(str, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(this.f4622g)});
                    return;
                case 3:
                    cls.getMethod(str, new Class[]{CharSequence.class}).invoke(view, new Object[]{this.f4621f});
                    return;
                case 4:
                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(this.f4623h)});
                    return;
                case 5:
                    Method method = cls.getMethod(str, new Class[]{Drawable.class});
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(this.f4623h);
                    method.invoke(view, new Object[]{colorDrawable});
                    return;
                case 7:
                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(this.f4620e)});
                    return;
                case 8:
                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(this.f4620e)});
                    return;
                default:
                    return;
            }
        } catch (NoSuchMethodException e2) {
            Log.e(f4615i, e2.getMessage());
            Log.e(f4615i, " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append(" must have a method ");
            sb2.append(str);
            Log.e(f4615i, sb2.toString());
        } catch (IllegalAccessException e3) {
            e = e3;
            sb = new StringBuilder();
            sb.append(" Custom Attribute \"");
            sb.append(str2);
            sb.append("\" not found on ");
            sb.append(cls.getName());
            Log.e(f4615i, sb.toString());
            e.printStackTrace();
        } catch (InvocationTargetException e4) {
            e = e4;
            sb = new StringBuilder();
            sb.append(" Custom Attribute \"");
            sb.append(str2);
            sb.append("\" not found on ");
            sb.append(cls.getName());
            Log.e(f4615i, sb.toString());
            e.printStackTrace();
        }
    }

    public boolean c(ConstraintAttribute constraintAttribute) {
        AttributeType attributeType;
        if (constraintAttribute == null || (attributeType = this.f4618c) != constraintAttribute.f4618c) {
            return false;
        }
        switch (AnonymousClass1.f4624a[attributeType.ordinal()]) {
            case 1:
            case 6:
                return this.f4619d == constraintAttribute.f4619d;
            case 2:
                return this.f4622g == constraintAttribute.f4622g;
            case 3:
                return this.f4619d == constraintAttribute.f4619d;
            case 4:
            case 5:
                return this.f4623h == constraintAttribute.f4623h;
            case 7:
                return this.f4620e == constraintAttribute.f4620e;
            case 8:
                return this.f4620e == constraintAttribute.f4620e;
            default:
                return false;
        }
    }

    public int e() {
        return this.f4623h;
    }

    public float f() {
        return this.f4620e;
    }

    public int g() {
        return this.f4619d;
    }

    public String h() {
        return this.f4617b;
    }

    public String i() {
        return this.f4621f;
    }

    public AttributeType j() {
        return this.f4618c;
    }

    public float k() {
        switch (AnonymousClass1.f4624a[this.f4618c.ordinal()]) {
            case 2:
                return this.f4622g ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return (float) this.f4619d;
            case 7:
                return this.f4620e;
            case 8:
                return this.f4620e;
            default:
                return Float.NaN;
        }
    }

    public void l(float[] fArr) {
        switch (AnonymousClass1.f4624a[this.f4618c.ordinal()]) {
            case 2:
                fArr[0] = this.f4622g ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i2 = this.f4623h;
                float pow = (float) Math.pow((double) (((float) ((i2 >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i2 >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i2 & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i2 >> 24) & 255)) / 255.0f;
                return;
            case 6:
                fArr[0] = (float) this.f4619d;
                return;
            case 7:
                fArr[0] = this.f4620e;
                return;
            case 8:
                fArr[0] = this.f4620e;
                return;
            default:
                return;
        }
    }

    public boolean m() {
        return this.f4622g;
    }

    public boolean n() {
        int i2 = AnonymousClass1.f4624a[this.f4618c.ordinal()];
        return (i2 == 1 || i2 == 2 || i2 == 3) ? false : true;
    }

    public boolean o() {
        return this.f4616a;
    }

    public int p() {
        int i2 = AnonymousClass1.f4624a[this.f4618c.ordinal()];
        return (i2 == 4 || i2 == 5) ? 4 : 1;
    }

    public void s(int i2) {
        this.f4623h = i2;
    }

    public void t(float f2) {
        this.f4620e = f2;
    }

    public void u(int i2) {
        this.f4619d = i2;
    }

    public void v(String str) {
        this.f4621f = str;
    }

    public void w(Object obj) {
        switch (AnonymousClass1.f4624a[this.f4618c.ordinal()]) {
            case 1:
            case 6:
                this.f4619d = ((Integer) obj).intValue();
                return;
            case 2:
                this.f4622g = ((Boolean) obj).booleanValue();
                return;
            case 3:
                this.f4621f = (String) obj;
                return;
            case 4:
            case 5:
                this.f4623h = ((Integer) obj).intValue();
                return;
            case 7:
            case 8:
                this.f4620e = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public void x(float[] fArr) {
        float f2;
        boolean z = false;
        switch (AnonymousClass1.f4624a[this.f4618c.ordinal()]) {
            case 1:
            case 6:
                this.f4619d = (int) fArr[0];
                return;
            case 2:
                if (((double) fArr[0]) > 0.5d) {
                    z = true;
                }
                this.f4622g = z;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int HSVToColor = Color.HSVToColor(fArr);
                this.f4623h = HSVToColor;
                this.f4623h = (b((int) (fArr[3] * 255.0f)) << 24) | (HSVToColor & ViewCompat.x);
                return;
            case 7:
                f2 = fArr[0];
                break;
            case 8:
                f2 = fArr[0];
                break;
            default:
                return;
        }
        this.f4620e = f2;
    }

    public ConstraintAttribute(String str, AttributeType attributeType) {
        this.f4616a = false;
        this.f4617b = str;
        this.f4618c = attributeType;
    }

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj, boolean z) {
        this.f4617b = str;
        this.f4618c = attributeType;
        this.f4616a = z;
        w(obj);
    }
}
