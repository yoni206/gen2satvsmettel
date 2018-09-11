/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukavronb.language.Lukavronb;


import java.io.InputStream;
import java.io.IOException;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Properties;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
public class LukavronbProblemAnalyzer{

    // UNLISTED_DEPTH must be lower than STARTING_DEPTH
    private final static int STARTING_DEPTH = 0;
    private final static int UNLISTED_DEPTH = -1;

    private static int currentDepth = STARTING_DEPTH - 1;

    private HashMap<String, Integer> valuationConnectivesOccurences = new HashMap<String, Integer>();
    private HashMap<String, Integer> valuationVariablesOccurences = new HashMap<String, Integer>();
    private HashMap<String, Integer> valuationConnectivesMaxDepth = new HashMap<String, Integer>();
    private HashMap<String, Integer> valuationVariablesMaxDepth = new HashMap<String, Integer>();

    private HashMap<String, Integer> formulaConnectivesOccurences = new HashMap<String, Integer>();
    private HashMap<String, Integer> formulaVariablesOccurences = new HashMap<String, Integer>();
    private HashMap<String, Integer> formulaConnectivesMaxDepth = new HashMap<String, Integer>();
    private HashMap<String, Integer> formulaVariablesMaxDepth = new HashMap<String, Integer>();

    private int totalSymbolsMaxLength = 0;
    public LukavronbProblemAnalyzer(String problemFile) throws IOException, RecognitionException{
        this(new FileInputStream(problemFile));
    }

    public LukavronbProblemAnalyzer(InputStream problemReader) throws IOException, RecognitionException{
        CharStream in = new ANTLRInputStream(problemReader);
        CommonTokenStream tokens = new CommonTokenStream();
        LukavronbParser parser = new LukavronbParser(tokens);
        tokens.setTokenSource(new LukavronbLexer(in));
        ArrayList<LukavronbExpression> list = parser.expressions();

        for (LukavronbExpression expression : list){
            if (totalSymbolsMaxLength < expression.length()){
                totalSymbolsMaxLength = expression.length();
            }
            determineSymbol(expression);
        }
    }

    private void determineSymbol(LukavronbExpression expression){
        currentDepth++;
        if (expression instanceof Lukavronb_valuation){
            if (expression instanceof Lukavronb_valuationVariable){
                Integer value;
                String variableName = ((Lukavronb_valuationVariable)expression).toString();
                if ((value = valuationVariablesOccurences.get(variableName)) == null){
                    valuationVariablesOccurences.put(variableName, 1);
                }else{
                    valuationVariablesOccurences.put(variableName, value + 1);
                }
                if (((value = valuationVariablesMaxDepth.get(variableName)) == null) || value < currentDepth){
                    valuationVariablesMaxDepth.put(variableName, currentDepth);
                }
            }else if (expression instanceof Lukavronb_true_valuation){
                update_valuationConnectiveOccurences("true");
                update_valuationConnectiveMaxDepth("true");
                determineSymbol(((Lukavronb_true_valuation)expression).e0);
            }else if (expression instanceof Lukavronb_false_valuation){
                update_valuationConnectiveOccurences("false");
                update_valuationConnectiveMaxDepth("false");
                determineSymbol(((Lukavronb_false_valuation)expression).e0);
            }
        }else         if (expression instanceof Lukavronb_formula){
            if (expression instanceof Lukavronb_formulaVariable){
                Integer value;
                String variableName = ((Lukavronb_formulaVariable)expression).toString();
                if ((value = formulaVariablesOccurences.get(variableName)) == null){
                    formulaVariablesOccurences.put(variableName, 1);
                }else{
                    formulaVariablesOccurences.put(variableName, value + 1);
                }
                if (((value = formulaVariablesMaxDepth.get(variableName)) == null) || value < currentDepth){
                    formulaVariablesMaxDepth.put(variableName, currentDepth);
                }
            }else if (expression instanceof Lukavronb_negation_formula){
                update_formulaConnectiveOccurences("negation");
                update_formulaConnectiveMaxDepth("negation");
                determineSymbol(((Lukavronb_negation_formula)expression).e0);
            }else if (expression instanceof Lukavronb_conjunction_formula){
                update_formulaConnectiveOccurences("conjunction");
                update_formulaConnectiveMaxDepth("conjunction");
                determineSymbol(((Lukavronb_conjunction_formula)expression).e0);
                determineSymbol(((Lukavronb_conjunction_formula)expression).e1);
            }else if (expression instanceof Lukavronb_disjunction_formula){
                update_formulaConnectiveOccurences("disjunction");
                update_formulaConnectiveMaxDepth("disjunction");
                determineSymbol(((Lukavronb_disjunction_formula)expression).e0);
                determineSymbol(((Lukavronb_disjunction_formula)expression).e1);
            }else if (expression instanceof Lukavronb_implication_formula){
                update_formulaConnectiveOccurences("implication");
                update_formulaConnectiveMaxDepth("implication");
                determineSymbol(((Lukavronb_implication_formula)expression).e0);
                determineSymbol(((Lukavronb_implication_formula)expression).e1);
            }
        }
        currentDepth--;
    }

