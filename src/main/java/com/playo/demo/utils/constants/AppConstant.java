package com.playo.demo.utils.constants;


public final class AppConstant {

        /**
         * DateTime custom API formats
         */
        public static final String LOCAL_DATE_FORMAT = "dd-MM-yyyy";
        public static final String LOCAL_DATE_TIME_FORMAT = "dd-MM-yyyy__HH:mm:ss:SSSSSS";
        public static final String ZONED_DATE_TIME_FORMAT = "dd-MM-yyyy__HH:mm:ss:SSSSSS";

        /**
         * API Context to setup Version for webservices
         */
        public static final String API_CONTEXT_V0 = "/api/v0";

        /**
         * WhiteList URLs to be authorised with http security
         */
        public static final String[] WHITELIST_URLS = {
                "/",
                "/h2-console/**",
                "/api/v*/player/login/**",
                "/api/v*/player/signup/**",
        };
}
