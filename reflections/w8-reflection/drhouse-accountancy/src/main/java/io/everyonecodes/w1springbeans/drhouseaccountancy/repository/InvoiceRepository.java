package io.everyonecodes.w1springbeans.drhouseaccountancy.repository;

import io.everyonecodes.w1springbeans.drhouseaccountancy.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
