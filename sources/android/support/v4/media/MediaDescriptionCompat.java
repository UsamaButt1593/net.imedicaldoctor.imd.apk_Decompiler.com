package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public MediaDescriptionCompat[] newArray(int i2) {
            return new MediaDescriptionCompat[i2];
        }
    };
    private static final String c3 = "MediaDescriptionCompat";
    public static final String d3 = "android.media.extra.BT_FOLDER_TYPE";
    public static final long e3 = 0;
    public static final long f3 = 1;
    public static final long g3 = 2;
    public static final long h3 = 3;
    public static final long i3 = 4;
    public static final long j3 = 5;
    public static final long k3 = 6;
    public static final String l3 = "android.media.extra.DOWNLOAD_STATUS";
    public static final long m3 = 0;
    public static final long n3 = 1;
    public static final long o3 = 2;
    @RestrictTo({RestrictTo.Scope.s})
    public static final String p3 = "android.support.v4.media.description.MEDIA_URI";
    @RestrictTo({RestrictTo.Scope.s})
    public static final String q3 = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    private final CharSequence X;
    private final Bitmap X2;
    private final CharSequence Y;
    private final Uri Y2;
    private final CharSequence Z;
    private final Bundle Z2;
    private final Uri a3;
    private MediaDescription b3;
    private final String s;

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static MediaDescription a(MediaDescription.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        static MediaDescription.Builder b() {
            return new MediaDescription.Builder();
        }

        @DoNotInline
        @Nullable
        static CharSequence c(MediaDescription mediaDescription) {
            return mediaDescription.getDescription();
        }

        @DoNotInline
        @Nullable
        static Bundle d(MediaDescription mediaDescription) {
            return mediaDescription.getExtras();
        }

        @DoNotInline
        @Nullable
        static Bitmap e(MediaDescription mediaDescription) {
            return mediaDescription.getIconBitmap();
        }

        @DoNotInline
        @Nullable
        static Uri f(MediaDescription mediaDescription) {
            return mediaDescription.getIconUri();
        }

        @DoNotInline
        @Nullable
        static String g(MediaDescription mediaDescription) {
            return mediaDescription.getMediaId();
        }

        @DoNotInline
        @Nullable
        static CharSequence h(MediaDescription mediaDescription) {
            return mediaDescription.getSubtitle();
        }

        @DoNotInline
        @Nullable
        static CharSequence i(MediaDescription mediaDescription) {
            return mediaDescription.getTitle();
        }

        @DoNotInline
        static void j(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        @DoNotInline
        static void k(MediaDescription.Builder builder, @Nullable Bundle bundle) {
            builder.setExtras(bundle);
        }

        @DoNotInline
        static void l(MediaDescription.Builder builder, @Nullable Bitmap bitmap) {
            builder.setIconBitmap(bitmap);
        }

        @DoNotInline
        static void m(MediaDescription.Builder builder, @Nullable Uri uri) {
            builder.setIconUri(uri);
        }

        @DoNotInline
        static void n(MediaDescription.Builder builder, @Nullable String str) {
            builder.setMediaId(str);
        }

        @DoNotInline
        static void o(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        @DoNotInline
        static void p(MediaDescription.Builder builder, @Nullable CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        @Nullable
        static Uri a(MediaDescription mediaDescription) {
            return mediaDescription.getMediaUri();
        }

        @DoNotInline
        static void b(MediaDescription.Builder builder, @Nullable Uri uri) {
            MediaDescription.Builder unused = builder.setMediaUri(uri);
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f2249a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f2250b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f2251c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f2252d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f2253e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f2254f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f2255g;

        /* renamed from: h  reason: collision with root package name */
        private Uri f2256h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f2249a, this.f2250b, this.f2251c, this.f2252d, this.f2253e, this.f2254f, this.f2255g, this.f2256h);
        }

        public Builder b(@Nullable CharSequence charSequence) {
            this.f2252d = charSequence;
            return this;
        }

        public Builder c(@Nullable Bundle bundle) {
            this.f2255g = bundle;
            return this;
        }

        public Builder d(@Nullable Bitmap bitmap) {
            this.f2253e = bitmap;
            return this;
        }

        public Builder e(@Nullable Uri uri) {
            this.f2254f = uri;
            return this;
        }

        public Builder f(@Nullable String str) {
            this.f2249a = str;
            return this;
        }

        public Builder g(@Nullable Uri uri) {
            this.f2256h = uri;
            return this;
        }

        public Builder h(@Nullable CharSequence charSequence) {
            this.f2251c = charSequence;
            return this;
        }

        public Builder i(@Nullable CharSequence charSequence) {
            this.f2250b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.s = parcel.readString();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.X = (CharSequence) creator.createFromParcel(parcel);
        this.Y = (CharSequence) creator.createFromParcel(parcel);
        this.Z = (CharSequence) creator.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.X2 = (Bitmap) parcel.readParcelable(classLoader);
        this.Y2 = (Uri) parcel.readParcelable(classLoader);
        this.Z2 = parcel.readBundle(classLoader);
        this.a3 = (Uri) parcel.readParcelable(classLoader);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L_0x007f
            int r1 = android.os.Build.VERSION.SDK_INT
            android.support.v4.media.MediaDescriptionCompat$Builder r2 = new android.support.v4.media.MediaDescriptionCompat$Builder
            r2.<init>()
            android.media.MediaDescription r9 = (android.media.MediaDescription) r9
            java.lang.String r3 = android.support.v4.media.MediaDescriptionCompat.Api21Impl.g(r9)
            r2.f(r3)
            java.lang.CharSequence r3 = android.support.v4.media.MediaDescriptionCompat.Api21Impl.i(r9)
            r2.i(r3)
            java.lang.CharSequence r3 = android.support.v4.media.MediaDescriptionCompat.Api21Impl.h(r9)
            r2.h(r3)
            java.lang.CharSequence r3 = android.support.v4.media.MediaDescriptionCompat.Api21Impl.c(r9)
            r2.b(r3)
            android.graphics.Bitmap r3 = android.support.v4.media.MediaDescriptionCompat.Api21Impl.e(r9)
            r2.d(r3)
            android.net.Uri r3 = android.support.v4.media.MediaDescriptionCompat.Api21Impl.f(r9)
            r2.e(r3)
            android.os.Bundle r3 = android.support.v4.media.MediaDescriptionCompat.Api21Impl.d(r9)
            if (r3 == 0) goto L_0x0040
            android.os.Bundle r3 = android.support.v4.media.session.MediaSessionCompat.G(r3)
        L_0x0040:
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L_0x004b
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L_0x004c
        L_0x004b:
            r5 = r0
        L_0x004c:
            if (r5 == 0) goto L_0x0064
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L_0x005e
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L_0x005e
            goto L_0x0065
        L_0x005e:
            r3.remove(r4)
            r3.remove(r6)
        L_0x0064:
            r0 = r3
        L_0x0065:
            r2.c(r0)
            if (r5 == 0) goto L_0x006e
            r2.g(r5)
            goto L_0x0079
        L_0x006e:
            r0 = 23
            if (r1 < r0) goto L_0x0079
            android.net.Uri r0 = android.support.v4.media.MediaDescriptionCompat.Api23Impl.a(r9)
            r2.g(r0)
        L_0x0079:
            android.support.v4.media.MediaDescriptionCompat r0 = r2.a()
            r0.b3 = r9
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    @Nullable
    public CharSequence b() {
        return this.Z;
    }

    @Nullable
    public Bundle c() {
        return this.Z2;
    }

    @Nullable
    public Bitmap d() {
        return this.X2;
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public Uri g() {
        return this.Y2;
    }

    public Object j() {
        Bundle bundle;
        MediaDescription mediaDescription = this.b3;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        int i2 = Build.VERSION.SDK_INT;
        MediaDescription.Builder b2 = Api21Impl.b();
        Api21Impl.n(b2, this.s);
        Api21Impl.p(b2, this.X);
        Api21Impl.o(b2, this.Y);
        Api21Impl.j(b2, this.Z);
        Api21Impl.l(b2, this.X2);
        Api21Impl.m(b2, this.Y2);
        if (i2 >= 23 || this.a3 == null) {
            bundle = this.Z2;
        } else {
            if (this.Z2 == null) {
                bundle = new Bundle();
                bundle.putBoolean(q3, true);
            } else {
                bundle = new Bundle(this.Z2);
            }
            bundle.putParcelable(p3, this.a3);
        }
        Api21Impl.k(b2, bundle);
        if (i2 >= 23) {
            Api23Impl.b(b2, this.a3);
        }
        MediaDescription a2 = Api21Impl.a(b2);
        this.b3 = a2;
        return a2;
    }

    @Nullable
    public String k() {
        return this.s;
    }

    @Nullable
    public Uri l() {
        return this.a3;
    }

    @Nullable
    public CharSequence m() {
        return this.Y;
    }

    @Nullable
    public CharSequence o() {
        return this.X;
    }

    public String toString() {
        return this.X + ", " + this.Y + ", " + this.Z;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        ((MediaDescription) j()).writeToParcel(parcel, i2);
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.s = str;
        this.X = charSequence;
        this.Y = charSequence2;
        this.Z = charSequence3;
        this.X2 = bitmap;
        this.Y2 = uri;
        this.Z2 = bundle;
        this.a3 = uri2;
    }
}
