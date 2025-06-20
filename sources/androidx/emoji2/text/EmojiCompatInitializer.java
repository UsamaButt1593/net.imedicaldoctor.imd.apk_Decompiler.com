package androidx.emoji2.text;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.c;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class EmojiCompatInitializer implements Initializer<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private static final long f7604a = 500;

    /* renamed from: b  reason: collision with root package name */
    private static final String f7605b = "EmojiCompatInitializer";

    @RequiresApi(19)
    static class BackgroundDefaultConfig extends EmojiCompat.Config {
        protected BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            f(1);
        }
    }

    @RequiresApi(19)
    static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7606a;

        BackgroundDefaultLoader(Context context) {
            this.f7606a = context.getApplicationContext();
        }

        public void a(@NonNull EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            ThreadPoolExecutor c2 = ConcurrencyHelpers.c(EmojiCompatInitializer.f7605b);
            c2.execute(new d(this, metadataRepoLoaderCallback, c2));
        }

        /* access modifiers changed from: package-private */
        @WorkerThread
        /* renamed from: c */
        public void d(@NonNull final EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, @NonNull final ThreadPoolExecutor threadPoolExecutor) {
            try {
                FontRequestEmojiCompatConfig a2 = DefaultEmojiCompatConfig.a(this.f7606a);
                if (a2 != null) {
                    a2.m(threadPoolExecutor);
                    a2.a().a(new EmojiCompat.MetadataRepoLoaderCallback() {
                        public void a(@Nullable Throwable th) {
                            try {
                                metadataRepoLoaderCallback.a(th);
                            } finally {
                                threadPoolExecutor.shutdown();
                            }
                        }

                        public void b(@NonNull MetadataRepo metadataRepo) {
                            try {
                                metadataRepoLoaderCallback.b(metadataRepo);
                            } finally {
                                threadPoolExecutor.shutdown();
                            }
                        }
                    });
                    return;
                }
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            } catch (Throwable th) {
                metadataRepoLoaderCallback.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    static class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        public void run() {
            try {
                TraceCompat.b("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.q()) {
                    EmojiCompat.c().t();
                }
            } finally {
                TraceCompat.d();
            }
        }
    }

    @NonNull
    /* renamed from: b */
    public Boolean a(@NonNull Context context) {
        EmojiCompat.p(new BackgroundDefaultConfig(context));
        c(context);
        return Boolean.TRUE;
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(19)
    public void c(@NonNull Context context) {
        final Lifecycle a2 = ((LifecycleOwner) AppInitializer.e(context).f(ProcessLifecycleInitializer.class)).a();
        a2.a(new DefaultLifecycleObserver() {
            public void b(@NonNull LifecycleOwner lifecycleOwner) {
                EmojiCompatInitializer.this.d();
                a2.d(this);
            }

            public /* synthetic */ void c(LifecycleOwner lifecycleOwner) {
                c.a(this, lifecycleOwner);
            }

            public /* synthetic */ void e(LifecycleOwner lifecycleOwner) {
                c.c(this, lifecycleOwner);
            }

            public /* synthetic */ void f(LifecycleOwner lifecycleOwner) {
                c.f(this, lifecycleOwner);
            }

            public /* synthetic */ void g(LifecycleOwner lifecycleOwner) {
                c.b(this, lifecycleOwner);
            }

            public /* synthetic */ void j(LifecycleOwner lifecycleOwner) {
                c.e(this, lifecycleOwner);
            }
        });
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(19)
    public void d() {
        ConcurrencyHelpers.e().postDelayed(new LoadEmojiCompatRunnable(), 500);
    }

    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
