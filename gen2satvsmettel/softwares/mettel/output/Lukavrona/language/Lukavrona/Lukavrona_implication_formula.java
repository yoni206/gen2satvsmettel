/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukavrona.language.Lukavrona;

import java.util.Comparator;

import mettel.core.tableau.MettelExpression;

public class Lukavrona_implication_formula extends LukavronaAbstractExpression implements Lukavrona_formula{

    static final int PRIORITY = 6;
    private final int LENGTH;
    protected Lukavrona_formula e0 = null;
    protected Lukavrona_formula e1 = null;

    public Lukavrona_implication_formula(Lukavrona_formula e0, Lukavrona_formula e1, LukavronaObjectFactory f){
        super(f);
        int l = 1;
        this.e0 = e0;
        l += e0.length();
        this.e1 = e1;
        l += e1.length();
        LENGTH = l;
    }

    int sortId(){ return SORTID; }

    int priority(){ return PRIORITY; }

    public int length(){ return LENGTH; }

    public LukavronaSubstitution match(LukavronaExpression e){
        LukavronaSubstitution s = new LukavronaTreeSubstitution();
        if(match(e,s)){
            return factory.getSubstitution(s);
        }else{ return null; }
    }

    public boolean match(LukavronaExpression e, LukavronaSubstitution s){
        if(!(e instanceof Lukavrona_implication_formula)){ return false;}
        final Lukavrona_implication_formula ee = (Lukavrona_implication_formula)e;
        return e0.match(ee.e0, s) && e1.match(ee.e1, s);
    }

    public LukavronaExpression substitute(LukavronaSubstitution s){
        return factory.create_implication_formula((Lukavrona_formula)e0.substitute(s), (Lukavrona_formula)e1.substitute(s));
    }

    public LukavronaExpression rewrite(LukavronaReplacement s){
        LukavronaExpression e = s.get_formula(this);
        if(e != null){ return e; }
        final Lukavrona_formula ee = factory.create_implication_formula((Lukavrona_formula)e0.rewrite(s), (Lukavrona_formula)e1.rewrite(s));
        e = s.get_formula(ee);
        if(e == null){ return ee; }else{ return e; }
    }

    private int hashCode = 0;
    public int hashCode(){
        if(hashCode == 0){
            hashCode = 31*SORTID + PRIORITY;
            hashCode = 31*hashCode + e0.hashCode();
            hashCode = 31*hashCode + e1.hashCode();
        }
        return hashCode;
    }

    public boolean equals(Object o){
        if(o == this){ return true; }
        if(!(o instanceof Lukavrona_implication_formula)){ return false; }
        Lukavrona_implication_formula e = (Lukavrona_implication_formula) o;
        return (e0.equals(e.e0)) && (e1.equals(e.e1));
    }

    int compareArgumentsTo(LukavronaAbstractExpression e, Comparator<LukavronaAbstractExpression> c){
        int result = 0;
        result = c.compare((LukavronaAbstractExpression)e0, e);
        if(result >= 0){ return 1; }
        result = c.compare((LukavronaAbstractExpression)e1, e);
        if(result >= 0){ return 1; }
        return 0;
    }
    int compareArguments(LukavronaAbstractExpression e, Comparator<LukavronaAbstractExpression> c){
        final Lukavrona_implication_formula ee = (Lukavrona_implication_formula)e;
        int result = 0;
        result = c.compare((LukavronaAbstractExpression)e0, (LukavronaAbstractExpression)ee.e0);
        if(result != 0){ return result; }
        result = c.compare((LukavronaAbstractExpression)e1, (LukavronaAbstractExpression)ee.e1);
        if(result != 0){ return result; }
        return 0;
    }
    public int compareTo(MettelExpression e){
        if(e == this){ return 0; }
        if(!(e instanceof Lukavrona_formula)){ return SORTID - ((LukavronaAbstractExpression)e).sortId(); }
        if(e instanceof Lukavrona_formulaVariable){ return 1; }
        if(!(e instanceof Lukavrona_implication_formula)){ return PRIORITY - ((LukavronaAbstractExpression)e).priority(); }
        Lukavrona_implication_formula ee = (Lukavrona_implication_formula) e;
        int result = 0;
        result = e0.compareTo(ee.e0);
        if(result != 0){ return result; }
        result = e1.compareTo(ee.e1);
        if(result != 0){ return result; }
        return 0;
    }


    private String str = null;
    public String toString(){
        if(str == null){
            StringBuilder b = new StringBuilder();
            b.append('(');
            b.append(' ');
            b.append(e0);
            b.append(' ');
            b.append("->");
            b.append(' ');
            b.append(e1);
            b.append(' ');
            b.append(')');
            str = b.toString();
        }
        return str;
    }
}