    private void update_valuationConnectiveOccurences(String connective){
        Integer value;
        if ((value = valuationConnectivesOccurences.get(connective)) == null){
            valuationConnectivesOccurences.put(connective, 1);
        }else{
            valuationConnectivesOccurences.put(connective, value + 1);
        }
    }

    private void update_valuationConnectiveMaxDepth(String connective){
        Integer value;
        if (((value = valuationConnectivesMaxDepth.get(connective)) == null) || (value < currentDepth)){
            valuationConnectivesMaxDepth.put(connective, currentDepth);
        }
    }

    private void update_formulaConnectiveOccurences(String connective){
        Integer value;
        if ((value = formulaConnectivesOccurences.get(connective)) == null){
            formulaConnectivesOccurences.put(connective, 1);
        }else{
            formulaConnectivesOccurences.put(connective, value + 1);
        }
    }

    private void update_formulaConnectiveMaxDepth(String connective){
        Integer value;
        if (((value = formulaConnectivesMaxDepth.get(connective)) == null) || (value < currentDepth)){
            formulaConnectivesMaxDepth.put(connective, currentDepth);
        }
    }

    public Set<String> valuationVariablesNames(){
        return valuationVariablesOccurences.keySet();
    }

    public int totalNumberOf_valuationVariables(){
        return valuationVariablesOccurences.size();
    }

    public int totalNumberOf_valuationConnectives(){
        return valuationConnectivesOccurences.size();
    }

    public HashMap<String, Integer> valuationVariablesOccurences(){
        return valuationVariablesOccurences;
    }

    public HashMap<String, Integer> valuationVariablesMaxDepth(){
        return valuationVariablesMaxDepth;
    }

    private Integer total_valuationVariablesOccurences = null;

    public int total_valuationVariablesOccurences(){
        if (total_valuationVariablesOccurences != null){
            return total_valuationVariablesOccurences;
        }else{
            int sum = 0;
            for (int occurence : valuationVariablesOccurences.values()){
                sum += occurence;
            }
            total_valuationVariablesOccurences = new Integer(sum);
            return sum;
        }
    }

    private Integer total_valuationVariablesMaxDepth = null;

    public int total_valuationVariablesMaxDepth(){
        if (total_valuationVariablesMaxDepth != null){
            return total_valuationVariablesMaxDepth;
        }else{
            if (valuationVariablesMaxDepth.size() > 0){
                int total = Collections.max(valuationVariablesMaxDepth.values());
                total_valuationVariablesMaxDepth = new Integer(total);
                return total;
            }else{
                total_valuationVariablesMaxDepth = new Integer(UNLISTED_DEPTH);
                return UNLISTED_DEPTH;
            }
        }
    }

    private Integer total_valuationConnectivesOccurences = null;

    public int total_valuationConnectivesOccurences(){
        if (total_valuationConnectivesOccurences != null){
            return total_valuationConnectivesOccurences;
        }else{
            int sum = 0;
            for (int occurence : valuationConnectivesOccurences.values()){
                sum += occurence;
            }
            total_valuationConnectivesOccurences = new Integer(sum);
            return sum;
        }
    }

    private Integer total_valuationConnectivesMaxDepth = null;

