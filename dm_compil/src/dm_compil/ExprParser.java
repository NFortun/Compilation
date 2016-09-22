package dm_compil;

// $ANTLR 3.5 Expr.g 2016-09-22 13:37:13

import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExprParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "NEWLINE", "WS", 
		"'('", "')'", "'*'", "'+'", "'-'", "'/'", "'='", "'^'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int ID=4;
	public static final int INT=5;
	public static final int NEWLINE=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ExprParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExprParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ExprParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Expr.g"; }


	/** Map variable name to Integer object holding value */
	HashMap memory = new HashMap();



	// $ANTLR start "prog"
	// Expr.g:14:1: prog : ( stat )+ ;
	public final void prog() throws RecognitionException {
		try {
			// Expr.g:14:5: ( ( stat )+ )
			// Expr.g:14:9: ( stat )+
			{
			// Expr.g:14:9: ( stat )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= ID && LA1_0 <= NEWLINE)||LA1_0==8) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Expr.g:14:9: stat
					{
					pushFollow(FOLLOW_stat_in_prog25);
					stat();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "prog"



	// $ANTLR start "stat"
	// Expr.g:16:1: stat : ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE );
	public final void stat() throws RecognitionException {
		Token ID2=null;
		int expr1 =0;
		int expr3 =0;

		try {
			// Expr.g:16:5: ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE )
			int alt2=3;
			switch ( input.LA(1) ) {
			case INT:
			case 8:
				{
				alt2=1;
				}
				break;
			case ID:
				{
				int LA2_2 = input.LA(2);
				if ( (LA2_2==14) ) {
					alt2=2;
				}
				else if ( (LA2_2==NEWLINE||(LA2_2 >= 10 && LA2_2 <= 13)||LA2_2==15) ) {
					alt2=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case NEWLINE:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// Expr.g:16:9: expr NEWLINE
					{
					pushFollow(FOLLOW_expr_in_stat52);
					expr1=expr();
					state._fsp--;

					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat54); 
					System.out.println(expr1);
					}
					break;
				case 2 :
					// Expr.g:17:9: ID '=' expr NEWLINE
					{
					ID2=(Token)match(input,ID,FOLLOW_ID_in_stat66); 
					match(input,14,FOLLOW_14_in_stat68); 
					pushFollow(FOLLOW_expr_in_stat70);
					expr3=expr();
					state._fsp--;

					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat72); 
					memory.put((ID2!=null?ID2.getText():null), new Integer(expr3));
					}
					break;
				case 3 :
					// Expr.g:19:9: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat92); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "stat"



	// $ANTLR start "expr"
	// Expr.g:22:1: expr returns [int value] : e= multExpr ( '+' e= multExpr | '-' e= multExpr )* ;
	public final int expr() throws RecognitionException {
		int value = 0;


		int e =0;

		try {
			// Expr.g:23:5: (e= multExpr ( '+' e= multExpr | '-' e= multExpr )* )
			// Expr.g:23:9: e= multExpr ( '+' e= multExpr | '-' e= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_expr117);
			e=multExpr();
			state._fsp--;

			value = e;
			// Expr.g:24:9: ( '+' e= multExpr | '-' e= multExpr )*
			loop3:
			while (true) {
				int alt3=3;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==11) ) {
					alt3=1;
				}
				else if ( (LA3_0==12) ) {
					alt3=2;
				}

				switch (alt3) {
				case 1 :
					// Expr.g:24:13: '+' e= multExpr
					{
					match(input,11,FOLLOW_11_in_expr133); 
					pushFollow(FOLLOW_multExpr_in_expr137);
					e=multExpr();
					state._fsp--;

					value += e;
					}
					break;
				case 2 :
					// Expr.g:25:13: '-' e= multExpr
					{
					match(input,12,FOLLOW_12_in_expr153); 
					pushFollow(FOLLOW_multExpr_in_expr157);
					e=multExpr();
					state._fsp--;

					value -= e;
					}
					break;

				default :
					break loop3;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "expr"



	// $ANTLR start "squaExpr"
	// Expr.g:29:1: squaExpr returns [int value] : e= atom ( '^' e= expr )* ;
	public final int squaExpr() throws RecognitionException {
		int value = 0;


		int e =0;

		try {
			// Expr.g:30:2: (e= atom ( '^' e= expr )* )
			// Expr.g:30:6: e= atom ( '^' e= expr )*
			{
			pushFollow(FOLLOW_atom_in_squaExpr192);
			e=atom();
			state._fsp--;

			value = e;
			// Expr.g:31:3: ( '^' e= expr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==15) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// Expr.g:32:4: '^' e= expr
					{
					match(input,15,FOLLOW_15_in_squaExpr204); 
					pushFollow(FOLLOW_expr_in_squaExpr208);
					e=expr();
					state._fsp--;

					 value =(int)Math.pow((double)value,(double) e);
					}
					break;

				default :
					break loop4;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "squaExpr"



	// $ANTLR start "multExpr"
	// Expr.g:36:1: multExpr returns [int value] : e= squaExpr ( ( '*' e= squaExpr ) | ( '/' e= squaExpr ) )* ;
	public final int multExpr() throws RecognitionException {
		int value = 0;


		int e =0;

		try {
			// Expr.g:37:5: (e= squaExpr ( ( '*' e= squaExpr ) | ( '/' e= squaExpr ) )* )
			// Expr.g:37:9: e= squaExpr ( ( '*' e= squaExpr ) | ( '/' e= squaExpr ) )*
			{
			pushFollow(FOLLOW_squaExpr_in_multExpr239);
			e=squaExpr();
			state._fsp--;

			value = e;
			// Expr.g:38:5: ( ( '*' e= squaExpr ) | ( '/' e= squaExpr ) )*
			loop5:
			while (true) {
				int alt5=3;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==10) ) {
					alt5=1;
				}
				else if ( (LA5_0==13) ) {
					alt5=2;
				}

				switch (alt5) {
				case 1 :
					// Expr.g:38:9: ( '*' e= squaExpr )
					{
					// Expr.g:38:9: ( '*' e= squaExpr )
					// Expr.g:38:10: '*' e= squaExpr
					{
					match(input,10,FOLLOW_10_in_multExpr253); 
					pushFollow(FOLLOW_squaExpr_in_multExpr257);
					e=squaExpr();
					state._fsp--;

					value *= e;
					}

					}
					break;
				case 2 :
					// Expr.g:39:8: ( '/' e= squaExpr )
					{
					// Expr.g:39:8: ( '/' e= squaExpr )
					// Expr.g:39:9: '/' e= squaExpr
					{
					match(input,13,FOLLOW_13_in_multExpr270); 
					pushFollow(FOLLOW_squaExpr_in_multExpr274);
					e=squaExpr();
					state._fsp--;

					value = value / e;
					}

					}
					break;

				default :
					break loop5;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "multExpr"



	// $ANTLR start "atom"
	// Expr.g:43:1: atom returns [int value] : ( INT | ID | '(' expr ')' );
	public final int atom() throws RecognitionException {
		int value = 0;


		Token INT4=null;
		Token ID5=null;
		int expr6 =0;

		try {
			// Expr.g:44:5: ( INT | ID | '(' expr ')' )
			int alt6=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt6=1;
				}
				break;
			case ID:
				{
				alt6=2;
				}
				break;
			case 8:
				{
				alt6=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// Expr.g:44:9: INT
					{
					INT4=(Token)match(input,INT,FOLLOW_INT_in_atom308); 
					value = Integer.parseInt((INT4!=null?INT4.getText():null));
					}
					break;
				case 2 :
					// Expr.g:45:9: ID
					{
					ID5=(Token)match(input,ID,FOLLOW_ID_in_atom320); 

					        Integer v = (Integer)memory.get((ID5!=null?ID5.getText():null));
					        if ( v!=null ) value = v.intValue();
					        else System.err.println("undefined variable "+(ID5!=null?ID5.getText():null));
					        
					}
					break;
				case 3 :
					// Expr.g:51:9: '(' expr ')'
					{
					match(input,8,FOLLOW_8_in_atom340); 
					pushFollow(FOLLOW_expr_in_atom342);
					expr6=expr();
					state._fsp--;

					match(input,9,FOLLOW_9_in_atom344); 
					value = expr6;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "atom"

	// Delegated rules



	public static final BitSet FOLLOW_stat_in_prog25 = new BitSet(new long[]{0x0000000000000172L});
	public static final BitSet FOLLOW_expr_in_stat52 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_stat54 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat66 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_stat68 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_expr_in_stat70 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_stat72 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_stat92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr117 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_11_in_expr133 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_multExpr_in_expr137 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_12_in_expr153 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_multExpr_in_expr157 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_atom_in_squaExpr192 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_15_in_squaExpr204 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_expr_in_squaExpr208 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_squaExpr_in_multExpr239 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_10_in_multExpr253 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_squaExpr_in_multExpr257 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_13_in_multExpr270 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_squaExpr_in_multExpr274 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_INT_in_atom308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_atom340 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_expr_in_atom342 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_atom344 = new BitSet(new long[]{0x0000000000000002L});
}
