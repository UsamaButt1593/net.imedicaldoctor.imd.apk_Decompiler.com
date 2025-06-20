package androidx.core.view.accessibility;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.os.BuildCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AccessibilityNodeInfoCompat {
    public static final int A = 1;
    public static final int A0 = 32;
    public static final int B = 2;
    @SuppressLint({"MinMaxConstant"})
    public static final int B0 = 50;
    public static final int C = 4;
    private static int C0 = 0;
    public static final int D = 8;
    public static final int E = 16;
    public static final int F = 32;
    public static final int G = 64;
    public static final int H = 128;
    public static final int I = 256;
    public static final int J = 512;
    public static final int K = 1024;
    public static final int L = 2048;
    public static final int M = 4096;
    public static final int N = 8192;
    public static final int O = 16384;
    public static final int P = 32768;
    public static final int Q = 65536;
    public static final int R = 131072;
    public static final int S = 262144;
    public static final int T = 524288;
    public static final int U = 1048576;
    public static final int V = 2097152;
    public static final String W = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String X = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String Y = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String Z = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String a0 = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String b0 = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final String c0 = "android.view.accessibility.action.ARGUMENT_ROW_INT";

    /* renamed from: d  reason: collision with root package name */
    private static final String f6638d = "AccessibilityNodeInfo.roleDescription";
    public static final String d0 = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";

    /* renamed from: e  reason: collision with root package name */
    private static final String f6639e = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    public static final String e0 = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";

    /* renamed from: f  reason: collision with root package name */
    private static final String f6640f = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    public static final String f0 = "ACTION_ARGUMENT_MOVE_WINDOW_X";

    /* renamed from: g  reason: collision with root package name */
    private static final String f6641g = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    public static final String g0 = "ACTION_ARGUMENT_MOVE_WINDOW_Y";

    /* renamed from: h  reason: collision with root package name */
    private static final String f6642h = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    @SuppressLint({"ActionValue"})
    public static final String h0 = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";

    /* renamed from: i  reason: collision with root package name */
    private static final String f6643i = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    public static final String i0 = "androidx.core.view.accessibility.action.ARGUMENT_DIRECTION_INT";

    /* renamed from: j  reason: collision with root package name */
    private static final String f6644j = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    public static final String j0 = "androidx.core.view.accessibility.action.ARGUMENT_SCROLL_AMOUNT_FLOAT";

    /* renamed from: k  reason: collision with root package name */
    private static final String f6645k = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    public static final int k0 = 1;

    /* renamed from: l  reason: collision with root package name */
    private static final String f6646l = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    public static final int l0 = 2;

    /* renamed from: m  reason: collision with root package name */
    private static final String f6647m = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    public static final int m0 = 1;

    /* renamed from: n  reason: collision with root package name */
    private static final String f6648n = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";
    public static final int n0 = 2;
    private static final String o = "androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY";
    public static final int o0 = 4;
    private static final String p = "androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY";
    public static final int p0 = 8;
    private static final String q = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY";
    public static final int q0 = 16;
    private static final String r = "androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY";
    public static final String r0 = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";
    private static final int s = 1;
    public static final String s0 = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";
    private static final int t = 2;
    public static final String t0 = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";
    private static final int u = 4;
    public static final int u0 = 20000;
    private static final int v = 8;
    public static final int v0 = 1;
    private static final int w = 32;
    public static final int w0 = 2;
    private static final int x = 64;
    public static final int x0 = 4;
    private static final int y = 8388608;
    public static final int y0 = 8;
    private static final int z = 67108864;
    public static final int z0 = 16;

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfo f6649a;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

    /* renamed from: b  reason: collision with root package name */
    public int f6650b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f6651c = -1;

    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat A = new AccessibilityActionCompat(2097152, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetTextArguments.class);
        public static final AccessibilityActionCompat B;
        public static final AccessibilityActionCompat C;
        public static final AccessibilityActionCompat D;
        public static final AccessibilityActionCompat E;
        public static final AccessibilityActionCompat F;
        public static final AccessibilityActionCompat G;
        @NonNull
        public static final AccessibilityActionCompat H;
        @NonNull
        public static final AccessibilityActionCompat I;
        @NonNull
        public static final AccessibilityActionCompat J;
        @NonNull
        public static final AccessibilityActionCompat K;
        public static final AccessibilityActionCompat L;
        public static final AccessibilityActionCompat M;
        public static final AccessibilityActionCompat N;
        public static final AccessibilityActionCompat O;
        public static final AccessibilityActionCompat P;
        @NonNull
        public static final AccessibilityActionCompat Q;
        @NonNull
        public static final AccessibilityActionCompat R;
        @NonNull
        public static final AccessibilityActionCompat S;
        @NonNull
        public static final AccessibilityActionCompat T;
        @NonNull
        public static final AccessibilityActionCompat U;
        @NonNull
        public static final AccessibilityActionCompat V;
        @NonNull
        @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
        public static final AccessibilityActionCompat W;

        /* renamed from: e  reason: collision with root package name */
        private static final String f6652e = "A11yActionCompat";

        /* renamed from: f  reason: collision with root package name */
        public static final AccessibilityActionCompat f6653f = new AccessibilityActionCompat(1, (CharSequence) null);

        /* renamed from: g  reason: collision with root package name */
        public static final AccessibilityActionCompat f6654g = new AccessibilityActionCompat(2, (CharSequence) null);

        /* renamed from: h  reason: collision with root package name */
        public static final AccessibilityActionCompat f6655h = new AccessibilityActionCompat(4, (CharSequence) null);

        /* renamed from: i  reason: collision with root package name */
        public static final AccessibilityActionCompat f6656i = new AccessibilityActionCompat(8, (CharSequence) null);

        /* renamed from: j  reason: collision with root package name */
        public static final AccessibilityActionCompat f6657j = new AccessibilityActionCompat(16, (CharSequence) null);

        /* renamed from: k  reason: collision with root package name */
        public static final AccessibilityActionCompat f6658k = new AccessibilityActionCompat(32, (CharSequence) null);

        /* renamed from: l  reason: collision with root package name */
        public static final AccessibilityActionCompat f6659l = new AccessibilityActionCompat(64, (CharSequence) null);

        /* renamed from: m  reason: collision with root package name */
        public static final AccessibilityActionCompat f6660m = new AccessibilityActionCompat(128, (CharSequence) null);

        /* renamed from: n  reason: collision with root package name */
        public static final AccessibilityActionCompat f6661n;
        public static final AccessibilityActionCompat o;
        public static final AccessibilityActionCompat p;
        public static final AccessibilityActionCompat q;
        public static final AccessibilityActionCompat r = new AccessibilityActionCompat(4096, (CharSequence) null);
        public static final AccessibilityActionCompat s = new AccessibilityActionCompat(8192, (CharSequence) null);
        public static final AccessibilityActionCompat t = new AccessibilityActionCompat(16384, (CharSequence) null);
        public static final AccessibilityActionCompat u = new AccessibilityActionCompat(32768, (CharSequence) null);
        public static final AccessibilityActionCompat v = new AccessibilityActionCompat(65536, (CharSequence) null);
        public static final AccessibilityActionCompat w = new AccessibilityActionCompat(131072, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetSelectionArguments.class);
        public static final AccessibilityActionCompat x = new AccessibilityActionCompat(262144, (CharSequence) null);
        public static final AccessibilityActionCompat y = new AccessibilityActionCompat(524288, (CharSequence) null);
        public static final AccessibilityActionCompat z = new AccessibilityActionCompat(1048576, (CharSequence) null);

        /* renamed from: a  reason: collision with root package name */
        final Object f6662a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6663b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<? extends AccessibilityViewCommand.CommandArguments> f6664c;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

        /* renamed from: d  reason: collision with root package name */
        protected final AccessibilityViewCommand f6665d;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            Class<AccessibilityViewCommand.MoveAtGranularityArguments> cls = AccessibilityViewCommand.MoveAtGranularityArguments.class;
            f6661n = new AccessibilityActionCompat(256, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) cls);
            o = new AccessibilityActionCompat(512, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) cls);
            Class<AccessibilityViewCommand.MoveHtmlArguments> cls2 = AccessibilityViewCommand.MoveHtmlArguments.class;
            p = new AccessibilityActionCompat(1024, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) cls2);
            q = new AccessibilityActionCompat(2048, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) cls2);
            int i2 = Build.VERSION.SDK_INT;
            B = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            C = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            D = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            E = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            F = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            G = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            H = new AccessibilityActionCompat(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            I = new AccessibilityActionCompat(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            J = new AccessibilityActionCompat(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            K = new AccessibilityActionCompat(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            L = new AccessibilityActionCompat(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            M = new AccessibilityActionCompat(i2 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.SetProgressArguments.class);
            N = new AccessibilityActionCompat(i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.MoveWindowArguments.class);
            O = new AccessibilityActionCompat(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            P = new AccessibilityActionCompat(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            Q = new AccessibilityActionCompat(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            R = new AccessibilityActionCompat(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, 16908372, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            S = new AccessibilityActionCompat(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, 16908373, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            T = new AccessibilityActionCompat(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, 16908374, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            U = new AccessibilityActionCompat(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, 16908375, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            V = new AccessibilityActionCompat(i2 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, 16908376, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i2 >= 34) {
                accessibilityAction = Api34Impl.a();
            }
            W = new AccessibilityActionCompat(accessibilityAction, 16908382, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        public AccessibilityActionCompat(int i2, CharSequence charSequence) {
            this((Object) null, i2, charSequence, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat a(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new AccessibilityActionCompat((Object) null, this.f6663b, charSequence, accessibilityViewCommand, this.f6664c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f6662a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f6662a).getLabel();
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0020  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0023  */
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean d(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                androidx.core.view.accessibility.AccessibilityViewCommand r0 = r4.f6665d
                if (r0 == 0) goto L_0x0044
                java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments> r0 = r4.f6664c
                r1 = 0
                if (r0 == 0) goto L_0x003d
                java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r1)     // Catch:{ Exception -> 0x001b }
                java.lang.Object r0 = r0.newInstance(r1)     // Catch:{ Exception -> 0x001b }
                androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments r0 = (androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments) r0     // Catch:{ Exception -> 0x001b }
                r0.a(r6)     // Catch:{ Exception -> 0x0018 }
                r1 = r0
                goto L_0x003d
            L_0x0018:
                r6 = move-exception
                r1 = r0
                goto L_0x001c
            L_0x001b:
                r6 = move-exception
            L_0x001c:
                java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments> r0 = r4.f6664c
                if (r0 != 0) goto L_0x0023
                java.lang.String r0 = "null"
                goto L_0x0027
            L_0x0023:
                java.lang.String r0 = r0.getName()
            L_0x0027:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Failed to execute command with argument class ViewCommandArgument: "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                java.lang.String r2 = "A11yActionCompat"
                android.util.Log.e(r2, r0, r6)
            L_0x003d:
                androidx.core.view.accessibility.AccessibilityViewCommand r6 = r4.f6665d
                boolean r5 = r6.a(r5, r1)
                return r5
            L_0x0044:
                r5 = 0
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.d(android.view.View, android.os.Bundle):boolean");
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            Object obj2 = this.f6662a;
            Object obj3 = ((AccessibilityActionCompat) obj).f6662a;
            return obj2 == null ? obj3 == null : obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f6662a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String o2 = AccessibilityNodeInfoCompat.o(this.f6663b);
            if (o2.equals("ACTION_UNKNOWN") && c() != null) {
                o2 = c().toString();
            }
            sb.append(o2);
            return sb.toString();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat(int i2, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this((Object) null, i2, charSequence, accessibilityViewCommand, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        private AccessibilityActionCompat(int i2, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this((Object) null, i2, charSequence, (AccessibilityViewCommand) null, cls);
        }

        AccessibilityActionCompat(Object obj) {
            this(obj, 0, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        AccessibilityActionCompat(Object obj, int i2, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this.f6663b = i2;
            this.f6665d = accessibilityViewCommand;
            this.f6662a = obj == null ? new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence) : obj;
            this.f6664c = cls;
        }
    }

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static CollectionItemInfoCompat a(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z, z2));
        }
    }

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static Object a(int i2, float f2, float f3, float f4) {
            return new AccessibilityNodeInfo.RangeInfo(i2, f2, f3, f4);
        }

        @DoNotInline
        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        @DoNotInline
        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static CollectionItemInfoCompat a(boolean z, int i2, int i3, int i4, int i5, boolean z2, String str, String str2) {
            return new CollectionItemInfoCompat(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z).setColumnIndex(i2).setRowIndex(i3).setColumnSpan(i4).setRowSpan(i5).setSelected(z2).setRowTitle(str).setColumnTitle(str2).build());
        }

        @DoNotInline
        public static AccessibilityNodeInfoCompat b(AccessibilityNodeInfo accessibilityNodeInfo, int i2, int i3) {
            return AccessibilityNodeInfoCompat.s2(accessibilityNodeInfo.getChild(i2, i3));
        }

        @DoNotInline
        public static String c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        @DoNotInline
        public static String d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        @DoNotInline
        public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        @DoNotInline
        public static AccessibilityNodeInfoCompat f(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
            return AccessibilityNodeInfoCompat.s2(accessibilityNodeInfo.getParent(i2));
        }

        @DoNotInline
        public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        @DoNotInline
        public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        @DoNotInline
        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setTextSelectable(z);
        }

        @DoNotInline
        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        @DoNotInline
        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        @DoNotInline
        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        @DoNotInline
        public static long d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        @DoNotInline
        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        @DoNotInline
        public static boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        @DoNotInline
        public static void g(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z);
        }

        @DoNotInline
        public static void h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        @DoNotInline
        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        @DoNotInline
        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, long j2) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j2));
        }

        @DoNotInline
        public static void k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z);
        }

        @DoNotInline
        public static void l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z);
        }
    }

    public static class CollectionInfoCompat {

        /* renamed from: b  reason: collision with root package name */
        public static final int f6666b = 0;

        /* renamed from: c  reason: collision with root package name */
        public static final int f6667c = 1;

        /* renamed from: d  reason: collision with root package name */
        public static final int f6668d = 2;

        /* renamed from: a  reason: collision with root package name */
        final Object f6669a;

        CollectionInfoCompat(Object obj) {
            this.f6669a = obj;
        }

        public static CollectionInfoCompat e(int i2, int i3, boolean z) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z));
        }

        public static CollectionInfoCompat f(int i2, int i3, boolean z, int i4) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z, i4));
        }

        public int a() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f6669a).getColumnCount();
        }

        public int b() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f6669a).getRowCount();
        }

        public int c() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f6669a).getSelectionMode();
        }

        public boolean d() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f6669a).isHierarchical();
        }
    }

    public static class CollectionItemInfoCompat {

        /* renamed from: a  reason: collision with root package name */
        final Object f6670a;

        public static final class Builder {

            /* renamed from: a  reason: collision with root package name */
            private boolean f6671a;

            /* renamed from: b  reason: collision with root package name */
            private int f6672b;

            /* renamed from: c  reason: collision with root package name */
            private int f6673c;

            /* renamed from: d  reason: collision with root package name */
            private int f6674d;

            /* renamed from: e  reason: collision with root package name */
            private int f6675e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f6676f;

            /* renamed from: g  reason: collision with root package name */
            private String f6677g;

            /* renamed from: h  reason: collision with root package name */
            private String f6678h;

            @NonNull
            public CollectionItemInfoCompat a() {
                return Build.VERSION.SDK_INT >= 33 ? Api33Impl.a(this.f6671a, this.f6672b, this.f6673c, this.f6674d, this.f6675e, this.f6676f, this.f6677g, this.f6678h) : Api21Impl.a(this.f6673c, this.f6675e, this.f6672b, this.f6674d, this.f6671a, this.f6676f);
            }

            @NonNull
            public Builder b(int i2) {
                this.f6672b = i2;
                return this;
            }

            @NonNull
            public Builder c(int i2) {
                this.f6674d = i2;
                return this;
            }

            @NonNull
            public Builder d(@Nullable String str) {
                this.f6678h = str;
                return this;
            }

            @NonNull
            public Builder e(boolean z) {
                this.f6671a = z;
                return this;
            }

            @NonNull
            public Builder f(int i2) {
                this.f6673c = i2;
                return this;
            }

            @NonNull
            public Builder g(int i2) {
                this.f6675e = i2;
                return this;
            }

            @NonNull
            public Builder h(@Nullable String str) {
                this.f6677g = str;
                return this;
            }

            @NonNull
            public Builder i(boolean z) {
                this.f6676f = z;
                return this;
            }
        }

        CollectionItemInfoCompat(Object obj) {
            this.f6670a = obj;
        }

        public static CollectionItemInfoCompat i(int i2, int i3, int i4, int i5, boolean z) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z));
        }

        public static CollectionItemInfoCompat j(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z, z2));
        }

        public int a() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f6670a).getColumnIndex();
        }

        public int b() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f6670a).getColumnSpan();
        }

        @Nullable
        public String c() {
            if (Build.VERSION.SDK_INT >= 33) {
                return Api33Impl.c(this.f6670a);
            }
            return null;
        }

        public int d() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f6670a).getRowIndex();
        }

        public int e() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f6670a).getRowSpan();
        }

        @Nullable
        public String f() {
            if (Build.VERSION.SDK_INT >= 33) {
                return Api33Impl.d(this.f6670a);
            }
            return null;
        }

        @Deprecated
        public boolean g() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f6670a).isHeading();
        }

        public boolean h() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f6670a).isSelected();
        }
    }

    public static class RangeInfoCompat {

        /* renamed from: b  reason: collision with root package name */
        public static final int f6679b = 0;

        /* renamed from: c  reason: collision with root package name */
        public static final int f6680c = 1;

        /* renamed from: d  reason: collision with root package name */
        public static final int f6681d = 2;

        /* renamed from: a  reason: collision with root package name */
        final Object f6682a;

        public RangeInfoCompat(int i2, float f2, float f3, float f4) {
            this.f6682a = Build.VERSION.SDK_INT >= 30 ? Api30Impl.a(i2, f2, f3, f4) : AccessibilityNodeInfo.RangeInfo.obtain(i2, f2, f3, f4);
        }

        public static RangeInfoCompat e(int i2, float f2, float f3, float f4) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(i2, f2, f3, f4));
        }

        public float a() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f6682a).getCurrent();
        }

        public float b() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f6682a).getMax();
        }

        public float c() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f6682a).getMin();
        }

        public int d() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f6682a).getType();
        }

        RangeInfoCompat(Object obj) {
            this.f6682a = obj;
        }
    }

    public static final class TouchDelegateInfoCompat {

        /* renamed from: a  reason: collision with root package name */
        final AccessibilityNodeInfo.TouchDelegateInfo f6683a;

        TouchDelegateInfoCompat(@NonNull AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
            this.f6683a = touchDelegateInfo;
        }

        @Nullable
        public Region a(@IntRange(from = 0) int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.f6683a.getRegionAt(i2);
            }
            return null;
        }

        @IntRange(from = 0)
        public int b() {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.f6683a.getRegionCount();
            }
            return 0;
        }

        @Nullable
        public AccessibilityNodeInfoCompat c(@NonNull Region region) {
            AccessibilityNodeInfo a2;
            if (Build.VERSION.SDK_INT < 29 || (a2 = this.f6683a.getTargetForRegion(region)) == null) {
                return null;
            }
            return AccessibilityNodeInfoCompat.r2(a2);
        }

        public TouchDelegateInfoCompat(@NonNull Map<Region, View> map) {
            this.f6683a = Build.VERSION.SDK_INT >= 29 ? d0.a(map) : null;
        }
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f6649a = accessibilityNodeInfo;
    }

    public static AccessibilityNodeInfoCompat N0() {
        return r2(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat O0(View view) {
        return r2(AccessibilityNodeInfo.obtain(view));
    }

    public static AccessibilityNodeInfoCompat P0(View view, int i2) {
        return s2(AccessibilityNodeInfo.obtain(view, i2));
    }

    public static AccessibilityNodeInfoCompat Q0(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return r2(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.f6649a));
    }

    private SparseArray<WeakReference<ClickableSpan>> R(View view) {
        SparseArray<WeakReference<ClickableSpan>> Y2 = Y(view);
        if (Y2 != null) {
            return Y2;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(R.id.g0, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> Y(View view) {
        return (SparseArray) view.getTag(R.id.g0);
    }

    private void Y0(View view) {
        SparseArray<WeakReference<ClickableSpan>> Y2 = Y(view);
        if (Y2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < Y2.size(); i2++) {
                if (Y2.valueAt(i2).get() == null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Y2.remove(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    private void c1(int i2, boolean z2) {
        Bundle H2 = H();
        if (H2 != null) {
            int i3 = H2.getInt(f6642h, 0) & (~i2);
            if (!z2) {
                i2 = 0;
            }
            H2.putInt(f6642h, i2 | i3);
        }
    }

    private void e(ClickableSpan clickableSpan, Spanned spanned, int i2) {
        i(f6644j).add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        i(f6645k).add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        i(f6646l).add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        i(f6643i).add(Integer.valueOf(i2));
    }

    private void h() {
        this.f6649a.getExtras().remove(f6644j);
        this.f6649a.getExtras().remove(f6645k);
        this.f6649a.getExtras().remove(f6646l);
        this.f6649a.getExtras().remove(f6643i);
    }

    private List<Integer> i(String str) {
        ArrayList<Integer> integerArrayList = this.f6649a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f6649a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private boolean m0() {
        return !i(f6644j).isEmpty();
    }

    private int n0(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i2).get())) {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = C0;
        C0 = i3 + 1;
        return i3;
    }

    static String o(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            case 16908382:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i2) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i2) {
                                    case 16908372:
                                        return "ACTION_IME_ENTER";
                                    case 16908373:
                                        return "ACTION_DRAG_START";
                                    case 16908374:
                                        return "ACTION_DRAG_DROP";
                                    case 16908375:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    private boolean r(int i2) {
        Bundle H2 = H();
        return H2 != null && (H2.getInt(f6642h, 0) & i2) == i2;
    }

    public static AccessibilityNodeInfoCompat r2(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    static AccessibilityNodeInfoCompat s2(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] z(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public CollectionInfoCompat A() {
        AccessibilityNodeInfo.CollectionInfo collectionInfo = this.f6649a.getCollectionInfo();
        if (collectionInfo != null) {
            return new CollectionInfoCompat(collectionInfo);
        }
        return null;
    }

    public boolean A0() {
        return r(67108864);
    }

    public void A1(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6649a.setHintText(charSequence);
        } else {
            this.f6649a.getExtras().putCharSequence(f6641g, charSequence);
        }
    }

    public CollectionItemInfoCompat B() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.f6649a.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            return new CollectionItemInfoCompat(collectionItemInfo);
        }
        return null;
    }

    public boolean B0() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.f6649a.isHeading();
        }
        if (r(2)) {
            return true;
        }
        CollectionItemInfoCompat B2 = B();
        return B2 != null && B2.g();
    }

    public void B1(boolean z2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f6649a.setImportantForAccessibility(z2);
        }
    }

    @Nullable
    public CharSequence C() {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.c(this.f6649a) : this.f6649a.getExtras().getCharSequence(p);
    }

    public boolean C0() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f6649a.isImportantForAccessibility();
        }
        return true;
    }

    public void C1(int i2) {
        this.f6649a.setInputType(i2);
    }

    public CharSequence D() {
        return this.f6649a.getContentDescription();
    }

    public boolean D0() {
        return this.f6649a.isLongClickable();
    }

    public void D1(View view) {
        this.f6649a.setLabelFor(view);
    }

    public int E() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f6649a.getDrawingOrder();
        }
        return 0;
    }

    public boolean E0() {
        return this.f6649a.isMultiLine();
    }

    public void E1(View view, int i2) {
        this.f6649a.setLabelFor(view, i2);
    }

    public CharSequence F() {
        return this.f6649a.getError();
    }

    public boolean F0() {
        return this.f6649a.isPassword();
    }

    public void F1(View view) {
        this.f6649a.setLabeledBy(view);
    }

    @Nullable
    public AccessibilityNodeInfo.ExtraRenderingInfo G() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.e(this.f6649a);
        }
        return null;
    }

    public boolean G0() {
        return Build.VERSION.SDK_INT >= 28 ? this.f6649a.isScreenReaderFocusable() : r(1);
    }

    public void G1(View view, int i2) {
        this.f6649a.setLabeledBy(view, i2);
    }

    public Bundle H() {
        return this.f6649a.getExtras();
    }

    public boolean H0() {
        return this.f6649a.isScrollable();
    }

    public void H1(int i2) {
        this.f6649a.setLiveRegion(i2);
    }

    @Nullable
    public CharSequence I() {
        return Build.VERSION.SDK_INT >= 26 ? this.f6649a.getHintText() : this.f6649a.getExtras().getCharSequence(f6641g);
    }

    public boolean I0() {
        return this.f6649a.isSelected();
    }

    public void I1(boolean z2) {
        this.f6649a.setLongClickable(z2);
    }

    @Deprecated
    public Object J() {
        return this.f6649a;
    }

    public boolean J0() {
        return Build.VERSION.SDK_INT >= 26 ? this.f6649a.isShowingHintText() : r(4);
    }

    public void J1(int i2) {
        this.f6649a.setMaxTextLength(i2);
    }

    public int K() {
        return this.f6649a.getInputType();
    }

    public boolean K0() {
        return Build.VERSION.SDK_INT >= 29 ? this.f6649a.isTextEntryKey() : r(8);
    }

    public void K1(long j2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.j(this.f6649a, j2);
        } else {
            this.f6649a.getExtras().putLong(r, j2);
        }
    }

    public AccessibilityNodeInfoCompat L() {
        return s2(this.f6649a.getLabelFor());
    }

    public boolean L0() {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.h(this.f6649a) : r(8388608);
    }

    public void L1(int i2) {
        this.f6649a.setMovementGranularities(i2);
    }

    public AccessibilityNodeInfoCompat M() {
        return s2(this.f6649a.getLabeledBy());
    }

    public boolean M0() {
        return this.f6649a.isVisibleToUser();
    }

    public void M1(boolean z2) {
        this.f6649a.setMultiLine(z2);
    }

    public int N() {
        return this.f6649a.getLiveRegion();
    }

    public void N1(CharSequence charSequence) {
        this.f6649a.setPackageName(charSequence);
    }

    public int O() {
        return this.f6649a.getMaxTextLength();
    }

    public void O1(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6649a.setPaneTitle(charSequence);
        } else {
            this.f6649a.getExtras().putCharSequence(f6639e, charSequence);
        }
    }

    public long P() {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.d(this.f6649a) : this.f6649a.getExtras().getLong(r);
    }

    public void P1(View view) {
        this.f6650b = -1;
        this.f6649a.setParent(view);
    }

    public int Q() {
        return this.f6649a.getMovementGranularities();
    }

    public void Q1(View view, int i2) {
        this.f6650b = i2;
        this.f6649a.setParent(view, i2);
    }

    public boolean R0(int i2) {
        return this.f6649a.performAction(i2);
    }

    public void R1(boolean z2) {
        this.f6649a.setPassword(z2);
    }

    public CharSequence S() {
        return this.f6649a.getPackageName();
    }

    public boolean S0(int i2, Bundle bundle) {
        return this.f6649a.performAction(i2, bundle);
    }

    public void S1(@NonNull View view, boolean z2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.k(this.f6649a, view, z2);
        }
    }

    @Nullable
    public CharSequence T() {
        return Build.VERSION.SDK_INT >= 28 ? this.f6649a.getPaneTitle() : this.f6649a.getExtras().getCharSequence(f6639e);
    }

    @Deprecated
    public void T0() {
    }

    public void T1(RangeInfoCompat rangeInfoCompat) {
        this.f6649a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) rangeInfoCompat.f6682a);
    }

    public AccessibilityNodeInfoCompat U() {
        return s2(this.f6649a.getParent());
    }

    public boolean U0() {
        return this.f6649a.refresh();
    }

    @SuppressLint({"GetterSetterNames"})
    public void U1(boolean z2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.l(this.f6649a, z2);
        } else {
            c1(32, z2);
        }
    }

    @Nullable
    public AccessibilityNodeInfoCompat V(int i2) {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.f(this.f6649a, i2) : U();
    }

    public boolean V0(AccessibilityActionCompat accessibilityActionCompat) {
        return this.f6649a.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f6662a);
    }

    public void V1(@Nullable CharSequence charSequence) {
        this.f6649a.getExtras().putCharSequence(f6638d, charSequence);
    }

    public RangeInfoCompat W() {
        AccessibilityNodeInfo.RangeInfo rangeInfo = this.f6649a.getRangeInfo();
        if (rangeInfo != null) {
            return new RangeInfoCompat(rangeInfo);
        }
        return null;
    }

    public boolean W0(View view) {
        return this.f6649a.removeChild(view);
    }

    public void W1(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6649a.setScreenReaderFocusable(z2);
        } else {
            c1(1, z2);
        }
    }

    @Nullable
    public CharSequence X() {
        return this.f6649a.getExtras().getCharSequence(f6638d);
    }

    public boolean X0(View view, int i2) {
        return this.f6649a.removeChild(view, i2);
    }

    public void X1(boolean z2) {
        this.f6649a.setScrollable(z2);
    }

    public void Y1(boolean z2) {
        this.f6649a.setSelected(z2);
    }

    @Nullable
    public CharSequence Z() {
        return Build.VERSION.SDK_INT >= 30 ? Api30Impl.b(this.f6649a) : this.f6649a.getExtras().getCharSequence(f6648n);
    }

    public void Z0(boolean z2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.g(this.f6649a, z2);
        } else {
            c1(64, z2);
        }
    }

    public void Z1(boolean z2) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6649a.setShowingHintText(z2);
        } else {
            c1(4, z2);
        }
    }

    public void a(int i2) {
        this.f6649a.addAction(i2);
    }

    public CharSequence a0() {
        if (!m0()) {
            return this.f6649a.getText();
        }
        List<Integer> i2 = i(f6644j);
        List<Integer> i3 = i(f6645k);
        List<Integer> i4 = i(f6646l);
        List<Integer> i5 = i(f6643i);
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f6649a.getText(), 0, this.f6649a.getText().length()));
        for (int i6 = 0; i6 < i2.size(); i6++) {
            spannableString.setSpan(new AccessibilityClickableSpanCompat(i5.get(i6).intValue(), this, H().getInt(f6647m)), i2.get(i6).intValue(), i3.get(i6).intValue(), i4.get(i6).intValue());
        }
        return spannableString;
    }

    public void a1(boolean z2) {
        this.f6649a.setAccessibilityFocused(z2);
    }

    public void a2(View view) {
        this.f6651c = -1;
        this.f6649a.setSource(view);
    }

    public void b(AccessibilityActionCompat accessibilityActionCompat) {
        this.f6649a.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f6662a);
    }

    public int b0() {
        return this.f6649a.getTextSelectionEnd();
    }

    public void b1(@NonNull List<String> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6649a.setAvailableExtraData(list);
        }
    }

    public void b2(View view, int i2) {
        this.f6651c = i2;
        this.f6649a.setSource(view, i2);
    }

    public void c(View view) {
        this.f6649a.addChild(view);
    }

    public int c0() {
        return this.f6649a.getTextSelectionStart();
    }

    public void c2(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.c(this.f6649a, charSequence);
        } else {
            this.f6649a.getExtras().putCharSequence(f6648n, charSequence);
        }
    }

    public void d(View view, int i2) {
        this.f6649a.addChild(view, i2);
    }

    @Nullable
    public CharSequence d0() {
        return Build.VERSION.SDK_INT >= 28 ? this.f6649a.getTooltipText() : this.f6649a.getExtras().getCharSequence(f6640f);
    }

    @Deprecated
    public void d1(Rect rect) {
        this.f6649a.setBoundsInParent(rect);
    }

    public void d2(CharSequence charSequence) {
        this.f6649a.setText(charSequence);
    }

    @Nullable
    public TouchDelegateInfoCompat e0() {
        AccessibilityNodeInfo.TouchDelegateInfo a2;
        if (Build.VERSION.SDK_INT < 29 || (a2 = this.f6649a.getTouchDelegateInfo()) == null) {
            return null;
        }
        return new TouchDelegateInfoCompat(a2);
    }

    public void e1(Rect rect) {
        this.f6649a.setBoundsInScreen(rect);
    }

    public void e2(boolean z2) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f6649a.setTextEntryKey(z2);
        } else {
            c1(8, z2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f6649a;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfoCompat.f6649a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.f6649a)) {
            return false;
        }
        return this.f6651c == accessibilityNodeInfoCompat.f6651c && this.f6650b == accessibilityNodeInfoCompat.f6650b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void f(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            h();
            Y0(view);
            ClickableSpan[] z2 = z(charSequence);
            if (z2 != null && z2.length > 0) {
                H().putInt(f6647m, R.id.f5145a);
                SparseArray<WeakReference<ClickableSpan>> R2 = R(view);
                for (int i2 = 0; i2 < z2.length; i2++) {
                    int n02 = n0(z2[i2], R2);
                    R2.put(n02, new WeakReference(z2[i2]));
                    e(z2[i2], (Spanned) charSequence, n02);
                }
            }
        }
    }

    public AccessibilityNodeInfoCompat f0() {
        if (Build.VERSION.SDK_INT >= 22) {
            return s2(this.f6649a.getTraversalAfter());
        }
        return null;
    }

    public void f1(@NonNull Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.h(this.f6649a, rect);
        } else {
            this.f6649a.getExtras().putParcelable(q, rect);
        }
    }

    public void f2(boolean z2) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.i(this.f6649a, z2);
        } else {
            c1(8388608, z2);
        }
    }

    public boolean g() {
        return this.f6649a.canOpenPopup();
    }

    public AccessibilityNodeInfoCompat g0() {
        if (Build.VERSION.SDK_INT >= 22) {
            return s2(this.f6649a.getTraversalBefore());
        }
        return null;
    }

    public void g1(boolean z2) {
        this.f6649a.setCanOpenPopup(z2);
    }

    public void g2(int i2, int i3) {
        this.f6649a.setTextSelection(i2, i3);
    }

    @Nullable
    public String h0() {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.g(this.f6649a) : this.f6649a.getExtras().getString(o);
    }

    public void h1(boolean z2) {
        this.f6649a.setCheckable(z2);
    }

    public void h2(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6649a.setTooltipText(charSequence);
        } else {
            this.f6649a.getExtras().putCharSequence(f6640f, charSequence);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f6649a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public String i0() {
        return this.f6649a.getViewIdResourceName();
    }

    public void i1(boolean z2) {
        this.f6649a.setChecked(z2);
    }

    public void i2(@NonNull TouchDelegateInfoCompat touchDelegateInfoCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f6649a.setTouchDelegateInfo(touchDelegateInfoCompat.f6683a);
        }
    }

    public List<AccessibilityNodeInfoCompat> j(String str) {
        ArrayList arrayList = new ArrayList();
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = this.f6649a.findAccessibilityNodeInfosByText(str);
        int size = findAccessibilityNodeInfosByText.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(r2(findAccessibilityNodeInfosByText.get(i2)));
        }
        return arrayList;
    }

    public AccessibilityWindowInfoCompat j0() {
        return AccessibilityWindowInfoCompat.y(this.f6649a.getWindow());
    }

    public void j1(CharSequence charSequence) {
        this.f6649a.setClassName(charSequence);
    }

    public void j2(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f6649a.setTraversalAfter(view);
        }
    }

    public List<AccessibilityNodeInfoCompat> k(String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = this.f6649a.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        for (AccessibilityNodeInfo r2 : findAccessibilityNodeInfosByViewId) {
            arrayList.add(r2(r2));
        }
        return arrayList;
    }

    public int k0() {
        return this.f6649a.getWindowId();
    }

    public void k1(boolean z2) {
        this.f6649a.setClickable(z2);
    }

    public void k2(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f6649a.setTraversalAfter(view, i2);
        }
    }

    public AccessibilityNodeInfoCompat l(int i2) {
        return s2(this.f6649a.findFocus(i2));
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean l0() {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.e(this.f6649a) : r(32);
    }

    public void l1(Object obj) {
        this.f6649a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) obj).f6669a);
    }

    public void l2(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f6649a.setTraversalBefore(view);
        }
    }

    public AccessibilityNodeInfoCompat m(int i2) {
        return s2(this.f6649a.focusSearch(i2));
    }

    public void m1(Object obj) {
        this.f6649a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).f6670a);
    }

    public void m2(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.f6649a.setTraversalBefore(view, i2);
        }
    }

    public List<AccessibilityActionCompat> n() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f6649a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new AccessibilityActionCompat(actionList.get(i2)));
        }
        return arrayList;
    }

    public void n1(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.i(this.f6649a, charSequence);
        } else {
            this.f6649a.getExtras().putCharSequence(p, charSequence);
        }
    }

    public void n2(@Nullable String str) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.j(this.f6649a, str);
        } else {
            this.f6649a.getExtras().putString(o, str);
        }
    }

    public boolean o0() {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.f(this.f6649a) : r(64);
    }

    public void o1(CharSequence charSequence) {
        this.f6649a.setContentDescription(charSequence);
    }

    public void o2(String str) {
        this.f6649a.setViewIdResourceName(str);
    }

    @Deprecated
    public int p() {
        return this.f6649a.getActions();
    }

    public boolean p0() {
        return this.f6649a.isAccessibilityFocused();
    }

    public void p1(boolean z2) {
        this.f6649a.setContentInvalid(z2);
    }

    public void p2(boolean z2) {
        this.f6649a.setVisibleToUser(z2);
    }

    @NonNull
    public List<String> q() {
        return Build.VERSION.SDK_INT >= 26 ? this.f6649a.getAvailableExtraData() : Collections.emptyList();
    }

    public boolean q0() {
        return this.f6649a.isCheckable();
    }

    public void q1(boolean z2) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f6649a.setContextClickable(z2);
        }
    }

    public AccessibilityNodeInfo q2() {
        return this.f6649a;
    }

    public boolean r0() {
        return this.f6649a.isChecked();
    }

    public void r1(boolean z2) {
        this.f6649a.setDismissable(z2);
    }

    @Deprecated
    public void s(Rect rect) {
        this.f6649a.getBoundsInParent(rect);
    }

    public boolean s0() {
        return this.f6649a.isClickable();
    }

    public void s1(int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f6649a.setDrawingOrder(i2);
        }
    }

    public void t(Rect rect) {
        this.f6649a.getBoundsInScreen(rect);
    }

    public boolean t0() {
        return this.f6649a.isContentInvalid();
    }

    public void t1(boolean z2) {
        this.f6649a.setEditable(z2);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        s(rect);
        sb.append("; boundsInParent: " + rect);
        t(rect);
        sb.append("; boundsInScreen: " + rect);
        u(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(S());
        sb.append("; className: ");
        sb.append(y());
        sb.append("; text: ");
        sb.append(a0());
        sb.append("; error: ");
        sb.append(F());
        sb.append("; maxTextLength: ");
        sb.append(O());
        sb.append("; stateDescription: ");
        sb.append(Z());
        sb.append("; contentDescription: ");
        sb.append(D());
        sb.append("; tooltipText: ");
        sb.append(d0());
        sb.append("; viewIdResName: ");
        sb.append(i0());
        sb.append("; uniqueId: ");
        sb.append(h0());
        sb.append("; checkable: ");
        sb.append(q0());
        sb.append("; checked: ");
        sb.append(r0());
        sb.append("; focusable: ");
        sb.append(y0());
        sb.append("; focused: ");
        sb.append(z0());
        sb.append("; selected: ");
        sb.append(I0());
        sb.append("; clickable: ");
        sb.append(s0());
        sb.append("; longClickable: ");
        sb.append(D0());
        sb.append("; contextClickable: ");
        sb.append(u0());
        sb.append("; enabled: ");
        sb.append(x0());
        sb.append("; password: ");
        sb.append(F0());
        sb.append("; scrollable: " + H0());
        sb.append("; containerTitle: ");
        sb.append(C());
        sb.append("; granularScrollingSupported: ");
        sb.append(A0());
        sb.append("; importantForAccessibility: ");
        sb.append(C0());
        sb.append("; visible: ");
        sb.append(M0());
        sb.append("; isTextSelectable: ");
        sb.append(L0());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(o0());
        sb.append("; [");
        List<AccessibilityActionCompat> n2 = n();
        for (int i2 = 0; i2 < n2.size(); i2++) {
            AccessibilityActionCompat accessibilityActionCompat = n2.get(i2);
            String o2 = o(accessibilityActionCompat.b());
            if (o2.equals("ACTION_UNKNOWN") && accessibilityActionCompat.c() != null) {
                o2 = accessibilityActionCompat.c().toString();
            }
            sb.append(o2);
            if (i2 != n2.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void u(@NonNull Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.b(this.f6649a, rect);
            return;
        }
        Rect rect2 = (Rect) this.f6649a.getExtras().getParcelable(q);
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public boolean u0() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.f6649a.isContextClickable();
        }
        return false;
    }

    public void u1(boolean z2) {
        this.f6649a.setEnabled(z2);
    }

    public AccessibilityNodeInfoCompat v(int i2) {
        return s2(this.f6649a.getChild(i2));
    }

    public boolean v0() {
        return this.f6649a.isDismissable();
    }

    public void v1(CharSequence charSequence) {
        this.f6649a.setError(charSequence);
    }

    @Nullable
    public AccessibilityNodeInfoCompat w(int i2, int i3) {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.b(this.f6649a, i2, i3) : v(i2);
    }

    public boolean w0() {
        return this.f6649a.isEditable();
    }

    public void w1(boolean z2) {
        this.f6649a.setFocusable(z2);
    }

    public int x() {
        return this.f6649a.getChildCount();
    }

    public boolean x0() {
        return this.f6649a.isEnabled();
    }

    public void x1(boolean z2) {
        this.f6649a.setFocused(z2);
    }

    public CharSequence y() {
        return this.f6649a.getClassName();
    }

    public boolean y0() {
        return this.f6649a.isFocusable();
    }

    public void y1(boolean z2) {
        c1(67108864, z2);
    }

    public boolean z0() {
        return this.f6649a.isFocused();
    }

    public void z1(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f6649a.setHeading(z2);
        } else {
            c1(2, z2);
        }
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object obj) {
        this.f6649a = (AccessibilityNodeInfo) obj;
    }
}
