package com.google.common.util.concurrent;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
final class ListenerCallQueue<L> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f23189b = Logger.getLogger(ListenerCallQueue.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final List<PerListenerQueue<L>> f23190a = Collections.synchronizedList(new ArrayList());

    interface Event<L> {
        void a(L l2);
    }

    private static final class PerListenerQueue<L> implements Runnable {
        final Executor X;
        @GuardedBy("this")
        boolean X2;
        @GuardedBy("this")
        final Queue<Event<L>> Y = Queues.d();
        @GuardedBy("this")
        final Queue<Object> Z = Queues.d();
        final L s;

        PerListenerQueue(L l2, Executor executor) {
            this.s = Preconditions.E(l2);
            this.X = (Executor) Preconditions.E(executor);
        }

        /* access modifiers changed from: package-private */
        public synchronized void a(Event<L> event, Object obj) {
            this.Y.add(event);
            this.Z.add(obj);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            boolean z;
            synchronized (this) {
                try {
                    if (!this.X2) {
                        z = true;
                        this.X2 = true;
                    } else {
                        z = false;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (z) {
                try {
                    this.X.execute(this);
                } catch (RuntimeException e2) {
                    synchronized (this) {
                        this.X2 = false;
                        Logger a2 = ListenerCallQueue.f23189b;
                        Level level = Level.SEVERE;
                        a2.log(level, "Exception while running callbacks for " + this.s + " on " + this.X, e2);
                        throw e2;
                    }
                }
            }
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        public void run() {
            /*
                r9 = this;
            L_0x0000:
                r0 = 0
                r1 = 1
                monitor-enter(r9)     // Catch:{ all -> 0x002a }
                boolean r2 = r9.X2     // Catch:{ all -> 0x001f }
                com.google.common.base.Preconditions.g0(r2)     // Catch:{ all -> 0x001f }
                java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue$Event<L>> r2 = r9.Y     // Catch:{ all -> 0x001f }
                java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x001f }
                com.google.common.util.concurrent.ListenerCallQueue$Event r2 = (com.google.common.util.concurrent.ListenerCallQueue.Event) r2     // Catch:{ all -> 0x001f }
                java.util.Queue<java.lang.Object> r3 = r9.Z     // Catch:{ all -> 0x001f }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x001f }
                if (r2 != 0) goto L_0x0023
                r9.X2 = r0     // Catch:{ all -> 0x001f }
                monitor-exit(r9)     // Catch:{ all -> 0x001c }
                return
            L_0x001c:
                r1 = move-exception
                r2 = 0
                goto L_0x0052
            L_0x001f:
                r2 = move-exception
                r1 = r2
                r2 = 1
                goto L_0x0052
            L_0x0023:
                monitor-exit(r9)     // Catch:{ all -> 0x001f }
                L r4 = r9.s     // Catch:{ RuntimeException -> 0x002c }
                r2.a(r4)     // Catch:{ RuntimeException -> 0x002c }
                goto L_0x0000
            L_0x002a:
                r2 = move-exception
                goto L_0x005b
            L_0x002c:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.ListenerCallQueue.f23189b     // Catch:{ all -> 0x002a }
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x002a }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                r6.<init>()     // Catch:{ all -> 0x002a }
                java.lang.String r7 = "Exception while executing callback: "
                r6.append(r7)     // Catch:{ all -> 0x002a }
                L r7 = r9.s     // Catch:{ all -> 0x002a }
                r6.append(r7)     // Catch:{ all -> 0x002a }
                java.lang.String r7 = " "
                r6.append(r7)     // Catch:{ all -> 0x002a }
                r6.append(r3)     // Catch:{ all -> 0x002a }
                java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x002a }
                r4.log(r5, r3, r2)     // Catch:{ all -> 0x002a }
                goto L_0x0000
            L_0x0052:
                monitor-exit(r9)     // Catch:{ all -> 0x0059 }
                throw r1     // Catch:{ all -> 0x0054 }
            L_0x0054:
                r1 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
                goto L_0x005b
            L_0x0059:
                r1 = move-exception
                goto L_0x0052
            L_0x005b:
                if (r1 == 0) goto L_0x0065
                monitor-enter(r9)
                r9.X2 = r0     // Catch:{ all -> 0x0062 }
                monitor-exit(r9)     // Catch:{ all -> 0x0062 }
                goto L_0x0065
            L_0x0062:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0062 }
                throw r0
            L_0x0065:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }

    ListenerCallQueue() {
    }

    private void f(Event<L> event, Object obj) {
        Preconditions.F(event, NotificationCompat.I0);
        Preconditions.F(obj, "label");
        synchronized (this.f23190a) {
            try {
                for (PerListenerQueue<L> a2 : this.f23190a) {
                    a2.a(event, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(L l2, Executor executor) {
        Preconditions.F(l2, ServiceSpecificExtraArgs.CastExtraArgs.f20260a);
        Preconditions.F(executor, "executor");
        this.f23190a.add(new PerListenerQueue(l2, executor));
    }

    public void c() {
        for (int i2 = 0; i2 < this.f23190a.size(); i2++) {
            this.f23190a.get(i2).b();
        }
    }

    public void d(Event<L> event) {
        f(event, event);
    }

    public void e(Event<L> event, String str) {
        f(event, str);
    }
}
