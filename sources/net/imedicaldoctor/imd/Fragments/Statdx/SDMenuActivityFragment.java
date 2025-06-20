package net.imedicaldoctor.imd.Fragments.Statdx;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.html.HTML;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.GridAutoFitLayoutManager;
import net.imedicaldoctor.imd.ViewHolders.ImageViewHolder;
import net.imedicaldoctor.imd.ViewHolders.NotStickySectionAdapter;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import net.imedicaldoctor.imd.iMDLogger;

public class SDMenuActivityFragment extends ViewerHelperFragment {
    public RecyclerView X4;
    public ArrayList<Bundle> Y4;
    public ArrayList<Bundle> Z4;
    public ArrayList<Bundle> a5;
    public DiagnosisAdapter b5;
    public Bundle c5;
    public ArrayList<Bundle> d5;
    public String e5;
    public ArrayList<String> f5;
    public NotStickySectionAdapter g5;
    public ArrayList<Bundle> h5;
    public ArrayList<Bundle> i5;
    public ArrayList<Bundle> j5;
    public ArrayList<Bundle> k5;
    public ArrayList<Bundle> l5;
    public ArrayList<Bundle> m5;
    public String n5;
    /* access modifiers changed from: private */
    public Bundle o5;

    public class DiagnosisAdapter extends RecyclerView.Adapter {

        /* renamed from: f  reason: collision with root package name */
        private static final int f29933f = 0;

        /* renamed from: g  reason: collision with root package name */
        private static final int f29934g = 1;

        /* renamed from: h  reason: collision with root package name */
        private static final int f29935h = 2;

        /* renamed from: d  reason: collision with root package name */
        public Context f29936d;

        public DiagnosisAdapter() {
        }

