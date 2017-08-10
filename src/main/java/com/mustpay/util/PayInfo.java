package com.mustpay.util;

import com.mustpay.config.MustpayConfig;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cx on 17-8-10.
 */
public class PayInfo {
    //out_trade_no 商户订单号，商户网站订单系统中唯一订单号，必填
    //subject 商品名称，必填
    //String total_fee付款金额，必填（单位：分）
    //用户id  phone代替
    public static String pay(String out_trade_no,String subject,String total_fee,String phone){
        //把请求参数打包成数组并签名
        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("apps_id", MustpayConfig.APPS_ID);
        sParaTemp.put("out_trade_no", out_trade_no);
        sParaTemp.put("mer_id", MustpayConfig.MER_ID);
        sParaTemp.put("total_fee", String.valueOf(new BigDecimal(total_fee).multiply(new BigDecimal(100)).intValue()));//将元转换为分
        sParaTemp.put("subject", subject);
        //	sParaTemp.put("body", body);
        sParaTemp.put("notify_url", MustpayConfig.NOTIFY_URL);
        sParaTemp.put("return_url", MustpayConfig.RETURN_URL);
        //	sParaTemp.put("show_url", show_url);
        sParaTemp.put("user_id", phone);//用户在商户平台的唯一标示
        sParaTemp.put("extra", "success");//扩展字段，在异步通知时会原样返回给商户

        //将请求参数进行RSA签名
        sParaTemp = MustpayCore.buildRequestPara(sParaTemp);

        //请求MustPay获取预支付ID
        String prepayId = MustpayRequest.requestPrepayId(sParaTemp);
        return prepayId;

    }
}
