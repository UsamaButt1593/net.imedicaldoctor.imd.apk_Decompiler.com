package com.google.android.material.badge;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class BadgeState {

    /* renamed from: l  reason: collision with root package name */
    private static final String f20827l = "badge";

    /* renamed from: a  reason: collision with root package name */
    private final State f20828a;

    /* renamed from: b  reason: collision with root package name */
    private final State f20829b;

    /* renamed from: c  reason: collision with root package name */
    final float f20830c;

    /* renamed from: d  reason: collision with root package name */
    final float f20831d;

    /* renamed from: e  reason: collision with root package name */
    final float f20832e;

    /* renamed from: f  reason: collision with root package name */
    final float f20833f;

    /* renamed from: g  reason: collision with root package name */
    final float f20834g;

    /* renamed from: h  reason: collision with root package name */
    final float f20835h;

    /* renamed from: i  reason: collision with root package name */
    final int f20836i;

    /* renamed from: j  reason: collision with root package name */
    final int f20837j;

    /* renamed from: k  reason: collision with root package name */
    int f20838k;

    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator<State>() {
            @NonNull
            /* renamed from: a */
            public State createFromParcel(@NonNull Parcel parcel) {
                return new State(parcel);
            }

            @NonNull
            /* renamed from: b */
            public State[] newArray(int i2) {
                return new State[i2];
            }
        };
        private static final int x3 = -1;
        private static final int y3 = -2;
        /* access modifiers changed from: private */
        @ColorInt
        public Integer X;
        /* access modifiers changed from: private */
        @StyleRes
        public Integer X2;
        /* access modifiers changed from: private */
        @ColorInt
        public Integer Y;
        /* access modifiers changed from: private */
        @StyleRes
        public Integer Y2;
        /* access modifiers changed from: private */
        @StyleRes
        public Integer Z;
        /* access modifiers changed from: private */
        @StyleRes
        public Integer Z2;
        /* access modifiers changed from: private */
        @StyleRes
        public Integer a3;
        /* access modifiers changed from: private */
        public int b3 = 255;
        /* access modifiers changed from: private */
        @Nullable
        public String c3;
        /* access modifiers changed from: private */
        public int d3 = -2;
        /* access modifiers changed from: private */
        public int e3 = -2;
        /* access modifiers changed from: private */
        public int f3 = -2;
        /* access modifiers changed from: private */
        public Locale g3;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence h3;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence i3;
        /* access modifiers changed from: private */
        @PluralsRes
        public int j3;
        /* access modifiers changed from: private */
        @StringRes
        public int k3;
        /* access modifiers changed from: private */
        public Integer l3;
        /* access modifiers changed from: private */
        public Boolean m3 = Boolean.TRUE;
        /* access modifiers changed from: private */
        @Px
        public Integer n3;
        /* access modifiers changed from: private */
        @Px
        public Integer o3;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public Integer p3;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public Integer q3;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public Integer r3;
        /* access modifiers changed from: private */
        @XmlRes
        public int s;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public Integer s3;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public Integer t3;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public Integer u3;
        /* access modifiers changed from: private */
        @Dimension(unit = 1)
        public Integer v3;
        /* access modifiers changed from: private */
        public Boolean w3;

        public State() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            parcel.writeInt(this.s);
            parcel.writeSerializable(this.X);
            parcel.writeSerializable(this.Y);
            parcel.writeSerializable(this.Z);
            parcel.writeSerializable(this.X2);
            parcel.writeSerializable(this.Y2);
            parcel.writeSerializable(this.Z2);
            parcel.writeSerializable(this.a3);
            parcel.writeInt(this.b3);
            parcel.writeString(this.c3);
            parcel.writeInt(this.d3);
            parcel.writeInt(this.e3);
            parcel.writeInt(this.f3);
            CharSequence charSequence = this.h3;
            String str = null;
            parcel.writeString(charSequence != null ? charSequence.toString() : null);
            CharSequence charSequence2 = this.i3;
            if (charSequence2 != null) {
                str = charSequence2.toString();
            }
            parcel.writeString(str);
            parcel.writeInt(this.j3);
            parcel.writeSerializable(this.l3);
            parcel.writeSerializable(this.n3);
            parcel.writeSerializable(this.o3);
            parcel.writeSerializable(this.p3);
            parcel.writeSerializable(this.q3);
            parcel.writeSerializable(this.r3);
            parcel.writeSerializable(this.s3);
            parcel.writeSerializable(this.v3);
            parcel.writeSerializable(this.t3);
            parcel.writeSerializable(this.u3);
            parcel.writeSerializable(this.m3);
            parcel.writeSerializable(this.g3);
            parcel.writeSerializable(this.w3);
        }

        State(@NonNull Parcel parcel) {
            this.s = parcel.readInt();
            this.X = (Integer) parcel.readSerializable();
            this.Y = (Integer) parcel.readSerializable();
            this.Z = (Integer) parcel.readSerializable();
            this.X2 = (Integer) parcel.readSerializable();
            this.Y2 = (Integer) parcel.readSerializable();
            this.Z2 = (Integer) parcel.readSerializable();
            this.a3 = (Integer) parcel.readSerializable();
            this.b3 = parcel.readInt();
            this.c3 = parcel.readString();
            this.d3 = parcel.readInt();
            this.e3 = parcel.readInt();
            this.f3 = parcel.readInt();
            this.h3 = parcel.readString();
            this.i3 = parcel.readString();
            this.j3 = parcel.readInt();
            this.l3 = (Integer) parcel.readSerializable();
            this.n3 = (Integer) parcel.readSerializable();
            this.o3 = (Integer) parcel.readSerializable();
            this.p3 = (Integer) parcel.readSerializable();
            this.q3 = (Integer) parcel.readSerializable();
            this.r3 = (Integer) parcel.readSerializable();
            this.s3 = (Integer) parcel.readSerializable();
            this.v3 = (Integer) parcel.readSerializable();
            this.t3 = (Integer) parcel.readSerializable();
            this.u3 = (Integer) parcel.readSerializable();
            this.m3 = (Boolean) parcel.readSerializable();
            this.g3 = (Locale) parcel.readSerializable();
            this.w3 = (Boolean) parcel.readSerializable();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02f9  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x033b  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    BadgeState(android.content.Context r7, @androidx.annotation.XmlRes int r8, @androidx.annotation.AttrRes int r9, @androidx.annotation.StyleRes int r10, @androidx.annotation.Nullable com.google.android.material.badge.BadgeState.State r11) {
        /*
            r6 = this;
            r6.<init>()
            com.google.android.material.badge.BadgeState$State r0 = new com.google.android.material.badge.BadgeState$State
            r0.<init>()
            r6.f20829b = r0
            if (r11 != 0) goto L_0x0011
            com.google.android.material.badge.BadgeState$State r11 = new com.google.android.material.badge.BadgeState$State
            r11.<init>()
        L_0x0011:
            if (r8 == 0) goto L_0x0016
            int unused = r11.s = r8
        L_0x0016:
            int r8 = r11.s
            android.content.res.TypedArray r8 = r6.c(r7, r8, r9, r10)
            android.content.res.Resources r9 = r7.getResources()
            int r10 = com.google.android.material.R.styleable.d4
            r1 = -1
            int r10 = r8.getDimensionPixelSize(r10, r1)
            float r10 = (float) r10
            r6.f20830c = r10
            android.content.res.Resources r10 = r7.getResources()
            int r2 = com.google.android.material.R.dimen.pa
            int r10 = r10.getDimensionPixelSize(r2)
            r6.f20836i = r10
            android.content.res.Resources r10 = r7.getResources()
            int r2 = com.google.android.material.R.dimen.sa
            int r10 = r10.getDimensionPixelSize(r2)
            r6.f20837j = r10
            int r10 = com.google.android.material.R.styleable.n4
            int r10 = r8.getDimensionPixelSize(r10, r1)
            float r10 = (float) r10
            r6.f20831d = r10
            int r10 = com.google.android.material.R.styleable.l4
            int r2 = com.google.android.material.R.dimen.z2
            float r3 = r9.getDimension(r2)
            float r10 = r8.getDimension(r10, r3)
            r6.f20832e = r10
            int r10 = com.google.android.material.R.styleable.q4
            int r3 = com.google.android.material.R.dimen.D2
            float r4 = r9.getDimension(r3)
            float r10 = r8.getDimension(r10, r4)
            r6.f20834g = r10
            int r10 = com.google.android.material.R.styleable.c4
            float r2 = r9.getDimension(r2)
            float r10 = r8.getDimension(r10, r2)
            r6.f20833f = r10
            int r10 = com.google.android.material.R.styleable.m4
            float r2 = r9.getDimension(r3)
            float r10 = r8.getDimension(r10, r2)
            r6.f20835h = r10
            int r10 = com.google.android.material.R.styleable.x4
            r2 = 1
            int r10 = r8.getInt(r10, r2)
            r6.f20838k = r10
            int r10 = r11.b3
            r3 = -2
            if (r10 != r3) goto L_0x0094
            r10 = 255(0xff, float:3.57E-43)
            goto L_0x0098
        L_0x0094:
            int r10 = r11.b3
        L_0x0098:
            int unused = r0.b3 = r10
            int r10 = r11.d3
            r4 = 0
            if (r10 == r3) goto L_0x00aa
            int r10 = r11.d3
        L_0x00a6:
            int unused = r0.d3 = r10
            goto L_0x00ba
        L_0x00aa:
            int r10 = com.google.android.material.R.styleable.w4
            boolean r5 = r8.hasValue(r10)
            if (r5 == 0) goto L_0x00b7
            int r10 = r8.getInt(r10, r4)
            goto L_0x00a6
        L_0x00b7:
            int unused = r0.d3 = r1
        L_0x00ba:
            java.lang.String r10 = r11.c3
            if (r10 == 0) goto L_0x00c8
            java.lang.String r10 = r11.c3
        L_0x00c4:
            java.lang.String unused = r0.c3 = r10
            goto L_0x00d5
        L_0x00c8:
            int r10 = com.google.android.material.R.styleable.g4
            boolean r1 = r8.hasValue(r10)
            if (r1 == 0) goto L_0x00d5
            java.lang.String r10 = r8.getString(r10)
            goto L_0x00c4
        L_0x00d5:
            java.lang.CharSequence r10 = r11.h3
            java.lang.CharSequence unused = r0.h3 = r10
            java.lang.CharSequence r10 = r11.i3
            if (r10 != 0) goto L_0x00e9
            int r10 = com.google.android.material.R.string.N0
            java.lang.String r10 = r7.getString(r10)
            goto L_0x00ed
        L_0x00e9:
            java.lang.CharSequence r10 = r11.i3
        L_0x00ed:
            java.lang.CharSequence unused = r0.i3 = r10
            int r10 = r11.j3
            if (r10 != 0) goto L_0x00f9
            int r10 = com.google.android.material.R.plurals.f20717a
            goto L_0x00fd
        L_0x00f9:
            int r10 = r11.j3
        L_0x00fd:
            int unused = r0.j3 = r10
            int r10 = r11.k3
            if (r10 != 0) goto L_0x0109
            int r10 = com.google.android.material.R.string.a1
            goto L_0x010d
        L_0x0109:
            int r10 = r11.k3
        L_0x010d:
            int unused = r0.k3 = r10
            java.lang.Boolean r10 = r11.m3
            if (r10 == 0) goto L_0x0122
            java.lang.Boolean r10 = r11.m3
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0121
            goto L_0x0122
        L_0x0121:
            r2 = 0
        L_0x0122:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r2)
            java.lang.Boolean unused = r0.m3 = r10
            int r10 = r11.e3
            if (r10 != r3) goto L_0x0136
            int r10 = com.google.android.material.R.styleable.u4
            int r10 = r8.getInt(r10, r3)
            goto L_0x013a
        L_0x0136:
            int r10 = r11.e3
        L_0x013a:
            int unused = r0.e3 = r10
            int r10 = r11.f3
            if (r10 != r3) goto L_0x014a
            int r10 = com.google.android.material.R.styleable.v4
            int r10 = r8.getInt(r10, r3)
            goto L_0x014e
        L_0x014a:
            int r10 = r11.f3
        L_0x014e:
            int unused = r0.f3 = r10
            java.lang.Integer r10 = r11.X2
            if (r10 != 0) goto L_0x0160
            int r10 = com.google.android.material.R.styleable.e4
            int r1 = com.google.android.material.R.style.q6
            int r10 = r8.getResourceId(r10, r1)
            goto L_0x0168
        L_0x0160:
            java.lang.Integer r10 = r11.X2
            int r10 = r10.intValue()
        L_0x0168:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Integer unused = r0.X2 = r10
            java.lang.Integer r10 = r11.Y2
            if (r10 != 0) goto L_0x017c
            int r10 = com.google.android.material.R.styleable.f4
            int r10 = r8.getResourceId(r10, r4)
            goto L_0x0184
        L_0x017c:
            java.lang.Integer r10 = r11.Y2
            int r10 = r10.intValue()
        L_0x0184:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Integer unused = r0.Y2 = r10
            java.lang.Integer r10 = r11.Z2
            if (r10 != 0) goto L_0x019a
            int r10 = com.google.android.material.R.styleable.o4
            int r1 = com.google.android.material.R.style.q6
            int r10 = r8.getResourceId(r10, r1)
            goto L_0x01a2
        L_0x019a:
            java.lang.Integer r10 = r11.Z2
            int r10 = r10.intValue()
        L_0x01a2:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Integer unused = r0.Z2 = r10
            java.lang.Integer r10 = r11.a3
            if (r10 != 0) goto L_0x01b6
            int r10 = com.google.android.material.R.styleable.p4
            int r10 = r8.getResourceId(r10, r4)
            goto L_0x01be
        L_0x01b6:
            java.lang.Integer r10 = r11.a3
            int r10 = r10.intValue()
        L_0x01be:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Integer unused = r0.a3 = r10
            java.lang.Integer r10 = r11.X
            if (r10 != 0) goto L_0x01d2
            int r10 = com.google.android.material.R.styleable.a4
            int r10 = J(r7, r8, r10)
            goto L_0x01da
        L_0x01d2:
            java.lang.Integer r10 = r11.X
            int r10 = r10.intValue()
        L_0x01da:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Integer unused = r0.X = r10
            java.lang.Integer r10 = r11.Z
            if (r10 != 0) goto L_0x01f0
            int r10 = com.google.android.material.R.styleable.h4
            int r1 = com.google.android.material.R.style.J8
            int r10 = r8.getResourceId(r10, r1)
            goto L_0x01f8
        L_0x01f0:
            java.lang.Integer r10 = r11.Z
            int r10 = r10.intValue()
        L_0x01f8:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Integer unused = r0.Z = r10
            java.lang.Integer r10 = r11.Y
            if (r10 == 0) goto L_0x020d
            java.lang.Integer r7 = r11.Y
        L_0x0209:
            java.lang.Integer unused = r0.Y = r7
            goto L_0x0234
        L_0x020d:
            int r10 = com.google.android.material.R.styleable.i4
            boolean r1 = r8.hasValue(r10)
            if (r1 == 0) goto L_0x021e
            int r7 = J(r7, r8, r10)
        L_0x0219:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0209
        L_0x021e:
            com.google.android.material.resources.TextAppearance r10 = new com.google.android.material.resources.TextAppearance
            java.lang.Integer r1 = r0.Z
            int r1 = r1.intValue()
            r10.<init>(r7, r1)
            android.content.res.ColorStateList r7 = r10.i()
            int r7 = r7.getDefaultColor()
            goto L_0x0219
        L_0x0234:
            java.lang.Integer r7 = r11.l3
            if (r7 != 0) goto L_0x0244
            int r7 = com.google.android.material.R.styleable.b4
            r10 = 8388661(0x800035, float:1.1755018E-38)
            int r7 = r8.getInt(r7, r10)
            goto L_0x024c
        L_0x0244:
            java.lang.Integer r7 = r11.l3
            int r7 = r7.intValue()
        L_0x024c:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Integer unused = r0.l3 = r7
            java.lang.Integer r7 = r11.n3
            if (r7 != 0) goto L_0x0266
            int r7 = com.google.android.material.R.styleable.k4
            int r10 = com.google.android.material.R.dimen.qa
            int r10 = r9.getDimensionPixelSize(r10)
            int r7 = r8.getDimensionPixelSize(r7, r10)
            goto L_0x026e
        L_0x0266:
            java.lang.Integer r7 = r11.n3
            int r7 = r7.intValue()
        L_0x026e:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Integer unused = r0.n3 = r7
            java.lang.Integer r7 = r11.o3
            if (r7 != 0) goto L_0x0288
            int r7 = com.google.android.material.R.styleable.j4
            int r10 = com.google.android.material.R.dimen.F2
            int r9 = r9.getDimensionPixelSize(r10)
            int r7 = r8.getDimensionPixelSize(r7, r9)
            goto L_0x0290
        L_0x0288:
            java.lang.Integer r7 = r11.o3
            int r7 = r7.intValue()
        L_0x0290:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Integer unused = r0.o3 = r7
            java.lang.Integer r7 = r11.p3
            if (r7 != 0) goto L_0x02a4
            int r7 = com.google.android.material.R.styleable.r4
            int r7 = r8.getDimensionPixelOffset(r7, r4)
            goto L_0x02ac
        L_0x02a4:
            java.lang.Integer r7 = r11.p3
            int r7 = r7.intValue()
        L_0x02ac:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Integer unused = r0.p3 = r7
            java.lang.Integer r7 = r11.q3
            if (r7 != 0) goto L_0x02c0
            int r7 = com.google.android.material.R.styleable.y4
            int r7 = r8.getDimensionPixelOffset(r7, r4)
            goto L_0x02c8
        L_0x02c0:
            java.lang.Integer r7 = r11.q3
            int r7 = r7.intValue()
        L_0x02c8:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Integer unused = r0.q3 = r7
            java.lang.Integer r7 = r11.r3
            if (r7 != 0) goto L_0x02e4
            int r7 = com.google.android.material.R.styleable.s4
            java.lang.Integer r9 = r0.p3
            int r9 = r9.intValue()
            int r7 = r8.getDimensionPixelOffset(r7, r9)
            goto L_0x02ec
        L_0x02e4:
            java.lang.Integer r7 = r11.r3
            int r7 = r7.intValue()
        L_0x02ec:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Integer unused = r0.r3 = r7
            java.lang.Integer r7 = r11.s3
            if (r7 != 0) goto L_0x0308
            int r7 = com.google.android.material.R.styleable.z4
            java.lang.Integer r9 = r0.q3
            int r9 = r9.intValue()
            int r7 = r8.getDimensionPixelOffset(r7, r9)
            goto L_0x0310
        L_0x0308:
            java.lang.Integer r7 = r11.s3
            int r7 = r7.intValue()
        L_0x0310:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Integer unused = r0.s3 = r7
            java.lang.Integer r7 = r11.v3
            if (r7 != 0) goto L_0x0324
            int r7 = com.google.android.material.R.styleable.t4
            int r7 = r8.getDimensionPixelOffset(r7, r4)
            goto L_0x032c
        L_0x0324:
            java.lang.Integer r7 = r11.v3
            int r7 = r7.intValue()
        L_0x032c:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Integer unused = r0.v3 = r7
            java.lang.Integer r7 = r11.t3
            if (r7 != 0) goto L_0x033b
            r7 = 0
            goto L_0x0343
        L_0x033b:
            java.lang.Integer r7 = r11.t3
            int r7 = r7.intValue()
        L_0x0343:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Integer unused = r0.t3 = r7
            java.lang.Integer r7 = r11.u3
            if (r7 != 0) goto L_0x0352
            r7 = 0
            goto L_0x035a
        L_0x0352:
            java.lang.Integer r7 = r11.u3
            int r7 = r7.intValue()
        L_0x035a:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Integer unused = r0.u3 = r7
            java.lang.Boolean r7 = r11.w3
            if (r7 != 0) goto L_0x036e
            int r7 = com.google.android.material.R.styleable.Z3
            boolean r7 = r8.getBoolean(r7, r4)
            goto L_0x0376
        L_0x036e:
            java.lang.Boolean r7 = r11.w3
            boolean r7 = r7.booleanValue()
        L_0x0376:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.Boolean unused = r0.w3 = r7
            r8.recycle()
            java.util.Locale r7 = r11.g3
            if (r7 != 0) goto L_0x039d
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 24
            if (r7 < r8) goto L_0x0395
            java.util.Locale$Category r7 = java.util.Locale.Category.FORMAT
            java.util.Locale r7 = java.util.Locale.getDefault(r7)
            goto L_0x0399
        L_0x0395:
            java.util.Locale r7 = java.util.Locale.getDefault()
        L_0x0399:
            java.util.Locale unused = r0.g3 = r7
            goto L_0x03a2
        L_0x039d:
            java.util.Locale r7 = r11.g3
            goto L_0x0399
        L_0x03a2:
            r6.f20828a = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.badge.BadgeState.<init>(android.content.Context, int, int, int, com.google.android.material.badge.BadgeState$State):void");
    }

    private static int J(Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        return MaterialResources.a(context, typedArray, i2).getDefaultColor();
    }

    private TypedArray c(Context context, @XmlRes int i2, @AttrRes int i3, @StyleRes int i4) {
        AttributeSet attributeSet;
        int i5;
        if (i2 != 0) {
            AttributeSet k2 = DrawableUtils.k(context, i2, f20827l);
            i5 = k2.getStyleAttribute();
            attributeSet = k2;
        } else {
            attributeSet = null;
            i5 = 0;
        }
        return ThemeEnforcement.k(context, attributeSet, R.styleable.Y3, i3, i5 == 0 ? i4 : i5, new int[0]);
    }

    /* access modifiers changed from: package-private */
    public State A() {
        return this.f20828a;
    }

    /* access modifiers changed from: package-private */
    public String B() {
        return this.f20829b.c3;
    }

    /* access modifiers changed from: package-private */
    @StyleRes
    public int C() {
        return this.f20829b.Z.intValue();
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int D() {
        return this.f20829b.s3.intValue();
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int E() {
        return this.f20829b.q3.intValue();
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        return this.f20829b.d3 != -1;
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        return this.f20829b.c3 != null;
    }

    /* access modifiers changed from: package-private */
    public boolean H() {
        return this.f20829b.w3.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        return this.f20829b.m3.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public void K(@Dimension(unit = 1) int i2) {
        Integer unused = this.f20828a.t3 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.t3 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    public void L(@Dimension(unit = 1) int i2) {
        Integer unused = this.f20828a.u3 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.u3 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    public void M(int i2) {
        int unused = this.f20828a.b3 = i2;
        int unused2 = this.f20829b.b3 = i2;
    }

    /* access modifiers changed from: package-private */
    public void N(boolean z) {
        Boolean unused = this.f20828a.w3 = Boolean.valueOf(z);
        Boolean unused2 = this.f20829b.w3 = Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    public void O(@ColorInt int i2) {
        Integer unused = this.f20828a.X = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.X = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    public void P(int i2) {
        Integer unused = this.f20828a.l3 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.l3 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    public void Q(@Px int i2) {
        Integer unused = this.f20828a.n3 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.n3 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    public void R(int i2) {
        Integer unused = this.f20828a.Y2 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.Y2 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    public void S(int i2) {
        Integer unused = this.f20828a.X2 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.X2 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    public void T(@ColorInt int i2) {
        Integer unused = this.f20828a.Y = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.Y = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    public void U(@Px int i2) {
        Integer unused = this.f20828a.o3 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.o3 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    public void V(int i2) {
        Integer unused = this.f20828a.a3 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.a3 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    public void W(int i2) {
        Integer unused = this.f20828a.Z2 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.Z2 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    public void X(@StringRes int i2) {
        int unused = this.f20828a.k3 = i2;
        int unused2 = this.f20829b.k3 = i2;
    }

    /* access modifiers changed from: package-private */
    public void Y(CharSequence charSequence) {
        CharSequence unused = this.f20828a.h3 = charSequence;
        CharSequence unused2 = this.f20829b.h3 = charSequence;
    }

    /* access modifiers changed from: package-private */
    public void Z(CharSequence charSequence) {
        CharSequence unused = this.f20828a.i3 = charSequence;
        CharSequence unused2 = this.f20829b.i3 = charSequence;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        g0(-1);
    }

    /* access modifiers changed from: package-private */
    public void a0(@PluralsRes int i2) {
        int unused = this.f20828a.j3 = i2;
        int unused2 = this.f20829b.j3 = i2;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        i0((String) null);
    }

    /* access modifiers changed from: package-private */
    public void b0(@Dimension(unit = 1) int i2) {
        Integer unused = this.f20828a.r3 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.r3 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    public void c0(@Dimension(unit = 1) int i2) {
        Integer unused = this.f20828a.p3 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.p3 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int d() {
        return this.f20829b.t3.intValue();
    }

    /* access modifiers changed from: package-private */
    public void d0(@Dimension(unit = 1) int i2) {
        Integer unused = this.f20828a.v3 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.v3 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int e() {
        return this.f20829b.u3.intValue();
    }

    /* access modifiers changed from: package-private */
    public void e0(int i2) {
        int unused = this.f20828a.e3 = i2;
        int unused2 = this.f20829b.e3 = i2;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f20829b.b3;
    }

    /* access modifiers changed from: package-private */
    public void f0(int i2) {
        int unused = this.f20828a.f3 = i2;
        int unused2 = this.f20829b.f3 = i2;
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int g() {
        return this.f20829b.X.intValue();
    }

    /* access modifiers changed from: package-private */
    public void g0(int i2) {
        int unused = this.f20828a.d3 = i2;
        int unused2 = this.f20829b.d3 = i2;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f20829b.l3.intValue();
    }

    /* access modifiers changed from: package-private */
    public void h0(Locale locale) {
        Locale unused = this.f20828a.g3 = locale;
        Locale unused2 = this.f20829b.g3 = locale;
    }

    /* access modifiers changed from: package-private */
    @Px
    public int i() {
        return this.f20829b.n3.intValue();
    }

    /* access modifiers changed from: package-private */
    public void i0(String str) {
        String unused = this.f20828a.c3 = str;
        String unused2 = this.f20829b.c3 = str;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f20829b.Y2.intValue();
    }

    /* access modifiers changed from: package-private */
    public void j0(@StyleRes int i2) {
        Integer unused = this.f20828a.Z = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.Z = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f20829b.X2.intValue();
    }

    /* access modifiers changed from: package-private */
    public void k0(@Dimension(unit = 1) int i2) {
        Integer unused = this.f20828a.s3 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.s3 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int l() {
        return this.f20829b.Y.intValue();
    }

    /* access modifiers changed from: package-private */
    public void l0(@Dimension(unit = 1) int i2) {
        Integer unused = this.f20828a.q3 = Integer.valueOf(i2);
        Integer unused2 = this.f20829b.q3 = Integer.valueOf(i2);
    }

    /* access modifiers changed from: package-private */
    @Px
    public int m() {
        return this.f20829b.o3.intValue();
    }

    /* access modifiers changed from: package-private */
    public void m0(boolean z) {
        Boolean unused = this.f20828a.m3 = Boolean.valueOf(z);
        Boolean unused2 = this.f20829b.m3 = Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.f20829b.a3.intValue();
    }

    /* access modifiers changed from: package-private */
    public int o() {
        return this.f20829b.Z2.intValue();
    }

    /* access modifiers changed from: package-private */
    @StringRes
    public int p() {
        return this.f20829b.k3;
    }

    /* access modifiers changed from: package-private */
    public CharSequence q() {
        return this.f20829b.h3;
    }

    /* access modifiers changed from: package-private */
    public CharSequence r() {
        return this.f20829b.i3;
    }

    /* access modifiers changed from: package-private */
    @PluralsRes
    public int s() {
        return this.f20829b.j3;
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int t() {
        return this.f20829b.r3.intValue();
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int u() {
        return this.f20829b.p3.intValue();
    }

    /* access modifiers changed from: package-private */
    @Dimension(unit = 1)
    public int v() {
        return this.f20829b.v3.intValue();
    }

    /* access modifiers changed from: package-private */
    public int w() {
        return this.f20829b.e3;
    }

    /* access modifiers changed from: package-private */
    public int x() {
        return this.f20829b.f3;
    }

    /* access modifiers changed from: package-private */
    public int y() {
        return this.f20829b.d3;
    }

    /* access modifiers changed from: package-private */
    public Locale z() {
        return this.f20829b.g3;
    }
}
