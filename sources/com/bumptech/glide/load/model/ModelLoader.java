package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

public interface ModelLoader<Model, Data> {

    public static class LoadData<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final Key f18164a;

        /* renamed from: b  reason: collision with root package name */
        public final List<Key> f18165b;

        /* renamed from: c  reason: collision with root package name */
        public final DataFetcher<Data> f18166c;

        public LoadData(@NonNull Key key, @NonNull DataFetcher<Data> dataFetcher) {
            this(key, Collections.emptyList(), dataFetcher);
        }

        public LoadData(@NonNull Key key, @NonNull List<Key> list, @NonNull DataFetcher<Data> dataFetcher) {
            this.f18164a = (Key) Preconditions.d(key);
            this.f18165b = (List) Preconditions.d(list);
            this.f18166c = (DataFetcher) Preconditions.d(dataFetcher);
        }
    }

    boolean a(@NonNull Model model);

    @Nullable
    LoadData<Data> b(@NonNull Model model, int i2, int i3, @NonNull Options options);
}
