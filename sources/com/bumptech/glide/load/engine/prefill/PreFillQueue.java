package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class PreFillQueue {

    /* renamed from: a  reason: collision with root package name */
    private final Map<PreFillType, Integer> f18103a;

    /* renamed from: b  reason: collision with root package name */
    private final List<PreFillType> f18104b;

    /* renamed from: c  reason: collision with root package name */
    private int f18105c;

    /* renamed from: d  reason: collision with root package name */
    private int f18106d;

    public PreFillQueue(Map<PreFillType, Integer> map) {
        this.f18103a = map;
        this.f18104b = new ArrayList(map.keySet());
        for (Integer intValue : map.values()) {
            this.f18105c += intValue.intValue();
        }
    }

    public int a() {
        return this.f18105c;
    }

    public boolean b() {
        return this.f18105c == 0;
    }

    public PreFillType c() {
        PreFillType preFillType = this.f18104b.get(this.f18106d);
        Integer num = this.f18103a.get(preFillType);
        if (num.intValue() == 1) {
            this.f18103a.remove(preFillType);
            this.f18104b.remove(this.f18106d);
        } else {
            this.f18103a.put(preFillType, Integer.valueOf(num.intValue() - 1));
        }
        this.f18105c--;
        this.f18106d = this.f18104b.isEmpty() ? 0 : (this.f18106d + 1) % this.f18104b.size();
        return preFillType;
    }
}
