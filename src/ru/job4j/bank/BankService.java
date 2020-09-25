package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
       if (!users.equals(user)) {
           users.put(user, new ArrayList<Account>());
       }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            users.putIfAbsent(user, accounts);
/*            if (findByRequisite(passport, account.getRequisite()) != null) {
                accounts.add(account);
                users.put(user, accounts);
            }

 */
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user: users.keySet()) {
           if (user.getPassport() == passport) {
               rsl = user;
               break;
           }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            int index = accounts.indexOf(requisite);
            if (index >= 0) {
                rsl = accounts.get(index);
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

/*
    public static void main(String[] args) {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.findByRequisite("3434", "5546").getBalance();
    }

 */
}
