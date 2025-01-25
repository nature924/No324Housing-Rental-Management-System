package com.javabean;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *������AlipayConfig
 *���ܣ�����������
 *��ϸ�������ʻ��й���Ϣ������·��
 *�޸����ڣ�2017-04-05
 *˵����
 *���´���ֻ��Ϊ�˷����̻����Զ��ṩ���������룬�̻����Ը����Լ���վ����Ҫ�����ռ����ĵ���д,����һ��Ҫʹ�øô��롣
 *�ô������ѧϰ���о�֧�����ӿ�ʹ�ã�ֻ���ṩһ���ο���
 */

public class AlipayConfig {
	
//�����������������������������������Ļ�����Ϣ������������������������������

	// Ӧ��ID,����APPID���տ��˺ż�������APPID��Ӧ֧�����˺�
	public static String app_id = "2021000117633162";
	
	// �̻�˽Կ������PKCS8��ʽRSA2˽Կ
	public static String merchant_private_key="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCLksx9to+emFapgFvhGDLPEYzsfIiaH5WSY0S2/m9/oL0X90OvNIWNIr29Eo4ymsrQHeoZ5oODqMDd0qzbu+2/vApbeRjdFK+P11gP4uKGKksvx7JBe8xWItJCF0IjLIZkzGSr/CQ6IjoFgNQnQsEIEH96YYyPopM1dFarjMt+KsHSjxr6taN60bhtQ0TZM+nuSAyMF5rXRAxjx4nTawSvprnr6CPKY6SJIhpKUaD/ItwVJxCNJ8kwFZfFw6mtGsbeM5MeA/MjdlP2eGhYPAxhqouctCjgqiTHlo2brAoviKIrgD/l5nQMbRTFcK8w6sjCdPsjQqv8me4fzDFsoqE1AgMBAAECggEAEWFhZ5IxRj2QJSFfz6L0yMZVtyk21YJzXLxR1TvP5KO+iFp5KjsvGkkmOYIzBOgzs0DWYw1KeT2tbrIKZn57d7HR1Fw7FWS7C/1z8N5++NgRbsy+TNs+scc6SZKd4MVtouW075nBZR/X+9F0GcN9SCTNyw6Us1o6XKC1Hj21JWu8Eb4kRk0KfSzQmX9xaOmQtwn4MeB80FHQ8PQyWT8YxTPInuY8cZd4GjRUdDQ3gHk4PLjHOo8ld1PIAJhXmE84TVi91wOXlrPBf8GPy6DWVkrenUduX8e5bYELLBaJJgW7eaZeU4rdtdBkgPuKeDT4xS3Dg8wN0Y4tI0WnuKB9LQKBgQDaF5dNDtu+z1h333+ny4bAhLTN/Axx9uR9b4qMm8HGLlKfUPJSyzYlYxy7KcCQLC1rXo/KaS9griCYQhw48vneMJ93EJAkhmoyzKjzydaZ82gaekDkotH4UIKuN8yPnnMYAT3j4Fpml2y/hBWkNV82qZl7s6B7XFPzoWpUPImoewKBgQCj1V+yba0i/h7i0HPgjDfy1+Cfp1RCKmo/ONZXW3BXPudSo8eBY29RXEZ47UoGW0u+oou7WtKLoDBOVP98gFJjuD4XOrw38Lpwan2g389BNYnXC/0klXxJyagZky+mVwY/Xr50beecIcbjD7qb8f7J5bWtP4cJZWT6+0SAzFamDwKBgQCTg3FrRamMnmKQcjO+IwO6JAjHarxgOUbDMTbddFzU13A7Il1Fcv3ku+0rC0qcOcVe4k8P8aWCF0Ukt1Kvkmk/yFOUDTfx/JjIU3XTr6nf56t6fUZ3X0n2Uz6Q6F0Mp3fhvLVH9PAwhCuiPo0EzLTiHEUcTps11XVTTNLGt0vFEQKBgAeaIgukfTEve31o0MetmfcBv2GJISbE0xNF7uQ00PyrZY53HQ3K8GJlFrwLvrCW0efxoOw7paNm9nbcCNLdHXWVGgR37D3oRK5sspGhcPuEoXXCD6f/67l8yvkM1Fwyk46jNdEvPF0JUDI/C5iq3Pi/WPPGC90KwGnI+P/E+4xPAoGBAIKNJ2J1KaOw+4GyypuQLYhGhYjSJNojG4Ggil0e734OXyAmXAzGxbv35At3lmODlY3Fqx6RNFDpAhO6eI1zLjS0U90Z2Un5sdVCoYMaGM33CTFkJ6WcM3jQJ+EgN71hNPTOSb+R5o3wlaZnQxh2q/GRGQPxJfkckNQo4UIoKl5w";
	
	// ֧������Կ,�鿴��ַ��https://openhome.alipay.com/platform/keyManage.htm ��ӦAPPID�µ�֧������Կ��
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq93XVc5J1f1qf70TOkwl6lNpCPmefg5JodjfH4/Y6Y16xxEmf3OxQC4LHn7Qu1MKB541K0sfJ2RkpegEWAL1vN/QZ24YgEnf5+WLxNior2m8eaKrHFMikoPDPWb7zDWl3rySIpUeMMebl0qFuHtm0srmTLoCqqOhk/fFdiB8Q5TJfRq7U99rAYLuTrsZ3apI3QBEib4Cr9cMKIIrpg00+k3WOHPaL3Qz/CroRqc38hOViDOVdIDaCnwfVAbAr4LRosvrl3z22hUq4lFhI1PItGL96+Sa6a2lT+kXvrBRQOP2RfyUbnQ1s6PwLeBh299MOqhkf41IkrraYq9RQMgdtQIDAQAB";

	// �������첽֪ͨҳ��·��  ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	public static String notify_url = "http://���̹������ʵ�ַ/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// ҳ����תͬ��֪ͨҳ��·�� ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	public static String return_url = "http://127.0.0.1:52577/ssm_leaseOfHouses/alipaymvc/returnUrl.do";

	// ǩ����ʽ
	public static String sign_type = "RSA2";
	
	// �ַ������ʽ
	public static String charset = "utf-8";
	
	// ֧��������
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// ֧��������
	public static String log_path = "C:/cnqf";

	//����rcid
	public static String rcid=null;
	
	//�û�call
	public static String usercall=null;

//�����������������������������������Ļ�����Ϣ������������������������������

    /** 
     * д��־��������ԣ�����վ����Ҳ���ԸĳɰѼ�¼�������ݿ⣩
     * @param sWord Ҫд����־����ı�����
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

