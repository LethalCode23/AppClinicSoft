package com.example.DentalClinicMVC.service;

import com.example.DentalClinicMVC.dao.IDao;
import com.example.DentalClinicMVC.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final IDao<Address> addressIDao;

    @Autowired
    public AddressService(IDao<Address> addressIDao) {
        this.addressIDao = addressIDao;
    }

    public Address save(Address address) {
        return addressIDao.save(address);
    }

    public Address findById(Integer id) {
        return addressIDao.findById(id);
    }

    public void update(Address address) {
        addressIDao.update(address);
    }

    public void delete (Integer id) {
        addressIDao.delete(id);
    }

    public List<Address> findAll(){
        return addressIDao.findAll();
    }
}