package ru.otus.java.pro.API;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.java.pro.cashmachine.machine.data.CashMachine;
import ru.otus.java.pro.cashmachine.machine.service.CashMachineService;

import java.math.BigDecimal;
import java.util.List;


@Controller
public class ATMDataController {
    private final CashMachine cashMachine;
    private final CashMachineService cashMachineService;

    @Autowired
    public ATMDataController(CashMachine cashMachine, CashMachineService cashMachineService) {
        this.cashMachineService = cashMachineService;
        this.cashMachine = cashMachine;
    }

    @GetMapping("/selectAction")
    public String showSelectActionForm(Model model) {
        model.addAttribute("atmRequest", new ATMRequest());
        return "SelectAction";
    }

    @GetMapping("/getMoney")
    public String showGetMoneyForm(Model model) {
        model.addAttribute("atmRequest", new ATMRequest());
        return "GetMoney";
    }

    @GetMapping("/putMoney")
    public String showPutMoneyForm(Model model) {
        model.addAttribute("atmRequest", new ATMRequest());
        return "PutMoney";
    }

    @GetMapping("/checkBalance")
    public String showCheckBalanceForm(Model model) {
        model.addAttribute("atmRequest", new ATMRequest());
        return "CheckBalance";
    }

    @GetMapping("/changePinCode")
    public String showChangePinForm(Model model) {
        model.addAttribute("atmRequest", new ATMRequest());
        return "ChangePinCode";
    }

    @PostMapping("/getMoney")
    public String getMoney(@ModelAttribute ATMRequest atmRequest, Model model) {
        try {
            List<Integer> bills = cashMachineService.getMoney(cashMachine, atmRequest.getCardNum(), atmRequest.getPin(), atmRequest.getAmount());
            model.addAttribute("count5000", bills.get(0));
            model.addAttribute("count1000", bills.get(1));
            model.addAttribute("count500", bills.get(2));
            model.addAttribute("count100", bills.get(3));
            return "GetMoney";
        } catch (Exception e) {
            return "index";
        }
    }

    @PostMapping("/putMoney")
    public String putMoney(@ModelAttribute ATMRequest atmRequest, Model model) {
        try {
            BigDecimal balance = cashMachineService.putMoney(cashMachine, atmRequest.getCardNum(), atmRequest.getPin(), atmRequest.counter());
            model.addAttribute("balance", balance);
            return "PutMoney";
        } catch (Exception e) {
            return "index";
        }
    }

    @PostMapping("/changePinCode")
    public String changePinCode(@ModelAttribute ATMRequest atmRequest, Model model) {
        try {
            if (cashMachineService.changePin(atmRequest.getCardNum(), atmRequest.getPin(), atmRequest.getNewPin())){
                model.addAttribute("message","PIN code changed successful");
                return "ChangePinCode";
            }
            else throw new Exception();
        } catch (Exception e) {
            return "index";
        }
    }

    @PostMapping("/checkBalance")
    public String checkBalance(@ModelAttribute ATMRequest atmRequest, Model model) {
        try {
            BigDecimal balance = cashMachineService.checkBalance(cashMachine, atmRequest.getCardNum(), atmRequest.getPin());
            model.addAttribute("balance", balance);
            return "CheckBalance";
        } catch (Exception e) {
            return "index";
        }
    }
}
