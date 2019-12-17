package bvp.his.isofhcare.web.repository;

import bvp.his.isofhcare.model.PatientHistory;
import bvp.his.isofhcare.model.result.DiagnosticResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PatientRespository  {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<List<PatientHistory>> getByValue(List<String> isofhCareIds){
        StringBuffer sql=new StringBuffer("select ph.timegoin, ph.HIS_PatientHistory_ID, ph.isofhcareid,ph.value,ph.appointmentDate from HIS_PatientHistory ph ")
                .append(" where ph.isofhcareid in :isofhcareIds and IsActive='Y' order by ph.value,ph.timegoin ");
        Query query=entityManager.createNativeQuery(sql.toString());
        query.setParameter("isofhcareIds",isofhCareIds);
        List<Object[]> list=query.setMaxResults(20).getResultList();
        List<PatientHistory> items=new ArrayList<>();
        if(list!=null && list.size()>0){
            list.stream().forEach(item->{
                Integer id=Integer.valueOf(0);
                PatientHistory ph=new PatientHistory();
                if(StringUtils.isNotBlank((String)item[3])){
                    id=Integer.valueOf(((BigDecimal)item[1]).intValue());
                    ph.setPatientHistoryId(id);
                    if (item[0] instanceof java.util.Date) {
                        java.util.Date timegoin = (java.util.Date) item[0];
                        ph.setDate(timegoin);
                    }
                    if(StringUtils.isNotBlank((String)item[2])){
                        ph.setIsofhCareId((String)item[2]);
                    }
                    if(StringUtils.isNotBlank((String)item[3])){
                        ph.setValue((String)item[3]);
                    }
                    if (item[4] instanceof java.util.Date) {
                        java.util.Date appointmentDate = (java.util.Date) item[4];
                        ph.setAppointmentDate(appointmentDate);
                    }
                    items.add(ph);
                }
            });

        }
        return Optional.ofNullable(items);
    }

    public Optional<Object[]> getInfoCheckUpDetail(Integer his_patienthistory_id){
        if(his_patienthistory_id==null || his_patienthistory_id.longValue()==0) return Optional.ofNullable(null);
        StringBuilder sql=new StringBuilder("");
        sql.append("select ph.timegoin,ph.value,ph.name,ph.age, ")
                .append(" case when nvl(ph.HIS_CHECKUP_CONTRACT_ID,0)>0 then 1 else 0 end IsContract, ")
                .append(" ph.TEL_NO,hp.value Province,hd.value District,hz.value Zone,ph.HIS_GENDER_ID, ")
                .append(" ph.BIRTHDAY,ph.CREATED,ph.ADDRESS2 address,hc.VALUE country, ph.IsInpatient ")
                .append(" from HIS_PatientHistory ph ")
                .append(" left join HIS_PROVINCE hp on ph.HIS_PROVINCE_ID=hp.HIS_PROVINCE_ID ")
                .append(" left join his_district hd on ph.HIS_DISTRICT_ID=hd.HIS_DISTRICT_ID ")
                .append(" left join his_zone hz on ph.HIS_ZONE_ID=hz.HIS_ZONE_ID ")
                .append(" left join his_country hc on ph.HIS_COUNTRY_ID=hc.HIS_COUNTRY_ID ")
                .append(" Where ph.HIS_PatientHistory_ID = ? ");
        Query query=entityManager.createNativeQuery(sql.toString());
        query.setParameter(1,his_patienthistory_id);
        Object[] item=(Object[])query.getSingleResult();
        return Optional.ofNullable(item);
    }

    public Optional<List<Object[]>> getListServiceByPatienthistory(Integer His_PatientHistory_ID){
        if(His_PatientHistory_ID==null || His_PatientHistory_ID.longValue()==0) return Optional.ofNullable(null);
        StringBuilder sql=new StringBuilder("");
        sql.append(" select hs.NAME,hsu.HIS_SERVICE_ID, au.fullname TenBS,'CheckUp' as ServiceType, ")
                .append(" hsu.AD_USER_ID doctorId, hr.name tenPhong,hsu.HIS_CHECKUP_ID,hd.HIS_DEPARTMENT_ID,hd.name TenKhoa,hsu.ISPAIDS ")
                .append(" from his_checkup hsu ")
                .append(" left join his_service hs on hsu.his_service_id=hs.HIS_SERVICE_ID ")
                .append(" left join ad_user au on hsu.AD_USER_ID=au.AD_USER_ID ")
                .append(" left join his_room hr on hsu.HIS_ROOM_ID=hr.HIS_ROOM_ID ")
                .append(" left join his_department hd on hr.HIS_DEPARTMENT_ID=hd.HIS_DEPARTMENT_ID ")
                .append(" Where hsu.HIS_PatientHistory_ID = ? ");
        Query query=entityManager.createNativeQuery(sql.toString());
        query.setParameter(1,His_PatientHistory_ID);
        List<Object[]> list=query.getResultList();
        return Optional.ofNullable(list);
    }

    public Optional<List<Object[]>> getListInvoiceByPatientHistory(Integer His_PatientHistory_ID,Boolean isInpatient){
        if(His_PatientHistory_ID==null || His_PatientHistory_ID.longValue()==0) return Optional.ofNullable(null);
        StringBuilder sql=new StringBuilder("");
        if(isInpatient){
            sql.append("select HIS_PatientHistory_ID, patientamount,invoiceno from his_inpatient_Invoice where ISACTIVE='Y' and HIS_PatientHistory_ID = ? ");
        }else{
            sql.append("select HIS_PatientHistory_ID, amount,invoiceno from his_invoice where ISACTIVE='Y' and HIS_PatientHistory_ID = ? ");
        }
        Query query=entityManager.createNativeQuery(sql.toString());
        query.setParameter(1,His_PatientHistory_ID);
        List<Object[]> list=query.getResultList();
        return Optional.ofNullable(list);
    }

    public Optional<List<Object[]>> getListMedicineByPatientHistory(Integer His_PatientHistory_ID,Integer checkupId){
        if(His_PatientHistory_ID==null || His_PatientHistory_ID.longValue()==0) return Optional.ofNullable(null);
        StringBuilder sql=new StringBuilder("");
        sql.append(" select hsm.HIS_USAGE_ID ,hs.name TenThuoc,hsm.amount ,hs.HIS_MEASURE,hsm.quantity, ")
                .append(" hd.name Dosage,cu.name DVT,hsm.UNITPRICE_SERVICE DonGia ")
                .append(" from his_service_medicine hsm ")
                .append(" left join his_service hs on hsm.his_service_id=hs.his_service_id ")
                .append(" left join his_dosage hd on hsm.HIS_DOSAGE_ID=hd.HIS_DOSAGE_ID ")
                .append(" left join c_uom cu on hsm.C_UOM_ID=cu.C_UOM_ID ")
                .append(" Where hsm.HIS_PatientHistory_ID = ? and hsm.IsActive='Y' and nvl(hsm.Status,'Nor')!='Canceled' and hsm.CREATEDFROMSERVICETYPE='CheckUp' and hsm.CREATEDFROMRECORD_ID = ?  ");
        Query query=entityManager.createNativeQuery(sql.toString());
        query.setParameter(1,His_PatientHistory_ID);
        query.setParameter(2,checkupId);
        List<Object[]> list=query.getResultList();
        return Optional.ofNullable(list);
    }

    public Optional<List<Object[]>> getListCheckUpByPatientHistory(Integer His_PatientHistory_ID){
        if(His_PatientHistory_ID==null || His_PatientHistory_ID.longValue()==0) return Optional.ofNullable(null);
        StringBuilder sql=new StringBuilder("");
        sql.append(" select hc.his_checkup_id,hd.name ChanDoanBenh,hc.DOCTORADVICETXT LoiDanchitiet, hc.DIAGNOSTIC ChanDoan, ")
                .append(" hc.HIS_SERVICE_ID,hc.First_Diagnostic ChanDoanSoBo, hc.HIS_PATIENTHISTORY_ID, ")
                .append(" hs.name ServiceName,hdo.content loidan,hd1.name ChanDoanKhac, hc.HIS_Service_Union_ID ")
                .append(" from his_checkup hc ")
                .append(" left join his_service hs on hc.HIS_SERVICE_ID=hs.HIS_SERVICE_ID ")
                .append(" left join HIS_DISEASE hd on hc.DISEASEDIAGNOSTIC_ID=hd.HIS_DISEASE_ID ")
                .append(" left join HIS_DISEASE hd1 on hc.OTHER_DISEASEDIAGNOSTIC_ID=hd.HIS_DISEASE_ID ")
                .append(" left join his_doctoradvice hdo on hc.HIS_DOCTORADVICE_ID=hdo.HIS_DOCTORADVICE_ID ")
                .append(" Where hc.HIS_PatientHistory_ID = ? and hc.IsActive='Y' and nvl(hc.Status,'Nor')!='Canceled' ");
        Query query=entityManager.createNativeQuery(sql.toString());
        query.setParameter(1,His_PatientHistory_ID);
        List<Object[]> list=query.getResultList();
        return Optional.ofNullable(list);
    }

    public Optional<List<Object[]>> getListDiagnosticByPatientHistory(Integer His_PatientHistory_ID){
        if(His_PatientHistory_ID==null || His_PatientHistory_ID.longValue()==0) return Optional.ofNullable(null);
        StringBuilder sql=new StringBuilder("");
        sql.append(" select hsu.HIS_PatientHistory_ID, hs.name ServiceName, hsu.HIS_Service_ID, hsu.Conclusion SummaryResult, ")
                .append(" '' First_Diagnostic, '' Discussion,hsu.Conclusion Conclusion,hsu.RESULTTEXT Result ")
                .append(" from HIS_SERVICE_DIAGNOSTICIMAGE hsu ")
                .append(" left join his_service hs on hsu.his_service_id=hs.his_service_id ")
                .append(" Where hsu.HIS_PatientHistory_ID = ? and hsu.IsActive='Y' and nvl(hsu.Status,'Nor')!='Canceled' ");
        Query query=entityManager.createNativeQuery(sql.toString());
        query.setParameter(1,His_PatientHistory_ID);
        List<Object[]> list=query.getResultList();
        return Optional.ofNullable(list);
    }

    public Optional<List<Object[]>> getListBloodByPatientHistory(Integer His_PatientHistory_ID){
        if(His_PatientHistory_ID==null || His_PatientHistory_ID.longValue()==0) return Optional.ofNullable(null);
        StringBuilder sql=new StringBuilder("");
        sql.append(" select hs.name ServiceName,hsu.HIS_Service_MedicalTest_ID,hsu.his_service_union_id, ")
                .append(" hsu.HIGHERINDICATOR,hsu.LOWERINDICATOR,GET_REFERENCE_VALUE('HIS_Service_Status',hsu.STATUS_LIS,'vi_VN','') TrangThai,hsu.unit ,hsu.INDICATOR_STR Result ")
                .append(" from HIS_Service_MedicalTest hsu ")
                .append(" left join his_service hs on hsu.his_service_id=hs.his_service_id ")
                .append(" Where hsu.HIS_PatientHistory_ID = ? and hsu.IsActive='Y' and nvl(hsu.Status,'Nor')!='Canceled' and hs.HIS_ServiceGroupLevel2_ID = 1000051 ");
        Query query=entityManager.createNativeQuery(sql.toString());
        query.setParameter(1,His_PatientHistory_ID);
        List<Object[]> list=query.getResultList();
        return Optional.ofNullable(list);
    }

    public Optional<List<Object[]>> getListSinhHoaByPatientHistory(Integer His_PatientHistory_ID){
        if(His_PatientHistory_ID==null || His_PatientHistory_ID.longValue()==0) return Optional.ofNullable(null);
        StringBuilder sql=new StringBuilder("");
        sql.append(" select hs.name ServiceName,hsu.HIS_Service_MedicalTest_ID,hsu.his_service_union_id, ")
                .append(" hsu.HIGHERINDICATOR,hsu.LOWERINDICATOR,GET_REFERENCE_VALUE('HIS_Service_Status',hsu.STATUS_LIS,'vi_VN','') TrangThai,hsu.unit ,hsu.INDICATOR_STR Result ")
                .append(" from HIS_Service_MedicalTest hsu ")
                .append(" left join his_service hs on hsu.his_service_id=hs.his_service_id ")
                .append(" Where hsu.HIS_PatientHistory_ID = ? and hsu.IsActive='Y' and nvl(hsu.Status,'Nor')!='Canceled' and hs.HIS_ServiceGroupLevel2_ID = 1000049  ");
        Query query=entityManager.createNativeQuery(sql.toString());
        query.setParameter(1,His_PatientHistory_ID);
        List<Object[]> list=query.getResultList();
        return Optional.ofNullable(list);
    }

    public Optional<Integer> checkExistsPatient(Integer His_PatientHistory_ID,String phone){
        if(His_PatientHistory_ID==null || His_PatientHistory_ID.longValue()==0) return Optional.ofNullable(null);
        StringBuilder sql=new StringBuilder("");
        sql.append(" select count(*) from HIS_PatientHistory  where HIS_PatientHistory_ID = ? and TEL_NO = ?");
        Query query=entityManager.createNativeQuery(sql.toString());
        query.setParameter(1,His_PatientHistory_ID);
        query.setParameter(2,phone);
        Integer count = ((Number) query.getSingleResult()).intValue();
        return Optional.ofNullable(count);
    }

    public Optional<Integer> updateISC(Integer His_PatientHistory_ID,String isofhcareId){
        if(His_PatientHistory_ID==null || His_PatientHistory_ID.longValue()==0 || StringUtils.isBlank(isofhcareId)) return Optional.ofNullable(null);
        StringBuilder sql=new StringBuilder("");
        sql.append("Update HIS_PatientHistory set isofhcareId = :isofhcareId where HIS_PatientHistory_ID = :HIS_PatientHistory_ID ");
        Query query=entityManager.createNativeQuery(sql.toString());
        query.setParameter("isofhcareId",isofhcareId);
        query.setParameter("HIS_PatientHistory_ID",His_PatientHistory_ID);
        int count=query.executeUpdate();
        return Optional.ofNullable(count);
    }


}
