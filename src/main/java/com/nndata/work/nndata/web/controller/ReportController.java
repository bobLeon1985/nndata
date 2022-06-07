package com.nndata.work.nndata.web.controller;

import com.nndata.work.nndata.domain.dto.AccountReport;
import com.nndata.work.nndata.domain.dto.AccountReportParams;
import com.nndata.work.nndata.domain.exceptions.ClientDoesntExistException;
import com.nndata.work.nndata.domain.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private CuentaService accountService;

    @RequestMapping(value = "/reports/client-accounts-by-date-range", method = RequestMethod.POST)
    @ResponseBody
    public List<AccountReport> getReport( @RequestBody AccountReportParams params) throws ClientDoesntExistException {
        System.out.println("clientId = "+params.getClientId());
        System.out.println("start = "+params.getStart());
        System.out.println("end = "+params.getEnd());
        return accountService.filterAccounts(params.getClientId(), params.getStart(), params.getEnd());
    }

}
