package net.imedicaldoctor.imd.Fragments;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import com.timehop.stickyheadersrecyclerview.ItemVisibilityAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersTouchListener;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.StatusAdapter;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class searchFragment extends SearchHelperFragment {
    private SearchAdapter A4;
    private boolean B4;
    /* access modifiers changed from: private */
    public ArrayList<Bundle> C4;
    /* access modifiers changed from: private */
    public RecyclerView D4;
    private AsyncTask E4;
    private boolean F4;
    /* access modifiers changed from: private */
    public Observable<Bundle> G4;
    /* access modifiers changed from: private */
    public DisposableObserver<Bundle> H4;
    /* access modifiers changed from: private */
    public ProgressBar I4;
    /* access modifiers changed from: private */
    public MenuItem J4;
    /* access modifiers changed from: private */
    public String K4;
    /* access modifiers changed from: private */
    public StickyRecyclerHeadersDecoration L4;
    /* access modifiers changed from: private */
    public LinearLayoutManager M4;
    /* access modifiers changed from: private */
    public ArrayList<String> N4;
    StickyRecyclerHeadersTouchListener O4;
    public CompressHelper P4;

    public class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View view) {
            super(view);
        }
    }

    public class SearchAdapter extends RecyclerView.Adapter implements StickyRecyclerHeadersAdapter {

        /* renamed from: d  reason: collision with root package name */
        private final Context f30207d;

        public SearchAdapter(Context context) {
            this.f30207d = context;
        }

        public int C(int i2) {
            searchFragment searchfragment = searchFragment.this;
            return searchfragment.j3(i2, searchfragment.C4).containsKey("Item") ? 0 : 1;
        }

        public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
            if (viewHolder.F() != 1) {
                SearchItemViewHolder searchItemViewHolder = (SearchItemViewHolder) viewHolder;
                searchFragment searchfragment = searchFragment.this;
                Bundle bundle = searchfragment.j3(i2, searchfragment.C4).getBundle("Item");
                searchItemViewHolder.I.setText(bundle.getString("text"));
                if (!bundle.containsKey("subText") || bundle.getString("subText").length() != 0) {
                    searchItemViewHolder.J.setVisibility(0);
                    searchItemViewHolder.J.setText(bundle.getString("subText"));
                } else {
                    searchItemViewHolder.J.setText((CharSequence) null);
                    searchItemViewHolder.J.setVisibility(8);
                }
                searchItemViewHolder.K.setOnClickListener(new View.OnClickListener() {
                    /* JADX WARNING: type inference failed for: r4v3, types: [java.lang.String[], java.lang.String] */
                    /* JADX WARNING: type inference failed for: r4v4 */
                    /* JADX WARNING: type inference failed for: r4v10 */
                    /* JADX WARNING: Code restructure failed: missing block: B:102:0x03d9, code lost:
                        if (r3.equals(r14) != false) goto L_0x03db;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0408, code lost:
                        if (r3.equals(androidx.media3.extractor.metadata.icy.IcyHeaders.a3) != false) goto L_0x03db;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void onClick(android.view.View r23) {
                        /*
                            r22 = this;
                            r0 = r22
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r1 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r1 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            int r2 = r6
                            java.util.ArrayList r3 = r1.C4
                            android.os.Bundle r1 = r1.j3(r2, r3)
                            if (r1 != 0) goto L_0x0013
                            return
                        L_0x0013:
                            java.lang.String r2 = "Database"
                            android.os.Bundle r4 = r1.getBundle(r2)
                            java.lang.String r2 = "Item"
                            android.os.Bundle r1 = r1.getBundle(r2)
                            java.lang.String r2 = "Type"
                            java.lang.String r2 = r4.getString(r2)
                            java.lang.String r3 = "id"
                            java.lang.String r5 = r1.getString(r3)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r6 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r6 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            r6.h4 = r4
                            java.lang.String r6 = "lexi"
                            boolean r6 = r2.equals(r6)
                            java.lang.String r7 = "Mode"
                            r8 = 2
                            java.lang.String r9 = "ParentId"
                            java.lang.String r10 = "DB"
                            java.lang.String r11 = "1"
                            r12 = 0
                            if (r6 == 0) goto L_0x00b7
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r1 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r1 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r1 = r1.P4
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder
                            r2.<init>()
                            java.lang.String r3 = "Select count(*) as c from indexitem_document where indexitem_id="
                            r2.append(r3)
                            r2.append(r5)
                            java.lang.String r2 = r2.toString()
                            java.util.ArrayList r2 = r1.V(r4, r2)
                            android.os.Bundle r1 = r1.z(r2)
                            if (r1 == 0) goto L_0x008e
                            java.lang.String r2 = "c"
                            java.lang.String r1 = r1.getString(r2)
                            boolean r1 = r1.equals(r11)
                            if (r1 == 0) goto L_0x0071
                            goto L_0x008e
                        L_0x0071:
                            android.os.Bundle r1 = new android.os.Bundle
                            r1.<init>()
                            r1.putString(r9, r5)
                            r1.putInt(r7, r8)
                            r1.putBundle(r10, r4)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.Lexi.LXItems> r3 = net.imedicaldoctor.imd.Fragments.Lexi.LXItems.class
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.Lexi.LXItems$LXItemsFragment> r4 = net.imedicaldoctor.imd.Fragments.Lexi.LXItems.LXItemsFragment.class
                            r2.N(r3, r4, r1)
                            goto L_0x0744
                        L_0x008e:
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r1 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r1 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r1 = r1.P4
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder
                            r2.<init>()
                            java.lang.String r3 = "select document_id from indexitem_document where indexitem_id="
                            r2.append(r3)
                            r2.append(r5)
                            java.lang.String r2 = r2.toString()
                            java.util.ArrayList r2 = r1.V(r4, r2)
                            android.os.Bundle r1 = r1.z(r2)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.String r3 = "document_id"
                            goto L_0x0149
                        L_0x00b7:
                            java.lang.String r6 = "skyscape"
                            boolean r6 = r2.equals(r6)
                            java.lang.String r13 = "docId"
                            java.lang.String r14 = "name"
                            java.lang.String r15 = "section"
                            if (r6 == 0) goto L_0x0120
                            java.lang.String r2 = "|"
                            boolean r2 = r5.contains(r2)
                            if (r2 == 0) goto L_0x0111
                            android.os.Bundle r2 = new android.os.Bundle
                            r2.<init>()
                            android.os.Bundle r3 = new android.os.Bundle
                            r3.<init>()
                            r3.putString(r13, r5)
                            java.lang.String r5 = "text"
                            java.lang.String r5 = r1.getString(r5)
                            r3.putString(r14, r5)
                            java.lang.String r1 = r1.getString(r15)
                            r3.putString(r15, r1)
                            java.lang.String r1 = "SelectedItem"
                            r2.putBundle(r1, r3)
                            r2.putBundle(r10, r4)
                            r2.putInt(r7, r8)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r1 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r1 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            android.os.Bundle r1 = r1.A3(r3)
                            java.lang.String r3 = "GotoSections"
                            r2.putBundle(r3, r1)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r1 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r1 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r1 = r1.P4
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.Skyscape.SSSearchActivity> r3 = net.imedicaldoctor.imd.Fragments.Skyscape.SSSearchActivity.class
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.Skyscape.SSSearchActivity$SSSearchFragment> r4 = net.imedicaldoctor.imd.Fragments.Skyscape.SSSearchActivity.SSSearchFragment.class
                        L_0x010c:
                            r1.N(r3, r4, r2)
                            goto L_0x0744
                        L_0x0111:
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.String r1 = r1.getString(r15)
                            r2.A1(r4, r5, r12, r1)
                            goto L_0x0744
                        L_0x0120:
                            java.lang.String r5 = "medhand"
                            boolean r5 = r2.equals(r5)
                            java.lang.String r6 = "URL"
                            if (r5 == 0) goto L_0x0139
                        L_0x012a:
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.String r1 = r1.getString(r6)
                        L_0x0134:
                            r2.A1(r4, r1, r12, r12)
                            goto L_0x0744
                        L_0x0139:
                            java.lang.String r5 = "irandarou"
                            boolean r5 = r2.equals(r5)
                            if (r5 == 0) goto L_0x014e
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.String r3 = "drugId"
                        L_0x0149:
                            java.lang.String r1 = r1.getString(r3)
                            goto L_0x0134
                        L_0x014e:
                            java.lang.String r5 = "uptodateddx"
                            boolean r5 = r2.equals(r5)
                            if (r5 == 0) goto L_0x015d
                        L_0x0156:
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            goto L_0x0149
                        L_0x015d:
                            java.lang.String r5 = "labvalues"
                            boolean r5 = r2.equals(r5)
                            if (r5 == 0) goto L_0x0167
                            goto L_0x0744
                        L_0x0167:
                            java.lang.String r5 = "visualdx"
                            boolean r5 = r2.equals(r5)
                            if (r5 == 0) goto L_0x0170
                            goto L_0x0156
                        L_0x0170:
                            java.lang.String r5 = "uptodate"
                            boolean r5 = r2.equals(r5)
                            if (r5 == 0) goto L_0x0179
                            goto L_0x012a
                        L_0x0179:
                            java.lang.String r5 = "accessmedicine"
                            boolean r5 = r2.equals(r5)
                            java.lang.String r6 = "select * from tables where id="
                            java.lang.String r7 = "2"
                            java.lang.String r8 = "4"
                            java.lang.String r12 = "sectionId"
                            r16 = r13
                            java.lang.String r13 = "3"
                            r17 = r14
                            java.lang.String r14 = "0"
                            r18 = r15
                            java.lang.String r15 = "goto"
                            r19 = r3
                            java.lang.String r3 = "type"
                            r20 = r2
                            java.lang.String r2 = "contentId"
                            if (r5 == 0) goto L_0x025d
                            java.lang.String r3 = r1.getString(r3)
                            java.lang.String r1 = r1.getString(r2)
                            boolean r2 = r3.equals(r14)
                            if (r2 == 0) goto L_0x01c2
                            android.os.Bundle r2 = new android.os.Bundle
                            r2.<init>()
                            r2.putBundle(r10, r4)
                            r2.putString(r9, r1)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r1 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r1 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r1 = r1.P4
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.AccessMedicine.AMChaptersActivity> r3 = net.imedicaldoctor.imd.Fragments.AccessMedicine.AMChaptersActivity.class
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.AccessMedicine.AMChaptersActivity$AMChaptersFragment> r4 = net.imedicaldoctor.imd.Fragments.AccessMedicine.AMChaptersActivity.AMChaptersFragment.class
                            goto L_0x010c
                        L_0x01c2:
                            boolean r2 = r3.equals(r11)
                            if (r2 == 0) goto L_0x01d4
                        L_0x01c8:
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            r3 = 0
                            r2.A1(r4, r1, r3, r3)
                            goto L_0x0744
                        L_0x01d4:
                            boolean r2 = r3.equals(r7)
                            if (r2 == 0) goto L_0x020f
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            java.lang.String r5 = "select * from videos where id="
                            r3.append(r5)
                            r3.append(r1)
                            java.lang.String r1 = r3.toString()
                            java.util.ArrayList r1 = r2.V(r4, r1)
                            android.os.Bundle r1 = r2.n1(r1)
                            if (r1 == 0) goto L_0x0744
                        L_0x01fb:
                            java.lang.String r2 = r1.getString(r12)
                        L_0x01ff:
                            java.lang.String r1 = r1.getString(r15)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r3 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r3 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r3.P4
                            r5 = 0
                            r3.A1(r4, r2, r5, r1)
                            goto L_0x0744
                        L_0x020f:
                            boolean r2 = r3.equals(r13)
                            if (r2 == 0) goto L_0x0237
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            java.lang.String r5 = "select * from images where id="
                            r3.append(r5)
                            r3.append(r1)
                            java.lang.String r1 = r3.toString()
                            java.util.ArrayList r1 = r2.V(r4, r1)
                            android.os.Bundle r1 = r2.n1(r1)
                            if (r1 == 0) goto L_0x0744
                            goto L_0x01fb
                        L_0x0237:
                            boolean r2 = r3.equals(r8)
                            if (r2 == 0) goto L_0x0744
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            r3.append(r6)
                            r3.append(r1)
                            java.lang.String r1 = r3.toString()
                            java.util.ArrayList r1 = r2.V(r4, r1)
                            android.os.Bundle r1 = r2.n1(r1)
                            if (r1 == 0) goto L_0x0744
                            goto L_0x01fb
                        L_0x025d:
                            java.lang.String r5 = "lww"
                            r21 = r12
                            r12 = r20
                            boolean r5 = r12.equals(r5)
                            if (r5 == 0) goto L_0x02a8
                            java.lang.String r3 = r1.getString(r3)
                            java.lang.String r1 = r1.getString(r2)
                            boolean r2 = r3.equals(r14)
                            if (r2 == 0) goto L_0x028e
                            android.os.Bundle r2 = new android.os.Bundle
                            r2.<init>()
                            r2.putBundle(r10, r4)
                            r2.putString(r9, r1)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r1 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r1 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r1 = r1.P4
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.LWW.LWWChapters> r3 = net.imedicaldoctor.imd.Fragments.LWW.LWWChapters.class
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.LWW.LWWChaptersFragment> r4 = net.imedicaldoctor.imd.Fragments.LWW.LWWChaptersFragment.class
                            goto L_0x010c
                        L_0x028e:
                            boolean r2 = r3.equals(r11)
                            if (r2 != 0) goto L_0x01c8
                            boolean r2 = r3.equals(r7)
                            if (r2 != 0) goto L_0x01c8
                            boolean r2 = r3.equals(r13)
                            if (r2 != 0) goto L_0x01c8
                            boolean r2 = r3.equals(r8)
                            if (r2 == 0) goto L_0x0744
                            goto L_0x01c8
                        L_0x02a8:
                            java.lang.String r5 = "elsevier"
                            boolean r5 = r12.equals(r5)
                            if (r5 != 0) goto L_0x02b8
                            java.lang.String r5 = "elseviernew"
                            boolean r5 = r12.equals(r5)
                            if (r5 == 0) goto L_0x02bb
                        L_0x02b8:
                            r5 = 0
                            goto L_0x06d0
                        L_0x02bb:
                            java.lang.String r5 = "ovid"
                            boolean r5 = r12.equals(r5)
                            if (r5 == 0) goto L_0x039e
                            java.lang.String r3 = r1.getString(r3)
                            java.lang.String r1 = r1.getString(r2)
                            boolean r2 = r3.equals(r14)
                            java.lang.String r5 = "bookId"
                            if (r2 == 0) goto L_0x0336
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            java.lang.String r6 = "Select * from TOC where id="
                            r3.append(r6)
                            r3.append(r1)
                            java.lang.String r1 = r3.toString()
                            java.util.ArrayList r1 = r2.V(r4, r1)
                            android.os.Bundle r1 = r2.s1(r1)
                            java.lang.String r2 = "leaf"
                            java.lang.String r2 = r1.getString(r2)
                            boolean r2 = r2.equals(r11)
                            if (r2 == 0) goto L_0x0319
                            android.os.Bundle r8 = new android.os.Bundle
                            r8.<init>()
                            java.lang.String r2 = "gotoSection"
                            r8.putBundle(r2, r1)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r2.P4
                            java.lang.String r5 = r1.getString(r5)
                            r6 = 0
                            r7 = 0
                            r3.B1(r4, r5, r6, r7, r8)
                            goto L_0x0744
                        L_0x0319:
                            android.os.Bundle r2 = new android.os.Bundle
                            r2.<init>()
                            r2.putBundle(r10, r4)
                            r5 = r19
                            java.lang.String r1 = r1.getString(r5)
                            r2.putString(r9, r1)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r1 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r1 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r1 = r1.P4
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.OVID.OvidChaptersActivity> r3 = net.imedicaldoctor.imd.Fragments.OVID.OvidChaptersActivity.class
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.OVID.OvidChaptersActivity$OvidChaptersFragment> r4 = net.imedicaldoctor.imd.Fragments.OVID.OvidChaptersActivity.OvidChaptersFragment.class
                            goto L_0x010c
                        L_0x0336:
                            boolean r2 = r3.equals(r11)
                            if (r2 == 0) goto L_0x033e
                            goto L_0x01c8
                        L_0x033e:
                            boolean r2 = r3.equals(r7)
                            if (r2 == 0) goto L_0x0346
                            goto L_0x0744
                        L_0x0346:
                            boolean r2 = r3.equals(r13)
                            if (r2 == 0) goto L_0x0378
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            java.lang.String r6 = "select * from images where imagename='"
                            r3.append(r6)
                            r3.append(r1)
                            java.lang.String r1 = "'"
                            r3.append(r1)
                            java.lang.String r1 = r3.toString()
                            java.util.ArrayList r1 = r2.V(r4, r1)
                            android.os.Bundle r1 = r2.n1(r1)
                            if (r1 == 0) goto L_0x0744
                        L_0x0372:
                            java.lang.String r2 = r1.getString(r5)
                            goto L_0x01ff
                        L_0x0378:
                            boolean r2 = r3.equals(r8)
                            if (r2 == 0) goto L_0x0744
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            r3.append(r6)
                            r3.append(r1)
                            java.lang.String r1 = r3.toString()
                            java.util.ArrayList r1 = r2.V(r4, r1)
                            android.os.Bundle r1 = r2.n1(r1)
                            if (r1 == 0) goto L_0x0744
                            goto L_0x0372
                        L_0x039e:
                            r5 = r19
                            java.lang.String r6 = "epub"
                            boolean r6 = r12.equals(r6)
                            if (r6 == 0) goto L_0x03ee
                            java.lang.String r3 = r1.getString(r3)
                            java.lang.String r2 = r1.getString(r2)
                            r6 = r18
                            java.lang.String r1 = r1.getString(r6)
                            boolean r5 = r3.equals(r11)
                            if (r5 == 0) goto L_0x03d5
                            android.os.Bundle r1 = new android.os.Bundle
                            r1.<init>()
                            r1.putBundle(r10, r4)
                            r1.putString(r9, r2)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivity> r3 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivity.class
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment> r4 = net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment.class
                            r2.N(r3, r4, r1)
                            goto L_0x03e5
                        L_0x03d5:
                            boolean r3 = r3.equals(r14)
                            if (r3 == 0) goto L_0x03e5
                        L_0x03db:
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r3 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r3 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r3.P4
                            r5 = 0
                            r3.A1(r4, r2, r5, r1)
                        L_0x03e5:
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r1 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r1 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            r1.V2()
                            goto L_0x0744
                        L_0x03ee:
                            r6 = r18
                            java.lang.String r7 = "nejm"
                            boolean r7 = r12.equals(r7)
                            if (r7 == 0) goto L_0x040b
                            java.lang.String r3 = r1.getString(r3)
                            java.lang.String r2 = r1.getString(r2)
                            java.lang.String r1 = r1.getString(r6)
                            boolean r3 = r3.equals(r11)
                            if (r3 == 0) goto L_0x03e5
                            goto L_0x03db
                        L_0x040b:
                            java.lang.String r4 = "epocrate"
                            boolean r4 = r12.equals(r4)
                            java.lang.String r6 = "typeText"
                            if (r4 == 0) goto L_0x04af
                            java.lang.String r3 = r1.getString(r6)
                            java.lang.String r1 = r1.getString(r2)
                            java.lang.String r2 = "Dx"
                            boolean r2 = r3.equals(r2)
                            if (r2 == 0) goto L_0x0436
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r2.P4
                            android.os.Bundle r2 = r2.h4
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            java.lang.String r5 = "dx-"
                            goto L_0x04ca
                        L_0x0436:
                            java.lang.String r2 = "Rx"
                            boolean r2 = r3.equals(r2)
                            if (r2 == 0) goto L_0x044f
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r2.P4
                            android.os.Bundle r2 = r2.h4
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            java.lang.String r5 = "rx-"
                            goto L_0x04ca
                        L_0x044f:
                            java.lang.String r2 = "ID"
                            boolean r2 = r3.equals(r2)
                            if (r2 == 0) goto L_0x0467
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r2.P4
                            android.os.Bundle r2 = r2.h4
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            java.lang.String r5 = "id-"
                            goto L_0x04ca
                        L_0x0467:
                            java.lang.String r2 = "Lab"
                            boolean r2 = r3.equals(r2)
                            if (r2 == 0) goto L_0x047f
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r2.P4
                            android.os.Bundle r2 = r2.h4
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            java.lang.String r5 = "lab-"
                            goto L_0x04ca
                        L_0x047f:
                            java.lang.String r2 = "Guideline"
                            boolean r2 = r3.equals(r2)
                            if (r2 == 0) goto L_0x0497
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r2.P4
                            android.os.Bundle r2 = r2.h4
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            java.lang.String r5 = "guideline-"
                            goto L_0x04ca
                        L_0x0497:
                            java.lang.String r2 = "Table"
                            boolean r2 = r3.equals(r2)
                            if (r2 == 0) goto L_0x0744
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r2.P4
                            android.os.Bundle r2 = r2.h4
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            java.lang.String r5 = "table-"
                            goto L_0x04ca
                        L_0x04af:
                            java.lang.String r4 = "amirsys"
                            boolean r4 = r12.equals(r4)
                            if (r4 == 0) goto L_0x04da
                            java.lang.String r1 = r1.getString(r2)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r2.P4
                            android.os.Bundle r2 = r2.h4
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            java.lang.String r5 = "menu,,,"
                        L_0x04ca:
                            r4.append(r5)
                            r4.append(r1)
                            java.lang.String r1 = r4.toString()
                        L_0x04d4:
                            r4 = 0
                        L_0x04d5:
                            r3.A1(r2, r1, r4, r4)
                            goto L_0x0744
                        L_0x04da:
                            java.lang.String r4 = "statdx"
                            boolean r4 = r12.equals(r4)
                            if (r4 == 0) goto L_0x051c
                            java.lang.String r2 = r1.getString(r2)
                            java.lang.String r1 = r1.getString(r3)
                            boolean r3 = r1.equals(r13)
                            if (r3 != 0) goto L_0x050b
                            java.lang.String r3 = "6"
                            boolean r1 = r1.equals(r3)
                            if (r1 == 0) goto L_0x04f9
                            goto L_0x050b
                        L_0x04f9:
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            r1.<init>()
                            java.lang.String r3 = "menu,,,"
                        L_0x0500:
                            r1.append(r3)
                            r1.append(r2)
                            java.lang.String r1 = r1.toString()
                            goto L_0x0513
                        L_0x050b:
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            r1.<init>()
                            java.lang.String r3 = "case,,,"
                            goto L_0x0500
                        L_0x0513:
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r2.P4
                            android.os.Bundle r2 = r2.h4
                            goto L_0x04d4
                        L_0x051c:
                            r4 = 0
                            java.lang.String r3 = "martindale"
                            boolean r3 = r12.equals(r3)
                            if (r3 == 0) goto L_0x0532
                            java.lang.String r1 = r1.getString(r2)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r2.P4
                            android.os.Bundle r2 = r2.h4
                            goto L_0x04d5
                        L_0x0532:
                            java.lang.String r3 = "micromedex-neofax"
                            boolean r3 = r12.equals(r3)
                            if (r3 == 0) goto L_0x0579
                            java.lang.String r2 = r1.getString(r2)
                            java.lang.String r1 = r1.getString(r6)
                            java.lang.String r3 = "Drug"
                            boolean r1 = r1.equals(r3)
                            if (r1 == 0) goto L_0x0569
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r1 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r1 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r1.P4
                            android.os.Bundle r1 = r1.h4
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            java.lang.String r5 = "drug-"
                        L_0x0559:
                            r4.append(r5)
                            r4.append(r2)
                            java.lang.String r2 = r4.toString()
                            r4 = 0
                            r3.A1(r1, r2, r4, r4)
                            goto L_0x0744
                        L_0x0569:
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r1 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r1 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r1.P4
                            android.os.Bundle r1 = r1.h4
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            java.lang.String r5 = "formula-"
                            goto L_0x0559
                        L_0x0579:
                            java.lang.String r3 = "sanford"
                            boolean r3 = r12.equals(r3)
                            if (r3 == 0) goto L_0x05a8
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r4 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r4 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r4 = r4.P4
                            java.lang.String r1 = r1.getString(r2)
                            java.lang.String r2 = "/"
                            java.lang.String[] r1 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r1, r2)
                            java.lang.String r1 = r4.t1(r1)
                            r3.append(r1)
                            java.lang.String r1 = ".html"
                            r3.append(r1)
                            java.lang.String r1 = r3.toString()
                            goto L_0x0513
                        L_0x05a8:
                            java.lang.String r3 = "mksap"
                            boolean r3 = r12.equals(r3)
                            if (r3 == 0) goto L_0x05e8
                            java.lang.String r2 = r1.getString(r2)
                            java.lang.String r3 = "_"
                            java.lang.String[] r3 = org.apache.commons.lang3.StringUtils.splitByWholeSeparator(r2, r3)
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            java.lang.String r5 = "groups/"
                            r4.append(r5)
                            r5 = 2
                            r3 = r3[r5]
                            r4.append(r3)
                            java.lang.String r3 = "/"
                            r4.append(r3)
                            java.lang.String r1 = r1.getString(r6)
                            java.lang.String r1 = r1.toLowerCase()
                            r4.append(r1)
                            java.lang.String r1 = "s/"
                            r4.append(r1)
                            r4.append(r2)
                            java.lang.String r1 = r4.toString()
                            goto L_0x0513
                        L_0x05e8:
                            java.lang.String r3 = "cme"
                            boolean r3 = r12.equals(r3)
                            if (r3 == 0) goto L_0x06be
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            android.os.Bundle r2 = r2.h4
                            r3 = r17
                            java.lang.String r4 = r1.getString(r3)
                            java.lang.String r6 = "temp"
                            java.lang.String r2 = net.imedicaldoctor.imd.Data.CompressHelper.h1(r2, r4, r6)
                            java.lang.String r4 = "dbname"
                            boolean r4 = r1.containsKey(r4)
                            if (r4 == 0) goto L_0x0634
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            android.os.Bundle r2 = r2.h4
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder
                            r4.<init>()
                            java.lang.String r6 = "dbname"
                            java.lang.String r6 = r1.getString(r6)
                            r4.append(r6)
                            java.lang.String r6 = "-"
                            r4.append(r6)
                            java.lang.String r3 = r1.getString(r3)
                            r4.append(r3)
                            java.lang.String r3 = r4.toString()
                            java.lang.String r4 = "temp"
                            java.lang.String r2 = net.imedicaldoctor.imd.Data.CompressHelper.h1(r2, r3, r4)
                        L_0x0634:
                            java.io.File r3 = new java.io.File
                            r3.<init>(r2)
                            boolean r3 = r3.exists()
                            if (r3 != 0) goto L_0x0676
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            androidx.fragment.app.FragmentActivity r2 = r2.V1()
                            java.lang.String r3 = "Video is not downloaded"
                            r4 = 0
                            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r4)
                            r2.show()
                            android.os.Bundle r2 = new android.os.Bundle
                            r2.<init>()
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r3 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r3 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            android.os.Bundle r3 = r3.h4
                            r2.putBundle(r10, r3)
                            java.lang.String r3 = "tocId"
                            java.lang.String r1 = r1.getString(r3)
                            r2.putString(r9, r1)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r1 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r1 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r1 = r1.P4
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.CMEInfo.CMETOC> r3 = net.imedicaldoctor.imd.Fragments.CMEInfo.CMETOC.class
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.CMEInfo.CMETOCFragment> r4 = net.imedicaldoctor.imd.Fragments.CMEInfo.CMETOCFragment.class
                            r1.N(r3, r4, r2)
                            return
                        L_0x0676:
                            android.content.Intent r3 = new android.content.Intent
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r4 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r4 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            androidx.fragment.app.FragmentActivity r4 = r4.V1()
                            java.lang.Class<net.imedicaldoctor.imd.Fragments.CMEInfo.Player> r6 = net.imedicaldoctor.imd.Fragments.CMEInfo.Player.class
                            r3.<init>(r4, r6)
                            java.lang.String r4 = "Address"
                            r3.putExtra(r4, r2)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            android.os.Bundle r2 = r2.h4
                            r3.putExtra(r10, r2)
                            java.lang.String r2 = "position"
                            java.lang.String r2 = r1.getString(r2)
                            java.lang.String r4 = ""
                            if (r2 != r4) goto L_0x069e
                            goto L_0x069f
                        L_0x069e:
                            r14 = r2
                        L_0x069f:
                            java.lang.String r2 = "Location"
                            java.lang.Long r4 = java.lang.Long.valueOf(r14)
                            r3.putExtra(r2, r4)
                            java.lang.String r2 = "VideoID"
                            java.lang.String r1 = r1.getString(r5)
                            r3.putExtra(r2, r1)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r1 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r1 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            androidx.fragment.app.FragmentActivity r1 = r1.V1()
                            r1.startActivity(r3)
                            goto L_0x0744
                        L_0x06be:
                            java.lang.String r1 = r1.getString(r2)
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r3 = r2.P4
                            android.os.Bundle r2 = r2.h4
                            r5 = 0
                            r3.A1(r2, r1, r5, r5)
                            goto L_0x0744
                        L_0x06d0:
                            java.lang.String r3 = r1.getString(r3)
                            java.lang.String r1 = r1.getString(r2)
                            boolean r2 = r3.equals(r11)
                            if (r2 == 0) goto L_0x06e8
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            r2.A1(r4, r1, r5, r5)
                            goto L_0x0744
                        L_0x06e8:
                            boolean r2 = r3.equals(r13)
                            if (r2 == 0) goto L_0x071c
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            java.lang.String r5 = "select * from images where id='"
                            r3.append(r5)
                            r3.append(r1)
                            java.lang.String r1 = "'"
                            r3.append(r1)
                            java.lang.String r1 = r3.toString()
                            java.util.ArrayList r1 = r2.V(r4, r1)
                            android.os.Bundle r1 = r2.n1(r1)
                            if (r1 == 0) goto L_0x0744
                            r2 = r16
                        L_0x0716:
                            java.lang.String r2 = r1.getString(r2)
                            goto L_0x01ff
                        L_0x071c:
                            boolean r2 = r3.equals(r8)
                            if (r2 == 0) goto L_0x0744
                            net.imedicaldoctor.imd.Fragments.searchFragment$SearchAdapter r2 = net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.this
                            net.imedicaldoctor.imd.Fragments.searchFragment r2 = net.imedicaldoctor.imd.Fragments.searchFragment.this
                            net.imedicaldoctor.imd.Data.CompressHelper r2 = r2.P4
                            java.lang.StringBuilder r3 = new java.lang.StringBuilder
                            r3.<init>()
                            r3.append(r6)
                            r3.append(r1)
                            java.lang.String r1 = r3.toString()
                            java.util.ArrayList r1 = r2.V(r4, r1)
                            android.os.Bundle r1 = r2.n1(r1)
                            if (r1 == 0) goto L_0x0744
                            r2 = r21
                            goto L_0x0716
                        L_0x0744:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.searchFragment.SearchAdapter.AnonymousClass1.onClick(android.view.View):void");
                    }
                });
            }
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 1) {
                return new EmptyViewHolder(LayoutInflater.from(this.f30207d).inflate(R.layout.f1325list_view_item_header_keeper, viewGroup, false));
            }
            View inflate = LayoutInflater.from(this.f30207d).inflate(R.layout.f1358list_view_item_search_ripple, viewGroup, false);
            searchFragment searchfragment = searchFragment.this;
            return new SearchItemViewHolder(searchfragment.r(), inflate);
        }

        public int b() {
            searchFragment searchfragment = searchFragment.this;
            return searchfragment.D3(searchfragment.C4);
        }

        public RecyclerView.ViewHolder o(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(this.f30207d).inflate(R.layout.f1357list_view_item_search_header, viewGroup, false);
            searchFragment searchfragment = searchFragment.this;
            return new SearchHeaderViewHolder(searchfragment.r(), inflate);
        }

        public void p(RecyclerView.ViewHolder viewHolder, int i2) {
            SearchHeaderViewHolder searchHeaderViewHolder = (SearchHeaderViewHolder) viewHolder;
            if (searchFragment.this.C4 != null) {
                viewHolder.f15587a.setTag(Integer.valueOf(i2));
                searchFragment searchfragment = searchFragment.this;
                Bundle bundle = searchfragment.j3(i2, searchfragment.C4).getBundle("Database");
                searchHeaderViewHolder.J.setText(bundle.getString("Title"));
                String C = CompressHelper.C(bundle);
                if (C.contains("file:///android_asset/")) {
                    try {
                        InputStream open = searchFragment.this.r().getAssets().open(C.replace("file:///android_asset/", ""));
                        searchHeaderViewHolder.I.setImageBitmap(BitmapFactory.decodeStream(open));
                        open.close();
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        e2.printStackTrace();
                    }
                } else {
                    searchHeaderViewHolder.I.setImageURI(Uri.parse(C));
                }
            }
        }

        public long r(int i2) {
            searchFragment searchfragment = searchFragment.this;
            return (long) searchfragment.i3(i2, searchfragment.C4);
        }
    }

    public class SearchHeaderViewHolder extends RecyclerView.ViewHolder {
        public ImageView I;
        public TextView J;
        public ImageView K;

        public SearchHeaderViewHolder(Context context, View view) {
            super(view);
            this.J = (TextView) view.findViewById(R.id.f896database_title);
            this.I = (ImageView) view.findViewById(R.id.f893database_image);
            this.K = (ImageView) view.findViewById(R.id.icon);
        }
    }

    public class SearchItemViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public TextView J;
        public MaterialRippleLayout K;

        public SearchItemViewHolder(Context context, View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1136title_text);
            this.J = (TextView) view.findViewById(R.id.f1098subtitle_text);
            this.K = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        }
    }

    /* access modifiers changed from: private */
    public Bundle A3(Bundle bundle) {
        String str;
        String str2;
        Bundle bundle2 = new Bundle();
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(bundle.getString("docId"), "|");
        String[] splitByWholeSeparator2 = StringUtils.splitByWholeSeparator(bundle.getString(HTML.Tag.V), "|");
        for (int i2 = 0; i2 < splitByWholeSeparator.length; i2++) {
            if (splitByWholeSeparator2.length > i2) {
                str = splitByWholeSeparator[i2];
                str2 = splitByWholeSeparator2[i2];
            } else {
                str = splitByWholeSeparator[i2];
                str2 = "";
            }
            bundle2.putString(str, str2);
        }
        return bundle2;
    }

    public void B3() {
        if (this.B4) {
            this.D4.A1(this.L4);
            this.B4 = false;
        }
    }

    public void C3() {
        StickyRecyclerHeadersTouchListener stickyRecyclerHeadersTouchListener = new StickyRecyclerHeadersTouchListener(this.D4, this.L4);
        this.O4 = stickyRecyclerHeadersTouchListener;
        stickyRecyclerHeadersTouchListener.h(new StickyRecyclerHeadersTouchListener.OnHeaderClickListener() {
            public void a(View view, int i2, long j2) {
                String string = ((Bundle) searchFragment.this.C4.get((int) j2)).getBundle("database").getString("Name");
                if (searchFragment.this.N4.contains(string)) {
                    searchFragment.this.N4.remove(string);
                } else {
                    searchFragment.this.N4.add(string);
                }
                searchFragment.this.D4.getAdapter().G();
            }
        });
        this.D4.s(this.O4);
        y3();
        this.D4.setAdapter(this.A4);
        this.A4.Z(new RecyclerView.AdapterDataObserver() {
            public void a() {
                searchFragment.this.L4.n();
            }
        });
    }

    public int D3(ArrayList<Bundle> arrayList) {
        int i2 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<Bundle> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            i2 += this.N4.contains(next.getBundle("database").getString("Name")) ? 1 : next.getParcelableArrayList("items").size();
        }
        return i2;
    }

    public void T0(Menu menu, MenuInflater menuInflater) {
        try {
            r().setTitle("");
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        menuInflater.inflate(R.menu.f1494search, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
        this.s4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        MenuItem findItem = menu.findItem(R.id.f1045progress_menu);
        this.J4 = findItem;
        this.I4 = (ProgressBar) findItem.getActionView();
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Search Anything");
        final String str = this.K4;
        this.s4.postDelayed(new Runnable() {
            public void run() {
                searchFragment.this.s4.k0(str, false);
                String str = searchFragment.this.f4;
                if (str != null && str.length() > 0) {
                    if (searchFragment.this.C4 == null || searchFragment.this.C4.size() == 0) {
                        searchFragment searchfragment = searchFragment.this;
                        searchfragment.s4.k0(searchfragment.f4, true);
                    } else {
                        searchFragment searchfragment2 = searchFragment.this;
                        searchfragment2.s4.k0(searchfragment2.f4, false);
                        searchFragment.this.e3();
                    }
                    searchFragment.this.V2();
                }
            }
        }, 10);
        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            public boolean a(int i2) {
                Cursor c2 = searchFragment.this.s4.getSuggestionsAdapter().c();
                if (!c2.moveToPosition(i2)) {
                    return false;
                }
                String string = c2.getString(c2.getColumnIndex("word"));
                if (searchFragment.this.s4.getTag(1) != null && ((String) searchFragment.this.s4.getTag(1)).length() > 0) {
                    string = searchFragment.this.s4.getTag() + StringUtils.SPACE + string;
                }
                searchFragment.this.s4.k0(string, true);
                return false;
            }

            public boolean b(int i2) {
                Cursor c2 = searchFragment.this.s4.getSuggestionsAdapter().c();
                if (!c2.moveToPosition(i2)) {
                    return false;
                }
                String string = c2.getString(c2.getColumnIndex("word"));
                if (searchFragment.this.s4.getTag() != null && ((String) searchFragment.this.s4.getTag()).length() > 0) {
                    string = searchFragment.this.s4.getTag() + StringUtils.SPACE + string;
                }
                searchFragment.this.s4.k0(string, true);
                return false;
            }
        });
        ((ImageView) searchView.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                searchFragment.this.s4.k0("", false);
                searchFragment.this.s4.clearFocus();
                searchFragment.this.f3("Search Anything");
                searchFragment.this.V2();
            }
        });
        searchView.setSuggestionsAdapter(new CursorAdapter(r(), (Cursor) null, 0) {
            public void e(View view, Context context, Cursor cursor) {
                ((TextView) view.getTag()).setText(cursor.getString(cursor.getColumnIndex("word")));
            }

            public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.f1374list_view_item_spell, viewGroup, false);
                inflate.setTag(inflate.findViewById(R.id.text));
                return inflate;
            }
        });
        Observable.w1(new ObservableOnSubscribe<String>() {
            public void a(@NonNull final ObservableEmitter<String> observableEmitter) throws Throwable {
                searchFragment.this.s4.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                    /* renamed from: a  reason: collision with root package name */
                    private DisposableObserver<Bundle> f30200a;

                    public boolean a(String str) {
                        observableEmitter.onNext(str);
                        return true;
                    }

                    public boolean b(final String str) {
                        iMDLogger.j("OnQueryTextSubmit", "OnQueryTextSubmit");
                        String unused = searchFragment.this.K4 = str;
                        searchFragment.this.f4 = str;
                        DisposableObserver<Bundle> disposableObserver = this.f30200a;
                        if (disposableObserver != null) {
                            disposableObserver.onComplete();
                        }
                        observableEmitter.onNext("SoheilvbSoheilvbSoheilvb");
                        searchFragment.this.P4.I(str, "SearchAll");
                        iMDLogger.j("OnQueryTextSubmit", "Building search observable");
                        Observable A4 = Observable.w1(new ObservableOnSubscribe<Bundle>() {
                            public void a(@NonNull ObservableEmitter<Bundle> observableEmitter) throws Throwable {
                                Iterator<Bundle> it2 = CompressHelper.t.iterator();
                                while (it2.hasNext()) {
                                    Bundle next = it2.next();
                                    ArrayList<Bundle> k3 = searchFragment.this.k3(next, str);
                                    if (!(k3 == null || k3.size() == 0)) {
                                        iMDLogger.j("Search", "Result from " + next.getString("Title") + " : " + k3.size());
                                        Bundle bundle = new Bundle();
                                        bundle.putBundle("database", next);
                                        bundle.putParcelableArrayList("items", k3);
                                        observableEmitter.onNext(bundle);
                                    }
                                }
                                observableEmitter.onComplete();
                            }
                        }).h6(Schedulers.e()).s4(AndroidSchedulers.e()).A4(new Function<Throwable, Bundle>() {
                            /* renamed from: a */
                            public Bundle apply(Throwable th) throws Throwable {
                                return null;
                            }
                        });
                        Observable unused2 = searchFragment.this.G4 = A4;
                        AnonymousClass3 r0 = new DisposableObserver<Bundle>() {
                            /* access modifiers changed from: protected */
                            public void a() {
                                super.a();
                                searchFragment.this.J4.setVisible(true);
                                searchFragment.this.I4.setIndeterminate(true);
                                iMDLogger.j("SearchSubscriber", "On Start");
                                ArrayList unused = searchFragment.this.C4 = new ArrayList();
                                searchFragment.this.C3();
                                searchFragment.this.V2();
                                searchFragment.this.s4.getSuggestionsAdapter().m((Cursor) null);
                                searchFragment.this.f3("Searching");
                            }

                            /* renamed from: c */
                            public void onNext(@NonNull Bundle bundle) {
                                searchFragment.this.C4.add(bundle);
                                searchFragment.this.e3();
                                StringBuilder sb = new StringBuilder();
                                sb.append("On Next - ");
                                sb.append(bundle.getBundle("database").getString("Title"));
                                sb.append(" - ");
                                searchFragment searchfragment = searchFragment.this;
                                sb.append(searchfragment.D3(searchfragment.C4));
                                sb.append(" - IN Thread :");
                                sb.append(Thread.currentThread());
                                iMDLogger.j("SearchSubscriber", sb.toString());
                            }

                            public void onComplete() {
                                searchFragment.this.J4.setVisible(false);
                                iMDLogger.j("SearchSubscriber", "On Complete");
                                if (searchFragment.this.C4 == null || searchFragment.this.C4.size() == 0) {
                                    searchFragment.this.f3("Nothing Found");
                                }
                                if (searchFragment.this.V1().getSharedPreferences("default_preferences", 0).getBoolean("SearchCollapsed", false)) {
                                    searchFragment.this.z3();
                                }
                            }

                            public void onError(@NonNull Throwable th) {
                                searchFragment.this.J4.setVisible(false);
                                iMDLogger.j("SearchSubscriber", "On Error");
                                iMDLogger.f("onQueryTextSubmit", "Some error on SearchObservable");
                            }
                        };
                        this.f30200a = r0;
                        DisposableObserver unused3 = searchFragment.this.H4 = r0;
                        A4.a(this.f30200a);
                        return true;
                    }
                });
            }
        }).x1(500, TimeUnit.MILLISECONDS).a(new DisposableObserver<String>() {
            /* renamed from: c */
            public void onNext(@NonNull String str) {
                if (str.equals("SoheilvbSoheilvbSoheilvb")) {
                    searchFragment.this.s4.getSuggestionsAdapter().m((Cursor) null);
                } else if (str.length() > 1) {
                    String[] split = str.trim().split(StringUtils.SPACE);
                    String str2 = split[split.length - 1];
                    String str3 = "";
                    for (int i2 = 0; i2 < split.length - 1; i2++) {
                        str3 = str3 + StringUtils.SPACE + split[i2];
                    }
                    searchFragment.this.s4.setTag(str3.trim());
                    CompressHelper compressHelper = searchFragment.this.P4;
                    compressHelper.c0(compressHelper.A(), "Select rowid as _id,word from spell where word match '" + str2 + "*'").h6(Schedulers.e()).s4(AndroidSchedulers.e()).d6(new Consumer<ArrayList<Bundle>>() {
                        /* renamed from: a */
                        public void accept(ArrayList<Bundle> arrayList) throws Throwable {
                            searchFragment.this.s4.getSuggestionsAdapter().m(searchFragment.this.P4.h(arrayList));
                        }
                    });
                }
            }

            public void onComplete() {
            }

            public void onError(@NonNull Throwable th) {
            }
        });
        r().setTitle("");
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.q4;
        if (view != null) {
            return view;
        }
        this.P4 = new CompressHelper(r());
        View inflate = layoutInflater.inflate(R.layout.f1265fragment_search, viewGroup, false);
        this.q4 = inflate;
        if (bundle != null && bundle.containsKey("Position")) {
            this.e4 = bundle.getInt("Position");
        }
        if (bundle != null && bundle.containsKey("Query")) {
            this.f4 = bundle.getString("Query");
        }
        if (bundle != null && bundle.containsKey("mIsSubmitted")) {
            this.F4 = bundle.getBoolean("mIsSubmitted");
        }
        this.N4 = new ArrayList<>();
        this.D4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        this.C4 = new ArrayList<>();
        if (bundle != null && bundle.containsKey("mResults")) {
            this.C4 = bundle.getParcelableArrayList("mResults");
        }
        SearchAdapter searchAdapter = new SearchAdapter(r());
        this.A4 = searchAdapter;
        this.L4 = new StickyRecyclerHeadersDecoration(searchAdapter, new ItemVisibilityAdapter() {
            public boolean a(int i2) {
                searchFragment searchfragment = searchFragment.this;
                LinearLayoutManager unused = searchfragment.M4 = (LinearLayoutManager) searchfragment.D4.getLayoutManager();
                searchFragment.this.M4.B2();
                searchFragment.this.M4.E2();
                boolean z = searchFragment.this.M4.B2() <= i2 && searchFragment.this.M4.E2() >= i2;
                Boolean valueOf = Boolean.valueOf(z);
                iMDLogger.f(CSS.Property.m0, i2 + " visible + " + valueOf);
                return z;
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(r());
        this.M4 = linearLayoutManager;
        this.D4.setLayoutManager(linearLayoutManager);
        this.D4.setItemAnimator(new DefaultItemAnimator());
        this.D4.setItemDecoration(new CustomItemDecoration(r()));
        o2(true);
        f3("Search Titles");
        return inflate;
    }

    public void e3() {
        RecyclerView.Adapter adapter = this.D4.getAdapter();
        SearchAdapter searchAdapter = this.A4;
        if (adapter != searchAdapter) {
            this.L4.n();
            this.D4.setAdapter(this.A4);
            return;
        }
        searchAdapter.G();
    }

    public void f3(String str) {
        try {
            if (!str.equals("Searching")) {
                this.L4.n();
                B3();
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        this.D4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
        this.D4.setAdapter(new StatusAdapter(r(), str));
    }

    public void g1() {
        super.g1();
    }

    public int i3(int i2, ArrayList<Bundle> arrayList) {
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            Bundle bundle = arrayList.get(i4);
            i3 += this.N4.contains(bundle.getBundle("database").getString("Name")) ? 1 : bundle.getParcelableArrayList("items").size();
            if (i2 < i3) {
                return i4;
            }
        }
        return 0;
    }

    public Bundle j3(int i2, ArrayList<Bundle> arrayList) {
        Iterator<Bundle> it2 = arrayList.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            Bundle next = it2.next();
            String string = next.getBundle("database").getString("Name");
            int size = this.N4.contains(string) ? 1 : next.getParcelableArrayList("items").size();
            i3 += size;
            if (i2 < i3) {
                int i4 = i2 - (i3 - size);
                Bundle bundle = new Bundle();
                bundle.putBundle("Database", next.getBundle("database"));
                if (this.N4.contains(string)) {
                    if (i4 == 0) {
                        return bundle;
                    }
                    i4--;
                }
                bundle.putBundle("Item", (Bundle) next.getParcelableArrayList("items").get(i4));
                return bundle;
            }
        }
        return null;
    }

    public ArrayList<Bundle> k3(Bundle bundle, String str) {
        CompressHelper compressHelper;
        String str2;
        CompressHelper compressHelper2;
        String str3;
        CompressHelper compressHelper3;
        String str4;
        String replace = str.replace("'", "''");
        String string = bundle.getString("Type");
        try {
            if (!string.equals("lexi")) {
                if (string.equals("skyscape")) {
                    compressHelper = this.P4;
                    str2 = "Select id as id, indexName as text,indexType as subText,section  from search where indexName match '" + replace + "'";
                } else if (string.equals("medhand")) {
                    compressHelper3 = this.P4;
                    str4 = "select Text as text, \"table\" as subText, URL from search where text match '" + replace + "'";
                } else if (string.equals("infopoems")) {
                    return null;
                } else {
                    if (string.equals("irandarou")) {
                        compressHelper = this.P4;
                        str2 = "Select drugId, drug as text, '' as subText from Search where drug match '" + replace + "' order by drug asc";
                    } else if (string.equals("uptodateddx")) {
                        compressHelper = this.P4;
                        str2 = "Select id, diagnosis as text, isMain from search where diagnosis match '" + replace + "' order by isMain desc";
                    } else if (string.equals("labvalues")) {
                        compressHelper = this.P4;
                        str2 = "Select id,shortName, longName, subtitle, value, shortName as text, subtitle as subText from search where search match 'shortName:" + replace + " OR longName:" + replace + "'";
                    } else if (string.equals("visualdx")) {
                        compressHelper = this.P4;
                        str2 = "Select id,dName as text,'' as subText from DiagnosesSearch where dNameSearch match '" + replace + "' order by dName asc";
                    } else if (string.equals("uptodate")) {
                        compressHelper3 = this.P4;
                        str4 = "select Text as text, \"table\" as subText,URL, related_topic from search where search match 'text:" + replace + " OR subText:" + replace + "'";
                    } else if (string.equals("accessmedicine")) {
                        compressHelper = this.P4;
                        str2 = "Select text, typeText as subText, type, contentId from Search where search match 'text:" + replace + " NOT type:5'";
                    } else if (string.equals("lww")) {
                        compressHelper = this.P4;
                        str2 = "Select text, typeText as subText, type, contentId from Search where search match 'text:" + replace + " NOT (type:5 OR type:0)'";
                    } else {
                        if (!string.equals("elsevier")) {
                            if (!string.equals("elseviernew")) {
                                if (string.equals("ovid")) {
                                    compressHelper = this.P4;
                                    str2 = "Select text, typeText as subText, type, contentId from Search where search match 'text:" + replace + " NOT type:5 NOT type:0'";
                                } else if (string.equals("epub")) {
                                    compressHelper = this.P4;
                                    str2 = "Select text, typeText as subText, type, contentId, section from Search where search match 'text:" + replace + " NOT type:5'";
                                } else if (string.equals("nejm")) {
                                    compressHelper = this.P4;
                                    str2 = "Select text, typeText as subText, type, contentId, section from Search where search match 'text:" + replace + " AND type:1'";
                                } else if (string.equals("epocrate")) {
                                    compressHelper = this.P4;
                                    str2 = "Select text, typeText as subText,typeText, type, contentId from Search where search match 'text:" + replace + " NOT type:5'";
                                } else if (string.equals("amirsys")) {
                                    compressHelper = this.P4;
                                    str2 = "Select text  || ' - ' || content as text, typeText as subText, type, contentId from Search where search match 'text:" + replace + " AND type:1' order by type asc";
                                } else if (string.equals("statdx")) {
                                    compressHelper = this.P4;
                                    str2 = "Select text  as text,content as subText, typeText, type, contentId from Search where search match '(text:" + replace + "*) AND (type:1 OR type:3)' order by type asc";
                                } else if (string.equals("martindale")) {
                                    compressHelper = this.P4;
                                    str2 = "Select distinct(text)  as text,content as subText, typeText, type, contentId from Search where search match '(text:" + replace + "*) AND (type:1)' ";
                                } else if (string.equals("facts")) {
                                    compressHelper = this.P4;
                                    str2 = "Select text  as text,content as subText, typeText, type, contentId from Search where search match '(text:" + replace + "*) AND (type:1)'";
                                } else {
                                    if (string.equals("micromedex-drug")) {
                                        compressHelper2 = this.P4;
                                        str3 = "Select text, content as subText, type, contentId from Search where search match 'text:" + replace + " NOT type:5'";
                                    } else if (string.equals("micromedex-neofax")) {
                                        compressHelper2 = this.P4;
                                        str3 = "Select text, typeText as subText, typeText, type, contentId from Search where search match 'text:" + replace + " NOT type:5'";
                                    } else if (string.equals("sanford")) {
                                        return this.P4.W(bundle, "Select title as text, '' as subText,path as contentId from Search_base where Search_base match 'title:" + replace + " OR subject:" + replace + "'", "fts.db");
                                    } else if (string.equals("noskhe")) {
                                        compressHelper = this.P4;
                                        str2 = "Select text  as text,content as subText, typeText, type, contentId from Search where search match '(text:" + replace + "*) AND (type:1)'";
                                    } else if (string.equals("stockley")) {
                                        compressHelper = this.P4;
                                        str2 = "Select text  as text,content as subText, typeText, type, contentId from Search where search match '(text:" + replace + "*) AND (type:1)'";
                                    } else if (string.equals("mksap")) {
                                        compressHelper = this.P4;
                                        str2 = "Select text  as text,content as subText, typeText, type, contentId from Search where search match '(text:" + replace + "*) AND (type:1) AND (typeText:Topic OR typeText:Question)'";
                                    } else if (!string.equals("cme")) {
                                        return null;
                                    } else {
                                        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(replace, StringUtils.SPACE);
                                        ArrayList arrayList = new ArrayList();
                                        for (String str5 : splitByWholeSeparator) {
                                            arrayList.add("title like '%" + str5 + "%'");
                                        }
                                        return this.P4.V(bundle, "SELECT medias.*, medias.title AS text, logs.position, logs.vDate, logs.duration AS dur, REPLACE(REPLACE(COALESCE(toc5.name || ' / ', '') || COALESCE(toc4.name || ' / ', '') || COALESCE(toc3.name || ' / ', '') || COALESCE(toc2.name || ' / ', '') || toc1.name, 'Videos / ', ''), 'Audios / ', '') AS subText FROM medias LEFT OUTER JOIN logs ON medias.id = logs.id LEFT OUTER JOIN TOC toc1 ON medias.tocId = toc1.id LEFT OUTER JOIN TOC toc2 ON toc1.parentId = toc2.id LEFT OUTER JOIN TOC toc3 ON toc2.parentId = toc3.id LEFT OUTER JOIN TOC toc4 ON toc3.parentId = toc4.id LEFT OUTER JOIN TOC toc5 ON toc4.parentId = toc5.id WHERE " + StringUtils.join((Iterable<?>) arrayList, " AND "));
                                    }
                                    return compressHelper2.W(bundle, str3, "fsearch.sqlite");
                                }
                            }
                        }
                        compressHelper = this.P4;
                        str2 = "Select text, typeText as subText, type, contentId from Search where search match 'text:" + replace + " NOT type:5'";
                    }
                }
                return compressHelper.V(bundle, str2);
            } else if (!new File(CompressHelper.g1(bundle, "fsearch.db")).exists()) {
                return null;
            } else {
                compressHelper3 = this.P4;
                str4 = "Select id, name as text, type as subText from search where name match '" + replace + "'";
            }
            return compressHelper3.W(bundle, str4, "fsearch.db");
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            e2.printStackTrace();
            iMDLogger.f("SearchInDB", "Error in searching " + bundle.getString("Title") + " : " + e2);
            return null;
        }
    }

    public void l1() {
        super.l1();
        V2();
    }

    public void m1(Bundle bundle) {
        super.m1(bundle);
    }

    public void y3() {
        if (!this.B4) {
            this.D4.setItemDecoration(this.L4);
            this.B4 = true;
        }
    }

    public void z3() {
        Bundle bundle;
        this.N4 = new ArrayList<>();
        Iterator<Bundle> it2 = this.C4.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            if (!(next == null || (bundle = next.getBundle("database")) == null)) {
                this.N4.add(bundle.getString("Name"));
            }
        }
        this.D4.getAdapter().G();
    }
}
