package androidx.fragment.app;

import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.util.Consumer;

public final /* synthetic */ class h implements Consumer {
    public final /* synthetic */ FragmentManager s;

    public /* synthetic */ h(FragmentManager fragmentManager) {
        this.s = fragmentManager;
    }

    public final void accept(Object obj) {
        this.s.i1((PictureInPictureModeChangedInfo) obj);
    }
}
