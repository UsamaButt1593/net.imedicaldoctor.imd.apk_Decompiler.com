package androidx.media3.exoplayer.offline;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.exoplayer.offline.Downloader;
import androidx.media3.exoplayer.scheduler.Requirements;
import androidx.media3.exoplayer.scheduler.RequirementsWatcher;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

@UnstableApi
public final class DownloadManager {
    private static final int A = 4;
    private static final int B = 5;
    private static final int C = 6;
    private static final int D = 7;
    private static final int E = 8;
    private static final int F = 9;
    private static final int G = 10;
    private static final int H = 11;
    private static final int I = 12;
    private static final String J = "DownloadManager";
    public static final int q = 3;
    public static final int r = 5;
    public static final Requirements s = new Requirements(1);
    private static final int t = 0;
    private static final int u = 1;
    private static final int v = 2;
    private static final int w = 0;
    private static final int x = 1;
    private static final int y = 2;
    private static final int z = 3;

    /* renamed from: a  reason: collision with root package name */
    private final Context f11784a;

    /* renamed from: b  reason: collision with root package name */
    private final WritableDownloadIndex f11785b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f11786c;

    /* renamed from: d  reason: collision with root package name */
    private final InternalHandler f11787d;

    /* renamed from: e  reason: collision with root package name */
    private final RequirementsWatcher.Listener f11788e;

    /* renamed from: f  reason: collision with root package name */
    private final CopyOnWriteArraySet<Listener> f11789f;

    /* renamed from: g  reason: collision with root package name */
    private int f11790g;

    /* renamed from: h  reason: collision with root package name */
    private int f11791h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11792i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11793j;

    /* renamed from: k  reason: collision with root package name */
    private int f11794k;

    /* renamed from: l  reason: collision with root package name */
    private int f11795l;

    /* renamed from: m  reason: collision with root package name */
    private int f11796m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f11797n;
    private List<Download> o;
    private RequirementsWatcher p;

    private static final class DownloadUpdate {

        /* renamed from: a  reason: collision with root package name */
        public final Download f11798a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f11799b;

        /* renamed from: c  reason: collision with root package name */
        public final List<Download> f11800c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final Exception f11801d;

        public DownloadUpdate(Download download, boolean z, List<Download> list, @Nullable Exception exc) {
            this.f11798a = download;
            this.f11799b = z;
            this.f11800c = list;
            this.f11801d = exc;
        }
    }

    private static final class InternalHandler extends Handler {

        /* renamed from: n  reason: collision with root package name */
        private static final int f11802n = 5000;

        /* renamed from: a  reason: collision with root package name */
        public boolean f11803a;

        /* renamed from: b  reason: collision with root package name */
        private final HandlerThread f11804b;

        /* renamed from: c  reason: collision with root package name */
        private final WritableDownloadIndex f11805c;

        /* renamed from: d  reason: collision with root package name */
        private final DownloaderFactory f11806d;

        /* renamed from: e  reason: collision with root package name */
        private final Handler f11807e;

        /* renamed from: f  reason: collision with root package name */
        private final ArrayList<Download> f11808f = new ArrayList<>();

        /* renamed from: g  reason: collision with root package name */
        private final HashMap<String, Task> f11809g = new HashMap<>();

        /* renamed from: h  reason: collision with root package name */
        private int f11810h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f11811i;

        /* renamed from: j  reason: collision with root package name */
        private int f11812j;

        /* renamed from: k  reason: collision with root package name */
        private int f11813k;

        /* renamed from: l  reason: collision with root package name */
        private int f11814l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f11815m;

        public InternalHandler(HandlerThread handlerThread, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory, Handler handler, int i2, int i3, boolean z) {
            super(handlerThread.getLooper());
            this.f11804b = handlerThread;
            this.f11805c = writableDownloadIndex;
            this.f11806d = downloaderFactory;
            this.f11807e = handler;
            this.f11812j = i2;
            this.f11813k = i3;
            this.f11811i = z;
        }

        private void A(@Nullable Task task) {
            if (task != null) {
                Assertions.i(!task.Z);
                task.f(false);
            }
        }

