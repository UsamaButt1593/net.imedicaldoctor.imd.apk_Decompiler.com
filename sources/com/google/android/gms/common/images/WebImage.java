package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "WebImageCreator")
public final class WebImage extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<WebImage> CREATOR = new zah();
    @SafeParcelable.Field(getter = "getUrl", id = 2)
    private final Uri X;
    @SafeParcelable.Field(getter = "getWidth", id = 3)
    private final int Y;
    @SafeParcelable.Field(getter = "getHeight", id = 4)
    private final int Z;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    WebImage(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) Uri uri, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) int i4) {
        this.s = i2;
        this.X = uri;
        this.Y = i3;
        this.Z = i4;
    }

    public int C() {
        return this.Z;
    }

    @NonNull
    public Uri H() {
        return this.X;
    }

    public int I() {
        return this.Y;
    }

    @NonNull
    @KeepForSdk
    public JSONObject N() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.X.toString());
            jSONObject.put("width", this.Y);
            jSONObject.put("height", this.Z);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            return Objects.b(this.X, webImage.X) && this.Y == webImage.Y && this.Z == webImage.Z;
        }
    }

    public int hashCode() {
        return Objects.c(this.X, Integer.valueOf(this.Y), Integer.valueOf(this.Z));
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.Y), Integer.valueOf(this.Z), this.X.toString()});
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.S(parcel, 2, H(), i2, false);
        SafeParcelWriter.F(parcel, 3, I());
        SafeParcelWriter.F(parcel, 4, C());
        SafeParcelWriter.b(parcel, a2);
    }

    public WebImage(@NonNull Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebImage(@NonNull Uri uri, int i2, int i3) throws IllegalArgumentException {
        this(1, uri, i2, i3);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WebImage(@androidx.annotation.NonNull org.json.JSONObject r5) throws java.lang.IllegalArgumentException {
        /*
            r4 = this;
            android.net.Uri r0 = android.net.Uri.EMPTY
            java.lang.String r1 = "url"
            boolean r2 = r5.has(r1)
            if (r2 == 0) goto L_0x0012
            java.lang.String r1 = r5.getString(r1)     // Catch:{ JSONException -> 0x0012 }
            android.net.Uri r0 = android.net.Uri.parse(r1)     // Catch:{ JSONException -> 0x0012 }
        L_0x0012:
            java.lang.String r1 = "width"
            r2 = 0
            int r1 = r5.optInt(r1, r2)
            java.lang.String r3 = "height"
            int r5 = r5.optInt(r3, r2)
            r4.<init>(r0, r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.images.WebImage.<init>(org.json.JSONObject):void");
    }
}
