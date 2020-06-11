package org.dkpro.treetagger.nlp4j_ner_demo;


import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.apache.uima.fit.factory.CollectionReaderFactory.createReaderDescription;
import static org.apache.uima.fit.pipeline.SimplePipeline.runPipeline;
import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;
import de.tudarmstadt.ukp.dkpro.core.io.xmi.XmiWriter;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpPosTagger;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpSegmenter;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpNamedEntityRecognizer;



public class Pipeline {

  public static void main(String[] args) throws Exception {
    runPipeline(
        createReaderDescription(TextReader.class,
            TextReader.PARAM_SOURCE_LOCATION, "document.txt",
            TextReader.PARAM_LANGUAGE, "en"),
        createEngineDescription(OpenNlpSegmenter.class),
        createEngineDescription(OpenNlpPosTagger.class),
        createEngineDescription(OpenNlpNamedEntityRecognizer.class,
        		OpenNlpNamedEntityRecognizer.PARAM_VARIANT, "person"),
        createEngineDescription(OpenNlpNamedEntityRecognizer.class,
        		OpenNlpNamedEntityRecognizer.PARAM_VARIANT, "organization"),
        createEngineDescription(XmiWriter.class,
        		XmiWriter.PARAM_TARGET_LOCATION, "."));
  }
}