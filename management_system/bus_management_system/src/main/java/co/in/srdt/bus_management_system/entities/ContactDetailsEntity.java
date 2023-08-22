package co.in.srdt.bus_management_system.entities;

import javax.persistence.*;

@Entity
@Table(name = "contact_details")
public class ContactDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long contactId;
    private String email;
    private String contactNo;
    private String address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basic_details_id")
    private BasicDetailsEntity basicDetailsEntity;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBasicDetailsEntity(BasicDetailsEntity basicDetailsEntity) {
        this.basicDetailsEntity = basicDetailsEntity;
    }

    @Override
    public String toString() {
        return "ContactDetailsEntity{" +
                "contactId=" + contactId +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
