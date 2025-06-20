package androidx.core.content.pm;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShortcutInfoCompat {
    private static final String C = "extraPersonCount";
    private static final String D = "extraPerson_";
    private static final String E = "extraLocusId";
    private static final String F = "extraLongLived";
    private static final String G = "extraSliceUri";
    public static final int H = 1;
    int A;
    int B;

    /* renamed from: a  reason: collision with root package name */
    Context f5702a;

    /* renamed from: b  reason: collision with root package name */
    String f5703b;

    /* renamed from: c  reason: collision with root package name */
    String f5704c;

    /* renamed from: d  reason: collision with root package name */
    Intent[] f5705d;

    /* renamed from: e  reason: collision with root package name */
    ComponentName f5706e;

    /* renamed from: f  reason: collision with root package name */
    CharSequence f5707f;

    /* renamed from: g  reason: collision with root package name */
    CharSequence f5708g;

    /* renamed from: h  reason: collision with root package name */
    CharSequence f5709h;

    /* renamed from: i  reason: collision with root package name */
    IconCompat f5710i;

    /* renamed from: j  reason: collision with root package name */
    boolean f5711j;

    /* renamed from: k  reason: collision with root package name */
    Person[] f5712k;

    /* renamed from: l  reason: collision with root package name */
    Set<String> f5713l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    LocusIdCompat f5714m;

    /* renamed from: n  reason: collision with root package name */
    boolean f5715n;
    int o;
    PersistableBundle p;
    Bundle q;
    long r;
    UserHandle s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y = true;
    boolean z;

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        static void a(@NonNull ShortcutInfo.Builder builder, int i2) {
            builder.setExcludedFromSurfaces(i2);
        }
    }

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final ShortcutInfoCompat f5716a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f5717b;

        /* renamed from: c  reason: collision with root package name */
        private Set<String> f5718c;

        /* renamed from: d  reason: collision with root package name */
        private Map<String, Map<String, List<String>>> f5719d;

        /* renamed from: e  reason: collision with root package name */
        private Uri f5720e;

        @RequiresApi(25)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull Context context, @NonNull ShortcutInfo shortcutInfo) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.f5716a = shortcutInfoCompat;
            shortcutInfoCompat.f5702a = context;
            shortcutInfoCompat.f5703b = shortcutInfo.getId();
            shortcutInfoCompat.f5704c = shortcutInfo.getPackage();
            Intent[] a2 = shortcutInfo.getIntents();
            shortcutInfoCompat.f5705d = (Intent[]) Arrays.copyOf(a2, a2.length);
            shortcutInfoCompat.f5706e = shortcutInfo.getActivity();
            shortcutInfoCompat.f5707f = shortcutInfo.getShortLabel();
            shortcutInfoCompat.f5708g = shortcutInfo.getLongLabel();
            shortcutInfoCompat.f5709h = shortcutInfo.getDisabledMessage();
            int i2 = Build.VERSION.SDK_INT;
            shortcutInfoCompat.A = i2 >= 28 ? shortcutInfo.getDisabledReason() : shortcutInfo.isEnabled() ? 0 : 3;
            shortcutInfoCompat.f5713l = shortcutInfo.getCategories();
            shortcutInfoCompat.f5712k = ShortcutInfoCompat.u(shortcutInfo.getExtras());
            shortcutInfoCompat.s = shortcutInfo.getUserHandle();
            shortcutInfoCompat.r = shortcutInfo.getLastChangedTimestamp();
            if (i2 >= 30) {
                shortcutInfoCompat.t = shortcutInfo.isCached();
            }
            shortcutInfoCompat.u = shortcutInfo.isDynamic();
            shortcutInfoCompat.v = shortcutInfo.isPinned();
            shortcutInfoCompat.w = shortcutInfo.isDeclaredInManifest();
            shortcutInfoCompat.x = shortcutInfo.isImmutable();
            shortcutInfoCompat.y = shortcutInfo.isEnabled();
            shortcutInfoCompat.z = shortcutInfo.hasKeyFieldsOnly();
            shortcutInfoCompat.f5714m = ShortcutInfoCompat.p(shortcutInfo);
            shortcutInfoCompat.o = shortcutInfo.getRank();
            shortcutInfoCompat.p = shortcutInfo.getExtras();
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @NonNull
        public Builder a(@NonNull String str) {
            if (this.f5718c == null) {
                this.f5718c = new HashSet();
            }
            this.f5718c.add(str);
            return this;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @NonNull
        public Builder b(@NonNull String str, @NonNull String str2, @NonNull List<String> list) {
            a(str);
            if (!list.isEmpty()) {
                if (this.f5719d == null) {
                    this.f5719d = new HashMap();
                }
                if (this.f5719d.get(str) == null) {
                    this.f5719d.put(str, new HashMap());
                }
                this.f5719d.get(str).put(str2, list);
            }
            return this;
        }

        @NonNull
        public ShortcutInfoCompat c() {
            if (!TextUtils.isEmpty(this.f5716a.f5707f)) {
                ShortcutInfoCompat shortcutInfoCompat = this.f5716a;
                Intent[] intentArr = shortcutInfoCompat.f5705d;
                if (intentArr == null || intentArr.length == 0) {
                    throw new IllegalArgumentException("Shortcut must have an intent");
                }
                if (this.f5717b) {
                    if (shortcutInfoCompat.f5714m == null) {
                        shortcutInfoCompat.f5714m = new LocusIdCompat(shortcutInfoCompat.f5703b);
                    }
                    this.f5716a.f5715n = true;
                }
                if (this.f5718c != null) {
                    ShortcutInfoCompat shortcutInfoCompat2 = this.f5716a;
                    if (shortcutInfoCompat2.f5713l == null) {
                        shortcutInfoCompat2.f5713l = new HashSet();
                    }
                    this.f5716a.f5713l.addAll(this.f5718c);
                }
                if (this.f5719d != null) {
                    ShortcutInfoCompat shortcutInfoCompat3 = this.f5716a;
                    if (shortcutInfoCompat3.p == null) {
                        shortcutInfoCompat3.p = new PersistableBundle();
                    }
                    for (String next : this.f5719d.keySet()) {
                        Map map = this.f5719d.get(next);
                        this.f5716a.p.putStringArray(next, (String[]) map.keySet().toArray(new String[0]));
                        for (String str : map.keySet()) {
                            List list = (List) map.get(str);
                            PersistableBundle persistableBundle = this.f5716a.p;
                            persistableBundle.putStringArray(next + "/" + str, list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                        }
                    }
                }
                if (this.f5720e != null) {
                    ShortcutInfoCompat shortcutInfoCompat4 = this.f5716a;
                    if (shortcutInfoCompat4.p == null) {
                        shortcutInfoCompat4.p = new PersistableBundle();
                    }
                    this.f5716a.p.putString(ShortcutInfoCompat.G, UriCompat.a(this.f5720e));
                }
                return this.f5716a;
            }
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        @NonNull
        public Builder d(@NonNull ComponentName componentName) {
            this.f5716a.f5706e = componentName;
            return this;
        }

        @NonNull
        public Builder e() {
            this.f5716a.f5711j = true;
            return this;
        }

        @NonNull
        public Builder f(@NonNull Set<String> set) {
            ArraySet arraySet = new ArraySet();
            arraySet.addAll(set);
            this.f5716a.f5713l = arraySet;
            return this;
        }

        @NonNull
        public Builder g(@NonNull CharSequence charSequence) {
            this.f5716a.f5709h = charSequence;
            return this;
        }

        @NonNull
        public Builder h(int i2) {
            this.f5716a.B = i2;
            return this;
        }

        @NonNull
        public Builder i(@NonNull PersistableBundle persistableBundle) {
            this.f5716a.p = persistableBundle;
            return this;
        }

        @NonNull
        public Builder j(IconCompat iconCompat) {
            this.f5716a.f5710i = iconCompat;
            return this;
        }

        @NonNull
        public Builder k(@NonNull Intent intent) {
            return l(new Intent[]{intent});
        }

        @NonNull
        public Builder l(@NonNull Intent[] intentArr) {
            this.f5716a.f5705d = intentArr;
            return this;
        }

        @NonNull
        public Builder m() {
            this.f5717b = true;
            return this;
        }

        @NonNull
        public Builder n(@Nullable LocusIdCompat locusIdCompat) {
            this.f5716a.f5714m = locusIdCompat;
            return this;
        }

        @NonNull
        public Builder o(@NonNull CharSequence charSequence) {
            this.f5716a.f5708g = charSequence;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder p() {
            this.f5716a.f5715n = true;
            return this;
        }

        @NonNull
        public Builder q(boolean z) {
            this.f5716a.f5715n = z;
            return this;
        }

        @NonNull
        public Builder r(@NonNull Person person) {
            return s(new Person[]{person});
        }

        @NonNull
        public Builder s(@NonNull Person[] personArr) {
            this.f5716a.f5712k = personArr;
            return this;
        }

        @NonNull
        public Builder t(int i2) {
            this.f5716a.o = i2;
            return this;
        }

        @NonNull
        public Builder u(@NonNull CharSequence charSequence) {
            this.f5716a.f5707f = charSequence;
            return this;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @NonNull
        public Builder v(@NonNull Uri uri) {
            this.f5720e = uri;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder w(@NonNull Bundle bundle) {
            this.f5716a.q = (Bundle) Preconditions.l(bundle);
            return this;
        }

        public Builder(@NonNull Context context, @NonNull String str) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.f5716a = shortcutInfoCompat;
            shortcutInfoCompat.f5702a = context;
            shortcutInfoCompat.f5703b = str;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull ShortcutInfoCompat shortcutInfoCompat) {
            ShortcutInfoCompat shortcutInfoCompat2 = new ShortcutInfoCompat();
            this.f5716a = shortcutInfoCompat2;
            shortcutInfoCompat2.f5702a = shortcutInfoCompat.f5702a;
            shortcutInfoCompat2.f5703b = shortcutInfoCompat.f5703b;
            shortcutInfoCompat2.f5704c = shortcutInfoCompat.f5704c;
            Intent[] intentArr = shortcutInfoCompat.f5705d;
            shortcutInfoCompat2.f5705d = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            shortcutInfoCompat2.f5706e = shortcutInfoCompat.f5706e;
            shortcutInfoCompat2.f5707f = shortcutInfoCompat.f5707f;
            shortcutInfoCompat2.f5708g = shortcutInfoCompat.f5708g;
            shortcutInfoCompat2.f5709h = shortcutInfoCompat.f5709h;
            shortcutInfoCompat2.A = shortcutInfoCompat.A;
            shortcutInfoCompat2.f5710i = shortcutInfoCompat.f5710i;
            shortcutInfoCompat2.f5711j = shortcutInfoCompat.f5711j;
            shortcutInfoCompat2.s = shortcutInfoCompat.s;
            shortcutInfoCompat2.r = shortcutInfoCompat.r;
            shortcutInfoCompat2.t = shortcutInfoCompat.t;
            shortcutInfoCompat2.u = shortcutInfoCompat.u;
            shortcutInfoCompat2.v = shortcutInfoCompat.v;
            shortcutInfoCompat2.w = shortcutInfoCompat.w;
            shortcutInfoCompat2.x = shortcutInfoCompat.x;
            shortcutInfoCompat2.y = shortcutInfoCompat.y;
            shortcutInfoCompat2.f5714m = shortcutInfoCompat.f5714m;
            shortcutInfoCompat2.f5715n = shortcutInfoCompat.f5715n;
            shortcutInfoCompat2.z = shortcutInfoCompat.z;
            shortcutInfoCompat2.o = shortcutInfoCompat.o;
            Person[] personArr = shortcutInfoCompat.f5712k;
            if (personArr != null) {
                shortcutInfoCompat2.f5712k = (Person[]) Arrays.copyOf(personArr, personArr.length);
            }
            if (shortcutInfoCompat.f5713l != null) {
                shortcutInfoCompat2.f5713l = new HashSet(shortcutInfoCompat.f5713l);
            }
            PersistableBundle persistableBundle = shortcutInfoCompat.p;
            if (persistableBundle != null) {
                shortcutInfoCompat2.p = persistableBundle;
            }
            shortcutInfoCompat2.B = shortcutInfoCompat.B;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Surface {
    }

    ShortcutInfoCompat() {
    }

    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private PersistableBundle b() {
        if (this.p == null) {
            this.p = new PersistableBundle();
        }
        Person[] personArr = this.f5712k;
        if (personArr != null && personArr.length > 0) {
            this.p.putInt(C, personArr.length);
            int i2 = 0;
            while (i2 < this.f5712k.length) {
                PersistableBundle persistableBundle = this.p;
                StringBuilder sb = new StringBuilder();
                sb.append(D);
                int i3 = i2 + 1;
                sb.append(i3);
                persistableBundle.putPersistableBundle(sb.toString(), this.f5712k[i2].n());
                i2 = i3;
            }
        }
        LocusIdCompat locusIdCompat = this.f5714m;
        if (locusIdCompat != null) {
            this.p.putString(E, locusIdCompat.a());
        }
        this.p.putBoolean(F, this.f5715n);
        return this.p;
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static List<ShortcutInfoCompat> c(@NonNull Context context, @NonNull List<ShortcutInfo> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (ShortcutInfo a2 : list) {
            arrayList.add(new Builder(context, C0028f.a(a2)).c());
        }
        return arrayList;
    }

    @RequiresApi(25)
    @Nullable
    static LocusIdCompat p(@NonNull ShortcutInfo shortcutInfo) {
        if (Build.VERSION.SDK_INT < 29) {
            return q(shortcutInfo.getExtras());
        }
        if (shortcutInfo.getLocusId() == null) {
            return null;
        }
        return LocusIdCompat.d(shortcutInfo.getLocusId());
    }

    @RequiresApi(25)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private static LocusIdCompat q(@Nullable PersistableBundle persistableBundle) {
        String string;
        if (persistableBundle == null || (string = persistableBundle.getString(E)) == null) {
            return null;
        }
        return new LocusIdCompat(string);
    }

    @RequiresApi(25)
    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static boolean s(@Nullable PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(F)) {
            return false;
        }
        return persistableBundle.getBoolean(F);
    }

    @RequiresApi(25)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    static Person[] u(@NonNull PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(C)) {
            return null;
        }
        int i2 = persistableBundle.getInt(C);
        Person[] personArr = new Person[i2];
        int i3 = 0;
        while (i3 < i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(D);
            int i4 = i3 + 1;
            sb.append(i4);
            personArr[i3] = Person.c(persistableBundle.getPersistableBundle(sb.toString()));
            i3 = i4;
        }
        return personArr;
    }

    public boolean A() {
        return this.t;
    }

    public boolean B() {
        return this.w;
    }

    public boolean C() {
        return this.u;
    }

    public boolean D() {
        return this.y;
    }

    public boolean E(int i2) {
        return (i2 & this.B) != 0;
    }

    public boolean F() {
        return this.x;
    }

    public boolean G() {
        return this.v;
    }

    @RequiresApi(25)
    public ShortcutInfo H() {
        C0034l.a();
        ShortcutInfo.Builder a2 = C0033k.a(this.f5702a, this.f5703b).setShortLabel(this.f5707f).setIntents(this.f5705d);
        IconCompat iconCompat = this.f5710i;
        if (iconCompat != null) {
            ShortcutInfo.Builder unused = a2.setIcon(iconCompat.M(this.f5702a));
        }
        if (!TextUtils.isEmpty(this.f5708g)) {
            ShortcutInfo.Builder unused2 = a2.setLongLabel(this.f5708g);
        }
        if (!TextUtils.isEmpty(this.f5709h)) {
            ShortcutInfo.Builder unused3 = a2.setDisabledMessage(this.f5709h);
        }
        ComponentName componentName = this.f5706e;
        if (componentName != null) {
            ShortcutInfo.Builder unused4 = a2.setActivity(componentName);
        }
        Set<String> set = this.f5713l;
        if (set != null) {
            ShortcutInfo.Builder unused5 = a2.setCategories(set);
        }
        ShortcutInfo.Builder unused6 = a2.setRank(this.o);
        PersistableBundle persistableBundle = this.p;
        if (persistableBundle != null) {
            ShortcutInfo.Builder unused7 = a2.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Person[] personArr = this.f5712k;
            if (personArr != null && personArr.length > 0) {
                int length = personArr.length;
                android.app.Person[] personArr2 = new android.app.Person[length];
                for (int i2 = 0; i2 < length; i2++) {
                    personArr2[i2] = this.f5712k[i2].k();
                }
                ShortcutInfo.Builder unused8 = a2.setPersons(personArr2);
            }
            LocusIdCompat locusIdCompat = this.f5714m;
            if (locusIdCompat != null) {
                ShortcutInfo.Builder unused9 = a2.setLocusId(locusIdCompat.c());
            }
            ShortcutInfo.Builder unused10 = a2.setLongLived(this.f5715n);
        } else {
            ShortcutInfo.Builder unused11 = a2.setExtras(b());
        }
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.a(a2, this.B);
        }
        return a2.build();
    }

    /* access modifiers changed from: package-private */
    public Intent a(Intent intent) {
        Intent[] intentArr = this.f5705d;
        intent.putExtra("android.intent.extra.shortcut.INTENT", intentArr[intentArr.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.f5707f.toString());
        if (this.f5710i != null) {
            Drawable drawable = null;
            if (this.f5711j) {
                PackageManager packageManager = this.f5702a.getPackageManager();
                ComponentName componentName = this.f5706e;
                if (componentName != null) {
                    try {
                        drawable = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (drawable == null) {
                    drawable = this.f5702a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.f5710i.c(intent, drawable, this.f5702a);
        }
        return intent;
    }

    @Nullable
    public ComponentName d() {
        return this.f5706e;
    }

    @Nullable
    public Set<String> e() {
        return this.f5713l;
    }

    @Nullable
    public CharSequence f() {
        return this.f5709h;
    }

    public int g() {
        return this.A;
    }

    public int h() {
        return this.B;
    }

    @Nullable
    public PersistableBundle i() {
        return this.p;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public IconCompat j() {
        return this.f5710i;
    }

    @NonNull
    public String k() {
        return this.f5703b;
    }

    @NonNull
    public Intent l() {
        Intent[] intentArr = this.f5705d;
        return intentArr[intentArr.length - 1];
    }

    @NonNull
    public Intent[] m() {
        Intent[] intentArr = this.f5705d;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    public long n() {
        return this.r;
    }

    @Nullable
    public LocusIdCompat o() {
        return this.f5714m;
    }

    @Nullable
    public CharSequence r() {
        return this.f5708g;
    }

    @NonNull
    public String t() {
        return this.f5704c;
    }

    public int v() {
        return this.o;
    }

    @NonNull
    public CharSequence w() {
        return this.f5707f;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bundle x() {
        return this.q;
    }

    @Nullable
    public UserHandle y() {
        return this.s;
    }

    public boolean z() {
        return this.z;
    }
}
