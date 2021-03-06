/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukasiewicz.language.Lukasiewicz;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import mettel.core.tableau.MettelReplacement;
import mettel.core.tableau.MettelSubstitution;
import mettel.core.tableau.MettelExpression;

public class LukasiewiczTreeReplacement implements LukasiewiczReplacement{

    private class Pointer<T extends LukasiewiczExpression>{
        T expression = null;
        Pointer(T expression){
            super();
            this.expression = expression;
        }
        public int hashCode(){
            return expression.hashCode();
        }
    }

    private Comparator<LukasiewiczAbstractExpression> comparator = new LukasiewiczIDComparator();

    protected final Map<Lukasiewicz_valuation, Pointer<Lukasiewicz_valuation>> valuationMap = new TreeMap<Lukasiewicz_valuation, Pointer<Lukasiewicz_valuation>>();
    public Lukasiewicz_valuation get_valuation(Lukasiewicz_valuation e){
        final Pointer<Lukasiewicz_valuation> p = valuationMap.get(e);
        return p == null? null: p.expression;
    }

    public Set<Lukasiewicz_valuation> valuationKeys(){
        return valuationMap.keySet();
    }

    public boolean append(Lukasiewicz_valuation e0, Lukasiewicz_valuation e1){
        if(e0 == null || e1 == null){ return false; }
        final int CMP = comparator.compare((LukasiewiczAbstractExpression)e0,(LukasiewiczAbstractExpression)e1);
        if(CMP == 0) return false;
            Lukasiewicz_valuation left = null;
            Lukasiewicz_valuation right = null;
            if(CMP > 0){
                left = e0;
                right = e1;
            }else{
                left = e1;
                right = e0;
            }
            final Pointer<Lukasiewicz_valuation> entry = valuationMap.get(left);
            if(entry == null){
                final Pointer<Lukasiewicz_valuation> rEntry = valuationMap.get(right);
                if(rEntry == null) {
                    valuationMap.put(left, new Pointer<Lukasiewicz_valuation>(right));
                }else{
                    valuationMap.put(left, rEntry);
                }
                return true;
            }else{
                final Lukasiewicz_valuation third = entry.expression;
                final int CMP0 = comparator.compare((LukasiewiczAbstractExpression)right, (LukasiewiczAbstractExpression)third);
                if(CMP0 == 0) return false;
                if(CMP0 > 0){
                    valuationMap.put(right, entry);
                    return true;
                }else{
                    entry.expression = right;
                    valuationMap.put(third, entry);
                    return true;
                }
            }
        }

        protected final Map<Lukasiewicz_formula, Pointer<Lukasiewicz_formula>> formulaMap = new TreeMap<Lukasiewicz_formula, Pointer<Lukasiewicz_formula>>();
        public Lukasiewicz_formula get_formula(Lukasiewicz_formula e){
            final Pointer<Lukasiewicz_formula> p = formulaMap.get(e);
            return p == null? null: p.expression;
        }

        public Set<Lukasiewicz_formula> formulaKeys(){
            return formulaMap.keySet();
        }

        public boolean append(Lukasiewicz_formula e0, Lukasiewicz_formula e1){
            if(e0 == null || e1 == null){ return false; }
            final int CMP = comparator.compare((LukasiewiczAbstractExpression)e0,(LukasiewiczAbstractExpression)e1);
            if(CMP == 0) return false;
                Lukasiewicz_formula left = null;
                Lukasiewicz_formula right = null;
                if(CMP > 0){
                    left = e0;
                    right = e1;
                }else{
                    left = e1;
                    right = e0;
                }
                final Pointer<Lukasiewicz_formula> entry = formulaMap.get(left);
                if(entry == null){
                    final Pointer<Lukasiewicz_formula> rEntry = formulaMap.get(right);
                    if(rEntry == null) {
                        formulaMap.put(left, new Pointer<Lukasiewicz_formula>(right));
                    }else{
                        formulaMap.put(left, rEntry);
                    }
                    return true;
                }else{
                    final Lukasiewicz_formula third = entry.expression;
                    final int CMP0 = comparator.compare((LukasiewiczAbstractExpression)right, (LukasiewiczAbstractExpression)third);
                    if(CMP0 == 0) return false;
                    if(CMP0 > 0){
                        formulaMap.put(right, entry);
                        return true;
                    }else{
                        entry.expression = right;
                        formulaMap.put(third, entry);
                        return true;
                    }
                }
            }

            public boolean isEmpty(){
                return valuationMap.isEmpty() && formulaMap.isEmpty();
            }

            public boolean append(MettelExpression e0, MettelExpression e1){
                if(e0 instanceof Lukasiewicz_valuation){ return append((Lukasiewicz_valuation)e0, (Lukasiewicz_valuation)e1); }
                if(e0 instanceof Lukasiewicz_formula){ return append((Lukasiewicz_formula)e0, (Lukasiewicz_formula)e1); }
                return false;
            }

            public boolean append(MettelReplacement r){
                if(r == null){ return false; }
                return append((LukasiewiczReplacement)r);
            }

            public MettelExpression rewrite(MettelExpression e) {
                if(e instanceof Lukasiewicz_valuation){
                    return ((Lukasiewicz_valuation)e).rewrite(this);
                }
                if(e instanceof Lukasiewicz_formula){
                    return ((Lukasiewicz_formula)e).rewrite(this);
                }
                return null;
            }

