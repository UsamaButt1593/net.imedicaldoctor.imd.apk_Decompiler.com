package androidx.media3.common;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public abstract class SimpleBasePlayer extends BasePlayer {
    private static final long j1 = 1000;
    private final ListenerSet<Player.Listener> c1;
    private final Looper d1;
    private final HandlerWrapper e1;
    private final HashSet<ListenableFuture<?>> f1;
    private final Timeline.Period g1;
    private State h1;
    private boolean i1;

    protected static final class MediaItemData {

        /* renamed from: a  reason: collision with root package name */
        public final Object f9270a;

        /* renamed from: b  reason: collision with root package name */
        public final Tracks f9271b;

        /* renamed from: c  reason: collision with root package name */
        public final MediaItem f9272c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final MediaMetadata f9273d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public final Object f9274e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public final MediaItem.LiveConfiguration f9275f;

        /* renamed from: g  reason: collision with root package name */
        public final long f9276g;

        /* renamed from: h  reason: collision with root package name */
        public final long f9277h;

        /* renamed from: i  reason: collision with root package name */
        public final long f9278i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f9279j;

        /* renamed from: k  reason: collision with root package name */
        public final boolean f9280k;

        /* renamed from: l  reason: collision with root package name */
        public final long f9281l;

        /* renamed from: m  reason: collision with root package name */
        public final long f9282m;

        /* renamed from: n  reason: collision with root package name */
        public final long f9283n;
        public final boolean o;
        public final ImmutableList<PeriodData> p;
        private final long[] q;
        /* access modifiers changed from: private */
        public final MediaMetadata r;

        /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00f1  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0112  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private MediaItemData(androidx.media3.common.SimpleBasePlayer.MediaItemData.Builder r10) {
            /*
                r9 = this;
                r9.<init>()
                androidx.media3.common.MediaItem$LiveConfiguration r0 = r10.f9289f
                r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                r3 = 0
                r4 = 1
                long r5 = r10.f9290g
                if (r0 != 0) goto L_0x0041
                int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x001a
                r0 = 1
                goto L_0x001b
            L_0x001a:
                r0 = 0
            L_0x001b:
                java.lang.String r5 = "presentationStartTimeMs can only be set if liveConfiguration != null"
                androidx.media3.common.util.Assertions.b(r0, r5)
                long r5 = r10.f9291h
                int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x002a
                r0 = 1
                goto L_0x002b
            L_0x002a:
                r0 = 0
            L_0x002b:
                java.lang.String r5 = "windowStartTimeMs can only be set if liveConfiguration != null"
                androidx.media3.common.util.Assertions.b(r0, r5)
                long r5 = r10.f9292i
                int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x003a
                r0 = 1
                goto L_0x003b
            L_0x003a:
                r0 = 0
            L_0x003b:
                java.lang.String r5 = "elapsedRealtimeEpochOffsetMs can only be set if liveConfiguration != null"
            L_0x003d:
                androidx.media3.common.util.Assertions.b(r0, r5)
                goto L_0x005f
            L_0x0041:
                int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x005f
                long r5 = r10.f9291h
                int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x005f
                long r5 = r10.f9291h
                long r7 = r10.f9290g
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r0 < 0) goto L_0x005b
                r0 = 1
                goto L_0x005c
            L_0x005b:
                r0 = 0
            L_0x005c:
                java.lang.String r5 = "windowStartTimeMs can't be less than presentationStartTimeMs"
                goto L_0x003d
            L_0x005f:
                com.google.common.collect.ImmutableList r0 = r10.p
                int r0 = r0.size()
                long r5 = r10.f9296m
                int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r7 == 0) goto L_0x0083
                long r1 = r10.f9295l
                long r5 = r10.f9296m
                int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                if (r7 > 0) goto L_0x007d
                r1 = 1
                goto L_0x007e
            L_0x007d:
                r1 = 0
            L_0x007e:
                java.lang.String r2 = "defaultPositionUs can't be greater than durationUs"
                androidx.media3.common.util.Assertions.b(r1, r2)
            L_0x0083:
                java.lang.Object r1 = r10.f9284a
                r9.f9270a = r1
                androidx.media3.common.Tracks r1 = r10.f9285b
                r9.f9271b = r1
                androidx.media3.common.MediaItem r1 = r10.f9286c
                r9.f9272c = r1
                androidx.media3.common.MediaMetadata r1 = r10.f9287d
                r9.f9273d = r1
                java.lang.Object r1 = r10.f9288e
                r9.f9274e = r1
                androidx.media3.common.MediaItem$LiveConfiguration r1 = r10.f9289f
                r9.f9275f = r1
                long r1 = r10.f9290g
                r9.f9276g = r1
                long r1 = r10.f9291h
                r9.f9277h = r1
                long r1 = r10.f9292i
                r9.f9278i = r1
                boolean r1 = r10.f9293j
                r9.f9279j = r1
                boolean r1 = r10.f9294k
                r9.f9280k = r1
                long r1 = r10.f9295l
                r9.f9281l = r1
                long r1 = r10.f9296m
                r9.f9282m = r1
                long r1 = r10.f9297n
                r9.f9283n = r1
                boolean r5 = r10.o
                r9.o = r5
                com.google.common.collect.ImmutableList r10 = r10.p
                r9.p = r10
                int r5 = r10.size()
                long[] r5 = new long[r5]
                r9.q = r5
                boolean r10 = r10.isEmpty()
                if (r10 != 0) goto L_0x010d
                long r1 = -r1
                r5[r3] = r1
            L_0x00f4:
                int r10 = r0 + -1
                if (r3 >= r10) goto L_0x010d
                long[] r10 = r9.q
                int r1 = r3 + 1
                r5 = r10[r3]
                com.google.common.collect.ImmutableList<androidx.media3.common.SimpleBasePlayer$PeriodData> r2 = r9.p
                java.lang.Object r2 = r2.get(r3)
                androidx.media3.common.SimpleBasePlayer$PeriodData r2 = (androidx.media3.common.SimpleBasePlayer.PeriodData) r2
                long r2 = r2.f9299b
                long r5 = r5 + r2
                r10[r1] = r5
                r3 = r1
                goto L_0x00f4
            L_0x010d:
                androidx.media3.common.MediaMetadata r10 = r9.f9273d
                if (r10 == 0) goto L_0x0112
                goto L_0x011a
            L_0x0112:
                androidx.media3.common.MediaItem r10 = r9.f9272c
                androidx.media3.common.Tracks r0 = r9.f9271b
                androidx.media3.common.MediaMetadata r10 = f(r10, r0)
            L_0x011a:
                r9.r = r10
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.MediaItemData.<init>(androidx.media3.common.SimpleBasePlayer$MediaItemData$Builder):void");
        }

        private static MediaMetadata f(MediaItem mediaItem, Tracks tracks) {
            MediaMetadata.Builder builder = new MediaMetadata.Builder();
            int size = tracks.d().size();
            for (int i2 = 0; i2 < size; i2++) {
                Tracks.Group group = tracks.d().get(i2);
                for (int i3 = 0; i3 < group.s; i3++) {
                    if (group.l(i3)) {
                        Format e2 = group.e(i3);
                        if (e2.d3 != null) {
                            for (int i4 = 0; i4 < e2.d3.g(); i4++) {
                                e2.d3.d(i4).q(builder);
                            }
                        }
                    }
                }
            }
            return builder.J(mediaItem.X2).H();
        }

        /* access modifiers changed from: private */
        public Timeline.Period g(int i2, int i3, Timeline.Period period) {
            Object obj;
            Object create;
            long j2;
            long j3;
            AdPlaybackState adPlaybackState;
            boolean z;
            Timeline.Period period2;
            if (this.p.isEmpty()) {
                create = this.f9270a;
                j2 = this.f9283n + this.f9282m;
                adPlaybackState = AdPlaybackState.e3;
                z = this.o;
                j3 = 0;
                period2 = period;
                obj = create;
            } else {
                PeriodData periodData = this.p.get(i3);
                obj = periodData.f9298a;
                create = Pair.create(this.f9270a, obj);
                j2 = periodData.f9299b;
                j3 = this.q[i3];
                adPlaybackState = periodData.f9300c;
                z = periodData.f9301d;
                period2 = period;
            }
            period2.y(obj, create, i2, j2, j3, adPlaybackState, z);
            return period;
        }

        /* access modifiers changed from: private */
        public Object h(int i2) {
            if (this.p.isEmpty()) {
                return this.f9270a;
            }
            return Pair.create(this.f9270a, this.p.get(i2).f9298a);
        }

        /* access modifiers changed from: private */
        public Timeline.Window i(int i2, Timeline.Window window) {
            Timeline.Window window2 = window;
            int size = this.p.isEmpty() ? 1 : this.p.size();
            Object obj = this.f9270a;
            Timeline.Window window3 = window;
            window.k(obj, this.f9272c, this.f9274e, this.f9276g, this.f9277h, this.f9278i, this.f9279j, this.f9280k, this.f9275f, this.f9281l, this.f9282m, i2, (i2 + size) - 1, this.f9283n);
            Timeline.Window window4 = window;
            window4.e3 = this.o;
            return window4;
        }

        public Builder e() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaItemData)) {
                return false;
            }
            MediaItemData mediaItemData = (MediaItemData) obj;
            return this.f9270a.equals(mediaItemData.f9270a) && this.f9271b.equals(mediaItemData.f9271b) && this.f9272c.equals(mediaItemData.f9272c) && Util.g(this.f9273d, mediaItemData.f9273d) && Util.g(this.f9274e, mediaItemData.f9274e) && Util.g(this.f9275f, mediaItemData.f9275f) && this.f9276g == mediaItemData.f9276g && this.f9277h == mediaItemData.f9277h && this.f9278i == mediaItemData.f9278i && this.f9279j == mediaItemData.f9279j && this.f9280k == mediaItemData.f9280k && this.f9281l == mediaItemData.f9281l && this.f9282m == mediaItemData.f9282m && this.f9283n == mediaItemData.f9283n && this.o == mediaItemData.o && this.p.equals(mediaItemData.p);
        }

        public int hashCode() {
            int hashCode = (((((217 + this.f9270a.hashCode()) * 31) + this.f9271b.hashCode()) * 31) + this.f9272c.hashCode()) * 31;
            MediaMetadata mediaMetadata = this.f9273d;
            int i2 = 0;
            int hashCode2 = (hashCode + (mediaMetadata == null ? 0 : mediaMetadata.hashCode())) * 31;
            Object obj = this.f9274e;
            int hashCode3 = (hashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
            MediaItem.LiveConfiguration liveConfiguration = this.f9275f;
            if (liveConfiguration != null) {
                i2 = liveConfiguration.hashCode();
            }
            long j2 = this.f9276g;
            long j3 = this.f9277h;
            long j4 = this.f9278i;
            long j5 = this.f9281l;
            long j6 = this.f9282m;
            long j7 = this.f9283n;
            return ((((((((((((((((((((hashCode3 + i2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.f9279j ? 1 : 0)) * 31) + (this.f9280k ? 1 : 0)) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.o ? 1 : 0)) * 31) + this.p.hashCode();
        }

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public Object f9284a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public Tracks f9285b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public MediaItem f9286c;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: d  reason: collision with root package name */
            public MediaMetadata f9287d;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: e  reason: collision with root package name */
            public Object f9288e;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: f  reason: collision with root package name */
            public MediaItem.LiveConfiguration f9289f;
            /* access modifiers changed from: private */

            /* renamed from: g  reason: collision with root package name */
            public long f9290g;
            /* access modifiers changed from: private */

            /* renamed from: h  reason: collision with root package name */
            public long f9291h;
            /* access modifiers changed from: private */

            /* renamed from: i  reason: collision with root package name */
            public long f9292i;
            /* access modifiers changed from: private */

            /* renamed from: j  reason: collision with root package name */
            public boolean f9293j;
            /* access modifiers changed from: private */

            /* renamed from: k  reason: collision with root package name */
            public boolean f9294k;
            /* access modifiers changed from: private */

            /* renamed from: l  reason: collision with root package name */
            public long f9295l;
            /* access modifiers changed from: private */

            /* renamed from: m  reason: collision with root package name */
            public long f9296m;
            /* access modifiers changed from: private */

            /* renamed from: n  reason: collision with root package name */
            public long f9297n;
            /* access modifiers changed from: private */
            public boolean o;
            /* access modifiers changed from: private */
            public ImmutableList<PeriodData> p;

            private Builder(MediaItemData mediaItemData) {
                this.f9284a = mediaItemData.f9270a;
                this.f9285b = mediaItemData.f9271b;
                this.f9286c = mediaItemData.f9272c;
                this.f9287d = mediaItemData.f9273d;
                this.f9288e = mediaItemData.f9274e;
                this.f9289f = mediaItemData.f9275f;
                this.f9290g = mediaItemData.f9276g;
                this.f9291h = mediaItemData.f9277h;
                this.f9292i = mediaItemData.f9278i;
                this.f9293j = mediaItemData.f9279j;
                this.f9294k = mediaItemData.f9280k;
                this.f9295l = mediaItemData.f9281l;
                this.f9296m = mediaItemData.f9282m;
                this.f9297n = mediaItemData.f9283n;
                this.o = mediaItemData.o;
                this.p = mediaItemData.p;
            }

            @CanIgnoreReturnValue
            public Builder A(@Nullable MediaMetadata mediaMetadata) {
                this.f9287d = mediaMetadata;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder B(List<PeriodData> list) {
                int size = list.size();
                int i2 = 0;
                while (i2 < size - 1) {
                    Assertions.b(list.get(i2).f9299b != C.f9084b, "Periods other than last need a duration");
                    int i3 = i2 + 1;
                    for (int i4 = i3; i4 < size; i4++) {
                        Assertions.b(!list.get(i2).f9298a.equals(list.get(i4).f9298a), "Duplicate PeriodData UIDs in period list");
                    }
                    i2 = i3;
                }
                this.p = ImmutableList.B(list);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder C(long j2) {
                Assertions.a(j2 >= 0);
                this.f9297n = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder D(long j2) {
                this.f9290g = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder E(Tracks tracks) {
                this.f9285b = tracks;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder F(Object obj) {
                this.f9284a = obj;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder G(long j2) {
                this.f9291h = j2;
                return this;
            }

            public MediaItemData q() {
                return new MediaItemData(this);
            }

            @CanIgnoreReturnValue
            public Builder r(long j2) {
                Assertions.a(j2 >= 0);
                this.f9295l = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder s(long j2) {
                Assertions.a(j2 == C.f9084b || j2 >= 0);
                this.f9296m = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder t(long j2) {
                this.f9292i = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder u(boolean z) {
                this.f9294k = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder v(boolean z) {
                this.o = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder w(boolean z) {
                this.f9293j = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder x(@Nullable MediaItem.LiveConfiguration liveConfiguration) {
                this.f9289f = liveConfiguration;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder y(@Nullable Object obj) {
                this.f9288e = obj;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder z(MediaItem mediaItem) {
                this.f9286c = mediaItem;
                return this;
            }

            public Builder(Object obj) {
                this.f9284a = obj;
                this.f9285b = Tracks.X;
                this.f9286c = MediaItem.c3;
                this.f9287d = null;
                this.f9288e = null;
                this.f9289f = null;
                this.f9290g = C.f9084b;
                this.f9291h = C.f9084b;
                this.f9292i = C.f9084b;
                this.f9293j = false;
                this.f9294k = false;
                this.f9295l = 0;
                this.f9296m = C.f9084b;
                this.f9297n = 0;
                this.o = false;
                this.p = ImmutableList.I();
            }
        }
    }

    protected static final class PeriodData {

        /* renamed from: a  reason: collision with root package name */
        public final Object f9298a;

        /* renamed from: b  reason: collision with root package name */
        public final long f9299b;

        /* renamed from: c  reason: collision with root package name */
        public final AdPlaybackState f9300c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f9301d;

        private PeriodData(Builder builder) {
            this.f9298a = builder.f9302a;
            this.f9299b = builder.f9303b;
            this.f9300c = builder.f9304c;
            this.f9301d = builder.f9305d;
        }

        public Builder a() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PeriodData)) {
                return false;
            }
            PeriodData periodData = (PeriodData) obj;
            return this.f9298a.equals(periodData.f9298a) && this.f9299b == periodData.f9299b && this.f9300c.equals(periodData.f9300c) && this.f9301d == periodData.f9301d;
        }

        public int hashCode() {
            long j2 = this.f9299b;
            return ((((((217 + this.f9298a.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f9300c.hashCode()) * 31) + (this.f9301d ? 1 : 0);
        }

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public Object f9302a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public long f9303b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public AdPlaybackState f9304c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public boolean f9305d;

            private Builder(PeriodData periodData) {
                this.f9302a = periodData.f9298a;
                this.f9303b = periodData.f9299b;
                this.f9304c = periodData.f9300c;
                this.f9305d = periodData.f9301d;
            }

            public PeriodData e() {
                return new PeriodData(this);
            }

            @CanIgnoreReturnValue
            public Builder f(AdPlaybackState adPlaybackState) {
                this.f9304c = adPlaybackState;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder g(long j2) {
                Assertions.a(j2 == C.f9084b || j2 >= 0);
                this.f9303b = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder h(boolean z) {
                this.f9305d = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder i(Object obj) {
                this.f9302a = obj;
                return this;
            }

            public Builder(Object obj) {
                this.f9302a = obj;
                this.f9303b = 0;
                this.f9304c = AdPlaybackState.e3;
                this.f9305d = false;
            }
        }
    }

    private static final class PlaceholderUid {
        private PlaceholderUid() {
        }
    }

    private static final class PlaylistTimeline extends Timeline {
        private final ImmutableList<MediaItemData> Y2;
        private final int[] Z2;
        private final int[] a3;
        private final HashMap<Object, Integer> b3;

        public PlaylistTimeline(ImmutableList<MediaItemData> immutableList) {
            int size = immutableList.size();
            this.Y2 = immutableList;
            this.Z2 = new int[size];
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                this.Z2[i3] = i2;
                i2 += z(immutableList.get(i3));
            }
            this.a3 = new int[i2];
            this.b3 = new HashMap<>();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                MediaItemData mediaItemData = immutableList.get(i5);
                for (int i6 = 0; i6 < z(mediaItemData); i6++) {
                    this.b3.put(mediaItemData.h(i6), Integer.valueOf(i4));
                    this.a3[i4] = i5;
                    i4++;
                }
            }
        }

        private static int z(MediaItemData mediaItemData) {
            if (mediaItemData.p.isEmpty()) {
                return 1;
            }
            return mediaItemData.p.size();
        }

        public int f(boolean z) {
            return super.f(z);
        }

        public int g(Object obj) {
            Integer num = this.b3.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        public int h(boolean z) {
            return super.h(z);
        }

        public int j(int i2, int i3, boolean z) {
            return super.j(i2, i3, z);
        }

        public Timeline.Period l(int i2, Timeline.Period period, boolean z) {
            int i3 = this.a3[i2];
            return this.Y2.get(i3).g(i3, i2 - this.Z2[i3], period);
        }

        public Timeline.Period m(Object obj, Timeline.Period period) {
            return l(((Integer) Assertions.g(this.b3.get(obj))).intValue(), period, true);
        }

        public int n() {
            return this.a3.length;
        }

        public int s(int i2, int i3, boolean z) {
            return super.s(i2, i3, z);
        }

        public Object t(int i2) {
            int i3 = this.a3[i2];
            return this.Y2.get(i3).h(i2 - this.Z2[i3]);
        }

        public Timeline.Window v(int i2, Timeline.Window window, long j2) {
            return this.Y2.get(i2).i(this.Z2[i2], window);
        }

        public int w() {
            return this.Y2.size();
        }
    }

    protected interface PositionSupplier {

        /* renamed from: a  reason: collision with root package name */
        public static final PositionSupplier f9306a = e1.a(0);

        long get();
    }

    protected static final class State {
        public final MediaMetadata A;
        public final int B;
        public final int C;
        public final int D;
        public final PositionSupplier E;
        public final PositionSupplier F;
        public final PositionSupplier G;
        public final PositionSupplier H;
        public final PositionSupplier I;
        public final boolean J;
        public final int K;
        public final long L;

        /* renamed from: a  reason: collision with root package name */
        public final Player.Commands f9307a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f9308b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9309c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9310d;

        /* renamed from: e  reason: collision with root package name */
        public final int f9311e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public final PlaybackException f9312f;

        /* renamed from: g  reason: collision with root package name */
        public final int f9313g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f9314h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f9315i;

        /* renamed from: j  reason: collision with root package name */
        public final long f9316j;

        /* renamed from: k  reason: collision with root package name */
        public final long f9317k;

        /* renamed from: l  reason: collision with root package name */
        public final long f9318l;

        /* renamed from: m  reason: collision with root package name */
        public final PlaybackParameters f9319m;

        /* renamed from: n  reason: collision with root package name */
        public final TrackSelectionParameters f9320n;
        public final AudioAttributes o;
        @FloatRange(from = 0.0d, to = 1.0d)
        public final float p;
        public final VideoSize q;
        public final CueGroup r;
        public final DeviceInfo s;
        @IntRange(from = 0)
        public final int t;
        public final boolean u;
        public final Size v;
        public final boolean w;
        public final Metadata x;
        public final ImmutableList<MediaItemData> y;
        public final Timeline z;

        public static final class Builder {
            /* access modifiers changed from: private */
            public MediaMetadata A;
            /* access modifiers changed from: private */
            public int B;
            /* access modifiers changed from: private */
            public int C;
            /* access modifiers changed from: private */
            public int D;
            /* access modifiers changed from: private */
            @Nullable
            public Long E;
            /* access modifiers changed from: private */
            public PositionSupplier F;
            /* access modifiers changed from: private */
            @Nullable
            public Long G;
            /* access modifiers changed from: private */
            public PositionSupplier H;
            /* access modifiers changed from: private */
            public PositionSupplier I;
            /* access modifiers changed from: private */
            public PositionSupplier J;
            /* access modifiers changed from: private */
            public PositionSupplier K;
            /* access modifiers changed from: private */
            public boolean L;
            /* access modifiers changed from: private */
            public int M;
            /* access modifiers changed from: private */
            public long N;
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public Player.Commands f9321a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public boolean f9322b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public int f9323c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public int f9324d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public int f9325e;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: f  reason: collision with root package name */
            public PlaybackException f9326f;
            /* access modifiers changed from: private */

            /* renamed from: g  reason: collision with root package name */
            public int f9327g;
            /* access modifiers changed from: private */

            /* renamed from: h  reason: collision with root package name */
            public boolean f9328h;
            /* access modifiers changed from: private */

            /* renamed from: i  reason: collision with root package name */
            public boolean f9329i;
            /* access modifiers changed from: private */

            /* renamed from: j  reason: collision with root package name */
            public long f9330j;
            /* access modifiers changed from: private */

            /* renamed from: k  reason: collision with root package name */
            public long f9331k;
            /* access modifiers changed from: private */

            /* renamed from: l  reason: collision with root package name */
            public long f9332l;
            /* access modifiers changed from: private */

            /* renamed from: m  reason: collision with root package name */
            public PlaybackParameters f9333m;
            /* access modifiers changed from: private */

            /* renamed from: n  reason: collision with root package name */
            public TrackSelectionParameters f9334n;
            /* access modifiers changed from: private */
            public AudioAttributes o;
            /* access modifiers changed from: private */
            public float p;
            /* access modifiers changed from: private */
            public VideoSize q;
            /* access modifiers changed from: private */
            public CueGroup r;
            /* access modifiers changed from: private */
            public DeviceInfo s;
            /* access modifiers changed from: private */
            public int t;
            /* access modifiers changed from: private */
            public boolean u;
            /* access modifiers changed from: private */
            public Size v;
            /* access modifiers changed from: private */
            public boolean w;
            /* access modifiers changed from: private */
            public Metadata x;
            /* access modifiers changed from: private */
            public ImmutableList<MediaItemData> y;
            /* access modifiers changed from: private */
            public Timeline z;

            public Builder() {
                this.f9321a = Player.Commands.X;
                this.f9322b = false;
                this.f9323c = 1;
                this.f9324d = 1;
                this.f9325e = 0;
                this.f9326f = null;
                this.f9327g = 0;
                this.f9328h = false;
                this.f9329i = false;
                this.f9330j = 5000;
                this.f9331k = C.b2;
                this.f9332l = C.c2;
                this.f9333m = PlaybackParameters.Z;
                this.f9334n = TrackSelectionParameters.v3;
                this.o = AudioAttributes.Z2;
                this.p = 1.0f;
                this.q = VideoSize.b3;
                this.r = CueGroup.Y;
                this.s = DeviceInfo.Z2;
                this.t = 0;
                this.u = false;
                this.v = Size.f9620c;
                this.w = false;
                this.x = new Metadata((long) C.f9084b, new Metadata.Entry[0]);
                this.y = ImmutableList.I();
                this.z = Timeline.s;
                this.A = MediaMetadata.O4;
                this.B = -1;
                this.C = -1;
                this.D = -1;
                this.E = null;
                this.F = e1.a(C.f9084b);
                this.G = null;
                PositionSupplier positionSupplier = PositionSupplier.f9306a;
                this.H = positionSupplier;
                this.I = e1.a(C.f9084b);
                this.J = positionSupplier;
                this.K = positionSupplier;
                this.L = false;
                this.M = 5;
                this.N = 0;
            }

            public State O() {
                return new State(this);
            }

            @CanIgnoreReturnValue
            public Builder P() {
                this.L = false;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder Q(PositionSupplier positionSupplier) {
                this.J = positionSupplier;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder R(long j2) {
                this.G = Long.valueOf(j2);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder S(PositionSupplier positionSupplier) {
                this.G = null;
                this.H = positionSupplier;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder T(AudioAttributes audioAttributes) {
                this.o = audioAttributes;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder U(Player.Commands commands) {
                this.f9321a = commands;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder V(PositionSupplier positionSupplier) {
                this.I = positionSupplier;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder W(long j2) {
                this.E = Long.valueOf(j2);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder X(PositionSupplier positionSupplier) {
                this.E = null;
                this.F = positionSupplier;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder Y(int i2, int i3) {
                boolean z2 = false;
                if ((i2 == -1) == (i3 == -1)) {
                    z2 = true;
                }
                Assertions.a(z2);
                this.C = i2;
                this.D = i3;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder Z(CueGroup cueGroup) {
                this.r = cueGroup;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder a0(int i2) {
                this.B = i2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder b0(DeviceInfo deviceInfo) {
                this.s = deviceInfo;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder c0(@IntRange(from = 0) int i2) {
                Assertions.a(i2 >= 0);
                this.t = i2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder d0(boolean z2) {
                this.u = z2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder e0(boolean z2) {
                this.f9329i = z2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder f0(long j2) {
                this.f9332l = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder g0(boolean z2) {
                this.w = z2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder h0(boolean z2, int i2) {
                this.f9322b = z2;
                this.f9323c = i2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder i0(PlaybackParameters playbackParameters) {
                this.f9333m = playbackParameters;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder j0(int i2) {
                this.f9324d = i2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder k0(int i2) {
                this.f9325e = i2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder l0(@Nullable PlaybackException playbackException) {
                this.f9326f = playbackException;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder m0(List<MediaItemData> list) {
                HashSet hashSet = new HashSet();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Assertions.b(hashSet.add(list.get(i2).f9270a), "Duplicate MediaItemData UID in playlist");
                }
                this.y = ImmutableList.B(list);
                this.z = new PlaylistTimeline(this.y);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder n0(MediaMetadata mediaMetadata) {
                this.A = mediaMetadata;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder o0(int i2, long j2) {
                this.L = true;
                this.M = i2;
                this.N = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder p0(int i2) {
                this.f9327g = i2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder q0(long j2) {
                this.f9330j = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder r0(long j2) {
                this.f9331k = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder s0(boolean z2) {
                this.f9328h = z2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder t0(Size size) {
                this.v = size;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder u0(Metadata metadata) {
                this.x = metadata;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder v0(PositionSupplier positionSupplier) {
                this.K = positionSupplier;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder w0(TrackSelectionParameters trackSelectionParameters) {
                this.f9334n = trackSelectionParameters;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder x0(VideoSize videoSize) {
                this.q = videoSize;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder y0(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
                Assertions.a(f2 >= 0.0f && f2 <= 1.0f);
                this.p = f2;
                return this;
            }

            private Builder(State state) {
                this.f9321a = state.f9307a;
                this.f9322b = state.f9308b;
                this.f9323c = state.f9309c;
                this.f9324d = state.f9310d;
                this.f9325e = state.f9311e;
                this.f9326f = state.f9312f;
                this.f9327g = state.f9313g;
                this.f9328h = state.f9314h;
                this.f9329i = state.f9315i;
                this.f9330j = state.f9316j;
                this.f9331k = state.f9317k;
                this.f9332l = state.f9318l;
                this.f9333m = state.f9319m;
                this.f9334n = state.f9320n;
                this.o = state.o;
                this.p = state.p;
                this.q = state.q;
                this.r = state.r;
                this.s = state.s;
                this.t = state.t;
                this.u = state.u;
                this.v = state.v;
                this.w = state.w;
                this.x = state.x;
                this.y = state.y;
                this.z = state.z;
                this.A = state.A;
                this.B = state.B;
                this.C = state.C;
                this.D = state.D;
                this.E = null;
                this.F = state.E;
                this.G = null;
                this.H = state.F;
                this.I = state.G;
                this.J = state.H;
                this.K = state.I;
                this.L = state.J;
                this.M = state.K;
                this.N = state.L;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:44:0x00c3  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00f0  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0142  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private State(androidx.media3.common.SimpleBasePlayer.State.Builder r14) {
            /*
                r13 = this;
                r13.<init>()
                androidx.media3.common.Timeline r0 = r14.z
                boolean r0 = r0.x()
                r1 = 4
                r2 = -1
                r3 = 0
                r4 = 1
                if (r0 == 0) goto L_0x003c
                int r0 = r14.f9324d
                if (r0 == r4) goto L_0x0020
                int r0 = r14.f9324d
                if (r0 != r1) goto L_0x001e
                goto L_0x0020
            L_0x001e:
                r0 = 0
                goto L_0x0021
            L_0x0020:
                r0 = 1
            L_0x0021:
                java.lang.String r5 = "Empty playlist only allowed in STATE_IDLE or STATE_ENDED"
                androidx.media3.common.util.Assertions.b(r0, r5)
                int r0 = r14.C
                if (r0 != r2) goto L_0x0034
                int r0 = r14.D
                if (r0 != r2) goto L_0x0034
                r0 = 1
                goto L_0x0035
            L_0x0034:
                r0 = 0
            L_0x0035:
                java.lang.String r5 = "Ads not allowed if playlist is empty"
            L_0x0037:
                androidx.media3.common.util.Assertions.b(r0, r5)
                goto L_0x00bd
            L_0x003c:
                int r0 = r14.B
                if (r0 != r2) goto L_0x0044
                r8 = 0
                goto L_0x005b
            L_0x0044:
                int r5 = r14.B
                androidx.media3.common.Timeline r6 = r14.z
                int r6 = r6.w()
                if (r5 >= r6) goto L_0x0054
                r5 = 1
                goto L_0x0055
            L_0x0054:
                r5 = 0
            L_0x0055:
                java.lang.String r6 = "currentMediaItemIndex must be less than playlist.size()"
                androidx.media3.common.util.Assertions.b(r5, r6)
                r8 = r0
            L_0x005b:
                int r0 = r14.C
                if (r0 == r2) goto L_0x00bd
                androidx.media3.common.Timeline$Period r0 = new androidx.media3.common.Timeline$Period
                r0.<init>()
                androidx.media3.common.Timeline$Window r11 = new androidx.media3.common.Timeline$Window
                r11.<init>()
                java.lang.Long r5 = r14.E
                if (r5 == 0) goto L_0x007b
                java.lang.Long r5 = r14.E
                long r5 = r5.longValue()
            L_0x0079:
                r9 = r5
                goto L_0x0084
            L_0x007b:
                androidx.media3.common.SimpleBasePlayer$PositionSupplier r5 = r14.F
                long r5 = r5.get()
                goto L_0x0079
            L_0x0084:
                androidx.media3.common.Timeline r7 = r14.z
                r12 = r0
                int r5 = androidx.media3.common.SimpleBasePlayer.j4(r7, r8, r9, r11, r12)
                androidx.media3.common.Timeline r6 = r14.z
                r6.k(r5, r0)
                int r5 = r14.C
                int r6 = r0.f()
                if (r5 >= r6) goto L_0x00a0
                r5 = 1
                goto L_0x00a1
            L_0x00a0:
                r5 = 0
            L_0x00a1:
                java.lang.String r6 = "PeriodData has less ad groups than adGroupIndex"
                androidx.media3.common.util.Assertions.b(r5, r6)
                int r5 = r14.C
                int r0 = r0.d(r5)
                if (r0 == r2) goto L_0x00bd
                int r5 = r14.D
                if (r5 >= r0) goto L_0x00b8
                r0 = 1
                goto L_0x00b9
            L_0x00b8:
                r0 = 0
            L_0x00b9:
                java.lang.String r5 = "Ad group has less ads than adIndexInGroupIndex"
                goto L_0x0037
            L_0x00bd:
                androidx.media3.common.PlaybackException r0 = r14.f9326f
                if (r0 == 0) goto L_0x00cf
                int r0 = r14.f9324d
                if (r0 != r4) goto L_0x00ca
                r3 = 1
            L_0x00ca:
                java.lang.String r0 = "Player error only allowed in STATE_IDLE"
                androidx.media3.common.util.Assertions.b(r3, r0)
            L_0x00cf:
                int r0 = r14.f9324d
                if (r0 == r4) goto L_0x00db
                int r0 = r14.f9324d
                if (r0 != r1) goto L_0x00e5
            L_0x00db:
                boolean r0 = r14.f9329i
                r0 = r0 ^ r4
                java.lang.String r1 = "isLoading only allowed when not in STATE_IDLE or STATE_ENDED"
                androidx.media3.common.util.Assertions.b(r0, r1)
            L_0x00e5:
                androidx.media3.common.SimpleBasePlayer$PositionSupplier r0 = r14.F
                java.lang.Long r1 = r14.E
                r3 = 3
                if (r1 == 0) goto L_0x0138
                int r0 = r14.C
                if (r0 != r2) goto L_0x012c
                boolean r0 = r14.f9322b
                if (r0 == 0) goto L_0x012c
                int r0 = r14.f9324d
                if (r0 != r3) goto L_0x012c
                int r0 = r14.f9325e
                if (r0 != 0) goto L_0x012c
                java.lang.Long r0 = r14.E
                long r0 = r0.longValue()
                r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r6 == 0) goto L_0x012c
                java.lang.Long r0 = r14.E
                long r0 = r0.longValue()
                androidx.media3.common.PlaybackParameters r4 = r14.f9333m
                float r4 = r4.s
                androidx.media3.common.SimpleBasePlayer$PositionSupplier r0 = androidx.media3.common.e1.b(r0, r4)
                goto L_0x0138
            L_0x012c:
                java.lang.Long r0 = r14.E
                long r0 = r0.longValue()
                androidx.media3.common.SimpleBasePlayer$PositionSupplier r0 = androidx.media3.common.e1.a(r0)
            L_0x0138:
                androidx.media3.common.SimpleBasePlayer$PositionSupplier r1 = r14.H
                java.lang.Long r4 = r14.G
                if (r4 == 0) goto L_0x0175
                int r1 = r14.C
                if (r1 == r2) goto L_0x0169
                boolean r1 = r14.f9322b
                if (r1 == 0) goto L_0x0169
                int r1 = r14.f9324d
                if (r1 != r3) goto L_0x0169
                int r1 = r14.f9325e
                if (r1 != 0) goto L_0x0169
                java.lang.Long r1 = r14.G
                long r1 = r1.longValue()
                r3 = 1065353216(0x3f800000, float:1.0)
                androidx.media3.common.SimpleBasePlayer$PositionSupplier r1 = androidx.media3.common.e1.b(r1, r3)
                goto L_0x0175
            L_0x0169:
                java.lang.Long r1 = r14.G
                long r1 = r1.longValue()
                androidx.media3.common.SimpleBasePlayer$PositionSupplier r1 = androidx.media3.common.e1.a(r1)
            L_0x0175:
                androidx.media3.common.Player$Commands r2 = r14.f9321a
                r13.f9307a = r2
                boolean r2 = r14.f9322b
                r13.f9308b = r2
                int r2 = r14.f9323c
                r13.f9309c = r2
                int r2 = r14.f9324d
                r13.f9310d = r2
                int r2 = r14.f9325e
                r13.f9311e = r2
                androidx.media3.common.PlaybackException r2 = r14.f9326f
                r13.f9312f = r2
                int r2 = r14.f9327g
                r13.f9313g = r2
                boolean r2 = r14.f9328h
                r13.f9314h = r2
                boolean r2 = r14.f9329i
                r13.f9315i = r2
                long r2 = r14.f9330j
                r13.f9316j = r2
                long r2 = r14.f9331k
                r13.f9317k = r2
                long r2 = r14.f9332l
                r13.f9318l = r2
                androidx.media3.common.PlaybackParameters r2 = r14.f9333m
                r13.f9319m = r2
                androidx.media3.common.TrackSelectionParameters r2 = r14.f9334n
                r13.f9320n = r2
                androidx.media3.common.AudioAttributes r2 = r14.o
                r13.o = r2
                float r2 = r14.p
                r13.p = r2
                androidx.media3.common.VideoSize r2 = r14.q
                r13.q = r2
                androidx.media3.common.text.CueGroup r2 = r14.r
                r13.r = r2
                androidx.media3.common.DeviceInfo r2 = r14.s
                r13.s = r2
                int r2 = r14.t
                r13.t = r2
                boolean r2 = r14.u
                r13.u = r2
                androidx.media3.common.util.Size r2 = r14.v
                r13.v = r2
                boolean r2 = r14.w
                r13.w = r2
                androidx.media3.common.Metadata r2 = r14.x
                r13.x = r2
                com.google.common.collect.ImmutableList r2 = r14.y
                r13.y = r2
                androidx.media3.common.Timeline r2 = r14.z
                r13.z = r2
                androidx.media3.common.MediaMetadata r2 = r14.A
                r13.A = r2
                int r2 = r14.B
                r13.B = r2
                int r2 = r14.C
                r13.C = r2
                int r2 = r14.D
                r13.D = r2
                r13.E = r0
                r13.F = r1
                androidx.media3.common.SimpleBasePlayer$PositionSupplier r0 = r14.I
                r13.G = r0
                androidx.media3.common.SimpleBasePlayer$PositionSupplier r0 = r14.J
                r13.H = r0
                androidx.media3.common.SimpleBasePlayer$PositionSupplier r0 = r14.K
                r13.I = r0
                boolean r0 = r14.L
                r13.J = r0
                int r0 = r14.M
                r13.K = r0
                long r0 = r14.N
                r13.L = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.SimpleBasePlayer.State.<init>(androidx.media3.common.SimpleBasePlayer$State$Builder):void");
        }

        public Builder a() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return this.f9308b == state.f9308b && this.f9309c == state.f9309c && this.f9307a.equals(state.f9307a) && this.f9310d == state.f9310d && this.f9311e == state.f9311e && Util.g(this.f9312f, state.f9312f) && this.f9313g == state.f9313g && this.f9314h == state.f9314h && this.f9315i == state.f9315i && this.f9316j == state.f9316j && this.f9317k == state.f9317k && this.f9318l == state.f9318l && this.f9319m.equals(state.f9319m) && this.f9320n.equals(state.f9320n) && this.o.equals(state.o) && this.p == state.p && this.q.equals(state.q) && this.r.equals(state.r) && this.s.equals(state.s) && this.t == state.t && this.u == state.u && this.v.equals(state.v) && this.w == state.w && this.x.equals(state.x) && this.y.equals(state.y) && this.A.equals(state.A) && this.B == state.B && this.C == state.C && this.D == state.D && this.E.equals(state.E) && this.F.equals(state.F) && this.G.equals(state.G) && this.H.equals(state.H) && this.I.equals(state.I) && this.J == state.J && this.K == state.K && this.L == state.L;
        }

        public int hashCode() {
            int hashCode = (((((((((217 + this.f9307a.hashCode()) * 31) + (this.f9308b ? 1 : 0)) * 31) + this.f9309c) * 31) + this.f9310d) * 31) + this.f9311e) * 31;
            PlaybackException playbackException = this.f9312f;
            int hashCode2 = playbackException == null ? 0 : playbackException.hashCode();
            long j2 = this.f9316j;
            long j3 = this.f9317k;
            long j4 = this.f9318l;
            long j5 = this.L;
            return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode + hashCode2) * 31) + this.f9313g) * 31) + (this.f9314h ? 1 : 0)) * 31) + (this.f9315i ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.f9319m.hashCode()) * 31) + this.f9320n.hashCode()) * 31) + this.o.hashCode()) * 31) + Float.floatToRawIntBits(this.p)) * 31) + this.q.hashCode()) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31) + this.t) * 31) + (this.u ? 1 : 0)) * 31) + this.v.hashCode()) * 31) + (this.w ? 1 : 0)) * 31) + this.x.hashCode()) * 31) + this.y.hashCode()) * 31) + this.A.hashCode()) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E.hashCode()) * 31) + this.F.hashCode()) * 31) + this.G.hashCode()) * 31) + this.H.hashCode()) * 31) + this.I.hashCode()) * 31) + (this.J ? 1 : 0)) * 31) + this.K) * 31) + ((int) (j5 ^ (j5 >>> 32)));
        }
    }

    protected SimpleBasePlayer(Looper looper) {
        this(looper, Clock.f9502a);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void B5(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.Listener listener) {
        listener.F(i2);
        listener.u0(positionInfo, positionInfo2, i2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void I5(State state, Player.Listener listener) {
        listener.E(state.f9315i);
        listener.H(state.f9315i);
    }

    private static boolean T4(State state) {
        return state.f9308b && state.f9310d == 3 && state.f9311e == 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ State U4(State state, List list, int i2) {
        ArrayList arrayList = new ArrayList(state.y);
        for (int i3 = 0; i3 < list.size(); i3++) {
            arrayList.add(i3 + i2, l4((MediaItem) list.get(i3)));
        }
        return !state.y.isEmpty() ? r4(state, arrayList, this.g1) : s4(state, arrayList, state.B, state.E.get());
    }

    private static State Y3(State.Builder builder, State state, long j2, List<MediaItemData> list, int i2, long j3, boolean z) {
        int i3;
        long p4 = p4(j2, state);
        boolean z2 = false;
        if (!list.isEmpty() && (i2 == -1 || i2 >= list.size())) {
            j3 = -9223372036854775807L;
            i2 = 0;
        }
        if (!list.isEmpty() && j3 == C.f9084b) {
            j3 = Util.H2(list.get(i2).f9281l);
        }
        boolean z3 = state.y.isEmpty() || list.isEmpty();
        if (!z3 && !state.y.get(c4(state)).f9270a.equals(list.get(i2).f9270a)) {
            z2 = true;
        }
        if (z3 || z2 || j3 < p4) {
            builder.a0(i2).Y(-1, -1).W(j3).V(e1.a(j3)).v0(PositionSupplier.f9306a);
        } else if (i3 == 0) {
            builder.a0(i2);
            if (state.C == -1 || !z) {
                builder.Y(-1, -1).v0(e1.a(a4(state) - p4));
            } else {
                builder.v0(e1.a(state.H.get() - state.F.get()));
            }
        } else {
            builder.a0(i2).Y(-1, -1).W(j3).V(e1.a(Math.max(a4(state), j3))).v0(e1.a(Math.max(0, state.I.get() - (j3 - p4))));
        }
        return builder.O();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ListenableFuture Y4(ListenableFuture listenableFuture, Object obj) throws Exception {
        return listenableFuture;
    }

    private void Z3(@Nullable Object obj) {
        m6();
        State state = this.h1;
        if (h6(27)) {
            j6(w4(obj), new K0(state));
        }
    }

    private static long a4(State state) {
        return p4(state.G.get(), state);
    }

    private static long b4(State state) {
        return p4(state.E.get(), state);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ State b5(State state, int i2, int i3, int i4) {
        ArrayList arrayList = new ArrayList(state.y);
        Util.H1(arrayList, i2, i3, i4);
        return r4(state, arrayList, this.g1);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b6(State state, Player.Listener listener) {
        listener.s(state.r.s);
        listener.p(state.r);
    }

    private static int c4(State state) {
        int i2 = state.B;
        if (i2 != -1) {
            return i2;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c5(Player.Listener listener, FlagSet flagSet) {
        listener.I(this, new Player.Events(flagSet));
    }

    private static int d4(State state, Timeline.Window window, Timeline.Period period) {
        int c4 = c4(state);
        return state.z.x() ? c4 : j4(state.z, c4, b4(state), window, period);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ State d5(State state) {
        return state.a().l0((PlaybackException) null).j0(state.z.x() ? 4 : 2).O();
    }

    private static long e4(State state, Object obj, Timeline.Period period) {
        return state.C != -1 ? state.F.get() : b4(state) - state.z.m(obj, period).r();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ State e5(State state) {
        return state;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e6(ListenableFuture listenableFuture) {
        Util.o(this.h1);
        this.f1.remove(listenableFuture);
        if (this.f1.isEmpty() && !this.i1) {
            i6(q4(), false, false);
        }
    }

    private static Tracks f4(State state) {
        return state.y.isEmpty() ? Tracks.X : state.y.get(c4(state)).f9271b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ State f5(State state, int i2, int i3) {
        ArrayList arrayList = new ArrayList(state.y);
        Util.Y1(arrayList, i2, i3);
        return r4(state, arrayList, this.g1);
    }

    /* access modifiers changed from: private */
    public void f6(Runnable runnable) {
        if (this.e1.o() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.e1.e(runnable);
        }
    }

    private static int g4(List<MediaItemData> list, Timeline timeline, int i2, Timeline.Period period) {
        if (!list.isEmpty()) {
            Object a2 = list.get(i2).h(0);
            if (timeline.g(a2) == -1) {
                return -1;
            }
            return timeline.m(a2, period).Y;
        } else if (i2 < timeline.w()) {
            return i2;
        } else {
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ State g5(State state, List list, int i2, int i3) {
        ArrayList arrayList = new ArrayList(state.y);
        for (int i4 = 0; i4 < list.size(); i4++) {
            arrayList.add(i4 + i2, l4((MediaItem) list.get(i4)));
        }
        State r4 = !state.y.isEmpty() ? r4(state, arrayList, this.g1) : s4(state, arrayList, state.B, state.E.get());
        if (i3 >= i2) {
            return r4;
        }
        Util.Y1(arrayList, i3, i2);
        return r4(r4, arrayList, this.g1);
    }

    @RequiresNonNull({"state"})
    private void g6(List<MediaItem> list, int i2, long j2) {
        Assertions.a(i2 == -1 || i2 >= 0);
        State state = this.h1;
        if (h6(20) || (list.size() == 1 && h6(31))) {
            j6(I4(list, i2, j2), new C0170r0(this, list, state, i2, j2));
        }
    }

    private static int h4(State state, State state2, int i2, boolean z, Timeline.Window window) {
        Timeline timeline = state.z;
        Timeline timeline2 = state2.z;
        if (timeline2.x() && timeline.x()) {
            return -1;
        }
        if (timeline2.x() != timeline.x()) {
            return 3;
        }
        Object obj = state.z.u(c4(state), window).s;
        Object obj2 = state2.z.u(c4(state2), window).s;
        if ((obj instanceof PlaceholderUid) && !(obj2 instanceof PlaceholderUid)) {
            return -1;
        }
        if (!obj.equals(obj2)) {
            if (i2 == 0) {
                return 1;
            }
            return i2 == 1 ? 2 : 3;
        } else if (i2 != 0 || b4(state) <= b4(state2)) {
            return (i2 != 1 || !z) ? -1 : 2;
        } else {
            return 0;
        }
    }

    @RequiresNonNull({"state"})
    private boolean h6(int i2) {
        return !this.i1 && this.h1.f9307a.d(i2);
    }

    private static MediaMetadata i4(State state) {
        return state.y.isEmpty() ? MediaMetadata.O4 : state.y.get(c4(state)).r;
    }

    @RequiresNonNull({"state"})
    private void i6(State state, boolean z, boolean z2) {
        State state2 = state;
        State state3 = this.h1;
        this.h1 = state2;
        if (state2.J || state2.w) {
            this.h1 = state.a().P().g0(false).O();
        }
        boolean z3 = state3.f9308b != state2.f9308b;
        boolean z4 = state3.f9310d != state2.f9310d;
        Tracks f4 = f4(state3);
        Tracks f42 = f4(state);
        MediaMetadata i4 = i4(state3);
        MediaMetadata i42 = i4(state);
        int n4 = n4(state3, state2, z, this.b1, this.g1);
        boolean z5 = !state3.z.equals(state2.z);
        int h4 = h4(state3, state2, n4, z2, this.b1);
        if (z5) {
            this.c1.j(0, new C0185w0(state2, u4(state3.y, state2.y)));
        }
        if (n4 != -1) {
            this.c1.j(11, new U(n4, o4(state3, false, this.b1, this.g1), o4(state2, state2.J, this.b1, this.g1)));
        }
        if (h4 != -1) {
            this.c1.j(1, new C0148g0(state2.z.x() ? null : state2.y.get(c4(state)).f9272c, h4));
        }
        if (!Util.g(state3.f9312f, state2.f9312f)) {
            this.c1.j(10, new C0152i0(state2));
            if (state2.f9312f != null) {
                this.c1.j(10, new C0154j0(state2));
            }
        }
        if (!state3.f9320n.equals(state2.f9320n)) {
            this.c1.j(19, new C0156k0(state2));
        }
        if (!f4.equals(f42)) {
            this.c1.j(2, new C0160m0(f42));
        }
        if (!i4.equals(i42)) {
            this.c1.j(14, new C0162n0(i42));
        }
        if (state3.f9315i != state2.f9315i) {
            this.c1.j(3, new C0164o0(state2));
        }
        if (z3 || z4) {
            this.c1.j(-1, new C0166p0(state2));
        }
        if (z4) {
            this.c1.j(4, new H0(state2));
        }
        if (z3 || state3.f9309c != state2.f9309c) {
            this.c1.j(5, new S0(state2));
        }
        if (state3.f9311e != state2.f9311e) {
            this.c1.j(6, new Y0(state2));
        }
        if (T4(state3) != T4(state)) {
            this.c1.j(7, new Z0(state2));
        }
        if (!state3.f9319m.equals(state2.f9319m)) {
            this.c1.j(12, new a1(state2));
        }
        if (state3.f9313g != state2.f9313g) {
            this.c1.j(8, new b1(state2));
        }
        if (state3.f9314h != state2.f9314h) {
            this.c1.j(9, new P(state2));
        }
        if (state3.f9316j != state2.f9316j) {
            this.c1.j(16, new Q(state2));
        }
        if (state3.f9317k != state2.f9317k) {
            this.c1.j(17, new S(state2));
        }
        if (state3.f9318l != state2.f9318l) {
            this.c1.j(18, new T(state2));
        }
        if (!state3.o.equals(state2.o)) {
            this.c1.j(20, new V(state2));
        }
        if (!state3.q.equals(state2.q)) {
            this.c1.j(25, new W(state2));
        }
        if (!state3.s.equals(state2.s)) {
            this.c1.j(29, new X(state2));
        }
        if (!state3.A.equals(state2.A)) {
            this.c1.j(15, new Y(state2));
        }
        if (state2.w) {
            this.c1.j(26, new Z());
        }
        if (!state3.v.equals(state2.v)) {
            this.c1.j(24, new C0138b0(state2));
        }
        if (state3.p != state2.p) {
            this.c1.j(22, new C0140c0(state2));
        }
        if (!(state3.t == state2.t && state3.u == state2.u)) {
            this.c1.j(30, new C0142d0(state2));
        }
        if (!state3.r.equals(state2.r)) {
            this.c1.j(27, new C0144e0(state2));
        }
        if (!state3.x.equals(state2.x) && state2.x.X != C.f9084b) {
            this.c1.j(28, new C0146f0(state2));
        }
        if (!state3.f9307a.equals(state2.f9307a)) {
            this.c1.j(13, new C0150h0(state2));
        }
        this.c1.g();
    }

    /* access modifiers changed from: private */
    public static int j4(Timeline timeline, int i2, long j2, Timeline.Window window, Timeline.Period period) {
        return timeline.g(timeline.q(window, period, i2, Util.I1(j2)).first);
    }

    @RequiresNonNull({"state"})
    private void j6(ListenableFuture<?> listenableFuture, Supplier<State> supplier) {
        k6(listenableFuture, supplier, false, false);
    }

    private static long k4(State state, Object obj, Timeline.Period period) {
        state.z.m(obj, period);
        int i2 = state.C;
        return Util.H2(i2 == -1 ? period.Z : period.e(i2, state.D));
    }

    @RequiresNonNull({"state"})
    private void k6(ListenableFuture<?> listenableFuture, Supplier<State> supplier, boolean z, boolean z2) {
        if (!listenableFuture.isDone() || !this.f1.isEmpty()) {
            this.f1.add(listenableFuture);
            i6(m4(supplier.get()), z, z2);
            listenableFuture.a0(new C0174t0(this, listenableFuture), new C0176u0(this));
            return;
        }
        i6(q4(), z, z2);
    }

    @EnsuresNonNull({"state"})
    private void m6() {
        l6();
        if (this.h1 == null) {
            this.h1 = q4();
        }
    }

    private static int n4(State state, State state2, boolean z, Timeline.Window window, Timeline.Period period) {
        if (state2.J) {
            return state2.K;
        }
        if (z) {
            return 1;
        }
        if (state.y.isEmpty()) {
            return -1;
        }
        if (state2.y.isEmpty()) {
            return 4;
        }
        Object t = state.z.t(d4(state, window, period));
        Object t2 = state2.z.t(d4(state2, window, period));
        if ((t instanceof PlaceholderUid) && !(t2 instanceof PlaceholderUid)) {
            return -1;
        }
        if (t2.equals(t) && state.C == state2.C && state.D == state2.D) {
            long e4 = e4(state, t, period);
            if (Math.abs(e4 - e4(state2, t2, period)) < 1000) {
                return -1;
            }
            long k4 = k4(state, t, period);
            return (k4 == C.f9084b || e4 < k4) ? 5 : 0;
        } else if (state2.z.g(t) == -1) {
            return 4;
        } else {
            long e42 = e4(state, t, period);
            long k42 = k4(state, t, period);
            return (k42 == C.f9084b || e42 < k42) ? 3 : 0;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ State n5(List list, State state, int i2, long j2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            arrayList.add(l4((MediaItem) list.get(i3)));
        }
        return s4(state, arrayList, i2, j2);
    }

    private static Player.PositionInfo o4(State state, boolean z, Timeline.Window window, Timeline.Period period) {
        int i2;
        Object obj;
        MediaItem mediaItem;
        Object obj2;
        long j2;
        long j3;
        State state2 = state;
        Timeline.Window window2 = window;
        Timeline.Period period2 = period;
        int c4 = c4(state);
        if (!state2.z.x()) {
            int d4 = d4(state2, window2, period2);
            Object obj3 = state2.z.l(d4, period2, true).X;
            Object obj4 = state2.z.u(c4, window2).s;
            i2 = d4;
            mediaItem = window2.Y;
            obj2 = obj4;
            obj = obj3;
        } else {
            obj2 = null;
            mediaItem = null;
            obj = null;
            i2 = -1;
        }
        if (z) {
            j3 = state2.L;
            j2 = state2.C == -1 ? j3 : b4(state);
        } else {
            long b4 = b4(state);
            long j4 = b4;
            j3 = state2.C != -1 ? state2.F.get() : b4;
            j2 = j4;
        }
        return new Player.PositionInfo(obj2, c4, mediaItem, obj, i2, j3, j2, state2.C, state2.D);
    }

    private static long p4(long j2, State state) {
        if (j2 != C.f9084b) {
            return j2;
        }
        if (state.y.isEmpty()) {
            return 0;
        }
        return Util.H2(state.y.get(c4(state)).f9281l);
    }

    private static State r4(State state, List<MediaItemData> list, Timeline.Period period) {
        State.Builder a2 = state.a();
        a2.m0(list);
        Timeline a3 = a2.z;
        long j2 = state.E.get();
        int c4 = c4(state);
        int g4 = g4(state.y, a3, c4, period);
        long j3 = g4 == -1 ? C.f9084b : j2;
        int i2 = c4 + 1;
        while (g4 == -1 && i2 < state.y.size()) {
            g4 = g4(state.y, a3, i2, period);
            i2++;
        }
        if (state.f9310d != 1 && g4 == -1) {
            a2.j0(4).e0(false);
        }
        return Y3(a2, state, j2, list, g4, j3, true);
    }

    /* access modifiers changed from: private */
    public static State s4(State state, List<MediaItemData> list, int i2, long j2) {
        State.Builder a2 = state.a();
        a2.m0(list);
        if (state.f9310d != 1) {
            if (list.isEmpty() || (i2 != -1 && i2 >= list.size())) {
                a2.j0(4).e0(false);
            } else {
                a2.j0(2);
            }
        }
        return Y3(a2, state, state.E.get(), list, i2, j2, false);
    }

    private static Size t4(SurfaceHolder surfaceHolder) {
        if (!surfaceHolder.getSurface().isValid()) {
            return Size.f9621d;
        }
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        return new Size(surfaceFrame.width(), surfaceFrame.height());
    }

    private static int u4(List<MediaItemData> list, List<MediaItemData> list2) {
        if (list.size() != list2.size()) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= list.size()) {
                return 1;
            }
            Object obj = list.get(i2).f9270a;
            Object obj2 = list2.get(i2).f9270a;
            if (!(obj instanceof PlaceholderUid) || (obj2 instanceof PlaceholderUid)) {
                z = false;
            }
            if (!obj.equals(obj2) && !z) {
                return 0;
            }
            i2++;
        }
    }

    public final void A(AudioAttributes audioAttributes, boolean z) {
        m6();
        State state = this.h1;
        if (h6(35)) {
            j6(F4(audioAttributes, z), new N0(state, audioAttributes));
        }
    }

    public final long A2() {
        m6();
        return this.h1.f9316j;
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> A4() {
        throw new IllegalStateException("Missing implementation to handle COMMAND_PREPARE");
    }

    public final float B() {
        m6();
        return this.h1.p;
    }

    public final int B0() {
        m6();
        return d4(this.h1, this.b1, this.g1);
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> B4() {
        throw new IllegalStateException("Missing implementation to handle COMMAND_RELEASE");
    }

    public final DeviceInfo C() {
        m6();
        return this.h1.s;
    }

    public final void C1(int i2) {
        m6();
        State state = this.h1;
        if (h6(34)) {
            j6(x4(i2), new U0(state));
        }
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> C4(int i2, int i3) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_CHANGE_MEDIA_ITEMS");
    }

    @Deprecated
    public final void D() {
        m6();
        State state = this.h1;
        if (h6(26)) {
            j6(x4(1), new A0(state));
        }
    }

    public final Tracks D1() {
        m6();
        return f4(this.h1);
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> D4(int i2, int i3, List<MediaItem> list) {
        return Util.F2(v4(i3, list), new Q0(C4(i2, i3)));
    }

    public final void E(@Nullable SurfaceView surfaceView) {
        m6();
        State state = this.h1;
        if (h6(27)) {
            if (surfaceView == null) {
                H();
            } else {
                j6(P4(surfaceView), new I0(state, surfaceView));
            }
        }
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> E4(int i2, long j2, int i3) {
        throw new IllegalStateException("Missing implementation to handle one of the COMMAND_SEEK_*");
    }

    public final void F(int i2, int i3, List<MediaItem> list) {
        m6();
        Assertions.a(i2 >= 0 && i2 <= i3);
        State state = this.h1;
        int size = state.y.size();
        if (h6(20) && i2 <= size) {
            int min = Math.min(i3, size);
            j6(D4(i2, min, list), new C0168q0(this, state, list, min, i2));
        }
    }

    public final void F0(List<MediaItem> list, boolean z) {
        m6();
        g6(list, z ? -1 : this.h1.B, z ? C.f9084b : this.h1.E.get());
    }

    @VisibleForTesting(otherwise = 4)
    public final void F2(int i2, long j2, int i3, boolean z) {
        m6();
        Assertions.a(i2 >= 0);
        State state = this.h1;
        if (h6(i3) && !c0()) {
            if (state.y.isEmpty() || i2 < state.y.size()) {
                k6(E4(i2, j2, i3), new O0(state, i2, j2), true, z);
            }
        }
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> F4(AudioAttributes audioAttributes, boolean z) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_AUDIO_ATTRIBUTES");
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> G4(boolean z, int i2) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME or COMMAND_ADJUST_DEVICE_VOLUME_WITH_FLAGS");
    }

    public final void H() {
        Z3((Object) null);
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> H4(@IntRange(from = 0) int i2, int i3) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_DEVICE_VOLUME or COMMAND_SET_DEVICE_VOLUME_WITH_FLAGS");
    }

    public final void I(@Nullable SurfaceHolder surfaceHolder) {
        m6();
        State state = this.h1;
        if (h6(27)) {
            if (surfaceHolder == null) {
                H();
            } else {
                j6(P4(surfaceHolder), new F0(state, surfaceHolder));
            }
        }
    }

    public final MediaMetadata I1() {
        m6();
        return this.h1.A;
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> I4(List<MediaItem> list, int i2, long j2) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_MEDIA_ITEM(S)");
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> J4(boolean z) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_PLAY_PAUSE");
    }

    public final void K0(int i2, int i3) {
        m6();
        State state = this.h1;
        if (h6(33)) {
            j6(H4(i2, i3), new C0191z0(state, i2));
        }
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> K4(PlaybackParameters playbackParameters) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_SPEED_AND_PITCH");
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> L4(MediaMetadata mediaMetadata) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_PLAYLIST_METADATA");
    }

    public final CueGroup M() {
        m6();
        return this.h1.r;
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> M4(int i2) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_REPEAT_MODE");
    }

    @Deprecated
    public final void N(boolean z) {
        m6();
        State state = this.h1;
        if (h6(26)) {
            j6(G4(z, 1), new J0(state, z));
        }
    }

    public final void N0(int i2) {
        m6();
        State state = this.h1;
        if (h6(34)) {
            j6(y4(i2), new C0183v0(state));
        }
    }

    public final void N1(Player.Listener listener) {
        m6();
        this.c1.l(listener);
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> N4(boolean z) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_SHUFFLE_MODE");
    }

    public final void O(@Nullable SurfaceView surfaceView) {
        Z3(surfaceView);
    }

    public final int O0() {
        m6();
        return this.h1.D;
    }

    public final int O1() {
        m6();
        return this.h1.C;
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> O4(TrackSelectionParameters trackSelectionParameters) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_TRACK_SELECTION_PARAMETERS");
    }

    public final int P1() {
        m6();
        return c4(this.h1);
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> P4(Object obj) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_VIDEO_SURFACE");
    }

    public final long Q() {
        m6();
        if (!c0()) {
            return A0();
        }
        this.h1.z.k(B0(), this.g1);
        Timeline.Period period = this.g1;
        State state = this.h1;
        return Util.H2(period.e(state.C, state.D));
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> Q4(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_VOLUME");
    }

    public final boolean R() {
        m6();
        return this.h1.u;
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> R4() {
        throw new IllegalStateException("Missing implementation to handle COMMAND_STOP");
    }

    /* access modifiers changed from: protected */
    public final void S4() {
        m6();
        if (this.f1.isEmpty() && !this.i1) {
            i6(q4(), false, false);
        }
    }

    public final Size T0() {
        m6();
        return this.h1.v;
    }

    @Deprecated
    public final void V() {
        m6();
        State state = this.h1;
        if (h6(26)) {
            j6(y4(1), new M0(state));
        }
    }

    public final void V0(MediaMetadata mediaMetadata) {
        m6();
        State state = this.h1;
        if (h6(19)) {
            j6(L4(mediaMetadata), new C0(state, mediaMetadata));
        }
    }

    @Deprecated
    public final void X(int i2) {
        m6();
        State state = this.h1;
        if (h6(25)) {
            j6(H4(i2, 1), new C0136a0(state, i2));
        }
    }

    public final void X1(TrackSelectionParameters trackSelectionParameters) {
        m6();
        State state = this.h1;
        if (h6(29)) {
            j6(O4(trackSelectionParameters), new X0(state, trackSelectionParameters));
        }
    }

    public final void Y(@Nullable TextureView textureView) {
        m6();
        State state = this.h1;
        if (h6(27)) {
            if (textureView == null) {
                H();
            } else {
                j6(P4(textureView), new C0158l0(state, textureView.isAvailable() ? new Size(textureView.getWidth(), textureView.getHeight()) : Size.f9621d));
            }
        }
    }

    public final void Z(@Nullable SurfaceHolder surfaceHolder) {
        Z3(surfaceHolder);
    }

    public final void a() {
        m6();
        State state = this.h1;
        if (h6(32)) {
            j6(B4(), new G0(state));
            this.i1 = true;
            this.c1.k();
            this.h1 = this.h1.a().j0(1).v0(PositionSupplier.f9306a).V(e1.a(b4(state))).Q(state.F).e0(false).O();
        }
    }

    public final boolean c() {
        m6();
        return this.h1.f9315i;
    }

    public final boolean c0() {
        m6();
        return this.h1.C != -1;
    }

    public final void c1(int i2, int i3) {
        int min;
        m6();
        Assertions.a(i2 >= 0 && i3 >= i2);
        State state = this.h1;
        int size = state.y.size();
        if (h6(20) && size != 0 && i2 < size && i2 != (min = Math.min(i3, size))) {
            j6(C4(i2, min), new P0(this, state, i2, min));
        }
    }

    public final void c2(int i2, int i3, int i4) {
        m6();
        Assertions.a(i2 >= 0 && i3 >= i2 && i4 >= 0);
        State state = this.h1;
        int size = state.y.size();
        if (h6(20) && size != 0 && i2 < size) {
            int min = Math.min(i3, size);
            int min2 = Math.min(i4, state.y.size() - (min - i2));
            if (i2 != min && min2 != i2) {
                j6(z4(i2, min, min2), new L0(this, state, i2, min, min2));
            }
        }
    }

    public final AudioAttributes d() {
        m6();
        return this.h1.o;
    }

    public final void f(PlaybackParameters playbackParameters) {
        m6();
        State state = this.h1;
        if (h6(13)) {
            j6(K4(playbackParameters), new V0(state, playbackParameters));
        }
    }

    public final void f2(Player.Listener listener) {
        this.c1.c((Player.Listener) Assertions.g(listener));
    }

    public final void g(float f2) {
        m6();
        State state = this.h1;
        if (h6(24)) {
            j6(Q4(f2), new E0(state, f2));
        }
    }

    public final int g2() {
        m6();
        return this.h1.f9311e;
    }

    public final long h0() {
        m6();
        return this.h1.I.get();
    }

    public final void h1(List<MediaItem> list, int i2, long j2) {
        m6();
        if (i2 == -1) {
            State state = this.h1;
            int i3 = state.B;
            long j3 = state.E.get();
            i2 = i3;
            j2 = j3;
        }
        g6(list, i2, j2);
    }

    public final int i() {
        m6();
        return this.h1.f9310d;
    }

    public final void i1(boolean z) {
        m6();
        State state = this.h1;
        if (h6(1)) {
            j6(J4(z), new O(state, z));
        }
    }

    @Nullable
    public final PlaybackException j() {
        m6();
        return this.h1.f9312f;
    }

    public final Player.Commands j0() {
        m6();
        return this.h1.f9307a;
    }

    public final Timeline j2() {
        m6();
        return this.h1.z;
    }

    public final void k() {
        m6();
        State state = this.h1;
        if (h6(2)) {
            j6(A4(), new T0(state));
        }
    }

    public final void k0(boolean z, int i2) {
        m6();
        State state = this.h1;
        if (h6(34)) {
            j6(G4(z, i2), new W0(state, z));
        }
    }

    public final Looper k2() {
        return this.d1;
    }

    public final long l1() {
        m6();
        return this.h1.f9317k;
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public MediaItemData l4(MediaItem mediaItem) {
        return new MediaItemData.Builder((Object) new PlaceholderUid()).z(mediaItem).u(true).v(true).q();
    }

    /* access modifiers changed from: protected */
    public final void l6() {
        if (Thread.currentThread() != this.d1.getThread()) {
            throw new IllegalStateException(Util.S("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\n", Thread.currentThread().getName(), this.d1.getThread().getName()));
        }
    }

    public final boolean m0() {
        m6();
        return this.h1.f9308b;
    }

    public final boolean m2() {
        m6();
        return this.h1.f9314h;
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public State m4(State state) {
        return state;
    }

    public final long n1() {
        m6();
        return b4(this.h1);
    }

    public final TrackSelectionParameters o2() {
        m6();
        return this.h1.f9320n;
    }

    public final void p(int i2) {
        m6();
        State state = this.h1;
        if (h6(15)) {
            j6(M4(i2), new D0(state, i2));
        }
    }

    public final void p0(boolean z) {
        m6();
        State state = this.h1;
        if (h6(14)) {
            j6(N4(z), new C0189y0(state, z));
        }
    }

    public final long p2() {
        m6();
        return Math.max(a4(this.h1), b4(this.h1));
    }

    public final int q() {
        m6();
        return this.h1.f9313g;
    }

    public final void q1(int i2, List<MediaItem> list) {
        m6();
        Assertions.a(i2 >= 0);
        State state = this.h1;
        int size = state.y.size();
        if (h6(20) && !list.isEmpty()) {
            int min = Math.min(i2, size);
            j6(v4(min, list), new C0187x0(this, state, list, min));
        }
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract State q4();

    public final PlaybackParameters r() {
        m6();
        return this.h1.f9319m;
    }

    public final void stop() {
        m6();
        State state = this.h1;
        if (h6(3)) {
            j6(R4(), new R0(state));
        }
    }

    public final int u() {
        m6();
        return this.h1.t;
    }

    public final long u1() {
        m6();
        return c0() ? Math.max(this.h1.H.get(), this.h1.F.get()) : p2();
    }

    public final void v(@Nullable Surface surface) {
        m6();
        State state = this.h1;
        if (h6(27)) {
            if (surface == null) {
                H();
            } else {
                j6(P4(surface), new C0172s0(state));
            }
        }
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> v4(int i2, List<MediaItem> list) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_CHANGE_MEDIA_ITEMS");
    }

    public final void w(@Nullable Surface surface) {
        Z3(surface);
    }

    public final long w0() {
        m6();
        return this.h1.f9318l;
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> w4(@Nullable Object obj) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_SET_VIDEO_SURFACE");
    }

    public final MediaMetadata x2() {
        m6();
        return i4(this.h1);
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> x4(int i2) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME or COMMAND_ADJUST_DEVICE_VOLUME_WITH_FLAGS");
    }

    public final void y(@Nullable TextureView textureView) {
        Z3(textureView);
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> y4(int i2) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_ADJUST_DEVICE_VOLUME or COMMAND_ADJUST_DEVICE_VOLUME_WITH_FLAGS");
    }

    public final VideoSize z() {
        m6();
        return this.h1.q;
    }

    public final long z2() {
        m6();
        return c0() ? this.h1.F.get() : n1();
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public ListenableFuture<?> z4(int i2, int i3, int i4) {
        throw new IllegalStateException("Missing implementation to handle COMMAND_CHANGE_MEDIA_ITEMS");
    }

    protected SimpleBasePlayer(Looper looper, Clock clock) {
        this.d1 = looper;
        this.e1 = clock.e(looper, (Handler.Callback) null);
        this.f1 = new HashSet<>();
        this.g1 = new Timeline.Period();
        this.c1 = new ListenerSet<>(looper, clock, new B0(this));
    }
}
