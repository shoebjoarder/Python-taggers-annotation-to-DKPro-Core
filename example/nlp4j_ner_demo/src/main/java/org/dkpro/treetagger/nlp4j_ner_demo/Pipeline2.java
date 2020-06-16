package org.dkpro.treetagger.nlp4j_ner_demo;


import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.apache.uima.fit.factory.CollectionReaderFactory.createReaderDescription;
import static org.apache.uima.fit.pipeline.SimplePipeline.runPipeline;

import de.tudarmstadt.ukp.dkpro.core.io.conll.Conll2006Writer;
//import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;
import de.tudarmstadt.ukp.dkpro.core.io.xmi.XmiReader;
import de.tudarmstadt.ukp.dkpro.core.io.xmi.XmiWriter;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpPosTagger;
//import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpSegmenter;
//import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpNamedEntityRecognizer;



public class Pipeline2 {

  public static void main(String[] args) throws Exception {

		String in_xmi = "output2.xmi";
		String output3_xmi = "output3.xmi";
		String ts3_xml = "ts3.xml";
		String conll2 = "doc2.conll";
		
	    runPipeline(
	        createReaderDescription(XmiReader.class,
        		XmiReader.PARAM_SOURCE_LOCATION, in_xmi,
        		XmiReader.PARAM_LANGUAGE, "en"),
	        
	        createEngineDescription(OpenNlpPosTagger.class),
	        
			createEngineDescription(XmiWriter.class,
					XmiWriter.PARAM_TARGET_LOCATION, output3_xmi,
					XmiWriter.PARAM_TYPE_SYSTEM_FILE, ts3_xml),
			createEngineDescription(Conll2006Writer.class,
		            Conll2006Writer.PARAM_TARGET_LOCATION, conll2));
  }
}