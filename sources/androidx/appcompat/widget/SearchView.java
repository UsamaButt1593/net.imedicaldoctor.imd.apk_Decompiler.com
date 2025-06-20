package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.android.gms.actions.SearchIntents;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
    static final boolean v4 = false;
    static final String w4 = "SearchView";
    private static final String x4 = "nm";
    static final PreQAutoCompleteTextViewReflector y4 = (Build.VERSION.SDK_INT < 29 ? new PreQAutoCompleteTextViewReflector() : null);
    private final View A3;
    final ImageView B3;
    final ImageView C3;
    final ImageView D3;
    final ImageView E3;
    private final View F3;
    private UpdatableTouchDelegate G3;
    private Rect H3;
    private Rect I3;
    private int[] J3;
    private int[] K3;
    private final ImageView L3;
    private final Drawable M3;
    private final int N3;
    private final int O3;
    private final Intent P3;
    private final Intent Q3;
    private final CharSequence R3;
    private OnQueryTextListener S3;
    private OnCloseListener T3;
    View.OnFocusChangeListener U3;
    private OnSuggestionListener V3;
    private View.OnClickListener W3;
    private boolean X3;
    private boolean Y3;
    CursorAdapter Z3;
    private boolean a4;
    private CharSequence b4;
    private boolean c4;
    private boolean d4;
    private int e4;
    private boolean f4;
    private CharSequence g4;
    private CharSequence h4;
    private boolean i4;
    private int j4;
    SearchableInfo k4;
    private Bundle l4;
    private final Runnable m4;
    private Runnable n4;
    private final WeakHashMap<String, Drawable.ConstantState> o4;
    private final View.OnClickListener p4;
    View.OnKeyListener q4;
    private final TextView.OnEditorActionListener r4;
    private final AdapterView.OnItemClickListener s4;
    private final AdapterView.OnItemSelectedListener t4;
    private TextWatcher u4;
    final SearchAutoComplete x3;
    private final View y3;
    private final View z3;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        @DoNotInline
        static void b(SearchAutoComplete searchAutoComplete, int i2) {
            searchAutoComplete.setInputMethodMode(i2);
        }
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<SearchView> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3249a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f3250b;

        /* renamed from: c  reason: collision with root package name */
        private int f3251c;

        /* renamed from: d  reason: collision with root package name */
        private int f3252d;

        /* renamed from: e  reason: collision with root package name */
        private int f3253e;

        /* renamed from: a */
        public void readProperties(@NonNull SearchView searchView, @NonNull PropertyReader propertyReader) {
            if (this.f3249a) {
                propertyReader.readInt(this.f3250b, searchView.getImeOptions());
                propertyReader.readInt(this.f3251c, searchView.getMaxWidth());
                propertyReader.readBoolean(this.f3252d, searchView.P());
                propertyReader.readObject(this.f3253e, searchView.getQueryHint());
                return;
            }
            throw C0004e.a();
        }

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.f3250b = propertyMapper.mapInt("imeOptions", 16843364);
            this.f3251c = propertyMapper.mapInt("maxWidth", 16843039);
            this.f3252d = propertyMapper.mapBoolean("iconifiedByDefault", R.attr.J1);
            this.f3253e = propertyMapper.mapObject("queryHint", R.attr.G2);
            this.f3249a = true;
        }
    }

    public interface OnCloseListener {
        boolean a();
    }

    public interface OnQueryTextListener {
        boolean a(String str);

        boolean b(String str);
    }

    public interface OnSuggestionListener {
        boolean a(int i2);

        boolean b(int i2);
    }

    private static class PreQAutoCompleteTextViewReflector {

        /* renamed from: a  reason: collision with root package name */
        private Method f3254a = null;

        /* renamed from: b  reason: collision with root package name */
        private Method f3255b = null;

        /* renamed from: c  reason: collision with root package name */
        private Method f3256c = null;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        PreQAutoCompleteTextViewReflector() {
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            d();
            try {
                Method declaredMethod = cls.getDeclaredMethod("doBeforeTextChanged", (Class[]) null);
                this.f3254a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = cls.getDeclaredMethod("doAfterTextChanged", (Class[]) null);
                this.f3255b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f3256c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        /* access modifiers changed from: package-private */
        public void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f3255b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, (Object[]) null);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f3254a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, (Object[]) null);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f3256c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.TRUE});
                } catch (Exception unused) {
                }
            }
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        boolean Y;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Y = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.Y + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeValue(Boolean.valueOf(this.Y));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private int a3;
        private SearchView b3;
        private boolean c3;
        final Runnable d3;

        public SearchAutoComplete(Context context) {
            this(context, (AttributeSet) null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i2 = configuration.screenWidthDp;
            int i3 = configuration.screenHeightDp;
            if (i2 >= 960 && i3 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i2 >= 600) {
                return PsExtractor.x;
            }
            if (i2 < 640 || i3 < 480) {
                return 160;
            }
            return PsExtractor.x;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.y4.c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (this.c3) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.c3 = false;
            }
        }

        public boolean enoughToFilter() {
            return this.a3 <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.c3) {
                removeCallbacks(this.d3);
                post(this.d3);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i2, Rect rect) {
            super.onFocusChanged(z, i2, rect);
            this.b3.g0();
        }

        public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
            if (i2 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.b3.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i2, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.b3.hasFocus() && getVisibility() == 0) {
                this.c3 = true;
                if (SearchView.R(getContext())) {
                    c();
                }
            }
        }

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        /* access modifiers changed from: package-private */
        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.c3 = false;
                removeCallbacks(this.d3);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.c3 = false;
                removeCallbacks(this.d3);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.c3 = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.b3 = searchView;
        }

        public void setThreshold(int i2) {
            super.setThreshold(i2);
            this.a3 = i2;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.S);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            this.d3 = new Runnable() {
                public void run() {
                    SearchAutoComplete.this.e();
                }
            };
            this.a3 = getThreshold();
        }
    }

    private static class UpdatableTouchDelegate extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final View f3257a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f3258b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private final Rect f3259c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        private final Rect f3260d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        private final int f3261e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3262f;

        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f3261e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.f3257a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f3258b.set(rect);
            this.f3260d.set(rect);
            Rect rect3 = this.f3260d;
            int i2 = this.f3261e;
            rect3.inset(-i2, -i2);
            this.f3259c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                r7 = this;
                float r0 = r8.getX()
                int r0 = (int) r0
                float r1 = r8.getY()
                int r1 = (int) r1
                int r2 = r8.getAction()
                r3 = 2
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L_0x0031
                if (r2 == r5) goto L_0x0022
                if (r2 == r3) goto L_0x0022
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003c
            L_0x001b:
                boolean r2 = r7.f3262f
                r7.f3262f = r4
            L_0x001f:
                r5 = r2
            L_0x0020:
                r2 = 1
                goto L_0x003e
            L_0x0022:
                boolean r2 = r7.f3262f
                if (r2 == 0) goto L_0x001f
                android.graphics.Rect r6 = r7.f3260d
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x001f
                r5 = r2
                r2 = 0
                goto L_0x003e
            L_0x0031:
                android.graphics.Rect r2 = r7.f3258b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003c
                r7.f3262f = r5
                goto L_0x0020
            L_0x003c:
                r2 = 1
                r5 = 0
            L_0x003e:
                if (r5 == 0) goto L_0x006e
                if (r2 == 0) goto L_0x005e
                android.graphics.Rect r2 = r7.f3259c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x005e
                android.view.View r0 = r7.f3257a
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r7.f3257a
                int r1 = r1.getHeight()
                int r1 = r1 / r3
            L_0x0059:
                float r1 = (float) r1
                r8.setLocation(r0, r1)
                goto L_0x0068
            L_0x005e:
                android.graphics.Rect r2 = r7.f3259c
                int r3 = r2.left
                int r0 = r0 - r3
                float r0 = (float) r0
                int r2 = r2.top
                int r1 = r1 - r2
                goto L_0x0059
            L_0x0068:
                android.view.View r0 = r7.f3257a
                boolean r4 = r0.dispatchTouchEvent(r8)
            L_0x006e:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.UpdatableTouchDelegate.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private Intent G(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.h4);
        if (str3 != null) {
            intent.putExtra(SearchIntents.f19720b, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.l4;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.k4.getSearchActivity());
        return intent;
    }

    private Intent H(Cursor cursor, int i2, String str) {
        int i3;
        String u;
        try {
            String u2 = SuggestionsAdapter.u(cursor, "suggest_intent_action");
            if (u2 == null) {
                u2 = this.k4.getSuggestIntentAction();
            }
            if (u2 == null) {
                u2 = "android.intent.action.SEARCH";
            }
            String str2 = u2;
            String u3 = SuggestionsAdapter.u(cursor, "suggest_intent_data");
            if (u3 == null) {
                u3 = this.k4.getSuggestIntentData();
            }
            if (!(u3 == null || (u = SuggestionsAdapter.u(cursor, "suggest_intent_data_id")) == null)) {
                u3 = u3 + "/" + Uri.encode(u);
            }
            return G(str2, u3 == null ? null : Uri.parse(u3), SuggestionsAdapter.u(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.u(cursor, "suggest_intent_query"), i2, str);
        } catch (RuntimeException e2) {
            try {
                i3 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i3 = -1;
            }
            Log.w(w4, "Search suggestions cursor at row " + i3 + " returned exception.", e2);
            return null;
        }
    }

    private Intent I(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.l4;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent J(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void K() {
        this.x3.dismissDropDown();
    }

    private void M(View view, Rect rect) {
        view.getLocationInWindow(this.J3);
        getLocationInWindow(this.K3);
        int[] iArr = this.J3;
        int i2 = iArr[1];
        int[] iArr2 = this.K3;
        int i3 = i2 - iArr2[1];
        int i5 = iArr[0] - iArr2[0];
        rect.set(i5, i3, view.getWidth() + i5, view.getHeight() + i3);
    }

    private CharSequence N(CharSequence charSequence) {
        if (!this.X3 || this.M3 == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.x3.getTextSize()) * 1.25d);
        this.M3.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.M3), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean O() {
        SearchableInfo searchableInfo = this.k4;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = this.k4.getVoiceSearchLaunchWebSearch() ? this.P3 : this.k4.getVoiceSearchLaunchRecognizer() ? this.Q3 : null;
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean R(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean T() {
        return (this.a4 || this.f4) && !Q();
    }

    private void V(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e2) {
                Log.e(w4, "Failed launch activity: " + intent, e2);
            }
        }
    }

    private boolean X(int i2, int i3, String str) {
        Cursor c2 = this.Z3.c();
        if (c2 == null || !c2.moveToPosition(i2)) {
            return false;
        }
        V(H(c2, i3, str));
        return true;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.c0);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.d0);
    }

    private void i0() {
        post(this.m4);
    }

    private void j0(int i2) {
        CharSequence a2;
        Editable text = this.x3.getText();
        Cursor c2 = this.Z3.c();
        if (c2 != null) {
            if (!c2.moveToPosition(i2) || (a2 = this.Z3.a(c2)) == null) {
                setQuery(text);
            } else {
                setQuery(a2);
            }
        }
    }

    private void l0() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.x3.getText());
        int i2 = 0;
        if (!z2 && (!this.X3 || this.i4)) {
            z = false;
        }
        ImageView imageView = this.D3;
        if (!z) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.D3.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void n0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.x3;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(N(queryHint));
    }

    private void o0() {
        this.x3.setThreshold(this.k4.getSuggestThreshold());
        this.x3.setImeOptions(this.k4.getImeOptions());
        int inputType = this.k4.getInputType();
        int i2 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.k4.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.x3.setInputType(inputType);
        CursorAdapter cursorAdapter = this.Z3;
        if (cursorAdapter != null) {
            cursorAdapter.b((Cursor) null);
        }
        if (this.k4.getSuggestAuthority() != null) {
            SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.k4, this.o4);
            this.Z3 = suggestionsAdapter;
            this.x3.setAdapter(suggestionsAdapter);
            SuggestionsAdapter suggestionsAdapter2 = (SuggestionsAdapter) this.Z3;
            if (this.c4) {
                i2 = 2;
            }
            suggestionsAdapter2.E(i2);
        }
    }

    private void p0() {
        this.A3.setVisibility((!T() || !(this.C3.getVisibility() == 0 || this.E3.getVisibility() == 0)) ? 8 : 0);
    }

    private void q0(boolean z) {
        this.C3.setVisibility((!this.a4 || !T() || !hasFocus() || (!z && this.f4)) ? 8 : 0);
    }

    private void r0(boolean z) {
        this.Y3 = z;
        int i2 = 8;
        int i3 = z ? 0 : 8;
        boolean isEmpty = TextUtils.isEmpty(this.x3.getText());
        this.B3.setVisibility(i3);
        q0(!isEmpty);
        this.y3.setVisibility(z ? 8 : 0);
        if (this.L3.getDrawable() != null && !this.X3) {
            i2 = 0;
        }
        this.L3.setVisibility(i2);
        l0();
        s0(isEmpty);
        p0();
    }

    private void s0(boolean z) {
        int i2 = 8;
        if (this.f4 && !Q() && z) {
            this.C3.setVisibility(8);
            i2 = 0;
        }
        this.E3.setVisibility(i2);
    }

    private void setQuery(CharSequence charSequence) {
        this.x3.setText(charSequence);
        this.x3.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* access modifiers changed from: package-private */
    public void F() {
        if (this.F3.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.z3.getPaddingLeft();
            Rect rect = new Rect();
            boolean b2 = ViewUtils.b(this);
            int dimensionPixelSize = this.X3 ? resources.getDimensionPixelSize(R.dimen.P) + resources.getDimensionPixelSize(R.dimen.Q) : 0;
            this.x3.getDropDownBackground().getPadding(rect);
            int i2 = rect.left;
            this.x3.setDropDownHorizontalOffset(b2 ? -i2 : paddingLeft - (i2 + dimensionPixelSize));
            this.x3.setDropDownWidth((((this.F3.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* access modifiers changed from: package-private */
    public void L() {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.a(this.x3);
            return;
        }
        PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = y4;
        preQAutoCompleteTextViewReflector.b(this.x3);
        preQAutoCompleteTextViewReflector.a(this.x3);
    }

    public boolean P() {
        return this.X3;
    }

    public boolean Q() {
        return this.Y3;
    }

    public boolean S() {
        return this.c4;
    }

    public boolean U() {
        return this.a4;
    }

    /* access modifiers changed from: package-private */
    public void W(int i2, String str, String str2) {
        getContext().startActivity(G("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i2, str));
    }

    /* access modifiers changed from: package-private */
    public void Y() {
        if (!TextUtils.isEmpty(this.x3.getText())) {
            this.x3.setText("");
            this.x3.requestFocus();
            this.x3.setImeVisibility(true);
        } else if (this.X3) {
            OnCloseListener onCloseListener = this.T3;
            if (onCloseListener == null || !onCloseListener.a()) {
                clearFocus();
                r0(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean Z(int i2, int i3, String str) {
        OnSuggestionListener onSuggestionListener = this.V3;
        if (onSuggestionListener != null && onSuggestionListener.b(i2)) {
            return false;
        }
        X(i2, 0, (String) null);
        this.x3.setImeVisibility(false);
        K();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a0(int i2) {
        OnSuggestionListener onSuggestionListener = this.V3;
        if (onSuggestionListener != null && onSuggestionListener.a(i2)) {
            return false;
        }
        j0(i2);
        return true;
    }

    public void b() {
        if (!this.i4) {
            this.i4 = true;
            int imeOptions = this.x3.getImeOptions();
            this.j4 = imeOptions;
            this.x3.setImeOptions(imeOptions | 33554432);
            this.x3.setText("");
            setIconified(false);
        }
    }

    /* access modifiers changed from: protected */
    public void b0(@Nullable CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void c0() {
        r0(false);
        this.x3.requestFocus();
        this.x3.setImeVisibility(true);
        View.OnClickListener onClickListener = this.W3;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void clearFocus() {
        this.d4 = true;
        super.clearFocus();
        this.x3.clearFocus();
        this.x3.setImeVisibility(false);
        this.d4 = false;
    }

    public void d() {
        k0("", false);
        clearFocus();
        r0(true);
        this.x3.setImeOptions(this.j4);
        this.i4 = false;
    }

    /* access modifiers changed from: package-private */
    public void d0() {
        Editable text = this.x3.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            OnQueryTextListener onQueryTextListener = this.S3;
            if (onQueryTextListener == null || !onQueryTextListener.b(text.toString())) {
                if (this.k4 != null) {
                    W(0, (String) null, text.toString());
                }
                this.x3.setImeVisibility(false);
                K();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e0(View view, int i2, KeyEvent keyEvent) {
        if (this.k4 != null && this.Z3 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return Z(this.x3.getListSelection(), 0, (String) null);
            }
            if (i2 == 21 || i2 == 22) {
                this.x3.setSelection(i2 == 21 ? 0 : this.x3.length());
                this.x3.setListSelection(0);
                this.x3.clearListSelection();
                this.x3.c();
                return true;
            } else if (i2 == 19) {
                this.x3.getListSelection();
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void f0(CharSequence charSequence) {
        Editable text = this.x3.getText();
        this.h4 = text;
        boolean isEmpty = TextUtils.isEmpty(text);
        q0(!isEmpty);
        s0(isEmpty);
        l0();
        p0();
        if (this.S3 != null && !TextUtils.equals(charSequence, this.g4)) {
            this.S3.a(charSequence.toString());
        }
        this.g4 = charSequence.toString();
    }

    /* access modifiers changed from: package-private */
    public void g0() {
        r0(Q());
        i0();
        if (this.x3.hasFocus()) {
            L();
        }
    }

    public int getImeOptions() {
        return this.x3.getImeOptions();
    }

    public int getInputType() {
        return this.x3.getInputType();
    }

    public int getMaxWidth() {
        return this.e4;
    }

    public CharSequence getQuery() {
        return this.x3.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.b4;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.k4;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.R3 : getContext().getText(this.k4.getHintId());
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.O3;
    }

    /* access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.N3;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.Z3;
    }

    /* access modifiers changed from: package-private */
    public void h0() {
        Intent I;
        SearchableInfo searchableInfo = this.k4;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    I = J(this.P3, searchableInfo);
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    I = I(this.Q3, searchableInfo);
                } else {
                    return;
                }
                getContext().startActivity(I);
            } catch (ActivityNotFoundException unused) {
                Log.w(w4, "Could not find voice search activity");
            }
        }
    }

    public void k0(CharSequence charSequence, boolean z) {
        this.x3.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.x3;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.h4 = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            d0();
        }
    }

    /* access modifiers changed from: package-private */
    public void m0() {
        int[] iArr = this.x3.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.z3.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.A3.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.m4);
        post(this.n4);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i5, int i6) {
        super.onLayout(z, i2, i3, i5, i6);
        if (z) {
            M(this.x3, this.H3);
            Rect rect = this.I3;
            Rect rect2 = this.H3;
            rect.set(rect2.left, 0, rect2.right, i6 - i3);
            UpdatableTouchDelegate updatableTouchDelegate = this.G3;
            if (updatableTouchDelegate == null) {
                UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(this.I3, this.H3, this.x3);
                this.G3 = updatableTouchDelegate2;
                setTouchDelegate(updatableTouchDelegate2);
                return;
            }
            updatableTouchDelegate.a(this.I3, this.H3);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r0 <= 0) goto L_0x003a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.Q()
            if (r0 == 0) goto L_0x000a
            super.onMeasure(r4, r5)
            return
        L_0x000a:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L_0x0030
            if (r0 == 0) goto L_0x0026
            if (r0 == r2) goto L_0x001d
            goto L_0x003a
        L_0x001d:
            int r0 = r3.e4
            if (r0 <= 0) goto L_0x003a
        L_0x0021:
            int r4 = java.lang.Math.min(r0, r4)
            goto L_0x003a
        L_0x0026:
            int r4 = r3.e4
            if (r4 <= 0) goto L_0x002b
            goto L_0x003a
        L_0x002b:
            int r4 = r3.getPreferredWidth()
            goto L_0x003a
        L_0x0030:
            int r0 = r3.e4
            if (r0 <= 0) goto L_0x0035
            goto L_0x0021
        L_0x0035:
            int r0 = r3.getPreferredWidth()
            goto L_0x0021
        L_0x003a:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L_0x004c
            if (r0 == 0) goto L_0x0047
            goto L_0x0054
        L_0x0047:
            int r5 = r3.getPreferredHeight()
            goto L_0x0054
        L_0x004c:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L_0x0054:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        r0(savedState.Y);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Y = Q();
        return savedState;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        i0();
    }

    public boolean requestFocus(int i2, Rect rect) {
        if (this.d4 || !isFocusable()) {
            return false;
        }
        if (Q()) {
            return super.requestFocus(i2, rect);
        }
        boolean requestFocus = this.x3.requestFocus(i2, rect);
        if (requestFocus) {
            r0(false);
        }
        return requestFocus;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle bundle) {
        this.l4 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            Y();
        } else {
            c0();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.X3 != z) {
            this.X3 = z;
            r0(z);
            n0();
        }
    }

    public void setImeOptions(int i2) {
        this.x3.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.x3.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.e4 = i2;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.T3 = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.U3 = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.S3 = onQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.W3 = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.V3 = onSuggestionListener;
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        this.b4 = charSequence;
        n0();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.c4 = z;
        CursorAdapter cursorAdapter = this.Z3;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) cursorAdapter).E(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.k4 = searchableInfo;
        if (searchableInfo != null) {
            o0();
            n0();
        }
        boolean O = O();
        this.f4 = O;
        if (O) {
            this.x3.setPrivateImeOptions(x4);
        }
        r0(Q());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.a4 = z;
        r0(Q());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.Z3 = cursorAdapter;
        this.x3.setAdapter(cursorAdapter);
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.N2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.H3 = new Rect();
        this.I3 = new Rect();
        this.J3 = new int[2];
        this.K3 = new int[2];
        this.m4 = new Runnable() {
            public void run() {
                SearchView.this.m0();
            }
        };
        this.n4 = new Runnable() {
            public void run() {
                CursorAdapter cursorAdapter = SearchView.this.Z3;
                if (cursorAdapter instanceof SuggestionsAdapter) {
                    cursorAdapter.b((Cursor) null);
                }
            }
        };
        this.o4 = new WeakHashMap<>();
        AnonymousClass5 r8 = new View.OnClickListener() {
            public void onClick(View view) {
                SearchView searchView = SearchView.this;
                if (view == searchView.B3) {
                    searchView.c0();
                } else if (view == searchView.D3) {
                    searchView.Y();
                } else if (view == searchView.C3) {
                    searchView.d0();
                } else if (view == searchView.E3) {
                    searchView.h0();
                } else if (view == searchView.x3) {
                    searchView.L();
                }
            }
        };
        this.p4 = r8;
        this.q4 = new View.OnKeyListener() {
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                SearchView searchView = SearchView.this;
                if (searchView.k4 == null) {
                    return false;
                }
                if (searchView.x3.isPopupShowing() && SearchView.this.x3.getListSelection() != -1) {
                    return SearchView.this.e0(view, i2, keyEvent);
                }
                if (SearchView.this.x3.d() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView searchView2 = SearchView.this;
                searchView2.W(0, (String) null, searchView2.x3.getText().toString());
                return true;
            }
        };
        AnonymousClass7 r9 = new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.d0();
                return true;
            }
        };
        this.r4 = r9;
        AnonymousClass8 r10 = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                SearchView.this.Z(i2, 0, (String) null);
            }
        };
        this.s4 = r10;
        AnonymousClass9 r11 = new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                SearchView.this.a0(i2);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.t4 = r11;
        this.u4 = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.f0(charSequence);
            }
        };
        int[] iArr = R.styleable.b5;
        AttributeSet attributeSet2 = attributeSet;
        int i3 = i2;
        TintTypedArray G = TintTypedArray.G(context, attributeSet2, iArr, i3, 0);
        ViewCompat.F1(this, context, iArr, attributeSet2, G.B(), i3, 0);
        LayoutInflater.from(context).inflate(G.u(R.styleable.v5, R.layout.z), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.e0);
        this.x3 = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.y3 = findViewById(R.id.a0);
        View findViewById = findViewById(R.id.d0);
        this.z3 = findViewById;
        View findViewById2 = findViewById(R.id.o0);
        this.A3 = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.Y);
        this.B3 = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.b0);
        this.C3 = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.Z);
        this.D3 = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.f0);
        this.E3 = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.c0);
        this.L3 = imageView5;
        ViewCompat.P1(findViewById, G.h(R.styleable.w5));
        ViewCompat.P1(findViewById2, G.h(R.styleable.B5));
        int i5 = R.styleable.z5;
        imageView.setImageDrawable(G.h(i5));
        imageView2.setImageDrawable(G.h(R.styleable.r5));
        imageView3.setImageDrawable(G.h(R.styleable.o5));
        imageView4.setImageDrawable(G.h(R.styleable.E5));
        imageView5.setImageDrawable(G.h(i5));
        this.M3 = G.h(R.styleable.y5);
        TooltipCompat.a(imageView, getResources().getString(R.string.v));
        this.N3 = G.u(R.styleable.C5, R.layout.y);
        this.O3 = G.u(R.styleable.p5, 0);
        imageView.setOnClickListener(r8);
        imageView3.setOnClickListener(r8);
        imageView2.setOnClickListener(r8);
        imageView4.setOnClickListener(r8);
        searchAutoComplete.setOnClickListener(r8);
        searchAutoComplete.addTextChangedListener(this.u4);
        searchAutoComplete.setOnEditorActionListener(r9);
        searchAutoComplete.setOnItemClickListener(r10);
        searchAutoComplete.setOnItemSelectedListener(r11);
        searchAutoComplete.setOnKeyListener(this.q4);
        searchAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                SearchView searchView = SearchView.this;
                View.OnFocusChangeListener onFocusChangeListener = searchView.U3;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(searchView, z);
                }
            }
        });
        setIconifiedByDefault(G.a(R.styleable.u5, true));
        int g2 = G.g(R.styleable.e5, -1);
        if (g2 != -1) {
            setMaxWidth(g2);
        }
        this.R3 = G.x(R.styleable.q5);
        this.b4 = G.x(R.styleable.x5);
        int o = G.o(R.styleable.i5, -1);
        if (o != -1) {
            setImeOptions(o);
        }
        int o2 = G.o(R.styleable.h5, -1);
        if (o2 != -1) {
            setInputType(o2);
        }
        setFocusable(G.a(R.styleable.d5, true));
        G.I();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.P3 = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.Q3 = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.F3 = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    SearchView.this.F();
                }
            });
        }
        r0(this.X3);
        n0();
    }
}
