package zw.co.lws.livestockwebservice.service;

import java.time.LocalDate;

public class PartnershipCreateRequest {
    public PartnershipCreateRequest() {
    }
    private String name;
    private LocalDate dateFormed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateFormed() {
        return dateFormed;
    }

    public void setDateFormed(LocalDate dateFormed) {
        this.dateFormed = dateFormed;
    }

    @Override
    public String toString() {
        return "PartnershipCreateRequest{" +
                "name='" + name + '\'' +
                ", dateFormed=" + dateFormed +
                '}';
    }
}
