package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class AsyncListDiffer<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final Executor f15216h = new MainThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    private final ListUpdateCallback f15217a;

    /* renamed from: b  reason: collision with root package name */
    final AsyncDifferConfig<T> f15218b;

    /* renamed from: c  reason: collision with root package name */
    Executor f15219c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ListListener<T>> f15220d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private List<T> f15221e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private List<T> f15222f;

    /* renamed from: g  reason: collision with root package name */
    int f15223g;

    public interface ListListener<T> {
        void a(@NonNull List<T> list, @NonNull List<T> list2);
    }

    private static class MainThreadExecutor implements Executor {
        final Handler s = new Handler(Looper.getMainLooper());

        MainThreadExecutor() {
        }

        public void execute(@NonNull Runnable runnable) {
            this.s.post(runnable);
        }
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.f15220d = new CopyOnWriteArrayList();
        this.f15222f = Collections.emptyList();
        this.f15217a = listUpdateCallback;
        this.f15218b = asyncDifferConfig;
        this.f15219c = asyncDifferConfig.c() != null ? asyncDifferConfig.c() : f15216h;
    }

    private void d(@NonNull List<T> list, @Nullable Runnable runnable) {
        for (ListListener<T> a2 : this.f15220d) {
            a2.a(list, this.f15222f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(@NonNull ListListener<T> listListener) {
        this.f15220d.add(listListener);
    }

    @NonNull
    public List<T> b() {
        return this.f15222f;
    }

    /* access modifiers changed from: package-private */
    public void c(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult, @Nullable Runnable runnable) {
        List<T> list2 = this.f15222f;
        this.f15221e = list;
        this.f15222f = Collections.unmodifiableList(list);
        diffResult.d(this.f15217a);
        d(list2, runnable);
    }

    public void e(@NonNull ListListener<T> listListener) {
        this.f15220d.remove(listListener);
    }

    public void f(@Nullable List<T> list) {
        g(list, (Runnable) null);
    }

    public void g(@Nullable List<T> list, @Nullable Runnable runnable) {
        final int i2 = this.f15223g + 1;
        this.f15223g = i2;
        final List<T> list2 = this.f15221e;
        if (list != list2) {
            List<T> list3 = this.f15222f;
            if (list == null) {
                int size = list2.size();
                this.f15221e = null;
                this.f15222f = Collections.emptyList();
                this.f15217a.c(0, size);
                d(list3, runnable);
            } else if (list2 == null) {
                this.f15221e = list;
                this.f15222f = Collections.unmodifiableList(list);
                this.f15217a.b(0, list.size());
                d(list3, runnable);
            } else {
                final List<T> list4 = list;
                final Runnable runnable2 = runnable;
                this.f15218b.a().execute(new Runnable() {
                    public void run() {
                        final DiffUtil.DiffResult b2 = DiffUtil.b(new DiffUtil.Callback() {
                            public boolean a(int i2, int i3) {
                                Object obj = list2.get(i2);
                                Object obj2 = list4.get(i3);
                                if (obj != null && obj2 != null) {
                                    return AsyncListDiffer.this.f15218b.b().a(obj, obj2);
                                }
                                if (obj == null && obj2 == null) {
                                    return true;
                                }
                                throw new AssertionError();
                            }

                            public boolean b(int i2, int i3) {
                                Object obj = list2.get(i2);
                                Object obj2 = list4.get(i3);
                                if (obj == null || obj2 == null) {
                                    return obj == null && obj2 == null;
                                }
                                return AsyncListDiffer.this.f15218b.b().b(obj, obj2);
                            }

                            @Nullable
                            public Object c(int i2, int i3) {
                                Object obj = list2.get(i2);
                                Object obj2 = list4.get(i3);
                                if (obj != null && obj2 != null) {
                                    return AsyncListDiffer.this.f15218b.b().c(obj, obj2);
                                }
                                throw new AssertionError();
                            }

                            public int d() {
                                return list4.size();
                            }

                            public int e() {
                                return list2.size();
                            }
                        });
                        AsyncListDiffer.this.f15219c.execute(new Runnable() {
                            public void run() {
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                                if (asyncListDiffer.f15223g == i2) {
                                    asyncListDiffer.c(list4, b2, runnable2);
                                }
                            }
                        });
                    }
                });
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public AsyncListDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this((ListUpdateCallback) new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).a());
    }
}
