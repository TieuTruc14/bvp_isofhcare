package bvp.his.isofhcare.result;

import bvp.his.isofhcare.model.ResultEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface IResponse {

    /**
     * Log service running time and response json object
     *
     * @param entity Object data muon chuyen sang json
     * @return {"code":0,"message":"no message","data":{}}
     */
    default ResponseEntity response(ResultEntity entity) {
        return new ResponseEntity(entity, HttpStatus.OK);
    }
}
