package com.nndata.work.nndata.domain.dto;

import com.nndata.work.nndata.persintence.entity.Cuenta;
import com.nndata.work.nndata.persintence.entity.Movimientos;
import com.nndata.work.nndata.persintence.entity.TipoMovimiento;
import com.nndata.work.nndata.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mglvl on 21/06/15.
 */
public class AccountReport {

    private Long accountNumber;

    private BigDecimal balance;

    private BigDecimal totalCredit;

    private BigDecimal totalDebit;

    private List<Movimientos> creditMovements;

    private List<Movimientos> debitMovements;

    public AccountReport(){
    }

    public List<Movimientos> getCreditMovements() {
        return creditMovements;
    }

    public void setCreditMovements(List<Movimientos> creditMovements) {
        this.creditMovements = creditMovements;
    }

    public List<Movimientos> getDebitMovements() {
        return debitMovements;
    }

    public void setDebitMovements(List<Movimientos> debitMovements) {
        this.debitMovements = debitMovements;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(BigDecimal totalCredit) {
        this.totalCredit = totalCredit;
    }

    public BigDecimal getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(BigDecimal totalDebit) {
        this.totalDebit = totalDebit;
    }

    public static AccountReport fromAccount(Cuenta account, Date start, Date end){
        AccountReport report = new AccountReport();

        List<Movimientos> filteredMovements = account
                .getMovimientosList()
                .stream()
                .filter(mov -> DateUtils.isInBetween(mov.getFecha(), start, end))
                .collect(Collectors.toList());

        List<Movimientos> credits = filteredMovements.stream().filter(mov -> mov.getTipoMovimiento().equals(TipoMovimiento.CREDIT)).collect(Collectors.toList());
        BigDecimal totalCredit = credits.stream().map(mov -> mov.getSaldo()).reduce(new BigDecimal(0.0), (a, b) -> a.add(b));
        List<Movimientos> debits = filteredMovements.stream().filter(mov -> mov.getTipoMovimiento().equals(TipoMovimiento.DEBIT)).collect(Collectors.toList());
        BigDecimal totalDebit = debits.stream().map(mov -> mov.getSaldo()).reduce(new BigDecimal(0.0), (a, b) -> a.add(b));

        report.setCreditMovements(credits);
        report.setDebitMovements(debits);
        report.setAccountNumber(account.getNumeroCuenta().longValue());
        report.setBalance(totalDebit.subtract(totalCredit));
        report.setTotalCredit(totalCredit);
        report.setTotalDebit(totalDebit);

        return report;
    }
}
