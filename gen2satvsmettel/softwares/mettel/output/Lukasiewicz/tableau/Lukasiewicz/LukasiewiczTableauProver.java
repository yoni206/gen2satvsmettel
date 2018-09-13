/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukasiewicz.tableau.Lukasiewicz;

import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashSet;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import mettel.core.tableau.MettelSimpleTableauManager;
import mettel.core.tableau.MettelGeneralTableauRule;
import mettel.core.tableau.MettelTableauObjectFactory;
import Lukasiewicz.language.Lukasiewicz.*;

public class LukasiewiczTableauProver{

    final private static CommonTokenStream tokens = new CommonTokenStream();
    final private static LukasiewiczParser parser = new LukasiewiczParser(tokens);

    private static PrintWriter out = null;
    private static PrintWriter err = null;
    private static CharStream in = null;
    private static String outFileName = null;
    private static String tableauFile = null;

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Hello there! I am an automated tableau prover for Lukasiewicz logic.");
        System.out.println("I am generated by MetTeL, an automated tableau prover generator,");
        System.out.println("which is designed and implemented by Dmitry Tishkovsky.");
        System.out.println("As a program, I have ABSOLUTELY NO WARRANTY.");
        System.out.println("-------------------------------------------------------------------");
        try{
            final int SIZE = args.length;
            for(int i = 0; i < SIZE; i++){
                if("-i".equals(args[i])||"--input".equals(args[i])){
                    if(i < SIZE-1){
                        in = new ANTLRFileStream(args[++i]);
                        System.out.println("Input file: "+args[i]);
                    }else{
                        System.out.println("I need a name of input file.");
                        System.exit(-1);
                    }
                }else if("-o".equals(args[i])||"--output".equals(args[i])){
                    if(i < SIZE-1){
                        outFileName = args[++i];
                        out = new PrintWriter(new FileWriter(outFileName),true);
                        System.out.println("Output file: "+outFileName);
                    }else{
                        System.out.println("I need a name of file for my output.");
                        System.exit(-1);
                    }
                }else if("-e".equals(args[i])||"--error".equals(args[i])){
                    if(i < SIZE-1){
                        err = new PrintWriter(new FileWriter(args[++i]),true);
                        System.out.println("Using error file: "+args[i]);
                    }else{
                        System.out.println("I need a name of file for output about my errors.");
                        System.exit(-1);
                    }
                }else if("-t".equals(args[i])||"--tableau".equals(args[i])){
                    if(i < SIZE-1){
                        tableauFile = args[++i];
                        System.out.println("Tableau file: "+tableauFile);
                    }else{
                        System.out.println("I need a name of file with a tableau calculus.");
                        System.exit(-1);
                    }
                }
            }
            if(out == null) out = new PrintWriter(new OutputStreamWriter(System.out),true);
            if(err == null) err = new PrintWriter(new OutputStreamWriter(System.err),true);
            LinkedHashSet<MettelGeneralTableauRule> calculus = new LinkedHashSet<MettelGeneralTableauRule>();
            parseCalculus(calculus, tableauFile);
            if(in == null) in = new ANTLRInputStream(System.in);
            tokens.setTokenSource(new LukasiewiczLexer(in));
            ArrayList<Lukasiewicz_valuation> list = new ArrayList<Lukasiewicz_valuation>();
            parser.valuations(list);
            MettelTableauObjectFactory tfactory = new LukasiewiczTableauObjectFactory();
            MettelSimpleTableauManager m = new MettelSimpleTableauManager(tfactory, calculus);
            final boolean result = m.isSatisfiable(list);
            if(result){
                out.println("Satisfiable.");
                out.println("Model: "+m.model());
            }else{
                out.println("Unsatisfiable.");
                if(m.contradiction() != null){
                    out.println("Contradiction: "+m.contradiction());
                }
            }
            System.exit(result?1:0);
        } catch(Exception e) {
            if(out == null) out = new PrintWriter(new OutputStreamWriter(System.out),true);
            if(err == null) err = new PrintWriter(new OutputStreamWriter(System.err),true);
            out.println("Sorry! I detected an exceptional situation and terminate now.");
            out.println("If you can help me to avoid this situation in future, please look at my error output.");
            err.println("==Exception==========================");
            e.printStackTrace(err);
            err.println("=====================================");
            System.exit(-1);
        }
    }
    public static void parseCalculus(Set<MettelGeneralTableauRule> calculus, String path)
    throws IOException, RecognitionException{
        CharStream tin = (path == null)?
            new ANTLRInputStream(LukasiewiczTableauProver.class.getResourceAsStream("calculus")):
            new ANTLRFileStream(path);
        tokens.setTokenSource(new LukasiewiczLexer(tin));
        parser.tableauCalculus(calculus);
    }
}
