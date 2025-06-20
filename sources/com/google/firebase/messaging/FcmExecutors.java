package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.firebase.messaging.threads.PoolableExecutors;
import com.google.firebase.messaging.threads.ThreadPriority;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class FcmExecutors {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24744a = "Firebase-Messaging-Network-Io";

    /* renamed from: b  reason: collision with root package name */
    private static final String f24745b = "Firebase-Messaging-Task";

    /* renamed from: c  reason: collision with root package name */
    private static final String f24746c = "Firebase-Messaging-File";

    /* renamed from: d  reason: collision with root package name */
    private static final String f24747d = "Firebase-Messaging-Intent-Handle";

    /* renamed from: e  reason: collision with root package name */
    private static final String f24748e = "Firebase-Messaging-Topics-Io";

    /* renamed from: f  reason: collision with root package name */
    private static final String f24749f = "Firebase-Messaging-Init";

    /* renamed from: g  reason: collision with root package name */
    static final String f24750g = "Firebase-Messaging-File-Io";

    /* renamed from: h  reason: collision with root package name */
    static final String f24751h = "Firebase-Messaging-Rpc-Task";

    private FcmExecutors() {
    }

    @SuppressLint({"ThreadPoolCreation"})
    private static Executor a(String str) {
        return new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(str));
    }

    @SuppressLint({"ThreadPoolCreation"})
    static ExecutorService b() {
        return Executors.newSingleThreadExecutor(new NamedThreadFactory(f24746c));
    }

    static Executor c() {
        return a(f24750g);
    }

    @SuppressLint({"ThreadPoolCreation"})
    static ScheduledExecutorService d() {
        return new ScheduledThreadPoolExecutor(1, new NamedThreadFactory(f24749f));
    }

    @SuppressLint({"ThreadPoolCreation"})
    static ExecutorService e() {
        return PoolableExecutors.a().i(new NamedThreadFactory(f24747d), ThreadPriority.HIGH_SPEED);
    }

    @SuppressLint({"ThreadPoolCreation"})
    static ExecutorService f() {
        return Executors.newSingleThreadExecutor(new NamedThreadFactory(f24744a));
    }

    static Executor g() {
        return a(f24751h);
    }

    @SuppressLint({"ThreadPoolCreation"})
    static ExecutorService h() {
        return Executors.newSingleThreadExecutor(new NamedThreadFactory(f24745b));
    }

    @SuppressLint({"ThreadPoolCreation"})
    static ScheduledExecutorService i() {
        return new ScheduledThreadPoolExecutor(1, new NamedThreadFactory(f24748e));
    }
}