        public int C(int i2) {
            SDMenuActivityFragment sDMenuActivityFragment = SDMenuActivityFragment.this;
            Bundle I4 = sDMenuActivityFragment.I4(i2, sDMenuActivityFragment.f5);
            String string = I4.getString("Type");
            if (string.equals("Header")) {
                return 0;
            }
            if (string.equals("Item")) {
                return I4.getString("Section").equals("Images") ? 2 : 1;
            }
            return -1;
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            MaterialRippleLayout materialRippleLayout;
            View.OnClickListener r0;
            SDMenuActivityFragment sDMenuActivityFragment = SDMenuActivityFragment.this;
            Bundle I4 = sDMenuActivityFragment.I4(i2, sDMenuActivityFragment.f5);
            int F = viewHolder.F();
            if (F == 0) {
                ((HeaderCellViewHolder) viewHolder).I.setText(SDMenuActivityFragment.this.M4(I4.getString("Text")));
            } else if (F == 2) {
                RecyclerViewViewHolder recyclerViewViewHolder = (RecyclerViewViewHolder) viewHolder;
                recyclerViewViewHolder.I.setAdapter(SDMenuActivityFragment.this.g5);
                final GridAutoFitLayoutManager gridAutoFitLayoutManager = new GridAutoFitLayoutManager(SDMenuActivityFragment.this.r(), (int) (SDMenuActivityFragment.this.b0().getDisplayMetrics().density * 100.0f));
                gridAutoFitLayoutManager.R3(new GridLayoutManager.SpanSizeLookup() {
                    public int f(int i2) {
                        if (SDMenuActivityFragment.this.g5.C(i2) == 1) {
                            return gridAutoFitLayoutManager.b0;
                        }
                        return 1;
                    }
                });
                recyclerViewViewHolder.I.setLayoutManager(gridAutoFitLayoutManager);
            } else if (F == 1) {
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                String string = I4.getString("Section");
                int i3 = I4.getInt("Index");
                rippleTextFullViewHolder.J.setVisibility(8);
                if (!string.equals("Images")) {
                    if (string.equals("Document")) {
                        final Bundle bundle = SDMenuActivityFragment.this.d5.get(i3);
                        rippleTextFullViewHolder.I.setText(bundle.getString("fieldTitle"));
                        materialRippleLayout = rippleTextFullViewHolder.M;
                        r0 = new View.OnClickListener() {
                            public void onClick(View view) {
                                SDMenuActivityFragment sDMenuActivityFragment = SDMenuActivityFragment.this;
                                CompressHelper compressHelper = sDMenuActivityFragment.Q4;
                                Bundle bundle = sDMenuActivityFragment.D4;
                                compressHelper.A1(bundle, "doc,,," + SDMenuActivityFragment.this.e5, (String[]) null, bundle.getString("fieldId"));
                            }
                        };
                    } else if (string.equals("ddx")) {
                        rippleTextFullViewHolder.J.setVisibility(0);
                        final Bundle bundle2 = SDMenuActivityFragment.this.h5.get(i3);
                        rippleTextFullViewHolder.I.setText(bundle2.getString("docTitle"));
                        rippleTextFullViewHolder.J.setText(bundle2.getString("docSection"));
                        materialRippleLayout = rippleTextFullViewHolder.M;
                        r0 = new View.OnClickListener() {
                            public void onClick(View view) {
                                SDMenuActivityFragment sDMenuActivityFragment = SDMenuActivityFragment.this;
                                CompressHelper compressHelper = sDMenuActivityFragment.Q4;
                                Bundle bundle = sDMenuActivityFragment.D4;
                                compressHelper.A1(bundle, "menu,,," + bundle2.getString("id"), (String[]) null, (String) null);
                            }
                        };
                    } else if (string.startsWith("case-")) {
                        final Bundle bundle3 = (Bundle) SDMenuActivityFragment.this.j5.get(Integer.valueOf(string.split("-")[1]).intValue()).getParcelableArrayList("items").get(i3);
                        rippleTextFullViewHolder.I.setText(bundle3.getString("caseTitle"));
                        materialRippleLayout = rippleTextFullViewHolder.M;
                        r0 = new View.OnClickListener() {
                            public void onClick(View view) {
                                SDMenuActivityFragment sDMenuActivityFragment = SDMenuActivityFragment.this;
                                CompressHelper compressHelper = sDMenuActivityFragment.Q4;
                                Bundle bundle = sDMenuActivityFragment.D4;
                                compressHelper.A1(bundle, "case,,," + bundle3.getString("caseId"), (String[]) null, (String) null);
                            }
                        };
                    } else if (string.equals("anatomy")) {
                        final Bundle bundle4 = SDMenuActivityFragment.this.k5.get(i3);
                        rippleTextFullViewHolder.J.setVisibility(0);
                        rippleTextFullViewHolder.I.setText(bundle4.getString("docTitle"));
                        rippleTextFullViewHolder.J.setText(bundle4.getString("docSection"));
                        materialRippleLayout = rippleTextFullViewHolder.M;
                        r0 = new View.OnClickListener() {
                            public void onClick(View view) {
                                SDMenuActivityFragment sDMenuActivityFragment = SDMenuActivityFragment.this;
                                CompressHelper compressHelper = sDMenuActivityFragment.Q4;
                                Bundle bundle = sDMenuActivityFragment.D4;
                                compressHelper.A1(bundle, "menu,,," + bundle4.getString("id"), (String[]) null, (String) null);
                            }
                        };
                    } else if (string.equals("relatedxddx")) {
                        final Bundle bundle5 = SDMenuActivityFragment.this.l5.get(i3);
                        rippleTextFullViewHolder.J.setVisibility(0);
                        rippleTextFullViewHolder.I.setText(bundle5.getString("topicTitle"));
                        rippleTextFullViewHolder.J.setText(bundle5.getString("topicCategory"));
                        materialRippleLayout = rippleTextFullViewHolder.M;
                        r0 = new View.OnClickListener() {
                            public void onClick(View view) {
                                SDMenuActivityFragment sDMenuActivityFragment = SDMenuActivityFragment.this;
                                CompressHelper compressHelper = sDMenuActivityFragment.Q4;
                                Bundle bundle = sDMenuActivityFragment.D4;
                                compressHelper.A1(bundle, "menu,,," + bundle5.getString("docId"), (String[]) null, (String) null);
                            }
                        };
                    } else if (string.equals("relatedxanatomy")) {
                        final Bundle bundle6 = SDMenuActivityFragment.this.m5.get(i3);
                        rippleTextFullViewHolder.J.setVisibility(0);
                        rippleTextFullViewHolder.I.setText(bundle6.getString("topicTitle"));
                        rippleTextFullViewHolder.J.setText(bundle6.getString("topicCategory"));
                        materialRippleLayout = rippleTextFullViewHolder.M;
                        r0 = new View.OnClickListener() {
                            public void onClick(View view) {
                                SDMenuActivityFragment sDMenuActivityFragment = SDMenuActivityFragment.this;
                                CompressHelper compressHelper = sDMenuActivityFragment.Q4;
                                Bundle bundle = sDMenuActivityFragment.D4;
                                compressHelper.A1(bundle, "menu,,," + bundle6.getString("docId"), (String[]) null, (String) null);
                            }
                        };
                    } else {
                        return;
                    }
                    materialRippleLayout.setOnClickListener(r0);
                }
            }
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new HeaderCellViewHolder(LayoutInflater.from(SDMenuActivityFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false));
            }
            if (i2 == 2) {
                return new RecyclerViewViewHolder(LayoutInflater.from(SDMenuActivityFragment.this.r()).inflate(R.layout.f1334list_view_item_recyclerview, viewGroup, false));
            }
            if (i2 != 1) {
                return null;
            }
            RippleTextFullViewHolder rippleTextFullViewHolder = new RippleTextFullViewHolder(LayoutInflater.from(SDMenuActivityFragment.this.r()).inflate(R.layout.f1346list_view_item_ripple_text_full, viewGroup, false));
            rippleTextFullViewHolder.K.setVisibility(8);
            return rippleTextFullViewHolder;
        }

