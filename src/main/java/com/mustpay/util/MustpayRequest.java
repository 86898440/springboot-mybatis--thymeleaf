package com.mustpay.util;

import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.alibaba.fastjson.JSONObject;
import com.mustpay.config.MustpayConfig;

/* *
 *类名：MustpayRequest
 *功能：MustPay请求函数类
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究MustPay接口使用，只是提供一个参考。
 */

public class MustpayRequest {

	/**
     * 请求MustPay预支付ID
     * @param sPara 要签名的数组
     * @return 签名结果字符串
     */
	public static String requestPrepayId(Map<String, String> sParaTemp) {
        String prepayId = "";
        try{
			// 发送http请求
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod(MustpayConfig.ADD_ORDER_URL);
			post.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded;charset=utf-8");
			
			NameValuePair apps_id = new NameValuePair("apps_id", sParaTemp.get("apps_id"));
			NameValuePair out_trade_no = new NameValuePair("out_trade_no", sParaTemp.get("out_trade_no"));
			NameValuePair mer_id = new NameValuePair("mer_id", sParaTemp.get("mer_id"));
			NameValuePair total_fee = new NameValuePair("total_fee", sParaTemp.get("total_fee"));
			NameValuePair subject = new NameValuePair("subject", sParaTemp.get("subject"));
			NameValuePair body = new NameValuePair("body", sParaTemp.get("body"));
			NameValuePair notify_url = new NameValuePair("notify_url", sParaTemp.get("notify_url"));
			NameValuePair return_url = new NameValuePair("return_url", sParaTemp.get("return_url"));
			NameValuePair show_url = new NameValuePair("show_url", sParaTemp.get("show_url"));
			NameValuePair user_id = new NameValuePair("user_id", sParaTemp.get("user_id"));
			NameValuePair extra = new NameValuePair("extra", sParaTemp.get("extra"));
			NameValuePair sign = new NameValuePair("sign", sParaTemp.get("sign"));
			NameValuePair sign_type = new NameValuePair("sign_type", sParaTemp.get("sign_type"));
			post.setRequestBody(new NameValuePair[] { apps_id, out_trade_no, mer_id, total_fee, subject, body, notify_url, return_url, show_url, user_id, extra, sign, sign_type});
			int responseCode = client.executeMethod(post);
			String responseBody = post.getResponseBodyAsString();
			
			
			if(responseCode == 200){
				if(responseBody != null && responseBody.startsWith("{")){
					JSONObject responseJson = JSONObject.parseObject(responseBody);
					if(responseJson.getString("status").equals("1")){
						//获取成功
						prepayId = responseJson.getJSONObject("info").getString("prepay_id");
					}else{
						//获取失败打印错误信息
						System.out.println("-----------------------------------"+responseJson.getString("msg"));
					}
				}
			}
		} catch (Exception e) {
	        e.printStackTrace();
	    }
        return prepayId;
    }

}
