package sys.common;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhaoruipeng
 * @ClassName Result
 * @Package hello.entity.common
 * @Description http请求返回的类
 * @date 2018/5/28 9:56
 */
@Data
public class ResultEnum<T> {
    /**
     * 状态码
     */
    private Integer status;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 结果
     */
    private String result;

    /**
     * 返回的具体内容
     */
    private T data;

    public static ResultEnum success(Object object) {
        ResultEnum resultEnum = new ResultEnum();
        resultEnum.setStatus(HttpServletResponse.SC_OK);
        resultEnum.setMsg("OK");
        resultEnum.setResult("success");
        resultEnum.setData(object);
        return resultEnum;
    }

    public static ResultEnum success() {
        return success(null);
    }

    public static ResultEnum error(Integer code, String msg) {
        ResultEnum resultEnum = new ResultEnum();
        resultEnum.setStatus(code);
        resultEnum.setMsg(msg);
        return resultEnum;
    }

    public static ResultEnum _403(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        ResultEnum resultEnum = new ResultEnum();
        resultEnum.setStatus(HttpServletResponse.SC_FORBIDDEN);
        resultEnum.setMsg("Forbidden");
        resultEnum.setResult("error");
        return resultEnum;
    }

    public static ResultEnum _401(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ResultEnum resultEnum = new ResultEnum();
        resultEnum.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        resultEnum.setMsg("Unauthorized");
        resultEnum.setResult("error");
        return resultEnum;
    }

    public static final String LOGIN_ERROR = "{\"result\":\"error\",\"msg\":\"login_error\"}";

}
