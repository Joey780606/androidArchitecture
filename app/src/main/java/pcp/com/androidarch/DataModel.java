package pcp.com.androidarch;

import android.os.Handler;

public class DataModel {
    public void retrieveData(final onDataReadyCallback callback) { // keynote: onDataReadyCallback在下方
        new Handler().postDelayed(new Runnable() {  // keynote: 用法學習
            @Override
            public void run() {
                callback.onDataReady("New data");
            }
        }, 1500);
    }

    interface onDataReadyCallback {  // keynote:  用法學習
        void onDataReady(String data);
    }
}
