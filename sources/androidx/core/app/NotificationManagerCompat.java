package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotificationManagerCompat {
    public static final int A = 4;
    public static final int B = 5;

    /* renamed from: c  reason: collision with root package name */
    private static final String f5517c = "NotifManCompat";

    /* renamed from: d  reason: collision with root package name */
    private static final String f5518d = "checkOpNoThrow";

    /* renamed from: e  reason: collision with root package name */
    private static final String f5519e = "OP_POST_NOTIFICATION";

    /* renamed from: f  reason: collision with root package name */
    public static final String f5520f = "android.support.useSideChannel";

    /* renamed from: g  reason: collision with root package name */
    public static final String f5521g = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";

    /* renamed from: h  reason: collision with root package name */
    static final int f5522h = 19;

    /* renamed from: i  reason: collision with root package name */
    private static final int f5523i = 1000;

    /* renamed from: j  reason: collision with root package name */
    private static final int f5524j = 6;

    /* renamed from: k  reason: collision with root package name */
    private static final String f5525k = "enabled_notification_listeners";

    /* renamed from: l  reason: collision with root package name */
    private static final Object f5526l = new Object();
    @GuardedBy("sEnabledNotificationListenersLock")

    /* renamed from: m  reason: collision with root package name */
    private static String f5527m = null;
    @GuardedBy("sEnabledNotificationListenersLock")

    /* renamed from: n  reason: collision with root package name */
    private static Set<String> f5528n = new HashSet();
    private static final Object o = new Object();
    @GuardedBy("sLock")
    private static SideChannelManager p = null;
    public static final int q = 1;
    public static final int r = 2;
    public static final int s = 3;
    public static final int t = 4;
    public static final int u = 0;
    public static final int v = -1000;
    public static final int w = 0;
    public static final int x = 1;
    public static final int y = 2;
    public static final int z = 3;

    /* renamed from: a  reason: collision with root package name */
    private final Context f5529a;

    /* renamed from: b  reason: collision with root package name */
    private final NotificationManager f5530b;

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static List<StatusBarNotification> a(NotificationManager notificationManager) {
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            return activeNotifications == null ? new ArrayList() : Arrays.asList(activeNotifications);
        }

        @DoNotInline
        static int b(NotificationManager notificationManager) {
            return notificationManager.getCurrentInterruptionFilter();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        @DoNotInline
        static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static void a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        @DoNotInline
        static void b(NotificationManager notificationManager, NotificationChannelGroup notificationChannelGroup) {
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }

        @DoNotInline
        static void c(NotificationManager notificationManager, List<NotificationChannelGroup> list) {
            notificationManager.createNotificationChannelGroups(list);
        }

        @DoNotInline
        static void d(NotificationManager notificationManager, List<NotificationChannel> list) {
            notificationManager.createNotificationChannels(list);
        }

        @DoNotInline
        static void e(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannel(str);
        }

        @DoNotInline
        static void f(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannelGroup(str);
        }

        @DoNotInline
        static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        @DoNotInline
        static String h(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        @DoNotInline
        static NotificationChannel i(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannel(str);
        }

        @DoNotInline
        static List<NotificationChannelGroup> j(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannelGroups();
        }

        @DoNotInline
        static List<NotificationChannel> k(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static NotificationChannelGroup a(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannelGroup(str);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static NotificationChannel a(NotificationManager notificationManager, String str, String str2) {
            return notificationManager.getNotificationChannel(str, str2);
        }

        @DoNotInline
        static String b(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }
    }

    @RequiresApi(34)
    static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static boolean a(NotificationManager notificationManager) {
            return notificationManager.canUseFullScreenIntent();
        }
    }

    private static class CancelTask implements Task {

        /* renamed from: a  reason: collision with root package name */
        final String f5531a;

        /* renamed from: b  reason: collision with root package name */
        final int f5532b;

        /* renamed from: c  reason: collision with root package name */
        final String f5533c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f5534d;

        CancelTask(String str) {
            this.f5531a = str;
            this.f5532b = 0;
            this.f5533c = null;
            this.f5534d = true;
        }

        public void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.f5534d) {
                iNotificationSideChannel.c0(this.f5531a);
            } else {
                iNotificationSideChannel.G0(this.f5531a, this.f5532b, this.f5533c);
            }
        }

        @NonNull
        public String toString() {
            return "CancelTask[" + "packageName:" + this.f5531a + ", id:" + this.f5532b + ", tag:" + this.f5533c + ", all:" + this.f5534d + "]";
        }

        CancelTask(String str, int i2, String str2) {
            this.f5531a = str;
            this.f5532b = i2;
            this.f5533c = str2;
            this.f5534d = false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterruptionFilter {
    }

    public static class NotificationWithIdAndTag {

        /* renamed from: a  reason: collision with root package name */
        final String f5535a;

        /* renamed from: b  reason: collision with root package name */
        final int f5536b;

        /* renamed from: c  reason: collision with root package name */
        Notification f5537c;

        public NotificationWithIdAndTag(int i2, @NonNull Notification notification) {
            this((String) null, i2, notification);
        }

        public NotificationWithIdAndTag(@Nullable String str, int i2, @NonNull Notification notification) {
            this.f5535a = str;
            this.f5536b = i2;
            this.f5537c = notification;
        }
    }

    private static class NotifyTask implements Task {

        /* renamed from: a  reason: collision with root package name */
        final String f5538a;

        /* renamed from: b  reason: collision with root package name */
        final int f5539b;

        /* renamed from: c  reason: collision with root package name */
        final String f5540c;

        /* renamed from: d  reason: collision with root package name */
        final Notification f5541d;

        NotifyTask(String str, int i2, String str2, Notification notification) {
            this.f5538a = str;
            this.f5539b = i2;
            this.f5540c = str2;
            this.f5541d = notification;
        }

        public void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.Y0(this.f5538a, this.f5539b, this.f5540c, this.f5541d);
        }

        @NonNull
        public String toString() {
            return "NotifyTask[" + "packageName:" + this.f5538a + ", id:" + this.f5539b + ", tag:" + this.f5540c + "]";
        }
    }

    private static class ServiceConnectedEvent {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f5542a;

        /* renamed from: b  reason: collision with root package name */
        final IBinder f5543b;

        ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.f5542a = componentName;
            this.f5543b = iBinder;
        }
    }

    private static class SideChannelManager implements Handler.Callback, ServiceConnection {
        private static final int Y2 = 0;
        private static final int Z2 = 1;
        private static final int a3 = 2;
        private static final int b3 = 3;
        private final HandlerThread X;
        private Set<String> X2 = new HashSet();
        private final Handler Y;
        private final Map<ComponentName, ListenerRecord> Z = new HashMap();
        private final Context s;

        private static class ListenerRecord {

            /* renamed from: a  reason: collision with root package name */
            final ComponentName f5544a;

            /* renamed from: b  reason: collision with root package name */
            boolean f5545b = false;

            /* renamed from: c  reason: collision with root package name */
            INotificationSideChannel f5546c;

            /* renamed from: d  reason: collision with root package name */
            ArrayDeque<Task> f5547d = new ArrayDeque<>();

            /* renamed from: e  reason: collision with root package name */
            int f5548e = 0;

            ListenerRecord(ComponentName componentName) {
                this.f5544a = componentName;
            }
        }

        SideChannelManager(Context context) {
            this.s = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.X = handlerThread;
            handlerThread.start();
            this.Y = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(ListenerRecord listenerRecord) {
            if (listenerRecord.f5545b) {
                return true;
            }
            boolean bindService = this.s.bindService(new Intent(NotificationManagerCompat.f5521g).setComponent(listenerRecord.f5544a), this, 33);
            listenerRecord.f5545b = bindService;
            if (bindService) {
                listenerRecord.f5548e = 0;
            } else {
                Log.w(NotificationManagerCompat.f5517c, "Unable to bind to listener " + listenerRecord.f5544a);
                this.s.unbindService(this);
            }
            return listenerRecord.f5545b;
        }

        private void b(ListenerRecord listenerRecord) {
            if (listenerRecord.f5545b) {
                this.s.unbindService(this);
                listenerRecord.f5545b = false;
            }
            listenerRecord.f5546c = null;
        }

        private void c(Task task) {
            j();
            for (ListenerRecord next : this.Z.values()) {
                next.f5547d.add(task);
                g(next);
            }
        }

        private void d(ComponentName componentName) {
            ListenerRecord listenerRecord = this.Z.get(componentName);
            if (listenerRecord != null) {
                g(listenerRecord);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = this.Z.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.f5546c = INotificationSideChannel.Stub.e(iBinder);
                listenerRecord.f5548e = 0;
                g(listenerRecord);
            }
        }

        private void f(ComponentName componentName) {
            ListenerRecord listenerRecord = this.Z.get(componentName);
            if (listenerRecord != null) {
                b(listenerRecord);
            }
        }

        private void g(ListenerRecord listenerRecord) {
            if (Log.isLoggable(NotificationManagerCompat.f5517c, 3)) {
                Log.d(NotificationManagerCompat.f5517c, "Processing component " + listenerRecord.f5544a + ", " + listenerRecord.f5547d.size() + " queued tasks");
            }
            if (!listenerRecord.f5547d.isEmpty()) {
                if (!a(listenerRecord) || listenerRecord.f5546c == null) {
                    i(listenerRecord);
                    return;
                }
                while (true) {
                    Task peek = listenerRecord.f5547d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable(NotificationManagerCompat.f5517c, 3)) {
                            Log.d(NotificationManagerCompat.f5517c, "Sending task " + peek);
                        }
                        peek.a(listenerRecord.f5546c);
                        listenerRecord.f5547d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable(NotificationManagerCompat.f5517c, 3)) {
                            Log.d(NotificationManagerCompat.f5517c, "Remote service has died: " + listenerRecord.f5544a);
                        }
                    } catch (RemoteException e2) {
                        Log.w(NotificationManagerCompat.f5517c, "RemoteException communicating with " + listenerRecord.f5544a, e2);
                    }
                }
                if (!listenerRecord.f5547d.isEmpty()) {
                    i(listenerRecord);
                }
            }
        }

        private void i(ListenerRecord listenerRecord) {
            if (!this.Y.hasMessages(3, listenerRecord.f5544a)) {
                int i2 = listenerRecord.f5548e;
                int i3 = i2 + 1;
                listenerRecord.f5548e = i3;
                if (i3 > 6) {
                    Log.w(NotificationManagerCompat.f5517c, "Giving up on delivering " + listenerRecord.f5547d.size() + " tasks to " + listenerRecord.f5544a + " after " + listenerRecord.f5548e + " retries");
                    listenerRecord.f5547d.clear();
                    return;
                }
                int i4 = (1 << i2) * 1000;
                if (Log.isLoggable(NotificationManagerCompat.f5517c, 3)) {
                    Log.d(NotificationManagerCompat.f5517c, "Scheduling retry for " + i4 + " ms");
                }
                this.Y.sendMessageDelayed(this.Y.obtainMessage(3, listenerRecord.f5544a), (long) i4);
            }
        }

        private void j() {
            Set<String> t = NotificationManagerCompat.t(this.s);
            if (!t.equals(this.X2)) {
                this.X2 = t;
                List<ResolveInfo> queryIntentServices = this.s.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.f5521g), 0);
                HashSet<ComponentName> hashSet = new HashSet<>();
                for (ResolveInfo next : queryIntentServices) {
                    if (t.contains(next.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = next.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (next.serviceInfo.permission != null) {
                            Log.w(NotificationManagerCompat.f5517c, "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.Z.containsKey(componentName2)) {
                        if (Log.isLoggable(NotificationManagerCompat.f5517c, 3)) {
                            Log.d(NotificationManagerCompat.f5517c, "Adding listener record for " + componentName2);
                        }
                        this.Z.put(componentName2, new ListenerRecord(componentName2));
                    }
                }
                Iterator<Map.Entry<ComponentName, ListenerRecord>> it2 = this.Z.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry next2 = it2.next();
                    if (!hashSet.contains(next2.getKey())) {
                        if (Log.isLoggable(NotificationManagerCompat.f5517c, 3)) {
                            Log.d(NotificationManagerCompat.f5517c, "Removing listener record for " + next2.getKey());
                        }
                        b((ListenerRecord) next2.getValue());
                        it2.remove();
                    }
                }
            }
        }

        public void h(Task task) {
            this.Y.obtainMessage(0, task).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                c((Task) message.obj);
                return true;
            } else if (i2 == 1) {
                ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                e(serviceConnectedEvent.f5542a, serviceConnectedEvent.f5543b);
                return true;
            } else if (i2 == 2) {
                f((ComponentName) message.obj);
                return true;
            } else if (i2 != 3) {
                return false;
            } else {
                d((ComponentName) message.obj);
                return true;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable(NotificationManagerCompat.f5517c, 3)) {
                Log.d(NotificationManagerCompat.f5517c, "Connected to service " + componentName);
            }
            this.Y.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable(NotificationManagerCompat.f5517c, 3)) {
                Log.d(NotificationManagerCompat.f5517c, "Disconnected from service " + componentName);
            }
            this.Y.obtainMessage(2, componentName).sendToTarget();
        }
    }

    private interface Task {
        void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    @VisibleForTesting
    NotificationManagerCompat(@NonNull NotificationManager notificationManager, @NonNull Context context) {
        this.f5529a = context;
        this.f5530b = notificationManager;
    }

    private void I(Task task) {
        synchronized (o) {
            try {
                if (p == null) {
                    p = new SideChannelManager(this.f5529a.getApplicationContext());
                }
                p.h(task);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean J(Notification notification) {
        Bundle n2 = NotificationCompat.n(notification);
        return n2 != null && n2.getBoolean(f5520f);
    }

    @NonNull
    public static NotificationManagerCompat q(@NonNull Context context) {
        return new NotificationManagerCompat(context);
    }

    @NonNull
    public static Set<String> t(@NonNull Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), f5525k);
        synchronized (f5526l) {
            if (string != null) {
                try {
                    if (!string.equals(f5527m)) {
                        String[] split = string.split(":", -1);
                        HashSet hashSet = new HashSet(split.length);
                        for (String unflattenFromString : split) {
                            ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                            if (unflattenFromString2 != null) {
                                hashSet.add(unflattenFromString2.getPackageName());
                            }
                        }
                        f5528n = hashSet;
                        f5527m = string;
                    }
                } finally {
                }
            }
            set = f5528n;
        }
        return set;
    }

    @Nullable
    public NotificationChannelGroupCompat A(@NonNull String str) {
        NotificationChannelGroup z2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            NotificationChannelGroup z3 = z(str);
            if (z3 != null) {
                return new NotificationChannelGroupCompat(z3);
            }
            return null;
        } else if (i2 < 26 || (z2 = z(str)) == null) {
            return null;
        } else {
            return new NotificationChannelGroupCompat(z2, D());
        }
    }

    @NonNull
    public List<NotificationChannelGroup> B() {
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.j(this.f5530b) : Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannelGroupCompat> C() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            List<NotificationChannelGroup> B2 = B();
            if (!B2.isEmpty()) {
                List<NotificationChannel> emptyList = i2 >= 28 ? Collections.emptyList() : D();
                ArrayList arrayList = new ArrayList(B2.size());
                for (NotificationChannelGroup a2 : B2) {
                    NotificationChannelGroup a3 = r.a(a2);
                    arrayList.add(Build.VERSION.SDK_INT >= 28 ? new NotificationChannelGroupCompat(a3) : new NotificationChannelGroupCompat(a3, emptyList));
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannel> D() {
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.k(this.f5530b) : Collections.emptyList();
    }

    @NonNull
    public List<NotificationChannelCompat> E() {
        if (Build.VERSION.SDK_INT >= 26) {
            List<NotificationChannel> D = D();
            if (!D.isEmpty()) {
                ArrayList arrayList = new ArrayList(D.size());
                for (NotificationChannel a2 : D) {
                    arrayList.add(new NotificationChannelCompat(i.a(a2)));
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void F(int i2, @NonNull Notification notification) {
        G((String) null, i2, notification);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void G(@Nullable String str, int i2, @NonNull Notification notification) {
        if (J(notification)) {
            I(new NotifyTask(this.f5529a.getPackageName(), i2, str, notification));
            this.f5530b.cancel(str, i2);
            return;
        }
        this.f5530b.notify(str, i2, notification);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    public void H(@NonNull List<NotificationWithIdAndTag> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            NotificationWithIdAndTag notificationWithIdAndTag = list.get(i2);
            G(notificationWithIdAndTag.f5535a, notificationWithIdAndTag.f5536b, notificationWithIdAndTag.f5537c);
        }
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.a(this.f5530b);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f5529a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f5529a.getApplicationInfo();
        String packageName = this.f5529a.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class cls2 = Integer.TYPE;
            Method method = cls.getMethod(f5518d, new Class[]{cls2, cls2, String.class});
            Integer num = (Integer) cls.getDeclaredField(f5519e).get(Integer.class);
            num.intValue();
            return ((Integer) method.invoke(appOpsManager, new Object[]{num, Integer.valueOf(i2), packageName})).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public boolean b() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 29) {
            return true;
        }
        if (i2 < 34) {
            return this.f5529a.checkSelfPermission("android.permission.USE_FULL_SCREEN_INTENT") == 0;
        }
        return Api34Impl.a(this.f5530b);
    }

    public void c(int i2) {
        d((String) null, i2);
    }

    public void d(@Nullable String str, int i2) {
        this.f5530b.cancel(str, i2);
    }

    public void e() {
        this.f5530b.cancelAll();
    }

    public void f(@NonNull NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.a(this.f5530b, notificationChannel);
        }
    }

    public void g(@NonNull NotificationChannelCompat notificationChannelCompat) {
        f(notificationChannelCompat.m());
    }

    public void h(@NonNull NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.b(this.f5530b, notificationChannelGroup);
        }
    }

    public void i(@NonNull NotificationChannelGroupCompat notificationChannelGroupCompat) {
        h(notificationChannelGroupCompat.f());
    }

    public void j(@NonNull List<NotificationChannelGroup> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.c(this.f5530b, list);
        }
    }

    public void k(@NonNull List<NotificationChannelGroupCompat> list) {
        if (Build.VERSION.SDK_INT >= 26 && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            for (NotificationChannelGroupCompat f2 : list) {
                arrayList.add(f2.f());
            }
            Api26Impl.c(this.f5530b, arrayList);
        }
    }

    public void l(@NonNull List<NotificationChannel> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.d(this.f5530b, list);
        }
    }

    public void m(@NonNull List<NotificationChannelCompat> list) {
        if (Build.VERSION.SDK_INT >= 26 && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            for (NotificationChannelCompat m2 : list) {
                arrayList.add(m2.m());
            }
            Api26Impl.d(this.f5530b, arrayList);
        }
    }

    public void n(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.e(this.f5530b, str);
        }
    }

    public void o(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.f(this.f5530b, str);
        }
    }

    public void p(@NonNull Collection<String> collection) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (NotificationChannel a2 : Api26Impl.k(this.f5530b)) {
                NotificationChannel a3 = i.a(a2);
                if (!collection.contains(Api26Impl.g(a3)) && (Build.VERSION.SDK_INT < 30 || !collection.contains(Api30Impl.b(a3)))) {
                    Api26Impl.e(this.f5530b, Api26Impl.g(a3));
                }
            }
        }
    }

    @NonNull
    public List<StatusBarNotification> r() {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.a(this.f5530b) : new ArrayList();
    }

    public int s() {
        if (Build.VERSION.SDK_INT < 23) {
            return 0;
        }
        return Api23Impl.b(this.f5530b);
    }

    public int u() {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.b(this.f5530b);
        }
        return -1000;
    }

    @Nullable
    public NotificationChannel v(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.i(this.f5530b, str);
        }
        return null;
    }

    @Nullable
    public NotificationChannel w(@NonNull String str, @NonNull String str2) {
        return Build.VERSION.SDK_INT >= 30 ? Api30Impl.a(this.f5530b, str, str2) : v(str);
    }

    @Nullable
    public NotificationChannelCompat x(@NonNull String str) {
        NotificationChannel v2;
        if (Build.VERSION.SDK_INT < 26 || (v2 = v(str)) == null) {
            return null;
        }
        return new NotificationChannelCompat(v2);
    }

    @Nullable
    public NotificationChannelCompat y(@NonNull String str, @NonNull String str2) {
        NotificationChannel w2;
        if (Build.VERSION.SDK_INT < 26 || (w2 = w(str, str2)) == null) {
            return null;
        }
        return new NotificationChannelCompat(w2);
    }

    @Nullable
    public NotificationChannelGroup z(@NonNull String str) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return Api28Impl.a(this.f5530b, str);
        }
        if (i2 >= 26) {
            for (NotificationChannelGroup a2 : B()) {
                NotificationChannelGroup a3 = r.a(a2);
                if (Api26Impl.h(a3).equals(str)) {
                    return a3;
                }
            }
        }
        return null;
    }

    private NotificationManagerCompat(Context context) {
        this.f5529a = context;
        this.f5530b = (NotificationManager) context.getSystemService("notification");
    }
}
