package bvp.his.isofhcare.model.result;

import bvp.his.isofhcare.model.Profile;

import java.util.List;

public class ServicePatient {
    private Profile Profile;
    private List<OtherResult> ListResulOther;
    private List<CheckUpResult> ListResultCheckup;
    private List<HuyetHocResult> ListResultHuyetHoc;
    private List<ViSinhResult> ListResultViSinh;
    private List<DiagnosticResult> ListDiagnostic;
    private List<HoaSinhResult> ListResultHoaSinh;
    private List<GiaiPhauResult> ListResultGiaiPhau;


    public ServicePatient() {
    }

    public bvp.his.isofhcare.model.Profile getProfile() {
        return Profile;
    }

    public void setProfile(bvp.his.isofhcare.model.Profile profile) {
        Profile = profile;
    }

    public List<OtherResult> getListResulOther() {
        return ListResulOther;
    }

    public void setListResulOther(List<OtherResult> listResulOther) {
        ListResulOther = listResulOther;
    }

    public List<CheckUpResult> getListResultCheckup() {
        return ListResultCheckup;
    }

    public void setListResultCheckup(List<CheckUpResult> listResultCheckup) {
        ListResultCheckup = listResultCheckup;
    }

    public List<HuyetHocResult> getListResultHuyetHoc() {
        return ListResultHuyetHoc;
    }

    public void setListResultHuyetHoc(List<HuyetHocResult> listResultHuyetHoc) {
        ListResultHuyetHoc = listResultHuyetHoc;
    }

    public List<ViSinhResult> getListResultViSinh() {
        return ListResultViSinh;
    }

    public void setListResultViSinh(List<ViSinhResult> listResultViSinh) {
        ListResultViSinh = listResultViSinh;
    }

    public List<DiagnosticResult> getListDiagnostic() {
        return ListDiagnostic;
    }

    public void setListDiagnostic(List<DiagnosticResult> listDiagnostic) {
        ListDiagnostic = listDiagnostic;
    }

    public List<HoaSinhResult> getListResultHoaSinh() {
        return ListResultHoaSinh;
    }

    public void setListResultHoaSinh(List<HoaSinhResult> listResultHoaSinh) {
        ListResultHoaSinh = listResultHoaSinh;
    }

    public List<GiaiPhauResult> getListResultGiaiPhau() {
        return ListResultGiaiPhau;
    }

    public void setListResultGiaiPhau(List<GiaiPhauResult> listResultGiaiPhau) {
        ListResultGiaiPhau = listResultGiaiPhau;
    }
}
