package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

@SuppressLint({"ThreadPoolCreation"})
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* renamed from: a  reason: collision with root package name */
    static final Lazy<ScheduledExecutorService> f23442a = new Lazy<>(new p());

    /* renamed from: b  reason: collision with root package name */
    static final Lazy<ScheduledExecutorService> f23443b = new Lazy<>(new q());

    /* renamed from: c  reason: collision with root package name */
    static final Lazy<ScheduledExecutorService> f23444c = new Lazy<>(new r());

    /* renamed from: d  reason: collision with root package name */
    static final Lazy<ScheduledExecutorService> f23445d = new Lazy<>(new s());

    private static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            StrictMode.ThreadPolicy.Builder unused = detectNetwork.detectResourceMismatches();
            if (i2 >= 26) {
                StrictMode.ThreadPolicy.Builder unused2 = detectNetwork.detectUnbufferedIo();
            }
        }
        return detectNetwork.penaltyLog().build();
    }

    private static ThreadFactory j(String str, int i2) {
        return new CustomThreadFactory(str, i2, (StrictMode.ThreadPolicy) null);
    }

    private static ThreadFactory k(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        return new CustomThreadFactory(str, i2, threadPolicy);
    }

    private static StrictMode.ThreadPolicy t() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    /* access modifiers changed from: private */
    public static ScheduledExecutorService u(ExecutorService executorService) {
        return new DelegatingScheduledExecutorService(executorService, f23445d.get());
    }

    public List<Component<?>> getComponents() {
        Class<Background> cls = Background.class;
        Class<ScheduledExecutorService> cls2 = ScheduledExecutorService.class;
        Class<ExecutorService> cls3 = ExecutorService.class;
        Class<Executor> cls4 = Executor.class;
        Component<ScheduledExecutorService> d2 = Component.g(Qualified.a(cls, cls2), Qualified.a(cls, cls3), Qualified.a(cls, cls4)).f(new t()).d();
        Class<Blocking> cls5 = Blocking.class;
        Component<Blocking> d3 = Component.g(Qualified.a(cls5, cls2), Qualified.a(cls5, cls3), Qualified.a(cls5, cls4)).f(new u()).d();
        Class<Lightweight> cls6 = Lightweight.class;
        return Arrays.asList(new Component[]{d2, d3, Component.g(Qualified.a(cls6, cls2), Qualified.a(cls6, cls3), Qualified.a(cls6, cls4)).f(new v()).d(), Component.f(Qualified.a(UiThread.class, cls4)).f(new w()).d()});
    }
}
