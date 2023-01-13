package entity;

public class Account {
    public int id;
    public String name;
    public String sex;
    public int age;
    public String date;
    public String phone;
    public double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(int id, String name, String sex, int age, String date, String phone, double balance) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.date = date;
        this.phone = phone;
        this.balance = balance;
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", date='" + date + '\'' +
                ", phone='" + phone + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
