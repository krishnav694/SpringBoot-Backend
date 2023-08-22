package co.in.srdt.bus_management_system.models;

import java.util.ArrayList;
import java.util.List;

public class BasicDetailsModel {
    private Long id;
    private String name;
    private String age;
    private String fatherName;
    private List<ContactDetailsModel> contactDetails = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public List<ContactDetailsModel> getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(List<ContactDetailsModel> contactDetails) {
        this.contactDetails = contactDetails;
    }

    @Override
    public String toString() {
        return "BasicDetailsModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", contactDetails=" + contactDetails +
                '}';
    }
}
