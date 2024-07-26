package io.everyonecodes.w1springbeans.drhouseaccountancy.logic;

import io.everyonecodes.w1springbeans.drhouseaccountancy.logic.dto.DTOTranslator;
import io.everyonecodes.w1springbeans.drhouseaccountancy.model.Invoice;
import io.everyonecodes.w1springbeans.drhouseaccountancy.model.Patient;
import io.everyonecodes.w1springbeans.drhouseaccountancy.model.PatientDTO;
import io.everyonecodes.w1springbeans.drhouseaccountancy.repository.InvoiceRepository;
import io.everyonecodes.w1springbeans.drhouseaccountancy.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final InvoiceRepository invoiceRepository;
    private final DTOTranslator dtoTranslator;

    public PatientService(PatientRepository patientRepository, InvoiceRepository invoiceRepository, DTOTranslator dtoTranslator) {
        this.patientRepository = patientRepository;
        this.invoiceRepository = invoiceRepository;
        this.dtoTranslator = dtoTranslator;
    }

    //Finds the Patient by uuid or saves a new one if it didn’t exist;
    // then generates an Invoice for that Patient, saves the Invoice, and returns the PatientDTO.

    public PatientDTO invoicePatient(PatientDTO patientDTO) {
        Optional<Patient> oPatient = patientRepository.findOneByUuid(patientDTO.getUuid());

        if (oPatient.isPresent()) {

            generateInvoice(oPatient.get());
            System.out.println("invoice existing patient");
            return patientDTO;
        } else {
            Patient newPatient = createNewPatient(patientDTO);

            generateInvoice(newPatient);
            System.out.println("invoice newly created patient");
            return patientDTO;
            }
    }

    private void generateInvoice(Patient patient){
        invoiceRepository.save(new Invoice(90.00, patient));
    }

    private Patient createNewPatient(PatientDTO patientDTO) {
        Patient newPatient = dtoTranslator.translateDTOToPatient(patientDTO);
        patientRepository.save(newPatient);
        return newPatient;
    }


}
