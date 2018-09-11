/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukavrona.tableau.Lukavrona.test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.io.File;
import java.io.IOException;
import junit.framework.*;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import mettel.core.tableau.MettelSimpleTableauManager;
import mettel.core.tableau.MettelGeneralTableauRule;
import mettel.core.tableau.MettelTableauObjectFactory;
import Lukavrona.language.Lukavrona.*;

public class LukavronaTableauTest extends TestCase{

    final static String tableauFile = "test/examples/Lukavrona/tableau";
    final static String inDir = "test/examples/Lukavrona/problems";

    public void testTableau() throws IOException, RecognitionException{
        CommonTokenStream tokens = new CommonTokenStream();
        CharStream tin = new ANTLRFileStream(tableauFile);
        LukavronaLexer lexer = new LukavronaLexer(tin);

        tokens.setTokenSource(lexer);
        LukavronaParser parser = new LukavronaParser(tokens);

        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.print("Reading tableau calculus for Lukavrona...");
        LinkedHashSet<MettelGeneralTableauRule> calculus = new LinkedHashSet<MettelGeneralTableauRule>();
        parser.tableauCalculus(calculus);
        System.out.println("OK");
        System.out.println("----------------------------------------------------");
        System.out.println("Testing tableau algorithm for Lukavrona");
        System.out.print("----------------------------------------------------");

        File problemDir = new File(inDir);
        String[] fileNames = problemDir.list();
        int counter = 0;
        for(String fileName:fileNames){
            int i = fileName.lastIndexOf('.');
            if(i != -1){
                String ext = fileName.substring(i);
                if(ext.equals(".mtl")){
                    String name = fileName.substring(0, i);
                    int j = name.lastIndexOf('-');
                    if(j != -1){
                        counter++;
                        System.out.println();
                        System.out.print(""+counter+". "+fileName+"...");
                        boolean expected = name.substring(j+1).equals("sat");
                        CharStream in = new ANTLRFileStream(inDir+System.getProperty("file.separator")+fileName);
                        lexer = new LukavronaLexer(in);
                        tokens.setTokenSource(lexer);
                        ArrayList<Lukavrona_valuation> list = new ArrayList<Lukavrona_valuation>();
                        parser.valuations(list);
                        MettelTableauObjectFactory tfactory = new LukavronaTableauObjectFactory();
                        MettelSimpleTableauManager m = new MettelSimpleTableauManager(tfactory, calculus);
                        final long start = System.currentTimeMillis();
                        final boolean result = m.isSatisfiable(list);
                        final long finish = System.currentTimeMillis();
                        System.out.print(""+(finish-start)+" msec...");
                        if(result){
                            System.out.println();
                            System.out.println("...Model: "+m.model());
                            System.out.print("...");
                        }else if(m.contradiction() != null){
                            System.out.println();
                            System.out.println("...Contradiction: "+m.contradiction());
                            System.out.print("...");
                        }
                        assertEquals(expected,result);
                        System.out.print("OK");
                    }
                }
            }
        }
        System.out.println();
        System.out.println("----------------------------------------------------");
    }
}
