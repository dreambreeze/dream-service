package cn.dreambreeze.server.utils;

import cn.dreambreeze.server.VO.Audience;
import cn.dreambreeze.server.constant.ResultCode;
import cn.dreambreeze.server.exception.CustomException;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;

/**
 * @author dream breeze
 * @date 2020/9/17 10:05
 */
public class JwtTokenUtil {

  public static final String AUTH_KEY = "AuthToken";
  private static final Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);

  /**
   * 解析jwt
   */
  public static Claims parseJWT(String jsonWebToken, String base64Security) {
    try {
      Claims claims = Jwts.parser()
        .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
        .parseClaimsJws(jsonWebToken).getBody();
      return claims;
    } catch (ExpiredJwtException eje) {
      log.error("===== Token过期 =====", eje);
      throw new CustomException(ResultCode.PERMISSION_TOKEN_EXPIRED);
    } catch (Exception e) {
      log.error("===== token解析异常 =====", e);
      throw new CustomException(ResultCode.PERMISSION_TOKEN_INVALID);
    }
  }

  /**
   * 构建jwt
   */
  public static String createJWT(String userId, String name, Audience audience) {
    try {

      long nowMillis = System.currentTimeMillis();
      Date now = new Date(nowMillis);

      //添加构成JWT的参数
      JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
        .claim("userId", userId)
        .setSubject(name)
        .setIssuer(audience.getClientId())
        .setIssuedAt(new Date())
        .setAudience(audience.getName())
        .signWith(SignatureAlgorithm.HS256, audience.getBase64Secret());
      //添加Token过期时间
      int TTLMillis = audience.getExpiresSecond();
      if (TTLMillis >= 0) {
        long expMillis = nowMillis + TTLMillis;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp);
        builder.setNotBefore(now);
      }

      //生成JWT
      return builder.compact();
    } catch (Exception e) {
      log.error("签名失败", e);
      throw new CustomException(ResultCode.PERMISSION_SIGNATURE_ERROR);
    }
  }

  /**
   * 从token中获取用户ID
   */
  public static String getUserId(String token, String base64Security) {
    return parseJWT(token, base64Security).get("userId", String.class);
  }

  /**
   * 是否已过期
   */
  public static boolean isExpiration(String token, String base64Security) {
    return parseJWT(token, base64Security).getExpiration().before(new Date());
  }

}