    public int total_valuationConnectivesMaxDepth(){
        if (total_valuationConnectivesMaxDepth != null){
            return total_valuationConnectivesMaxDepth;
        }else{
            if (valuationConnectivesMaxDepth.size() > 0){
                int total = Collections.max(valuationConnectivesMaxDepth.values());
                total_valuationConnectivesMaxDepth = new Integer(total);
                return total;
            }else{
                total_valuationConnectivesMaxDepth = new Integer(UNLISTED_DEPTH);
                return UNLISTED_DEPTH;
            }
        }
    }

    public int true_valuationOccurences(){
        Integer result = valuationConnectivesOccurences.get("true");
        return result == null ? 0 : result;
    }

    public int true_valuationMaxDepth(){
        Integer result = valuationConnectivesMaxDepth.get("true");
        return result == null ? UNLISTED_DEPTH : result;
    }

    public int false_valuationOccurences(){
        Integer result = valuationConnectivesOccurences.get("false");
        return result == null ? 0 : result;
    }

    public int false_valuationMaxDepth(){
        Integer result = valuationConnectivesMaxDepth.get("false");
        return result == null ? UNLISTED_DEPTH : result;
    }

    public Set<String> formulaVariablesNames(){
        return formulaVariablesOccurences.keySet();
    }

    public int totalNumberOf_formulaVariables(){
        return formulaVariablesOccurences.size();
    }

    public int totalNumberOf_formulaConnectives(){
        return formulaConnectivesOccurences.size();
    }

    public HashMap<String, Integer> formulaVariablesOccurences(){
        return formulaVariablesOccurences;
    }

    public HashMap<String, Integer> formulaVariablesMaxDepth(){
        return formulaVariablesMaxDepth;
    }

    private Integer total_formulaVariablesOccurences = null;

    public int total_formulaVariablesOccurences(){
        if (total_formulaVariablesOccurences != null){
            return total_formulaVariablesOccurences;
        }else{
            int sum = 0;
            for (int occurence : formulaVariablesOccurences.values()){
                sum += occurence;
            }
            total_formulaVariablesOccurences = new Integer(sum);
            return sum;
        }
    }

    private Integer total_formulaVariablesMaxDepth = null;

    public int total_formulaVariablesMaxDepth(){
        if (total_formulaVariablesMaxDepth != null){
            return total_formulaVariablesMaxDepth;
        }else{
            if (formulaVariablesMaxDepth.size() > 0){
                int total = Collections.max(formulaVariablesMaxDepth.values());
                total_formulaVariablesMaxDepth = new Integer(total);
                return total;
            }else{
                total_formulaVariablesMaxDepth = new Integer(UNLISTED_DEPTH);
                return UNLISTED_DEPTH;
            }
        }
    }

    private Integer total_formulaConnectivesOccurences = null;

    public int total_formulaConnectivesOccurences(){
        if (total_formulaConnectivesOccurences != null){
            return total_formulaConnectivesOccurences;
        }else{
            int sum = 0;
            for (int occurence : formulaConnectivesOccurences.values()){
                sum += occurence;
            }
            total_formulaConnectivesOccurences = new Integer(sum);
            return sum;
        }
    }

    private Integer total_formulaConnectivesMaxDepth = null;

    public int total_formulaConnectivesMaxDepth(){
        if (total_formulaConnectivesMaxDepth != null){
            return total_formulaConnectivesMaxDepth;
        }else{
            if (formulaConnectivesMaxDepth.size() > 0){
                int total = Collections.max(formulaConnectivesMaxDepth.values());
                total_formulaConnectivesMaxDepth = new Integer(total);
                return total;
            }else{
                total_formulaConnectivesMaxDepth = new Integer(UNLISTED_DEPTH);
                return UNLISTED_DEPTH;
            }
        }
    }

    public int negation_formulaOccurences(){
        Integer result = formulaConnectivesOccurences.get("negation");
        return result == null ? 0 : result;
    }

    public int negation_formulaMaxDepth(){
        Integer result = formulaConnectivesMaxDepth.get("negation");
        return result == null ? UNLISTED_DEPTH : result;
    }

    public int conjunction_formulaOccurences(){
        Integer result = formulaConnectivesOccurences.get("conjunction");
        return result == null ? 0 : result;
    }

