package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
public abstract class JobIntentService extends Service {
    static final String a3 = "JobIntentService";
    static final boolean b3 = false;
    static final Object c3 = new Object();
    static final HashMap<ComponentName, WorkEnqueuer> d3 = new HashMap<>();
    WorkEnqueuer X;
    boolean X2 = false;
    CommandProcessor Y;
    boolean Y2 = false;
    boolean Z = false;
    final ArrayList<CompatWorkItem> Z2;
    CompatJobEngine s;

    final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        CommandProcessor() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                GenericWorkItem a2 = JobIntentService.this.a();
                if (a2 == null) {
                    return null;
                }
                JobIntentService.this.h(a2.getIntent());
                a2.c();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onCancelled(Void voidR) {
            JobIntentService.this.j();
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(Void voidR) {
            JobIntentService.this.j();
        }
    }

    interface CompatJobEngine {
        IBinder a();

        GenericWorkItem b();
    }

    static final class CompatWorkEnqueuer extends WorkEnqueuer {

        /* renamed from: d  reason: collision with root package name */
        private final Context f5262d;

        /* renamed from: e  reason: collision with root package name */
        private final PowerManager.WakeLock f5263e;

        /* renamed from: f  reason: collision with root package name */
        private final PowerManager.WakeLock f5264f;

        /* renamed from: g  reason: collision with root package name */
        boolean f5265g;

        /* renamed from: h  reason: collision with root package name */
        boolean f5266h;

        CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            this.f5262d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f5263e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f5264f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        /* access modifiers changed from: package-private */
        public void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f5279a);
            if (this.f5262d.startService(intent2) != null) {
                synchronized (this) {
                    try {
                        if (!this.f5265g) {
                            this.f5265g = true;
                            if (!this.f5266h) {
                                this.f5263e.acquire(60000);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public void c() {
            synchronized (this) {
                try {
                    if (this.f5266h) {
                        if (this.f5265g) {
                            this.f5263e.acquire(60000);
                        }
                        this.f5266h = false;
                        this.f5264f.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void d() {
            synchronized (this) {
                try {
                    if (!this.f5266h) {
                        this.f5266h = true;
                        this.f5264f.acquire(600000);
                        this.f5263e.release();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void e() {
            synchronized (this) {
                this.f5265g = false;
            }
        }
    }

    final class CompatWorkItem implements GenericWorkItem {

        /* renamed from: a  reason: collision with root package name */
        final Intent f5267a;

        /* renamed from: b  reason: collision with root package name */
        final int f5268b;

        CompatWorkItem(Intent intent, int i2) {
            this.f5267a = intent;
            this.f5268b = i2;
        }

        public void c() {
            JobIntentService.this.stopSelf(this.f5268b);
        }

        public Intent getIntent() {
            return this.f5267a;
        }
    }

    interface GenericWorkItem {
        void c();

        Intent getIntent();
    }

    @RequiresApi(26)
    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {

        /* renamed from: d  reason: collision with root package name */
        static final String f5270d = "JobServiceEngineImpl";

        /* renamed from: e  reason: collision with root package name */
        static final boolean f5271e = false;

        /* renamed from: a  reason: collision with root package name */
        final JobIntentService f5272a;

        /* renamed from: b  reason: collision with root package name */
        final Object f5273b = new Object();

        /* renamed from: c  reason: collision with root package name */
        JobParameters f5274c;

        final class WrapperWorkItem implements GenericWorkItem {

            /* renamed from: a  reason: collision with root package name */
            final JobWorkItem f5275a;

            WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.f5275a = jobWorkItem;
            }

            public void c() {
                synchronized (JobServiceEngineImpl.this.f5273b) {
                    try {
                        JobParameters jobParameters = JobServiceEngineImpl.this.f5274c;
                        if (jobParameters != null) {
                            f.a(jobParameters, this.f5275a);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            public Intent getIntent() {
                return this.f5275a.getIntent();
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f5272a = jobIntentService;
        }

        public IBinder a() {
            return getBinder();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0011, code lost:
            if (r1 == null) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            androidx.core.app.e.a(r1).setExtrasClassLoader(r3.f5272a.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
            return new androidx.core.app.JobIntentService.JobServiceEngineImpl.WrapperWorkItem(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.core.app.JobIntentService.GenericWorkItem b() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.f5273b
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r3.f5274c     // Catch:{ all -> 0x000a }
                r2 = 0
                if (r1 != 0) goto L_0x000c
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                return r2
            L_0x000a:
                r1 = move-exception
                goto L_0x0027
            L_0x000c:
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ all -> 0x000a }
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                if (r1 == 0) goto L_0x0026
                android.content.Intent r0 = r1.getIntent()
                androidx.core.app.JobIntentService r2 = r3.f5272a
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                androidx.core.app.JobIntentService$JobServiceEngineImpl$WrapperWorkItem r0 = new androidx.core.app.JobIntentService$JobServiceEngineImpl$WrapperWorkItem
                r0.<init>(r1)
                return r0
            L_0x0026:
                return r2
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.JobIntentService.JobServiceEngineImpl.b():androidx.core.app.JobIntentService$GenericWorkItem");
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f5274c = jobParameters;
            this.f5272a.e(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b2 = this.f5272a.b();
            synchronized (this.f5273b) {
                this.f5274c = null;
            }
            return b2;
        }
    }

    @RequiresApi(26)
    static final class JobWorkEnqueuer extends WorkEnqueuer {

        /* renamed from: d  reason: collision with root package name */
        private final JobInfo f5277d;

        /* renamed from: e  reason: collision with root package name */
        private final JobScheduler f5278e;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i2) {
            super(componentName);
            b(i2);
            this.f5277d = new JobInfo.Builder(i2, this.f5279a).setOverrideDeadline(0).build();
            this.f5278e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* access modifiers changed from: package-private */
        public void a(Intent intent) {
            int unused = this.f5278e.enqueue(this.f5277d, h.a(intent));
        }
    }

    static abstract class WorkEnqueuer {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f5279a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5280b;

        /* renamed from: c  reason: collision with root package name */
        int f5281c;

        WorkEnqueuer(ComponentName componentName) {
            this.f5279a = componentName;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(Intent intent);

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            if (!this.f5280b) {
                this.f5280b = true;
                this.f5281c = i2;
            } else if (this.f5281c != i2) {
                throw new IllegalArgumentException("Given job ID " + i2 + " is different than previous " + this.f5281c);
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public JobIntentService() {
        this.Z2 = Build.VERSION.SDK_INT >= 26 ? null : new ArrayList<>();
    }

    public static void c(@NonNull Context context, @NonNull ComponentName componentName, int i2, @NonNull Intent intent) {
        if (intent != null) {
            synchronized (c3) {
                WorkEnqueuer f2 = f(context, componentName, true, i2);
                f2.b(i2);
                f2.a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    public static void d(@NonNull Context context, @NonNull Class<?> cls, int i2, @NonNull Intent intent) {
        c(context, new ComponentName(context, cls), i2, intent);
    }

    static WorkEnqueuer f(Context context, ComponentName componentName, boolean z, int i2) {
        WorkEnqueuer compatWorkEnqueuer;
        HashMap<ComponentName, WorkEnqueuer> hashMap = d3;
        WorkEnqueuer workEnqueuer = hashMap.get(componentName);
        if (workEnqueuer == null) {
            if (Build.VERSION.SDK_INT < 26) {
                compatWorkEnqueuer = new CompatWorkEnqueuer(context, componentName);
            } else if (z) {
                compatWorkEnqueuer = new JobWorkEnqueuer(context, componentName, i2);
            } else {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            workEnqueuer = compatWorkEnqueuer;
            hashMap.put(componentName, workEnqueuer);
        }
        return workEnqueuer;
    }

    /* access modifiers changed from: package-private */
    public GenericWorkItem a() {
        CompatJobEngine compatJobEngine = this.s;
        if (compatJobEngine != null) {
            return compatJobEngine.b();
        }
        synchronized (this.Z2) {
            try {
                if (this.Z2.size() <= 0) {
                    return null;
                }
                GenericWorkItem remove = this.Z2.remove(0);
                return remove;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        CommandProcessor commandProcessor = this.Y;
        if (commandProcessor != null) {
            commandProcessor.cancel(this.Z);
        }
        this.X2 = true;
        return i();
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z) {
        if (this.Y == null) {
            this.Y = new CommandProcessor();
            WorkEnqueuer workEnqueuer = this.X;
            if (workEnqueuer != null && z) {
                workEnqueuer.d();
            }
            this.Y.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public boolean g() {
        return this.X2;
    }

    /* access modifiers changed from: protected */
    public abstract void h(@NonNull Intent intent);

    public boolean i() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        ArrayList<CompatWorkItem> arrayList = this.Z2;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.Y = null;
                    ArrayList<CompatWorkItem> arrayList2 = this.Z2;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        e(false);
                    } else if (!this.Y2) {
                        this.X.c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void k(boolean z) {
        this.Z = z;
    }

    public IBinder onBind(@NonNull Intent intent) {
        CompatJobEngine compatJobEngine = this.s;
        if (compatJobEngine != null) {
            return compatJobEngine.a();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.s = new JobServiceEngineImpl(this);
            this.X = null;
            return;
        }
        this.s = null;
        this.X = f(this, new ComponentName(this, getClass()), false, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList<CompatWorkItem> arrayList = this.Z2;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.Y2 = true;
                this.X.c();
            }
        }
    }

    public int onStartCommand(@Nullable Intent intent, int i2, int i3) {
        if (this.Z2 == null) {
            return 2;
        }
        this.X.e();
        synchronized (this.Z2) {
            ArrayList<CompatWorkItem> arrayList = this.Z2;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i3));
            e(true);
        }
        return 3;
    }
}
