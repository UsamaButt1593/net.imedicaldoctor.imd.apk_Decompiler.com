package androidx.media3.exoplayer.upstream;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

@UnstableApi
public final class CmcdData {

    /* renamed from: f  reason: collision with root package name */
    private static final Joiner f12460f = Joiner.p(",");

    /* renamed from: a  reason: collision with root package name */
    private final CmcdObject f12461a;

    /* renamed from: b  reason: collision with root package name */
    private final CmcdRequest f12462b;

    /* renamed from: c  reason: collision with root package name */
    private final CmcdSession f12463c;

    /* renamed from: d  reason: collision with root package name */
    private final CmcdStatus f12464d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12465e;

    private static final class CmcdObject {

        /* renamed from: a  reason: collision with root package name */
        public final int f12466a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12467b;

        /* renamed from: c  reason: collision with root package name */
        public final long f12468c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final String f12469d;

        /* renamed from: e  reason: collision with root package name */
        public final ImmutableList<String> f12470e;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public int f12471a = C.f9088f;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public int f12472b = C.f9088f;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public long f12473c = C.f9084b;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: d  reason: collision with root package name */
            public String f12474d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public ImmutableList<String> f12475e = ImmutableList.I();

            public CmcdObject f() {
                return new CmcdObject(this);
            }

