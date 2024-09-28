// Generated from Cactus.g4 by ANTLR 4.13.1

import org.antlr.v4.runtime.Token;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CactusParser}.
 */
public interface CactusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CactusParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CactusParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CactusParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(CactusParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(CactusParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CactusParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CactusParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(CactusParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(CactusParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CactusParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CactusParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void enterReadStmt(CactusParser.ReadStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#readStmt}.
	 * @param ctx the parse tree
	 */
	void exitReadStmt(CactusParser.ReadStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void enterWriteStmt(CactusParser.WriteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#writeStmt}.
	 * @param ctx the parse tree
	 */
	void exitWriteStmt(CactusParser.WriteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#exitStmt}.
	 * @param ctx the parse tree
	 */
	void enterExitStmt(CactusParser.ExitStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#exitStmt}.
	 * @param ctx the parse tree
	 */
	void exitExitStmt(CactusParser.ExitStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(CactusParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(CactusParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(CactusParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(CactusParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#ifElseStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStmt(CactusParser.IfElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#ifElseStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStmt(CactusParser.IfElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(CactusParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(CactusParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void enterCondExpr(CactusParser.CondExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#condExpr}.
	 * @param ctx the parse tree
	 */
	void exitCondExpr(CactusParser.CondExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#relop}.
	 * @param ctx the parse tree
	 */
	void enterRelop(CactusParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#relop}.
	 * @param ctx the parse tree
	 */
	void exitRelop(CactusParser.RelopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CactusParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CactusParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(CactusParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(CactusParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CactusParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(CactusParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CactusParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(CactusParser.PrimaryExprContext ctx);
}