        private void B() {
            int i2 = 0;
            for (int i3 = 0; i3 < this.f11808f.size(); i3++) {
                Download download = this.f11808f.get(i3);
                Task task = this.f11809g.get(download.f11762a.s);
                int i4 = download.f11763b;
                if (i4 == 0) {
                    task = y(task, download);
                } else if (i4 == 1) {
                    A(task);
                } else if (i4 == 2) {
                    Assertions.g(task);
                    x(task, download, i2);
                } else if (i4 == 5 || i4 == 7) {
                    z(task, download);
                } else {
                    throw new IllegalStateException();
                }
                if (task != null && !task.Z) {
                    i2++;
                }
            }
        }

        private void C() {
            for (int i2 = 0; i2 < this.f11808f.size(); i2++) {
                Download download = this.f11808f.get(i2);
                if (download.f11763b == 2) {
                    try {
                        this.f11805c.d(download);
                    } catch (IOException e2) {
                        Log.e(DownloadManager.J, "Failed to update index.", e2);
                    }
                }
            }
            sendEmptyMessageDelayed(11, 5000);
        }

        private void b(DownloadRequest downloadRequest, int i2) {
            Download f2 = f(downloadRequest.s, true);
            long currentTimeMillis = System.currentTimeMillis();
            if (f2 != null) {
                m(DownloadManager.r(f2, downloadRequest, i2, currentTimeMillis));
            } else {
                m(new Download(downloadRequest, i2 != 0 ? 1 : 0, currentTimeMillis, currentTimeMillis, -1, i2, 0));
            }
            B();
        }

        private boolean c() {
            return !this.f11811i && this.f11810h == 0;
        }

        /* access modifiers changed from: private */
        public static int d(Download download, Download download2) {
            return Util.u(download.f11764c, download2.f11764c);
        }

        private static Download e(Download download, int i2, int i3) {
            return new Download(download.f11762a, i2, download.f11764c, System.currentTimeMillis(), download.f11766e, i3, 0, download.f11769h);
        }

        @Nullable
        private Download f(String str, boolean z) {
            int g2 = g(str);
            if (g2 != -1) {
                return this.f11808f.get(g2);
            }
            if (!z) {
                return null;
            }
            try {
                return this.f11805c.f(str);
            } catch (IOException e2) {
                Log.e(DownloadManager.J, "Failed to load download: " + str, e2);
                return null;
            }
        }

        private int g(String str) {
            for (int i2 = 0; i2 < this.f11808f.size(); i2++) {
                if (this.f11808f.get(i2).f11762a.s.equals(str)) {
                    return i2;
                }
            }
            return -1;
        }

        private void h(int i2) {
            this.f11810h = i2;
            DownloadCursor downloadCursor = null;
            try {
                this.f11805c.e();
                downloadCursor = this.f11805c.a(0, 1, 2, 5, 7);
                while (downloadCursor.moveToNext()) {
                    this.f11808f.add(downloadCursor.i2());
                }
            } catch (IOException e2) {
                Log.e(DownloadManager.J, "Failed to load index.", e2);
                this.f11808f.clear();
            } catch (Throwable th) {
                Util.t((Closeable) null);
                throw th;
            }
            Util.t(downloadCursor);
            this.f11807e.obtainMessage(0, new ArrayList(this.f11808f)).sendToTarget();
            B();
        }

        private void i(Task task, long j2) {
            Download download = (Download) Assertions.g(f(task.s.s, false));
            if (j2 != download.f11766e && j2 != -1) {
                m(new Download(download.f11762a, download.f11763b, download.f11764c, System.currentTimeMillis(), j2, download.f11767f, download.f11768g, download.f11769h));
            }
        }

