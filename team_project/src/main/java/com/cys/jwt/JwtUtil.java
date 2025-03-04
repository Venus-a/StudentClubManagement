package com.cys.jwt;
import com.cys.model.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
public class JwtUtil {

    //过期时间设置
    public static final long EXPIRE = 1000 * 60 * 30 ;//30分钟
    //生成密码
    public static final String APP_SECRET = "kappy";

    /**
     * 生成token 方法
     * @param user
     * @return
     */
    public static String getJwtToken(UserInfo user){
        String JwtToken = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("username", user.getUsername())
                .claim("type", user.getType())
                .claim("id", user.getId())
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
        return JwtToken;
    }
    /**
     * 判断token是否存在与有效
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * 判断token是否存在与有效
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if(StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 获取用户id
     */
    public static Integer getUserId(String token){
        Jws<Claims> claimsJws =
                Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (Integer) claims.get("id");
    }

    /**
     * 获取用户type
     */
    public static Integer getUserType(String token){
        Jws<Claims> claimsJws =
                Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (Integer) claims.get("type");
    }

    /**
     * 根据token获取xm
     * @return
     */
    public static String getMemberIdByJwtToken(String token) {
//        String jwtToken = request.getHeader("token");
        Jws<Claims> claimsJws =
                Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("username");
    }




    public static void main(String[] args) {
        // 生成token
        UserInfo info=new UserInfo();
        info.setId(1);
        info.setType(1);    //代表管理员
        info.setUsername("admin");
        String token = getJwtToken(info);
        System.out.println(token);
//        String token="eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NTkwNTU0OTEsImV4cCI6MTY1OTA1NTUwMSwidXNlcm5hbWUiOiJ6aGFuZ3NhbiIsInR5cGUiOjEsImlkIjoxfQ.xXCMq2ujV-wEeQCUsoLkpwwJXVVrJl8QH2C-iDCM83E";
         //验证是否存在与有效
        boolean b = checkToken(token);
        System.out.println(b);

//        //获取对象 用户名信息
//       String username= getMemberIdByJwtToken(token);
//       System.out.println(username);


        Integer id= getUserId(token);
        System.out.println(id);
    }

}
