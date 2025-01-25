package com.javabean;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000117633162";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCLksx9to+emFapgFvhGDLPEYzsfIiaH5WSY0S2/m9/oL0X90OvNIWNIr29Eo4ymsrQHeoZ5oODqMDd0qzbu+2/vApbeRjdFK+P11gP4uKGKksvx7JBe8xWItJCF0IjLIZkzGSr/CQ6IjoFgNQnQsEIEH96YYyPopM1dFarjMt+KsHSjxr6taN60bhtQ0TZM+nuSAyMF5rXRAxjx4nTawSvprnr6CPKY6SJIhpKUaD/ItwVJxCNJ8kwFZfFw6mtGsbeM5MeA/MjdlP2eGhYPAxhqouctCjgqiTHlo2brAoviKIrgD/l5nQMbRTFcK8w6sjCdPsjQqv8me4fzDFsoqE1AgMBAAECggEAEWFhZ5IxRj2QJSFfz6L0yMZVtyk21YJzXLxR1TvP5KO+iFp5KjsvGkkmOYIzBOgzs0DWYw1KeT2tbrIKZn57d7HR1Fw7FWS7C/1z8N5++NgRbsy+TNs+scc6SZKd4MVtouW075nBZR/X+9F0GcN9SCTNyw6Us1o6XKC1Hj21JWu8Eb4kRk0KfSzQmX9xaOmQtwn4MeB80FHQ8PQyWT8YxTPInuY8cZd4GjRUdDQ3gHk4PLjHOo8ld1PIAJhXmE84TVi91wOXlrPBf8GPy6DWVkrenUduX8e5bYELLBaJJgW7eaZeU4rdtdBkgPuKeDT4xS3Dg8wN0Y4tI0WnuKB9LQKBgQDaF5dNDtu+z1h333+ny4bAhLTN/Axx9uR9b4qMm8HGLlKfUPJSyzYlYxy7KcCQLC1rXo/KaS9griCYQhw48vneMJ93EJAkhmoyzKjzydaZ82gaekDkotH4UIKuN8yPnnMYAT3j4Fpml2y/hBWkNV82qZl7s6B7XFPzoWpUPImoewKBgQCj1V+yba0i/h7i0HPgjDfy1+Cfp1RCKmo/ONZXW3BXPudSo8eBY29RXEZ47UoGW0u+oou7WtKLoDBOVP98gFJjuD4XOrw38Lpwan2g389BNYnXC/0klXxJyagZky+mVwY/Xr50beecIcbjD7qb8f7J5bWtP4cJZWT6+0SAzFamDwKBgQCTg3FrRamMnmKQcjO+IwO6JAjHarxgOUbDMTbddFzU13A7Il1Fcv3ku+0rC0qcOcVe4k8P8aWCF0Ukt1Kvkmk/yFOUDTfx/JjIU3XTr6nf56t6fUZ3X0n2Uz6Q6F0Mp3fhvLVH9PAwhCuiPo0EzLTiHEUcTps11XVTTNLGt0vFEQKBgAeaIgukfTEve31o0MetmfcBv2GJISbE0xNF7uQ00PyrZY53HQ3K8GJlFrwLvrCW0efxoOw7paNm9nbcCNLdHXWVGgR37D3oRK5sspGhcPuEoXXCD6f/67l8yvkM1Fwyk46jNdEvPF0JUDI/C5iq3Pi/WPPGC90KwGnI+P/E+4xPAoGBAIKNJ2J1KaOw+4GyypuQLYhGhYjSJNojG4Ggil0e734OXyAmXAzGxbv35At3lmODlY3Fqx6RNFDpAhO6eI1zLjS0U90Z2Un5sdVCoYMaGM33CTFkJ6WcM3jQJ+EgN71hNPTOSb+R5o3wlaZnQxh2q/GRGQPxJfkckNQo4UIoKl5w";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq93XVc5J1f1qf70TOkwl6lNpCPmefg5JodjfH4/Y6Y16xxEmf3OxQC4LHn7Qu1MKB541K0sfJ2RkpegEWAL1vN/QZ24YgEnf5+WLxNior2m8eaKrHFMikoPDPWb7zDWl3rySIpUeMMebl0qFuHtm0srmTLoCqqOhk/fFdiB8Q5TJfRq7U99rAYLuTrsZ3apI3QBEib4Cr9cMKIIrpg00+k3WOHPaL3Qz/CroRqc38hOViDOVdIDaCnwfVAbAr4LRosvrl3z22hUq4lFhI1PItGL96+Sa6a2lT+kXvrBRQOP2RfyUbnQ1s6PwLeBh299MOqhkf41IkrraYq9RQMgdtQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1:52577/ssm_leaseOfHouses/alipaymvc/returnUrl.do";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:/cnqf";

	//房屋rcid
	public static String rcid=null;
	
	//用户call
	public static String usercall=null;

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