    public int conjunction_formulaMaxDepth(){
        Integer result = formulaConnectivesMaxDepth.get("conjunction");
        return result == null ? UNLISTED_DEPTH : result;
    }

    public int disjunction_formulaOccurences(){
        Integer result = formulaConnectivesOccurences.get("disjunction");
        return result == null ? 0 : result;
    }

    public int disjunction_formulaMaxDepth(){
        Integer result = formulaConnectivesMaxDepth.get("disjunction");
        return result == null ? UNLISTED_DEPTH : result;
    }

    public int implication_formulaOccurences(){
        Integer result = formulaConnectivesOccurences.get("implication");
        return result == null ? 0 : result;
    }

    public int implication_formulaMaxDepth(){
        Integer result = formulaConnectivesMaxDepth.get("implication");
        return result == null ? UNLISTED_DEPTH : result;
    }

    private Integer totalVariablesOccurences = null;

    public int totalVariablesOccurences(){
        if (totalVariablesOccurences != null){
            return totalVariablesOccurences;
        }else{
            int sum = 0;
            sum += total_valuationVariablesOccurences();
            sum += total_formulaVariablesOccurences();
            return sum;
        }
    }

    private Integer totalVariablesMaxDepth = null;

    public int totalVariablesMaxDepth(){
        if (totalVariablesMaxDepth != null){
            return totalVariablesMaxDepth;
        }else{
            int maxDepth = UNLISTED_DEPTH;
            int tempDepth = 0;
            tempDepth = total_valuationVariablesMaxDepth();
            maxDepth = maxDepth > tempDepth ? maxDepth : tempDepth;
            tempDepth = total_formulaVariablesMaxDepth();
            maxDepth = maxDepth > tempDepth ? maxDepth : tempDepth;
            return maxDepth;
        }
    }

    private Integer totalNumberOfVariables = null;

    public int totalNumberOfVariables(){
        if (totalNumberOfVariables != null){
            return totalNumberOfVariables;
        }else{
            int sum = 0;
            sum += totalNumberOf_valuationVariables();
            sum += totalNumberOf_formulaVariables();
            return sum;
        }
    }

    private Integer totalConnectivesOccurences = null;

    public int totalConnectivesOccurences(){
        if (totalConnectivesOccurences != null){
            return totalConnectivesOccurences;
        }else{
            int sum = 0;
            sum += total_valuationConnectivesOccurences();
            sum += total_formulaConnectivesOccurences();
            return sum;
        }
    }

    private Integer totalConnectivesMaxDepth = null;

    public int totalConnectivesMaxDepth(){
        if (totalConnectivesMaxDepth != null){
            return totalConnectivesMaxDepth;
        }else{
            int maxDepth = UNLISTED_DEPTH;
            int tempDepth = 0;
            tempDepth = total_valuationConnectivesMaxDepth();
            maxDepth = maxDepth > tempDepth ? maxDepth : tempDepth;
            tempDepth = total_formulaConnectivesMaxDepth();
            maxDepth = maxDepth > tempDepth ? maxDepth : tempDepth;
            return maxDepth;
        }
    }

    private Integer totalNumberOfConnectives = null;

    public int totalNumberOfConnectives(){
        if (totalNumberOfConnectives != null){
            return totalNumberOfConnectives;
        }else{
            int sum = 0;
            sum += totalNumberOf_valuationConnectives();
            sum += totalNumberOf_formulaConnectives();
            return sum;
        }
    }

    public int totalSymbolsMaxDepth(){
        return totalVariablesMaxDepth() > totalConnectivesMaxDepth() ? totalVariablesMaxDepth() : totalConnectivesMaxDepth();
    }

