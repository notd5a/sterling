
/*
This is the data structure we use to load and save data using our resource manager.
Any values changed during the program will not persists unless we set the values into this object,
 then save them using our resource manager into the file: balance.txt
 */

package sample;

import java.io.Serializable;

public class saveData implements Serializable {

    private static final long serialVersionUID = 1L;

    //regular data
    private String name;
    private int age;
    private String username;
    private String password;

    //total values
    private int income;
    private int savings;
    private int spendings;

    //income values
    private int salary;
    private int investment;
    private int credit;
    private int loan;

    //savings values
    private int four01k;
    private int education;
    private int emergencyFund;
    private int uncategorized;

    //spendings values
    private int home;
    private int transport;
    private int health;
    private int entertainment;

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

    public int getFour01k() {
        return four01k;
    }

    public void setFour01k(int four01k) {
        this.four01k = four01k;
    }

    public int getEducation() {
        return education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public int getEmergencyFund() {
        return emergencyFund;
    }

    public void setEmergencyFund(int emergencyFund) {
        this.emergencyFund = emergencyFund;
    }

    public int getUncategorized() {
        return uncategorized;
    }

    public void setUncategorized(int uncategorized) {
        this.uncategorized = uncategorized;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getTransport() {
        return transport;
    }

    public void setTransport(int transport) {
        this.transport = transport;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(int entertainment) {
        this.entertainment = entertainment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
