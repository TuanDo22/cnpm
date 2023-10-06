package com.example.projectse.service.impl;

import com.example.projectse.entity.ServiceEntity;
import com.example.projectse.reponsitory.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.ListenerNotFoundException;
import java.util.Optional;

@Service
public class Servicess {
    @Autowired
    private ServiceRepository serviceRepository;
    public void deleteService(long id){
        serviceRepository.deleteById(id);
    }
    public void saveID(ServiceEntity serviceEntity){
        serviceRepository.save(serviceEntity);
    }
    public ServiceEntity fixCompanyID(long id) throws ListenerNotFoundException {
        Optional<ServiceEntity> serviceEntity = serviceRepository.findById(id);
        if (serviceEntity.isPresent()){
            return serviceEntity.get();
        }
        throw new ListenerNotFoundException("Not find ID" + id);
    }
}
