package daidai.lexin.function;

public class Constant {
	protected final static String REGISTER_PHONENUMBER_MATCHES = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9]))\\d{8}$";
	protected final static String REGISTER_PASSWORD_MATCHES = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
	
	protected final static String VINFORMATION_VALUE_MATCHES = "\\d{1,32}";
	protected final static String VINFORMATION_SPECIALTY_MATCHES = "[0-9a-zA-Z\u4e00-\u9fa5-]{1,100}";
	protected final static String VINFORMATION_GOOD_MATCHES = "\\d{1,32}";
	
	protected final static String BINFORMATION_PHOTO_MATCHES = "[0-9a-zA-Z\\\\/:]{1,46}(\\.jpg)$";
	protected final static String BINFORMATION_SEX_MATCHES = "[012]{1}";
	protected final static String BINFORMATION_NAME_MATCHES = "[0-9a-zA-Z\u4e00-\u9fa5]{1,16}";
	protected final static String BINFORMATION_ADDRESS_MATCHES = "[0-9a-zA-Z\u4e00-\u9fa5-&; ]{1,128}";
	protected final static String BINFORMATION_INTRODUCTION_MATCHES = "[0-9a-zA-Z\u4e00-\u9fa5-&; ]{1,192}";
	
	protected final static String DINFORMATION_EDUCATION_MATCHES = "[\u4e00-\u9fa5]{2,8}";
	protected final static String DINFORMATION_SCHOOL_MATCHES = "[0-9a-zA-Z\u4e00-\u9fa5-]{1,64}";
	protected final static String DINFORMATION_JOB_MATCHES = "[0-9a-zA-Z\u4e00-\u9fa5-]{1,16}";
	protected final static String DINFORMATION_COMPANY_MATCHES = "[0-9a-zA-Z\u4e00-\u9fa5-]{1,64}";
	
	protected final static String Login_IP = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.((1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.){2}(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)";
	protected final static String Login_ADDRESS = "[0-9a-zA-Z\u4e00-\u9fa5-&; ]{1,128}";
	
	protected final static String OPERATION_MES = "[0-9a-zA-Z\u4e00-\u9fa5-&; ]{1,128}";
	protected final static String OPERATION_RESULT = "[A-Z]{1,8}";
	
	protected final static String BLACKBOX_RESON = "[0-9a-zA-Z\u4e00-\u9fa5-&; ]{1,128}";
	
	
	protected static final String MAPPERPATH = "daidai.lexin.models.xml";
	
	protected static final String mapper(String className,String functionName) {
		return Constant.MAPPERPATH+"."+className+"."+functionName;
	}
	
}
