package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.itextpdf.text.Annotation;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    static final int A3 = 2;
    static final int B3 = -1;
    private static final boolean v3 = false;
    private static final String w3 = "SuggestionsAdapter";
    private static final int x3 = 50;
    static final int y3 = 0;
    static final int z3 = 1;
    private final SearchView h3;
    private final SearchableInfo i3;
    private final Context j3;
    private final WeakHashMap<String, Drawable.ConstantState> k3;
    private final int l3;
    private boolean m3 = false;
    private int n3 = 1;
    private ColorStateList o3;
    private int p3 = -1;
    private int q3 = -1;
    private int r3 = -1;
    private int s3 = -1;
    private int t3 = -1;
    private int u3 = -1;

    private static final class ChildViewCache {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f3273a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f3274b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f3275c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f3276d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f3277e;

        public ChildViewCache(View view) {
            this.f3273a = (TextView) view.findViewById(16908308);
            this.f3274b = (TextView) view.findViewById(16908309);
            this.f3275c = (ImageView) view.findViewById(16908295);
            this.f3276d = (ImageView) view.findViewById(16908296);
            this.f3277e = (ImageView) view.findViewById(R.id.z);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.h3 = searchView;
        this.i3 = searchableInfo;
        this.l3 = searchView.getSuggestionCommitIconResId();
        this.j3 = context;
        this.k3 = weakHashMap;
    }

    private Drawable A(Cursor cursor) {
        int i2 = this.t3;
        if (i2 == -1) {
            return null;
        }
        return y(cursor.getString(i2));
    }

    private static String D(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            Log.e(w3, "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    private void F(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void G(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    private void H(String str, Drawable drawable) {
        if (drawable != null) {
            this.k3.put(str, drawable.getConstantState());
        }
    }

    private void I(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable p(String str) {
        Drawable.ConstantState constantState = this.k3.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence r(CharSequence charSequence) {
        if (this.o3 == null) {
            TypedValue typedValue = new TypedValue();
            this.j3.getTheme().resolveAttribute(R.attr.x3, typedValue, true);
            this.o3 = this.j3.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.o3, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable s(ComponentName componentName) {
        String obj;
        PackageManager packageManager = this.j3.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            obj = "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString();
            Log.w(w3, obj);
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            obj = e2.toString();
        }
    }

    private Drawable t(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.k3.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.k3.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.j3.getResources());
        }
        Drawable s = s(componentName);
        if (s != null) {
            constantState = s.getConstantState();
        }
        this.k3.put(flattenToShortString, constantState);
        return s;
    }

    public static String u(Cursor cursor, String str) {
        return D(cursor, cursor.getColumnIndex(str));
    }

    private Drawable v() {
        Drawable t = t(this.i3.getSearchActivity());
        return t != null ? t : this.j3.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r7);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable w(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Error closing icon stream for "
            java.lang.String r1 = "SuggestionsAdapter"
            r2 = 0
            java.lang.String r3 = r7.getScheme()     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r4 = "android.resource"
            boolean r3 = r4.equals(r3)     // Catch:{ FileNotFoundException -> 0x0016 }
            if (r3 == 0) goto L_0x002f
            android.graphics.drawable.Drawable r7 = r6.x(r7)     // Catch:{ NotFoundException -> 0x0018 }
            return r7
        L_0x0016:
            r0 = move-exception
            goto L_0x0087
        L_0x0018:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0016 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r4 = "Resource does not exist: "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0016 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0016 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0016 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x002f:
            android.content.Context r3 = r6.j3     // Catch:{ FileNotFoundException -> 0x0016 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0016 }
            java.io.InputStream r3 = r3.openInputStream(r7)     // Catch:{ FileNotFoundException -> 0x0016 }
            if (r3 == 0) goto L_0x0070
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromStream(r3, r2)     // Catch:{ all -> 0x0057 }
            r3.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0056
        L_0x0043:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0016 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x0056:
            return r4
        L_0x0057:
            r4 = move-exception
            r3.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x006f
        L_0x005c:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0016 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x006f:
            throw r4     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x0070:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0016 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r4 = "Failed to open "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0016 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0016 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0016 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x0087:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Icon not found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = ", "
            r3.append(r7)
            java.lang.String r7 = r0.getMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            android.util.Log.w(r1, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SuggestionsAdapter.w(android.net.Uri):android.graphics.drawable.Drawable");
    }

    private Drawable y(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.j3.getPackageName() + "/" + parseInt;
            Drawable p = p(str2);
            if (p != null) {
                return p;
            }
            Drawable l2 = ContextCompat.l(this.j3, parseInt);
            H(str2, l2);
            return l2;
        } catch (NumberFormatException unused) {
            Drawable p2 = p(str);
            if (p2 != null) {
                return p2;
            }
            Drawable w = w(Uri.parse(str));
            H(str, w);
            return w;
        } catch (Resources.NotFoundException unused2) {
            Log.w(w3, "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable z(Cursor cursor) {
        int i2 = this.s3;
        if (i2 == -1) {
            return null;
        }
        Drawable y = y(cursor.getString(i2));
        return y != null ? y : v();
    }

    public int B() {
        return this.n3;
    }

    /* access modifiers changed from: package-private */
    public Cursor C(SearchableInfo searchableInfo, String str, int i2) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme(Annotation.i3).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i2 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.j3.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr2, (String) null);
    }

    public void E(int i2) {
        this.n3 = i2;
    }

    public CharSequence a(Cursor cursor) {
        String u;
        String u2;
        if (cursor == null) {
            return null;
        }
        String u4 = u(cursor, "suggest_intent_query");
        if (u4 != null) {
            return u4;
        }
        if (this.i3.shouldRewriteQueryFromData() && (u2 = u(cursor, "suggest_intent_data")) != null) {
            return u2;
        }
        if (!this.i3.shouldRewriteQueryFromText() || (u = u(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return u;
    }

    public void b(Cursor cursor) {
        if (this.m3) {
            Log.w(w3, "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.b(cursor);
            if (cursor != null) {
                this.p3 = cursor.getColumnIndex("suggest_text_1");
                this.q3 = cursor.getColumnIndex("suggest_text_2");
                this.r3 = cursor.getColumnIndex("suggest_text_2_url");
                this.s3 = cursor.getColumnIndex("suggest_icon_1");
                this.t3 = cursor.getColumnIndex("suggest_icon_2");
                this.u3 = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e(w3, "error changing cursor and caching columns", e2);
        }
    }

    public Cursor d(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.h3.getVisibility() == 0 && this.h3.getWindowVisibility() == 0) {
            try {
                Cursor C = C(this.i3, charSequence2, 50);
                if (C != null) {
                    C.getCount();
                    return C;
                }
            } catch (RuntimeException e2) {
                Log.w(w3, "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }

    public void e(View view, Context context, Cursor cursor) {
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i2 = this.u3;
        int i4 = i2 != -1 ? cursor.getInt(i2) : 0;
        if (childViewCache.f3273a != null) {
            G(childViewCache.f3273a, D(cursor, this.p3));
        }
        if (childViewCache.f3274b != null) {
            String D = D(cursor, this.r3);
            CharSequence r = D != null ? r(D) : D(cursor, this.q3);
            if (TextUtils.isEmpty(r)) {
                TextView textView = childViewCache.f3273a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    childViewCache.f3273a.setMaxLines(2);
                }
            } else {
                TextView textView2 = childViewCache.f3273a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    childViewCache.f3273a.setMaxLines(1);
                }
            }
            G(childViewCache.f3274b, r);
        }
        ImageView imageView = childViewCache.f3275c;
        if (imageView != null) {
            F(imageView, z(cursor), 4);
        }
        ImageView imageView2 = childViewCache.f3276d;
        if (imageView2 != null) {
            F(imageView2, A(cursor), 8);
        }
        int i5 = this.n3;
        if (i5 == 2 || (i5 == 1 && (i4 & 1) != 0)) {
            childViewCache.f3277e.setVisibility(0);
            childViewCache.f3277e.setTag(childViewCache.f3273a.getText());
            childViewCache.f3277e.setOnClickListener(this);
            return;
        }
        childViewCache.f3277e.setVisibility(8);
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w(w3, "Search suggestions cursor threw exception.", e2);
            View i4 = i(this.j3, c(), viewGroup);
            if (i4 != null) {
                ((ChildViewCache) i4.getTag()).f3273a.setText(e2.toString());
            }
            return i4;
        }
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w(w3, "Search suggestions cursor threw exception.", e2);
            View j2 = j(this.j3, c(), viewGroup);
            if (j2 != null) {
                ((ChildViewCache) j2.getTag()).f3273a.setText(e2.toString());
            }
            return j2;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
        View j2 = super.j(context, cursor, viewGroup);
        j2.setTag(new ChildViewCache(j2));
        ((ImageView) j2.findViewById(R.id.z)).setImageResource(this.l3);
        return j2;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        I(c());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        I(c());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.h3.b0((CharSequence) tag);
        }
    }

    public void q() {
        b((Cursor) null);
        this.m3 = true;
    }

    /* access modifiers changed from: package-private */
    public Drawable x(Uri uri) throws FileNotFoundException {
        int i2;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.j3.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i2 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i2 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i2 != 0) {
                        return resourcesForApplication.getDrawable(i2);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }
}
