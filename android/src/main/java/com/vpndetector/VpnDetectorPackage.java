package com.vpndetector;

import com.facebook.react.BaseReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;

import java.util.HashMap;
import java.util.Map;

public class VpnDetectorPackage extends BaseReactPackage {

    @Override
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        if (VpnDetector.NAME.equals(name)) {
            return new VpnDetector(reactContext);
        }
        return null;
    }

    @Override
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return () -> {
            Map<String, ReactModuleInfo> moduleInfoMap = new HashMap<>();
            moduleInfoMap.put(
                VpnDetector.NAME,
                new ReactModuleInfo(
                    VpnDetector.NAME,
                    VpnDetector.NAME,
                    false, // canOverrideExistingModule
                    false, // needsEagerInit
                    false, // hasConstants
                    true   // isTurboModule
                )
            );
            return moduleInfoMap;
        };
    }
}
