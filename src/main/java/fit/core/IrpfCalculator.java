package fit.core;

public class IrpfCalculator {

    public static Double calculateBaseSalary(Double totalSalary) {

        Double aliquota = 11.0;
        var salarioBase = totalSalary - ((totalSalary * aliquota) / 100);
        System.out.println("salarioBase = " + salarioBase);

        return salarioBase;
    }
 
    public static Double calculateExemption() {
        var isencao = 1903.98;
        System.out.println("isencao = " + isencao);
        return isencao;
    }

    public static Double calculateDiscount(Double baseSalary) {

        var isencao = calculateExemption();
        var desconto = baseSalary - isencao;
        System.out.println("desconto = " + desconto);
        return desconto;

    }

    public static Double calculateTaxLayer(Double baseSalary) {

        Double taxa = 0.0;   

        if (baseSalary <= 1903.98) {
            taxa = 0.0;   
        }
        if (baseSalary >  1903.98 && baseSalary <= 2826.65) {
            taxa = 0.075;
        }
        if (baseSalary >= 2826.66 && baseSalary <= 3751.05) {
            taxa = 0.150;
        }
        if (baseSalary >= 3751.06 && baseSalary <= 4664.68) {
            taxa = 0.225;
        }
        if (baseSalary >  4664.68) {
            taxa = 0.275;
        }
        System.out.println("taxa = " + taxa);
        return taxa;
    }

    public static Double calculateIrpf(Double totalSalary) {

        var salarioBase = calculateBaseSalary(totalSalary);
        var desconto = calculateDiscount(salarioBase); 
        Double descontoIRRF = desconto * calculateTaxLayer(salarioBase);
        System.out.println("descontoIRRF = " + descontoIRRF);
        
        return descontoIRRF;
    }
}
