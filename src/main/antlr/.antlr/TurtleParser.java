// Generated from c:\Users\liseg\Documents\Etudes\M1 S1\PDS\pds-tp1-java-master\src\main\antlr\TurtleParser.g by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import TP1.ASD;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TurtleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, STRING=2, ENTITY=3, PERIOD=4, COMA=5, SEMIC=6;
	public static final int
		RULE_document = 0, RULE_statements = 1, RULE_statement = 2, RULE_properties = 3, 
		RULE_property = 4, RULE_objects = 5, RULE_object = 6, RULE_bracket = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "statements", "statement", "properties", "property", "objects", 
			"object", "bracket"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'.'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "STRING", "ENTITY", "PERIOD", "COMA", "SEMIC"
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
	public String getGrammarFileName() { return "TurtleParser.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TurtleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class DocumentContext extends ParserRuleContext {
		public ASD.Document out;
		public StatementsContext s;
		public TerminalNode EOF() { return getToken(TurtleParser.EOF, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			((DocumentContext)_localctx).s = statements();
			setState(17);
			match(EOF);
			 ((DocumentContext)_localctx).out =  new ASD.Document(((DocumentContext)_localctx).s.out); 
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

	public static class StatementsContext extends ParserRuleContext {
		public List<ASD.Declaration> out;
		public StatementContext s;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((StatementsContext)_localctx).out =  new ArrayList<ASD.Declaration>(); 
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ENTITY) {
				{
				{
				setState(21);
				((StatementsContext)_localctx).s = statement();
				 _localctx.out.add(((StatementsContext)_localctx).s.out); 
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class StatementContext extends ParserRuleContext {
		public ASD.Declaration out;
		public BracketContext b;
		public PropertiesContext p;
		public TerminalNode PERIOD() { return getToken(TurtleParser.PERIOD, 0); }
		public BracketContext bracket() {
			return getRuleContext(BracketContext.class,0);
		}
		public PropertiesContext properties() {
			return getRuleContext(PropertiesContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			((StatementContext)_localctx).b = bracket();
			setState(30);
			((StatementContext)_localctx).p = properties();
			setState(31);
			match(PERIOD);
			 ((StatementContext)_localctx).out =  new ASD.Declaration(new ASD.Sujet(((StatementContext)_localctx).b.out), ((StatementContext)_localctx).p.out); 
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

	public static class PropertiesContext extends ParserRuleContext {
		public List<ASD.Propriete> out;
		public PropertyContext p;
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<TerminalNode> SEMIC() { return getTokens(TurtleParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(TurtleParser.SEMIC, i);
		}
		public PropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_properties; }
	}

	public final PropertiesContext properties() throws RecognitionException {
		PropertiesContext _localctx = new PropertiesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_properties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((PropertiesContext)_localctx).out =  new ArrayList<ASD.Propriete>(); 
			setState(35);
			((PropertiesContext)_localctx).p = property();
			 _localctx.out.add(((PropertiesContext)_localctx).p.out); 
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMIC) {
				{
				{
				setState(37);
				match(SEMIC);
				setState(38);
				((PropertiesContext)_localctx).p = property();
				 _localctx.out.add(((PropertiesContext)_localctx).p.out); 
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class PropertyContext extends ParserRuleContext {
		public ASD.Propriete out;
		public BracketContext b;
		public ObjectsContext o;
		public BracketContext bracket() {
			return getRuleContext(BracketContext.class,0);
		}
		public ObjectsContext objects() {
			return getRuleContext(ObjectsContext.class,0);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			((PropertyContext)_localctx).b = bracket();
			setState(47);
			((PropertyContext)_localctx).o = objects();
			 ((PropertyContext)_localctx).out =  new ASD.Propriete(new ASD.Predicat(((PropertyContext)_localctx).b.out), ((PropertyContext)_localctx).o.out); 
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

	public static class ObjectsContext extends ParserRuleContext {
		public List<ASD.Objet> out;
		public ObjectContext o1;
		public ObjectContext o2;
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(TurtleParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(TurtleParser.COMA, i);
		}
		public ObjectsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objects; }
	}

	public final ObjectsContext objects() throws RecognitionException {
		ObjectsContext _localctx = new ObjectsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_objects);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ObjectsContext)_localctx).out =  new ArrayList<ASD.Objet>(); 
			setState(51);
			((ObjectsContext)_localctx).o1 = object();
			 _localctx.out.add(((ObjectsContext)_localctx).o1.out); 
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(53);
				match(COMA);
				setState(54);
				((ObjectsContext)_localctx).o2 = object();
				 _localctx.out.add(((ObjectsContext)_localctx).o2.out); 
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ObjectContext extends ParserRuleContext {
		public ASD.Objet out;
		public BracketContext b;
		public Token s;
		public BracketContext bracket() {
			return getRuleContext(BracketContext.class,0);
		}
		public TerminalNode STRING() { return getToken(TurtleParser.STRING, 0); }
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_object);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENTITY:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				((ObjectContext)_localctx).b = bracket();
				 ((ObjectContext)_localctx).out =  ((ObjectContext)_localctx).b.out; 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				((ObjectContext)_localctx).s = match(STRING);
				 ((ObjectContext)_localctx).out =  new ASD.Text((((ObjectContext)_localctx).s!=null?((ObjectContext)_localctx).s.getText():null).substring(1, (((ObjectContext)_localctx).s!=null?((ObjectContext)_localctx).s.getText():null).length()-1)); 
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

	public static class BracketContext extends ParserRuleContext {
		public ASD.Entity out;
		public Token s;
		public TerminalNode ENTITY() { return getToken(TurtleParser.ENTITY, 0); }
		public BracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracket; }
	}

	public final BracketContext bracket() throws RecognitionException {
		BracketContext _localctx = new BracketContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			((BracketContext)_localctx).s = match(ENTITY);
			 ((BracketContext)_localctx).out =  new ASD.Entity((((BracketContext)_localctx).s!=null?((BracketContext)_localctx).s.getText():null).substring(1, (((BracketContext)_localctx).s!=null?((BracketContext)_localctx).s.getText():null).length()-1)); 
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\bK\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\7\3\33\n\3\f\3\16\3\36\13\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\7\5,\n\5\f\5\16\5/\13\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\7\7<\n\7\f\7\16\7?\13\7\3\b\3\b\3\b\3\b\3\b\5\bF\n\b"+
		"\3\t\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\2\2F\2\22\3\2\2\2\4\26\3\2"+
		"\2\2\6\37\3\2\2\2\b$\3\2\2\2\n\60\3\2\2\2\f\64\3\2\2\2\16E\3\2\2\2\20"+
		"G\3\2\2\2\22\23\5\4\3\2\23\24\7\2\2\3\24\25\b\2\1\2\25\3\3\2\2\2\26\34"+
		"\b\3\1\2\27\30\5\6\4\2\30\31\b\3\1\2\31\33\3\2\2\2\32\27\3\2\2\2\33\36"+
		"\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\5\3\2\2\2\36\34\3\2\2\2\37 \5"+
		"\20\t\2 !\5\b\5\2!\"\7\6\2\2\"#\b\4\1\2#\7\3\2\2\2$%\b\5\1\2%&\5\n\6\2"+
		"&-\b\5\1\2\'(\7\b\2\2()\5\n\6\2)*\b\5\1\2*,\3\2\2\2+\'\3\2\2\2,/\3\2\2"+
		"\2-+\3\2\2\2-.\3\2\2\2.\t\3\2\2\2/-\3\2\2\2\60\61\5\20\t\2\61\62\5\f\7"+
		"\2\62\63\b\6\1\2\63\13\3\2\2\2\64\65\b\7\1\2\65\66\5\16\b\2\66=\b\7\1"+
		"\2\678\7\7\2\289\5\16\b\29:\b\7\1\2:<\3\2\2\2;\67\3\2\2\2<?\3\2\2\2=;"+
		"\3\2\2\2=>\3\2\2\2>\r\3\2\2\2?=\3\2\2\2@A\5\20\t\2AB\b\b\1\2BF\3\2\2\2"+
		"CD\7\4\2\2DF\b\b\1\2E@\3\2\2\2EC\3\2\2\2F\17\3\2\2\2GH\7\5\2\2HI\b\t\1"+
		"\2I\21\3\2\2\2\6\34-=E";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}