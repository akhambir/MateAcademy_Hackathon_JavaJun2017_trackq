package com.mate.trackq.util;

import javax.servlet.http.HttpServletRequest;

public class DomainUtils {

    public static String getUrl(HttpServletRequest request) {
        return request.getScheme() + "://" +
                request.getServerName() +
                ":" + request.getServerPort();
    }

}
