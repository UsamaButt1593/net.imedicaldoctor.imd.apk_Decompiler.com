package net.imedicaldoctor.imd.Gallery;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.common.MimeTypes;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Views.ButtonSmall;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class ImagePagerFragment extends Fragment {
    public static final String l4 = "com.nostra13.example.universalimageloader.FRAGMENT_INDEX";
    public static final String m4 = "com.nostra13.example.universalimageloader.IMAGE_POSITION";
    public static final int n4 = 2;
    private static int o4;
    ArrayList<Bundle> e4;
    public Toolbar f4;
    public TextView g4;
    public MediaController h4;
    public VideoView i4;
    public String j4;
    public Typeface k4;

    private class ImageAdapter extends PagerAdapter {

        /* renamed from: g  reason: collision with root package name */
        static final /* synthetic */ boolean f30211g = false;

        /* renamed from: e  reason: collision with root package name */
        private final LayoutInflater f30212e;

        ImageAdapter() {
            this.f30212e = LayoutInflater.from(ImagePagerFragment.this.r());
        }

        public void b(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int e() {
            return ImagePagerFragment.this.e4.size();
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x0226  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0238  */
        @android.annotation.SuppressLint({"UnsafeOptInUsageError"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object j(android.view.ViewGroup r21, int r22) {
            /*
                r20 = this;
                r1 = r20
                r2 = r21
                r0 = r22
                r3 = 1
                java.lang.String r4 = "::"
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r5 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this
                java.util.ArrayList<android.os.Bundle> r5 = r5.e4
                java.lang.Object r5 = r5.get(r0)
                android.os.Bundle r5 = (android.os.Bundle) r5
                java.lang.String r6 = "isVideo"
                boolean r6 = r5.containsKey(r6)
                java.lang.String r7 = " "
                r8 = 8
                java.lang.String r10 = "ImagePath"
                if (r6 == 0) goto L_0x0124
                java.lang.String r0 = "VideoPath"
                boolean r6 = r5.containsKey(r0)
                java.lang.String r11 = ".mp4"
                java.lang.String r12 = ".mov"
                if (r6 == 0) goto L_0x00d2
                java.lang.String r0 = r5.getString(r0)
                java.lang.String r6 = r5.getString(r10)
                java.io.File r13 = new java.io.File
                r13.<init>(r0)
                net.imedicaldoctor.imd.Data.CompressHelper r14 = new net.imedicaldoctor.imd.Data.CompressHelper     // Catch:{ Exception -> 0x007f }
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r0 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this     // Catch:{ Exception -> 0x007f }
                androidx.fragment.app.FragmentActivity r0 = r0.r()     // Catch:{ Exception -> 0x007f }
                r14.<init>(r0)     // Catch:{ Exception -> 0x007f }
                net.imedicaldoctor.imd.VBHelper r0 = new net.imedicaldoctor.imd.VBHelper     // Catch:{ Exception -> 0x007f }
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r15 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this     // Catch:{ Exception -> 0x007f }
                androidx.fragment.app.FragmentActivity r15 = r15.r()     // Catch:{ Exception -> 0x007f }
                r0.<init>(r15)     // Catch:{ Exception -> 0x007f }
                java.lang.String r15 = r13.getName()     // Catch:{ Exception -> 0x007f }
                java.lang.String r9 = r0.m()     // Catch:{ Exception -> 0x007f }
                java.lang.String r0 = r0.x(r9)     // Catch:{ Exception -> 0x007f }
                java.lang.String r9 = "||"
                java.lang.String r0 = r0.replace(r9, r4)     // Catch:{ Exception -> 0x007f }
                java.lang.String[] r0 = android.text.TextUtils.split(r0, r4)     // Catch:{ Exception -> 0x007f }
                r0 = r0[r3]     // Catch:{ Exception -> 0x007f }
                int r4 = r15.length()     // Catch:{ Exception -> 0x007f }
            L_0x006c:
                if (r4 >= r8) goto L_0x0081
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007f }
                r9.<init>()     // Catch:{ Exception -> 0x007f }
                r9.append(r15)     // Catch:{ Exception -> 0x007f }
                r9.append(r7)     // Catch:{ Exception -> 0x007f }
                java.lang.String r15 = r9.toString()     // Catch:{ Exception -> 0x007f }
                int r4 = r4 + r3
                goto L_0x006c
            L_0x007f:
                r0 = move-exception
                goto L_0x00c4
            L_0x0081:
                java.lang.String r3 = r6.replace(r12, r11)     // Catch:{ Exception -> 0x007f }
                java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x007f }
                r4.<init>(r3)     // Catch:{ Exception -> 0x007f }
                boolean r4 = r4.exists()     // Catch:{ Exception -> 0x007f }
                if (r4 != 0) goto L_0x00d2
                r4 = 16
                byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x007f }
                r4 = {17, 115, 105, 102, 103, 104, 111, 107, 108, 122, 120, 119, 118, 98, 110, 109} // fill-array     // Catch:{ Exception -> 0x007f }
                java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x007f }
                r6.<init>(r13)     // Catch:{ Exception -> 0x007f }
                java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x007f }
                r7.<init>(r3)     // Catch:{ Exception -> 0x007f }
                char[] r0 = r0.toCharArray()     // Catch:{ Exception -> 0x007f }
                java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x007f }
                byte[] r16 = r15.getBytes(r8)     // Catch:{ Exception -> 0x007f }
                r15 = r0
                r17 = r4
                r18 = r6
                r19 = r7
                r14.O0(r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x007f }
                r6.close()     // Catch:{ Exception -> 0x007f }
                r7.close()     // Catch:{ Exception -> 0x007f }
                java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x007f }
                r0.<init>(r3)     // Catch:{ Exception -> 0x007f }
                r0.deleteOnExit()     // Catch:{ Exception -> 0x007f }
                goto L_0x00d2
            L_0x00c4:
                com.google.firebase.crashlytics.FirebaseCrashlytics r3 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                r3.g(r0)
                java.lang.String r0 = "VideoPlayer"
                java.lang.String r3 = "Error in Decrypting video"
                net.imedicaldoctor.imd.iMDLogger.f(r0, r3)
            L_0x00d2:
                android.view.LayoutInflater r0 = r1.f30212e
                r3 = 2131558576(0x7f0d00b0, float:1.8742472E38)
                r4 = 0
                android.view.View r0 = r0.inflate(r3, r2, r4)
                r3 = 2131362157(0x7f0a016d, float:1.8344087E38)
                android.view.View r3 = r0.findViewById(r3)
                androidx.media3.ui.PlayerView r3 = (androidx.media3.ui.PlayerView) r3
                androidx.media3.exoplayer.ExoPlayer$Builder r4 = new androidx.media3.exoplayer.ExoPlayer$Builder
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r6 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this
                android.content.Context r6 = r6.B()
                r4.<init>(r6)
                androidx.media3.exoplayer.ExoPlayer r4 = r4.w()
                java.io.File r6 = new java.io.File
                java.lang.String r5 = r5.getString(r10)
                java.lang.String r5 = r5.replace(r12, r11)
                r6.<init>(r5)
                android.net.Uri r5 = android.net.Uri.fromFile(r6)
                androidx.media3.datasource.FileDataSource$Factory r6 = new androidx.media3.datasource.FileDataSource$Factory
                r6.<init>()
                androidx.media3.exoplayer.source.ProgressiveMediaSource$Factory r7 = new androidx.media3.exoplayer.source.ProgressiveMediaSource$Factory
                r7.<init>(r6)
                androidx.media3.common.MediaItem r5 = androidx.media3.common.MediaItem.d(r5)
                androidx.media3.exoplayer.source.ProgressiveMediaSource r5 = r7.c(r5)
                r3.setPlayer(r4)
                r4.A1(r5)
                r4.k()
                r2.addView(r0)
                return r0
            L_0x0124:
                android.view.LayoutInflater r3 = r1.f30212e
                r4 = 2131558588(0x7f0d00bc, float:1.8742496E38)
                r5 = 0
                android.view.View r3 = r3.inflate(r4, r2, r5)
                r4 = 2131362260(0x7f0a01d4, float:1.8344296E38)
                android.view.View r4 = r3.findViewById(r4)
                android.widget.ImageView r4 = (android.widget.ImageView) r4
                r5 = 2131362644(0x7f0a0354, float:1.8345074E38)
                android.view.View r5 = r3.findViewById(r5)
                android.widget.TextView r5 = (android.widget.TextView) r5
                r6 = 2131361995(0x7f0a00cb, float:1.8343758E38)
                android.view.View r6 = r3.findViewById(r6)
                android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
                r9 = r4
                com.github.chrisbanes.photoview.PhotoView r9 = (com.github.chrisbanes.photoview.PhotoView) r9
                r11 = 1045220557(0x3e4ccccd, float:0.2)
                r9.setMinimumScale(r11)
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r11 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this
                android.graphics.Typeface r11 = r11.k4
                r5.setTypeface(r11)
                r11 = 1065353216(0x3f800000, float:1.0)
                r9.setScale(r11)
                r6.setVisibility(r8)
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r8 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this
                java.util.ArrayList<android.os.Bundle> r8 = r8.e4
                java.lang.Object r8 = r8.get(r0)
                android.os.Bundle r8 = (android.os.Bundle) r8
                java.lang.String r11 = "Description"
                boolean r8 = r8.containsKey(r11)
                if (r8 == 0) goto L_0x019b
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r8 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this
                java.util.ArrayList<android.os.Bundle> r8 = r8.e4
                java.lang.Object r8 = r8.get(r0)
                android.os.Bundle r8 = (android.os.Bundle) r8
                java.lang.String r8 = r8.getString(r11)
                java.lang.String r8 = r8.trim()
                java.lang.String r11 = "\\s{2,}"
                java.lang.String r7 = r8.replaceAll(r11, r7)
                java.lang.String r7 = r7.trim()
                r5.setText(r7)
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment$ImageAdapter$1 r5 = new net.imedicaldoctor.imd.Gallery.ImagePagerFragment$ImageAdapter$1
                r5.<init>(r6)
            L_0x0197:
                r9.setOnPhotoTapListener(r5)
                goto L_0x020b
            L_0x019b:
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r7 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this
                java.util.ArrayList<android.os.Bundle> r7 = r7.e4
                java.lang.Object r7 = r7.get(r0)
                android.os.Bundle r7 = (android.os.Bundle) r7
                java.lang.String r8 = "DescriptionHTML"
                boolean r7 = r7.containsKey(r8)
                if (r7 == 0) goto L_0x01c8
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r7 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this
                java.util.ArrayList<android.os.Bundle> r7 = r7.e4
                java.lang.Object r7 = r7.get(r0)
                android.os.Bundle r7 = (android.os.Bundle) r7
                java.lang.String r7 = r7.getString(r8)
                android.text.Spanned r7 = android.text.Html.fromHtml(r7)
                r5.setText(r7)
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment$ImageAdapter$2 r5 = new net.imedicaldoctor.imd.Gallery.ImagePagerFragment$ImageAdapter$2
                r5.<init>(r6)
                goto L_0x0197
            L_0x01c8:
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r7 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this
                java.util.ArrayList<android.os.Bundle> r7 = r7.e4
                java.lang.Object r7 = r7.get(r0)
                android.os.Bundle r7 = (android.os.Bundle) r7
                java.lang.String r8 = "DescriptionHTML2"
                boolean r7 = r7.containsKey(r8)
                if (r7 == 0) goto L_0x020b
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r7 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this
                java.util.ArrayList<android.os.Bundle> r7 = r7.e4
                java.lang.Object r7 = r7.get(r0)
                android.os.Bundle r7 = (android.os.Bundle) r7
                java.lang.String r7 = r7.getString(r8)
                java.lang.String r8 = "&lt;"
                java.lang.String r11 = "<"
                java.lang.String r7 = r7.replace(r8, r11)
                java.lang.String r8 = "&gt;"
                java.lang.String r11 = ">"
                java.lang.String r7 = r7.replace(r8, r11)
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment$ImageAdapter$3 r8 = new net.imedicaldoctor.imd.Gallery.ImagePagerFragment$ImageAdapter$3
                r8.<init>(r0)
                r11 = 0
                android.text.Spanned r7 = android.text.Html.fromHtml(r7, r8, r11)
                r5.setText(r7)
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment$ImageAdapter$4 r5 = new net.imedicaldoctor.imd.Gallery.ImagePagerFragment$ImageAdapter$4
                r5.<init>(r6)
                goto L_0x0197
            L_0x020b:
                r5 = 2131362311(0x7f0a0207, float:1.83444E38)
                android.view.View r5 = r3.findViewById(r5)
                android.widget.ProgressBar r5 = (android.widget.ProgressBar) r5
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r6 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this
                java.util.ArrayList<android.os.Bundle> r6 = r6.e4
                java.lang.Object r0 = r6.get(r0)
                android.os.Bundle r0 = (android.os.Bundle) r0
                java.lang.String r6 = "Encrypted"
                boolean r6 = r0.containsKey(r6)
                if (r6 == 0) goto L_0x0238
                r6 = 0
                r5.setVisibility(r6)
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment$ImageAdapter$5 r7 = new net.imedicaldoctor.imd.Gallery.ImagePagerFragment$ImageAdapter$5
                r7.<init>(r0, r4, r5)
                java.util.concurrent.Executor r0 = android.os.AsyncTask.THREAD_POOL_EXECUTOR
                java.lang.Object[] r4 = new java.lang.Object[r6]
                r7.executeOnExecutor(r0, r4)
            L_0x0236:
                r4 = 0
                goto L_0x029d
            L_0x0238:
                java.lang.String r5 = "base64"
                boolean r6 = r0.containsKey(r5)
                if (r6 == 0) goto L_0x0256
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r6 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this
                androidx.fragment.app.FragmentActivity r6 = r6.r()
                com.bumptech.glide.RequestManager r6 = com.bumptech.glide.Glide.G(r6)
                byte[] r0 = r0.getByteArray(r5)
                com.bumptech.glide.RequestBuilder r0 = r6.h(r0)
            L_0x0252:
                r0.B2(r4)
                goto L_0x0236
            L_0x0256:
                java.lang.String r5 = r0.getString(r10)
                java.lang.String r6 = "http://"
                boolean r5 = r5.contains(r6)
                if (r5 == 0) goto L_0x0285
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r5 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this
                androidx.fragment.app.FragmentActivity r5 = r5.r()
                com.bumptech.glide.RequestManager r5 = com.bumptech.glide.Glide.G(r5)
                java.lang.String r0 = r0.getString(r10)
                com.bumptech.glide.RequestBuilder r0 = r5.t(r0)
                com.bumptech.glide.request.RequestOptions r5 = new com.bumptech.glide.request.RequestOptions
                r5.<init>()
                r6 = 2131231292(0x7f08023c, float:1.807866E38)
                com.bumptech.glide.request.BaseRequestOptions r5 = r5.d1(r6)
                com.bumptech.glide.RequestBuilder r0 = r0.a(r5)
                goto L_0x0252
            L_0x0285:
                net.imedicaldoctor.imd.Gallery.ImagePagerFragment r5 = net.imedicaldoctor.imd.Gallery.ImagePagerFragment.this
                androidx.fragment.app.FragmentActivity r5 = r5.r()
                com.bumptech.glide.RequestManager r5 = com.bumptech.glide.Glide.G(r5)
                java.io.File r6 = new java.io.File
                java.lang.String r0 = r0.getString(r10)
                r6.<init>(r0)
                com.bumptech.glide.RequestBuilder r0 = r5.i(r6)
                goto L_0x0252
            L_0x029d:
                r2.addView(r3, r4)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Gallery.ImagePagerFragment.ImageAdapter.j(android.view.ViewGroup, int):java.lang.Object");
        }

        public boolean k(View view, Object obj) {
            return view.equals(obj);
        }

        public void n(Parcelable parcelable, ClassLoader classLoader) {
        }

        public Parcelable o() {
            return null;
        }
    }

    public static void L2(String str, Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("mime_type", MimeTypes.f9231f);
        contentValues.put("_data", str);
        context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    public Boolean J2() {
        try {
            if (Build.VERSION.SDK_INT < 23 || ContextCompat.a(r(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                return Boolean.TRUE;
            }
            if (ActivityCompat.T(r(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                Toast.makeText(r(), "", 1).show();
            }
            new AlertDialog.Builder(r(), R.style.f2185alertDialogTheme).l("Write External Storage permission allows us to save images on your device").y("Allow it", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    ActivityCompat.N(ImagePagerFragment.this.r(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
                }
            }).p("Not now", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).I();
            return Boolean.FALSE;
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            Log.e("PremissionGranted", e2.getLocalizedMessage());
            return Boolean.FALSE;
        }
    }

    public void K2(String str, Context context) {
        try {
            M2(str, context);
        } catch (Exception unused) {
            Toast.makeText(context, "Error in saving image", 0).show();
        }
    }

    public void M2(String str, Context context) throws IOException {
        OutputStream outputStream;
        String name = new File(str).getName();
        if (Build.VERSION.SDK_INT >= 29) {
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", name);
            contentValues.put("mime_type", MimeTypes.R0);
            contentValues.put("relative_path", "DCIM/" + "iMD");
            outputStream = contentResolver.openOutputStream(contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues));
        } else if (J2().booleanValue()) {
            String file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM + "/" + "iMD").toString();
            File file2 = new File(file);
            if (!file2.exists()) {
                file2.mkdir();
            }
            outputStream = new FileOutputStream(new File(file, name));
        } else {
            return;
        }
        BufferedSource e2 = Okio.e(Okio.t(new File(str)));
        BufferedSink d2 = Okio.d(Okio.p(outputStream));
        d2.y1(e2);
        e2.close();
        d2.close();
        Toast.makeText(context, "Image Saved", 0).show();
    }

    public void Q0(Bundle bundle) {
        super.Q0(bundle);
        this.k4 = Typeface.createFromAsset(r().getAssets(), "fonts/HelveticaNeue-Light.otf");
    }

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e4 = y().getParcelableArrayList("Images");
        int i2 = 0;
        View inflate = layoutInflater.inflate(R.layout.f1210fr_image_pager, viewGroup, false);
        final ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.f1036pager);
        viewPager.setAdapter(new ImageAdapter());
        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.f1139toolbar);
        this.f4 = toolbar;
        this.g4 = (TextView) toolbar.findViewById(R.id.f1143toolbar_title);
        ButtonSmall buttonSmall = (ButtonSmall) inflate.findViewById(R.id.f829back_button);
        this.f4.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ImagePagerFragment.this.r().finish();
                ImagePagerFragment.this.r().overridePendingTransition(R.anim.f23to_fade_in, R.anim.f24to_fade_out);
            }
        });
        if (buttonSmall != null) {
            buttonSmall.setDrawableIcon(r().getResources().getDrawable(R.drawable.f537back_icon));
            buttonSmall.setRippleColor(r().getResources().getColor(R.color.f466toolbar_item_ripple_color));
            buttonSmall.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ImagePagerFragment.this.r().finish();
                    ImagePagerFragment.this.r().overridePendingTransition(R.anim.f23to_fade_in, R.anim.f24to_fade_out);
                }
            });
        }
        ((TextView) inflate.findViewById(R.id.f1074show_in_text)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        ((ImageButton) inflate.findViewById(R.id.f816action_share)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String str;
                int i2;
                BufferedSource e2;
                Throwable th;
                BufferedSink d2;
                Throwable th2;
                FragmentActivity r;
                String str2;
                Bundle bundle = ImagePagerFragment.this.e4.get(viewPager.getCurrentItem());
                if (bundle.containsKey("isVideo")) {
                    CompressHelper.x2(ImagePagerFragment.this.r(), "Can't share video", 0);
                    return;
                }
                String str3 = "";
                String string = bundle.containsKey("Description") ? bundle.getString("Description") : str3;
                if (bundle.containsKey("DescriptionHTML")) {
                    str3 = bundle.getString("DescriptionHTML");
                }
                if (bundle.containsKey("DescriptionHTML2")) {
                    str3 = bundle.getString("DescriptionHTML2");
                }
                if (string.length() == 0) {
                    string = str3;
                }
                if (bundle.containsKey("Encrypted")) {
                    try {
                        File file = new File(bundle.getString("ImagePath"));
                        byte[] b0 = Okio.e(Okio.t(file)).b0();
                        String name = file.getName();
                        byte[] w = new CompressHelper(ImagePagerFragment.this.r()).w(b0, name, "127");
                        File file2 = new File(new CompressHelper(ImagePagerFragment.this.r()).M1() + "/" + name);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        Okio.d(Okio.n(file2)).write(w).close();
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.SEND");
                        intent.addFlags(1);
                        FragmentActivity r2 = ImagePagerFragment.this.r();
                        intent.putExtra("android.intent.extra.STREAM", FileProvider.h(r2, ImagePagerFragment.this.r().getApplicationContext().getPackageName() + ".provider", file2));
                        if (string.length() > 0) {
                            intent.putExtra("android.intent.extra.TEXT", string);
                        }
                        intent.setType("image/*");
                        ImagePagerFragment.this.D2(Intent.createChooser(intent, "Share Image ..."));
                        return;
                    } catch (Exception e3) {
                        FirebaseCrashlytics.d().g(e3);
                        e3.printStackTrace();
                        CompressHelper.x2(ImagePagerFragment.this.r(), "Can't share this photo", 0);
                        return;
                    }
                } else if (bundle.containsKey("base64")) {
                    try {
                        String string2 = bundle.getString("name");
                        StringBuilder sb = new StringBuilder();
                        str2 = "Can't share this photo";
                        try {
                            sb.append(new CompressHelper(ImagePagerFragment.this.r()).M1());
                            sb.append("/");
                            sb.append(string2);
                            File file3 = new File(sb.toString());
                            if (file3.exists()) {
                                file3.delete();
                            }
                            Okio.d(Okio.n(file3)).write(bundle.getByteArray("base64")).close();
                            Intent intent2 = new Intent();
                            intent2.setAction("android.intent.action.SEND");
                            FragmentActivity r3 = ImagePagerFragment.this.r();
                            intent2.putExtra("android.intent.extra.STREAM", FileProvider.h(r3, ImagePagerFragment.this.r().getApplicationContext().getPackageName() + ".provider", file3));
                            if (string.length() > 0) {
                                intent2.putExtra("android.intent.extra.TEXT", string);
                            }
                            intent2.setType("image/*");
                            intent2.addFlags(1);
                            ImagePagerFragment.this.D2(Intent.createChooser(intent2, "Share Image ..."));
                            return;
                        } catch (Exception e4) {
                            e = e4;
                            FirebaseCrashlytics.d().g(e);
                            e.printStackTrace();
                            r = ImagePagerFragment.this.r();
                            str = str2;
                            i2 = 0;
                            CompressHelper.x2(r, str, i2);
                            return;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        str2 = "Can't share this photo";
                        FirebaseCrashlytics.d().g(e);
                        e.printStackTrace();
                        r = ImagePagerFragment.this.r();
                        str = str2;
                        i2 = 0;
                        CompressHelper.x2(r, str, i2);
                        return;
                    }
                } else {
                    str = "Can't share this photo";
                    i2 = 0;
                    if (bundle.getString("ImagePath").contains("http://")) {
                        r = ImagePagerFragment.this.r();
                        CompressHelper.x2(r, str, i2);
                        return;
                    }
                    File file4 = new File(bundle.getString("ImagePath"));
                    String name2 = file4.getName();
                    File file5 = new File(new CompressHelper(ImagePagerFragment.this.r()).M1() + "/" + name2);
                    if (file5.exists()) {
                        file5.delete();
                    }
                    try {
                        e2 = Okio.e(Okio.t(file4));
                        d2 = Okio.d(Okio.n(file5));
                        d2.y1(e2);
                        d2.close();
                        if (e2 != null) {
                            e2.close();
                        }
                    } catch (Exception e6) {
                        FirebaseCrashlytics.d().g(e6);
                        e6.printStackTrace();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    Intent intent3 = new Intent();
                    intent3.setAction("android.intent.action.SEND");
                    FragmentActivity r4 = ImagePagerFragment.this.r();
                    intent3.putExtra("android.intent.extra.STREAM", FileProvider.h(r4, ImagePagerFragment.this.r().getApplicationContext().getPackageName() + ".provider", file5));
                    intent3.setType("image/*");
                    intent3.addFlags(1);
                    ImagePagerFragment.this.D2(Intent.createChooser(intent3, "Share Image ..."));
                    return;
                }
                throw th;
                throw th2;
            }
        });
        ((ImageButton) inflate.findViewById(R.id.f812action_save)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BufferedSource e2;
                BufferedSink d2;
                FragmentActivity r;
                String str;
                BufferedSink d3;
                BufferedSource e3;
                BufferedSink d4;
                Bundle bundle = ImagePagerFragment.this.e4.get(viewPager.getCurrentItem());
                if (bundle.containsKey("isVideo")) {
                    CompressHelper.x2(ImagePagerFragment.this.r(), "Can't save video", 0);
                    return;
                } else if (bundle.containsKey("Encrypted")) {
                    try {
                        File file = new File(bundle.getString("ImagePath"));
                        e3 = Okio.e(Okio.t(file));
                        byte[] b0 = e3.b0();
                        e3.close();
                        String name = file.getName();
                        byte[] w = new CompressHelper(ImagePagerFragment.this.r()).w(b0, name, "127");
                        File file2 = new File(new CompressHelper(ImagePagerFragment.this.r()).M1() + "/" + name);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        d4 = Okio.d(Okio.n(file2));
                        d4.write(w);
                        d4.close();
                        ImagePagerFragment.this.K2(file2.getPath(), ImagePagerFragment.this.r());
                        return;
                    } catch (Exception e4) {
                        FirebaseCrashlytics.d().g(e4);
                        e4.printStackTrace();
                        r = ImagePagerFragment.this.r();
                        str = "Can't save this media";
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                } else if (bundle.containsKey("base64")) {
                    try {
                        String string = bundle.getString("name");
                        File file3 = new File(new CompressHelper(ImagePagerFragment.this.r()).M1() + "/" + string);
                        if (file3.exists()) {
                            file3.delete();
                        }
                        byte[] byteArray = bundle.getByteArray("base64");
                        d3 = Okio.d(Okio.n(file3));
                        d3.write(byteArray);
                        d3.close();
                        ImagePagerFragment.this.K2(file3.getPath(), ImagePagerFragment.this.r());
                        return;
                    } catch (Exception e5) {
                        FirebaseCrashlytics.d().g(e5);
                        e5.printStackTrace();
                        r = ImagePagerFragment.this.r();
                        str = "Can't save this photo";
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                } else if (bundle.getString("ImagePath").contains("http://")) {
                    r = ImagePagerFragment.this.r();
                    str = "Can't share this media";
                    CompressHelper.x2(r, str, 0);
                    return;
                } else {
                    File file4 = new File(bundle.getString("ImagePath"));
                    String name2 = file4.getName();
                    File file5 = new File(new CompressHelper(ImagePagerFragment.this.r()).M1() + "/" + name2);
                    if (file5.exists()) {
                        file5.delete();
                    }
                    try {
                        e2 = Okio.e(Okio.t(file4));
                        d2 = Okio.d(Okio.n(file5));
                        d2.y1(e2);
                        d2.close();
                        if (e2 != null) {
                            e2.close();
                        }
                    } catch (Exception e6) {
                        FirebaseCrashlytics.d().g(e6);
                        e6.printStackTrace();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    ImagePagerFragment.this.K2(file5.getPath(), ImagePagerFragment.this.r());
                    return;
                }
                throw th;
                throw th;
                throw th;
                throw th;
                throw th;
            }
        });
        final int e2 = viewPager.getAdapter().e();
        if (y() != null) {
            i2 = y().getInt("Start", 0);
        }
        viewPager.setCurrentItem(i2);
        if (bundle != null) {
            o4 = bundle.getInt("Start");
        }
        int i3 = o4;
        if (i3 > 0) {
            viewPager.setCurrentItem(i3);
        }
        TextView textView = this.g4;
        textView.setText((viewPager.getCurrentItem() + 1) + " of " + e2);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void a(int i2, float f2, int i3) {
            }

            public void c(int i2) {
                MediaController mediaController = ImagePagerFragment.this.h4;
                if (mediaController != null) {
                    mediaController.hide();
                    ImagePagerFragment.this.i4.pause();
                }
            }

            public void d(int i2) {
                TextView textView = ImagePagerFragment.this.g4;
                textView.setText((i2 + 1) + " of " + e2);
            }
        });
        return inflate;
    }

    public void m1(Bundle bundle) {
        super.m1(bundle);
    }
}
