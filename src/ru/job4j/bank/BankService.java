package ru.job4j.bank;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (accounts.indexOf(account) < 0) {
                accounts.add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        return  Stream.of(users)
                .flatMap(user -> user.keySet().stream())
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.isPresent() ?
                users.get(user.get()).stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst() : null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            double srcBalance = srcAccount.get().getBalance();
            double destBalance = destAccount.get().getBalance();
            if (srcBalance >= amount) {
               srcAccount.get().setBalance(srcBalance - amount);
               destAccount.get().setBalance(destBalance + amount);
               rsl = true;
            }
        }
        return rsl;
    }
}
