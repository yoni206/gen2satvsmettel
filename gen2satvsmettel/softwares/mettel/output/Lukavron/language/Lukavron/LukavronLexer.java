// $ANTLR 3.4 output/Lukavron/language/Lukavron/Lukavron.g 2017-04-12 16:40:36

package Lukavron.language.Lukavron;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class LukavronLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int COMMENT=4;
    public static final int ID=5;
    public static final int ID_DIGIT=6;
    public static final int INT=7;
    public static final int LETTER=8;
    public static final int WS=9;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public LukavronLexer() {} 
    public LukavronLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public LukavronLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "output/Lukavron/language/Lukavron/Lukavron.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:6:7: ( '!' )
            // output/Lukavron/language/Lukavron/Lukavron.g:6:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:7:7: ( '$;' )
            // output/Lukavron/language/Lukavron/Lukavron.g:7:9: '$;'
            {
            match("$;"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:8:7: ( '$|' )
            // output/Lukavron/language/Lukavron/Lukavron.g:8:9: '$|'
            {
            match("$|"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:9:7: ( '&' )
            // output/Lukavron/language/Lukavron/Lukavron.g:9:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:10:7: ( '(' )
            // output/Lukavron/language/Lukavron/Lukavron.g:10:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:11:7: ( ')' )
            // output/Lukavron/language/Lukavron/Lukavron.g:11:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:12:7: ( '->' )
            // output/Lukavron/language/Lukavron/Lukavron.g:12:9: '->'
            {
            match("->"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:13:7: ( '/' )
            // output/Lukavron/language/Lukavron/Lukavron.g:13:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:14:7: ( 'F' )
            // output/Lukavron/language/Lukavron/Lukavron.g:14:9: 'F'
            {
            match('F'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:15:7: ( 'T' )
            // output/Lukavron/language/Lukavron/Lukavron.g:15:9: 'T'
            {
            match('T'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:16:7: ( 'priority' )
            // output/Lukavron/language/Lukavron/Lukavron.g:16:9: 'priority'
            {
            match("priority"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:17:7: ( '|' )
            // output/Lukavron/language/Lukavron/Lukavron.g:17:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:399:5: ( LETTER ( LETTER | ID_DIGIT )* )
            // output/Lukavron/language/Lukavron/Lukavron.g:399:7: LETTER ( LETTER | ID_DIGIT )*
            {
            mLETTER(); 


            // output/Lukavron/language/Lukavron/Lukavron.g:399:14: ( LETTER | ID_DIGIT )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='$'||(LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')||(LA1_0 >= '\u00C0' && LA1_0 <= '\u00D6')||(LA1_0 >= '\u00D8' && LA1_0 <= '\u00F6')||(LA1_0 >= '\u00F8' && LA1_0 <= '\u1FFF')||(LA1_0 >= '\u3040' && LA1_0 <= '\u318F')||(LA1_0 >= '\u3300' && LA1_0 <= '\u337F')||(LA1_0 >= '\u3400' && LA1_0 <= '\u3D2D')||(LA1_0 >= '\u4E00' && LA1_0 <= '\u9FFF')||(LA1_0 >= '\uF900' && LA1_0 <= '\uFAFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // output/Lukavron/language/Lukavron/Lukavron.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F8' && input.LA(1) <= '\u1FFF')||(input.LA(1) >= '\u3040' && input.LA(1) <= '\u318F')||(input.LA(1) >= '\u3300' && input.LA(1) <= '\u337F')||(input.LA(1) >= '\u3400' && input.LA(1) <= '\u3D2D')||(input.LA(1) >= '\u4E00' && input.LA(1) <= '\u9FFF')||(input.LA(1) >= '\uF900' && input.LA(1) <= '\uFAFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // output/Lukavron/language/Lukavron/Lukavron.g:406:5: ( '\\u0024' | '\\u0041' .. '\\u005a' | '\\u005f' | '\\u0061' .. '\\u007a' | '\\u00c0' .. '\\u00d6' | '\\u00d8' .. '\\u00f6' | '\\u00f8' .. '\\u00ff' | '\\u0100' .. '\\u1fff' | '\\u3040' .. '\\u318f' | '\\u3300' .. '\\u337f' | '\\u3400' .. '\\u3d2d' | '\\u4e00' .. '\\u9fff' | '\\uf900' .. '\\ufaff' )
            // output/Lukavron/language/Lukavron/Lukavron.g:
            {
            if ( input.LA(1)=='$'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F8' && input.LA(1) <= '\u1FFF')||(input.LA(1) >= '\u3040' && input.LA(1) <= '\u318F')||(input.LA(1) >= '\u3300' && input.LA(1) <= '\u337F')||(input.LA(1) >= '\u3400' && input.LA(1) <= '\u3D2D')||(input.LA(1) >= '\u4E00' && input.LA(1) <= '\u9FFF')||(input.LA(1) >= '\uF900' && input.LA(1) <= '\uFAFF') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "ID_DIGIT"
    public final void mID_DIGIT() throws RecognitionException {
        try {
            // output/Lukavron/language/Lukavron/Lukavron.g:423:5: ( '\\u0030' .. '\\u0039' | '\\u0660' .. '\\u0669' | '\\u06f0' .. '\\u06f9' | '\\u0966' .. '\\u096f' | '\\u09e6' .. '\\u09ef' | '\\u0a66' .. '\\u0a6f' | '\\u0ae6' .. '\\u0aef' | '\\u0b66' .. '\\u0b6f' | '\\u0be7' .. '\\u0bef' | '\\u0c66' .. '\\u0c6f' | '\\u0ce6' .. '\\u0cef' | '\\u0d66' .. '\\u0d6f' | '\\u0e50' .. '\\u0e59' | '\\u0ed0' .. '\\u0ed9' | '\\u1040' .. '\\u1049' )
            // output/Lukavron/language/Lukavron/Lukavron.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= '\u0660' && input.LA(1) <= '\u0669')||(input.LA(1) >= '\u06F0' && input.LA(1) <= '\u06F9')||(input.LA(1) >= '\u0966' && input.LA(1) <= '\u096F')||(input.LA(1) >= '\u09E6' && input.LA(1) <= '\u09EF')||(input.LA(1) >= '\u0A66' && input.LA(1) <= '\u0A6F')||(input.LA(1) >= '\u0AE6' && input.LA(1) <= '\u0AEF')||(input.LA(1) >= '\u0B66' && input.LA(1) <= '\u0B6F')||(input.LA(1) >= '\u0BE7' && input.LA(1) <= '\u0BEF')||(input.LA(1) >= '\u0C66' && input.LA(1) <= '\u0C6F')||(input.LA(1) >= '\u0CE6' && input.LA(1) <= '\u0CEF')||(input.LA(1) >= '\u0D66' && input.LA(1) <= '\u0D6F')||(input.LA(1) >= '\u0E50' && input.LA(1) <= '\u0E59')||(input.LA(1) >= '\u0ED0' && input.LA(1) <= '\u0ED9')||(input.LA(1) >= '\u1040' && input.LA(1) <= '\u1049') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID_DIGIT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:444:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='/') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='/') ) {
                    alt5=1;
                }
                else if ( (LA5_1=='*') ) {
                    alt5=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // output/Lukavron/language/Lukavron/Lukavron.g:444:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // output/Lukavron/language/Lukavron/Lukavron.g:444:14: (~ ( '\\n' | '\\r' ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // output/Lukavron/language/Lukavron/Lukavron.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    // output/Lukavron/language/Lukavron/Lukavron.g:444:28: ( '\\r' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\r') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // output/Lukavron/language/Lukavron/Lukavron.g:444:28: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // output/Lukavron/language/Lukavron/Lukavron.g:445:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // output/Lukavron/language/Lukavron/Lukavron.g:445:14: ( options {greedy=false; } : . )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='*') ) {
                            int LA4_1 = input.LA(2);

                            if ( (LA4_1=='/') ) {
                                alt4=2;
                            }
                            else if ( ((LA4_1 >= '\u0000' && LA4_1 <= '.')||(LA4_1 >= '0' && LA4_1 <= '\uFFFF')) ) {
                                alt4=1;
                            }


                        }
                        else if ( ((LA4_0 >= '\u0000' && LA4_0 <= ')')||(LA4_0 >= '+' && LA4_0 <= '\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // output/Lukavron/language/Lukavron/Lukavron.g:445:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    match("*/"); 



                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:448:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // output/Lukavron/language/Lukavron/Lukavron.g:448:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // output/Lukavron/language/Lukavron/Lukavron.g:455:5: ( ( '0' .. '9' )+ )
            // output/Lukavron/language/Lukavron/Lukavron.g:455:7: ( '0' .. '9' )+
            {
            // output/Lukavron/language/Lukavron/Lukavron.g:455:7: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // output/Lukavron/language/Lukavron/Lukavron.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    public void mTokens() throws RecognitionException {
        // output/Lukavron/language/Lukavron/Lukavron.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | ID | COMMENT | WS | INT )
        int alt7=16;
        int LA7_0 = input.LA(1);

        if ( (LA7_0=='!') ) {
            alt7=1;
        }
        else if ( (LA7_0=='$') ) {
            switch ( input.LA(2) ) {
            case ';':
                {
                alt7=2;
                }
                break;
            case '|':
                {
                alt7=3;
                }
                break;
            default:
                alt7=13;
            }

        }
        else if ( (LA7_0=='&') ) {
            alt7=4;
        }
        else if ( (LA7_0=='(') ) {
            alt7=5;
        }
        else if ( (LA7_0==')') ) {
            alt7=6;
        }
        else if ( (LA7_0=='-') ) {
            alt7=7;
        }
        else if ( (LA7_0=='/') ) {
            int LA7_7 = input.LA(2);

            if ( (LA7_7=='*'||LA7_7=='/') ) {
                alt7=14;
            }
            else {
                alt7=8;
            }
        }
        else if ( (LA7_0=='F') ) {
            int LA7_8 = input.LA(2);

            if ( (LA7_8=='$'||(LA7_8 >= '0' && LA7_8 <= '9')||(LA7_8 >= 'A' && LA7_8 <= 'Z')||LA7_8=='_'||(LA7_8 >= 'a' && LA7_8 <= 'z')||(LA7_8 >= '\u00C0' && LA7_8 <= '\u00D6')||(LA7_8 >= '\u00D8' && LA7_8 <= '\u00F6')||(LA7_8 >= '\u00F8' && LA7_8 <= '\u1FFF')||(LA7_8 >= '\u3040' && LA7_8 <= '\u318F')||(LA7_8 >= '\u3300' && LA7_8 <= '\u337F')||(LA7_8 >= '\u3400' && LA7_8 <= '\u3D2D')||(LA7_8 >= '\u4E00' && LA7_8 <= '\u9FFF')||(LA7_8 >= '\uF900' && LA7_8 <= '\uFAFF')) ) {
                alt7=13;
            }
            else {
                alt7=9;
            }
        }
        else if ( (LA7_0=='T') ) {
            int LA7_9 = input.LA(2);

            if ( (LA7_9=='$'||(LA7_9 >= '0' && LA7_9 <= '9')||(LA7_9 >= 'A' && LA7_9 <= 'Z')||LA7_9=='_'||(LA7_9 >= 'a' && LA7_9 <= 'z')||(LA7_9 >= '\u00C0' && LA7_9 <= '\u00D6')||(LA7_9 >= '\u00D8' && LA7_9 <= '\u00F6')||(LA7_9 >= '\u00F8' && LA7_9 <= '\u1FFF')||(LA7_9 >= '\u3040' && LA7_9 <= '\u318F')||(LA7_9 >= '\u3300' && LA7_9 <= '\u337F')||(LA7_9 >= '\u3400' && LA7_9 <= '\u3D2D')||(LA7_9 >= '\u4E00' && LA7_9 <= '\u9FFF')||(LA7_9 >= '\uF900' && LA7_9 <= '\uFAFF')) ) {
                alt7=13;
            }
            else {
                alt7=10;
            }
        }
        else if ( (LA7_0=='p') ) {
            int LA7_10 = input.LA(2);

            if ( (LA7_10=='r') ) {
                int LA7_21 = input.LA(3);

                if ( (LA7_21=='i') ) {
                    int LA7_22 = input.LA(4);

                    if ( (LA7_22=='o') ) {
                        int LA7_23 = input.LA(5);

                        if ( (LA7_23=='r') ) {
                            int LA7_24 = input.LA(6);

                            if ( (LA7_24=='i') ) {
                                int LA7_25 = input.LA(7);

                                if ( (LA7_25=='t') ) {
                                    int LA7_26 = input.LA(8);

                                    if ( (LA7_26=='y') ) {
                                        int LA7_27 = input.LA(9);

                                        if ( (LA7_27=='$'||(LA7_27 >= '0' && LA7_27 <= '9')||(LA7_27 >= 'A' && LA7_27 <= 'Z')||LA7_27=='_'||(LA7_27 >= 'a' && LA7_27 <= 'z')||(LA7_27 >= '\u00C0' && LA7_27 <= '\u00D6')||(LA7_27 >= '\u00D8' && LA7_27 <= '\u00F6')||(LA7_27 >= '\u00F8' && LA7_27 <= '\u1FFF')||(LA7_27 >= '\u3040' && LA7_27 <= '\u318F')||(LA7_27 >= '\u3300' && LA7_27 <= '\u337F')||(LA7_27 >= '\u3400' && LA7_27 <= '\u3D2D')||(LA7_27 >= '\u4E00' && LA7_27 <= '\u9FFF')||(LA7_27 >= '\uF900' && LA7_27 <= '\uFAFF')) ) {
                                            alt7=13;
                                        }
                                        else {
                                            alt7=11;
                                        }
                                    }
                                    else {
                                        alt7=13;
                                    }
                                }
                                else {
                                    alt7=13;
                                }
                            }
                            else {
                                alt7=13;
                            }
                        }
                        else {
                            alt7=13;
                        }
                    }
                    else {
                        alt7=13;
                    }
                }
                else {
                    alt7=13;
                }
            }
            else {
                alt7=13;
            }
        }
        else if ( (LA7_0=='|') ) {
            alt7=12;
        }
        else if ( ((LA7_0 >= 'A' && LA7_0 <= 'E')||(LA7_0 >= 'G' && LA7_0 <= 'S')||(LA7_0 >= 'U' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'o')||(LA7_0 >= 'q' && LA7_0 <= 'z')||(LA7_0 >= '\u00C0' && LA7_0 <= '\u00D6')||(LA7_0 >= '\u00D8' && LA7_0 <= '\u00F6')||(LA7_0 >= '\u00F8' && LA7_0 <= '\u1FFF')||(LA7_0 >= '\u3040' && LA7_0 <= '\u318F')||(LA7_0 >= '\u3300' && LA7_0 <= '\u337F')||(LA7_0 >= '\u3400' && LA7_0 <= '\u3D2D')||(LA7_0 >= '\u4E00' && LA7_0 <= '\u9FFF')||(LA7_0 >= '\uF900' && LA7_0 <= '\uFAFF')) ) {
            alt7=13;
        }
        else if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||LA7_0=='\r'||LA7_0==' ') ) {
            alt7=15;
        }
        else if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
            alt7=16;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("", 7, 0, input);

            throw nvae;

        }
        switch (alt7) {
            case 1 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:10: T__10
                {
                mT__10(); 


                }
                break;
            case 2 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:16: T__11
                {
                mT__11(); 


                }
                break;
            case 3 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:22: T__12
                {
                mT__12(); 


                }
                break;
            case 4 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:28: T__13
                {
                mT__13(); 


                }
                break;
            case 5 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:34: T__14
                {
                mT__14(); 


                }
                break;
            case 6 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:40: T__15
                {
                mT__15(); 


                }
                break;
            case 7 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:46: T__16
                {
                mT__16(); 


                }
                break;
            case 8 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:52: T__17
                {
                mT__17(); 


                }
                break;
            case 9 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:58: T__18
                {
                mT__18(); 


                }
                break;
            case 10 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:64: T__19
                {
                mT__19(); 


                }
                break;
            case 11 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:70: T__20
                {
                mT__20(); 


                }
                break;
            case 12 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:76: T__21
                {
                mT__21(); 


                }
                break;
            case 13 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:82: ID
                {
                mID(); 


                }
                break;
            case 14 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:85: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 15 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:93: WS
                {
                mWS(); 


                }
                break;
            case 16 :
                // output/Lukavron/language/Lukavron/Lukavron.g:1:96: INT
                {
                mINT(); 


                }
                break;

        }

    }


 

}