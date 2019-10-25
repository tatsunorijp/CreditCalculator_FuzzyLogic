import net.sourceforge.jFuzzyLogic.*;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;


public class Main {

    public static void main(String[] args) {
	// write your code here

        // Load from 'FCL' file
        String fileName = "tipp.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) {
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Show
        JFuzzyChart.get().chart(fis.getFunctionBlock("tipper"));

        // Set inputs
        fis.setVariable("service", 3);
        fis.setVariable("food", 7);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable tip = fis.getFunctionBlock("tipper").getVariable("tip");
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        // Print ruleSet
        System.out.println(fis);
    }
}
