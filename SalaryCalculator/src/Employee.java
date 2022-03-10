public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;

    Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    double tax() {
        if(this.salary > 1000) {
            double tax = this.salary * 0.03;
            return tax;
        }
        return 0;
    }

    int bonus() {
        if(this.workHours > 40) {
            int increaseHours = workHours - 40;
            int bonus = increaseHours * 30;
            return bonus;
        }
        return 0;
    }

    double raiseSalary() {
        int workYear = 2021 - hireYear;
        double raiseSalary;

        if(workYear < 10) {
            raiseSalary = this.salary * 0.05;
            return raiseSalary;
        }else if(workYear > 9 && workYear < 20) {
            raiseSalary = this.salary * 0.1;
            return raiseSalary;
        }else{
            raiseSalary = this.salary * 0.15;
            return raiseSalary;
        }
    }

    @Override
    public String toString() {
        double totalSalary = this.salary + raiseSalary() + bonus();
        double netSalary = totalSalary - tax();

        return "Employee{" + "\n" +
                "\tname: " + name + "\n" +
                "\tsalary: " + salary + "\n" +
                "\tworkHours: " + workHours + "\n" +
                "\thireYear: " + hireYear + "\n" +
                "\ttax: " + this.tax() + "\n" +
                "\tbonus: " + this.bonus() + "\n" +
                "\tsalary increase by year: " + this.raiseSalary() + "\n" +
                "\tnet salary with tax and bonus: " + netSalary + "\n" +
                "\ttotal salary: " + totalSalary + "\n" +
                '}';
    }
}
