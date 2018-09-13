/**
 * This file is generated by MetTeL v2
 * which is designed and implemented
 * by Dmitry Tishkovsky.
 */
grammar Lukasiewicz;
options{
 k=1;
 superClass=MettelAbstractLogicParser;
 backtrack=false;
 memoize=false;
}
@header{
package Lukasiewicz.language.Lukasiewicz;

import java.util.Collection;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import mettel.core.tableau.MettelGeneralTableauRule;
import mettel.core.language.MettelAbstractLogicParser;
}
@lexer::header{
package Lukasiewicz.language.Lukasiewicz;
}
@rulecatch{
catch (RecognitionException e) {
reportError(e);
throw e;
}
}
@members{
public Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
       throws RecognitionException{
    MismatchedTokenException e = new MismatchedTokenException(ttype, input);
    reportError(e);
    throw e;
}
private LukasiewiczObjectFactory factory = LukasiewiczObjectFactory.DEFAULT;
public LukasiewiczParser(TokenStream input, LukasiewiczObjectFactory factory){
    this(input);
    this.factory = factory;
}
public LukasiewiczParser(TokenStream input, RecognizerSharedState state, LukasiewiczObjectFactory factory){
    this(input,state);
    this.factory = factory;
}
}
valuations
[Collection<Lukasiewicz_valuation> a0]
:
(
 (
  (e0 = valuation
   {
   a0.add(e0);
   }
  )
*
 )
 (EOF)
)
;
valuationVariable
returns [Lukasiewicz_valuation r0]
@after{
r0 = factory.create_valuationVariable(t.getText());
}
:
(t = ID)
;
basic_valuation
returns [Lukasiewicz_valuation r0]
@after{
r0 = e0;
}
:
(
 (e0 = valuationVariable)
 |
 (
  ('(')
  (e0 = valuation)
  (')')
 )
)
;
valuation_true
returns [Lukasiewicz_valuation r0]
:
(
 (e00 = basic_valuation
  {
  r0 = e00;
  }
 )

 |
 (
  ('T')
  (e10 = formula)
 
  {
  r0 = factory.create_true_valuation(e10);
  }
 )

)
;
valuation_unknown
returns [Lukasiewicz_valuation r0]
:
(
 (e00 = valuation_true
  {
  r0 = e00;
  }
 )

 |
 (
  ('U')
  (e10 = formula)
 
  {
  r0 = factory.create_unknown_valuation(e10);
  }
 )

)
;
valuation_false
returns [Lukasiewicz_valuation r0]
:
(
 (e00 = valuation_unknown
  {
  r0 = e00;
  }
 )

 |
 (
  ('F')
  (e10 = formula)
 
  {
  r0 = factory.create_false_valuation(e10);
  }
 )

)
;
valuation
returns [Lukasiewicz_valuation r0]
@after{
r0 = e0;
}
:
(e0 = valuation_false)
;
formulas
[Collection<Lukasiewicz_formula> a0]
:
(
 (
  (e0 = formula
   {
   a0.add(e0);
   }
  )
*
 )
 (EOF)
)
;
formulaVariable
returns [Lukasiewicz_formula r0]
@after{
r0 = factory.create_formulaVariable(t.getText());
}
:
(t = ID)
;
basic_formula
returns [Lukasiewicz_formula r0]
@after{
r0 = e0;
}
:
(
 (e0 = formulaVariable)
 |
 (
  ('(')
  (e0 = formula)
  (')')
 )
)
;
formula_negation
returns [Lukasiewicz_formula r0]
:
(
 (e00 = basic_formula
  {
  r0 = e00;
  }
 )

 |
 (
  ('!')
  (e10 = basic_formula)
 
  {
  r0 = factory.create_negation_formula(e10);
  }
 )

)
;
formula_conjunction
returns [Lukasiewicz_formula r0]
@after{
r0 = e0;
}
:
(
 (e0 = formula_negation)
 (
  (
   ('&')
   (e1 = formula_negation
    {
    e0 = factory.create_conjunction_formula(e0, e1);
    }
   )

  )*
 )
)
;
formula_disjunction
returns [Lukasiewicz_formula r0]
@after{
r0 = e0;
}
:
(
 (e0 = formula_conjunction)
 (
  (
   ('|')
   (e1 = formula_conjunction
    {
    e0 = factory.create_disjunction_formula(e0, e1);
    }
   )

  )*
 )
)
;
formula_implication
returns [Lukasiewicz_formula r0]
@after{
r0 = e0;
}
:
(
 (e0 = formula_disjunction)
 (
  (
   ('->')
   (e1 = formula_disjunction
    {
    e0 = factory.create_implication_formula(e0, e1);
    }
   )

  )*
 )
)
;
formula
returns [Lukasiewicz_formula r0]
@after{
r0 = e0;
}
:
(e0 = formula_implication)
;
expressions
returns [ArrayList<LukasiewiczExpression> r0]
@init{
r0 = new ArrayList<LukasiewiczExpression>();
}
:
((
  (e0 = expression
   {
   r0.add(e0);
   }
  )
*
 ))
