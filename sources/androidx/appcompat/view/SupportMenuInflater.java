package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportMenuInflater extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    static final String f2918e = "SupportMenuInflater";

    /* renamed from: f  reason: collision with root package name */
    private static final String f2919f = "menu";

    /* renamed from: g  reason: collision with root package name */
    private static final String f2920g = "group";

    /* renamed from: h  reason: collision with root package name */
    private static final String f2921h = "item";

    /* renamed from: i  reason: collision with root package name */
    static final int f2922i = 0;

    /* renamed from: j  reason: collision with root package name */
    static final Class<?>[] f2923j;

    /* renamed from: k  reason: collision with root package name */
    static final Class<?>[] f2924k;

    /* renamed from: a  reason: collision with root package name */
    final Object[] f2925a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f2926b;

    /* renamed from: c  reason: collision with root package name */
    Context f2927c;

    /* renamed from: d  reason: collision with root package name */
    private Object f2928d;

    private static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?>[] f2929c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        private Object f2930a;

        /* renamed from: b  reason: collision with root package name */
        private Method f2931b;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.f2930a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f2931b = cls.getMethod(str, f2929c);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f2931b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f2931b.invoke(this.f2930a, new Object[]{menuItem})).booleanValue();
                }
                this.f2931b.invoke(this.f2930a, new Object[]{menuItem});
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private class MenuState {
        private static final int G = 0;
        private static final int H = 0;
        private static final int I = 0;
        private static final int J = 0;
        private static final int K = 0;
        private static final boolean L = false;
        private static final boolean M = true;
        private static final boolean N = true;
        ActionProvider A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f2932a;

        /* renamed from: b  reason: collision with root package name */
        private int f2933b;

        /* renamed from: c  reason: collision with root package name */
        private int f2934c;

        /* renamed from: d  reason: collision with root package name */
        private int f2935d;

        /* renamed from: e  reason: collision with root package name */
        private int f2936e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2937f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2938g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f2939h;

        /* renamed from: i  reason: collision with root package name */
        private int f2940i;

        /* renamed from: j  reason: collision with root package name */
        private int f2941j;

        /* renamed from: k  reason: collision with root package name */
        private CharSequence f2942k;

        /* renamed from: l  reason: collision with root package name */
        private CharSequence f2943l;

        /* renamed from: m  reason: collision with root package name */
        private int f2944m;

        /* renamed from: n  reason: collision with root package name */
        private char f2945n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public MenuState(Menu menu) {
            this.f2932a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.f2927c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w(SupportMenuInflater.f2918e, "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.f2943l).setIcon(this.f2944m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!SupportMenuInflater.this.f2927c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(SupportMenuInflater.this.b(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).w(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).j(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) e(str, SupportMenuInflater.f2923j, SupportMenuInflater.this.f2925a));
                z2 = true;
            }
            int i3 = this.w;
            if (i3 > 0) {
                if (!z2) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w(SupportMenuInflater.f2918e, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider actionProvider = this.A;
            if (actionProvider != null) {
                MenuItemCompat.l(menuItem, actionProvider);
            }
            MenuItemCompat.p(menuItem, this.B);
            MenuItemCompat.w(menuItem, this.C);
            MenuItemCompat.o(menuItem, this.f2945n, this.o);
            MenuItemCompat.s(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                MenuItemCompat.r(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                MenuItemCompat.q(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f2939h = true;
            i(this.f2932a.add(this.f2933b, this.f2940i, this.f2941j, this.f2942k));
        }

        public SubMenu b() {
            this.f2939h = true;
            SubMenu addSubMenu = this.f2932a.addSubMenu(this.f2933b, this.f2940i, this.f2941j, this.f2942k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f2939h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.f2927c.obtainStyledAttributes(attributeSet, R.styleable.d4);
            this.f2933b = obtainStyledAttributes.getResourceId(R.styleable.f4, 0);
            this.f2934c = obtainStyledAttributes.getInt(R.styleable.h4, 0);
            this.f2935d = obtainStyledAttributes.getInt(R.styleable.i4, 0);
            this.f2936e = obtainStyledAttributes.getInt(R.styleable.j4, 0);
            this.f2937f = obtainStyledAttributes.getBoolean(R.styleable.g4, true);
            this.f2938g = obtainStyledAttributes.getBoolean(R.styleable.e4, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            TintTypedArray F2 = TintTypedArray.F(SupportMenuInflater.this.f2927c, attributeSet, R.styleable.k4);
            this.f2940i = F2.u(R.styleable.n4, 0);
            this.f2941j = (F2.o(R.styleable.q4, this.f2934c) & SupportMenu.f5941c) | (F2.o(R.styleable.r4, this.f2935d) & 65535);
            this.f2942k = F2.x(R.styleable.s4);
            this.f2943l = F2.x(R.styleable.t4);
            this.f2944m = F2.u(R.styleable.l4, 0);
            this.f2945n = c(F2.w(R.styleable.u4));
            this.o = F2.o(R.styleable.B4, 4096);
            this.p = c(F2.w(R.styleable.v4));
            this.q = F2.o(R.styleable.F4, 4096);
            int i2 = R.styleable.w4;
            this.r = F2.C(i2) ? F2.a(i2, false) : this.f2936e;
            this.s = F2.a(R.styleable.o4, false);
            this.t = F2.a(R.styleable.p4, this.f2937f);
            this.u = F2.a(R.styleable.m4, this.f2938g);
            this.v = F2.o(R.styleable.G4, -1);
            this.z = F2.w(R.styleable.x4);
            this.w = F2.u(R.styleable.y4, 0);
            this.x = F2.w(R.styleable.A4);
            String w2 = F2.w(R.styleable.z4);
            this.y = w2;
            boolean z2 = w2 != null;
            if (z2 && this.w == 0 && this.x == null) {
                this.A = (ActionProvider) e(w2, SupportMenuInflater.f2924k, SupportMenuInflater.this.f2926b);
            } else {
                if (z2) {
                    Log.w(SupportMenuInflater.f2918e, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = F2.x(R.styleable.C4);
            this.C = F2.x(R.styleable.H4);
            int i3 = R.styleable.E4;
            if (F2.C(i3)) {
                this.E = DrawableUtils.e(F2.o(i3, -1), this.E);
            } else {
                this.E = null;
            }
            int i4 = R.styleable.D4;
            if (F2.C(i4)) {
                this.D = F2.d(i4);
            } else {
                this.D = null;
            }
            F2.I();
            this.f2939h = false;
        }

        public void h() {
            this.f2933b = 0;
            this.f2934c = 0;
            this.f2935d = 0;
            this.f2936e = 0;
            this.f2937f = true;
            this.f2938g = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            r2 = 0
            r0[r2] = r1
            f2923j = r0
            f2924k = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.SupportMenuInflater.<clinit>():void");
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f2927c = context;
        Object[] objArr = {context};
        this.f2925a = objArr;
        this.f2926b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        MenuState menuState = new MenuState(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                        } else if (name2.equals(f2920g)) {
                            menuState.h();
                        } else if (name2.equals(f2921h)) {
                            if (!menuState.d()) {
                                ActionProvider actionProvider = menuState.A;
                                if (actionProvider == null || !actionProvider.b()) {
                                    menuState.a();
                                } else {
                                    menuState.b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals(f2920g)) {
                        menuState.f(attributeSet);
                    } else if (name3.equals(f2921h)) {
                        menuState.g(attributeSet);
                    } else if (name3.equals("menu")) {
                        c(xmlPullParser, attributeSet, menuState.b());
                    } else {
                        str = name3;
                        z2 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object b() {
        if (this.f2928d == null) {
            this.f2928d = a(this.f2927c);
        }
        return this.f2928d;
    }

    public void inflate(@LayoutRes int i2, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        boolean z = false;
        try {
            XmlResourceParser layout2 = this.f2927c.getResources().getLayout(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(layout2);
            if (menu instanceof MenuBuilder) {
                MenuBuilder menuBuilder = (MenuBuilder) menu;
                if (menuBuilder.I()) {
                    menuBuilder.n0();
                    z = true;
                }
            }
            c(layout2, asAttributeSet, menu);
            if (z) {
                ((MenuBuilder) menu).m0();
            }
            if (layout2 != null) {
                layout2.close();
            }
        } catch (XmlPullParserException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (IOException e3) {
            throw new InflateException("Error inflating menu XML", e3);
        } catch (Throwable th) {
            if (0 != 0) {
                ((MenuBuilder) menu).m0();
            }
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
