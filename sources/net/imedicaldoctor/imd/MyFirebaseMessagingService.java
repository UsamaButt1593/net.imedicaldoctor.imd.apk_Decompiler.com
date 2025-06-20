package net.imedicaldoctor.imd;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.util.Map;
import net.imedicaldoctor.imd.Data.CompressHelper;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public void r(RemoteMessage remoteMessage) {
        super.r(remoteMessage);
        Log.d("PushNotification", "From: " + remoteMessage.I());
        Map<String, String> H = remoteMessage.H();
        Intent intent = new Intent(this, NotificationActivity.class);
        intent.putExtra("title", H.get("title"));
        intent.putExtra(Annotation.i3, H.get(Annotation.i3));
        intent.putExtra(HTML.Tag.C, H.get(HTML.Tag.C));
        intent.addFlags(268435456);
        startActivity(intent);
    }

    public void t(@NonNull String str) {
        new CompressHelper(this).l0();
    }
}
