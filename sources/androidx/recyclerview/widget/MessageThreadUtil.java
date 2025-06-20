package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil<T> implements ThreadUtil<T> {

    static class MessageQueue {

        /* renamed from: a  reason: collision with root package name */
        private SyncQueueItem f15457a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f15458b = new Object();

        MessageQueue() {
        }

        /* access modifiers changed from: package-private */
        public SyncQueueItem a() {
            synchronized (this.f15458b) {
                try {
                    SyncQueueItem syncQueueItem = this.f15457a;
                    if (syncQueueItem == null) {
                        return null;
                    }
                    this.f15457a = syncQueueItem.f15461a;
                    return syncQueueItem;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0017 A[Catch:{ all -> 0x0013 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(int r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r5.f15458b
                monitor-enter(r0)
            L_0x0003:
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r1 = r5.f15457a     // Catch:{ all -> 0x0013 }
                if (r1 == 0) goto L_0x0015
                int r2 = r1.f15462b     // Catch:{ all -> 0x0013 }
                if (r2 != r6) goto L_0x0015
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r2 = r1.f15461a     // Catch:{ all -> 0x0013 }
                r5.f15457a = r2     // Catch:{ all -> 0x0013 }
                r1.d()     // Catch:{ all -> 0x0013 }
                goto L_0x0003
            L_0x0013:
                r6 = move-exception
                goto L_0x002c
            L_0x0015:
                if (r1 == 0) goto L_0x002a
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r2 = r1.f15461a     // Catch:{ all -> 0x0013 }
            L_0x0019:
                if (r2 == 0) goto L_0x002a
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r3 = r2.f15461a     // Catch:{ all -> 0x0013 }
                int r4 = r2.f15462b     // Catch:{ all -> 0x0013 }
                if (r4 != r6) goto L_0x0027
                r1.f15461a = r3     // Catch:{ all -> 0x0013 }
                r2.d()     // Catch:{ all -> 0x0013 }
                goto L_0x0028
            L_0x0027:
                r1 = r2
            L_0x0028:
                r2 = r3
                goto L_0x0019
            L_0x002a:
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                return
            L_0x002c:
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.MessageThreadUtil.MessageQueue.b(int):void");
        }

        /* access modifiers changed from: package-private */
        public void c(SyncQueueItem syncQueueItem) {
            synchronized (this.f15458b) {
                try {
                    SyncQueueItem syncQueueItem2 = this.f15457a;
                    if (syncQueueItem2 == null) {
                        this.f15457a = syncQueueItem;
                        return;
                    }
                    while (true) {
                        SyncQueueItem syncQueueItem3 = syncQueueItem2.f15461a;
                        if (syncQueueItem3 != null) {
                            syncQueueItem2 = syncQueueItem3;
                        } else {
                            syncQueueItem2.f15461a = syncQueueItem;
                            return;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(SyncQueueItem syncQueueItem) {
            synchronized (this.f15458b) {
                syncQueueItem.f15461a = this.f15457a;
                this.f15457a = syncQueueItem;
            }
        }
    }

    static class SyncQueueItem {

        /* renamed from: i  reason: collision with root package name */
        private static SyncQueueItem f15459i;

        /* renamed from: j  reason: collision with root package name */
        private static final Object f15460j = new Object();

        /* renamed from: a  reason: collision with root package name */
        SyncQueueItem f15461a;

        /* renamed from: b  reason: collision with root package name */
        public int f15462b;

        /* renamed from: c  reason: collision with root package name */
        public int f15463c;

        /* renamed from: d  reason: collision with root package name */
        public int f15464d;

        /* renamed from: e  reason: collision with root package name */
        public int f15465e;

        /* renamed from: f  reason: collision with root package name */
        public int f15466f;

        /* renamed from: g  reason: collision with root package name */
        public int f15467g;

        /* renamed from: h  reason: collision with root package name */
        public Object f15468h;

        SyncQueueItem() {
        }

        static SyncQueueItem a(int i2, int i3, int i4) {
            return b(i2, i3, i4, 0, 0, 0, (Object) null);
        }

        static SyncQueueItem b(int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (f15460j) {
                try {
                    syncQueueItem = f15459i;
                    if (syncQueueItem == null) {
                        syncQueueItem = new SyncQueueItem();
                    } else {
                        f15459i = syncQueueItem.f15461a;
                        syncQueueItem.f15461a = null;
                    }
                    syncQueueItem.f15462b = i2;
                    syncQueueItem.f15463c = i3;
                    syncQueueItem.f15464d = i4;
                    syncQueueItem.f15465e = i5;
                    syncQueueItem.f15466f = i6;
                    syncQueueItem.f15467g = i7;
                    syncQueueItem.f15468h = obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return syncQueueItem;
        }

        static SyncQueueItem c(int i2, int i3, Object obj) {
            return b(i2, i3, 0, 0, 0, 0, obj);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f15461a = null;
            this.f15467g = 0;
            this.f15466f = 0;
            this.f15465e = 0;
            this.f15464d = 0;
            this.f15463c = 0;
            this.f15462b = 0;
            this.f15468h = null;
            synchronized (f15460j) {
                try {
                    SyncQueueItem syncQueueItem = f15459i;
                    if (syncQueueItem != null) {
                        this.f15461a = syncQueueItem;
                    }
                    f15459i = this;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    MessageThreadUtil() {
    }

    public ThreadUtil.BackgroundCallback<T> a(final ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new ThreadUtil.BackgroundCallback<T>() {

            /* renamed from: g  reason: collision with root package name */
            static final int f15447g = 1;

            /* renamed from: h  reason: collision with root package name */
            static final int f15448h = 2;

            /* renamed from: i  reason: collision with root package name */
            static final int f15449i = 3;

            /* renamed from: j  reason: collision with root package name */
            static final int f15450j = 4;

            /* renamed from: a  reason: collision with root package name */
            final MessageQueue f15451a = new MessageQueue();

            /* renamed from: b  reason: collision with root package name */
            private final Executor f15452b = AsyncTask.THREAD_POOL_EXECUTOR;

            /* renamed from: c  reason: collision with root package name */
            AtomicBoolean f15453c = new AtomicBoolean(false);

            /* renamed from: d  reason: collision with root package name */
            private Runnable f15454d = new Runnable() {
                public void run() {
                    while (true) {
                        SyncQueueItem a2 = AnonymousClass2.this.f15451a.a();
                        if (a2 == null) {
                            AnonymousClass2.this.f15453c.set(false);
                            return;
                        }
                        int i2 = a2.f15462b;
                        if (i2 == 1) {
                            AnonymousClass2.this.f15451a.b(1);
                            backgroundCallback.d(a2.f15463c);
                        } else if (i2 == 2) {
                            AnonymousClass2.this.f15451a.b(2);
                            AnonymousClass2.this.f15451a.b(3);
                            backgroundCallback.a(a2.f15463c, a2.f15464d, a2.f15465e, a2.f15466f, a2.f15467g);
                        } else if (i2 == 3) {
                            backgroundCallback.c(a2.f15463c, a2.f15464d);
                        } else if (i2 != 4) {
                            Log.e("ThreadUtil", "Unsupported message, what=" + a2.f15462b);
                        } else {
                            backgroundCallback.b((TileList.Tile) a2.f15468h);
                        }
                    }
                }
            };

            private void e() {
                if (this.f15453c.compareAndSet(false, true)) {
                    this.f15452b.execute(this.f15454d);
                }
            }

            private void f(SyncQueueItem syncQueueItem) {
                this.f15451a.c(syncQueueItem);
                e();
            }

            private void g(SyncQueueItem syncQueueItem) {
                this.f15451a.d(syncQueueItem);
                e();
            }

            public void a(int i2, int i3, int i4, int i5, int i6) {
                g(SyncQueueItem.b(2, i2, i3, i4, i5, i6, (Object) null));
            }

            public void b(TileList.Tile<T> tile) {
                f(SyncQueueItem.c(4, 0, tile));
            }

            public void c(int i2, int i3) {
                f(SyncQueueItem.a(3, i2, i3));
            }

            public void d(int i2) {
                g(SyncQueueItem.c(1, i2, (Object) null));
            }
        };
    }

    public ThreadUtil.MainThreadCallback<T> b(final ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new ThreadUtil.MainThreadCallback<T>() {

            /* renamed from: f  reason: collision with root package name */
            static final int f15439f = 1;

            /* renamed from: g  reason: collision with root package name */
            static final int f15440g = 2;

            /* renamed from: h  reason: collision with root package name */
            static final int f15441h = 3;

            /* renamed from: a  reason: collision with root package name */
            final MessageQueue f15442a = new MessageQueue();

            /* renamed from: b  reason: collision with root package name */
            private final Handler f15443b = new Handler(Looper.getMainLooper());

            /* renamed from: c  reason: collision with root package name */
            private Runnable f15444c = new Runnable() {
                public void run() {
                    while (true) {
                        SyncQueueItem a2 = AnonymousClass1.this.f15442a.a();
                        if (a2 != null) {
                            int i2 = a2.f15462b;
                            if (i2 == 1) {
                                mainThreadCallback.c(a2.f15463c, a2.f15464d);
                            } else if (i2 == 2) {
                                mainThreadCallback.a(a2.f15463c, (TileList.Tile) a2.f15468h);
                            } else if (i2 != 3) {
                                Log.e("ThreadUtil", "Unsupported message, what=" + a2.f15462b);
                            } else {
                                mainThreadCallback.b(a2.f15463c, a2.f15464d);
                            }
                        } else {
                            return;
                        }
                    }
                }
            };

            private void d(SyncQueueItem syncQueueItem) {
                this.f15442a.c(syncQueueItem);
                this.f15443b.post(this.f15444c);
            }

            public void a(int i2, TileList.Tile<T> tile) {
                d(SyncQueueItem.c(2, i2, tile));
            }

            public void b(int i2, int i3) {
                d(SyncQueueItem.a(3, i2, i3));
            }

            public void c(int i2, int i3) {
                d(SyncQueueItem.a(1, i2, i3));
            }
        };
    }
}
