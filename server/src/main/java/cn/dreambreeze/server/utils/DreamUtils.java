package cn.dreambreeze.server.utils;


import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

/**
 * private utils
 *
 * @author dream breeze
 * @create 2020/9/4 23:11
 */
public class DreamUtils {

    public static Long getUTCTimestamp() {
        OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
        return utc.toInstant().toEpochMilli();
    }

    public static String getRequestId(String prefix) {
        return prefix + UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
