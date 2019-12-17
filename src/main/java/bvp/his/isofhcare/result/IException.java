package bvp.his.isofhcare.result;

import bvp.his.isofhcare.utils.CustomException;


public interface IException {
    default CustomException getException(String message, Object... objects) {
        return new CustomException(String.format(message, objects));
    }

    /**
     * Tra ve loi voi cac thong so
     *
     * @param code    ma loi
     * @param message Noi dung loi
     */
    default CustomException getException(int code, String message, Object... objects) {
        return new CustomException(code, String.format(message, objects));
    }
}
