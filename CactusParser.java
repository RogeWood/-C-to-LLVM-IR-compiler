// Generated from Cactus.g4 by ANTLR 4.13.1

import org.antlr.v4.runtime.Token;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CactusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, BEGIN=2, DO=3, ELSE=4, END=5, ENDIF=6, ENDWHILE=7, EXIT=8, IF=9, 
		SET=10, NOT=11, OR=12, PROGRAM=13, READ=14, THEN=15, VAR=16, WHILE=17, 
		WRITE=18, ID=19, INT=20, WS=21, COMMENT=22, ADD=23, SUB=24, MUL=25, DIV=26, 
		MOD=27, ASSIGN=28, EQUAL=29, NOTEQUAL=30, GREATER=31, GREATEREQUAL=32, 
		LESS=33, LESSEQUAL=34, LPAREN=35, RPAREN=36;
	public static final int
		RULE_program = 0, RULE_declarations = 1, RULE_declaration = 2, RULE_statements = 3, 
		RULE_statement = 4, RULE_readStmt = 5, RULE_writeStmt = 6, RULE_exitStmt = 7, 
		RULE_assignStmt = 8, RULE_ifStmt = 9, RULE_ifElseStmt = 10, RULE_whileStmt = 11, 
		RULE_condExpr = 12, RULE_relop = 13, RULE_expr = 14, RULE_multExpr = 15, 
		RULE_primaryExpr = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declarations", "declaration", "statements", "statement", 
			"readStmt", "writeStmt", "exitStmt", "assignStmt", "ifStmt", "ifElseStmt", 
			"whileStmt", "condExpr", "relop", "expr", "multExpr", "primaryExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'And'", "'Begin'", "'Do'", "'Else'", "'End'", "'EndIf'", "'EndWhile'", 
			"'Exit'", "'If'", "'Set'", "'Not'", "'Or'", "'Program'", "'Read'", "'Then'", 
			"'Var'", "'While'", "'Write'", null, null, null, null, "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'='", "'=='", "'<>'", "'>'", "'>='", "'<'", "'<='", 
			"'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AND", "BEGIN", "DO", "ELSE", "END", "ENDIF", "ENDWHILE", "EXIT", 
			"IF", "SET", "NOT", "OR", "PROGRAM", "READ", "THEN", "VAR", "WHILE", 
			"WRITE", "ID", "INT", "WS", "COMMENT", "ADD", "SUB", "MUL", "DIV", "MOD", 
			"ASSIGN", "EQUAL", "NOTEQUAL", "GREATER", "GREATEREQUAL", "LESS", "LESSEQUAL", 
			"LPAREN", "RPAREN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cactus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    int tempCounter = 0;
	    int labelCounter = 1;

	    String newTemp() {
	        return "$t" + (tempCounter++);
	    }
	    String curTemp() {
	        return "$t" + (tempCounter);
	    }
	    void releaseTemp() {
	        tempCounter--;
	    }

	    String newLabel() {
	        return "L" + (labelCounter++);
	    }
	    String curLabel() {
	        return "L" + (labelCounter);
	    }
	    String upLabel() {
	        return "L" + (labelCounter-1);
	    }
	    String upupLabel() {
	        return "L" + (labelCounter-2);
	    }

	        String insertBeforeFirstNewline(String original, String toInsert) {
	        int newlineIndex = original.indexOf('\n');
	        
	        if (newlineIndex == -1) {
	            return original + toInsert;
	        }
	        
	        return original.substring(0, newlineIndex) + toInsert + original.substring(newlineIndex);
	    }

	public CactusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(CactusParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(CactusParser.ID, 0); }
		public TerminalNode BEGIN() { return getToken(CactusParser.BEGIN, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode END() { return getToken(CactusParser.END, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(PROGRAM);
			setState(35);
			match(ID);
			setState(36);
			match(BEGIN);
			 System.out.println("\t.data"); 
			setState(38);
			declarations();
			 System.out.println("\t.text\nmain:"); 
			setState(40);
			statements(0);
			setState(41);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationsContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitDeclarations(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(43);
					declaration();
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode VAR() { return getToken(CactusParser.VAR, 0); }
		public TerminalNode ID() { return getToken(CactusParser.ID, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(VAR);
			setState(50);
			((DeclarationContext)_localctx).ID = match(ID);

			            System.out.println((((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null) + ": \t\t\t\t# Var " + (((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null));
			            System.out.println("\t.word 0");
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		return statements(0);
	}

	private StatementsContext statements(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementsContext _localctx = new StatementsContext(_ctx, _parentState);
		StatementsContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_statements, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(60);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_statements);
					setState(56);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(57);
					statement();
					}
					} 
				}
				setState(62);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public IfElseStmtContext ifElseStmt() {
			return getRuleContext(IfElseStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public WriteStmtContext writeStmt() {
			return getRuleContext(WriteStmtContext.class,0);
		}
		public ExitStmtContext exitStmt() {
			return getRuleContext(ExitStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public ReadStmtContext readStmt() {
			return getRuleContext(ReadStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				ifStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				ifElseStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				whileStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				writeStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				exitStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(68);
				assignStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(69);
				readStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReadStmtContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode READ() { return getToken(CactusParser.READ, 0); }
		public TerminalNode ID() { return getToken(CactusParser.ID, 0); }
		public ReadStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterReadStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitReadStmt(this);
		}
	}

	public final ReadStmtContext readStmt() throws RecognitionException {
		ReadStmtContext _localctx = new ReadStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_readStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(READ);
			setState(73);
			((ReadStmtContext)_localctx).ID = match(ID);

			            String code = "";
			            String temp = newTemp();
			            code = "\tli $v0, 5" + "\t\t\t\t# Read " + (((ReadStmtContext)_localctx).ID!=null?((ReadStmtContext)_localctx).ID.getText():null) + "\n" +
			                    "\tsyscall\n" +
			                    "\tla " + temp + ", " + (((ReadStmtContext)_localctx).ID!=null?((ReadStmtContext)_localctx).ID.getText():null) + "\n" +
			                    "\tsw $v0, 0(" + temp + ")";
			            releaseTemp();
			            System.out.println(code);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteStmtContext extends ParserRuleContext {
		public ExprContext expr;
		public TerminalNode WRITE() { return getToken(CactusParser.WRITE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WriteStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterWriteStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitWriteStmt(this);
		}
	}

	public final WriteStmtContext writeStmt() throws RecognitionException {
		WriteStmtContext _localctx = new WriteStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_writeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(WRITE);
			setState(77);
			((WriteStmtContext)_localctx).expr = expr();

			            String code = "";
			            String instruction = "\t\t\t\t# Write " + (((WriteStmtContext)_localctx).expr!=null?_input.getText(((WriteStmtContext)_localctx).expr.start,((WriteStmtContext)_localctx).expr.stop):null);
			            
			            code = insertBeforeFirstNewline(((WriteStmtContext)_localctx).expr.code, instruction) +
			                    "\tmove $a0, " + ((WriteStmtContext)_localctx).expr.result + "\n" +
			                    "\tli $v0, 1\n" +
			                    "\tsyscall\n";
			            System.out.print(code);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExitStmtContext extends ParserRuleContext {
		public TerminalNode EXIT() { return getToken(CactusParser.EXIT, 0); }
		public ExitStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exitStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterExitStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitExitStmt(this);
		}
	}

	public final ExitStmtContext exitStmt() throws RecognitionException {
		ExitStmtContext _localctx = new ExitStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exitStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(EXIT);

			            String code = "";
			            code = "\tli $v0, 10\n" +
			                    "\tsyscall";
			            System.out.println(code);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignStmtContext extends ParserRuleContext {
		public Token ID;
		public ExprContext expr;
		public TerminalNode SET() { return getToken(CactusParser.SET, 0); }
		public TerminalNode ID() { return getToken(CactusParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(CactusParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitAssignStmt(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(SET);
			setState(84);
			((AssignStmtContext)_localctx).ID = match(ID);
			setState(85);
			match(ASSIGN);
			setState(86);
			((AssignStmtContext)_localctx).expr = expr();

			            String code = "";
			            String instruction = "\t\t\t\t# SET " + (((AssignStmtContext)_localctx).ID!=null?((AssignStmtContext)_localctx).ID.getText():null) + " = " + (((AssignStmtContext)_localctx).expr!=null?_input.getText(((AssignStmtContext)_localctx).expr.start,((AssignStmtContext)_localctx).expr.stop):null);

			            String temp = newTemp();
			            code = insertBeforeFirstNewline(((AssignStmtContext)_localctx).expr.code, instruction) +
			                    "\tla " + temp + ", " + (((AssignStmtContext)_localctx).ID!=null?((AssignStmtContext)_localctx).ID.getText():null) + "\n" +
			                    "\tsw " + ((AssignStmtContext)_localctx).expr.result + ", 0(" + temp + ")\n";
			            System.out.print(code);
			            releaseTemp();
			            releaseTemp();
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public StatementsContext thenStmt;
		public TerminalNode IF() { return getToken(CactusParser.IF, 0); }
		public CondExprContext condExpr() {
			return getRuleContext(CondExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(CactusParser.THEN, 0); }
		public TerminalNode ENDIF() { return getToken(CactusParser.ENDIF, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitIfStmt(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(IF);
			setState(90);
			condExpr();

			            String code = "";
			            newLabel();
			            code = "\tb " + curLabel() + "\n" +
			                    upLabel() + ":\n";
			            System.out.print(code);
			        
			setState(92);
			match(THEN);
			setState(93);
			((IfStmtContext)_localctx).thenStmt = statements(0);
			setState(94);
			match(ENDIF);

			            code = curLabel() + ":\n";
			            System.out.print(code);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfElseStmtContext extends ParserRuleContext {
		public StatementsContext thenStmt;
		public StatementsContext elseStmt;
		public TerminalNode IF() { return getToken(CactusParser.IF, 0); }
		public CondExprContext condExpr() {
			return getRuleContext(CondExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(CactusParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CactusParser.ELSE, 0); }
		public TerminalNode ENDIF() { return getToken(CactusParser.ENDIF, 0); }
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public IfElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterIfElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitIfElseStmt(this);
		}
	}

	public final IfElseStmtContext ifElseStmt() throws RecognitionException {
		IfElseStmtContext _localctx = new IfElseStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifElseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(IF);
			setState(98);
			condExpr();

			            String code = "";
			            newLabel();
			            code = "\tb " + curLabel() + "\n" +
			                    upLabel() + ":\n";
			            System.out.print(code);
			        
			setState(100);
			match(THEN);
			setState(101);
			((IfElseStmtContext)_localctx).thenStmt = statements(0);

			            newLabel();
			            code = "\tb " + curLabel() + "\n" +
			                    upLabel() + ":\n";
			            System.out.print(code);
			        
			setState(103);
			match(ELSE);
			setState(104);
			((IfElseStmtContext)_localctx).elseStmt = statements(0);
			setState(105);
			match(ENDIF);

			            code = curLabel() + ":\n";
			            System.out.print(code);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public StatementsContext body;
		public TerminalNode WHILE() { return getToken(CactusParser.WHILE, 0); }
		public CondExprContext condExpr() {
			return getRuleContext(CondExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(CactusParser.DO, 0); }
		public TerminalNode ENDWHILE() { return getToken(CactusParser.ENDWHILE, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitWhileStmt(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(WHILE);

			            String code = "";
			            newLabel();
			            code = curLabel() + ":\n";
			            System.out.print(code);
			            newLabel();
			        
			setState(110);
			condExpr();
			setState(111);
			match(DO);

			            newLabel();
			            code = "\tb " + curLabel() + "\n" +
			                    upLabel() + ":\n";
			            System.out.print(code);
			        
			setState(113);
			((WhileStmtContext)_localctx).body = statements(0);
			setState(114);
			match(ENDWHILE);

			            code = "\tb " + upupLabel() + "\n" +
			                    curLabel() + ":\n";
			            System.out.print(code);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CondExprContext extends ParserRuleContext {
		public String code;
		public String result;
		public ExprContext e1;
		public RelopContext relop;
		public ExprContext e2;
		public RelopContext relop() {
			return getRuleContext(RelopContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CondExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterCondExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitCondExpr(this);
		}
	}

	public final CondExprContext condExpr() throws RecognitionException {
		CondExprContext _localctx = new CondExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_condExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			((CondExprContext)_localctx).e1 = expr();
			setState(118);
			((CondExprContext)_localctx).relop = relop();
			setState(119);
			((CondExprContext)_localctx).e2 = expr();

			            ((CondExprContext)_localctx).code =  ((CondExprContext)_localctx).e1.code + ((CondExprContext)_localctx).e2.code;
			            ((CondExprContext)_localctx).result =  curLabel();
			            switch ((((CondExprContext)_localctx).relop!=null?_input.getText(((CondExprContext)_localctx).relop.start,((CondExprContext)_localctx).relop.stop):null)) {
			                case "<":
			                    _localctx.code += "\tblt " + ((CondExprContext)_localctx).e1.result + ", " + ((CondExprContext)_localctx).e2.result + ", " + _localctx.result + "\n";
			                    break;
			                case "<=":
			                    _localctx.code += "\tble " + ((CondExprContext)_localctx).e1.result + ", " + ((CondExprContext)_localctx).e2.result + ", " + _localctx.result + "\n";
			                    break;
			                case ">":
			                    _localctx.code += "\tbgt " + ((CondExprContext)_localctx).e1.result + ", " + ((CondExprContext)_localctx).e2.result + ", " + _localctx.result + "\n";
			                    break;
			                case ">=":
			                    _localctx.code += "\tbge " + ((CondExprContext)_localctx).e1.result + ", " + ((CondExprContext)_localctx).e2.result + ", " + _localctx.result + "\n";
			                    break;
			                case "==":
			                    _localctx.code += "\tbeq " + ((CondExprContext)_localctx).e1.result + ", " + ((CondExprContext)_localctx).e2.result + ", " + _localctx.result + "\n";
			                    break;
			                case "<>":
			                    _localctx.code += "\tbne " + ((CondExprContext)_localctx).e1.result + ", " + ((CondExprContext)_localctx).e2.result + ", " + _localctx.result + "\n";
			                    break;
			            }
			            releaseTemp();
			            releaseTemp();
			            System.out.print(_localctx.code);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelopContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(CactusParser.LESS, 0); }
		public TerminalNode LESSEQUAL() { return getToken(CactusParser.LESSEQUAL, 0); }
		public TerminalNode GREATER() { return getToken(CactusParser.GREATER, 0); }
		public TerminalNode GREATEREQUAL() { return getToken(CactusParser.GREATEREQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(CactusParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(CactusParser.NOTEQUAL, 0); }
		public RelopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterRelop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitRelop(this);
		}
	}

	public final RelopContext relop() throws RecognitionException {
		RelopContext _localctx = new RelopContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33822867456L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public String code;
		public String result;
		public MultExprContext e1;
		public MultExprContext e2;
		public MultExprContext e4;
		public List<MultExprContext> multExpr() {
			return getRuleContexts(MultExprContext.class);
		}
		public MultExprContext multExpr(int i) {
			return getRuleContext(MultExprContext.class,i);
		}
		public List<TerminalNode> ADD() { return getTokens(CactusParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(CactusParser.ADD, i);
		}
		public List<TerminalNode> SUB() { return getTokens(CactusParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(CactusParser.SUB, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			((ExprContext)_localctx).e1 = multExpr();
			 
			            ((ExprContext)_localctx).code =  ((ExprContext)_localctx).e1.code;
			            ((ExprContext)_localctx).result =  ((ExprContext)_localctx).e1.result;
			        
			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(134);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ADD:
						{
						setState(126);
						match(ADD);
						setState(127);
						((ExprContext)_localctx).e2 = multExpr();
						 
						            ((ExprContext)_localctx).code =  _localctx.code + ((ExprContext)_localctx).e2.code + "\tadd " + _localctx.result + ", " + _localctx.result + ", " + ((ExprContext)_localctx).e2.result + "\n";
						            releaseTemp();
						        
						}
						break;
					case SUB:
						{
						setState(130);
						match(SUB);
						setState(131);
						((ExprContext)_localctx).e4 = multExpr();
						 
						            ((ExprContext)_localctx).code =  _localctx.code + ((ExprContext)_localctx).e4.code + "\tsub " + _localctx.result + ", " + _localctx.result + ", " + ((ExprContext)_localctx).e4.result + "\n";
						            releaseTemp();
						        
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultExprContext extends ParserRuleContext {
		public String code;
		public String result;
		public PrimaryExprContext e1;
		public PrimaryExprContext e2;
		public List<PrimaryExprContext> primaryExpr() {
			return getRuleContexts(PrimaryExprContext.class);
		}
		public PrimaryExprContext primaryExpr(int i) {
			return getRuleContext(PrimaryExprContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(CactusParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(CactusParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(CactusParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(CactusParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(CactusParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(CactusParser.MOD, i);
		}
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitMultExpr(this);
		}
	}

	public final MultExprContext multExpr() throws RecognitionException {
		MultExprContext _localctx = new MultExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_multExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			((MultExprContext)_localctx).e1 = primaryExpr();
			 
			            newTemp();
			            ((MultExprContext)_localctx).code =  ((MultExprContext)_localctx).e1.code;
			            ((MultExprContext)_localctx).result =  ((MultExprContext)_localctx).e1.result;
			            // System.out.println("multExpr:" + _localctx.code + _localctx.result);
			        
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(153);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case MUL:
						{
						setState(141);
						match(MUL);
						setState(142);
						((MultExprContext)_localctx).e2 = primaryExpr();
						 
						            ((MultExprContext)_localctx).code =  _localctx.code + ((MultExprContext)_localctx).e2.code + "\tmul " + _localctx.result + ", " + _localctx.result + ", " + ((MultExprContext)_localctx).e2.result + "\n";
						            releaseTemp();
						        
						}
						break;
					case DIV:
						{
						setState(145);
						match(DIV);
						setState(146);
						((MultExprContext)_localctx).e2 = primaryExpr();
						 
						            ((MultExprContext)_localctx).code =  _localctx.code + ((MultExprContext)_localctx).e2.code + "\tdiv " + _localctx.result + ", " + _localctx.result + ", " + ((MultExprContext)_localctx).e2.result + "\n";
						            releaseTemp();
						        
						}
						break;
					case MOD:
						{
						setState(149);
						match(MOD);
						setState(150);
						((MultExprContext)_localctx).e2 = primaryExpr();
						 
						            ((MultExprContext)_localctx).code =  _localctx.code + ((MultExprContext)_localctx).e2.code + "\tmod " + _localctx.result + ", " + _localctx.result + ", " + ((MultExprContext)_localctx).e2.result + "\n";
						            releaseTemp();
						        
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExprContext extends ParserRuleContext {
		public String code;
		public String result;
		public Token ID;
		public Token INT;
		public PrimaryExprContext primaryExpr;
		public ExprContext expr;
		public TerminalNode ID() { return getToken(CactusParser.ID, 0); }
		public TerminalNode INT() { return getToken(CactusParser.INT, 0); }
		public TerminalNode SUB() { return getToken(CactusParser.SUB, 0); }
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CactusParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CactusParser.RPAREN, 0); }
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).enterPrimaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CactusListener ) ((CactusListener)listener).exitPrimaryExpr(this);
		}
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_primaryExpr);
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				((PrimaryExprContext)_localctx).ID = match(ID);

				            String temp = curTemp();
				            ((PrimaryExprContext)_localctx).code =  "\tla " + temp + ", " + (((PrimaryExprContext)_localctx).ID!=null?((PrimaryExprContext)_localctx).ID.getText():null) + "\n\tlw " + temp + ", 0(" + temp + ")\n";
				            ((PrimaryExprContext)_localctx).result =  temp;
				            // System.out.println("ID:" + _localctx.code + _localctx.result);
				        
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				((PrimaryExprContext)_localctx).INT = match(INT);

				            String temp = curTemp();
				            ((PrimaryExprContext)_localctx).code =  "\tli " + temp + ", " + (((PrimaryExprContext)_localctx).INT!=null?((PrimaryExprContext)_localctx).INT.getText():null) + "\n";
				            ((PrimaryExprContext)_localctx).result =  temp;
				        
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				match(SUB);
				setState(163);
				((PrimaryExprContext)_localctx).primaryExpr = primaryExpr();

				            ((PrimaryExprContext)_localctx).code =  ((PrimaryExprContext)_localctx).primaryExpr.code + "\tneg " + ((PrimaryExprContext)_localctx).primaryExpr.result + ", " + ((PrimaryExprContext)_localctx).primaryExpr.result + "\n";
				            ((PrimaryExprContext)_localctx).result =  ((PrimaryExprContext)_localctx).primaryExpr.result;
				            releaseTemp();
				        
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 4);
				{
				setState(166);
				match(LPAREN);
				setState(167);
				((PrimaryExprContext)_localctx).expr = expr();
				setState(168);
				match(RPAREN);

				            ((PrimaryExprContext)_localctx).code =  ((PrimaryExprContext)_localctx).expr.code;
				            ((PrimaryExprContext)_localctx).result =  ((PrimaryExprContext)_localctx).expr.result;
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return statements_sempred((StatementsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean statements_sempred(StatementsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001$\u00ae\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0005\u0001-\b\u0001\n\u0001\f\u00010\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003;\b\u0003\n\u0003\f\u0003>\t\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004G\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u0087\b\u000e\n\u000e\f\u000e\u008a\t\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u009a\b\u000f\n\u000f\f\u000f\u009d\t\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u00ac\b\u0010\u0001\u0010\u0000\u0001\u0006\u0011\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000"+
		"\u0001\u0001\u0000\u001d\"\u00ac\u0000\"\u0001\u0000\u0000\u0000\u0002"+
		".\u0001\u0000\u0000\u0000\u00041\u0001\u0000\u0000\u0000\u00065\u0001"+
		"\u0000\u0000\u0000\bF\u0001\u0000\u0000\u0000\nH\u0001\u0000\u0000\u0000"+
		"\fL\u0001\u0000\u0000\u0000\u000eP\u0001\u0000\u0000\u0000\u0010S\u0001"+
		"\u0000\u0000\u0000\u0012Y\u0001\u0000\u0000\u0000\u0014a\u0001\u0000\u0000"+
		"\u0000\u0016l\u0001\u0000\u0000\u0000\u0018u\u0001\u0000\u0000\u0000\u001a"+
		"z\u0001\u0000\u0000\u0000\u001c|\u0001\u0000\u0000\u0000\u001e\u008b\u0001"+
		"\u0000\u0000\u0000 \u00ab\u0001\u0000\u0000\u0000\"#\u0005\r\u0000\u0000"+
		"#$\u0005\u0013\u0000\u0000$%\u0005\u0002\u0000\u0000%&\u0006\u0000\uffff"+
		"\uffff\u0000&\'\u0003\u0002\u0001\u0000\'(\u0006\u0000\uffff\uffff\u0000"+
		"()\u0003\u0006\u0003\u0000)*\u0005\u0005\u0000\u0000*\u0001\u0001\u0000"+
		"\u0000\u0000+-\u0003\u0004\u0002\u0000,+\u0001\u0000\u0000\u0000-0\u0001"+
		"\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000"+
		"/\u0003\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u000012\u0005\u0010"+
		"\u0000\u000023\u0005\u0013\u0000\u000034\u0006\u0002\uffff\uffff\u0000"+
		"4\u0005\u0001\u0000\u0000\u000056\u0006\u0003\uffff\uffff\u000067\u0006"+
		"\u0003\uffff\uffff\u00007<\u0001\u0000\u0000\u000089\n\u0002\u0000\u0000"+
		"9;\u0003\b\u0004\u0000:8\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000"+
		"<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=\u0007\u0001\u0000"+
		"\u0000\u0000><\u0001\u0000\u0000\u0000?G\u0003\u0012\t\u0000@G\u0003\u0014"+
		"\n\u0000AG\u0003\u0016\u000b\u0000BG\u0003\f\u0006\u0000CG\u0003\u000e"+
		"\u0007\u0000DG\u0003\u0010\b\u0000EG\u0003\n\u0005\u0000F?\u0001\u0000"+
		"\u0000\u0000F@\u0001\u0000\u0000\u0000FA\u0001\u0000\u0000\u0000FB\u0001"+
		"\u0000\u0000\u0000FC\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000"+
		"FE\u0001\u0000\u0000\u0000G\t\u0001\u0000\u0000\u0000HI\u0005\u000e\u0000"+
		"\u0000IJ\u0005\u0013\u0000\u0000JK\u0006\u0005\uffff\uffff\u0000K\u000b"+
		"\u0001\u0000\u0000\u0000LM\u0005\u0012\u0000\u0000MN\u0003\u001c\u000e"+
		"\u0000NO\u0006\u0006\uffff\uffff\u0000O\r\u0001\u0000\u0000\u0000PQ\u0005"+
		"\b\u0000\u0000QR\u0006\u0007\uffff\uffff\u0000R\u000f\u0001\u0000\u0000"+
		"\u0000ST\u0005\n\u0000\u0000TU\u0005\u0013\u0000\u0000UV\u0005\u001c\u0000"+
		"\u0000VW\u0003\u001c\u000e\u0000WX\u0006\b\uffff\uffff\u0000X\u0011\u0001"+
		"\u0000\u0000\u0000YZ\u0005\t\u0000\u0000Z[\u0003\u0018\f\u0000[\\\u0006"+
		"\t\uffff\uffff\u0000\\]\u0005\u000f\u0000\u0000]^\u0003\u0006\u0003\u0000"+
		"^_\u0005\u0006\u0000\u0000_`\u0006\t\uffff\uffff\u0000`\u0013\u0001\u0000"+
		"\u0000\u0000ab\u0005\t\u0000\u0000bc\u0003\u0018\f\u0000cd\u0006\n\uffff"+
		"\uffff\u0000de\u0005\u000f\u0000\u0000ef\u0003\u0006\u0003\u0000fg\u0006"+
		"\n\uffff\uffff\u0000gh\u0005\u0004\u0000\u0000hi\u0003\u0006\u0003\u0000"+
		"ij\u0005\u0006\u0000\u0000jk\u0006\n\uffff\uffff\u0000k\u0015\u0001\u0000"+
		"\u0000\u0000lm\u0005\u0011\u0000\u0000mn\u0006\u000b\uffff\uffff\u0000"+
		"no\u0003\u0018\f\u0000op\u0005\u0003\u0000\u0000pq\u0006\u000b\uffff\uffff"+
		"\u0000qr\u0003\u0006\u0003\u0000rs\u0005\u0007\u0000\u0000st\u0006\u000b"+
		"\uffff\uffff\u0000t\u0017\u0001\u0000\u0000\u0000uv\u0003\u001c\u000e"+
		"\u0000vw\u0003\u001a\r\u0000wx\u0003\u001c\u000e\u0000xy\u0006\f\uffff"+
		"\uffff\u0000y\u0019\u0001\u0000\u0000\u0000z{\u0007\u0000\u0000\u0000"+
		"{\u001b\u0001\u0000\u0000\u0000|}\u0003\u001e\u000f\u0000}\u0088\u0006"+
		"\u000e\uffff\uffff\u0000~\u007f\u0005\u0017\u0000\u0000\u007f\u0080\u0003"+
		"\u001e\u000f\u0000\u0080\u0081\u0006\u000e\uffff\uffff\u0000\u0081\u0087"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u0018\u0000\u0000\u0083\u0084"+
		"\u0003\u001e\u000f\u0000\u0084\u0085\u0006\u000e\uffff\uffff\u0000\u0085"+
		"\u0087\u0001\u0000\u0000\u0000\u0086~\u0001\u0000\u0000\u0000\u0086\u0082"+
		"\u0001\u0000\u0000\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u0086"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u001d"+
		"\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\u0003 \u0010\u0000\u008c\u009b\u0006\u000f\uffff\uffff\u0000\u008d\u008e"+
		"\u0005\u0019\u0000\u0000\u008e\u008f\u0003 \u0010\u0000\u008f\u0090\u0006"+
		"\u000f\uffff\uffff\u0000\u0090\u009a\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0005\u001a\u0000\u0000\u0092\u0093\u0003 \u0010\u0000\u0093\u0094\u0006"+
		"\u000f\uffff\uffff\u0000\u0094\u009a\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0005\u001b\u0000\u0000\u0096\u0097\u0003 \u0010\u0000\u0097\u0098\u0006"+
		"\u000f\uffff\uffff\u0000\u0098\u009a\u0001\u0000\u0000\u0000\u0099\u008d"+
		"\u0001\u0000\u0000\u0000\u0099\u0091\u0001\u0000\u0000\u0000\u0099\u0095"+
		"\u0001\u0000\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u0099"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u001f"+
		"\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0005\u0013\u0000\u0000\u009f\u00ac\u0006\u0010\uffff\uffff\u0000\u00a0"+
		"\u00a1\u0005\u0014\u0000\u0000\u00a1\u00ac\u0006\u0010\uffff\uffff\u0000"+
		"\u00a2\u00a3\u0005\u0018\u0000\u0000\u00a3\u00a4\u0003 \u0010\u0000\u00a4"+
		"\u00a5\u0006\u0010\uffff\uffff\u0000\u00a5\u00ac\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0005#\u0000\u0000\u00a7\u00a8\u0003\u001c\u000e\u0000\u00a8"+
		"\u00a9\u0005$\u0000\u0000\u00a9\u00aa\u0006\u0010\uffff\uffff\u0000\u00aa"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ab\u009e\u0001\u0000\u0000\u0000\u00ab"+
		"\u00a0\u0001\u0000\u0000\u0000\u00ab\u00a2\u0001\u0000\u0000\u0000\u00ab"+
		"\u00a6\u0001\u0000\u0000\u0000\u00ac!\u0001\u0000\u0000\u0000\b.<F\u0086"+
		"\u0088\u0099\u009b\u00ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}