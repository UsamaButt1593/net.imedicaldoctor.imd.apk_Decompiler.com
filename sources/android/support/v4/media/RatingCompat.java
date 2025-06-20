package android.support.v4.media;

import android.annotation.SuppressLint;
import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressLint({"BanParcelableUsage"})
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() {
        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: b */
        public RatingCompat[] newArray(int i2) {
            return new RatingCompat[i2];
        }
    };
    public static final int X2 = 0;
    public static final int Y2 = 1;
    private static final String Z = "Rating";
    public static final int Z2 = 2;
    public static final int a3 = 3;
    public static final int b3 = 4;
    public static final int c3 = 5;
    public static final int d3 = 6;
    private static final float e3 = -1.0f;
    private final float X;
    private Object Y;
    private final int s;

    @RequiresApi(19)
    private static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static float a(Rating rating) {
            return rating.getPercentRating();
        }

        @DoNotInline
        static int b(Rating rating) {
            return rating.getRatingStyle();
        }

        @DoNotInline
        static float c(Rating rating) {
            return rating.getStarRating();
        }

        @DoNotInline
        static boolean d(Rating rating) {
            return rating.hasHeart();
        }

        @DoNotInline
        static boolean e(Rating rating) {
            return rating.isRated();
        }

        @DoNotInline
        static boolean f(Rating rating) {
            return rating.isThumbUp();
        }

        @DoNotInline
        static Rating g(boolean z) {
            return Rating.newHeartRating(z);
        }

        @DoNotInline
        static Rating h(float f2) {
            return Rating.newPercentageRating(f2);
        }

        @DoNotInline
        static Rating i(int i2, float f2) {
            return Rating.newStarRating(i2, f2);
        }

        @DoNotInline
        static Rating j(boolean z) {
            return Rating.newThumbRating(z);
        }

        @DoNotInline
        static Rating k(int i2) {
            return Rating.newUnratedRating(i2);
        }
    }

    @RestrictTo({RestrictTo.Scope.s})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }

    @RestrictTo({RestrictTo.Scope.Y})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    RatingCompat(int i2, float f2) {
        this.s = i2;
        this.X = f2;
    }

    public static RatingCompat a(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null) {
            Rating rating = (Rating) obj;
            int b2 = Api19Impl.b(rating);
            if (Api19Impl.e(rating)) {
                switch (b2) {
                    case 1:
                        ratingCompat = m(Api19Impl.d(rating));
                        break;
                    case 2:
                        ratingCompat = t(Api19Impl.f(rating));
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = p(b2, Api19Impl.c(rating));
                        break;
                    case 6:
                        ratingCompat = o(Api19Impl.a(rating));
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompat = v(b2);
            }
            ratingCompat.Y = obj;
        }
        return ratingCompat;
    }

    public static RatingCompat m(boolean z) {
        return new RatingCompat(1, z ? 1.0f : 0.0f);
    }

    public static RatingCompat o(float f2) {
        if (f2 >= 0.0f && f2 <= 100.0f) {
            return new RatingCompat(6, f2);
        }
        Log.e(Z, "Invalid percentage-based rating value");
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.RatingCompat p(int r4, float r5) {
        /*
            r0 = 3
            r1 = 0
            java.lang.String r2 = "Rating"
            if (r4 == r0) goto L_0x002c
            r0 = 4
            if (r4 == r0) goto L_0x0029
            r0 = 5
            if (r4 == r0) goto L_0x0026
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Invalid rating style ("
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = ") for a star rating"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
        L_0x0022:
            android.util.Log.e(r2, r4)
            return r1
        L_0x0026:
            r0 = 1084227584(0x40a00000, float:5.0)
            goto L_0x002e
        L_0x0029:
            r0 = 1082130432(0x40800000, float:4.0)
            goto L_0x002e
        L_0x002c:
            r0 = 1077936128(0x40400000, float:3.0)
        L_0x002e:
            r3 = 0
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x003e
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0038
            goto L_0x003e
        L_0x0038:
            android.support.v4.media.RatingCompat r0 = new android.support.v4.media.RatingCompat
            r0.<init>(r4, r5)
            return r0
        L_0x003e:
            java.lang.String r4 = "Trying to set out of range star-based rating"
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.RatingCompat.p(int, float):android.support.v4.media.RatingCompat");
    }

    public static RatingCompat t(boolean z) {
        return new RatingCompat(2, z ? 1.0f : 0.0f);
    }

    public static RatingCompat v(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i2, e3);
            default:
                return null;
        }
    }

    public float b() {
        return (this.s != 6 || !k()) ? e3 : this.X;
    }

    public Object c() {
        Rating k2;
        if (this.Y == null) {
            if (k()) {
                int i2 = this.s;
                switch (i2) {
                    case 1:
                        k2 = Api19Impl.g(j());
                        break;
                    case 2:
                        k2 = Api19Impl.j(l());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        k2 = Api19Impl.i(i2, g());
                        break;
                    case 6:
                        k2 = Api19Impl.h(b());
                        break;
                    default:
                        return null;
                }
            } else {
                k2 = Api19Impl.k(this.s);
            }
            this.Y = k2;
        }
        return this.Y;
    }

    public int d() {
        return this.s;
    }

    public int describeContents() {
        return this.s;
    }

    public float g() {
        int i2 = this.s;
        return ((i2 == 3 || i2 == 4 || i2 == 5) && k()) ? this.X : e3;
    }

    public boolean j() {
        return this.s == 1 && this.X == 1.0f;
    }

    public boolean k() {
        return this.X >= 0.0f;
    }

    public boolean l() {
        return this.s == 2 && this.X == 1.0f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.s);
        sb.append(" rating=");
        float f2 = this.X;
        sb.append(f2 < 0.0f ? "unrated" : String.valueOf(f2));
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.s);
        parcel.writeFloat(this.X);
    }
}
