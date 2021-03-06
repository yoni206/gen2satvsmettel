/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukavrona.language.Lukavrona;

import java.util.Map;
import mettel.core.tableau.MettelSubstitution;
public interface LukavronaSubstitution extends MettelSubstitution{

    Lukavrona_valuation get_valuation(Lukavrona_valuationVariable e);

    Map<Lukavrona_valuationVariable, Lukavrona_valuation> valuationMap();

    boolean append(Lukavrona_valuationVariable e0, Lukavrona_valuation e1);

    Lukavrona_formula get_formula(Lukavrona_formulaVariable e);

    Map<Lukavrona_formulaVariable, Lukavrona_formula> formulaMap();

    boolean append(Lukavrona_formulaVariable e0, Lukavrona_formula e1);

}
