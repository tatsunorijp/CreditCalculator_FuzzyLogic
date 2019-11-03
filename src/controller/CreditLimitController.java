package controller;

import model.CreditLimitModel;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class CreditLimitController {

    public static double calculateCreditLimit(CreditLimitModel creditLimit) {
        String fileName = "src/fuzzy.fcl";
        FIS fis = FIS.load(fileName,true);

        if( fis == null ) {
            System.err.println("Can't load file: '" + fileName + "'");
            return 0;
        }

        // Show
        JFuzzyChart.get().chart(fis.getFunctionBlock("creditcalculator"));

        // Set inputs
        fis.setVariable("salary", creditLimit.getSalary());
        fis.setVariable("variableSalary", creditLimit.getVariableSalary());
        fis.setVariable("companyYears", creditLimit.getCompanyYears());
        fis.setVariable("patrimonyValue", creditLimit.getPatrimonyValue());
        fis.setVariable("serasaPontuation", creditLimit.getSerasaPontuation());

        fis.evaluate();

        // Show output variable's chart
        Variable salaryValue = fis.getFunctionBlock("creditCalculator").getVariable("creditcalculator");
        JFuzzyChart.get().chart(salaryValue, salaryValue.getDefuzzifier(), true);

        // Print ruleSet
//        System.out.println(fis);

        return salaryValue.getLatestDefuzzifiedValue();
    }
}
