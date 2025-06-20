package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppCompatViewInflater {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?>[] f2786b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f2787c = {16843375};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f2788d = {16844160};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f2789e = {16844156};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f2790f = {16844148};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f2791g = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: h  reason: collision with root package name */
    private static final String f2792h = "AppCompatViewInflater";

    /* renamed from: i  reason: collision with root package name */
    private static final SimpleArrayMap<String, Constructor<? extends View>> f2793i = new SimpleArrayMap<>();

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f2794a = new Object[2];

    private static class DeclaredOnClickListener implements View.OnClickListener {
        private final String X;
        private Method Y;
        private Context Z;
        private final View s;

        public DeclaredOnClickListener(@NonNull View view, @NonNull String str) {
            this.s = view;
            this.X = str;
        }

        private void a(@Nullable Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.X, new Class[]{View.class})) != null) {
                        this.Y = method;
                        this.Z = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.s.getId();
            if (id == -1) {
                str = "";
            } else {
                str = " with id '" + this.s.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.X + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.s.getClass() + str);
        }

        public void onClick(@NonNull View view) {
            if (this.Y == null) {
                a(this.s.getContext());
            }
            try {
                this.Y.invoke(this.Z, new Object[]{view});
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    private void a(@NonNull Context context, @NonNull View view, @NonNull AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT <= 28) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2788d);
            if (obtainStyledAttributes.hasValue(0)) {
                ViewCompat.I1(view, obtainStyledAttributes.getBoolean(0, false));
            }
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f2789e);
            if (obtainStyledAttributes2.hasValue(0)) {
                ViewCompat.K1(view, obtainStyledAttributes2.getString(0));
            }
            obtainStyledAttributes2.recycle();
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f2790f);
            if (obtainStyledAttributes3.hasValue(0)) {
                ViewCompat.x2(view, obtainStyledAttributes3.getBoolean(0, false));
            }
            obtainStyledAttributes3.recycle();
        }
    }

    private void b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && view.hasOnClickListeners()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2787c);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new DeclaredOnClickListener(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View s(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        SimpleArrayMap<String, Constructor<? extends View>> simpleArrayMap = f2793i;
        Constructor<? extends U> constructor = simpleArrayMap.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f2786b);
            simpleArrayMap.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f2794a);
    }

    private View t(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        try {
            Object[] objArr = this.f2794a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                int i2 = 0;
                while (true) {
                    String[] strArr = f2791g;
                    if (i2 < strArr.length) {
                        View s = s(context, str, strArr[i2]);
                        if (s != null) {
                            return s;
                        }
                        i2++;
                    } else {
                        Object[] objArr2 = this.f2794a;
                        objArr2[0] = null;
                        objArr2[1] = null;
                        return null;
                    }
                }
            } else {
                View s2 = s(context, str, (String) null);
                Object[] objArr3 = this.f2794a;
                objArr3[0] = null;
                objArr3[1] = null;
                return s2;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr4 = this.f2794a;
            objArr4[0] = null;
            objArr4[1] = null;
        }
    }

    private static Context u(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.W6, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(R.styleable.X6, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.b7, 0)) != 0) {
            Log.i(f2792h, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return (!(context instanceof ContextThemeWrapper) || ((ContextThemeWrapper) context).c() != resourceId) ? new ContextThemeWrapper(context, resourceId) : context;
        }
        return context;
    }

    private void v(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatAutoCompleteTextView c(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatButton d(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatCheckBox e(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatCheckedTextView f(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatEditText g(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatImageButton h(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatImageView i(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatMultiAutoCompleteTextView j(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatRadioButton k(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatRatingBar l(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatSeekBar m(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatSpinner n(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatTextView o(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatToggleButton p(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public View q(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    @Nullable
    public final View r(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View view2;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = u(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = TintContextWrapper.b(context2);
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = 2;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 3;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c2 = 4;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = 5;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = 6;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = 12;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = 13;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                view2 = l(context2, attributeSet);
                break;
            case 1:
                view2 = f(context2, attributeSet);
                break;
            case 2:
                view2 = j(context2, attributeSet);
                break;
            case 3:
                view2 = o(context2, attributeSet);
                break;
            case 4:
                view2 = h(context2, attributeSet);
                break;
            case 5:
                view2 = m(context2, attributeSet);
                break;
            case 6:
                view2 = n(context2, attributeSet);
                break;
            case 7:
                view2 = k(context2, attributeSet);
                break;
            case 8:
                view2 = p(context2, attributeSet);
                break;
            case 9:
                view2 = i(context2, attributeSet);
                break;
            case 10:
                view2 = c(context2, attributeSet);
                break;
            case 11:
                view2 = e(context2, attributeSet);
                break;
            case 12:
                view2 = g(context2, attributeSet);
                break;
            case 13:
                view2 = d(context2, attributeSet);
                break;
            default:
                view2 = q(context2, str, attributeSet);
                break;
        }
        v(view2, str);
        if (view2 == null && context != context2) {
            view2 = t(context2, str, attributeSet);
        }
        if (view2 != null) {
            b(view2, attributeSet);
            a(context2, view2, attributeSet);
        }
        return view2;
    }
}
