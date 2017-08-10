package com.mustpay.config;

/* *
 *类名：MustpayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究MustPay接口使用，只是提供一个参考。
 */

public class MustpayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	//MustPay平台公钥
	public static final String PLATE_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDO7CQpYHhEonv1g9YjRVGJDaCOu0bXogD7pBLQu2dDvJ8TGROCEw6ArIWgAWEEE1uEShPBa4MpCP4ZMjT5RMj45o0pb0Z8s4k6CpS9D1LFK9msNpsN8PyaRDQC86R6jxAVQMWgfIZ9cxfZR8Ple3GJGjwBfeRnzh75rE1DHCBOcwIDAQAB";

	//商户私钥
	public static final String MER_PRIVATE_KEY ="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOEoPUJSOc4ZG4XM" +
			"L1eN07cElpaqZ/1wvUYhJwoPA4Zv6jfGtiEDpHLFPPsnJQZ55qTfrGb/pqOXV8Nr" +
			"InzIMQRb/oo08nEH9beGamRlJ86nzTpjSSZ5lDMiCkS4rInsQglc0QOjVVV8LnwB" +
			"2SLkhSNBVFyp21DkuTC8PGcZ0OjHAgMBAAECgYBNIc7SkH6S9xDxpgA12zVDBkRc" +
			"OuZC8UM16heIn5oSjPZMwzsTVj8Yvi7kzwUlEc+Mfb9+zWeVtTvwixwWaTI46mZ2" +
			"Ryo3pvnufr/XTU2ohb0u/FN9cn/x93GgIHWbZklZtj1PwAB+W3Htg3ISopT0tQ34" +
			"lnSY4lUvt3EYbfagGQJBAPwWS5OGjunTW955o80ewYWeQYmnPuVpu8FkQ+yRtkj3" +
			"JgKfVjk9GEgu3Dlc4qMlN77QBs8npN1YHH56D2jwOMsCQQDkpu8lr6DV50aWbwBd" +
			"9lpeyq2HswLXsArmashpEJPOqNWPUYw9nD41DkP85X8E7yIplIrk9ksnLieJ6G3B" +
			"Glx1AkEA1kS5Hn8cEIHXr6Vi5mHDCij2+eMPYf5aWco4tecwsppoU4hNyL82WXyD" +
			"MbrS5Osok+bMMt42kvFm3tYvLPoquwJBAKRnazh7qXdjzZtIwMjO43eY32Dc08Rl" +
			"7dBzIxp4Mu668qMUDXQXLZtUYIosMUJI9xVSmvO6K5tGUmOUXaYk4CkCQDibC4fr" +
			"bVeBv0L4r591qJ9uRbKor+dG1nFDEwC6Kat3et0vKOyKZ0IHEBYG32VONU9z/bMU" +
			"S7E9/Uw4aVaeOWQ=";
			//测试商户apps_id
	public static final String APPS_ID = "1a8a2532aa974b8ab05473f4e1aeb027";
	
	//测试商户mer_id
	public static final String MER_ID = "17062018013877669";
	
	//异步回调URL 此地址必须外网可访问
	public static final String NOTIFY_URL = "http://xxx/testpay/MustPay-JAVA-UTF-8/notify_url.jsp";
	
	//同步回调URL 此地址必须外网可访问
	public static final String RETURN_URL = "http://xxx/testpay/MustPay-JAVA-UTF-8/return_url.jsp";
	
	// 签名方式
	public static final String SIGN_TYPE = "RSA";
		
	// 字符编码格式 目前支持utf-8
	public static final String INPUT_CHARSET = "utf-8";
	
	//下单地址
	public static final String ADD_ORDER_URL = "https://www.mustpay.com.cn/service/order/saveOrder";
	
	//订单查询地址
	public static final String QUERY_ORDER_URL = "https://www.mustpay.com.cn/service/order/queryOrder";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

}

