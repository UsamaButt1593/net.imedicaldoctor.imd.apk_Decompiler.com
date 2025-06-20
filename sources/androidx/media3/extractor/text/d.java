package androidx.media3.extractor.text;

import androidx.media3.common.util.Consumer;
import com.google.common.collect.ImmutableList;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImmutableList.Builder f13855a;

    public /* synthetic */ d(ImmutableList.Builder builder) {
        this.f13855a = builder;
    }

    public final void accept(Object obj) {
        this.f13855a.g((CuesWithTiming) obj);
    }
}
