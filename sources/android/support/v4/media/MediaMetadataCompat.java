package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.util.Set;

@SuppressLint({"BanParcelableUsage"})
public final class MediaMetadataCompat implements Parcelable {
    public static final String A3 = "android.media.metadata.ADVERTISEMENT";
    public static final String B3 = "android.media.metadata.DOWNLOAD_STATUS";
    static final int C3 = 0;
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new Parcelable.Creator<MediaMetadataCompat>() {
        /* renamed from: a */
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        /* renamed from: b */
        public MediaMetadataCompat[] newArray(int i2) {
            return new MediaMetadataCompat[i2];
        }
    };
    static final int D3 = 1;
    static final int E3 = 2;
    static final int F3 = 3;
    static final ArrayMap<String, Integer> G3;
    private static final String[] H3 = {X2, Y2, a3, l3, c3, b3, d3};
    private static final String[] I3 = {v3, m3, o3};
    private static final String[] J3 = {w3, n3, p3};
    public static final String X2 = "android.media.metadata.TITLE";
    public static final String Y2 = "android.media.metadata.ARTIST";
    private static final String Z = "MediaMetadata";
    public static final String Z2 = "android.media.metadata.DURATION";
    public static final String a3 = "android.media.metadata.ALBUM";
    public static final String b3 = "android.media.metadata.AUTHOR";
    public static final String c3 = "android.media.metadata.WRITER";
    public static final String d3 = "android.media.metadata.COMPOSER";
    public static final String e3 = "android.media.metadata.COMPILATION";
    public static final String f3 = "android.media.metadata.DATE";
    public static final String g3 = "android.media.metadata.YEAR";
    public static final String h3 = "android.media.metadata.GENRE";
    public static final String i3 = "android.media.metadata.TRACK_NUMBER";
    public static final String j3 = "android.media.metadata.NUM_TRACKS";
    public static final String k3 = "android.media.metadata.DISC_NUMBER";
    public static final String l3 = "android.media.metadata.ALBUM_ARTIST";
    public static final String m3 = "android.media.metadata.ART";
    public static final String n3 = "android.media.metadata.ART_URI";
    public static final String o3 = "android.media.metadata.ALBUM_ART";
    public static final String p3 = "android.media.metadata.ALBUM_ART_URI";
    public static final String q3 = "android.media.metadata.USER_RATING";
    public static final String r3 = "android.media.metadata.RATING";
    public static final String s3 = "android.media.metadata.DISPLAY_TITLE";
    public static final String t3 = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String u3 = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String v3 = "android.media.metadata.DISPLAY_ICON";
    public static final String w3 = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String x3 = "android.media.metadata.MEDIA_ID";
    public static final String y3 = "android.media.metadata.MEDIA_URI";
    public static final String z3 = "android.media.metadata.BT_FOLDER_TYPE";
    private MediaMetadata X;
    private MediaDescriptionCompat Y;
    final Bundle s;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Bundle f2257a;

        public Builder() {
            this.f2257a = new Bundle();
        }

