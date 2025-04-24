package com.vpndetector;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = VpnDetector.NAME)
public class VpnDetector extends NativeVpnDetectorSpec {
    public static final String NAME = "VpnDetector";

    public VpnDetector(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void isProxyEnabled(Callback callback) {
        String proxyHost = System.getProperty("http.proxyHost");
        int proxyPort;
        try {
            proxyPort = Integer.parseInt(System.getProperty("http.proxyPort", "-1"));
        } catch (NumberFormatException e) {
            proxyPort = -1;
        }

        if (proxyHost == null || proxyHost.isEmpty()) {
            callback.invoke("NO");
        } else {
            callback.invoke("YES");
        }
    }

    @Override
    public void isVPNEnabled(Callback callback) {
        ConnectivityManager cm = (ConnectivityManager) getReactApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkCapabilities caps = cm.getNetworkCapabilities(cm.getActiveNetwork());
        boolean vpnActive = caps != null && caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN);

        callback.invoke(vpnActive ? "YES" : "NO");
    }
}
