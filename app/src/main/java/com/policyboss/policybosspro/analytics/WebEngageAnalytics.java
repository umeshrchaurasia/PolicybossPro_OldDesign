package com.policyboss.policybosspro.analytics;

import com.webengage.sdk.android.Analytics;
import com.webengage.sdk.android.WebEngage;
import com.webengage.sdk.android.utils.WebEngageConstant;

import java.util.Map;

public class WebEngageAnalytics {
    private static WebEngageAnalytics instance;
    private WebEngageConstant weConstant;

    static Analytics weAnalytics = WebEngage.get().analytics();

    // Singleton instance of WebEngageAnalytics
    public static synchronized WebEngageAnalytics getInstance() {
        if (instance == null) {
            instance = new WebEngageAnalytics();
        }
        return instance;
    }

    // Private constructor to prevent external instantiation
    private WebEngageAnalytics() {
        // No configuration required in this class
    }

    // Method to track events
    public void trackEvent(String eventName, Map<String, Object> eventAttributes) {
        weAnalytics.track(eventName, eventAttributes);
    }
}