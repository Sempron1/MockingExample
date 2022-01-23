package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BankServiceDummy implements BankService {

    List<String> list = new ArrayList<>();
    @Override
    public void pay(String id, double amount) {
        throw new RuntimeException();
    }
}
