/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukavron.language.Lukavron;

import java.util.Comparator;

import mettel.core.tableau.MettelExpression;

public class Lukavron_true_valuation extends LukavronAbstractExpression implements Lukavron_valuation{

    static final int PRIORITY = 1;
    private final int LENGTH;
    protected Lukavron_formula e0 = null;

    public Lukavron_true_valuation(Lukavron_formula e0, LukavronObjectFactory f){
        super(f);
        int l = 1;
        this.e0 = e0;
        l += e0.length();
        LENGTH = l;
    }

    int sortId(){ return SORTID; }

    int priority(){ return PRIORITY; }

    public int length(){ return LENGTH; }

    public LukavronSubstitution match(LukavronExpression e){
        LukavronSubstitution s = new LukavronTreeSubstitution();
        if(match(e,s)){
            return factory.getSubstitution(s);
        }else{ return null; }
    }

    public boolean match(LukavronExpression e, LukavronSubstitution s){
        if(!(e instanceof Lukavron_true_valuation)){ return false;}
        final Lukavron_true_valuation ee = (Lukavron_true_valuation)e;
        return e0.match(ee.e0, s);
    }

    public LukavronExpression substitute(LukavronSubstitution s){
        return factory.create_true_valuation((Lukavron_formula)e0.substitute(s));
    }

    public LukavronExpression rewrite(LukavronReplacement s){
        LukavronExpression e = s.get_valuation(this);
        if(e != null){ return e; }
        final Lukavron_valuation ee = factory.create_true_valuation((Lukavron_formula)e0.rewrite(s));
        e = s.get_valuation(ee);
        if(e == null){ return ee; }else{ return e; }
    }

    private int hashCode = 0;
    public int hashCode(){
        if(hashCode == 0){
            hashCode = 31*SORTID + PRIORITY;
            hashCode = 31*hashCode + e0.hashCode();
        }
        return hashCode;
    }

    public boolean equals(Object o){
        if(o == this){ return true; }
        if(!(o instanceof Lukavron_true_valuation)){ return false; }
        Lukavron_true_valuation e = (Lukavron_true_valuation) o;
        return (e0.equals(e.e0));
    }

    int compareArgumentsTo(LukavronAbstractExpression e, Comparator<LukavronAbstractExpression> c){
        int result = 0;
        result = c.compare((LukavronAbstractExpression)e0, e);
        if(result >= 0){ return 1; }
        return 0;
    }
    int compareArguments(LukavronAbstractExpression e, Comparator<LukavronAbstractExpression> c){
        final Lukavron_true_valuation ee = (Lukavron_true_valuation)e;
        int result = 0;
        result = c.compare((LukavronAbstractExpression)e0, (LukavronAbstractExpression)ee.e0);
        if(result != 0){ return result; }
        return 0;
    }
    public int compareTo(MettelExpression e){
        if(e == this){ return 0; }
        if(!(e instanceof Lukavron_valuation)){ return SORTID - ((LukavronAbstractExpression)e).sortId(); }
        if(e instanceof Lukavron_valuationVariable){ return 1; }
        if(!(e instanceof Lukavron_true_valuation)){ return PRIORITY - ((LukavronAbstractExpression)e).priority(); }
        Lukavron_true_valuation ee = (Lukavron_true_valuation) e;
        int result = 0;
        result = e0.compareTo(ee.e0);
        if(result != 0){ return result; }
        return 0;
    }


    private String str = null;
    public String toString(){
        if(str == null){
            StringBuilder b = new StringBuilder();
            b.append('(');
            b.append(' ');
            b.append('T');
            b.append(' ');
            b.append(e0);
            b.append(' ');
            b.append(')');
            str = b.toString();
        }
        return str;
    }
}
