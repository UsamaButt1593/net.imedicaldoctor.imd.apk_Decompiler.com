package androidx.core.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class RemoteInput {

    /* renamed from: h  reason: collision with root package name */
    public static final String f5575h = "android.remoteinput.results";

    /* renamed from: i  reason: collision with root package name */
    public static final String f5576i = "android.remoteinput.resultsData";

    /* renamed from: j  reason: collision with root package name */
    private static final String f5577j = "android.remoteinput.dataTypeResultsData";

    /* renamed from: k  reason: collision with root package name */
    private static final String f5578k = "android.remoteinput.resultsSource";

    /* renamed from: l  reason: collision with root package name */
    public static final int f5579l = 0;

    /* renamed from: m  reason: collision with root package name */
    public static final int f5580m = 1;

    /* renamed from: n  reason: collision with root package name */
    public static final int f5581n = 0;
    public static final int o = 1;
    public static final int p = 2;

    /* renamed from: a  reason: collision with root package name */
    private final String f5582a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f5583b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence[] f5584c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f5585d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5586e;

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f5587f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<String> f5588g;

    @RequiresApi(20)
    static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        static void a(Object obj, Intent intent, Bundle bundle) {
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[]) obj, intent, bundle);
        }

        public static android.app.RemoteInput b(RemoteInput remoteInput) {
            Set<String> g2;
            RemoteInput.Builder addExtras = new RemoteInput.Builder(remoteInput.o()).setLabel(remoteInput.n()).setChoices(remoteInput.h()).setAllowFreeFormInput(remoteInput.f()).addExtras(remoteInput.m());
            if (Build.VERSION.SDK_INT >= 26 && (g2 = remoteInput.g()) != null) {
                for (String d2 : g2) {
                    Api26Impl.d(addExtras, d2, true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.b(addExtras, remoteInput.k());
            }
            return addExtras.build();
        }

        static RemoteInput c(Object obj) {
            Set<String> b2;
            android.app.RemoteInput remoteInput = (android.app.RemoteInput) obj;
            Builder a2 = new Builder(remoteInput.getResultKey()).h(remoteInput.getLabel()).f(remoteInput.getChoices()).e(remoteInput.getAllowFreeFormInput()).a(remoteInput.getExtras());
            if (Build.VERSION.SDK_INT >= 26 && (b2 = Api26Impl.b(remoteInput)) != null) {
                for (String d2 : b2) {
                    a2.d(d2, true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                a2.g(Api29Impl.a(remoteInput));
            }
            return a2.b();
        }

        @DoNotInline
        static Bundle d(Intent intent) {
            return android.app.RemoteInput.getResultsFromIntent(intent);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static void a(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
            android.app.RemoteInput.addDataResultToIntent(RemoteInput.c(remoteInput), intent, map);
        }

        @DoNotInline
        static Set<String> b(Object obj) {
            return ((android.app.RemoteInput) obj).getAllowedDataTypes();
        }

        @DoNotInline
        static Map<String, Uri> c(Intent intent, String str) {
            return android.app.RemoteInput.getDataResultsFromIntent(intent, str);
        }

        @DoNotInline
        static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z) {
            return builder.setAllowDataType(str, z);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static int a(Intent intent) {
            return android.app.RemoteInput.getResultsSource(intent);
        }

        @DoNotInline
        static void b(Intent intent, int i2) {
            android.app.RemoteInput.setResultsSource(intent, i2);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static int a(Object obj) {
            return ((android.app.RemoteInput) obj).getEditChoicesBeforeSending();
        }

        @DoNotInline
        static RemoteInput.Builder b(RemoteInput.Builder builder, int i2) {
            return builder.setEditChoicesBeforeSending(i2);
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final String f5589a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<String> f5590b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Bundle f5591c = new Bundle();

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f5592d;

        /* renamed from: e  reason: collision with root package name */
        private CharSequence[] f5593e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f5594f = true;

        /* renamed from: g  reason: collision with root package name */
        private int f5595g = 0;

        public Builder(@NonNull String str) {
            if (str != null) {
                this.f5589a = str;
                return;
            }
            throw new IllegalArgumentException("Result key can't be null");
        }

        @NonNull
        public Builder a(@NonNull Bundle bundle) {
            if (bundle != null) {
                this.f5591c.putAll(bundle);
            }
            return this;
        }

        @NonNull
        public RemoteInput b() {
            return new RemoteInput(this.f5589a, this.f5592d, this.f5593e, this.f5594f, this.f5595g, this.f5591c, this.f5590b);
        }

        @NonNull
        public Bundle c() {
            return this.f5591c;
        }

        @NonNull
        public Builder d(@NonNull String str, boolean z) {
            if (z) {
                this.f5590b.add(str);
            } else {
                this.f5590b.remove(str);
            }
            return this;
        }

        @NonNull
        public Builder e(boolean z) {
            this.f5594f = z;
            return this;
        }

        @NonNull
        public Builder f(@Nullable CharSequence[] charSequenceArr) {
            this.f5593e = charSequenceArr;
            return this;
        }

        @NonNull
        public Builder g(int i2) {
            this.f5595g = i2;
            return this;
        }

        @NonNull
        public Builder h(@Nullable CharSequence charSequence) {
            this.f5592d = charSequence;
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EditChoicesBeforeSending {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, int i2, Bundle bundle, Set<String> set) {
        this.f5582a = str;
        this.f5583b = charSequence;
        this.f5584c = charSequenceArr;
        this.f5585d = z;
        this.f5586e = i2;
        this.f5587f = bundle;
        this.f5588g = set;
        if (k() == 2 && !f()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public static void a(@NonNull RemoteInput remoteInput, @NonNull Intent intent, @NonNull Map<String, Uri> map) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.a(remoteInput, intent, map);
            return;
        }
        Intent i2 = i(intent);
        if (i2 == null) {
            i2 = new Intent();
        }
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Uri uri = (Uri) next.getValue();
            if (str != null) {
                Bundle bundleExtra = i2.getBundleExtra(l(str));
                if (bundleExtra == null) {
                    bundleExtra = new Bundle();
                }
                bundleExtra.putString(remoteInput.o(), uri.toString());
                i2.putExtra(l(str), bundleExtra);
            }
        }
        intent.setClipData(ClipData.newIntent(f5575h, i2));
    }

    public static void b(@NonNull RemoteInput[] remoteInputArr, @NonNull Intent intent, @NonNull Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api20Impl.a(d(remoteInputArr), intent, bundle);
            return;
        }
        Bundle p2 = p(intent);
        int q = q(intent);
        if (p2 != null) {
            p2.putAll(bundle);
            bundle = p2;
        }
        for (RemoteInput remoteInput : remoteInputArr) {
            Map<String, Uri> j2 = j(intent, remoteInput.o());
            Api20Impl.a(d(new RemoteInput[]{remoteInput}), intent, bundle);
            if (j2 != null) {
                a(remoteInput, intent, j2);
            }
        }
        s(intent, q);
    }

    @RequiresApi(20)
    static android.app.RemoteInput c(RemoteInput remoteInput) {
        return Api20Impl.b(remoteInput);
    }

    @RequiresApi(20)
    static android.app.RemoteInput[] d(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i2 = 0; i2 < remoteInputArr.length; i2++) {
            remoteInputArr2[i2] = c(remoteInputArr[i2]);
        }
        return remoteInputArr2;
    }

    @RequiresApi(20)
    static RemoteInput e(android.app.RemoteInput remoteInput) {
        return Api20Impl.c(remoteInput);
    }

    private static Intent i(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription description = clipData.getDescription();
        if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().toString().contentEquals(f5575h)) {
            return clipData.getItemAt(0).getIntent();
        }
        return null;
    }

    @Nullable
    public static Map<String, Uri> j(@NonNull Intent intent, @NonNull String str) {
        String string;
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.c(intent, str);
        }
        Intent i2 = i(intent);
        if (i2 == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String next : i2.getExtras().keySet()) {
            if (next.startsWith(f5577j)) {
                String substring = next.substring(39);
                if (!substring.isEmpty() && (string = i2.getBundleExtra(next).getString(str)) != null && !string.isEmpty()) {
                    hashMap.put(substring, Uri.parse(string));
                }
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    private static String l(String str) {
        return f5577j + str;
    }

    @Nullable
    public static Bundle p(@NonNull Intent intent) {
        return Api20Impl.d(intent);
    }

    public static int q(@NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.a(intent);
        }
        Intent i2 = i(intent);
        if (i2 == null) {
            return 0;
        }
        return i2.getExtras().getInt(f5578k, 0);
    }

    public static void s(@NonNull Intent intent, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.b(intent, i2);
            return;
        }
        Intent i3 = i(intent);
        if (i3 == null) {
            i3 = new Intent();
        }
        i3.putExtra(f5578k, i2);
        intent.setClipData(ClipData.newIntent(f5575h, i3));
    }

    public boolean f() {
        return this.f5585d;
    }

    @Nullable
    public Set<String> g() {
        return this.f5588g;
    }

    @Nullable
    public CharSequence[] h() {
        return this.f5584c;
    }

    public int k() {
        return this.f5586e;
    }

    @NonNull
    public Bundle m() {
        return this.f5587f;
    }

    @Nullable
    public CharSequence n() {
        return this.f5583b;
    }

    @NonNull
    public String o() {
        return this.f5582a;
    }

    public boolean r() {
        return !f() && (h() == null || h().length == 0) && g() != null && !g().isEmpty();
    }
}
