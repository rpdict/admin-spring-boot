/**   
* @Title: Constant.java 
* @Package com.ge.common 
* @Description: TODO(常量类) 
* @author lhh   
* @date 2014-4-25 上午11:35:27 
* @version V1.0   
*/
package sys.common;


/** 
 * @ClassName: Constant 
 * @Description: TODO(常量类) 
 * @author lhh 
 * @date 2014-4-25 上午11:35:27 
 *  
 */
public class Constant {

	/************************************************登录session值****begin****************************************/
	/** 
	* @Fields SESSION_USER : TODO(用户登陆常量) 
	*/
	public static final String SESSION_USER = "LoginUser";
	
	/** 
	* @Fields SESSION_USER_TACHE_CORD : TODO(用户权限code码常量) 
	*/
	public static final String SESSION_USER_TACHE_CORD = "UserTacheCord";
	
	/** 
	* @Fields SESSION_USER_TACHE_NO : TODO(用户权限No号常量) 
	*/
	public static final String SESSION_USER_TACHE_NO = "UserTacheNo";
	
	/** 
	* @Fields SESSION_USER_TACHE_NO : TODO(用户栏目No号常量) 
	*/
	public static final String SESSION_USER_ITEM_NO = "UserItemNos";

	/**
	 * @Fields SESSION_USER : TODO(用户登陆常量)
	 */
	public static final String CLAIMS = "LoginToken";
	
	/** 
	* @Fields SESSION_USER_INFO_MAP : TODO(用户信息常量map) 
	*/
	public static final String SESSION_USER_INFO_MAP = "userInfoMap";
	
	/** 
	* @Fields COOKIE_ID : TODO(COOKIE id) 
	*/
	public static final String COOKIE_ID = "SSM_SYSTEMCOOKIE";
	
	/** 
	* @Fields COOKIE_PWD : TODO(COOKIE 密码) 
	*/
	public static final String COOKIE_PWD = "SSM_SYSTEMCOOKIE";
	
	/** 
	* @Fields PRIZE_CODE : TODO(奖品解锁权限号) 
	*/
	public static final String PRIZE_CODE = "362421192893";
	
	/************************************************登录session值****end********************************************/
	
	/***************************************************文档tableNo begin*******************************************/
	
	/** 
	* @Fields DOC_STUDENT_PHOTO  TODO(新闻图片上传tableNo)
	*/
	public static final String DOC_NEWS_PICTURE = "1";
	/***************************************************文档tableNo end*********************************************/
	
	/** 
	* @Fields DOC_STUDENT_PHOTO  TODO(学员信息头像上传tableNo) 
	*/
	public static final long CLIENT_FOOTBALL_RANKING = 50l;
	public static final double CLIENT_FOOTBALLRET_MULTIPLE = 1.00;

	/***************************************************文档tableNo end*********************************************/
	
	public static final String REGULAR_EXPRESSION_UNICOM= "^((13[0-2])|(145)|(15[5-6])|(176)|(186)|(183)|(185))\\d{8}$";
	
	/** 
	* @Fields TACHE_CODE  TODO(栏目管理-权限管理-权限控制根节点) 
	*/
	public static final Long TACHE_ROOTCODE = 385062145020L;
	

	public static Long TACHE_ARTICLE = 400586680558l;  //推送筛选
	public static Long TACHE_FINISH = 400586703274l;  //内容发布
	public static Long TACHE_EDIT = 400586628339l;  //内容编辑
	public static Long TACHE_CHECK = 400586694628l;  //内容审核
	public static Long TACHE_ADMIN = 400587686835l;  //后台管理
	public static Long LOG_TACHE = 405871786079l;  //c管理员用户权限
	public static Long TACHE_USER = 400604138208l;  //A管理员权限
	public static Long TACHE_TACHE = 404671359479l;  //B管理员权限
	public static String SQL_NAME = "jmrh";  //数据库名
	
}
