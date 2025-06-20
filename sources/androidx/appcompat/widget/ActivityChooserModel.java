package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class ActivityChooserModel extends DataSetObservable {
    private static final Object A = new Object();
    private static final Map<String, ActivityChooserModel> B = new HashMap();

    /* renamed from: n  reason: collision with root package name */
    static final boolean f3004n = false;
    static final String o = "ActivityChooserModel";
    static final String p = "historical-records";
    static final String q = "historical-record";
    static final String r = "activity";
    static final String s = "time";
    static final String t = "weight";
    public static final String u = "activity_choser_model_history.xml";
    public static final int v = 50;
    private static final int w = 5;
    private static final float x = 1.0f;
    private static final String y = ".xml";
    private static final int z = -1;

    /* renamed from: a  reason: collision with root package name */
    private final Object f3005a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final List<ActivityResolveInfo> f3006b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final List<HistoricalRecord> f3007c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    final Context f3008d;

    /* renamed from: e  reason: collision with root package name */
    final String f3009e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f3010f;

    /* renamed from: g  reason: collision with root package name */
    private ActivitySorter f3011g = new DefaultSorter();

    /* renamed from: h  reason: collision with root package name */
    private int f3012h = 50;

    /* renamed from: i  reason: collision with root package name */
    boolean f3013i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3014j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3015k = true;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3016l = false;

    /* renamed from: m  reason: collision with root package name */
    private OnChooseActivityListener f3017m;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public float X;
        public final ResolveInfo s;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.s = resolveInfo;
        }

        /* renamed from: a */
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.X) - Float.floatToIntBits(this.X);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.X) == Float.floatToIntBits(((ActivityResolveInfo) obj).X);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.X) + 31;
        }

        public String toString() {
            return "[" + "resolveInfo:" + this.s.toString() + "; weight:" + new BigDecimal((double) this.X) + "]";
        }
    }

    public interface ActivitySorter {
        void a(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    private static final class DefaultSorter implements ActivitySorter {

        /* renamed from: b  reason: collision with root package name */
        private static final float f3018b = 0.95f;

        /* renamed from: a  reason: collision with root package name */
        private final Map<ComponentName, ActivityResolveInfo> f3019a = new HashMap();

        DefaultSorter() {
        }

        public void a(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            Map<ComponentName, ActivityResolveInfo> map = this.f3019a;
            map.clear();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ActivityResolveInfo activityResolveInfo = list.get(i2);
                activityResolveInfo.X = 0.0f;
                ActivityInfo activityInfo = activityResolveInfo.s.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
            }
            float f2 = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.f3020a);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.X += historicalRecord.f3022c * f2;
                    f2 *= f3018b;
                }
            }
            Collections.sort(list);
        }
    }

    public static final class HistoricalRecord {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f3020a;

        /* renamed from: b  reason: collision with root package name */
        public final long f3021b;

        /* renamed from: c  reason: collision with root package name */
        public final float f3022c;

        public HistoricalRecord(ComponentName componentName, long j2, float f2) {
            this.f3020a = componentName;
            this.f3021b = j2;
            this.f3022c = f2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.f3020a;
            if (componentName == null) {
                if (historicalRecord.f3020a != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.f3020a)) {
                return false;
            }
            return this.f3021b == historicalRecord.f3021b && Float.floatToIntBits(this.f3022c) == Float.floatToIntBits(historicalRecord.f3022c);
        }

        public int hashCode() {
            ComponentName componentName = this.f3020a;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j2 = this.f3021b;
            return ((((hashCode + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Float.floatToIntBits(this.f3022c);
        }

        public String toString() {
            return "[" + "; activity:" + this.f3020a + "; time:" + this.f3021b + "; weight:" + new BigDecimal((double) this.f3022c) + "]";
        }

        public HistoricalRecord(String str, long j2, float f2) {
            this(ComponentName.unflattenFromString(str), j2, f2);
        }
    }

    public interface OnChooseActivityListener {
        boolean a(ActivityChooserModel activityChooserModel, Intent intent);
    }

    private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        PersistHistoryAsyncTask() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
            if (r15 != null) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r15.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0096, code lost:
            if (r15 == null) goto L_0x00d7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b5, code lost:
            if (r15 == null) goto L_0x00d7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d4, code lost:
            if (r15 == null) goto L_0x00d7;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                r14 = this;
                java.lang.String r0 = "historical-record"
                java.lang.String r1 = "historical-records"
                java.lang.String r2 = "Error writing historical record file: "
                r3 = 0
                r4 = r15[r3]
                java.util.List r4 = (java.util.List) r4
                r5 = 1
                r15 = r15[r5]
                java.lang.String r15 = (java.lang.String) r15
                r6 = 0
                androidx.appcompat.widget.ActivityChooserModel r7 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ FileNotFoundException -> 0x00e2 }
                android.content.Context r7 = r7.f3008d     // Catch:{ FileNotFoundException -> 0x00e2 }
                java.io.FileOutputStream r15 = r7.openFileOutput(r15, r3)     // Catch:{ FileNotFoundException -> 0x00e2 }
                org.xmlpull.v1.XmlSerializer r7 = android.util.Xml.newSerializer()
                r7.setOutput(r15, r6)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r8 = "UTF-8"
                java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.startDocument(r8, r9)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.startTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                int r8 = r4.size()     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r9 = 0
            L_0x002f:
                if (r9 >= r8) goto L_0x006a
                java.lang.Object r10 = r4.remove(r3)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord r10 = (androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord) r10     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.startTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r11 = "activity"
                android.content.ComponentName r12 = r10.f3020a     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r12 = r12.flattenToString()     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r11 = "time"
                long r12 = r10.f3021b     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r11 = "weight"
                float r10 = r10.f3022c     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.attribute(r6, r11, r10)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.endTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                int r9 = r9 + 1
                goto L_0x002f
            L_0x0061:
                r0 = move-exception
                goto L_0x00d8
            L_0x0064:
                r0 = move-exception
                goto L_0x007a
            L_0x0066:
                r0 = move-exception
                goto L_0x0099
            L_0x0068:
                r0 = move-exception
                goto L_0x00b8
            L_0x006a:
                r7.endTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.endDocument()     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.f3013i = r5
                if (r15 == 0) goto L_0x00d7
            L_0x0076:
                r15.close()     // Catch:{ IOException -> 0x00d7 }
                goto L_0x00d7
            L_0x007a:
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.o     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r3.<init>()     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r2.f3009e     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0061 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.f3013i = r5
                if (r15 == 0) goto L_0x00d7
                goto L_0x0076
            L_0x0099:
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.o     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r3.<init>()     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r2.f3009e     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0061 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.f3013i = r5
                if (r15 == 0) goto L_0x00d7
                goto L_0x0076
            L_0x00b8:
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.o     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r3.<init>()     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r2.f3009e     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0061 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.f3013i = r5
                if (r15 == 0) goto L_0x00d7
                goto L_0x0076
            L_0x00d7:
                return r6
            L_0x00d8:
                androidx.appcompat.widget.ActivityChooserModel r1 = androidx.appcompat.widget.ActivityChooserModel.this
                r1.f3013i = r5
                if (r15 == 0) goto L_0x00e1
                r15.close()     // Catch:{ IOException -> 0x00e1 }
            L_0x00e1:
                throw r0
            L_0x00e2:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.o
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                r3.append(r15)
                java.lang.String r15 = r3.toString()
                android.util.Log.e(r1, r15, r0)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    private ActivityChooserModel(Context context, String str) {
        this.f3008d = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(y)) {
            this.f3009e = str;
            return;
        }
        this.f3009e = str + y;
    }

    private boolean a(HistoricalRecord historicalRecord) {
        boolean add = this.f3007c.add(historicalRecord);
        if (add) {
            this.f3015k = true;
            n();
            m();
            v();
            notifyChanged();
        }
        return add;
    }

    private void c() {
        boolean l2 = l() | o();
        n();
        if (l2) {
            v();
            notifyChanged();
        }
    }

    public static ActivityChooserModel d(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (A) {
            try {
                Map<String, ActivityChooserModel> map = B;
                activityChooserModel = map.get(str);
                if (activityChooserModel == null) {
                    activityChooserModel = new ActivityChooserModel(context, str);
                    map.put(str, activityChooserModel);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return activityChooserModel;
    }

    private boolean l() {
        if (!this.f3016l || this.f3010f == null) {
            return false;
        }
        this.f3016l = false;
        this.f3006b.clear();
        List<ResolveInfo> queryIntentActivities = this.f3008d.getPackageManager().queryIntentActivities(this.f3010f, 0);
        int size = queryIntentActivities.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f3006b.add(new ActivityResolveInfo(queryIntentActivities.get(i2)));
        }
        return true;
    }

    private void m() {
        if (!this.f3014j) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f3015k) {
            this.f3015k = false;
            if (!TextUtils.isEmpty(this.f3009e)) {
                new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.f3007c), this.f3009e});
            }
        }
    }

    private void n() {
        int size = this.f3007c.size() - this.f3012h;
        if (size > 0) {
            this.f3015k = true;
            for (int i2 = 0; i2 < size; i2++) {
                HistoricalRecord remove = this.f3007c.remove(0);
            }
        }
    }

    private boolean o() {
        if (!this.f3013i || !this.f3015k || TextUtils.isEmpty(this.f3009e)) {
            return false;
        }
        this.f3013i = false;
        this.f3014j = true;
        p();
        return true;
    }

    private void p() {
        try {
            FileInputStream openFileInput = this.f3008d.openFileInput(this.f3009e);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i2 = 0;
                while (i2 != 1 && i2 != 2) {
                    i2 = newPullParser.next();
                }
                if (p.equals(newPullParser.getName())) {
                    List<HistoricalRecord> list = this.f3007c;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput == null) {
                                return;
                            }
                        } else if (!(next == 3 || next == 4)) {
                            if (q.equals(newPullParser.getName())) {
                                list.add(new HistoricalRecord(newPullParser.getAttributeValue((String) null, r), Long.parseLong(newPullParser.getAttributeValue((String) null, "time")), Float.parseFloat(newPullParser.getAttributeValue((String) null, t))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    try {
                        openFileInput.close();
                    } catch (IOException unused) {
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (XmlPullParserException e2) {
                String str = o;
                Log.e(str, "Error reading historical recrod file: " + this.f3009e, e2);
                if (openFileInput == null) {
                }
            } catch (IOException e3) {
                String str2 = o;
                Log.e(str2, "Error reading historical recrod file: " + this.f3009e, e3);
                if (openFileInput == null) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    private boolean v() {
        if (this.f3011g == null || this.f3010f == null || this.f3006b.isEmpty() || this.f3007c.isEmpty()) {
            return false;
        }
        this.f3011g.a(this.f3010f, this.f3006b, Collections.unmodifiableList(this.f3007c));
        return true;
    }

    public Intent b(int i2) {
        synchronized (this.f3005a) {
            try {
                if (this.f3010f == null) {
                    return null;
                }
                c();
                ActivityInfo activityInfo = this.f3006b.get(i2).s.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                Intent intent = new Intent(this.f3010f);
                intent.setComponent(componentName);
                if (this.f3017m != null) {
                    if (this.f3017m.a(this, new Intent(intent))) {
                        return null;
                    }
                }
                a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
                return intent;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResolveInfo e(int i2) {
        ResolveInfo resolveInfo;
        synchronized (this.f3005a) {
            c();
            resolveInfo = this.f3006b.get(i2).s;
        }
        return resolveInfo;
    }

    public int f() {
        int size;
        synchronized (this.f3005a) {
            c();
            size = this.f3006b.size();
        }
        return size;
    }

    public int g(ResolveInfo resolveInfo) {
        synchronized (this.f3005a) {
            try {
                c();
                List<ActivityResolveInfo> list = this.f3006b;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2).s == resolveInfo) {
                        return i2;
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResolveInfo h() {
        synchronized (this.f3005a) {
            try {
                c();
                if (this.f3006b.isEmpty()) {
                    return null;
                }
                ResolveInfo resolveInfo = this.f3006b.get(0).s;
                return resolveInfo;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int i() {
        int i2;
        synchronized (this.f3005a) {
            i2 = this.f3012h;
        }
        return i2;
    }

    public int j() {
        int size;
        synchronized (this.f3005a) {
            c();
            size = this.f3007c.size();
        }
        return size;
    }

    public Intent k() {
        Intent intent;
        synchronized (this.f3005a) {
            intent = this.f3010f;
        }
        return intent;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(androidx.appcompat.widget.ActivityChooserModel.ActivitySorter r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f3005a
            monitor-enter(r0)
            androidx.appcompat.widget.ActivityChooserModel$ActivitySorter r1 = r2.f3011g     // Catch:{ all -> 0x0009 }
            if (r1 != r3) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0009:
            r3 = move-exception
            goto L_0x0018
        L_0x000b:
            r2.f3011g = r3     // Catch:{ all -> 0x0009 }
            boolean r3 = r2.v()     // Catch:{ all -> 0x0009 }
            if (r3 == 0) goto L_0x0016
            r2.notifyChanged()     // Catch:{ all -> 0x0009 }
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.q(androidx.appcompat.widget.ActivityChooserModel$ActivitySorter):void");
    }

    public void r(int i2) {
        synchronized (this.f3005a) {
            try {
                c();
                ActivityResolveInfo activityResolveInfo = this.f3006b.get(i2);
                ActivityResolveInfo activityResolveInfo2 = this.f3006b.get(0);
                float f2 = activityResolveInfo2 != null ? (activityResolveInfo2.X - activityResolveInfo.X) + 5.0f : 1.0f;
                ActivityInfo activityInfo = activityResolveInfo.s.activityInfo;
                a(new HistoricalRecord(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s(int r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f3005a
            monitor-enter(r0)
            int r1 = r2.f3012h     // Catch:{ all -> 0x0009 }
            if (r1 != r3) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0009:
            r3 = move-exception
            goto L_0x001b
        L_0x000b:
            r2.f3012h = r3     // Catch:{ all -> 0x0009 }
            r2.n()     // Catch:{ all -> 0x0009 }
            boolean r3 = r2.v()     // Catch:{ all -> 0x0009 }
            if (r3 == 0) goto L_0x0019
            r2.notifyChanged()     // Catch:{ all -> 0x0009 }
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.s(int):void");
    }

    public void t(Intent intent) {
        synchronized (this.f3005a) {
            try {
                if (this.f3010f != intent) {
                    this.f3010f = intent;
                    this.f3016l = true;
                    c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void u(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.f3005a) {
            this.f3017m = onChooseActivityListener;
        }
    }
}
