package androidx.media3.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.media3.common.Format;
import androidx.media3.common.Player;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.ui.TrackSelectionView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class TrackSelectionDialogBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14848a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f14849b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Tracks.Group> f14850c;

    /* renamed from: d  reason: collision with root package name */
    private final DialogCallback f14851d;
    @StyleRes

    /* renamed from: e  reason: collision with root package name */
    private int f14852e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14853f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14854g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14855h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private TrackNameProvider f14856i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14857j;

    /* renamed from: k  reason: collision with root package name */
    private ImmutableMap<TrackGroup, TrackSelectionOverride> f14858k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private Comparator<Format> f14859l;

    public interface DialogCallback {
        void a(boolean z, Map<TrackGroup, TrackSelectionOverride> map);
    }

    public TrackSelectionDialogBuilder(Context context, CharSequence charSequence, Player player, int i2) {
        this.f14848a = context;
        this.f14849b = charSequence;
        ImmutableList<Tracks.Group> d2 = (player.R1(30) ? player.D1() : Tracks.X).d();
        this.f14850c = new ArrayList();
        for (int i3 = 0; i3 < d2.size(); i3++) {
            Tracks.Group group = d2.get(i3);
            if (group.g() == i2) {
                this.f14850c.add(group);
            }
        }
        this.f14858k = player.o2().t3;
        this.f14851d = new L(player, i2);
    }

    @Nullable
    private Dialog d() {
        Class<DialogInterface.OnClickListener> cls = DialogInterface.OnClickListener.class;
        Class<AlertDialog.Builder> cls2 = AlertDialog.Builder.class;
        try {
            Class cls3 = Integer.TYPE;
            AlertDialog.Builder newInstance = cls2.getConstructor(new Class[]{Context.class, cls3}).newInstance(new Object[]{this.f14848a, Integer.valueOf(this.f14852e)});
            View inflate = LayoutInflater.from((Context) cls2.getMethod("getContext", (Class[]) null).invoke(newInstance, (Object[]) null)).inflate(R.layout.f14775k, (ViewGroup) null);
            DialogInterface.OnClickListener q = q(inflate);
            cls2.getMethod("setTitle", new Class[]{CharSequence.class}).invoke(newInstance, new Object[]{this.f14849b});
            cls2.getMethod("setView", new Class[]{View.class}).invoke(newInstance, new Object[]{inflate});
            cls2.getMethod("setPositiveButton", new Class[]{cls3, cls}).invoke(newInstance, new Object[]{17039370, q});
            cls2.getMethod("setNegativeButton", new Class[]{cls3, cls}).invoke(newInstance, new Object[]{17039360, null});
            return (Dialog) cls2.getMethod("create", (Class[]) null).invoke(newInstance, (Object[]) null);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    private Dialog e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f14848a, this.f14852e);
        View inflate = LayoutInflater.from(builder.getContext()).inflate(R.layout.f14775k, (ViewGroup) null);
        return builder.setTitle(this.f14849b).setView(inflate).setPositiveButton(17039370, q(inflate)).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).create();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void f(Player player, int i2, boolean z, Map map) {
        if (player.R1(29)) {
            TrackSelectionParameters.Builder G = player.o2().G();
            G.r0(i2, z);
            G.G(i2);
            for (TrackSelectionOverride C : map.values()) {
                G.C(C);
            }
            player.X1(G.D());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(TrackSelectionView trackSelectionView, DialogInterface dialogInterface, int i2) {
        this.f14851d.a(trackSelectionView.getIsDisabled(), trackSelectionView.getOverrides());
    }

    private DialogInterface.OnClickListener q(View view) {
        TrackSelectionView trackSelectionView = (TrackSelectionView) view.findViewById(R.id.R0);
        trackSelectionView.setAllowMultipleOverrides(this.f14854g);
        trackSelectionView.setAllowAdaptiveSelections(this.f14853f);
        trackSelectionView.setShowDisableOption(this.f14855h);
        TrackNameProvider trackNameProvider = this.f14856i;
        if (trackNameProvider != null) {
            trackSelectionView.setTrackNameProvider(trackNameProvider);
        }
        trackSelectionView.d(this.f14850c, this.f14857j, this.f14858k, this.f14859l, (TrackSelectionView.TrackSelectionListener) null);
        return new K(this, trackSelectionView);
    }

    public Dialog c() {
        Dialog d2 = d();
        return d2 == null ? e() : d2;
    }

    public TrackSelectionDialogBuilder h(boolean z) {
        this.f14853f = z;
        return this;
    }

    public TrackSelectionDialogBuilder i(boolean z) {
        this.f14854g = z;
        return this;
    }

    public TrackSelectionDialogBuilder j(boolean z) {
        this.f14857j = z;
        return this;
    }

    public TrackSelectionDialogBuilder k(@Nullable TrackSelectionOverride trackSelectionOverride) {
        return l(trackSelectionOverride == null ? Collections.emptyMap() : ImmutableMap.t(trackSelectionOverride.s, trackSelectionOverride));
    }

    public TrackSelectionDialogBuilder l(Map<TrackGroup, TrackSelectionOverride> map) {
        this.f14858k = ImmutableMap.g(map);
        return this;
    }

    public TrackSelectionDialogBuilder m(boolean z) {
        this.f14855h = z;
        return this;
    }

    public TrackSelectionDialogBuilder n(@StyleRes int i2) {
        this.f14852e = i2;
        return this;
    }

    public void o(@Nullable Comparator<Format> comparator) {
        this.f14859l = comparator;
    }

    public TrackSelectionDialogBuilder p(@Nullable TrackNameProvider trackNameProvider) {
        this.f14856i = trackNameProvider;
        return this;
    }

    public TrackSelectionDialogBuilder(Context context, CharSequence charSequence, List<Tracks.Group> list, DialogCallback dialogCallback) {
        this.f14848a = context;
        this.f14849b = charSequence;
        this.f14850c = ImmutableList.B(list);
        this.f14851d = dialogCallback;
        this.f14858k = ImmutableMap.s();
    }
}
