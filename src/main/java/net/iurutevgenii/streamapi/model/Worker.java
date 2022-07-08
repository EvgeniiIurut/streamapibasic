package net.iurutevgenii.streamapi.model;

import java.math.BigDecimal;

public class Worker {
    private String name;
    private BigDecimal salary;
    private WorkerSpecialty specialty;

    public Worker(String name, BigDecimal salary, WorkerSpecialty specialty) {
        this.name = name;
        this.salary = salary;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public WorkerSpecialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(WorkerSpecialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", specialty=" + specialty +
                '}';
    }
}