            public MettelSubstitution rewrite(MettelSubstitution s) {
                final LukasiewiczSubstitution s0 = (LukasiewiczSubstitution)s;
                LukasiewiczSubstitution res = new LukasiewiczTreeSubstitution();
                final Set<Entry<Lukasiewicz_valuationVariable, Lukasiewicz_valuation>> valuationEntrySet = s0.valuationMap().entrySet();
                for(Entry<Lukasiewicz_valuationVariable, Lukasiewicz_valuation> entry:valuationEntrySet){
                    res.append(entry.getKey(),(Lukasiewicz_valuation)rewrite(entry.getValue()));
                }
                final Set<Entry<Lukasiewicz_formulaVariable, Lukasiewicz_formula>> formulaEntrySet = s0.formulaMap().entrySet();
                for(Entry<Lukasiewicz_formulaVariable, Lukasiewicz_formula> entry:formulaEntrySet){
                    res.append(entry.getKey(),(Lukasiewicz_formula)rewrite(entry.getValue()));
                }
                return res;
            }

            public boolean append(LukasiewiczReplacement r){
                boolean result = false;
                final Set<Lukasiewicz_valuation> valuationKeys = r.valuationKeys();
                for(Lukasiewicz_valuation key:valuationKeys){
                    result |= append(key, r.get_valuation(key));
                }
                final Set<Lukasiewicz_formula> formulaKeys = r.formulaKeys();
                for(Lukasiewicz_formula key:formulaKeys){
                    result |= append(key, r.get_formula(key));
                }
                return result;
            }

            private int hashCode = 0;
            public int hashCode(){
                hashCode = 1;
                hashCode = 31*hashCode + valuationMap.hashCode();
                hashCode = 31*hashCode + formulaMap.hashCode();
                return hashCode;
            }

            public int compareTo(MettelReplacement r){
                if(r == this){ return 0; }
                final Set<Lukasiewicz_valuation> keys_valuation0 = valuationMap.keySet();
                final Set<Lukasiewicz_valuation> keys_valuation1 = ((LukasiewiczReplacement)r).valuationKeys();
                final TreeSet<Lukasiewicz_valuation> keys_valuation = new TreeSet<Lukasiewicz_valuation>(keys_valuation0);
                keys_valuation.addAll(keys_valuation1);
                for(Lukasiewicz_valuation key:keys_valuation){
                    if(!keys_valuation0.contains(key)){
                        return 1;
                    }else{
                        if(!keys_valuation1.contains(key)){
                            return -1;
                        }else{
                            final Lukasiewicz_valuation v0 = valuationMap.get(key).expression;
                            final Lukasiewicz_valuation v1 = ((LukasiewiczReplacement)r).get_valuation(key);
                            final int result = v0.compareTo(v1);
                            if(result != 0){ return result; }
                        }
                    }
                }
                final Set<Lukasiewicz_formula> keys_formula0 = formulaMap.keySet();
                final Set<Lukasiewicz_formula> keys_formula1 = ((LukasiewiczReplacement)r).formulaKeys();
                final TreeSet<Lukasiewicz_formula> keys_formula = new TreeSet<Lukasiewicz_formula>(keys_formula0);
                keys_formula.addAll(keys_formula1);
                for(Lukasiewicz_formula key:keys_formula){
                    if(!keys_formula0.contains(key)){
                        return 1;
                    }else{
                        if(!keys_formula1.contains(key)){
                            return -1;
                        }else{
                            final Lukasiewicz_formula v0 = formulaMap.get(key).expression;
                            final Lukasiewicz_formula v1 = ((LukasiewiczReplacement)r).get_formula(key);
                            final int result = v0.compareTo(v1);
                            if(result != 0){ return result; }
                        }
                    }
                }
                return 0;
            }

            public boolean equals(Object o){
                if(o == this){ return true; }
                if(!(o instanceof LukasiewiczReplacement)){ return false; }
                final LukasiewiczReplacement r = (LukasiewiczReplacement)o;
                final Set<Lukasiewicz_valuation> valuationKeys = valuationMap.keySet();
                if(!valuationKeys.equals(r.valuationKeys())) return false;
                for(Lukasiewicz_valuation key:valuationKeys){
                    final Lukasiewicz_valuation v = valuationMap.get(key).expression;
                    if(!v.equals(r.get_valuation(key))) return false;
                }
                final Set<Lukasiewicz_formula> formulaKeys = formulaMap.keySet();
                if(!formulaKeys.equals(r.formulaKeys())) return false;
                for(Lukasiewicz_formula key:formulaKeys){
                    final Lukasiewicz_formula v = formulaMap.get(key).expression;
                    if(!v.equals(r.get_formula(key))) return false;
                }
                return true;
            }

            public String toString(){
                StringBuilder b = new StringBuilder();
                b.append("$[");
                boolean notFirst = false;
                final Set<Entry<Lukasiewicz_valuation, Pointer<Lukasiewicz_valuation>>> valuationEntrySet = valuationMap.entrySet();
                for(Entry<Lukasiewicz_valuation, Pointer<Lukasiewicz_valuation>> entry:valuationEntrySet){
                    if(notFirst){
                        b.append(", ");
                    }else{
                        notFirst = true;
                    }
                    b.append(entry.getKey());
                    b.append('/');
                    b.append(entry.getValue().expression);
                }
                final Set<Entry<Lukasiewicz_formula, Pointer<Lukasiewicz_formula>>> formulaEntrySet = formulaMap.entrySet();
                for(Entry<Lukasiewicz_formula, Pointer<Lukasiewicz_formula>> entry:formulaEntrySet){
                    if(notFirst){
                        b.append(", ");
                    }else{
                        notFirst = true;
                    }
                    b.append(entry.getKey());
                    b.append('/');
                    b.append(entry.getValue().expression);
                }
                b.append(']');
                return b.toString();
            }

}
