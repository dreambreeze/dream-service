package cn.dreambreeze.server.utils;


import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

/**
 * private utils
 *
 * @author dream breeze
 * @date 2020/9/4 23:11
 */
public class CommonUtils {

  public static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
    "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
    "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
    "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
    "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
    "W", "X", "Y", "Z"};

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

  public static String getRemoteIpAddr(HttpServletRequest request) {
    String ip = request.getHeader("x-forwarded-for");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    int index = ip.indexOf(",");
    if (index != -1) {
      return ip.substring(0, index);
    } else {
      return ip;
    }
  }

}
