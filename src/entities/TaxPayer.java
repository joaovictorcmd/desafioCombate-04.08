package entities;

public class TaxPayer {
    private double salaryIncome;
    private double servicesIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
            double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {
        if ((this.salaryIncome / 12) < 3000.0) {
            return 0;
        } else if ((this.salaryIncome / 12) >= 3000.0 && (this.salaryIncome / 12) < 5000.0) {
            return this.salaryIncome * 0.1;
        } else {
            return this.salaryIncome * 0.2;
        }
    }

    public double servicesTax() {
        if (servicesIncome > 0) {
            return servicesIncome * 0.15;
        } else {
            return 0;
        }
    }

    public double capitalTax() {
        if (capitalIncome > 0) {
            return servicesIncome * 0.2;
        } else {
            return 0;
        }
    }

    public double grossTax() {
        return salaryTax() + servicesTax() + capitalTax();
    }

    public double taxRebate() {
        if ((healthSpending + educationSpending) < grossTax() * 0.3) {
            return healthSpending + educationSpending;
        } else {
            return grossTax() * 0.3;
        }
    }

    public double netTax() {
        return grossTax() - taxRebate();
    }

    public String toString() {
        return "Imposto bruto total: " +
                String.format("%.2f\n", grossTax()) +
                "Abatimento: " +
                String.format("%.2f\n", taxRebate()) +
                "Imposto devido: " +
                String.format("%.2f\n", netTax());
    }
}
