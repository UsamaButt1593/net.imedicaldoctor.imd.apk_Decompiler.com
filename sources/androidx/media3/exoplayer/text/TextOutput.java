package androidx.media3.exoplayer.text;

import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.UnstableApi;
import java.util.List;

@UnstableApi
public interface TextOutput {
    void p(CueGroup cueGroup);

    @Deprecated
    void s(List<Cue> list);
}
