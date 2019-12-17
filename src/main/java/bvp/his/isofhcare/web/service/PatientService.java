package bvp.his.isofhcare.web.service;

import bvp.his.isofhcare.model.ResultEntity;

public interface PatientService {
    ResultEntity getByValue(Object object);
    ResultEntity getDetailByPatientHistory(Object object);
    ResultEntity getResultByPatientHistory(Object object);
    ResultEntity updateISCID(Object object);
}
