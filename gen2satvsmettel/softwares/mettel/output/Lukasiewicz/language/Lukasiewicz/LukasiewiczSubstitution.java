/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukasiewicz.language.Lukasiewicz;

import java.util.Map;
import mettel.core.tableau.MettelSubstitution;
public interface LukasiewiczSubstitution extends MettelSubstitution{

    Lukasiewicz_valuation get_valuation(Lukasiewicz_valuationVariable e);

    Map<Lukasiewicz_valuationVariable, Lukasiewicz_valuation> valuationMap();

    boolean append(Lukasiewicz_valuationVariable e0, Lukasiewicz_valuation e1);

    Lukasiewicz_formula get_formula(Lukasiewicz_formulaVariable e);

    Map<Lukasiewicz_formulaVariable, Lukasiewicz_formula> formulaMap();

    boolean append(Lukasiewicz_formulaVariable e0, Lukasiewicz_formula e1);

}
