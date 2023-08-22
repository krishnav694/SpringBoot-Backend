package co.in.srdt.bus_management_system.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "basic_details")
public class BasicDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String age;
    private String fatherName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "basicDetailsEntity")
    private List<ContactDetailsEntity> contactDetails;

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

    public List<ContactDetailsEntity> getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(List<ContactDetailsEntity> contactDetails) {
        this.contactDetails = contactDetails;
    }

    @Override
    public String toString() {
        return "BasicDetailsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", contactDetails=" + contactDetails +
                '}';
    }

}
