package ru.job4j.bank;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (accounts.indexOf(account) < 0) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        return  Stream.of(users)
                .flatMap(user -> user.keySet().stream())
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        return user != null ?
                users.get(user).stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null) : null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            double srcBalance = srcAccount.getBalance();
            double destBalance = destAccount.getBalance();
            if (srcBalance >= amount) {
               srcAccount.setBalance(srcBalance - amount);
               destAccount.setBalance(destBalance + amount);
               rsl = true;
            }
        }
        return rsl;
    }
}
