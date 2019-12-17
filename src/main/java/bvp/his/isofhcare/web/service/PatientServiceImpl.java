package bvp.his.isofhcare.web.service;

import bvp.his.isofhcare.HisIsofhcareApplication;
import bvp.his.isofhcare.model.*;
import bvp.his.isofhcare.model.result.*;
import bvp.his.isofhcare.web.repository.PatientRespository;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PatientServiceImpl extends BaseService implements PatientService {
    @Autowired
    PatientRespository patientRespository;

    @Override
    public ResultEntity getByValue(Object object) {
        JSONObject jsonData=getJsonData(object);
        JSONArray arr = jsonData.getJSONArray("isofhCareIds");
        List<String> isofhCareIds=new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            isofhCareIds.add(arr.getString(i));
        }
        List<PatientHistory> items=patientRespository.getByValue(isofhCareIds).orElse(new ArrayList<>());
        return ok(items);
    }

    @Override
    public ResultEntity getDetailByPatientHistory(Object object) {
        JSONObject jsonData=getJsonData(object);
        JSONArray arr = jsonData.getJSONArray("patientHistoryIds");
        List<Integer> patienthistoryIds=new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            patienthistoryIds.add(Integer.valueOf(arr.getString(i)));
        }
        List<DetailCheckUpResult> list=genDetailCheckUpResult(patienthistoryIds);
        return ok(list);
    }

    private List<DetailCheckUpResult> genDetailCheckUpResult(List<Integer> patienthistoryIds ){
        List<DetailCheckUpResult> list=new ArrayList<>();
        for(Integer patientHistoryId:patienthistoryIds){
            Object[] info=patientRespository.getInfoCheckUpDetail(patientHistoryId).orElse(null);
            if(info!=null){
                DetailCheckUpResult detailCheckUpResult=new DetailCheckUpResult();
                Boolean isInPatient=false;
                if(info[14]!=null){
                    if((info[14].toString()).equals("Y")){
                        isInPatient=true;
                    }
                }
                PatientResult patientResult=new PatientResult();
                Profile profile=genProfile(info);
                List<ServiceDetail> services=genListServiceDetail(patientHistoryId);
                List<Invoice> invoices=genInvoice(patientHistoryId,isInPatient);
                patientResult.setProfile(profile);
                patientResult.setListService(services);
                patientResult.setListInvoice(invoices);

                detailCheckUpResult.setPatientHistoryId(patientHistoryId);
                detailCheckUpResult.setPatientName(profile.getPatientName());
                detailCheckUpResult.setPatientValue(profile.getValue());
                if (info[0] instanceof java.util.Date) {
                    java.util.Date timegoin = (java.util.Date) info[0];
                    detailCheckUpResult.setTimeGoIn(timegoin);
                }
                detailCheckUpResult.setPatientResult(patientResult);
                list.add(detailCheckUpResult);
            }
        }
        return list;
    }

    private Profile genProfile(Object[] info){
        Profile profile=new Profile();
        if(StringUtils.isNotBlank((String)info[1])){
            profile.setValue((String)info[1]);
        }
        if(info[3]!=null){
            profile.setAge(((BigDecimal)info[3]).intValue());
        }
        if(info[4]!=null){
            Integer contract=Integer.valueOf(info[4].toString());
            if(contract.intValue()==1){
                profile.setContract(true);
            }else{
                profile.setContract(false);
            }
        }
        if(info[5]!=null){
            profile.setPhoneNumber((String)info[5]);
        }
        profile.setPriority(false);
        profile.setPatientDocument("");
        if(info[6]!=null){
            profile.setProvinceId(Integer.valueOf((String)info[6]));
        }
        if(info[7]!=null){
            profile.setDistrictId(Integer.valueOf((String)info[7]));
        }
        if(info[8]!=null){
            profile.setZoneId(Integer.valueOf((String)info[8]));
        }

        if(info[9]!=null){
            profile.setGenderId(info[9].toString());
        }
        if (info[10] instanceof java.util.Date) {
            java.util.Date birthday = (java.util.Date) info[10];
            profile.setBirthday(birthday.getTime());
        }
        if (info[11] instanceof java.util.Date) {
            java.util.Date created = (java.util.Date) info[11];
            profile.setCreated(created.getTime());
        }
        if(info[12]!=null){
            profile.setAddress((String)info[12]);
        }

        if(info[13]!=null){
            profile.setCountryId(Integer.valueOf((String)info[13]));
        }
        if (info[0] instanceof java.util.Date) {
            java.util.Date timegoin = (java.util.Date) info[0];
            profile.setTimeGoIn(timegoin.getTime());
        }
        return profile;
    }
    private List<ServiceDetail> genListServiceDetail(Integer HIS_PatientHistory_ID){
        List<ServiceDetail> services=new ArrayList<>();
        List<Object[]> list=patientRespository.getListServiceByPatienthistory(HIS_PatientHistory_ID).orElse(new ArrayList<>());
        if(list!=null && list.size()>0){
            for(Object[] item:list){
                ServiceDetail service=new ServiceDetail();
                if(item[0]!=null){
                    service.setName((String)item[0]);
                }
                if(item[1]!=null){
                    service.setHIS_Service_ID(Integer.valueOf(item[1].toString()));
                }
                if(item[2]!=null){
                    service.setDoctorName((String)item[2]);
                    service.setDoctorFullName((String)item[2]);
                }
                if(item[3]!=null){
                    service.setServiceType((String)item[3]);
                }
                if(item[5]!=null){
                    service.setRoomName((String)item[5]);
                }
                if(item[4]!=null){
                    service.setDoctorId(Integer.valueOf(item[4].toString()));
                }
                if(item[6]!=null){
                    service.setHIS_CheckUp_ID(Integer.valueOf(item[6].toString()));
                }
                if(item[7]!=null){
                    service.setDepartmentId(Integer.valueOf(item[7].toString()));
                }
                if(item[8]!=null){
                    service.setDepartmentName((String)item[8]);
                }
                if(item[9]!=null){
                    String paid=item[9].toString();
                    if(paid.equals("Y")){
                        service.setPaid(true);
                    }else{
                        service.setPaid(false);
                    }
                }
                service.setLocation("");
                services.add(service);
            }
        }

        return services;
    }

    private List<Invoice> genInvoice(Integer HIS_Patienthistory_ID,Boolean isinpatient){
        List<Invoice> items=new ArrayList<>();
        List<Object[]> list=patientRespository.getListInvoiceByPatientHistory(HIS_Patienthistory_ID,isinpatient).orElse(null);
        if(list!=null && list.size()>0){
            for(Object[] item:list){
                Invoice invoice=new Invoice();
                if(item[0]!=null){
                    invoice.setHIS_PatientHistory_ID(Integer.valueOf(item[0].toString()));
                }
                if(item[1]!=null){
                    invoice.setAmount((BigDecimal) item[1]);
                }
                if(item[2]!=null){
                    invoice.setInvoiceNo((String)item[2]);
                }
                items.add(invoice);
            }
        }

        return items;
    }

    @Override
    public ResultEntity getResultByPatientHistory(Object object) {
        JSONObject jsonData=getJsonData(object);
        JSONArray arr = jsonData.getJSONArray("patientHistoryIds");
        List<Integer> patienthistoryIds=new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            patienthistoryIds.add(Integer.valueOf(arr.getString(i)));
        }
        List<ResultCheckUpParent> list=genResultCheckUp(patienthistoryIds);
        return ok(list);
    }

    private List<ResultCheckUpParent> genResultCheckUp(List<Integer> patienthistoryIds ){
        List<ResultCheckUpParent> list=new ArrayList<>();
        for(Integer patientHistoryId:patienthistoryIds){
            Object[] info=patientRespository.getInfoCheckUpDetail(patientHistoryId).orElse(null);
            if(info!=null){
                ResultCheckUpParent item=new ResultCheckUpParent();
                ServicePatient patientResult=new ServicePatient();
                Profile profile=genProfile(info);
                patientResult.setProfile(profile);
                List<CheckUpResult> checkUpResults=genCheckUpResult(patientHistoryId);
                patientResult.setListResultCheckup(checkUpResults);

                List<DiagnosticResult> diagnosticResults=genDiagnosticResult(patientHistoryId);
                patientResult.setListDiagnostic(diagnosticResults);

                List<HuyetHocResult> huyetHocResults=genBloodResult(patientHistoryId);
                patientResult.setListResultHuyetHoc(huyetHocResults);

                List<HoaSinhResult> hoasinh=genHoaSinh(patientHistoryId);
                patientResult.setListResultHoaSinh(hoasinh);

                item.setPatientHistoryId(patientHistoryId);
                item.setPatientName(profile.getPatientName());
                item.setPatientValue(profile.getValue());
                if (info[0] instanceof java.util.Date) {
                    java.util.Date timegoin = (java.util.Date) info[0];
                    item.setTimeGoIn(timegoin);
                }

                item.setPatientResult(patientResult);
                list.add(item);
            }
        }
        return list;
    }

    private List<CheckUpResult> genCheckUpResult(Integer patientHistoryId){
        List<CheckUpResult> listCheckup=new ArrayList<>();
        List<Object[]> list=patientRespository.getListCheckUpByPatientHistory(patientHistoryId).orElse(new ArrayList<>());
        if(list!=null && list.size()>0){
            for(Object[] info:list){
                CheckUpResult item=new CheckUpResult();
                if(info[1]!=null){
                    item.setDiseaseDiagnostic(info[1].toString());
                }
                if(info[2]!=null){
                    item.setDoctorAdviceTxt(info[2].toString());
                }
                if(info[3]!=null){
                    item.setDiagnostic(info[3].toString());
                }
                if(info[4]!=null){
                    item.setHIS_Service_ID(Integer.valueOf(info[4].toString()));
                }
                if(info[5]!=null){
                    item.setFirst_Diagnostic(info[5].toString());
                }
                if(info[6]!=null){
                    item.setHIS_PatientHistory_ID(Integer.valueOf(info[6].toString()));
                }
                if(info[7]!=null){
                    item.setServiceName(info[7].toString());
                }
                if(info[8]!=null){
                    item.setDoctorAdvice(info[8].toString());
                }
                if(info[9]!=null){
                    item.setOther_DiseaseDiagnostic(info[9].toString());
                }
                if(info[10]!=null){
                    item.setHIS_Service_Union_ID(Integer.valueOf(info[10].toString()));
                }

                Integer checkId= info[0]!=null ? Integer.valueOf(info[0].toString()):0;
                if(checkId>0){
                    List<MedicineResult> listMedicine=new ArrayList<>();
                    List<Object[]> listMedicineObject=patientRespository.getListMedicineByPatientHistory(patientHistoryId,checkId).orElse(new ArrayList<>());
                    if(listMedicineObject.size()>0){
                        for(Object[] object : listMedicineObject){
                            MedicineResult medicine=new MedicineResult();
                            if(object[0]!=null){
                                medicine.setUsage(object[0].toString());
                            }
                            if(object[1]!=null){
                                medicine.setServiceName(object[1].toString());
                            }
                            if(object[2]!=null){
                                medicine.setAmount((BigDecimal)object[2]);
                            }
                            if(object[3]!=null){
                                medicine.setMeasure(object[3].toString());
                            }if(object[4]!=null){
                                medicine.setQuantity((BigDecimal)object[4]);
                            }
                            if(object[5]!=null){
                                medicine.setDosage(object[5].toString());
                            }
                            if(object[6]!=null){
                                medicine.setUnit(object[6].toString());
                            }
                            if(object[7]!=null){
                                medicine.setUnit_Price(object[7].toString());
                            }
                            listMedicine.add(medicine);
                        }
                    }
                    item.setListMedicine(listMedicine);
                }

                listCheckup.add(item);

            }

        }
        return listCheckup;
    }


    public List<DiagnosticResult> genDiagnosticResult(Integer HIS_PatientHistory_ID){
        List<DiagnosticResult> result=new ArrayList<>();
        List<Object[]> list=patientRespository.getListDiagnosticByPatientHistory(HIS_PatientHistory_ID).orElse(new ArrayList<>());
        if(list!=null && list.size()>0){
            for(Object[] info:list){
                DiagnosticResult item=new DiagnosticResult();
                if(info[0]!=null){
                    item.setHIS_PatientHistory_ID(Integer.valueOf(info[0].toString()));
                }
                if(info[1]!=null){
                    item.setServiceName(info[1].toString());
                }
                if(info[2]!=null){
                    item.setHIS_Service_ID(Integer.valueOf(info[2].toString()));
                }
                if(info[3]!=null){
                    item.setSummaryResult(info[3].toString());
                }
                item.setFirst_Diagnostic("");
                item.setDiscussion("");
                if(info[6]!=null){
                    item.setConclusion(info[6].toString());
                }
                if(info[7]!=null) {
                    item.setResult(info[7].toString());
                }
                result.add(item);
            }
        }
        return result;
    }


    public List<HuyetHocResult> genBloodResult(Integer HIS_PatientHistory_ID){
        List<HuyetHocResult> huyethoc=new ArrayList<>();
        HuyetHocResult result=new HuyetHocResult();
        List<HuyetHocMedical> medicals=new ArrayList<>();
        List<Object[]> list=patientRespository.getListBloodByPatientHistory(HIS_PatientHistory_ID).orElse(new ArrayList<>());
        if(list!=null && list.size()>0){
            for(Object[] info:list){
                HuyetHocMedical item=new HuyetHocMedical();
                if(info[0]!=null){
                    item.setServiceName(info[0].toString());
                }
                if(info[1]!=null){
                    item.setHIS_Service_MedicalTest_ID(Integer.valueOf(info[1].toString()));
                }
                if(info[2]!=null){
                    item.setHIS_Service_Union_ID(Integer.valueOf(info[2].toString()));
                }
                List<ServiceMedicTestLine> serviceMedicTestLine=new ArrayList<>();
                ServiceMedicTestLine line=new ServiceMedicTestLine();
                if(info[3]!=null){
                    line.setHigherIndicator(info[3].toString());
                }
                if(info[4]!=null){
                    line.setLowerIndicator(info[4].toString());
                }
                if(info[5]!=null){
                    line.setResultState(info[5].toString());
                }
                if(info[6]!=null){
                    line.setUnit(info[6].toString());
                }
                if(info[7]!=null){
                    line.setResult(info[7].toString());
                }
                serviceMedicTestLine.add(line);
                item.setServiceMedicTestLine(serviceMedicTestLine);

                medicals.add(item);
            }
        }
        result.setGroupId(0);
        result.setListMedical(medicals);
        huyethoc.add(result);
        return huyethoc;
    }

    public List<HoaSinhResult> genHoaSinh(Integer HIS_PatientHistory_ID){
        List<HoaSinhResult> hoasinh=new ArrayList<>();
        HoaSinhResult result=new HoaSinhResult();
        List<HoaSinhMedical> medicals=new ArrayList<>();
        List<Object[]> list=patientRespository.getListSinhHoaByPatientHistory(HIS_PatientHistory_ID).orElse(new ArrayList<>());
        if(list!=null && list.size()>0){
            for(Object[] info:list){
                HoaSinhMedical item=new HoaSinhMedical();

                if(info[3]!=null){
                    item.setHigherIndicator(info[3].toString());
                }
                if(info[4]!=null){
                    item.setLowerIndicator(info[4].toString());
                }
                if(info[5]!=null){
                    item.setResultState(info[5].toString());
                }
                if(info[6]!=null){
                    item.setUnit(info[6].toString());
                }
                if(info[7]!=null){
                    item.setResult(info[7].toString());
                }
                medicals.add(item);
            }
        }
        result.setGroupId(0);
        result.setListMedical(medicals);
        hoasinh.add(result);
        return hoasinh;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultEntity updateISCID(Object object) {
        JSONObject jsonData=getJsonData(object);
        String phone = jsonData.getString("phone");
        Integer patientHistoryId = jsonData.getBigInteger("patientHistoryId").intValue();
        String isofhCareId = jsonData.getString("isofhCareId");
        Integer check=patientRespository.checkExistsPatient(patientHistoryId,phone).orElse(0);
        if(check.intValue()>0){
            int count=patientRespository.updateISC(patientHistoryId,isofhCareId).orElse(0);
            if(count>0){
                return ok(isofhCareId);
            }
        }
        return errorIsofhcare("DL khong phu hop");
    }
}
