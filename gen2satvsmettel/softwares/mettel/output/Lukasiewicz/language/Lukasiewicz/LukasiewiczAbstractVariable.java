/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
package Lukasiewicz.language.Lukasiewicz;

abstract class LukasiewiczAbstractVariable extends LukasiewiczAbstractExpression implements LukasiewiczVariable{

    String name = null;

    public String name(){
        return name;
    }

    public LukasiewiczAbstractVariable(String name, LukasiewiczObjectFactory factory){
        super(factory);
        this.name = name;
    }

    public String toString(){
        return name;
    }
    int priority(){
        return -1;
    }
}
