package com.example.DentalClinicMVC.service;

import com.example.DentalClinicMVC.dao.IDao;
import com.example.DentalClinicMVC.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {

    private final IDao<Patient> patientIDao;

    @Autowired
    public PatientService(IDao<Patient> patientIDao) {
        this.patientIDao = patientIDao;
    }

    public Patient save(Patient patient) {
        return this.patientIDao.save(patient);
    }

    public Patient findById(Integer id) {
        return this.patientIDao.findById(id);
    }

    public void update(Patient patient) {
        this.patientIDao.update(patient);
    }

    public void delete (Integer id) {
        this.patientIDao.delete(id);
    }

    public List<Patient> findAll(){
        return this.patientIDao.findAll();
    }

    public Patient findByEmail(String email) {
        return this.patientIDao.findByString(email);
    }
}