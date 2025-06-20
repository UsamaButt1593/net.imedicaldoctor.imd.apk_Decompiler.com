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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
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
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.GridAutoFitLayoutManager;
import net.imedicaldoctor.imd.ViewHolders.ImageViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;
import net.imedicaldoctor.imd.iMDLogger;

public class SDCaseActivityFragment extends ViewerHelperFragment {
    public RecyclerView X4;
    public ArrayList<Bundle> Y4;
    public ArrayList<Bundle> Z4;
    public DiagnosisAdapter a5;
    public Bundle b5;
    public ArrayList<Bundle> c5;
    public String d5;
    public ArrayList<String> e5;
    public ChaptersAdapter f5;
    public ArrayList<Bundle> g5;
    public String h5;
    /* access modifiers changed from: private */
    public Bundle i5;

    public class DiagnosisAdapter extends RecyclerView.Adapter {

        /* renamed from: f  reason: collision with root package name */
        private static final int f29923f = 0;

        /* renamed from: g  reason: collision with root package name */
        private static final int f29924g = 1;

        /* renamed from: h  reason: collision with root package name */
        private static final int f29925h = 2;

        /* renamed from: d  reason: collision with root package name */
        public Context f29926d;

        public DiagnosisAdapter() {
        }

        public int C(int i2) {
            SDCaseActivityFragment sDCaseActivityFragment = SDCaseActivityFragment.this;
            Bundle I4 = sDCaseActivityFragment.I4(i2, sDCaseActivityFragment.e5);
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
            SDCaseActivityFragment sDCaseActivityFragment = SDCaseActivityFragment.this;
            Bundle I4 = sDCaseActivityFragment.I4(i2, sDCaseActivityFragment.e5);
            int F = viewHolder.F();
            if (F == 0) {
                ((HeaderCellViewHolder) viewHolder).I.setText(SDCaseActivityFragment.this.M4(I4.getString("Text")));
            } else if (F == 2) {
                RecyclerViewViewHolder recyclerViewViewHolder = (RecyclerViewViewHolder) viewHolder;
                recyclerViewViewHolder.I.setAdapter(SDCaseActivityFragment.this.f5);
                recyclerViewViewHolder.I.setLayoutManager(new GridAutoFitLayoutManager(SDCaseActivityFragment.this.r(), (int) (SDCaseActivityFragment.this.b0().getDisplayMetrics().density * 100.0f)));
            } else if (F == 1) {
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                String string = I4.getString("Section");
                int i3 = I4.getInt("Index");
                rippleTextFullViewHolder.J.setVisibility(8);
                if (!string.equals("Images")) {
                    if (string.equals("Document")) {
                        final Bundle bundle = SDCaseActivityFragment.this.c5.get(i3);
                        rippleTextFullViewHolder.I.setText(bundle.getString("fieldTitle"));
                        materialRippleLayout = rippleTextFullViewHolder.M;
                        r0 = new View.OnClickListener() {
                            public void onClick(View view) {
                                SDCaseActivityFragment sDCaseActivityFragment = SDCaseActivityFragment.this;
                                CompressHelper compressHelper = sDCaseActivityFragment.Q4;
                                Bundle bundle = sDCaseActivityFragment.D4;
                                compressHelper.A1(bundle, "doc,,,case,,," + SDCaseActivityFragment.this.d5, (String[]) null, bundle.getString("fieldId"));
                            }
                        };
                    } else if (string.equals("ddx")) {
                        rippleTextFullViewHolder.J.setVisibility(0);
                        final Bundle bundle2 = SDCaseActivityFragment.this.g5.get(i3);
                        rippleTextFullViewHolder.I.setText(bundle2.getString("docTitle"));
                        rippleTextFullViewHolder.J.setText(bundle2.getString("docSection"));
                        materialRippleLayout = rippleTextFullViewHolder.M;
                        r0 = new View.OnClickListener() {
                            public void onClick(View view) {
                                SDCaseActivityFragment sDCaseActivityFragment = SDCaseActivityFragment.this;
                                CompressHelper compressHelper = sDCaseActivityFragment.Q4;
                                Bundle bundle = sDCaseActivityFragment.D4;
                                compressHelper.A1(bundle, "menu,,," + bundle2.getString("docId"), (String[]) null, (String) null);
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
                return new HeaderCellViewHolder(LayoutInflater.from(SDCaseActivityFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false));
            }
            if (i2 == 2) {
                return new RecyclerViewViewHolder(LayoutInflater.from(SDCaseActivityFragment.this.r()).inflate(R.layout.f1334list_view_item_recyclerview, viewGroup, false));
            }
            if (i2 != 1) {
                return null;
            }
            RippleTextFullViewHolder rippleTextFullViewHolder = new RippleTextFullViewHolder(LayoutInflater.from(SDCaseActivityFragment.this.r()).inflate(R.layout.f1346list_view_item_ripple_text_full, viewGroup, false));
            rippleTextFullViewHolder.K.setVisibility(8);
            return rippleTextFullViewHolder;
        }

        public int b() {
            SDCaseActivityFragment sDCaseActivityFragment = SDCaseActivityFragment.this;
            return sDCaseActivityFragment.P4(sDCaseActivityFragment.e5);
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
            if (i3 >= this.Z4.size() - 1) {
                break;
            } else if (this.Z4.get(i3).getString("id").equals(str)) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        Intent intent = new Intent(r(), GalleryActivity.class);
        intent.putExtra("Images", this.Z4);
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
        this.X4.p(new CustomItemDecoration(r()));
        this.X4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
    }

    public String M4(String str) {
        if (str.equals("Images")) {
            return this.Y4.size() + " Images";
        } else if (str.equals("Document")) {
            return "Document";
        } else {
            return str.equals("ddx") ? "Related Dx" : "";
        }
    }

    public int N4(String str) {
        ArrayList<Bundle> arrayList;
        if (str.equals("Images")) {
            return 1;
        }
        if (str.equals("Document")) {
            arrayList = this.c5;
        } else if (!str.equals("ddx")) {
            return 0;
        } else {
            arrayList = this.g5;
        }
        return arrayList.size();
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
        String h1 = CompressHelper.h1(bundle, v3.getString("imageId") + ".jpg", "images-E");
        T3(v3.getString("imageId"), "images-E");
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
        this.i5 = new Bundle();
        String[] split = this.E4.split(",,,");
        if (split.length == 2) {
            this.d5 = split[1];
        } else if (split.length == 3) {
            this.d5 = split[1];
            this.h5 = split[2];
            this.E4 = split[0] + ",,," + split[1];
        }
        this.e5 = new ArrayList<>();
        this.Z4 = new ArrayList<>();
        CompressHelper compressHelper = this.Q4;
        Bundle bundle2 = this.D4;
        ArrayList<Bundle> V = compressHelper.V(bundle2, "Select * from cases where id='" + this.d5 + "'");
        if (V == null || V.size() == 0) {
            CompressHelper.x2(r(), "Can't find the document, sorry", 1);
        } else {
            Bundle bundle3 = V.get(0);
            this.b5 = bundle3;
            this.F4 = bundle3.getString("title");
            r3(new Runnable() {
                public void run() {
                    SDCaseActivityFragment.this.c5 = new ArrayList<>();
                    Bundle bundle = new Bundle();
                    bundle.putString("fieldTitle", "Description");
                    bundle.putString("fieldId", "");
                    SDCaseActivityFragment.this.c5.add(bundle);
                    SDCaseActivityFragment sDCaseActivityFragment = SDCaseActivityFragment.this;
                    CompressHelper compressHelper = sDCaseActivityFragment.Q4;
                    Bundle bundle2 = sDCaseActivityFragment.D4;
                    sDCaseActivityFragment.Y4 = compressHelper.V(bundle2, "Select * from cases_images where caseId='" + SDCaseActivityFragment.this.d5 + "'");
                    SDCaseActivityFragment sDCaseActivityFragment2 = SDCaseActivityFragment.this;
                    if (sDCaseActivityFragment2.Y4 == null) {
                        sDCaseActivityFragment2.Y4 = new ArrayList<>();
                    }
                    if (SDCaseActivityFragment.this.Y4.size() > 0) {
                        SDCaseActivityFragment.this.e5.add("Images");
                        Iterator<Bundle> it2 = SDCaseActivityFragment.this.Y4.iterator();
                        while (it2.hasNext()) {
                            Bundle next = it2.next();
                            Bundle bundle3 = new Bundle();
                            Bundle bundle4 = SDCaseActivityFragment.this.D4;
                            String h1 = CompressHelper.h1(bundle4, next.getString("imageId") + ".jpg", "images-E");
                            SDCaseActivityFragment.this.T3(next.getString("imageId"), "images-E");
                            bundle3.putString("ImagePath", h1);
                            bundle3.putString("id", next.getString("imageId"));
                            bundle3.putString("Encrypted", IcyHeaders.a3);
                            bundle3.putBundle("db", SDCaseActivityFragment.this.D4);
                            SDCaseActivityFragment.this.Z4.add(bundle3);
                        }
                        SDCaseActivityFragment sDCaseActivityFragment3 = SDCaseActivityFragment.this;
                        sDCaseActivityFragment3.f5 = new ChaptersAdapter(sDCaseActivityFragment3.r(), SDCaseActivityFragment.this.Y4, "title", R.layout.f1326list_view_item_image) {
                            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                                final ImageViewHolder imageViewHolder = (ImageViewHolder) viewHolder;
                                Bundle bundle2 = SDCaseActivityFragment.this.D4;
                                final String h1 = CompressHelper.h1(bundle2, bundle.getString("imageId") + ".jpg", "small");
                                SDCaseActivityFragment.this.T3(bundle.getString("imageId"), "small");
                                Glide.G(SDCaseActivityFragment.this.r()).i(new File(h1)).B2(imageViewHolder.I);
                                if (SDCaseActivityFragment.this.i5.containsKey(h1)) {
                                    imageViewHolder.J.setRippleColor(SDCaseActivityFragment.this.i5.getInt(h1));
                                } else {
                                    SDCaseActivityFragment.this.q3(new Runnable() {
                                        public void run() {
                                            Palette.Swatch C = Palette.b(BitmapFactory.decodeFile(h1)).g().C();
                                            if (C != null) {
                                                int e2 = C.e();
                                                if (!SDCaseActivityFragment.this.i5.containsKey(h1)) {
                                                    SDCaseActivityFragment.this.i5.putInt(h1, e2);
                                                }
                                            }
                                        }
                                    }, new Runnable() {
                                        public void run() {
                                            imageViewHolder.J.setRippleColor(SDCaseActivityFragment.this.i5.getInt(h1));
                                        }
                                    });
                                }
                                imageViewHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View view) {
                                        SDCaseActivityFragment.this.O4(bundle.getString("imageId"));
                                    }
                                });
                            }

                            public RecyclerView.ViewHolder h0(View view) {
                                return new ImageViewHolder(view);
                            }
                        };
                    }
                    SDCaseActivityFragment sDCaseActivityFragment4 = SDCaseActivityFragment.this;
                    CompressHelper compressHelper2 = sDCaseActivityFragment4.Q4;
                    Bundle bundle5 = sDCaseActivityFragment4.D4;
                    sDCaseActivityFragment4.g5 = compressHelper2.V(bundle5, "Select * from cases_docs where caseId='" + SDCaseActivityFragment.this.d5 + "'");
                    ArrayList<Bundle> arrayList = SDCaseActivityFragment.this.g5;
                    if (arrayList != null && arrayList.size() > 0) {
                        SDCaseActivityFragment.this.e5.add("ddx");
                    }
                    SDCaseActivityFragment.this.e5.add("Document");
                }
            }, new Runnable() {
                public void run() {
                    SDCaseActivityFragment sDCaseActivityFragment = SDCaseActivityFragment.this;
                    if (sDCaseActivityFragment.Y4 == null) {
                        sDCaseActivityFragment.Y4 = new ArrayList<>();
                    }
                    SDCaseActivityFragment sDCaseActivityFragment2 = SDCaseActivityFragment.this;
                    final String str = sDCaseActivityFragment2.h5;
                    if (str != null) {
                        sDCaseActivityFragment2.C4.postDelayed(new Runnable() {
                            public void run() {
                                SDCaseActivityFragment.this.O4(str);
                            }
                        }, 1000);
                    }
                    if (SDCaseActivityFragment.this.y().containsKey("SEARCH") && SDCaseActivityFragment.this.y().getStringArray("SEARCH") != null) {
                        new Timer().schedule(new TimerTask() {
                            public void run() {
                                SDCaseActivityFragment sDCaseActivityFragment = SDCaseActivityFragment.this;
                                CompressHelper compressHelper = sDCaseActivityFragment.Q4;
                                Bundle bundle = sDCaseActivityFragment.D4;
                                compressHelper.A1(bundle, "doc,,,case,,," + SDCaseActivityFragment.this.d5, SDCaseActivityFragment.this.y().getStringArray("SEARCH"), (String) null);
                                SDCaseActivityFragment.this.y().remove("SEARCH");
                            }
                        }, ExoPlayer.a1);
                    }
                    SDCaseActivityFragment sDCaseActivityFragment3 = SDCaseActivityFragment.this;
                    sDCaseActivityFragment3.a5 = new DiagnosisAdapter();
                    SDCaseActivityFragment sDCaseActivityFragment4 = SDCaseActivityFragment.this;
                    sDCaseActivityFragment4.X4.setAdapter(sDCaseActivityFragment4.a5);
                    SDCaseActivityFragment.this.L4();
                    SDCaseActivityFragment.this.f3(R.menu.f1414favorite);
                    SDCaseActivityFragment.this.o2(false);
                    SDCaseActivityFragment.this.G3();
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
            byte[] f29921a;

            /* access modifiers changed from: protected */
            public Object doInBackground(Object[] objArr) {
                try {
                    File file = new File(SDCaseActivityFragment.this.R2());
                    this.f29921a = new CompressHelper(SDCaseActivityFragment.this.r()).w(CompressHelper.d2(file), file.getName(), "127");
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
                Glide.G(SDCaseActivityFragment.this.r()).h(this.f29921a).B2(SDCaseActivityFragment.this.M4);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.C4.postDelayed(new Runnable() {
            public void run() {
                SDCaseActivityFragment.this.a5.G();
            }
        }, 500);
    }
}
