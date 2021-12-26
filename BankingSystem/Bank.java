package BankingSystem;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /** In. */
    public void readCustomerList(InputStream inputStream) {
        Scanner sc = new Scanner(inputStream);
        Customer customer = null;
        String checkAcc = "(\\d+) CHECKING (\\d+(\\.\\d+)?)";
        String savingAcc = "(\\d+) SAVINGS (\\d+(\\.\\d+)?)";
        String accNumber = "(\\d+)";

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.matches(checkAcc)) {
                String[] arr = line.split(" ");
                CheckingAccount a = new CheckingAccount(Long.parseLong(arr[0]),
                        Double.parseDouble(arr[2]));
                customer.addAccount(a);
            } else if (line.matches(savingAcc)) {
                String[] arr = line.split(" ");
                SavingsAccount a = new SavingsAccount(Long.parseLong(arr[0]),
                        Double.parseDouble(arr[2]));
                customer.addAccount(a);
            } else {
                Pattern pattern = Pattern.compile(accNumber);
                Matcher matcher = pattern.matcher(line);
                String fullName = "";
                long idNumber = 0;
                if (matcher.find()) {
                    idNumber = Long.parseLong(matcher.group(1));
                    fullName = line.substring(0, matcher.start() - 1);
                }
                customer = new Customer(idNumber, fullName);
                customerList.add(customer);
            }
        }
        sc.close();
    }

    /** Name order.*/
    public String getCustomersInfoByNameOrder() {
        List<Customer> t = customerList;
        t.sort(new OrderByName());
        String ans = "";
        for (Customer i: t) {
            ans += i.getCustomerInfo() + "\n";
        }
        return ans.substring(0, ans.length() - 1);
    }

    /** Id order. */
    public String getCustomersInfoByIdOrder() {
        List<Customer> t = customerList;
        t.sort(new OrderById());
        String ans = "";
        for (Customer i: t) {
            ans += i.getCustomerInfo() + "\n";
        }
        return ans.substring(0, ans.length() - 1);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    private class OrderById implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            if (o1.getIdNumber() == o2.getIdNumber()) {
                return 0;
            } else {
                return o1.getIdNumber() > o2.getIdNumber() ? 1 : -1;
            }
        }
    }

    private class OrderByName implements Comparator<Customer> {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.getFullName().compareTo(o2.getFullName());
        }
    }
}