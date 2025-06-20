package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MediaSessionCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String A = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String B = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String C = "android.support.v4.media.session.action.ARGUMENT_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String D = "android.support.v4.media.session.action.ARGUMENT_RATING";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String E = "android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String F = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String G = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String H = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String I = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String J = "android.support.v4.media.session.TOKEN";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String K = "android.support.v4.media.session.EXTRA_BINDER";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String L = "android.support.v4.media.session.SESSION_TOKEN2";
    private static final int M = 320;
    private static final String N = "data_calling_pkg";
    private static final String O = "data_calling_pid";
    private static final String P = "data_calling_uid";
    private static final String Q = "data_extras";
    static int R = 0;

    /* renamed from: d  reason: collision with root package name */
    static final String f2316d = "MediaSessionCompat";
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static final int f2317e = 1;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final int f2318f = 2;

    /* renamed from: g  reason: collision with root package name */
    public static final int f2319g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static final String f2320h = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";

    /* renamed from: i  reason: collision with root package name */
    public static final String f2321i = "android.support.v4.media.session.action.SKIP_AD";

    /* renamed from: j  reason: collision with root package name */
    public static final String f2322j = "android.support.v4.media.session.action.FOLLOW";

    /* renamed from: k  reason: collision with root package name */
    public static final String f2323k = "android.support.v4.media.session.action.UNFOLLOW";

    /* renamed from: l  reason: collision with root package name */
    public static final String f2324l = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";

    /* renamed from: m  reason: collision with root package name */
    public static final String f2325m = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";

    /* renamed from: n  reason: collision with root package name */
    public static final int f2326n = 0;
    public static final int o = 1;
    public static final int p = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String q = "android.support.v4.media.session.action.PLAY_FROM_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String r = "android.support.v4.media.session.action.PREPARE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String s = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String t = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String u = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String v = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String w = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String x = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String y = "android.support.v4.media.session.action.SET_RATING";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String z = "android.support.v4.media.session.action.SET_PLAYBACK_SPEED";

    /* renamed from: a  reason: collision with root package name */
    private final MediaSessionImpl f2327a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaControllerCompat f2328b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<OnActiveChangeListener> f2329c;

    public static abstract class Callback {

        /* renamed from: a  reason: collision with root package name */
        final Object f2331a = new Object();

        /* renamed from: b  reason: collision with root package name */
        final MediaSession.Callback f2332b = new MediaSessionCallbackApi21();

        /* renamed from: c  reason: collision with root package name */
        private boolean f2333c;
        @GuardedBy("mLock")

        /* renamed from: d  reason: collision with root package name */
        WeakReference<MediaSessionImpl> f2334d = new WeakReference<>((Object) null);
        @GuardedBy("mLock")

        /* renamed from: e  reason: collision with root package name */
        CallbackHandler f2335e;

        private class CallbackHandler extends Handler {

            /* renamed from: b  reason: collision with root package name */
            private static final int f2336b = 1;

            CallbackHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                MediaSessionImpl mediaSessionImpl;
                Callback callback;
                CallbackHandler callbackHandler;
                if (message.what == 1) {
                    synchronized (Callback.this.f2331a) {
                        mediaSessionImpl = Callback.this.f2334d.get();
                        callback = Callback.this;
                        callbackHandler = callback.f2335e;
                    }
                    if (mediaSessionImpl != null && callback == mediaSessionImpl.l() && callbackHandler != null) {
                        mediaSessionImpl.t((MediaSessionManager.RemoteUserInfo) message.obj);
                        Callback.this.a(mediaSessionImpl, callbackHandler);
                        mediaSessionImpl.t((MediaSessionManager.RemoteUserInfo) null);
                    }
                }
            }
        }

        @RequiresApi(21)
        private class MediaSessionCallbackApi21 extends MediaSession.Callback {
            MediaSessionCallbackApi21() {
            }

            private void a(MediaSessionImpl mediaSessionImpl) {
                mediaSessionImpl.t((MediaSessionManager.RemoteUserInfo) null);
            }

            private MediaSessionImplApi21 b() {
                MediaSessionImplApi21 mediaSessionImplApi21;
                synchronized (Callback.this.f2331a) {
                    mediaSessionImplApi21 = (MediaSessionImplApi21) Callback.this.f2334d.get();
                }
                if (mediaSessionImplApi21 == null || Callback.this != mediaSessionImplApi21.l()) {
                    return null;
                }
                return mediaSessionImplApi21;
            }

            private void c(MediaSessionImpl mediaSessionImpl) {
                if (Build.VERSION.SDK_INT < 28) {
                    String e2 = mediaSessionImpl.e();
                    if (TextUtils.isEmpty(e2)) {
                        e2 = MediaSessionManager.RemoteUserInfo.f8969b;
                    }
                    mediaSessionImpl.t(new MediaSessionManager.RemoteUserInfo(e2, -1, -1));
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.support.v4.media.session.MediaSessionCompat$QueueItem} */
            /* JADX WARNING: type inference failed for: r2v0 */
            /* JADX WARNING: type inference failed for: r2v4, types: [android.os.IBinder] */
            /* JADX WARNING: type inference failed for: r2v6 */
            /* JADX WARNING: type inference failed for: r2v7 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onCommand(java.lang.String r6, android.os.Bundle r7, android.os.ResultReceiver r8) {
                /*
                    r5 = this;
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21 r0 = r5.b()
                    if (r0 != 0) goto L_0x0007
                    return
                L_0x0007:
                    android.support.v4.media.session.MediaSessionCompat.b(r7)
                    r5.c(r0)
                    java.lang.String r1 = "android.support.v4.media.session.command.GET_EXTRA_BINDER"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b5 }
                    r2 = 0
                    if (r1 == 0) goto L_0x003e
                    android.os.Bundle r6 = new android.os.Bundle     // Catch:{ BadParcelableException -> 0x00b5 }
                    r6.<init>()     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.support.v4.media.session.MediaSessionCompat$Token r7 = r0.k()     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.support.v4.media.session.IMediaSession r1 = r7.d()     // Catch:{ BadParcelableException -> 0x00b5 }
                    java.lang.String r3 = "android.support.v4.media.session.EXTRA_BINDER"
                    if (r1 != 0) goto L_0x0028
                    goto L_0x002c
                L_0x0028:
                    android.os.IBinder r2 = r1.asBinder()     // Catch:{ BadParcelableException -> 0x00b5 }
                L_0x002c:
                    androidx.core.app.BundleCompat.b(r6, r3, r2)     // Catch:{ BadParcelableException -> 0x00b5 }
                    java.lang.String r1 = "android.support.v4.media.session.SESSION_TOKEN2"
                    androidx.versionedparcelable.VersionedParcelable r7 = r7.g()     // Catch:{ BadParcelableException -> 0x00b5 }
                    androidx.versionedparcelable.ParcelUtils.e(r6, r1, r7)     // Catch:{ BadParcelableException -> 0x00b5 }
                    r7 = 0
                    r8.send(r7, r6)     // Catch:{ BadParcelableException -> 0x00b5 }
                    goto L_0x00bc
                L_0x003e:
                    java.lang.String r1 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b5 }
                    java.lang.String r3 = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"
                    if (r1 == 0) goto L_0x0054
                    android.support.v4.media.session.MediaSessionCompat$Callback r6 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.os.Parcelable r7 = r7.getParcelable(r3)     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.support.v4.media.MediaDescriptionCompat r7 = (android.support.v4.media.MediaDescriptionCompat) r7     // Catch:{ BadParcelableException -> 0x00b5 }
                    r6.b(r7)     // Catch:{ BadParcelableException -> 0x00b5 }
                    goto L_0x00bc
                L_0x0054:
                    java.lang.String r1 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b5 }
                    java.lang.String r4 = "android.support.v4.media.session.command.ARGUMENT_INDEX"
                    if (r1 == 0) goto L_0x006e
                    android.support.v4.media.session.MediaSessionCompat$Callback r6 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.os.Parcelable r8 = r7.getParcelable(r3)     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.support.v4.media.MediaDescriptionCompat r8 = (android.support.v4.media.MediaDescriptionCompat) r8     // Catch:{ BadParcelableException -> 0x00b5 }
                    int r7 = r7.getInt(r4)     // Catch:{ BadParcelableException -> 0x00b5 }
                    r6.c(r8, r7)     // Catch:{ BadParcelableException -> 0x00b5 }
                    goto L_0x00bc
                L_0x006e:
                    java.lang.String r1 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b5 }
                    if (r1 == 0) goto L_0x0082
                    android.support.v4.media.session.MediaSessionCompat$Callback r6 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.os.Parcelable r7 = r7.getParcelable(r3)     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.support.v4.media.MediaDescriptionCompat r7 = (android.support.v4.media.MediaDescriptionCompat) r7     // Catch:{ BadParcelableException -> 0x00b5 }
                L_0x007e:
                    r6.q(r7)     // Catch:{ BadParcelableException -> 0x00b5 }
                    goto L_0x00bc
                L_0x0082:
                    java.lang.String r1 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b5 }
                    if (r1 == 0) goto L_0x00af
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r6 = r0.f2349i     // Catch:{ BadParcelableException -> 0x00b5 }
                    if (r6 == 0) goto L_0x00bc
                    r6 = -1
                    int r6 = r7.getInt(r4, r6)     // Catch:{ BadParcelableException -> 0x00b5 }
                    if (r6 < 0) goto L_0x00a6
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r7 = r0.f2349i     // Catch:{ BadParcelableException -> 0x00b5 }
                    int r7 = r7.size()     // Catch:{ BadParcelableException -> 0x00b5 }
                    if (r6 >= r7) goto L_0x00a6
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r7 = r0.f2349i     // Catch:{ BadParcelableException -> 0x00b5 }
                    java.lang.Object r6 = r7.get(r6)     // Catch:{ BadParcelableException -> 0x00b5 }
                    r2 = r6
                    android.support.v4.media.session.MediaSessionCompat$QueueItem r2 = (android.support.v4.media.session.MediaSessionCompat.QueueItem) r2     // Catch:{ BadParcelableException -> 0x00b5 }
                L_0x00a6:
                    if (r2 == 0) goto L_0x00bc
                    android.support.v4.media.session.MediaSessionCompat$Callback r6 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b5 }
                    android.support.v4.media.MediaDescriptionCompat r7 = r2.c()     // Catch:{ BadParcelableException -> 0x00b5 }
                    goto L_0x007e
                L_0x00af:
                    android.support.v4.media.session.MediaSessionCompat$Callback r1 = android.support.v4.media.session.MediaSessionCompat.Callback.this     // Catch:{ BadParcelableException -> 0x00b5 }
                    r1.d(r6, r7, r8)     // Catch:{ BadParcelableException -> 0x00b5 }
                    goto L_0x00bc
                L_0x00b5:
                    java.lang.String r6 = "MediaSessionCompat"
                    java.lang.String r7 = "Could not unparcel the extra data."
                    android.util.Log.e(r6, r7)
                L_0x00bc:
                    r5.a(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.Callback.MediaSessionCallbackApi21.onCommand(java.lang.String, android.os.Bundle, android.os.ResultReceiver):void");
            }

            public void onCustomAction(String str, Bundle bundle) {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    MediaSessionCompat.b(bundle);
                    c(b2);
                    try {
                        if (str.equals(MediaSessionCompat.q)) {
                            Bundle bundle2 = bundle.getBundle(MediaSessionCompat.F);
                            MediaSessionCompat.b(bundle2);
                            Callback.this.l((Uri) bundle.getParcelable(MediaSessionCompat.C), bundle2);
                        } else if (str.equals(MediaSessionCompat.r)) {
                            Callback.this.m();
                        } else if (str.equals(MediaSessionCompat.s)) {
                            String string = bundle.getString(MediaSessionCompat.A);
                            Bundle bundle3 = bundle.getBundle(MediaSessionCompat.F);
                            MediaSessionCompat.b(bundle3);
                            Callback.this.n(string, bundle3);
                        } else if (str.equals(MediaSessionCompat.t)) {
                            String string2 = bundle.getString(MediaSessionCompat.B);
                            Bundle bundle4 = bundle.getBundle(MediaSessionCompat.F);
                            MediaSessionCompat.b(bundle4);
                            Callback.this.o(string2, bundle4);
                        } else if (str.equals(MediaSessionCompat.u)) {
                            Bundle bundle5 = bundle.getBundle(MediaSessionCompat.F);
                            MediaSessionCompat.b(bundle5);
                            Callback.this.p((Uri) bundle.getParcelable(MediaSessionCompat.C), bundle5);
                        } else if (str.equals(MediaSessionCompat.v)) {
                            Callback.this.u(bundle.getBoolean(MediaSessionCompat.G));
                        } else if (str.equals(MediaSessionCompat.w)) {
                            Callback.this.y(bundle.getInt(MediaSessionCompat.H));
                        } else if (str.equals(MediaSessionCompat.x)) {
                            Callback.this.z(bundle.getInt(MediaSessionCompat.I));
                        } else if (str.equals(MediaSessionCompat.y)) {
                            Bundle bundle6 = bundle.getBundle(MediaSessionCompat.F);
                            MediaSessionCompat.b(bundle6);
                            Callback.this.x((RatingCompat) bundle.getParcelable(MediaSessionCompat.D), bundle6);
                        } else if (str.equals(MediaSessionCompat.z)) {
                            Callback.this.v(bundle.getFloat(MediaSessionCompat.E, 1.0f));
                        } else {
                            Callback.this.e(str, bundle);
                        }
                    } catch (BadParcelableException unused) {
                        Log.e(MediaSessionCompat.f2316d, "Could not unparcel the data.");
                    }
                    a(b2);
                }
            }

            public void onFastForward() {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    c(b2);
                    Callback.this.f();
                    a(b2);
                }
            }

            public boolean onMediaButtonEvent(Intent intent) {
                MediaSessionImplApi21 b2 = b();
                if (b2 == null) {
                    return false;
                }
                c(b2);
                boolean g2 = Callback.this.g(intent);
                a(b2);
                return g2 || super.onMediaButtonEvent(intent);
            }

            public void onPause() {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    c(b2);
                    Callback.this.h();
                    a(b2);
                }
            }

            public void onPlay() {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    c(b2);
                    Callback.this.i();
                    a(b2);
                }
            }

            public void onPlayFromMediaId(String str, Bundle bundle) {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    MediaSessionCompat.b(bundle);
                    c(b2);
                    Callback.this.j(str, bundle);
                    a(b2);
                }
            }

            public void onPlayFromSearch(String str, Bundle bundle) {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    MediaSessionCompat.b(bundle);
                    c(b2);
                    Callback.this.k(str, bundle);
                    a(b2);
                }
            }

            @RequiresApi(23)
            public void onPlayFromUri(Uri uri, Bundle bundle) {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    MediaSessionCompat.b(bundle);
                    c(b2);
                    Callback.this.l(uri, bundle);
                    a(b2);
                }
            }

            @RequiresApi(24)
            public void onPrepare() {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    c(b2);
                    Callback.this.m();
                    a(b2);
                }
            }

            @RequiresApi(24)
            public void onPrepareFromMediaId(String str, Bundle bundle) {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    MediaSessionCompat.b(bundle);
                    c(b2);
                    Callback.this.n(str, bundle);
                    a(b2);
                }
            }

            @RequiresApi(24)
            public void onPrepareFromSearch(String str, Bundle bundle) {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    MediaSessionCompat.b(bundle);
                    c(b2);
                    Callback.this.o(str, bundle);
                    a(b2);
                }
            }

            @RequiresApi(24)
            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    MediaSessionCompat.b(bundle);
                    c(b2);
                    Callback.this.p(uri, bundle);
                    a(b2);
                }
            }

            public void onRewind() {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    c(b2);
                    Callback.this.s();
                    a(b2);
                }
            }

            public void onSeekTo(long j2) {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    c(b2);
                    Callback.this.t(j2);
                    a(b2);
                }
            }

            @RequiresApi(29)
            public void onSetPlaybackSpeed(float f2) {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    c(b2);
                    Callback.this.v(f2);
                    a(b2);
                }
            }

            public void onSetRating(Rating rating) {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    c(b2);
                    Callback.this.w(RatingCompat.a(rating));
                    a(b2);
                }
            }

            public void onSkipToNext() {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    c(b2);
                    Callback.this.A();
                    a(b2);
                }
            }

            public void onSkipToPrevious() {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    c(b2);
                    Callback.this.B();
                    a(b2);
                }
            }

            public void onSkipToQueueItem(long j2) {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    c(b2);
                    Callback.this.C(j2);
                    a(b2);
                }
            }

            public void onStop() {
                MediaSessionImplApi21 b2 = b();
                if (b2 != null) {
                    c(b2);
                    Callback.this.D();
                    a(b2);
                }
            }
        }

        public void A() {
        }

        public void B() {
        }

        public void C(long j2) {
        }

        public void D() {
        }

        /* access modifiers changed from: package-private */
        public void E(MediaSessionImpl mediaSessionImpl, Handler handler) {
            synchronized (this.f2331a) {
                try {
                    this.f2334d = new WeakReference<>(mediaSessionImpl);
                    CallbackHandler callbackHandler = this.f2335e;
                    CallbackHandler callbackHandler2 = null;
                    if (callbackHandler != null) {
                        callbackHandler.removeCallbacksAndMessages((Object) null);
                    }
                    if (mediaSessionImpl != null) {
                        if (handler != null) {
                            callbackHandler2 = new CallbackHandler(handler.getLooper());
                        }
                    }
                    this.f2335e = callbackHandler2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(MediaSessionImpl mediaSessionImpl, Handler handler) {
            if (this.f2333c) {
                boolean z = false;
                this.f2333c = false;
                handler.removeMessages(1);
                PlaybackStateCompat i2 = mediaSessionImpl.i();
                long b2 = i2 == null ? 0 : i2.b();
                boolean z2 = i2 != null && i2.z() == 3;
                boolean z3 = (516 & b2) != 0;
                if ((b2 & 514) != 0) {
                    z = true;
                }
                if (z2 && z) {
                    h();
                } else if (!z2 && z3) {
                    i();
                }
            }
        }

        public void b(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void c(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
        }

        public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void e(String str, Bundle bundle) {
        }

        public void f() {
        }

        public boolean g(Intent intent) {
            MediaSessionImpl mediaSessionImpl;
            CallbackHandler callbackHandler;
            KeyEvent keyEvent;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.f2331a) {
                mediaSessionImpl = this.f2334d.get();
                callbackHandler = this.f2335e;
            }
            if (mediaSessionImpl == null || callbackHandler == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            MediaSessionManager.RemoteUserInfo y = mediaSessionImpl.y();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 79 || keyCode == 85) {
                if (keyEvent.getRepeatCount() != 0) {
                    a(mediaSessionImpl, callbackHandler);
                } else if (this.f2333c) {
                    callbackHandler.removeMessages(1);
                    this.f2333c = false;
                    PlaybackStateCompat i2 = mediaSessionImpl.i();
                    if (((i2 == null ? 0 : i2.b()) & 32) != 0) {
                        A();
                    }
                } else {
                    this.f2333c = true;
                    callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, y), (long) ViewConfiguration.getDoubleTapTimeout());
                }
                return true;
            }
            a(mediaSessionImpl, callbackHandler);
            return false;
        }

        public void h() {
        }

        public void i() {
        }

        public void j(String str, Bundle bundle) {
        }

        public void k(String str, Bundle bundle) {
        }

        public void l(Uri uri, Bundle bundle) {
        }

        public void m() {
        }

        public void n(String str, Bundle bundle) {
        }

        public void o(String str, Bundle bundle) {
        }

        public void p(Uri uri, Bundle bundle) {
        }

        public void q(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void r(int i2) {
        }

        public void s() {
        }

        public void t(long j2) {
        }

        public void u(boolean z) {
        }

        public void v(float f2) {
        }

        public void w(RatingCompat ratingCompat) {
        }

        public void x(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void y(int i2) {
        }

        public void z(int i2) {
        }
    }

    interface MediaSessionImpl {
        void H(boolean z);

        void L(int i2);

        void a();

        boolean b();

        void c(int i2);

        void d(String str, Bundle bundle);

        String e();

        void f(PendingIntent pendingIntent);

        void g(Callback callback, Handler handler);

        void h(int i2);

        PlaybackStateCompat i();

        void j(CharSequence charSequence);

        Token k();

        Callback l();

        void m(MediaMetadataCompat mediaMetadataCompat);

        void n(PendingIntent pendingIntent);

        void o(int i2);

        void p(int i2);

        void q(List<QueueItem> list);

        Object r();

        void s(boolean z);

        void setExtras(Bundle bundle);

        void t(MediaSessionManager.RemoteUserInfo remoteUserInfo);

        void u(PlaybackStateCompat playbackStateCompat);

        Object v();

        void w(@Nullable RegistrationCallback registrationCallback, @NonNull Handler handler);

        void x(VolumeProviderCompat volumeProviderCompat);

        MediaSessionManager.RemoteUserInfo y();
    }

    @RequiresApi(18)
    static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean G = true;

        MediaSessionImplApi18(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, componentName, pendingIntent, versionedParcelable, bundle);
        }

        /* access modifiers changed from: package-private */
        public int D(long j2) {
            int D = super.D(j2);
            return (j2 & 256) != 0 ? D | 256 : D;
        }

        /* access modifiers changed from: package-private */
        public void F(PendingIntent pendingIntent, ComponentName componentName) {
            if (G) {
                try {
                    this.f2361g.registerMediaButtonEventReceiver(pendingIntent);
                } catch (NullPointerException unused) {
                    Log.w(MediaSessionCompat.f2316d, "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                    G = false;
                }
            }
            if (!G) {
                super.F(pendingIntent, componentName);
            }
        }

        /* access modifiers changed from: package-private */
        public void T(PlaybackStateCompat playbackStateCompat) {
            long v = playbackStateCompat.v();
            float p = playbackStateCompat.p();
            long o = playbackStateCompat.o();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (playbackStateCompat.z() == 3) {
                long j2 = 0;
                if (v > 0) {
                    if (o > 0) {
                        j2 = elapsedRealtime - o;
                        if (p > 0.0f && p != 1.0f) {
                            j2 = (long) (((float) j2) * p);
                        }
                    }
                    v += j2;
                }
            }
            this.f2362h.setPlaybackState(C(playbackStateCompat.z()), v, p);
        }

        /* access modifiers changed from: package-private */
        public void V(PendingIntent pendingIntent, ComponentName componentName) {
            if (G) {
                this.f2361g.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.V(pendingIntent, componentName);
            }
        }

        public void g(Callback callback, Handler handler) {
            super.g(callback, handler);
            if (callback == null) {
                this.f2362h.setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener) null);
                return;
            }
            this.f2362h.setPlaybackPositionUpdateListener(new RemoteControlClient.OnPlaybackPositionUpdateListener() {
                public void onPlaybackPositionUpdate(long j2) {
                    MediaSessionImplApi18.this.E(18, -1, -1, Long.valueOf(j2), (Bundle) null);
                }
            });
        }
    }

    @RequiresApi(19)
    static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        MediaSessionImplApi19(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, componentName, pendingIntent, versionedParcelable, bundle);
        }

        /* access modifiers changed from: package-private */
        public RemoteControlClient.MetadataEditor A(Bundle bundle) {
            RemoteControlClient.MetadataEditor A = super.A(bundle);
            PlaybackStateCompat playbackStateCompat = this.s;
            if (((playbackStateCompat == null ? 0 : playbackStateCompat.b()) & 128) != 0) {
                A.addEditableKey(268435457);
            }
            if (bundle == null) {
                return A;
            }
            if (bundle.containsKey(MediaMetadataCompat.g3)) {
                A.putLong(8, bundle.getLong(MediaMetadataCompat.g3));
            }
            if (bundle.containsKey(MediaMetadataCompat.r3)) {
                A.putObject(101, bundle.getParcelable(MediaMetadataCompat.r3));
            }
            if (bundle.containsKey(MediaMetadataCompat.q3)) {
                A.putObject(268435457, bundle.getParcelable(MediaMetadataCompat.q3));
            }
            return A;
        }

        /* access modifiers changed from: package-private */
        public int D(long j2) {
            int D = super.D(j2);
            return (j2 & 128) != 0 ? D | 512 : D;
        }

        public void g(Callback callback, Handler handler) {
            super.g(callback, handler);
            if (callback == null) {
                this.f2362h.setMetadataUpdateListener((RemoteControlClient.OnMetadataUpdateListener) null);
                return;
            }
            this.f2362h.setMetadataUpdateListener(new RemoteControlClient.OnMetadataUpdateListener() {
                public void onMetadataUpdate(int i2, Object obj) {
                    if (i2 == 268435457 && (obj instanceof Rating)) {
                        MediaSessionImplApi19.this.E(19, -1, -1, RatingCompat.a(obj), (Bundle) null);
                    }
                }
            });
        }
    }

    @RequiresApi(21)
    static class MediaSessionImplApi21 implements MediaSessionImpl {

        /* renamed from: a  reason: collision with root package name */
        final MediaSession f2341a;

        /* renamed from: b  reason: collision with root package name */
        final ExtraSession f2342b;

        /* renamed from: c  reason: collision with root package name */
        final Token f2343c;

        /* renamed from: d  reason: collision with root package name */
        final Object f2344d = new Object();

        /* renamed from: e  reason: collision with root package name */
        Bundle f2345e;

        /* renamed from: f  reason: collision with root package name */
        boolean f2346f = false;

        /* renamed from: g  reason: collision with root package name */
        final RemoteCallbackList<IMediaControllerCallback> f2347g = new RemoteCallbackList<>();

        /* renamed from: h  reason: collision with root package name */
        PlaybackStateCompat f2348h;

        /* renamed from: i  reason: collision with root package name */
        List<QueueItem> f2349i;

        /* renamed from: j  reason: collision with root package name */
        MediaMetadataCompat f2350j;

        /* renamed from: k  reason: collision with root package name */
        int f2351k;

        /* renamed from: l  reason: collision with root package name */
        boolean f2352l;

        /* renamed from: m  reason: collision with root package name */
        int f2353m;

        /* renamed from: n  reason: collision with root package name */
        int f2354n;
        @GuardedBy("mLock")
        Callback o;
        @GuardedBy("mLock")
        RegistrationCallbackHandler p;
        @GuardedBy("mLock")
        MediaSessionManager.RemoteUserInfo q;

        private static class ExtraSession extends IMediaSession.Stub {
            private final AtomicReference<MediaSessionImplApi21> k0;

            ExtraSession(@NonNull MediaSessionImplApi21 mediaSessionImplApi21) {
                this.k0 = new AtomicReference<>(mediaSessionImplApi21);
            }

            public void A0(int i2, int i3, String str) {
                throw new AssertionError();
            }

            public void C0(RatingCompat ratingCompat, Bundle bundle) {
                throw new AssertionError();
            }

            public void E0(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
                throw new AssertionError();
            }

            public void G(long j2) {
                throw new AssertionError();
            }

            public void H(boolean z) {
                throw new AssertionError();
            }

            public int I() {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.k0.get();
                if (mediaSessionImplApi21 != null) {
                    return mediaSessionImplApi21.f2354n;
                }
                return -1;
            }

            public boolean J() {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.k0.get();
                return mediaSessionImplApi21 != null && mediaSessionImplApi21.f2352l;
            }

            public List<QueueItem> K() {
                return null;
            }

            public void K0(int i2) {
                throw new AssertionError();
            }

            public void L(int i2) throws RemoteException {
                throw new AssertionError();
            }

            public void M(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void N(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.k0.get();
                if (mediaSessionImplApi21 != null) {
                    int callingPid = Binder.getCallingPid();
                    int callingUid = Binder.getCallingUid();
                    mediaSessionImplApi21.f2347g.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.f8969b, callingPid, callingUid));
                    synchronized (mediaSessionImplApi21.f2344d) {
                        try {
                            RegistrationCallbackHandler registrationCallbackHandler = mediaSessionImplApi21.p;
                            if (registrationCallbackHandler != null) {
                                registrationCallbackHandler.a(callingPid, callingUid);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }

            public void N0(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            public boolean O() {
                return false;
            }

            public void P(RatingCompat ratingCompat) {
                throw new AssertionError();
            }

            public void P0() {
                throw new AssertionError();
            }

            public void Q(int i2, int i3, String str) {
                throw new AssertionError();
            }

            public void R(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public boolean S() {
                throw new AssertionError();
            }

            public void S0(long j2) {
                throw new AssertionError();
            }

            public void T0(boolean z) {
            }

            public PendingIntent U() {
                throw new AssertionError();
            }

            public ParcelableVolumeInfo V0() {
                throw new AssertionError();
            }

            public void W(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void f() {
                this.k0.set((Object) null);
            }

            public Bundle getExtras() {
                throw new AssertionError();
            }

            public void h() {
                throw new AssertionError();
            }

            public PlaybackStateCompat i() {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.k0.get();
                if (mediaSessionImplApi21 != null) {
                    return MediaSessionCompat.j(mediaSessionImplApi21.f2348h, mediaSessionImplApi21.f2350j);
                }
                return null;
            }

            public void i0(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public long j() {
                throw new AssertionError();
            }

            public void j0(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.k0.get();
                if (mediaSessionImplApi21 != null) {
                    mediaSessionImplApi21.f2347g.unregister(iMediaControllerCallback);
                    int callingPid = Binder.getCallingPid();
                    int callingUid = Binder.getCallingUid();
                    synchronized (mediaSessionImplApi21.f2344d) {
                        try {
                            RegistrationCallbackHandler registrationCallbackHandler = mediaSessionImplApi21.p;
                            if (registrationCallbackHandler != null) {
                                registrationCallbackHandler.b(callingPid, callingUid);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }

            public void k() throws RemoteException {
                throw new AssertionError();
            }

            public MediaMetadataCompat l() {
                throw new AssertionError();
            }

            public void m(float f2) {
                throw new AssertionError();
            }

            public void m0(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public String n() {
                throw new AssertionError();
            }

            public void next() {
                throw new AssertionError();
            }

            public void o() throws RemoteException {
                throw new AssertionError();
            }

            public void o0(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void p(int i2) {
                throw new AssertionError();
            }

            public void p0() {
                throw new AssertionError();
            }

            public void previous() {
                throw new AssertionError();
            }

            public int q() {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.k0.get();
                if (mediaSessionImplApi21 != null) {
                    return mediaSessionImplApi21.f2353m;
                }
                return -1;
            }

            public String r() {
                throw new AssertionError();
            }

            public void r0(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public void s(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void stop() {
                throw new AssertionError();
            }

            public void t(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public int u() {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.k0.get();
                if (mediaSessionImplApi21 != null) {
                    return mediaSessionImplApi21.f2351k;
                }
                return 0;
            }

            public CharSequence v() {
                throw new AssertionError();
            }

            public Bundle w() {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.k0.get();
                if (mediaSessionImplApi21.f2345e == null) {
                    return null;
                }
                return new Bundle(mediaSessionImplApi21.f2345e);
            }

            public boolean x0(KeyEvent keyEvent) {
                throw new AssertionError();
            }
        }

        MediaSessionImplApi21(Context context, String str, VersionedParcelable versionedParcelable, Bundle bundle) {
            MediaSession z = z(context, str, bundle);
            this.f2341a = z;
            ExtraSession extraSession = new ExtraSession(this);
            this.f2342b = extraSession;
            this.f2343c = new Token(z.getSessionToken(), extraSession, versionedParcelable);
            this.f2345e = bundle;
            c(3);
        }

        public void H(boolean z) {
            if (this.f2352l != z) {
                this.f2352l = z;
                synchronized (this.f2344d) {
                    for (int beginBroadcast = this.f2347g.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.f2347g.getBroadcastItem(beginBroadcast).s0(z);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.f2347g.finishBroadcast();
                }
            }
        }

        public void L(int i2) {
            if (this.f2354n != i2) {
                this.f2354n = i2;
                synchronized (this.f2344d) {
                    for (int beginBroadcast = this.f2347g.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.f2347g.getBroadcastItem(beginBroadcast).M0(i2);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.f2347g.finishBroadcast();
                }
            }
        }

        public void a() {
            this.f2346f = true;
            this.f2347g.kill();
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    Field declaredField = this.f2341a.getClass().getDeclaredField("mCallback");
                    declaredField.setAccessible(true);
                    Handler handler = (Handler) declaredField.get(this.f2341a);
                    if (handler != null) {
                        handler.removeCallbacksAndMessages((Object) null);
                    }
                } catch (Exception e2) {
                    Log.w(MediaSessionCompat.f2316d, "Exception happened while accessing MediaSession.mCallback.", e2);
                }
            }
            this.f2341a.setCallback((MediaSession.Callback) null);
            this.f2342b.f();
            this.f2341a.release();
        }

        public boolean b() {
            return this.f2341a.isActive();
        }

        @SuppressLint({"WrongConstant"})
        public void c(int i2) {
            this.f2341a.setFlags(i2 | 3);
        }

        public void d(String str, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 23) {
                synchronized (this.f2344d) {
                    for (int beginBroadcast = this.f2347g.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.f2347g.getBroadcastItem(beginBroadcast).y(str, bundle);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.f2347g.finishBroadcast();
                }
            }
            this.f2341a.sendSessionEvent(str, bundle);
        }

        public String e() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            try {
                return (String) this.f2341a.getClass().getMethod("getCallingPackage", (Class[]) null).invoke(this.f2341a, (Object[]) null);
            } catch (Exception e2) {
                Log.e(MediaSessionCompat.f2316d, "Cannot execute MediaSession.getCallingPackage()", e2);
                return null;
            }
        }

        public void f(PendingIntent pendingIntent) {
            this.f2341a.setSessionActivity(pendingIntent);
        }

        public void g(Callback callback, Handler handler) {
            synchronized (this.f2344d) {
                try {
                    this.o = callback;
                    this.f2341a.setCallback(callback == null ? null : callback.f2332b, handler);
                    if (callback != null) {
                        callback.E(this, handler);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void h(int i2) {
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setLegacyStreamType(i2);
            this.f2341a.setPlaybackToLocal(builder.build());
        }

        public PlaybackStateCompat i() {
            return this.f2348h;
        }

        public void j(CharSequence charSequence) {
            this.f2341a.setQueueTitle(charSequence);
        }

        public Token k() {
            return this.f2343c;
        }

        public Callback l() {
            Callback callback;
            synchronized (this.f2344d) {
                callback = this.o;
            }
            return callback;
        }

        public void m(MediaMetadataCompat mediaMetadataCompat) {
            this.f2350j = mediaMetadataCompat;
            this.f2341a.setMetadata(mediaMetadataCompat == null ? null : (MediaMetadata) mediaMetadataCompat.k());
        }

        public void n(PendingIntent pendingIntent) {
            this.f2341a.setMediaButtonReceiver(pendingIntent);
        }

        public void o(int i2) {
            this.f2351k = i2;
        }

        public void p(int i2) {
            if (this.f2353m != i2) {
                this.f2353m = i2;
                synchronized (this.f2344d) {
                    for (int beginBroadcast = this.f2347g.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.f2347g.getBroadcastItem(beginBroadcast).x(i2);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.f2347g.finishBroadcast();
                }
            }
        }

        public void q(List<QueueItem> list) {
            ArrayList arrayList;
            MediaSession mediaSession;
            this.f2349i = list;
            if (list == null) {
                mediaSession = this.f2341a;
                arrayList = null;
            } else {
                arrayList = new ArrayList(list.size());
                for (QueueItem g2 : list) {
                    arrayList.add((MediaSession.QueueItem) g2.g());
                }
                mediaSession = this.f2341a;
            }
            mediaSession.setQueue(arrayList);
        }

        public Object r() {
            return null;
        }

        public void s(boolean z) {
            this.f2341a.setActive(z);
        }

        public void setExtras(Bundle bundle) {
            this.f2341a.setExtras(bundle);
        }

        public void t(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            synchronized (this.f2344d) {
                this.q = remoteUserInfo;
            }
        }

        public void u(PlaybackStateCompat playbackStateCompat) {
            this.f2348h = playbackStateCompat;
            synchronized (this.f2344d) {
                for (int beginBroadcast = this.f2347g.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f2347g.getBroadcastItem(beginBroadcast).Z0(playbackStateCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.f2347g.finishBroadcast();
            }
            this.f2341a.setPlaybackState(playbackStateCompat == null ? null : (PlaybackState) playbackStateCompat.t());
        }

        public Object v() {
            return this.f2341a;
        }

        public void w(@Nullable RegistrationCallback registrationCallback, @NonNull Handler handler) {
            synchronized (this.f2344d) {
                try {
                    RegistrationCallbackHandler registrationCallbackHandler = this.p;
                    if (registrationCallbackHandler != null) {
                        registrationCallbackHandler.removeCallbacksAndMessages((Object) null);
                    }
                    if (registrationCallback != null) {
                        this.p = new RegistrationCallbackHandler(handler.getLooper(), registrationCallback);
                    } else {
                        this.p = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void x(VolumeProviderCompat volumeProviderCompat) {
            this.f2341a.setPlaybackToRemote((VolumeProvider) volumeProviderCompat.e());
        }

        public MediaSessionManager.RemoteUserInfo y() {
            MediaSessionManager.RemoteUserInfo remoteUserInfo;
            synchronized (this.f2344d) {
                remoteUserInfo = this.q;
            }
            return remoteUserInfo;
        }

        public MediaSession z(Context context, String str, Bundle bundle) {
            return new MediaSession(context, str);
        }

        MediaSessionImplApi21(Object obj) {
            if (obj instanceof MediaSession) {
                MediaSession mediaSession = (MediaSession) obj;
                this.f2341a = mediaSession;
                ExtraSession extraSession = new ExtraSession(this);
                this.f2342b = extraSession;
                this.f2343c = new Token(mediaSession.getSessionToken(), extraSession);
                this.f2345e = null;
                c(3);
                return;
            }
            throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
        }
    }

    @RequiresApi(22)
    static class MediaSessionImplApi22 extends MediaSessionImplApi21 {
        MediaSessionImplApi22(Context context, String str, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, versionedParcelable, bundle);
        }

        public void o(int i2) {
            this.f2341a.setRatingType(i2);
        }

        MediaSessionImplApi22(Object obj) {
            super(obj);
        }
    }

    @RequiresApi(28)
    static class MediaSessionImplApi28 extends MediaSessionImplApi22 {
        MediaSessionImplApi28(Context context, String str, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, versionedParcelable, bundle);
        }

        public void t(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        }

        @NonNull
        public final MediaSessionManager.RemoteUserInfo y() {
            return new MediaSessionManager.RemoteUserInfo(this.f2341a.getCurrentControllerInfo());
        }

        MediaSessionImplApi28(Object obj) {
            super(obj);
        }
    }

    @RequiresApi(29)
    static class MediaSessionImplApi29 extends MediaSessionImplApi28 {
        MediaSessionImplApi29(Context context, String str, VersionedParcelable versionedParcelable, Bundle bundle) {
            super(context, str, versionedParcelable, bundle);
        }

        public MediaSession z(Context context, String str, Bundle bundle) {
            return j.a(context, str, bundle);
        }

        MediaSessionImplApi29(Object obj) {
            super(obj);
            this.f2345e = ((MediaSession) obj).getController().getSessionInfo();
        }
    }

    static class MediaSessionImplBase implements MediaSessionImpl {
        static final int F = 0;
        Bundle A;
        int B;
        int C;
        VolumeProviderCompat D;
        private VolumeProviderCompat.Callback E = new VolumeProviderCompat.Callback() {
            public void a(VolumeProviderCompat volumeProviderCompat) {
                if (MediaSessionImplBase.this.D == volumeProviderCompat) {
                    MediaSessionImplBase mediaSessionImplBase = MediaSessionImplBase.this;
                    MediaSessionImplBase.this.S(new ParcelableVolumeInfo(mediaSessionImplBase.B, mediaSessionImplBase.C, volumeProviderCompat.c(), volumeProviderCompat.b(), volumeProviderCompat.a()));
                }
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final Context f2355a;

        /* renamed from: b  reason: collision with root package name */
        private final ComponentName f2356b;

        /* renamed from: c  reason: collision with root package name */
        private final PendingIntent f2357c;

        /* renamed from: d  reason: collision with root package name */
        private final MediaSessionStub f2358d;

        /* renamed from: e  reason: collision with root package name */
        private final Token f2359e;

        /* renamed from: f  reason: collision with root package name */
        final Bundle f2360f;

        /* renamed from: g  reason: collision with root package name */
        final AudioManager f2361g;

        /* renamed from: h  reason: collision with root package name */
        final RemoteControlClient f2362h;

        /* renamed from: i  reason: collision with root package name */
        final Object f2363i = new Object();

        /* renamed from: j  reason: collision with root package name */
        final RemoteCallbackList<IMediaControllerCallback> f2364j = new RemoteCallbackList<>();

        /* renamed from: k  reason: collision with root package name */
        private MessageHandler f2365k;

        /* renamed from: l  reason: collision with root package name */
        boolean f2366l = false;

        /* renamed from: m  reason: collision with root package name */
        boolean f2367m = false;

        /* renamed from: n  reason: collision with root package name */
        volatile Callback f2368n;
        private MediaSessionManager.RemoteUserInfo o;
        RegistrationCallbackHandler p;
        int q = 3;
        MediaMetadataCompat r;
        PlaybackStateCompat s;
        PendingIntent t;
        List<QueueItem> u;
        CharSequence v;
        int w;
        boolean x;
        int y;
        int z;

        private static final class Command {

            /* renamed from: a  reason: collision with root package name */
            public final String f2370a;

            /* renamed from: b  reason: collision with root package name */
            public final Bundle f2371b;

            /* renamed from: c  reason: collision with root package name */
            public final ResultReceiver f2372c;

            public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f2370a = str;
                this.f2371b = bundle;
                this.f2372c = resultReceiver;
            }
        }

        static class MediaSessionStub extends IMediaSession.Stub {
            private final AtomicReference<MediaSessionImplBase> k0;
            private final String l0;
            private final String m0;

            MediaSessionStub(MediaSessionImplBase mediaSessionImplBase, String str, String str2) {
                this.k0 = new AtomicReference<>(mediaSessionImplBase);
                this.l0 = str;
                this.m0 = str2;
            }

            public void A0(int i2, int i3, String str) {
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase != null) {
                    mediaSessionImplBase.z(i2, i3);
                }
            }

            public void C0(RatingCompat ratingCompat, Bundle bundle) {
                e1(31, ratingCompat, bundle);
            }

            public void E0(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
                d1(26, mediaDescriptionCompat, i2, (Bundle) null);
            }

            public void G(long j2) {
                u0(18, Long.valueOf(j2));
            }

            public void H(boolean z) {
                u0(29, Boolean.valueOf(z));
            }

            public int I() {
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase != null) {
                    return mediaSessionImplBase.z;
                }
                return -1;
            }

            public boolean J() {
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                return mediaSessionImplBase != null && mediaSessionImplBase.x;
            }

            public List<QueueItem> K() {
                List<QueueItem> list;
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase == null) {
                    return null;
                }
                synchronized (mediaSessionImplBase.f2363i) {
                    list = mediaSessionImplBase.u;
                }
                return list;
            }

            public void K0(int i2) {
                z(28, i2);
            }

            public void L(int i2) {
                z(30, i2);
            }

            public void M(String str, Bundle bundle) throws RemoteException {
                e1(20, str, bundle);
            }

            public void N(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase == null) {
                    try {
                        iMediaControllerCallback.D0();
                    } catch (Exception unused) {
                    }
                } else {
                    int callingPid = Binder.getCallingPid();
                    int callingUid = Binder.getCallingUid();
                    mediaSessionImplBase.f2364j.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(mediaSessionImplBase.B(callingUid), callingPid, callingUid));
                    synchronized (mediaSessionImplBase.f2363i) {
                        try {
                            RegistrationCallbackHandler registrationCallbackHandler = mediaSessionImplBase.p;
                            if (registrationCallbackHandler != null) {
                                registrationCallbackHandler.a(callingPid, callingUid);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }

            public void N0(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                u0(1, new Command(str, bundle, resultReceiverWrapper == null ? null : resultReceiverWrapper.s));
            }

            public boolean O() {
                return false;
            }

            public void P(RatingCompat ratingCompat) {
                u0(19, ratingCompat);
            }

            public void P0() {
                f(17);
            }

            public void Q(int i2, int i3, String str) {
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase != null) {
                    mediaSessionImplBase.U(i2, i3);
                }
            }

            public void R(Uri uri, Bundle bundle) {
                e1(6, uri, bundle);
            }

            public boolean S() {
                return true;
            }

            public void S0(long j2) {
                u0(11, Long.valueOf(j2));
            }

            public void T0(boolean z) {
            }

            public PendingIntent U() {
                PendingIntent pendingIntent;
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase == null) {
                    return null;
                }
                synchronized (mediaSessionImplBase.f2363i) {
                    pendingIntent = mediaSessionImplBase.t;
                }
                return pendingIntent;
            }

            public ParcelableVolumeInfo V0() {
                int i2;
                int i3;
                ParcelableVolumeInfo parcelableVolumeInfo;
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase == null) {
                    return null;
                }
                synchronized (mediaSessionImplBase.f2363i) {
                    try {
                        int i4 = mediaSessionImplBase.B;
                        int i5 = mediaSessionImplBase.C;
                        VolumeProviderCompat volumeProviderCompat = mediaSessionImplBase.D;
                        int i6 = 2;
                        if (i4 == 2) {
                            int c2 = volumeProviderCompat.c();
                            int b2 = volumeProviderCompat.b();
                            i2 = volumeProviderCompat.a();
                            i3 = b2;
                            i6 = c2;
                        } else {
                            int streamMaxVolume = mediaSessionImplBase.f2361g.getStreamMaxVolume(i5);
                            i2 = mediaSessionImplBase.f2361g.getStreamVolume(i5);
                            i3 = streamMaxVolume;
                        }
                        parcelableVolumeInfo = new ParcelableVolumeInfo(i4, i5, i6, i3, i2);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return parcelableVolumeInfo;
            }

            public void W(String str, Bundle bundle) {
                e1(5, str, bundle);
            }

            /* access modifiers changed from: package-private */
            public void d1(int i2, Object obj, int i3, Bundle bundle) {
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase != null) {
                    mediaSessionImplBase.E(i2, i3, 0, obj, bundle);
                }
            }

            /* access modifiers changed from: package-private */
            public void e1(int i2, Object obj, Bundle bundle) {
                d1(i2, obj, 0, bundle);
            }

            /* access modifiers changed from: package-private */
            public void f(int i2) {
                d1(i2, (Object) null, 0, (Bundle) null);
            }

            public Bundle getExtras() {
                Bundle bundle;
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase == null) {
                    return null;
                }
                synchronized (mediaSessionImplBase.f2363i) {
                    bundle = mediaSessionImplBase.A;
                }
                return bundle;
            }

            public void h() {
                f(12);
            }

            public PlaybackStateCompat i() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase == null) {
                    return null;
                }
                synchronized (mediaSessionImplBase.f2363i) {
                    playbackStateCompat = mediaSessionImplBase.s;
                    mediaMetadataCompat = mediaSessionImplBase.r;
                }
                return MediaSessionCompat.j(playbackStateCompat, mediaMetadataCompat);
            }

            public void i0(String str, Bundle bundle) {
                e1(4, str, bundle);
            }

            public long j() {
                long j2;
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase == null) {
                    return 0;
                }
                synchronized (mediaSessionImplBase.f2363i) {
                    j2 = (long) mediaSessionImplBase.q;
                }
                return j2;
            }

            public void j0(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase != null) {
                    mediaSessionImplBase.f2364j.unregister(iMediaControllerCallback);
                    int callingPid = Binder.getCallingPid();
                    int callingUid = Binder.getCallingUid();
                    synchronized (mediaSessionImplBase.f2363i) {
                        try {
                            RegistrationCallbackHandler registrationCallbackHandler = mediaSessionImplBase.p;
                            if (registrationCallbackHandler != null) {
                                registrationCallbackHandler.b(callingPid, callingUid);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }

            public void k() throws RemoteException {
                f(3);
            }

            public MediaMetadataCompat l() {
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase != null) {
                    return mediaSessionImplBase.r;
                }
                return null;
            }

            public void m(float f2) {
                u0(32, Float.valueOf(f2));
            }

            public void m0(String str, Bundle bundle) {
                e1(8, str, bundle);
            }

            public String n() {
                return this.m0;
            }

            public void next() {
                f(14);
            }

            public void o() throws RemoteException {
                f(7);
            }

            public void o0(String str, Bundle bundle) {
                e1(9, str, bundle);
            }

            public void p(int i2) {
                z(23, i2);
            }

            public void p0() {
                f(16);
            }

            public void previous() {
                f(15);
            }

            public int q() {
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase != null) {
                    return mediaSessionImplBase.y;
                }
                return -1;
            }

            public String r() {
                return this.l0;
            }

            public void r0(Uri uri, Bundle bundle) {
                e1(10, uri, bundle);
            }

            public void s(MediaDescriptionCompat mediaDescriptionCompat) {
                u0(27, mediaDescriptionCompat);
            }

            public void stop() {
                f(13);
            }

            public void t(MediaDescriptionCompat mediaDescriptionCompat) {
                u0(25, mediaDescriptionCompat);
            }

            public int u() {
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase != null) {
                    return mediaSessionImplBase.w;
                }
                return 0;
            }

            /* access modifiers changed from: package-private */
            public void u0(int i2, Object obj) {
                d1(i2, obj, 0, (Bundle) null);
            }

            public CharSequence v() {
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase != null) {
                    return mediaSessionImplBase.v;
                }
                return null;
            }

            public Bundle w() {
                MediaSessionImplBase mediaSessionImplBase = this.k0.get();
                if (mediaSessionImplBase == null || mediaSessionImplBase.f2360f == null) {
                    return null;
                }
                return new Bundle(mediaSessionImplBase.f2360f);
            }

            public boolean x0(KeyEvent keyEvent) {
                u0(21, keyEvent);
                return true;
            }

            /* access modifiers changed from: package-private */
            public void z(int i2, int i3) {
                d1(i2, (Object) null, i3, (Bundle) null);
            }
        }

        class MessageHandler extends Handler {
            private static final int A = 25;
            private static final int B = 26;
            private static final int C = 27;
            private static final int D = 28;
            private static final int E = 29;
            private static final int F = 30;
            private static final int G = 127;
            private static final int H = 126;

            /* renamed from: b  reason: collision with root package name */
            private static final int f2373b = 1;

            /* renamed from: c  reason: collision with root package name */
            private static final int f2374c = 2;

            /* renamed from: d  reason: collision with root package name */
            private static final int f2375d = 3;

            /* renamed from: e  reason: collision with root package name */
            private static final int f2376e = 4;

            /* renamed from: f  reason: collision with root package name */
            private static final int f2377f = 5;

            /* renamed from: g  reason: collision with root package name */
            private static final int f2378g = 6;

            /* renamed from: h  reason: collision with root package name */
            private static final int f2379h = 7;

            /* renamed from: i  reason: collision with root package name */
            private static final int f2380i = 8;

            /* renamed from: j  reason: collision with root package name */
            private static final int f2381j = 9;

            /* renamed from: k  reason: collision with root package name */
            private static final int f2382k = 10;

            /* renamed from: l  reason: collision with root package name */
            private static final int f2383l = 11;

            /* renamed from: m  reason: collision with root package name */
            private static final int f2384m = 12;

            /* renamed from: n  reason: collision with root package name */
            private static final int f2385n = 13;
            private static final int o = 14;
            private static final int p = 15;
            private static final int q = 16;
            private static final int r = 17;
            private static final int s = 18;
            private static final int t = 19;
            private static final int u = 31;
            private static final int v = 32;
            private static final int w = 20;
            private static final int x = 21;
            private static final int y = 22;
            private static final int z = 23;

            public MessageHandler(Looper looper) {
                super(looper);
            }

            private void a(KeyEvent keyEvent, Callback callback) {
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    PlaybackStateCompat playbackStateCompat = MediaSessionImplBase.this.s;
                    long b2 = playbackStateCompat == null ? 0 : playbackStateCompat.b();
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 79) {
                        if (keyCode != 126) {
                            if (keyCode != 127) {
                                switch (keyCode) {
                                    case 85:
                                        break;
                                    case 86:
                                        if ((b2 & 1) != 0) {
                                            callback.D();
                                            return;
                                        }
                                        return;
                                    case 87:
                                        if ((b2 & 32) != 0) {
                                            callback.A();
                                            return;
                                        }
                                        return;
                                    case 88:
                                        if ((b2 & 16) != 0) {
                                            callback.B();
                                            return;
                                        }
                                        return;
                                    case 89:
                                        if ((b2 & 8) != 0) {
                                            callback.s();
                                            return;
                                        }
                                        return;
                                    case 90:
                                        if ((b2 & 64) != 0) {
                                            callback.f();
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            } else if ((b2 & 2) != 0) {
                                callback.h();
                                return;
                            } else {
                                return;
                            }
                        } else if ((b2 & 4) != 0) {
                            callback.i();
                            return;
                        } else {
                            return;
                        }
                    }
                    Log.w(MediaSessionCompat.f2316d, "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                }
            }

            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void handleMessage(android.os.Message r8) {
                /*
                    r7 = this;
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this
                    android.support.v4.media.session.MediaSessionCompat$Callback r0 = r0.f2368n
                    if (r0 != 0) goto L_0x0007
                    return
                L_0x0007:
                    android.os.Bundle r1 = r8.getData()
                    android.support.v4.media.session.MediaSessionCompat.b(r1)
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r2 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this
                    androidx.media.MediaSessionManager$RemoteUserInfo r3 = new androidx.media.MediaSessionManager$RemoteUserInfo
                    java.lang.String r4 = "data_calling_pkg"
                    java.lang.String r4 = r1.getString(r4)
                    java.lang.String r5 = "data_calling_pid"
                    int r5 = r1.getInt(r5)
                    java.lang.String r6 = "data_calling_uid"
                    int r6 = r1.getInt(r6)
                    r3.<init>(r4, r5, r6)
                    r2.t(r3)
                    java.lang.String r2 = "data_extras"
                    android.os.Bundle r1 = r1.getBundle(r2)
                    android.support.v4.media.session.MediaSessionCompat.b(r1)
                    r2 = 0
                    int r3 = r8.what     // Catch:{ all -> 0x0049 }
                    r4 = 0
                    switch(r3) {
                        case 1: goto L_0x015c;
                        case 2: goto L_0x0154;
                        case 3: goto L_0x0150;
                        case 4: goto L_0x0148;
                        case 5: goto L_0x0140;
                        case 6: goto L_0x0138;
                        case 7: goto L_0x0134;
                        case 8: goto L_0x012c;
                        case 9: goto L_0x0124;
                        case 10: goto L_0x011c;
                        case 11: goto L_0x0110;
                        case 12: goto L_0x010c;
                        case 13: goto L_0x0108;
                        case 14: goto L_0x0104;
                        case 15: goto L_0x00ff;
                        case 16: goto L_0x00fa;
                        case 17: goto L_0x00f5;
                        case 18: goto L_0x00e8;
                        case 19: goto L_0x00df;
                        case 20: goto L_0x00d6;
                        case 21: goto L_0x00bb;
                        case 22: goto L_0x00b2;
                        case 23: goto L_0x00ab;
                        case 24: goto L_0x003a;
                        case 25: goto L_0x00a2;
                        case 26: goto L_0x0097;
                        case 27: goto L_0x0092;
                        case 28: goto L_0x0069;
                        case 29: goto L_0x005c;
                        case 30: goto L_0x0055;
                        case 31: goto L_0x004c;
                        case 32: goto L_0x003c;
                        default: goto L_0x003a;
                    }     // Catch:{ all -> 0x0049 }
                L_0x003a:
                    goto L_0x0169
                L_0x003c:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    java.lang.Float r8 = (java.lang.Float) r8     // Catch:{ all -> 0x0049 }
                    float r8 = r8.floatValue()     // Catch:{ all -> 0x0049 }
                    r0.v(r8)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0049:
                    r8 = move-exception
                    goto L_0x016f
                L_0x004c:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    android.support.v4.media.RatingCompat r8 = (android.support.v4.media.RatingCompat) r8     // Catch:{ all -> 0x0049 }
                    r0.x(r8, r1)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0055:
                    int r8 = r8.arg1     // Catch:{ all -> 0x0049 }
                    r0.z(r8)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x005c:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x0049 }
                    boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0049 }
                    r0.u(r8)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0069:
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r1 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this     // Catch:{ all -> 0x0049 }
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r1 = r1.u     // Catch:{ all -> 0x0049 }
                    if (r1 == 0) goto L_0x0169
                    int r3 = r8.arg1     // Catch:{ all -> 0x0049 }
                    if (r3 < 0) goto L_0x0086
                    int r1 = r1.size()     // Catch:{ all -> 0x0049 }
                    if (r3 >= r1) goto L_0x0086
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r1 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this     // Catch:{ all -> 0x0049 }
                    java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem> r1 = r1.u     // Catch:{ all -> 0x0049 }
                    int r8 = r8.arg1     // Catch:{ all -> 0x0049 }
                    java.lang.Object r8 = r1.get(r8)     // Catch:{ all -> 0x0049 }
                    android.support.v4.media.session.MediaSessionCompat$QueueItem r8 = (android.support.v4.media.session.MediaSessionCompat.QueueItem) r8     // Catch:{ all -> 0x0049 }
                    goto L_0x0087
                L_0x0086:
                    r8 = r2
                L_0x0087:
                    if (r8 == 0) goto L_0x0169
                    android.support.v4.media.MediaDescriptionCompat r8 = r8.c()     // Catch:{ all -> 0x0049 }
                L_0x008d:
                    r0.q(r8)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0092:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    android.support.v4.media.MediaDescriptionCompat r8 = (android.support.v4.media.MediaDescriptionCompat) r8     // Catch:{ all -> 0x0049 }
                    goto L_0x008d
                L_0x0097:
                    java.lang.Object r1 = r8.obj     // Catch:{ all -> 0x0049 }
                    android.support.v4.media.MediaDescriptionCompat r1 = (android.support.v4.media.MediaDescriptionCompat) r1     // Catch:{ all -> 0x0049 }
                    int r8 = r8.arg1     // Catch:{ all -> 0x0049 }
                    r0.c(r1, r8)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x00a2:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    android.support.v4.media.MediaDescriptionCompat r8 = (android.support.v4.media.MediaDescriptionCompat) r8     // Catch:{ all -> 0x0049 }
                    r0.b(r8)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x00ab:
                    int r8 = r8.arg1     // Catch:{ all -> 0x0049 }
                    r0.y(r8)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x00b2:
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this     // Catch:{ all -> 0x0049 }
                    int r8 = r8.arg1     // Catch:{ all -> 0x0049 }
                    r0.U(r8, r4)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x00bb:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    android.view.KeyEvent r8 = (android.view.KeyEvent) r8     // Catch:{ all -> 0x0049 }
                    android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x0049 }
                    java.lang.String r3 = "android.intent.action.MEDIA_BUTTON"
                    r1.<init>(r3)     // Catch:{ all -> 0x0049 }
                    java.lang.String r3 = "android.intent.extra.KEY_EVENT"
                    r1.putExtra(r3, r8)     // Catch:{ all -> 0x0049 }
                    boolean r1 = r0.g(r1)     // Catch:{ all -> 0x0049 }
                    if (r1 != 0) goto L_0x0169
                    r7.a(r8, r0)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x00d6:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0049 }
                    r0.e(r8, r1)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x00df:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    android.support.v4.media.RatingCompat r8 = (android.support.v4.media.RatingCompat) r8     // Catch:{ all -> 0x0049 }
                    r0.w(r8)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x00e8:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x0049 }
                    long r3 = r8.longValue()     // Catch:{ all -> 0x0049 }
                    r0.t(r3)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x00f5:
                    r0.s()     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x00fa:
                    r0.f()     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x00ff:
                    r0.B()     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0104:
                    r0.A()     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0108:
                    r0.D()     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x010c:
                    r0.h()     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0110:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x0049 }
                    long r3 = r8.longValue()     // Catch:{ all -> 0x0049 }
                    r0.C(r3)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x011c:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    android.net.Uri r8 = (android.net.Uri) r8     // Catch:{ all -> 0x0049 }
                    r0.l(r8, r1)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0124:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0049 }
                    r0.k(r8, r1)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x012c:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0049 }
                    r0.j(r8, r1)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0134:
                    r0.i()     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0138:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    android.net.Uri r8 = (android.net.Uri) r8     // Catch:{ all -> 0x0049 }
                    r0.p(r8, r1)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0140:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0049 }
                    r0.o(r8, r1)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0148:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0049 }
                    r0.n(r8, r1)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0150:
                    r0.m()     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x0154:
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this     // Catch:{ all -> 0x0049 }
                    int r8 = r8.arg1     // Catch:{ all -> 0x0049 }
                    r0.z(r8, r4)     // Catch:{ all -> 0x0049 }
                    goto L_0x0169
                L_0x015c:
                    java.lang.Object r8 = r8.obj     // Catch:{ all -> 0x0049 }
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$Command r8 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.Command) r8     // Catch:{ all -> 0x0049 }
                    java.lang.String r1 = r8.f2370a     // Catch:{ all -> 0x0049 }
                    android.os.Bundle r3 = r8.f2371b     // Catch:{ all -> 0x0049 }
                    android.os.ResultReceiver r8 = r8.f2372c     // Catch:{ all -> 0x0049 }
                    r0.d(r1, r3, r8)     // Catch:{ all -> 0x0049 }
                L_0x0169:
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r8 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this
                    r8.t(r2)
                    return
                L_0x016f:
                    android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this
                    r0.t(r2)
                    throw r8
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MessageHandler.handleMessage(android.os.Message):void");
            }
        }

        public MediaSessionImplBase(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, VersionedParcelable versionedParcelable, Bundle bundle) {
            if (componentName != null) {
                this.f2355a = context;
                this.f2360f = bundle;
                this.f2361g = (AudioManager) context.getSystemService("audio");
                this.f2356b = componentName;
                this.f2357c = pendingIntent;
                MediaSessionStub mediaSessionStub = new MediaSessionStub(this, context.getPackageName(), str);
                this.f2358d = mediaSessionStub;
                this.f2359e = new Token(mediaSessionStub, (IMediaSession) null, versionedParcelable);
                this.w = 0;
                this.B = 1;
                this.C = 3;
                this.f2362h = new RemoteControlClient(pendingIntent);
                return;
            }
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null");
        }

        private void G(boolean z2) {
            synchronized (this.f2363i) {
                for (int beginBroadcast = this.f2364j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f2364j.getBroadcastItem(beginBroadcast).s0(z2);
                    } catch (RemoteException unused) {
                    }
                }
                this.f2364j.finishBroadcast();
            }
        }

        private void I(String str, Bundle bundle) {
            synchronized (this.f2363i) {
                for (int beginBroadcast = this.f2364j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f2364j.getBroadcastItem(beginBroadcast).y(str, bundle);
                    } catch (RemoteException unused) {
                    }
                }
                this.f2364j.finishBroadcast();
            }
        }

        private void J(Bundle bundle) {
            synchronized (this.f2363i) {
                for (int beginBroadcast = this.f2364j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f2364j.getBroadcastItem(beginBroadcast).a0(bundle);
                    } catch (RemoteException unused) {
                    }
                }
                this.f2364j.finishBroadcast();
            }
        }

        private void K(MediaMetadataCompat mediaMetadataCompat) {
            synchronized (this.f2363i) {
                for (int beginBroadcast = this.f2364j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f2364j.getBroadcastItem(beginBroadcast).F0(mediaMetadataCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.f2364j.finishBroadcast();
            }
        }

        private void M(List<QueueItem> list) {
            synchronized (this.f2363i) {
                for (int beginBroadcast = this.f2364j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f2364j.getBroadcastItem(beginBroadcast).d0(list);
                    } catch (RemoteException unused) {
                    }
                }
                this.f2364j.finishBroadcast();
            }
        }

        private void N(CharSequence charSequence) {
            synchronized (this.f2363i) {
                for (int beginBroadcast = this.f2364j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f2364j.getBroadcastItem(beginBroadcast).z0(charSequence);
                    } catch (RemoteException unused) {
                    }
                }
                this.f2364j.finishBroadcast();
            }
        }

        private void O(int i2) {
            synchronized (this.f2363i) {
                for (int beginBroadcast = this.f2364j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f2364j.getBroadcastItem(beginBroadcast).x(i2);
                    } catch (RemoteException unused) {
                    }
                }
                this.f2364j.finishBroadcast();
            }
        }

        private void P() {
            synchronized (this.f2363i) {
                for (int beginBroadcast = this.f2364j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f2364j.getBroadcastItem(beginBroadcast).D0();
                    } catch (RemoteException unused) {
                    }
                }
                this.f2364j.finishBroadcast();
                this.f2364j.kill();
            }
        }

        private void Q(int i2) {
            synchronized (this.f2363i) {
                for (int beginBroadcast = this.f2364j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f2364j.getBroadcastItem(beginBroadcast).M0(i2);
                    } catch (RemoteException unused) {
                    }
                }
                this.f2364j.finishBroadcast();
            }
        }

        private void R(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.f2363i) {
                for (int beginBroadcast = this.f2364j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f2364j.getBroadcastItem(beginBroadcast).Z0(playbackStateCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.f2364j.finishBroadcast();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
            if (r2 != null) goto L_0x001d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
            if (r2 != null) goto L_0x001d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00a3  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b3  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00c4  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00e5  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00f5  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0104  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.media.RemoteControlClient.MetadataEditor A(android.os.Bundle r7) {
            /*
                r6 = this;
                android.media.RemoteControlClient r0 = r6.f2362h
                r1 = 1
                android.media.RemoteControlClient$MetadataEditor r0 = r0.editMetadata(r1)
                if (r7 != 0) goto L_0x000a
                return r0
            L_0x000a:
                java.lang.String r2 = "android.media.metadata.ART"
                boolean r3 = r7.containsKey(r2)
                r4 = 100
                r5 = 0
                if (r3 == 0) goto L_0x0029
                android.os.Parcelable r2 = r7.getParcelable(r2)
                android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
                if (r2 == 0) goto L_0x0025
            L_0x001d:
                android.graphics.Bitmap$Config r3 = r2.getConfig()
                android.graphics.Bitmap r2 = r2.copy(r3, r5)
            L_0x0025:
                r0.putBitmap(r4, r2)
                goto L_0x003a
            L_0x0029:
                java.lang.String r2 = "android.media.metadata.ALBUM_ART"
                boolean r3 = r7.containsKey(r2)
                if (r3 == 0) goto L_0x003a
                android.os.Parcelable r2 = r7.getParcelable(r2)
                android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
                if (r2 == 0) goto L_0x0025
                goto L_0x001d
            L_0x003a:
                java.lang.String r2 = "android.media.metadata.ALBUM"
                boolean r3 = r7.containsKey(r2)
                if (r3 == 0) goto L_0x0049
                java.lang.String r2 = r7.getString(r2)
                r0.putString(r1, r2)
            L_0x0049:
                java.lang.String r1 = "android.media.metadata.ALBUM_ARTIST"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x005a
                r2 = 13
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x005a:
                java.lang.String r1 = "android.media.metadata.ARTIST"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x006a
                r2 = 2
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x006a:
                java.lang.String r1 = "android.media.metadata.AUTHOR"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x007a
                r2 = 3
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x007a:
                java.lang.String r1 = "android.media.metadata.COMPILATION"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x008b
                r2 = 15
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x008b:
                java.lang.String r1 = "android.media.metadata.COMPOSER"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x009b
                r2 = 4
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x009b:
                java.lang.String r1 = "android.media.metadata.DATE"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00ab
                r2 = 5
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x00ab:
                java.lang.String r1 = "android.media.metadata.DISC_NUMBER"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00bc
                r2 = 14
                long r3 = r7.getLong(r1)
                r0.putLong(r2, r3)
            L_0x00bc:
                java.lang.String r1 = "android.media.metadata.DURATION"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00cd
                r2 = 9
                long r3 = r7.getLong(r1)
                r0.putLong(r2, r3)
            L_0x00cd:
                java.lang.String r1 = "android.media.metadata.GENRE"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00dd
                r2 = 6
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x00dd:
                java.lang.String r1 = "android.media.metadata.TITLE"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00ed
                r2 = 7
                java.lang.String r1 = r7.getString(r1)
                r0.putString(r2, r1)
            L_0x00ed:
                java.lang.String r1 = "android.media.metadata.TRACK_NUMBER"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x00fc
                long r1 = r7.getLong(r1)
                r0.putLong(r5, r1)
            L_0x00fc:
                java.lang.String r1 = "android.media.metadata.WRITER"
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x010d
                r2 = 11
                java.lang.String r7 = r7.getString(r1)
                r0.putString(r2, r7)
            L_0x010d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.A(android.os.Bundle):android.media.RemoteControlClient$MetadataEditor");
        }

        /* access modifiers changed from: package-private */
        public String B(int i2) {
            String nameForUid = this.f2355a.getPackageManager().getNameForUid(i2);
            return TextUtils.isEmpty(nameForUid) ? MediaSessionManager.RemoteUserInfo.f8969b : nameForUid;
        }

        /* access modifiers changed from: package-private */
        public int C(int i2) {
            switch (i2) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        /* access modifiers changed from: package-private */
        public int D(long j2) {
            int i2 = (1 & j2) != 0 ? 32 : 0;
            if ((2 & j2) != 0) {
                i2 |= 16;
            }
            if ((4 & j2) != 0) {
                i2 |= 4;
            }
            if ((8 & j2) != 0) {
                i2 |= 2;
            }
            if ((16 & j2) != 0) {
                i2 |= 1;
            }
            if ((32 & j2) != 0) {
                i2 |= 128;
            }
            if ((64 & j2) != 0) {
                i2 |= 64;
            }
            return (j2 & 512) != 0 ? i2 | 8 : i2;
        }

        /* access modifiers changed from: package-private */
        public void E(int i2, int i3, int i4, Object obj, Bundle bundle) {
            synchronized (this.f2363i) {
                try {
                    MessageHandler messageHandler = this.f2365k;
                    if (messageHandler != null) {
                        Message obtainMessage = messageHandler.obtainMessage(i2, i3, i4, obj);
                        Bundle bundle2 = new Bundle();
                        int callingUid = Binder.getCallingUid();
                        bundle2.putInt("data_calling_uid", callingUid);
                        bundle2.putString(MediaSessionCompat.N, B(callingUid));
                        int callingPid = Binder.getCallingPid();
                        if (callingPid > 0) {
                            bundle2.putInt("data_calling_pid", callingPid);
                        } else {
                            bundle2.putInt("data_calling_pid", -1);
                        }
                        if (bundle != null) {
                            bundle2.putBundle(MediaSessionCompat.Q, bundle);
                        }
                        obtainMessage.setData(bundle2);
                        obtainMessage.sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void F(PendingIntent pendingIntent, ComponentName componentName) {
            this.f2361g.registerMediaButtonEventReceiver(componentName);
        }

        public void H(boolean z2) {
            if (this.x != z2) {
                this.x = z2;
                G(z2);
            }
        }

        public void L(int i2) {
            if (this.z != i2) {
                this.z = i2;
                Q(i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void S(ParcelableVolumeInfo parcelableVolumeInfo) {
            synchronized (this.f2363i) {
                for (int beginBroadcast = this.f2364j.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f2364j.getBroadcastItem(beginBroadcast).b1(parcelableVolumeInfo);
                    } catch (RemoteException unused) {
                    }
                }
                this.f2364j.finishBroadcast();
            }
        }

        /* access modifiers changed from: package-private */
        public void T(PlaybackStateCompat playbackStateCompat) {
            this.f2362h.setPlaybackState(C(playbackStateCompat.z()));
        }

        /* access modifiers changed from: package-private */
        public void U(int i2, int i3) {
            if (this.B == 2) {
                VolumeProviderCompat volumeProviderCompat = this.D;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.g(i2);
                    return;
                }
                return;
            }
            this.f2361g.setStreamVolume(this.C, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public void V(PendingIntent pendingIntent, ComponentName componentName) {
            this.f2361g.unregisterMediaButtonEventReceiver(componentName);
        }

        /* access modifiers changed from: package-private */
        public void W() {
            if (this.f2367m) {
                F(this.f2357c, this.f2356b);
                this.f2361g.registerRemoteControlClient(this.f2362h);
                m(this.r);
                u(this.s);
                return;
            }
            V(this.f2357c, this.f2356b);
            this.f2362h.setPlaybackState(0);
            this.f2361g.unregisterRemoteControlClient(this.f2362h);
        }

        public void a() {
            this.f2367m = false;
            this.f2366l = true;
            W();
            P();
            g((Callback) null, (Handler) null);
        }

        public boolean b() {
            return this.f2367m;
        }

        public void c(int i2) {
            synchronized (this.f2363i) {
                this.q = i2 | 3;
            }
        }

        public void d(String str, Bundle bundle) {
            I(str, bundle);
        }

        public String e() {
            return null;
        }

        public void f(PendingIntent pendingIntent) {
            synchronized (this.f2363i) {
                this.t = pendingIntent;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0033 A[Catch:{ all -> 0x000c }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g(android.support.v4.media.session.MediaSessionCompat.Callback r5, android.os.Handler r6) {
            /*
                r4 = this;
                java.lang.Object r0 = r4.f2363i
                monitor-enter(r0)
                android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler r1 = r4.f2365k     // Catch:{ all -> 0x000c }
                r2 = 0
                if (r1 == 0) goto L_0x000e
                r1.removeCallbacksAndMessages(r2)     // Catch:{ all -> 0x000c }
                goto L_0x000e
            L_0x000c:
                r5 = move-exception
                goto L_0x003a
            L_0x000e:
                if (r5 == 0) goto L_0x001d
                if (r6 != 0) goto L_0x0013
                goto L_0x001d
            L_0x0013:
                android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler r1 = new android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler     // Catch:{ all -> 0x000c }
                android.os.Looper r3 = r6.getLooper()     // Catch:{ all -> 0x000c }
                r1.<init>(r3)     // Catch:{ all -> 0x000c }
                goto L_0x001e
            L_0x001d:
                r1 = r2
            L_0x001e:
                r4.f2365k = r1     // Catch:{ all -> 0x000c }
                android.support.v4.media.session.MediaSessionCompat$Callback r1 = r4.f2368n     // Catch:{ all -> 0x000c }
                if (r1 == r5) goto L_0x002d
                android.support.v4.media.session.MediaSessionCompat$Callback r1 = r4.f2368n     // Catch:{ all -> 0x000c }
                if (r1 == 0) goto L_0x002d
                android.support.v4.media.session.MediaSessionCompat$Callback r1 = r4.f2368n     // Catch:{ all -> 0x000c }
                r1.E(r2, r2)     // Catch:{ all -> 0x000c }
            L_0x002d:
                r4.f2368n = r5     // Catch:{ all -> 0x000c }
                android.support.v4.media.session.MediaSessionCompat$Callback r5 = r4.f2368n     // Catch:{ all -> 0x000c }
                if (r5 == 0) goto L_0x0038
                android.support.v4.media.session.MediaSessionCompat$Callback r5 = r4.f2368n     // Catch:{ all -> 0x000c }
                r5.E(r4, r6)     // Catch:{ all -> 0x000c }
            L_0x0038:
                monitor-exit(r0)     // Catch:{ all -> 0x000c }
                return
            L_0x003a:
                monitor-exit(r0)     // Catch:{ all -> 0x000c }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.g(android.support.v4.media.session.MediaSessionCompat$Callback, android.os.Handler):void");
        }

        public void h(int i2) {
            VolumeProviderCompat volumeProviderCompat = this.D;
            if (volumeProviderCompat != null) {
                volumeProviderCompat.h((VolumeProviderCompat.Callback) null);
            }
            this.C = i2;
            this.B = 1;
            int i3 = this.B;
            int i4 = this.C;
            S(new ParcelableVolumeInfo(i3, i4, 2, this.f2361g.getStreamMaxVolume(i4), this.f2361g.getStreamVolume(this.C)));
        }

        public PlaybackStateCompat i() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.f2363i) {
                playbackStateCompat = this.s;
            }
            return playbackStateCompat;
        }

        public void j(CharSequence charSequence) {
            this.v = charSequence;
            N(charSequence);
        }

        public Token k() {
            return this.f2359e;
        }

        public Callback l() {
            Callback callback;
            synchronized (this.f2363i) {
                callback = this.f2368n;
            }
            return callback;
        }

        public void m(MediaMetadataCompat mediaMetadataCompat) {
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new MediaMetadataCompat.Builder(mediaMetadataCompat, MediaSessionCompat.R).a();
            }
            synchronized (this.f2363i) {
                this.r = mediaMetadataCompat;
            }
            K(mediaMetadataCompat);
            if (this.f2367m) {
                A(mediaMetadataCompat == null ? null : mediaMetadataCompat.d()).apply();
            }
        }

        public void n(PendingIntent pendingIntent) {
        }

        public void o(int i2) {
            this.w = i2;
        }

        public void p(int i2) {
            if (this.y != i2) {
                this.y = i2;
                O(i2);
            }
        }

        public void q(List<QueueItem> list) {
            this.u = list;
            M(list);
        }

        public Object r() {
            return null;
        }

        public void s(boolean z2) {
            if (z2 != this.f2367m) {
                this.f2367m = z2;
                W();
            }
        }

        public void setExtras(Bundle bundle) {
            this.A = bundle;
            J(bundle);
        }

        public void t(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            synchronized (this.f2363i) {
                this.o = remoteUserInfo;
            }
        }

        public void u(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.f2363i) {
                this.s = playbackStateCompat;
            }
            R(playbackStateCompat);
            if (this.f2367m) {
                if (playbackStateCompat == null) {
                    this.f2362h.setPlaybackState(0);
                    this.f2362h.setTransportControlFlags(0);
                    return;
                }
                T(playbackStateCompat);
                this.f2362h.setTransportControlFlags(D(playbackStateCompat.b()));
            }
        }

        public Object v() {
            return null;
        }

        public void w(@Nullable RegistrationCallback registrationCallback, @NonNull Handler handler) {
            synchronized (this.f2363i) {
                try {
                    RegistrationCallbackHandler registrationCallbackHandler = this.p;
                    if (registrationCallbackHandler != null) {
                        registrationCallbackHandler.removeCallbacksAndMessages((Object) null);
                    }
                    if (registrationCallback != null) {
                        this.p = new RegistrationCallbackHandler(handler.getLooper(), registrationCallback);
                    } else {
                        this.p = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void x(VolumeProviderCompat volumeProviderCompat) {
            if (volumeProviderCompat != null) {
                VolumeProviderCompat volumeProviderCompat2 = this.D;
                if (volumeProviderCompat2 != null) {
                    volumeProviderCompat2.h((VolumeProviderCompat.Callback) null);
                }
                this.B = 2;
                this.D = volumeProviderCompat;
                S(new ParcelableVolumeInfo(this.B, this.C, this.D.c(), this.D.b(), this.D.a()));
                volumeProviderCompat.h(this.E);
                return;
            }
            throw new IllegalArgumentException("volumeProvider may not be null");
        }

        public MediaSessionManager.RemoteUserInfo y() {
            MediaSessionManager.RemoteUserInfo remoteUserInfo;
            synchronized (this.f2363i) {
                remoteUserInfo = this.o;
            }
            return remoteUserInfo;
        }

        /* access modifiers changed from: package-private */
        public void z(int i2, int i3) {
            if (this.B == 2) {
                VolumeProviderCompat volumeProviderCompat = this.D;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.f(i2);
                    return;
                }
                return;
            }
            this.f2361g.adjustStreamVolume(this.C, i2, i3);
        }
    }

    public interface OnActiveChangeListener {
        void a();
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() {
            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: b */
            public QueueItem[] newArray(int i2) {
                return new QueueItem[i2];
            }
        };
        public static final int Z = -1;
        private final long X;
        private MediaSession.QueueItem Y;
        private final MediaDescriptionCompat s;

        @RequiresApi(21)
        private static class Api21Impl {
            private Api21Impl() {
            }

            @DoNotInline
            static MediaSession.QueueItem a(MediaDescription mediaDescription, long j2) {
                return new MediaSession.QueueItem(mediaDescription, j2);
            }

            @DoNotInline
            static MediaDescription b(MediaSession.QueueItem queueItem) {
                return queueItem.getDescription();
            }

            @DoNotInline
            static long c(MediaSession.QueueItem queueItem) {
                return queueItem.getQueueId();
            }
        }

        private QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            } else if (j2 != -1) {
                this.s = mediaDescriptionCompat;
                this.X = j2;
                this.Y = queueItem;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        public static QueueItem a(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
            return new QueueItem(queueItem, MediaDescriptionCompat.a(Api21Impl.b(queueItem)), Api21Impl.c(queueItem));
        }

        public static List<QueueItem> b(List<?> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object a2 : list) {
                arrayList.add(a(a2));
            }
            return arrayList;
        }

        public MediaDescriptionCompat c() {
            return this.s;
        }

        public long d() {
            return this.X;
        }

        public int describeContents() {
            return 0;
        }

        public Object g() {
            MediaSession.QueueItem queueItem = this.Y;
            if (queueItem != null) {
                return queueItem;
            }
            MediaSession.QueueItem a2 = Api21Impl.a((MediaDescription) this.s.j(), this.X);
            this.Y = a2;
            return a2;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.s + ", Id=" + this.X + " }";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            this.s.writeToParcel(parcel, i2);
            parcel.writeLong(this.X);
        }

        QueueItem(Parcel parcel) {
            this.s = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.X = parcel.readLong();
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j2) {
            this((MediaSession.QueueItem) null, mediaDescriptionCompat, j2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface RegistrationCallback {
        void a(int i2, int i3);

        void b(int i2, int i3);
    }

    static final class RegistrationCallbackHandler extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private static final int f2387b = 1001;

        /* renamed from: c  reason: collision with root package name */
        private static final int f2388c = 1002;

        /* renamed from: a  reason: collision with root package name */
        private final RegistrationCallback f2389a;

        RegistrationCallbackHandler(@NonNull Looper looper, @NonNull RegistrationCallback registrationCallback) {
            super(looper);
            this.f2389a = registrationCallback;
        }

        public void a(int i2, int i3) {
            obtainMessage(1001, i2, i3).sendToTarget();
        }

        public void b(int i2, int i3) {
            obtainMessage(1002, i2, i3).sendToTarget();
        }

        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1001) {
                this.f2389a.a(message.arg1, message.arg2);
            } else if (i2 == 1002) {
                this.f2389a.b(message.arg1, message.arg2);
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() {
            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: b */
            public ResultReceiverWrapper[] newArray(int i2) {
                return new ResultReceiverWrapper[i2];
            }
        };
        ResultReceiver s;

        ResultReceiverWrapper(Parcel parcel) {
            this.s = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            this.s.writeToParcel(parcel, i2);
        }

        public ResultReceiverWrapper(@NonNull ResultReceiver resultReceiver) {
            this.s = resultReceiver;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() {
            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable((ClassLoader) null));
            }

            /* renamed from: b */
            public Token[] newArray(int i2) {
                return new Token[i2];
            }
        };
        private final Object X;
        @GuardedBy("mLock")
        private IMediaSession Y;
        @GuardedBy("mLock")
        private VersionedParcelable Z;
        private final Object s;

        Token(Object obj) {
            this(obj, (IMediaSession) null, (VersionedParcelable) null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static Token a(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            bundle.setClassLoader(Token.class.getClassLoader());
            IMediaSession e2 = IMediaSession.Stub.e(BundleCompat.a(bundle, MediaSessionCompat.K));
            VersionedParcelable c2 = ParcelUtils.c(bundle, MediaSessionCompat.L);
            Token token = (Token) bundle.getParcelable(MediaSessionCompat.J);
            if (token == null) {
                return null;
            }
            return new Token(token.X, e2, c2);
        }

        public static Token b(Object obj) {
            return c(obj, (IMediaSession) null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Token c(Object obj, IMediaSession iMediaSession) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof MediaSession.Token) {
                return new Token(obj, iMediaSession);
            }
            throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public IMediaSession d() {
            IMediaSession iMediaSession;
            synchronized (this.s) {
                iMediaSession = this.Y;
            }
            return iMediaSession;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Object obj2 = this.X;
            Object obj3 = ((Token) obj).X;
            if (obj2 == null) {
                return obj3 == null;
            }
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public VersionedParcelable g() {
            VersionedParcelable versionedParcelable;
            synchronized (this.s) {
                versionedParcelable = this.Z;
            }
            return versionedParcelable;
        }

        public int hashCode() {
            Object obj = this.X;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public Object j() {
            return this.X;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void k(IMediaSession iMediaSession) {
            synchronized (this.s) {
                this.Y = iMediaSession;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void l(VersionedParcelable versionedParcelable) {
            synchronized (this.s) {
                this.Z = versionedParcelable;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bundle m() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.J, this);
            synchronized (this.s) {
                try {
                    IMediaSession iMediaSession = this.Y;
                    if (iMediaSession != null) {
                        BundleCompat.b(bundle, MediaSessionCompat.K, iMediaSession.asBinder());
                    }
                    VersionedParcelable versionedParcelable = this.Z;
                    if (versionedParcelable != null) {
                        ParcelUtils.e(bundle, MediaSessionCompat.L, versionedParcelable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return bundle;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable((Parcelable) this.X, i2);
        }

        Token(Object obj, IMediaSession iMediaSession) {
            this(obj, iMediaSession, (VersionedParcelable) null);
        }

        Token(Object obj, IMediaSession iMediaSession, VersionedParcelable versionedParcelable) {
            this.s = new Object();
            this.X = obj;
            this.Y = iMediaSession;
            this.Z = versionedParcelable;
        }
    }

    private MediaSessionCompat(Context context, MediaSessionImpl mediaSessionImpl) {
        this.f2329c = new ArrayList<>();
        this.f2327a = mediaSessionImpl;
        this.f2328b = new MediaControllerCompat(context, this);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Bundle G(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        b(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e(f2316d, "Could not unparcel the data.");
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void b(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static MediaSessionCompat c(Context context, Object obj) {
        int i2 = Build.VERSION.SDK_INT;
        if (context == null || obj == null) {
            return null;
        }
        return new MediaSessionCompat(context, i2 >= 29 ? new MediaSessionImplApi29(obj) : i2 >= 28 ? new MediaSessionImplApi28(obj) : new MediaSessionImplApi21(obj));
    }

    static PlaybackStateCompat j(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j2 = -1;
        if (playbackStateCompat.v() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.z() != 3 && playbackStateCompat.z() != 4 && playbackStateCompat.z() != 5) {
            return playbackStateCompat;
        }
        long o2 = playbackStateCompat.o();
        if (o2 <= 0) {
            return playbackStateCompat;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long p2 = ((long) (playbackStateCompat.p() * ((float) (elapsedRealtime - o2)))) + playbackStateCompat.v();
        if (mediaMetadataCompat != null && mediaMetadataCompat.a(MediaMetadataCompat.Z2)) {
            j2 = mediaMetadataCompat.j(MediaMetadataCompat.Z2);
        }
        return new PlaybackStateCompat.Builder(playbackStateCompat).k(playbackStateCompat.z(), (j2 < 0 || p2 <= j2) ? p2 < 0 ? 0 : p2 : j2, playbackStateCompat.p(), elapsedRealtime).c();
    }

    public void A(CharSequence charSequence) {
        this.f2327a.j(charSequence);
    }

    public void B(int i2) {
        this.f2327a.o(i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void C(@Nullable RegistrationCallback registrationCallback, @NonNull Handler handler) {
        this.f2327a.w(registrationCallback, handler);
    }

    public void D(int i2) {
        this.f2327a.p(i2);
    }

    public void E(PendingIntent pendingIntent) {
        this.f2327a.f(pendingIntent);
    }

    public void F(int i2) {
        this.f2327a.L(i2);
    }

    public void a(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.f2329c.add(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String d() {
        return this.f2327a.e();
    }

    public MediaControllerCompat e() {
        return this.f2328b;
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo f() {
        return this.f2327a.y();
    }

    public Object g() {
        return this.f2327a.v();
    }

    public Object h() {
        return this.f2327a.r();
    }

    public Token i() {
        return this.f2327a.k();
    }

    public boolean k() {
        return this.f2327a.b();
    }

    public void l() {
        this.f2327a.a();
    }

    public void m(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.f2329c.remove(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void n(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f2327a.d(str, bundle);
            return;
        }
        throw new IllegalArgumentException("event cannot be null or empty");
    }

    public void o(boolean z2) {
        this.f2327a.s(z2);
        Iterator<OnActiveChangeListener> it2 = this.f2329c.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    public void p(Callback callback) {
        q(callback, (Handler) null);
    }

    public void q(Callback callback, Handler handler) {
        if (callback == null) {
            this.f2327a.g((Callback) null, (Handler) null);
            return;
        }
        MediaSessionImpl mediaSessionImpl = this.f2327a;
        if (handler == null) {
            handler = new Handler();
        }
        mediaSessionImpl.g(callback, handler);
    }

    public void r(boolean z2) {
        this.f2327a.H(z2);
    }

    public void s(Bundle bundle) {
        this.f2327a.setExtras(bundle);
    }

    public void t(int i2) {
        this.f2327a.c(i2);
    }

    public void u(PendingIntent pendingIntent) {
        this.f2327a.n(pendingIntent);
    }

    public void v(MediaMetadataCompat mediaMetadataCompat) {
        this.f2327a.m(mediaMetadataCompat);
    }

    public void w(PlaybackStateCompat playbackStateCompat) {
        this.f2327a.u(playbackStateCompat);
    }

    public void x(int i2) {
        this.f2327a.h(i2);
    }

    public void y(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat != null) {
            this.f2327a.x(volumeProviderCompat);
            return;
        }
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }

    public void z(List<QueueItem> list) {
        if (list != null) {
            HashSet hashSet = new HashSet();
            for (QueueItem next : list) {
                if (next != null) {
                    if (hashSet.contains(Long.valueOf(next.d()))) {
                        Log.e(f2316d, "Found duplicate queue id: " + next.d(), new IllegalArgumentException("id of each queue item should be unique"));
                    }
                    hashSet.add(Long.valueOf(next.d()));
                } else {
                    throw new IllegalArgumentException("queue shouldn't have null items");
                }
            }
        }
        this.f2327a.q(list);
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str) {
        this(context, str, (ComponentName) null, (PendingIntent) null);
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, (Bundle) null);
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, (VersionedParcelable) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable VersionedParcelable versionedParcelable) {
        this.f2329c = new ArrayList<>();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        } else if (!TextUtils.isEmpty(str)) {
            if (componentName == null && (componentName = MediaButtonReceiver.c(context)) == null) {
                Log.w(f2316d, "Couldn't find a unique registered media button receiver in the given context.");
            }
            if (componentName != null && pendingIntent == null) {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(componentName);
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
            }
            int i2 = Build.VERSION.SDK_INT;
            this.f2327a = i2 >= 29 ? new MediaSessionImplApi29(context, str, versionedParcelable, bundle) : i2 >= 28 ? new MediaSessionImplApi28(context, str, versionedParcelable, bundle) : i2 >= 22 ? new MediaSessionImplApi22(context, str, versionedParcelable, bundle) : new MediaSessionImplApi21(context, str, versionedParcelable, bundle);
            q(new Callback() {
            }, new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
            this.f2327a.n(pendingIntent);
            this.f2328b = new MediaControllerCompat(context, this);
            if (R == 0) {
                R = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
            }
        } else {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
    }
}
