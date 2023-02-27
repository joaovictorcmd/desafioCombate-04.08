package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println();

        List<TaxPayer> list = new ArrayList<>();

        for (int i=0;i<n;i++) {
            System.out.printf("Digite os dados do %do contribuinte:\n", i + 1);
            System.out.print("Renda anual com salário: ");
            double salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            double servicesIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            double capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            double healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();

            TaxPayer tPayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
            list.add(tPayer);

            System.out.println();
        }

        System.out.println();

        for (int i=0;i<n;i++) {
            System.out.printf("Resumo do %do contribuinte:\n", i + 1);
            System.out.println(list.get(i).toString());
            System.out.println();
        }

        sc.close();
    }
}