        private void j(Download download, @Nullable Exception exc) {
            Download download2 = download;
            Exception exc2 = exc;
            Download download3 = new Download(download2.f11762a, exc2 == null ? 3 : 4, download2.f11764c, System.currentTimeMillis(), download2.f11766e, download2.f11767f, exc2 == null ? 0 : 1, download2.f11769h);
            this.f11808f.remove(g(download3.f11762a.s));
            try {
                this.f11805c.d(download3);
            } catch (IOException e2) {
                Log.e(DownloadManager.J, "Failed to update index.", e2);
            }
            this.f11807e.obtainMessage(2, new DownloadUpdate(download3, false, new ArrayList(this.f11808f), exc2)).sendToTarget();
        }

        private void k(Download download) {
            int i2 = 1;
            if (download.f11763b == 7) {
                int i3 = download.f11767f;
                if (i3 == 0) {
                    i2 = 0;
                }
                n(download, i2, i3);
                B();
                return;
            }
            this.f11808f.remove(g(download.f11762a.s));
            try {
                this.f11805c.g(download.f11762a.s);
            } catch (IOException unused) {
                Log.d(DownloadManager.J, "Failed to remove from database");
            }
            this.f11807e.obtainMessage(2, new DownloadUpdate(download, true, new ArrayList(this.f11808f), (Exception) null)).sendToTarget();
        }

        private void l(Task task) {
            String str = task.s.s;
            this.f11809g.remove(str);
            boolean b2 = task.Z;
            if (b2) {
                this.f11815m = false;
            } else {
                int i2 = this.f11814l - 1;
                this.f11814l = i2;
                if (i2 == 0) {
                    removeMessages(11);
                }
            }
            if (task.Z2) {
                B();
                return;
            }
            Exception e2 = task.a3;
            if (e2 != null) {
                Log.e(DownloadManager.J, "Task failed: " + task.s + ", " + b2, e2);
            }
            Download download = (Download) Assertions.g(f(str, false));
            int i3 = download.f11763b;
            if (i3 == 2) {
                Assertions.i(!b2);
                j(download, e2);
            } else if (i3 == 5 || i3 == 7) {
                Assertions.i(b2);
                k(download);
            } else {
                throw new IllegalStateException();
            }
            B();
        }

