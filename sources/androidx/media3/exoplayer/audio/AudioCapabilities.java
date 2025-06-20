package androidx.media3.exoplayer.audio;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@UnstableApi
public final class AudioCapabilities {
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    static final int f10741c = 10;
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    static final int f10742d = 48000;

    /* renamed from: e  reason: collision with root package name */
    public static final AudioCapabilities f10743e = new AudioCapabilities(ImmutableList.K(AudioProfile.f10750d));
    @SuppressLint({"InlinedApi"})

    /* renamed from: f  reason: collision with root package name */
    private static final ImmutableList<Integer> f10744f = ImmutableList.M(2, 5, 6);
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    static final ImmutableMap<Integer, Integer> f10745g = new ImmutableMap.Builder().i(5, 6).i(17, 6).i(7, 6).i(30, 10).i(18, 6).i(6, 8).i(8, 8).i(14, 8).d();

    /* renamed from: h  reason: collision with root package name */
    private static final String f10746h = "external_surround_sound_enabled";

    /* renamed from: i  reason: collision with root package name */
    private static final String f10747i = "use_external_surround_sound_flag";

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<AudioProfile> f10748a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10749b;

    @RequiresApi(23)
    private static final class Api23 {
        private Api23() {
        }

        @DoNotInline
        private static ImmutableSet<Integer> a() {
            ImmutableSet.Builder k2 = new ImmutableSet.Builder().b(8, 7);
            int i2 = Util.f9646a;
            if (i2 >= 31) {
                k2.b(26, 27);
            }
            if (i2 >= 33) {
                k2.g(30);
            }
            return k2.e();
        }

        @DoNotInline
        public static boolean b(AudioManager audioManager, @Nullable AudioDeviceInfoApi23 audioDeviceInfoApi23) {
            AudioDeviceInfo[] a2 = audioDeviceInfoApi23 == null ? ((AudioManager) Assertions.g(audioManager)).getDevices(2) : new AudioDeviceInfo[]{audioDeviceInfoApi23.f10769a};
            ImmutableSet<Integer> a3 = a();
            for (AudioDeviceInfo a4 : a2) {
                if (a3.contains(Integer.valueOf(a4.getType()))) {
                    return true;
                }
            }
            return false;
        }
    }

    @RequiresApi(29)
    private static final class Api29 {
        private Api29() {
        }

        @DoNotInline
        public static ImmutableList<Integer> a(AudioAttributes audioAttributes) {
            ImmutableList.Builder r = ImmutableList.r();
            UnmodifiableIterator<Integer> k2 = AudioCapabilities.f10745g.keySet().iterator();
            while (k2.hasNext()) {
                Integer next = k2.next();
                int intValue = next.intValue();
                if (Util.f9646a >= Util.X(intValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), audioAttributes.c().f9067a)) {
                    r.g(next);
                }
            }
            r.g(2);
            return r.e();
        }

