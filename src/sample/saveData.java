package sample;

import java.io.Serializable;

public class saveData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private int income;
    private int savings;
    private int spendings;
    private int totalSaved;
    private int salary;
    private int investment;
    private int credit;
    private int loan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }

    public int getSpendings() {
        return spendings;
    }

    public void setSpendings(int spendings) {
        this.spendings = spendings;
    }

    public int getTotalSaved() {
        return totalSaved;
    }

    public void setTotalSaved(int totalSaved) {
        this.totalSaved = totalSaved;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getInvestment() {
        return investment;
    }

    public void setInvestment(int investment) {
        this.investment = investment;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

}
