package androidx.core.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.IntentCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

public final class ShareCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5601a = "androidx.core.app.EXTRA_CALLING_PACKAGE";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5602b = "android.support.v4.app.EXTRA_CALLING_PACKAGE";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5603c = "androidx.core.app.EXTRA_CALLING_ACTIVITY";

    /* renamed from: d  reason: collision with root package name */
    public static final String f5604d = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";

    /* renamed from: e  reason: collision with root package name */
    private static final String f5605e = ".sharecompat_";

    public static class IntentBuilder {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Context f5606a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final Intent f5607b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f5608c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<String> f5609d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<String> f5610e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private ArrayList<String> f5611f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private ArrayList<Uri> f5612g;

        public IntentBuilder(@NonNull Context context) {
            Activity activity;
            this.f5606a = (Context) Preconditions.l(context);
            Intent action = new Intent().setAction("android.intent.action.SEND");
            this.f5607b = action;
            action.putExtra(ShareCompat.f5601a, context.getPackageName());
            action.putExtra(ShareCompat.f5602b, context.getPackageName());
            action.addFlags(524288);
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (activity != null) {
                ComponentName componentName = activity.getComponentName();
                this.f5607b.putExtra(ShareCompat.f5603c, componentName);
                this.f5607b.putExtra(ShareCompat.f5604d, componentName);
            }
        }

        private void h(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.f5607b.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[(arrayList.size() + length)];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.f5607b.putExtra(str, strArr);
        }

        private void i(@Nullable String str, @NonNull String[] strArr) {
            Intent m2 = m();
            String[] stringArrayExtra = m2.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr2 = new String[(strArr.length + length)];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr2, 0, length);
            }
            System.arraycopy(strArr, 0, strArr2, length, strArr.length);
            m2.putExtra(str, strArr2);
        }

        @NonNull
        @Deprecated
        public static IntentBuilder k(@NonNull Activity activity) {
            return new IntentBuilder(activity);
        }

        @NonNull
        public IntentBuilder a(@NonNull String str) {
            if (this.f5611f == null) {
                this.f5611f = new ArrayList<>();
            }
            this.f5611f.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder b(@NonNull String[] strArr) {
            i("android.intent.extra.BCC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder c(@NonNull String str) {
            if (this.f5610e == null) {
                this.f5610e = new ArrayList<>();
            }
            this.f5610e.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder d(@NonNull String[] strArr) {
            i("android.intent.extra.CC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder e(@NonNull String str) {
            if (this.f5609d == null) {
                this.f5609d = new ArrayList<>();
            }
            this.f5609d.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder f(@NonNull String[] strArr) {
            i("android.intent.extra.EMAIL", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder g(@NonNull Uri uri) {
            if (this.f5612g == null) {
                this.f5612g = new ArrayList<>();
            }
            this.f5612g.add(uri);
            return this;
        }

        @NonNull
        public Intent j() {
            return Intent.createChooser(m(), this.f5608c);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Context l() {
            return this.f5606a;
        }

        @NonNull
        public Intent m() {
            ArrayList<String> arrayList = this.f5609d;
            if (arrayList != null) {
                h("android.intent.extra.EMAIL", arrayList);
                this.f5609d = null;
            }
            ArrayList<String> arrayList2 = this.f5610e;
            if (arrayList2 != null) {
                h("android.intent.extra.CC", arrayList2);
                this.f5610e = null;
            }
            ArrayList<String> arrayList3 = this.f5611f;
            if (arrayList3 != null) {
                h("android.intent.extra.BCC", arrayList3);
                this.f5611f = null;
            }
            ArrayList<Uri> arrayList4 = this.f5612g;
            if (arrayList4 == null || arrayList4.size() <= 1) {
                this.f5607b.setAction("android.intent.action.SEND");
                ArrayList<Uri> arrayList5 = this.f5612g;
                if (arrayList5 == null || arrayList5.isEmpty()) {
                    this.f5607b.removeExtra("android.intent.extra.STREAM");
                    this.f5607b.setClipData((ClipData) null);
                    Intent intent = this.f5607b;
                    intent.setFlags(intent.getFlags() & -2);
                    return this.f5607b;
                }
                this.f5607b.putExtra("android.intent.extra.STREAM", this.f5612g.get(0));
            } else {
                this.f5607b.setAction("android.intent.action.SEND_MULTIPLE");
                this.f5607b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f5612g);
            }
            ShareCompat.g(this.f5607b, this.f5612g);
            return this.f5607b;
        }

        @NonNull
        public IntentBuilder n(@StringRes int i2) {
            return o(this.f5606a.getText(i2));
        }

        @NonNull
        public IntentBuilder o(@Nullable CharSequence charSequence) {
            this.f5608c = charSequence;
            return this;
        }

        @NonNull
        public IntentBuilder p(@Nullable String[] strArr) {
            this.f5607b.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder q(@Nullable String[] strArr) {
            this.f5607b.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder r(@Nullable String[] strArr) {
            if (this.f5609d != null) {
                this.f5609d = null;
            }
            this.f5607b.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder s(@Nullable String str) {
            this.f5607b.putExtra(IntentCompat.f5642b, str);
            if (!this.f5607b.hasExtra("android.intent.extra.TEXT")) {
                v(Html.fromHtml(str));
            }
            return this;
        }

        @NonNull
        public IntentBuilder t(@Nullable Uri uri) {
            this.f5612g = null;
            if (uri != null) {
                g(uri);
            }
            return this;
        }

        @NonNull
        public IntentBuilder u(@Nullable String str) {
            this.f5607b.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }

        @NonNull
        public IntentBuilder v(@Nullable CharSequence charSequence) {
            this.f5607b.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        @NonNull
        public IntentBuilder w(@Nullable String str) {
            this.f5607b.setType(str);
            return this;
        }

        public void x() {
            this.f5606a.startActivity(j());
        }
    }

    public static class IntentReader {

        /* renamed from: f  reason: collision with root package name */
        private static final String f5613f = "IntentReader";
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Context f5614a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final Intent f5615b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final String f5616c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final ComponentName f5617d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<Uri> f5618e;

        public IntentReader(@NonNull Activity activity) {
            this((Context) Preconditions.l(activity), activity.getIntent());
        }

        @NonNull
        @Deprecated
        public static IntentReader a(@NonNull Activity activity) {
            return new IntentReader(activity);
        }

        @Nullable
        public ComponentName b() {
            return this.f5617d;
        }

        @Nullable
        public Drawable c() {
            if (this.f5617d == null) {
                return null;
            }
            try {
                return this.f5614a.getPackageManager().getActivityIcon(this.f5617d);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e(f5613f, "Could not retrieve icon for calling activity", e2);
                return null;
            }
        }

        @Nullable
        public Drawable d() {
            if (this.f5616c == null) {
                return null;
            }
            try {
                return this.f5614a.getPackageManager().getApplicationIcon(this.f5616c);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e(f5613f, "Could not retrieve icon for calling application", e2);
                return null;
            }
        }

        @Nullable
        public CharSequence e() {
            if (this.f5616c == null) {
                return null;
            }
            PackageManager packageManager = this.f5614a.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.f5616c, 0));
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e(f5613f, "Could not retrieve label for calling application", e2);
                return null;
            }
        }

        @Nullable
        public String f() {
            return this.f5616c;
        }

        @Nullable
        public String[] g() {
            return this.f5615b.getStringArrayExtra("android.intent.extra.BCC");
        }

        @Nullable
        public String[] h() {
            return this.f5615b.getStringArrayExtra("android.intent.extra.CC");
        }

        @Nullable
        public String[] i() {
            return this.f5615b.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        @Nullable
        public String j() {
            String stringExtra = this.f5615b.getStringExtra(IntentCompat.f5642b);
            if (stringExtra != null) {
                return stringExtra;
            }
            CharSequence o = o();
            if (o instanceof Spanned) {
                return Html.toHtml((Spanned) o);
            }
            return o != null ? Html.escapeHtml(o) : stringExtra;
        }

        @Nullable
        public Uri k() {
            return (Uri) this.f5615b.getParcelableExtra("android.intent.extra.STREAM");
        }

        @Nullable
        public Uri l(int i2) {
            Object parcelableExtra;
            if (this.f5618e == null && q()) {
                this.f5618e = this.f5615b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList arrayList = this.f5618e;
            if (arrayList != null) {
                parcelableExtra = arrayList.get(i2);
            } else if (i2 == 0) {
                parcelableExtra = this.f5615b.getParcelableExtra("android.intent.extra.STREAM");
            } else {
                throw new IndexOutOfBoundsException("Stream items available: " + m() + " index requested: " + i2);
            }
            return (Uri) parcelableExtra;
        }

        public int m() {
            if (this.f5618e == null && q()) {
                this.f5618e = this.f5615b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.f5618e;
            if (arrayList != null) {
                return arrayList.size();
            }
            return this.f5615b.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        @Nullable
        public String n() {
            return this.f5615b.getStringExtra("android.intent.extra.SUBJECT");
        }

        @Nullable
        public CharSequence o() {
            return this.f5615b.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        @Nullable
        public String p() {
            return this.f5615b.getType();
        }

        public boolean q() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.f5615b.getAction());
        }

        public boolean r() {
            String action = this.f5615b.getAction();
            return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
        }

        public boolean s() {
            return "android.intent.action.SEND".equals(this.f5615b.getAction());
        }

        public IntentReader(@NonNull Context context, @NonNull Intent intent) {
            this.f5614a = (Context) Preconditions.l(context);
            this.f5615b = (Intent) Preconditions.l(intent);
            this.f5616c = ShareCompat.f(intent);
            this.f5617d = ShareCompat.d(intent);
        }
    }

    private ShareCompat() {
    }

    @Deprecated
    public static void a(@NonNull Menu menu, @IdRes int i2, @NonNull IntentBuilder intentBuilder) {
        MenuItem findItem = menu.findItem(i2);
        if (findItem != null) {
            b(findItem, intentBuilder);
            return;
        }
        throw new IllegalArgumentException("Could not find menu item with id " + i2 + " in the supplied menu");
    }

    @Deprecated
    public static void b(@NonNull MenuItem menuItem, @NonNull IntentBuilder intentBuilder) {
        ActionProvider actionProvider = menuItem.getActionProvider();
        ShareActionProvider shareActionProvider = !(actionProvider instanceof ShareActionProvider) ? new ShareActionProvider(intentBuilder.l()) : (ShareActionProvider) actionProvider;
        shareActionProvider.setShareHistoryFileName(f5605e + intentBuilder.l().getClass().getName());
        shareActionProvider.setShareIntent(intentBuilder.m());
        menuItem.setActionProvider(shareActionProvider);
    }

    @Nullable
    public static ComponentName c(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        ComponentName callingActivity = activity.getCallingActivity();
        return callingActivity == null ? d(intent) : callingActivity;
    }

    @Nullable
    static ComponentName d(@NonNull Intent intent) {
        ComponentName componentName = (ComponentName) intent.getParcelableExtra(f5603c);
        return componentName == null ? (ComponentName) intent.getParcelableExtra(f5604d) : componentName;
    }

    @Nullable
    public static String e(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        String callingPackage = activity.getCallingPackage();
        return (callingPackage != null || intent == null) ? callingPackage : f(intent);
    }

    @Nullable
    static String f(@NonNull Intent intent) {
        String stringExtra = intent.getStringExtra(f5601a);
        return stringExtra == null ? intent.getStringExtra(f5602b) : stringExtra;
    }

    static void g(@NonNull Intent intent, @NonNull ArrayList<Uri> arrayList) {
        ClipData clipData = new ClipData((CharSequence) null, new String[]{intent.getType()}, new ClipData.Item(intent.getCharSequenceExtra("android.intent.extra.TEXT"), intent.getStringExtra(IntentCompat.f5642b), (Intent) null, arrayList.get(0)));
        int size = arrayList.size();
        for (int i2 = 1; i2 < size; i2++) {
            clipData.addItem(new ClipData.Item(arrayList.get(i2)));
        }
        intent.setClipData(clipData);
        intent.addFlags(1);
    }
}
