package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UnstableApi
public class TrackSelectionView extends LinearLayout {
    private final LayoutInflater X2;
    private final CheckedTextView Y2;
    private final CheckedTextView Z2;
    private final ComponentListener a3;
    private final List<Tracks.Group> b3;
    private final Map<TrackGroup, TrackSelectionOverride> c3;
    private boolean d3;
    private boolean e3;
    private TrackNameProvider f3;
    private CheckedTextView[][] g3;
    private boolean h3;
    @Nullable
    private Comparator<TrackInfo> i3;
    @Nullable
    private TrackSelectionListener j3;
    private final int s;

    private class ComponentListener implements View.OnClickListener {
        private ComponentListener() {
        }

        public void onClick(View view) {
            TrackSelectionView.this.f(view);
        }
    }

    private static final class TrackInfo {

        /* renamed from: a  reason: collision with root package name */
        public final Tracks.Group f14860a;

        /* renamed from: b  reason: collision with root package name */
        public final int f14861b;

        public TrackInfo(Tracks.Group group, int i2) {
            this.f14860a = group;
            this.f14861b = i2;
        }

        public Format a() {
            return this.f14860a.e(this.f14861b);
        }
    }

    public interface TrackSelectionListener {
        void a(boolean z, Map<TrackGroup, TrackSelectionOverride> map);
    }

    public TrackSelectionView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static Map<TrackGroup, TrackSelectionOverride> c(Map<TrackGroup, TrackSelectionOverride> map, List<Tracks.Group> list, boolean z) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            TrackSelectionOverride trackSelectionOverride = map.get(list.get(i2).d());
            if (trackSelectionOverride != null && (z || hashMap.isEmpty())) {
                hashMap.put(trackSelectionOverride.s, trackSelectionOverride);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void f(View view) {
        if (view == this.Y2) {
            h();
        } else if (view == this.Z2) {
            g();
        } else {
            i(view);
        }
        l();
        TrackSelectionListener trackSelectionListener = this.j3;
        if (trackSelectionListener != null) {
            trackSelectionListener.a(getIsDisabled(), getOverrides());
        }
    }

    private void g() {
        this.h3 = false;
        this.c3.clear();
    }

    private void h() {
        this.h3 = true;
        this.c3.clear();
    }

    private void i(View view) {
        Map<TrackGroup, TrackSelectionOverride> map;
        TrackSelectionOverride trackSelectionOverride;
        boolean z = false;
        this.h3 = false;
        TrackInfo trackInfo = (TrackInfo) Assertions.g(view.getTag());
        TrackGroup d2 = trackInfo.f14860a.d();
        int i2 = trackInfo.f14861b;
        TrackSelectionOverride trackSelectionOverride2 = this.c3.get(d2);
        if (trackSelectionOverride2 == null) {
            if (!this.e3 && this.c3.size() > 0) {
                this.c3.clear();
            }
            map = this.c3;
            trackSelectionOverride = new TrackSelectionOverride(d2, (List<Integer>) ImmutableList.K(Integer.valueOf(i2)));
        } else {
            ArrayList arrayList = new ArrayList(trackSelectionOverride2.X);
            boolean isChecked = ((CheckedTextView) view).isChecked();
            boolean j2 = j(trackInfo.f14860a);
            if (j2 || k()) {
                z = true;
            }
            if (isChecked && z) {
                arrayList.remove(Integer.valueOf(i2));
                if (arrayList.isEmpty()) {
                    this.c3.remove(d2);
                    return;
                } else {
                    map = this.c3;
                    trackSelectionOverride = new TrackSelectionOverride(d2, (List<Integer>) arrayList);
                }
            } else if (isChecked) {
                return;
            } else {
                if (j2) {
                    arrayList.add(Integer.valueOf(i2));
                    map = this.c3;
                    trackSelectionOverride = new TrackSelectionOverride(d2, (List<Integer>) arrayList);
                } else {
                    map = this.c3;
                    trackSelectionOverride = new TrackSelectionOverride(d2, (List<Integer>) ImmutableList.K(Integer.valueOf(i2)));
                }
            }
        }
        map.put(d2, trackSelectionOverride);
    }

    private boolean j(Tracks.Group group) {
        return this.d3 && group.h();
    }

    private boolean k() {
        return this.e3 && this.b3.size() > 1;
    }

    private void l() {
        this.Y2.setChecked(this.h3);
        this.Z2.setChecked(!this.h3 && this.c3.size() == 0);
        for (int i2 = 0; i2 < this.g3.length; i2++) {
            TrackSelectionOverride trackSelectionOverride = this.c3.get(this.b3.get(i2).d());
            int i4 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.g3[i2];
                if (i4 >= checkedTextViewArr.length) {
                    break;
                }
                if (trackSelectionOverride != null) {
                    this.g3[i2][i4].setChecked(trackSelectionOverride.X.contains(Integer.valueOf(((TrackInfo) Assertions.g(checkedTextViewArr[i4].getTag())).f14861b)));
                } else {
                    checkedTextViewArr[i4].setChecked(false);
                }
                i4++;
            }
        }
    }

