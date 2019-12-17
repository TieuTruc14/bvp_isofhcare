package bvp.his.isofhcare.result;

import bvp.his.isofhcare.model.EmptyEntity;
import bvp.his.isofhcare.model.ResultEntity;
import bvp.his.isofhcare.utils.CustomException;
import bvp.his.isofhcare.utils.LogUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;

public interface IResultError extends IResponse {
    /**
     * Create response when exception
     */
    default ResultEntity error(Exception ex) {
        String message;
        int code;
        Object data = new EmptyEntity();
        if (ex instanceof CustomException) {
            CustomException customException = (CustomException) ex;
            message = ex.getMessage();
            code = customException.getCode();
            data = customException.getData();
        } else {
            code = 500;
            message = "Internal Server Error " + ex.getMessage();
        }
        LogUtils.getInstance().error(message);
        return error(code, message, data);
    }

    default ResultEntity error(int code, String message, Object data) {
        return new ResultEntity(code, message, data);
    }

    default ResponseEntity responseError(Exception ex) {
        return response(error(ex));
    }

    default ResultEntity errorIsofhcare(String message) {
        int code;
        Object data = new EmptyEntity();
        code = 1;
        if(StringUtils.isBlank(message)){
            message = "No Data";
        }
        LogUtils.getInstance().error(message);
        return error(code, message, data);
    }

}
