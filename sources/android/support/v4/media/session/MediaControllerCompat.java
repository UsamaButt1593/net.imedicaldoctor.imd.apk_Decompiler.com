package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media.R;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MediaControllerCompat {

    /* renamed from: d  reason: collision with root package name */
    static final String f2268d = "MediaControllerCompat";
    @RestrictTo({RestrictTo.Scope.s})

    /* renamed from: e  reason: collision with root package name */
    public static final String f2269e = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    @RestrictTo({RestrictTo.Scope.s})

    /* renamed from: f  reason: collision with root package name */
    public static final String f2270f = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    @RestrictTo({RestrictTo.Scope.s})

    /* renamed from: g  reason: collision with root package name */
    public static final String f2271g = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    @RestrictTo({RestrictTo.Scope.s})

    /* renamed from: h  reason: collision with root package name */
    public static final String f2272h = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    @RestrictTo({RestrictTo.Scope.s})

    /* renamed from: i  reason: collision with root package name */
    public static final String f2273i = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    @RestrictTo({RestrictTo.Scope.s})

    /* renamed from: j  reason: collision with root package name */
    public static final String f2274j = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    @RestrictTo({RestrictTo.Scope.s})

    /* renamed from: k  reason: collision with root package name */
    public static final String f2275k = "android.support.v4.media.session.command.ARGUMENT_INDEX";

    /* renamed from: a  reason: collision with root package name */
    private final MediaControllerImpl f2276a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaSessionCompat.Token f2277b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Callback> f2278c;

    public static abstract class Callback implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        final MediaController.Callback f2279a = new MediaControllerCallbackApi21(this);

        /* renamed from: b  reason: collision with root package name */
        MessageHandler f2280b;

        /* renamed from: c  reason: collision with root package name */
        IMediaControllerCallback f2281c;

        @RequiresApi(21)
        private static class MediaControllerCallbackApi21 extends MediaController.Callback {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<Callback> f2282a;

            MediaControllerCallbackApi21(Callback callback) {
                this.f2282a = new WeakReference<>(callback);
            }

            public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                Callback callback = this.f2282a.get();
                if (callback != null) {
                    callback.b(new PlaybackInfo(playbackInfo.getPlaybackType(), AudioAttributesCompat.k(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()));
                }
            }

            public void onExtrasChanged(Bundle bundle) {
                MediaSessionCompat.b(bundle);
                Callback callback = this.f2282a.get();
                if (callback != null) {
                    callback.d(bundle);
                }
            }

            public void onMetadataChanged(MediaMetadata mediaMetadata) {
                Callback callback = this.f2282a.get();
                if (callback != null) {
                    callback.e(MediaMetadataCompat.b(mediaMetadata));
                }
            }

            public void onPlaybackStateChanged(PlaybackState playbackState) {
                Callback callback = this.f2282a.get();
                if (callback != null && callback.f2281c == null) {
                    callback.f(PlaybackStateCompat.a(playbackState));
                }
            }

            public void onQueueChanged(List<MediaSession.QueueItem> list) {
                Callback callback = this.f2282a.get();
                if (callback != null) {
                    callback.g(MediaSessionCompat.QueueItem.b(list));
                }
            }

            public void onQueueTitleChanged(CharSequence charSequence) {
                Callback callback = this.f2282a.get();
                if (callback != null) {
                    callback.h(charSequence);
                }
            }

            public void onSessionDestroyed() {
                Callback callback = this.f2282a.get();
                if (callback != null) {
                    callback.j();
                }
            }

            public void onSessionEvent(String str, Bundle bundle) {
                MediaSessionCompat.b(bundle);
                Callback callback = this.f2282a.get();
                if (callback == null) {
                    return;
                }
                if (callback.f2281c == null || Build.VERSION.SDK_INT >= 23) {
                    callback.k(str, bundle);
                }
            }
        }

        private class MessageHandler extends Handler {

            /* renamed from: c  reason: collision with root package name */
            private static final int f2283c = 1;

            /* renamed from: d  reason: collision with root package name */
            private static final int f2284d = 2;

            /* renamed from: e  reason: collision with root package name */
            private static final int f2285e = 3;

            /* renamed from: f  reason: collision with root package name */
            private static final int f2286f = 4;

            /* renamed from: g  reason: collision with root package name */
            private static final int f2287g = 5;

            /* renamed from: h  reason: collision with root package name */
            private static final int f2288h = 6;

            /* renamed from: i  reason: collision with root package name */
            private static final int f2289i = 7;

            /* renamed from: j  reason: collision with root package name */
            private static final int f2290j = 8;

            /* renamed from: k  reason: collision with root package name */
            private static final int f2291k = 9;

            /* renamed from: l  reason: collision with root package name */
            private static final int f2292l = 11;

            /* renamed from: m  reason: collision with root package name */
            private static final int f2293m = 12;

            /* renamed from: n  reason: collision with root package name */
            private static final int f2294n = 13;

            /* renamed from: a  reason: collision with root package name */
            boolean f2295a = false;

            MessageHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (this.f2295a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.b(data);
                            Callback.this.k((String) message.obj, data);
                            return;
                        case 2:
                            Callback.this.f((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            Callback.this.e((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            Callback.this.b((PlaybackInfo) message.obj);
                            return;
                        case 5:
                            Callback.this.g((List) message.obj);
                            return;
                        case 6:
                            Callback.this.h((CharSequence) message.obj);
                            return;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.b(bundle);
                            Callback.this.d(bundle);
                            return;
                        case 8:
                            Callback.this.j();
                            return;
                        case 9:
                            Callback.this.i(((Integer) message.obj).intValue());
                            return;
                        case 11:
                            Callback.this.c(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            Callback.this.m(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            Callback.this.l();
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        private static class StubCompat extends IMediaControllerCallback.Stub {
            private final WeakReference<Callback> y;

            StubCompat(Callback callback) {
                this.y = new WeakReference<>(callback);
            }

            public void D0() throws RemoteException {
                Callback callback = this.y.get();
                if (callback != null) {
                    callback.n(8, (Object) null, (Bundle) null);
                }
            }

            public void F0(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Callback callback = this.y.get();
                if (callback != null) {
                    callback.n(3, mediaMetadataCompat, (Bundle) null);
                }
            }

            public void M0(int i2) throws RemoteException {
                Callback callback = this.y.get();
                if (callback != null) {
                    callback.n(12, Integer.valueOf(i2), (Bundle) null);
                }
            }

            public void Z() throws RemoteException {
                Callback callback = this.y.get();
                if (callback != null) {
                    callback.n(13, (Object) null, (Bundle) null);
                }
            }

            public void Z0(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback callback = this.y.get();
                if (callback != null) {
                    callback.n(2, playbackStateCompat, (Bundle) null);
                }
            }

            public void a0(Bundle bundle) throws RemoteException {
                Callback callback = this.y.get();
                if (callback != null) {
                    callback.n(7, bundle, (Bundle) null);
                }
            }

            public void b1(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Callback callback = this.y.get();
                if (callback != null) {
                    callback.n(4, parcelableVolumeInfo != null ? new PlaybackInfo(parcelableVolumeInfo.s, parcelableVolumeInfo.X, parcelableVolumeInfo.Y, parcelableVolumeInfo.Z, parcelableVolumeInfo.X2) : null, (Bundle) null);
                }
            }

            public void d0(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Callback callback = this.y.get();
                if (callback != null) {
                    callback.n(5, list, (Bundle) null);
                }
            }

            public void s0(boolean z) throws RemoteException {
                Callback callback = this.y.get();
                if (callback != null) {
                    callback.n(11, Boolean.valueOf(z), (Bundle) null);
                }
            }

            public void x(int i2) throws RemoteException {
                Callback callback = this.y.get();
                if (callback != null) {
                    callback.n(9, Integer.valueOf(i2), (Bundle) null);
                }
            }

            public void y(String str, Bundle bundle) throws RemoteException {
                Callback callback = this.y.get();
                if (callback != null) {
                    callback.n(1, str, bundle);
                }
            }

            public void y0(boolean z) throws RemoteException {
            }

            public void z0(CharSequence charSequence) throws RemoteException {
                Callback callback = this.y.get();
                if (callback != null) {
                    callback.n(6, charSequence, (Bundle) null);
                }
            }
        }

        @RestrictTo({RestrictTo.Scope.Y})
        public IMediaControllerCallback a() {
            return this.f2281c;
        }

        public void b(PlaybackInfo playbackInfo) {
        }

        public void binderDied() {
            n(8, (Object) null, (Bundle) null);
        }

        public void c(boolean z) {
        }

        public void d(Bundle bundle) {
        }

        public void e(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void f(PlaybackStateCompat playbackStateCompat) {
        }

        public void g(List<MediaSessionCompat.QueueItem> list) {
        }

        public void h(CharSequence charSequence) {
        }

        public void i(int i2) {
        }

        public void j() {
        }

        public void k(String str, Bundle bundle) {
        }

        public void l() {
        }

        public void m(int i2) {
        }

        /* access modifiers changed from: package-private */
        public void n(int i2, Object obj, Bundle bundle) {
            MessageHandler messageHandler = this.f2280b;
            if (messageHandler != null) {
                Message obtainMessage = messageHandler.obtainMessage(i2, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        /* access modifiers changed from: package-private */
        public void o(Handler handler) {
            if (handler == null) {
                MessageHandler messageHandler = this.f2280b;
                if (messageHandler != null) {
                    messageHandler.f2295a = false;
                    messageHandler.removeCallbacksAndMessages((Object) null);
                    this.f2280b = null;
                    return;
                }
                return;
            }
            MessageHandler messageHandler2 = new MessageHandler(handler.getLooper());
            this.f2280b = messageHandler2;
            messageHandler2.f2295a = true;
        }
    }

    interface MediaControllerImpl {
        int I();

        boolean J();

        List<MediaSessionCompat.QueueItem> K();

        PlaybackInfo a();

        void b(int i2, int i3);

        void c(Callback callback);

        boolean d(KeyEvent keyEvent);

        void e(int i2, int i3);

        void f(MediaDescriptionCompat mediaDescriptionCompat, int i2);

        void g(String str, Bundle bundle, ResultReceiver resultReceiver);

        Bundle getExtras();

        boolean h();

        PlaybackStateCompat i();

        long j();

        PendingIntent k();

        MediaMetadataCompat l();

        TransportControls m();

        Object n();

        void o(Callback callback, Handler handler);

        int q();

        String r();

        void s(MediaDescriptionCompat mediaDescriptionCompat);

        void t(MediaDescriptionCompat mediaDescriptionCompat);

        int u();

        CharSequence v();

        Bundle w();
    }

    @RequiresApi(21)
    static class MediaControllerImplApi21 implements MediaControllerImpl {

        /* renamed from: a  reason: collision with root package name */
        protected final MediaController f2297a;

        /* renamed from: b  reason: collision with root package name */
        final Object f2298b = new Object();
        @GuardedBy("mLock")

        /* renamed from: c  reason: collision with root package name */
        private final List<Callback> f2299c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private HashMap<Callback, ExtraCallback> f2300d = new HashMap<>();

        /* renamed from: e  reason: collision with root package name */
        protected Bundle f2301e;

        /* renamed from: f  reason: collision with root package name */
        final MediaSessionCompat.Token f2302f;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> s;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super((Handler) null);
                this.s = new WeakReference<>(mediaControllerImplApi21);
            }

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i2, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.s.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.f2298b) {
                        mediaControllerImplApi21.f2302f.k(IMediaSession.Stub.e(BundleCompat.a(bundle, MediaSessionCompat.K)));
                        mediaControllerImplApi21.f2302f.l(ParcelUtils.c(bundle, MediaSessionCompat.L));
                        mediaControllerImplApi21.x();
                    }
                }
            }
        }

        private static class ExtraCallback extends Callback.StubCompat {
            ExtraCallback(Callback callback) {
                super(callback);
            }

            public void D0() throws RemoteException {
                throw new AssertionError();
            }

            public void F0(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            public void a0(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void b1(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }

            public void d0(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            public void z0(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }
        }

        MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f2302f = token;
            this.f2297a = new MediaController(context, (MediaSession.Token) token.j());
            if (token.d() == null) {
                y();
            }
        }

        @Nullable
        static MediaControllerCompat p(@NonNull Activity activity) {
            MediaController mediaController = activity.getMediaController();
            if (mediaController == null) {
                return null;
            }
            return new MediaControllerCompat((Context) activity, MediaSessionCompat.Token.b(mediaController.getSessionToken()));
        }

        private void y() {
            g(MediaControllerCompat.f2269e, (Bundle) null, new ExtraBinderRequestResultReceiver(this));
        }

        static void z(@NonNull Activity activity, @Nullable MediaControllerCompat mediaControllerCompat) {
            activity.setMediaController(mediaControllerCompat != null ? new MediaController(activity, (MediaSession.Token) mediaControllerCompat.t().j()) : null);
        }

        public int I() {
            if (this.f2302f.d() == null) {
                return -1;
            }
            try {
                return this.f2302f.d().I();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getShuffleMode.", e2);
                return -1;
            }
        }

        public boolean J() {
            if (this.f2302f.d() == null) {
                return false;
            }
            try {
                return this.f2302f.d().J();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in isCaptioningEnabled.", e2);
                return false;
            }
        }

        public List<MediaSessionCompat.QueueItem> K() {
            List<MediaSession.QueueItem> queue = this.f2297a.getQueue();
            if (queue != null) {
                return MediaSessionCompat.QueueItem.b(queue);
            }
            return null;
        }

        public PlaybackInfo a() {
            MediaController.PlaybackInfo playbackInfo = this.f2297a.getPlaybackInfo();
            if (playbackInfo != null) {
                return new PlaybackInfo(playbackInfo.getPlaybackType(), AudioAttributesCompat.k(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
            }
            return null;
        }

        public void b(int i2, int i3) {
            this.f2297a.adjustVolume(i2, i3);
        }

        public final void c(Callback callback) {
            this.f2297a.unregisterCallback(callback.f2279a);
            synchronized (this.f2298b) {
                if (this.f2302f.d() != null) {
                    try {
                        ExtraCallback remove = this.f2300d.remove(callback);
                        if (remove != null) {
                            callback.f2281c = null;
                            this.f2302f.d().j0(remove);
                        }
                    } catch (RemoteException e2) {
                        Log.e(MediaControllerCompat.f2268d, "Dead object in unregisterCallback.", e2);
                    }
                } else {
                    this.f2299c.remove(callback);
                }
            }
        }

        public boolean d(KeyEvent keyEvent) {
            return this.f2297a.dispatchMediaButtonEvent(keyEvent);
        }

        public void e(int i2, int i3) {
            this.f2297a.setVolumeTo(i2, i3);
        }

        public void f(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
            if ((j() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaControllerCompat.f2274j, mediaDescriptionCompat);
                bundle.putInt(MediaControllerCompat.f2275k, i2);
                g(MediaControllerCompat.f2271g, bundle, (ResultReceiver) null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.f2297a.sendCommand(str, bundle, resultReceiver);
        }

        public Bundle getExtras() {
            return this.f2297a.getExtras();
        }

        public boolean h() {
            return this.f2302f.d() != null;
        }

        public PlaybackStateCompat i() {
            if (this.f2302f.d() != null) {
                try {
                    return this.f2302f.d().i();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.f2268d, "Dead object in getPlaybackState.", e2);
                }
            }
            PlaybackState playbackState = this.f2297a.getPlaybackState();
            if (playbackState != null) {
                return PlaybackStateCompat.a(playbackState);
            }
            return null;
        }

        public long j() {
            return this.f2297a.getFlags();
        }

        public PendingIntent k() {
            return this.f2297a.getSessionActivity();
        }

        public MediaMetadataCompat l() {
            MediaMetadata metadata = this.f2297a.getMetadata();
            if (metadata != null) {
                return MediaMetadataCompat.b(metadata);
            }
            return null;
        }

        public TransportControls m() {
            MediaController.TransportControls transportControls = this.f2297a.getTransportControls();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                return new TransportControlsApi29(transportControls);
            }
            if (i2 >= 24) {
                return new TransportControlsApi24(transportControls);
            }
            return i2 >= 23 ? new TransportControlsApi23(transportControls) : new TransportControlsApi21(transportControls);
        }

        public Object n() {
            return this.f2297a;
        }

        public final void o(Callback callback, Handler handler) {
            this.f2297a.registerCallback(callback.f2279a, handler);
            synchronized (this.f2298b) {
                if (this.f2302f.d() != null) {
                    ExtraCallback extraCallback = new ExtraCallback(callback);
                    this.f2300d.put(callback, extraCallback);
                    callback.f2281c = extraCallback;
                    try {
                        this.f2302f.d().N(extraCallback);
                        callback.n(13, (Object) null, (Bundle) null);
                    } catch (RemoteException e2) {
                        Log.e(MediaControllerCompat.f2268d, "Dead object in registerCallback.", e2);
                    }
                } else {
                    callback.f2281c = null;
                    this.f2299c.add(callback);
                }
            }
        }

        public int q() {
            if (this.f2302f.d() == null) {
                return -1;
            }
            try {
                return this.f2302f.d().q();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getRepeatMode.", e2);
                return -1;
            }
        }

        public String r() {
            return this.f2297a.getPackageName();
        }

        public void s(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((j() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaControllerCompat.f2274j, mediaDescriptionCompat);
                g(MediaControllerCompat.f2272h, bundle, (ResultReceiver) null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        public void t(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((j() & 4) != 0) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaControllerCompat.f2274j, mediaDescriptionCompat);
                g(MediaControllerCompat.f2270f, bundle, (ResultReceiver) null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        public int u() {
            if (Build.VERSION.SDK_INT < 22 && this.f2302f.d() != null) {
                try {
                    return this.f2302f.d().u();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.f2268d, "Dead object in getRatingType.", e2);
                }
            }
            return this.f2297a.getRatingType();
        }

        public CharSequence v() {
            return this.f2297a.getQueueTitle();
        }

        public Bundle w() {
            if (this.f2301e != null) {
                return new Bundle(this.f2301e);
            }
            if (this.f2302f.d() != null) {
                try {
                    this.f2301e = this.f2302f.d().w();
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.f2268d, "Dead object in getSessionInfo.", e2);
                    this.f2301e = Bundle.EMPTY;
                }
            }
            Bundle G = MediaSessionCompat.G(this.f2301e);
            this.f2301e = G;
            return G == null ? Bundle.EMPTY : new Bundle(this.f2301e);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("mLock")
        public void x() {
            if (this.f2302f.d() != null) {
                for (Callback next : this.f2299c) {
                    ExtraCallback extraCallback = new ExtraCallback(next);
                    this.f2300d.put(next, extraCallback);
                    next.f2281c = extraCallback;
                    try {
                        this.f2302f.d().N(extraCallback);
                        next.n(13, (Object) null, (Bundle) null);
                    } catch (RemoteException e2) {
                        Log.e(MediaControllerCompat.f2268d, "Dead object in registerCallback.", e2);
                    }
                }
                this.f2299c.clear();
            }
        }
    }

    @RequiresApi(29)
    static class MediaControllerImplApi29 extends MediaControllerImplApi21 {
        MediaControllerImplApi29(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }

        public Bundle w() {
            if (this.f2301e != null) {
                return new Bundle(this.f2301e);
            }
            Bundle a2 = this.f2297a.getSessionInfo();
            this.f2301e = a2;
            Bundle G = MediaSessionCompat.G(a2);
            this.f2301e = G;
            return G == null ? Bundle.EMPTY : new Bundle(this.f2301e);
        }
    }

    static class MediaControllerImplBase implements MediaControllerImpl {

        /* renamed from: a  reason: collision with root package name */
        private IMediaSession f2303a;

        /* renamed from: b  reason: collision with root package name */
        private TransportControls f2304b;

        /* renamed from: c  reason: collision with root package name */
        private Bundle f2305c;

        MediaControllerImplBase(MediaSessionCompat.Token token) {
            this.f2303a = IMediaSession.Stub.e((IBinder) token.j());
        }

        public int I() {
            try {
                return this.f2303a.I();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getShuffleMode.", e2);
                return -1;
            }
        }

        public boolean J() {
            try {
                return this.f2303a.J();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in isCaptioningEnabled.", e2);
                return false;
            }
        }

        public List<MediaSessionCompat.QueueItem> K() {
            try {
                return this.f2303a.K();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getQueue.", e2);
                return null;
            }
        }

        public PlaybackInfo a() {
            try {
                ParcelableVolumeInfo V0 = this.f2303a.V0();
                return new PlaybackInfo(V0.s, V0.X, V0.Y, V0.Z, V0.X2);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getPlaybackInfo.", e2);
                return null;
            }
        }

        public void b(int i2, int i3) {
            try {
                this.f2303a.A0(i2, i3, (String) null);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in adjustVolume.", e2);
            }
        }

        public void c(Callback callback) {
            if (callback != null) {
                try {
                    this.f2303a.j0(callback.f2281c);
                    this.f2303a.asBinder().unlinkToDeath(callback, 0);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.f2268d, "Dead object in unregisterCallback.", e2);
                }
            } else {
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        public boolean d(KeyEvent keyEvent) {
            if (keyEvent != null) {
                try {
                    this.f2303a.x0(keyEvent);
                    return false;
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.f2268d, "Dead object in dispatchMediaButtonEvent.", e2);
                    return false;
                }
            } else {
                throw new IllegalArgumentException("event may not be null.");
            }
        }

        public void e(int i2, int i3) {
            try {
                this.f2303a.Q(i2, i3, (String) null);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in setVolumeTo.", e2);
            }
        }

        public void f(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
            try {
                if ((this.f2303a.j() & 4) != 0) {
                    this.f2303a.E0(mediaDescriptionCompat, i2);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in addQueueItemAt.", e2);
            }
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver) {
            try {
                this.f2303a.N0(str, bundle, resultReceiver == null ? null : new MediaSessionCompat.ResultReceiverWrapper(resultReceiver));
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in sendCommand.", e2);
            }
        }

        public Bundle getExtras() {
            try {
                return this.f2303a.getExtras();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getExtras.", e2);
                return null;
            }
        }

        public boolean h() {
            return true;
        }

        public PlaybackStateCompat i() {
            try {
                return this.f2303a.i();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getPlaybackState.", e2);
                return null;
            }
        }

        public long j() {
            try {
                return this.f2303a.j();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getFlags.", e2);
                return 0;
            }
        }

        public PendingIntent k() {
            try {
                return this.f2303a.U();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getSessionActivity.", e2);
                return null;
            }
        }

        public MediaMetadataCompat l() {
            try {
                return this.f2303a.l();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getMetadata.", e2);
                return null;
            }
        }

        public TransportControls m() {
            if (this.f2304b == null) {
                this.f2304b = new TransportControlsBase(this.f2303a);
            }
            return this.f2304b;
        }

        public Object n() {
            return null;
        }

        public void o(Callback callback, Handler handler) {
            if (callback != null) {
                try {
                    this.f2303a.asBinder().linkToDeath(callback, 0);
                    this.f2303a.N(callback.f2281c);
                    callback.n(13, (Object) null, (Bundle) null);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.f2268d, "Dead object in registerCallback.", e2);
                    callback.n(8, (Object) null, (Bundle) null);
                }
            } else {
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        public int q() {
            try {
                return this.f2303a.q();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getRepeatMode.", e2);
                return -1;
            }
        }

        public String r() {
            try {
                return this.f2303a.r();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getPackageName.", e2);
                return null;
            }
        }

        public void s(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.f2303a.j() & 4) != 0) {
                    this.f2303a.s(mediaDescriptionCompat);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in removeQueueItem.", e2);
            }
        }

        public void t(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.f2303a.j() & 4) != 0) {
                    this.f2303a.t(mediaDescriptionCompat);
                    return;
                }
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in addQueueItem.", e2);
            }
        }

        public int u() {
            try {
                return this.f2303a.u();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getRatingType.", e2);
                return 0;
            }
        }

        public CharSequence v() {
            try {
                return this.f2303a.v();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in getQueueTitle.", e2);
                return null;
            }
        }

        public Bundle w() {
            try {
                this.f2305c = this.f2303a.w();
            } catch (RemoteException e2) {
                Log.d(MediaControllerCompat.f2268d, "Dead object in getSessionInfo.", e2);
            }
            Bundle G = MediaSessionCompat.G(this.f2305c);
            this.f2305c = G;
            return G == null ? Bundle.EMPTY : new Bundle(this.f2305c);
        }
    }

    public static final class PlaybackInfo {

        /* renamed from: f  reason: collision with root package name */
        public static final int f2306f = 1;

        /* renamed from: g  reason: collision with root package name */
        public static final int f2307g = 2;

        /* renamed from: a  reason: collision with root package name */
        private final int f2308a;

        /* renamed from: b  reason: collision with root package name */
        private final AudioAttributesCompat f2309b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2310c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2311d;

        /* renamed from: e  reason: collision with root package name */
        private final int f2312e;

        PlaybackInfo(int i2, int i3, int i4, int i5, int i6) {
            this(i2, new AudioAttributesCompat.Builder().d(i3).a(), i4, i5, i6);
        }

        @NonNull
        public AudioAttributesCompat a() {
            return this.f2309b;
        }

        @Deprecated
        public int b() {
            return this.f2309b.e();
        }

        public int c() {
            return this.f2312e;
        }

        public int d() {
            return this.f2311d;
        }

        public int e() {
            return this.f2308a;
        }

        public int f() {
            return this.f2310c;
        }

        PlaybackInfo(int i2, @NonNull AudioAttributesCompat audioAttributesCompat, int i3, int i4, int i5) {
            this.f2308a = i2;
            this.f2309b = audioAttributesCompat;
            this.f2310c = i3;
            this.f2311d = i4;
            this.f2312e = i5;
        }
    }

    public static abstract class TransportControls {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final String f2313a = "android.media.session.extra.LEGACY_STREAM_TYPE";

        TransportControls() {
        }

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d(String str, Bundle bundle);

        public abstract void e(String str, Bundle bundle);

        public abstract void f(Uri uri, Bundle bundle);

        public abstract void g();

        public abstract void h(String str, Bundle bundle);

        public abstract void i(String str, Bundle bundle);

        public abstract void j(Uri uri, Bundle bundle);

        public abstract void k();

        public abstract void l(long j2);

        public abstract void m(PlaybackStateCompat.CustomAction customAction, Bundle bundle);

        public abstract void n(String str, Bundle bundle);

        public abstract void o(boolean z);

        public void p(float f2) {
        }

        public abstract void q(RatingCompat ratingCompat);

        public abstract void r(RatingCompat ratingCompat, Bundle bundle);

        public abstract void s(int i2);

        public abstract void t(int i2);

        public abstract void u();

        public abstract void v();

        public abstract void w(long j2);

        public abstract void x();
    }

    @RequiresApi(21)
    static class TransportControlsApi21 extends TransportControls {

        /* renamed from: b  reason: collision with root package name */
        protected final MediaController.TransportControls f2314b;

        TransportControlsApi21(MediaController.TransportControls transportControls) {
            this.f2314b = transportControls;
        }

        public void a() {
            this.f2314b.fastForward();
        }

        public void b() {
            this.f2314b.pause();
        }

        public void c() {
            this.f2314b.play();
        }

        public void d(String str, Bundle bundle) {
            this.f2314b.playFromMediaId(str, bundle);
        }

        public void e(String str, Bundle bundle) {
            this.f2314b.playFromSearch(str, bundle);
        }

        public void f(Uri uri, Bundle bundle) {
            if (uri == null || Uri.EMPTY.equals(uri)) {
                throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.C, uri);
            bundle2.putBundle(MediaSessionCompat.F, bundle);
            n(MediaSessionCompat.q, bundle2);
        }

        public void g() {
            n(MediaSessionCompat.r, (Bundle) null);
        }

        public void h(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaSessionCompat.A, str);
            bundle2.putBundle(MediaSessionCompat.F, bundle);
            n(MediaSessionCompat.s, bundle2);
        }

        public void i(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaSessionCompat.B, str);
            bundle2.putBundle(MediaSessionCompat.F, bundle);
            n(MediaSessionCompat.t, bundle2);
        }

        public void j(Uri uri, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.C, uri);
            bundle2.putBundle(MediaSessionCompat.F, bundle);
            n(MediaSessionCompat.u, bundle2);
        }

        public void k() {
            this.f2314b.rewind();
        }

        public void l(long j2) {
            this.f2314b.seekTo(j2);
        }

        public void m(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            MediaControllerCompat.G(customAction.b(), bundle);
            this.f2314b.sendCustomAction(customAction.b(), bundle);
        }

        public void n(String str, Bundle bundle) {
            MediaControllerCompat.G(str, bundle);
            this.f2314b.sendCustomAction(str, bundle);
        }

        public void o(boolean z) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(MediaSessionCompat.G, z);
            n(MediaSessionCompat.v, bundle);
        }

        public void p(float f2) {
            if (f2 != 0.0f) {
                Bundle bundle = new Bundle();
                bundle.putFloat(MediaSessionCompat.E, f2);
                n(MediaSessionCompat.z, bundle);
                return;
            }
            throw new IllegalArgumentException("speed must not be zero");
        }

        public void q(RatingCompat ratingCompat) {
            this.f2314b.setRating(ratingCompat != null ? (Rating) ratingCompat.c() : null);
        }

        public void r(RatingCompat ratingCompat, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.D, ratingCompat);
            bundle2.putBundle(MediaSessionCompat.F, bundle);
            n(MediaSessionCompat.y, bundle2);
        }

        public void s(int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.H, i2);
            n(MediaSessionCompat.w, bundle);
        }

        public void t(int i2) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.I, i2);
            n(MediaSessionCompat.x, bundle);
        }

        public void u() {
            this.f2314b.skipToNext();
        }

        public void v() {
            this.f2314b.skipToPrevious();
        }

        public void w(long j2) {
            this.f2314b.skipToQueueItem(j2);
        }

        public void x() {
            this.f2314b.stop();
        }
    }

    @RequiresApi(23)
    static class TransportControlsApi23 extends TransportControlsApi21 {
        TransportControlsApi23(MediaController.TransportControls transportControls) {
            super(transportControls);
        }

        public void f(Uri uri, Bundle bundle) {
            this.f2314b.playFromUri(uri, bundle);
        }
    }

    @RequiresApi(24)
    static class TransportControlsApi24 extends TransportControlsApi23 {
        TransportControlsApi24(MediaController.TransportControls transportControls) {
            super(transportControls);
        }

        public void g() {
            this.f2314b.prepare();
        }

        public void h(String str, Bundle bundle) {
            this.f2314b.prepareFromMediaId(str, bundle);
        }

        public void i(String str, Bundle bundle) {
            this.f2314b.prepareFromSearch(str, bundle);
        }

        public void j(Uri uri, Bundle bundle) {
            this.f2314b.prepareFromUri(uri, bundle);
        }
    }

    @RequiresApi(29)
    static class TransportControlsApi29 extends TransportControlsApi24 {
        TransportControlsApi29(MediaController.TransportControls transportControls) {
            super(transportControls);
        }

        public void p(float f2) {
            if (f2 != 0.0f) {
                this.f2314b.setPlaybackSpeed(f2);
                return;
            }
            throw new IllegalArgumentException("speed must not be zero");
        }
    }

    static class TransportControlsBase extends TransportControls {

        /* renamed from: b  reason: collision with root package name */
        private IMediaSession f2315b;

        public TransportControlsBase(IMediaSession iMediaSession) {
            this.f2315b = iMediaSession;
        }

        public void a() {
            try {
                this.f2315b.p0();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in fastForward.", e2);
            }
        }

        public void b() {
            try {
                this.f2315b.h();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in pause.", e2);
            }
        }

        public void c() {
            try {
                this.f2315b.o();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in play.", e2);
            }
        }

        public void d(String str, Bundle bundle) {
            try {
                this.f2315b.m0(str, bundle);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in playFromMediaId.", e2);
            }
        }

        public void e(String str, Bundle bundle) {
            try {
                this.f2315b.o0(str, bundle);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in playFromSearch.", e2);
            }
        }

        public void f(Uri uri, Bundle bundle) {
            try {
                this.f2315b.r0(uri, bundle);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in playFromUri.", e2);
            }
        }

        public void g() {
            try {
                this.f2315b.k();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in prepare.", e2);
            }
        }

        public void h(String str, Bundle bundle) {
            try {
                this.f2315b.i0(str, bundle);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in prepareFromMediaId.", e2);
            }
        }

        public void i(String str, Bundle bundle) {
            try {
                this.f2315b.W(str, bundle);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in prepareFromSearch.", e2);
            }
        }

        public void j(Uri uri, Bundle bundle) {
            try {
                this.f2315b.R(uri, bundle);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in prepareFromUri.", e2);
            }
        }

        public void k() {
            try {
                this.f2315b.P0();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in rewind.", e2);
            }
        }

        public void l(long j2) {
            try {
                this.f2315b.G(j2);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in seekTo.", e2);
            }
        }

        public void m(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            n(customAction.b(), bundle);
        }

        public void n(String str, Bundle bundle) {
            MediaControllerCompat.G(str, bundle);
            try {
                this.f2315b.M(str, bundle);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in sendCustomAction.", e2);
            }
        }

        public void o(boolean z) {
            try {
                this.f2315b.H(z);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in setCaptioningEnabled.", e2);
            }
        }

        public void p(float f2) {
            if (f2 != 0.0f) {
                try {
                    this.f2315b.m(f2);
                } catch (RemoteException e2) {
                    Log.e(MediaControllerCompat.f2268d, "Dead object in setPlaybackSpeed.", e2);
                }
            } else {
                throw new IllegalArgumentException("speed must not be zero");
            }
        }

        public void q(RatingCompat ratingCompat) {
            try {
                this.f2315b.P(ratingCompat);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in setRating.", e2);
            }
        }

        public void r(RatingCompat ratingCompat, Bundle bundle) {
            try {
                this.f2315b.C0(ratingCompat, bundle);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in setRating.", e2);
            }
        }

        public void s(int i2) {
            try {
                this.f2315b.p(i2);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in setRepeatMode.", e2);
            }
        }

        public void t(int i2) {
            try {
                this.f2315b.L(i2);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in setShuffleMode.", e2);
            }
        }

        public void u() {
            try {
                this.f2315b.next();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in skipToNext.", e2);
            }
        }

        public void v() {
            try {
                this.f2315b.previous();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in skipToPrevious.", e2);
            }
        }

        public void w(long j2) {
            try {
                this.f2315b.S0(j2);
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in skipToQueueItem.", e2);
            }
        }

        public void x() {
            try {
                this.f2315b.stop();
            } catch (RemoteException e2) {
                Log.e(MediaControllerCompat.f2268d, "Dead object in stop.", e2);
            }
        }
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat.Token token) {
        if (token != null) {
            this.f2278c = Collections.synchronizedSet(new HashSet());
            this.f2277b = token;
            this.f2276a = Build.VERSION.SDK_INT >= 29 ? new MediaControllerImplApi29(context, token) : new MediaControllerImplApi21(context, token);
            return;
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    public static void D(@NonNull Activity activity, MediaControllerCompat mediaControllerCompat) {
        activity.getWindow().getDecorView().setTag(R.id.f8998k, mediaControllerCompat);
        MediaControllerImplApi21.z(activity, mediaControllerCompat);
    }

    static void G(String str, Bundle bundle) {
        if (str != null) {
            if (!str.equals(MediaSessionCompat.f2322j) && !str.equals(MediaSessionCompat.f2323k)) {
                return;
            }
            if (bundle == null || !bundle.containsKey(MediaSessionCompat.f2324l)) {
                throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + str + ".");
            }
        }
    }

    public static MediaControllerCompat g(@NonNull Activity activity) {
        Object tag = activity.getWindow().getDecorView().getTag(R.id.f8998k);
        return tag instanceof MediaControllerCompat ? (MediaControllerCompat) tag : MediaControllerImplApi21.p(activity);
    }

    public void A(MediaDescriptionCompat mediaDescriptionCompat) {
        this.f2276a.s(mediaDescriptionCompat);
    }

    @Deprecated
    public void B(int i2) {
        MediaSessionCompat.QueueItem queueItem;
        List<MediaSessionCompat.QueueItem> m2 = m();
        if (m2 != null && i2 >= 0 && i2 < m2.size() && (queueItem = m2.get(i2)) != null) {
            A(queueItem.c());
        }
    }

    public void C(@NonNull String str, @Nullable Bundle bundle, @Nullable ResultReceiver resultReceiver) {
        if (!TextUtils.isEmpty(str)) {
            this.f2276a.g(str, bundle, resultReceiver);
            return;
        }
        throw new IllegalArgumentException("command must neither be null nor empty");
    }

    public void E(int i2, int i3) {
        this.f2276a.e(i2, i3);
    }

    public void F(@NonNull Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        } else if (!this.f2278c.remove(callback)) {
            Log.w(f2268d, "the callback has never been registered");
        } else {
            try {
                this.f2276a.c(callback);
            } finally {
                callback.o((Handler) null);
            }
        }
    }

    public void a(MediaDescriptionCompat mediaDescriptionCompat) {
        this.f2276a.t(mediaDescriptionCompat);
    }

    public void b(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
        this.f2276a.f(mediaDescriptionCompat, i2);
    }

    public void c(int i2, int i3) {
        this.f2276a.b(i2, i3);
    }

    public boolean d(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f2276a.d(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public Bundle e() {
        return this.f2276a.getExtras();
    }

    public long f() {
        return this.f2276a.j();
    }

    public Object h() {
        return this.f2276a.n();
    }

    public MediaMetadataCompat i() {
        return this.f2276a.l();
    }

    public String j() {
        return this.f2276a.r();
    }

    public PlaybackInfo k() {
        return this.f2276a.a();
    }

    public PlaybackStateCompat l() {
        return this.f2276a.i();
    }

    public List<MediaSessionCompat.QueueItem> m() {
        return this.f2276a.K();
    }

    public CharSequence n() {
        return this.f2276a.v();
    }

    public int o() {
        return this.f2276a.u();
    }

    public int p() {
        return this.f2276a.q();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.s})
    public VersionedParcelable q() {
        return this.f2277b.g();
    }

    public PendingIntent r() {
        return this.f2276a.k();
    }

    @NonNull
    public Bundle s() {
        return this.f2276a.w();
    }

    public MediaSessionCompat.Token t() {
        return this.f2277b;
    }

    public int u() {
        return this.f2276a.I();
    }

    public TransportControls v() {
        return this.f2276a.m();
    }

    public boolean w() {
        return this.f2276a.J();
    }

    public boolean x() {
        return this.f2276a.h();
    }

    public void y(@NonNull Callback callback) {
        z(callback, (Handler) null);
    }

    public void z(@NonNull Callback callback, Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        } else if (!this.f2278c.add(callback)) {
            Log.w(f2268d, "the callback has already been registered");
        } else {
            if (handler == null) {
                handler = new Handler();
            }
            callback.o(handler);
            this.f2276a.o(callback, handler);
        }
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat mediaSessionCompat) {
        this(context, mediaSessionCompat.i());
    }
}
