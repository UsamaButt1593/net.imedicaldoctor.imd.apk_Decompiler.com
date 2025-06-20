package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.media.MediaSessionManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    static final String b3 = "MBServiceCompat";
    static final boolean c3 = Log.isLoggable(b3, 3);
    private static final float d3 = 1.0E-5f;
    public static final String e3 = "android.media.browse.MediaBrowserService";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f3 = "media_item";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String g3 = "search_results";
    static final int h3 = 1;
    static final int i3 = 2;
    static final int j3 = 4;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int k3 = -1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int l3 = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int m3 = 1;
    private final ServiceBinderImpl X = new ServiceBinderImpl();
    final ArrayMap<IBinder, ConnectionRecord> X2 = new ArrayMap<>();
    final ConnectionRecord Y = new ConnectionRecord(MediaSessionManager.RemoteUserInfo.f8969b, -1, -1, (Bundle) null, (ServiceCallbacks) null);
    ConnectionRecord Y2;
    final ArrayList<ConnectionRecord> Z = new ArrayList<>();
    final ServiceHandler Z2 = new ServiceHandler(this);
    MediaSessionCompat.Token a3;
    private MediaBrowserServiceImpl s;

    public static final class BrowserRoot {

        /* renamed from: c  reason: collision with root package name */
        public static final String f8924c = "android.service.media.extra.RECENT";

        /* renamed from: d  reason: collision with root package name */
        public static final String f8925d = "android.service.media.extra.OFFLINE";

        /* renamed from: e  reason: collision with root package name */
        public static final String f8926e = "android.service.media.extra.SUGGESTED";
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public static final String f8927f = "android.service.media.extra.SUGGESTION_KEYWORDS";
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f8928a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f8929b;

        public BrowserRoot(@NonNull String str, @Nullable Bundle bundle) {
            if (str != null) {
                this.f8928a = str;
                this.f8929b = bundle;
                return;
            }
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
        }

        public Bundle c() {
            return this.f8929b;
        }

        public String d() {
            return this.f8928a;
        }
    }

    private class ConnectionRecord implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        public final String f8930a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8931b;

        /* renamed from: c  reason: collision with root package name */
        public final int f8932c;

        /* renamed from: d  reason: collision with root package name */
        public final MediaSessionManager.RemoteUserInfo f8933d;

        /* renamed from: e  reason: collision with root package name */
        public final Bundle f8934e;

        /* renamed from: f  reason: collision with root package name */
        public final ServiceCallbacks f8935f;

        /* renamed from: g  reason: collision with root package name */
        public final HashMap<String, List<Pair<IBinder, Bundle>>> f8936g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        public BrowserRoot f8937h;

        ConnectionRecord(String str, int i2, int i3, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            this.f8930a = str;
            this.f8931b = i2;
            this.f8932c = i3;
            this.f8933d = new MediaSessionManager.RemoteUserInfo(str, i2, i3);
            this.f8934e = bundle;
            this.f8935f = serviceCallbacks;
        }

        public void binderDied() {
            MediaBrowserServiceCompat.this.Z2.post(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = ConnectionRecord.this;
                    MediaBrowserServiceCompat.this.X2.remove(connectionRecord.f8935f.asBinder());
                }
            });
        }
    }

    interface MediaBrowserServiceImpl {
        Bundle a();

        void b();

        void c(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle);

        MediaSessionManager.RemoteUserInfo d();

        IBinder e(Intent intent);

        void f(String str, Bundle bundle);

        void g(MediaSessionCompat.Token token);
    }

    @RequiresApi(21)
    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl {

        /* renamed from: a  reason: collision with root package name */
        final List<Bundle> f8939a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        MediaBrowserService f8940b;

        /* renamed from: c  reason: collision with root package name */
        Messenger f8941c;

        @RequiresApi(21)
        class MediaBrowserServiceApi21 extends MediaBrowserService {
            MediaBrowserServiceApi21(Context context) {
                attachBaseContext(context);
            }

            public MediaBrowserService.BrowserRoot onGetRoot(String str, int i2, Bundle bundle) {
                MediaSessionCompat.b(bundle);
                BrowserRoot l2 = MediaBrowserServiceImplApi21.this.l(str, i2, bundle == null ? null : new Bundle(bundle));
                if (l2 == null) {
                    return null;
                }
                return new MediaBrowserService.BrowserRoot(l2.f8928a, l2.f8929b);
            }

            public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
                MediaBrowserServiceImplApi21.this.m(str, new ResultWrapper(result));
            }
        }

        MediaBrowserServiceImplApi21() {
        }

        public Bundle a() {
            if (this.f8941c == null) {
                return null;
            }
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.Y2;
            if (connectionRecord == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            } else if (connectionRecord.f8934e == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.Y2.f8934e);
            }
        }

        public void b() {
            MediaBrowserServiceApi21 mediaBrowserServiceApi21 = new MediaBrowserServiceApi21(MediaBrowserServiceCompat.this);
            this.f8940b = mediaBrowserServiceApi21;
            mediaBrowserServiceApi21.onCreate();
        }

        public void c(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            h(remoteUserInfo, str, bundle);
        }

        public MediaSessionManager.RemoteUserInfo d() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.Y2;
            if (connectionRecord != null) {
                return connectionRecord.f8933d;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        public IBinder e(Intent intent) {
            return this.f8940b.onBind(intent);
        }

        public void f(String str, Bundle bundle) {
            k(str, bundle);
            i(str, bundle);
        }

        public void g(final MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.Z2.a(new Runnable() {
                public void run() {
                    MediaBrowserServiceImplApi21.this.n(token);
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void h(final MediaSessionManager.RemoteUserInfo remoteUserInfo, final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.Z2.post(new Runnable() {
                public void run() {
                    for (int i2 = 0; i2 < MediaBrowserServiceCompat.this.X2.size(); i2++) {
                        ConnectionRecord m2 = MediaBrowserServiceCompat.this.X2.m(i2);
                        if (m2.f8933d.equals(remoteUserInfo)) {
                            MediaBrowserServiceImplApi21.this.j(m2, str, bundle);
                        }
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void i(final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.Z2.post(new Runnable() {
                public void run() {
                    for (IBinder iBinder : MediaBrowserServiceCompat.this.X2.keySet()) {
                        ArrayMap<IBinder, ConnectionRecord> arrayMap = MediaBrowserServiceCompat.this.X2;
                        MediaBrowserServiceImplApi21.this.j(arrayMap.get(iBinder), str, bundle);
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void j(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair> list = connectionRecord.f8936g.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    if (MediaBrowserCompatUtils.b(bundle, (Bundle) pair.f6297b)) {
                        MediaBrowserServiceCompat.this.u(str, connectionRecord, (Bundle) pair.f6297b, bundle);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void k(String str, Bundle bundle) {
            this.f8940b.notifyChildrenChanged(str);
        }

        public BrowserRoot l(String str, int i2, Bundle bundle) {
            int i3;
            Bundle bundle2;
            if (bundle == null || bundle.getInt(MediaBrowserProtocol.p, 0) == 0) {
                bundle2 = null;
                i3 = -1;
            } else {
                bundle.remove(MediaBrowserProtocol.p);
                this.f8941c = new Messenger(MediaBrowserServiceCompat.this.Z2);
                bundle2 = new Bundle();
                bundle2.putInt(MediaBrowserProtocol.r, 2);
                BundleCompat.b(bundle2, MediaBrowserProtocol.s, this.f8941c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.a3;
                if (token != null) {
                    IMediaSession d2 = token.d();
                    BundleCompat.b(bundle2, MediaBrowserProtocol.t, d2 == null ? null : d2.asBinder());
                } else {
                    this.f8939a.add(bundle2);
                }
                int i4 = bundle.getInt(MediaBrowserProtocol.q, -1);
                bundle.remove(MediaBrowserProtocol.q);
                i3 = i4;
            }
            ConnectionRecord connectionRecord = new ConnectionRecord(str, i3, i2, bundle, (ServiceCallbacks) null);
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.Y2 = connectionRecord;
            BrowserRoot m2 = mediaBrowserServiceCompat.m(str, i2, bundle);
            MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat2.Y2 = null;
            if (m2 == null) {
                return null;
            }
            if (this.f8941c != null) {
                mediaBrowserServiceCompat2.Z.add(connectionRecord);
            }
            if (bundle2 == null) {
                bundle2 = m2.c();
            } else if (m2.c() != null) {
                bundle2.putAll(m2.c());
            }
            return new BrowserRoot(m2.d(), bundle2);
        }

        public void m(String str, final ResultWrapper<List<Parcel>> resultWrapper) {
            AnonymousClass2 r0 = new Result<List<MediaBrowserCompat.MediaItem>>(str) {
                public void b() {
                    resultWrapper.a();
                }

                /* access modifiers changed from: package-private */
                /* renamed from: l */
                public void g(@Nullable List<MediaBrowserCompat.MediaItem> list) {
                    List list2;
                    if (list == null) {
                        list2 = Build.VERSION.SDK_INT >= 24 ? null : Collections.emptyList();
                    } else {
                        ArrayList arrayList = new ArrayList(list.size());
                        for (MediaBrowserCompat.MediaItem writeToParcel : list) {
                            Parcel obtain = Parcel.obtain();
                            writeToParcel.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                        list2 = arrayList;
                    }
                    resultWrapper.c(list2);
                }
            };
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.Y2 = mediaBrowserServiceCompat.Y;
            mediaBrowserServiceCompat.n(str, r0);
            MediaBrowserServiceCompat.this.Y2 = null;
        }

        /* access modifiers changed from: package-private */
        public void n(MediaSessionCompat.Token token) {
            if (!this.f8939a.isEmpty()) {
                IMediaSession d2 = token.d();
                if (d2 != null) {
                    for (Bundle b2 : this.f8939a) {
                        BundleCompat.b(b2, MediaBrowserProtocol.t, d2.asBinder());
                    }
                }
                this.f8939a.clear();
            }
            this.f8940b.setSessionToken((MediaSession.Token) token.j());
        }
    }

    @RequiresApi(23)
    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 {

        class MediaBrowserServiceApi23 extends MediaBrowserServiceImplApi21.MediaBrowserServiceApi21 {
            MediaBrowserServiceApi23(Context context) {
                super(context);
            }

            public void onLoadItem(String str, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
                MediaBrowserServiceImplApi23.this.o(str, new ResultWrapper(result));
            }
        }

        MediaBrowserServiceImplApi23() {
            super();
        }

        public void b() {
            MediaBrowserServiceApi23 mediaBrowserServiceApi23 = new MediaBrowserServiceApi23(MediaBrowserServiceCompat.this);
            this.f8940b = mediaBrowserServiceApi23;
            mediaBrowserServiceApi23.onCreate();
        }

        public void o(String str, final ResultWrapper<Parcel> resultWrapper) {
            AnonymousClass1 r0 = new Result<MediaBrowserCompat.MediaItem>(str) {
                public void b() {
                    resultWrapper.a();
                }

                /* access modifiers changed from: package-private */
                /* renamed from: l */
                public void g(@Nullable MediaBrowserCompat.MediaItem mediaItem) {
                    Parcel obtain;
                    ResultWrapper resultWrapper;
                    if (mediaItem == null) {
                        resultWrapper = resultWrapper;
                        obtain = null;
                    } else {
                        obtain = Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        resultWrapper = resultWrapper;
                    }
                    resultWrapper.c(obtain);
                }
            };
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.Y2 = mediaBrowserServiceCompat.Y;
            mediaBrowserServiceCompat.p(str, r0);
            MediaBrowserServiceCompat.this.Y2 = null;
        }
    }

    @RequiresApi(26)
    class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 {

        class MediaBrowserServiceApi26 extends MediaBrowserServiceImplApi23.MediaBrowserServiceApi23 {
            MediaBrowserServiceApi26(Context context) {
                super(context);
            }

            public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
                MediaSessionCompat.b(bundle);
                MediaBrowserServiceImplApi26 mediaBrowserServiceImplApi26 = MediaBrowserServiceImplApi26.this;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.Y2 = mediaBrowserServiceCompat.Y;
                mediaBrowserServiceImplApi26.p(str, new ResultWrapper(result), bundle);
                MediaBrowserServiceCompat.this.Y2 = null;
            }
        }

        MediaBrowserServiceImplApi26() {
            super();
        }

        public Bundle a() {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            ConnectionRecord connectionRecord = mediaBrowserServiceCompat.Y2;
            if (connectionRecord == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            } else if (connectionRecord == mediaBrowserServiceCompat.Y) {
                return this.f8940b.getBrowserRootHints();
            } else {
                if (connectionRecord.f8934e == null) {
                    return null;
                }
                return new Bundle(MediaBrowserServiceCompat.this.Y2.f8934e);
            }
        }

        public void b() {
            MediaBrowserServiceApi26 mediaBrowserServiceApi26 = new MediaBrowserServiceApi26(MediaBrowserServiceCompat.this);
            this.f8940b = mediaBrowserServiceApi26;
            mediaBrowserServiceApi26.onCreate();
        }

        /* access modifiers changed from: package-private */
        public void k(String str, Bundle bundle) {
            if (bundle != null) {
                this.f8940b.notifyChildrenChanged(str, bundle);
            } else {
                super.k(str, bundle);
            }
        }

        public void p(String str, final ResultWrapper<List<Parcel>> resultWrapper, final Bundle bundle) {
            AnonymousClass1 r0 = new Result<List<MediaBrowserCompat.MediaItem>>(str) {
                public void b() {
                    resultWrapper.a();
                }

                /* access modifiers changed from: package-private */
                /* renamed from: l */
                public void g(@Nullable List<MediaBrowserCompat.MediaItem> list) {
                    ArrayList arrayList;
                    ResultWrapper resultWrapper;
                    if (list == null) {
                        resultWrapper = resultWrapper;
                        arrayList = null;
                    } else {
                        if ((c() & 1) != 0) {
                            list = MediaBrowserServiceCompat.this.b(list, bundle);
                        }
                        arrayList = new ArrayList(list.size());
                        for (MediaBrowserCompat.MediaItem writeToParcel : list) {
                            Parcel obtain = Parcel.obtain();
                            writeToParcel.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                        resultWrapper = resultWrapper;
                    }
                    resultWrapper.c(arrayList);
                }
            };
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.Y2 = mediaBrowserServiceCompat.Y;
            mediaBrowserServiceCompat.o(str, r0, bundle);
            MediaBrowserServiceCompat.this.Y2 = null;
        }
    }

    @RequiresApi(28)
    class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        MediaBrowserServiceImplApi28() {
            super();
        }

        public MediaSessionManager.RemoteUserInfo d() {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            ConnectionRecord connectionRecord = mediaBrowserServiceCompat.Y2;
            if (connectionRecord != null) {
                return connectionRecord == mediaBrowserServiceCompat.Y ? new MediaSessionManager.RemoteUserInfo(this.f8940b.getCurrentBrowserInfo()) : connectionRecord.f8933d;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }
    }

    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {

        /* renamed from: a  reason: collision with root package name */
        private Messenger f8953a;

        MediaBrowserServiceImplBase() {
        }

        public Bundle a() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.Y2;
            if (connectionRecord == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            } else if (connectionRecord.f8934e == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.Y2.f8934e);
            }
        }

        public void b() {
            this.f8953a = new Messenger(MediaBrowserServiceCompat.this.Z2);
        }

        public void c(@NonNull final MediaSessionManager.RemoteUserInfo remoteUserInfo, @NonNull final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.Z2.post(new Runnable() {
                public void run() {
                    for (int i2 = 0; i2 < MediaBrowserServiceCompat.this.X2.size(); i2++) {
                        ConnectionRecord m2 = MediaBrowserServiceCompat.this.X2.m(i2);
                        if (m2.f8933d.equals(remoteUserInfo)) {
                            MediaBrowserServiceImplBase.this.h(m2, str, bundle);
                            return;
                        }
                    }
                }
            });
        }

        public MediaSessionManager.RemoteUserInfo d() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.Y2;
            if (connectionRecord != null) {
                return connectionRecord.f8933d;
            }
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        public IBinder e(Intent intent) {
            if (MediaBrowserServiceCompat.e3.equals(intent.getAction())) {
                return this.f8953a.getBinder();
            }
            return null;
        }

        public void f(@NonNull final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.Z2.post(new Runnable() {
                public void run() {
                    for (IBinder iBinder : MediaBrowserServiceCompat.this.X2.keySet()) {
                        ArrayMap<IBinder, ConnectionRecord> arrayMap = MediaBrowserServiceCompat.this.X2;
                        MediaBrowserServiceImplBase.this.h(arrayMap.get(iBinder), str, bundle);
                    }
                }
            });
        }

        public void g(final MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.Z2.post(new Runnable() {
                public void run() {
                    Iterator<ConnectionRecord> it2 = MediaBrowserServiceCompat.this.X2.values().iterator();
                    while (it2.hasNext()) {
                        ConnectionRecord next = it2.next();
                        try {
                            next.f8935f.c(next.f8937h.d(), token, next.f8937h.c());
                        } catch (RemoteException unused) {
                            Log.w(MediaBrowserServiceCompat.b3, "Connection for " + next.f8930a + " is no longer valid.");
                            it2.remove();
                        }
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void h(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair> list = connectionRecord.f8936g.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    if (MediaBrowserCompatUtils.b(bundle, (Bundle) pair.f6297b)) {
                        MediaBrowserServiceCompat.this.u(str, connectionRecord, (Bundle) pair.f6297b, bundle);
                    }
                }
            }
        }
    }

    public static class Result<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f8955a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f8956b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8957c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8958d;

        /* renamed from: e  reason: collision with root package name */
        private int f8959e;

        Result(Object obj) {
            this.f8955a = obj;
        }

        private void a(@Nullable Bundle bundle) {
            if (bundle != null && bundle.containsKey(MediaBrowserCompat.f2205g)) {
                float f2 = bundle.getFloat(MediaBrowserCompat.f2205g);
                if (f2 < -1.0E-5f || f2 > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0]");
                }
            }
        }

        public void b() {
            if (this.f8956b) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.f8955a);
            } else if (this.f8957c) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.f8955a);
            } else if (!this.f8958d) {
                this.f8956b = true;
            } else {
                throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.f8955a);
            }
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return this.f8959e;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return this.f8956b || this.f8957c || this.f8958d;
        }

        /* access modifiers changed from: package-private */
        public void e(@Nullable Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f8955a);
        }

        /* access modifiers changed from: package-private */
        public void f(@Nullable Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.f8955a);
        }

        /* access modifiers changed from: package-private */
        public void g(@Nullable T t) {
        }

        public void h(@Nullable Bundle bundle) {
            if (this.f8957c || this.f8958d) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f8955a);
            }
            this.f8958d = true;
            e(bundle);
        }

        public void i(@Nullable Bundle bundle) {
            if (this.f8957c || this.f8958d) {
                throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.f8955a);
            }
            a(bundle);
            f(bundle);
        }

        public void j(@Nullable T t) {
            if (this.f8957c || this.f8958d) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f8955a);
            }
            this.f8957c = true;
            g(t);
        }

        /* access modifiers changed from: package-private */
        public void k(int i2) {
            this.f8959e = i2;
        }
    }

    @RequiresApi(21)
    static class ResultWrapper<T> {

        /* renamed from: a  reason: collision with root package name */
        MediaBrowserService.Result f8960a;

        ResultWrapper(MediaBrowserService.Result result) {
            this.f8960a = result;
        }

        public void a() {
            this.f8960a.detach();
        }

        /* access modifiers changed from: package-private */
        public List<MediaBrowser.MediaItem> b(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Parcel next : list) {
                next.setDataPosition(0);
                arrayList.add((MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(next));
                next.recycle();
            }
            return arrayList;
        }

        public void c(T t) {
            if (t instanceof List) {
                this.f8960a.sendResult(b((List) t));
            } else if (t instanceof Parcel) {
                Parcel parcel = (Parcel) t;
                parcel.setDataPosition(0);
                this.f8960a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            } else {
                this.f8960a.sendResult((Object) null);
            }
        }
    }

    private class ServiceBinderImpl {
        ServiceBinderImpl() {
        }

        public void a(String str, IBinder iBinder, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
            final String str2 = str;
            final IBinder iBinder2 = iBinder;
            final Bundle bundle2 = bundle;
            MediaBrowserServiceCompat.this.Z2.a(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.X2.get(serviceCallbacks2.asBinder());
                    if (connectionRecord == null) {
                        Log.w(MediaBrowserServiceCompat.b3, "addSubscription for callback that isn't registered id=" + str2);
                        return;
                    }
                    MediaBrowserServiceCompat.this.a(str2, connectionRecord, iBinder2, bundle2);
                }
            });
        }

        public void b(String str, int i2, int i3, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            if (MediaBrowserServiceCompat.this.h(str, i3)) {
                final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                final String str2 = str;
                final int i4 = i2;
                final int i5 = i3;
                final Bundle bundle2 = bundle;
                MediaBrowserServiceCompat.this.Z2.a(new Runnable() {
                    public void run() {
                        IBinder asBinder = serviceCallbacks2.asBinder();
                        MediaBrowserServiceCompat.this.X2.remove(asBinder);
                        ConnectionRecord connectionRecord = new ConnectionRecord(str2, i4, i5, bundle2, serviceCallbacks2);
                        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                        mediaBrowserServiceCompat.Y2 = connectionRecord;
                        BrowserRoot m2 = mediaBrowserServiceCompat.m(str2, i5, bundle2);
                        connectionRecord.f8937h = m2;
                        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                        mediaBrowserServiceCompat2.Y2 = null;
                        if (m2 == null) {
                            Log.i(MediaBrowserServiceCompat.b3, "No root for client " + str2 + " from service " + getClass().getName());
                            try {
                                serviceCallbacks2.b();
                            } catch (RemoteException unused) {
                                Log.w(MediaBrowserServiceCompat.b3, "Calling onConnectFailed() failed. Ignoring. pkg=" + str2);
                            }
                        } else {
                            try {
                                mediaBrowserServiceCompat2.X2.put(asBinder, connectionRecord);
                                asBinder.linkToDeath(connectionRecord, 0);
                                if (MediaBrowserServiceCompat.this.a3 != null) {
                                    serviceCallbacks2.c(connectionRecord.f8937h.d(), MediaBrowserServiceCompat.this.a3, connectionRecord.f8937h.c());
                                }
                            } catch (RemoteException unused2) {
                                Log.w(MediaBrowserServiceCompat.b3, "Calling onConnect() failed. Dropping client. pkg=" + str2);
                                MediaBrowserServiceCompat.this.X2.remove(asBinder);
                            }
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i3 + " package=" + str);
        }

        public void c(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.Z2.a(new Runnable() {
                public void run() {
                    ConnectionRecord remove = MediaBrowserServiceCompat.this.X2.remove(serviceCallbacks.asBinder());
                    if (remove != null) {
                        remove.f8935f.asBinder().unlinkToDeath(remove, 0);
                    }
                }
            });
        }

        public void d(final String str, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.Z2.a(new Runnable() {
                    public void run() {
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.X2.get(serviceCallbacks.asBinder());
                        if (connectionRecord == null) {
                            Log.w(MediaBrowserServiceCompat.b3, "getMediaItem for callback that isn't registered id=" + str);
                            return;
                        }
                        MediaBrowserServiceCompat.this.v(str, connectionRecord, resultReceiver);
                    }
                });
            }
        }

        public void e(ServiceCallbacks serviceCallbacks, String str, int i2, int i3, Bundle bundle) {
            final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
            final int i4 = i3;
            final String str2 = str;
            final int i5 = i2;
            final Bundle bundle2 = bundle;
            MediaBrowserServiceCompat.this.Z2.a(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord;
                    IBinder asBinder = serviceCallbacks2.asBinder();
                    MediaBrowserServiceCompat.this.X2.remove(asBinder);
                    Iterator<ConnectionRecord> it2 = MediaBrowserServiceCompat.this.Z.iterator();
                    while (true) {
                        connectionRecord = null;
                        if (!it2.hasNext()) {
                            break;
                        }
                        ConnectionRecord next = it2.next();
                        if (next.f8932c == i4) {
                            if (TextUtils.isEmpty(str2) || i5 <= 0) {
                                connectionRecord = new ConnectionRecord(next.f8930a, next.f8931b, next.f8932c, bundle2, serviceCallbacks2);
                            }
                            it2.remove();
                        }
                    }
                    if (connectionRecord == null) {
                        connectionRecord = new ConnectionRecord(str2, i5, i4, bundle2, serviceCallbacks2);
                    }
                    MediaBrowserServiceCompat.this.X2.put(asBinder, connectionRecord);
                    try {
                        asBinder.linkToDeath(connectionRecord, 0);
                    } catch (RemoteException unused) {
                        Log.w(MediaBrowserServiceCompat.b3, "IBinder is already dead.");
                    }
                }
            });
        }

        public void f(final String str, final IBinder iBinder, final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.Z2.a(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.X2.get(serviceCallbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w(MediaBrowserServiceCompat.b3, "removeSubscription for callback that isn't registered id=" + str);
                    } else if (!MediaBrowserServiceCompat.this.x(str, connectionRecord, iBinder)) {
                        Log.w(MediaBrowserServiceCompat.b3, "removeSubscription called for " + str + " which is not subscribed");
                    }
                }
            });
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                final ResultReceiver resultReceiver2 = resultReceiver;
                MediaBrowserServiceCompat.this.Z2.a(new Runnable() {
                    public void run() {
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.X2.get(serviceCallbacks2.asBinder());
                        if (connectionRecord == null) {
                            Log.w(MediaBrowserServiceCompat.b3, "search for callback that isn't registered query=" + str2);
                            return;
                        }
                        MediaBrowserServiceCompat.this.w(str2, bundle2, connectionRecord, resultReceiver2);
                    }
                });
            }
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                final ResultReceiver resultReceiver2 = resultReceiver;
                MediaBrowserServiceCompat.this.Z2.a(new Runnable() {
                    public void run() {
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.X2.get(serviceCallbacks2.asBinder());
                        if (connectionRecord == null) {
                            Log.w(MediaBrowserServiceCompat.b3, "sendCustomAction for callback that isn't registered action=" + str2 + ", extras=" + bundle2);
                            return;
                        }
                        MediaBrowserServiceCompat.this.t(str2, bundle2, connectionRecord, resultReceiver2);
                    }
                });
            }
        }

        public void i(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.Z2.a(new Runnable() {
                public void run() {
                    IBinder asBinder = serviceCallbacks.asBinder();
                    ConnectionRecord remove = MediaBrowserServiceCompat.this.X2.remove(asBinder);
                    if (remove != null) {
                        asBinder.unlinkToDeath(remove, 0);
                    }
                }
            });
        }
    }

    private interface ServiceCallbacks {
        void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;

        IBinder asBinder();

        void b() throws RemoteException;

        void c(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;
    }

    private static class ServiceCallbacksCompat implements ServiceCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final Messenger f8962a;

        ServiceCallbacksCompat(Messenger messenger) {
            this.f8962a = messenger;
        }

        private void d(int i2, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f8962a.send(obtain);
        }

        public void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString(MediaBrowserProtocol.f8902d, str);
            bundle3.putBundle(MediaBrowserProtocol.f8905g, bundle);
            bundle3.putBundle(MediaBrowserProtocol.f8906h, bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList(MediaBrowserProtocol.f8903e, list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
            }
            d(3, bundle3);
        }

        public IBinder asBinder() {
            return this.f8962a.getBinder();
        }

        public void b() throws RemoteException {
            d(2, (Bundle) null);
        }

        public void c(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(MediaBrowserProtocol.r, 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.f8902d, str);
            bundle2.putParcelable(MediaBrowserProtocol.f8904f, token);
            bundle2.putBundle(MediaBrowserProtocol.f8909k, bundle);
            d(1, bundle2);
        }
    }

    private static final class ServiceHandler extends Handler {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private MediaBrowserServiceCompat f8963a;

        @MainThread
        ServiceHandler(@NonNull MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.f8963a = mediaBrowserServiceCompat;
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @MainThread
        public void b() {
            this.f8963a = null;
        }

        @MainThread
        public void handleMessage(@NonNull Message message) {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = this.f8963a;
            if (mediaBrowserServiceCompat != null) {
                mediaBrowserServiceCompat.g(message);
            } else {
                removeCallbacksAndMessages((Object) null);
            }
        }

        public boolean sendMessageAtTime(Message message, long j2) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(MediaBrowserProtocol.f8900b, Binder.getCallingUid());
            int callingPid = Binder.getCallingPid();
            if (callingPid <= 0) {
                if (!data.containsKey(MediaBrowserProtocol.f8901c)) {
                    callingPid = -1;
                }
                return super.sendMessageAtTime(message, j2);
            }
            data.putInt(MediaBrowserProtocol.f8901c, callingPid);
            return super.sendMessageAtTime(message, j2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<Pair> list = connectionRecord.f8936g.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (Pair pair : list) {
            if (iBinder == pair.f6296a && MediaBrowserCompatUtils.a(bundle, (Bundle) pair.f6297b)) {
                return;
            }
        }
        list.add(new Pair(iBinder, bundle));
        connectionRecord.f8936g.put(str, list);
        u(str, connectionRecord, bundle, (Bundle) null);
        this.Y2 = connectionRecord;
        r(str, bundle);
        this.Y2 = null;
    }

    /* access modifiers changed from: package-private */
    public List<MediaBrowserCompat.MediaItem> b(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i2 = bundle.getInt(MediaBrowserCompat.f2202d, -1);
        int i4 = bundle.getInt(MediaBrowserCompat.f2203e, -1);
        if (i2 == -1 && i4 == -1) {
            return list;
        }
        int i5 = i4 * i2;
        int i6 = i5 + i4;
        if (i2 < 0 || i4 < 1 || i5 >= list.size()) {
            return Collections.emptyList();
        }
        if (i6 > list.size()) {
            i6 = list.size();
        }
        return list.subList(i5, i6);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void c(Context context) {
        attachBaseContext(context);
    }

    public final Bundle d() {
        return this.s.a();
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo e() {
        return this.s.d();
    }

    @Nullable
    public MediaSessionCompat.Token f() {
        return this.a3;
    }

    /* access modifiers changed from: package-private */
    public void g(Message message) {
        Bundle data = message.getData();
        switch (message.what) {
            case 1:
                Bundle bundle = data.getBundle(MediaBrowserProtocol.f8909k);
                MediaSessionCompat.b(bundle);
                this.X.b(data.getString(MediaBrowserProtocol.f8907i), data.getInt(MediaBrowserProtocol.f8901c), data.getInt(MediaBrowserProtocol.f8900b), bundle, new ServiceCallbacksCompat(message.replyTo));
                return;
            case 2:
                this.X.c(new ServiceCallbacksCompat(message.replyTo));
                return;
            case 3:
                Bundle bundle2 = data.getBundle(MediaBrowserProtocol.f8905g);
                MediaSessionCompat.b(bundle2);
                this.X.a(data.getString(MediaBrowserProtocol.f8902d), BundleCompat.a(data, MediaBrowserProtocol.f8899a), bundle2, new ServiceCallbacksCompat(message.replyTo));
                return;
            case 4:
                this.X.f(data.getString(MediaBrowserProtocol.f8902d), BundleCompat.a(data, MediaBrowserProtocol.f8899a), new ServiceCallbacksCompat(message.replyTo));
                return;
            case 5:
                this.X.d(data.getString(MediaBrowserProtocol.f8902d), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.f8908j), new ServiceCallbacksCompat(message.replyTo));
                return;
            case 6:
                Bundle bundle3 = data.getBundle(MediaBrowserProtocol.f8909k);
                MediaSessionCompat.b(bundle3);
                ServiceBinderImpl serviceBinderImpl = this.X;
                ServiceCallbacksCompat serviceCallbacksCompat = new ServiceCallbacksCompat(message.replyTo);
                serviceBinderImpl.e(serviceCallbacksCompat, data.getString(MediaBrowserProtocol.f8907i), data.getInt(MediaBrowserProtocol.f8901c), data.getInt(MediaBrowserProtocol.f8900b), bundle3);
                return;
            case 7:
                this.X.i(new ServiceCallbacksCompat(message.replyTo));
                return;
            case 8:
                Bundle bundle4 = data.getBundle(MediaBrowserProtocol.f8910l);
                MediaSessionCompat.b(bundle4);
                this.X.g(data.getString(MediaBrowserProtocol.f8911m), bundle4, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.f8908j), new ServiceCallbacksCompat(message.replyTo));
                return;
            case 9:
                Bundle bundle5 = data.getBundle(MediaBrowserProtocol.o);
                MediaSessionCompat.b(bundle5);
                this.X.h(data.getString(MediaBrowserProtocol.f8912n), bundle5, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.f8908j), new ServiceCallbacksCompat(message.replyTo));
                return;
            default:
                Log.w(b3, "Unhandled message: " + message + "\n  Service version: " + 2 + "\n  Client version: " + message.arg1);
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean h(String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i2)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void i(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, @NonNull String str, @NonNull Bundle bundle) {
        if (remoteUserInfo == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        } else if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.s.c(remoteUserInfo, str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    public void j(@NonNull String str) {
        if (str != null) {
            this.s.f(str, (Bundle) null);
            return;
        }
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public void k(@NonNull String str, @NonNull Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.s.f(str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    public void l(@NonNull String str, Bundle bundle, @NonNull Result<Bundle> result) {
        result.h((Bundle) null);
    }

    @Nullable
    public abstract BrowserRoot m(@NonNull String str, int i2, @Nullable Bundle bundle);

    public abstract void n(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result);

    public void o(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result, @NonNull Bundle bundle) {
        result.k(1);
        n(str, result);
    }

    public IBinder onBind(Intent intent) {
        return this.s.e(intent);
    }

    public void onCreate() {
        super.onCreate();
        int i2 = Build.VERSION.SDK_INT;
        this.s = i2 >= 28 ? new MediaBrowserServiceImplApi28() : i2 >= 26 ? new MediaBrowserServiceImplApi26() : i2 >= 23 ? new MediaBrowserServiceImplApi23() : new MediaBrowserServiceImplApi21();
        this.s.b();
    }

    @CallSuper
    @MainThread
    public void onDestroy() {
        this.Z2.b();
    }

    public void p(String str, @NonNull Result<MediaBrowserCompat.MediaItem> result) {
        result.k(2);
        result.j(null);
    }

    public void q(@NonNull String str, Bundle bundle, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.k(4);
        result.j(null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void r(String str, Bundle bundle) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void s(String str) {
    }

    /* access modifiers changed from: package-private */
    public void t(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass4 r0 = new Result<Bundle>(str) {
            /* access modifiers changed from: package-private */
            public void e(@Nullable Bundle bundle) {
                resultReceiver.b(-1, bundle);
            }

            /* access modifiers changed from: package-private */
            public void f(@Nullable Bundle bundle) {
                resultReceiver.b(1, bundle);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: l */
            public void g(@Nullable Bundle bundle) {
                resultReceiver.b(0, bundle);
            }
        };
        this.Y2 = connectionRecord;
        l(str, bundle, r0);
        this.Y2 = null;
        if (!r0.d()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void u(String str, ConnectionRecord connectionRecord, Bundle bundle, Bundle bundle2) {
        final ConnectionRecord connectionRecord2 = connectionRecord;
        final String str2 = str;
        final Bundle bundle3 = bundle;
        final Bundle bundle4 = bundle2;
        AnonymousClass1 r0 = new Result<List<MediaBrowserCompat.MediaItem>>(str) {
            /* access modifiers changed from: package-private */
            /* renamed from: l */
            public void g(@Nullable List<MediaBrowserCompat.MediaItem> list) {
                if (MediaBrowserServiceCompat.this.X2.get(connectionRecord2.f8935f.asBinder()) == connectionRecord2) {
                    if ((c() & 1) != 0) {
                        list = MediaBrowserServiceCompat.this.b(list, bundle3);
                    }
                    try {
                        connectionRecord2.f8935f.a(str2, list, bundle3, bundle4);
                    } catch (RemoteException unused) {
                        Log.w(MediaBrowserServiceCompat.b3, "Calling onLoadChildren() failed for id=" + str2 + " package=" + connectionRecord2.f8930a);
                    }
                } else if (MediaBrowserServiceCompat.c3) {
                    Log.d(MediaBrowserServiceCompat.b3, "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + connectionRecord2.f8930a + " id=" + str2);
                }
            }
        };
        this.Y2 = connectionRecord;
        if (bundle == null) {
            n(str, r0);
        } else {
            o(str, r0, bundle);
        }
        this.Y2 = null;
        if (!r0.d()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.f8930a + " id=" + str);
        }
    }

    /* access modifiers changed from: package-private */
    public void v(String str, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass2 r0 = new Result<MediaBrowserCompat.MediaItem>(str) {
            /* access modifiers changed from: package-private */
            /* renamed from: l */
            public void g(@Nullable MediaBrowserCompat.MediaItem mediaItem) {
                if ((c() & 2) != 0) {
                    resultReceiver.b(-1, (Bundle) null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaBrowserServiceCompat.f3, mediaItem);
                resultReceiver.b(0, bundle);
            }
        };
        this.Y2 = connectionRecord;
        p(str, r0);
        this.Y2 = null;
        if (!r0.d()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    /* access modifiers changed from: package-private */
    public void w(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass3 r0 = new Result<List<MediaBrowserCompat.MediaItem>>(str) {
            /* access modifiers changed from: package-private */
            /* renamed from: l */
            public void g(@Nullable List<MediaBrowserCompat.MediaItem> list) {
                if ((c() & 4) != 0 || list == null) {
                    resultReceiver.b(-1, (Bundle) null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArray(MediaBrowserServiceCompat.g3, (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                resultReceiver.b(0, bundle);
            }
        };
        this.Y2 = connectionRecord;
        q(str, bundle, r0);
        this.Y2 = null;
        if (!r0.d()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean x(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z = false;
        if (iBinder == null) {
            try {
                if (connectionRecord.f8936g.remove(str) != null) {
                    z = true;
                }
            } catch (Throwable th) {
                this.Y2 = connectionRecord;
                s(str);
                this.Y2 = null;
                throw th;
            }
        } else {
            List list = connectionRecord.f8936g.get(str);
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    if (iBinder == ((Pair) it2.next()).f6296a) {
                        it2.remove();
                        z = true;
                    }
                }
                if (list.size() == 0) {
                    connectionRecord.f8936g.remove(str);
                }
            }
        }
        this.Y2 = connectionRecord;
        s(str);
        this.Y2 = null;
        return z;
    }

    public void y(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null");
        } else if (this.a3 == null) {
            this.a3 = token;
            this.s.g(token);
        } else {
            throw new IllegalStateException("The session token has already been set");
        }
    }
}