            @CanIgnoreReturnValue
            public Builder g(int i2) {
                Assertions.a(i2 >= 0 || i2 == -2147483647);
                this.f12471a = i2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder h(List<String> list) {
                this.f12475e = ImmutableList.B(list);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder i(long j2) {
                Assertions.a(j2 >= 0 || j2 == C.f9084b);
                this.f12473c = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder j(@Nullable String str) {
                this.f12474d = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder k(int i2) {
                Assertions.a(i2 >= 0 || i2 == -2147483647);
                this.f12472b = i2;
                return this;
            }
        }

        private CmcdObject(Builder builder) {
            this.f12466a = builder.f12471a;
            this.f12467b = builder.f12472b;
            this.f12468c = builder.f12473c;
            this.f12469d = builder.f12474d;
            this.f12470e = builder.f12475e;
        }

        public void a(ArrayListMultimap<String, String> arrayListMultimap) {
            ArrayList arrayList = new ArrayList();
            if (this.f12466a != -2147483647) {
                arrayList.add("br=" + this.f12466a);
            }
            if (this.f12467b != -2147483647) {
                arrayList.add("tb=" + this.f12467b);
            }
            if (this.f12468c != C.f9084b) {
                arrayList.add("d=" + this.f12468c);
            }
            if (!TextUtils.isEmpty(this.f12469d)) {
                arrayList.add("ot=" + this.f12469d);
            }
            arrayList.addAll(this.f12470e);
            if (!arrayList.isEmpty()) {
                arrayListMultimap.T0(CmcdConfiguration.f12446f, arrayList);
            }
        }
    }

    private static final class CmcdRequest {

        /* renamed from: a  reason: collision with root package name */
        public final long f12476a;

        /* renamed from: b  reason: collision with root package name */
        public final long f12477b;

        /* renamed from: c  reason: collision with root package name */
        public final long f12478c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f12479d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public final String f12480e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public final String f12481f;

        /* renamed from: g  reason: collision with root package name */
        public final ImmutableList<String> f12482g;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public long f12483a = C.f9084b;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public long f12484b = -2147483647L;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public long f12485c = C.f9084b;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public boolean f12486d;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: e  reason: collision with root package name */
            public String f12487e;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: f  reason: collision with root package name */
            public String f12488f;
            /* access modifiers changed from: private */

            /* renamed from: g  reason: collision with root package name */
            public ImmutableList<String> f12489g = ImmutableList.I();

            public CmcdRequest h() {
                return new CmcdRequest(this);
            }

            @CanIgnoreReturnValue
            public Builder i(long j2) {
                Assertions.a(j2 >= 0 || j2 == C.f9084b);
                this.f12483a = ((j2 + 50) / 100) * 100;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder j(List<String> list) {
                this.f12489g = ImmutableList.B(list);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder k(long j2) {
                Assertions.a(j2 >= 0 || j2 == C.f9084b);
                this.f12485c = ((j2 + 50) / 100) * 100;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder l(long j2) {
                Assertions.a(j2 >= 0 || j2 == -2147483647L);
                this.f12484b = ((j2 + 50) / 100) * 100;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder m(@Nullable String str) {
                this.f12487e = str == null ? null : Uri.encode(str);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder n(@Nullable String str) {
                this.f12488f = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder o(boolean z) {
                this.f12486d = z;
                return this;
            }
        }

        private CmcdRequest(Builder builder) {
            this.f12476a = builder.f12483a;
            this.f12477b = builder.f12484b;
            this.f12478c = builder.f12485c;
            this.f12479d = builder.f12486d;
            this.f12480e = builder.f12487e;
            this.f12481f = builder.f12488f;
            this.f12482g = builder.f12489g;
        }

        public void a(ArrayListMultimap<String, String> arrayListMultimap) {
            ArrayList arrayList = new ArrayList();
            if (this.f12476a != C.f9084b) {
                arrayList.add("bl=" + this.f12476a);
            }
            if (this.f12477b != -2147483647L) {
                arrayList.add("mtp=" + this.f12477b);
            }
            if (this.f12478c != C.f9084b) {
                arrayList.add("dl=" + this.f12478c);
            }
            if (this.f12479d) {
                arrayList.add(CmcdConfiguration.z);
            }
            if (!TextUtils.isEmpty(this.f12480e)) {
                arrayList.add(Util.S("%s=\"%s\"", CmcdConfiguration.A, this.f12480e));
            }
            if (!TextUtils.isEmpty(this.f12481f)) {
                arrayList.add(Util.S("%s=\"%s\"", CmcdConfiguration.B, this.f12481f));
            }
            arrayList.addAll(this.f12482g);
            if (!arrayList.isEmpty()) {
                arrayListMultimap.T0(CmcdConfiguration.f12447g, arrayList);
            }
        }
    }

    private static final class CmcdSession {

        /* renamed from: g  reason: collision with root package name */
        public static final int f12490g = 1;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final String f12491a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final String f12492b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public final String f12493c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final String f12494d;

        /* renamed from: e  reason: collision with root package name */
        public final float f12495e;

        /* renamed from: f  reason: collision with root package name */
        public final ImmutableList<String> f12496f;

        public static final class Builder {
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: a  reason: collision with root package name */
            public String f12497a;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            public String f12498b;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            public String f12499c;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: d  reason: collision with root package name */
            public String f12500d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public float f12501e;
            /* access modifiers changed from: private */

            /* renamed from: f  reason: collision with root package name */
            public ImmutableList<String> f12502f = ImmutableList.I();

            public CmcdSession g() {
                return new CmcdSession(this);
            }

            @CanIgnoreReturnValue
            public Builder h(@Nullable String str) {
                Assertions.a(str == null || str.length() <= 64);
                this.f12497a = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder i(List<String> list) {
                this.f12502f = ImmutableList.B(list);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder j(float f2) {
                Assertions.a(f2 > 0.0f || f2 == -3.4028235E38f);
                this.f12501e = f2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder k(@Nullable String str) {
                Assertions.a(str == null || str.length() <= 64);
                this.f12498b = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder l(@Nullable String str) {
                this.f12500d = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder m(@Nullable String str) {
                this.f12499c = str;
                return this;
            }
        }

        private CmcdSession(Builder builder) {
            this.f12491a = builder.f12497a;
            this.f12492b = builder.f12498b;
            this.f12493c = builder.f12499c;
            this.f12494d = builder.f12500d;
            this.f12495e = builder.f12501e;
            this.f12496f = builder.f12502f;
        }

        public void a(ArrayListMultimap<String, String> arrayListMultimap) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.f12491a)) {
                arrayList.add(Util.S("%s=\"%s\"", CmcdConfiguration.f12453m, this.f12491a));
            }
            if (!TextUtils.isEmpty(this.f12492b)) {
                arrayList.add(Util.S("%s=\"%s\"", CmcdConfiguration.f12454n, this.f12492b));
            }
            if (!TextUtils.isEmpty(this.f12493c)) {
                arrayList.add("sf=" + this.f12493c);
            }
            if (!TextUtils.isEmpty(this.f12494d)) {
                arrayList.add("st=" + this.f12494d);
            }
            float f2 = this.f12495e;
            if (!(f2 == -3.4028235E38f || f2 == 1.0f)) {
                arrayList.add(Util.S("%s=%.2f", CmcdConfiguration.y, Float.valueOf(f2)));
            }
            arrayList.addAll(this.f12496f);
            if (!arrayList.isEmpty()) {
                arrayListMultimap.T0(CmcdConfiguration.f12448h, arrayList);
            }
        }
    }

    private static final class CmcdStatus {

        /* renamed from: a  reason: collision with root package name */
        public final int f12503a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f12504b;

        /* renamed from: c  reason: collision with root package name */
        public final ImmutableList<String> f12505c;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public int f12506a = C.f9088f;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public boolean f12507b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public ImmutableList<String> f12508c = ImmutableList.I();

            public CmcdStatus d() {
                return new CmcdStatus(this);
            }

            @CanIgnoreReturnValue
            public Builder e(boolean z) {
                this.f12507b = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder f(List<String> list) {
                this.f12508c = ImmutableList.B(list);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder g(int i2) {
                Assertions.a(i2 >= 0 || i2 == -2147483647);
                if (i2 != -2147483647) {
                    i2 = ((i2 + 50) / 100) * 100;
                }
                this.f12506a = i2;
                return this;
            }
        }

        private CmcdStatus(Builder builder) {
            this.f12503a = builder.f12506a;
            this.f12504b = builder.f12507b;
            this.f12505c = builder.f12508c;
        }

        public void a(ArrayListMultimap<String, String> arrayListMultimap) {
            ArrayList arrayList = new ArrayList();
            if (this.f12503a != -2147483647) {
                arrayList.add("rtp=" + this.f12503a);
            }
            if (this.f12504b) {
                arrayList.add(CmcdConfiguration.w);
            }
            arrayList.addAll(this.f12505c);
            if (!arrayList.isEmpty()) {
                arrayListMultimap.T0(CmcdConfiguration.f12449i, arrayList);
            }
        }
    }

    public static final class Factory {

        /* renamed from: m  reason: collision with root package name */
        public static final String f12509m = "d";

        /* renamed from: n  reason: collision with root package name */
        public static final String f12510n = "h";
        public static final String o = "s";
        public static final String p = "v";
        public static final String q = "l";
        public static final String r = "i";
        public static final String s = "a";
        public static final String t = "v";
        public static final String u = "av";
        private static final Pattern v = Pattern.compile(".*-.*");

        /* renamed from: a  reason: collision with root package name */
        private final CmcdConfiguration f12511a;

        /* renamed from: b  reason: collision with root package name */
        private final ExoTrackSelection f12512b;

        /* renamed from: c  reason: collision with root package name */
        private final long f12513c;

        /* renamed from: d  reason: collision with root package name */
        private final float f12514d;

        /* renamed from: e  reason: collision with root package name */
        private final String f12515e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f12516f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f12517g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f12518h;

        /* renamed from: i  reason: collision with root package name */
        private long f12519i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private String f12520j;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        private String f12521k;
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        private String f12522l;

        public Factory(CmcdConfiguration cmcdConfiguration, ExoTrackSelection exoTrackSelection, long j2, float f2, String str, boolean z, boolean z2, boolean z3) {
            boolean z4 = false;
            Assertions.a(j2 >= 0);
            Assertions.a(f2 > 0.0f ? true : z4);
            this.f12511a = cmcdConfiguration;
            this.f12512b = exoTrackSelection;
            this.f12513c = j2;
            this.f12514d = f2;
            this.f12515e = str;
            this.f12516f = z;
            this.f12517g = z2;
            this.f12518h = z3;
            this.f12519i = C.f9084b;
        }

        private boolean b() {
            String str = this.f12520j;
            return str != null && str.equals("i");
        }

        @Nullable
        public static String c(ExoTrackSelection exoTrackSelection) {
            Assertions.a(exoTrackSelection != null);
            int l2 = MimeTypes.l(exoTrackSelection.o().f3);
            if (l2 == -1) {
                l2 = MimeTypes.l(exoTrackSelection.o().e3);
            }
            if (l2 == 1) {
                return "a";
            }
            if (l2 == 2) {
                return "v";
            }
            return null;
        }

        private void h(List<String> list) {
            for (String p2 : list) {
                Assertions.i(v.matcher(Util.p2(p2, "=")[0]).matches());
            }
        }

        public CmcdData a() {
            ImmutableListMultimap<String, String> c2 = this.f12511a.f12457c.c();
            UnmodifiableIterator<String> k2 = c2.keySet().iterator();
            while (k2.hasNext()) {
                h(c2.v(k2.next()));
            }
            int q2 = Util.q(this.f12512b.o().b3, 1000);
            CmcdObject.Builder builder = new CmcdObject.Builder();
            boolean z = false;
            if (!b()) {
                if (this.f12511a.a()) {
                    builder.g(q2);
                }
                if (this.f12511a.q()) {
                    TrackGroup d2 = this.f12512b.d();
                    int i2 = this.f12512b.o().b3;
                    for (int i3 = 0; i3 < d2.s; i3++) {
                        i2 = Math.max(i2, d2.d(i3).b3);
                    }
                    builder.k(Util.q(i2, 1000));
                }
                if (this.f12511a.j()) {
                    builder.i(Util.H2(this.f12519i));
                }
            }
            if (this.f12511a.k()) {
                builder.j(this.f12520j);
            }
            if (c2.containsKey(CmcdConfiguration.f12446f)) {
                builder.h(c2.v(CmcdConfiguration.f12446f));
            }
            CmcdRequest.Builder builder2 = new CmcdRequest.Builder();
            if (!b() && this.f12511a.b()) {
                builder2.i(Util.H2(this.f12513c));
            }
            if (this.f12511a.g() && this.f12512b.a() != -2147483647L) {
                builder2.l(Util.r(this.f12512b.a(), 1000));
            }
            if (this.f12511a.e()) {
                builder2.k(Util.H2((long) (((float) this.f12513c) / this.f12514d)));
            }
            if (this.f12511a.n()) {
                if (this.f12517g || this.f12518h) {
                    z = true;
                }
                builder2.o(z);
            }
            if (this.f12511a.h()) {
                builder2.m(this.f12521k);
            }
            if (this.f12511a.i()) {
                builder2.n(this.f12522l);
            }
            if (c2.containsKey(CmcdConfiguration.f12447g)) {
                builder2.j(c2.v(CmcdConfiguration.f12447g));
            }
            CmcdSession.Builder builder3 = new CmcdSession.Builder();
            if (this.f12511a.d()) {
                builder3.h(this.f12511a.f12456b);
            }
            if (this.f12511a.m()) {
                builder3.k(this.f12511a.f12455a);
            }
            if (this.f12511a.p()) {
                builder3.m(this.f12515e);
            }
            if (this.f12511a.o()) {
                builder3.l(this.f12516f ? q : "v");
            }
            if (this.f12511a.l()) {
                builder3.j(this.f12514d);
            }
            if (c2.containsKey(CmcdConfiguration.f12448h)) {
                builder3.i(c2.v(CmcdConfiguration.f12448h));
            }
            CmcdStatus.Builder builder4 = new CmcdStatus.Builder();
            if (this.f12511a.f()) {
                builder4.g(this.f12511a.f12457c.b(q2));
            }
            if (this.f12511a.c()) {
                builder4.e(this.f12517g);
            }
            if (c2.containsKey(CmcdConfiguration.f12449i)) {
                builder4.f(c2.v(CmcdConfiguration.f12449i));
            }
            return new CmcdData(builder.f(), builder2.h(), builder3.g(), builder4.d(), this.f12511a.f12458d);
        }

        @CanIgnoreReturnValue
        public Factory d(long j2) {
            Assertions.a(j2 >= 0);
            this.f12519i = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory e(@Nullable String str) {
            this.f12521k = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory f(@Nullable String str) {
            this.f12522l = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory g(@Nullable String str) {
            this.f12520j = str;
            return this;
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ObjectType {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamingFormat {
    }

    private CmcdData(CmcdObject cmcdObject, CmcdRequest cmcdRequest, CmcdSession cmcdSession, CmcdStatus cmcdStatus, int i2) {
        this.f12461a = cmcdObject;
        this.f12462b = cmcdRequest;
        this.f12463c = cmcdSession;
        this.f12464d = cmcdStatus;
        this.f12465e = i2;
    }

    public DataSpec a(DataSpec dataSpec) {
        ArrayListMultimap J = ArrayListMultimap.J();
        this.f12461a.a(J);
        this.f12462b.a(J);
        this.f12463c.a(J);
        this.f12464d.a(J);
        if (this.f12465e == 0) {
            ImmutableMap.Builder b2 = ImmutableMap.b();
            for (String str : J.keySet()) {
                List list = J.get(str);
                Collections.sort(list);
                b2.i(str, f12460f.k(list));
            }
            return dataSpec.g(b2.d());
        }
        ArrayList arrayList = new ArrayList();
        for (Collection addAll : J.g().values()) {
            arrayList.addAll(addAll);
        }
        Collections.sort(arrayList);
        return dataSpec.a().j(dataSpec.f9779a.buildUpon().appendQueryParameter(CmcdConfiguration.f12450j, f12460f.k(arrayList)).build()).a();
    }
}
