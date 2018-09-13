/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukasiewicz.language.Lukasiewicz;

import java.util.Comparator;

import mettel.core.tableau.MettelExpression;

public class Lukasiewicz_valuationVariable extends LukasiewiczAbstractVariable implements Lukasiewicz_valuation{

    public Lukasiewicz_valuationVariable(String name, LukasiewiczObjectFactory factory) {
        super(name, factory);
    }

    int sortId(){ return SORTID; }

    public LukasiewiczSubstitution match(LukasiewiczExpression e){
        LukasiewiczSubstitution s = new LukasiewiczTreeSubstitution();
        if(match(e,s)){
            return factory.getSubstitution(s);
        }else{ return null; }
    }

    public boolean match(LukasiewiczExpression e, LukasiewiczSubstitution s){
        if(!(e instanceof Lukasiewicz_valuation)){ return false; }
        return s.append(this,(Lukasiewicz_valuation)e);
    }

    public LukasiewiczExpression rewrite(LukasiewiczReplacement r) {
        Lukasiewicz_valuation e = r.get_valuation(this);
        return (e == null) ? this : e;
    }

    public LukasiewiczExpression substitute(LukasiewiczSubstitution s) {
        Lukasiewicz_valuation e = s.get_valuation(this);
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
        if(e instanceof Lukasiewicz_valuationVariable) return name.compareTo(((Lukasiewicz_valuationVariable)e).name());
        if(e instanceof Lukasiewicz_valuation) return -1;
        return SORTID - ((LukasiewiczAbstractExpression)e).sortId();
    }

    int compareArgumentsTo(LukasiewiczAbstractExpression e, Comparator<LukasiewiczAbstractExpression> c){return 0;}
    int compareArguments(LukasiewiczAbstractExpression e, Comparator<LukasiewiczAbstractExpression> c){return 0;}

    public boolean equals(Object o){
        if(o == this){ return true; }
        if(!(o instanceof Lukasiewicz_valuationVariable)){ return false; }
        return name.equals(((Lukasiewicz_valuationVariable)o).name());
    }

    public boolean isEquality(){
        return false;
    }
    public int length(){
        return 1;
    }
}
