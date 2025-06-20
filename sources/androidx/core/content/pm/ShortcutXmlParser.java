package androidx.core.content.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ShortcutXmlParser {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5735a = "ShortcutXmlParser";

    /* renamed from: b  reason: collision with root package name */
    private static final String f5736b = "android.app.shortcuts";

    /* renamed from: c  reason: collision with root package name */
    private static final String f5737c = "shortcut";

    /* renamed from: d  reason: collision with root package name */
    private static final String f5738d = "shortcutId";

    /* renamed from: e  reason: collision with root package name */
    private static volatile ArrayList<String> f5739e;

    /* renamed from: f  reason: collision with root package name */
    private static final Object f5740f = new Object();

    private ShortcutXmlParser() {
    }

    private static String a(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str);
        return attributeValue == null ? xmlPullParser.getAttributeValue((String) null, str) : attributeValue;
    }

    @WorkerThread
    @NonNull
    public static List<String> b(@NonNull Context context) {
        if (f5739e == null) {
            synchronized (f5740f) {
                try {
                    if (f5739e == null) {
                        f5739e = new ArrayList<>();
                        f5739e.addAll(e(context));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5739e;
    }

    @NonNull
    private static XmlResourceParser c(Context context, ActivityInfo activityInfo) {
        XmlResourceParser loadXmlMetaData = activityInfo.loadXmlMetaData(context.getPackageManager(), f5736b);
        if (loadXmlMetaData != null) {
            return loadXmlMetaData;
        }
        throw new IllegalArgumentException("Failed to open android.app.shortcuts meta-data resource of " + activityInfo.name);
    }

    @VisibleForTesting
    @NonNull
    public static List<String> d(@NonNull XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String a2;
        ArrayList arrayList = new ArrayList(1);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= 0)) {
                return arrayList;
            }
            int depth = xmlPullParser.getDepth();
            String name = xmlPullParser.getName();
            if (next == 2 && depth == 2 && f5737c.equals(name) && (a2 = a(xmlPullParser, f5738d)) != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    @NonNull
    private static Set<String> e(@NonNull Context context) {
        XmlResourceParser c2;
        HashSet hashSet = new HashSet();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 128);
        if (!(queryIntentActivities == null || queryIntentActivities.size() == 0)) {
            try {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    Bundle bundle = activityInfo.metaData;
                    if (bundle != null && bundle.containsKey(f5736b)) {
                        c2 = c(context, activityInfo);
                        hashSet.addAll(d(c2));
                        if (c2 != null) {
                            c2.close();
                        }
                    }
                }
            } catch (Exception e2) {
                Log.e(f5735a, "Failed to parse the Xml resource: ", e2);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        return hashSet;
        throw th;
    }
}
