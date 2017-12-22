package com.jeeday.passopener;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.pm.PackageManager;

public class PassOpener extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("openPass")) {
            String uri = args.getString(0);
            this.openPass(uri, callbackContext);
            return true;
        }
        if(action.equals("available")) {
            this.available(callbackContext);
            return true;
        }
        if(action.equals("downloadPass")) {
            String uri = args.getString(0);
            this.downloadPass(uri, callbackContext);
            return true;
        }
        if(action.equals("addPass")) {
            String uri = args.getString(0);
            this.addPass(uri, callbackContext);
            return true;
        }
        return false;
    }

    // Pass specific functions

    private void openPass(String uri, CallbackContext callbackContext) {
        if(this.checkAvailabilityOfApplications()) {
            callbackContext.success();
        }
        else {
            callbackContext.error("");
        }
    }

    private void available(CallbackContext callbackContext) {
        if(this.checkAvailabilityOfApplications()) {
            callbackContext.success();
        }
        else {
            callbackContext.error("");
        }
    }

    private void downloadPass(String uri, CallbackContext callbackContext) {
        if(this.checkAvailabilityOfApplications()) {
            callbackContext.success();
        }
        else {
            callbackContext.error("");
        }
    }

    private void addPass(String uri, CallbackContext callbackContext) {
        if(this.checkAvailabilityOfApplications()) {
            callbackContext.success();
        }
        else {
            callbackContext.error("");
        }
    }


    // Availability functions

    private void checkAvailabilityOfPassApplications() {
        String[] uris = this.getDefaultListOfPassApplications();
        boolean[] availabilities = {};
        boolean isExist = false;
        for(int item=0; item < uris.length; item++) {
           availabilities = append(availabilities, this.appInstalled(uris[item]));
        }

        // If compatible applications are found for Android
        return this.doesContainBoolean(availabilities);
    }

    // Thanks to http://floresosvaldo.com/android-cordova-plugin-checking-if-an-app-exists
    public boolean appInstalled(String uri) {
        Context ctx = this.cordova.getActivity().getApplicationContext();
        final PackageManager pm = ctx.getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch(PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    private String[] getDefaultListOfPassApplications() {
        return new String[] {
            "io.walletpasses.android",
            "org.ligi.passandroid",
            "com.attidomobile.passwallet",
            "com.passesalliance.wallet",
            "com.walletunion.wallet",
            "com.pbook.passwallet",
            "com.passkit.android",
            "es.claucookie.pasbuk"
        };
    }

    private boolean doesContainBoolean(boolean[] boolArray) {
        for(int item=0; item < boolArray.length; item++) {
           if(boolArray[item]) {
                return true;
           }
        }
        return false;
    }
}
