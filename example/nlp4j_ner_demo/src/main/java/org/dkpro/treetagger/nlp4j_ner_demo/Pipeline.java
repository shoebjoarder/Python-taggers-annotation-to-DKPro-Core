package org.dkpro.treetagger.nlp4j_ner_demo;


import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.apache.uima.fit.factory.CollectionReaderFactory.createReaderDescription;
import static org.apache.uima.fit.pipeline.SimplePipeline.runPipeline;

import de.tudarmstadt.ukp.dkpro.core.io.conll.Conll2006Writer;
import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;
import de.tudarmstadt.ukp.dkpro.core.io.xmi.XmiWriter;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpPosTagger;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpSegmenter;
//import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpNamedEntityRecognizer;



public class Pipeline {

  public static void main(String[] args) throws Exception {
	  
	  String text_doc = "document.txt";;
	  String output1_xmi = "output1.xmi";
	  String ts1_xml = "ts1.xml";
	  String conll1 = "doc1.conll";
		
	  runPipeline(
			  createReaderDescription(TextReader.class,
					  TextReader.PARAM_SOURCE_LOCATION, text_doc,
					  TextReader.PARAM_LANGUAGE, "en"),
        
			  createEngineDescription(OpenNlpSegmenter.class),
        
//			  createEngineDescription(OpenNlpPosTagger.class),
	        
//			  createEngineDescription(OpenNlpNamedEntityRecognizer.class,
//					  OpenNlpNamedEntityRecognizer.PARAM_VARIANT, "person"),
//			  createEngineDescription(OpenNlpNamedEntityRecognizer.class,
//					  OpenNlpNamedEntityRecognizer.PARAM_VARIANT, "organization"),
//			  createEngineDescription(XmiWriter.class,
//					  XmiWriter.PARAM_TARGET_LOCATION, "."));
			  
			  createEngineDescription(XmiWriter.class,
					  XmiWriter.PARAM_TARGET_LOCATION, output1_xmi,
					  XmiWriter.PARAM_TYPE_SYSTEM_FILE, ts1_xml),
			  createEngineDescription(Conll2006Writer.class,
					  Conll2006Writer.PARAM_TARGET_LOCATION, conll1));
  }
}