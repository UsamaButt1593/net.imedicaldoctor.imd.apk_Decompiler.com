package com.google.firebase.crashlytics.internal.metadata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MetaDataStore {

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f23716b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    private static final String f23717c = "userId";

    /* renamed from: a  reason: collision with root package name */
    private final FileStore f23718a;

    public MetaDataStore(FileStore fileStore) {
        this.f23718a = fileStore;
    }

    private static Map<String, String> e(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, p(jSONObject, next));
        }
        return hashMap;
    }

    private static List<RolloutAssignment> f(String str) throws JSONException {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("rolloutsState");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String string = jSONArray.getString(i2);
            try {
                arrayList.add(RolloutAssignment.a(string));
            } catch (Exception e2) {
                Logger f2 = Logger.f();
                f2.n("Failed de-serializing rollouts state. " + string, e2);
            }
        }
        return arrayList;
    }

    @Nullable
    private String g(String str) throws JSONException {
        return p(new JSONObject(str), f23717c);
    }

    private static String h(Map<String, String> map) {
        return new JSONObject(map).toString();
    }

    private static String m(List<RolloutAssignment> list) {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                jSONArray.put(new JSONObject(RolloutAssignment.f23737b.encode(list.get(i2))));
            } catch (JSONException e2) {
                Logger.f().n("Exception parsing rollout assignment!", e2);
            }
        }
        hashMap.put("rolloutsState", jSONArray);
        return new JSONObject(hashMap).toString();
    }

    private static void n(File file) {
        if (file.exists() && file.delete()) {
            Logger f2 = Logger.f();
            f2.g("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    private static String o(String str) throws JSONException {
        return new JSONObject(str) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f23719a;

            {
                this.f23719a = r2;
                put(MetaDataStore.f23717c, r2);
            }
        }.toString();
    }

    private static String p(JSONObject jSONObject, String str) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.optString(str, (String) null);
        }
        return null;
    }

    @NonNull
    public File a(String str) {
        return this.f23718a.r(str, UserMetadata.f23743j);
    }

    @NonNull
    public File b(String str) {
        return this.f23718a.r(str, UserMetadata.f23742i);
    }

    @NonNull
    public File c(String str) {
        return this.f23718a.r(str, UserMetadata.f23744k);
    }

    @NonNull
    public File d(String str) {
        return this.f23718a.r(str, UserMetadata.f23741h);
    }

    public Map<String, String> i(String str) {
        return j(str, false);
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> j(String str, boolean z) {
        Exception e2;
        FileInputStream fileInputStream;
        File a2 = z ? a(str) : b(str);
        if (!a2.exists() || a2.length() == 0) {
            n(a2);
            return Collections.emptyMap();
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(a2);
            try {
                Map<String, String> e3 = e(CommonUtils.D(fileInputStream));
                CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
                return e3;
            } catch (Exception e4) {
                e2 = e4;
                try {
                    Logger.f().n("Error deserializing user metadata.", e2);
                    n(a2);
                    CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    CommonUtils.f(fileInputStream2, "Failed to close user metadata file.");
                    throw th;
                }
            }
        } catch (Exception e5) {
            Exception exc = e5;
            fileInputStream = null;
            e2 = exc;
            Logger.f().n("Error deserializing user metadata.", e2);
            n(a2);
            CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
            return Collections.emptyMap();
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.f(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public List<RolloutAssignment> k(String str) {
        File c2 = c(str);
        if (!c2.exists() || c2.length() == 0) {
            n(c2);
            return Collections.emptyList();
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(c2);
            try {
                List<RolloutAssignment> f2 = f(CommonUtils.D(fileInputStream2));
                Logger f3 = Logger.f();
                f3.b("Loaded rollouts state:\n" + f2 + "\nfor session " + str);
                CommonUtils.f(fileInputStream2, "Failed to close rollouts state file.");
                return f2;
            } catch (Exception e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                try {
                    Logger.f().n("Error deserializing rollouts state.", e);
                    n(c2);
                    CommonUtils.f(fileInputStream, "Failed to close rollouts state file.");
                    return Collections.emptyList();
                } catch (Throwable th) {
                    th = th;
                    CommonUtils.f(fileInputStream, "Failed to close rollouts state file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                CommonUtils.f(fileInputStream, "Failed to close rollouts state file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            Logger.f().n("Error deserializing rollouts state.", e);
            n(c2);
            CommonUtils.f(fileInputStream, "Failed to close rollouts state file.");
            return Collections.emptyList();
        }
    }

    @Nullable
    public String l(String str) {
        FileInputStream fileInputStream;
        File d2 = d(str);
        FileInputStream fileInputStream2 = null;
        if (!d2.exists() || d2.length() == 0) {
            Logger.f().b("No userId set for session " + str);
            n(d2);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(d2);
            try {
                String g2 = g(CommonUtils.D(fileInputStream));
                Logger.f().b("Loaded userId " + g2 + " for session " + str);
                CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
                return g2;
            } catch (Exception e2) {
                e = e2;
                try {
                    Logger.f().n("Error deserializing user metadata.", e);
                    n(d2);
                    CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    CommonUtils.f(fileInputStream2, "Failed to close user metadata file.");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            Logger.f().n("Error deserializing user metadata.", e);
            n(d2);
            CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
            return null;
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.f(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void q(String str, Map<String, String> map) {
        r(str, map, false);
    }

    public void r(String str, Map<String, String> map, boolean z) {
        File a2 = z ? a(str) : b(str);
        BufferedWriter bufferedWriter = null;
        try {
            String h2 = h(map);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(a2), f23716b));
            try {
                bufferedWriter2.write(h2);
                bufferedWriter2.flush();
                CommonUtils.f(bufferedWriter2, "Failed to close key/value metadata file.");
            } catch (Exception e2) {
                e = e2;
                bufferedWriter = bufferedWriter2;
                try {
                    Logger.f().n("Error serializing key/value metadata.", e);
                    n(a2);
                    CommonUtils.f(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    th = th;
                    CommonUtils.f(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                CommonUtils.f(bufferedWriter, "Failed to close key/value metadata file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            Logger.f().n("Error serializing key/value metadata.", e);
            n(a2);
            CommonUtils.f(bufferedWriter, "Failed to close key/value metadata file.");
        }
    }

    public void s(String str, List<RolloutAssignment> list) {
        File c2 = c(str);
        if (list.isEmpty()) {
            n(c2);
            return;
        }
        BufferedWriter bufferedWriter = null;
        try {
            String m2 = m(list);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c2), f23716b));
            try {
                bufferedWriter2.write(m2);
                bufferedWriter2.flush();
                CommonUtils.f(bufferedWriter2, "Failed to close rollouts state file.");
            } catch (Exception e2) {
                e = e2;
                bufferedWriter = bufferedWriter2;
                try {
                    Logger.f().n("Error serializing rollouts state.", e);
                    n(c2);
                    CommonUtils.f(bufferedWriter, "Failed to close rollouts state file.");
                } catch (Throwable th) {
                    th = th;
                    CommonUtils.f(bufferedWriter, "Failed to close rollouts state file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                CommonUtils.f(bufferedWriter, "Failed to close rollouts state file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            Logger.f().n("Error serializing rollouts state.", e);
            n(c2);
            CommonUtils.f(bufferedWriter, "Failed to close rollouts state file.");
        }
    }

    public void t(String str, String str2) {
        File d2 = d(str);
        BufferedWriter bufferedWriter = null;
        try {
            String o = o(str2);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d2), f23716b));
            try {
                bufferedWriter2.write(o);
                bufferedWriter2.flush();
                CommonUtils.f(bufferedWriter2, "Failed to close user metadata file.");
            } catch (Exception e2) {
                e = e2;
                bufferedWriter = bufferedWriter2;
                try {
                    Logger.f().n("Error serializing user metadata.", e);
                    CommonUtils.f(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    th = th;
                    CommonUtils.f(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                CommonUtils.f(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            Logger.f().n("Error serializing user metadata.", e);
            CommonUtils.f(bufferedWriter, "Failed to close user metadata file.");
        }
    }
}
