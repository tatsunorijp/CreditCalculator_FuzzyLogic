import controller.CreditLimitController;
import model.CreditLimitModel;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        CreditLimitModel credit = new CreditLimitModel();
//        Double result;
//
//        System.out.println("Digite o seu salário");
//        credit.setSalary(scanner.nextDouble());
//
//        System.out.println("Digite tal coisa");
//        credit.setVariableSalary(scanner.nextDouble());
//
//        System.out.println("Digite tal coisa");
//        credit.setCompanyYears(scanner.nextDouble());
//
//        System.out.println("Digite tal coisa");
//        credit.setPatrimonyValue(scanner.nextDouble());
//
//        System.out.println("Digite tal coisa");
//        credit.setSerasaPontuation(scanner.nextDouble());

//        result = CreditLimitController.calculateCreditLimit(credit);

//        System.out.println(result);

        String fileName = "src/fuzzy.fcl";
        FIS fis = FIS.load(fileName,true);

        if( fis == null ) {
            System.err.println("Can't load file: '" + fileName + "'");
            return ;
        }

        // Show
        JFuzzyChart.get().chart(fis.getFunctionBlock("tipper"));

        // Set inputs
        fis.setVariable("salary", 10000);
        fis.setVariable("variableSalary", 5000);
        fis.setVariable("companyYears", 5);
        fis.setVariable("patrimonyValue", 400000);
        fis.setVariable("serasaPontuation", 850);

        fis.evaluate();

        // Show output variable's chart
        Variable salaryValue = fis.getFunctionBlock("tipper").getVariable("creditValue");
        JFuzzyChart.get().chart(salaryValue, salaryValue.getDefuzzifier(), true);

        System.out.println();
        System.out.println(salaryValue.toStringFcl());



//        fis.getFunctionBlock("creditCalculator").getVariable("creditValue").

        // Print ruleSet
//        System.out.println(fis);

//        return salaryValue.getLatestDefuzzifiedValue();
    }
}
