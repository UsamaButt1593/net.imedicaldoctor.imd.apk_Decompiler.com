package com.airbnb.lottie;

import android.util.Log;
import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PerformanceTracker {

    /* renamed from: a  reason: collision with root package name */
    private boolean f16768a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set<FrameListener> f16769b = new ArraySet();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, MeanCalculator> f16770c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Comparator<Pair<String, Float>> f16771d = new Comparator<Pair<String, Float>>() {
        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = ((Float) pair.f6297b).floatValue();
            float floatValue2 = ((Float) pair2.f6297b).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    public interface FrameListener {
        void a(float f2);
    }

    public void a(FrameListener frameListener) {
        this.f16769b.add(frameListener);
    }

    public void b() {
        this.f16770c.clear();
    }

    public List<Pair<String, Float>> c() {
        if (!this.f16768a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f16770c.size());
        for (Map.Entry next : this.f16770c.entrySet()) {
            arrayList.add(new Pair(next.getKey(), Float.valueOf(((MeanCalculator) next.getValue()).b())));
        }
        Collections.sort(arrayList, this.f16771d);
        return arrayList;
    }

    public void d() {
        if (this.f16768a) {
            List<Pair<String, Float>> c2 = c();
            Log.d(L.f16671b, "Render times:");
            for (int i2 = 0; i2 < c2.size(); i2++) {
                Pair pair = c2.get(i2);
                Log.d(L.f16671b, String.format("\t\t%30s:%.2f", new Object[]{pair.f6296a, pair.f6297b}));
            }
        }
    }

    public void e(String str, float f2) {
        if (this.f16768a) {
            MeanCalculator meanCalculator = this.f16770c.get(str);
            if (meanCalculator == null) {
                meanCalculator = new MeanCalculator();
                this.f16770c.put(str, meanCalculator);
            }
            meanCalculator.a(f2);
            if (str.equals("__container")) {
                for (FrameListener a2 : this.f16769b) {
                    a2.a(f2);
                }
            }
        }
    }

    public void f(FrameListener frameListener) {
        this.f16769b.remove(frameListener);
    }

    /* access modifiers changed from: package-private */
    public void g(boolean z) {
        this.f16768a = z;
    }
}
