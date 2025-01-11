import com.aliasi.tokenizer.LowerCaseTokenizerFactory;
import com.aliasi.tokenizer.EnglishStopTokenizerFactory;
import com.aliasi.tokenizer.PorterStemmerTokenizerFactory;
import com.aliasi.tokenizer.TokenizerFactory;
//import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
//import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
//import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
//import edu.stanford.nlp.ling.CoreLabel;
//import edu.stanford.nlp.ling.HasWord;
//import edu.stanford.nlp.pipeline.Annotation;
//import edu.stanford.nlp.pipeline.StanfordCoreNLP;
//import edu.stanford.nlp.process.CoreLabelTokenFactory;
//import edu.stanford.nlp.process.DocumentPreprocessor;
//import edu.stanford.nlp.process.PTBTokenizer;
//import edu.stanford.nlp.util.CoreMap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.tokenize.TokenSampleStream;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
// java -cp "/home/share/4.142.2.23/apache-opennlp-2.5.0/lib/*:/home/share/4.142.2.23/stanford-corenpl-4.5.7/*:/home/share/4.142.2.23/lin
// gpipe-master/*"
public class LibTokDemo {

	private static String paragraph = "Let's pause, \nand then reflect.";

	public static void main(String[] args) {

		System.out.println("Токенизация при помощи библиотеки OpenNLP");

 		System.out.println("\nИспользование класса SimpleTokenizer");
		SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;
		String tokens [] = simpleTokenizer.tokenize(paragraph);
		for (String token : tokens) {
			System.out.println(token);
		}
		System.out.println("\n\n");
		
		System.out.println("Токенизаия при помощи класса WhitespaceTokenizer");
		tokens = WhitespaceTokenizer.INSTANCE.tokenize(paragraph);
		for (String token : tokens) {
			 System.out.println(token);	 
		}
		System.out.println("\n\n");
		
		System.out.println("Использование класса TokenizerME");
		try {
			InputStream modelIn = new FileInputStream (new File(getModelDir(), "opennlp-en-ud-ewt-tokens-1.2-2.5.0.bin"));
			TokenizerModel model = new TokenizerModel(modelIn);
			Tokenizer tokenizer = new TokenizerME(model);
			tokens = tokenizer.tokenize(paragraph);
			for (String token : tokens) {
				System.out.println(token);
			}
		System.out.println("\n\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("\nИспользование класса TokenizerME на русском");
		try {		             
	       		InputStream modelIn1 = new FileInputStream (new File(getModelDir(), "opennlp-en-ud-ewt-tokens-1.2-2.5.0.bin"));
	        	TokenizerModel model1 = new TokenizerModel(modelIn1);
	      		Tokenizer tokenizer1 = new TokenizerME(model1);
			String paragraph1 = "Проверка. какая-то. на русском языке. Фраза на русском языке. ";
	        	String tokens1[]  = tokenizer1.tokenize(paragraph1);
    		 	for (String token : tokens1) {				
				System.out.println(token);					
       			}
		 System.out.println("\n\n");		 
		 } catch (IOException ex) {	
			 ex.printStackTrace();							
		
		 }
		System.out.println("Использовать токенайзер из библиотеки Стефорд");
		CoreLabelTokenFactory ctf = new CoreLabelFactory();
		PTBTokenizer ptb = new PTBTokenizer(new StringReader(paragraph), ctf, "invertible=true");
		while (ptb.hasNext()) {
			 CoreLabe cl (CoreLabe) ptb.next();
			 System.out.println(cl.originaltEXT() + " (" + cl.beginPosition() + "-" + cl.endPosition() + ") ");
			
		}

		 System.out.println("\n\n");

		System.out.println("токенайзер из библиотеки Стефорд при помощи DocumentPreprocessor");
		Reader reader = new StringReader(paragraph);
		DocumentPreprocessor documentPreprocessor = new DocumentPreprocessor(reader);

		Iterator <List<HasWord>> it = DocumentPreprocessor.iterator();
		while (it.hasNext()) {
			List<HasWord> sentence = it.next();
			for (HasWord token2 : sentence) {
				System.out.println(token2);
			}
		}

	public static File getModelDir() {
		return new File("/home/share/4.142.2.23/openNLPModels");
	}
}
