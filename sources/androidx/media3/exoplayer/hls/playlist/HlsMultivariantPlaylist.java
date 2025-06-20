package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class HlsMultivariantPlaylist extends HlsPlaylist {

    /* renamed from: n  reason: collision with root package name */
    public static final HlsMultivariantPlaylist f11576n = new HlsMultivariantPlaylist("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (Format) null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 2;

    /* renamed from: d  reason: collision with root package name */
    public final List<Uri> f11577d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Variant> f11578e;

    /* renamed from: f  reason: collision with root package name */
    public final List<Rendition> f11579f;

    /* renamed from: g  reason: collision with root package name */
    public final List<Rendition> f11580g;

    /* renamed from: h  reason: collision with root package name */
    public final List<Rendition> f11581h;

    /* renamed from: i  reason: collision with root package name */
    public final List<Rendition> f11582i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public final Format f11583j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public final List<Format> f11584k;

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, String> f11585l;

    /* renamed from: m  reason: collision with root package name */
    public final List<DrmInitData> f11586m;

    public static final class Rendition {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final Uri f11587a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f11588b;

        /* renamed from: c  reason: collision with root package name */
        public final String f11589c;

        /* renamed from: d  reason: collision with root package name */
        public final String f11590d;

        public Rendition(@Nullable Uri uri, Format format, String str, String str2) {
            this.f11587a = uri;
            this.f11588b = format;
            this.f11589c = str;
            this.f11590d = str2;
        }
    }

    public static final class Variant {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f11591a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f11592b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public final String f11593c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final String f11594d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public final String f11595e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public final String f11596f;

        public Variant(Uri uri, Format format, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.f11591a = uri;
            this.f11592b = format;
            this.f11593c = str;
            this.f11594d = str2;
            this.f11595e = str3;
            this.f11596f = str4;
        }

        public static Variant b(Uri uri) {
            return new Variant(uri, new Format.Builder().X("0").O(MimeTypes.t0).I(), (String) null, (String) null, (String) null, (String) null);
        }

        public Variant a(Format format) {
            return new Variant(this.f11591a, format, this.f11593c, this.f11594d, this.f11595e, this.f11596f);
        }
    }

    public HlsMultivariantPlaylist(String str, List<String> list, List<Variant> list2, List<Rendition> list3, List<Rendition> list4, List<Rendition> list5, List<Rendition> list6, @Nullable Format format, @Nullable List<Format> list7, boolean z, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, z);
        this.f11577d = Collections.unmodifiableList(f(list2, list3, list4, list5, list6));
        this.f11578e = Collections.unmodifiableList(list2);
        this.f11579f = Collections.unmodifiableList(list3);
        this.f11580g = Collections.unmodifiableList(list4);
        this.f11581h = Collections.unmodifiableList(list5);
        this.f11582i = Collections.unmodifiableList(list6);
        this.f11583j = format;
        this.f11584k = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f11585l = Collections.unmodifiableMap(map);
        this.f11586m = Collections.unmodifiableList(list8);
    }

    private static void b(List<Rendition> list, List<Uri> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Uri uri = list.get(i2).f11587a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    private static <T> List<T> d(List<T> list, int i2, List<StreamKey> list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            T t = list.get(i3);
            int i4 = 0;
            while (true) {
                if (i4 >= list2.size()) {
                    break;
                }
                StreamKey streamKey = list2.get(i4);
                if (streamKey.X == i2 && streamKey.Y == i3) {
                    arrayList.add(t);
                    break;
                }
                i4++;
            }
        }
        return arrayList;
    }

    public static HlsMultivariantPlaylist e(String str) {
        return new HlsMultivariantPlaylist("", Collections.emptyList(), Collections.singletonList(Variant.b(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (Format) null, (List<Format>) null, false, Collections.emptyMap(), Collections.emptyList());
    }

    private static List<Uri> f(List<Variant> list, List<Rendition> list2, List<Rendition> list3, List<Rendition> list4, List<Rendition> list5) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Uri uri = list.get(i2).f11591a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list2, arrayList);
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        return arrayList;
    }

    /* renamed from: c */
    public HlsMultivariantPlaylist a(List<StreamKey> list) {
        return new HlsMultivariantPlaylist(this.f11597a, this.f11598b, d(this.f11578e, 0, list), Collections.emptyList(), d(this.f11580g, 1, list), d(this.f11581h, 2, list), Collections.emptyList(), this.f11583j, this.f11584k, this.f11599c, this.f11585l, this.f11586m);
    }
}
