/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukavron.language.Lukavron;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import mettel.core.tableau.MettelReplacement;
import mettel.core.tableau.MettelSubstitution;
import mettel.core.tableau.MettelExpression;

public class LukavronTreeReplacement implements LukavronReplacement{

    private class Pointer<T extends LukavronExpression>{
        T expression = null;
        Pointer(T expression){
            super();
            this.expression = expression;
        }
        public int hashCode(){
            return expression.hashCode();
        }
    }

    private Comparator<LukavronAbstractExpression> comparator = new LukavronIDComparator();

    protected final Map<Lukavron_valuation, Pointer<Lukavron_valuation>> valuationMap = new TreeMap<Lukavron_valuation, Pointer<Lukavron_valuation>>();
    public Lukavron_valuation get_valuation(Lukavron_valuation e){
        final Pointer<Lukavron_valuation> p = valuationMap.get(e);
        return p == null? null: p.expression;
    }

    public Set<Lukavron_valuation> valuationKeys(){
        return valuationMap.keySet();
    }

    public boolean append(Lukavron_valuation e0, Lukavron_valuation e1){
        if(e0 == null || e1 == null){ return false; }
        final int CMP = comparator.compare((LukavronAbstractExpression)e0,(LukavronAbstractExpression)e1);
        if(CMP == 0) return false;
            Lukavron_valuation left = null;
            Lukavron_valuation right = null;
            if(CMP > 0){
                left = e0;
                right = e1;
            }else{
                left = e1;
                right = e0;
            }
            final Pointer<Lukavron_valuation> entry = valuationMap.get(left);
            if(entry == null){
                final Pointer<Lukavron_valuation> rEntry = valuationMap.get(right);
                if(rEntry == null) {
                    valuationMap.put(left, new Pointer<Lukavron_valuation>(right));
                }else{
                    valuationMap.put(left, rEntry);
                }
                return true;
            }else{
                final Lukavron_valuation third = entry.expression;
                final int CMP0 = comparator.compare((LukavronAbstractExpression)right, (LukavronAbstractExpression)third);
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

        protected final Map<Lukavron_formula, Pointer<Lukavron_formula>> formulaMap = new TreeMap<Lukavron_formula, Pointer<Lukavron_formula>>();
        public Lukavron_formula get_formula(Lukavron_formula e){
            final Pointer<Lukavron_formula> p = formulaMap.get(e);
            return p == null? null: p.expression;
        }

        public Set<Lukavron_formula> formulaKeys(){
            return formulaMap.keySet();
        }

        public boolean append(Lukavron_formula e0, Lukavron_formula e1){
            if(e0 == null || e1 == null){ return false; }
            final int CMP = comparator.compare((LukavronAbstractExpression)e0,(LukavronAbstractExpression)e1);
            if(CMP == 0) return false;
                Lukavron_formula left = null;
                Lukavron_formula right = null;
                if(CMP > 0){
                    left = e0;
                    right = e1;
                }else{
                    left = e1;
                    right = e0;
                }
                final Pointer<Lukavron_formula> entry = formulaMap.get(left);
                if(entry == null){
                    final Pointer<Lukavron_formula> rEntry = formulaMap.get(right);
                    if(rEntry == null) {
                        formulaMap.put(left, new Pointer<Lukavron_formula>(right));
                    }else{
                        formulaMap.put(left, rEntry);
                    }
                    return true;
                }else{
                    final Lukavron_formula third = entry.expression;
                    final int CMP0 = comparator.compare((LukavronAbstractExpression)right, (LukavronAbstractExpression)third);
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
                if(e0 instanceof Lukavron_valuation){ return append((Lukavron_valuation)e0, (Lukavron_valuation)e1); }
                if(e0 instanceof Lukavron_formula){ return append((Lukavron_formula)e0, (Lukavron_formula)e1); }
                return false;
            }

            public boolean append(MettelReplacement r){
                if(r == null){ return false; }
                return append((LukavronReplacement)r);
            }

            public MettelExpression rewrite(MettelExpression e) {
                if(e instanceof Lukavron_valuation){
                    return ((Lukavron_valuation)e).rewrite(this);
                }
                if(e instanceof Lukavron_formula){
                    return ((Lukavron_formula)e).rewrite(this);
                }
                return null;
            }

            public MettelSubstitution rewrite(MettelSubstitution s) {
                final LukavronSubstitution s0 = (LukavronSubstitution)s;
                LukavronSubstitution res = new LukavronTreeSubstitution();
                final Set<Entry<Lukavron_valuationVariable, Lukavron_valuation>> valuationEntrySet = s0.valuationMap().entrySet();
                for(Entry<Lukavron_valuationVariable, Lukavron_valuation> entry:valuationEntrySet){
                    res.append(entry.getKey(),(Lukavron_valuation)rewrite(entry.getValue()));
                }
                final Set<Entry<Lukavron_formulaVariable, Lukavron_formula>> formulaEntrySet = s0.formulaMap().entrySet();
                for(Entry<Lukavron_formulaVariable, Lukavron_formula> entry:formulaEntrySet){
                    res.append(entry.getKey(),(Lukavron_formula)rewrite(entry.getValue()));
                }
                return res;
            }

            public boolean append(LukavronReplacement r){
                boolean result = false;
                final Set<Lukavron_valuation> valuationKeys = r.valuationKeys();
                for(Lukavron_valuation key:valuationKeys){
                    result |= append(key, r.get_valuation(key));
                }
                final Set<Lukavron_formula> formulaKeys = r.formulaKeys();
                for(Lukavron_formula key:formulaKeys){
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
                final Set<Lukavron_valuation> keys_valuation0 = valuationMap.keySet();
                final Set<Lukavron_valuation> keys_valuation1 = ((LukavronReplacement)r).valuationKeys();
                final TreeSet<Lukavron_valuation> keys_valuation = new TreeSet<Lukavron_valuation>(keys_valuation0);
                keys_valuation.addAll(keys_valuation1);
                for(Lukavron_valuation key:keys_valuation){
                    if(!keys_valuation0.contains(key)){
                        return 1;
                    }else{
                        if(!keys_valuation1.contains(key)){
                            return -1;
                        }else{
                            final Lukavron_valuation v0 = valuationMap.get(key).expression;
                            final Lukavron_valuation v1 = ((LukavronReplacement)r).get_valuation(key);
                            final int result = v0.compareTo(v1);
                            if(result != 0){ return result; }
                        }
                    }
                }
                final Set<Lukavron_formula> keys_formula0 = formulaMap.keySet();
                final Set<Lukavron_formula> keys_formula1 = ((LukavronReplacement)r).formulaKeys();
                final TreeSet<Lukavron_formula> keys_formula = new TreeSet<Lukavron_formula>(keys_formula0);
                keys_formula.addAll(keys_formula1);
                for(Lukavron_formula key:keys_formula){
                    if(!keys_formula0.contains(key)){
                        return 1;
                    }else{
                        if(!keys_formula1.contains(key)){
                            return -1;
                        }else{
                            final Lukavron_formula v0 = formulaMap.get(key).expression;
                            final Lukavron_formula v1 = ((LukavronReplacement)r).get_formula(key);
                            final int result = v0.compareTo(v1);
                            if(result != 0){ return result; }
                        }
                    }
                }
                return 0;
            }

            public boolean equals(Object o){
                if(o == this){ return true; }
                if(!(o instanceof LukavronReplacement)){ return false; }
                final LukavronReplacement r = (LukavronReplacement)o;
                final Set<Lukavron_valuation> valuationKeys = valuationMap.keySet();
                if(!valuationKeys.equals(r.valuationKeys())) return false;
                for(Lukavron_valuation key:valuationKeys){
                    final Lukavron_valuation v = valuationMap.get(key).expression;
                    if(!v.equals(r.get_valuation(key))) return false;
                }
                final Set<Lukavron_formula> formulaKeys = formulaMap.keySet();
                if(!formulaKeys.equals(r.formulaKeys())) return false;
                for(Lukavron_formula key:formulaKeys){
                    final Lukavron_formula v = formulaMap.get(key).expression;
                    if(!v.equals(r.get_formula(key))) return false;
                }
                return true;
            }

            public String toString(){
                StringBuilder b = new StringBuilder();
                b.append("$[");
                boolean notFirst = false;
                final Set<Entry<Lukavron_valuation, Pointer<Lukavron_valuation>>> valuationEntrySet = valuationMap.entrySet();
                for(Entry<Lukavron_valuation, Pointer<Lukavron_valuation>> entry:valuationEntrySet){
                    if(notFirst){
                        b.append(", ");
                    }else{
                        notFirst = true;
                    }
                    b.append(entry.getKey());
                    b.append('/');
                    b.append(entry.getValue().expression);
                }
                final Set<Entry<Lukavron_formula, Pointer<Lukavron_formula>>> formulaEntrySet = formulaMap.entrySet();
                for(Entry<Lukavron_formula, Pointer<Lukavron_formula>> entry:formulaEntrySet){
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