        private Bitmap g(Bitmap bitmap, int i2) {
            float f2 = (float) i2;
            float min = Math.min(f2 / ((float) bitmap.getWidth()), f2 / ((float) bitmap.getHeight()));
            return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), true);
        }

        public MediaMetadataCompat a() {
            return new MediaMetadataCompat(this.f2257a);
        }

        public Builder b(String str, Bitmap bitmap) {
            ArrayMap<String, Integer> arrayMap = MediaMetadataCompat.G3;
            if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 2) {
                this.f2257a.putParcelable(str, bitmap);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
        }

        public Builder c(String str, long j2) {
            ArrayMap<String, Integer> arrayMap = MediaMetadataCompat.G3;
            if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 0) {
                this.f2257a.putLong(str, j2);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
        }

        public Builder d(String str, RatingCompat ratingCompat) {
            ArrayMap<String, Integer> arrayMap = MediaMetadataCompat.G3;
            if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 3) {
                this.f2257a.putParcelable(str, (Parcelable) ratingCompat.c());
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
        }

        public Builder e(String str, String str2) {
            ArrayMap<String, Integer> arrayMap = MediaMetadataCompat.G3;
            if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 1) {
                this.f2257a.putCharSequence(str, str2);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
        }

        public Builder f(String str, CharSequence charSequence) {
            ArrayMap<String, Integer> arrayMap = MediaMetadataCompat.G3;
            if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 1) {
                this.f2257a.putCharSequence(str, charSequence);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
        }

        public Builder(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle = new Bundle(mediaMetadataCompat.s);
            this.f2257a = bundle;
            MediaSessionCompat.b(bundle);
        }

        @RestrictTo({RestrictTo.Scope.s})
        public Builder(MediaMetadataCompat mediaMetadataCompat, int i2) {
            this(mediaMetadataCompat);
            for (String next : this.f2257a.keySet()) {
                Object obj = this.f2257a.get(next);
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap.getHeight() > i2 || bitmap.getWidth() > i2) {
                        b(next, g(bitmap, i2));
                    }
                }
            }
        }
    }

    static {
        ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
        G3 = arrayMap;
        arrayMap.put(X2, 1);
        arrayMap.put(Y2, 1);
        arrayMap.put(Z2, 0);
        arrayMap.put(a3, 1);
        arrayMap.put(b3, 1);
        arrayMap.put(c3, 1);
        arrayMap.put(d3, 1);
        arrayMap.put(e3, 1);
        arrayMap.put(f3, 1);
        arrayMap.put(g3, 0);
        arrayMap.put(h3, 1);
        arrayMap.put(i3, 0);
        arrayMap.put(j3, 0);
        arrayMap.put(k3, 0);
        arrayMap.put(l3, 1);
        arrayMap.put(m3, 2);
        arrayMap.put(n3, 1);
        arrayMap.put(o3, 2);
        arrayMap.put(p3, 1);
        arrayMap.put(q3, 3);
        arrayMap.put(r3, 3);
        arrayMap.put(s3, 1);
        arrayMap.put(t3, 1);
        arrayMap.put(u3, 1);
        arrayMap.put(v3, 2);
        arrayMap.put(w3, 1);
        arrayMap.put(x3, 1);
        arrayMap.put(z3, 0);
        arrayMap.put(y3, 1);
        arrayMap.put("android.media.metadata.ADVERTISEMENT", 0);
        arrayMap.put(B3, 0);
    }

    MediaMetadataCompat(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        this.s = bundle2;
        MediaSessionCompat.b(bundle2);
    }

    public static MediaMetadataCompat b(Object obj) {
        if (obj == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        mediaMetadata.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        createFromParcel.X = mediaMetadata;
        return createFromParcel;
    }

    public boolean a(String str) {
        return this.s.containsKey(str);
    }

    public Bitmap c(String str) {
        try {
            return (Bitmap) this.s.getParcelable(str);
        } catch (Exception e2) {
            Log.w(Z, "Failed to retrieve a key as Bitmap.", e2);
            return null;
        }
    }

    public Bundle d() {
        return new Bundle(this.s);
    }

    public int describeContents() {
        return 0;
    }

    public MediaDescriptionCompat g() {
        Uri uri;
        Bitmap bitmap;
        Uri uri2;
        MediaDescriptionCompat mediaDescriptionCompat = this.Y;
        if (mediaDescriptionCompat != null) {
            return mediaDescriptionCompat;
        }
        String m2 = m(x3);
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence o = o(s3);
        if (TextUtils.isEmpty(o)) {
            int i2 = 0;
            int i4 = 0;
            while (i2 < 3) {
                String[] strArr = H3;
                if (i4 >= strArr.length) {
                    break;
                }
                int i5 = i4 + 1;
                CharSequence o2 = o(strArr[i4]);
                if (!TextUtils.isEmpty(o2)) {
                    charSequenceArr[i2] = o2;
                    i2++;
                }
                i4 = i5;
            }
        } else {
            charSequenceArr[0] = o;
            charSequenceArr[1] = o(t3);
            charSequenceArr[2] = o(u3);
        }
        int i6 = 0;
        while (true) {
            String[] strArr2 = I3;
            uri = null;
            if (i6 >= strArr2.length) {
                bitmap = null;
                break;
            }
            bitmap = c(strArr2[i6]);
            if (bitmap != null) {
                break;
            }
            i6++;
        }
        int i7 = 0;
        while (true) {
            String[] strArr3 = J3;
            if (i7 >= strArr3.length) {
                uri2 = null;
                break;
            }
            String m4 = m(strArr3[i7]);
            if (!TextUtils.isEmpty(m4)) {
                uri2 = Uri.parse(m4);
                break;
            }
            i7++;
        }
        String m5 = m(y3);
        if (!TextUtils.isEmpty(m5)) {
            uri = Uri.parse(m5);
        }
        MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder();
        builder.f(m2);
        builder.i(charSequenceArr[0]);
        builder.h(charSequenceArr[1]);
        builder.b(charSequenceArr[2]);
        builder.d(bitmap);
        builder.e(uri2);
        builder.g(uri);
        Bundle bundle = new Bundle();
        if (this.s.containsKey(z3)) {
            bundle.putLong(MediaDescriptionCompat.d3, j(z3));
        }
        if (this.s.containsKey(B3)) {
            bundle.putLong(MediaDescriptionCompat.l3, j(B3));
        }
        if (!bundle.isEmpty()) {
            builder.c(bundle);
        }
        MediaDescriptionCompat a2 = builder.a();
        this.Y = a2;
        return a2;
    }

    public long j(String str) {
        return this.s.getLong(str, 0);
    }

    public Object k() {
        if (this.X == null) {
            Parcel obtain = Parcel.obtain();
            writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            this.X = (MediaMetadata) MediaMetadata.CREATOR.createFromParcel(obtain);
            obtain.recycle();
        }
        return this.X;
    }

    public RatingCompat l(String str) {
        try {
            return RatingCompat.a(this.s.getParcelable(str));
        } catch (Exception e2) {
            Log.w(Z, "Failed to retrieve a key as Rating.", e2);
            return null;
        }
    }

    public String m(String str) {
        CharSequence charSequence = this.s.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public CharSequence o(String str) {
        return this.s.getCharSequence(str);
    }

    public Set<String> p() {
        return this.s.keySet();
    }

    public int t() {
        return this.s.size();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.s);
    }

    MediaMetadataCompat(Parcel parcel) {
        this.s = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
}
