package com.mustpay.util;

import java.util.Map;

import com.mustpay.config.MustpayConfig;
import com.mustpay.sign.RSA;

/* *
 *类名：MustpayNotify
 *功能：MustPay通知处理类
 *详细：处理MustPay各接口通知返回
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究MustPay接口使用，只是提供一个参考

 */
public class MustpayNotify {
	/**
     * 验证消息是否是MustPay发出的合法消息
     * @param params 通知返回来的参数数组
     * @param publicKey 
     * @return 验证结果
     */
    public static boolean verify(Map<String, Object> params) {

        //判断isSign是否为true
        //isSign不是true，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
	    String sign = "";
	    if(params.get("sign") != null) {sign = (String)params.get("sign");}
	    boolean isSign = getSignVeryfy(params, sign, MustpayConfig.PLATE_PUBLIC_KEY);

	    if (isSign) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据反馈回来的信息，生成签名结果
     * @param Params 通知返回来的参数数组
     * @param sign 比对的签名结果
     * @return 生成的签名结果
     */
	private static boolean getSignVeryfy(Map<String, Object> Params, String sign, String publicKey) {
    	//过滤空值、sign与sign_type参数
    	Map<String, String> sParaNew = MustpayCore.paraFilter(Params);
        //获取待签名字符串
        String preSignStr = MustpayCore.createLinkString(sParaNew);
        //获得签名验证结果
        boolean isSign = false;
        if(MustpayConfig.SIGN_TYPE.equals("RSA")){
        	isSign = RSA.verify(preSignStr, sign, publicKey, MustpayConfig.INPUT_CHARSET);
        }
        return isSign;
    }

}
