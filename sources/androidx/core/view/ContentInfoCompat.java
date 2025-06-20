package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class ContentInfoCompat {

    /* renamed from: b  reason: collision with root package name */
    public static final int f6339b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6340c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f6341d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f6342e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f6343f = 4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f6344g = 5;

    /* renamed from: h  reason: collision with root package name */
    public static final int f6345h = 1;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Compat f6346a;

    @RequiresApi(31)
    private static final class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        @NonNull
        public static Pair<ContentInfo, ContentInfo> a(@NonNull ContentInfo contentInfo, @NonNull Predicate<ClipData.Item> predicate) {
            ClipData clip = contentInfo.getClip();
            if (clip.getItemCount() == 1) {
                boolean test = predicate.test(clip.getItemAt(0));
                ContentInfo contentInfo2 = test ? contentInfo : null;
                if (test) {
                    contentInfo = null;
                }
                return Pair.create(contentInfo2, contentInfo);
            }
            Objects.requireNonNull(predicate);
            Pair<ClipData, ClipData> h2 = ContentInfoCompat.h(clip, new C0089b(predicate));
            if (h2.first == null) {
                return Pair.create((Object) null, contentInfo);
            }
            return h2.second == null ? Pair.create(contentInfo, (Object) null) : Pair.create(new ContentInfo.Builder(contentInfo).setClip((ClipData) h2.first).build(), new ContentInfo.Builder(contentInfo).setClip((ClipData) h2.second).build());
        }
    }

    public static final class Builder {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final BuilderCompat f6347a;

        public Builder(@NonNull ClipData clipData, int i2) {
            this.f6347a = Build.VERSION.SDK_INT >= 31 ? new BuilderCompat31Impl(clipData, i2) : new BuilderCompatImpl(clipData, i2);
        }

        @NonNull
        public ContentInfoCompat a() {
            return this.f6347a.build();
        }

        @NonNull
        public Builder b(@NonNull ClipData clipData) {
            this.f6347a.d(clipData);
            return this;
        }

        @NonNull
        public Builder c(@Nullable Bundle bundle) {
            this.f6347a.setExtras(bundle);
            return this;
        }

        @NonNull
        public Builder d(int i2) {
            this.f6347a.c(i2);
            return this;
        }

        @NonNull
        public Builder e(@Nullable Uri uri) {
            this.f6347a.b(uri);
            return this;
        }

        @NonNull
        public Builder f(int i2) {
            this.f6347a.a(i2);
            return this;
        }

        public Builder(@NonNull ContentInfoCompat contentInfoCompat) {
            this.f6347a = Build.VERSION.SDK_INT >= 31 ? new BuilderCompat31Impl(contentInfoCompat) : new BuilderCompatImpl(contentInfoCompat);
        }
    }

    private interface BuilderCompat {
        void a(int i2);

        void b(@Nullable Uri uri);

        @NonNull
        ContentInfoCompat build();

        void c(int i2);

        void d(@NonNull ClipData clipData);

        void setExtras(@Nullable Bundle bundle);
    }

    @RequiresApi(31)
    private static final class BuilderCompat31Impl implements BuilderCompat {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo.Builder f6348a;

        BuilderCompat31Impl(@NonNull ClipData clipData, int i2) {
            this.f6348a = C0103i.a(clipData, i2);
        }

        public void a(int i2) {
            ContentInfo.Builder unused = this.f6348a.setSource(i2);
        }

        public void b(@Nullable Uri uri) {
            ContentInfo.Builder unused = this.f6348a.setLinkUri(uri);
        }

        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.f6348a.build()));
        }

        public void c(int i2) {
            ContentInfo.Builder unused = this.f6348a.setFlags(i2);
        }

        public void d(@NonNull ClipData clipData) {
            ContentInfo.Builder unused = this.f6348a.setClip(clipData);
        }

        public void setExtras(@Nullable Bundle bundle) {
            ContentInfo.Builder unused = this.f6348a.setExtras(bundle);
        }

        BuilderCompat31Impl(@NonNull ContentInfoCompat contentInfoCompat) {
            C0107k.a();
            this.f6348a = C0105j.a(contentInfoCompat.l());
        }
    }

    private static final class BuilderCompatImpl implements BuilderCompat {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        ClipData f6349a;

        /* renamed from: b  reason: collision with root package name */
        int f6350b;

        /* renamed from: c  reason: collision with root package name */
        int f6351c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        Uri f6352d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        Bundle f6353e;

        BuilderCompatImpl(@NonNull ClipData clipData, int i2) {
            this.f6349a = clipData;
            this.f6350b = i2;
        }

        public void a(int i2) {
            this.f6350b = i2;
        }

        public void b(@Nullable Uri uri) {
            this.f6352d = uri;
        }

        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        public void c(int i2) {
            this.f6351c = i2;
        }

        public void d(@NonNull ClipData clipData) {
            this.f6349a = clipData;
        }

        public void setExtras(@Nullable Bundle bundle) {
            this.f6353e = bundle;
        }

        BuilderCompatImpl(@NonNull ContentInfoCompat contentInfoCompat) {
            this.f6349a = contentInfoCompat.c();
            this.f6350b = contentInfoCompat.g();
            this.f6351c = contentInfoCompat.e();
            this.f6352d = contentInfoCompat.f();
            this.f6353e = contentInfoCompat.d();
        }
    }

    private interface Compat {
        @Nullable
        Uri a();

        @NonNull
        ClipData b();

        @Nullable
        ContentInfo c();

        int d();

        @Nullable
        Bundle getExtras();

        int j();
    }

    @RequiresApi(31)
    private static final class Compat31Impl implements Compat {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo f6354a;

        Compat31Impl(@NonNull ContentInfo contentInfo) {
            this.f6354a = C0062a.a(Preconditions.l(contentInfo));
        }

        @Nullable
        public Uri a() {
            return this.f6354a.getLinkUri();
        }

        @NonNull
        public ClipData b() {
            return this.f6354a.getClip();
        }

        @NonNull
        public ContentInfo c() {
            return this.f6354a;
        }

        public int d() {
            return this.f6354a.getSource();
        }

        @Nullable
        public Bundle getExtras() {
            return this.f6354a.getExtras();
        }

        public int j() {
            return this.f6354a.getFlags();
        }

        @NonNull
        public String toString() {
            return "ContentInfoCompat{" + this.f6354a + "}";
        }
    }

    private static final class CompatImpl implements Compat {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ClipData f6355a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6356b;

        /* renamed from: c  reason: collision with root package name */
        private final int f6357c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final Uri f6358d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f6359e;

        CompatImpl(BuilderCompatImpl builderCompatImpl) {
            this.f6355a = (ClipData) Preconditions.l(builderCompatImpl.f6349a);
            this.f6356b = Preconditions.g(builderCompatImpl.f6350b, 0, 5, "source");
            this.f6357c = Preconditions.k(builderCompatImpl.f6351c, 1);
            this.f6358d = builderCompatImpl.f6352d;
            this.f6359e = builderCompatImpl.f6353e;
        }

        @Nullable
        public Uri a() {
            return this.f6358d;
        }

        @NonNull
        public ClipData b() {
            return this.f6355a;
        }

        @Nullable
        public ContentInfo c() {
            return null;
        }

        public int d() {
            return this.f6356b;
        }

        @Nullable
        public Bundle getExtras() {
            return this.f6359e;
        }

        public int j() {
            return this.f6357c;
        }

        @NonNull
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f6355a.getDescription());
            sb.append(", source=");
            sb.append(ContentInfoCompat.k(this.f6356b));
            sb.append(", flags=");
            sb.append(ContentInfoCompat.b(this.f6357c));
            String str2 = "";
            if (this.f6358d == null) {
                str = str2;
            } else {
                str = ", hasLinkUri(" + this.f6358d.toString().length() + ")";
            }
            sb.append(str);
            if (this.f6359e != null) {
                str2 = ", hasExtras";
            }
            sb.append(str2);
            sb.append("}");
            return sb.toString();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    ContentInfoCompat(@NonNull Compat compat) {
        this.f6346a = compat;
    }

    @NonNull
    static ClipData a(@NonNull ClipDescription clipDescription, @NonNull List<ClipData.Item> list) {
        ClipData clipData = new ClipData(new ClipDescription(clipDescription), list.get(0));
        for (int i2 = 1; i2 < list.size(); i2++) {
            clipData.addItem(list.get(i2));
        }
        return clipData;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static String b(int i2) {
        return (i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2);
    }

    @NonNull
    static Pair<ClipData, ClipData> h(@NonNull ClipData clipData, @NonNull androidx.core.util.Predicate<ClipData.Item> predicate) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i2 = 0; i2 < clipData.getItemCount(); i2++) {
            ClipData.Item itemAt = clipData.getItemAt(i2);
            if (predicate.test(itemAt)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(itemAt);
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(itemAt);
            }
        }
        if (arrayList == null) {
            return Pair.create((Object) null, clipData);
        }
        return arrayList2 == null ? Pair.create(clipData, (Object) null) : Pair.create(a(clipData.getDescription(), arrayList), a(clipData.getDescription(), arrayList2));
    }

    @RequiresApi(31)
    @NonNull
    public static Pair<ContentInfo, ContentInfo> i(@NonNull ContentInfo contentInfo, @NonNull Predicate<ClipData.Item> predicate) {
        return Api31Impl.a(contentInfo, predicate);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static String k(int i2) {
        if (i2 == 0) {
            return "SOURCE_APP";
        }
        if (i2 == 1) {
            return "SOURCE_CLIPBOARD";
        }
        if (i2 == 2) {
            return "SOURCE_INPUT_METHOD";
        }
        if (i2 == 3) {
            return "SOURCE_DRAG_AND_DROP";
        }
        if (i2 != 4) {
            return i2 != 5 ? String.valueOf(i2) : "SOURCE_PROCESS_TEXT";
        }
        return "SOURCE_AUTOFILL";
    }

    @RequiresApi(31)
    @NonNull
    public static ContentInfoCompat m(@NonNull ContentInfo contentInfo) {
        return new ContentInfoCompat(new Compat31Impl(contentInfo));
    }

    @NonNull
    public ClipData c() {
        return this.f6346a.b();
    }

    @Nullable
    public Bundle d() {
        return this.f6346a.getExtras();
    }

    public int e() {
        return this.f6346a.j();
    }

    @Nullable
    public Uri f() {
        return this.f6346a.a();
    }

    public int g() {
        return this.f6346a.d();
    }

    @NonNull
    public Pair<ContentInfoCompat, ContentInfoCompat> j(@NonNull androidx.core.util.Predicate<ClipData.Item> predicate) {
        ClipData b2 = this.f6346a.b();
        ContentInfoCompat contentInfoCompat = null;
        if (b2.getItemCount() == 1) {
            boolean test = predicate.test(b2.getItemAt(0));
            ContentInfoCompat contentInfoCompat2 = test ? this : null;
            if (!test) {
                contentInfoCompat = this;
            }
            return Pair.create(contentInfoCompat2, contentInfoCompat);
        }
        Pair<ClipData, ClipData> h2 = h(b2, predicate);
        if (h2.first == null) {
            return Pair.create((Object) null, this);
        }
        return h2.second == null ? Pair.create(this, (Object) null) : Pair.create(new Builder(this).b((ClipData) h2.first).a(), new Builder(this).b((ClipData) h2.second).a());
    }

    @RequiresApi(31)
    @NonNull
    public ContentInfo l() {
        ContentInfo c2 = this.f6346a.c();
        Objects.requireNonNull(c2);
        return C0062a.a(c2);
    }

    @NonNull
    public String toString() {
        return this.f6346a.toString();
    }
}
