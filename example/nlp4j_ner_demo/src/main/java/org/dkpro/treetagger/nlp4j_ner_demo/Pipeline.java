package org.dkpro.treetagger.nlp4j_ner_demo;


import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.apache.uima.fit.factory.CollectionReaderFactory.createReaderDescription;
import static org.apache.uima.fit.pipeline.SimplePipeline.runPipeline;
import de.tudarmstadt.ukp.dkpro.core.io.conll.Conll2006Writer;
import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;
import de.tudarmstadt.ukp.dkpro.core.io.xmi.XmiWriter;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpSegmenter;

public class Pipeline {

  public static void main(String[] args) throws Exception {
	  
	  String text_doc = "document.txt";;
		
	  runPipeline(
		  createReaderDescription(TextReader.class,
			  TextReader.PARAM_SOURCE_LOCATION, text_doc,
			  TextReader.PARAM_LANGUAGE, "en"),
        
		  createEngineDescription(OpenNlpSegmenter.class),
       			  
		  createEngineDescription(XmiWriter.class,
			  XmiWriter.PARAM_TARGET_LOCATION, "OpenNlpSegmenter",
			  XmiWriter.PARAM_TYPE_SYSTEM_FILE, "TypeSystem.xml"),
		  createEngineDescription(Conll2006Writer.class,
			  Conll2006Writer.PARAM_TARGET_LOCATION, "."));
  }
}