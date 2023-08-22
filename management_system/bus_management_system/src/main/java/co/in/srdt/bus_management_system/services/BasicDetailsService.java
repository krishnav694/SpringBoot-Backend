package co.in.srdt.bus_management_system.services;

import co.in.srdt.bus_management_system.entities.BasicDetailsEntity;
import co.in.srdt.bus_management_system.entities.ContactDetailsEntity;
import co.in.srdt.bus_management_system.models.ApiResponseModel;
import co.in.srdt.bus_management_system.models.BasicDetailsModel;
import co.in.srdt.bus_management_system.models.ContactDetailsModel;
import co.in.srdt.bus_management_system.repositories.BasicDetailsRepository;
import co.in.srdt.bus_management_system.repositories.ContactDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasicDetailsService {

    @Autowired
    BasicDetailsRepository basicDetailsRepository;

    @Autowired
    ContactDetailsRepository contactDetailsRepository;

    /*
    @Transactional
    public ResponseEntity saveBasicDetails(BasicDetailsModel basicDetailsModel) {
        System.out.println("basicDetailsModel"+basicDetailsModel);
        BasicDetailsEntity basicDetailsEntity = new BasicDetailsEntity();
        basicDetailsEntity.setName(basicDetailsModel.getName());
        basicDetailsEntity.setAge(basicDetailsModel.getAge());
        basicDetailsEntity.setFatherName(basicDetailsModel.getFatherName());
        List<ContactDetailsEntity> contactDetailsEntityList = new ArrayList<>();
        basicDetailsModel.getContactDetails().stream().forEach(data -> {
            ContactDetailsEntity contactDetailsEntity = new ContactDetailsEntity();
            contactDetailsEntity.setContactNo(data.getContactNo());
            contactDetailsEntity.setAddress(data.getAddress());
            contactDetailsEntity.setEmail(data.getEmail());
            contactDetailsEntity.setBasicDetailsEntity(basicDetailsEntity);
            contactDetailsEntityList.add(contactDetailsEntity);
        });
        basicDetailsEntity.setContactDetails(contactDetailsEntityList);
        System.out.println("basicDetailsEntity=>"+basicDetailsEntity);
        basicDetailsRepository.save(basicDetailsEntity);
        System.out.println("******************************************");
        System.out.println("basicDetailsEntity=========================>"+basicDetailsEntity);
        return new ResponseEntity(new ApiResponseModel("Saved successfully.","Success"), HttpStatus.OK);
    }
    */

    public List<BasicDetailsModel> getAllBasicDetails() {
        List<BasicDetailsEntity> basicDetailsEntityList = basicDetailsRepository.findAll();
        List<BasicDetailsModel> basicDetailsModelList = new ArrayList<>();
        basicDetailsEntityList.stream().forEach(data -> {
            BasicDetailsModel basicDetailsModel = new BasicDetailsModel();
            List<ContactDetailsEntity> contactDetailsEntityList = contactDetailsRepository.findByBasicDetailsEntity(data);
            System.out.println("contactDetailsEntityList.size()=>"+contactDetailsEntityList.size());
            List<ContactDetailsModel> contactDetailsModelList = new ArrayList<>();
            contactDetailsEntityList.stream().forEach(contact ->{
                ContactDetailsModel contactDetailsModel = new ContactDetailsModel();
                contactDetailsModel.setContactId(contact.getContactId());
                contactDetailsModel.setAddress(contact.getAddress());
                contactDetailsModel.setContactNo(contact.getContactNo());
                contactDetailsModel.setEmail(contact.getEmail());
                contactDetailsModelList.add(contactDetailsModel);
            });
            basicDetailsModel.setName(data.getName());
            basicDetailsModel.setAge(data.getAge());
            basicDetailsModel.setFatherName(data.getFatherName());
            basicDetailsModel.setId(data.getId());
            basicDetailsModel.setContactDetails(contactDetailsModelList);
            basicDetailsModelList.add(basicDetailsModel);

        });
        return basicDetailsModelList;
    }

    public BasicDetailsModel getBasicDetailsById(Long id) {
        Optional<BasicDetailsEntity> basicDetailsEntity = basicDetailsRepository.findById(id);
        BasicDetailsModel basicDetailsModel = new BasicDetailsModel();
        if (basicDetailsEntity.isPresent()) {
            BasicDetailsEntity basicDetailsEntity1 = basicDetailsEntity.get();

            List<ContactDetailsModel> contactDetailsModelList = new ArrayList<>();
            List<ContactDetailsEntity> contactDetailsEntityList = contactDetailsRepository.findByBasicDetailsEntity(basicDetailsEntity1);
            contactDetailsEntityList.stream().forEach(data ->{
                ContactDetailsModel contactDetailsModel = new ContactDetailsModel();
                contactDetailsModel.setContactId(data.getContactId());
                contactDetailsModel.setEmail(data.getEmail());
                contactDetailsModel.setAddress(data.getAddress());
                contactDetailsModel.setContactNo(data.getContactNo());
                contactDetailsModelList.add(contactDetailsModel);
            });
            basicDetailsModel.setContactDetails(contactDetailsModelList);
            basicDetailsModel.setName(basicDetailsEntity1.getName());
            basicDetailsModel.setId(basicDetailsEntity1.getId());
            basicDetailsModel.setAge(basicDetailsEntity1.getAge());
            basicDetailsModel.setFatherName(basicDetailsEntity1.getFatherName());
            return basicDetailsModel;
        }
        else {
            return basicDetailsModel;
        }
    }

    @Transactional
    public ResponseEntity deleteBasicDetailsById(Long id) {
        Optional<BasicDetailsEntity> basicDetailsEntity = basicDetailsRepository.findById(id);
        if(basicDetailsEntity.isPresent()){
            BasicDetailsEntity basicDetailsEntity1 = basicDetailsEntity.get();
            basicDetailsRepository.delete(basicDetailsEntity1);
            return new ResponseEntity(new ApiResponseModel("Deleted Successfully.","Success"), HttpStatus.OK);
        }
        else {
            return new ResponseEntity(new ApiResponseModel("Id not found.","Success"), HttpStatus.OK);
        }
    }

    @Transactional
    public ResponseEntity saveBasicDetails(BasicDetailsModel basicDetailsModel) {
        System.out.println("basicDetailsModel Service -->"+basicDetailsModel);
        if (basicDetailsModel.getId() == null) {
            System.out.println("basicDetailsModel"+basicDetailsModel);
            BasicDetailsEntity basicDetailsEntity = new BasicDetailsEntity();
            basicDetailsEntity.setName(basicDetailsModel.getName());
            basicDetailsEntity.setAge(basicDetailsModel.getAge());
            basicDetailsEntity.setFatherName(basicDetailsModel.getFatherName());
            List<ContactDetailsEntity> contactDetailsEntityList = new ArrayList<>();
            basicDetailsModel.getContactDetails().stream().forEach(data -> {
                ContactDetailsEntity contactDetailsEntity = new ContactDetailsEntity();
                contactDetailsEntity.setContactNo(data.getContactNo());
                contactDetailsEntity.setAddress(data.getAddress());
                contactDetailsEntity.setEmail(data.getEmail());
                contactDetailsEntity.setBasicDetailsEntity(basicDetailsEntity);
                contactDetailsEntityList.add(contactDetailsEntity);
            });
            basicDetailsEntity.setContactDetails(contactDetailsEntityList);
            System.out.println("basicDetailsEntity=>"+basicDetailsEntity);
            basicDetailsRepository.save(basicDetailsEntity);
            System.out.println("******************************************");
            System.out.println("basicDetailsEntity=========================>"+basicDetailsEntity);
            return new ResponseEntity(new ApiResponseModel("Saved successfully.","Success"), HttpStatus.OK);
        } else {
            System.out.println("basicDetailsModel if -->"+basicDetailsModel);
            Optional<BasicDetailsEntity> basicDetailsEntity = basicDetailsRepository.findById(basicDetailsModel.getId());
            if (basicDetailsEntity.isPresent()) {
                BasicDetailsEntity basicDetailsEntity1 = basicDetailsEntity.get();
                List<ContactDetailsEntity> contactDetailsEntityList = basicDetailsEntity1.getContactDetails();
                List<ContactDetailsModel> contactDetailsModelList = basicDetailsModel.getContactDetails();
                System.out.println("contactDetailsModelList=>" + contactDetailsModelList.size());
                for (int i = 0; i < contactDetailsModelList.size(); i++) {
                    ContactDetailsEntity contactDetailsEntity = contactDetailsEntityList.get(i);
                    ContactDetailsModel contactDetailsModel = basicDetailsModel.getContactDetails().get(i);
                    if (contactDetailsEntity.getContactId() == contactDetailsModel.getContactId()) {
                        contactDetailsEntity.setContactNo(contactDetailsModel.getContactNo());
                        contactDetailsEntity.setAddress(contactDetailsModel.getAddress());
                        contactDetailsEntity.setEmail(contactDetailsModel.getEmail());
                        contactDetailsRepository.save(contactDetailsEntity);
                    }
                }
                basicDetailsEntity1.setName(basicDetailsModel.getName());
                basicDetailsEntity1.setAge(basicDetailsModel.getAge());
                basicDetailsEntity1.setFatherName(basicDetailsModel.getFatherName());
                return new ResponseEntity(new ApiResponseModel("Updated Successfully.", "Success"), HttpStatus.OK);
            }
            else {
                return new ResponseEntity(new ApiResponseModel("UserId absent.", "Success"), HttpStatus.OK);
            }
        }
    }
}