package constants;

public class SqlConstants {
	public static final String ALL_FIELDS = "U_ID, U_NAME, U_PWD, REG_TS";
	public static final String INS_FIELDS = "U_NAME, U_PWD, REG_TS";
	public static final String INS_FIELDS_BLANK = "?, ?, ?";
	
	public static final String USER_SEL_BY_NAME = "SELECT " + ALL_FIELDS + " FROM TBL_USR WHERE U_NAME = ?";
	public static final String USER_INS_USER = "INSERT INTO TBL_USR (" + INS_FIELDS + ") VALUES (" + INS_FIELDS_BLANK +")";
}