        @DoNotInline
        public static int b(int i2, int i3, AudioAttributes audioAttributes) {
            for (int i4 = 10; i4 > 0; i4--) {
                int a0 = Util.a0(i4);
                if (a0 != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i2).setSampleRate(i3).setChannelMask(a0).build(), audioAttributes.c().f9067a)) {
                    return i4;
                }
            }
            return 0;
        }
    }

    @RequiresApi(33)
    private static final class Api33 {
        private Api33() {
        }

        @DoNotInline
        public static AudioCapabilities a(AudioManager audioManager, AudioAttributes audioAttributes) {
            return new AudioCapabilities((List) AudioCapabilities.c(audioManager.getDirectProfilesForAttributes(audioAttributes.c().f9067a)));
        }

        @DoNotInline
        @Nullable
        public static AudioDeviceInfoApi23 b(AudioManager audioManager, AudioAttributes audioAttributes) {
            try {
                List a2 = ((AudioManager) Assertions.g(audioManager)).getAudioDevicesForAttributes(audioAttributes.c().f9067a);
                if (a2.isEmpty()) {
                    return null;
                }
                return new AudioDeviceInfoApi23(C0262g.a(a2.get(0)));
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }

    private static final class AudioProfile {

        /* renamed from: d  reason: collision with root package name */
        public static final AudioProfile f10750d = (Util.f9646a >= 33 ? new AudioProfile(2, (Set<Integer>) a(10)) : new AudioProfile(2, 10));

        /* renamed from: a  reason: collision with root package name */
        public final int f10751a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10752b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableSet<Integer> f10753c;

        public AudioProfile(int i2, int i3) {
            this.f10751a = i2;
            this.f10752b = i3;
            this.f10753c = null;
        }

        private static ImmutableSet<Integer> a(int i2) {
            ImmutableSet.Builder builder = new ImmutableSet.Builder();
            for (int i3 = 1; i3 <= i2; i3++) {
                builder.g(Integer.valueOf(Util.a0(i3)));
            }
            return builder.e();
        }

        public int b(int i2, AudioAttributes audioAttributes) {
            if (this.f10753c != null) {
                return this.f10752b;
            }
            return Util.f9646a >= 29 ? Api29.b(this.f10751a, i2, audioAttributes) : ((Integer) Assertions.g(AudioCapabilities.f10745g.getOrDefault(Integer.valueOf(this.f10751a), 0))).intValue();
        }

        public boolean c(int i2) {
            if (this.f10753c == null) {
                return i2 <= this.f10752b;
            }
            int a0 = Util.a0(i2);
            if (a0 == 0) {
                return false;
            }
            return this.f10753c.contains(Integer.valueOf(a0));
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioProfile)) {
                return false;
            }
            AudioProfile audioProfile = (AudioProfile) obj;
            return this.f10751a == audioProfile.f10751a && this.f10752b == audioProfile.f10752b && Util.g(this.f10753c, audioProfile.f10753c);
        }

        public int hashCode() {
            int i2 = ((this.f10751a * 31) + this.f10752b) * 31;
            ImmutableSet<Integer> immutableSet = this.f10753c;
            return i2 + (immutableSet == null ? 0 : immutableSet.hashCode());
        }

        public String toString() {
            return "AudioProfile[format=" + this.f10751a + ", maxChannelCount=" + this.f10752b + ", channelMasks=" + this.f10753c + "]";
        }

        @RequiresApi(33)
        public AudioProfile(int i2, Set<Integer> set) {
            this.f10751a = i2;
            ImmutableSet<Integer> C = ImmutableSet.C(set);
            this.f10753c = C;
            UnmodifiableIterator<Integer> k2 = C.iterator();
            int i3 = 0;
            while (k2.hasNext()) {
                i3 = Math.max(i3, Integer.bitCount(k2.next().intValue()));
            }
            this.f10752b = i3;
        }
    }

    private AudioCapabilities(List<AudioProfile> list) {
        this.f10748a = new SparseArray<>();
        for (int i2 = 0; i2 < list.size(); i2++) {
            AudioProfile audioProfile = list.get(i2);
            this.f10748a.put(audioProfile.f10751a, audioProfile);
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f10748a.size(); i4++) {
            i3 = Math.max(i3, this.f10748a.valueAt(i4).f10752b);
        }
        this.f10749b = i3;
    }

    private static boolean b() {
        if (Util.f9646a >= 17) {
            String str = Util.f9648c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    @RequiresApi(33)
    @SuppressLint({"WrongConstant"})
    public static ImmutableList<AudioProfile> c(List<android.media.AudioProfile> list) {
        HashMap hashMap = new HashMap();
        hashMap.put(2, new HashSet(Ints.c(12)));
        for (int i2 = 0; i2 < list.size(); i2++) {
            android.media.AudioProfile a2 = C0256a.a(list.get(i2));
            if (a2.getEncapsulationType() != 1) {
                int a3 = a2.getFormat();
                if (Util.i1(a3) || f10745g.containsKey(Integer.valueOf(a3))) {
                    boolean containsKey = hashMap.containsKey(Integer.valueOf(a3));
                    Integer valueOf = Integer.valueOf(a3);
                    if (containsKey) {
                        ((Set) Assertions.g((Set) hashMap.get(valueOf))).addAll(Ints.c(a2.getChannelMasks()));
                    } else {
                        hashMap.put(valueOf, new HashSet(Ints.c(a2.getChannelMasks())));
                    }
                }
            }
        }
        ImmutableList.Builder r = ImmutableList.r();
        for (Map.Entry entry : hashMap.entrySet()) {
            r.g(new AudioProfile(((Integer) entry.getKey()).intValue(), (Set<Integer>) (Set) entry.getValue()));
        }
        return r.e();
    }

    private static ImmutableList<AudioProfile> d(@Nullable int[] iArr, int i2) {
        ImmutableList.Builder r = ImmutableList.r();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int audioProfile : iArr) {
            r.g(new AudioProfile(audioProfile, i2));
        }
        return r.e();
    }

    @Deprecated
    public static AudioCapabilities e(Context context) {
        return f(context, AudioAttributes.Z2, (AudioDeviceInfo) null);
    }

    public static AudioCapabilities f(Context context, AudioAttributes audioAttributes, @Nullable AudioDeviceInfo audioDeviceInfo) {
        return h(context, audioAttributes, (Util.f9646a < 23 || audioDeviceInfo == null) ? null : new AudioDeviceInfoApi23(audioDeviceInfo));
    }

    @SuppressLint({"InlinedApi"})
    static AudioCapabilities g(Context context, @Nullable Intent intent, AudioAttributes audioAttributes, @Nullable AudioDeviceInfoApi23 audioDeviceInfoApi23) {
        AudioManager audioManager = (AudioManager) Assertions.g(context.getSystemService("audio"));
        if (audioDeviceInfoApi23 == null) {
            audioDeviceInfoApi23 = Util.f9646a >= 33 ? Api33.b(audioManager, audioAttributes) : null;
        }
        int i2 = Util.f9646a;
        if (i2 >= 33 && (Util.q1(context) || Util.f1(context))) {
            return Api33.a(audioManager, audioAttributes);
        }
        if (i2 >= 23 && Api23.b(audioManager, audioDeviceInfoApi23)) {
            return f10743e;
        }
        ImmutableSet.Builder builder = new ImmutableSet.Builder();
        builder.g(2);
        if (i2 < 29 || (!Util.q1(context) && !Util.f1(context))) {
            ContentResolver contentResolver = context.getContentResolver();
            boolean z = Settings.Global.getInt(contentResolver, f10747i, 0) == 1;
            if ((z || b()) && Settings.Global.getInt(contentResolver, f10746h, 0) == 1) {
                builder.c(f10744f);
            }
            if (intent == null || z || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
                return new AudioCapabilities(d(Ints.D(builder.e()), 10));
            }
            int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
            if (intArrayExtra != null) {
                builder.c(Ints.c(intArrayExtra));
            }
            return new AudioCapabilities(d(Ints.D(builder.e()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
        }
        builder.c(Api29.a(audioAttributes));
        return new AudioCapabilities(d(Ints.D(builder.e()), 10));
    }

    @SuppressLint({"UnprotectedReceiver"})
    static AudioCapabilities h(Context context, AudioAttributes audioAttributes, @Nullable AudioDeviceInfoApi23 audioDeviceInfoApi23) {
        return g(context, context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), audioAttributes, audioDeviceInfoApi23);
    }

    private static int i(int i2) {
        int i3 = Util.f9646a;
        if (i3 <= 28) {
            if (i2 == 7) {
                i2 = 8;
            } else if (i2 == 3 || i2 == 4 || i2 == 5) {
                i2 = 6;
            }
        }
        if (i3 <= 26 && "fugu".equals(Util.f9647b) && i2 == 1) {
            i2 = 2;
        }
        return Util.a0(i2);
    }

    @Nullable
    static Uri l() {
        if (b()) {
            return Settings.Global.getUriFor(f10746h);
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        return Util.A(this.f10748a, audioCapabilities.f10748a) && this.f10749b == audioCapabilities.f10749b;
    }

    public int hashCode() {
        return this.f10749b + (Util.B(this.f10748a) * 31);
    }

    @Deprecated
    @Nullable
    public Pair<Integer, Integer> j(Format format) {
        return k(format, AudioAttributes.Z2);
    }

    @Nullable
    public Pair<Integer, Integer> k(Format format, AudioAttributes audioAttributes) {
        int f2 = MimeTypes.f((String) Assertions.g(format.f3), format.c3);
        if (!f10745g.containsKey(Integer.valueOf(f2))) {
            return null;
        }
        if (f2 == 18 && !p(18)) {
            f2 = 6;
        } else if ((f2 == 8 && !p(8)) || (f2 == 30 && !p(30))) {
            f2 = 7;
        }
        if (!p(f2)) {
            return null;
        }
        AudioProfile audioProfile = (AudioProfile) Assertions.g(this.f10748a.get(f2));
        int i2 = format.s3;
        if (i2 == -1 || f2 == 18) {
            int i3 = format.t3;
            if (i3 == -1) {
                i3 = 48000;
            }
            i2 = audioProfile.b(i3, audioAttributes);
        } else if (!format.f3.equals(MimeTypes.Y) || Util.f9646a >= 33) {
            if (!audioProfile.c(i2)) {
                return null;
            }
        } else if (i2 > 10) {
            return null;
        }
        int i4 = i(i2);
        if (i4 == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(f2), Integer.valueOf(i4));
    }

    public int m() {
        return this.f10749b;
    }

    @Deprecated
    public boolean n(Format format) {
        return o(format, AudioAttributes.Z2);
    }

    public boolean o(Format format, AudioAttributes audioAttributes) {
        return k(format, audioAttributes) != null;
    }

    public boolean p(int i2) {
        return Util.y(this.f10748a, i2);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f10749b + ", audioProfiles=" + this.f10748a + "]";
    }

    @Deprecated
    public AudioCapabilities(@Nullable int[] iArr, int i2) {
        this(d(iArr, i2));
    }
}
