package daidai.lexin.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;


/**
 * ���Ź�����
 * Created by LV on 2016/4/15 0015.
 * Email:LvLoveYuForever@gmail.com
 */
public class MobileMessageSend {
	
	//��֤��ȴ���������ڴ洢��ȴ״̬���ֻ���
	private static HashMap<String, Date> readys = new HashMap<String,Date>();
	private static final int SEND_READY_TIME = 5999; //��ȴʱ�� 1s = 1000
	
	/***
	 * �ж��ֻ����Ƿ�����ȴ״̬
	 * @param phone
	 * @return
	 */
	private static boolean exitsReady(String phone) {
		boolean isExits = false;
		if (readys.get(phone)!=null) {
			if( !isOutTimeReady(phone) ) {
				isExits = true;
			}
		}
		return isExits;
	}
	
	/***
	 * �ж��ֻ����Ƿ���ȴ���
	 * @param phone
	 * @return
	 */
	private static boolean isOutTimeReady(String phone) {
		boolean is = false;
		if( Math.abs(readys.get(phone).getTime()-new Date().getTime())>SEND_READY_TIME ) {
			readys.remove(phone);
			is = true;
		}
		return is;
	}
	
	/***
	 * �����ȴ������������ȴ��ɵ��ֻ���
	 */
	private static void clearReadys() {
		for(String phone : readys.keySet()){
			isOutTimeReady(phone);
		}
	}
	
	/*
	 * POST https://api.netease.im/sms/sendcode.action HTTP/1.1
		Content-Type:application/x-www-form-urlencoded;charset=utf-8
	 * */
    private static final String SERVER_URL="https://api.netease.im/sms/sendcode.action";//������֤�������URL
    private static final String VERIFYCODE_URL = "https://api.netease.im/sms/verifycode.action";//��֤��֤������URL
    private static final String APP_KEY="2748926c67176556cf043ae9422481e6";//�˺�
    private static final String APP_SECRET="9642042f6cf9";//����
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=utf-8";
    private static final String VERSION = "HTTP/1.1";
    private static final String MOULD_ID="3064171";//ģ��ID
    private static final String NONCE="123456";
    
    
    /***
     * �ж���֤���Ƿ���ȷ
     * @param phone
     * @param code
     * @return
     * @throws IOException
     */
    public static int verifycode(String phone,String code) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(VERIFYCODE_URL);
        
        String curTime=String.valueOf((new Date().getTime()/1000L));
        String checkSum=CheckSumBuilder.getCheckSum(APP_SECRET,NONCE,curTime);
        
        //���������header
        post.addHeader("AppKey",APP_KEY);
        post.addHeader("Nonce",NONCE);
        post.addHeader("CurTime",curTime);
        post.addHeader("CheckSum",checkSum);
        post.addHeader("Content-Type",CONTENT_TYPE);
        post.addHeader("version", VERSION);
        
        //�����������
        List<NameValuePair> nameValuePairs =new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("mobile",phone));
        nameValuePairs.add(new BasicNameValuePair("code",code));

        post.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));
        
        //ִ������
        HttpResponse response=httpclient.execute(post);

        String responseEntity= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(responseEntity);
        //�ж��Ƿ��ͳɹ������ͳɹ�����true
        String c= JSON.parseObject(responseEntity).getString("code");
        if (c.equals("200"))
            {return 0;}

        httpclient.close();
        
        return 500;
    }
    
    /***
     * ����ȴʱ��ķ�����֤��
     * @param phone
     * @return
     * @throws IOException
     */
    public static int haveReadySendMsg(String phone) throws IOException {
    	int state = 500;
    	clearReadys();
    	if (!exitsReady(phone)) {
    		state = sendMsg(phone); 
    		if (0==state) {
    			readys.put(phone, new Date());    			
    		}
    	} else {
    		state = 999;
    	}
    	return state;
    }
    
    /***
     * ������֤��
     * @param phone
     * @return
     * @throws IOException
     */
    public static int sendMsg(String phone) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(SERVER_URL);

        String curTime=String.valueOf((new Date().getTime()/1000L));
        String checkSum=CheckSumBuilder.getCheckSum(APP_SECRET,NONCE,curTime);

        //���������header
        post.addHeader("AppKey",APP_KEY);
        post.addHeader("Nonce",NONCE);
        post.addHeader("CurTime",curTime);
        post.addHeader("CheckSum",checkSum);
        post.addHeader("Content-Type",CONTENT_TYPE);
        post.addHeader("version", VERSION);

        //�����������
        List<NameValuePair> nameValuePairs =new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("templateid",MOULD_ID));
        nameValuePairs.add(new BasicNameValuePair("mobile",phone));

        post.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));

        //ִ������
        HttpResponse response=httpclient.execute(post);

        String responseEntity= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(responseEntity);
        //�ж��Ƿ��ͳɹ������ͳɹ�����true
        String code= JSON.parseObject(responseEntity).getString("code");
        if (code.equals("200"))
            {return 0;}

        httpclient.close();
        
        return 500;
    }
}



/***
 * CheckSum����
 * @author Lexin
 *
 */
class CheckSumBuilder {
    // ���㲢��ȡCheckSum
    public static String getCheckSum(String appSecret, String nonce, String curTime) {
        return encode("sha1", appSecret + nonce + curTime);
    }

    // ���㲢��ȡmd5ֵ
    public static String getMD5(String requestBody) {
        return encode("md5", requestBody);
    }

    private static String encode(String algorithm, String value) {
        if (value == null) {
            return null;
        }
        try {
            MessageDigest messageDigest
                    = MessageDigest.getInstance(algorithm);
            messageDigest.update(value.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
}
