package io.everyonecodes.w1springbeans.drhouseaccountancy.communication.endpoints;

import io.everyonecodes.w1springbeans.drhouseaccountancy.logic.InvoiceService;
import io.everyonecodes.w1springbeans.drhouseaccountancy.model.Invoice;
import io.everyonecodes.w1springbeans.drhouseaccountancy.repository.InvoiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class AccountancyEndpoint {
    final InvoiceService invoiceService;

    public AccountancyEndpoint(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.findAll();
    }

    @PutMapping("/{id}/paid")
    public void updatePaid(@PathVariable long id) {
        invoiceService.updateInvoice(id);
    }
}
