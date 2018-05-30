package sys.common;

import lombok.Data;

/**
 * @author zhaoruipeng
 * @ClassName Result
 * @Package hello.entity.common
 * @Description http请求返回的类
 * @date 2018/5/28 9:56
 */
@Data
public class ResultEnum <T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回的具体内容
     */
    private T data;

    public static ResultEnum success(Object object) {
        ResultEnum resultEnum = new ResultEnum();
        resultEnum.setCode(200);
        resultEnum.setMsg("success");
        resultEnum.setData(object);
        return resultEnum;
    }

    public static ResultEnum success() {
        return success(null);
    }

    public static ResultEnum error(Integer code, String msg) {
        ResultEnum resultEnum = new ResultEnum();
        resultEnum.setCode(code);
        resultEnum.setMsg(msg);
        return resultEnum;
    }

    public static ResultEnum _403() {
        ResultEnum resultEnum = new ResultEnum();
        resultEnum.setCode(403);
        resultEnum.setMsg("forbidden");
        return resultEnum;
    }

    public static final String LOGIN_ERROR = "{\"result\":\"error\",\"msg\":\"login_error\"}";

}
