/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukavrona.language.Lukavrona;

import java.util.Comparator;

import mettel.core.tableau.MettelExpression;

public class Lukavrona_valuationVariable extends LukavronaAbstractVariable implements Lukavrona_valuation{

    public Lukavrona_valuationVariable(String name, LukavronaObjectFactory factory) {
        super(name, factory);
    }

    int sortId(){ return SORTID; }

    public LukavronaSubstitution match(LukavronaExpression e){
        LukavronaSubstitution s = new LukavronaTreeSubstitution();
        if(match(e,s)){
            return factory.getSubstitution(s);
        }else{ return null; }
    }

    public boolean match(LukavronaExpression e, LukavronaSubstitution s){
        if(!(e instanceof Lukavrona_valuation)){ return false; }
        return s.append(this,(Lukavrona_valuation)e);
    }

    public LukavronaExpression rewrite(LukavronaReplacement r) {
        Lukavrona_valuation e = r.get_valuation(this);
        return (e == null) ? this : e;
    }

    public LukavronaExpression substitute(LukavronaSubstitution s) {
        Lukavrona_valuation e = s.get_valuation(this);
        return (e == null) ? this : e;
    }

    private int hashCode = 0;
    public int hashCode(){
        if(hashCode == 0){
            hashCode = 23*SORTID + name.hashCode();
        }
        return hashCode;
    }

    public int compareTo(MettelExpression e){
        if(e instanceof Lukavrona_valuationVariable) return name.compareTo(((Lukavrona_valuationVariable)e).name());
        if(e instanceof Lukavrona_valuation) return -1;
        return SORTID - ((LukavronaAbstractExpression)e).sortId();
    }

    int compareArgumentsTo(LukavronaAbstractExpression e, Comparator<LukavronaAbstractExpression> c){return 0;}
    int compareArguments(LukavronaAbstractExpression e, Comparator<LukavronaAbstractExpression> c){return 0;}

    public boolean equals(Object o){
        if(o == this){ return true; }
        if(!(o instanceof Lukavrona_valuationVariable)){ return false; }
        return name.equals(((Lukavrona_valuationVariable)o).name());
    }

    public boolean isEquality(){
        return false;
    }
    public int length(){
        return 1;
    }
}