;
expression
returns [LukasiewiczExpression r0]
:
(
 ((valuation)=> valuationExpression = valuation
  {
  r0 = valuationExpression;
  }
 )

 |
 ((formula)=> formulaExpression = formula
  {
  r0 = formulaExpression;
  }
 )

)
;
expressionEOF
returns [LukasiewiczExpression r0]
:
(
 ((valuation)=> valuationExpression = valuation
  {
  r0 = valuationExpression;
  }
 )

 |
 ((formula)=> formulaExpression = formula
  {
  r0 = formulaExpression;
  }
 )

 |
 (EOF)
)
;
tableauRule
returns [MettelGeneralTableauRule r0]
@init{
LinkedHashSet<LinkedHashSet<LukasiewiczExpression>> branches = new LinkedHashSet<LinkedHashSet<LukasiewiczExpression>>();
int priority = 0;
}
@after{
r0 = new MettelGeneralTableauRule(new LinkedHashSet<LukasiewiczExpression>(premises),branches,priority);
}
:
(
 (premises = expressions)
 ('/')
 (conclusion = expressions
  {
  branches.add(new LinkedHashSet<LukasiewiczExpression>(conclusion));
  }
 )

 (
  (
   ('$|')
   (conclusion = expressions
    {
    branches.add(new LinkedHashSet<LukasiewiczExpression>(conclusion));
    }
   )

  )*
 )
 (
  (
   ('priority')
   (t = INT)
  
   {
   priority = Integer.valueOf(t.getText());
   }
  )
?
 )
)
;
tableauCalculus
[Collection<MettelGeneralTableauRule> a0]
:
(
 (e0 = tableauRule
  {
  a0.add(e0);
  }
 )

 (
  (
   ('$;')
   (
    (e0 = tableauRule
     {
     a0.add(e0);
     }
    )
?
   )
  )*
 )
 (EOF)
)
;

//Trivial Lexer
ID
    : LETTER (LETTER|ID_DIGIT)*
    ;

//Char range from JavaCC's grammar for Java
fragment
LETTER
    : '\u0024' |
       '\u0041'..'\u005a' |
       '\u005f' |
       '\u0061'..'\u007a' |
       '\u00c0'..'\u00d6' |
       '\u00d8'..'\u00f6' |
       '\u00f8'..'\u00ff' |
       '\u0100'..'\u1fff' |
       '\u3040'..'\u318f' |
       '\u3300'..'\u337f' |
       '\u3400'..'\u3d2d' |
       '\u4e00'..'\u9fff' |
       '\uf900'..'\ufaff'
    ;

fragment
ID_DIGIT
    : '\u0030'..'\u0039' |
       '\u0660'..'\u0669' |
       '\u06f0'..'\u06f9' |
       '\u0966'..'\u096f' |
       '\u09e6'..'\u09ef' |
       '\u0a66'..'\u0a6f' |
       '\u0ae6'..'\u0aef' |
       '\u0b66'..'\u0b6f' |
       '\u0be7'..'\u0bef' |
       '\u0c66'..'\u0c6f' |
       '\u0ce6'..'\u0cef' |
       '\u0d66'..'\u0d6f' |
       '\u0e50'..'\u0e59' |
       '\u0ed0'..'\u0ed9' |
       '\u1040'..'\u1049'
   ;


//ID  :	('a'..'z'|'A'..'Z'|'_'|'$') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'$')*
//    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

INT :	'0'..'9'+
    ;

/*
STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
*/
