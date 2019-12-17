package bvp.his.isofhcare.model;

import java.util.List;

public class PatientResult {
    private Profile Profile;
    private List<ServiceDetail> ListService;
    private List<String> ListPayment;
    private List<Invoice> ListInvoice;

    public PatientResult() {
    }

    public Profile getProfile() {
        return Profile;
    }

    public void setProfile(Profile profile) {
        Profile = profile;
    }

    public List<ServiceDetail> getListService() {
        return ListService;
    }

    public void setListService(List<ServiceDetail> listService) {
        ListService = listService;
    }

    public List<String> getListPayment() {
        return ListPayment;
    }

    public void setListPayment(List<String> listPayment) {
        ListPayment = listPayment;
    }

    public List<Invoice> getListInvoice() {
        return ListInvoice;
    }

    public void setListInvoice(List<Invoice> listInvoice) {
        ListInvoice = listInvoice;
    }
}
