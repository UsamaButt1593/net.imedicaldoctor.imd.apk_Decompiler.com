package androidx.media3.extractor.flv;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.DummyTrackOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ScriptTagPayloadReader extends TagPayloadReader {

    /* renamed from: e  reason: collision with root package name */
    private static final String f13286e = "onMetaData";

    /* renamed from: f  reason: collision with root package name */
    private static final String f13287f = "duration";

    /* renamed from: g  reason: collision with root package name */
    private static final String f13288g = "keyframes";

    /* renamed from: h  reason: collision with root package name */
    private static final String f13289h = "filepositions";

    /* renamed from: i  reason: collision with root package name */
    private static final String f13290i = "times";

    /* renamed from: j  reason: collision with root package name */
    private static final int f13291j = 0;

    /* renamed from: k  reason: collision with root package name */
    private static final int f13292k = 1;

    /* renamed from: l  reason: collision with root package name */
    private static final int f13293l = 2;

    /* renamed from: m  reason: collision with root package name */
    private static final int f13294m = 3;

    /* renamed from: n  reason: collision with root package name */
    private static final int f13295n = 8;
    private static final int o = 9;
    private static final int p = 10;
    private static final int q = 11;

    /* renamed from: b  reason: collision with root package name */
    private long f13296b = C.f9084b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f13297c = new long[0];

    /* renamed from: d  reason: collision with root package name */
    private long[] f13298d = new long[0];

    public ScriptTagPayloadReader() {
        super(new DummyTrackOutput());
    }

    private static Boolean h(ParsableByteArray parsableByteArray) {
        boolean z = true;
        if (parsableByteArray.L() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    @Nullable
    private static Object i(ParsableByteArray parsableByteArray, int i2) {
        if (i2 == 0) {
            return k(parsableByteArray);
        }
        if (i2 == 1) {
            return h(parsableByteArray);
        }
        if (i2 == 2) {
            return o(parsableByteArray);
        }
        if (i2 == 3) {
            return m(parsableByteArray);
        }
        if (i2 == 8) {
            return l(parsableByteArray);
        }
        if (i2 == 10) {
            return n(parsableByteArray);
        }
        if (i2 != 11) {
            return null;
        }
        return j(parsableByteArray);
    }

    private static Date j(ParsableByteArray parsableByteArray) {
        Date date = new Date((long) k(parsableByteArray).doubleValue());
        parsableByteArray.Z(2);
        return date;
    }

    private static Double k(ParsableByteArray parsableByteArray) {
        return Double.valueOf(Double.longBitsToDouble(parsableByteArray.E()));
    }

    private static HashMap<String, Object> l(ParsableByteArray parsableByteArray) {
        int P = parsableByteArray.P();
        HashMap<String, Object> hashMap = new HashMap<>(P);
        for (int i2 = 0; i2 < P; i2++) {
            String o2 = o(parsableByteArray);
            Object i3 = i(parsableByteArray, p(parsableByteArray));
            if (i3 != null) {
                hashMap.put(o2, i3);
            }
        }
        return hashMap;
    }

    private static HashMap<String, Object> m(ParsableByteArray parsableByteArray) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String o2 = o(parsableByteArray);
            int p2 = p(parsableByteArray);
            if (p2 == 9) {
                return hashMap;
            }
            Object i2 = i(parsableByteArray, p2);
            if (i2 != null) {
                hashMap.put(o2, i2);
            }
        }
    }

    private static ArrayList<Object> n(ParsableByteArray parsableByteArray) {
        int P = parsableByteArray.P();
        ArrayList<Object> arrayList = new ArrayList<>(P);
        for (int i2 = 0; i2 < P; i2++) {
            Object i3 = i(parsableByteArray, p(parsableByteArray));
            if (i3 != null) {
                arrayList.add(i3);
            }
        }
        return arrayList;
    }

    private static String o(ParsableByteArray parsableByteArray) {
        int R = parsableByteArray.R();
        int f2 = parsableByteArray.f();
        parsableByteArray.Z(R);
        return new String(parsableByteArray.e(), f2, R);
    }

    private static int p(ParsableByteArray parsableByteArray) {
        return parsableByteArray.L();
    }

    /* access modifiers changed from: protected */
    public boolean b(ParsableByteArray parsableByteArray) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean c(ParsableByteArray parsableByteArray, long j2) {
        if (p(parsableByteArray) != 2 || !f13286e.equals(o(parsableByteArray)) || parsableByteArray.a() == 0 || p(parsableByteArray) != 8) {
            return false;
        }
        HashMap<String, Object> l2 = l(parsableByteArray);
        Object obj = l2.get("duration");
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > 0.0d) {
                this.f13296b = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = l2.get(f13288g);
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get(f13289h);
            Object obj4 = map.get(f13290i);
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f13297c = new long[size];
                this.f13298d = new long[size];
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    Object obj5 = list.get(i2);
                    Object obj6 = list2.get(i2);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f13297c = new long[0];
                        this.f13298d = new long[0];
                    } else {
                        this.f13297c[i2] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.f13298d[i2] = ((Double) obj5).longValue();
                        i2++;
                    }
                }
                this.f13297c = new long[0];
                this.f13298d = new long[0];
            }
        }
        return false;
    }

    public void d() {
    }

    public long e() {
        return this.f13296b;
    }

    public long[] f() {
        return this.f13298d;
    }

    public long[] g() {
        return this.f13297c;
    }
}
