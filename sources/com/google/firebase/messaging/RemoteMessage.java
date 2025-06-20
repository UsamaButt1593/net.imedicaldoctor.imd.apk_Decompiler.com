package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.messaging.Constants;
import com.itextpdf.text.html.HtmlTags;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new RemoteMessageCreator();
    public static final int X2 = 1;
    public static final int Y2 = 2;
    public static final int Z = 0;
    private Map<String, String> X;
    private Notification Y;
    @SafeParcelable.Field(id = 2)
    Bundle s;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Bundle f24821a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, String> f24822b = new ArrayMap();

        public Builder(@NonNull String str) {
            Bundle bundle = new Bundle();
            this.f24821a = bundle;
            if (!TextUtils.isEmpty(str)) {
                bundle.putString(Constants.MessagePayloadKeys.f24705g, str);
                return;
            }
            throw new IllegalArgumentException("Invalid to: " + str);
        }

        @NonNull
        public Builder a(@NonNull String str, @Nullable String str2) {
            this.f24822b.put(str, str2);
            return this;
        }

        @NonNull
        public RemoteMessage b() {
            Bundle bundle = new Bundle();
            for (Map.Entry next : this.f24822b.entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            bundle.putAll(this.f24821a);
            this.f24821a.remove("from");
            return new RemoteMessage(bundle);
        }

        @NonNull
        public Builder c() {
            this.f24822b.clear();
            return this;
        }

        @Nullable
        public String d() {
            return this.f24821a.getString(Constants.MessagePayloadKeys.f24702d);
        }

        @NonNull
        public Map<String, String> e() {
            return this.f24822b;
        }

        @NonNull
        public String f() {
            return this.f24821a.getString(Constants.MessagePayloadKeys.f24706h, "");
        }

        @Nullable
        public String g() {
            return this.f24821a.getString(Constants.MessagePayloadKeys.f24702d);
        }

        @IntRange(from = 0, to = 86400)
        public int h() {
            return Integer.parseInt(this.f24821a.getString(Constants.MessagePayloadKeys.f24702d, "0"));
        }

        @NonNull
        public Builder i(@Nullable String str) {
            this.f24821a.putString(Constants.MessagePayloadKeys.f24703e, str);
            return this;
        }

        @NonNull
        public Builder j(@NonNull Map<String, String> map) {
            this.f24822b.clear();
            this.f24822b.putAll(map);
            return this;
        }

        @NonNull
        public Builder k(@NonNull String str) {
            this.f24821a.putString(Constants.MessagePayloadKeys.f24706h, str);
            return this;
        }

        @NonNull
        public Builder l(@Nullable String str) {
            this.f24821a.putString(Constants.MessagePayloadKeys.f24702d, str);
            return this;
        }

        @ShowFirstParty
        @NonNull
        public Builder m(byte[] bArr) {
            this.f24821a.putByteArray(Constants.MessagePayloadKeys.f24701c, bArr);
            return this;
        }

        @NonNull
        public Builder n(@IntRange(from = 0, to = 86400) int i2) {
            this.f24821a.putString(Constants.MessagePayloadKeys.f24707i, String.valueOf(i2));
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification {

        /* renamed from: a  reason: collision with root package name */
        private final String f24823a;

        /* renamed from: b  reason: collision with root package name */
        private final String f24824b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f24825c;

        /* renamed from: d  reason: collision with root package name */
        private final String f24826d;

        /* renamed from: e  reason: collision with root package name */
        private final String f24827e;

        /* renamed from: f  reason: collision with root package name */
        private final String[] f24828f;

        /* renamed from: g  reason: collision with root package name */
        private final String f24829g;

        /* renamed from: h  reason: collision with root package name */
        private final String f24830h;

        /* renamed from: i  reason: collision with root package name */
        private final String f24831i;

        /* renamed from: j  reason: collision with root package name */
        private final String f24832j;

        /* renamed from: k  reason: collision with root package name */
        private final String f24833k;

        /* renamed from: l  reason: collision with root package name */
        private final String f24834l;

        /* renamed from: m  reason: collision with root package name */
        private final String f24835m;

        /* renamed from: n  reason: collision with root package name */
        private final Uri f24836n;
        private final String o;
        private final Integer p;
        private final Integer q;
        private final Integer r;
        private final int[] s;
        private final Long t;
        private final boolean u;
        private final boolean v;
        private final boolean w;
        private final boolean x;
        private final boolean y;
        private final long[] z;

        private Notification(NotificationParams notificationParams) {
            this.f24823a = notificationParams.p(Constants.MessageNotificationKeys.f24691g);
            this.f24824b = notificationParams.h(Constants.MessageNotificationKeys.f24691g);
            this.f24825c = p(notificationParams, Constants.MessageNotificationKeys.f24691g);
            this.f24826d = notificationParams.p(Constants.MessageNotificationKeys.f24692h);
            this.f24827e = notificationParams.h(Constants.MessageNotificationKeys.f24692h);
            this.f24828f = p(notificationParams, Constants.MessageNotificationKeys.f24692h);
            this.f24829g = notificationParams.p(Constants.MessageNotificationKeys.f24693i);
            this.f24831i = notificationParams.o();
            this.f24832j = notificationParams.p(Constants.MessageNotificationKeys.f24695k);
            this.f24833k = notificationParams.p(Constants.MessageNotificationKeys.f24696l);
            this.f24834l = notificationParams.p(Constants.MessageNotificationKeys.A);
            this.f24835m = notificationParams.p(Constants.MessageNotificationKeys.D);
            this.f24836n = notificationParams.f();
            this.f24830h = notificationParams.p(Constants.MessageNotificationKeys.f24694j);
            this.o = notificationParams.p(Constants.MessageNotificationKeys.f24697m);
            this.p = notificationParams.b(Constants.MessageNotificationKeys.p);
            this.q = notificationParams.b(Constants.MessageNotificationKeys.u);
            this.r = notificationParams.b(Constants.MessageNotificationKeys.t);
            this.u = notificationParams.a(Constants.MessageNotificationKeys.o);
            this.v = notificationParams.a(Constants.MessageNotificationKeys.f24698n);
            this.w = notificationParams.a(Constants.MessageNotificationKeys.q);
            this.x = notificationParams.a(Constants.MessageNotificationKeys.r);
            this.y = notificationParams.a(Constants.MessageNotificationKeys.s);
            this.t = notificationParams.j(Constants.MessageNotificationKeys.x);
            this.s = notificationParams.e();
            this.z = notificationParams.q();
        }

        private static String[] p(NotificationParams notificationParams, String str) {
            Object[] g2 = notificationParams.g(str);
            if (g2 == null) {
                return null;
            }
            String[] strArr = new String[g2.length];
            for (int i2 = 0; i2 < g2.length; i2++) {
                strArr[i2] = String.valueOf(g2[i2]);
            }
            return strArr;
        }

        @Nullable
        public Integer A() {
            return this.q;
        }

        @Nullable
        public String a() {
            return this.f24826d;
        }

        @Nullable
        public String[] b() {
            return this.f24828f;
        }

        @Nullable
        public String c() {
            return this.f24827e;
        }

        @Nullable
        public String d() {
            return this.f24835m;
        }

        @Nullable
        public String e() {
            return this.f24834l;
        }

        @Nullable
        public String f() {
            return this.f24833k;
        }

        public boolean g() {
            return this.y;
        }

        public boolean h() {
            return this.w;
        }

        public boolean i() {
            return this.x;
        }

        @Nullable
        public Long j() {
            return this.t;
        }

        @Nullable
        public String k() {
            return this.f24829g;
        }

        @Nullable
        public Uri l() {
            String str = this.f24830h;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        @Nullable
        public int[] m() {
            return this.s;
        }

        @Nullable
        public Uri n() {
            return this.f24836n;
        }

        public boolean o() {
            return this.v;
        }

        @Nullable
        public Integer q() {
            return this.r;
        }

        @Nullable
        public Integer r() {
            return this.p;
        }

        @Nullable
        public String s() {
            return this.f24831i;
        }

        public boolean t() {
            return this.u;
        }

        @Nullable
        public String u() {
            return this.f24832j;
        }

        @Nullable
        public String v() {
            return this.o;
        }

        @Nullable
        public String w() {
            return this.f24823a;
        }

        @Nullable
        public String[] x() {
            return this.f24825c;
        }

        @Nullable
        public String y() {
            return this.f24824b;
        }

        @Nullable
        public long[] z() {
            return this.z;
        }
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.s = bundle;
    }

    private int O(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return HtmlTags.y0.equals(str) ? 2 : 0;
    }

    @Nullable
    public String C() {
        return this.s.getString(Constants.MessagePayloadKeys.f24703e);
    }

    @NonNull
    public Map<String, String> H() {
        if (this.X == null) {
            this.X = Constants.MessagePayloadKeys.a(this.s);
        }
        return this.X;
    }

    @Nullable
    public String I() {
        return this.s.getString("from");
    }

    @Nullable
    public String N() {
        String string = this.s.getString(Constants.MessagePayloadKeys.f24706h);
        return string == null ? this.s.getString(Constants.MessagePayloadKeys.f24704f) : string;
    }

    @Nullable
    public String P() {
        return this.s.getString(Constants.MessagePayloadKeys.f24702d);
    }

    @Nullable
    public Notification Q() {
        if (this.Y == null && NotificationParams.v(this.s)) {
            this.Y = new Notification(new NotificationParams(this.s));
        }
        return this.Y;
    }

    public int R() {
        String string = this.s.getString(Constants.MessagePayloadKeys.f24709k);
        if (string == null) {
            string = this.s.getString(Constants.MessagePayloadKeys.f24711m);
        }
        return O(string);
    }

    public int S() {
        String string = this.s.getString(Constants.MessagePayloadKeys.f24710l);
        if (string == null) {
            if (IcyHeaders.a3.equals(this.s.getString(Constants.MessagePayloadKeys.f24712n))) {
                return 2;
            }
            string = this.s.getString(Constants.MessagePayloadKeys.f24711m);
        }
        return O(string);
    }

    @ShowFirstParty
    @Nullable
    public byte[] T() {
        return this.s.getByteArray(Constants.MessagePayloadKeys.f24701c);
    }

    @Nullable
    public String W() {
        return this.s.getString(Constants.MessagePayloadKeys.q);
    }

    public long Z() {
        Object obj = this.s.get(Constants.MessagePayloadKeys.f24708j);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            Log.w(Constants.f24670a, "Invalid sent time: " + obj);
            return 0;
        }
    }

    @Nullable
    public String a0() {
        return this.s.getString(Constants.MessagePayloadKeys.f24705g);
    }

    public int c0() {
        Object obj = this.s.get(Constants.MessagePayloadKeys.f24707i);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w(Constants.f24670a, "Invalid TTL: " + obj);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void d0(Intent intent) {
        intent.putExtras(this.s);
    }

    @KeepForSdk
    public Intent e0() {
        Intent intent = new Intent();
        intent.putExtras(this.s);
        return intent;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        RemoteMessageCreator.c(this, parcel, i2);
    }
}
