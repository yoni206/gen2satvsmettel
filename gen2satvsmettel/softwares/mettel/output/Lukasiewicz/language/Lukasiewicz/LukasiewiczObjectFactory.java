/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukasiewicz.language.Lukasiewicz;

public interface LukasiewiczObjectFactory{

    final LukasiewiczObjectFactory DEFAULT = new LukasiewiczDefaultObjectFactory();

    LukasiewiczReplacement getReplacement(LukasiewiczReplacement r);

    LukasiewiczSubstitution getSubstitution(LukasiewiczSubstitution s);

    Lukasiewicz_valuation create_true_valuation(Lukasiewicz_formula e0);    

    Lukasiewicz_valuation create_unknown_valuation(Lukasiewicz_formula e0);    

    Lukasiewicz_valuation create_false_valuation(Lukasiewicz_formula e0);    

    Lukasiewicz_formula create_negation_formula(Lukasiewicz_formula e0);    

    Lukasiewicz_formula create_conjunction_formula(Lukasiewicz_formula e0, Lukasiewicz_formula e1);    

    Lukasiewicz_formula create_disjunction_formula(Lukasiewicz_formula e0, Lukasiewicz_formula e1);    

    Lukasiewicz_formula create_implication_formula(Lukasiewicz_formula e0, Lukasiewicz_formula e1);    

    Lukasiewicz_valuationVariable create_valuationVariable(String name);

    Lukasiewicz_formulaVariable create_formulaVariable(String name);

}
