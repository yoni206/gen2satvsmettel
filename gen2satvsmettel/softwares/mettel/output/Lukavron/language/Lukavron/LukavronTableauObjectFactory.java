/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukavron.language.Lukavron;

import mettel.core.tableau.MettelTableauObjectFactory;
import mettel.core.tableau.MettelReplacement;

public class LukavronTableauObjectFactory implements MettelTableauObjectFactory{

    public MettelReplacement createReplacement(){
        return new LukavronTreeReplacement();
    }

}
