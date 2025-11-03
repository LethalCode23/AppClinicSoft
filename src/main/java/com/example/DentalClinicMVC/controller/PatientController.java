package com.example.DentalClinicMVC.controller;

import com.example.DentalClinicMVC.model.Patient;
import com.example.DentalClinicMVC.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/home")
    public String findPatientByEmail(Model model, @RequestParam("email") String email) {

        Patient patient = this.patientService.findByEmail(email);
        model.addAttribute("name", patient.getPatName());
        model.addAttribute("lastName", patient.getPatLastName());
        model.addAttribute("email", patient.getPatEmail());
        model.addAttribute("admission", patient.getPatAdmission());

        return "index";
    }
}