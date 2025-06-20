package net.imedicaldoctor.imd.Fragments.Amirsys;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import java.io.File;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Gallery.GalleryActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.GridAutoFitLayoutManager;
import net.imedicaldoctor.imd.ViewHolders.ImageViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextViewHolder;
import net.imedicaldoctor.imd.iMDLogger;

public class ASMenuActivityFragment extends ViewerHelperFragment {
    public RecyclerView X4;
    public ArrayList<Bundle> Y4;
    public ArrayList<Bundle> Z4;
    public DiagnosisAdapter a5;
    public Bundle b5;
    public ArrayList<Bundle> c5;
    /* access modifiers changed from: private */
    public Bundle d5;
    public String e5;
    /* access modifiers changed from: private */
    public boolean f5;

    public class DiagnosisAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        public Context f29625d;

        public DiagnosisAdapter() {
        }

        public int C(int i2) {
            String string = d0(i2).getString("Type");
            if (string.equals("Header")) {
                return 0;
            }
            if (string.equals("GridView")) {
                return 1;
            }
            return string.equals("Item") ? 2 : -1;
        }

        public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
            Bundle d0 = d0(i2);
            int F = viewHolder.F();
            if (F == 0) {
                ((HeaderCellViewHolder) viewHolder).I.setText(d0.getString("Text"));
            } else if (F == 1) {
                RecyclerViewViewHolder recyclerViewViewHolder = (RecyclerViewViewHolder) viewHolder;
                final AnonymousClass1 r0 = new ChaptersAdapter(ASMenuActivityFragment.this.r(), ASMenuActivityFragment.this.Y4, "title", R.layout.f1326list_view_item_image) {
                    public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                        final ImageViewHolder imageViewHolder = (ImageViewHolder) viewHolder;
                        Bundle bundle2 = ASMenuActivityFragment.this.D4;
                        final String h1 = CompressHelper.h1(bundle2, bundle.getString("id") + ".jpg", "small");
                        Glide.G(ASMenuActivityFragment.this.r()).i(new File(h1)).B2(imageViewHolder.I);
                        if (ASMenuActivityFragment.this.f5) {
                            if (ASMenuActivityFragment.this.d5.containsKey(h1)) {
                                imageViewHolder.J.setRippleColor(ASMenuActivityFragment.this.d5.getInt(h1));
                            } else {
                                ASMenuActivityFragment.this.q3(new Runnable() {
                                    public void run() {
                                        Palette.Swatch C = Palette.b(BitmapFactory.decodeFile(h1)).g().C();
                                        if (C != null) {
                                            int e2 = C.e();
                                            if (!ASMenuActivityFragment.this.d5.containsKey(h1)) {
                                                ASMenuActivityFragment.this.d5.putInt(h1, e2);
                                            }
                                        }
                                    }
                                }, new Runnable() {
                                    public void run() {
                                        imageViewHolder.J.setRippleColor(ASMenuActivityFragment.this.d5.getInt(h1));
                                    }
                                });
                            }
                        }
                        imageViewHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                ASMenuActivityFragment.this.M4(bundle.getString("id"));
                            }
                        });
                    }

                    public RecyclerView.ViewHolder h0(View view) {
                        return new ImageViewHolder(view);
                    }
                };
                recyclerViewViewHolder.I.setAdapter(r0);
                final GridAutoFitLayoutManager gridAutoFitLayoutManager = new GridAutoFitLayoutManager(ASMenuActivityFragment.this.r(), (int) (ASMenuActivityFragment.this.b0().getDisplayMetrics().density * 100.0f));
                gridAutoFitLayoutManager.R3(new GridLayoutManager.SpanSizeLookup() {
                    public int f(int i2) {
                        if (r0.C(i2) == 1) {
                            return gridAutoFitLayoutManager.b0;
                        }
                        return 1;
                    }
                });
                recyclerViewViewHolder.I.setLayoutManager(gridAutoFitLayoutManager);
            } else if (F == 2) {
                RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
                rippleTextViewHolder.I.setText(d0.getBundle("Item").getString("fieldTitle"));
                rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Bundle bundle = DiagnosisAdapter.this.d0(i2).getBundle("Item");
                        ASMenuActivityFragment aSMenuActivityFragment = ASMenuActivityFragment.this;
                        CompressHelper compressHelper = aSMenuActivityFragment.Q4;
                        Bundle bundle2 = aSMenuActivityFragment.D4;
                        compressHelper.A1(bundle2, "doc,,," + ASMenuActivityFragment.this.e5, (String[]) null, bundle.getString("fieldId"));
                    }
                });
            }
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new HeaderCellViewHolder(LayoutInflater.from(ASMenuActivityFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false));
            }
            if (i2 == 1) {
                return new RecyclerViewViewHolder(LayoutInflater.from(ASMenuActivityFragment.this.r()).inflate(R.layout.f1334list_view_item_recyclerview, viewGroup, false));
            }
            if (i2 == 2) {
                return new RippleTextViewHolder(LayoutInflater.from(ASMenuActivityFragment.this.r()).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
            }
            return null;
        }

        public int b() {
            return ASMenuActivityFragment.this.c5.size() + 3;
        }

        public Bundle d0(int i2) {
            String str;
            Bundle bundle = new Bundle();
            if (i2 == 0) {
                bundle.putString("Type", "Header");
                str = ASMenuActivityFragment.this.Y4.size() + " IMAGES";
            } else if (i2 == 1) {
                bundle.putString("Type", "GridView");
                str = "";
            } else if (i2 == 2) {
                bundle.putString("Type", "Header");
                str = PdfWriterPipeline.f27720f;
            } else {
                if (i2 > 2) {
                    bundle.putString("Type", "Item");
                    bundle.putBundle("Item", ASMenuActivityFragment.this.c5.get(i2 - 3));
                }
                return bundle;
            }
            bundle.putString("Text", str);
            return bundle;
        }

        public void e0(Bundle bundle, int i2) {
        }
    }

    public static class GridViewHolder extends RecyclerView.ViewHolder {
        public GridView I;

        public GridViewHolder(View view) {
            super(view);
            this.I = (GridView) view.findViewById(R.id.f952grid_view);
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
    public void M4(String str) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= this.Z4.size()) {
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

    public void L4() {
        this.X4.setItemAnimator(new DefaultItemAnimator());
        this.X4.p(new CustomItemDecoration(r()));
        this.X4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
    }

    public String R2() {
        ArrayList<Bundle> arrayList = this.Y4;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        Bundle v3 = v3(this.Y4);
        Bundle bundle = this.D4;
        return CompressHelper.h1(bundle, v3.getString("id") + ".jpg", "images-E");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View U0(android.view.LayoutInflater r7, android.view.ViewGroup r8, android.os.Bundle r9) {
        /*
            r6 = this;
            android.view.View r0 = r6.C4
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            r0 = 2131558540(0x7f0d008c, float:1.8742399E38)
            r1 = 0
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r6.C4 = r7
            androidx.fragment.app.FragmentActivity r7 = r6.V1()
            java.lang.String r8 = "default_preferences"
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r8, r1)
            java.lang.String r8 = "ripple"
            r0 = 1
            boolean r7 = r7.getBoolean(r8, r0)
            r6.f5 = r7
            android.view.View r7 = r6.C4
            r6.r4(r7, r9)
            android.view.View r7 = r6.C4
            r8 = 2131362493(0x7f0a02bd, float:1.8344768E38)
            android.view.View r7 = r7.findViewById(r8)
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            r6.X4 = r7
            android.os.Bundle r7 = r6.y()
            if (r7 != 0) goto L_0x003d
            android.view.View r7 = r6.C4
            return r7
        L_0x003d:
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            r6.d5 = r7
            java.lang.String r7 = r6.E4
            java.lang.String r8 = ",,,"
            java.lang.String[] r7 = r7.split(r8)
            int r9 = r7.length
            r2 = 2
            if (r9 != r2) goto L_0x0055
            r7 = r7[r0]
            r6.e5 = r7
            goto L_0x0078
        L_0x0055:
            int r9 = r7.length
            r3 = 3
            if (r9 != r3) goto L_0x0078
            r9 = r7[r0]
            r6.e5 = r9
            r9 = r7[r2]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = r7[r1]
            r2.append(r3)
            r2.append(r8)
            r7 = r7[r0]
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r6.E4 = r7
            goto L_0x0079
        L_0x0078:
            r9 = 0
        L_0x0079:
            net.imedicaldoctor.imd.Data.CompressHelper r7 = r6.Q4
            android.os.Bundle r8 = r6.D4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Select * from topics where id='"
            r2.append(r3)
            java.lang.String r3 = r6.e5
            r2.append(r3)
            java.lang.String r3 = "'"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.util.ArrayList r7 = r7.V(r8, r2)
            if (r7 == 0) goto L_0x01df
            int r8 = r7.size()
            if (r8 != 0) goto L_0x00a3
            goto L_0x01df
        L_0x00a3:
            java.lang.Object r7 = r7.get(r1)
            android.os.Bundle r7 = (android.os.Bundle) r7
            r6.b5 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            android.os.Bundle r8 = r6.b5
            java.lang.String r0 = "title"
            java.lang.String r8 = r8.getString(r0)
            r7.append(r8)
            java.lang.String r8 = " - "
            r7.append(r8)
            android.os.Bundle r8 = r6.b5
            java.lang.String r0 = "category"
            java.lang.String r8 = r8.getString(r0)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.F4 = r7
            net.imedicaldoctor.imd.Data.CompressHelper r7 = r6.Q4
            android.os.Bundle r8 = r6.D4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Select * from fields where topicId='"
            r0.append(r2)
            java.lang.String r2 = r6.e5
            r0.append(r2)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.util.ArrayList r7 = r7.V(r8, r0)
            r6.c5 = r7
            net.imedicaldoctor.imd.Data.CompressHelper r7 = r6.Q4
            android.os.Bundle r8 = r6.D4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Select * from images where topic_id='"
            r0.append(r2)
            java.lang.String r2 = r6.e5
            r0.append(r2)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.util.ArrayList r7 = r7.V(r8, r0)
            r6.Y4 = r7
            if (r7 != 0) goto L_0x011a
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.Y4 = r7
        L_0x011a:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.Z4 = r7
            java.util.ArrayList<android.os.Bundle> r7 = r6.Y4
            java.util.Iterator r7 = r7.iterator()
        L_0x0127:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x018e
            java.lang.Object r8 = r7.next()
            android.os.Bundle r8 = (android.os.Bundle) r8
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            android.os.Bundle r2 = r6.D4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "id"
            java.lang.String r5 = r8.getString(r4)
            r3.append(r5)
            java.lang.String r5 = ".jpg"
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "images-E"
            java.lang.String r2 = net.imedicaldoctor.imd.Data.CompressHelper.h1(r2, r3, r5)
            java.lang.String r3 = "ImagePath"
            r0.putString(r3, r2)
            java.lang.String r2 = r8.getString(r4)
            r0.putString(r4, r2)
            java.lang.String r2 = "Encrypted"
            java.lang.String r3 = "1"
            r0.putString(r2, r3)
            net.imedicaldoctor.imd.Data.CompressHelper r2 = r6.Q4
            java.lang.String r3 = "caption"
            java.lang.String r3 = r8.getString(r3)
            java.lang.String r8 = r8.getString(r4)
            java.lang.String r4 = "127"
            java.lang.String r8 = r2.B(r3, r8, r4)
            java.lang.String r2 = "DescriptionHTML2"
            r0.putString(r2, r8)
            java.lang.String r8 = "db"
            android.os.Bundle r2 = r6.D4
            r0.putBundle(r8, r2)
            java.util.ArrayList<android.os.Bundle> r8 = r6.Z4
            r8.add(r0)
            goto L_0x0127
        L_0x018e:
            if (r9 == 0) goto L_0x019c
            android.view.View r7 = r6.C4
            net.imedicaldoctor.imd.Fragments.Amirsys.ASMenuActivityFragment$1 r8 = new net.imedicaldoctor.imd.Fragments.Amirsys.ASMenuActivityFragment$1
            r8.<init>(r9)
            r2 = 1000(0x3e8, double:4.94E-321)
            r7.postDelayed(r8, r2)
        L_0x019c:
            android.os.Bundle r7 = r6.y()
            java.lang.String r8 = "SEARCH"
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L_0x01c1
            android.os.Bundle r7 = r6.y()
            java.lang.String[] r7 = r7.getStringArray(r8)
            if (r7 == 0) goto L_0x01c1
            java.util.Timer r7 = new java.util.Timer
            r7.<init>()
            net.imedicaldoctor.imd.Fragments.Amirsys.ASMenuActivityFragment$2 r8 = new net.imedicaldoctor.imd.Fragments.Amirsys.ASMenuActivityFragment$2
            r8.<init>()
            r2 = 2000(0x7d0, double:9.88E-321)
            r7.schedule(r8, r2)
        L_0x01c1:
            net.imedicaldoctor.imd.Fragments.Amirsys.ASMenuActivityFragment$DiagnosisAdapter r7 = new net.imedicaldoctor.imd.Fragments.Amirsys.ASMenuActivityFragment$DiagnosisAdapter
            r7.<init>()
            r6.a5 = r7
            androidx.recyclerview.widget.RecyclerView r8 = r6.X4
            r8.setAdapter(r7)
            r6.L4()
            r7 = 2131689477(0x7f0f0005, float:1.900797E38)
            r6.f3(r7)
            r6.o2(r1)
            r6.G3()
        L_0x01dc:
            android.view.View r7 = r6.C4
            return r7
        L_0x01df:
            androidx.fragment.app.FragmentActivity r7 = r6.r()
            java.lang.String r8 = "Can't find the document, sorry"
            net.imedicaldoctor.imd.Data.CompressHelper.x2(r7, r8, r0)
            goto L_0x01dc
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Amirsys.ASMenuActivityFragment.U0(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public boolean e1(MenuItem menuItem) {
        menuItem.getItemId();
        return super.e1(menuItem);
    }

    public void o4() {
        new AsyncTask() {

            /* renamed from: a  reason: collision with root package name */
            byte[] f29623a;

            /* access modifiers changed from: protected */
            public Object doInBackground(Object[] objArr) {
                try {
                    File file = new File(ASMenuActivityFragment.this.R2());
                    this.f29623a = new CompressHelper(ASMenuActivityFragment.this.r()).w(CompressHelper.d2(file), file.getName(), "127");
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
                Glide.G(ASMenuActivityFragment.this.r()).h(this.f29623a).B2(ASMenuActivityFragment.this.M4);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.C4.postDelayed(new Runnable() {
            public void run() {
                ASMenuActivityFragment.this.a5.G();
            }
        }, 500);
    }
}
