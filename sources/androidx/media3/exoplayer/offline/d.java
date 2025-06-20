package androidx.media3.exoplayer.offline;

import androidx.media3.common.text.CueGroup;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.text.c;
import java.util.List;

public final /* synthetic */ class d implements TextOutput {
    public final void p(CueGroup cueGroup) {
        DownloadHelper.J(cueGroup);
    }

    public /* synthetic */ void s(List list) {
        c.a(this, list);
    }
}