        public int b() {
            SDMenuActivityFragment sDMenuActivityFragment = SDMenuActivityFragment.this;
            return sDMenuActivityFragment.P4(sDMenuActivityFragment.f5);
        }
    }

    public static class HeaderCellViewHolder extends RecyclerView.ViewHolder {
        public TextView I;

        public HeaderCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f957header_text);
        }
    }

    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView I;

        public RecyclerViewViewHolder(View view) {
            super(view);
            this.I = (RecyclerView) view.findViewById(R.id.f1054recycler_view);
        }
    }

    /* access modifiers changed from: private */
    public void O4(String str) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= this.a5.size()) {
                break;
            } else if (this.a5.get(i3).getString("id").equals(str)) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        Intent intent = new Intent(r(), GalleryActivity.class);
        intent.putExtra("Images", this.a5);
        intent.putExtra("Start", i2);
        D2(intent);
    }

    public Bundle I4(int i2, ArrayList<String> arrayList) {
        Iterator<String> it2 = arrayList.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            String next = it2.next();
            if (i2 == i3) {
                Bundle bundle = new Bundle();
                bundle.putString("Text", next);
                bundle.putString("Type", "Header");
                return bundle;
            }
            int N4 = i3 + N4(next);
            if (i2 <= N4) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("Section", next);
                bundle2.putInt("Index", (i2 - (N4 - N4(next))) - 1);
                bundle2.putString("Type", "Item");
                return bundle2;
            }
            i3 = N4 + 1;
        }
        return null;
    }

    public void L4() {
        this.X4.setItemAnimator(new DefaultItemAnimator());
        this.X4.setItemDecoration(new CustomItemDecoration(r()));
        this.X4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
    }

    public String M4(String str) {
        if (str.equals("Images")) {
            return this.Y4.size() + " Images";
        } else if (str.equals("Document")) {
            return "Document";
        } else {
            if (str.equals("ddx")) {
                return "Differential Diagnosis";
            }
            if (str.startsWith("case-")) {
                return this.j5.get(Integer.valueOf(str.split("-")[1]).intValue()).getString("title");
            } else if (str.equals("anatomy")) {
                return "Related Anatomy";
            } else {
                if (str.equals("relatedxddx") || str.equals("relatedxanatomy")) {
                    return "Related Dx";
                }
                iMDLogger.f("numberOfRowsInSection", "Where is title for : " + str);
                return str;
            }
        }
    }

    public int N4(String str) {
        if (str.equals("Images")) {
            return 1;
        }
        if (str.equals("Document")) {
            return this.d5.size();
        }
        if (str.equals("ddx")) {
            return this.h5.size();
        }
        if (str.startsWith("case-")) {
            return this.j5.get(Integer.valueOf(str.split("-")[1]).intValue()).getParcelableArrayList("items").size();
        } else if (str.equals("anatomy")) {
            return this.k5.size();
        } else {
            if (str.equals("relatedxddx")) {
                return this.l5.size();
            }
            if (str.equals("relatedxanatomy")) {
                return this.m5.size();
            }
            iMDLogger.f("numberOfRowsInSection", "Where is row count for : " + str);
            return -1;
        }
    }

    public int P4(ArrayList<String> arrayList) {
        int i2 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i2 = i2 + N4(it2.next()) + 1;
        }
        return i2;
    }

    public String R2() {
        ArrayList<Bundle> arrayList = this.Y4;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        Bundle v3 = v3(this.Y4);
        Bundle bundle = this.D4;
        String h1 = CompressHelper.h1(bundle, v3.getString("id") + ".jpg", "images-E");
        T3(v3.getString("id"), "images-E");
        return h1;
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.C4;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.f1248fragment_new_list_viewer, viewGroup, false);
        this.C4 = inflate;
        r4(inflate, bundle);
        this.X4 = (RecyclerView) this.C4.findViewById(R.id.f1054recycler_view);
        if (y() == null) {
            return this.C4;
        }
        this.o5 = new Bundle();
        String[] split = this.E4.split(",,,");
        if (split.length == 2) {
            this.e5 = split[1];
        } else if (split.length == 3) {
            this.e5 = split[1];
            this.n5 = split[2];
            this.E4 = split[0] + ",,," + split[1];
        }
        if (!new File(CompressHelper.g1(this.D4, "base")).exists()) {
            new File(CompressHelper.g1(this.D4, "base")).mkdirs();
        }
        this.f5 = new ArrayList<>();
        this.a5 = new ArrayList<>();
        CompressHelper compressHelper = this.Q4;
        Bundle bundle2 = this.D4;
        ArrayList<Bundle> V = compressHelper.V(bundle2, "Select * from docs where id='" + this.e5 + "'");
        if (V == null || V.size() == 0) {
            CompressHelper.x2(r(), "Can't find the document, sorry", 1);
        } else {
            this.c5 = V.get(0);
            this.F4 = this.c5.getString("title") + " - " + this.c5.getString("category");
            r3(new Runnable() {
                public void run() {
                    SDMenuActivityFragment sDMenuActivityFragment = SDMenuActivityFragment.this;
                    CompressHelper compressHelper = sDMenuActivityFragment.Q4;
                    Bundle bundle = sDMenuActivityFragment.D4;
                    sDMenuActivityFragment.d5 = compressHelper.V(bundle, "Select * from fields where topicId='" + SDMenuActivityFragment.this.e5 + "'");
                    SDMenuActivityFragment sDMenuActivityFragment2 = SDMenuActivityFragment.this;
                    CompressHelper compressHelper2 = sDMenuActivityFragment2.Q4;
                    Bundle bundle2 = sDMenuActivityFragment2.D4;
                    sDMenuActivityFragment2.Y4 = compressHelper2.V(bundle2, "Select * from images where docId='" + SDMenuActivityFragment.this.e5 + "'");
                    SDMenuActivityFragment sDMenuActivityFragment3 = SDMenuActivityFragment.this;
                    if (sDMenuActivityFragment3.Y4 == null) {
                        sDMenuActivityFragment3.Y4 = new ArrayList<>();
                    }
                    if (SDMenuActivityFragment.this.Y4.size() > 0) {
                        SDMenuActivityFragment sDMenuActivityFragment4 = SDMenuActivityFragment.this;
                        sDMenuActivityFragment4.Z4 = sDMenuActivityFragment4.Q4.r2(sDMenuActivityFragment4.Y4, "category");
                        SDMenuActivityFragment.this.f5.add("Images");
                        Iterator<Bundle> it2 = SDMenuActivityFragment.this.Y4.iterator();
                        while (it2.hasNext()) {
                            Bundle next = it2.next();
                            Bundle bundle3 = new Bundle();
                            Bundle bundle4 = SDMenuActivityFragment.this.D4;
                            String h1 = CompressHelper.h1(bundle4, next.getString("id") + ".jpg", "images-E");
                            SDMenuActivityFragment.this.T3(next.getString("id"), "images-E");
                            bundle3.putString("ImagePath", h1);
                            bundle3.putString("id", next.getString("id"));
                            bundle3.putString("Encrypted", IcyHeaders.a3);
                            bundle3.putString("DescriptionHTML2", SDMenuActivityFragment.this.Q4.B(next.getString(HTML.Tag.f27619g), next.getString("id"), "127"));
                            bundle3.putBundle("db", SDMenuActivityFragment.this.D4);
                            SDMenuActivityFragment.this.a5.add(bundle3);
                        }
                        SDMenuActivityFragment sDMenuActivityFragment5 = SDMenuActivityFragment.this;
                        sDMenuActivityFragment5.g5 = new NotStickySectionAdapter(sDMenuActivityFragment5.r(), SDMenuActivityFragment.this.Z4, "title", R.layout.f1326list_view_item_image, R.layout.f1327list_view_item_image_header) {
                            public void f0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                                final ImageViewHolder imageViewHolder = (ImageViewHolder) viewHolder;
                                Bundle bundle2 = SDMenuActivityFragment.this.D4;
                                final String h1 = CompressHelper.h1(bundle2, bundle.getString("id") + ".jpg", "small");
                                SDMenuActivityFragment.this.T3(bundle.getString("id"), "small");
                                Glide.G(SDMenuActivityFragment.this.r()).i(new File(h1)).B2(imageViewHolder.I);
                                if (SDMenuActivityFragment.this.o5.containsKey(h1)) {
                                    imageViewHolder.J.setRippleColor(SDMenuActivityFragment.this.o5.getInt(h1));
                                } else {
                                    SDMenuActivityFragment.this.q3(new Runnable() {
                                        public void run() {
                                            Palette.Swatch C = Palette.b(BitmapFactory.decodeFile(h1)).g().C();
                                            if (C != null) {
                                                int e2 = C.e();
                                                if (!SDMenuActivityFragment.this.o5.containsKey(h1)) {
                                                    SDMenuActivityFragment.this.o5.putInt(h1, e2);
                                                }
                                            }
                                        }
                                    }, new Runnable() {
                                        public void run() {
                                            imageViewHolder.J.setRippleColor(SDMenuActivityFragment.this.o5.getInt(h1));
                                        }
                                    });
                                }
                                imageViewHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View view) {
                                        SDMenuActivityFragment.this.O4(bundle.getString("id"));
                                    }
                                });
                            }

                            public RecyclerView.ViewHolder k0(View view) {
                                return new ImageViewHolder(view);
                            }
                        };
                    }
                    if (!SDMenuActivityFragment.this.D4.getString("Name").equals("expertpath.d")) {
                        SDMenuActivityFragment sDMenuActivityFragment6 = SDMenuActivityFragment.this;
                        CompressHelper compressHelper3 = sDMenuActivityFragment6.Q4;
                        Bundle bundle5 = sDMenuActivityFragment6.D4;
                        sDMenuActivityFragment6.h5 = compressHelper3.V(bundle5, "Select * from ddx where docId='" + SDMenuActivityFragment.this.e5 + "'");
                        ArrayList<Bundle> arrayList = SDMenuActivityFragment.this.h5;
                        if (arrayList != null && arrayList.size() > 0) {
                            SDMenuActivityFragment.this.f5.add("ddx");
                        }
                        SDMenuActivityFragment sDMenuActivityFragment7 = SDMenuActivityFragment.this;
                        CompressHelper compressHelper4 = sDMenuActivityFragment7.Q4;
                        Bundle bundle6 = sDMenuActivityFragment7.D4;
                        sDMenuActivityFragment7.i5 = compressHelper4.V(bundle6, "Select * from docs_cases where docId='" + SDMenuActivityFragment.this.e5 + "'");
                        ArrayList<Bundle> arrayList2 = SDMenuActivityFragment.this.i5;
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            SDMenuActivityFragment sDMenuActivityFragment8 = SDMenuActivityFragment.this;
                            sDMenuActivityFragment8.j5 = sDMenuActivityFragment8.Q4.r2(sDMenuActivityFragment8.i5, "caseGroup");
                            Iterator<Bundle> it3 = SDMenuActivityFragment.this.j5.iterator();
                            while (it3.hasNext()) {
                                ArrayList<String> arrayList3 = SDMenuActivityFragment.this.f5;
                                arrayList3.add("case-" + SDMenuActivityFragment.this.j5.indexOf(it3.next()));
                            }
                        }
                        SDMenuActivityFragment sDMenuActivityFragment9 = SDMenuActivityFragment.this;
                        CompressHelper compressHelper5 = sDMenuActivityFragment9.Q4;
                        Bundle bundle7 = sDMenuActivityFragment9.D4;
                        sDMenuActivityFragment9.k5 = compressHelper5.V(bundle7, "Select * from anatomy where docId='" + SDMenuActivityFragment.this.e5 + "'");
                        ArrayList<Bundle> arrayList4 = SDMenuActivityFragment.this.k5;
                        if (arrayList4 != null && arrayList4.size() > 0) {
                            SDMenuActivityFragment.this.f5.add("anatomy");
                        }
                        SDMenuActivityFragment sDMenuActivityFragment10 = SDMenuActivityFragment.this;
                        CompressHelper compressHelper6 = sDMenuActivityFragment10.Q4;
                        Bundle bundle8 = sDMenuActivityFragment10.D4;
                        sDMenuActivityFragment10.l5 = compressHelper6.V(bundle8, "Select * from ddx where id='" + SDMenuActivityFragment.this.e5 + "'");
                        ArrayList<Bundle> arrayList5 = SDMenuActivityFragment.this.l5;
                        if (arrayList5 != null && arrayList5.size() > 0) {
                            SDMenuActivityFragment.this.f5.add("relatedxddx");
                        }
                        SDMenuActivityFragment sDMenuActivityFragment11 = SDMenuActivityFragment.this;
                        CompressHelper compressHelper7 = sDMenuActivityFragment11.Q4;
                        Bundle bundle9 = sDMenuActivityFragment11.D4;
                        sDMenuActivityFragment11.m5 = compressHelper7.V(bundle9, "Select * from anatomy where id='" + SDMenuActivityFragment.this.e5 + "'");
                        ArrayList<Bundle> arrayList6 = SDMenuActivityFragment.this.m5;
                        if (arrayList6 != null && arrayList6.size() > 0) {
                            SDMenuActivityFragment.this.f5.add("relatedxanatomy");
                        }
                    }
                    SDMenuActivityFragment.this.f5.add("Document");
                }
            }, new Runnable() {
                public void run() {
                    SDMenuActivityFragment sDMenuActivityFragment = SDMenuActivityFragment.this;
                    if (sDMenuActivityFragment.Y4 == null) {
                        sDMenuActivityFragment.Y4 = new ArrayList<>();
                    }
                    SDMenuActivityFragment sDMenuActivityFragment2 = SDMenuActivityFragment.this;
                    final String str = sDMenuActivityFragment2.n5;
                    if (str != null) {
                        sDMenuActivityFragment2.C4.postDelayed(new Runnable() {
                            public void run() {
                                SDMenuActivityFragment.this.O4(str);
                            }
                        }, 1000);
                    }
                    if (SDMenuActivityFragment.this.y().containsKey("SEARCH") && SDMenuActivityFragment.this.y().getStringArray("SEARCH") != null) {
                        new Timer().schedule(new TimerTask() {
                            public void run() {
                                SDMenuActivityFragment sDMenuActivityFragment = SDMenuActivityFragment.this;
                                CompressHelper compressHelper = sDMenuActivityFragment.Q4;
                                Bundle bundle = sDMenuActivityFragment.D4;
                                compressHelper.A1(bundle, "doc,,," + SDMenuActivityFragment.this.e5, SDMenuActivityFragment.this.y().getStringArray("SEARCH"), (String) null);
                                SDMenuActivityFragment.this.y().remove("SEARCH");
                            }
                        }, ExoPlayer.a1);
                    }
                    SDMenuActivityFragment sDMenuActivityFragment3 = SDMenuActivityFragment.this;
                    sDMenuActivityFragment3.b5 = new DiagnosisAdapter();
                    SDMenuActivityFragment sDMenuActivityFragment4 = SDMenuActivityFragment.this;
                    sDMenuActivityFragment4.X4.setAdapter(sDMenuActivityFragment4.b5);
                    SDMenuActivityFragment.this.L4();
                    SDMenuActivityFragment.this.f3(R.menu.f1414favorite);
                    SDMenuActivityFragment.this.o2(false);
                    SDMenuActivityFragment.this.G3();
                }
            });
        }
        return this.C4;
    }

    public boolean e1(MenuItem menuItem) {
        menuItem.getItemId();
        return super.e1(menuItem);
    }

    public void e3(Menu menu) {
        super.e3(menu);
    }

    public void o4() {
        new AsyncTask() {

            /* renamed from: a  reason: collision with root package name */
            byte[] f29931a;

            /* access modifiers changed from: protected */
            public Object doInBackground(Object[] objArr) {
                try {
                    File file = new File(SDMenuActivityFragment.this.R2());
                    this.f29931a = new CompressHelper(SDMenuActivityFragment.this.r()).w(CompressHelper.d2(file), file.getName(), "127");
                    return null;
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    iMDLogger.f("ImageGallery", "Error in decrypting image");
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Object obj) {
                super.onPostExecute(obj);
                Glide.G(SDMenuActivityFragment.this.r()).h(this.f29931a).B2(SDMenuActivityFragment.this.M4);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.C4.postDelayed(new Runnable() {
            public void run() {
                SDMenuActivityFragment.this.b5.G();
            }
        }, 500);
    }
}
