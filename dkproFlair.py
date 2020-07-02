# Import libraries
from flair.data import Sentence
from flair.models import SequenceTagger
from cassis import *
import sys
import getopt


def importData(file):
    with open(file, 'r', encoding='utf-8') as file:
        document = file.read().replace('\n', ' ')
    return document


def casFlair(docu):
    document = importData(docu)
    model_name = 'ner'
    sentence = Sentence(document)
    nlp = SequenceTagger.load(model_name)
    nlp.predict(sentence)
    cas = Cas(typesystem=load_dkpro_core_typesystem())
    NERType = cas.typesystem.get_type(
        "de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity")
    for span in sentence.get_spans('ner'):
        if span.tag == 'PER':
            val = 'person'
        if span.tag == 'LOC':
            val = 'location'
        if span.tag == 'ORG':
            val = "organization"
        if span.tag == 'MISC':
            val = "miscellaneous"
        ner_annotation = NERType(begin=span.start_pos,
                                    end=span.end_pos,
                                    value=val)
        cas.add_annotation(ner_annotation)
        cas.to_xmi('./flairTEST.xmi', pretty_print=True)
        with open('flairTEST.xmi', 'r') as file:
            flairXMI = file.read()
    return flairXMI



# def outputXMI(xmifile):
#     xmifile.to_xmi('./flairNLP.xmi', pretty_print=True)

# def casFlair(argv):
#     inputFile = ""
#     outputFile = ""
#     try:
#         opts, args = getopt.getopt(argv, "hi:o", ["ifile=", "ofile="])
#     except getopt.GetoptError:
#         print 'flairpoc.py -i <inputfile> -o <outputfile>'
#         sys.exit(2)
#     for opt, arg in opts:
#         if opt == '-h':
#             print 'flairpoc.py -i <inputfile> -o <outputfile>'
#             sys.exit()
#         elif opt in ("-i", "--ifile"):
#             inputFile = arg
#         elif opt in ("-o", "--ofile"):
#             outputFile = arg
