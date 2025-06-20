package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat implements Parcelable {
    public static final long A3 = 2097152;
    public static final long B3 = 4194304;
    public static final int C3 = 0;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() {
        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i2) {
            return new PlaybackStateCompat[i2];
        }
    };
    public static final int D3 = 1;
    public static final int E3 = 2;
    public static final int F3 = 3;
    public static final int G3 = 4;
    public static final int H3 = 5;
    public static final int I3 = 6;
    public static final int J3 = 7;
    public static final int K3 = 8;
    public static final int L3 = 9;
    public static final int M3 = 10;
    public static final int N3 = 11;
    public static final long O3 = -1;
    public static final int P3 = -1;
    public static final int Q3 = 0;
    public static final int R3 = 1;
    public static final int S3 = 2;
    public static final int T3 = 3;
    public static final int U3 = -1;
    public static final int V3 = 0;
    public static final int W3 = 1;
    public static final int X3 = 2;
    public static final int Y3 = 0;
    public static final int Z3 = 1;
    public static final int a4 = 2;
    public static final int b4 = 3;
    public static final int c4 = 4;
    public static final int d4 = 5;
    public static final int e4 = 6;
    public static final long f3 = 1;
    public static final int f4 = 7;
    public static final long g3 = 2;
    public static final int g4 = 8;
    public static final long h3 = 4;
    public static final int h4 = 9;
    public static final long i3 = 8;
    public static final int i4 = 10;
    public static final long j3 = 16;
    public static final int j4 = 11;
    public static final long k3 = 32;
    private static final int k4 = 127;
    public static final long l3 = 64;
    private static final int l4 = 126;
    public static final long m3 = 128;
    public static final long n3 = 256;
    public static final long o3 = 512;
    public static final long p3 = 1024;
    public static final long q3 = 2048;
    public static final long r3 = 4096;
    public static final long s3 = 8192;
    public static final long t3 = 16384;
    public static final long u3 = 32768;
    public static final long v3 = 65536;
    public static final long w3 = 131072;
    public static final long x3 = 262144;
    @Deprecated
    public static final long y3 = 524288;
    public static final long z3 = 1048576;
    final long X;
    final long X2;
    final long Y;
    final int Y2;
    final float Z;
    final CharSequence Z2;
    final long a3;
    List<CustomAction> b3;
    final long c3;
    final Bundle d3;
    private PlaybackState e3;
    final int s;

    @RestrictTo({RestrictTo.Scope.Y})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Actions {
    }

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void a(PlaybackState.Builder builder, PlaybackState.CustomAction customAction) {
            builder.addCustomAction(customAction);
        }

        @DoNotInline
        static PlaybackState.CustomAction b(PlaybackState.CustomAction.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        static PlaybackState c(PlaybackState.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        static PlaybackState.Builder d() {
            return new PlaybackState.Builder();
        }

        @DoNotInline
        static PlaybackState.CustomAction.Builder e(String str, CharSequence charSequence, int i2) {
            return new PlaybackState.CustomAction.Builder(str, charSequence, i2);
        }

        @DoNotInline
        static String f(PlaybackState.CustomAction customAction) {
            return customAction.getAction();
        }

        @DoNotInline
        static long g(PlaybackState playbackState) {
            return playbackState.getActions();
        }

        @DoNotInline
        static long h(PlaybackState playbackState) {
            return playbackState.getActiveQueueItemId();
        }

        @DoNotInline
        static long i(PlaybackState playbackState) {
            return playbackState.getBufferedPosition();
        }

        @DoNotInline
        static List<PlaybackState.CustomAction> j(PlaybackState playbackState) {
            return playbackState.getCustomActions();
        }

        @DoNotInline
        static CharSequence k(PlaybackState playbackState) {
            return playbackState.getErrorMessage();
        }

        @DoNotInline
        static Bundle l(PlaybackState.CustomAction customAction) {
            return customAction.getExtras();
        }

        @DoNotInline
        static int m(PlaybackState.CustomAction customAction) {
            return customAction.getIcon();
        }

        @DoNotInline
        static long n(PlaybackState playbackState) {
            return playbackState.getLastPositionUpdateTime();
        }

        @DoNotInline
        static CharSequence o(PlaybackState.CustomAction customAction) {
            return customAction.getName();
        }

        @DoNotInline
        static float p(PlaybackState playbackState) {
            return playbackState.getPlaybackSpeed();
        }

        @DoNotInline
        static long q(PlaybackState playbackState) {
            return playbackState.getPosition();
        }

        @DoNotInline
        static int r(PlaybackState playbackState) {
            return playbackState.getState();
        }

        @DoNotInline
        static void s(PlaybackState.Builder builder, long j2) {
            builder.setActions(j2);
        }

        @DoNotInline
        static void t(PlaybackState.Builder builder, long j2) {
            builder.setActiveQueueItemId(j2);
        }

        @DoNotInline
        static void u(PlaybackState.Builder builder, long j2) {
            builder.setBufferedPosition(j2);
        }

        @DoNotInline
        static void v(PlaybackState.Builder builder, CharSequence charSequence) {
            builder.setErrorMessage(charSequence);
        }

        @DoNotInline
        static void w(PlaybackState.CustomAction.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        @DoNotInline
        static void x(PlaybackState.Builder builder, int i2, long j2, float f2, long j3) {
            builder.setState(i2, j2, f2, j3);
        }
    }

    @RequiresApi(22)
    private static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        static Bundle a(PlaybackState playbackState) {
            return playbackState.getExtras();
        }

        @DoNotInline
        static void b(PlaybackState.Builder builder, Bundle bundle) {
            PlaybackState.Builder unused = builder.setExtras(bundle);
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List<CustomAction> f2390a;

        /* renamed from: b  reason: collision with root package name */
        private int f2391b;

        /* renamed from: c  reason: collision with root package name */
        private long f2392c;

        /* renamed from: d  reason: collision with root package name */
        private long f2393d;

        /* renamed from: e  reason: collision with root package name */
        private float f2394e;

        /* renamed from: f  reason: collision with root package name */
        private long f2395f;

        /* renamed from: g  reason: collision with root package name */
        private int f2396g;

        /* renamed from: h  reason: collision with root package name */
        private CharSequence f2397h;

        /* renamed from: i  reason: collision with root package name */
        private long f2398i;

        /* renamed from: j  reason: collision with root package name */
        private long f2399j;

        /* renamed from: k  reason: collision with root package name */
        private Bundle f2400k;

        public Builder() {
            this.f2390a = new ArrayList();
            this.f2399j = -1;
        }

        public Builder a(CustomAction customAction) {
            if (customAction != null) {
                this.f2390a.add(customAction);
                return this;
            }
            throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat");
        }

        public Builder b(String str, String str2, int i2) {
            return a(new CustomAction(str, str2, i2, (Bundle) null));
        }

        public PlaybackStateCompat c() {
            return new PlaybackStateCompat(this.f2391b, this.f2392c, this.f2393d, this.f2394e, this.f2395f, this.f2396g, this.f2397h, this.f2398i, this.f2390a, this.f2399j, this.f2400k);
        }

        public Builder d(long j2) {
            this.f2395f = j2;
            return this;
        }

        public Builder e(long j2) {
            this.f2399j = j2;
            return this;
        }

        public Builder f(long j2) {
            this.f2393d = j2;
            return this;
        }

        public Builder g(int i2, CharSequence charSequence) {
            this.f2396g = i2;
            this.f2397h = charSequence;
            return this;
        }

        @Deprecated
        public Builder h(CharSequence charSequence) {
            this.f2397h = charSequence;
            return this;
        }

        public Builder i(Bundle bundle) {
            this.f2400k = bundle;
            return this;
        }

        public Builder j(int i2, long j2, float f2) {
            return k(i2, j2, f2, SystemClock.elapsedRealtime());
        }

        public Builder k(int i2, long j2, float f2, long j3) {
            this.f2391b = i2;
            this.f2392c = j2;
            this.f2398i = j3;
            this.f2394e = f2;
            return this;
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList = new ArrayList();
            this.f2390a = arrayList;
            this.f2399j = -1;
            this.f2391b = playbackStateCompat.s;
            this.f2392c = playbackStateCompat.X;
            this.f2394e = playbackStateCompat.Z;
            this.f2398i = playbackStateCompat.a3;
            this.f2393d = playbackStateCompat.Y;
            this.f2395f = playbackStateCompat.X2;
            this.f2396g = playbackStateCompat.Y2;
            this.f2397h = playbackStateCompat.Z2;
            List<CustomAction> list = playbackStateCompat.b3;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.f2399j = playbackStateCompat.c3;
            this.f2400k = playbackStateCompat.d3;
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() {
            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: b */
            public CustomAction[] newArray(int i2) {
                return new CustomAction[i2];
            }
        };
        private final CharSequence X;
        private PlaybackState.CustomAction X2;
        private final int Y;
        private final Bundle Z;
        private final String s;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private final String f2401a;

            /* renamed from: b  reason: collision with root package name */
            private final CharSequence f2402b;

            /* renamed from: c  reason: collision with root package name */
            private final int f2403c;

            /* renamed from: d  reason: collision with root package name */
            private Bundle f2404d;

            public Builder(String str, CharSequence charSequence, int i2) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction");
                } else if (TextUtils.isEmpty(charSequence)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction");
                } else if (i2 != 0) {
                    this.f2401a = str;
                    this.f2402b = charSequence;
                    this.f2403c = i2;
                } else {
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction");
                }
            }

            public CustomAction a() {
                return new CustomAction(this.f2401a, this.f2402b, this.f2403c, this.f2404d);
            }

            public Builder b(Bundle bundle) {
                this.f2404d = bundle;
                return this;
            }
        }

        CustomAction(Parcel parcel) {
            this.s = parcel.readString();
            this.X = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.Y = parcel.readInt();
            this.Z = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        public static CustomAction a(Object obj) {
            if (obj == null) {
                return null;
            }
            PlaybackState.CustomAction customAction = (PlaybackState.CustomAction) obj;
            Bundle l2 = Api21Impl.l(customAction);
            MediaSessionCompat.b(l2);
            CustomAction customAction2 = new CustomAction(Api21Impl.f(customAction), Api21Impl.o(customAction), Api21Impl.m(customAction), l2);
            customAction2.X2 = customAction;
            return customAction2;
        }

        public String b() {
            return this.s;
        }

        public Object c() {
            PlaybackState.CustomAction customAction = this.X2;
            if (customAction != null) {
                return customAction;
            }
            PlaybackState.CustomAction.Builder e2 = Api21Impl.e(this.s, this.X, this.Y);
            Api21Impl.w(e2, this.Z);
            return Api21Impl.b(e2);
        }

        public Bundle d() {
            return this.Z;
        }

        public int describeContents() {
            return 0;
        }

        public int g() {
            return this.Y;
        }

        public CharSequence j() {
            return this.X;
        }

        public String toString() {
            return "Action:mName='" + this.X + ", mIcon=" + this.Y + ", mExtras=" + this.Z;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.s);
            TextUtils.writeToParcel(this.X, parcel, i2);
            parcel.writeInt(this.Y);
            parcel.writeBundle(this.Z);
        }

        CustomAction(String str, CharSequence charSequence, int i2, Bundle bundle) {
            this.s = str;
            this.X = charSequence;
            this.Y = i2;
            this.Z = bundle;
        }
    }

    @RestrictTo({RestrictTo.Scope.s})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaKeyAction {
    }

    @RestrictTo({RestrictTo.Scope.Y})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @RestrictTo({RestrictTo.Scope.Y})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShuffleMode {
    }

    @RestrictTo({RestrictTo.Scope.Y})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    PlaybackStateCompat(int i2, long j2, long j5, float f2, long j6, int i5, CharSequence charSequence, long j7, List<CustomAction> list, long j8, Bundle bundle) {
        this.s = i2;
        this.X = j2;
        this.Y = j5;
        this.Z = f2;
        this.X2 = j6;
        this.Y2 = i5;
        this.Z2 = charSequence;
        this.a3 = j7;
        this.b3 = new ArrayList(list);
        this.c3 = j8;
        this.d3 = bundle;
    }

    public static int B(long j2) {
        if (j2 == 4) {
            return 126;
        }
        if (j2 == 2) {
            return 127;
        }
        if (j2 == 32) {
            return 87;
        }
        if (j2 == 16) {
            return 88;
        }
        if (j2 == 1) {
            return 86;
        }
        if (j2 == 64) {
            return 90;
        }
        if (j2 == 8) {
            return 89;
        }
        return j2 == 512 ? 85 : 0;
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        Bundle bundle = null;
        if (obj == null) {
            return null;
        }
        PlaybackState playbackState = (PlaybackState) obj;
        List<PlaybackState.CustomAction> j2 = Api21Impl.j(playbackState);
        if (j2 != null) {
            ArrayList arrayList2 = new ArrayList(j2.size());
            for (PlaybackState.CustomAction a2 : j2) {
                arrayList2.add(CustomAction.a(a2));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = Api22Impl.a(playbackState);
            MediaSessionCompat.b(bundle);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(Api21Impl.r(playbackState), Api21Impl.q(playbackState), Api21Impl.i(playbackState), Api21Impl.p(playbackState), Api21Impl.g(playbackState), 0, Api21Impl.k(playbackState), Api21Impl.n(playbackState), arrayList, Api21Impl.h(playbackState), bundle);
        playbackStateCompat.e3 = playbackState;
        return playbackStateCompat;
    }

    public long b() {
        return this.X2;
    }

    public long c() {
        return this.c3;
    }

    public long d() {
        return this.Y;
    }

    public int describeContents() {
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.Y})
    public long g(Long l2) {
        return Math.max(0, this.X + ((long) (this.Z * ((float) (l2 != null ? l2.longValue() : SystemClock.elapsedRealtime() - this.a3)))));
    }

    public List<CustomAction> j() {
        return this.b3;
    }

    public int k() {
        return this.Y2;
    }

    public CharSequence l() {
        return this.Z2;
    }

    @Nullable
    public Bundle m() {
        return this.d3;
    }

    public long o() {
        return this.a3;
    }

    public float p() {
        return this.Z;
    }

    public Object t() {
        if (this.e3 == null) {
            PlaybackState.Builder d2 = Api21Impl.d();
            Api21Impl.x(d2, this.s, this.X, this.Z, this.a3);
            Api21Impl.u(d2, this.Y);
            Api21Impl.s(d2, this.X2);
            Api21Impl.v(d2, this.Z2);
            for (CustomAction c2 : this.b3) {
                Api21Impl.a(d2, (PlaybackState.CustomAction) c2.c());
            }
            Api21Impl.t(d2, this.c3);
            if (Build.VERSION.SDK_INT >= 22) {
                Api22Impl.b(d2, this.d3);
            }
            this.e3 = Api21Impl.c(d2);
        }
        return this.e3;
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.s + ", position=" + this.X + ", buffered position=" + this.Y + ", speed=" + this.Z + ", updated=" + this.a3 + ", actions=" + this.X2 + ", error code=" + this.Y2 + ", error message=" + this.Z2 + ", custom actions=" + this.b3 + ", active item id=" + this.c3 + "}";
    }

    public long v() {
        return this.X;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.s);
        parcel.writeLong(this.X);
        parcel.writeFloat(this.Z);
        parcel.writeLong(this.a3);
        parcel.writeLong(this.Y);
        parcel.writeLong(this.X2);
        TextUtils.writeToParcel(this.Z2, parcel, i2);
        parcel.writeTypedList(this.b3);
        parcel.writeLong(this.c3);
        parcel.writeBundle(this.d3);
        parcel.writeInt(this.Y2);
    }

    public int z() {
        return this.s;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.s = parcel.readInt();
        this.X = parcel.readLong();
        this.Z = parcel.readFloat();
        this.a3 = parcel.readLong();
        this.Y = parcel.readLong();
        this.X2 = parcel.readLong();
        this.Z2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.b3 = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.c3 = parcel.readLong();
        this.d3 = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.Y2 = parcel.readInt();
    }
}
