package com.wyy.zsj.conversion;
/** 
* @author  hjw
* @date 创建时间：2018年4月8日 上午11:22:11
* @Function: Convert.java
* @version 1.0 
* @Description: string <--> byte[]
* @parameter  
* @return  
*/
public class Convert {
	 private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5',
	            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	    //byte[]转换成16进制字符串
	    public static String bytesToHexFun1(byte[] bytes  ) {
	        // 一个byte为8位，可用两个十六进制位标识
	        char[] buf = new char[bytes.length * 2];
	        int a = 0;
	        int index = 0;
	        for(byte b : bytes) { // 使用除与取余进行转换
	            if(b < 0) {
	                a = 256 + b;
	            } else {
	                a = b;
	            }

	            buf[index++] = HEX_CHAR[a / 16];
	            buf[index++] = HEX_CHAR[a % 16];
	        }

	        return new String(buf);
	    }


	    /**
	     * 字节数组转成16进制表示格式的字符串
	     *
	     * @param byteArray 需要转换的字节数组
	     * @return 16进制表示格式的字符串
	     **/
	    public static String bytesToHexString(byte[] byteArray) {
	        if (byteArray == null || byteArray.length < 1) {
	            throw new IllegalArgumentException("this byteArray must not be null or empty");
	        }

	        final StringBuilder hexString = new StringBuilder();
	        for (int i = 0; i < byteArray.length; i++) {
	            hexString.append(" ");
	            // 0~F前面补零
	            if ((byteArray[i] & 0xff) < 0x10) {
	                hexString.append("0");
	            }
//		        System.out.println(0xFF & byteArray[i]);
	            hexString.append(Integer.toHexString(0xFF & byteArray[i]));
	        }
	        return hexString.toString().substring(1).toLowerCase();
	    }

	    /**
	     * 字符串转化成为16进制字符串
	     * @param s
	     * @return
	     */
	    public static String strTo16(String s) {
	        String str = "";
	        for (int i = 0; i < s.length(); i++) {
	            int ch = (int) s.charAt(i);
	            String s4 = Integer.toHexString(ch);
	            str = str + s4;
	        }
	        return str;
	    }
	    /**
	     * 16进制直接转换成为字符串(无需Unicode解码)
	     * @param hexStr
	     * @return
	     */
	    public static String hexStr2Str(String hexStr) {
	        String str = "0123456789ABCDEF";
	        char[] hexs = hexStr.toCharArray();
	        byte[] bytes = new byte[hexStr.length() / 2];
	        int n;
	        for (int i = 0; i < bytes.length; i++) {
	            n = str.indexOf(hexs[2 * i]) * 16;
	            n += str.indexOf(hexs[2 * i + 1]);
	            bytes[i] = (byte) (n & 0xff);
	        }
	        return new String(bytes);
	    }
	    /*
	     * 16进制数字字符集
	     */
	    private static String hexString = "0123456789ABCDEF";
	    /*
	     * 将字符串编码成16进制数字,适用于所有字符（包括中文）
	     */
	    public static String encode(String str) {
	        // 根据默认编码获取字节数组
	        byte[] bytes = str.getBytes();
	        StringBuilder sb = new StringBuilder(bytes.length * 2);
	        // 将字节数组中每个字节拆解成2位16进制整数
	        for (int i = 0; i < bytes.length; i++) {
	            sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
	            sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
	        }
	        return sb.toString();
	    }


	    /**
	     * 将16进制字符串转换为byte[]
	     *
	     * @param str
	     * @return
	     */
	    public static byte[] hexStringToByte(String str) {
	        str = str.replaceAll("-", "");
	        if(str == null || str.trim().equals("")) {
	            return new byte[0];
	        }

	        byte[] bytes = new byte[str.length() / 2];
	        for(int i = 0; i < str.length() / 2; i++) {
	            String subStr = str.substring(i * 2, i * 2 + 2);
	            bytes[i] = (byte) Integer.parseInt(subStr, 16);
	        }

	        return bytes;
	    }
}
