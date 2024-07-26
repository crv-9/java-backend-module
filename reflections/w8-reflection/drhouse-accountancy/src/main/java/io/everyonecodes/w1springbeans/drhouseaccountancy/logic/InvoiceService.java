package io.everyonecodes.w1springbeans.drhouseaccountancy.logic;

import io.everyonecodes.w1springbeans.drhouseaccountancy.model.Invoice;
import io.everyonecodes.w1springbeans.drhouseaccountancy.repository.InvoiceRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    //  Marks the Invoice with the matching id as paid in the database.

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public void updateInvoice(Long id) {
        Optional<Invoice> oInvoice = invoiceRepository.findById(id);

        if (oInvoice.isPresent()) {
            oInvoice.get().setPaid(true);
            invoiceRepository.save(oInvoice.get());
        }
    }
}
