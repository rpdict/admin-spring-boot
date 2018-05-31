package sys.filter;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;
import sys.common.Constant;
import sys.common.JwtHelper;
import sys.common.ResultEnum;
import sys.controller.Base;
import sys.entity.auth.Audience;

import javax.security.auth.login.LoginException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhaoruipeng
 * @ClassName JwtFilter
 * @Package sys.filter
 * @Description JWT拦截器
 * @date 2018/5/29 10:00
 */
public class JwtFilter extends GenericFilterBean {

    @Autowired
    private Audience audience;

    /**
     * Reserved claims（保留），它的含义就像是编程语言的保留字一样，属于JWT标准里面规定的一些claim。JWT标准里面定好的claim有：
     * <p>
     * iss(Issuser)：代表这个JWT的签发主体；
     * sub(Subject)：代表这个JWT的主体，即它的所有人；
     * aud(Audience)：代表这个JWT的接收对象；
     * exp(Expiration time)：是一个时间戳，代表这个JWT的过期时间；
     * nbf(Not Before)：是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的；
     * iat(Issued at)：是一个时间戳，代表这个JWT的签发时间；
     * jti(JWT ID)：是JWT的唯一标识。
     *
     * @param req
     * @param res
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        //等到请求头信息authorization信息
        final String authHeader = request.getHeader("authorization");
        Gson gson = new Gson();
        res.setContentType("text/html;charset=utf-8");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(req, res);
        } else {
            try {
                if (authHeader == null || !authHeader.startsWith("bearer;")) {
                    ((HttpServletResponse) res).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    res.getWriter().write(gson.toJson(ResultEnum._401((HttpServletResponse) res)));
                    System.out.println("no authHeader 401");
                    return;
//                    throw new LoginException(ResultEnum.LOGIN_ERROR);
                }
                final String token = authHeader.substring(7);

                if (audience == null) {
                    BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                    audience = (Audience) factory.getBean("audience");
                }
                if (request.getSession().getAttribute(Constant.CLAIMS) == null) {
                    ((HttpServletResponse) res).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    res.getWriter().write(gson.toJson(ResultEnum._401((HttpServletResponse) res)));
                    System.out.println("no session 401");
                    return;
                }
                final Claims claims = JwtHelper.parseJWT(token, audience.getBase64Secret());
                if (claims == null) {
                    ((HttpServletResponse) res).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    res.getWriter().write(gson.toJson(ResultEnum._401((HttpServletResponse) res)));
                    System.out.println("token wrong 401");
                    return;

//                    throw new LoginException(ResultEnum.LOGIN_ERROR);
                }
                request.setAttribute(Constant.CLAIMS, claims);
            } catch (final Exception e) {
                e.printStackTrace();
                res.getWriter().write(gson.toJson(ResultEnum._401((HttpServletResponse) res)));
                return;
            }

            chain.doFilter(req, res);
        }
    }
}
