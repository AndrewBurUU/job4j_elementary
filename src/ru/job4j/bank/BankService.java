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
        User rsl = null;
        for (User user: users.keySet()) {
           if (user.getPassport().equals(passport)) {
               rsl = user;
               break;
           }
        }
        return rsl;
    }

    public User findByPassportNew(String passport) {
//        List<User> userList = (List<User>) users.keySet();
//        return userList.stream().filter(user -> user.getPassport().contains(passport)).collect(Collectors.toList());
//        return Stream.of(users)
//                .map(user -> user.getPassport().contains(passport));
        List<User> userList = Stream.of(users).flatMap(user -> user.keySet().stream()).collect(Collectors.toList());
        return userList.stream().filter(user -> user.getPassport().contains(passport));
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account: accounts) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
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
