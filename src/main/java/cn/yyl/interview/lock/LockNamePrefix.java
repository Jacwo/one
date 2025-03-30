package cn.yyl.interview.lock;

public enum LockNamePrefix {
	
	LOCK_ORDER_UPDATE_STATE("LOCK_ORDER_UPDATE_STATE","订单更新状态锁"),
	LOCK_ORDER_CANCEL_ALL("LOCK_ORDER_CANCEL_ALL","订单取消全部锁定"),
	LOCK_ORDER("LOCK_ORDER","订单锁"),
	LOCK_UNLOCK_QUANTTIY("LOCK_UNLOCK_QUANTITY","库存写锁")
	;

	private final String code;

    private final String message;

    private LockNamePrefix(String code, String message) {
		this.code = code;
		this.message = message;
    }

    public String getMessage() {
    	return message;
    }

    public String getCode() {
    	return code;
    }

    @Override
	public String toString() {
    	return String.format("%s: %s", this.code, this.message);
    }
}