    public int totalSymbolsMaxLength(){
        return totalSymbolsMaxLength;
    }
    public Properties getStatistics(){
        Properties st = new Properties();

        st.setProperty("valuation.variable.names", variableNamesString(valuationVariablesNames()));
        st.setProperty("valuation.total.variable.number", String.valueOf(totalNumberOf_valuationVariables()));
        st.setProperty("valuation.total.connective.number", String.valueOf(totalNumberOf_valuationConnectives()));

        for (Map.Entry<String, Integer> entry : valuationVariablesOccurences().entrySet()){
            st.setProperty("valuation.variable.occurences." + entry.getKey(), String.valueOf(entry.getValue()));
        }
        for (Map.Entry<String, Integer> entry : valuationVariablesMaxDepth().entrySet()){
            st.setProperty("valuation.variable.max-depth." + entry.getKey(), String.valueOf(entry.getValue()));
        }

        st.setProperty("valuation.total.variable.occurences", String.valueOf(total_valuationVariablesOccurences()));
        st.setProperty("valuation.total.variable.max-depth", String.valueOf(total_valuationVariablesMaxDepth()));
        st.setProperty("valuation.total.connective.occurences", String.valueOf(total_valuationConnectivesOccurences()));
        st.setProperty("valuation.total.connective.max-depth", String.valueOf(total_valuationConnectivesMaxDepth()));
        st.setProperty("valuation.true.occurences", String.valueOf(true_valuationOccurences()));
        st.setProperty("valuation.true.max-depth", String.valueOf(true_valuationMaxDepth()));
        st.setProperty("valuation.false.occurences", String.valueOf(false_valuationOccurences()));
        st.setProperty("valuation.false.max-depth", String.valueOf(false_valuationMaxDepth()));
        st.setProperty("formula.variable.names", variableNamesString(formulaVariablesNames()));
        st.setProperty("formula.total.variable.number", String.valueOf(totalNumberOf_formulaVariables()));
        st.setProperty("formula.total.connective.number", String.valueOf(totalNumberOf_formulaConnectives()));

        for (Map.Entry<String, Integer> entry : formulaVariablesOccurences().entrySet()){
            st.setProperty("formula.variable.occurences." + entry.getKey(), String.valueOf(entry.getValue()));
        }
        for (Map.Entry<String, Integer> entry : formulaVariablesMaxDepth().entrySet()){
            st.setProperty("formula.variable.max-depth." + entry.getKey(), String.valueOf(entry.getValue()));
        }

        st.setProperty("formula.total.variable.occurences", String.valueOf(total_formulaVariablesOccurences()));
        st.setProperty("formula.total.variable.max-depth", String.valueOf(total_formulaVariablesMaxDepth()));
        st.setProperty("formula.total.connective.occurences", String.valueOf(total_formulaConnectivesOccurences()));
        st.setProperty("formula.total.connective.max-depth", String.valueOf(total_formulaConnectivesMaxDepth()));
        st.setProperty("formula.negation.occurences", String.valueOf(negation_formulaOccurences()));
        st.setProperty("formula.negation.max-depth", String.valueOf(negation_formulaMaxDepth()));
        st.setProperty("formula.conjunction.occurences", String.valueOf(conjunction_formulaOccurences()));
        st.setProperty("formula.conjunction.max-depth", String.valueOf(conjunction_formulaMaxDepth()));
        st.setProperty("formula.disjunction.occurences", String.valueOf(disjunction_formulaOccurences()));
        st.setProperty("formula.disjunction.max-depth", String.valueOf(disjunction_formulaMaxDepth()));
        st.setProperty("formula.implication.occurences", String.valueOf(implication_formulaOccurences()));
        st.setProperty("formula.implication.max-depth", String.valueOf(implication_formulaMaxDepth()));

        st.setProperty("total.variable.occurences", String.valueOf(totalVariablesOccurences()));
        st.setProperty("total.variable.max-depth", String.valueOf(totalVariablesMaxDepth()));
        st.setProperty("total.variable.number", String.valueOf(totalNumberOfVariables()));

        st.setProperty("total.connective.occurences", String.valueOf(totalConnectivesOccurences()));
        st.setProperty("total.connective.max-depth", String.valueOf(totalConnectivesMaxDepth()));
        st.setProperty("total.connective.number", String.valueOf(totalNumberOfConnectives()));

        st.setProperty("total.symbol.max-depth", String.valueOf(totalSymbolsMaxDepth()));
        st.setProperty("total.symbol.length", String.valueOf(totalSymbolsMaxLength()));

        return st;
    }

    private static String variableNamesString(Set<String> variableSet){
        StringBuilder variableNames = new StringBuilder();
        boolean notStart = false;
        for (String variable : variableSet){
            if(notStart){
                variableNames.append(", ");
            }else{
                notStart = true;
            }
            variableNames.append(variable);
        }
        return variableNames.toString();
    }

}
