import net.sourceforge.jFuzzyLogic.*;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // Load from 'FCL' file
        String fileName = "fuzzy.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) {
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Show
        JFuzzyChart.get().chart(fis.getFunctionBlock("tipper"));

        // Set inputs
        fis.setVariable("salary", 15000);
        fis.setVariable("variableSalary", 5000);
        fis.setVariable("companyYears", 6);
        fis.setVariable("patrimonyValue", 400000);
        fis.setVariable("serasaPontuation", 850);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable salaryValue = fis.getFunctionBlock("tipper").getVariable("creditValue");
        JFuzzyChart.get().chart(salaryValue, salaryValue.getDefuzzifier(), true);

        System.out.println(salaryValue.getLatestDefuzzifiedValue());

        // Print ruleSet
//        System.out.println(fis);
    }
}