        private Download m(Download download) {
            ArrayList<Download> arrayList;
            Comparator comparator;
            int i2 = download.f11763b;
            boolean z = true;
            Assertions.i((i2 == 3 || i2 == 4) ? false : true);
            int g2 = g(download.f11762a.s);
            if (g2 == -1) {
                this.f11808f.add(download);
                arrayList = this.f11808f;
                new l
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: CONSTRUCTOR  (r1v12 ? I:androidx.media3.exoplayer.offline.l) =  call: androidx.media3.exoplayer.offline.l.<init>():void type: CONSTRUCTOR in method: androidx.media3.exoplayer.offline.DownloadManager.InternalHandler.m(androidx.media3.exoplayer.offline.Download):androidx.media3.exoplayer.offline.Download, dex: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v12 ?
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 49 more
                    */
                /*
                    this = this;
                    int r0 = r9.f11763b
                    r1 = 3
                    r2 = 1
                    r3 = 0
                    if (r0 == r1) goto L_0x000c
                    r1 = 4
                    if (r0 == r1) goto L_0x000c
                    r0 = 1
                    goto L_0x000d
                L_0x000c:
                    r0 = 0
                L_0x000d:
                    androidx.media3.common.util.Assertions.i(r0)
                    androidx.media3.exoplayer.offline.DownloadRequest r0 = r9.f11762a
                    java.lang.String r0 = r0.s
                    int r0 = r8.g(r0)
                    r1 = -1
                    if (r0 != r1) goto L_0x002b
                    java.util.ArrayList<androidx.media3.exoplayer.offline.Download> r0 = r8.f11808f
                    r0.add(r9)
                    java.util.ArrayList<androidx.media3.exoplayer.offline.Download> r0 = r8.f11808f
                    androidx.media3.exoplayer.offline.l r1 = new androidx.media3.exoplayer.offline.l
                    r1.<init>()
                L_0x0027:
                    java.util.Collections.sort(r0, r1)
                    goto L_0x004c
                L_0x002b:
                    long r4 = r9.f11764c
                    java.util.ArrayList<androidx.media3.exoplayer.offline.Download> r1 = r8.f11808f
                    java.lang.Object r1 = r1.get(r0)
                    androidx.media3.exoplayer.offline.Download r1 = (androidx.media3.exoplayer.offline.Download) r1
                    long r6 = r1.f11764c
                    int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r1 == 0) goto L_0x003c
                    goto L_0x003d
                L_0x003c:
                    r2 = 0
                L_0x003d:
                    java.util.ArrayList<androidx.media3.exoplayer.offline.Download> r1 = r8.f11808f
                    r1.set(r0, r9)
                    if (r2 == 0) goto L_0x004c
                    java.util.ArrayList<androidx.media3.exoplayer.offline.Download> r0 = r8.f11808f
                    androidx.media3.exoplayer.offline.l r1 = new androidx.media3.exoplayer.offline.l
                    r1.<init>()
                    goto L_0x0027
                L_0x004c:
                    androidx.media3.exoplayer.offline.WritableDownloadIndex r0 = r8.f11805c     // Catch:{ IOException -> 0x0052 }
                    r0.d(r9)     // Catch:{ IOException -> 0x0052 }
                    goto L_0x005a
                L_0x0052:
                    r0 = move-exception
                    java.lang.String r1 = "DownloadManager"
                    java.lang.String r2 = "Failed to update index."
                    androidx.media3.common.util.Log.e(r1, r2, r0)
                L_0x005a:
                    androidx.media3.exoplayer.offline.DownloadManager$DownloadUpdate r0 = new androidx.media3.exoplayer.offline.DownloadManager$DownloadUpdate
                    java.util.ArrayList r1 = new java.util.ArrayList
                    java.util.ArrayList<androidx.media3.exoplayer.offline.Download> r2 = r8.f11808f
                    r1.<init>(r2)
                    r2 = 0
                    r0.<init>(r9, r3, r1, r2)
                    android.os.Handler r1 = r8.f11807e
                    r2 = 2
                    android.os.Message r0 = r1.obtainMessage(r2, r0)
                    r0.sendToTarget()
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.offline.DownloadManager.InternalHandler.m(androidx.media3.exoplayer.offline.Download):androidx.media3.exoplayer.offline.Download");
            }

            private Download n(Download download, int i2, int i3) {
                Assertions.i((i2 == 3 || i2 == 4) ? false : true);
                return m(e(download, i2, i3));
            }

            private void o() {
                for (Task f2 : this.f11809g.values()) {
                    f2.f(true);
                }
                try {
                    this.f11805c.e();
                } catch (IOException e2) {
                    Log.e(DownloadManager.J, "Failed to update index.", e2);
                }
                this.f11808f.clear();
                this.f11804b.quit();
                synchronized (this) {
                    this.f11803a = true;
                    notifyAll();
                }
            }

            private void p() {
                DownloadCursor a2;
                ArrayList arrayList = new ArrayList();
                try {
                    a2 = this.f11805c.a(3, 4);
                    while (a2.moveToNext()) {
                        arrayList.add(a2.i2());
                    }
                    a2.close();
                } catch (IOException unused) {
                    Log.d(DownloadManager.J, "Failed to load downloads.");
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
                for (int i2 = 0; i2 < this.f11808f.size(); i2++) {
                    ArrayList<Download> arrayList2 = this.f11808f;
                    arrayList2.set(i2, e(arrayList2.get(i2), 5, 0));
                }
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    this.f11808f.add(e((Download) arrayList.get(i3), 5, 0));
                }
                Collections.sort(this.f11808f, new l());
                try {
                    this.f11805c.b();
                } catch (IOException e2) {
                    Log.e(DownloadManager.J, "Failed to update index.", e2);
                }
                ArrayList arrayList3 = new ArrayList(this.f11808f);
                for (int i4 = 0; i4 < this.f11808f.size(); i4++) {
                    this.f11807e.obtainMessage(2, new DownloadUpdate(this.f11808f.get(i4), false, arrayList3, (Exception) null)).sendToTarget();
                }
                B();
                return;
                throw th;
            }

            private void q(String str) {
                Download f2 = f(str, true);
                if (f2 == null) {
                    Log.d(DownloadManager.J, "Failed to remove nonexistent download: " + str);
                    return;
                }
                n(f2, 5, 0);
                B();
            }

            private void r(boolean z) {
                this.f11811i = z;
                B();
            }

            private void s(int i2) {
                this.f11812j = i2;
                B();
            }

            private void t(int i2) {
                this.f11813k = i2;
            }

            private void u(int i2) {
                this.f11810h = i2;
                B();
            }

            private void v(Download download, int i2) {
                Download download2 = download;
                int i3 = i2;
                if (i3 == 0) {
                    if (download2.f11763b == 1) {
                        n(download, 0, 0);
                    }
                } else if (i3 != download2.f11767f) {
                    int i4 = download2.f11763b;
                    if (i4 == 0 || i4 == 2) {
                        i4 = 1;
                    }
                    m(new Download(download2.f11762a, i4, download2.f11764c, System.currentTimeMillis(), download2.f11766e, i2, 0, download2.f11769h));
                }
            }

            private void w(@Nullable String str, int i2) {
                if (str == null) {
                    for (int i3 = 0; i3 < this.f11808f.size(); i3++) {
                        v(this.f11808f.get(i3), i2);
                    }
                    try {
                        this.f11805c.h(i2);
                    } catch (IOException e2) {
                        Log.e(DownloadManager.J, "Failed to set manual stop reason", e2);
                    }
                } else {
                    Download f2 = f(str, false);
                    if (f2 != null) {
                        v(f2, i2);
                    } else {
                        try {
                            this.f11805c.c(str, i2);
                        } catch (IOException e3) {
                            Log.e(DownloadManager.J, "Failed to set manual stop reason: " + str, e3);
                        }
                    }
                }
                B();
            }

            private void x(Task task, Download download, int i2) {
                Assertions.i(!task.Z);
                if (!c() || i2 >= this.f11812j) {
                    n(download, 0, 0);
                    task.f(false);
                }
            }

            @CheckResult
            @Nullable
            private Task y(@Nullable Task task, Download download) {
                if (task != null) {
                    Assertions.i(!task.Z);
                    task.f(false);
                    return task;
                } else if (!c() || this.f11814l >= this.f11812j) {
                    return null;
                } else {
                    Download n2 = n(download, 2, 0);
                    Task task2 = new Task(n2.f11762a, this.f11806d.a(n2.f11762a), n2.f11769h, false, this.f11813k, this);
                    this.f11809g.put(n2.f11762a.s, task2);
                    int i2 = this.f11814l;
                    this.f11814l = i2 + 1;
                    if (i2 == 0) {
                        sendEmptyMessageDelayed(11, 5000);
                    }
                    task2.start();
                    return task2;
                }
            }

            private void z(@Nullable Task task, Download download) {
                if (task != null) {
                    if (!task.Z) {
                        task.f(false);
                    }
                } else if (!this.f11815m) {
                    Task task2 = new Task(download.f11762a, this.f11806d.a(download.f11762a), download.f11769h, true, this.f11813k, this);
                    this.f11809g.put(download.f11762a.s, task2);
                    this.f11815m = true;
                    task2.start();
                }
            }

            public void handleMessage(Message message) {
                boolean z = false;
                switch (message.what) {
                    case 0:
                        h(message.arg1);
                        break;
                    case 1:
                        if (message.arg1 != 0) {
                            z = true;
                        }
                        r(z);
                        break;
                    case 2:
                        u(message.arg1);
                        break;
                    case 3:
                        w((String) message.obj, message.arg1);
                        break;
                    case 4:
                        s(message.arg1);
                        break;
                    case 5:
                        t(message.arg1);
                        break;
                    case 6:
                        b((DownloadRequest) message.obj, message.arg1);
                        break;
                    case 7:
                        q((String) message.obj);
                        break;
                    case 8:
                        p();
                        break;
                    case 9:
                        l((Task) message.obj);
                        break;
                    case 10:
                        i((Task) message.obj, Util.D2(message.arg1, message.arg2));
                        return;
                    case 11:
                        C();
                        return;
                    case 12:
                        o();
                        return;
                    default:
                        throw new IllegalStateException();
                }
                z = true;
                this.f11807e.obtainMessage(1, z ? 1 : 0, this.f11809g.size()).sendToTarget();
            }
        }

        public interface Listener {
            void a(DownloadManager downloadManager, boolean z);

            void b(DownloadManager downloadManager, Download download);

            void c(DownloadManager downloadManager);

            void d(DownloadManager downloadManager, Requirements requirements, int i2);

            void e(DownloadManager downloadManager, Download download, @Nullable Exception exc);

            void f(DownloadManager downloadManager, boolean z);

            void g(DownloadManager downloadManager);
        }

        private static class Task extends Thread implements Downloader.ProgressListener {
            private final Downloader X;
            private final int X2;
            private final DownloadProgress Y;
            @Nullable
            private volatile InternalHandler Y2;
            /* access modifiers changed from: private */
            public final boolean Z;
            /* access modifiers changed from: private */
            public volatile boolean Z2;
            /* access modifiers changed from: private */
            @Nullable
            public Exception a3;
            private long b3;
            /* access modifiers changed from: private */
            public final DownloadRequest s;

            private Task(DownloadRequest downloadRequest, Downloader downloader, DownloadProgress downloadProgress, boolean z, int i2, InternalHandler internalHandler) {
                this.s = downloadRequest;
                this.X = downloader;
                this.Y = downloadProgress;
                this.Z = z;
                this.X2 = i2;
                this.Y2 = internalHandler;
                this.b3 = -1;
            }

            private static int g(int i2) {
                return Math.min((i2 - 1) * 1000, 5000);
            }

            public void a(long j2, long j3, float f2) {
                this.Y.f11818a = j3;
                this.Y.f11819b = f2;
                if (j2 != this.b3) {
                    this.b3 = j2;
                    InternalHandler internalHandler = this.Y2;
                    if (internalHandler != null) {
                        internalHandler.obtainMessage(10, (int) (j2 >> 32), (int) j2, this).sendToTarget();
                    }
                }
            }

            public void f(boolean z) {
                if (z) {
                    this.Y2 = null;
                }
                if (!this.Z2) {
                    this.Z2 = true;
                    this.X.cancel();
                    interrupt();
                }
            }

            public void run() {
                long j2;
                int i2;
                try {
                    if (this.Z) {
                        this.X.remove();
                    } else {
                        j2 = -1;
                        i2 = 0;
                        while (!this.Z2) {
                            this.X.a(this);
                        }
                    }
                } catch (IOException e2) {
                    if (!this.Z2) {
                        long j3 = this.Y.f11818a;
                        if (j3 != j2) {
                            j2 = j3;
                            i2 = 0;
                        }
                        i2++;
                        if (i2 <= this.X2) {
                            Thread.sleep((long) g(i2));
                        } else {
                            throw e2;
                        }
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                } catch (Exception e3) {
                    this.a3 = e3;
                }
                InternalHandler internalHandler = this.Y2;
                if (internalHandler != null) {
                    internalHandler.obtainMessage(9, this).sendToTarget();
                }
            }
        }

        public DownloadManager(Context context, DatabaseProvider databaseProvider, Cache cache, DataSource.Factory factory, Executor executor) {
            this(context, new DefaultDownloadIndex(databaseProvider), new DefaultDownloaderFactory(new CacheDataSource.Factory().j(cache).p(factory), executor));
        }

        private void D(boolean z2) {
            if (this.f11793j != z2) {
                this.f11793j = z2;
                this.f11790g++;
                this.f11787d.obtainMessage(1, z2 ? 1 : 0, 0).sendToTarget();
                boolean I2 = I();
                Iterator<Listener> it2 = this.f11789f.iterator();
                while (it2.hasNext()) {
                    it2.next().f(this, z2);
                }
                if (I2) {
                    s();
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean I() {
            /*
                r4 = this;
                boolean r0 = r4.f11793j
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L_0x0024
                int r0 = r4.f11796m
                if (r0 == 0) goto L_0x0024
                r0 = 0
            L_0x000b:
                java.util.List<androidx.media3.exoplayer.offline.Download> r3 = r4.o
                int r3 = r3.size()
                if (r0 >= r3) goto L_0x0024
                java.util.List<androidx.media3.exoplayer.offline.Download> r3 = r4.o
                java.lang.Object r3 = r3.get(r0)
                androidx.media3.exoplayer.offline.Download r3 = (androidx.media3.exoplayer.offline.Download) r3
                int r3 = r3.f11763b
                if (r3 != 0) goto L_0x0021
                r0 = 1
                goto L_0x0025
            L_0x0021:
                int r0 = r0 + 1
                goto L_0x000b
            L_0x0024:
                r0 = 0
            L_0x0025:
                boolean r3 = r4.f11797n
                if (r3 == r0) goto L_0x002a
                goto L_0x002b
            L_0x002a:
                r1 = 0
            L_0x002b:
                r4.f11797n = r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.offline.DownloadManager.I():boolean");
        }

        /* access modifiers changed from: private */
        public boolean n(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                u((List) message.obj);
            } else if (i2 == 1) {
                v(message.arg1, message.arg2);
            } else if (i2 == 2) {
                t((DownloadUpdate) message.obj);
            } else {
                throw new IllegalStateException();
            }
            return true;
        }

        static Download r(Download download, DownloadRequest downloadRequest, int i2, long j2) {
            Download download2 = download;
            int i3 = download2.f11763b;
            return new Download(download2.f11762a.c(downloadRequest), (i3 == 5 || i3 == 7) ? 7 : i2 != 0 ? 1 : 0, (i3 == 5 || download.c()) ? j2 : download2.f11764c, j2, -1, i2, 0);
        }

        private void s() {
            Iterator<Listener> it2 = this.f11789f.iterator();
            while (it2.hasNext()) {
                it2.next().a(this, this.f11797n);
            }
        }

        private void t(DownloadUpdate downloadUpdate) {
            this.o = Collections.unmodifiableList(downloadUpdate.f11800c);
            Download download = downloadUpdate.f11798a;
            boolean I2 = I();
            if (downloadUpdate.f11799b) {
                Iterator<Listener> it2 = this.f11789f.iterator();
                while (it2.hasNext()) {
                    it2.next().b(this, download);
                }
            } else {
                Iterator<Listener> it3 = this.f11789f.iterator();
                while (it3.hasNext()) {
                    it3.next().e(this, download, downloadUpdate.f11801d);
                }
            }
            if (I2) {
                s();
            }
        }

        private void u(List<Download> list) {
            this.f11792i = true;
            this.o = Collections.unmodifiableList(list);
            boolean I2 = I();
            Iterator<Listener> it2 = this.f11789f.iterator();
            while (it2.hasNext()) {
                it2.next().g(this);
            }
            if (I2) {
                s();
            }
        }

        private void v(int i2, int i3) {
            this.f11790g -= i2;
            this.f11791h = i3;
            if (o()) {
                Iterator<Listener> it2 = this.f11789f.iterator();
                while (it2.hasNext()) {
                    it2.next().c(this);
                }
            }
        }

        /* access modifiers changed from: private */
        public void w(RequirementsWatcher requirementsWatcher, int i2) {
            Requirements f2 = requirementsWatcher.f();
            if (this.f11796m != i2) {
                this.f11796m = i2;
                this.f11790g++;
                this.f11787d.obtainMessage(2, i2, 0).sendToTarget();
            }
            boolean I2 = I();
            Iterator<Listener> it2 = this.f11789f.iterator();
            while (it2.hasNext()) {
                it2.next().d(this, f2, i2);
            }
            if (I2) {
                s();
            }
        }

        public void A(String str) {
            this.f11790g++;
            this.f11787d.obtainMessage(7, str).sendToTarget();
        }

        public void B(Listener listener) {
            this.f11789f.remove(listener);
        }

        public void C() {
            D(false);
        }

        public void E(@IntRange(from = 1) int i2) {
            Assertions.a(i2 > 0);
            if (this.f11794k != i2) {
                this.f11794k = i2;
                this.f11790g++;
                this.f11787d.obtainMessage(4, i2, 0).sendToTarget();
            }
        }

        public void F(int i2) {
            Assertions.a(i2 >= 0);
            if (this.f11795l != i2) {
                this.f11795l = i2;
                this.f11790g++;
                this.f11787d.obtainMessage(5, i2, 0).sendToTarget();
            }
        }

        public void G(Requirements requirements) {
            if (!requirements.equals(this.p.f())) {
                this.p.j();
                RequirementsWatcher requirementsWatcher = new RequirementsWatcher(this.f11784a, this.f11788e, requirements);
                this.p = requirementsWatcher;
                w(this.p, requirementsWatcher.i());
            }
        }

        public void H(@Nullable String str, int i2) {
            this.f11790g++;
            this.f11787d.obtainMessage(3, i2, 0, str).sendToTarget();
        }

        public void c(DownloadRequest downloadRequest) {
            d(downloadRequest, 0);
        }

        public void d(DownloadRequest downloadRequest, int i2) {
            this.f11790g++;
            this.f11787d.obtainMessage(6, i2, 0, downloadRequest).sendToTarget();
        }

        public void e(Listener listener) {
            Assertions.g(listener);
            this.f11789f.add(listener);
        }

        public Looper f() {
            return this.f11786c.getLooper();
        }

        public List<Download> g() {
            return this.o;
        }

        public DownloadIndex h() {
            return this.f11785b;
        }

        public boolean i() {
            return this.f11793j;
        }

        public int j() {
            return this.f11794k;
        }

        public int k() {
            return this.f11795l;
        }

        public int l() {
            return this.f11796m;
        }

        public Requirements m() {
            return this.p.f();
        }

        public boolean o() {
            return this.f11791h == 0 && this.f11790g == 0;
        }

        public boolean p() {
            return this.f11792i;
        }

        public boolean q() {
            return this.f11797n;
        }

        public void x() {
            D(true);
        }

        public void y() {
            synchronized (this.f11787d) {
                try {
                    InternalHandler internalHandler = this.f11787d;
                    if (!internalHandler.f11803a) {
                        internalHandler.sendEmptyMessage(12);
                        boolean z2 = false;
                        while (true) {
                            InternalHandler internalHandler2 = this.f11787d;
                            if (internalHandler2.f11803a) {
                                break;
                            }
                            try {
                                internalHandler2.wait();
                            } catch (InterruptedException unused) {
                                z2 = true;
                            }
                        }
                        if (z2) {
                            Thread.currentThread().interrupt();
                        }
                        this.f11786c.removeCallbacksAndMessages((Object) null);
                        this.p.j();
                        this.o = Collections.emptyList();
                        this.f11790g = 0;
                        this.f11791h = 0;
                        this.f11792i = false;
                        this.f11796m = 0;
                        this.f11797n = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void z() {
            this.f11790g++;
            this.f11787d.obtainMessage(8).sendToTarget();
        }

        public DownloadManager(Context context, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory) {
            this.f11784a = context.getApplicationContext();
            this.f11785b = writableDownloadIndex;
            this.f11794k = 3;
            this.f11795l = 5;
            this.f11793j = true;
            this.o = Collections.emptyList();
            this.f11789f = new CopyOnWriteArraySet<>();
            Handler K = Util.K(new j(this));
            this.f11786c = K;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
            handlerThread.start();
            InternalHandler internalHandler = new InternalHandler(handlerThread, writableDownloadIndex, downloaderFactory, K, this.f11794k, this.f11795l, this.f11793j);
            this.f11787d = internalHandler;
            k kVar = new k(this);
            this.f11788e = kVar;
            RequirementsWatcher requirementsWatcher = new RequirementsWatcher(context, kVar, s);
            this.p = requirementsWatcher;
            int i2 = requirementsWatcher.i();
            this.f11796m = i2;
            this.f11790g = 1;
            internalHandler.obtainMessage(0, i2, 0).sendToTarget();
        }
    }
