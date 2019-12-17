
package bvp.his.isofhcare.utils;

import bvp.his.isofhcare.model.EmptyEntity;

public class CustomException extends Exception {

    public CustomException(Exception ex) {
        super(ex);
    }

    public CustomException(int code, Exception ex) {
        super(ex);
        this.code = code;
    }

    public CustomException(int code, String message) {
        super(new Exception(message));
        this.code = code;
    }

    public CustomException(String message) {
        super(new Exception(message));
        this.code = 500;
    }

    public CustomException(int code, String message, Object data) {
        super(new Exception(message));
        this.code = code;
        this.data = data;
    }

    private Integer code;
    private Object data = new EmptyEntity();

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
