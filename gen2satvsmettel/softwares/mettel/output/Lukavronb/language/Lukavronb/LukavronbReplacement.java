/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukavronb.language.Lukavronb;

import java.util.Set;
import mettel.core.tableau.MettelReplacement;

public interface LukavronbReplacement extends MettelReplacement{

    Lukavronb_valuation get_valuation(Lukavronb_valuation e);

    Set<Lukavronb_valuation> valuationKeys();

    boolean append(Lukavronb_valuation e0, Lukavronb_valuation e1);

    Lukavronb_formula get_formula(Lukavronb_formula e);

    Set<Lukavronb_formula> formulaKeys();

    boolean append(Lukavronb_formula e0, Lukavronb_formula e1);

    boolean append(LukavronbReplacement r);

}
