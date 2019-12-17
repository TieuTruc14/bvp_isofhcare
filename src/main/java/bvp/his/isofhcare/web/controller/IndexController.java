package bvp.his.isofhcare.web.controller;

import bvp.his.isofhcare.model.ResultEntity;
import bvp.his.isofhcare.result.IResponse;
import bvp.his.isofhcare.result.IResultError;
import bvp.his.isofhcare.web.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/isofhcare/patient")
public class IndexController  implements IResultError, IResponse {
    @Autowired
    PatientService patientService;

    @PostMapping("/get-by-value")
    public ResponseEntity<?>  getByValue(@RequestBody Object object){
        try{
            return response(patientService.getByValue(object));
        }catch (Exception e){
            return responseError(e);
        }
    }

    @PostMapping("/get-detail-patient-history")
    public ResponseEntity<?>  getDetailPatientHistory(@RequestBody Object object){
        try{
            return response(patientService.getDetailByPatientHistory(object));
        }catch (Exception e){
            return responseError(e);
        }
    }

    @PostMapping("/get-result-patient-history")
    public ResponseEntity<?>  getResultPatientHistory(@RequestBody Object object){
        try{
            return response(patientService.getResultByPatientHistory(object));
        }catch (Exception e){
            return responseError(e);
        }
    }

    @PostMapping("/update-isc-id")
    public ResponseEntity<?>  updateISCID(@RequestBody Object object){
        try{
            return response(patientService.updateISCID(object));
        }catch (Exception e){
            return responseError(e);
        }
    }
}
