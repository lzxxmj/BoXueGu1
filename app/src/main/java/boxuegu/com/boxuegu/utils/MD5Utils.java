package boxuegu.com.boxuegu.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    public static String md5(String text){

        //初始化
        try {
            MessageDigest md=MessageDigest.getInstance("md5");
            md.update(text.getBytes());
            byte[] result=md.digest();
            StringBuilder sb=new StringBuilder();
            for(byte b:result){
                int number=b&0xff;
                String hex=Integer.toHexString(number);
                if(hex.length()==1){
                    sb.append("0"+hex);
                }else{
                    sb.append(hex);
                }
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

    }
}
