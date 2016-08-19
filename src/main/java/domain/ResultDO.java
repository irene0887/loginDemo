package domain;

public class ResultDO<T> {
	private boolean success = false;
	
	private String respCode;
	private String respDesc;
	
	private T result = null;
	
	public ResultDO(){
		
	}
	
	public ResultDO(boolean success, String respCode, String respDesc){
		this.success = success;
		this.setRespCode(respCode);
		this.setRespDesc(respDesc);
	}
	
	public boolean isFailure() {
		return !success;
	}
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
