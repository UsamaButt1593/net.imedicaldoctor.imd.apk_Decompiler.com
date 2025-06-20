package android.support.v4.media;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import com.dd.plist.ASCIIPropertyListParser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class MediaBrowserCompat {

    /* renamed from: b  reason: collision with root package name */
    static final String f2200b = "MediaBrowserCompat";

    /* renamed from: c  reason: collision with root package name */
    static final boolean f2201c = Log.isLoggable(f2200b, 3);

    /* renamed from: d  reason: collision with root package name */
    public static final String f2202d = "android.media.browse.extra.PAGE";

    /* renamed from: e  reason: collision with root package name */
    public static final String f2203e = "android.media.browse.extra.PAGE_SIZE";

    /* renamed from: f  reason: collision with root package name */
    public static final String f2204f = "android.media.browse.extra.MEDIA_ID";

    /* renamed from: g  reason: collision with root package name */
    public static final String f2205g = "android.media.browse.extra.DOWNLOAD_PROGRESS";

    /* renamed from: h  reason: collision with root package name */
    public static final String f2206h = "android.support.v4.media.action.DOWNLOAD";

    /* renamed from: i  reason: collision with root package name */
    public static final String f2207i = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";

    /* renamed from: a  reason: collision with root package name */
    private final MediaBrowserImpl f2208a;

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static MediaDescription a(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getDescription();
        }

        @DoNotInline
        static int b(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getFlags();
        }
    }

    private static class CallbackHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<MediaBrowserServiceCallbackImpl> f2209a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<Messenger> f2210b;

        CallbackHandler(MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.f2209a = new WeakReference<>(mediaBrowserServiceCallbackImpl);
        }

        /* access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            this.f2210b = new WeakReference<>(messenger);
        }

        public void handleMessage(@NonNull Message message) {
            WeakReference<Messenger> weakReference = this.f2210b;
            if (weakReference != null && weakReference.get() != null && this.f2209a.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.b(data);
                MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = this.f2209a.get();
                Messenger messenger = this.f2210b.get();
                try {
                    int i2 = message.what;
                    if (i2 == 1) {
                        Bundle bundle = data.getBundle(MediaBrowserProtocol.f8909k);
                        MediaSessionCompat.b(bundle);
                        mediaBrowserServiceCallbackImpl.a(messenger, data.getString(MediaBrowserProtocol.f8902d), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.f8904f), bundle);
                    } else if (i2 == 2) {
                        mediaBrowserServiceCallbackImpl.d(messenger);
                    } else if (i2 != 3) {
                        Log.w(MediaBrowserCompat.f2200b, "Unhandled message: " + message + "\n  Client version: " + 1 + "\n  Service version: " + message.arg1);
                    } else {
                        Bundle bundle2 = data.getBundle(MediaBrowserProtocol.f8905g);
                        MediaSessionCompat.b(bundle2);
                        Bundle bundle3 = data.getBundle(MediaBrowserProtocol.f8906h);
                        MediaSessionCompat.b(bundle3);
                        mediaBrowserServiceCallbackImpl.b(messenger, data.getString(MediaBrowserProtocol.f8902d), data.getParcelableArrayList(MediaBrowserProtocol.f8903e), bundle2, bundle3);
                    }
                } catch (BadParcelableException unused) {
                    Log.e(MediaBrowserCompat.f2200b, "Could not unparcel the data.");
                    if (message.what == 1) {
                        mediaBrowserServiceCallbackImpl.d(messenger);
                    }
                }
            }
        }
    }

    public static class ConnectionCallback {

        /* renamed from: a  reason: collision with root package name */
        final MediaBrowser.ConnectionCallback f2211a = new ConnectionCallbackApi21();

        /* renamed from: b  reason: collision with root package name */
        ConnectionCallbackInternal f2212b;

        @RequiresApi(21)
        private class ConnectionCallbackApi21 extends MediaBrowser.ConnectionCallback {
            ConnectionCallbackApi21() {
            }

            public void onConnected() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.f2212b;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.e();
                }
                ConnectionCallback.this.a();
            }

            public void onConnectionFailed() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.f2212b;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.f();
                }
                ConnectionCallback.this.b();
            }

            public void onConnectionSuspended() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.f2212b;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.c();
                }
                ConnectionCallback.this.c();
            }
        }

        interface ConnectionCallbackInternal {
            void c();

            void e();

            void f();
        }

        public void a() {
        }

        public void b() {
        }

        public void c() {
        }

        /* access modifiers changed from: package-private */
        public void d(ConnectionCallbackInternal connectionCallbackInternal) {
            this.f2212b = connectionCallbackInternal;
        }
    }

    public static abstract class CustomActionCallback {
        public void a(String str, Bundle bundle, Bundle bundle2) {
        }

        public void b(String str, Bundle bundle, Bundle bundle2) {
        }

        public void c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    private static class CustomActionResultReceiver extends ResultReceiver {
        private final Bundle X2;
        private final CustomActionCallback Y2;
        private final String Z;

        CustomActionResultReceiver(String str, Bundle bundle, CustomActionCallback customActionCallback, Handler handler) {
            super(handler);
            this.Z = str;
            this.X2 = bundle;
            this.Y2 = customActionCallback;
        }

        /* access modifiers changed from: protected */
        public void a(int i2, Bundle bundle) {
            if (this.Y2 != null) {
                MediaSessionCompat.b(bundle);
                if (i2 == -1) {
                    this.Y2.a(this.Z, this.X2, bundle);
                } else if (i2 == 0) {
                    this.Y2.c(this.Z, this.X2, bundle);
                } else if (i2 != 1) {
                    Log.w(MediaBrowserCompat.f2200b, "Unknown result code: " + i2 + " (extras=" + this.X2 + ", resultData=" + bundle + ")");
                } else {
                    this.Y2.b(this.Z, this.X2, bundle);
                }
            }
        }
    }

    public static abstract class ItemCallback {

        /* renamed from: a  reason: collision with root package name */
        final MediaBrowser.ItemCallback f2214a;

        @RequiresApi(23)
        private class ItemCallbackApi23 extends MediaBrowser.ItemCallback {
            ItemCallbackApi23() {
            }

            public void onError(@NonNull String str) {
                ItemCallback.this.a(str);
            }

            public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
                ItemCallback.this.b(MediaItem.a(mediaItem));
            }
        }

        public ItemCallback() {
            this.f2214a = Build.VERSION.SDK_INT >= 23 ? new ItemCallbackApi23() : null;
        }

        public void a(@NonNull String str) {
        }

        public void b(MediaItem mediaItem) {
        }
    }

    private static class ItemReceiver extends ResultReceiver {
        private final ItemCallback X2;
        private final String Z;

        ItemReceiver(String str, ItemCallback itemCallback, Handler handler) {
            super(handler);
            this.Z = str;
            this.X2 = itemCallback;
        }

        /* access modifiers changed from: protected */
        public void a(int i2, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.G(bundle);
            }
            if (i2 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.f3)) {
                this.X2.a(this.Z);
                return;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.f3);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.X2.b((MediaItem) parcelable);
            } else {
                this.X2.a(this.Z);
            }
        }
    }

    interface MediaBrowserImpl {
        @Nullable
        Bundle getExtras();

        @NonNull
        String i();

        boolean j();

        @NonNull
        MediaSessionCompat.Token k();

        void l();

        void m(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback);

        ComponentName n();

        void o(@NonNull String str, @NonNull ItemCallback itemCallback);

        void p();

        void q(@NonNull String str, @Nullable Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback);

        void r(@NonNull String str, SubscriptionCallback subscriptionCallback);

        void s(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback);

        @Nullable
        Bundle t();
    }

    @RequiresApi(21)
    static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {

        /* renamed from: a  reason: collision with root package name */
        final Context f2216a;

        /* renamed from: b  reason: collision with root package name */
        protected final MediaBrowser f2217b;

        /* renamed from: c  reason: collision with root package name */
        protected final Bundle f2218c;

        /* renamed from: d  reason: collision with root package name */
        protected final CallbackHandler f2219d = new CallbackHandler(this);

        /* renamed from: e  reason: collision with root package name */
        private final ArrayMap<String, Subscription> f2220e = new ArrayMap<>();

        /* renamed from: f  reason: collision with root package name */
        protected int f2221f;

        /* renamed from: g  reason: collision with root package name */
        protected ServiceBinderWrapper f2222g;

        /* renamed from: h  reason: collision with root package name */
        protected Messenger f2223h;

        /* renamed from: i  reason: collision with root package name */
        private MediaSessionCompat.Token f2224i;

        /* renamed from: j  reason: collision with root package name */
        private Bundle f2225j;

        MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            Bundle bundle2;
            this.f2216a = context;
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            this.f2218c = bundle2;
            bundle2.putInt(MediaBrowserProtocol.p, 1);
            bundle2.putInt(MediaBrowserProtocol.q, Process.myPid());
            connectionCallback.d(this);
            this.f2217b = new MediaBrowser(context, componentName, connectionCallback.f2211a, bundle2);
        }

        public void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        public void b(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            if (this.f2223h == messenger) {
                Subscription subscription = this.f2220e.get(str);
                if (subscription != null) {
                    SubscriptionCallback a2 = subscription.a(bundle);
                    if (a2 != null) {
                        if (bundle == null) {
                            if (list == null) {
                                a2.c(str);
                                return;
                            } else {
                                this.f2225j = bundle2;
                                a2.a(str, list);
                            }
                        } else if (list == null) {
                            a2.d(str, bundle);
                            return;
                        } else {
                            this.f2225j = bundle2;
                            a2.b(str, list, bundle);
                        }
                        this.f2225j = null;
                    }
                } else if (MediaBrowserCompat.f2201c) {
                    Log.d(MediaBrowserCompat.f2200b, "onLoadChildren for id that isn't subscribed id=" + str);
                }
            }
        }

        public void c() {
            this.f2222g = null;
            this.f2223h = null;
            this.f2224i = null;
            this.f2219d.a((Messenger) null);
        }

        public void d(Messenger messenger) {
        }

        public void e() {
            try {
                Bundle extras = this.f2217b.getExtras();
                if (extras != null) {
                    this.f2221f = extras.getInt(MediaBrowserProtocol.r, 0);
                    IBinder a2 = BundleCompat.a(extras, MediaBrowserProtocol.s);
                    if (a2 != null) {
                        this.f2222g = new ServiceBinderWrapper(a2, this.f2218c);
                        Messenger messenger = new Messenger(this.f2219d);
                        this.f2223h = messenger;
                        this.f2219d.a(messenger);
                        try {
                            this.f2222g.e(this.f2216a, this.f2223h);
                        } catch (RemoteException unused) {
                            Log.i(MediaBrowserCompat.f2200b, "Remote error registering client messenger.");
                        }
                    }
                    IMediaSession e2 = IMediaSession.Stub.e(BundleCompat.a(extras, MediaBrowserProtocol.t));
                    if (e2 != null) {
                        this.f2224i = MediaSessionCompat.Token.c(this.f2217b.getSessionToken(), e2);
                    }
                }
            } catch (IllegalStateException e3) {
                Log.e(MediaBrowserCompat.f2200b, "Unexpected IllegalStateException", e3);
            }
        }

        public void f() {
        }

        @Nullable
        public Bundle getExtras() {
            return this.f2217b.getExtras();
        }

        @NonNull
        public String i() {
            return this.f2217b.getRoot();
        }

        public boolean j() {
            return this.f2217b.isConnected();
        }

        @NonNull
        public MediaSessionCompat.Token k() {
            if (this.f2224i == null) {
                this.f2224i = MediaSessionCompat.Token.b(this.f2217b.getSessionToken());
            }
            return this.f2224i;
        }

        public void l() {
            Messenger messenger;
            ServiceBinderWrapper serviceBinderWrapper = this.f2222g;
            if (!(serviceBinderWrapper == null || (messenger = this.f2223h) == null)) {
                try {
                    serviceBinderWrapper.j(messenger);
                } catch (RemoteException unused) {
                    Log.i(MediaBrowserCompat.f2200b, "Remote error unregistering client messenger.");
                }
            }
            this.f2217b.disconnect();
        }

        public void m(@NonNull final String str, final Bundle bundle, @Nullable final CustomActionCallback customActionCallback) {
            if (j()) {
                if (this.f2222g == null) {
                    Log.i(MediaBrowserCompat.f2200b, "The connected service doesn't support sendCustomAction.");
                    if (customActionCallback != null) {
                        this.f2219d.post(new Runnable() {
                            public void run() {
                                customActionCallback.a(str, bundle, (Bundle) null);
                            }
                        });
                    }
                }
                try {
                    this.f2222g.h(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.f2219d), this.f2223h);
                } catch (RemoteException e2) {
                    Log.i(MediaBrowserCompat.f2200b, "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e2);
                    if (customActionCallback != null) {
                        this.f2219d.post(new Runnable() {
                            public void run() {
                                customActionCallback.a(str, bundle, (Bundle) null);
                            }
                        });
                    }
                }
            } else {
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
        }

        public ComponentName n() {
            return this.f2217b.getServiceComponent();
        }

        public void o(@NonNull final String str, @NonNull final ItemCallback itemCallback) {
            CallbackHandler callbackHandler;
            Runnable r1;
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            } else if (itemCallback != null) {
                if (!this.f2217b.isConnected()) {
                    Log.i(MediaBrowserCompat.f2200b, "Not connected, unable to retrieve the MediaItem.");
                    callbackHandler = this.f2219d;
                    r1 = new Runnable() {
                        public void run() {
                            itemCallback.a(str);
                        }
                    };
                } else if (this.f2222g == null) {
                    callbackHandler = this.f2219d;
                    r1 = new Runnable() {
                        public void run() {
                            itemCallback.a(str);
                        }
                    };
                } else {
                    try {
                        this.f2222g.d(str, new ItemReceiver(str, itemCallback, this.f2219d), this.f2223h);
                        return;
                    } catch (RemoteException unused) {
                        Log.i(MediaBrowserCompat.f2200b, "Remote error getting media item: " + str);
                        this.f2219d.post(new Runnable() {
                            public void run() {
                                itemCallback.a(str);
                            }
                        });
                        return;
                    }
                }
                callbackHandler.post(r1);
            } else {
                throw new IllegalArgumentException("cb is null");
            }
        }

        public void p() {
            this.f2217b.connect();
        }

        public void q(@NonNull String str, Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.f2220e.get(str);
            if (subscription == null) {
                subscription = new Subscription();
                this.f2220e.put(str, subscription);
            }
            subscriptionCallback.e(subscription);
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            subscription.e(bundle2, subscriptionCallback);
            ServiceBinderWrapper serviceBinderWrapper = this.f2222g;
            if (serviceBinderWrapper == null) {
                this.f2217b.subscribe(str, subscriptionCallback.f2244a);
                return;
            }
            try {
                serviceBinderWrapper.a(str, subscriptionCallback.f2245b, bundle2, this.f2223h);
            } catch (RemoteException unused) {
                Log.i(MediaBrowserCompat.f2200b, "Remote error subscribing media item: " + str);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
            if (r1.size() == 0) goto L_0x0011;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void r(@androidx.annotation.NonNull java.lang.String r8, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback r9) {
            /*
                r7 = this;
                androidx.collection.ArrayMap<java.lang.String, android.support.v4.media.MediaBrowserCompat$Subscription> r0 = r7.f2220e
                java.lang.Object r0 = r0.get(r8)
                android.support.v4.media.MediaBrowserCompat$Subscription r0 = (android.support.v4.media.MediaBrowserCompat.Subscription) r0
                if (r0 != 0) goto L_0x000b
                return
            L_0x000b:
                android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper r1 = r7.f2222g
                if (r1 != 0) goto L_0x003d
                if (r9 != 0) goto L_0x0017
            L_0x0011:
                android.media.browse.MediaBrowser r1 = r7.f2217b
                r1.unsubscribe(r8)
                goto L_0x0084
            L_0x0017:
                java.util.List r1 = r0.b()
                java.util.List r2 = r0.c()
                int r3 = r1.size()
                int r3 = r3 + -1
            L_0x0025:
                if (r3 < 0) goto L_0x0036
                java.lang.Object r4 = r1.get(r3)
                if (r4 != r9) goto L_0x0033
                r1.remove(r3)
                r2.remove(r3)
            L_0x0033:
                int r3 = r3 + -1
                goto L_0x0025
            L_0x0036:
                int r1 = r1.size()
                if (r1 != 0) goto L_0x0084
                goto L_0x0011
            L_0x003d:
                if (r9 != 0) goto L_0x0046
                android.os.Messenger r2 = r7.f2223h     // Catch:{ RemoteException -> 0x006e }
                r3 = 0
                r1.f(r8, r3, r2)     // Catch:{ RemoteException -> 0x006e }
                goto L_0x0084
            L_0x0046:
                java.util.List r1 = r0.b()     // Catch:{ RemoteException -> 0x006e }
                java.util.List r2 = r0.c()     // Catch:{ RemoteException -> 0x006e }
                int r3 = r1.size()     // Catch:{ RemoteException -> 0x006e }
                int r3 = r3 + -1
            L_0x0054:
                if (r3 < 0) goto L_0x0084
                java.lang.Object r4 = r1.get(r3)     // Catch:{ RemoteException -> 0x006e }
                if (r4 != r9) goto L_0x006b
                android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper r4 = r7.f2222g     // Catch:{ RemoteException -> 0x006e }
                android.os.IBinder r5 = r9.f2245b     // Catch:{ RemoteException -> 0x006e }
                android.os.Messenger r6 = r7.f2223h     // Catch:{ RemoteException -> 0x006e }
                r4.f(r8, r5, r6)     // Catch:{ RemoteException -> 0x006e }
                r1.remove(r3)     // Catch:{ RemoteException -> 0x006e }
                r2.remove(r3)     // Catch:{ RemoteException -> 0x006e }
            L_0x006b:
                int r3 = r3 + -1
                goto L_0x0054
            L_0x006e:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "removeSubscription failed with RemoteException parentId="
                r1.append(r2)
                r1.append(r8)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "MediaBrowserCompat"
                android.util.Log.d(r2, r1)
            L_0x0084:
                boolean r0 = r0.d()
                if (r0 != 0) goto L_0x008c
                if (r9 != 0) goto L_0x0091
            L_0x008c:
                androidx.collection.ArrayMap<java.lang.String, android.support.v4.media.MediaBrowserCompat$Subscription> r9 = r7.f2220e
                r9.remove(r8)
            L_0x0091:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.r(java.lang.String, android.support.v4.media.MediaBrowserCompat$SubscriptionCallback):void");
        }

        public void s(@NonNull final String str, final Bundle bundle, @NonNull final SearchCallback searchCallback) {
            if (!j()) {
                throw new IllegalStateException("search() called while not connected");
            } else if (this.f2222g == null) {
                Log.i(MediaBrowserCompat.f2200b, "The connected service doesn't support search.");
                this.f2219d.post(new Runnable() {
                    public void run() {
                        searchCallback.a(str, bundle);
                    }
                });
            } else {
                try {
                    this.f2222g.g(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.f2219d), this.f2223h);
                } catch (RemoteException e2) {
                    Log.i(MediaBrowserCompat.f2200b, "Remote error searching items with query: " + str, e2);
                    this.f2219d.post(new Runnable() {
                        public void run() {
                            searchCallback.a(str, bundle);
                        }
                    });
                }
            }
        }

        public Bundle t() {
            return this.f2225j;
        }
    }

    @RequiresApi(23)
    static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        MediaBrowserImplApi23(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        public void o(@NonNull String str, @NonNull ItemCallback itemCallback) {
            if (this.f2222g == null) {
                this.f2217b.getItem(str, itemCallback.f2214a);
            } else {
                super.o(str, itemCallback);
            }
        }
    }

    @RequiresApi(26)
    static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        MediaBrowserImplApi26(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        public void q(@NonNull String str, @Nullable Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            if (this.f2222g != null && this.f2221f >= 2) {
                super.q(str, bundle, subscriptionCallback);
            } else if (bundle == null) {
                this.f2217b.subscribe(str, subscriptionCallback.f2244a);
            } else {
                this.f2217b.subscribe(str, bundle, subscriptionCallback.f2244a);
            }
        }

        public void r(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            if (this.f2222g != null && this.f2221f >= 2) {
                super.r(str, subscriptionCallback);
            } else if (subscriptionCallback == null) {
                this.f2217b.unsubscribe(str);
            } else {
                this.f2217b.unsubscribe(str, subscriptionCallback.f2244a);
            }
        }
    }

    static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        static final int o = 0;
        static final int p = 1;
        static final int q = 2;
        static final int r = 3;
        static final int s = 4;

        /* renamed from: a  reason: collision with root package name */
        final Context f2226a;

        /* renamed from: b  reason: collision with root package name */
        final ComponentName f2227b;

        /* renamed from: c  reason: collision with root package name */
        final ConnectionCallback f2228c;

        /* renamed from: d  reason: collision with root package name */
        final Bundle f2229d;

        /* renamed from: e  reason: collision with root package name */
        final CallbackHandler f2230e = new CallbackHandler(this);

        /* renamed from: f  reason: collision with root package name */
        private final ArrayMap<String, Subscription> f2231f = new ArrayMap<>();

        /* renamed from: g  reason: collision with root package name */
        int f2232g = 1;

        /* renamed from: h  reason: collision with root package name */
        MediaServiceConnection f2233h;

        /* renamed from: i  reason: collision with root package name */
        ServiceBinderWrapper f2234i;

        /* renamed from: j  reason: collision with root package name */
        Messenger f2235j;

        /* renamed from: k  reason: collision with root package name */
        private String f2236k;

        /* renamed from: l  reason: collision with root package name */
        private MediaSessionCompat.Token f2237l;

        /* renamed from: m  reason: collision with root package name */
        private Bundle f2238m;

        /* renamed from: n  reason: collision with root package name */
        private Bundle f2239n;

        private class MediaServiceConnection implements ServiceConnection {
            MediaServiceConnection() {
            }

            private void b(Runnable runnable) {
                if (Thread.currentThread() == MediaBrowserImplBase.this.f2230e.getLooper().getThread()) {
                    runnable.run();
                } else {
                    MediaBrowserImplBase.this.f2230e.post(runnable);
                }
            }

            /* access modifiers changed from: package-private */
            public boolean a(String str) {
                int i2;
                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                if (mediaBrowserImplBase.f2233h == this && (i2 = mediaBrowserImplBase.f2232g) != 0 && i2 != 1) {
                    return true;
                }
                int i3 = mediaBrowserImplBase.f2232g;
                if (i3 == 0 || i3 == 1) {
                    return false;
                }
                Log.i(MediaBrowserCompat.f2200b, str + " for " + MediaBrowserImplBase.this.f2227b + " with mServiceConnection=" + MediaBrowserImplBase.this.f2233h + " this=" + this);
                return false;
            }

            public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                b(new Runnable() {
                    public void run() {
                        boolean z = MediaBrowserCompat.f2201c;
                        if (z) {
                            Log.d(MediaBrowserCompat.f2200b, "MediaServiceConnection.onServiceConnected name=" + componentName + " binder=" + iBinder);
                            MediaBrowserImplBase.this.c();
                        }
                        if (MediaServiceConnection.this.a("onServiceConnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.f2234i = new ServiceBinderWrapper(iBinder, mediaBrowserImplBase.f2229d);
                            MediaBrowserImplBase.this.f2235j = new Messenger(MediaBrowserImplBase.this.f2230e);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase2.f2230e.a(mediaBrowserImplBase2.f2235j);
                            MediaBrowserImplBase.this.f2232g = 2;
                            if (z) {
                                try {
                                    Log.d(MediaBrowserCompat.f2200b, "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.c();
                                } catch (RemoteException unused) {
                                    Log.w(MediaBrowserCompat.f2200b, "RemoteException during connect for " + MediaBrowserImplBase.this.f2227b);
                                    if (MediaBrowserCompat.f2201c) {
                                        Log.d(MediaBrowserCompat.f2200b, "ServiceCallbacks.onConnect...");
                                        MediaBrowserImplBase.this.c();
                                        return;
                                    }
                                    return;
                                }
                            }
                            MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase3.f2234i.b(mediaBrowserImplBase3.f2226a, mediaBrowserImplBase3.f2235j);
                        }
                    }
                });
            }

            public void onServiceDisconnected(final ComponentName componentName) {
                b(new Runnable() {
                    public void run() {
                        if (MediaBrowserCompat.f2201c) {
                            Log.d(MediaBrowserCompat.f2200b, "MediaServiceConnection.onServiceDisconnected name=" + componentName + " this=" + this + " mServiceConnection=" + MediaBrowserImplBase.this.f2233h);
                            MediaBrowserImplBase.this.c();
                        }
                        if (MediaServiceConnection.this.a("onServiceDisconnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.f2234i = null;
                            mediaBrowserImplBase.f2235j = null;
                            mediaBrowserImplBase.f2230e.a((Messenger) null);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase2.f2232g = 4;
                            mediaBrowserImplBase2.f2228c.c();
                        }
                    }
                });
            }
        }

        public MediaBrowserImplBase(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (connectionCallback != null) {
                this.f2226a = context;
                this.f2227b = componentName;
                this.f2228c = connectionCallback;
                this.f2229d = bundle == null ? null : new Bundle(bundle);
            } else {
                throw new IllegalArgumentException("connection callback must not be null");
            }
        }

        private static String f(int i2) {
            if (i2 == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i2 == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i2 == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i2 == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (i2 == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            return "UNKNOWN/" + i2;
        }

        private boolean g(Messenger messenger, String str) {
            int i2;
            if (this.f2235j == messenger && (i2 = this.f2232g) != 0 && i2 != 1) {
                return true;
            }
            int i3 = this.f2232g;
            if (i3 == 0 || i3 == 1) {
                return false;
            }
            Log.i(MediaBrowserCompat.f2200b, str + " for " + this.f2227b + " with mCallbacksMessenger=" + this.f2235j + " this=" + this);
            return false;
        }

        public void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (g(messenger, "onConnect")) {
                if (this.f2232g != 2) {
                    Log.w(MediaBrowserCompat.f2200b, "onConnect from service while mState=" + f(this.f2232g) + "... ignoring");
                    return;
                }
                this.f2236k = str;
                this.f2237l = token;
                this.f2238m = bundle;
                this.f2232g = 3;
                if (MediaBrowserCompat.f2201c) {
                    Log.d(MediaBrowserCompat.f2200b, "ServiceCallbacks.onConnect...");
                    c();
                }
                this.f2228c.a();
                try {
                    for (Map.Entry next : this.f2231f.entrySet()) {
                        String str2 = (String) next.getKey();
                        Subscription subscription = (Subscription) next.getValue();
                        List<SubscriptionCallback> b2 = subscription.b();
                        List<Bundle> c2 = subscription.c();
                        for (int i2 = 0; i2 < b2.size(); i2++) {
                            this.f2234i.a(str2, b2.get(i2).f2245b, c2.get(i2), this.f2235j);
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d(MediaBrowserCompat.f2200b, "addSubscription failed with RemoteException.");
                }
            }
        }

        public void b(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            if (g(messenger, "onLoadChildren")) {
                boolean z = MediaBrowserCompat.f2201c;
                if (z) {
                    Log.d(MediaBrowserCompat.f2200b, "onLoadChildren for " + this.f2227b + " id=" + str);
                }
                Subscription subscription = this.f2231f.get(str);
                if (subscription != null) {
                    SubscriptionCallback a2 = subscription.a(bundle);
                    if (a2 != null) {
                        if (bundle == null) {
                            if (list == null) {
                                a2.c(str);
                                return;
                            } else {
                                this.f2239n = bundle2;
                                a2.a(str, list);
                            }
                        } else if (list == null) {
                            a2.d(str, bundle);
                            return;
                        } else {
                            this.f2239n = bundle2;
                            a2.b(str, list, bundle);
                        }
                        this.f2239n = null;
                    }
                } else if (z) {
                    Log.d(MediaBrowserCompat.f2200b, "onLoadChildren for id that isn't subscribed id=" + str);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            Log.d(MediaBrowserCompat.f2200b, "MediaBrowserCompat...");
            Log.d(MediaBrowserCompat.f2200b, "  mServiceComponent=" + this.f2227b);
            Log.d(MediaBrowserCompat.f2200b, "  mCallback=" + this.f2228c);
            Log.d(MediaBrowserCompat.f2200b, "  mRootHints=" + this.f2229d);
            Log.d(MediaBrowserCompat.f2200b, "  mState=" + f(this.f2232g));
            Log.d(MediaBrowserCompat.f2200b, "  mServiceConnection=" + this.f2233h);
            Log.d(MediaBrowserCompat.f2200b, "  mServiceBinderWrapper=" + this.f2234i);
            Log.d(MediaBrowserCompat.f2200b, "  mCallbacksMessenger=" + this.f2235j);
            Log.d(MediaBrowserCompat.f2200b, "  mRootId=" + this.f2236k);
            Log.d(MediaBrowserCompat.f2200b, "  mMediaSessionToken=" + this.f2237l);
        }

        public void d(Messenger messenger) {
            Log.e(MediaBrowserCompat.f2200b, "onConnectFailed for " + this.f2227b);
            if (g(messenger, "onConnectFailed")) {
                if (this.f2232g != 2) {
                    Log.w(MediaBrowserCompat.f2200b, "onConnect from service while mState=" + f(this.f2232g) + "... ignoring");
                    return;
                }
                e();
                this.f2228c.b();
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            MediaServiceConnection mediaServiceConnection = this.f2233h;
            if (mediaServiceConnection != null) {
                this.f2226a.unbindService(mediaServiceConnection);
            }
            this.f2232g = 1;
            this.f2233h = null;
            this.f2234i = null;
            this.f2235j = null;
            this.f2230e.a((Messenger) null);
            this.f2236k = null;
            this.f2237l = null;
        }

        @Nullable
        public Bundle getExtras() {
            if (j()) {
                return this.f2238m;
            }
            throw new IllegalStateException("getExtras() called while not connected (state=" + f(this.f2232g) + ")");
        }

        @NonNull
        public String i() {
            if (j()) {
                return this.f2236k;
            }
            throw new IllegalStateException("getRoot() called while not connected(state=" + f(this.f2232g) + ")");
        }

        public boolean j() {
            return this.f2232g == 3;
        }

        @NonNull
        public MediaSessionCompat.Token k() {
            if (j()) {
                return this.f2237l;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f2232g + ")");
        }

        public void l() {
            this.f2232g = 0;
            this.f2230e.post(new Runnable() {
                public void run() {
                    MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                    Messenger messenger = mediaBrowserImplBase.f2235j;
                    if (messenger != null) {
                        try {
                            mediaBrowserImplBase.f2234i.c(messenger);
                        } catch (RemoteException unused) {
                            Log.w(MediaBrowserCompat.f2200b, "RemoteException during connect for " + MediaBrowserImplBase.this.f2227b);
                        }
                    }
                    MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                    int i2 = mediaBrowserImplBase2.f2232g;
                    mediaBrowserImplBase2.e();
                    if (i2 != 0) {
                        MediaBrowserImplBase.this.f2232g = i2;
                    }
                    if (MediaBrowserCompat.f2201c) {
                        Log.d(MediaBrowserCompat.f2200b, "disconnect...");
                        MediaBrowserImplBase.this.c();
                    }
                }
            });
        }

        public void m(@NonNull final String str, final Bundle bundle, @Nullable final CustomActionCallback customActionCallback) {
            if (j()) {
                try {
                    this.f2234i.h(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.f2230e), this.f2235j);
                } catch (RemoteException e2) {
                    Log.i(MediaBrowserCompat.f2200b, "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e2);
                    if (customActionCallback != null) {
                        this.f2230e.post(new Runnable() {
                            public void run() {
                                customActionCallback.a(str, bundle, (Bundle) null);
                            }
                        });
                    }
                }
            } else {
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
        }

        @NonNull
        public ComponentName n() {
            if (j()) {
                return this.f2227b;
            }
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.f2232g + ")");
        }

        public void o(@NonNull final String str, @NonNull final ItemCallback itemCallback) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            } else if (itemCallback == null) {
                throw new IllegalArgumentException("cb is null");
            } else if (!j()) {
                Log.i(MediaBrowserCompat.f2200b, "Not connected, unable to retrieve the MediaItem.");
                this.f2230e.post(new Runnable() {
                    public void run() {
                        itemCallback.a(str);
                    }
                });
            } else {
                try {
                    this.f2234i.d(str, new ItemReceiver(str, itemCallback, this.f2230e), this.f2235j);
                } catch (RemoteException unused) {
                    Log.i(MediaBrowserCompat.f2200b, "Remote error getting media item: " + str);
                    this.f2230e.post(new Runnable() {
                        public void run() {
                            itemCallback.a(str);
                        }
                    });
                }
            }
        }

        public void p() {
            int i2 = this.f2232g;
            if (i2 == 0 || i2 == 1) {
                this.f2232g = 2;
                this.f2230e.post(new Runnable() {
                    public void run() {
                        boolean z;
                        MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                        if (mediaBrowserImplBase.f2232g != 0) {
                            mediaBrowserImplBase.f2232g = 2;
                            if (MediaBrowserCompat.f2201c && mediaBrowserImplBase.f2233h != null) {
                                throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserImplBase.this.f2233h);
                            } else if (mediaBrowserImplBase.f2234i != null) {
                                throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserImplBase.this.f2234i);
                            } else if (mediaBrowserImplBase.f2235j == null) {
                                Intent intent = new Intent(MediaBrowserServiceCompat.e3);
                                intent.setComponent(MediaBrowserImplBase.this.f2227b);
                                MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                                mediaBrowserImplBase2.f2233h = new MediaServiceConnection();
                                try {
                                    MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                                    z = mediaBrowserImplBase3.f2226a.bindService(intent, mediaBrowserImplBase3.f2233h, 1);
                                } catch (Exception unused) {
                                    Log.e(MediaBrowserCompat.f2200b, "Failed binding to service " + MediaBrowserImplBase.this.f2227b);
                                    z = false;
                                }
                                if (!z) {
                                    MediaBrowserImplBase.this.e();
                                    MediaBrowserImplBase.this.f2228c.b();
                                }
                                if (MediaBrowserCompat.f2201c) {
                                    Log.d(MediaBrowserCompat.f2200b, "connect...");
                                    MediaBrowserImplBase.this.c();
                                }
                            } else {
                                throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserImplBase.this.f2235j);
                            }
                        }
                    }
                });
                return;
            }
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + f(this.f2232g) + ")");
        }

        public void q(@NonNull String str, Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.f2231f.get(str);
            if (subscription == null) {
                subscription = new Subscription();
                this.f2231f.put(str, subscription);
            }
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            subscription.e(bundle2, subscriptionCallback);
            if (j()) {
                try {
                    this.f2234i.a(str, subscriptionCallback.f2245b, bundle2, this.f2235j);
                } catch (RemoteException unused) {
                    Log.d(MediaBrowserCompat.f2200b, "addSubscription failed with RemoteException parentId=" + str);
                }
            }
        }

        public void r(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            Subscription subscription = this.f2231f.get(str);
            if (subscription != null) {
                if (subscriptionCallback == null) {
                    try {
                        if (j()) {
                            this.f2234i.f(str, (IBinder) null, this.f2235j);
                        }
                    } catch (RemoteException unused) {
                        Log.d(MediaBrowserCompat.f2200b, "removeSubscription failed with RemoteException parentId=" + str);
                    }
                } else {
                    List<SubscriptionCallback> b2 = subscription.b();
                    List<Bundle> c2 = subscription.c();
                    for (int size = b2.size() - 1; size >= 0; size--) {
                        if (b2.get(size) == subscriptionCallback) {
                            if (j()) {
                                this.f2234i.f(str, subscriptionCallback.f2245b, this.f2235j);
                            }
                            b2.remove(size);
                            c2.remove(size);
                        }
                    }
                }
                if (subscription.d() || subscriptionCallback == null) {
                    this.f2231f.remove(str);
                }
            }
        }

        public void s(@NonNull final String str, final Bundle bundle, @NonNull final SearchCallback searchCallback) {
            if (j()) {
                try {
                    this.f2234i.g(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.f2230e), this.f2235j);
                } catch (RemoteException e2) {
                    Log.i(MediaBrowserCompat.f2200b, "Remote error searching items with query: " + str, e2);
                    this.f2230e.post(new Runnable() {
                        public void run() {
                            searchCallback.a(str, bundle);
                        }
                    });
                }
            } else {
                throw new IllegalStateException("search() called while not connected (state=" + f(this.f2232g) + ")");
            }
        }

        public Bundle t() {
            return this.f2239n;
        }
    }

    interface MediaBrowserServiceCallbackImpl {
        void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void b(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2);

        void d(Messenger messenger);
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: b */
            public MediaItem[] newArray(int i2) {
                return new MediaItem[i2];
            }
        };
        public static final int Y = 1;
        public static final int Z = 2;
        private final MediaDescriptionCompat X;
        private final int s;

        MediaItem(Parcel parcel) {
            this.s = parcel.readInt();
            this.X = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public static MediaItem a(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
            return new MediaItem(MediaDescriptionCompat.a(Api21Impl.a(mediaItem)), Api21Impl.b(mediaItem));
        }

        public static List<MediaItem> b(List<?> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object a2 : list) {
                arrayList.add(a(a2));
            }
            return arrayList;
        }

        @NonNull
        public MediaDescriptionCompat c() {
            return this.X;
        }

        public int d() {
            return this.s;
        }

        public int describeContents() {
            return 0;
        }

        @Nullable
        public String g() {
            return this.X.k();
        }

        public boolean j() {
            return (this.s & 1) != 0;
        }

        public boolean k() {
            return (this.s & 2) != 0;
        }

        @NonNull
        public String toString() {
            return "MediaItem{" + "mFlags=" + this.s + ", mDescription=" + this.X + ASCIIPropertyListParser.f18653k;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.s);
            this.X.writeToParcel(parcel, i2);
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (!TextUtils.isEmpty(mediaDescriptionCompat.k())) {
                this.s = i2;
                this.X = mediaDescriptionCompat;
            } else {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
        }
    }

    public static abstract class SearchCallback {
        public void a(@NonNull String str, Bundle bundle) {
        }

        public void b(@NonNull String str, Bundle bundle, @NonNull List<MediaItem> list) {
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {
        private final Bundle X2;
        private final SearchCallback Y2;
        private final String Z;

        SearchResultReceiver(String str, Bundle bundle, SearchCallback searchCallback, Handler handler) {
            super(handler);
            this.Z = str;
            this.X2 = bundle;
            this.Y2 = searchCallback;
        }

        /* access modifiers changed from: protected */
        public void a(int i2, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.G(bundle);
            }
            if (i2 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.g3)) {
                this.Y2.a(this.Z, this.X2);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.g3);
            if (parcelableArray != null) {
                ArrayList arrayList = new ArrayList(parcelableArray.length);
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
                this.Y2.b(this.Z, this.X2, arrayList);
                return;
            }
            this.Y2.a(this.Z, this.X2);
        }
    }

    private static class ServiceBinderWrapper {

        /* renamed from: a  reason: collision with root package name */
        private Messenger f2240a;

        /* renamed from: b  reason: collision with root package name */
        private Bundle f2241b;

        public ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
            this.f2240a = new Messenger(iBinder);
            this.f2241b = bundle;
        }

        private void i(int i2, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f2240a.send(obtain);
        }

        /* access modifiers changed from: package-private */
        public void a(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.f8902d, str);
            BundleCompat.b(bundle2, MediaBrowserProtocol.f8899a, iBinder);
            bundle2.putBundle(MediaBrowserProtocol.f8905g, bundle);
            i(3, bundle2, messenger);
        }

        /* access modifiers changed from: package-private */
        public void b(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.f8907i, context.getPackageName());
            bundle.putInt(MediaBrowserProtocol.f8901c, Process.myPid());
            bundle.putBundle(MediaBrowserProtocol.f8909k, this.f2241b);
            i(1, bundle, messenger);
        }

        /* access modifiers changed from: package-private */
        public void c(Messenger messenger) throws RemoteException {
            i(2, (Bundle) null, messenger);
        }

        /* access modifiers changed from: package-private */
        public void d(String str, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.f8902d, str);
            bundle.putParcelable(MediaBrowserProtocol.f8908j, resultReceiver);
            i(5, bundle, messenger);
        }

        /* access modifiers changed from: package-private */
        public void e(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.f8907i, context.getPackageName());
            bundle.putInt(MediaBrowserProtocol.f8901c, Process.myPid());
            bundle.putBundle(MediaBrowserProtocol.f8909k, this.f2241b);
            i(6, bundle, messenger);
        }

        /* access modifiers changed from: package-private */
        public void f(String str, IBinder iBinder, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.f8902d, str);
            BundleCompat.b(bundle, MediaBrowserProtocol.f8899a, iBinder);
            i(4, bundle, messenger);
        }

        /* access modifiers changed from: package-private */
        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.f8911m, str);
            bundle2.putBundle(MediaBrowserProtocol.f8910l, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.f8908j, resultReceiver);
            i(8, bundle2, messenger);
        }

        /* access modifiers changed from: package-private */
        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.f8912n, str);
            bundle2.putBundle(MediaBrowserProtocol.o, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.f8908j, resultReceiver);
            i(9, bundle2, messenger);
        }

        /* access modifiers changed from: package-private */
        public void j(Messenger messenger) throws RemoteException {
            i(7, (Bundle) null, messenger);
        }
    }

    private static class Subscription {

        /* renamed from: a  reason: collision with root package name */
        private final List<SubscriptionCallback> f2242a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<Bundle> f2243b = new ArrayList();

        public SubscriptionCallback a(Bundle bundle) {
            for (int i2 = 0; i2 < this.f2243b.size(); i2++) {
                if (MediaBrowserCompatUtils.a(this.f2243b.get(i2), bundle)) {
                    return this.f2242a.get(i2);
                }
            }
            return null;
        }

        public List<SubscriptionCallback> b() {
            return this.f2242a;
        }

        public List<Bundle> c() {
            return this.f2243b;
        }

        public boolean d() {
            return this.f2242a.isEmpty();
        }

        public void e(Bundle bundle, SubscriptionCallback subscriptionCallback) {
            for (int i2 = 0; i2 < this.f2243b.size(); i2++) {
                if (MediaBrowserCompatUtils.a(this.f2243b.get(i2), bundle)) {
                    this.f2242a.set(i2, subscriptionCallback);
                    return;
                }
            }
            this.f2242a.add(subscriptionCallback);
            this.f2243b.add(bundle);
        }
    }

    public static abstract class SubscriptionCallback {

        /* renamed from: a  reason: collision with root package name */
        final MediaBrowser.SubscriptionCallback f2244a;

        /* renamed from: b  reason: collision with root package name */
        final IBinder f2245b = new Binder();

        /* renamed from: c  reason: collision with root package name */
        WeakReference<Subscription> f2246c;

        @RequiresApi(21)
        private class SubscriptionCallbackApi21 extends MediaBrowser.SubscriptionCallback {
            SubscriptionCallbackApi21() {
            }

            /* access modifiers changed from: package-private */
            public List<MediaItem> a(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i2 = bundle.getInt(MediaBrowserCompat.f2202d, -1);
                int i3 = bundle.getInt(MediaBrowserCompat.f2203e, -1);
                if (i2 == -1 && i3 == -1) {
                    return list;
                }
                int i4 = i3 * i2;
                int i5 = i4 + i3;
                if (i2 < 0 || i3 < 1 || i4 >= list.size()) {
                    return Collections.emptyList();
                }
                if (i5 > list.size()) {
                    i5 = list.size();
                }
                return list.subList(i4, i5);
            }

            public void onChildrenLoaded(@NonNull String str, List<MediaBrowser.MediaItem> list) {
                WeakReference<Subscription> weakReference = SubscriptionCallback.this.f2246c;
                Subscription subscription = weakReference == null ? null : weakReference.get();
                if (subscription == null) {
                    SubscriptionCallback.this.a(str, MediaItem.b(list));
                    return;
                }
                List<MediaItem> b2 = MediaItem.b(list);
                List<SubscriptionCallback> b3 = subscription.b();
                List<Bundle> c2 = subscription.c();
                for (int i2 = 0; i2 < b3.size(); i2++) {
                    Bundle bundle = c2.get(i2);
                    if (bundle == null) {
                        SubscriptionCallback.this.a(str, b2);
                    } else {
                        SubscriptionCallback.this.b(str, a(b2, bundle), bundle);
                    }
                }
            }

            public void onError(@NonNull String str) {
                SubscriptionCallback.this.c(str);
            }
        }

        @RequiresApi(26)
        private class SubscriptionCallbackApi26 extends SubscriptionCallbackApi21 {
            SubscriptionCallbackApi26() {
                super();
            }

            public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowser.MediaItem> list, @NonNull Bundle bundle) {
                MediaSessionCompat.b(bundle);
                SubscriptionCallback.this.b(str, MediaItem.b(list), bundle);
            }

            public void onError(@NonNull String str, @NonNull Bundle bundle) {
                MediaSessionCompat.b(bundle);
                SubscriptionCallback.this.d(str, bundle);
            }
        }

        public SubscriptionCallback() {
            this.f2244a = Build.VERSION.SDK_INT >= 26 ? new SubscriptionCallbackApi26() : new SubscriptionCallbackApi21();
        }

        public void a(@NonNull String str, @NonNull List<MediaItem> list) {
        }

        public void b(@NonNull String str, @NonNull List<MediaItem> list, @NonNull Bundle bundle) {
        }

        public void c(@NonNull String str) {
        }

        public void d(@NonNull String str, @NonNull Bundle bundle) {
        }

        /* access modifiers changed from: package-private */
        public void e(Subscription subscription) {
            this.f2246c = new WeakReference<>(subscription);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        int i2 = Build.VERSION.SDK_INT;
        this.f2208a = i2 >= 26 ? new MediaBrowserImplApi26(context, componentName, connectionCallback, bundle) : i2 >= 23 ? new MediaBrowserImplApi23(context, componentName, connectionCallback, bundle) : new MediaBrowserImplApi21(context, componentName, connectionCallback, bundle);
    }

    public void a() {
        Log.d(f2200b, "Connecting to a MediaBrowserService.");
        this.f2208a.p();
    }

    public void b() {
        this.f2208a.l();
    }

    @Nullable
    public Bundle c() {
        return this.f2208a.getExtras();
    }

    public void d(@NonNull String str, @NonNull ItemCallback itemCallback) {
        this.f2208a.o(str, itemCallback);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bundle e() {
        return this.f2208a.t();
    }

    @NonNull
    public String f() {
        return this.f2208a.i();
    }

    @NonNull
    public ComponentName g() {
        return this.f2208a.n();
    }

    @NonNull
    public MediaSessionCompat.Token h() {
        return this.f2208a.k();
    }

    public boolean i() {
        return this.f2208a.j();
    }

    public void j(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("query cannot be empty");
        } else if (searchCallback != null) {
            this.f2208a.s(str, bundle, searchCallback);
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    public void k(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.f2208a.m(str, bundle, customActionCallback);
            return;
        }
        throw new IllegalArgumentException("action cannot be empty");
    }

    public void l(@NonNull String str, @NonNull Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        } else if (bundle != null) {
            this.f2208a.q(str, bundle, subscriptionCallback);
        } else {
            throw new IllegalArgumentException("options are null");
        }
    }

    public void m(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (subscriptionCallback != null) {
            this.f2208a.q(str, (Bundle) null, subscriptionCallback);
        } else {
            throw new IllegalArgumentException("callback is null");
        }
    }

    public void n(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f2208a.r(str, (SubscriptionCallback) null);
            return;
        }
        throw new IllegalArgumentException("parentId is empty");
    }

    public void o(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (subscriptionCallback != null) {
            this.f2208a.r(str, subscriptionCallback);
        } else {
            throw new IllegalArgumentException("callback is null");
        }
    }
}
