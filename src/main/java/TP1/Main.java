package TP1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
	public static void main(String[] args) {
	    // Use with a manually made AST
		  
	    ASD.Document asd = new ASD.Document(Arrays.asList(
    		new ASD.Declaration(
				new ASD.Sujet(new ASD.Entity("poly117")),
					Arrays.asList(new ASD.Propriete(new ASD.Predicat(new ASD.Entity("type")), Arrays.asList(new ASD.Entity("poly"))),
							new ASD.Propriete(new ASD.Predicat(new ASD.Entity("auteur")), Arrays.asList(new ASD.Entity("Ridoux"), new ASD.Entity("Ferre"))),
							new ASD.Propriete(new ASD.Predicat(new ASD.Entity("titre")), Arrays.asList(new ASD.Text("Compilation"))))),
    		new ASD.Declaration(
				new ASD.Sujet(new ASD.Entity("Ridoux")), 
						Arrays.asList(new ASD.Propriete(new ASD.Predicat(new ASD.Entity("type")), Arrays.asList(new ASD.Entity("personne"), new ASD.Entity("professeur")))
	    ))));
	    
//	    <poly117>
//	    <type> <poly> ;
//	    <auteur> <Ridoux>, <Ferre> ;
//	    <titre> "Compilation" .
//	    <Ridoux> <type> <personne>, <professeur> .
	    
//		RESULT
//    	<poly117> <type> <poly> .
//    	<poly117> <auteur> <Ridoux> .
//   	<poly117> <auteur> <Ferre> .
//   	<poly117> <titre> "Compilation" .
//   	<Ridoux> <type> <personne>.
//   	<Ridoux> <type> <professeur> .
	    
	    System.out.println(asd.toNtriples());
	
	    // Use with lexer and parser
	    
	    try {
			// Set input
			CharStream input;
			if(args.length == 0) {
				// From standard input
				input = CharStreams.fromStream(System.in);
			}
			else {
				// From file set in first argument
				input = CharStreams.fromPath(Paths.get(args[0]));
			}
		
			// Instantiate Lexer
			TurtleLexer lexer = new TurtleLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
		
			// Instantiate Parser
			TurtleParser parser = new TurtleParser(tokens);
		
			// Parse
			ASD.Document ast = parser.document().out;
		
			// Print as Ntriples
			System.out.println(ast.toNtriples());
			} catch(IOException e) {
			e.printStackTrace();
	    }
	    
	}
}
