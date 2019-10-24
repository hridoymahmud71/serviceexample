package hridoy.aiz.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class HridoyPlayService extends Service {
    public HridoyPlayService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
