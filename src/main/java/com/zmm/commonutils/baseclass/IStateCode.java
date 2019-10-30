package com.zmm.commonutils.baseclass;

/**
 * 接口请求返回编码
 * 
 * @author 李小林
 *
 */
public interface IStateCode {

	/********************** HTTP 状态码 begin ************************/
	/**
	 * OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
	 */
	final static String HTTP_200 = "200";

	/**
	 * 201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
	 */
	final static String HTTP_201 = "201";

	/**
	 * 202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
	 */
	final static String HTTP_202 = "201";

	/**
	 * 204 NO CONTENT - [DELETE]：用户删除数据成功。
	 */
	final static String HTTP_204 = "204";

	/**
	 * 400 INVALID REQUEST -
	 * [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
	 */
	final static String HTTP_400 = "400";

	/**
	 * 401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
	 */
	final static String HTTP_401 = "401";

	/**
	 * 403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
	 */
	final static String HTTP_403 = "403";

	/**
	 * 404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
	 */
	final static String HTTP_404 = "404";

	/**
	 * 406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
	 */
	final static String HTTP_406 = "406";

	/**
	 * 410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
	 */
	final static String HTTP_410 = "410";

	/**
	 * 422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
	 */
	final static String HTTP_422 = "422";

	/**
	 * 500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。
	 */
	final static String HTTP_450 = "450";

	/**
	 * 500 INTERNAL SERVER ERROR
	 */
	final static String HTTP_500 = "500";

	/********************** HTTP 状态码 end ************************/

	/**
	 * 10000 - 参数为空
	 */
	final static String PARAMETER_IS_EMPTY = "10000";

	/**
	 * 10001 - 参数非法
	 */
	final static String PARAMETER_IS_INVALID = "10001";

	/**
	 * 10002 - 参数超长
	 */
	final static String PARAMETER_IS_OVERLENGTH = "10002";

	/**
	 * 10003 - 系统未知错误
	 */
	final static String SYSTEM_ERORR = "10003";

	/**
	 * 10004 SQL语句报错
	 */
	final static String SQL_ERORR = "10004";

	/**
	 * 10004 参数重复
	 */
	final static String PARAMETER_IS_DUPLICATE = "10005";

	/**
	 * 10006 密码加解密失败
	 */
	final static String PASSWD_OPERATE_ERROR = "10006";

	/**
	 * 10007 批量保存部分成功
	 */
	final static String BATCH_SAVE_PARTS_SUCCESS = "10007";

	/**
	 * 该学生已经存在此家长了，无需重复添加
	 */
	final static String PARENT_STUDENT_SAVE_DUPLICATE_ADD = "10008";
	
	
	/**
	 * 10009 -ES查询错误
	 */
	final static String ES_QUERY_ERORR = "10009";
	
	/**
	 * 10010 -OPENOFFICE连接失败
	 */
	final static String ERROR_FORMAT_NOT_CONNECTED = "10010";
	
	/**
	 * 10011 -文件转换异常
	 */
	final static String ERROR_FORMAT = "10011";

	/**
	 * 批量删除失败``
	 */
	final static String BATCH_DELETE_ERROR = "10012";

	/**
	 * 用户名密码错误``
	 */
	final static String USER_PWD_ERROR = "10013";

	/**
	 * 登录失败``
	 */
	final static String LOGIN_FAIL = "10014";

	/**
	 * 已登录``
	 */
	final static String LOGIN_AREADY = "10015";


	/**
	 * 未登录状态
	 */
	final static String NOT_LOGGED_IN = "10019";

	/**
	 * 微信账号已绑定
	 */
	final static String OPEN_ID_ALREADY_BIND = "10016";

	/**
	 * 账号已经绑定微信登录
	 */
	final static String USER_ALREADY_BIND_WECHAT = "10019";

	/**
	 * 学生已毕业
	 */
	final static String USER_IS_GRADUATE="10020";

	//您不是园区工作人员，无访问权限!
	String YUNBABY_NO_RIGHT = "10017";

	//您的幼儿园信息未配置，请联系客服处理！
	String YUNBABY_INFO_NOT_CONFIG = "10018";


}