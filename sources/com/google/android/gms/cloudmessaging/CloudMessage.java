package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.messaging.Constants;
import com.itextpdf.text.html.HtmlTags;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.Objects;

@SafeParcelable.Class(creator = "CloudMessageCreator")
public final class CloudMessage extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<CloudMessage> CREATOR = new zza();
    public static final int X2 = 2;
    public static final int Y = 0;
    public static final int Z = 1;
    private Map X;
    @SafeParcelable.Field(id = 1)
    @NonNull
    final Intent s;

    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    public CloudMessage(@SafeParcelable.Param(id = 1) @NonNull Intent intent) {
        this.s = intent;
    }

    private static int d0(@Nullable String str) {
        if (Objects.equals(str, "high")) {
            return 1;
        }
        return Objects.equals(str, HtmlTags.y0) ? 2 : 0;
    }

    @Nullable
    public String C() {
        return this.s.getStringExtra(Constants.MessagePayloadKeys.f24703e);
    }

    @NonNull
    public synchronized Map<String, String> H() {
        try {
            if (this.X == null) {
                Bundle extras = this.s.getExtras();
                ArrayMap arrayMap = new ArrayMap();
                if (extras != null) {
                    for (String next : extras.keySet()) {
                        Object obj = extras.get(next);
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (!next.startsWith(Constants.MessagePayloadKeys.f24699a) && !next.equals("from") && !next.equals(Constants.MessagePayloadKeys.f24702d) && !next.equals(Constants.MessagePayloadKeys.f24703e)) {
                                arrayMap.put(next, str);
                            }
                        }
                    }
                }
                this.X = arrayMap;
            }
        } finally {
            while (true) {
            }
        }
        return this.X;
    }

    @Nullable
    public String I() {
        return this.s.getStringExtra("from");
    }

    @NonNull
    public Intent N() {
        return this.s;
    }

    @Nullable
    public String O() {
        String stringExtra = this.s.getStringExtra(Constants.MessagePayloadKeys.f24706h);
        return stringExtra == null ? this.s.getStringExtra(Constants.MessagePayloadKeys.f24704f) : stringExtra;
    }

    @Nullable
    public String P() {
        return this.s.getStringExtra(Constants.MessagePayloadKeys.f24702d);
    }

    public int Q() {
        String stringExtra = this.s.getStringExtra(Constants.MessagePayloadKeys.f24709k);
        if (stringExtra == null) {
            stringExtra = this.s.getStringExtra(Constants.MessagePayloadKeys.f24711m);
        }
        return d0(stringExtra);
    }

    public int R() {
        String stringExtra = this.s.getStringExtra(Constants.MessagePayloadKeys.f24710l);
        if (stringExtra == null) {
            if (Objects.equals(this.s.getStringExtra(Constants.MessagePayloadKeys.f24712n), IcyHeaders.a3)) {
                return 2;
            }
            stringExtra = this.s.getStringExtra(Constants.MessagePayloadKeys.f24711m);
        }
        return d0(stringExtra);
    }

    @Nullable
    public byte[] S() {
        return this.s.getByteArrayExtra(Constants.MessagePayloadKeys.f24701c);
    }

    @Nullable
    public String T() {
        return this.s.getStringExtra(Constants.MessagePayloadKeys.q);
    }

    public long W() {
        Bundle extras = this.s.getExtras();
        Object obj = extras != null ? extras.get(Constants.MessagePayloadKeys.f24708j) : null;
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("CloudMessage", "Invalid sent time: ".concat(String.valueOf(obj)));
            return 0;
        }
    }

    @Nullable
    public String Z() {
        return this.s.getStringExtra(Constants.MessagePayloadKeys.f24705g);
    }

    public int a0() {
        Bundle extras = this.s.getExtras();
        Object obj = extras != null ? extras.get(Constants.MessagePayloadKeys.f24707i) : null;
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("CloudMessage", "Invalid TTL: ".concat(String.valueOf(obj)));
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final Integer c0() {
        if (this.s.hasExtra(Constants.MessagePayloadKeys.o)) {
            return Integer.valueOf(this.s.getIntExtra(Constants.MessagePayloadKeys.o, 0));
        }
        return null;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.S(parcel, 1, this.s, i2, false);
        SafeParcelWriter.b(parcel, a2);
    }
}
