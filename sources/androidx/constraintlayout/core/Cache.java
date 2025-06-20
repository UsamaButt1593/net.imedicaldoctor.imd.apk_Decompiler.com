package androidx.constraintlayout.core;

import androidx.constraintlayout.core.Pools;

public class Cache {

    /* renamed from: a  reason: collision with root package name */
    Pools.Pool<ArrayRow> f3597a = new Pools.SimplePool(256);

    /* renamed from: b  reason: collision with root package name */
    Pools.Pool<ArrayRow> f3598b = new Pools.SimplePool(256);

    /* renamed from: c  reason: collision with root package name */
    Pools.Pool<SolverVariable> f3599c = new Pools.SimplePool(256);

    /* renamed from: d  reason: collision with root package name */
    SolverVariable[] f3600d = new SolverVariable[32];
}
