package com.fiume.util;

import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class AppJwtUtil {

    // TOKEN的有效期一天（S）
    private static final int TOKEN_TIME_OUT = 3_600;
    // 加密KEY
    private static final String TOKEN_ENCRY_KEY = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY";
    // 最小刷新间隔(S)
    private static final int REFRESH_TIME = 300;

    // 生产ID
    public static String getToken(Long id){
        Map<String, Object> claimMaps = new HashMap<>();
        claimMaps.put("id",id);
        long currentTime = System.currentTimeMillis();
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date(currentTime))  //签发时间
                .setSubject("system")  //说明
                .setIssuer("heima") //签发者信息
                .setAudience("app")  //接收用户
                .compressWith(CompressionCodecs.GZIP)  //数据压缩方式
                .signWith(SignatureAlgorithm.HS512, generalKey()) //加密方式
                .setExpiration(new Date(currentTime + TOKEN_TIME_OUT * 1000))  //过期时间戳
                .addClaims(claimMaps) //cla信息
                .compact();
    }

    /**
     * 获取token中的claims信息
     *
     * @param token
     * @return
     */
    private static Jws<Claims> getJws(String token) {
            return Jwts.parser()
                    .setSigningKey(generalKey())
                    .parseClaimsJws(token);
    }

    /**
     * 获取payload body信息
     *
     * @param token
     * @return
     */
    public static Claims getClaimsBody(String token) {
        try {
            return getJws(token).getBody();
        }catch (ExpiredJwtException e){
            return null;
        }
    }

    /**
     * 获取hearder body信息
     *
     * @param token
     * @return
     */
    public static JwsHeader getHeaderBody(String token) {
        return getJws(token).getHeader();
    }

    /**
     * 是否过期
     *
     * @param claims
     * @return -1：有效，0：有效，1：过期，2：过期
     */
    public static int verifyToken(Claims claims) {
        if(claims==null){
            return 1;
        }
        try {   // 1个小时    3分钟
            claims.getExpiration()
                    .before(new Date());
            // 需要自动刷新TOKEN  1小时     300   55
            if((claims.getExpiration().getTime()-System.currentTimeMillis())>REFRESH_TIME*1000){
                return -1;
            }else {
                return 0;
            }
        } catch (ExpiredJwtException ex) {
            return 1;
        }catch (Exception e){
            return 2;
        }
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getEncoder().encode(TOKEN_ENCRY_KEY.getBytes());
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public static void main(String[] args) {
        Long userId = 1L;
        String token = getToken(userId); // 生成token   颁发给前端
        Claims claims = getClaimsBody(token); // 如果token 格式不对  或者 过期会报异常
        int i = verifyToken(claims); // -1：有效，0：有效，1：过期，2：过期
//        Map<String, Object> claimMaps = new HashMap<>();
//        claimMaps.put("id","1");
//        claimMaps.put("name","xiaoming");
//
//        long current = System.currentTimeMillis();
//        String token = Jwts.builder()
//                .setId(UUID.randomUUID().toString())
//                .setIssuedAt(new Date(current))  //签发时间
//                .setSubject("system")  //说明
//                .setIssuer("heima") //签发者信息
//                .setAudience("app")  //接收用户
//                .compressWith(CompressionCodecs.GZIP)  //数据压缩方式
//                .signWith(SignatureAlgorithm.HS512, "12345678") //加密方式
//                .setExpiration(new Date(current + 1000 * 1000))  //过期时间戳
//                .addClaims(claimMaps) //cla信息
//                .compact();
//        System.out.println(token);
//
//        //eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAEWLWwrDIBQF93K_I_TGRzS7OWlMa8FU0EBC6d57_erfGebMh14t0UybZ4uoWZnAizKjsSpg8wq4Q1t7C9PqaaCERjM7Zj3p0bqB6rFIXa_aYu6-VsFnTBlCOFYhlCI7nuVfOil35Cj2THjntD963N9M3x827OGHlAAAAA.5cYf8Yqc8IGGvpAgaQMWTcVZL5HZFtAjNzPrEiaVrtGXGgOS_jGxAhccb7IiNoAsQSDOI0G0dGY2rnfkymoVAg
//
//        Jws<Claims> claimsJws = Jwts.parser().setSigningKey("12345678").parseClaimsJws(token);
//
//        JwsHeader header = claimsJws.getHeader();
//        System.out.println(header);
//        Claims body = claimsJws.getBody();
//        System.out.println(body);
//        String signature = claimsJws.getSignature();
//        System.out.println(signature);
    }

}