    private void m() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.b3.isEmpty()) {
            this.Y2.setEnabled(false);
            this.Z2.setEnabled(false);
            return;
        }
        this.Y2.setEnabled(true);
        this.Z2.setEnabled(true);
        this.g3 = new CheckedTextView[this.b3.size()][];
        boolean k2 = k();
        for (int i2 = 0; i2 < this.b3.size(); i2++) {
            Tracks.Group group = this.b3.get(i2);
            boolean j2 = j(group);
            CheckedTextView[][] checkedTextViewArr = this.g3;
            int i4 = group.s;
            checkedTextViewArr[i2] = new CheckedTextView[i4];
            TrackInfo[] trackInfoArr = new TrackInfo[i4];
            for (int i5 = 0; i5 < group.s; i5++) {
                trackInfoArr[i5] = new TrackInfo(group, i5);
            }
            Comparator<TrackInfo> comparator = this.i3;
            if (comparator != null) {
                Arrays.sort(trackInfoArr, comparator);
            }
            for (int i6 = 0; i6 < i4; i6++) {
                if (i6 == 0) {
                    addView(this.X2.inflate(R.layout.f14767c, this, false));
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.X2.inflate((j2 || k2) ? 17367056 : 17367055, this, false);
                checkedTextView.setBackgroundResource(this.s);
                checkedTextView.setText(this.f3.a(trackInfoArr[i6].a()));
                checkedTextView.setTag(trackInfoArr[i6]);
                if (group.m(i6)) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener(this.a3);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.g3[i2][i6] = checkedTextView;
                addView(checkedTextView);
            }
        }
        l();
    }

    public void d(List<Tracks.Group> list, boolean z, Map<TrackGroup, TrackSelectionOverride> map, @Nullable Comparator<Format> comparator, @Nullable TrackSelectionListener trackSelectionListener) {
        this.h3 = z;
        this.i3 = comparator == null ? null : new M(comparator);
        this.j3 = trackSelectionListener;
        this.b3.clear();
        this.b3.addAll(list);
        this.c3.clear();
        this.c3.putAll(c(map, list, this.e3));
        m();
    }

    public boolean getIsDisabled() {
        return this.h3;
    }

    public Map<TrackGroup, TrackSelectionOverride> getOverrides() {
        return this.c3;
    }

    public void setAllowAdaptiveSelections(boolean z) {
        if (this.d3 != z) {
            this.d3 = z;
            m();
        }
    }

    public void setAllowMultipleOverrides(boolean z) {
        if (this.e3 != z) {
            this.e3 = z;
            if (!z && this.c3.size() > 1) {
                Map<TrackGroup, TrackSelectionOverride> c2 = c(this.c3, this.b3, false);
                this.c3.clear();
                this.c3.putAll(c2);
            }
            m();
        }
    }

    public void setShowDisableOption(boolean z) {
        this.Y2.setVisibility(z ? 0 : 8);
    }

    public void setTrackNameProvider(TrackNameProvider trackNameProvider) {
        this.f3 = (TrackNameProvider) Assertions.g(trackNameProvider);
        m();
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843534});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.s = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.X2 = from;
        ComponentListener componentListener = new ComponentListener();
        this.a3 = componentListener;
        this.f3 = new DefaultTrackNameProvider(getResources());
        this.b3 = new ArrayList();
        this.c3 = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(17367055, this, false);
        this.Y2 = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R.string.J);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(componentListener);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(R.layout.f14767c, this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(17367055, this, false);
        this.Z2 = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R.string.I);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(componentListener);
        addView(checkedTextView2);
    }
}
