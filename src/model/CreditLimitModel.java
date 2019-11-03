package model;

public class CreditLimitModel {
    Double salary;
    Double variableSalary;
    Double companyYears;
    Double patrimonyValue;
    Double serasaPontuation;

    public CreditLimitModel(Double salary,
                            Double variableSalary,
                            Double companyYears,
                            Double patrimonyValue,
                            Double serasaPontuation) {

        this.salary = salary;
        this.variableSalary = variableSalary;
        this.companyYears = companyYears;
        this.patrimonyValue = patrimonyValue;
        this.serasaPontuation = serasaPontuation;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setVariableSalary(Double variableSalary) {
        this.variableSalary = variableSalary;
    }

    public void setCompanyYears(Double companyYears) {
        this.companyYears = companyYears;
    }

    public void setPatrimonyValue(Double patrimonyValue) {
        this.patrimonyValue = patrimonyValue;
    }

    public void setSerasaPontuation(Double serasaPontuation) {
        this.serasaPontuation = serasaPontuation;
    }

    public CreditLimitModel() {

    }

    public Double getSalary() {
        return salary;
    }

    public Double getVariableSalary() {
        return variableSalary;
    }

    public Double getCompanyYears() {
        return companyYears;
    }

    public Double getPatrimonyValue() {
        return patrimonyValue;
    }

    public Double getSerasaPontuation() {
        return serasaPontuation;
    }
}